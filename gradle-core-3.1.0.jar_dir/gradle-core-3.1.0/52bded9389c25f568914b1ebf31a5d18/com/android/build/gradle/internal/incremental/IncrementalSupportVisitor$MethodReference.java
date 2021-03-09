/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import org.objectweb.asm.tree.ClassNode;
/*     */ import org.objectweb.asm.tree.MethodNode;
/*     */ 
/*     */ class IncrementalSupportVisitor$MethodReference
/*     */ {
/*     */   final MethodNode method;
/*     */   final ClassNode owner;
/*     */   
/*     */   private IncrementalSupportVisitor$MethodReference(MethodNode method, ClassNode owner)
/*     */   {
/* 446 */     this.method = method;
/* 447 */     this.owner = owner;
/*     */   }
/*     */   
/*     */   private String getDefautlDispatchName() {
/* 451 */     return getDefaultDispatchName(method);
/*     */   }
/*     */   
/*     */   private static String getDefaultDispatchName(MethodNode method) {
/* 455 */     return name + "." + desc;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.IncrementalSupportVisitor.MethodReference
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */