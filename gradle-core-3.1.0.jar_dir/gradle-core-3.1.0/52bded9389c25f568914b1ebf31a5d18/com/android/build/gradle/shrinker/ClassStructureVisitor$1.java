/*    */ package com.android.build.gradle.shrinker;
/*    */ 
/*    */ import org.objectweb.asm.AnnotationVisitor;
/*    */ import org.objectweb.asm.MethodVisitor;
/*    */ import org.objectweb.asm.Type;
/*    */ 
/*    */ class ClassStructureVisitor$1
/*    */   extends MethodVisitor
/*    */ {
/* 64 */   ClassStructureVisitor$1(ClassStructureVisitor this$0, int x0, MethodVisitor x1, Object paramObject) { super(x0, x1); }
/*    */   
/*    */   public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
/* 67 */     ClassStructureVisitor.access$000(this$0).addAnnotation(val$method, Type.getType(desc).getInternalName());
/* 68 */     return super.visitAnnotation(desc, visible);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.ClassStructureVisitor.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */