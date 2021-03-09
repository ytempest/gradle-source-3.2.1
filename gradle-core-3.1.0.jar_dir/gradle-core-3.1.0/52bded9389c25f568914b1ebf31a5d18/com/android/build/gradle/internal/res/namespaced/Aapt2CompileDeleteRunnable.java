/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.builder.internal.aapt.v2.Aapt2RenamingConventions;
/*    */ import java.io.File;
/*    */ import java.io.Serializable;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Path;
/*    */ import java.util.Iterator;
/*    */ import javax.inject.Inject;
/*    */ import kotlin.Metadata;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\032\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\030\0002\0020\001:\001\007B\017\b\007\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\005\032\0020\006H\026R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\b"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/Aapt2CompileDeleteRunnable;", "Ljava/lang/Runnable;", "params", "Lcom/android/build/gradle/internal/res/namespaced/Aapt2CompileDeleteRunnable$Params;", "(Lcom/android/build/gradle/internal/res/namespaced/Aapt2CompileDeleteRunnable$Params;)V", "run", "", "Params", "gradle-core"})
/*    */ public final class Aapt2CompileDeleteRunnable
/*    */   implements Runnable
/*    */ {
/*    */   private final Params params;
/*    */   
/*    */   @Inject
/* 25 */   public Aapt2CompileDeleteRunnable(@NotNull Params params) { this.params = params; }
/*    */   
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\030\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\034\n\002\b\006\030\0002\0020\001B\033\022\006\020\002\032\0020\003\022\f\020\004\032\b\022\004\022\0020\0030\005¢\006\002\020\006R\027\020\004\032\b\022\004\022\0020\0030\005¢\006\b\n\000\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\013"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/Aapt2CompileDeleteRunnable$Params;", "Ljava/io/Serializable;", "outputDirectory", "Ljava/io/File;", "deletedInputs", "", "(Ljava/io/File;Ljava/lang/Iterable;)V", "getDeletedInputs", "()Ljava/lang/Iterable;", "getOutputDirectory", "()Ljava/io/File;", "gradle-core"})
/*    */   public static final class Params implements Serializable {
/*    */     @NotNull
/*    */     private final File outputDirectory;
/*    */     @NotNull
/*    */     private final Iterable<File> deletedInputs;
/*    */     
/*    */     public Params(@NotNull File outputDirectory, @NotNull Iterable<? extends File> deletedInputs) {
/* 35 */       this.outputDirectory = outputDirectory;this.deletedInputs = deletedInputs; } @NotNull
/* 35 */     public final Iterable<File> getDeletedInputs() { return deletedInputs; } @NotNull
/* 35 */     public final File getOutputDirectory() { return outputDirectory; }
/*    */   }
/*    */   
/*    */   public void run()
/*    */   {
/* 29 */     Path outDir = params.getOutputDirectory().toPath();
/* 30 */     Iterable $receiver$iv = params.getDeletedInputs();
/*    */     
/*    */     int $i$f$forEach;
/*    */     
/*    */     File it;
/*    */     
/*    */     int $i$a$1$forEach;
/*    */     
/* 38 */     for (Iterator localIterator = $receiver$iv.iterator(); localIterator.hasNext(); Files.delete(outDir.resolve(Aapt2RenamingConventions.compilationRename(it))))
/*    */     {
/* 38 */       Object element$iv = localIterator.next();it = (File)element$iv;
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.Aapt2CompileDeleteRunnable
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */