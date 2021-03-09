/*    */ package com.android.build.gradle.internal.plugin;
/*    */ 
/*    */ import com.android.build.api.dsl.model.BuildType;
/*    */ import com.android.build.api.dsl.options.SigningConfig;
/*    */ import com.android.build.gradle.internal.api.dsl.extensions.ApkPropertiesImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.extensions.BuildPropertiesImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.extensions.EmbeddedTestPropertiesImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.extensions.OnDeviceTestPropertiesImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.extensions.TestExtensionImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.extensions.VariantAwarePropertiesImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.extensions.VariantOrExtensionPropertiesImpl;
/*    */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*    */ import com.android.build.gradle.internal.variant2.TestVariantFactory;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.collections.CollectionsKt;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ import org.gradle.api.plugins.ExtensionContainer;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000F\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\005¢\006\002\020\003J\020\020\004\032\0020\0052\006\020\006\032\0020\002H\026J8\020\007\032\0020\0022\006\020\b\032\0020\t2\006\020\n\032\0020\0132\006\020\f\032\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\0212\006\020\022\032\0020\023H\026J\016\020\024\032\b\022\004\022\0020\0260\025H\026¨\006\027"}, d2={"Lcom/android/build/gradle/internal/plugin/TestPluginDelegate;", "Lcom/android/build/gradle/internal/plugin/TypedPluginDelegate;", "Lcom/android/build/gradle/internal/api/dsl/extensions/TestExtensionImpl;", "()V", "createDefaults", "", "extension", "createNewExtension", "extensionContainer", "Lorg/gradle/api/plugins/ExtensionContainer;", "buildProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/BuildPropertiesImpl;", "variantExtensionProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;", "variantAwareProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/VariantAwarePropertiesImpl;", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "getVariantFactories", "", "Lcom/android/build/gradle/internal/variant2/TestVariantFactory;", "gradle-core"})
/*    */ public final class TestPluginDelegate
/*    */   implements TypedPluginDelegate<TestExtensionImpl>
/*    */ {
/*    */   @NotNull
/*    */   public List<TestVariantFactory> getVariantFactories()
/*    */   {
/* 35 */     return CollectionsKt.listOf(new TestVariantFactory());
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public TestExtensionImpl createNewExtension(@NotNull ExtensionContainer extensionContainer, @NotNull BuildPropertiesImpl buildProperties, @NotNull VariantOrExtensionPropertiesImpl variantExtensionProperties, @NotNull VariantAwarePropertiesImpl variantAwareProperties, @NotNull DeprecationReporter deprecationReporter, @NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 43 */     Intrinsics.checkParameterIsNotNull(extensionContainer, "extensionContainer");Intrinsics.checkParameterIsNotNull(buildProperties, "buildProperties");Intrinsics.checkParameterIsNotNull(variantExtensionProperties, "variantExtensionProperties");Intrinsics.checkParameterIsNotNull(variantAwareProperties, "variantAwareProperties");Intrinsics.checkParameterIsNotNull(deprecationReporter, "deprecationReporter");Intrinsics.checkParameterIsNotNull(issueReporter, "issueReporter"); Object 
/* 44 */       tmp109_104 = extensionContainer.create(
/* 45 */       "android", 
/* 46 */       TestExtensionImpl.class, new Object[] {
/* 47 */       buildProperties, 
/* 48 */       variantExtensionProperties, 
/* 49 */       variantAwareProperties, 
/* 50 */       new ApkPropertiesImpl(issueReporter), 
/* 51 */       new EmbeddedTestPropertiesImpl(issueReporter), 
/* 52 */       new OnDeviceTestPropertiesImpl(issueReporter), 
/* 53 */       issueReporter });Intrinsics.checkExpressionValueIsNotNull(tmp109_104, "extensionContainer\n     …           issueReporter)");return (TestExtensionImpl)tmp109_104;
/*    */   }
/*    */   
/*    */   public void createDefaults(@NotNull TestExtensionImpl extension)
/*    */   {
/* 57 */     Intrinsics.checkParameterIsNotNull(extension, "extension");((BuildType)extension.getBuildTypes().create("debug"))
/* 58 */       .setSigningConfig((SigningConfig)extension.getSigningConfigs().create("debug"));
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.plugin.TestPluginDelegate
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */