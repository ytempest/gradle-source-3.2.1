/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import java.util.concurrent.atomic.AtomicReference;
/*     */ import org.objectweb.asm.MethodVisitor;
/*     */ import org.objectweb.asm.Type;
/*     */ 
/*     */ class IncrementalSupportVisitor$ISDefaultMethodVisitor
/*     */   extends IncrementalSupportVisitor.ISAbstractMethodVisitor
/*     */ {
/*     */   public IncrementalSupportVisitor$ISDefaultMethodVisitor(IncrementalSupportVisitor paramIncrementalSupportVisitor, MethodVisitor mv, int access, String name, String desc)
/*     */   {
/* 406 */     super(mv, access, name, desc);
/*     */   }
/*     */   
/*     */   protected void visitChangeField()
/*     */   {
/* 411 */     visitFieldInsn(178, this$0.visitedClassName, "$change", 
/*     */     
/* 415 */       IncrementalVisitor.getRuntimeTypeName(Type.getType(AtomicReference.class)));
/* 416 */     mv.visitMethodInsn(182, "java/util/concurrent/atomic/AtomicReference", "get", "()Ljava/lang/Object;", false);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.IncrementalSupportVisitor.ISDefaultMethodVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */