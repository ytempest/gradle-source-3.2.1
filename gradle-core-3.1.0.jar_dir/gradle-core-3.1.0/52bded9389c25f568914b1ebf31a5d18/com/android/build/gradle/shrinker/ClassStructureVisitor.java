/*    */ package com.android.build.gradle.shrinker;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.objectweb.asm.AnnotationVisitor;
/*    */ import org.objectweb.asm.ClassVisitor;
/*    */ import org.objectweb.asm.FieldVisitor;
/*    */ import org.objectweb.asm.MethodVisitor;
/*    */ import org.objectweb.asm.Type;
/*    */ 
/*    */ public class ClassStructureVisitor<T>
/*    */   extends ClassVisitor
/*    */ {
/*    */   private final File mClassFile;
/*    */   private final ShrinkerGraph<T> mGraph;
/*    */   private T mClass;
/*    */   
/*    */   public ClassStructureVisitor(ShrinkerGraph<T> graph, File classFile, ClassVisitor cv)
/*    */   {
/* 41 */     super(327680, cv);
/* 42 */     mClassFile = classFile;
/* 43 */     mGraph = graph;
/*    */   }
/*    */   
/*    */   public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
/*    */   {
/* 54 */     mClass = mGraph.addClass(name, superName, interfaces, access, mClassFile);
/* 55 */     super.visit(version, access, name, signature, superName, interfaces);
/*    */   }
/*    */   
/*    */   public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
/*    */   {
/* 61 */     final T method = mGraph.addMember(mClass, name, desc, access);
/*    */     
/* 63 */     MethodVisitor superVisitor = super.visitMethod(access, name, desc, signature, exceptions);
/* 64 */     new MethodVisitor(327680, superVisitor)
/*    */     {
/*    */       public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
/* 67 */         mGraph.addAnnotation(method, Type.getType(desc).getInternalName());
/* 68 */         return super.visitAnnotation(desc, visible);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public FieldVisitor visitField(int access, String name, String desc, String signature, Object value)
/*    */   {
/* 76 */     final T field = mGraph.addMember(mClass, name, desc, access);
/*    */     
/* 78 */     FieldVisitor superVisitor = super.visitField(access, name, desc, signature, value);
/* 79 */     new FieldVisitor(327680, superVisitor)
/*    */     {
/*    */       public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
/* 82 */         mGraph.addAnnotation(field, Type.getType(desc).getInternalName());
/* 83 */         return super.visitAnnotation(desc, visible);
/*    */       }
/*    */     };
/*    */   }
/*    */   
/*    */   public AnnotationVisitor visitAnnotation(String desc, boolean visible)
/*    */   {
/* 90 */     mGraph.addAnnotation(mClass, Type.getType(desc).getInternalName());
/* 91 */     return super.visitAnnotation(desc, visible);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.ClassStructureVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */