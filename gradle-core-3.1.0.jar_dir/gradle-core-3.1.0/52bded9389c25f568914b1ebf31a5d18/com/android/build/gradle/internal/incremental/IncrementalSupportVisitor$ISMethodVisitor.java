/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import org.objectweb.asm.MethodVisitor;
/*     */ 
/*     */ class IncrementalSupportVisitor$ISMethodVisitor
/*     */   extends IncrementalSupportVisitor.ISAbstractMethodVisitor
/*     */ {
/*     */   public IncrementalSupportVisitor$ISMethodVisitor(IncrementalSupportVisitor paramIncrementalSupportVisitor, MethodVisitor mv, int access, String name, String desc)
/*     */   {
/* 390 */     super(mv, access, name, desc);
/*     */   }
/*     */   
/*     */   protected void visitChangeField()
/*     */   {
/* 395 */     visitFieldInsn(178, this$0.visitedClassName, "$change", 
/*     */     
/* 399 */       IncrementalVisitor.getRuntimeTypeName(IncrementalVisitor.CHANGE_TYPE));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.IncrementalSupportVisitor.ISMethodVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */