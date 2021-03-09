/*     */ package com.android.build.gradle.internal.variant2;
/*     */ 
/*     */ import com.android.build.api.dsl.model.BuildTypeOrProductFlavor;
/*     */ import com.android.build.api.dsl.model.ProductFlavorOrVariant;
/*     */ import com.android.build.api.dsl.model.VariantProperties;
/*     */ import com.android.build.api.dsl.variant.Variant;
/*     */ import com.android.build.gradle.internal.api.dsl.extensions.BaseExtension2;
/*     */ import com.android.build.gradle.internal.api.dsl.extensions.VariantOrExtensionPropertiesImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.model.BuildTypeImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.model.BuildTypeOrVariantImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.model.ProductFlavorImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.model.ProductFlavorOrVariantImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.model.VariantPropertiesImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.variant.SealableVariant;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import com.android.builder.errors.EvalIssueReporter.Type;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.IdentityHashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.gradle.api.NamedDomainObjectContainer;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\001\n\002\030\002\n\000\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020%\n\002\030\002\n\000\n\002\020!\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\036\n\002\b\003\n\002\020 \n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\030\000*\n\b\000\020\001 \000*\0020\0022\0020\003B+\022\f\020\004\032\b\022\004\022\0028\0000\005\022\006\020\006\032\0028\000\022\006\020\007\032\0020\b\022\006\020\t\032\0020\n¢\006\002\020\013J\020\020\035\032\0020\0362\006\020\037\032\0020 H\002J\020\020\035\032\0020\0362\006\020\037\032\0020\036H\002J\020\020!\032\0020\"2\006\020\037\032\0020\"H\002J\020\020#\032\0020$2\006\020\037\032\0020$H\002J\020\020%\032\0020&2\006\020\037\032\0020&H\002J*\020'\032\0020(2\006\020)\032\0020*2\006\020+\032\0020,2\b\020-\032\004\030\0010.2\006\020/\032\0020 H\002J\016\0200\032\b\022\004\022\0020.0\032H\002J\032\0201\032\002022\006\020/\032\0020 2\b\020-\032\004\030\0010.H\002J\006\0203\032\00202J\026\0204\032\0020\"2\f\0205\032\b\022\004\022\002060\032H\003J\026\0207\032\0020&2\f\0205\032\b\022\004\022\002080\032H\002R\032\020\f\032\016\022\004\022\0020\016\022\004\022\0020\0160\rX\004¢\006\002\n\000R\024\020\017\032\b\022\004\022\0020\0210\020X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\024\020\004\032\b\022\004\022\0028\0000\005X\004¢\006\002\n\000R\020\020\006\032\0028\000X\004¢\006\004\n\002\020\022R\016\020\023\032\0020\024X\016¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\027\020\025\032\b\022\004\022\0020\0160\0268F¢\006\006\032\004\b\027\020\030R\027\020\031\032\b\022\004\022\0020\0210\0328F¢\006\006\032\004\b\033\020\034¨\0069"}, d2={"Lcom/android/build/gradle/internal/variant2/VariantBuilder;", "E", "Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;", "", "dslModelData", "Lcom/android/build/gradle/internal/variant2/DslModelDataImpl;", "extension", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/build/gradle/internal/variant2/DslModelDataImpl;Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;Lcom/android/build/gradle/internal/errors/DeprecationReporter;Lcom/android/builder/errors/EvalIssueReporter;)V", "_shims", "", "Lcom/android/build/api/dsl/variant/Variant;", "_variants", "", "Lcom/android/build/gradle/internal/api/dsl/variant/SealableVariant;", "Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;", "generated", "", "shims", "", "getShims", "()Ljava/util/Collection;", "variants", "", "getVariants", "()Ljava/util/List;", "cloneBuildTypeOrVariant", "Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl;", "that", "Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeImpl;", "cloneProductFlavorOrVariant", "Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl;", "cloneVariantOrExtensionProperties", "Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;", "cloneVariantProperties", "Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;", "computeCommonVariantPropertiesImpl", "Lcom/android/build/gradle/internal/api/dsl/variant/CommonVariantPropertiesImpl;", "variantType", "Lcom/android/builder/core/VariantType;", "variantName", "", "flavorCombo", "Lcom/android/build/gradle/internal/variant2/FlavorCombination;", "buildType", "computeFlavorCombo", "createVariant", "", "generateVariants", "mergeProductFlavorOrVariant", "items", "Lcom/android/build/api/dsl/model/ProductFlavorOrVariant;", "mergeVariantProperties", "Lcom/android/build/api/dsl/model/VariantProperties;", "gradle-core"})
/*     */ public final class VariantBuilder<E extends BaseExtension2>
/*     */ {
/*     */   private boolean generated;
/*     */   private final List<SealableVariant> _variants;
/*     */   private final Map<Variant, Variant> _shims;
/*     */   private final DslModelDataImpl<E> dslModelData;
/*     */   private final E extension;
/*     */   private final DeprecationReporter deprecationReporter;
/*     */   private final EvalIssueReporter issueReporter;
/*     */   
/*     */   public VariantBuilder(@NotNull DslModelDataImpl<? super E> dslModelData, @NotNull E extension, @NotNull DeprecationReporter deprecationReporter, @NotNull EvalIssueReporter issueReporter)
/*     */   {
/*  63 */     this.dslModelData = dslModelData;this.extension = extension;this.deprecationReporter = deprecationReporter;this.issueReporter = issueReporter;
/*     */     
/*  73 */     VariantBuilder localVariantBuilder = this;List localList = (List)new ArrayList();_variants = localList; IdentityHashMap 
/*     */     
/*  75 */       tmp80_77 = Maps.newIdentityHashMap();Intrinsics.checkExpressionValueIsNotNull(tmp80_77, "Maps.newIdentityHashMap()");_shims = ((Map)tmp80_77);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final List<SealableVariant> getVariants() {
/*  80 */     if (!generated) {
/*  81 */       throw ((Throwable)new RuntimeException("VariantBuilder.generateVariants() not called"));
/*     */     }
/*  83 */     return _variants;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Collection<Variant> getShims()
/*     */   {
/*  89 */     if (!generated) {
/*  90 */       throw ((Throwable)new RuntimeException("VariantBuilder.generateVariants() not called"));
/*     */     }
/*  92 */     return _shims.values();
/*     */   }
/*     */   
/*     */   public final void generateVariants()
/*     */   {
/*  98 */     List flavorCombinations = computeFlavorCombo();
/*     */     
/*     */     Iterator localIterator1;
/*     */     
/* 102 */     if (flavorCombinations.isEmpty()) {
/* 103 */       for (localIterator1 = dslModelData.get_buildTypes$gradle_core().iterator(); localIterator1.hasNext(); 
/* 104 */           createVariant(tmp48_47, null))
/*     */       {
/* 103 */         BuildTypeImpl buildType = (BuildTypeImpl)localIterator1.next();
/* 104 */         Intrinsics.checkExpressionValueIsNotNull(buildType, "buildType");
/*     */       }
/*     */       
/*     */     } else {
/* 108 */       for (BuildTypeImpl buildType : dslModelData.get_buildTypes$gradle_core()) { FlavorCombination flavorCombo;
/* 109 */         for (Iterator localIterator2 = flavorCombinations.iterator(); localIterator2.hasNext(); 
/* 110 */             createVariant(tmp128_127, flavorCombo))
/*     */         {
/* 109 */           flavorCombo = (FlavorCombination)localIterator2.next();
/* 110 */           Intrinsics.checkExpressionValueIsNotNull(buildType, "buildType");
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 116 */     generated = true;
/*     */   }
/*     */   
/*     */   private final List<FlavorCombination> computeFlavorCombo()
/*     */   {
/* 127 */     List flavorDimensions = extension.getFlavorDimensions();
/*     */     
/* 129 */     if (dslModelData.get_productFlavors$gradle_core().isEmpty())
/*     */     {
/* 136 */       return CollectionsKt.emptyList();
/*     */     }
/*     */     
/*     */     String dimensionName;
/* 140 */     if (flavorDimensions.isEmpty()) {
/* 141 */       issueReporter.reportError(EvalIssueReporter.Type.UNNAMED_FLAVOR_DIMENSION, 
/* 142 */         "All flavors must now belong to a named flavor dimension. Learn more at https://d.android.com/r/tools/flavorDimensions-missing-error-message.html");
/*     */     }
/* 146 */     else if (flavorDimensions.size() == 1)
/*     */     {
/* 148 */       dimensionName = (String)flavorDimensions.get(0);
/* 149 */       for (ProductFlavorImpl productFlavor : dslModelData.get_productFlavors$gradle_core())
/*     */       {
/* 151 */         productFlavor.set_dimension$gradle_core(dimensionName);
/*     */       }
/*     */     }
/*     */     
/* 160 */     return VariantBuilderKt.access$createCombinations(flavorDimensions, (Set)dslModelData.getProductFlavors(), issueReporter);
/*     */   }
/*     */   
/*     */   private final VariantPropertiesImpl mergeVariantProperties(List<? extends VariantProperties> items)
/*     */   {
/* 355 */     VariantPropertiesImpl variantProperties = new VariantPropertiesImpl(issueReporter);
/*     */     
/* 357 */     VariantBuilderKt.access$takeLastNonNull(variantProperties, items, VariantBuilderKt.access$getSET_MULTIDEX_ENABLED$p(), VariantBuilderKt.access$getGET_MULTIDEX_ENABLED$p());
/* 358 */     VariantBuilderKt.access$takeLastNonNull(variantProperties, items, VariantBuilderKt.access$getSET_MULTIDEX_KEEPFILE$p(), VariantBuilderKt.access$getGET_MULTIDEX_KEEPFILE$p());
/*     */     
/* 361 */     return variantProperties;
/*     */   }
/*     */   
/*     */   private final VariantPropertiesImpl cloneVariantProperties(VariantPropertiesImpl that) {
/* 365 */     VariantPropertiesImpl clone = new VariantPropertiesImpl(issueReporter);
/* 366 */     clone.initWith(that);
/* 367 */     return clone;
/*     */   }
/*     */   
/*     */   private final ProductFlavorOrVariantImpl mergeProductFlavorOrVariant(List<? extends ProductFlavorOrVariant> items)
/*     */   {
/* 373 */     ProductFlavorOrVariantImpl productFlavorOrVariant = new ProductFlavorOrVariantImpl(issueReporter);
/*     */     
/* 378 */     return productFlavorOrVariant;
/*     */   }
/*     */   
/*     */   private final ProductFlavorOrVariantImpl cloneProductFlavorOrVariant(ProductFlavorOrVariantImpl that) {
/* 382 */     ProductFlavorOrVariantImpl clone = new ProductFlavorOrVariantImpl(issueReporter);
/* 383 */     clone.initWith$gradle_core(that);
/* 384 */     return clone;
/*     */   }
/*     */   
/*     */   private final BuildTypeOrVariantImpl cloneBuildTypeOrVariant(BuildTypeImpl that) {
/* 388 */     return cloneBuildTypeOrVariant(that.getBuildTypeOrVariant$gradle_core());
/*     */   }
/*     */   
/*     */   private final BuildTypeOrVariantImpl cloneBuildTypeOrVariant(BuildTypeOrVariantImpl that) {
/* 392 */     BuildTypeOrVariantImpl clone = new BuildTypeOrVariantImpl(
/* 393 */       "Variant", deprecationReporter, issueReporter);
/* 394 */     clone.initWith$gradle_core(that);
/* 395 */     return clone;
/*     */   }
/*     */   
/*     */   private final VariantOrExtensionPropertiesImpl cloneVariantOrExtensionProperties(VariantOrExtensionPropertiesImpl that)
/*     */   {
/* 400 */     VariantOrExtensionPropertiesImpl prop = new VariantOrExtensionPropertiesImpl(issueReporter);
/*     */     
/* 402 */     prop.initWith(that);
/* 403 */     return prop;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   private final void createVariant(BuildTypeImpl buildType, FlavorCombination flavorCombo)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: new 168	com/android/build/gradle/internal/variant2/VariantFilterImpl
/*     */     //   3: dup
/*     */     //   4: aload_1
/*     */     //   5: invokevirtual 172	com/android/build/gradle/internal/api/dsl/model/BuildTypeImpl:getName	()Ljava/lang/String;
/*     */     //   8: aload_2
/*     */     //   9: dup
/*     */     //   10: ifnull +13 -> 23
/*     */     //   13: invokevirtual 175	com/android/build/gradle/internal/variant2/FlavorCombination:getFlavorNames	()Ljava/util/List;
/*     */     //   16: dup
/*     */     //   17: ifnull +6 -> 23
/*     */     //   20: goto +16 -> 36
/*     */     //   23: pop
/*     */     //   24: invokestatic 181	com/google/common/collect/ImmutableList:of	()Lcom/google/common/collect/ImmutableList;
/*     */     //   27: dup
/*     */     //   28: ldc -73
/*     */     //   30: invokestatic 87	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   33: checkcast 48	java/util/List
/*     */     //   36: aload_0
/*     */     //   37: getfield 120	com/android/build/gradle/internal/variant2/VariantBuilder:issueReporter	Lcom/android/builder/errors/EvalIssueReporter;
/*     */     //   40: invokespecial 186	com/android/build/gradle/internal/variant2/VariantFilterImpl:<init>	(Ljava/lang/String;Ljava/util/List;Lcom/android/builder/errors/EvalIssueReporter;)V
/*     */     //   43: astore_3
/*     */     //   44: aload_0
/*     */     //   45: getfield 102	com/android/build/gradle/internal/variant2/VariantBuilder:extension	Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;
/*     */     //   48: invokeinterface 189 1 0
/*     */     //   53: invokeinterface 92 1 0
/*     */     //   58: astore 5
/*     */     //   60: aload 5
/*     */     //   62: invokeinterface 73 1 0
/*     */     //   67: ifeq +34 -> 101
/*     */     //   70: aload 5
/*     */     //   72: invokeinterface 77 1 0
/*     */     //   77: checkcast 191	org/gradle/api/Action
/*     */     //   80: astore 4
/*     */     //   82: aload 4
/*     */     //   84: aload_3
/*     */     //   85: invokeinterface 195 2 0
/*     */     //   90: aload_3
/*     */     //   91: invokevirtual 198	com/android/build/gradle/internal/variant2/VariantFilterImpl:getIgnoresAll	()Z
/*     */     //   94: ifeq +4 -> 98
/*     */     //   97: return
/*     */     //   98: goto -38 -> 60
/*     */     //   101: aload_3
/*     */     //   102: invokevirtual 201	com/android/build/gradle/internal/variant2/VariantFilterImpl:seal	()V
/*     */     //   105: new 203	java/util/ArrayList
/*     */     //   108: dup
/*     */     //   109: invokespecial 205	java/util/ArrayList:<init>	()V
/*     */     //   112: checkcast 48	java/util/List
/*     */     //   115: astore 4
/*     */     //   117: aload 4
/*     */     //   119: aload_0
/*     */     //   120: getfield 56	com/android/build/gradle/internal/variant2/VariantBuilder:dslModelData	Lcom/android/build/gradle/internal/variant2/DslModelDataImpl;
/*     */     //   123: invokevirtual 209	com/android/build/gradle/internal/variant2/DslModelDataImpl:getDefaultConfig	()Lcom/android/build/gradle/internal/api/dsl/model/DefaultConfigImpl;
/*     */     //   126: invokeinterface 213 2 0
/*     */     //   131: pop
/*     */     //   132: aload_2
/*     */     //   133: dup
/*     */     //   134: ifnull +28 -> 162
/*     */     //   137: astore 5
/*     */     //   139: aload 5
/*     */     //   141: astore 6
/*     */     //   143: aload 4
/*     */     //   145: aload 6
/*     */     //   147: invokevirtual 216	com/android/build/gradle/internal/variant2/FlavorCombination:getFlavors	()Lcom/google/common/collect/ImmutableList;
/*     */     //   150: checkcast 218	java/util/Collection
/*     */     //   153: invokeinterface 222 2 0
/*     */     //   158: pop
/*     */     //   159: goto +4 -> 163
/*     */     //   162: pop
/*     */     //   163: aload_0
/*     */     //   164: aload 4
/*     */     //   166: invokestatic 228	kotlin/jvm/internal/TypeIntrinsics:asMutableList	(Ljava/lang/Object;)Ljava/util/List;
/*     */     //   169: invokespecial 232	com/android/build/gradle/internal/variant2/VariantBuilder:mergeProductFlavorOrVariant	(Ljava/util/List;)Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl;
/*     */     //   172: astore 5
/*     */     //   174: aload 4
/*     */     //   176: aload_1
/*     */     //   177: invokeinterface 213 2 0
/*     */     //   182: pop
/*     */     //   183: aload_0
/*     */     //   184: aload 4
/*     */     //   186: invokestatic 228	kotlin/jvm/internal/TypeIntrinsics:asMutableList	(Ljava/lang/Object;)Ljava/util/List;
/*     */     //   189: invokespecial 236	com/android/build/gradle/internal/variant2/VariantBuilder:mergeVariantProperties	(Ljava/util/List;)Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;
/*     */     //   192: astore 6
/*     */     //   194: aload 4
/*     */     //   196: invokestatic 228	kotlin/jvm/internal/TypeIntrinsics:asMutableList	(Ljava/lang/Object;)Ljava/util/List;
/*     */     //   199: getstatic 242	com/android/build/gradle/internal/variant2/VariantBuilder$createVariant$appIdSuffixFromFlavors$1:INSTANCE	Lcom/android/build/gradle/internal/variant2/VariantBuilder$createVariant$appIdSuffixFromFlavors$1;
/*     */     //   202: checkcast 244	kotlin/jvm/functions/Function1
/*     */     //   205: bipush 46
/*     */     //   207: invokestatic 250	java/lang/Character:valueOf	(C)Ljava/lang/Character;
/*     */     //   210: invokestatic 254	com/android/build/gradle/internal/variant2/VariantBuilderKt:access$combineSuffixes	(Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/lang/Character;)Ljava/lang/String;
/*     */     //   213: astore 7
/*     */     //   215: aload 4
/*     */     //   217: invokestatic 228	kotlin/jvm/internal/TypeIntrinsics:asMutableList	(Ljava/lang/Object;)Ljava/util/List;
/*     */     //   220: getstatic 259	com/android/build/gradle/internal/variant2/VariantBuilder$createVariant$variantNameSuffixFromFlavors$1:INSTANCE	Lcom/android/build/gradle/internal/variant2/VariantBuilder$createVariant$variantNameSuffixFromFlavors$1;
/*     */     //   223: checkcast 244	kotlin/jvm/functions/Function1
/*     */     //   226: aconst_null
/*     */     //   227: invokestatic 254	com/android/build/gradle/internal/variant2/VariantBuilderKt:access$combineSuffixes	(Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/lang/Character;)Ljava/lang/String;
/*     */     //   230: astore 8
/*     */     //   232: aload_0
/*     */     //   233: aload_1
/*     */     //   234: invokespecial 263	com/android/build/gradle/internal/variant2/VariantBuilder:cloneBuildTypeOrVariant	(Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeImpl;)Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl;
/*     */     //   237: astore 9
/*     */     //   239: aload_0
/*     */     //   240: aload_0
/*     */     //   241: getfield 102	com/android/build/gradle/internal/variant2/VariantBuilder:extension	Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;
/*     */     //   244: invokeinterface 267 1 0
/*     */     //   249: invokespecial 271	com/android/build/gradle/internal/variant2/VariantBuilder:cloneVariantOrExtensionProperties	(Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;)Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;
/*     */     //   252: astore 10
/*     */     //   254: aload_0
/*     */     //   255: getfield 56	com/android/build/gradle/internal/variant2/VariantBuilder:dslModelData	Lcom/android/build/gradle/internal/variant2/DslModelDataImpl;
/*     */     //   258: invokevirtual 274	com/android/build/gradle/internal/variant2/DslModelDataImpl:getVariantFactories$gradle_core	()Ljava/util/List;
/*     */     //   261: astore 11
/*     */     //   263: new 276	com/android/build/gradle/internal/variant2/VariantDispatchImpl
/*     */     //   266: dup
/*     */     //   267: invokespecial 277	com/android/build/gradle/internal/variant2/VariantDispatchImpl:<init>	()V
/*     */     //   270: astore 12
/*     */     //   272: new 279	java/util/LinkedHashMap
/*     */     //   275: dup
/*     */     //   276: invokespecial 280	java/util/LinkedHashMap:<init>	()V
/*     */     //   279: checkcast 38	java/util/Map
/*     */     //   282: astore 13
/*     */     //   284: iconst_0
/*     */     //   285: istore 14
/*     */     //   287: aload 11
/*     */     //   289: invokeinterface 92 1 0
/*     */     //   294: astore 16
/*     */     //   296: aload 16
/*     */     //   298: invokeinterface 73 1 0
/*     */     //   303: ifeq +316 -> 619
/*     */     //   306: aload 16
/*     */     //   308: invokeinterface 77 1 0
/*     */     //   313: checkcast 282	com/android/build/gradle/internal/variant2/VariantFactory2
/*     */     //   316: astore 15
/*     */     //   318: aload 15
/*     */     //   320: invokeinterface 286 1 0
/*     */     //   325: astore 17
/*     */     //   327: aload_3
/*     */     //   328: aload 17
/*     */     //   330: invokevirtual 290	com/android/build/gradle/internal/variant2/VariantFilterImpl:ignores	(Lcom/android/builder/core/VariantType;)Z
/*     */     //   333: ifeq +6 -> 339
/*     */     //   336: goto +280 -> 616
/*     */     //   339: aload_1
/*     */     //   340: invokevirtual 172	com/android/build/gradle/internal/api/dsl/model/BuildTypeImpl:getName	()Ljava/lang/String;
/*     */     //   343: aload_2
/*     */     //   344: dup
/*     */     //   345: ifnull +9 -> 354
/*     */     //   348: invokevirtual 291	com/android/build/gradle/internal/variant2/FlavorCombination:getName	()Ljava/lang/String;
/*     */     //   351: goto +5 -> 356
/*     */     //   354: pop
/*     */     //   355: aconst_null
/*     */     //   356: aload 17
/*     */     //   358: aload 15
/*     */     //   360: invokeinterface 294 1 0
/*     */     //   365: invokestatic 298	com/android/build/gradle/internal/variant2/VariantBuilderKt:access$computeVariantName	(Ljava/lang/String;Ljava/lang/String;Lcom/android/builder/core/VariantType;Lcom/android/builder/core/VariantType;)Ljava/lang/String;
/*     */     //   368: astore 18
/*     */     //   370: aload 5
/*     */     //   372: aload 15
/*     */     //   374: aload 5
/*     */     //   376: checkcast 300	com/android/build/api/dsl/model/ProductFlavorOrVariant
/*     */     //   379: aload 7
/*     */     //   381: invokeinterface 304 3 0
/*     */     //   386: invokevirtual 309	com/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl:setApplicationId	(Ljava/lang/String;)V
/*     */     //   389: iload 14
/*     */     //   391: ifne +8 -> 399
/*     */     //   394: aload 6
/*     */     //   396: goto +9 -> 405
/*     */     //   399: aload_0
/*     */     //   400: aload 6
/*     */     //   402: invokespecial 313	com/android/build/gradle/internal/variant2/VariantBuilder:cloneVariantProperties	(Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;)Lcom/android/build/gradle/internal/api/dsl/model/VariantPropertiesImpl;
/*     */     //   405: astore 19
/*     */     //   407: iload 14
/*     */     //   409: ifne +8 -> 417
/*     */     //   412: aload 5
/*     */     //   414: goto +9 -> 423
/*     */     //   417: aload_0
/*     */     //   418: aload 5
/*     */     //   420: invokespecial 317	com/android/build/gradle/internal/variant2/VariantBuilder:cloneProductFlavorOrVariant	(Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl;)Lcom/android/build/gradle/internal/api/dsl/model/ProductFlavorOrVariantImpl;
/*     */     //   423: astore 20
/*     */     //   425: iload 14
/*     */     //   427: ifne +8 -> 435
/*     */     //   430: aload 9
/*     */     //   432: goto +9 -> 441
/*     */     //   435: aload_0
/*     */     //   436: aload 9
/*     */     //   438: invokespecial 320	com/android/build/gradle/internal/variant2/VariantBuilder:cloneBuildTypeOrVariant	(Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl;)Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeOrVariantImpl;
/*     */     //   441: astore 21
/*     */     //   443: iload 14
/*     */     //   445: ifne +8 -> 453
/*     */     //   448: aload 10
/*     */     //   450: goto +9 -> 459
/*     */     //   453: aload_0
/*     */     //   454: aload 10
/*     */     //   456: invokespecial 271	com/android/build/gradle/internal/variant2/VariantBuilder:cloneVariantOrExtensionProperties	(Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;)Lcom/android/build/gradle/internal/api/dsl/extensions/VariantOrExtensionPropertiesImpl;
/*     */     //   459: astore 22
/*     */     //   461: aload_0
/*     */     //   462: aload 17
/*     */     //   464: aload 18
/*     */     //   466: aload_2
/*     */     //   467: aload_1
/*     */     //   468: invokespecial 324	com/android/build/gradle/internal/variant2/VariantBuilder:computeCommonVariantPropertiesImpl	(Lcom/android/builder/core/VariantType;Ljava/lang/String;Lcom/android/build/gradle/internal/variant2/FlavorCombination;Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeImpl;)Lcom/android/build/gradle/internal/api/dsl/variant/CommonVariantPropertiesImpl;
/*     */     //   471: astore 23
/*     */     //   473: aload 15
/*     */     //   475: aload_0
/*     */     //   476: getfield 102	com/android/build/gradle/internal/variant2/VariantBuilder:extension	Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;
/*     */     //   479: aload 19
/*     */     //   481: aload 20
/*     */     //   483: aload 21
/*     */     //   485: aload 22
/*     */     //   487: aload 23
/*     */     //   489: aload 12
/*     */     //   491: checkcast 326	com/android/build/gradle/internal/variant2/VariantDispatcher
/*     */     //   494: aload_0
/*     */     //   495: getfield 120	com/android/build/gradle/internal/variant2/VariantBuilder:issueReporter	Lcom/android/builder/errors/EvalIssueReporter;
/*     */     //   498: invokeinterface 329 9 0
/*     */     //   503: astore 24
/*     */     //   505: aload 24
/*     */     //   507: invokeinterface 334 1 0
/*     */     //   512: astore 25
/*     */     //   514: aload_0
/*     */     //   515: getfield 30	com/android/build/gradle/internal/variant2/VariantBuilder:_variants	Ljava/util/List;
/*     */     //   518: aload 24
/*     */     //   520: invokeinterface 213 2 0
/*     */     //   525: pop
/*     */     //   526: aload 24
/*     */     //   528: invokeinterface 338 1 0
/*     */     //   533: astore 26
/*     */     //   535: aload_0
/*     */     //   536: getfield 36	com/android/build/gradle/internal/variant2/VariantBuilder:_shims	Ljava/util/Map;
/*     */     //   539: astore 27
/*     */     //   541: aload 26
/*     */     //   543: astore 28
/*     */     //   545: aload 27
/*     */     //   547: aload 24
/*     */     //   549: aload 28
/*     */     //   551: invokeinterface 342 3 0
/*     */     //   556: pop
/*     */     //   557: aload 13
/*     */     //   559: aload 25
/*     */     //   561: invokeinterface 345 2 0
/*     */     //   566: ifnull +35 -> 601
/*     */     //   569: new 20	java/lang/RuntimeException
/*     */     //   572: dup
/*     */     //   573: new 347	java/lang/StringBuilder
/*     */     //   576: dup
/*     */     //   577: invokespecial 348	java/lang/StringBuilder:<init>	()V
/*     */     //   580: ldc_w 350
/*     */     //   583: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   586: aload 25
/*     */     //   588: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   591: invokevirtual 360	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   594: invokespecial 26	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
/*     */     //   597: checkcast 28	java/lang/Throwable
/*     */     //   600: athrow
/*     */     //   601: aload 13
/*     */     //   603: aload 25
/*     */     //   605: aload 24
/*     */     //   607: invokeinterface 342 3 0
/*     */     //   612: pop
/*     */     //   613: iconst_1
/*     */     //   614: istore 14
/*     */     //   616: goto -320 -> 296
/*     */     //   619: aload 11
/*     */     //   621: invokeinterface 92 1 0
/*     */     //   626: astore 16
/*     */     //   628: aload 16
/*     */     //   630: invokeinterface 73 1 0
/*     */     //   635: ifeq +175 -> 810
/*     */     //   638: aload 16
/*     */     //   640: invokeinterface 77 1 0
/*     */     //   645: checkcast 282	com/android/build/gradle/internal/variant2/VariantFactory2
/*     */     //   648: astore 15
/*     */     //   650: aload 13
/*     */     //   652: aload 15
/*     */     //   654: invokeinterface 286 1 0
/*     */     //   659: invokeinterface 345 2 0
/*     */     //   664: checkcast 362	com/android/build/api/dsl/variant/Variant
/*     */     //   667: dup
/*     */     //   668: ifnull +6 -> 674
/*     */     //   671: goto +7 -> 678
/*     */     //   674: pop
/*     */     //   675: goto +132 -> 807
/*     */     //   678: astore 17
/*     */     //   680: aload_0
/*     */     //   681: getfield 36	com/android/build/gradle/internal/variant2/VariantBuilder:_shims	Ljava/util/Map;
/*     */     //   684: aload 17
/*     */     //   686: invokeinterface 345 2 0
/*     */     //   691: dup
/*     */     //   692: ifnonnull +6 -> 698
/*     */     //   695: invokestatic 365	kotlin/jvm/internal/Intrinsics:throwNpe	()V
/*     */     //   698: checkcast 362	com/android/build/api/dsl/variant/Variant
/*     */     //   701: astore 18
/*     */     //   703: aload 15
/*     */     //   705: invokeinterface 286 1 0
/*     */     //   710: getstatic 371	com/android/build/gradle/internal/variant2/VariantBuilder$WhenMappings:$EnumSwitchMapping$0	[I
/*     */     //   713: swap
/*     */     //   714: invokevirtual 376	com/android/builder/core/VariantType:ordinal	()I
/*     */     //   717: iaload
/*     */     //   718: lookupswitch	default:+82->800, 1:+26->744, 2:+54->772
/*     */     //   744: aload 12
/*     */     //   746: aload 18
/*     */     //   748: dup
/*     */     //   749: ifnonnull +14 -> 763
/*     */     //   752: new 378	kotlin/TypeCastException
/*     */     //   755: dup
/*     */     //   756: ldc_w 380
/*     */     //   759: invokespecial 381	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
/*     */     //   762: athrow
/*     */     //   763: checkcast 383	com/android/build/api/dsl/variant/UnitTestVariant
/*     */     //   766: invokevirtual 387	com/android/build/gradle/internal/variant2/VariantDispatchImpl:setUnitTestVariant	(Lcom/android/build/api/dsl/variant/UnitTestVariant;)V
/*     */     //   769: goto +38 -> 807
/*     */     //   772: aload 12
/*     */     //   774: aload 18
/*     */     //   776: dup
/*     */     //   777: ifnonnull +14 -> 791
/*     */     //   780: new 378	kotlin/TypeCastException
/*     */     //   783: dup
/*     */     //   784: ldc_w 389
/*     */     //   787: invokespecial 381	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
/*     */     //   790: athrow
/*     */     //   791: checkcast 391	com/android/build/api/dsl/variant/AndroidTestVariant
/*     */     //   794: invokevirtual 395	com/android/build/gradle/internal/variant2/VariantDispatchImpl:setAndroidTestVariant	(Lcom/android/build/api/dsl/variant/AndroidTestVariant;)V
/*     */     //   797: goto +10 -> 807
/*     */     //   800: aload 12
/*     */     //   802: aload 18
/*     */     //   804: invokevirtual 399	com/android/build/gradle/internal/variant2/VariantDispatchImpl:setProductionVariant	(Lcom/android/build/api/dsl/variant/Variant;)V
/*     */     //   807: goto -179 -> 628
/*     */     //   810: return
/*     */     // Line number table:
/*     */     //   Java source line #172	-> byte code offset #0
/*     */     //   Java source line #173	-> byte code offset #4
/*     */     //   Java source line #174	-> byte code offset #8
/*     */     //   Java source line #175	-> byte code offset #36
/*     */     //   Java source line #172	-> byte code offset #40
/*     */     //   Java source line #176	-> byte code offset #44
/*     */     //   Java source line #177	-> byte code offset #82
/*     */     //   Java source line #178	-> byte code offset #90
/*     */     //   Java source line #179	-> byte code offset #97
/*     */     //   Java source line #176	-> byte code offset #98
/*     */     //   Java source line #184	-> byte code offset #101
/*     */     //   Java source line #197	-> byte code offset #105
/*     */     //   Java source line #197	-> byte code offset #115
/*     */     //   Java source line #200	-> byte code offset #117
/*     */     //   Java source line #201	-> byte code offset #132
/*     */     //   Java source line #202	-> byte code offset #143
/*     */     //   Java source line #201	-> byte code offset #159
/*     */     //   Java source line #206	-> byte code offset #163
/*     */     //   Java source line #207	-> byte code offset #164
/*     */     //   Java source line #206	-> byte code offset #169
/*     */     //   Java source line #210	-> byte code offset #174
/*     */     //   Java source line #212	-> byte code offset #183
/*     */     //   Java source line #218	-> byte code offset #194
/*     */     //   Java source line #219	-> byte code offset #194
/*     */     //   Java source line #220	-> byte code offset #199
/*     */     //   Java source line #221	-> byte code offset #205
/*     */     //   Java source line #218	-> byte code offset #210
/*     */     //   Java source line #224	-> byte code offset #215
/*     */     //   Java source line #225	-> byte code offset #215
/*     */     //   Java source line #226	-> byte code offset #220
/*     */     //   Java source line #227	-> byte code offset #226
/*     */     //   Java source line #224	-> byte code offset #227
/*     */     //   Java source line #234	-> byte code offset #232
/*     */     //   Java source line #237	-> byte code offset #239
/*     */     //   Java source line #238	-> byte code offset #240
/*     */     //   Java source line #237	-> byte code offset #249
/*     */     //   Java source line #242	-> byte code offset #254
/*     */     //   Java source line #249	-> byte code offset #263
/*     */     //   Java source line #251	-> byte code offset #272
/*     */     //   Java source line #251	-> byte code offset #282
/*     */     //   Java source line #254	-> byte code offset #284
/*     */     //   Java source line #256	-> byte code offset #287
/*     */     //   Java source line #258	-> byte code offset #318
/*     */     //   Java source line #260	-> byte code offset #327
/*     */     //   Java source line #261	-> byte code offset #336
/*     */     //   Java source line #266	-> byte code offset #339
/*     */     //   Java source line #267	-> byte code offset #339
/*     */     //   Java source line #266	-> byte code offset #365
/*     */     //   Java source line #272	-> byte code offset #370
/*     */     //   Java source line #273	-> byte code offset #374
/*     */     //   Java source line #274	-> byte code offset #379
/*     */     //   Java source line #272	-> byte code offset #381
/*     */     //   Java source line #280	-> byte code offset #389
/*     */     //   Java source line #281	-> byte code offset #394
/*     */     //   Java source line #283	-> byte code offset #399
/*     */     //   Java source line #280	-> byte code offset #405
/*     */     //   Java source line #286	-> byte code offset #407
/*     */     //   Java source line #287	-> byte code offset #412
/*     */     //   Java source line #289	-> byte code offset #417
/*     */     //   Java source line #286	-> byte code offset #423
/*     */     //   Java source line #292	-> byte code offset #425
/*     */     //   Java source line #293	-> byte code offset #430
/*     */     //   Java source line #295	-> byte code offset #435
/*     */     //   Java source line #292	-> byte code offset #441
/*     */     //   Java source line #298	-> byte code offset #443
/*     */     //   Java source line #299	-> byte code offset #448
/*     */     //   Java source line #301	-> byte code offset #453
/*     */     //   Java source line #298	-> byte code offset #459
/*     */     //   Java source line #305	-> byte code offset #461
/*     */     //   Java source line #306	-> byte code offset #462
/*     */     //   Java source line #305	-> byte code offset #468
/*     */     //   Java source line #309	-> byte code offset #473
/*     */     //   Java source line #310	-> byte code offset #475
/*     */     //   Java source line #311	-> byte code offset #479
/*     */     //   Java source line #312	-> byte code offset #481
/*     */     //   Java source line #313	-> byte code offset #483
/*     */     //   Java source line #314	-> byte code offset #485
/*     */     //   Java source line #315	-> byte code offset #487
/*     */     //   Java source line #316	-> byte code offset #489
/*     */     //   Java source line #317	-> byte code offset #494
/*     */     //   Java source line #309	-> byte code offset #498
/*     */     //   Java source line #319	-> byte code offset #505
/*     */     //   Java source line #322	-> byte code offset #514
/*     */     //   Java source line #325	-> byte code offset #526
/*     */     //   Java source line #326	-> byte code offset #535
/*     */     //   Java source line #329	-> byte code offset #557
/*     */     //   Java source line #330	-> byte code offset #569
/*     */     //   Java source line #332	-> byte code offset #601
/*     */     //   Java source line #335	-> byte code offset #613
/*     */     //   Java source line #256	-> byte code offset #616
/*     */     //   Java source line #341	-> byte code offset #619
/*     */     //   Java source line #342	-> byte code offset #650
/*     */     //   Java source line #344	-> byte code offset #680
/*     */     //   Java source line #346	-> byte code offset #703
/*     */     //   Java source line #347	-> byte code offset #744
/*     */     //   Java source line #348	-> byte code offset #772
/*     */     //   Java source line #349	-> byte code offset #800
/*     */     //   Java source line #350	-> byte code offset #807
/*     */     //   Java source line #341	-> byte code offset #807
/*     */     //   Java source line #352	-> byte code offset #810
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	811	0	this	VariantBuilder
/*     */     //   0	811	1	buildType	BuildTypeImpl
/*     */     //   0	811	2	flavorCombo	FlavorCombination
/*     */     //   44	767	3	filterObject	VariantFilterImpl
/*     */     //   82	16	4	filter	org.gradle.api.Action
/*     */     //   117	694	4	items	List
/*     */     //   174	637	5	productFlavorOrVariant	ProductFlavorOrVariantImpl
/*     */     //   143	15	6	it	FlavorCombination
/*     */     //   194	617	6	variantProperties	VariantPropertiesImpl
/*     */     //   143	15	7	$i$a$1$let	int
/*     */     //   215	596	7	appIdSuffixFromFlavors	String
/*     */     //   232	579	8	variantNameSuffixFromFlavors	String
/*     */     //   239	572	9	buildTypOrVariant	BuildTypeOrVariantImpl
/*     */     //   254	557	10	variantExtensionProperties	VariantOrExtensionPropertiesImpl
/*     */     //   263	548	11	variantFactories	List
/*     */     //   272	539	12	variantDispatcher	VariantDispatchImpl
/*     */     //   284	527	13	createdVariantMap	Map
/*     */     //   287	524	14	duplicateCommonProps	boolean
/*     */     //   318	298	15	factory	VariantFactory2
/*     */     //   650	157	15	factory	VariantFactory2
/*     */     //   327	289	17	generatedType	com.android.builder.core.VariantType
/*     */     //   680	127	17	generatedVariant	Variant
/*     */     //   370	246	18	variantName	String
/*     */     //   703	104	18	shim	Variant
/*     */     //   407	209	19	variantPropertiesCopy	VariantPropertiesImpl
/*     */     //   425	191	20	productFlavorOrVariantCopy	ProductFlavorOrVariantImpl
/*     */     //   443	173	21	buildTypOrVariantCopy	BuildTypeOrVariantImpl
/*     */     //   461	155	22	variantExtensionPropertiesCopy	VariantOrExtensionPropertiesImpl
/*     */     //   473	143	23	commonVariantProperties	com.android.build.gradle.internal.api.dsl.variant.CommonVariantPropertiesImpl
/*     */     //   505	111	24	variant	SealableVariant
/*     */     //   514	102	25	variantType	com.android.builder.core.VariantType
/*     */     //   535	81	26	shim	Variant
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   private final com.android.build.gradle.internal.api.dsl.variant.CommonVariantPropertiesImpl computeCommonVariantPropertiesImpl(com.android.builder.core.VariantType variantType, String variantName, FlavorCombination flavorCombo, BuildTypeImpl buildType)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_3
/*     */     //   1: dup
/*     */     //   2: ifnull +13 -> 15
/*     */     //   5: invokevirtual 216	com/android/build/gradle/internal/variant2/FlavorCombination:getFlavors	()Lcom/google/common/collect/ImmutableList;
/*     */     //   8: dup
/*     */     //   9: ifnull +6 -> 15
/*     */     //   12: goto +13 -> 25
/*     */     //   15: pop
/*     */     //   16: invokestatic 181	com/google/common/collect/ImmutableList:of	()Lcom/google/common/collect/ImmutableList;
/*     */     //   19: dup
/*     */     //   20: ldc -73
/*     */     //   22: invokestatic 87	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   25: astore 5
/*     */     //   27: new 203	java/util/ArrayList
/*     */     //   30: dup
/*     */     //   31: invokespecial 205	java/util/ArrayList:<init>	()V
/*     */     //   34: checkcast 48	java/util/List
/*     */     //   37: astore 6
/*     */     //   39: aload_0
/*     */     //   40: getfield 56	com/android/build/gradle/internal/variant2/VariantBuilder:dslModelData	Lcom/android/build/gradle/internal/variant2/DslModelDataImpl;
/*     */     //   43: invokevirtual 504	com/android/build/gradle/internal/variant2/DslModelDataImpl:getDefaultConfigData	()Lcom/android/build/gradle/internal/variant2/DimensionData;
/*     */     //   46: aload_1
/*     */     //   47: invokevirtual 510	com/android/build/gradle/internal/variant2/DimensionData:getSourceSet	(Lcom/android/builder/core/VariantType;)Lcom/android/build/api/sourcesets/AndroidSourceSet;
/*     */     //   50: dup
/*     */     //   51: ifnull +22 -> 73
/*     */     //   54: astore 7
/*     */     //   56: aload 7
/*     */     //   58: astore 8
/*     */     //   60: aload 6
/*     */     //   62: aload 8
/*     */     //   64: invokeinterface 213 2 0
/*     */     //   69: pop
/*     */     //   70: goto +4 -> 74
/*     */     //   73: pop
/*     */     //   74: aload 5
/*     */     //   76: checkcast 512	java/lang/Iterable
/*     */     //   79: astore 7
/*     */     //   81: aload 7
/*     */     //   83: invokeinterface 513 1 0
/*     */     //   88: astore 8
/*     */     //   90: aload 8
/*     */     //   92: invokeinterface 73 1 0
/*     */     //   97: ifeq +84 -> 181
/*     */     //   100: aload 8
/*     */     //   102: invokeinterface 77 1 0
/*     */     //   107: astore 9
/*     */     //   109: aload 9
/*     */     //   111: checkcast 515	com/android/build/api/dsl/model/ProductFlavor
/*     */     //   114: astore 10
/*     */     //   116: aload_0
/*     */     //   117: getfield 56	com/android/build/gradle/internal/variant2/VariantBuilder:dslModelData	Lcom/android/build/gradle/internal/variant2/DslModelDataImpl;
/*     */     //   120: invokevirtual 519	com/android/build/gradle/internal/variant2/DslModelDataImpl:getFlavorData	()Ljava/util/Map;
/*     */     //   123: aload 10
/*     */     //   125: dup
/*     */     //   126: ldc_w 520
/*     */     //   129: invokestatic 87	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   132: invokeinterface 521 1 0
/*     */     //   137: invokeinterface 345 2 0
/*     */     //   142: checkcast 506	com/android/build/gradle/internal/variant2/DimensionData
/*     */     //   145: dup
/*     */     //   146: ifnull +30 -> 176
/*     */     //   149: aload_1
/*     */     //   150: invokevirtual 510	com/android/build/gradle/internal/variant2/DimensionData:getSourceSet	(Lcom/android/builder/core/VariantType;)Lcom/android/build/api/sourcesets/AndroidSourceSet;
/*     */     //   153: dup
/*     */     //   154: ifnull +22 -> 176
/*     */     //   157: astore 11
/*     */     //   159: aload 11
/*     */     //   161: astore 12
/*     */     //   163: aload 6
/*     */     //   165: aload 12
/*     */     //   167: invokeinterface 213 2 0
/*     */     //   172: pop
/*     */     //   173: goto +4 -> 177
/*     */     //   176: pop
/*     */     //   177: nop
/*     */     //   178: goto -88 -> 90
/*     */     //   181: nop
/*     */     //   182: aconst_null
/*     */     //   183: checkcast 523	com/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet
/*     */     //   186: astore 7
/*     */     //   188: aload_3
/*     */     //   189: dup
/*     */     //   190: ifnull +39 -> 229
/*     */     //   193: invokevirtual 291	com/android/build/gradle/internal/variant2/FlavorCombination:getName	()Ljava/lang/String;
/*     */     //   196: dup
/*     */     //   197: ifnull +32 -> 229
/*     */     //   200: astore 8
/*     */     //   202: aload 8
/*     */     //   204: astore 9
/*     */     //   206: aload_0
/*     */     //   207: getfield 56	com/android/build/gradle/internal/variant2/VariantBuilder:dslModelData	Lcom/android/build/gradle/internal/variant2/DslModelDataImpl;
/*     */     //   210: invokevirtual 526	com/android/build/gradle/internal/variant2/DslModelDataImpl:get_sourceSets$gradle_core	()Lorg/gradle/api/NamedDomainObjectContainer;
/*     */     //   213: aload 9
/*     */     //   215: invokeinterface 530 2 0
/*     */     //   220: checkcast 523	com/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet
/*     */     //   223: astore 7
/*     */     //   225: nop
/*     */     //   226: goto +4 -> 230
/*     */     //   229: pop
/*     */     //   230: aload 7
/*     */     //   232: dup
/*     */     //   233: ifnull +22 -> 255
/*     */     //   236: astore 8
/*     */     //   238: aload 8
/*     */     //   240: astore 9
/*     */     //   242: aload 6
/*     */     //   244: aload 9
/*     */     //   246: invokeinterface 213 2 0
/*     */     //   251: pop
/*     */     //   252: goto +4 -> 256
/*     */     //   255: pop
/*     */     //   256: aload_0
/*     */     //   257: getfield 56	com/android/build/gradle/internal/variant2/VariantBuilder:dslModelData	Lcom/android/build/gradle/internal/variant2/DslModelDataImpl;
/*     */     //   260: invokevirtual 533	com/android/build/gradle/internal/variant2/DslModelDataImpl:getBuildTypeData	()Ljava/util/Map;
/*     */     //   263: aload 4
/*     */     //   265: invokevirtual 172	com/android/build/gradle/internal/api/dsl/model/BuildTypeImpl:getName	()Ljava/lang/String;
/*     */     //   268: invokeinterface 345 2 0
/*     */     //   273: checkcast 506	com/android/build/gradle/internal/variant2/DimensionData
/*     */     //   276: dup
/*     */     //   277: ifnull +30 -> 307
/*     */     //   280: aload_1
/*     */     //   281: invokevirtual 510	com/android/build/gradle/internal/variant2/DimensionData:getSourceSet	(Lcom/android/builder/core/VariantType;)Lcom/android/build/api/sourcesets/AndroidSourceSet;
/*     */     //   284: dup
/*     */     //   285: ifnull +22 -> 307
/*     */     //   288: astore 8
/*     */     //   290: aload 8
/*     */     //   292: astore 9
/*     */     //   294: aload 6
/*     */     //   296: aload 9
/*     */     //   298: invokeinterface 213 2 0
/*     */     //   303: pop
/*     */     //   304: goto +4 -> 308
/*     */     //   307: pop
/*     */     //   308: aconst_null
/*     */     //   309: checkcast 523	com/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet
/*     */     //   312: astore 8
/*     */     //   314: aload 5
/*     */     //   316: invokevirtual 534	com/google/common/collect/ImmutableList:isEmpty	()Z
/*     */     //   319: ifne +38 -> 357
/*     */     //   322: aload_0
/*     */     //   323: getfield 56	com/android/build/gradle/internal/variant2/VariantBuilder:dslModelData	Lcom/android/build/gradle/internal/variant2/DslModelDataImpl;
/*     */     //   326: invokevirtual 526	com/android/build/gradle/internal/variant2/DslModelDataImpl:get_sourceSets$gradle_core	()Lorg/gradle/api/NamedDomainObjectContainer;
/*     */     //   329: aload_2
/*     */     //   330: invokeinterface 530 2 0
/*     */     //   335: checkcast 523	com/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet
/*     */     //   338: astore 8
/*     */     //   340: aload 6
/*     */     //   342: aload 8
/*     */     //   344: dup
/*     */     //   345: ldc_w 536
/*     */     //   348: invokestatic 87	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   351: invokeinterface 213 2 0
/*     */     //   356: pop
/*     */     //   357: new 447	com/android/build/gradle/internal/api/dsl/variant/CommonVariantPropertiesImpl
/*     */     //   360: dup
/*     */     //   361: aload_2
/*     */     //   362: aload 4
/*     */     //   364: invokevirtual 172	com/android/build/gradle/internal/api/dsl/model/BuildTypeImpl:getName	()Ljava/lang/String;
/*     */     //   367: aload_3
/*     */     //   368: dup
/*     */     //   369: ifnull +13 -> 382
/*     */     //   372: invokevirtual 175	com/android/build/gradle/internal/variant2/FlavorCombination:getFlavorNames	()Ljava/util/List;
/*     */     //   375: dup
/*     */     //   376: ifnull +6 -> 382
/*     */     //   379: goto +16 -> 395
/*     */     //   382: pop
/*     */     //   383: invokestatic 181	com/google/common/collect/ImmutableList:of	()Lcom/google/common/collect/ImmutableList;
/*     */     //   386: dup
/*     */     //   387: ldc -73
/*     */     //   389: invokestatic 87	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   392: checkcast 48	java/util/List
/*     */     //   395: aload 6
/*     */     //   397: aload 8
/*     */     //   399: aload 7
/*     */     //   401: aload_0
/*     */     //   402: getfield 120	com/android/build/gradle/internal/variant2/VariantBuilder:issueReporter	Lcom/android/builder/errors/EvalIssueReporter;
/*     */     //   405: invokespecial 539	com/android/build/gradle/internal/api/dsl/variant/CommonVariantPropertiesImpl:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet;Lcom/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet;Lcom/android/builder/errors/EvalIssueReporter;)V
/*     */     //   408: areturn
/*     */     // Line number table:
/*     */     //   Java source line #412	-> byte code offset #0
/*     */     //   Java source line #414	-> byte code offset #27
/*     */     //   Java source line #414	-> byte code offset #37
/*     */     //   Java source line #418	-> byte code offset #39
/*     */     //   Java source line #419	-> byte code offset #60
/*     */     //   Java source line #418	-> byte code offset #70
/*     */     //   Java source line #423	-> byte code offset #74
/*     */     //   Java source line #663	-> byte code offset #81
/*     */     //   Java source line #424	-> byte code offset #116
/*     */     //   Java source line #425	-> byte code offset #163
/*     */     //   Java source line #424	-> byte code offset #173
/*     */     //   Java source line #427	-> byte code offset #177
/*     */     //   Java source line #664	-> byte code offset #181
/*     */     //   Java source line #430	-> byte code offset #182
/*     */     //   Java source line #431	-> byte code offset #188
/*     */     //   Java source line #433	-> byte code offset #206
/*     */     //   Java source line #434	-> byte code offset #225
/*     */     //   Java source line #431	-> byte code offset #226
/*     */     //   Java source line #436	-> byte code offset #230
/*     */     //   Java source line #437	-> byte code offset #242
/*     */     //   Java source line #436	-> byte code offset #252
/*     */     //   Java source line #441	-> byte code offset #256
/*     */     //   Java source line #442	-> byte code offset #294
/*     */     //   Java source line #441	-> byte code offset #304
/*     */     //   Java source line #447	-> byte code offset #308
/*     */     //   Java source line #448	-> byte code offset #314
/*     */     //   Java source line #449	-> byte code offset #322
/*     */     //   Java source line #450	-> byte code offset #340
/*     */     //   Java source line #453	-> byte code offset #357
/*     */     //   Java source line #454	-> byte code offset #361
/*     */     //   Java source line #455	-> byte code offset #362
/*     */     //   Java source line #456	-> byte code offset #367
/*     */     //   Java source line #457	-> byte code offset #395
/*     */     //   Java source line #458	-> byte code offset #397
/*     */     //   Java source line #459	-> byte code offset #399
/*     */     //   Java source line #460	-> byte code offset #401
/*     */     //   Java source line #453	-> byte code offset #405
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	409	0	this	VariantBuilder
/*     */     //   0	409	1	variantType	com.android.builder.core.VariantType
/*     */     //   0	409	2	variantName	String
/*     */     //   0	409	3	flavorCombo	FlavorCombination
/*     */     //   0	409	4	buildType	BuildTypeImpl
/*     */     //   27	382	5	flavors	com.google.common.collect.ImmutableList
/*     */     //   39	370	6	sourceSets	List
/*     */     //   81	101	7	$receiver$iv	Iterable
/*     */     //   188	221	7	multiFlavorSourceSet	Object
/*     */     //   60	9	8	it	com.android.build.api.sourcesets.AndroidSourceSet
/*     */     //   314	95	8	variantSourceSet	com.android.build.gradle.internal.api.sourcesets.DefaultAndroidSourceSet
/*     */     //   60	9	9	$i$a$1$let	int
/*     */     //   109	69	9	element$iv	Object
/*     */     //   206	19	9	it	String
/*     */     //   242	9	9	it	com.android.build.gradle.internal.api.sourcesets.DefaultAndroidSourceSet
/*     */     //   294	9	9	it	com.android.build.api.sourcesets.AndroidSourceSet
/*     */     //   116	61	10	it	com.android.build.api.dsl.model.ProductFlavor
/*     */     //   206	19	10	$i$a$3$let	int
/*     */     //   242	9	10	$i$a$4$let	int
/*     */     //   294	9	10	$i$a$5$let	int
/*     */     //   163	9	12	it	com.android.build.api.sourcesets.AndroidSourceSet
/*     */     //   163	9	13	$i$a$1$let	int
/*     */     //   116	61	14	$i$a$2$forEach	int
/*     */     //   81	101	15	$i$f$forEach	int
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.VariantBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */