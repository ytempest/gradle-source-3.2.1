/*     */ package com.android.build.gradle.internal.api.dsl.model;
/*     */ 
/*     */ import com.android.build.api.dsl.model.BuildTypeOrVariant;
/*     */ import com.android.build.api.dsl.options.PostProcessingOptions;
/*     */ import com.android.build.gradle.internal.api.dsl.options.PostProcessingOptionsImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.OptionalSupplier;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.gradle.api.Action;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000T\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\000\n\002\020\013\n\002\b\017\n\002\030\002\n\002\b\b\n\002\020\b\n\002\b\f\n\002\020\002\n\002\b\n\n\002\030\002\n\002\b\002\030\0002\0020\0012\0020\002B\035\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\b¢\006\002\020\tJ\025\0203\032\002042\006\0205\032\0020\000H\000¢\006\002\b6J\b\0207\032\0020\016H\027J\b\0208\032\0020\016H\027J\b\0209\032\0020\016H\027J\b\020:\032\0020\016H\027J\b\020;\032\0020\016H\027J\b\020<\032\0020\016H\027J\b\020=\032\0020\016H\027J\026\020\035\032\002042\f\020>\032\b\022\004\022\0020\0360?H\026J\b\020@\032\00204H\026R\024\020\n\032\b\022\004\022\0020\f0\013X\004¢\006\002\n\000R$\020\017\032\0020\0162\006\020\r\032\0020\016@VX\016¢\006\016\n\000\032\004\b\020\020\021\"\004\b\022\020\023R$\020\024\032\0020\0162\006\020\r\032\0020\016@VX\016¢\006\016\n\000\032\004\b\025\020\021\"\004\b\026\020\023R\016\020\005\032\0020\006X\004¢\006\002\n\000R$\020\027\032\0020\0162\006\020\r\032\0020\016@VX\016¢\006\016\n\000\032\004\b\030\020\021\"\004\b\031\020\023R$\020\032\032\0020\0162\006\020\r\032\0020\016@VX\016¢\006\016\n\000\032\004\b\033\020\021\"\004\b\034\020\023R\024\020\035\032\0020\0368VX\004¢\006\006\032\004\b\037\020 R$\020!\032\0020\0162\006\020\r\032\0020\016@VX\016¢\006\016\n\000\032\004\b\"\020\021\"\004\b#\020\023R$\020$\032\0020\0162\006\020\r\032\0020\016@VX\016¢\006\016\n\000\032\004\b%\020\021\"\004\b&\020\023R$\020(\032\0020'2\006\020\r\032\0020'@VX\016¢\006\016\n\000\032\004\b)\020*\"\004\b+\020,R$\020-\032\0020\0162\006\020\r\032\0020\016@VX\016¢\006\016\n\000\032\004\b.\020\021\"\004\b/\020\023R\016\020\003\032\0020\004X\004¢\006\002\n\000R$\0200\032\0020\0162\006\020\r\032\0020\016@VX\016¢\006\016\n\000\032\004\b1\020\021\"\004\b2\020\023¨\006A"}, d2={"Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/model/BuildTypeOrVariant;", "typeName", "", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Ljava/lang/String;Lcom/android/build/gradle/internal/errors/DeprecationReporter;Lcom/android/builder/errors/EvalIssueReporter;)V", "_postProcessing", "Lcom/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier;", "Lcom/android/build/gradle/internal/api/dsl/options/PostProcessingOptionsImpl;", "value", "", "crunchPngs", "getCrunchPngs", "()Z", "setCrunchPngs", "(Z)V", "debuggable", "getDebuggable", "setDebuggable", "embedMicroApp", "getEmbedMicroApp", "setEmbedMicroApp", "jniDebuggable", "getJniDebuggable", "setJniDebuggable", "postProcessing", "Lcom/android/build/api/dsl/options/PostProcessingOptions;", "getPostProcessing", "()Lcom/android/build/api/dsl/options/PostProcessingOptions;", "pseudoLocalesEnabled", "getPseudoLocalesEnabled", "setPseudoLocalesEnabled", "renderscriptDebuggable", "getRenderscriptDebuggable", "setRenderscriptDebuggable", "", "renderscriptOptimLevel", "getRenderscriptOptimLevel", "()I", "setRenderscriptOptimLevel", "(I)V", "testCoverageEnabled", "getTestCoverageEnabled", "setTestCoverageEnabled", "zipAlignEnabled", "getZipAlignEnabled", "setZipAlignEnabled", "initWith", "", "that", "initWith$gradle_core", "isDebuggable", "isEmbedMicroApp", "isJniDebuggable", "isPseudoLocalesEnabled", "isRenderscriptDebuggable", "isTestCoverageEnabled", "isZipAlignEnabled", "action", "Lorg/gradle/api/Action;", "seal", "gradle-core"})
/*     */ public final class BuildTypeOrVariantImpl
/*     */   extends SealableObject
/*     */   implements BuildTypeOrVariant
/*     */ {
/*     */   private final OptionalSupplier<PostProcessingOptionsImpl> _postProcessing;
/*     */   private boolean debuggable;
/*     */   private boolean testCoverageEnabled;
/*     */   private boolean pseudoLocalesEnabled;
/*     */   private boolean jniDebuggable;
/*     */   private boolean renderscriptDebuggable;
/*     */   private int renderscriptOptimLevel;
/*     */   private boolean zipAlignEnabled;
/*     */   private boolean embedMicroApp;
/*     */   private boolean crunchPngs;
/*     */   private final String typeName;
/*     */   private final DeprecationReporter deprecationReporter;
/*     */   
/*  36 */   public boolean getDebuggable() { return debuggable; }
/*     */   
/*  38 */   public void setDebuggable(boolean value) { if (checkSeal()) {
/*  39 */       debuggable = value;
/*     */     }
/*     */   }
/*     */   
/*  43 */   public boolean getTestCoverageEnabled() { return testCoverageEnabled; }
/*     */   
/*  45 */   public void setTestCoverageEnabled(boolean value) { if (checkSeal()) {
/*  46 */       testCoverageEnabled = value;
/*     */     }
/*     */   }
/*     */   
/*  50 */   public boolean getPseudoLocalesEnabled() { return pseudoLocalesEnabled; }
/*     */   
/*  52 */   public void setPseudoLocalesEnabled(boolean value) { if (checkSeal()) {
/*  53 */       pseudoLocalesEnabled = value;
/*     */     }
/*     */   }
/*     */   
/*  57 */   public boolean getJniDebuggable() { return jniDebuggable; }
/*     */   
/*  59 */   public void setJniDebuggable(boolean value) { if (checkSeal()) {
/*  60 */       jniDebuggable = value;
/*     */     }
/*     */   }
/*     */   
/*  64 */   public boolean getRenderscriptDebuggable() { return renderscriptDebuggable; }
/*     */   
/*  66 */   public void setRenderscriptDebuggable(boolean value) { if (checkSeal()) {
/*  67 */       renderscriptDebuggable = value;
/*     */     }
/*     */   }
/*     */   
/*  71 */   public int getRenderscriptOptimLevel() { return renderscriptOptimLevel; }
/*     */   
/*  73 */   public void setRenderscriptOptimLevel(int value) { if (checkSeal()) {
/*  74 */       renderscriptOptimLevel = value;
/*     */     }
/*     */   }
/*     */   
/*  78 */   public boolean getZipAlignEnabled() { return zipAlignEnabled; }
/*     */   
/*  80 */   public void setZipAlignEnabled(boolean value) { if (checkSeal()) {
/*  81 */       zipAlignEnabled = value;
/*     */     }
/*     */   }
/*     */   
/*  85 */   public boolean getEmbedMicroApp() { return embedMicroApp; }
/*     */   
/*  87 */   public void setEmbedMicroApp(boolean value) { if (checkSeal())
/*  88 */       embedMicroApp = value;
/*     */   }
/*     */   
/*     */   public boolean getCrunchPngs() {
/*  92 */     return crunchPngs;
/*     */   }
/*     */   
/*     */   public BuildTypeOrVariantImpl(@NotNull String typeName, @NotNull DeprecationReporter deprecationReporter, @NotNull EvalIssueReporter issueReporter)
/*     */   {
/*  32 */     super(issueReporter);this.typeName = typeName;this.deprecationReporter = deprecationReporter;
/*     */     
/*  34 */     _postProcessing = new OptionalSupplier((Function0)new Lambda(issueReporter) { @NotNull
/*  34 */       public final PostProcessingOptionsImpl invoke() { return new PostProcessingOptionsImpl($issueReporter);
/*     */       }
/*     */       
/*  70 */     });
/*  71 */     renderscriptOptimLevel = 3;
/*     */     
/*  78 */     zipAlignEnabled = true;
/*     */     
/*  85 */     embedMicroApp = true;
/*     */     
/*  92 */     crunchPngs = true; }
/*     */   
/*  94 */   public void setCrunchPngs(boolean value) { if (checkSeal()) {
/*  95 */       crunchPngs = value;
/*     */     }
/*     */   }
/*     */   
/*     */   public void postProcessing(@NotNull Action<PostProcessingOptions> action) {
/* 100 */     Intrinsics.checkParameterIsNotNull(action, "action");action.execute(_postProcessing.get(isSealed()));
/*     */   }
/*     */   
/*     */   @NotNull
/* 104 */   public PostProcessingOptions getPostProcessing() { return (PostProcessingOptions)_postProcessing.get(isSealed()); }
/*     */   
/*     */   public final void initWith$gradle_core(@NotNull BuildTypeOrVariantImpl that) {
/* 107 */     Intrinsics.checkParameterIsNotNull(that, "that"); if (checkSeal()) {
/* 108 */       _postProcessing.copyFrom(_postProcessing);
/*     */       
/* 110 */       setDebuggable(that.getDebuggable());
/* 111 */       setTestCoverageEnabled(that.getTestCoverageEnabled());
/* 112 */       setPseudoLocalesEnabled(that.getPseudoLocalesEnabled());
/* 113 */       setJniDebuggable(that.getJniDebuggable());
/* 114 */       setRenderscriptDebuggable(that.getRenderscriptDebuggable());
/* 115 */       setRenderscriptOptimLevel(that.getRenderscriptOptimLevel());
/* 116 */       setZipAlignEnabled(that.getZipAlignEnabled());
/* 117 */       setEmbedMicroApp(that.getEmbedMicroApp());
/* 118 */       setCrunchPngs(that.getCrunchPngs());
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isDebuggable()
/*     */   {
/* 131 */     deprecationReporter.reportDeprecatedUsage(
/* 132 */       "" + typeName + ".debuggable", 
/* 133 */       "" + typeName + ".isDebuggable", 
/* 134 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 135 */     return getDebuggable();
/*     */   }
/*     */   
/*     */   public boolean isTestCoverageEnabled()
/*     */   {
/* 140 */     deprecationReporter.reportDeprecatedUsage(
/* 141 */       "" + typeName + ".testCoverageEnabled", 
/* 142 */       "" + typeName + ".isTestCoverageEnabled", 
/* 143 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 144 */     return getTestCoverageEnabled();
/*     */   }
/*     */   
/*     */   public boolean isEmbedMicroApp()
/*     */   {
/* 149 */     deprecationReporter.reportDeprecatedUsage(
/* 150 */       "" + typeName + ".testCoverageEnabled", 
/* 151 */       "" + typeName + ".isTestCoverageEnabled", 
/* 152 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 153 */     return getEmbedMicroApp();
/*     */   }
/*     */   
/*     */   public boolean isPseudoLocalesEnabled()
/*     */   {
/* 158 */     deprecationReporter.reportDeprecatedUsage(
/* 159 */       "" + typeName + ".pseudoLocalesEnabled", 
/* 160 */       "" + typeName + ".isPseudoLocalesEnabled", 
/* 161 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 162 */     return getPseudoLocalesEnabled();
/*     */   }
/*     */   
/*     */   public boolean isJniDebuggable()
/*     */   {
/* 167 */     deprecationReporter.reportDeprecatedUsage(
/* 168 */       "" + typeName + ".jniDebuggable", 
/* 169 */       "" + typeName + ".isJniDebuggable", 
/* 170 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 171 */     return getJniDebuggable();
/*     */   }
/*     */   
/*     */   public boolean isRenderscriptDebuggable()
/*     */   {
/* 176 */     deprecationReporter.reportDeprecatedUsage(
/* 177 */       "" + typeName + ".renderscriptDebuggable", 
/* 178 */       "" + typeName + ".isRenderscriptDebuggable", 
/* 179 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 180 */     return getRenderscriptDebuggable();
/*     */   }
/*     */   
/*     */   public boolean isZipAlignEnabled()
/*     */   {
/* 185 */     deprecationReporter.reportDeprecatedUsage(
/* 186 */       "" + typeName + ".zipAlignEnabled", 
/* 187 */       "" + typeName + ".isZipAlignEnabled", 
/* 188 */       DeprecationReporter.DeprecationTarget.OLD_DSL);
/* 189 */     return getZipAlignEnabled();
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void seal()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial 147	com/android/build/gradle/internal/api/dsl/sealing/SealableObject:seal	()V
/*     */     //   4: aload_0
/*     */     //   5: getfield 79	com/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl:_postProcessing	Lcom/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier;
/*     */     //   8: invokevirtual 151	com/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier:getInstance	()Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;
/*     */     //   11: checkcast 153	com/android/build/gradle/internal/api/dsl/options/PostProcessingOptionsImpl
/*     */     //   14: dup
/*     */     //   15: ifnull +9 -> 24
/*     */     //   18: invokevirtual 154	com/android/build/gradle/internal/api/dsl/options/PostProcessingOptionsImpl:seal	()V
/*     */     //   21: goto +4 -> 25
/*     */     //   24: pop
/*     */     //   25: return
/*     */     // Line number table:
/*     */     //   Java source line #123	-> byte code offset #0
/*     */     //   Java source line #124	-> byte code offset #4
/*     */     //   Java source line #125	-> byte code offset #25
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	26	0	this	BuildTypeOrVariantImpl
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.model.BuildTypeOrVariantImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */