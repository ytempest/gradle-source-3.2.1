/*     */ package com.android.build.gradle.internal.publishing;
/*     */ 
/*     */ import org.gradle.api.attributes.Attribute;
/*     */ 
/*     */ public class AndroidArtifacts
/*     */ {
/*  37 */   public static final Attribute<String> ARTIFACT_TYPE = Attribute.of("artifactType", String.class);
/*     */   
/*     */   public static final String TYPE_AAR = "aar";
/*     */   
/*     */   private static final String TYPE_APK = "apk";
/*     */   
/*     */   private static final String TYPE_JAR = "jar";
/*     */   
/*     */   private static final String TYPE_CLASSES = "android-classes";
/*     */   
/*     */   private static final String TYPE_SHARED_CLASSES = "android-shared-classes";
/*     */   
/*     */   private static final String TYPE_DEX = "android-dex";
/*     */   
/*     */   private static final String TYPE_JAVA_RES = "android-java-res";
/*     */   
/*     */   private static final String TYPE_SHARED_JAVA_RES = "android-shared-java-res";
/*     */   
/*     */   private static final String TYPE_MANIFEST = "android-manifest";
/*     */   
/*     */   private static final String TYPE_MANIFEST_METADATA = "android-manifest-metadata";
/*     */   
/*     */   private static final String TYPE_ANDROID_RES = "android-res";
/*     */   
/*     */   private static final String TYPE_ANDROID_NAMESPACED_R_CLASS_JAR = "android-res-namespaced-r-class-jar";
/*     */   
/*     */   private static final String TYPE_ANDROID_RES_STATIC_LIBRARY = "android-res-static-library";
/*     */   private static final String TYPE_ANDROID_RES_SHARED_STATIC_LIBRARY = "android-res-shared-static-library";
/*     */   private static final String TYPE_ANDROID_RES_BUNDLE = "android-res-for-bundle";
/*     */   private static final String TYPE_ASSETS = "android-assets";
/*     */   private static final String TYPE_SHARED_ASSETS = "android-shared-assets";
/*     */   private static final String TYPE_JNI = "android-jni";
/*     */   private static final String TYPE_SHARED_JNI = "android-shared-jni";
/*     */   private static final String TYPE_AIDL = "android-aidl";
/*     */   private static final String TYPE_RENDERSCRIPT = "android-renderscript";
/*     */   private static final String TYPE_LINT_JAR = "android-lint";
/*     */   private static final String TYPE_EXT_ANNOTATIONS = "android-ext-annot";
/*     */   private static final String TYPE_PUBLIC_RES = "android-public-res";
/*     */   private static final String TYPE_SYMBOL = "android-symbol";
/*     */   private static final String TYPE_SYMBOL_WITH_PACKAGE_NAME = "android-symbol-with-package-name";
/*     */   private static final String TYPE_PROGUARD_RULES = "android-proguad";
/*     */   private static final String TYPE_DATA_BINDING_ARTIFACT = "android-databinding";
/*     */   private static final String TYPE_DATA_BINDING_BASE_CLASS_LOG_ARTIFACT = "android-databinding-class-log";
/*     */   private static final String TYPE_EXPLODED_AAR = "android-exploded-aar";
/*     */   private static final String TYPE_MAPPING = "android-mapping";
/*     */   private static final String TYPE_METADATA = "android-metadata";
/*     */   private static final String TYPE_FEATURE_IDS_DECLARATION = "android-feature-split-ids";
/*     */   private static final String TYPE_FEATURE_APPLICATION_ID = "android-feature-application-id";
/*     */   private static final String TYPE_FEATURE_RESOURCE_PKG = "android-feature-res-ap_";
/*     */   private static final String TYPE_FEATURE_TRANSITIVE_DEPS = "android-feature-transitive-deps";
/*     */   private static final String TYPE_METADATA_FEATURE_DECLARATION = "android-metadata-feature-decl";
/*     */   private static final String TYPE_METADATA_FEATURE_MANIFEST = "android-metadata-feature-manifest";
/*     */   private static final String TYPE_METADATA_APP_ID_DECLARATION = "android-metadata-app-id-decl";
/*     */   
/*     */   public static enum ConsumedConfigType
/*     */   {
/*  93 */     COMPILE_CLASSPATH("compileClasspath", AndroidArtifacts.PublishedConfigType.API_ELEMENTS, true), 
/*  94 */     RUNTIME_CLASSPATH("runtimeClasspath", AndroidArtifacts.PublishedConfigType.RUNTIME_ELEMENTS, true), 
/*  95 */     ANNOTATION_PROCESSOR("annotationProcessorClasspath", AndroidArtifacts.PublishedConfigType.RUNTIME_ELEMENTS, false), 
/*  96 */     METADATA_VALUES("metadata", AndroidArtifacts.PublishedConfigType.METADATA_ELEMENTS, false);
/*     */     
/*     */     private final String name;
/*     */     
/*     */     private final AndroidArtifacts.PublishedConfigType publishedTo;
/*     */     private final boolean needsTestedComponents;
/*     */     
/*     */     private ConsumedConfigType(String name, AndroidArtifacts.PublishedConfigType publishedTo, boolean needsTestedComponents)
/*     */     {
/* 106 */       this.name = name;
/* 107 */       this.publishedTo = publishedTo;
/* 108 */       this.needsTestedComponents = needsTestedComponents;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 113 */       return name;
/*     */     }
/*     */     
/*     */     public AndroidArtifacts.PublishedConfigType getPublishedTo()
/*     */     {
/* 118 */       return publishedTo;
/*     */     }
/*     */     
/*     */     public boolean needsTestedComponents() {
/* 122 */       return needsTestedComponents;
/*     */     }
/*     */   }
/*     */   
/*     */   public static enum PublishedConfigType {
/* 127 */     API_ELEMENTS, 
/* 128 */     RUNTIME_ELEMENTS, 
/* 129 */     METADATA_ELEMENTS, 
/* 130 */     BUNDLE_ELEMENTS;
/*     */     
/*     */     private PublishedConfigType() {} }
/*     */   
/* 134 */   public static enum ArtifactScope { ALL,  EXTERNAL,  MODULE;
/*     */     
/*     */     private ArtifactScope() {} }
/*     */   
/* 138 */   public static enum ArtifactType { CLASSES("android-classes"), 
/* 139 */     SHARED_CLASSES("android-shared-classes"), 
/*     */     
/* 141 */     JAR("jar"), 
/*     */     
/* 143 */     DEX("android-dex", "dex"), 
/*     */     
/* 146 */     MANIFEST("android-manifest"), 
/* 147 */     MANIFEST_METADATA("android-manifest-metadata"), 
/*     */     
/* 151 */     RES_STATIC_LIBRARY("android-res-static-library"), 
/* 152 */     RES_SHARED_STATIC_LIBRARY("android-res-shared-static-library"), 
/* 153 */     RES_BUNDLE("android-res-for-bundle", "res"), 
/*     */     
/* 156 */     AIDL("android-aidl"), 
/* 157 */     RENDERSCRIPT("android-renderscript"), 
/* 158 */     DATA_BINDING_ARTIFACT("android-databinding"), 
/* 159 */     DATA_BINDING_BASE_CLASS_LOG_ARTIFACT("android-databinding-class-log"), 
/* 160 */     COMPILE_ONLY_NAMESPACED_R_CLASS_JAR("android-res-namespaced-r-class-jar"), 
/*     */     
/* 163 */     JAVA_RES("android-java-res", "root"), 
/* 164 */     SHARED_JAVA_RES("android-shared-java-res"), 
/* 165 */     ANDROID_RES("android-res"), 
/* 166 */     ASSETS("android-assets", "assets"), 
/* 167 */     SHARED_ASSETS("android-shared-assets"), 
/* 168 */     SYMBOL_LIST("android-symbol"), 
/*     */     
/* 174 */     SYMBOL_LIST_WITH_PACKAGE_NAME("android-symbol-with-package-name"), 
/* 175 */     JNI("android-jni", "lib"), 
/* 176 */     SHARED_JNI("android-shared-jni"), 
/* 177 */     ANNOTATIONS("android-ext-annot"), 
/* 178 */     PUBLIC_RES("android-public-res"), 
/* 179 */     PROGUARD_RULES("android-proguad"), 
/*     */     
/* 181 */     LINT("android-lint"), 
/*     */     
/* 183 */     APK_MAPPING("android-mapping"), 
/* 184 */     APK_METADATA("android-metadata"), 
/* 185 */     APK("apk"), 
/*     */     
/* 188 */     FEATURE_IDS_DECLARATION("android-feature-split-ids"), 
/* 189 */     FEATURE_APPLICATION_ID_DECLARATION("android-feature-application-id"), 
/* 190 */     FEATURE_RESOURCE_PKG("android-feature-res-ap_"), 
/* 191 */     FEATURE_TRANSITIVE_DEPS("android-feature-transitive-deps"), 
/*     */     
/* 194 */     METADATA_FEATURE_DECLARATION("android-metadata-feature-decl"), 
/* 195 */     METADATA_FEATURE_MANIFEST("android-metadata-feature-manifest"), 
/* 196 */     METADATA_APP_ID_DECLARATION("android-metadata-app-id-decl"), 
/*     */     
/* 199 */     AAR("aar"), 
/* 200 */     EXPLODED_AAR("android-exploded-aar");
/*     */     
/*     */     private final String type;
/*     */     private final String pathPrefix;
/*     */     
/*     */     private ArtifactType(String type)
/*     */     {
/* 207 */       this(type, null);
/*     */     }
/*     */     
/*     */     private ArtifactType(String type, String pathPrefix) {
/* 211 */       this.type = type;
/* 212 */       this.pathPrefix = pathPrefix;
/*     */     }
/*     */     
/*     */     public String getType()
/*     */     {
/* 217 */       return type;
/*     */     }
/*     */     
/*     */     public String getPathPrefix()
/*     */     {
/* 222 */       return pathPrefix;
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.publishing.AndroidArtifacts
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */