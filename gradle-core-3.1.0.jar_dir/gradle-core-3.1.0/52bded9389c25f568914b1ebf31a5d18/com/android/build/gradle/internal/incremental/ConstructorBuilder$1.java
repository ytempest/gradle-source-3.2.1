/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import org.objectweb.asm.Type;
/*     */ import org.objectweb.asm.tree.analysis.BasicInterpreter;
/*     */ import org.objectweb.asm.tree.analysis.BasicValue;
/*     */ 
/*     */ final class ConstructorBuilder$1
/*     */   extends BasicInterpreter
/*     */ {
/* 128 */   boolean done = false;
/*     */   
/*     */   public BasicValue newValue(Type type)
/*     */   {
/* 133 */     if (type == null)
/* 134 */       return BasicValue.UNINITIALIZED_VALUE;
/* 135 */     if (type.getSort() == 0) {
/* 136 */       return null;
/*     */     }
/*     */     
/* 140 */     BasicValue ret = done ? super.newValue(type) : new ConstructorBuilder.LocalValue(type);
/* 141 */     done = true;
/* 142 */     return ret;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.ConstructorBuilder.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */