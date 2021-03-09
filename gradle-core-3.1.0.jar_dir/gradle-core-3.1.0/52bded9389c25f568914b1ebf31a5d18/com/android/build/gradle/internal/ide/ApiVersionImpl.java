/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.builder.model.ApiVersion;
/*    */ import com.android.sdklib.AndroidVersion;
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ 
/*    */ final class ApiVersionImpl
/*    */   implements ApiVersion, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final int mApiLevel;
/*    */   private final String mCodename;
/*    */   
/*    */   public static ApiVersion clone(ApiVersion apiVersion)
/*    */   {
/* 41 */     if (apiVersion == null) {
/* 42 */       return null;
/*    */     }
/*    */     
/* 45 */     return new ApiVersionImpl(apiVersion);
/*    */   }
/*    */   
/*    */   public static ApiVersion clone(AndroidVersion androidVersion) {
/* 49 */     return new ApiVersionImpl(androidVersion.getApiLevel(), androidVersion.getCodename());
/*    */   }
/*    */   
/*    */   private ApiVersionImpl(ApiVersion apiVersion) {
/* 53 */     this(apiVersion.getApiLevel(), apiVersion.getCodename());
/*    */   }
/*    */   
/*    */   private ApiVersionImpl(int apiLevel, String codename) {
/* 57 */     mApiLevel = apiLevel;
/* 58 */     mCodename = codename;
/*    */   }
/*    */   
/*    */   public int getApiLevel()
/*    */   {
/* 63 */     return mApiLevel;
/*    */   }
/*    */   
/*    */   public String getCodename()
/*    */   {
/* 69 */     return mCodename;
/*    */   }
/*    */   
/*    */   public String getApiString()
/*    */   {
/* 75 */     return mCodename != null ? mCodename : Integer.toString(mApiLevel);
/*    */   }
/*    */   
/*    */   public boolean equals(Object o)
/*    */   {
/* 80 */     if (this == o) {
/* 81 */       return true;
/*    */     }
/* 83 */     if ((o == null) || (getClass() != o.getClass())) {
/* 84 */       return false;
/*    */     }
/* 86 */     ApiVersionImpl that = (ApiVersionImpl)o;
/* 87 */     return (mApiLevel == mApiLevel) && 
/* 88 */       (Objects.equals(mCodename, mCodename));
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 93 */     return Objects.hash(new Object[] { Integer.valueOf(mApiLevel), mCodename });
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.ApiVersionImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */