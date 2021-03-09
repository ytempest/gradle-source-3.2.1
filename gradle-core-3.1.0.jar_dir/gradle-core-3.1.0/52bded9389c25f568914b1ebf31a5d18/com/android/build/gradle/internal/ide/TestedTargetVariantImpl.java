/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.builder.model.TestedTargetVariant;
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ 
/*    */ public final class TestedTargetVariantImpl
/*    */   implements TestedTargetVariant, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final String mTargetProjectPath;
/*    */   private final String mTargetVariant;
/*    */   
/*    */   public TestedTargetVariantImpl(String targetProjectPath, String targetVariant)
/*    */   {
/* 41 */     mTargetProjectPath = targetProjectPath;
/* 42 */     mTargetVariant = targetVariant;
/*    */   }
/*    */   
/*    */   public String getTargetProjectPath()
/*    */   {
/* 48 */     return mTargetProjectPath;
/*    */   }
/*    */   
/*    */   public String getTargetVariant()
/*    */   {
/* 54 */     return mTargetVariant;
/*    */   }
/*    */   
/*    */   public boolean equals(Object o)
/*    */   {
/* 59 */     if (this == o) {
/* 60 */       return true;
/*    */     }
/* 62 */     if ((o == null) || (getClass() != o.getClass())) {
/* 63 */       return false;
/*    */     }
/* 65 */     TestedTargetVariantImpl that = (TestedTargetVariantImpl)o;
/* 66 */     return (Objects.equals(mTargetProjectPath, mTargetProjectPath)) && 
/* 67 */       (Objects.equals(mTargetVariant, mTargetVariant));
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 72 */     return Objects.hash(new Object[] { mTargetProjectPath, mTargetVariant });
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 77 */     return 
/*    */     
/* 80 */       MoreObjects.toStringHelper(this).add("mTargetProjectPath", mTargetProjectPath).add("mTargetVariant", mTargetVariant).toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.TestedTargetVariantImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */