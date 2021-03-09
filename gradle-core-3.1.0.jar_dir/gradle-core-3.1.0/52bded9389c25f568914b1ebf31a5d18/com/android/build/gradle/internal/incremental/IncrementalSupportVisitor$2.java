/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import java.util.Map;
/*     */ import org.objectweb.asm.Type;
/*     */ import org.objectweb.asm.commons.GeneratorAdapter;
/*     */ import org.objectweb.asm.tree.MethodNode;
/*     */ 
/*     */ class IncrementalSupportVisitor$2
/*     */   extends StringSwitch
/*     */ {
/*     */   IncrementalSupportVisitor$2(IncrementalSupportVisitor this$0, GeneratorAdapter paramGeneratorAdapter, int paramInt, Map paramMap) {}
/*     */   
/*     */   void visitString()
/*     */   {
/* 649 */     val$mv.loadLocal(val$constructorCanonicalName);
/*     */   }
/*     */   
/*     */   void visitCase(String canonicalName)
/*     */   {
/* 654 */     MethodNode methodNode = (MethodNode)val$uniqueMethods.get(canonicalName);
/* 655 */     String owner = canonicalName.split("\\.")[0];
/*     */     
/* 658 */     val$mv.visitVarInsn(25, 0);
/* 659 */     Type[] args = Type.getArgumentTypes(desc);
/* 660 */     int argc = 1;
/* 661 */     for (Type t : args) {
/* 662 */       val$mv.visitVarInsn(25, 1);
/* 663 */       val$mv.push(argc + 1);
/* 664 */       val$mv.visitInsn(50);
/* 665 */       ByteCodeUtils.unbox(val$mv, t);
/* 666 */       argc++;
/*     */     }
/*     */     
/* 669 */     val$mv.visitMethodInsn(183, owner, "<init>", desc, false);
/*     */     
/* 672 */     val$mv.visitInsn(177);
/*     */   }
/*     */   
/*     */   void visitDefault()
/*     */   {
/* 677 */     writeMissingMessageWithHash(val$mv, this$0.visitedClassName);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.IncrementalSupportVisitor.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */