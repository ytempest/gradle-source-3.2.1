/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.function.Function;
/*     */ import org.objectweb.asm.tree.ClassNode;
/*     */ 
/*     */ class AsmClassNode
/*     */   extends AsmAbstractNode
/*     */ {
/*     */   private final AsmClassNode parent;
/*     */   private final List<AsmInterfaceNode> implementedInterfaces;
/*     */   
/*     */   AsmClassNode(ClassNode classNode, AsmClassNode parent, List<AsmInterfaceNode> implementedInterfaces)
/*     */   {
/*  45 */     super(classNode);
/*  46 */     this.parent = parent;
/*  47 */     this.implementedInterfaces = implementedInterfaces;
/*     */   }
/*     */   
/*     */   <T> T onHierarchy(Function<ClassNode, T> function)
/*     */   {
/*  64 */     T value = function.apply(getClassNode());
/*  65 */     if (value != null) {
/*  66 */       return value;
/*     */     }
/*  68 */     if (parent != null) {
/*  69 */       return (T)parent.onHierarchy(function);
/*     */     }
/*     */     
/*  72 */     return null;
/*     */   }
/*     */   
/*     */   <T> T onParents(Function<ClassNode, T> function)
/*     */   {
/*  89 */     if (parent != null) {
/*  90 */       T value = function.apply(parent.getClassNode());
/*  91 */       if (value != null) {
/*  92 */         return value;
/*     */       }
/*  94 */       return (T)parent.onParents(function);
/*     */     }
/*  96 */     return null;
/*     */   }
/*     */   
/*     */   <T> T onAll(Function<ClassNode, T> function)
/*     */   {
/* 115 */     T value = function.apply(getClassNode());
/* 116 */     if (value != null) {
/* 117 */       return value;
/*     */     }
/* 119 */     for (AsmInterfaceNode implementedInterface : implementedInterfaces) {
/* 120 */       value = implementedInterface.onAll(function);
/* 121 */       if (value != null) {
/* 122 */         return value;
/*     */       }
/*     */     }
/* 125 */     if (parent != null) {
/* 126 */       return (T)parent.onAll(function);
/*     */     }
/*     */     
/* 129 */     return null;
/*     */   }
/*     */   
/*     */   public boolean hasParent()
/*     */   {
/* 134 */     return parent != null;
/*     */   }
/*     */   
/*     */   public AsmClassNode getParent()
/*     */   {
/* 140 */     if (parent == null)
/*     */     {
/* 142 */       throw new IllegalStateException(String.format("getParent() called on %s which has not parent", new Object[] {
/* 143 */         getClassNodename }));
/*     */     }
/* 145 */     return parent;
/*     */   }
/*     */   
/*     */   public List<AsmInterfaceNode> getInterfaces()
/*     */   {
/* 154 */     return implementedInterfaces;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.AsmClassNode
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */