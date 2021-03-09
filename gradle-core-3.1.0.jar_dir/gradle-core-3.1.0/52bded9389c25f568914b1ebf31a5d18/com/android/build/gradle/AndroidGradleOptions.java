/*    */ package com.android.build.gradle;
/*    */ 
/*    */ import org.gradle.api.Project;
/*    */ 
/*    */ @Deprecated
/*    */ public class AndroidGradleOptions
/*    */ {
/*    */   public static final String PROPERTY_KEEP_TIMESTAMPS_IN_APK = "android.keepTimestampsInApk";
/*    */   
/*    */   public static boolean keepTimestampsInApk(Project project)
/*    */   {
/* 33 */     return getBoolean(project, "android.keepTimestampsInApk");
/*    */   }
/*    */   
/*    */   private static boolean getBoolean(Project project, String propertyName)
/*    */   {
/* 39 */     if (project.hasProperty(propertyName)) {
/* 40 */       Object value = project.property(propertyName);
/* 41 */       if ((value instanceof String))
/* 42 */         return Boolean.parseBoolean((String)value);
/* 43 */       if ((value instanceof Boolean)) {
/* 44 */         return ((Boolean)value).booleanValue();
/*    */       }
/*    */     }
/*    */     
/* 48 */     return false;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.AndroidGradleOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */