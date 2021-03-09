/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import org.objectweb.asm.signature.SignatureVisitor;
/*     */ 
/*     */ class DependencyFinderVisitor$DependencyFinderSignatureVisitor
/*     */   extends SignatureVisitor
/*     */ {
/*     */   DependencyFinderVisitor$DependencyFinderSignatureVisitor(DependencyFinderVisitor paramDependencyFinderVisitor)
/*     */   {
/* 549 */     super(327680);
/*     */   }
/*     */   
/*     */   public void visitClassType(String name)
/*     */   {
/* 554 */     if (!AbstractShrinker.isSdkPackage(name)) {
/* 555 */       DependencyFinderVisitor.access$200(this$0).addTypeFromGenericSignature(DependencyFinderVisitor.access$500(this$0), DependencyFinderVisitor.access$200(this$0).getClassReference(name));
/*     */     }
/* 557 */     super.visitClassType(name);
/*     */   }
/*     */   
/*     */   public void visitInnerClassType(String name)
/*     */   {
/* 562 */     if (!AbstractShrinker.isSdkPackage(name)) {
/* 563 */       DependencyFinderVisitor.access$200(this$0).addTypeFromGenericSignature(DependencyFinderVisitor.access$500(this$0), DependencyFinderVisitor.access$200(this$0).getClassReference(name));
/*     */     }
/* 565 */     super.visitInnerClassType(name);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.DependencyFinderVisitor.DependencyFinderSignatureVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */