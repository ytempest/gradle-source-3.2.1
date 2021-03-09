/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.build.gradle.internal.cxx.json.AndroidBuildGradleJsonCompositeVisitor;
/*     */ import com.android.build.gradle.internal.cxx.json.AndroidBuildGradleJsonStatsBuildingVisitor;
/*     */ import com.android.build.gradle.internal.cxx.json.AndroidBuildGradleJsonStreamingParser;
/*     */ import com.android.build.gradle.internal.cxx.json.AndroidBuildGradleJsonStreamingVisitor;
/*     */ import com.android.builder.model.NativeAndroidProject;
/*     */ import com.android.builder.model.NativeArtifact;
/*     */ import com.android.builder.model.NativeFile;
/*     */ import com.android.builder.model.NativeSettings;
/*     */ import com.android.builder.model.NativeToolchain;
/*     */ import com.android.builder.model.Version;
/*     */ import com.android.utils.StringHelper;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.wireless.android.sdk.stats.GradleBuildVariant.NativeBuildConfigInfo.Builder;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ class NativeAndroidProjectBuilder
/*     */ {
/*     */   private final String projectName;
/*  49 */   private final Set<File> buildFiles = Sets.newHashSet();
/*  50 */   private final Map<String, String> extensions = Maps.newHashMap();
/*  51 */   private final List<NativeArtifact> artifacts = Lists.newArrayList();
/*  52 */   private final List<NativeToolchain> toolChains = Lists.newArrayList();
/*  53 */   private final Map<List<String>, NativeSettings> settingsMap = Maps.newHashMap();
/*  54 */   private final Set<String> buildSystems = Sets.newHashSet();
/*  55 */   int settingIndex = 0;
/*     */   
/*     */   NativeAndroidProjectBuilder(String projectName) {
/*  58 */     this.projectName = projectName;
/*     */   }
/*     */   
/*     */   void addBuildSystem(String buildSystem)
/*     */   {
/*  65 */     buildSystems.add(buildSystem);
/*     */   }
/*     */   
/*     */   void addJson(JsonReader reader, String variantName, GradleBuildVariant.NativeBuildConfigInfo.Builder config)
/*     */     throws IOException
/*     */   {
/*  77 */     JsonStreamingVisitor modelBuildingVisitor = new JsonStreamingVisitor(this, variantName);
/*  78 */     AndroidBuildGradleJsonStatsBuildingVisitor statsVisitor = new AndroidBuildGradleJsonStatsBuildingVisitor(config);
/*     */     
/*  80 */     AndroidBuildGradleJsonCompositeVisitor composite = new AndroidBuildGradleJsonCompositeVisitor(new AndroidBuildGradleJsonStreamingVisitor[] { statsVisitor, modelBuildingVisitor });
/*     */     
/*  82 */     AndroidBuildGradleJsonStreamingParser parser = new AndroidBuildGradleJsonStreamingParser(reader, composite);Throwable localThrowable3 = null;
/*     */     try {
/*  84 */       parser.parse();
/*     */     }
/*     */     catch (Throwable localThrowable1)
/*     */     {
/*  82 */       localThrowable3 = localThrowable1;throw localThrowable1;
/*     */     }
/*     */     finally {
/*  85 */       if (parser != null) { if (localThrowable3 != null) try { parser.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else { parser.close();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   NativeAndroidProject buildOrNull()
/*     */   {
/*  95 */     if (buildFiles.isEmpty()) {
/*  96 */       return null;
/*     */     }
/*  98 */     return new NativeAndroidProjectImpl(Version.ANDROID_GRADLE_PLUGIN_VERSION, projectName, buildFiles, artifacts, toolChains, 
/*     */     
/* 104 */       ImmutableList.copyOf(settingsMap.values()), extensions, buildSystems, Version.BUILDER_MODEL_API_VERSION);
/*     */   }
/*     */   
/*     */   static class JsonStreamingVisitor
/*     */     extends AndroidBuildGradleJsonStreamingVisitor
/*     */   {
/*     */     private final NativeAndroidProjectBuilder builder;
/*     */     
/*     */     private final String variantName;
/*     */     
/* 116 */     private String currentToolchain = null;
/* 117 */     private String currentCExecutable = null;
/* 118 */     private String currentCppExecutable = null;
/* 119 */     private String currentLibraryName = null;
/* 120 */     private String currentLibraryToolchain = null;
/* 121 */     private String currentLibraryOutput = null;
/* 122 */     private String currentLibraryAbi = null;
/* 123 */     private String currentLibraryArtifactName = null;
/* 124 */     private List<File> currentLibraryRuntimeFiles = null;
/* 125 */     private List<NativeFile> currentLibrarySourceFiles = null;
/* 126 */     private String currentLibraryFileSettingsName = null;
/* 127 */     private String currentLibraryFilePath = null;
/* 128 */     private String currentLibraryFileWorkingDirectory = null;
/*     */     
/*     */     JsonStreamingVisitor(NativeAndroidProjectBuilder builder, String variantName)
/*     */     {
/* 132 */       this.variantName = variantName;
/* 133 */       this.builder = builder;
/*     */     }
/*     */     
/*     */     public void visitBuildFile(String buildFile)
/*     */     {
/* 138 */       builder.buildFiles.add(new File(buildFile));
/*     */     }
/*     */     
/*     */     public void beginLibrary(String libraryName)
/*     */     {
/* 143 */       currentLibraryName = libraryName;
/* 144 */       currentLibraryRuntimeFiles = Lists.newArrayList();
/* 145 */       currentLibrarySourceFiles = Lists.newArrayList();
/*     */     }
/*     */     
/*     */     public void endLibrary()
/*     */     {
/* 150 */       Preconditions.checkNotNull(currentLibraryName);
/* 151 */       Preconditions.checkNotNull(currentLibraryToolchain);
/* 152 */       Preconditions.checkNotNull(currentLibrarySourceFiles);
/* 153 */       Preconditions.checkNotNull(currentLibraryOutput);
/* 154 */       Preconditions.checkNotNull(currentLibraryRuntimeFiles);
/* 155 */       Preconditions.checkNotNull(currentLibraryAbi);
/* 156 */       Preconditions.checkNotNull(currentLibraryArtifactName);
/*     */       
/* 158 */       builder.artifacts.add(new NativeArtifactImpl(currentLibraryName, currentLibraryToolchain, variantName, "", 
/*     */       
/* 164 */         ImmutableList.of(), currentLibrarySourceFiles, 
/*     */         
/* 166 */         ImmutableList.of(), 
/* 167 */         newFileOrNull(currentLibraryOutput), currentLibraryRuntimeFiles, currentLibraryAbi, currentLibraryArtifactName));
/*     */       
/* 172 */       currentLibraryName = null;
/* 173 */       currentLibraryToolchain = null;
/* 174 */       currentLibraryOutput = null;
/* 175 */       currentLibraryAbi = null;
/* 176 */       currentLibraryArtifactName = null;
/* 177 */       currentLibraryRuntimeFiles = null;
/* 178 */       currentLibrarySourceFiles = null;
/*     */     }
/*     */     
/*     */     public void beginToolchain(String toolchain)
/*     */     {
/* 183 */       currentToolchain = toolchain;
/*     */     }
/*     */     
/*     */     public void endToolchain()
/*     */     {
/* 188 */       Preconditions.checkNotNull(currentToolchain);
/* 189 */       builder.toolChains.add(new NativeToolchainImpl(currentToolchain, 
/*     */       
/* 192 */         newFileOrNull(currentCExecutable), 
/* 193 */         newFileOrNull(currentCppExecutable)));
/* 194 */       currentToolchain = null;
/* 195 */       currentCExecutable = null;
/* 196 */       currentCppExecutable = null;
/*     */     }
/*     */     
/*     */     private File newFileOrNull(String filename)
/*     */     {
/* 201 */       if (filename == null) {
/* 202 */         return null;
/*     */       }
/* 204 */       return new File(filename);
/*     */     }
/*     */     
/*     */     public void visitLibraryAbi(String abi)
/*     */     {
/* 209 */       currentLibraryAbi = abi;
/*     */     }
/*     */     
/*     */     public void visitLibraryArtifactName(String artifact)
/*     */     {
/* 214 */       currentLibraryArtifactName = artifact;
/*     */     }
/*     */     
/*     */     public void visitLibraryOutput(String output)
/*     */     {
/* 219 */       currentLibraryOutput = output;
/*     */     }
/*     */     
/*     */     public void visitLibraryToolchain(String toolchain)
/*     */     {
/* 224 */       currentLibraryToolchain = toolchain;
/*     */     }
/*     */     
/*     */     public void visitToolchainCCompilerExecutable(String executable)
/*     */     {
/* 229 */       currentCExecutable = executable;
/*     */     }
/*     */     
/*     */     public void visitToolchainCppCompilerExecutable(String executable)
/*     */     {
/* 234 */       currentCppExecutable = executable;
/*     */     }
/*     */     
/*     */     public void visitLibraryFileFlags(String flags)
/*     */     {
/* 240 */       currentLibraryFileSettingsName = getSettingsName(StringHelper.tokenizeCommandLineToEscaped(flags));
/*     */     }
/*     */     
/*     */     public void visitLibraryFileSrc(String src)
/*     */     {
/* 245 */       currentLibraryFilePath = src;
/*     */     }
/*     */     
/*     */     public void visitLibraryFileWorkingDirectory(String workingDirectory)
/*     */     {
/* 250 */       currentLibraryFileWorkingDirectory = workingDirectory;
/*     */     }
/*     */     
/*     */     public void visitCFileExtensions(String extension)
/*     */     {
/* 255 */       builder.extensions.put(extension, "c");
/*     */     }
/*     */     
/*     */     public void visitCppFileExtensions(String extension)
/*     */     {
/* 260 */       builder.extensions.put(extension, "c++");
/*     */     }
/*     */     
/*     */     public void visitLibraryRuntimeFile(String runtimeFile)
/*     */     {
/* 265 */       Preconditions.checkNotNull(currentLibraryRuntimeFiles);
/* 266 */       currentLibraryRuntimeFiles.add(new File(runtimeFile));
/*     */     }
/*     */     
/*     */     public void endLibraryFile()
/*     */     {
/* 271 */       Preconditions.checkNotNull(currentLibrarySourceFiles);
/* 272 */       Preconditions.checkNotNull(currentLibraryFilePath);
/*     */       
/* 274 */       if (currentLibraryFileSettingsName != null)
/*     */       {
/* 279 */         currentLibrarySourceFiles.add(new NativeFileImpl(new File(currentLibraryFilePath), currentLibraryFileSettingsName, 
/*     */         
/* 283 */           newFileOrNull(currentLibraryFileWorkingDirectory)));
/*     */       }
/*     */       
/* 286 */       currentLibraryFilePath = null;
/* 287 */       currentLibraryFileSettingsName = null;
/* 288 */       currentLibraryFileWorkingDirectory = null;
/*     */     }
/*     */     
/*     */     private String getSettingsName(List<String> flags)
/*     */     {
/* 293 */       List<String> flagsCopy = ImmutableList.copyOf(flags);
/* 294 */       NativeSettings setting = (NativeSettings)builder.settingsMap.get(flags);
/* 295 */       if (setting == null) {
/* 296 */         setting = new NativeSettingsImpl("setting" + builder.settingIndex, flagsCopy);
/* 297 */         builder.settingsMap.put(flagsCopy, setting);
/* 298 */         builder.settingIndex += 1;
/*     */       }
/* 300 */       return setting.getName();
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.NativeAndroidProjectBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */