/*    */ package com.android.build.gradle.internal.variant2;
/*    */ 
/*    */ import com.android.build.api.dsl.variant.VariantFilter;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*    */ import com.android.builder.core.VariantType;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.util.List;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0008\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020 \n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\n\n\002\020\002\n\002\b\005\n\002\030\002\n\000\030\0002\0020\0012\0020\002B#\022\006\020\003\032\0020\004\022\f\020\005\032\b\022\004\022\0020\0040\006\022\006\020\007\032\0020\b¢\006\002\020\tJ\b\020\025\032\0020\026H\026J\b\020\027\032\0020\026H\026J\b\020\030\032\0020\026H\026J\b\020\031\032\0020\026H\026J\016\020\032\032\0020\0132\006\020\033\032\0020\034R\016\020\n\032\0020\013X\016¢\006\002\n\000R\016\020\f\032\0020\013X\016¢\006\002\n\000R\016\020\r\032\0020\013X\016¢\006\002\n\000R\024\020\003\032\0020\004X\004¢\006\b\n\000\032\004\b\016\020\017R\032\020\005\032\b\022\004\022\0020\0040\006X\004¢\006\b\n\000\032\004\b\020\020\021R\021\020\022\032\0020\0138F¢\006\006\032\004\b\023\020\024¨\006\035"}, d2={"Lcom/android/build/gradle/internal/variant2/VariantFilterImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/variant/VariantFilter;", "buildType", "", "flavors", "", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Ljava/lang/String;Ljava/util/List;Lcom/android/builder/errors/EvalIssueReporter;)V", "_ignoresAndroidTest", "", "_ignoresProd", "_ignoresUnitTest", "getBuildType", "()Ljava/lang/String;", "getFlavors", "()Ljava/util/List;", "ignoresAll", "getIgnoresAll", "()Z", "ignoreAll", "", "ignoreAndroidTests", "ignoreTests", "ignoreUnitTests", "ignores", "type", "Lcom/android/builder/core/VariantType;", "gradle-core"})
/*    */ public final class VariantFilterImpl
/*    */   extends SealableObject
/*    */   implements VariantFilter
/*    */ {
/*    */   private boolean _ignoresProd;
/*    */   private boolean _ignoresAndroidTest;
/*    */   private boolean _ignoresUnitTest;
/*    */   @NotNull
/*    */   private final String buildType;
/*    */   @NotNull
/*    */   private final List<String> flavors;
/*    */   
/*    */   @NotNull
/* 25 */   public String getBuildType() { return buildType; } @NotNull
/* 26 */   public List<String> getFlavors() { return flavors; }
/* 27 */   public VariantFilterImpl(@NotNull String buildType, @NotNull List<String> flavors, @NotNull EvalIssueReporter issueReporter) { super(issueReporter);this.buildType = buildType;this.flavors = flavors;
/*    */   }
/*    */   
/*    */   public void ignoreAll()
/*    */   {
/* 33 */     if (checkSeal()) {
/* 34 */       _ignoresProd = true;
/* 35 */       _ignoresAndroidTest = true;
/* 36 */       _ignoresUnitTest = true;
/*    */     }
/*    */   }
/*    */   
/*    */   public void ignoreTests() {
/* 41 */     if (checkSeal()) {
/* 42 */       _ignoresAndroidTest = true;
/* 43 */       _ignoresUnitTest = true;
/*    */     }
/*    */   }
/*    */   
/*    */   public void ignoreUnitTests() {
/* 48 */     if (checkSeal()) {
/* 49 */       _ignoresUnitTest = true;
/*    */     }
/*    */   }
/*    */   
/*    */   public void ignoreAndroidTests() {
/* 54 */     if (checkSeal())
/* 55 */       _ignoresAndroidTest = true;
/*    */   }
/*    */   
/*    */   public final boolean ignores(@NotNull VariantType type) {
/* 59 */     Intrinsics.checkParameterIsNotNull(type, "type"); switch (VariantFilterImpl.WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
/*    */     case 1: 
/*    */       break;
/*    */     case 2:  break; }
/* 63 */     return _ignoresProd;
/*    */   }
/*    */   
/* 66 */   public final boolean getIgnoresAll() { return (_ignoresProd) && (_ignoresAndroidTest) && (_ignoresUnitTest); }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.VariantFilterImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */