/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.builder.internal.aapt.AaptPackageConfig;
/*    */ import com.android.repository.Revision;
/*    */ import java.io.Serializable;
/*    */ import kotlin.Metadata;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\030\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\013"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/Aapt2LinkRunnable$Params;", "Ljava/io/Serializable;", "revision", "Lcom/android/repository/Revision;", "request", "Lcom/android/builder/internal/aapt/AaptPackageConfig;", "(Lcom/android/repository/Revision;Lcom/android/builder/internal/aapt/AaptPackageConfig;)V", "getRequest", "()Lcom/android/builder/internal/aapt/AaptPackageConfig;", "getRevision", "()Lcom/android/repository/Revision;", "gradle-core"})
/*    */ public final class Aapt2LinkRunnable$Params
/*    */   implements Serializable
/*    */ {
/*    */   @NotNull
/*    */   private final Revision revision;
/*    */   @NotNull
/*    */   private final AaptPackageConfig request;
/*    */   
/*    */   public Aapt2LinkRunnable$Params(@NotNull Revision revision, @NotNull AaptPackageConfig request)
/*    */   {
/* 36 */     this.revision = revision;this.request = request; } @NotNull
/* 37 */   public final Revision getRevision() { return revision; } @NotNull
/* 38 */   public final AaptPackageConfig getRequest() { return request; }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.Aapt2LinkRunnable.Params
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */