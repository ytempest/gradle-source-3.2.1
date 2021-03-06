/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.build.gradle.internal.transforms;

import com.android.annotations.NonNull;
import com.android.annotations.Nullable;
import com.android.build.api.transform.JarInput;
import com.android.build.api.transform.QualifiedContent;
import com.android.build.gradle.internal.BuildCacheUtils;
import com.android.build.gradle.internal.LoggerWrapper;
import com.android.build.gradle.internal.pipeline.OriginalStream;
import com.android.builder.core.DexOptions;
import com.android.builder.dexing.DexerTool;
import com.android.builder.utils.FileCache;
import com.android.dx.Version;
import com.google.common.base.Joiner;
import com.google.common.base.Throwables;
import com.google.common.base.Verify;
import com.google.common.io.ByteStreams;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;

/** helper class used to cache dex archives in the user or build caches. */
class DexArchiveBuilderCacheHandler {

    static final class CacheableItem {
        @NonNull final QualifiedContent input;
        @NonNull final Collection<File> cachable;
        @NonNull final List<Path> dependencies;

        CacheableItem(
                @NonNull QualifiedContent input,
                @NonNull Collection<File> cachable,
                @NonNull List<Path> dependencies) {
            this.input = input;
            this.cachable = cachable;
            this.dependencies = dependencies;
        }
    }

    private static final LoggerWrapper logger =
            LoggerWrapper.getLogger(DexArchiveBuilderTransform.class);

    // Increase this if we might have generated broken cache entries to invalidate them.
    private static final int CACHE_KEY_VERSION = 4;

    @Nullable private final FileCache userLevelCache;
    @NonNull private final DexOptions dexOptions;
    private final int minSdkVersion;
    private final boolean isDebuggable;
    @NonNull private final DexerTool dexer;
    /**
     * A cache session to share between all cache access. We can do that because each {@link
     * DexArchiveBuilderCacheHandler} is used only by one DexArchiveBuilderTransform and all files
     * we use as cache inputs are left unchanged during the DexArchiveBuilderTransform.
     */
    @NonNull private final FileCache.CacheSession cacheSession = FileCache.newSession();

    DexArchiveBuilderCacheHandler(
            @Nullable FileCache userLevelCache,
            @NonNull DexOptions dexOptions,
            int minSdkVersion,
            boolean isDebuggable,
            @NonNull DexerTool dexer) {
        this.userLevelCache = userLevelCache;
        this.dexOptions = dexOptions;
        this.minSdkVersion = minSdkVersion;
        this.isDebuggable = isDebuggable;
        this.dexer = dexer;
    }

    @Nullable
    File getCachedVersionIfPresent(@NonNull JarInput input, @NonNull List<Path> dependencies)
            throws IOException {
        FileCache cache =
                PreDexTransform.getBuildCache(
                        input.getFile(), isExternalLib(input), userLevelCache);

        if (cache == null) {
            return null;
        }

        FileCache.Inputs buildCacheInputs =
                DexArchiveBuilderCacheHandler.getBuildCacheInputs(
                        input.getFile(),
                        dexOptions,
                        dexer,
                        minSdkVersion,
                        isDebuggable,
                        dependencies,
                        cacheSession);
        return cache.cacheEntryExists(buildCacheInputs)
                ? cache.getFileInCache(buildCacheInputs)
                : null;
    }

    void populateCache(@NonNull Collection<CacheableItem> cacheableItems)
            throws IOException, ExecutionException {

        for (CacheableItem cacheableItem : cacheableItems) {
            FileCache cache =
                    PreDexTransform.getBuildCache(
                            cacheableItem.input.getFile(),
                            isExternalLib(cacheableItem.input),
                            userLevelCache);
            if (cache != null) {
                FileCache.Inputs buildCacheInputs =
                        DexArchiveBuilderCacheHandler.getBuildCacheInputs(
                                cacheableItem.input.getFile(),
                                dexOptions,
                                dexer,
                                minSdkVersion,
                                isDebuggable,
                                cacheableItem.dependencies,
                                cacheSession);
                FileCache.QueryResult result =
                        cache.createFileInCacheIfAbsent(
                                buildCacheInputs,
                                in -> {
                                    Collection<File> dexArchives = cacheableItem.cachable;
                                    logger.verbose(
                                            "Merging %1$s into %2$s",
                                            Joiner.on(',').join(dexArchives), in.getAbsolutePath());
                                    mergeJars(in, cacheableItem.cachable);
                                });
                if (result.getQueryEvent().equals(FileCache.QueryEvent.CORRUPTED)) {
                    Verify.verifyNotNull(result.getCauseOfCorruption());
                    logger.lifecycle(
                            "The build cache at '%1$s' contained an invalid cache entry.\n"
                                    + "Cause: %2$s\n"
                                    + "We have recreated the cache entry.\n"
                                    + "%3$s",
                            cache.getCacheDirectory().getAbsolutePath(),
                            Throwables.getStackTraceAsString(result.getCauseOfCorruption()),
                            BuildCacheUtils.BUILD_CACHE_TROUBLESHOOTING_MESSAGE);
                }
            }
        }
    }

    private static void mergeJars(File out, Iterable<File> dexArchives) throws IOException {

        try (JarOutputStream jarOutputStream =
                new JarOutputStream(new BufferedOutputStream(new FileOutputStream(out)))) {

            Set<String> usedNames = new HashSet<>();
            for (File dexArchive : dexArchives) {
                if (dexArchive.exists()) {
                    try (JarFile jarFile = new JarFile(dexArchive)) {
                        Enumeration<JarEntry> entries = jarFile.entries();
                        while (entries.hasMoreElements()) {
                            JarEntry jarEntry = entries.nextElement();
                            // Get unique name as jars might have multiple classes.dex, as for D8
                            // we do not want to output single dex per class for performance reasons
                            String entryName = jarEntry.getName();
                            while (!usedNames.add(entryName)) {
                                entryName = "_" + entryName;
                            }
                            jarOutputStream.putNextEntry(new JarEntry(entryName));
                            try (InputStream inputStream =
                                    new BufferedInputStream(jarFile.getInputStream(jarEntry))) {
                                ByteStreams.copy(inputStream, jarOutputStream);
                            }
                            jarOutputStream.closeEntry();
                        }
                    }
                }
            }
        }
    }

    /** Returns if the qualified content is an external jar. */
    private static boolean isExternalLib(@NonNull QualifiedContent content) {
        return content.getFile().isFile()
                && content.getScopes()
                        .equals(Collections.singleton(QualifiedContent.Scope.EXTERNAL_LIBRARIES))
                && content.getContentTypes()
                        .equals(Collections.singleton(QualifiedContent.DefaultContentType.CLASSES))
                && !content.getName().startsWith(OriginalStream.LOCAL_JAR_GROUPID);
    }

    /**
     * Input parameters to be provided by the client when using {@link FileCache}.
     *
     * <p>The clients of {@link FileCache} need to exhaustively specify all the inputs that affect
     * the creation of an output file/directory. This enum class lists the input parameters that are
     * used in {@link DexArchiveBuilderCacheHandler}.
     */
    private enum FileCacheInputParams {

        /** The input file. */
        FILE,

        /** Dx version used to create the dex archive. */
        DX_VERSION,

        /** Whether jumbo mode is enabled. */
        JUMBO_MODE,

        /** Whether optimize is enabled. */
        OPTIMIZE,

        /** Tool used to produce the dex archive. */
        DEXER_TOOL,

        /** Version of the cache key. */
        CACHE_KEY_VERSION,

        /** Min sdk version used to generate dex. */
        MIN_SDK_VERSION,

        /** If generate dex is debuggable. */
        IS_DEBUGGABLE,

        /** Additional dependency files. */
        EXTRA_DEPENDENCIES,
    }

    /**
     * Returns a {@link FileCache.Inputs} object computed from the given parameters for the
     * predex-library task to use the build cache.
     */
    @NonNull
    public static FileCache.Inputs getBuildCacheInputs(
            @NonNull File inputFile,
            @NonNull DexOptions dexOptions,
            @NonNull DexerTool dexerTool,
            int minSdkVersion,
            boolean isDebuggable,
            @NonNull List<Path> extraDependencies,
            FileCache.CacheSession cacheSession)
            throws IOException {
        // To use the cache, we need to specify all the inputs that affect the outcome of a pre-dex
        // (see DxDexKey for an exhaustive list of these inputs)
        FileCache.Inputs.Builder buildCacheInputs =
                new FileCache.Inputs.Builder(
                        FileCache.Command.PREDEX_LIBRARY_TO_DEX_ARCHIVE, cacheSession);

        buildCacheInputs
                .putFile(
                        FileCacheInputParams.FILE.name(),
                        inputFile,
                        FileCache.FileProperties.PATH_HASH)
                .putString(FileCacheInputParams.DX_VERSION.name(), Version.VERSION)
                .putBoolean(FileCacheInputParams.JUMBO_MODE.name(), isJumboModeEnabledForDx())
                .putBoolean(
                        FileCacheInputParams.OPTIMIZE.name(),
                        !dexOptions.getAdditionalParameters().contains("--no-optimize"))
                .putString(FileCacheInputParams.DEXER_TOOL.name(), dexerTool.name())
                .putLong(FileCacheInputParams.CACHE_KEY_VERSION.name(), CACHE_KEY_VERSION)
                .putLong(FileCacheInputParams.MIN_SDK_VERSION.name(), minSdkVersion)
                .putBoolean(FileCacheInputParams.IS_DEBUGGABLE.name(), isDebuggable);

        for (int i = 0; i < extraDependencies.size(); i++) {
            Path path = extraDependencies.get(i);
            if (Files.isDirectory(path)) {
                buildCacheInputs.putDirectory(
                        FileCacheInputParams.EXTRA_DEPENDENCIES.name() + "[" + i + "]",
                        path.toFile(),
                        FileCache.DirectoryProperties.PATH_HASH);
            } else if (Files.isRegularFile(path)) {
                buildCacheInputs.putFile(
                        FileCacheInputParams.EXTRA_DEPENDENCIES.name() + "[" + i + "]",
                        path.toFile(),
                        FileCache.FileProperties.PATH_HASH);
            } else if (!Files.exists(path)) {
                throw new NoSuchFileException(path.toString());
            } else {
                throw new IOException("Unsupported file '" + path.toString() + "'");
            }
        }

        return buildCacheInputs.build();
    }

    /** Jumbo mode is always enabled for dex archives - see http://b.android.com/321744 */
    static boolean isJumboModeEnabledForDx() {
        return true;
    }
}
