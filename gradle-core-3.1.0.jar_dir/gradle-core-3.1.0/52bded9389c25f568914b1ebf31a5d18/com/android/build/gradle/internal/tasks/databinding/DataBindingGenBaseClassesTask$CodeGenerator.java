/*     */ package com.android.build.gradle.internal.tasks.databinding;
/*     */ 
/*     */ import android.databinding.tool.BaseDataBinder;
/*     */ import android.databinding.tool.DataBindingBuilder.GradleFileWriter;
/*     */ import android.databinding.tool.store.LayoutInfoInput;
/*     */ import android.databinding.tool.store.LayoutInfoInput.Args;
/*     */ import android.databinding.tool.writer.JavaFileWriter;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import javax.inject.Inject;
/*     */ import kotlin.Metadata;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\"\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\000\030\0002\0020\0012\0020\002B\027\b\007\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006¢\006\002\020\007J\b\020\n\032\0020\013H\026R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\b\020\tR\016\020\005\032\0020\006X\004¢\006\002\n\000¨\006\f"}, d2={"Lcom/android/build/gradle/internal/tasks/databinding/DataBindingGenBaseClassesTask$CodeGenerator;", "Ljava/lang/Runnable;", "Ljava/io/Serializable;", "args", "Landroid/databinding/tool/store/LayoutInfoInput$Args;", "sourceOutFolder", "Ljava/io/File;", "(Landroid/databinding/tool/store/LayoutInfoInput$Args;Ljava/io/File;)V", "getArgs", "()Landroid/databinding/tool/store/LayoutInfoInput$Args;", "run", "", "gradle-core"})
/*     */ public final class DataBindingGenBaseClassesTask$CodeGenerator
/*     */   implements Runnable, Serializable
/*     */ {
/*     */   @NotNull
/*     */   private final LayoutInfoInput.Args args;
/*     */   private final File sourceOutFolder;
/*     */   
/*     */   @Inject
/*     */   public DataBindingGenBaseClassesTask$CodeGenerator(@NotNull LayoutInfoInput.Args args, @NotNull File sourceOutFolder)
/*     */   {
/* 147 */     this.args = args;this.sourceOutFolder = sourceOutFolder; } @NotNull
/* 147 */   public final LayoutInfoInput.Args getArgs() { return args; }
/*     */   
/*     */   public void run()
/*     */   {
/* 151 */     new BaseDataBinder(new LayoutInfoInput(args)).generateAll((JavaFileWriter)new DataBindingBuilder.GradleFileWriter(sourceOutFolder.getAbsolutePath()));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.databinding.DataBindingGenBaseClassesTask.CodeGenerator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */