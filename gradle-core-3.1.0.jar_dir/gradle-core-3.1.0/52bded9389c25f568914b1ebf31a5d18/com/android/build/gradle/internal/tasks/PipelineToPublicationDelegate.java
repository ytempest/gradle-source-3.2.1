/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import java.io.File;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000.\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\b\002\030\0002\0020\001B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bJ\016\020\r\032\b\022\004\022\0020\0170\016H\026J\b\020\020\032\0020\021H\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\nR\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\013\020\f¨\006\022"}, d2={"Lcom/android/build/gradle/internal/tasks/PipelineToPublicationDelegate;", "Lcom/android/build/gradle/internal/tasks/TaskDelegateWithWorker;", "inputCollection", "Lorg/gradle/api/file/FileCollection;", "outputFile", "Ljava/io/File;", "projectOptions", "Lcom/android/build/gradle/options/ProjectOptions;", "(Lorg/gradle/api/file/FileCollection;Ljava/io/File;Lcom/android/build/gradle/options/ProjectOptions;)V", "getInputCollection", "()Lorg/gradle/api/file/FileCollection;", "getOutputFile", "()Ljava/io/File;", "getWorkerClass", "Ljava/lang/Class;", "Lcom/android/build/gradle/internal/tasks/PipelineOutputCopier;", "getWorkerParam", "Lcom/android/build/gradle/internal/tasks/PipelineToPublicationParam;", "gradle-core"})
/*     */ final class PipelineToPublicationDelegate
/*     */   extends TaskDelegateWithWorker
/*     */ {
/*     */   @NotNull
/*     */   private final FileCollection inputCollection;
/*     */   @NotNull
/*     */   private final File outputFile;
/*     */   
/*     */   @NotNull
/* 106 */   public final FileCollection getInputCollection() { return inputCollection; } @NotNull
/* 107 */   public final File getOutputFile() { return outputFile; }
/*     */   
/* 109 */   public PipelineToPublicationDelegate(@NotNull FileCollection inputCollection, @NotNull File outputFile, @NotNull ProjectOptions projectOptions) { super(projectOptions);this.inputCollection = inputCollection;this.outputFile = outputFile; }
/*     */   @NotNull
/* 111 */   public Class<PipelineOutputCopier> getWorkerClass() { return PipelineOutputCopier.class; }
/*     */   
/*     */   @NotNull
/* 114 */   public PipelineToPublicationParam getWorkerParam() { File tmp13_8 = inputCollection.getSingleFile();Intrinsics.checkExpressionValueIsNotNull(tmp13_8, "inputCollection.singleFile");return new PipelineToPublicationParam(tmp13_8, outputFile);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.PipelineToPublicationDelegate
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */