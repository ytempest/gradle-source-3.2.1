/*    */ package com.android.build.gradle.internal.ndk;
/*    */ 
/*    */ import com.android.build.gradle.internal.core.Abi;
/*    */ import com.google.gson.annotations.SerializedName;
/*    */ 
/*    */ public class AbiInfo
/*    */ {
/*    */   public Abi abi;
/*    */   public boolean deprecated;
/*    */   @SerializedName("default")
/*    */   public boolean defaultAbi;
/*    */   
/*    */   public AbiInfo()
/*    */   {
/* 34 */     abi = null;
/* 35 */     deprecated = false;
/* 36 */     defaultAbi = true;
/*    */   }
/*    */   
/*    */   public AbiInfo(Abi abi, boolean deprecated, boolean isDefault) {
/* 40 */     this.abi = abi;
/* 41 */     this.deprecated = deprecated;
/* 42 */     defaultAbi = isDefault;
/*    */   }
/*    */   
/*    */   public Abi getAbi()
/*    */   {
/* 47 */     return abi;
/*    */   }
/*    */   
/*    */   public boolean isDeprecated() {
/* 51 */     return deprecated;
/*    */   }
/*    */   
/*    */   public boolean isDefault() {
/* 55 */     return defaultAbi;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ndk.AbiInfo
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */