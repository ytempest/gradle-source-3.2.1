/*     */ package com.android.build.gradle.internal.api.dsl.model;
/*     */ 
/*     */ import com.android.build.api.dsl.model.TypedValue;
/*     */ import com.android.build.gradle.internal.api.dsl.options.ExternalNativeBuildOptionsImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.options.NdkOptionsImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.OptionalSupplier;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.SealableList;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.gradle.api.Action;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000¤\001\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\020\016\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020!\n\002\b\006\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020%\n\002\b\005\n\002\020\013\n\002\b\006\n\002\030\002\n\002\b\t\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\006\n\002\020\002\n\002\b\004\n\002\030\002\n\002\b\006\030\0002\0020\0012\0020\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005J \020M\032\0020N2\006\020O\032\0020\0202\006\020P\032\0020\0202\006\020\027\032\0020\020H\026J\026\020Q\032\0020N2\f\020R\032\b\022\004\022\0020\0370SH\026J\026\020\036\032\0020N2\f\020R\032\b\022\004\022\0020\0370SH\026J\016\020T\032\0020N2\006\020U\032\0020\000J\026\020\"\032\0020N2\f\020R\032\b\022\004\022\0020#0SH\026J\026\020<\032\0020N2\f\020R\032\b\022\004\022\0020=0SH\026J \020V\032\0020N2\006\020O\032\0020\0202\006\020P\032\0020\0202\006\020\027\032\0020\020H\026J\b\020W\032\0020NH\026J\026\020X\032\0020N2\f\020R\032\b\022\004\022\0020D0SH\026R\024\020\006\032\b\022\004\022\0020\b0\007X\004¢\006\002\n\000R\024\020\t\032\b\022\004\022\0020\0130\nX\004¢\006\002\n\000R\024\020\f\032\b\022\004\022\0020\r0\nX\004¢\006\002\n\000R\032\020\016\032\016\022\004\022\0020\020\022\004\022\0020\0210\017X\004¢\006\002\n\000R\024\020\022\032\b\022\004\022\0020\0230\nX\004¢\006\002\n\000R\024\020\024\032\b\022\004\022\0020\b0\007X\004¢\006\002\n\000R\024\020\025\032\b\022\004\022\0020\0260\nX\004¢\006\002\n\000R0\020\031\032\b\022\004\022\0020\b0\0302\f\020\027\032\b\022\004\022\0020\b0\0308V@VX\016¢\006\f\032\004\b\032\020\033\"\004\b\034\020\035R\024\020\036\032\0020\0378VX\004¢\006\006\032\004\b \020!R\024\020\"\032\0020#8VX\004¢\006\006\032\004\b$\020%R<\020'\032\016\022\004\022\0020\020\022\004\022\0020\0210&2\022\020\027\032\016\022\004\022\0020\020\022\004\022\0020\0210&8V@VX\016¢\006\f\032\004\b(\020)\"\004\b*\020+R*\020-\032\004\030\0010,2\b\020\027\032\004\030\0010,@VX\016¢\006\020\n\002\0202\032\004\b.\020/\"\004\b0\0201R(\0204\032\004\030\001032\b\020\027\032\004\030\00103@VX\016¢\006\016\n\000\032\004\b5\0206\"\004\b7\0208R(\0209\032\004\030\001032\b\020\027\032\004\030\00103@VX\016¢\006\016\n\000\032\004\b:\0206\"\004\b;\0208R\024\020<\032\0020=8VX\004¢\006\006\032\004\b>\020?R0\020@\032\b\022\004\022\0020\b0\0302\f\020\027\032\b\022\004\022\0020\b0\0308V@VX\016¢\006\f\032\004\bA\020\033\"\004\bB\020\035R\024\020C\032\0020D8VX\004¢\006\006\032\004\bE\020FR(\020H\032\004\030\0010G2\b\020\027\032\004\030\0010G@VX\016¢\006\016\n\000\032\004\bI\020J\"\004\bK\020L¨\006Y"}, d2={"Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/model/VariantProperties;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "_buildConfigFields", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableList;", "Lcom/android/build/api/dsl/model/TypedValue;", "_externalNativeBuildOptions", "Lcom/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier;", "Lcom/android/build/gradle/internal/api/dsl/options/ExternalNativeBuildOptionsImpl;", "_javaCompileOptions", "Lcom/android/build/gradle/internal/api/dsl/options/JavaCompileOptionsImpl;", "_manifestPlaceholders", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableMap;", "", "", "_ndkOptions", "Lcom/android/build/gradle/internal/api/dsl/options/NdkOptionsImpl;", "_resValues", "_shaders", "Lcom/android/build/gradle/internal/api/dsl/options/ShaderOptionsImpl;", "value", "", "buildConfigFields", "getBuildConfigFields", "()Ljava/util/List;", "setBuildConfigFields", "(Ljava/util/List;)V", "externalNativeBuildOptions", "Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "getExternalNativeBuildOptions", "()Lcom/android/build/api/dsl/options/ExternalNativeBuildOptions;", "javaCompileOptions", "Lcom/android/build/api/dsl/options/JavaCompileOptions;", "getJavaCompileOptions", "()Lcom/android/build/api/dsl/options/JavaCompileOptions;", "", "manifestPlaceholders", "getManifestPlaceholders", "()Ljava/util/Map;", "setManifestPlaceholders", "(Ljava/util/Map;)V", "", "multiDexEnabled", "getMultiDexEnabled", "()Ljava/lang/Boolean;", "setMultiDexEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "Ljava/io/File;", "multiDexKeepFile", "getMultiDexKeepFile", "()Ljava/io/File;", "setMultiDexKeepFile", "(Ljava/io/File;)V", "multiDexKeepProguard", "getMultiDexKeepProguard", "setMultiDexKeepProguard", "ndkOptions", "Lcom/android/build/api/dsl/options/NdkOptions;", "getNdkOptions", "()Lcom/android/build/api/dsl/options/NdkOptions;", "resValues", "getResValues", "setResValues", "shaders", "Lcom/android/build/api/dsl/options/ShaderOptions;", "getShaders", "()Lcom/android/build/api/dsl/options/ShaderOptions;", "Lcom/android/build/api/dsl/options/SigningConfig;", "signingConfig", "getSigningConfig", "()Lcom/android/build/api/dsl/options/SigningConfig;", "setSigningConfig", "(Lcom/android/build/api/dsl/options/SigningConfig;)V", "buildConfigField", "", "type", "name", "externalNativeBuild", "action", "Lorg/gradle/api/Action;", "initWith", "that", "resValue", "seal", "shaderOptions", "gradle-core"})
/*     */ public final class VariantPropertiesImpl extends com.android.build.gradle.internal.api.dsl.sealing.SealableObject implements com.android.build.api.dsl.model.VariantProperties
/*     */ {
/*     */   private final SealableList<TypedValue> _buildConfigFields;
/*     */   private final SealableList<TypedValue> _resValues;
/*     */   private final com.android.build.gradle.internal.api.dsl.sealing.SealableMap<String, Object> _manifestPlaceholders;
/*     */   private final OptionalSupplier<NdkOptionsImpl> _ndkOptions;
/*     */   private final OptionalSupplier<com.android.build.gradle.internal.api.dsl.options.JavaCompileOptionsImpl> _javaCompileOptions;
/*     */   private final OptionalSupplier<ExternalNativeBuildOptionsImpl> _externalNativeBuildOptions;
/*     */   private final OptionalSupplier<com.android.build.gradle.internal.api.dsl.options.ShaderOptionsImpl> _shaders;
/*     */   @Nullable
/*     */   private com.android.build.api.dsl.options.SigningConfig signingConfig;
/*     */   @Nullable
/*     */   private Boolean multiDexEnabled;
/*     */   @Nullable
/*     */   private File multiDexKeepFile;
/*     */   @Nullable
/*     */   private File multiDexKeepProguard;
/*     */   
/*     */   public VariantPropertiesImpl(@NotNull EvalIssueReporter issueReporter)
/*     */   {
/*  42 */     super(issueReporter);
/*     */     
/*  45 */     _buildConfigFields = SealableList.Companion.jdMethod_new(issueReporter);
/*  46 */     _resValues = SealableList.Companion.jdMethod_new(issueReporter);
/*  47 */     _manifestPlaceholders = com.android.build.gradle.internal.api.dsl.sealing.SealableMap.Companion.jdMethod_new(issueReporter);
/*     */     
/*  49 */     _ndkOptions = new OptionalSupplier((Function0)new Lambda(issueReporter) { @NotNull
/*  49 */       public final NdkOptionsImpl invoke() { return new NdkOptionsImpl($issueReporter); } });
/*  50 */     _javaCompileOptions = new OptionalSupplier((Function0)new Lambda(issueReporter) { @NotNull
/*  50 */       public final com.android.build.gradle.internal.api.dsl.options.JavaCompileOptionsImpl invoke() { return new com.android.build.gradle.internal.api.dsl.options.JavaCompileOptionsImpl($issueReporter); } });
/*  51 */     _externalNativeBuildOptions = new OptionalSupplier((Function0)new Lambda(issueReporter) { @NotNull
/*  52 */       public final ExternalNativeBuildOptionsImpl invoke() { return new ExternalNativeBuildOptionsImpl($issueReporter); } });
/*  53 */     _shaders = new OptionalSupplier((Function0)new Lambda(issueReporter) { @NotNull
/*  53 */       public final com.android.build.gradle.internal.api.dsl.options.ShaderOptionsImpl invoke() { return new com.android.build.gradle.internal.api.dsl.options.ShaderOptionsImpl($issueReporter); } }); }
/*     */   
/*     */   @NotNull
/*  56 */   public com.android.build.api.dsl.options.NdkOptions getNdkOptions() { return (com.android.build.api.dsl.options.NdkOptions)_ndkOptions.get(isSealed()); }
/*     */   @NotNull
/*  58 */   public com.android.build.api.dsl.options.JavaCompileOptions getJavaCompileOptions() { return (com.android.build.api.dsl.options.JavaCompileOptions)_javaCompileOptions.get(isSealed()); }
/*     */   @NotNull
/*  60 */   public com.android.build.api.dsl.options.ExternalNativeBuildOptions getExternalNativeBuildOptions() { return (com.android.build.api.dsl.options.ExternalNativeBuildOptions)_externalNativeBuildOptions.get(isSealed()); }
/*     */   @NotNull
/*  62 */   public com.android.build.api.dsl.options.ShaderOptions getShaders() { return (com.android.build.api.dsl.options.ShaderOptions)_shaders.get(isSealed()); }
/*     */   @Nullable
/*  64 */   public com.android.build.api.dsl.options.SigningConfig getSigningConfig() { return signingConfig; }
/*     */   
/*  66 */   public void setSigningConfig(@Nullable com.android.build.api.dsl.options.SigningConfig value) { if (checkSeal()) {
/*  67 */       if (!(value instanceof com.android.build.gradle.internal.api.dsl.options.SigningConfigImpl)) {
/*  68 */         getIssueReporter().reportError(
/*  69 */           com.android.builder.errors.EvalIssueReporter.Type.GENERIC, 
/*  70 */           "BuildType.signingConfig set with an object not from android.signingConfigs");
/*     */       }
/*  72 */       signingConfig = value;
/*     */     }
/*     */   }
/*     */   
/*     */   @NotNull
/*  77 */   public List<TypedValue> getBuildConfigFields() { return (List)_buildConfigFields; }
/*     */   
/*  79 */   public void setBuildConfigFields(@NotNull List<TypedValue> value) { Intrinsics.checkParameterIsNotNull(value, "value");_buildConfigFields.reset$gradle_core((Collection)value);
/*     */   }
/*     */   
/*     */   public void buildConfigField(@NotNull String type, @NotNull String name, @NotNull String value) {
/*  83 */     Intrinsics.checkParameterIsNotNull(type, "type");Intrinsics.checkParameterIsNotNull(name, "name");Intrinsics.checkParameterIsNotNull(value, "value");_buildConfigFields.add(new TypedValueImpl(type, name, value));
/*     */   }
/*     */   
/*     */   @NotNull
/*  87 */   public List<TypedValue> getResValues() { return (List)_resValues; }
/*     */   
/*  89 */   public void setResValues(@NotNull List<TypedValue> value) { Intrinsics.checkParameterIsNotNull(value, "value");_resValues.reset$gradle_core((Collection)value);
/*     */   }
/*     */   
/*     */   public void resValue(@NotNull String type, @NotNull String name, @NotNull String value) {
/*  93 */     Intrinsics.checkParameterIsNotNull(type, "type");Intrinsics.checkParameterIsNotNull(name, "name");Intrinsics.checkParameterIsNotNull(value, "value"); if (checkSeal()) {
/*  94 */       _resValues.add(new TypedValueImpl(type, name, value));
/*     */     }
/*     */   }
/*     */   
/*     */   @NotNull
/*  99 */   public Map<String, Object> getManifestPlaceholders() { return (Map)_manifestPlaceholders; }
/*     */   
/* 101 */   public void setManifestPlaceholders(@NotNull Map<String, Object> value) { Intrinsics.checkParameterIsNotNull(value, "value");_manifestPlaceholders.reset$gradle_core(value); }
/*     */   
/*     */   @Nullable
/* 104 */   public Boolean getMultiDexEnabled() { return multiDexEnabled; }
/*     */   
/* 106 */   public void setMultiDexEnabled(@Nullable Boolean value) { if (checkSeal())
/* 107 */       multiDexEnabled = value;
/*     */   }
/*     */   
/*     */   @Nullable
/* 111 */   public File getMultiDexKeepFile() { return multiDexKeepFile; }
/*     */   
/* 113 */   public void setMultiDexKeepFile(@Nullable File value) { if (checkSeal())
/* 114 */       multiDexKeepFile = value;
/*     */   }
/*     */   
/*     */   @Nullable
/* 118 */   public File getMultiDexKeepProguard() { return multiDexKeepProguard; }
/*     */   
/* 120 */   public void setMultiDexKeepProguard(@Nullable File value) { if (checkSeal()) {
/* 121 */       multiDexKeepProguard = value;
/*     */     }
/*     */   }
/*     */   
/*     */   public void ndkOptions(@NotNull Action<com.android.build.api.dsl.options.NdkOptions> action) {
/* 126 */     Intrinsics.checkParameterIsNotNull(action, "action");action.execute(_ndkOptions.get(isSealed()));
/*     */   }
/*     */   
/*     */   public void javaCompileOptions(@NotNull Action<com.android.build.api.dsl.options.JavaCompileOptions> action) {
/* 130 */     Intrinsics.checkParameterIsNotNull(action, "action");action.execute(_javaCompileOptions.get(isSealed()));
/*     */   }
/*     */   
/*     */   public void externalNativeBuild(@NotNull Action<com.android.build.api.dsl.options.ExternalNativeBuildOptions> action)
/*     */   {
/* 135 */     Intrinsics.checkParameterIsNotNull(action, "action");action.execute(_externalNativeBuildOptions.get(isSealed()));
/*     */   }
/*     */   
/*     */   public void externalNativeBuildOptions(@NotNull Action<com.android.build.api.dsl.options.ExternalNativeBuildOptions> action)
/*     */   {
/* 140 */     Intrinsics.checkParameterIsNotNull(action, "action");action.execute(_externalNativeBuildOptions.get(isSealed()));
/*     */   }
/*     */   
/*     */   public void shaderOptions(@NotNull Action<com.android.build.api.dsl.options.ShaderOptions> action) {
/* 144 */     Intrinsics.checkParameterIsNotNull(action, "action");action.execute(_shaders.get(isSealed()));
/*     */   }
/*     */   
/*     */   public final void initWith(@NotNull VariantPropertiesImpl that)
/*     */   {
/* 149 */     Intrinsics.checkParameterIsNotNull(that, "that"); if (checkSeal()) {
/* 150 */       _buildConfigFields.reset$gradle_core((Collection)_buildConfigFields);
/* 151 */       _resValues.reset$gradle_core((Collection)_resValues);
/* 152 */       _manifestPlaceholders.reset$gradle_core((Map)_manifestPlaceholders);
/*     */       
/* 154 */       _ndkOptions.copyFrom(_ndkOptions);
/* 155 */       _javaCompileOptions.copyFrom(_javaCompileOptions);
/*     */       
/* 157 */       _externalNativeBuildOptions.copyFrom(_externalNativeBuildOptions);
/* 158 */       _shaders.copyFrom(_shaders);
/*     */       
/* 160 */       setMultiDexEnabled(that.getMultiDexEnabled());
/* 161 */       setMultiDexKeepFile(that.getMultiDexKeepFile());
/* 162 */       setMultiDexKeepProguard(that.getMultiDexKeepProguard());
/*     */     }
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void seal()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial 211	com/android/build/gradle/internal/api/dsl/sealing/SealableObject:seal	()V
/*     */     //   4: aload_0
/*     */     //   5: getfield 96	com/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl:_buildConfigFields	Lcom/android/build/gradle/internal/api/dsl/sealing/SealableList;
/*     */     //   8: invokevirtual 212	com/android/build/gradle/internal/api/dsl/sealing/SealableList:seal	()V
/*     */     //   11: aload_0
/*     */     //   12: getfield 135	com/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl:_resValues	Lcom/android/build/gradle/internal/api/dsl/sealing/SealableList;
/*     */     //   15: invokevirtual 212	com/android/build/gradle/internal/api/dsl/sealing/SealableList:seal	()V
/*     */     //   18: aload_0
/*     */     //   19: getfield 141	com/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl:_manifestPlaceholders	Lcom/android/build/gradle/internal/api/dsl/sealing/SealableMap;
/*     */     //   22: invokevirtual 213	com/android/build/gradle/internal/api/dsl/sealing/SealableMap:seal	()V
/*     */     //   25: aload_0
/*     */     //   26: getfield 27	com/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl:_ndkOptions	Lcom/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier;
/*     */     //   29: invokevirtual 217	com/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier:getInstance	()Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;
/*     */     //   32: checkcast 219	com/android/build/gradle/internal/api/dsl/options/NdkOptionsImpl
/*     */     //   35: dup
/*     */     //   36: ifnull +9 -> 45
/*     */     //   39: invokevirtual 220	com/android/build/gradle/internal/api/dsl/options/NdkOptionsImpl:seal	()V
/*     */     //   42: goto +4 -> 46
/*     */     //   45: pop
/*     */     //   46: aload_0
/*     */     //   47: getfield 45	com/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl:_javaCompileOptions	Lcom/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier;
/*     */     //   50: invokevirtual 217	com/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier:getInstance	()Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;
/*     */     //   53: checkcast 222	com/android/build/gradle/internal/api/dsl/options/JavaCompileOptionsImpl
/*     */     //   56: dup
/*     */     //   57: ifnull +9 -> 66
/*     */     //   60: invokevirtual 223	com/android/build/gradle/internal/api/dsl/options/JavaCompileOptionsImpl:seal	()V
/*     */     //   63: goto +4 -> 67
/*     */     //   66: pop
/*     */     //   67: aload_0
/*     */     //   68: getfield 51	com/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl:_externalNativeBuildOptions	Lcom/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier;
/*     */     //   71: invokevirtual 217	com/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier:getInstance	()Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;
/*     */     //   74: checkcast 225	com/android/build/gradle/internal/api/dsl/options/ExternalNativeBuildOptionsImpl
/*     */     //   77: dup
/*     */     //   78: ifnull +9 -> 87
/*     */     //   81: invokevirtual 226	com/android/build/gradle/internal/api/dsl/options/ExternalNativeBuildOptionsImpl:seal	()V
/*     */     //   84: goto +4 -> 88
/*     */     //   87: pop
/*     */     //   88: aload_0
/*     */     //   89: getfield 57	com/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl:_shaders	Lcom/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier;
/*     */     //   92: invokevirtual 217	com/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier:getInstance	()Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;
/*     */     //   95: checkcast 228	com/android/build/gradle/internal/api/dsl/options/ShaderOptionsImpl
/*     */     //   98: dup
/*     */     //   99: ifnull +9 -> 108
/*     */     //   102: invokevirtual 229	com/android/build/gradle/internal/api/dsl/options/ShaderOptionsImpl:seal	()V
/*     */     //   105: goto +4 -> 109
/*     */     //   108: pop
/*     */     //   109: aload_0
/*     */     //   110: invokevirtual 231	com/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl:getSigningConfig	()Lcom/android/build/api/dsl/options/SigningConfig;
/*     */     //   113: dup
/*     */     //   114: instanceof 73
/*     */     //   117: ifne +5 -> 122
/*     */     //   120: pop
/*     */     //   121: aconst_null
/*     */     //   122: checkcast 73	com/android/build/gradle/internal/api/dsl/options/SigningConfigImpl
/*     */     //   125: dup
/*     */     //   126: ifnull +9 -> 135
/*     */     //   129: invokevirtual 232	com/android/build/gradle/internal/api/dsl/options/SigningConfigImpl:seal	()V
/*     */     //   132: goto +4 -> 136
/*     */     //   135: pop
/*     */     //   136: return
/*     */     // Line number table:
/*     */     //   Java source line #167	-> byte code offset #0
/*     */     //   Java source line #169	-> byte code offset #4
/*     */     //   Java source line #170	-> byte code offset #11
/*     */     //   Java source line #171	-> byte code offset #18
/*     */     //   Java source line #173	-> byte code offset #25
/*     */     //   Java source line #174	-> byte code offset #46
/*     */     //   Java source line #175	-> byte code offset #67
/*     */     //   Java source line #176	-> byte code offset #88
/*     */     //   Java source line #178	-> byte code offset #109
/*     */     //   Java source line #179	-> byte code offset #136
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	137	0	this	VariantPropertiesImpl
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.model.VariantPropertiesImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */