/*    */ package com.android.build.gradle.internal.transforms;
/*    */ 
/*    */ import com.android.build.gradle.internal.incremental.InstantRunVerifierStatus;
/*    */ 
/*    */ class InstantRunVerifierTransform$VerificationResult
/*    */ {
/*    */   private final InstantRunVerifierStatus changes;
/*    */   
/*    */   InstantRunVerifierTransform$VerificationResult(InstantRunVerifierStatus changes)
/*    */   {
/* 89 */     this.changes = changes;
/*    */   }
/*    */   
/*    */   public boolean isCompatible()
/*    */   {
/* 98 */     return changes == null;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.InstantRunVerifierTransform.VerificationResult
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */