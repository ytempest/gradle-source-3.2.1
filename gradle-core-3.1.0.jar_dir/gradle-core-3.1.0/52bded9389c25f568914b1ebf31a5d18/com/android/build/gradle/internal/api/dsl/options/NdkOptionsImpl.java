/*    */ package com.android.build.gradle.internal.api.dsl.options;
/*    */ 
/*    */ import com.android.build.api.dsl.options.NdkOptions;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableList;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableSet;
/*    */ import java.util.Collection;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000F\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\016\n\000\n\002\030\002\n\000\n\002\020#\n\002\b\013\n\002\020\b\n\002\b\005\n\002\020!\n\002\b\f\n\002\020\002\n\002\b\003\030\0002\b\022\004\022\0020\0020\0012\0020\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\020\020*\032\0020+2\006\020,\032\0020\002H\026J\b\020-\032\0020+H\026R\024\020\006\032\b\022\004\022\0020\b0\007X\004¢\006\002\n\000R\024\020\t\032\b\022\004\022\0020\b0\nX\004¢\006\002\n\000R0\020\r\032\b\022\004\022\0020\b0\f2\f\020\013\032\b\022\004\022\0020\b0\f8V@VX\016¢\006\f\032\004\b\016\020\017\"\004\b\020\020\021R\034\020\022\032\004\030\0010\bX\016¢\006\016\n\000\032\004\b\023\020\024\"\004\b\025\020\026R\036\020\027\032\004\030\0010\030X\016¢\006\020\n\002\020\035\032\004\b\031\020\032\"\004\b\033\020\034R0\020\037\032\b\022\004\022\0020\b0\0362\f\020\013\032\b\022\004\022\0020\b0\0368V@VX\016¢\006\f\032\004\b \020!\"\004\b\"\020#R\034\020$\032\004\030\0010\bX\016¢\006\016\n\000\032\004\b%\020\024\"\004\b&\020\026R\034\020'\032\004\030\0010\bX\016¢\006\016\n\000\032\004\b(\020\024\"\004\b)\020\026¨\006."}, d2={"Lcom/android/build/gradle/internal/api/dsl/options/NdkOptionsImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;", "Lcom/android/build/api/dsl/options/NdkOptions;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "_abiFilters", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableSet;", "", "_ldlibs", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableList;", "value", "", "abiFilters", "getAbiFilters", "()Ljava/util/Set;", "setAbiFilters", "(Ljava/util/Set;)V", "cFlags", "getCFlags", "()Ljava/lang/String;", "setCFlags", "(Ljava/lang/String;)V", "jobs", "", "getJobs", "()Ljava/lang/Integer;", "setJobs", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "", "ldLibs", "getLdLibs", "()Ljava/util/List;", "setLdLibs", "(Ljava/util/List;)V", "moduleName", "getModuleName", "setModuleName", "stl", "getStl", "setStl", "initWith", "", "that", "seal", "gradle-core"})
/*    */ public final class NdkOptionsImpl extends com.android.build.gradle.internal.api.dsl.sealing.InitializableSealable<NdkOptions> implements NdkOptions
/*    */ {
/*    */   private final SealableList<String> _ldlibs;
/*    */   private final SealableSet<String> _abiFilters;
/*    */   @Nullable
/*    */   private String moduleName;
/*    */   @Nullable
/*    */   private String cFlags;
/*    */   @Nullable
/*    */   private String stl;
/*    */   @Nullable
/*    */   private Integer jobs;
/*    */   
/*    */   public NdkOptionsImpl(@NotNull com.android.builder.errors.EvalIssueReporter issueReporter)
/*    */   {
/* 26 */     super(issueReporter);
/*    */     
/* 29 */     _ldlibs = SealableList.Companion.jdMethod_new(issueReporter);
/* 30 */     _abiFilters = SealableSet.Companion.jdMethod_new(issueReporter); }
/*    */   
/*    */   @NotNull
/* 33 */   public java.util.List<String> getLdLibs() { return (java.util.List)_ldlibs; }
/*    */   
/* 35 */   public void setLdLibs(@NotNull java.util.List<String> value) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(value, "value");_ldlibs.reset$gradle_core((Collection)value);
/*    */   }
/*    */   
/*    */   @NotNull
/* 39 */   public java.util.Set<String> getAbiFilters() { return (java.util.Set)_abiFilters; }
/*    */   
/* 41 */   public void setAbiFilters(@NotNull java.util.Set<String> value) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(value, "value");_abiFilters.reset$gradle_core((Collection)value); }
/*    */   
/*    */   @Nullable
/* 44 */   public String getModuleName() { return moduleName; } public void setModuleName(@Nullable String <set-?>) { moduleName = <set-?>; } @Nullable
/* 45 */   public String getCFlags() { return cFlags; } public void setCFlags(@Nullable String <set-?>) { cFlags = <set-?>; } @Nullable
/* 46 */   public String getStl() { return stl; } public void setStl(@Nullable String <set-?>) { stl = <set-?>; } @Nullable
/* 47 */   public Integer getJobs() { return jobs; } public void setJobs(@Nullable Integer <set-?>) { jobs = <set-?>; }
/*    */   
/*    */   public void initWith(@NotNull NdkOptions that) {
/* 50 */     kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(that, "that"); if (checkSeal()) {
/* 51 */       setModuleName(that.getModuleName());
/* 52 */       setCFlags(that.getCFlags());
/* 53 */       setStl(that.getStl());
/* 54 */       setJobs(that.getJobs());
/* 55 */       _ldlibs.reset$gradle_core((Collection)that.getLdLibs());
/* 56 */       _abiFilters.reset$gradle_core((Collection)that.getAbiFilters());
/*    */     }
/*    */   }
/*    */   
/*    */   public void seal() {
/* 61 */     super.seal();
/*    */     
/* 63 */     _ldlibs.seal();
/* 64 */     _abiFilters.seal();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.options.NdkOptionsImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */