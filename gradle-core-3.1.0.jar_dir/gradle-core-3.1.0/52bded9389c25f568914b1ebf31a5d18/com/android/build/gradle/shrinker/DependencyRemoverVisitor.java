/*    */ package com.android.build.gradle.shrinker;
/*    */ 
/*    */ import org.objectweb.asm.ClassVisitor;
/*    */ import org.objectweb.asm.MethodVisitor;
/*    */ 
/*    */ public class DependencyRemoverVisitor<T>
/*    */   extends ClassVisitor
/*    */ {
/*    */   private final ShrinkerGraph<T> mGraph;
/*    */   private String mClassName;
/*    */   
/*    */   public DependencyRemoverVisitor(ShrinkerGraph<T> graph, ClassVisitor cv)
/*    */   {
/* 34 */     super(327680, cv);
/* 35 */     mGraph = graph;
/*    */   }
/*    */   
/*    */   public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
/*    */   {
/* 46 */     mClassName = name;
/* 47 */     super.visit(version, access, name, signature, superName, interfaces);
/*    */   }
/*    */   
/*    */   public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
/*    */   {
/* 53 */     mGraph.removeAllCodeDependencies(mGraph.getMemberReference(mClassName, name, desc));
/* 54 */     return super.visitMethod(access, name, desc, signature, exceptions);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.DependencyRemoverVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */