/*    */ package com.android.build.gradle.internal.api.dsl.options;
/*    */ 
/*    */ import com.android.build.api.dsl.options.InstrumentationOptions;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.InitializableSealable;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableMap;
/*    */ import java.util.Map;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000:\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\016\n\002\b\006\n\002\020\013\n\002\b\f\n\002\020%\n\002\b\006\n\002\020\002\n\002\b\003\030\0002\b\022\004\022\0020\0020\0012\0020\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\020\020\"\032\0020#2\006\020$\032\0020\002H\026J\b\020%\032\0020#H\026R\032\020\006\032\016\022\004\022\0020\b\022\004\022\0020\b0\007X\004¢\006\002\n\000R(\020\n\032\004\030\0010\b2\b\020\t\032\004\030\0010\b@VX\016¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016R*\020\020\032\004\030\0010\0172\b\020\t\032\004\030\0010\017@VX\016¢\006\020\n\002\020\025\032\004\b\021\020\022\"\004\b\023\020\024R*\020\026\032\004\030\0010\0172\b\020\t\032\004\030\0010\017@VX\016¢\006\020\n\002\020\025\032\004\b\027\020\022\"\004\b\030\020\024R(\020\031\032\004\030\0010\b2\b\020\t\032\004\030\0010\b@VX\016¢\006\016\n\000\032\004\b\032\020\f\"\004\b\033\020\016R<\020\035\032\016\022\004\022\0020\b\022\004\022\0020\b0\0342\022\020\t\032\016\022\004\022\0020\b\022\004\022\0020\b0\0348V@VX\016¢\006\f\032\004\b\036\020\037\"\004\b \020!¨\006&"}, d2={"Lcom/android/build/gradle/internal/api/dsl/options/InstrumentationOptionsImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;", "Lcom/android/build/api/dsl/options/InstrumentationOptions;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "_instrumentationRunnerArguments", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableMap;", "", "value", "applicationId", "getApplicationId", "()Ljava/lang/String;", "setApplicationId", "(Ljava/lang/String;)V", "", "functionalTest", "getFunctionalTest", "()Ljava/lang/Boolean;", "setFunctionalTest", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "handleProfiling", "getHandleProfiling", "setHandleProfiling", "instrumentationRunner", "getInstrumentationRunner", "setInstrumentationRunner", "", "instrumentationRunnerArguments", "getInstrumentationRunnerArguments", "()Ljava/util/Map;", "setInstrumentationRunnerArguments", "(Ljava/util/Map;)V", "initWith", "", "that", "seal", "gradle-core"})
/*    */ public final class InstrumentationOptionsImpl extends InitializableSealable<InstrumentationOptions> implements InstrumentationOptions
/*    */ {
/*    */   private final SealableMap<String, String> _instrumentationRunnerArguments;
/*    */   @Nullable
/*    */   private String applicationId;
/*    */   @Nullable
/*    */   private String instrumentationRunner;
/*    */   @Nullable
/*    */   private Boolean handleProfiling;
/*    */   @Nullable
/*    */   private Boolean functionalTest;
/*    */   
/*    */   public InstrumentationOptionsImpl(@NotNull com.android.builder.errors.EvalIssueReporter issueReporter)
/*    */   {
/* 25 */     super(issueReporter);
/*    */     
/* 27 */     _instrumentationRunnerArguments = SealableMap.Companion.jdMethod_new(issueReporter); }
/*    */   @Nullable
/* 29 */   public String getApplicationId() { return applicationId; }
/*    */   
/* 31 */   public void setApplicationId(@Nullable String value) { if (checkSeal())
/* 32 */       applicationId = value;
/*    */   }
/*    */   
/*    */   @Nullable
/* 36 */   public String getInstrumentationRunner() { return instrumentationRunner; }
/*    */   
/* 38 */   public void setInstrumentationRunner(@Nullable String value) { if (checkSeal()) {
/* 39 */       instrumentationRunner = value;
/*    */     }
/*    */   }
/*    */   
/*    */   @NotNull
/* 44 */   public Map<String, String> getInstrumentationRunnerArguments() { return (Map)_instrumentationRunnerArguments; }
/*    */   
/* 46 */   public void setInstrumentationRunnerArguments(@NotNull Map<String, String> value) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(value, "value");_instrumentationRunnerArguments.reset$gradle_core(value); }
/*    */   
/*    */   @Nullable
/* 49 */   public Boolean getHandleProfiling() { return handleProfiling; }
/*    */   
/* 51 */   public void setHandleProfiling(@Nullable Boolean value) { if (checkSeal())
/* 52 */       handleProfiling = value;
/*    */   }
/*    */   
/*    */   @Nullable
/* 56 */   public Boolean getFunctionalTest() { return functionalTest; }
/*    */   
/* 58 */   public void setFunctionalTest(@Nullable Boolean value) { if (checkSeal()) {
/* 59 */       functionalTest = value;
/*    */     }
/*    */   }
/*    */   
/*    */   public void initWith(@NotNull InstrumentationOptions that) {
/* 64 */     kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(that, "that"); if (checkSeal()) {
/* 65 */       setApplicationId(that.getApplicationId());
/* 66 */       setInstrumentationRunner(that.getInstrumentationRunner());
/* 67 */       _instrumentationRunnerArguments.reset$gradle_core(that.getInstrumentationRunnerArguments());
/* 68 */       setHandleProfiling(that.getHandleProfiling());
/* 69 */       setFunctionalTest(that.getFunctionalTest());
/*    */     }
/*    */   }
/*    */   
/*    */   public void seal() {
/* 74 */     super.seal();
/* 75 */     _instrumentationRunnerArguments.seal();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.options.InstrumentationOptionsImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */