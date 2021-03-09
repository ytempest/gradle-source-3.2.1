/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000*\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\t\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\b\n\000\n\002\020\016\n\000\b\b\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003¢\006\002\020\005J\t\020\t\032\0020\003HÆ\003J\t\020\n\032\0020\003HÆ\003J\035\020\013\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\003HÆ\001J\023\020\f\032\0020\r2\b\020\016\032\004\030\0010\017HÖ\003J\t\020\020\032\0020\021HÖ\001J\t\020\022\032\0020\023HÖ\001R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\006\020\007R\021\020\004\032\0020\003¢\006\b\n\000\032\004\b\b\020\007¨\006\024"}, d2={"Lcom/android/build/gradle/internal/tasks/PipelineToPublicationParam;", "Ljava/io/Serializable;", "inputFile", "Ljava/io/File;", "outputFile", "(Ljava/io/File;Ljava/io/File;)V", "getInputFile", "()Ljava/io/File;", "getOutputFile", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "gradle-core"})
/*     */ final class PipelineToPublicationParam
/*     */   implements Serializable
/*     */ {
/*     */   @NotNull
/*     */   private final File inputFile;
/*     */   @NotNull
/*     */   private final File outputFile;
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/*     */     if (this != paramObject)
/*     */     {
/*     */       if ((paramObject instanceof PipelineToPublicationParam))
/*     */       {
/*     */         PipelineToPublicationParam localPipelineToPublicationParam = (PipelineToPublicationParam)paramObject;
/*     */         if ((!Intrinsics.areEqual(inputFile, inputFile)) || (!Intrinsics.areEqual(outputFile, outputFile))) {}
/*     */       }
/*     */     }
/*     */     else {
/*     */       return true;
/*     */     }
/*     */     return false;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public int hashCode()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 13	com/android/build/gradle/internal/tasks/PipelineToPublicationParam:inputFile	Ljava/io/File;
/*     */     //   4: dup
/*     */     //   5: ifnull +9 -> 14
/*     */     //   8: invokevirtual 66	java/lang/Object:hashCode	()I
/*     */     //   11: goto +5 -> 16
/*     */     //   14: pop
/*     */     //   15: iconst_0
/*     */     //   16: bipush 31
/*     */     //   18: imul
/*     */     //   19: aload_0
/*     */     //   20: getfield 19	com/android/build/gradle/internal/tasks/PipelineToPublicationParam:outputFile	Ljava/io/File;
/*     */     //   23: dup
/*     */     //   24: ifnull +9 -> 33
/*     */     //   27: invokevirtual 66	java/lang/Object:hashCode	()I
/*     */     //   30: goto +5 -> 35
/*     */     //   33: pop
/*     */     //   34: iconst_0
/*     */     //   35: iadd
/*     */     //   36: ireturn
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/*     */     return "PipelineToPublicationParam(inputFile=" + inputFile + ", outputFile=" + outputFile + ")";
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final PipelineToPublicationParam copy(@NotNull File inputFile, @NotNull File outputFile)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(inputFile, "inputFile");
/*     */     Intrinsics.checkParameterIsNotNull(outputFile, "outputFile");
/*     */     return new PipelineToPublicationParam(inputFile, outputFile);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final File component2()
/*     */   {
/*     */     return outputFile;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final File component1()
/*     */   {
/*     */     return inputFile;
/*     */   }
/*     */   
/*     */   public PipelineToPublicationParam(@NotNull File inputFile, @NotNull File outputFile)
/*     */   {
/* 121 */     this.inputFile = inputFile;this.outputFile = outputFile; } @NotNull
/* 121 */   public final File getOutputFile() { return outputFile; } @NotNull
/* 121 */   public final File getInputFile() { return inputFile; }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.PipelineToPublicationParam
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */