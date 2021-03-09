/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.Serializable;
/*    */ import kotlin.Metadata;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\030\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\034\n\002\b\006\030\0002\0020\001B\033\022\006\020\002\032\0020\003\022\f\020\004\032\b\022\004\022\0020\0030\005¢\006\002\020\006R\027\020\004\032\b\022\004\022\0020\0030\005¢\006\b\n\000\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\013"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/Aapt2CompileDeleteRunnable$Params;", "Ljava/io/Serializable;", "outputDirectory", "Ljava/io/File;", "deletedInputs", "", "(Ljava/io/File;Ljava/lang/Iterable;)V", "getDeletedInputs", "()Ljava/lang/Iterable;", "getOutputDirectory", "()Ljava/io/File;", "gradle-core"})
/*    */ public final class Aapt2CompileDeleteRunnable$Params
/*    */   implements Serializable
/*    */ {
/*    */   @NotNull
/*    */   private final File outputDirectory;
/*    */   @NotNull
/*    */   private final Iterable<File> deletedInputs;
/*    */   
/*    */   public Aapt2CompileDeleteRunnable$Params(@NotNull File outputDirectory, @NotNull Iterable<? extends File> deletedInputs)
/*    */   {
/* 35 */     this.outputDirectory = outputDirectory;this.deletedInputs = deletedInputs; } @NotNull
/* 35 */   public final Iterable<File> getDeletedInputs() { return deletedInputs; } @NotNull
/* 35 */   public final File getOutputDirectory() { return outputDirectory; }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.Aapt2CompileDeleteRunnable.Params
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */