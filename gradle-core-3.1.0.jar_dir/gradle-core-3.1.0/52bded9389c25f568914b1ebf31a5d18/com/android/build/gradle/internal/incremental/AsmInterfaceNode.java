/*    */ package com.android.build.gradle.internal.incremental;
/*    */ 
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import com.google.common.collect.UnmodifiableIterator;
/*    */ import java.util.Iterator;
/*    */ import java.util.function.Function;
/*    */ import org.objectweb.asm.tree.ClassNode;
/*    */ 
/*    */ class AsmInterfaceNode
/*    */   extends AsmAbstractNode
/*    */ {
/*    */   private final ImmutableList<AsmInterfaceNode> superInterfaces;
/*    */   
/*    */   AsmInterfaceNode(ClassNode classNode, ImmutableList<AsmInterfaceNode> superInterfaces)
/*    */   {
/* 42 */     super(classNode);
/* 43 */     this.superInterfaces = superInterfaces;
/*    */   }
/*    */   
/*    */   <T> T onAll(Function<ClassNode, T> function)
/*    */   {
/* 60 */     T value = function.apply(getClassNode());
/* 61 */     if (value != null) {
/* 62 */       return value;
/*    */     }
/* 64 */     for (UnmodifiableIterator localUnmodifiableIterator = superInterfaces.iterator(); localUnmodifiableIterator.hasNext();) { AsmInterfaceNode extendedInterface = (AsmInterfaceNode)localUnmodifiableIterator.next();
/* 65 */       value = extendedInterface.onAll(function);
/* 66 */       if (value != null) {
/* 67 */         return value;
/*    */       }
/*    */     }
/* 70 */     return null;
/*    */   }
/*    */   
/*    */   Iterable<AsmInterfaceNode> getSuperInterfaces() {
/* 74 */     return superInterfaces;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.AsmInterfaceNode
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */