/*     */ package com.android.build.gradle.internal.api.dsl.model;
/*     */ 
/*     */ import com.android.build.api.dsl.model.BaseFlavor;
/*     */ import com.android.build.api.dsl.options.PostProcessingFilesOptions;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.NotImplementedError;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Action;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000f\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\"\n\002\020\016\n\002\b\005\n\002\030\002\n\002\b\n\n\002\020\013\n\002\b\n\n\002\020$\n\002\b\f\n\002\020\002\n\002\b\004\n\002\020\021\n\002\b\002\n\002\020 \n\000\n\002\030\002\n\002\b\002\n\002\020\034\n\002\b\b\030\0002\0020\0012\0020\002B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006¢\006\002\020\007J\016\0202\032\002032\006\0204\032\0020\000J)\0205\032\002032\006\0206\032\0020\n2\022\0207\032\n\022\006\b\001\022\0020\n08\"\0020\nH\026¢\006\002\0209J\030\0205\032\002032\006\0206\032\0020\n2\006\020:\032\0020\nH\026J\036\0205\032\002032\006\0206\032\0020\n2\f\0207\032\b\022\004\022\0020\n0;H\026J\026\020\017\032\002032\f\020<\032\b\022\004\022\0020\0200=H\026J\030\020>\032\002032\016\020?\032\n\022\004\022\0020\n\030\0010@H\027J\020\020A\032\002032\006\020B\032\0020\033H\027J\020\020C\032\002032\006\020D\032\0020\033H\027J\030\020E\032\002032\006\020F\032\0020\n2\006\020\023\032\0020\nH\027J\034\020'\032\002032\022\020G\032\016\022\004\022\0020\n\022\004\022\0020\n0&H\027J\027\020-\032\002032\b\020-\032\004\030\0010\033H\027¢\006\002\0200R\016\020\003\032\0020\004X\004¢\006\002\n\000R\"\020\b\032\n\022\004\022\0020\n\030\0010\t8VX\004¢\006\f\022\004\b\013\020\f\032\004\b\r\020\016R\024\020\017\032\0020\0208VX\004¢\006\006\032\004\b\021\020\022R.\020\024\032\004\030\0010\n2\b\020\023\032\004\030\0010\n8V@VX\016¢\006\022\022\004\b\025\020\f\032\004\b\026\020\027\"\004\b\030\020\031R\034\020\032\032\004\030\0010\0338VX\004¢\006\f\022\004\b\034\020\f\032\004\b\035\020\036R\034\020\037\032\004\030\0010\0338VX\004¢\006\f\022\004\b \020\f\032\004\b!\020\036R.\020\"\032\004\030\0010\n2\b\020\023\032\004\030\0010\n8V@VX\016¢\006\022\022\004\b#\020\f\032\004\b$\020\027\"\004\b%\020\031RB\020'\032\016\022\004\022\0020\n\022\004\022\0020\n0&2\022\020\023\032\016\022\004\022\0020\n\022\004\022\0020\n0&8V@VX\016¢\006\022\022\004\b(\020\f\032\004\b)\020*\"\004\b+\020,R*\020-\032\004\030\0010\0332\b\020\023\032\004\030\0010\033@VX\016¢\006\020\n\002\0201\032\004\b.\020\036\"\004\b/\0200¨\006H"}, d2={"Lcom/android/build/gradle/internal/api/dsl/model/BaseFlavorImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/model/BaseFlavor;", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/build/gradle/internal/errors/DeprecationReporter;Lcom/android/builder/errors/EvalIssueReporter;)V", "generatedDensities", "", "", "generatedDensities$annotations", "()V", "getGeneratedDensities", "()Ljava/util/Set;", "postProcessing", "Lcom/android/build/api/dsl/options/PostProcessingFilesOptions;", "getPostProcessing", "()Lcom/android/build/api/dsl/options/PostProcessingFilesOptions;", "value", "testApplicationId", "testApplicationId$annotations", "getTestApplicationId", "()Ljava/lang/String;", "setTestApplicationId", "(Ljava/lang/String;)V", "testFunctionalTest", "", "testFunctionalTest$annotations", "getTestFunctionalTest", "()Ljava/lang/Boolean;", "testHandleProfiling", "testHandleProfiling$annotations", "getTestHandleProfiling", "testInstrumentationRunner", "testInstrumentationRunner$annotations", "getTestInstrumentationRunner", "setTestInstrumentationRunner", "", "testInstrumentationRunnerArguments", "testInstrumentationRunnerArguments$annotations", "getTestInstrumentationRunnerArguments", "()Ljava/util/Map;", "setTestInstrumentationRunnerArguments", "(Ljava/util/Map;)V", "wearAppUnbundled", "getWearAppUnbundled", "setWearAppUnbundled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "initWith", "", "that", "missingDimensionStrategy", "dimension", "requestedValues", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "requestedValue", "", "action", "Lorg/gradle/api/Action;", "setGeneratedDensities", "densities", "", "setTestFunctionalTest", "functionalTest", "setTestHandleProfiling", "handleProfiling", "testInstrumentationRunnerArgument", "key", "args", "gradle-core"})
/*     */ public final class BaseFlavorImpl
/*     */   extends SealableObject
/*     */   implements BaseFlavor
/*     */ {
/*     */   @Nullable
/*     */   private Boolean wearAppUnbundled;
/*     */   private final DeprecationReporter deprecationReporter;
/*     */   
/*     */   public BaseFlavorImpl(@NotNull DeprecationReporter deprecationReporter, @NotNull EvalIssueReporter issueReporter)
/*     */   {
/*  29 */     super(issueReporter);this.deprecationReporter = deprecationReporter; }
/*     */   @Nullable
/*  31 */   public Boolean getWearAppUnbundled() { return wearAppUnbundled; }
/*     */   
/*  33 */   public void setWearAppUnbundled(@Nullable Boolean value) { if (checkSeal()) {
/*  34 */       wearAppUnbundled = value;
/*     */     }
/*     */   }
/*     */   
/*     */   public void missingDimensionStrategy(@NotNull String dimension, @NotNull String requestedValue) {
/*  39 */     Intrinsics.checkParameterIsNotNull(dimension, "dimension");Intrinsics.checkParameterIsNotNull(requestedValue, "requestedValue");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   public void missingDimensionStrategy(@NotNull String dimension, @NotNull String... requestedValues) {
/*  43 */     Intrinsics.checkParameterIsNotNull(dimension, "dimension");Intrinsics.checkParameterIsNotNull(requestedValues, "requestedValues");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   public void missingDimensionStrategy(@NotNull String dimension, @NotNull List<String> requestedValues) {
/*  47 */     Intrinsics.checkParameterIsNotNull(dimension, "dimension");Intrinsics.checkParameterIsNotNull(requestedValues, "requestedValues");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   public void postProcessing(@NotNull Action<PostProcessingFilesOptions> action) {
/*  51 */     Intrinsics.checkParameterIsNotNull(action, "action");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   @NotNull
/*  55 */   public PostProcessingFilesOptions getPostProcessing() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*  58 */   public final void initWith(@NotNull BaseFlavorImpl that) { Intrinsics.checkParameterIsNotNull(that, "that"); if (checkSeal()) {
/*  59 */       setWearAppUnbundled(that.getWearAppUnbundled());
/*     */     }
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Set<String> getGeneratedDensities()
/*     */   {
/*  67 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   public void setGeneratedDensities(@Nullable Iterable<String> densities) {
/*  71 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   public void wearAppUnbundled(@Nullable Boolean wearAppUnbundled)
/*     */   {
/*  76 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getTestApplicationId() {
/*  81 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   public void testInstrumentationRunnerArgument(@NotNull String key, @NotNull String value)
/*     */   {
/*  86 */     Intrinsics.checkParameterIsNotNull(key, "key");Intrinsics.checkParameterIsNotNull(value, "value");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   public void testInstrumentationRunnerArguments(@NotNull Map<String, String> args)
/*     */   {
/*  91 */     Intrinsics.checkParameterIsNotNull(args, "args");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String getTestInstrumentationRunner() {
/*  96 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Map<String, String> getTestInstrumentationRunnerArguments() {
/* 101 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str)); }
/* 102 */   public void setTestInstrumentationRunnerArguments(@NotNull Map<String, String> value) { Intrinsics.checkParameterIsNotNull(value, "value"); }
/*     */   
/*     */   public void setTestHandleProfiling(boolean handleProfiling)
/*     */   {
/* 106 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Boolean getTestHandleProfiling() {
/* 111 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   public void setTestFunctionalTest(boolean functionalTest) {
/* 115 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public Boolean getTestFunctionalTest() {
/* 120 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*     */   }
/*     */   
/*     */   public void setTestApplicationId(@Nullable String value) {}
/*     */   
/*     */   public void setTestInstrumentationRunner(@Nullable String value) {}
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.model.BaseFlavorImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */