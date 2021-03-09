/*    */ package com.android.build.gradle.internal.core;
/*    */ 
/*    */ import com.android.build.gradle.api.JavaCompileOptions;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class MergedJavaCompileOptions
/*    */   implements JavaCompileOptions
/*    */ {
/* 26 */   private com.android.build.gradle.internal.dsl.AnnotationProcessorOptions annotationProcessorOptions = new com.android.build.gradle.internal.dsl.AnnotationProcessorOptions();
/*    */   
/*    */   public com.android.build.gradle.api.AnnotationProcessorOptions getAnnotationProcessorOptions()
/*    */   {
/* 33 */     return annotationProcessorOptions;
/*    */   }
/*    */   
/*    */   public void reset() {
/* 37 */     annotationProcessorOptions.getClassNames().clear();
/* 38 */     annotationProcessorOptions.getArguments().clear();
/*    */   }
/*    */   
/*    */   public void append(JavaCompileOptions javaCompileOptions) {
/* 42 */     annotationProcessorOptions.classNames(javaCompileOptions
/* 43 */       .getAnnotationProcessorOptions().getClassNames());
/* 44 */     annotationProcessorOptions.arguments(javaCompileOptions
/* 45 */       .getAnnotationProcessorOptions().getArguments());
/* 46 */     if (javaCompileOptions.getAnnotationProcessorOptions().getIncludeCompileClasspath() != null) {
/* 47 */       annotationProcessorOptions.setIncludeCompileClasspath(javaCompileOptions
/* 48 */         .getAnnotationProcessorOptions().getIncludeCompileClasspath());
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.core.MergedJavaCompileOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */