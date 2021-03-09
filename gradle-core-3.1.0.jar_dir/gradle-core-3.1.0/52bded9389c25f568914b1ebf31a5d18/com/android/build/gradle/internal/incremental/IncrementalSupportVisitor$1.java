/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import com.android.utils.ILogger;
/*     */ import java.util.Map;
/*     */ import org.objectweb.asm.Type;
/*     */ import org.objectweb.asm.commons.GeneratorAdapter;
/*     */ import org.objectweb.asm.tree.ClassNode;
/*     */ import org.objectweb.asm.tree.MethodNode;
/*     */ 
/*     */ class IncrementalSupportVisitor$1
/*     */   extends StringSwitch
/*     */ {
/*     */   IncrementalSupportVisitor$1(IncrementalSupportVisitor this$0, GeneratorAdapter paramGeneratorAdapter, Map paramMap) {}
/*     */   
/*     */   void visitString()
/*     */   {
/* 526 */     val$mv.visitVarInsn(25, 1);
/*     */   }
/*     */   
/*     */   void visitCase(String methodName)
/*     */   {
/* 531 */     IncrementalSupportVisitor.MethodReference methodRef = (IncrementalSupportVisitor.MethodReference)val$uniqueMethods.get(methodName);
/*     */     
/* 533 */     val$mv.visitVarInsn(25, 0);
/*     */     
/* 535 */     Type[] args = Type.getArgumentTypes(method.desc);
/* 536 */     int argc = 0;
/* 537 */     for (Type t : args) {
/* 538 */       val$mv.visitVarInsn(25, 2);
/* 539 */       val$mv.push(argc);
/* 540 */       val$mv.visitInsn(50);
/* 541 */       ByteCodeUtils.unbox(val$mv, t);
/* 542 */       argc++;
/*     */     }
/*     */     
/* 545 */     if (IncrementalVisitor.TRACING_ENABLED) {
/* 546 */       IncrementalVisitor.trace(val$mv, "super selected ", owner.name, method.name, method.desc);
/*     */     }
/*     */     
/* 549 */     String parentName = this$0.findParentClassForMethod(methodRef);
/* 550 */     this$0.logger.verbose("Generating access$super for %1$s recev %2$s", new Object[] { method.name, parentName });
/*     */     
/* 557 */     val$mv.visitMethodInsn(183, parentName, method.name, method.desc, false);
/*     */     
/* 562 */     Type ret = Type.getReturnType(method.desc);
/* 563 */     if (ret.getSort() == 0) {
/* 564 */       val$mv.visitInsn(1);
/*     */     } else {
/* 566 */       val$mv.box(ret);
/*     */     }
/* 568 */     val$mv.visitInsn(176);
/*     */   }
/*     */   
/*     */   void visitDefault()
/*     */   {
/* 573 */     writeMissingMessageWithHash(val$mv, this$0.visitedClassName);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.IncrementalSupportVisitor.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */