/*    */ package com.android.build.gradle.shrinker;
/*    */ 
/*    */ import org.objectweb.asm.AnnotationVisitor;
/*    */ import org.objectweb.asm.FieldVisitor;
/*    */ import org.objectweb.asm.Type;
/*    */ 
/*    */ class ClassStructureVisitor$2
/*    */   extends FieldVisitor
/*    */ {
/* 79 */   ClassStructureVisitor$2(ClassStructureVisitor this$0, int x0, FieldVisitor x1, Object paramObject) { super(x0, x1); }
/*    */   
/*    */   public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
/* 82 */     ClassStructureVisitor.access$000(this$0).addAnnotation(val$field, Type.getType(desc).getInternalName());
/* 83 */     return super.visitAnnotation(desc, visible);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.ClassStructureVisitor.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */