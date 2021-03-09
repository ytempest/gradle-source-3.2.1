/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.io.Files;
/*     */ import java.io.File;
/*     */ import javax.inject.Inject;
/*     */ import kotlin.Metadata;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\030\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\000\b\002\030\0002\0020\001B\017\b\007\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\007\032\0020\bH\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\t"}, d2={"Lcom/android/build/gradle/internal/tasks/PipelineOutputCopier;", "Ljava/lang/Runnable;", "param", "Lcom/android/build/gradle/internal/tasks/PipelineToPublicationParam;", "(Lcom/android/build/gradle/internal/tasks/PipelineToPublicationParam;)V", "getParam", "()Lcom/android/build/gradle/internal/tasks/PipelineToPublicationParam;", "run", "", "gradle-core"})
/*     */ final class PipelineOutputCopier
/*     */   implements Runnable
/*     */ {
/*     */   @NotNull
/*     */   private final PipelineToPublicationParam param;
/*     */   
/*     */   @Inject
/* 129 */   public PipelineOutputCopier(@NotNull PipelineToPublicationParam param) { this.param = param; } @NotNull
/* 130 */   public final PipelineToPublicationParam getParam() { return param; }
/*     */   
/*     */   public void run()
/*     */   {
/* 134 */     File inputFile = param.getInputFile();
/* 135 */     File outputFile = param.getOutputFile();
/*     */     
/* 137 */     FileUtils.deleteDirectoryContents(outputFile);
/*     */     
/* 139 */     File targetFile = new File(outputFile, inputFile.getName());
/*     */     
/* 141 */     if (inputFile.isFile()) {
/* 142 */       Files.copy(inputFile, targetFile);
/*     */     }
/*     */     else {
/* 145 */       FileUtils.mkdirs(targetFile);
/*     */       
/* 147 */       FileUtils.copyDirectoryContentToDirectory(inputFile, targetFile);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.PipelineOutputCopier
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */