/*    */ package com.android.build.gradle.internal.api.dsl.extensions;
/*    */ 
/*    */ import com.android.build.api.dsl.extension.EmbeddedTestProperties;
/*    */ import com.android.build.api.dsl.variant.TestVariant;
/*    */ import com.android.build.api.dsl.variant.UnitTestVariant;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import com.android.builder.model.TestOptions;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.NotImplementedError;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.gradle.api.DomainObjectSet;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000F\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\006\n\002\030\002\n\002\b\003\n\002\030\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\030\0002\0020\0012\0020\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\b\020\034\032\0020\035H\026J\026\020\r\032\0020\0352\f\020\036\032\b\022\004\022\0020\0160\037H\026R(\020\b\032\004\030\0010\0072\b\020\006\032\004\030\0010\007@VX\016¢\006\016\n\000\032\004\b\t\020\n\"\004\b\013\020\fR\024\020\r\032\0020\0168VX\004¢\006\006\032\004\b\017\020\020R \020\021\032\b\022\004\022\0020\0230\0228VX\004¢\006\f\022\004\b\024\020\025\032\004\b\026\020\027R \020\030\032\b\022\004\022\0020\0310\0228VX\004¢\006\f\022\004\b\032\020\025\032\004\b\033\020\027¨\006 "}, d2={"Lcom/android/build/gradle/internal/api/dsl/extensions/EmbeddedTestPropertiesImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/extension/EmbeddedTestProperties;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "value", "", "testBuildType", "getTestBuildType", "()Ljava/lang/String;", "setTestBuildType", "(Ljava/lang/String;)V", "testOptions", "Lcom/android/builder/model/TestOptions;", "getTestOptions", "()Lcom/android/builder/model/TestOptions;", "testVariants", "Lorg/gradle/api/DomainObjectSet;", "Lcom/android/build/api/dsl/variant/TestVariant;", "testVariants$annotations", "()V", "getTestVariants", "()Lorg/gradle/api/DomainObjectSet;", "unitTestVariants", "Lcom/android/build/api/dsl/variant/UnitTestVariant;", "unitTestVariants$annotations", "getUnitTestVariants", "seal", "", "action", "Lorg/gradle/api/Action;", "gradle-core"})
/*    */ public final class EmbeddedTestPropertiesImpl
/*    */   extends SealableObject
/*    */   implements EmbeddedTestProperties
/*    */ {
/* 32 */   public EmbeddedTestPropertiesImpl(@NotNull EvalIssueReporter issueReporter) { super(issueReporter); }
/*    */   @Nullable
/* 34 */   public String getTestBuildType() { return testBuildType; } @Nullable
/* 34 */   private String testBuildType = "debug";
/*    */   
/* 36 */   public void setTestBuildType(@Nullable String value) { if (checkSeal())
/* 37 */       testBuildType = value;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public TestOptions getTestOptions() {
/* 42 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/* 45 */   public void testOptions(@NotNull Action<TestOptions> action) { Intrinsics.checkParameterIsNotNull(action, "action");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public DomainObjectSet<TestVariant> getTestVariants() {
/* 50 */     String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str)); }
/*    */   
/*    */   @NotNull
/* 53 */   public DomainObjectSet<UnitTestVariant> getUnitTestVariants() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/* 56 */   public void seal() { super.seal(); }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.extensions.EmbeddedTestPropertiesImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */