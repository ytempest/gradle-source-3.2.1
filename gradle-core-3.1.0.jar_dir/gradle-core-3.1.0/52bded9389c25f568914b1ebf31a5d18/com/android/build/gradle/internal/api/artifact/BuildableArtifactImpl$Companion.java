/*    */ package com.android.build.gradle.internal.api.artifact;
/*    */ 
/*    */ import java.util.concurrent.atomic.AtomicBoolean;
/*    */ import kotlin.Metadata;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\002\n\002\020\013\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\006\020\007\032\0020\bJ\006\020\t\032\0020\bJ\006\020\n\032\0020\013R\024\020\003\032\0020\004X\004¢\006\b\n\000\032\004\b\005\020\006¨\006\f"}, d2={"Lcom/android/build/gradle/internal/api/artifact/BuildableArtifactImpl$Companion;", "", "()V", "resolvable", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getResolvable", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "disableResolution", "", "enableResolution", "isResolvable", "", "gradle-core"})
/*    */ public final class BuildableArtifactImpl$Companion
/*    */ {
/*    */   private final AtomicBoolean getResolvable()
/*    */   {
/* 36 */     return BuildableArtifactImpl.access$getResolvable$cp();
/*    */   }
/*    */   
/* 39 */   public final boolean isResolvable() { return ((Companion)this).getResolvable().get(); }
/*    */   
/*    */   public final void enableResolution()
/*    */   {
/* 43 */     ((Companion)this).getResolvable().set(true);
/*    */   }
/*    */   
/*    */   public final void disableResolution() {
/* 47 */     ((Companion)this).getResolvable().set(false);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.artifact.BuildableArtifactImpl.Companion
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */