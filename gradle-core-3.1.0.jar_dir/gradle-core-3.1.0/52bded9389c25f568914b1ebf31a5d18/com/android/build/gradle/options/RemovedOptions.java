/*    */ package com.android.build.gradle.options;
/*    */ 
/*    */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*    */ 
/*    */ public enum RemovedOptions
/*    */   implements Option<String>
/*    */ {
/* 29 */   INCREMENTAL_JAVA_COMPILE("android.incrementalJavaCompile", "The android.incrementalJavaCompile property has been replaced by a DSL property. Please add the following to your build.gradle instead:\nandroid {\n  compileOptions.incremental = false\n}"), 
/*    */   
/* 36 */   THREAD_POOL_SIZE_OLD("com.android.build.threadPoolSize", "The com.android.build.threadPoolSize property has no effect"), 
/*    */   
/* 39 */   THREAD_POOL_SIZE("android.threadPoolSize", "The android.threadPoolSize property has no effect"), 
/* 40 */   ENABLE_IMPROVED_DEPENDENCY_RESOLUTION("android.enableImprovedDependenciesResolution", "The android.enableImprovedDependenciesResolution property does not have any effect. Dependency resolution is only performed during task execution phase."), 
/*    */   
/* 45 */   ENABLE_NEW_RESOURCE_PROCESSING("android.enableNewResourceProcessing", "New resource processing is now always enabled."), 
/*    */   
/* 48 */   DISABLE_RES_MERGE_IN_LIBRARY("android.disable.res.merge", "Resources from dependencies are never merged in libraries."), 
/*    */   
/* 51 */   ENABLE_IN_PROCESS_AAPT2("android.enableAapt2jni", "AAPT2 JNI has been removed."), 
/* 52 */   ENABLE_DAEMON_MODE_AAPT2("android.enableAapt2DaemonMode", "AAPT2 daemon mode is now always enabled.");
/*    */   
/*    */   private final String propertyName;
/*    */   private final String errorMessage;
/*    */   
/*    */   private RemovedOptions(String propertyName, String errorMessage)
/*    */   {
/* 60 */     this.propertyName = propertyName;
/* 61 */     this.errorMessage = errorMessage;
/*    */   }
/*    */   
/*    */   public String getPropertyName()
/*    */   {
/* 67 */     return propertyName;
/*    */   }
/*    */   
/*    */   public String getDefaultValue()
/*    */   {
/* 73 */     return null;
/*    */   }
/*    */   
/*    */   public String parse(Object value)
/*    */   {
/* 79 */     return errorMessage;
/*    */   }
/*    */   
/*    */   public boolean isDeprecated()
/*    */   {
/* 86 */     return false;
/*    */   }
/*    */   
/*    */   public DeprecationReporter.DeprecationTarget getDeprecationTarget()
/*    */   {
/* 93 */     return null;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.options.RemovedOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */