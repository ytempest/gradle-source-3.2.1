package com.android.build.gradle.internal.plugin;

import com.android.build.gradle.internal.api.dsl.extensions.BaseExtension2;
import com.android.build.gradle.internal.api.dsl.extensions.BuildPropertiesImpl;
import com.android.build.gradle.internal.api.dsl.extensions.VariantAwarePropertiesImpl;
import com.android.build.gradle.internal.api.dsl.extensions.VariantOrExtensionPropertiesImpl;
import com.android.build.gradle.internal.errors.DeprecationReporter;
import com.android.build.gradle.internal.variant2.VariantFactory2;
import com.android.builder.errors.EvalIssueReporter;
import java.util.List;
import kotlin.Metadata;
import org.gradle.api.plugins.ExtensionContainer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000H\n\002\030\002\n\000\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020 \n\002\030\002\n\000\bf\030\000*\b\b\000\020\001*\0020\0022\0020\003J\025\020\004\032\0020\0052\006\020\006\032\0028\000H&¢\006\002\020\007J=\020\b\032\0028\0002\006\020\t\032\0020\n2\006\020\013\032\0020\f2\006\020\r\032\0020\0162\006\020\017\032\0020\0202\006\020\021\032\0020\0222\006\020\023\032\0020\024H&¢\006\002\020\025J\024\020\026\032\016\022\n\022\b\022\004\022\0028\0000\0300\027H&¨\006\031"}, d2={"Lcom/android/build/gradle/internal/plugin/TypedPluginDelegate;", "E", "Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;", "", "createDefaults", "", "extension", "(Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;)V", "createNewExtension", "extensionContainer", "Lorg/gradle/api/plugins/ExtensionContainer;", "buildProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/BuildPropertiesImpl;", "variantExtensionProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;", "variantAwareProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/VariantAwarePropertiesImpl;", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lorg/gradle/api/plugins/ExtensionContainer;Lcom/android/build/gradle/internal/api/dsl/extensions/BuildPropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;Lcom/android/build/gradle/internal/api/dsl/extensions/VariantAwarePropertiesImpl;Lcom/android/build/gradle/internal/errors/DeprecationReporter;Lcom/android/builder/errors/EvalIssueReporter;)Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;", "getVariantFactories", "", "Lcom/android/build/gradle/internal/variant2/VariantFactory2;", "gradle-core"})
public abstract interface TypedPluginDelegate<E extends BaseExtension2>
{
  @NotNull
  public abstract List<VariantFactory2<E>> getVariantFactories();
  
  @NotNull
  public abstract E createNewExtension(@NotNull ExtensionContainer paramExtensionContainer, @NotNull BuildPropertiesImpl paramBuildPropertiesImpl, @NotNull VariantOrExtensionPropertiesImpl paramVariantOrExtensionPropertiesImpl, @NotNull VariantAwarePropertiesImpl paramVariantAwarePropertiesImpl, @NotNull DeprecationReporter paramDeprecationReporter, @NotNull EvalIssueReporter paramEvalIssueReporter);
  
  public abstract void createDefaults(@NotNull E paramE);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.plugin.TypedPluginDelegate
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */