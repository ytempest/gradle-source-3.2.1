/*    */ package com.android.build.gradle.internal.incremental;
/*    */ 
/*    */ import org.objectweb.asm.Type;
/*    */ 
/*    */ class LocalVariable
/*    */ {
/*    */   public final Type type;
/*    */   public final int var;
/*    */   
/*    */   LocalVariable(Type type, int var)
/*    */   {
/* 33 */     this.type = type;
/* 34 */     this.var = var;
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj)
/*    */   {
/* 40 */     return ((obj instanceof LocalVariable)) && (var == var);
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 45 */     return var;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.LocalVariable
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */