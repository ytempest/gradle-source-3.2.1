/*    */ package com.android.build.gradle.internal.variant2;
/*    */ 
/*    */ import com.android.build.api.dsl.model.ProductFlavorOrVariant;
/*    */ import com.android.build.api.dsl.options.InstrumentationOptions;
/*    */ import com.android.build.gradle.internal.api.dsl.extensions.LibraryExtensionImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.extensions.VariantOrExtensionPropertiesImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.model.BuildTypeOrVariantImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.model.ProductFlavorOrVariantImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.model.VariantPropertiesImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.variant.CommonVariantPropertiesImpl;
/*    */ import com.android.build.gradle.internal.api.dsl.variant.SealableVariant;
/*    */ import com.android.builder.core.VariantType;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.collections.CollectionsKt;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000`\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020 \n\002\b\003\n\002\020\016\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\005¢\006\002\020\003J\034\020\016\032\004\030\0010\0172\006\020\020\032\0020\0212\b\020\022\032\004\030\0010\017H\026JH\020\023\032\0020\0242\006\020\025\032\0020\0022\006\020\026\032\0020\0272\006\020\030\032\0020\0312\006\020\032\032\0020\0332\006\020\034\032\0020\0352\006\020\036\032\0020\0372\006\020 \032\0020!2\006\020\"\032\0020#H\026R\024\020\004\032\0020\005X\004¢\006\b\n\000\032\004\b\006\020\007R\026\020\b\032\004\030\0010\005XD¢\006\b\n\000\032\004\b\t\020\007R\032\020\n\032\b\022\004\022\0020\0050\013X\004¢\006\b\n\000\032\004\b\f\020\r¨\006$"}, d2={"Lcom/android/build/gradle/internal/variant2/LibAndroidTestVariantFactory;", "Lcom/android/build/gradle/internal/variant2/VariantFactory2;", "Lcom/android/build/gradle/internal/api/dsl/extensions/LibraryExtensionImpl;", "()V", "generatedType", "Lcom/android/builder/core/VariantType;", "getGeneratedType", "()Lcom/android/builder/core/VariantType;", "testTarget", "getTestTarget", "testedBy", "", "getTestedBy", "()Ljava/util/List;", "computeApplicationId", "", "mergedFlavor", "Lcom/android/build/api/dsl/model/ProductFlavorOrVariant;", "appIdSuffixFromFlavors", "createVariant", "Lcom/android/build/gradle/internal/api/dsl/variant/SealableVariant;", "extension", "variantProperties", "Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;", "productFlavorOrVariant", "Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl;", "buildTypOrVariant", "Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl;", "variantExtensionProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;", "commonVariantProperties", "Lcom/android/build/gradle/internal/api/dsl/variant/CommonVariantPropertiesImpl;", "variantDispatcher", "Lcom/android/build/gradle/internal/variant2/VariantDispatcher;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "gradle-core"})
/*    */ public final class LibAndroidTestVariantFactory
/*    */   implements VariantFactory2<LibraryExtensionImpl>
/*    */ {
/*    */   @NotNull
/*    */   private final VariantType generatedType;
/*    */   @NotNull
/*    */   private final List<VariantType> testedBy;
/*    */   @Nullable
/*    */   private final VariantType testTarget;
/*    */   
/*    */   @NotNull
/* 35 */   public VariantType getGeneratedType() { return generatedType; } @NotNull
/* 36 */   public List<VariantType> getTestedBy() { return testedBy; } @Nullable
/* 37 */   public VariantType getTestTarget() { return testTarget; }
/*    */   
/*    */   public LibAndroidTestVariantFactory()
/*    */   {
/* 35 */     generatedType = VariantType.ANDROID_TEST;
/* 36 */     LibAndroidTestVariantFactory localLibAndroidTestVariantFactory = this;List localList = CollectionsKt.emptyList();testedBy = localList;
/* 37 */     testTarget = VariantType.LIBRARY;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public SealableVariant createVariant(@NotNull LibraryExtensionImpl extension, @NotNull VariantPropertiesImpl variantProperties, @NotNull ProductFlavorOrVariantImpl productFlavorOrVariant, @NotNull BuildTypeOrVariantImpl buildTypOrVariant, @NotNull VariantOrExtensionPropertiesImpl variantExtensionProperties, @NotNull CommonVariantPropertiesImpl commonVariantProperties, @NotNull VariantDispatcher variantDispatcher, @NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 50 */     Intrinsics.checkParameterIsNotNull(extension, "extension");Intrinsics.checkParameterIsNotNull(variantProperties, "variantProperties");Intrinsics.checkParameterIsNotNull(productFlavorOrVariant, "productFlavorOrVariant");Intrinsics.checkParameterIsNotNull(buildTypOrVariant, "buildTypOrVariant");Intrinsics.checkParameterIsNotNull(variantExtensionProperties, "variantExtensionProperties");Intrinsics.checkParameterIsNotNull(commonVariantProperties, "commonVariantProperties");Intrinsics.checkParameterIsNotNull(variantDispatcher, "variantDispatcher");Intrinsics.checkParameterIsNotNull(issueReporter, "issueReporter");return (SealableVariant)new AndroidTestVariantImpl(
/* 51 */       VariantType.ANDROID_TEST, 
/* 52 */       variantProperties, 
/* 53 */       productFlavorOrVariant, 
/* 54 */       buildTypOrVariant, 
/* 55 */       variantExtensionProperties, 
/* 56 */       commonVariantProperties, 
/* 57 */       variantDispatcher, 
/* 58 */       issueReporter);
/*    */   }
/*    */   
/*    */   @Nullable
/* 62 */   public String computeApplicationId(@NotNull ProductFlavorOrVariant mergedFlavor, @Nullable String appIdSuffixFromFlavors) { Intrinsics.checkParameterIsNotNull(mergedFlavor, "mergedFlavor"); if (appIdSuffixFromFlavors != null) {
/* 63 */       return Intrinsics.stringPlus(mergedFlavor.getInstrumentationOptions().getApplicationId(), appIdSuffixFromFlavors);
/*    */     }
/*    */     
/* 66 */     return mergedFlavor.getInstrumentationOptions().getApplicationId();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.LibAndroidTestVariantFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */