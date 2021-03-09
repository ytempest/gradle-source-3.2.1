/*     */ package com.android.build.gradle.internal.api.sourcesets;
/*     */ 
/*     */ import com.android.build.api.sourcesets.AndroidSourceDirectorySet;
/*     */ import com.android.build.api.sourcesets.AndroidSourceFile;
/*     */ import com.android.build.api.sourcesets.AndroidSourceSet;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.tasks.util.PatternFilterable;
/*     */ import org.gradle.util.GUtil;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000^\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\t\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\033\n\002\030\002\n\002\b\025\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\004\030\0002\0020\0012\0020\002B-\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\b\022\006\020\t\032\0020\n\022\006\020\013\032\0020\f¢\006\002\020\rJ\026\020!\032\0020\0022\f\020S\032\b\022\004\022\0020\"0TH\026J\026\020)\032\0020\0022\f\020S\032\b\022\004\022\0020\"0TH\026J\b\020U\032\0020\004H\026J\026\0207\032\0020\0022\f\020S\032\b\022\004\022\0020\"0TH\026J\026\0209\032\0020\0022\f\020S\032\b\022\004\022\0020\"0TH\026J\026\020;\032\0020\0022\f\020S\032\b\022\004\022\0020\"0TH\026J\026\020=\032\0020\0022\f\020S\032\b\022\004\022\0020>0TH\026J\026\020G\032\0020\0022\f\020S\032\b\022\004\022\0020\"0TH\026J\026\020I\032\0020\0022\f\020S\032\b\022\004\022\0020\"0TH\026J\026\020K\032\0020\0022\f\020S\032\b\022\004\022\0020\"0TH\026J\b\020V\032\0020WH\026J\020\020X\032\0020\0022\006\020Y\032\0020\004H\026J\026\020O\032\0020\0022\f\020S\032\b\022\004\022\0020\"0TH\026J\b\020Z\032\0020\004H\026R\016\020\016\032\0020\017X\004¢\006\002\n\000R\016\020\020\032\0020\017X\004¢\006\002\n\000R\024\020\021\032\0020\0048@X\004¢\006\006\032\004\b\022\020\023R\016\020\024\032\0020\017X\004¢\006\002\n\000R\016\020\025\032\0020\017X\004¢\006\002\n\000R\016\020\026\032\0020\017X\004¢\006\002\n\000R\016\020\027\032\0020\017X\004¢\006\002\n\000R\016\020\030\032\0020\031X\004¢\006\002\n\000R\024\020\032\032\0020\0048@X\004¢\006\006\032\004\b\033\020\023R\024\020\034\032\0020\0048@X\004¢\006\006\032\004\b\035\020\023R\016\020\036\032\0020\017X\004¢\006\002\n\000R\016\020\037\032\0020\017X\004¢\006\002\n\000R\016\020 \032\0020\017X\004¢\006\002\n\000R\024\020!\032\0020\"8VX\004¢\006\006\032\004\b#\020$R\024\020%\032\0020\0048VX\004¢\006\006\032\004\b&\020\023R\024\020'\032\0020\0048VX\004¢\006\006\032\004\b(\020\023R\024\020)\032\0020\"8VX\004¢\006\006\032\004\b*\020$R\032\020+\032\0020\0048VX\004¢\006\f\022\004\b,\020-\032\004\b.\020\023R\024\020/\032\0020\0048VX\004¢\006\006\032\004\b0\020\023R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\0201\032\0020\004X\004¢\006\002\n\000R\024\0202\032\0020\0048VX\004¢\006\006\032\004\b3\020\023R\032\0204\032\0020\0048VX\004¢\006\f\022\004\b5\020-\032\004\b6\020\023R\024\0207\032\0020\"8VX\004¢\006\006\032\004\b8\020$R\024\0209\032\0020\"8VX\004¢\006\006\032\004\b:\020$R\024\020;\032\0020\"8VX\004¢\006\006\032\004\b<\020$R\024\020=\032\0020>8VX\004¢\006\006\032\004\b?\020@R\016\020\003\032\0020\004X\004¢\006\002\n\000R\032\020A\032\0020\0048VX\004¢\006\f\022\004\bB\020-\032\004\bC\020\023R\032\020D\032\0020\0048VX\004¢\006\f\022\004\bE\020-\032\004\bF\020\023R\016\020\007\032\0020\bX\004¢\006\002\n\000R\024\020G\032\0020\"8VX\004¢\006\006\032\004\bH\020$R\024\020I\032\0020\"8VX\004¢\006\006\032\004\bJ\020$R\024\020K\032\0020\"8VX\004¢\006\006\032\004\bL\020$R\024\020M\032\0020\0048VX\004¢\006\006\032\004\bN\020\023R\024\020O\032\0020\"8VX\004¢\006\006\032\004\bP\020$R\024\020Q\032\0020\0048VX\004¢\006\006\032\004\bR\020\023¨\006["}, d2={"Lcom/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/sourcesets/AndroidSourceSet;", "name", "", "filesProvider", "Lcom/android/build/gradle/internal/api/sourcesets/FilesProvider;", "publishPackage", "", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Ljava/lang/String;Lcom/android/build/gradle/internal/api/sourcesets/FilesProvider;ZLcom/android/build/gradle/internal/errors/DeprecationReporter;Lcom/android/builder/errors/EvalIssueReporter;)V", "_aidl", "Lcom/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceDirectorySet;", "_assets", "_compileConfigurationName", "get_compileConfigurationName$gradle_core", "()Ljava/lang/String;", "_javaResources", "_javaSource", "_jni", "_jniLibs", "_manifest", "Lcom/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceFile;", "_packageConfigurationName", "get_packageConfigurationName$gradle_core", "_providedConfigurationName", "get_providedConfigurationName$gradle_core", "_renderscript", "_res", "_shaders", "aidl", "Lcom/android/build/api/sourcesets/AndroidSourceDirectorySet;", "getAidl", "()Lcom/android/build/api/sourcesets/AndroidSourceDirectorySet;", "annotationProcessorConfigurationName", "getAnnotationProcessorConfigurationName", "apiConfigurationName", "getApiConfigurationName", "assets", "getAssets", "compileConfigurationName", "compileConfigurationName$annotations", "()V", "getCompileConfigurationName", "compileOnlyConfigurationName", "getCompileOnlyConfigurationName", "displayName", "implementationConfigurationName", "getImplementationConfigurationName", "jackPluginConfigurationName", "jackPluginConfigurationName$annotations", "getJackPluginConfigurationName", "java", "getJava", "jni", "getJni", "jniLibs", "getJniLibs", "manifest", "Lcom/android/build/api/sourcesets/AndroidSourceFile;", "getManifest", "()Lcom/android/build/api/sourcesets/AndroidSourceFile;", "packageConfigurationName", "packageConfigurationName$annotations", "getPackageConfigurationName", "providedConfigurationName", "providedConfigurationName$annotations", "getProvidedConfigurationName", "renderscript", "getRenderscript", "res", "getRes", "resources", "getResources", "runtimeOnlyConfigurationName", "getRuntimeOnlyConfigurationName", "shaders", "getShaders", "wearAppConfigurationName", "getWearAppConfigurationName", "action", "Lorg/gradle/api/Action;", "getName", "seal", "", "setRoot", "path", "toString", "gradle-core"})
/*     */ public final class DefaultAndroidSourceSet
/*     */   extends SealableObject
/*     */   implements AndroidSourceSet
/*     */ {
/*     */   private final DefaultAndroidSourceDirectorySet _javaSource;
/*     */   private final DefaultAndroidSourceDirectorySet _javaResources;
/*     */   private final DefaultAndroidSourceFile _manifest;
/*     */   private final DefaultAndroidSourceDirectorySet _assets;
/*     */   private final DefaultAndroidSourceDirectorySet _res;
/*     */   private final DefaultAndroidSourceDirectorySet _aidl;
/*     */   private final DefaultAndroidSourceDirectorySet _renderscript;
/*     */   private final DefaultAndroidSourceDirectorySet _jni;
/*     */   private final DefaultAndroidSourceDirectorySet _jniLibs;
/*     */   private final DefaultAndroidSourceDirectorySet _shaders;
/*     */   private final String displayName;
/*     */   private final String name;
/*     */   private final boolean publishPackage;
/*     */   private final DeprecationReporter deprecationReporter;
/*     */   
/*     */   public DefaultAndroidSourceSet(@NotNull String name, @NotNull FilesProvider filesProvider, boolean publishPackage, @NotNull DeprecationReporter deprecationReporter, @NotNull EvalIssueReporter issueReporter)
/*     */   {
/*  47 */     super(issueReporter);this.name = name;this.publishPackage = publishPackage;this.deprecationReporter = deprecationReporter; String 
/*     */     
/*  59 */       tmp63_60 = GUtil.toWords((CharSequence)this.name);Intrinsics.checkExpressionValueIsNotNull(tmp63_60, "GUtil.toWords(this.name)");displayName = tmp63_60;
/*     */     
/*  62 */     String javaSrcDisplayName = "" + displayName + " Java source";
/*  63 */     _javaSource = new DefaultAndroidSourceDirectorySet(javaSrcDisplayName, 
/*  64 */       filesProvider, issueReporter);
/*  65 */     _javaSource.getFilter().include(new String[] { "**/*.java" });
/*     */     
/*  67 */     String javaResourcesDisplayName = "" + displayName + " Java resources";
/*  68 */     _javaResources = new DefaultAndroidSourceDirectorySet(javaResourcesDisplayName, 
/*  69 */       filesProvider, issueReporter);
/*  70 */     _javaResources.getFilter().exclude(new String[] { "**/*.java" });
/*     */     
/*  72 */     String manifestDisplayName = "" + displayName + " manifest";
/*  73 */     _manifest = new DefaultAndroidSourceFile(manifestDisplayName, filesProvider, issueReporter);
/*     */     
/*  75 */     String assetsDisplayName = "" + displayName + " assets";
/*  76 */     _assets = new DefaultAndroidSourceDirectorySet(assetsDisplayName, filesProvider, issueReporter);
/*     */     
/*  78 */     String resourcesDisplayName = "" + displayName + " resources";
/*  79 */     _res = new DefaultAndroidSourceDirectorySet(resourcesDisplayName, filesProvider, issueReporter);
/*     */     
/*  81 */     String aidlDisplayName = "" + displayName + " aidl";
/*  82 */     _aidl = new DefaultAndroidSourceDirectorySet(aidlDisplayName, filesProvider, issueReporter);
/*     */     
/*  84 */     String renderscriptDisplayName = "" + displayName + " renderscript";
/*  85 */     _renderscript = new DefaultAndroidSourceDirectorySet(renderscriptDisplayName, 
/*  86 */       filesProvider, issueReporter);
/*     */     
/*  88 */     String jniDisplayName = "" + displayName + " jni";
/*  89 */     _jni = new DefaultAndroidSourceDirectorySet(jniDisplayName, filesProvider, issueReporter);
/*     */     
/*  91 */     String libsDisplayName = "" + displayName + " jniLibs";
/*  92 */     _jniLibs = new DefaultAndroidSourceDirectorySet(libsDisplayName, filesProvider, issueReporter);
/*     */     
/*  94 */     String shaderDisplayName = "" + displayName + " shaders";
/*  95 */     _shaders = new DefaultAndroidSourceDirectorySet(shaderDisplayName, filesProvider, issueReporter); }
/*     */   
/*     */   @NotNull
/*  98 */   public String getName() { return name; }
/*     */   
/*     */   public void seal() {
/* 101 */     super.seal();
/*     */     
/* 103 */     _manifest.seal();
/* 104 */     _javaSource.seal();
/* 105 */     _javaResources.seal();
/* 106 */     _assets.seal();
/* 107 */     _res.seal();
/* 108 */     _aidl.seal();
/* 109 */     _renderscript.seal();
/* 110 */     _jni.seal();
/* 111 */     _jniLibs.seal();
/* 112 */     _shaders.seal(); }
/*     */   
/*     */   @NotNull
/* 115 */   public String toString() { return "source set " + displayName; }
/*     */   
/*     */   @NotNull
/* 118 */   public AndroidSourceDirectorySet getRes() { return (AndroidSourceDirectorySet)_res; }
/*     */   
/*     */   @NotNull
/* 121 */   public AndroidSourceDirectorySet getAssets() { return (AndroidSourceDirectorySet)_assets; }
/*     */   
/*     */   @NotNull
/* 124 */   public AndroidSourceDirectorySet getResources() { return (AndroidSourceDirectorySet)_javaResources; }
/*     */   
/*     */   @NotNull
/* 127 */   public AndroidSourceDirectorySet getJava() { return (AndroidSourceDirectorySet)_javaSource; }
/*     */   
/*     */   @NotNull
/* 130 */   public AndroidSourceFile getManifest() { return (AndroidSourceFile)_manifest; }
/*     */   
/*     */   @NotNull
/* 133 */   public AndroidSourceDirectorySet getAidl() { return (AndroidSourceDirectorySet)_aidl; }
/*     */   
/*     */   @NotNull
/* 136 */   public AndroidSourceDirectorySet getRenderscript() { return (AndroidSourceDirectorySet)_renderscript; }
/*     */   
/*     */   @NotNull
/* 139 */   public AndroidSourceDirectorySet getJni() { return (AndroidSourceDirectorySet)_jni; }
/*     */   
/*     */   @NotNull
/* 142 */   public AndroidSourceDirectorySet getJniLibs() { return (AndroidSourceDirectorySet)_jniLibs; }
/*     */   
/*     */   @NotNull
/* 145 */   public AndroidSourceDirectorySet getShaders() { return (AndroidSourceDirectorySet)_shaders; }
/*     */   
/*     */   @NotNull
/*     */   public String getApiConfigurationName()
/*     */   {
/* 152 */     return "" + name + "Api";
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getCompileOnlyConfigurationName()
/*     */   {
/* 159 */     return "" + name + "CompileOnly";
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getImplementationConfigurationName()
/*     */   {
/* 166 */     return "" + name + "Implementation";
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getRuntimeOnlyConfigurationName()
/*     */   {
/* 173 */     return "" + name + "RuntimeOnly";
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getWearAppConfigurationName()
/*     */   {
/* 180 */     return "" + name + "WearApp";
/*     */   }
/*     */   
/*     */   @NotNull
/* 187 */   public String getAnnotationProcessorConfigurationName() { return "" + name + "AnnotationProcessor"; }
/*     */   
/*     */   @NotNull
/* 190 */   public AndroidSourceSet manifest(@NotNull Action<AndroidSourceFile> action) { Intrinsics.checkParameterIsNotNull(action, "action");action.execute(_manifest);
/* 191 */     return (AndroidSourceSet)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 195 */   public AndroidSourceSet res(@NotNull Action<AndroidSourceDirectorySet> action) { Intrinsics.checkParameterIsNotNull(action, "action");action.execute(_res);
/* 196 */     return (AndroidSourceSet)this;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public AndroidSourceSet assets(@NotNull Action<AndroidSourceDirectorySet> action) {
/* 201 */     Intrinsics.checkParameterIsNotNull(action, "action");action.execute(_assets);
/* 202 */     return (AndroidSourceSet)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 206 */   public AndroidSourceSet aidl(@NotNull Action<AndroidSourceDirectorySet> action) { Intrinsics.checkParameterIsNotNull(action, "action");action.execute(_aidl);
/* 207 */     return (AndroidSourceSet)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 211 */   public AndroidSourceSet renderscript(@NotNull Action<AndroidSourceDirectorySet> action) { Intrinsics.checkParameterIsNotNull(action, "action");action.execute(_renderscript);
/* 212 */     return (AndroidSourceSet)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 216 */   public AndroidSourceSet jni(@NotNull Action<AndroidSourceDirectorySet> action) { Intrinsics.checkParameterIsNotNull(action, "action");action.execute(_jni);
/* 217 */     return (AndroidSourceSet)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 221 */   public AndroidSourceSet jniLibs(@NotNull Action<AndroidSourceDirectorySet> action) { Intrinsics.checkParameterIsNotNull(action, "action");action.execute(_jniLibs);
/* 222 */     return (AndroidSourceSet)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 226 */   public AndroidSourceSet shaders(@NotNull Action<AndroidSourceDirectorySet> action) { Intrinsics.checkParameterIsNotNull(action, "action");action.execute(_shaders);
/* 227 */     return (AndroidSourceSet)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 231 */   public AndroidSourceSet java(@NotNull Action<AndroidSourceDirectorySet> action) { Intrinsics.checkParameterIsNotNull(action, "action");action.execute(_javaSource);
/* 232 */     return (AndroidSourceSet)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 236 */   public AndroidSourceSet resources(@NotNull Action<AndroidSourceDirectorySet> action) { Intrinsics.checkParameterIsNotNull(action, "action");action.execute(_javaResources);
/* 237 */     return (AndroidSourceSet)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 241 */   public AndroidSourceSet setRoot(@NotNull String path) { Intrinsics.checkParameterIsNotNull(path, "path");_javaSource.setSrcDirs((Iterable)CollectionsKt.listOf(path + "/java"));
/* 242 */     _javaResources.setSrcDirs((Iterable)CollectionsKt.listOf(path + "/resources"));
/* 243 */     _res.setSrcDirs((Iterable)CollectionsKt.listOf(path + "/" + "res"));
/* 244 */     _assets.setSrcDirs((Iterable)CollectionsKt.listOf(path + "/" + "assets"));
/* 245 */     _manifest.srcFile(path + "/" + "AndroidManifest.xml");
/* 246 */     _aidl.setSrcDirs((Iterable)CollectionsKt.listOf(path + "/aidl"));
/* 247 */     _renderscript.setSrcDirs((Iterable)CollectionsKt.listOf(path + "/rs"));
/* 248 */     _jni.setSrcDirs((Iterable)CollectionsKt.listOf(path + "/jni"));
/* 249 */     _jniLibs.setSrcDirs((Iterable)CollectionsKt.listOf(path + "/jniLibs"));
/* 250 */     _shaders.setSrcDirs((Iterable)CollectionsKt.listOf(path + "/shaders"));
/* 251 */     return (AndroidSourceSet)this;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getCompileConfigurationName()
/*     */   {
/* 259 */     deprecationReporter.reportDeprecatedUsage(
/* 260 */       "AndroidSourceSet.implementationConfigurationName", 
/* 261 */       "AndroidSourceSet.compileConfigurationName", 
/* 262 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 263 */     return get_compileConfigurationName$gradle_core();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final String get_compileConfigurationName$gradle_core()
/*     */   {
/* 271 */     return "" + name + "Compile";
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getPackageConfigurationName() {
/* 276 */     deprecationReporter.reportDeprecatedUsage(
/* 277 */       "AndroidSourceSet.runtimeOnlyConfigurationName", 
/* 278 */       "AndroidSourceSet.packageConfigurationName", 
/* 279 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 280 */     return get_packageConfigurationName$gradle_core();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final String get_packageConfigurationName$gradle_core() {
/* 285 */     if (publishPackage) {
/* 286 */       return 
/*     */       
/* 289 */         "" + name + "Publish";
/*     */     }
/*     */     
/* 293 */     return 
/*     */     
/* 296 */       "" + name + "Apk";
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getProvidedConfigurationName()
/*     */   {
/* 303 */     deprecationReporter.reportDeprecatedUsage(
/* 304 */       "AndroidSourceSet.compileOnlyConfigurationName", 
/* 305 */       "AndroidSourceSet.providedConfigurationName", 
/* 306 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 307 */     return get_providedConfigurationName$gradle_core();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final String get_providedConfigurationName$gradle_core()
/*     */   {
/* 315 */     return "" + name + "Provided";
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public String getJackPluginConfigurationName() {
/* 320 */     deprecationReporter.reportObsoleteUsage("AndroidSourceSet.getJackPluginConfigurationName()", 
/* 321 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 322 */     return "";
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.sourcesets.DefaultAndroidSourceSet
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */