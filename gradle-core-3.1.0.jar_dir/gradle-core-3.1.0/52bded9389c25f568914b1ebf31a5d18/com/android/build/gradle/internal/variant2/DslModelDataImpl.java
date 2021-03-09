/*     */ package com.android.build.gradle.internal.variant2;
/*     */ 
/*     */ import com.android.build.api.dsl.model.BuildType;
/*     */ import com.android.build.api.dsl.model.ProductFlavor;
/*     */ import com.android.build.api.dsl.options.SigningConfig;
/*     */ import com.android.build.api.sourcesets.AndroidSourceSet;
/*     */ import com.android.build.gradle.internal.api.dsl.extensions.BaseExtension2;
/*     */ import com.android.build.gradle.internal.api.dsl.model.BuildTypeImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.model.DefaultConfigImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.model.ProductFlavorFactory;
/*     */ import com.android.build.gradle.internal.api.dsl.model.ProductFlavorImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.options.SigningConfigImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.Sealable;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.SealableNamedDomainObjectContainer;
/*     */ import com.android.build.gradle.internal.api.sourcesets.AndroidSourceSetFactory;
/*     */ import com.android.build.gradle.internal.api.sourcesets.DefaultAndroidSourceSet;
/*     */ import com.android.build.gradle.internal.api.sourcesets.FilesProvider;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import com.android.builder.errors.EvalIssueReporter.Type;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.Predicate;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Stream;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Unit;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.NamedDomainObjectContainer;
/*     */ import org.gradle.api.NamedDomainObjectFactory;
/*     */ import org.gradle.api.artifacts.Configuration;
/*     */ import org.gradle.api.artifacts.ConfigurationContainer;
/*     */ import org.gradle.api.artifacts.DependencySet;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.model.ObjectFactory;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000Ø\001\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020%\n\002\020\016\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020$\n\002\b\003\n\002\030\002\n\002\030\002\n\002\b\f\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\n\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\007\030\000*\n\b\000\020\001 \000*\0020\0022\0020\0032\0020\004BY\022\006\020\005\032\0020\006\022\022\020\007\032\016\022\n\022\b\022\004\022\0028\0000\t0\b\022\006\020\n\032\0020\013\022\006\020\f\032\0020\r\022\006\020\016\032\0020\017\022\006\020\020\032\0020\021\022\006\020\022\032\0020\023\022\006\020\024\032\0020\025\022\006\020\026\032\0020\027¢\006\002\020\030J\006\020L\032\0020MJ\030\020N\032\0020,2\006\020O\032\0020\0332\006\020P\032\0020\033H\002J\020\020Q\032\0020M2\006\020R\032\0020\035H\002J\020\020S\032\0020M2\006\020T\032\0020#H\002J \020U\032\0020,2\006\020O\032\0020\0332\006\020P\032\0020\0332\006\020V\032\0020\033H\002J*\020W\032\0020X2\006\020\n\032\0020\0132\006\020O\032\0020\0332\006\020Y\032\0020\0332\b\b\002\020Z\032\0020,H\002J5\020[\032\b\022\004\022\002H\\0\034\"\004\b\001\020\\2\006\020]\032\002H\\2\022\020^\032\016\022\004\022\002H\\\022\004\022\0020\0330_H\002¢\006\002\020`JN\020a\032\016\022\004\022\002Hb\022\004\022\002H\\02\"\004\b\001\020b\"\b\b\002\020\\*\002Hb2\f\020c\032\b\022\004\022\002Hb0d2\f\020e\032\b\022\004\022\002H\\0d2\f\020f\032\b\022\004\022\002H\\0\037H\002J\020\020g\032\0020M2\006\020O\032\0020\033H\002J\020\020h\032\0020M2\006\020i\032\0020)H\002J\b\020j\032\0020MH\026R \020\031\032\024\022\004\022\0020\033\022\n\022\b\022\004\022\0020\0350\0340\032X\004¢\006\002\n\000R\032\020\036\032\b\022\004\022\0020\0350\037X\004¢\006\b\n\000\032\004\b \020!R \020\"\032\024\022\004\022\0020\033\022\n\022\b\022\004\022\0020#0\0340\032X\004¢\006\002\n\000R\032\020$\032\b\022\004\022\0020#0\037X\004¢\006\b\n\000\032\004\b%\020!R\024\020&\032\b\022\004\022\0020'0\037X\004¢\006\002\n\000R\032\020(\032\b\022\004\022\0020)0\037X\004¢\006\b\n\000\032\004\b*\020!R\016\020+\032\0020,X\016¢\006\002\n\000R#\020-\032\024\022\004\022\0020\033\022\n\022\b\022\004\022\0020\0350\0340.8F¢\006\006\032\004\b/\0200R \0201\032\016\022\004\022\00203\022\004\022\0020\03502X\004¢\006\b\n\000\032\004\b4\0205R\016\020\n\032\0020\013X\004¢\006\002\n\000R\024\020\005\032\0020\006X\004¢\006\b\n\000\032\004\b6\0207R\027\0208\032\b\022\004\022\0020\0060\034¢\006\b\n\000\032\004\b9\020:R\016\020\022\032\0020\023X\004¢\006\002\n\000R#\020;\032\024\022\004\022\0020\033\022\n\022\b\022\004\022\0020#0\0340.8F¢\006\006\032\004\b<\0200R\016\020=\032\0020,X\004¢\006\002\n\000R\016\020>\032\0020,X\004¢\006\002\n\000R\016\020\024\032\0020\025X\004¢\006\002\n\000R\016\020\026\032\0020\027X\004¢\006\002\n\000R\016\020?\032\0020@X\004¢\006\002\n\000R \020A\032\016\022\004\022\0020B\022\004\022\0020#02X\004¢\006\b\n\000\032\004\bC\0205R \020D\032\016\022\004\022\0020E\022\004\022\0020'02X\004¢\006\b\n\000\032\004\bF\0205R \020G\032\016\022\004\022\0020H\022\004\022\0020)02X\004¢\006\b\n\000\032\004\bI\0205R \020\007\032\016\022\n\022\b\022\004\022\0028\0000\t0\bX\004¢\006\b\n\000\032\004\bJ\020K¨\006k"}, d2={"Lcom/android/build/gradle/internal/variant2/DslModelDataImpl;", "E", "Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;", "Lcom/android/build/gradle/internal/variant2/DslModelData;", "Lcom/android/build/gradle/internal/api/dsl/sealing/Sealable;", "defaultConfig", "Lcom/android/build/gradle/internal/api/dsl/model/DefaultConfigImpl;", "variantFactories", "", "Lcom/android/build/gradle/internal/variant2/VariantFactory2;", "configurationContainer", "Lorg/gradle/api/artifacts/ConfigurationContainer;", "filesProvider", "Lcom/android/build/gradle/internal/api/sourcesets/FilesProvider;", "containerFactory", "Lcom/android/build/gradle/internal/variant2/ContainerFactory;", "objectFactory", "Lorg/gradle/api/model/ObjectFactory;", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "logger", "Lorg/gradle/api/logging/Logger;", "(Lcom/android/build/gradle/internal/api/dsl/model/DefaultConfigImpl;Ljava/util/List;Lorg/gradle/api/artifacts/ConfigurationContainer;Lcom/android/build/gradle/internal/api/sourcesets/FilesProvider;Lcom/android/build/gradle/internal/variant2/ContainerFactory;Lorg/gradle/api/model/ObjectFactory;Lcom/android/build/gradle/internal/errors/DeprecationReporter;Lcom/android/builder/errors/EvalIssueReporter;Lorg/gradle/api/logging/Logger;)V", "_buildTypeData", "", "", "Lcom/android/build/gradle/internal/variant2/DimensionData;", "Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeImpl;", "_buildTypes", "Lorg/gradle/api/NamedDomainObjectContainer;", "get_buildTypes$gradle_core", "()Lorg/gradle/api/NamedDomainObjectContainer;", "_flavorData", "Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorImpl;", "_productFlavors", "get_productFlavors$gradle_core", "_signingConfigs", "Lcom/android/build/gradle/internal/api/dsl/options/SigningConfigImpl;", "_sourceSets", "Lcom/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet;", "get_sourceSets$gradle_core", "afterEvaluatedComputation", "", "buildTypeData", "", "getBuildTypeData", "()Ljava/util/Map;", "buildTypes", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableNamedDomainObjectContainer;", "Lcom/android/build/api/dsl/model/BuildType;", "getBuildTypes", "()Lcom/android/build/gradle/internal/api/dsl/sealing/SealableNamedDomainObjectContainer;", "getDefaultConfig", "()Lcom/android/build/gradle/internal/api/dsl/model/DefaultConfigImpl;", "defaultConfigData", "getDefaultConfigData", "()Lcom/android/build/gradle/internal/variant2/DimensionData;", "flavorData", "getFlavorData", "hasAndroidTests", "hasUnitTests", "mainVariantType", "Lcom/android/builder/core/VariantType;", "productFlavors", "Lcom/android/build/api/dsl/model/ProductFlavor;", "getProductFlavors", "signingConfigs", "Lcom/android/build/api/dsl/options/SigningConfig;", "getSigningConfigs", "sourceSets", "Lcom/android/build/api/sourcesets/AndroidSourceSet;", "getSourceSets", "getVariantFactories$gradle_core", "()Ljava/util/List;", "afterEvaluateCompute", "", "checkName", "name", "displayName", "checkNewBuildType", "buildType", "checkNewFlavor", "productFlavor", "checkPrefix", "prefix", "createConfiguration", "Lorg/gradle/api/artifacts/Configuration;", "desc", "canBeResolved", "createDimensionData", "T", "data", "nameFun", "Lkotlin/Function1;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lcom/android/build/gradle/internal/variant2/DimensionData;", "createSealableContainer", "I", "interfaceClass", "Ljava/lang/Class;", "itemClass", "container", "createSourceSets", "handleNewSourceSet", "sourceSet", "seal", "gradle-core"})
/*     */ public final class DslModelDataImpl<E extends BaseExtension2>
/*     */   implements DslModelData, Sealable
/*     */ {
/*     */   @NotNull
/*     */   private final NamedDomainObjectContainer<DefaultAndroidSourceSet> _sourceSets;
/*     */   @NotNull
/*     */   private final SealableNamedDomainObjectContainer<AndroidSourceSet, DefaultAndroidSourceSet> sourceSets;
/*     */   @NotNull
/*     */   private final NamedDomainObjectContainer<ProductFlavorImpl> _productFlavors;
/*     */   @NotNull
/*     */   private final SealableNamedDomainObjectContainer<ProductFlavor, ProductFlavorImpl> productFlavors;
/*     */   @NotNull
/*     */   private final NamedDomainObjectContainer<BuildTypeImpl> _buildTypes;
/*     */   @NotNull
/*     */   private final SealableNamedDomainObjectContainer<BuildType, BuildTypeImpl> buildTypes;
/*     */   private final NamedDomainObjectContainer<SigningConfigImpl> _signingConfigs;
/*     */   @NotNull
/*     */   private final SealableNamedDomainObjectContainer<SigningConfig, SigningConfigImpl> signingConfigs;
/*     */   private final Map<String, DimensionData<ProductFlavorImpl>> _flavorData;
/*     */   private final Map<String, DimensionData<BuildTypeImpl>> _buildTypeData;
/*     */   private boolean afterEvaluatedComputation;
/*     */   @NotNull
/*     */   private final DimensionData<DefaultConfigImpl> defaultConfigData;
/*     */   private final VariantType mainVariantType;
/*     */   private final boolean hasAndroidTests;
/*     */   private final boolean hasUnitTests;
/*     */   @NotNull
/*     */   private final DefaultConfigImpl defaultConfig;
/*     */   @NotNull
/*     */   private final List<VariantFactory2<E>> variantFactories;
/*     */   private final ConfigurationContainer configurationContainer;
/*     */   private final DeprecationReporter deprecationReporter;
/*     */   private final EvalIssueReporter issueReporter;
/*     */   private final Logger logger;
/*     */   
/*     */   @NotNull
/*  85 */   public DefaultConfigImpl getDefaultConfig() { return defaultConfig; } @NotNull
/*  86 */   public final List<VariantFactory2<E>> getVariantFactories$gradle_core() { return variantFactories; }
/*     */   
/*     */   @NotNull
/*  96 */   public final NamedDomainObjectContainer<DefaultAndroidSourceSet> get_sourceSets$gradle_core() { return _sourceSets; }
/*     */   
/*     */   @NotNull
/*  99 */   public SealableNamedDomainObjectContainer<AndroidSourceSet, DefaultAndroidSourceSet> getSourceSets() { return sourceSets; }
/*     */   
/*     */   @NotNull
/* 102 */   public final NamedDomainObjectContainer<ProductFlavorImpl> get_productFlavors$gradle_core() { return _productFlavors; }
/*     */   
/*     */   @NotNull
/*     */   public SealableNamedDomainObjectContainer<ProductFlavor, ProductFlavorImpl> getProductFlavors()
/*     */   {
/* 108 */     return productFlavors;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final NamedDomainObjectContainer<BuildTypeImpl> get_buildTypes$gradle_core()
/*     */   {
/* 115 */     return _buildTypes;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public SealableNamedDomainObjectContainer<BuildType, BuildTypeImpl> getBuildTypes()
/*     */   {
/* 121 */     return buildTypes;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public SealableNamedDomainObjectContainer<SigningConfig, SigningConfigImpl> getSigningConfigs()
/*     */   {
/* 138 */     return signingConfigs;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Map<String, DimensionData<ProductFlavorImpl>> getFlavorData()
/*     */   {
/* 151 */     if (!afterEvaluatedComputation) throw ((Throwable)new RuntimeException("Called before afterEvaluateCompute"));
/* 152 */     return _flavorData;
/*     */   }
/*     */   
/*     */   @NotNull
/* 156 */   public final Map<String, DimensionData<BuildTypeImpl>> getBuildTypeData() { if (!afterEvaluatedComputation) throw ((Throwable)new RuntimeException("Called before afterEvaluateCompute"));
/* 157 */     return _buildTypeData; }
/*     */   
/*     */   @NotNull
/* 160 */   public final DimensionData<DefaultConfigImpl> getDefaultConfigData() { return defaultConfigData; }
/*     */   
/*     */   public DslModelDataImpl(@NotNull DefaultConfigImpl defaultConfig, @NotNull List<? extends VariantFactory2<? super E>> variantFactories, @NotNull ConfigurationContainer configurationContainer, @NotNull FilesProvider filesProvider, @NotNull ContainerFactory containerFactory, @NotNull ObjectFactory objectFactory, @NotNull DeprecationReporter deprecationReporter, @NotNull EvalIssueReporter issueReporter, @NotNull Logger logger)
/*     */   {
/*  84 */     this.defaultConfig = defaultConfig;this.variantFactories = variantFactories;this.configurationContainer = configurationContainer;this.deprecationReporter = deprecationReporter;this.issueReporter = issueReporter;this.logger = logger;
/*     */     
/* 103 */     _productFlavors = containerFactory.createContainer(
/* 104 */       ProductFlavorImpl.class, 
/* 105 */       (NamedDomainObjectFactory)new ProductFlavorFactory(objectFactory, this.deprecationReporter, this.issueReporter));
/*     */     
/* 109 */     productFlavors = createSealableContainer(
/* 110 */       ProductFlavor.class, 
/* 111 */       ProductFlavorImpl.class, 
/* 112 */       _productFlavors);
/*     */     
/* 116 */     _buildTypes = containerFactory.createContainer(
/* 117 */       BuildTypeImpl.class, 
/* 118 */       (NamedDomainObjectFactory)new com.android.build.gradle.internal.api.dsl.model.BuildTypeFactory(objectFactory, this.deprecationReporter, this.issueReporter));
/*     */     
/* 122 */     buildTypes = createSealableContainer(
/* 123 */       BuildType.class, 
/* 124 */       BuildTypeImpl.class, 
/* 125 */       _buildTypes);
/*     */     
/* 129 */     _signingConfigs = containerFactory.createContainer(
/* 130 */       SigningConfigImpl.class, 
/* 131 */       (NamedDomainObjectFactory)new com.android.build.gradle.internal.api.dsl.options.SigningConfigFactory(
/* 132 */       objectFactory, 
/* 133 */       this.deprecationReporter, 
/* 134 */       this.issueReporter, 
/* 135 */       com.android.build.gradle.internal.packaging.GradleKeystoreHelper.getDefaultDebugKeystoreLocation()));
/*     */     
/* 139 */     signingConfigs = createSealableContainer(
/* 140 */       SigningConfig.class, 
/* 141 */       SigningConfigImpl.class, 
/* 142 */       _signingConfigs);
/*     */     
/* 144 */     Object localObject1 = this;Object localObject2 = (Map)new LinkedHashMap();_flavorData = ((Map)localObject2);
/* 145 */     localObject1 = this;localObject2 = (Map)new LinkedHashMap();_buildTypeData = ((Map)localObject2);
/*     */     
/* 168 */     Iterable $receiver$iv = (Iterable)this.variantFactories;
/*     */     
/*     */     int $i$f$map;
/*     */     
/* 538 */     Iterable localIterable1 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 539 */     int $i$f$mapTo; Object $receiver$iv$iv; for (Iterator localIterator = ((Iterable)$receiver$iv$iv).iterator(); localIterator.hasNext(); ((Collection)localObject1).add(localObject2))
/*     */     {
/* 539 */       Object item$iv$iv = localIterator.next();
/* 540 */       VariantFactory2 localVariantFactory21 = (VariantFactory2)item$iv$iv;localObject1 = destination$iv$iv;
/*     */       int $i$a$1$map;
/*     */       VariantFactory2 it;
/* 168 */       localObject2 = it.getGeneratedType(); } List variantTypes = 
/*     */     
/* 541 */       (List)destination$iv$iv; Object tmp441_438 = variantTypes.stream().filter((Predicate)1.INSTANCE).reduce(DslModelDataKt.access$toSingleItem()).orElseThrow((Supplier)2.INSTANCE);Intrinsics.checkExpressionValueIsNotNull(tmp441_438, "variantTypes\n           …\"No main variant type\") }");mainVariantType = ((VariantType)tmp441_438);_sourceSets = containerFactory.createContainer(DefaultAndroidSourceSet.class, (NamedDomainObjectFactory)new AndroidSourceSetFactory(filesProvider, Intrinsics.areEqual(mainVariantType, VariantType.LIBRARY), objectFactory, this.deprecationReporter, this.issueReporter));sourceSets = createSealableContainer(AndroidSourceSet.class, DefaultAndroidSourceSet.class, _sourceSets);hasAndroidTests = variantTypes.contains(VariantType.ANDROID_TEST);hasUnitTests = variantTypes.contains(VariantType.UNIT_TEST);_productFlavors.whenObjectAdded((Action)new Action() { public final void execute(ProductFlavorImpl it) { ProductFlavorImpl tmp5_4 = it;Intrinsics.checkExpressionValueIsNotNull(tmp5_4, "it");DslModelDataImpl.access$checkNewFlavor(this$0, tmp5_4); } });
/* 194 */     _buildTypes.whenObjectAdded((Action)new Action() { public final void execute(BuildTypeImpl it) { BuildTypeImpl tmp5_4 = it;Intrinsics.checkExpressionValueIsNotNull(tmp5_4, "it");DslModelDataImpl.access$checkNewBuildType(this$0, tmp5_4); } });
/* 195 */     _sourceSets.whenObjectAdded((Action)new Action() { public final void execute(DefaultAndroidSourceSet it) { DefaultAndroidSourceSet tmp5_4 = it;Intrinsics.checkExpressionValueIsNotNull(tmp5_4, "it");DslModelDataImpl.access$handleNewSourceSet(this$0, tmp5_4);
/*     */       }
/* 197 */     });
/* 198 */     Function1 lambda = (Function1)lambda.1.INSTANCE; Function1 
/* 199 */       tmp622_620 = lambda;
/* 199 */     if (tmp622_620 != null) $receiver$iv$iv = tmp622_620; _sourceSets.whenObjectRemoved((Action)new DslModelDataKt.sam.Action.1412e668((Function1)$receiver$iv$iv)); Function1 
/* 200 */       tmp652_650 = lambda;
/* 200 */     if (tmp652_650 != null) $receiver$iv$iv = tmp652_650; _signingConfigs.whenObjectRemoved((Action)new DslModelDataKt.sam.Action.1412e668((Function1)$receiver$iv$iv)); Function1 
/* 201 */       tmp682_680 = lambda;
/* 201 */     if (tmp682_680 != null) $receiver$iv$iv = tmp682_680; _buildTypes.whenObjectRemoved((Action)new DslModelDataKt.sam.Action.1412e668((Function1)$receiver$iv$iv)); Function1 
/* 202 */       tmp712_710 = lambda;
/* 202 */     if (tmp712_710 != null) $receiver$iv$iv = tmp712_710; _productFlavors.whenObjectRemoved((Action)new DslModelDataKt.sam.Action.1412e668((Function1)$receiver$iv$iv));
/*     */     
/* 205 */     createSourceSets("main");
/* 206 */     defaultConfigData = createDimensionData(getDefaultConfig(), (Function1)6.INSTANCE);
/*     */   }
/*     */   
/*     */   public final void afterEvaluateCompute()
/*     */   {
/* 214 */     Iterable $receiver$iv = (Iterable)_productFlavors;
/*     */     
/*     */     int $i$f$forEach;
/*     */     
/*     */     Map localMap;
/*     */     
/*     */     String str;
/*     */     
/*     */     DimensionData localDimensionData;
/*     */     
/* 528 */     for (Iterator localIterator = $receiver$iv.iterator(); localIterator.hasNext(); localMap.put(str, localDimensionData))
/*     */     {
/* 528 */       Object element$iv = localIterator.next();ProductFlavorImpl flavor = (ProductFlavorImpl)element$iv;
/*     */       int $i$a$1$forEach;
/* 215 */       localMap = _flavorData; ProductFlavorImpl tmp45_43 = flavor;Intrinsics.checkExpressionValueIsNotNull(tmp45_43, "flavor");str = tmp45_43.getName();localDimensionData = createDimensionData(flavor, (Function1)DslModelDataImpl.afterEvaluateCompute.1.1.INSTANCE);
/*     */     }
/*     */     
/* 218 */     Iterable $receiver$iv = (Iterable)_buildTypes;
/*     */     
/*     */     int $i$f$forEach;
/*     */     
/* 530 */     for (localIterator = $receiver$iv.iterator(); localIterator.hasNext(); localMap.put(str, localDimensionData))
/*     */     {
/* 530 */       Object element$iv = localIterator.next();BuildTypeImpl buildType = (BuildTypeImpl)element$iv;
/*     */       int $i$a$2$forEach;
/* 219 */       localMap = _buildTypeData; BuildTypeImpl tmp132_130 = buildType;Intrinsics.checkExpressionValueIsNotNull(tmp132_130, "buildType");str = tmp132_130.getName();localDimensionData = createDimensionData(buildType, (Function1)DslModelDataImpl.afterEvaluateCompute.2.1.INSTANCE);
/*     */     }
/*     */     
/* 222 */     afterEvaluatedComputation = true;
/*     */   }
/*     */   
/*     */   public void seal() {
/* 226 */     getDefaultConfig().seal();
/* 227 */     getSourceSets().seal();
/* 228 */     getProductFlavors().seal();
/* 229 */     getSigningConfigs().seal();
/*     */   }
/*     */   
/*     */   private final <I, T extends I> SealableNamedDomainObjectContainer<I, T> createSealableContainer(Class<I> interfaceClass, Class<T> itemClass, NamedDomainObjectContainer<T> container)
/*     */   {
/* 237 */     return new SealableNamedDomainObjectContainer(container, itemClass, issueReporter);
/*     */   }
/*     */   
/*     */   private final <T> DimensionData<T> createDimensionData(T data, Function1<? super T, String> nameFun) {
/* 241 */     String name = (String)nameFun.invoke(data);
/*     */     
/* 243 */     return new DimensionData(
/* 244 */       data, 
/* 245 */       (AndroidSourceSet)getSourceSets().getByName(name), 
/* 246 */       (AndroidSourceSet)getSourceSets().findByName(DslModelDataKt.access$computeSourceSetName(name, VariantType.ANDROID_TEST)), 
/* 247 */       (AndroidSourceSet)getSourceSets().findByName(DslModelDataKt.access$computeSourceSetName(name, VariantType.UNIT_TEST)), 
/* 248 */       configurationContainer);
/*     */   }
/*     */   
/*     */   private final void checkNewFlavor(ProductFlavorImpl productFlavor)
/*     */   {
/* 257 */     String name = productFlavor.getName();
/*     */     
/* 259 */     if (!checkName(name, "ProductFlavor"))
/*     */     {
/* 261 */       return;
/*     */     }
/*     */     
/* 264 */     Iterable $receiver$iv = (Iterable)_buildTypes;
/*     */     
/*     */     int $i$f$any;
/*     */     
/* 533 */     for (Iterator localIterator = $receiver$iv.iterator(); localIterator.hasNext(); Intrinsics.checkExpressionValueIsNotNull(tmp83_81, "it"))
/*     */     {
/* 533 */       Object element$iv = localIterator.next();BuildTypeImpl it = (BuildTypeImpl)element$iv;
/* 534 */       int $i$a$1$any; } if ((Intrinsics.areEqual(tmp83_81.getName(), name) ? 1 : (($receiver$iv instanceof Collection)) && (((Collection)$receiver$iv).isEmpty()) ? 0 : 0) != 0)
/*     */     {
/* 265 */       issueReporter.reportError(EvalIssueReporter.Type.GENERIC, 
/* 266 */         "ProductFlavor names cannot collide with BuildType names: " + name);
/*     */       
/* 269 */       return;
/*     */     }
/*     */     
/* 273 */     createSourceSets(name);
/*     */   }
/*     */   
/*     */   private final void checkNewBuildType(BuildTypeImpl buildType)
/*     */   {
/* 282 */     String name = buildType.getName();
/*     */     
/* 284 */     if (!checkName(name, "BuildType"))
/*     */     {
/* 286 */       return;
/*     */     }
/*     */     
/* 289 */     Iterable $receiver$iv = (Iterable)_productFlavors;
/*     */     
/*     */     int $i$f$any;
/*     */     
/* 536 */     for (Iterator localIterator = $receiver$iv.iterator(); localIterator.hasNext(); Intrinsics.checkExpressionValueIsNotNull(tmp84_82, "it"))
/*     */     {
/* 536 */       Object element$iv = localIterator.next();ProductFlavorImpl it = (ProductFlavorImpl)element$iv;
/* 537 */       int $i$a$1$any; } if ((Intrinsics.areEqual(tmp84_82.getName(), name) ? 1 : (($receiver$iv instanceof Collection)) && (((Collection)$receiver$iv).isEmpty()) ? 0 : 0) != 0)
/*     */     {
/* 290 */       issueReporter.reportError(EvalIssueReporter.Type.GENERIC, 
/* 291 */         "BuildType names cannot collide with ProductFlavor names: " + name);
/*     */       
/* 294 */       return;
/*     */     }
/*     */     
/* 298 */     createSourceSets(name);
/*     */   }
/*     */   
/*     */   private final void createSourceSets(String name)
/*     */   {
/* 305 */     _sourceSets.maybeCreate(name);
/*     */     
/* 307 */     if (hasAndroidTests) {
/* 308 */       _sourceSets.maybeCreate(DslModelDataKt.access$computeSourceSetName(name, VariantType.ANDROID_TEST));
/*     */     }
/*     */     
/* 311 */     if (hasUnitTests) {
/* 312 */       _sourceSets.maybeCreate(DslModelDataKt.access$computeSourceSetName(name, VariantType.UNIT_TEST));
/*     */     }
/*     */   }
/*     */   
/*     */   private final void handleNewSourceSet(DefaultAndroidSourceSet sourceSet)
/*     */   {
/* 321 */     sourceSet.setRoot("src/" + sourceSet.getName());
/*     */     
/* 324 */     String implementationName = sourceSet.getImplementationConfigurationName();
/* 325 */     String runtimeOnlyName = sourceSet.getRuntimeOnlyConfigurationName();
/* 326 */     String compileOnlyName = sourceSet.getCompileOnlyConfigurationName();
/*     */     
/* 329 */     String compileName = sourceSet.get_compileConfigurationName$gradle_core();
/*     */     
/* 333 */     Configuration compile = createConfiguration(
/* 334 */       configurationContainer, 
/* 335 */       compileName, 
/* 336 */       "Compile dependencies for '" + sourceSet.getName() + "' sources (deprecated: use '" + implementationName + "' instead).", 
/* 337 */       (Intrinsics.areEqual("compile", compileName)) || (Intrinsics.areEqual("testCompile", compileName)));
/* 338 */     compile.getAllDependencies()
/* 339 */       .whenObjectAdded(
/* 340 */       (Action)new DeprecatedConfigurationAction(implementationName, compileName, deprecationReporter, null, 8, null));
/*     */     
/* 342 */     String packageConfigDescription = 
/*     */     
/* 345 */       "Apk dependencies for '" + sourceSet.getName() + "' sources (deprecated: use '" + runtimeOnlyName + "' instead).";
/*     */     
/* 348 */     String apkName = sourceSet.get_packageConfigurationName$gradle_core();
/* 349 */     Configuration apk = createConfiguration$default(this, 
/* 350 */       configurationContainer, apkName, packageConfigDescription, false, 8, null);
/* 351 */     apk.getAllDependencies()
/* 352 */       .whenObjectAdded(
/* 353 */       (Action)new DeprecatedConfigurationAction(
/* 354 */       runtimeOnlyName, apkName, deprecationReporter, null, 8, null));
/*     */     
/* 356 */     String providedName = sourceSet.get_providedConfigurationName$gradle_core();
/* 357 */     Configuration provided = createConfiguration$default(this, 
/* 358 */       configurationContainer, 
/* 359 */       providedName, 
/* 360 */       "Provided dependencies for '" + sourceSet.getName() + "' sources (deprecated: use '" + compileOnlyName + "' instead).", false, 8, null);
/* 361 */     provided.getAllDependencies()
/* 362 */       .whenObjectAdded(
/* 363 */       (Action)new DeprecatedConfigurationAction(
/* 364 */       compileOnlyName, providedName, deprecationReporter, null, 8, null));
/*     */     
/* 367 */     String apiName = sourceSet.getApiConfigurationName();
/* 368 */     Configuration api = createConfiguration$default(this, 
/* 369 */       configurationContainer, apiName, "API dependencies for '" + sourceSet.getName() + "' sources.", false, 8, null);
/* 370 */     api.extendsFrom(new Configuration[] { compile });
/*     */     
/* 372 */     Configuration implementation = createConfiguration$default(this, 
/* 373 */       configurationContainer, 
/* 374 */       implementationName, 
/* 375 */       "Implementation Only dependencies for '" + sourceSet.getName() + "' sources.", false, 8, null);
/* 376 */     implementation.extendsFrom(new Configuration[] { api });
/*     */     
/* 378 */     Configuration runtimeOnly = createConfiguration$default(this, 
/* 379 */       configurationContainer, 
/* 380 */       runtimeOnlyName, 
/* 381 */       "Runtime Only dependencies for '" + sourceSet.getName() + "' sources.", false, 8, null);
/* 382 */     runtimeOnly.extendsFrom(new Configuration[] { apk });
/*     */     
/* 384 */     Configuration compileOnly = createConfiguration$default(this, 
/* 385 */       configurationContainer, 
/* 386 */       compileOnlyName, 
/* 387 */       "Compile Only dependencies for '" + sourceSet.getName() + "' sources.", false, 8, null);
/* 388 */     compileOnly.extendsFrom(new Configuration[] { provided });
/*     */     
/* 391 */     createConfiguration$default(this, 
/* 392 */       configurationContainer, 
/* 393 */       sourceSet.getWearAppConfigurationName(), 
/* 394 */       "Link to a wear app to embed for object '" + 
/* 395 */       sourceSet.getName() + "'.", false, 8, null);
/*     */     
/* 398 */     createConfiguration$default(this, 
/* 399 */       configurationContainer, 
/* 400 */       sourceSet.getAnnotationProcessorConfigurationName(), 
/* 401 */       "Classpath for the annotation processor for '" + 
/* 402 */       sourceSet.getName() + "'.", false, 8, null);
/*     */   }
/*     */   
/*     */   private final Configuration createConfiguration(ConfigurationContainer configurationContainer, String name, String desc, boolean canBeResolved)
/*     */   {
/* 422 */     logger.debug("Creating configuration {}", name);
/*     */     
/* 424 */     Configuration configuration = (Configuration)configurationContainer.maybeCreate(name);
/*     */     
/* 426 */     Configuration $receiver = configuration;
/* 427 */     int $i$a$1$with; $receiver.setVisible(false);
/* 428 */     $receiver.setDescription(desc);
/* 429 */     $receiver.setCanBeConsumed(false);
/* 430 */     $receiver.setCanBeResolved(canBeResolved); Configuration 
/*     */     
/* 433 */       tmp68_66 = configuration;Intrinsics.checkExpressionValueIsNotNull(tmp68_66, "configuration");return tmp68_66;
/*     */   }
/*     */   
/*     */   private final boolean checkName(String name, String displayName) {
/* 437 */     String tmp9_6 = VariantType.ANDROID_TEST.getPrefix();Intrinsics.checkExpressionValueIsNotNull(tmp9_6, "VariantType.ANDROID_TEST.prefix"); if (!checkPrefix(name, displayName, tmp9_6)) {
/* 438 */       return false;
/*     */     }
/* 440 */     String tmp33_30 = VariantType.UNIT_TEST.getPrefix();Intrinsics.checkExpressionValueIsNotNull(tmp33_30, "VariantType.UNIT_TEST.prefix"); if (!checkPrefix(name, displayName, tmp33_30)) {
/* 441 */       return false;
/*     */     }
/*     */     
/* 444 */     if (Intrinsics.areEqual("main", name)) {
/* 445 */       issueReporter.reportError(EvalIssueReporter.Type.GENERIC, 
/* 446 */         "" + displayName + " names cannot be 'main'");
/* 447 */       return false;
/*     */     }
/*     */     
/* 450 */     if (Intrinsics.areEqual("lint", name)) {
/* 451 */       issueReporter.reportError(EvalIssueReporter.Type.GENERIC, 
/* 452 */         "" + displayName + " names cannot be 'lint'");
/* 453 */       return false;
/*     */     }
/*     */     
/* 456 */     return true;
/*     */   }
/*     */   
/*     */   private final boolean checkPrefix(String name, String displayName, String prefix) {
/* 460 */     if (kotlin.text.StringsKt.startsWith$default(name, prefix, false, 2, null)) {
/* 461 */       issueReporter.reportError(EvalIssueReporter.Type.GENERIC, 
/* 462 */         "" + displayName + " names cannot start with '" + prefix + '\'');
/* 463 */       return false;
/*     */     }
/*     */     
/* 466 */     return true;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.DslModelDataImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */