/*    */ package com.android.build.gradle.internal.api.artifact;
/*    */ 
/*    */ import com.android.build.api.artifact.BuildableArtifact;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import com.android.builder.errors.EvalIssueReporter.Type;
/*    */ import java.io.File;
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedHashSet;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.atomic.AtomicBoolean;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Task;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ import org.gradle.api.tasks.TaskDependency;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000>\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\020\"\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020(\n\002\b\002\030\000 \0302\0020\001:\001\030B\027\022\b\020\002\032\004\030\0010\003\022\006\020\004\032\0020\005¢\006\002\020\006J\b\020\020\032\0020\021H\002J\b\020\022\032\0020\023H\026J\b\020\024\032\0020\025H\026J\017\020\026\032\b\022\004\022\0020\r0\027H\002R\034\020\002\032\004\030\0010\003X\016¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\032\020\013\032\b\022\004\022\0020\r0\f8VX\004¢\006\006\032\004\b\016\020\017R\016\020\004\032\0020\005X\016¢\006\002\n\000¨\006\031"}, d2={"Lcom/android/build/gradle/internal/api/artifact/BuildableArtifactImpl;", "Lcom/android/build/api/artifact/BuildableArtifact;", "fileCollection", "Lorg/gradle/api/file/FileCollection;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lorg/gradle/api/file/FileCollection;Lcom/android/builder/errors/EvalIssueReporter;)V", "getFileCollection$gradle_core", "()Lorg/gradle/api/file/FileCollection;", "setFileCollection$gradle_core", "(Lorg/gradle/api/file/FileCollection;)V", "files", "", "Ljava/io/File;", "getFiles", "()Ljava/util/Set;", "checkResolvable", "", "getBuildDependencies", "Lorg/gradle/api/tasks/TaskDependency;", "isEmpty", "", "iterator", "", "Companion", "gradle-core"})
/*    */ public final class BuildableArtifactImpl
/*    */   implements BuildableArtifact
/*    */ {
/*    */   public BuildableArtifactImpl(@Nullable FileCollection fileCollection, @NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 31 */     this.fileCollection = fileCollection;this.issueReporter = issueReporter; } @Nullable
/* 32 */   public final FileCollection getFileCollection$gradle_core() { return fileCollection; } public final void setFileCollection$gradle_core(@Nullable FileCollection <set-?>) { fileCollection = <set-?>; }
/*    */   
/* 36 */   public static final Companion Companion = new Companion(null); private static final AtomicBoolean resolvable = new AtomicBoolean(false); @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\002\n\002\020\013\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\006\020\007\032\0020\bJ\006\020\t\032\0020\bJ\006\020\n\032\0020\013R\024\020\003\032\0020\004X\004¢\006\b\n\000\032\004\b\005\020\006¨\006\f"}, d2={"Lcom/android/build/gradle/internal/api/artifact/BuildableArtifactImpl$Companion;", "", "()V", "resolvable", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getResolvable", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "disableResolution", "", "enableResolution", "isResolvable", "", "gradle-core"})
/* 36 */   public static final class Companion { private final AtomicBoolean getResolvable() { return BuildableArtifactImpl.access$getResolvable$cp(); }
/*    */     
/*    */     public final boolean isResolvable() {
/* 39 */       return ((Companion)this).getResolvable().get();
/*    */     }
/*    */     
/*    */     public final void enableResolution() {
/* 43 */       ((Companion)this).getResolvable().set(true);
/*    */     }
/*    */     
/* 47 */     public final void disableResolution() { ((Companion)this).getResolvable().set(false); } }
/*    */   
/*    */   private EvalIssueReporter issueReporter;
/*    */   @Nullable
/*    */   private FileCollection fileCollection;
/* 52 */   private final void checkResolvable() { if (!Companion.isResolvable()) {
/* 53 */       issueReporter.reportError(
/* 54 */         EvalIssueReporter.Type.GENERIC, 
/* 55 */         "Resolving this BuildableArtifact can only done during task execution.");
/*    */     }
/* 57 */     if (fileCollection == null)
/*    */     {
/* 63 */       issueReporter.reportError(
/* 64 */         EvalIssueReporter.Type.GENERIC, 
/* 65 */         "BuildableArtifact has not been initialized."); }
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public Iterator<File> iterator() {
/* 70 */     return getFiles().iterator();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public Set<File> getFiles() {
/* 75 */     checkResolvable(); FileCollection 
/* 76 */       tmp8_5 = fileCollection;
/* 76 */     if (tmp8_5 == null) Intrinsics.throwNpe(); Set tmp23_20 = Collections.unmodifiableSet(tmp8_5.getFiles());Intrinsics.checkExpressionValueIsNotNull(tmp23_20, "Collections.unmodifiable…t(fileCollection!!.files)");return tmp23_20;
/*    */   }
/*    */   
/*    */   public boolean isEmpty() {
/* 80 */     checkResolvable(); FileCollection 
/* 81 */       tmp8_5 = fileCollection;
/* 81 */     if (tmp8_5 == null) Intrinsics.throwNpe(); return tmp8_5.isEmpty();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public TaskDependency getBuildDependencies() {
/* 86 */     FileCollection tmp11_8 = fileCollection;
/*    */     
/* 86 */     if (tmp11_8 == null) Intrinsics.throwNpe(); TaskDependency tmp23_18 = tmp11_8.getBuildDependencies();Intrinsics.checkExpressionValueIsNotNull(tmp23_18, "fileCollection!!.buildDependencies");
/*    */     
/* 88 */     issueReporter.reportError(
/* 89 */       EvalIssueReporter.Type.GENERIC, 
/* 90 */       "Cannot get build dependencies before BuildableArtifact is initialized.");
/*    */     
/* 92 */     return fileCollection != null ? tmp23_18 : (TaskDependency)getBuildDependencies.1.INSTANCE;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.artifact.BuildableArtifactImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */