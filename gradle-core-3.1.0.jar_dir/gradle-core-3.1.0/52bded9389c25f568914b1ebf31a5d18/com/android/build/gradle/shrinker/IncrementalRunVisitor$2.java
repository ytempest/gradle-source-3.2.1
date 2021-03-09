/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import java.util.Set;
/*     */ import org.objectweb.asm.AnnotationVisitor;
/*     */ import org.objectweb.asm.MethodVisitor;
/*     */ 
/*     */ class IncrementalRunVisitor$2
/*     */   extends MethodVisitor
/*     */ {
/* 170 */   IncrementalRunVisitor$2(IncrementalRunVisitor this$0, int x0, MethodVisitor x1, Set paramSet, String paramString) { super(x0, x1); }
/*     */   
/*     */   public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
/* 173 */     IncrementalRunVisitor.access$100(desc, val$memberAnnotations, IncrementalRunVisitor.access$000(this$0) + "." + val$name);
/* 174 */     return super.visitAnnotation(desc, visible);
/*     */   }
/*     */   
/*     */   public void visitEnd()
/*     */   {
/* 179 */     IncrementalRunVisitor.access$200(val$memberAnnotations, IncrementalRunVisitor.access$000(this$0) + "." + val$name);
/* 180 */     super.visitEnd();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.IncrementalRunVisitor.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */