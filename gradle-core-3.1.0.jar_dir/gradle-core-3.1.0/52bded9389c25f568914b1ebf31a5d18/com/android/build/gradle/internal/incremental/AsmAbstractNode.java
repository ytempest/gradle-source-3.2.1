/*    */ package com.android.build.gradle.internal.incremental;
/*    */ 
/*    */ import org.objectweb.asm.tree.ClassNode;
/*    */ 
/*    */ class AsmAbstractNode
/*    */ {
/*    */   private final ClassNode classNode;
/*    */   
/*    */   protected AsmAbstractNode(ClassNode classNode)
/*    */   {
/* 27 */     this.classNode = classNode;
/*    */   }
/*    */   
/*    */   public ClassNode getClassNode()
/*    */   {
/* 32 */     return classNode;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.AsmAbstractNode
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */