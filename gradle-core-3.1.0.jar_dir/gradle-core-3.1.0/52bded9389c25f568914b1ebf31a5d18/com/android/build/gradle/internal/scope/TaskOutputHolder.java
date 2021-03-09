/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import java.io.File;
/*     */ import org.gradle.api.file.ConfigurableFileCollection;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ 
/*     */ public abstract interface TaskOutputHolder
/*     */ {
/*     */   public abstract FileCollection getOutput(OutputType paramOutputType)
/*     */     throws MissingTaskOutputException;
/*     */   
/*     */   public abstract boolean hasOutput(OutputType paramOutputType);
/*     */   
/*     */   public abstract ConfigurableFileCollection addTaskOutput(TaskOutputType paramTaskOutputType, Object paramObject, String paramString)
/*     */     throws TaskOutputAlreadyRegisteredException;
/*     */   
/*     */   public abstract ConfigurableFileCollection createAnchorOutput(AnchorOutputType paramAnchorOutputType)
/*     */     throws TaskOutputAlreadyRegisteredException;
/*     */   
/*     */   public abstract void addToAnchorOutput(AnchorOutputType paramAnchorOutputType, File paramFile, String paramString);
/*     */   
/*     */   public abstract void addToAnchorOutput(AnchorOutputType paramAnchorOutputType, FileCollection paramFileCollection);
/*     */   
/*     */   public static abstract interface OutputType
/*     */   {
/*     */     public abstract String name();
/*     */   }
/*     */   
/*     */   public static enum TaskOutputType
/*     */     implements TaskOutputHolder.OutputType
/*     */   {
/*  43 */     JAVAC, 
/*     */     
/*  50 */     LIBRARY_CLASSES, 
/*     */     
/*  53 */     APP_CLASSES, 
/*     */     
/*  56 */     FEATURE_CLASSES, 
/*     */     
/*  60 */     JAVA_RES, 
/*     */     
/*  62 */     LIBRARY_JAVA_RES, 
/*     */     
/*  65 */     FULL_JAR, 
/*     */     
/*  69 */     PLATFORM_R_TXT, 
/*     */     
/*  71 */     MERGED_RES, 
/*     */     
/*  73 */     NOT_NAMESPACED_R_CLASS_SOURCES, 
/*     */     
/*  76 */     COMPILE_ONLY_NOT_NAMESPACED_R_CLASS_JAR, 
/*     */     
/*  78 */     MERGED_NOT_COMPILED_RES, 
/*     */     
/*  80 */     UNIT_TEST_CONFIG_DIRECTORY, 
/*     */     
/*  82 */     PROCESSED_RES, 
/*     */     
/*  84 */     PACKAGED_RES, 
/*     */     
/*  86 */     SYMBOL_LIST, 
/*     */     
/*  88 */     SYMBOL_LIST_WITH_PACKAGE_NAME, 
/*     */     
/*  90 */     PUBLIC_RES, 
/*  91 */     SHRUNK_PROCESSED_RES, 
/*  92 */     DENSITY_OR_LANGUAGE_SPLIT_PROCESSED_RES, 
/*  93 */     ABI_PROCESSED_SPLIT_RES, 
/*  94 */     DENSITY_OR_LANGUAGE_PACKAGED_SPLIT, 
/*  95 */     INSTANT_RUN_MAIN_APK_RESOURCES, 
/*  96 */     INSTANT_RUN_PACKAGED_RESOURCES, 
/*     */     
/*  98 */     LINKED_RES_FOR_BUNDLE, 
/*     */     
/* 103 */     PUBLISHED_DEX, 
/* 104 */     PUBLISHED_JAVA_RES, 
/* 105 */     PUBLISHED_NATIVE_LIBS, 
/*     */     
/* 109 */     RES_COMPILED_FLAT_FILES, 
/*     */     
/* 111 */     RES_STATIC_LIBRARY, 
/*     */     
/* 113 */     COMPILE_ONLY_NAMESPACED_R_CLASS_JAR, 
/*     */     
/* 115 */     NAMESPACED_SYMBOL_LIST_WITH_PACKAGE_NAME, 
/*     */     
/* 117 */     RUNTIME_R_CLASS_SOURCES, 
/*     */     
/* 119 */     RUNTIME_R_CLASS_CLASSES, 
/*     */     
/* 123 */     LIBRARY_JNI, 
/*     */     
/* 125 */     LIBRARY_AND_LOCAL_JARS_JNI, 
/*     */     
/* 128 */     SHADER_ASSETS, 
/*     */     
/* 130 */     LIBRARY_ASSETS, 
/* 131 */     MERGED_ASSETS, 
/* 132 */     MOCKABLE_JAR, 
/*     */     
/* 135 */     AIDL_PARCELABLE, 
/*     */     
/* 137 */     RENDERSCRIPT_HEADERS, 
/*     */     
/* 139 */     COMPATIBLE_SCREEN_MANIFEST, 
/* 140 */     MERGED_MANIFESTS, 
/* 141 */     LIBRARY_MANIFEST, 
/* 142 */     AAPT_FRIENDLY_MERGED_MANIFESTS, 
/* 143 */     INSTANT_RUN_MERGED_MANIFESTS, 
/* 144 */     MANIFEST_METADATA, 
/* 145 */     MANIFEST_MERGE_REPORT, 
/*     */     
/* 148 */     ANNOTATION_PROCESSOR_LIST, 
/*     */     
/* 151 */     CONSUMER_PROGUARD_FILE, 
/*     */     
/* 154 */     DATA_BINDING_ARTIFACT, 
/*     */     
/* 156 */     DATA_BINDING_DEPENDENCY_ARTIFACTS, 
/*     */     
/* 158 */     DATA_BINDING_BASE_CLASS_LOGS_DEPENDENCY_ARTIFACTS, 
/*     */     
/* 161 */     DATA_BINDING_BASE_CLASS_LOG_ARTIFACT, 
/*     */     
/* 163 */     DATA_BINDING_BASE_CLASS_SOURCE_OUT, 
/*     */     
/* 165 */     LINT_JAR, 
/*     */     
/* 168 */     ANNOTATIONS_ZIP, 
/*     */     
/* 170 */     ANNOTATIONS_TYPEDEF_FILE, 
/*     */     
/* 172 */     ANNOTATIONS_PROGUARD, 
/*     */     
/* 174 */     AAR_MAIN_JAR, 
/*     */     
/* 176 */     AAR_LIBS_DIRECTORY, 
/*     */     
/* 178 */     ABI_PACKAGED_SPLIT, 
/* 179 */     FULL_APK, 
/* 180 */     APK, 
/* 181 */     APK_MAPPING, 
/* 182 */     AAR, 
/* 183 */     INSTANTAPP_BUNDLE, 
/* 184 */     SPLIT_LIST, 
/* 185 */     APK_LIST, 
/*     */     
/* 187 */     FEATURE_IDS_DECLARATION, 
/* 188 */     FEATURE_APPLICATION_ID_DECLARATION, 
/* 189 */     FEATURE_RESOURCE_PKG, 
/* 190 */     FEATURE_TRANSITIVE_DEPS, 
/*     */     
/* 193 */     METADATA_FEATURE_DECLARATION, 
/* 194 */     METADADA_FEATURE_MANIFEST, 
/* 195 */     METADATA_APP_ID_DECLARATION;
/*     */     
/*     */     private TaskOutputType() {}
/*     */   }
/*     */   
/*     */   public static enum AnchorOutputType
/*     */     implements TaskOutputHolder.OutputType
/*     */   {
/* 210 */     GENERATED_RES, 
/* 211 */     GENERATED_SRC, 
/*     */     
/* 213 */     ALL_CLASSES;
/*     */     
/*     */     private AnchorOutputType() {}
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.TaskOutputHolder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */