/*    */ package com.android.build.gradle.internal.plugin;
/*    */ 
/*    */ import com.android.build.api.dsl.model.BuildType;
/*    */ import com.android.build.api.dsl.options.SigningConfig;
/*    */ import com.android.build.gradle.internal.api.dsl.extensions.BuildPropertiesImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.extensions.EmbeddedTestPropertiesImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.extensions.LibraryExtensionImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.extensions.OnDeviceTestPropertiesImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.extensions.VariantAwarePropertiesImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.extensions.VariantOrExtensionPropertiesImpl;
/*    */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*    */ import com.android.build.gradle.internal.variant2.LibAndroidTestVariantFactory;
/*    */ import com.android.build.gradle.internal.variant2.LibUnitTestVariantFactory;
/*    */ import com.android.build.gradle.internal.variant2.LibraryVariantFactory;
/*    */ import com.android.build.gradle.internal.variant2.VariantFactory2;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.collections.CollectionsKt;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ import org.gradle.api.plugins.ExtensionContainer;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000F\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\005¢\006\002\020\003J\020\020\004\032\0020\0052\006\020\006\032\0020\002H\026J8\020\007\032\0020\0022\006\020\b\032\0020\t2\006\020\n\032\0020\0132\006\020\f\032\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\0212\006\020\022\032\0020\023H\026J\024\020\024\032\016\022\n\022\b\022\004\022\0020\0020\0260\025H\026¨\006\027"}, d2={"Lcom/android/build/gradle/internal/plugin/LibPluginDelegate;", "Lcom/android/build/gradle/internal/plugin/TypedPluginDelegate;", "Lcom/android/build/gradle/internal/api/dsl/extensions/LibraryExtensionImpl;", "()V", "createDefaults", "", "extension", "createNewExtension", "extensionContainer", "Lorg/gradle/api/plugins/ExtensionContainer;", "buildProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/BuildPropertiesImpl;", "variantExtensionProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;", "variantAwareProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/VariantAwarePropertiesImpl;", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "getVariantFactories", "", "Lcom/android/build/gradle/internal/variant2/VariantFactory2;", "gradle-core"})
/*    */ public final class LibPluginDelegate
/*    */   implements TypedPluginDelegate<LibraryExtensionImpl>
/*    */ {
/*    */   @NotNull
/*    */   public List<VariantFactory2<LibraryExtensionImpl>> getVariantFactories()
/*    */   {
/* 38 */     return CollectionsKt.listOf(new VariantFactory2[] {(VariantFactory2)new LibraryVariantFactory(), (VariantFactory2)new LibAndroidTestVariantFactory(), (VariantFactory2)new LibUnitTestVariantFactory() });
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public LibraryExtensionImpl createNewExtension(@NotNull ExtensionContainer extensionContainer, @NotNull BuildPropertiesImpl buildProperties, @NotNull VariantOrExtensionPropertiesImpl variantExtensionProperties, @NotNull VariantAwarePropertiesImpl variantAwareProperties, @NotNull DeprecationReporter deprecationReporter, @NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 47 */     Intrinsics.checkParameterIsNotNull(extensionContainer, "extensionContainer");Intrinsics.checkParameterIsNotNull(buildProperties, "buildProperties");Intrinsics.checkParameterIsNotNull(variantExtensionProperties, "variantExtensionProperties");Intrinsics.checkParameterIsNotNull(variantAwareProperties, "variantAwareProperties");Intrinsics.checkParameterIsNotNull(deprecationReporter, "deprecationReporter");Intrinsics.checkParameterIsNotNull(issueReporter, "issueReporter"); Object 
/* 48 */       tmp96_91 = extensionContainer.create(
/* 49 */       "android", 
/* 50 */       LibraryExtensionImpl.class, new Object[] {
/* 51 */       buildProperties, 
/* 52 */       variantExtensionProperties, 
/* 53 */       variantAwareProperties, 
/* 54 */       new EmbeddedTestPropertiesImpl(issueReporter), 
/* 55 */       new OnDeviceTestPropertiesImpl(issueReporter), 
/* 56 */       issueReporter });Intrinsics.checkExpressionValueIsNotNull(tmp96_91, "extensionContainer\n     …           issueReporter)");return (LibraryExtensionImpl)tmp96_91;
/*    */   }
/*    */   
/*    */   public void createDefaults(@NotNull LibraryExtensionImpl extension)
/*    */   {
/* 60 */     Intrinsics.checkParameterIsNotNull(extension, "extension");SigningConfig signingConfig = (SigningConfig)extension.getSigningConfigs().create("debug");
/* 61 */     BuildType debug = (BuildType)extension.getBuildTypes().create("debug");
/* 62 */     debug.setSigningConfig(signingConfig);
/* 63 */     debug.setDebuggable(true);
/* 64 */     debug.setJniDebuggable(true);
/* 65 */     debug.setRenderscriptDebuggable(true);
/* 66 */     debug.setEmbedMicroApp(false);
/* 67 */     debug.setCrunchPngs(false);
/*    */     
/* 69 */     extension.getBuildTypes().create("release");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.plugin.LibPluginDelegate
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */