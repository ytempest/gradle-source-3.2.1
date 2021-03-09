/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import org.gradle.api.DefaultTask;
/*    */ import org.gradle.api.tasks.Internal;
/*    */ 
/*    */ public abstract class AndroidVariantTask
/*    */   extends DefaultTask
/*    */ {
/*    */   private String variantName;
/*    */   
/*    */   @Internal("No influence on output, this is for our build stats reporting mechanism")
/*    */   public String getVariantName()
/*    */   {
/* 32 */     return variantName;
/*    */   }
/*    */   
/*    */   public void setVariantName(String variantName) {
/* 36 */     this.variantName = variantName;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.AndroidVariantTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */