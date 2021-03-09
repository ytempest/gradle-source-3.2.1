/*     */ package com.android.build.gradle.internal.publishing;
/*     */ 
/*     */ public enum AndroidArtifacts$ArtifactType
/*     */ {
/* 138 */   CLASSES("android-classes"), 
/* 139 */   SHARED_CLASSES("android-shared-classes"), 
/*     */   
/* 141 */   JAR("jar"), 
/*     */   
/* 143 */   DEX("android-dex", "dex"), 
/*     */   
/* 146 */   MANIFEST("android-manifest"), 
/* 147 */   MANIFEST_METADATA("android-manifest-metadata"), 
/*     */   
/* 151 */   RES_STATIC_LIBRARY("android-res-static-library"), 
/* 152 */   RES_SHARED_STATIC_LIBRARY("android-res-shared-static-library"), 
/* 153 */   RES_BUNDLE("android-res-for-bundle", "res"), 
/*     */   
/* 156 */   AIDL("android-aidl"), 
/* 157 */   RENDERSCRIPT("android-renderscript"), 
/* 158 */   DATA_BINDING_ARTIFACT("android-databinding"), 
/* 159 */   DATA_BINDING_BASE_CLASS_LOG_ARTIFACT("android-databinding-class-log"), 
/* 160 */   COMPILE_ONLY_NAMESPACED_R_CLASS_JAR("android-res-namespaced-r-class-jar"), 
/*     */   
/* 163 */   JAVA_RES("android-java-res", "root"), 
/* 164 */   SHARED_JAVA_RES("android-shared-java-res"), 
/* 165 */   ANDROID_RES("android-res"), 
/* 166 */   ASSETS("android-assets", "assets"), 
/* 167 */   SHARED_ASSETS("android-shared-assets"), 
/* 168 */   SYMBOL_LIST("android-symbol"), 
/*     */   
/* 174 */   SYMBOL_LIST_WITH_PACKAGE_NAME("android-symbol-with-package-name"), 
/* 175 */   JNI("android-jni", "lib"), 
/* 176 */   SHARED_JNI("android-shared-jni"), 
/* 177 */   ANNOTATIONS("android-ext-annot"), 
/* 178 */   PUBLIC_RES("android-public-res"), 
/* 179 */   PROGUARD_RULES("android-proguad"), 
/*     */   
/* 181 */   LINT("android-lint"), 
/*     */   
/* 183 */   APK_MAPPING("android-mapping"), 
/* 184 */   APK_METADATA("android-metadata"), 
/* 185 */   APK("apk"), 
/*     */   
/* 188 */   FEATURE_IDS_DECLARATION("android-feature-split-ids"), 
/* 189 */   FEATURE_APPLICATION_ID_DECLARATION("android-feature-application-id"), 
/* 190 */   FEATURE_RESOURCE_PKG("android-feature-res-ap_"), 
/* 191 */   FEATURE_TRANSITIVE_DEPS("android-feature-transitive-deps"), 
/*     */   
/* 194 */   METADATA_FEATURE_DECLARATION("android-metadata-feature-decl"), 
/* 195 */   METADATA_FEATURE_MANIFEST("android-metadata-feature-manifest"), 
/* 196 */   METADATA_APP_ID_DECLARATION("android-metadata-app-id-decl"), 
/*     */   
/* 199 */   AAR("aar"), 
/* 200 */   EXPLODED_AAR("android-exploded-aar");
/*     */   
/*     */   private final String type;
/*     */   private final String pathPrefix;
/*     */   
/*     */   private AndroidArtifacts$ArtifactType(String type)
/*     */   {
/* 207 */     this(type, null);
/*     */   }
/*     */   
/*     */   private AndroidArtifacts$ArtifactType(String type, String pathPrefix) {
/* 211 */     this.type = type;
/* 212 */     this.pathPrefix = pathPrefix;
/*     */   }
/*     */   
/*     */   public String getType()
/*     */   {
/* 217 */     return type;
/*     */   }
/*     */   
/*     */   public String getPathPrefix()
/*     */   {
/* 222 */     return pathPrefix;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */