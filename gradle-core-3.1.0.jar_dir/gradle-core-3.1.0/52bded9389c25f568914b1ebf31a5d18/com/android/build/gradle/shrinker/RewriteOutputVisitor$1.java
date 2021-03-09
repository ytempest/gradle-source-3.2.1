/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import org.objectweb.asm.Label;
/*     */ import org.objectweb.asm.MethodVisitor;
/*     */ import org.objectweb.asm.commons.Remapper;
/*     */ 
/*     */ class RewriteOutputVisitor$1
/*     */   extends MethodVisitor
/*     */ {
/*     */   RewriteOutputVisitor$1(RewriteOutputVisitor this$0, int x0, MethodVisitor x1)
/*     */   {
/* 113 */     super(x0, x1);
/*     */   }
/*     */   
/*     */   public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index)
/*     */   {
/* 122 */     signature = RewriteOutputVisitor.access$100(this$0).mapSignature(signature, true);
/* 123 */     super.visitLocalVariable(name, desc, signature, start, end, index);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.RewriteOutputVisitor.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */