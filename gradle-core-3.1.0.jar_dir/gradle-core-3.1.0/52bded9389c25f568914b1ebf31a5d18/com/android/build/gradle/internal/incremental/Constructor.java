/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.objectweb.asm.tree.AbstractInsnNode;
/*     */ import org.objectweb.asm.tree.MethodInsnNode;
/*     */ import org.objectweb.asm.tree.MethodNode;
/*     */ import org.objectweb.asm.tree.VarInsnNode;
/*     */ 
/*     */ class Constructor
/*     */ {
/*     */   public String owner;
/*     */   public final List<AbstractInsnNode> prelude;
/*     */   public final VarInsnNode loadThis;
/*     */   public final int lineForLoad;
/*     */   public final MethodNode args;
/*     */   public final MethodInsnNode delegation;
/*     */   public final MethodNode body;
/*     */   public final List<LocalVariable> variables;
/*     */   public final int localsAtLoadThis;
/*     */   
/*     */   Constructor(String owner, List<AbstractInsnNode> prelude, VarInsnNode loadThis, int lineForLoad, MethodNode args, MethodInsnNode delegation, MethodNode body, List<LocalVariable> variables, int localsAtLoadThis)
/*     */   {
/*  95 */     this.owner = owner;
/*  96 */     this.prelude = prelude;
/*  97 */     this.loadThis = loadThis;
/*  98 */     this.lineForLoad = lineForLoad;
/*  99 */     this.args = args;
/* 100 */     this.delegation = delegation;
/* 101 */     this.body = body;
/* 102 */     this.variables = variables;
/* 103 */     this.localsAtLoadThis = localsAtLoadThis;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.Constructor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */