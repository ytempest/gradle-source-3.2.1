/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import java.util.Set;
/*     */ import org.objectweb.asm.AnnotationVisitor;
/*     */ import org.objectweb.asm.FieldVisitor;
/*     */ 
/*     */ class IncrementalRunVisitor$1
/*     */   extends FieldVisitor
/*     */ {
/* 138 */   IncrementalRunVisitor$1(IncrementalRunVisitor this$0, int x0, FieldVisitor x1, Set paramSet, String paramString) { super(x0, x1); }
/*     */   
/*     */   public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
/* 141 */     IncrementalRunVisitor.access$100(desc, val$memberAnnotations, IncrementalRunVisitor.access$000(this$0) + "." + val$name);
/* 142 */     return super.visitAnnotation(desc, visible);
/*     */   }
/*     */   
/*     */   public void visitEnd()
/*     */   {
/* 147 */     IncrementalRunVisitor.access$200(val$memberAnnotations, IncrementalRunVisitor.access$000(this$0) + "." + val$name);
/* 148 */     super.visitEnd();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.IncrementalRunVisitor.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */