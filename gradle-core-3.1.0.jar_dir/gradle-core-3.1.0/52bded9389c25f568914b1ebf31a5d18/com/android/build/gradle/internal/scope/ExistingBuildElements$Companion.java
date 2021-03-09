/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import com.android.ide.common.build.ApkInfo;
/*     */ import com.android.ide.common.internal.WaitableExecutor;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import com.google.gson.reflect.TypeToken;
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.lang.reflect.Type;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.io.CloseableKt;
/*     */ import kotlin.jvm.JvmStatic;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import kotlin.sequences.SequencesKt;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.file.FileTree;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000V\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\020\036\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\032\020\007\032\0020\b2\006\020\t\032\0020\n2\b\020\013\032\004\030\0010\fH\002J\030\020\r\032\0020\b2\006\020\t\032\0020\n2\006\020\r\032\0020\fH\007J\030\020\r\032\0020\b2\006\020\t\032\0020\n2\006\020\r\032\0020\016H\007J\020\020\017\032\0020\f2\006\020\020\032\0020\fH\007J\022\020\021\032\004\030\0010\f2\006\020\020\032\0020\fH\007J\022\020\021\032\004\030\0010\f2\006\020\022\032\0020\016H\002J(\020\023\032\b\022\004\022\0020\0250\0242\006\020\026\032\0020\0272\b\020\030\032\004\030\0010\n2\006\020\031\032\0020\032H\007J\026\020\033\032\b\022\004\022\0020\0340\0242\006\020\035\032\0020\fH\007J\026\020\036\032\0020\0372\f\020 \032\b\022\004\022\0020\0340\024H\007R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006!"}, d2={"Lcom/android/build/gradle/internal/scope/ExistingBuildElements$Companion;", "", "()V", "executor", "Lcom/android/ide/common/internal/WaitableExecutor;", "getExecutor", "()Lcom/android/ide/common/internal/WaitableExecutor;", "_from", "Lcom/android/build/gradle/internal/scope/BuildElements;", "elementType", "Lcom/android/build/gradle/internal/scope/TaskOutputHolder$OutputType;", "metadataFile", "Ljava/io/File;", "from", "Lorg/gradle/api/file/FileCollection;", "getMetadataFile", "folder", "getMetadataFileIfPresent", "fileCollection", "load", "", "Lcom/android/build/gradle/internal/scope/BuildOutput;", "projectPath", "Ljava/nio/file/Path;", "outputType", "reader", "Ljava/io/Reader;", "loadApkList", "Lcom/android/ide/common/build/ApkInfo;", "file", "persistApkList", "", "apkInfos", "gradle-core"})
/*     */ public final class ExistingBuildElements$Companion
/*     */ {
/*     */   @NotNull
/*     */   public final WaitableExecutor getExecutor()
/*     */   {
/*  44 */     return ExistingBuildElements.access$getExecutor$cp();
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public final BuildElements from(@NotNull TaskOutputHolder.OutputType elementType, @NotNull FileCollection from)
/*     */   {
/*  52 */     Intrinsics.checkParameterIsNotNull(elementType, "elementType");Intrinsics.checkParameterIsNotNull(from, "from");File metadataFile = ((Companion)this).getMetadataFileIfPresent(from);
/*  53 */     return ((Companion)this)._from(elementType, metadataFile);
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public final BuildElements from(@NotNull TaskOutputHolder.OutputType elementType, @NotNull File from)
/*     */   {
/*  64 */     Intrinsics.checkParameterIsNotNull(elementType, "elementType");Intrinsics.checkParameterIsNotNull(from, "from");File metadataFile = ((Companion)this).getMetadataFileIfPresent(from);
/*  65 */     return ((Companion)this)._from(elementType, metadataFile);
/*     */   }
/*     */   
/*     */   private final BuildElements _from(TaskOutputHolder.OutputType elementType, File metadataFile)
/*     */   {
/*  70 */     if ((metadataFile == null) || (!metadataFile.exists())) {
/*  71 */       ImmutableList tmp18_15 = ImmutableList.of();Intrinsics.checkExpressionValueIsNotNull(tmp18_15, "ImmutableList.of()");return new BuildElements((Collection)tmp18_15);
/*     */     }
/*     */     try {
/*  74 */       Closeable localCloseable = (Closeable)new FileReader(metadataFile);Throwable localThrowable1 = (Throwable)null; try { FileReader reader = (FileReader)localCloseable;
/*  75 */         int $i$a$1$use; Path tmp71_68 = metadataFile.getParentFile().toPath();Intrinsics.checkExpressionValueIsNotNull(tmp71_68, "metadataFile.parentFile.toPath()");return new BuildElements(ExistingBuildElements.Companion.load(tmp71_68, 
/*  76 */           elementType, 
/*  77 */           (Reader)reader));
/*     */       }
/*     */       catch (Throwable localThrowable)
/*     */       {
/*  74 */         localThrowable1 = localThrowable; throw localThrowable; } finally { CloseableKt.closeFinally(localCloseable, localThrowable1);
/*     */       }
/*     */       
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  80 */       Intrinsics.checkExpressionValueIsNotNull(ImmutableList.of(), "ImmutableList.of<BuildOutput>()"); } return new BuildElements((Collection)tmp128_125);
/*     */   }
/*     */   
/*     */   private final File getMetadataFileIfPresent(FileCollection fileCollection)
/*     */   {
/*  85 */     FileTree tmp6_1 = fileCollection.getAsFileTree();Intrinsics.checkExpressionValueIsNotNull(tmp6_1, "fileCollection.asFileTree"); Set tmp17_12 = tmp6_1.getFiles();Intrinsics.checkExpressionValueIsNotNull(tmp17_12, "fileCollection.asFileTree.files");Iterable localIterable1 = (Iterable)tmp17_12;Iterable localIterable2 = localIterable1; Object localObject; for (Iterator localIterator = localIterable2.iterator(); localIterator.hasNext(); Intrinsics.checkExpressionValueIsNotNull(tmp65_63, "it")) { localObject = localIterator.next();File it = (File)localObject; int $i$a$1$find; } return (File)(Intrinsics.areEqual(tmp65_63.getName(), "output.json") ? localObject : null);
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @Nullable
/*  90 */   public final File getMetadataFileIfPresent(@NotNull File folder) { Intrinsics.checkParameterIsNotNull(folder, "folder");File outputFile = ((Companion)this).getMetadataFile(folder);
/*  91 */     return outputFile.exists() ? outputFile : null;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*  96 */   public final File getMetadataFile(@NotNull File folder) { Intrinsics.checkParameterIsNotNull(folder, "folder");return new File(folder, "output.json");
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/* 101 */   public final String persistApkList(@NotNull Collection<? extends ApkInfo> apkInfos) { Intrinsics.checkParameterIsNotNull(apkInfos, "apkInfos");GsonBuilder gsonBuilder = new GsonBuilder();
/* 102 */     gsonBuilder.registerTypeHierarchyAdapter(ApkInfo.class, new ExistingBuildElements.ApkInfoAdapter());
/* 103 */     Gson gson = gsonBuilder.create(); String 
/* 104 */       tmp38_35 = gson.toJson(apkInfos);Intrinsics.checkExpressionValueIsNotNull(tmp38_35, "gson.toJson(apkInfos)");return tmp38_35;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public final Collection<ApkInfo> loadApkList(@NotNull File file) throws FileNotFoundException {
/* 110 */     Intrinsics.checkParameterIsNotNull(file, "file");GsonBuilder gsonBuilder = new GsonBuilder();
/* 111 */     gsonBuilder.registerTypeHierarchyAdapter(ApkInfo.class, new ExistingBuildElements.ApkInfoAdapter());
/* 112 */     gsonBuilder.registerTypeAdapter((Type)TaskOutputHolder.OutputType.class, 
/* 113 */       new ExistingBuildElements.OutputTypeTypeAdapter());
/* 114 */     Gson gson = gsonBuilder.create();
/* 115 */     Type recordType = new TypeToken() {}.getType(); Object tmp79_76 = gson.fromJson((Reader)new FileReader(file), recordType);Intrinsics.checkExpressionValueIsNotNull(tmp79_76, "gson.fromJson(FileReader(file), recordType)");return (Collection)tmp79_76;
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public final Collection<BuildOutput> load(@NotNull Path projectPath, @Nullable TaskOutputHolder.OutputType outputType, @NotNull Reader reader)
/*     */   {
/* 124 */     Intrinsics.checkParameterIsNotNull(projectPath, "projectPath");Intrinsics.checkParameterIsNotNull(reader, "reader");GsonBuilder gsonBuilder = new GsonBuilder();
/*     */     
/* 126 */     gsonBuilder.registerTypeAdapter((Type)ApkInfo.class, new ExistingBuildElements.ApkInfoAdapter());
/* 127 */     gsonBuilder.registerTypeAdapter((Type)TaskOutputHolder.OutputType.class, 
/* 128 */       new ExistingBuildElements.OutputTypeTypeAdapter());
/* 129 */     Gson gson = gsonBuilder.create();
/* 130 */     Type recordType = new TypeToken() {}.getType();
/* 131 */     Collection buildOutputs = (Collection)gson.fromJson(reader, recordType); Collection 
/*     */     
/* 133 */       tmp91_89 = buildOutputs;Intrinsics.checkExpressionValueIsNotNull(tmp91_89, "buildOutputs");
/*     */     
/* 143 */     (Collection)SequencesKt.toList(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence((Iterable)tmp91_89), (Function1)new Lambda(outputType) { public final boolean invoke(@NotNull BuildOutput it) { Intrinsics.checkParameterIsNotNull(it, "it");return ($outputType == null) || (Intrinsics.areEqual(it.getType(), $outputType));
/* 136 */       } }), (Function1)new Lambda(projectPath) { @NotNull
/* 137 */       public final BuildOutput invoke(@NotNull BuildOutput buildOutput) { Intrinsics.checkParameterIsNotNull(buildOutput, "buildOutput");
/*     */         
/* 141 */         return new BuildOutput(buildOutput.getType(), buildOutput.getApkInfo(), $projectPath.resolve(buildOutput.getOutputPath()), buildOutput.getProperties());
/*     */       }
/*     */     }));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.ExistingBuildElements.Companion
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */