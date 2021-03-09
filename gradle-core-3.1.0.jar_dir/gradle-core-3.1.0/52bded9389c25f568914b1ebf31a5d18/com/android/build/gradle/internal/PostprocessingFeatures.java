/*    */ package com.android.build.gradle.internal;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\036\n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\002\b\013\n\002\020\b\n\000\n\002\020\016\n\000\b\b\030\0002\0020\001B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003¢\006\002\020\006J\t\020\b\032\0020\003HÆ\003J\t\020\t\032\0020\003HÆ\003J\t\020\n\032\0020\003HÆ\003J'\020\013\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\0032\b\b\002\020\005\032\0020\003HÆ\001J\023\020\f\032\0020\0032\b\020\r\032\004\030\0010\001HÖ\003J\t\020\016\032\0020\017HÖ\001J\t\020\020\032\0020\021HÖ\001R\021\020\004\032\0020\003¢\006\b\n\000\032\004\b\004\020\007R\021\020\005\032\0020\003¢\006\b\n\000\032\004\b\005\020\007R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\002\020\007¨\006\022"}, d2={"Lcom/android/build/gradle/internal/PostprocessingFeatures;", "", "isRemoveUnusedCode", "", "isObfuscate", "isOptimize", "(ZZZ)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "gradle-core"})
/*    */ public final class PostprocessingFeatures
/*    */ {
/*    */   private final boolean isRemoveUnusedCode;
/*    */   private final boolean isObfuscate;
/*    */   private final boolean isOptimize;
/*    */   
/*    */   public PostprocessingFeatures(boolean isRemoveUnusedCode, boolean isObfuscate, boolean isOptimize)
/*    */   {
/* 20 */     this.isRemoveUnusedCode = isRemoveUnusedCode;this.isObfuscate = isObfuscate;this.isOptimize = isOptimize; }
/* 21 */   public final boolean isRemoveUnusedCode() { return isRemoveUnusedCode; }
/* 22 */   public final boolean isObfuscate() { return isObfuscate; }
/* 23 */   public final boolean isOptimize() { return isOptimize; }
/*    */   
/*    */   public final boolean component1()
/*    */   {
/*    */     return isRemoveUnusedCode;
/*    */   }
/*    */   
/*    */   public final boolean component2()
/*    */   {
/*    */     return isObfuscate;
/*    */   }
/*    */   
/*    */   public final boolean component3()
/*    */   {
/*    */     return isOptimize;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final PostprocessingFeatures copy(boolean isRemoveUnusedCode, boolean isObfuscate, boolean isOptimize)
/*    */   {
/*    */     return new PostprocessingFeatures(isRemoveUnusedCode, isObfuscate, isOptimize);
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/*    */     return "PostprocessingFeatures(isRemoveUnusedCode=" + isRemoveUnusedCode + ", isObfuscate=" + isObfuscate + ", isOptimize=" + isOptimize + ")";
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/*    */     boolean tmp4_1 = isRemoveUnusedCode;
/*    */     if (tmp4_1) {
/*    */       tmp4_1;
/*    */     }
/*    */     boolean tmp17_14 = isObfuscate;
/*    */     if (tmp17_14) {
/*    */       tmp17_14;
/*    */     }
/*    */     boolean tmp31_28 = isOptimize;
/*    */     if (tmp31_28) {
/*    */       tmp31_28;
/*    */     }
/*    */     return (1 * 31 + 1) * 31 + 1;
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject)
/*    */   {
/*    */     if (this != paramObject)
/*    */     {
/*    */       if ((paramObject instanceof PostprocessingFeatures))
/*    */       {
/*    */         PostprocessingFeatures localPostprocessingFeatures = (PostprocessingFeatures)paramObject;
/*    */         if ((isRemoveUnusedCode == isRemoveUnusedCode ? 1 : 0) != 0) {
/*    */           if ((isObfuscate == isObfuscate ? 1 : 0) != 0) {
/*    */             if ((isOptimize == isOptimize ? 1 : 0) == 0) {}
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     else {
/*    */       return true;
/*    */     }
/*    */     return false;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.PostprocessingFeatures
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */