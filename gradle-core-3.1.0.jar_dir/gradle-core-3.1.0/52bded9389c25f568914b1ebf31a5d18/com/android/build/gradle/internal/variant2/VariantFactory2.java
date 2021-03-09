package com.android.build.gradle.internal.variant2;

import com.android.build.api.dsl.model.ProductFlavorOrVariant;
import com.android.build.gradle.internal.api.dsl.extensions.BaseExtension2;
import com.android.build.gradle.internal.api.dsl.extensions.VariantOrExtensionPropertiesImpl;
import com.android.build.gradle.internal.api.dsl.model.BuildTypeOrVariantImpl;
import com.android.build.gradle.internal.api.dsl.model.ProductFlavorOrVariantImpl;
import com.android.build.gradle.internal.api.dsl.model.VariantPropertiesImpl;
import com.android.build.gradle.internal.api.dsl.variant.CommonVariantPropertiesImpl;
import com.android.build.gradle.internal.api.dsl.variant.SealableVariant;
import com.android.builder.core.VariantType;
import com.android.builder.errors.EvalIssueReporter;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000b\n\002\030\002\n\000\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\005\n\002\020 \n\002\b\003\n\002\020\016\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\bf\030\000*\n\b\000\020\001 \000*\0020\0022\0020\003J\034\020\016\032\004\030\0010\0172\006\020\020\032\0020\0212\b\020\022\032\004\030\0010\017H&JM\020\023\032\0020\0242\006\020\025\032\0028\0002\006\020\026\032\0020\0272\006\020\030\032\0020\0312\006\020\032\032\0020\0332\006\020\034\032\0020\0352\006\020\036\032\0020\0372\006\020 \032\0020!2\006\020\"\032\0020#H&¢\006\002\020$R\022\020\004\032\0020\005X¦\004¢\006\006\032\004\b\006\020\007R\024\020\b\032\004\030\0010\005X¦\004¢\006\006\032\004\b\t\020\007R\030\020\n\032\b\022\004\022\0020\0050\013X¦\004¢\006\006\032\004\b\f\020\r¨\006%"}, d2={"Lcom/android/build/gradle/internal/variant2/VariantFactory2;", "E", "Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;", "", "generatedType", "Lcom/android/builder/core/VariantType;", "getGeneratedType", "()Lcom/android/builder/core/VariantType;", "testTarget", "getTestTarget", "testedBy", "", "getTestedBy", "()Ljava/util/List;", "computeApplicationId", "", "mergedFlavor", "Lcom/android/build/api/dsl/model/ProductFlavorOrVariant;", "appIdSuffixFromFlavors", "createVariant", "Lcom/android/build/gradle/internal/api/dsl/variant/SealableVariant;", "extension", "variantProperties", "Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;", "productFlavorOrVariant", "Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl;", "buildTypOrVariant", "Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl;", "variantExtensionProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;", "commonVariantProperties", "Lcom/android/build/gradle/internal/api/dsl/variant/CommonVariantPropertiesImpl;", "variantDispatcher", "Lcom/android/build/gradle/internal/variant2/VariantDispatcher;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl;Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl;Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/variant/CommonVariantPropertiesImpl;Lcom/android/build/gradle/internal/variant2/VariantDispatcher;Lcom/android/builder/errors/EvalIssueReporter;)Lcom/android/build/gradle/internal/api/dsl/variant/SealableVariant;", "gradle-core"})
public abstract interface VariantFactory2<E extends BaseExtension2>
{
  @NotNull
  public abstract VariantType getGeneratedType();
  
  @NotNull
  public abstract List<VariantType> getTestedBy();
  
  @Nullable
  public abstract VariantType getTestTarget();
  
  @NotNull
  public abstract SealableVariant createVariant(@NotNull E paramE, @NotNull VariantPropertiesImpl paramVariantPropertiesImpl, @NotNull ProductFlavorOrVariantImpl paramProductFlavorOrVariantImpl, @NotNull BuildTypeOrVariantImpl paramBuildTypeOrVariantImpl, @NotNull VariantOrExtensionPropertiesImpl paramVariantOrExtensionPropertiesImpl, @NotNull CommonVariantPropertiesImpl paramCommonVariantPropertiesImpl, @NotNull VariantDispatcher paramVariantDispatcher, @NotNull EvalIssueReporter paramEvalIssueReporter);
  
  @Nullable
  public abstract String computeApplicationId(@NotNull ProductFlavorOrVariant paramProductFlavorOrVariant, @Nullable String paramString);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.VariantFactory2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */