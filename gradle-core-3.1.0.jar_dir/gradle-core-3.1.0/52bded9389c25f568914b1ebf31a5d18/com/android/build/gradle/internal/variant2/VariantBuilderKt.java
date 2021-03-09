/*     */ package com.android.build.gradle.internal.variant2;
/*     */ 
/*     */ import com.android.build.api.dsl.model.ProductFlavor;
/*     */ import com.android.build.api.dsl.model.VariantProperties;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import com.android.builder.errors.EvalIssueReporter.Type;
/*     */ import com.android.utils.StringHelper;
/*     */ import com.google.common.collect.ArrayListMultimap;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ListMultimap;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.functions.Function2;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=2, d1={"\000v\n\000\n\002\030\002\n\002\030\002\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\020!\n\002\030\002\n\002\b\002\n\002\020\f\n\002\b\003\n\002\020 \n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\"\n\000\n\002\030\002\n\002\b\004\n\002\020\b\n\002\b\002\n\002\030\002\n\002\b\b\032=\020\n\032\004\030\0010\0132\f\020\f\032\b\022\004\022\0020\0160\r2\024\020\017\032\020\022\004\022\0020\016\022\006\022\004\030\0010\0130\0012\b\020\020\032\004\030\0010\021H\002¢\006\002\020\022\032\026\020\023\032\0020\0132\f\020\024\032\b\022\004\022\0020\0260\025H\002\032,\020\027\032\0020\0132\006\020\030\032\0020\0132\b\020\031\032\004\030\0010\0132\006\020\032\032\0020\0332\b\020\034\032\004\030\0010\033H\002\0322\020\035\032\b\022\004\022\0020\0360\0252\f\020\037\032\b\022\004\022\0020\0130\0252\f\020 \032\b\022\004\022\0020\0260!2\006\020\"\032\0020#H\002\032V\020$\032\0020\b2\f\020%\032\b\022\004\022\0020\0360\r2\f\020&\032\b\022\004\022\0020\0260\r2\006\020'\032\0020(2\f\020)\032\b\022\004\022\0020\0130\0252\022\020*\032\016\022\004\022\0020\013\022\004\022\0020\0260+2\006\020\"\032\0020#H\002\032_\020,\032\0020\b\"\004\b\000\020-\"\004\b\001\020.2\006\020/\032\002H-2\f\0200\032\b\022\004\022\002H-0\0252\030\0201\032\024\022\004\022\002H-\022\004\022\002H.\022\004\022\0020\b0\0072\024\020\017\032\020\022\004\022\002H-\022\006\022\004\030\001H.0\001H\002¢\006\002\0202\"\034\020\000\032\020\022\004\022\0020\002\022\006\022\004\030\0010\0030\001X\004¢\006\002\n\000\"\034\020\004\032\020\022\004\022\0020\002\022\006\022\004\030\0010\0050\001X\004¢\006\002\n\000\"\"\020\006\032\026\022\004\022\0020\002\022\006\022\004\030\0010\003\022\004\022\0020\b0\007X\004¢\006\002\n\000\"\"\020\t\032\026\022\004\022\0020\002\022\006\022\004\030\0010\005\022\004\022\0020\b0\007X\004¢\006\002\n\000¨\0063"}, d2={"GET_MULTIDEX_ENABLED", "Lkotlin/Function1;", "Lcom/android/build/api/dsl/model/VariantProperties;", "", "GET_MULTIDEX_KEEPFILE", "Ljava/io/File;", "SET_MULTIDEX_ENABLED", "Lkotlin/Function2;", "", "SET_MULTIDEX_KEEPFILE", "combineSuffixes", "", "items", "", "Lcom/android/build/api/dsl/model/BuildTypeOrProductFlavor;", "getter", "separator", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Ljava/lang/Character;)Ljava/lang/String;", "computeMultiFlavorName", "flavors", "", "Lcom/android/build/api/dsl/model/ProductFlavor;", "computeVariantName", "buildTypeName", "multiFlavorName", "type", "Lcom/android/builder/core/VariantType;", "testedType", "createCombinations", "Lcom/android/build/gradle/internal/variant2/FlavorCombination;", "flavorDimensions", "productFlavors", "", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "createFlavorCombinations", "outCombos", "flavorAccumulator", "index", "", "flavorDimensionList", "flavorMap", "Lcom/google/common/collect/ListMultimap;", "takeLastNonNull", "T", "V", "outObject", "inList", "setter", "(Ljava/lang/Object;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "gradle-core"})
/*     */ public final class VariantBuilderKt
/*     */ {
/* 464 */   private static final Function2<VariantProperties, Boolean, Unit> SET_MULTIDEX_ENABLED = (Function2)SET_MULTIDEX_ENABLED.1.INSTANCE;
/* 465 */   private static final Function1<VariantProperties, Boolean> GET_MULTIDEX_ENABLED = (Function1)GET_MULTIDEX_ENABLED.1.INSTANCE;
/* 466 */   private static final Function2<VariantProperties, File, Unit> SET_MULTIDEX_KEEPFILE = (Function2)SET_MULTIDEX_KEEPFILE.1.INSTANCE;
/* 467 */   private static final Function1<VariantProperties, File> GET_MULTIDEX_KEEPFILE = (Function1)GET_MULTIDEX_KEEPFILE.1.INSTANCE;
/*     */   
/*     */   private static final <T, V> void takeLastNonNull(T outObject, List<? extends T> inList, Function2<? super T, ? super V, Unit> setter, Function1<? super T, ? extends V> getter) {
/* 470 */     int i = inList.size() - 1;int j = 0; int i; for (i < 0;; i--) {
/* 471 */       Object value = getter.invoke(inList.get(i));
/* 472 */       if (value != null) {
/* 473 */         setter.invoke(outObject, value); return;
/*     */       }
/* 470 */       if (i == 0) {
/*     */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static final List<FlavorCombination> createCombinations(List<String> flavorDimensions, Set<? extends ProductFlavor> productFlavors, EvalIssueReporter issueReporter)
/*     */   {
/*     */     ImmutableList flavors;
/*     */     
/* 500 */     if (flavorDimensions.size() == 1) {
/* 501 */       ArrayList result = Lists.newArrayListWithCapacity(productFlavors.size());
/* 502 */       for (Iterator localIterator = productFlavors.iterator(); localIterator.hasNext(); 
/*     */           
/* 504 */           result.add(new FlavorCombination(computeMultiFlavorName((List)tmp64_62), flavors)))
/*     */       {
/* 502 */         ProductFlavor flavor = (ProductFlavor)localIterator.next();
/* 503 */         flavors = ImmutableList.of(flavor);
/* 504 */         Intrinsics.checkExpressionValueIsNotNull(flavors, "flavors");
/*     */       }
/*     */       
/* 507 */       ArrayList tmp89_88 = result;Intrinsics.checkExpressionValueIsNotNull(tmp89_88, "result");return (List)tmp89_88;
/*     */     }
/* 509 */     List result = (List)new ArrayList();
/*     */     
/* 512 */     ArrayListMultimap map = ArrayListMultimap.create();
/*     */     
/* 514 */     for (ProductFlavor flavor : productFlavors) {
/* 515 */       if (flavor.getDimension() == null) {
/* 516 */         issueReporter.reportError(
/* 517 */           EvalIssueReporter.Type.GENERIC, 
/* 518 */           "Flavor '" + flavor.getName() + "' has no flavor dimension.");
/*     */       }
/*     */       else
/*     */       {
/* 522 */         String tmp205_200 = flavor.getDimension();
/*     */         
/* 522 */         if (tmp205_200 == null) Intrinsics.throwNpe(); String flavorDimension = tmp205_200;
/*     */         
/* 524 */         if (!flavorDimensions.contains(flavorDimension)) {
/* 525 */           issueReporter.reportError(
/* 526 */             EvalIssueReporter.Type.GENERIC, 
/* 527 */             "Flavor '" + flavor.getName() + "' has unknown dimension '" + flavorDimension);
/*     */         }
/*     */         else
/*     */         {
/* 531 */           map.put(flavorDimension, flavor);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 537 */     ArrayList tmp296_293 = Lists.newArrayListWithCapacity(flavorDimensions.size());Intrinsics.checkExpressionValueIsNotNull(tmp296_293, "Lists.newArrayListWithCa…ty(flavorDimensions.size)"); ArrayListMultimap 
/* 538 */       tmp309_307 = map;Intrinsics.checkExpressionValueIsNotNull(tmp309_307, "map");createFlavorCombinations(result, (List)tmp296_293, 0, flavorDimensions, (ListMultimap)tmp309_307, issueReporter);
/*     */     
/* 540 */     return result;
/*     */   }
/*     */   
/*     */   private static final void createFlavorCombinations(List<FlavorCombination> outCombos, List<ProductFlavor> flavorAccumulator, int index, List<String> flavorDimensionList, ListMultimap<String, ProductFlavor> flavorMap, EvalIssueReporter issueReporter)
/*     */   {
/* 553 */     if (index == flavorDimensionList.size())
/*     */     {
/* 556 */       ImmutableList tmp26_23 = ImmutableList.copyOf((Collection)flavorAccumulator);Intrinsics.checkExpressionValueIsNotNull(tmp26_23, "ImmutableList.copyOf(flavorAccumulator)");outCombos.add(new FlavorCombination(computeMultiFlavorName(flavorAccumulator), tmp26_23));
/* 557 */       return;
/*     */     }
/*     */     
/* 562 */     String dimensionName = (String)flavorDimensionList.get(index);
/*     */     
/* 565 */     List flavorList = flavorMap.get(dimensionName);
/*     */     
/* 569 */     if (flavorList.isEmpty()) {
/* 570 */       issueReporter.reportError(EvalIssueReporter.Type.GENERIC, 
/* 571 */         "No flavor is associated with flavor dimension '" + dimensionName + "'.");
/* 572 */       return;
/*     */     }
/*     */     
/* 575 */     for (ProductFlavor flavor : flavorList) {
/* 576 */       ProductFlavor tmp146_144 = flavor;Intrinsics.checkExpressionValueIsNotNull(tmp146_144, "flavor");flavorAccumulator.add(tmp146_144);
/*     */       
/* 578 */       createFlavorCombinations(
/* 579 */         outCombos, 
/* 580 */         flavorAccumulator, 
/* 581 */         index + 1, 
/* 582 */         flavorDimensionList, 
/* 583 */         flavorMap, 
/* 584 */         issueReporter);
/*     */       
/* 586 */       flavorAccumulator.remove(index + 1);
/*     */     }
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   private static final String combineSuffixes(List<com.android.build.api.dsl.model.BuildTypeOrProductFlavor> items, Function1<? super com.android.build.api.dsl.model.BuildTypeOrProductFlavor, String> getter, Character separator)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: checkcast 219	java/lang/Iterable
/*     */     //   4: astore 4
/*     */     //   6: aload 4
/*     */     //   8: astore 5
/*     */     //   10: new 99	java/util/ArrayList
/*     */     //   13: dup
/*     */     //   14: invokespecial 108	java/util/ArrayList:<init>	()V
/*     */     //   17: checkcast 185	java/util/Collection
/*     */     //   20: astore 6
/*     */     //   22: aload 5
/*     */     //   24: astore 7
/*     */     //   26: aload 7
/*     */     //   28: invokeinterface 220 1 0
/*     */     //   33: astore 8
/*     */     //   35: aload 8
/*     */     //   37: invokeinterface 67 1 0
/*     */     //   42: ifeq +52 -> 94
/*     */     //   45: aload 8
/*     */     //   47: invokeinterface 71 1 0
/*     */     //   52: astore 9
/*     */     //   54: aload 9
/*     */     //   56: astore 10
/*     */     //   58: aload_1
/*     */     //   59: aload 10
/*     */     //   61: invokeinterface 32 2 0
/*     */     //   66: dup
/*     */     //   67: ifnull +22 -> 89
/*     */     //   70: astore 11
/*     */     //   72: aload 11
/*     */     //   74: astore 12
/*     */     //   76: aload 6
/*     */     //   78: aload 12
/*     */     //   80: invokeinterface 221 2 0
/*     */     //   85: pop
/*     */     //   86: goto +4 -> 90
/*     */     //   89: pop
/*     */     //   90: nop
/*     */     //   91: goto -56 -> 35
/*     */     //   94: nop
/*     */     //   95: aload 6
/*     */     //   97: checkcast 18	java/util/List
/*     */     //   100: astore_3
/*     */     //   101: aload_3
/*     */     //   102: invokeinterface 198 1 0
/*     */     //   107: ifeq +5 -> 112
/*     */     //   110: aconst_null
/*     */     //   111: areturn
/*     */     //   112: new 126	java/lang/StringBuilder
/*     */     //   115: dup
/*     */     //   116: invokespecial 127	java/lang/StringBuilder:<init>	()V
/*     */     //   119: astore 4
/*     */     //   121: aload_3
/*     */     //   122: invokeinterface 203 1 0
/*     */     //   127: astore 6
/*     */     //   129: aload 6
/*     */     //   131: invokeinterface 67 1 0
/*     */     //   136: ifeq +61 -> 197
/*     */     //   139: aload 6
/*     */     //   141: invokeinterface 71 1 0
/*     */     //   146: checkcast 183	java/lang/String
/*     */     //   149: astore 5
/*     */     //   151: aload_2
/*     */     //   152: ifnull +16 -> 168
/*     */     //   155: aload 5
/*     */     //   157: iconst_0
/*     */     //   158: invokevirtual 225	java/lang/String:charAt	(I)C
/*     */     //   161: aload_2
/*     */     //   162: invokevirtual 231	java/lang/Character:charValue	()C
/*     */     //   165: if_icmpne +14 -> 179
/*     */     //   168: aload 4
/*     */     //   170: aload 5
/*     */     //   172: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   175: pop
/*     */     //   176: goto +18 -> 194
/*     */     //   179: aload 4
/*     */     //   181: aload_2
/*     */     //   182: invokevirtual 231	java/lang/Character:charValue	()C
/*     */     //   185: invokevirtual 234	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
/*     */     //   188: aload 5
/*     */     //   190: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   193: pop
/*     */     //   194: goto -65 -> 129
/*     */     //   197: aload 4
/*     */     //   199: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   202: areturn
/*     */     // Line number table:
/*     */     //   Java source line #594	-> byte code offset #0
/*     */     //   Java source line #663	-> byte code offset #6
/*     */     //   Java source line #671	-> byte code offset #22
/*     */     //   Java source line #672	-> byte code offset #26
/*     */     //   Java source line #671	-> byte code offset #58
/*     */     //   Java source line #671	-> byte code offset #76
/*     */     //   Java source line #671	-> byte code offset #86
/*     */     //   Java source line #671	-> byte code offset #90
/*     */     //   Java source line #673	-> byte code offset #94
/*     */     //   Java source line #674	-> byte code offset #95
/*     */     //   Java source line #594	-> byte code offset #100
/*     */     //   Java source line #596	-> byte code offset #101
/*     */     //   Java source line #597	-> byte code offset #110
/*     */     //   Java source line #600	-> byte code offset #112
/*     */     //   Java source line #601	-> byte code offset #121
/*     */     //   Java source line #602	-> byte code offset #151
/*     */     //   Java source line #603	-> byte code offset #168
/*     */     //   Java source line #605	-> byte code offset #179
/*     */     //   Java source line #606	-> byte code offset #194
/*     */     //   Java source line #601	-> byte code offset #194
/*     */     //   Java source line #609	-> byte code offset #197
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	203	0	items	List
/*     */     //   0	203	1	getter	Function1
/*     */     //   0	203	2	separator	Character
/*     */     //   101	102	3	suffixes	List
/*     */     //   6	94	4	$receiver$iv	Iterable
/*     */     //   121	82	4	sb	StringBuilder
/*     */     //   22	75	5	$receiver$iv$iv	Iterable
/*     */     //   151	43	5	suffix	String
/*     */     //   22	75	6	destination$iv$iv	Collection
/*     */     //   26	69	7	$receiver$iv$iv$iv	Iterable
/*     */     //   54	37	9	element$iv$iv$iv	Object
/*     */     //   58	32	10	element$iv$iv	Object
/*     */     //   76	9	12	it$iv$iv	Object
/*     */     //   76	9	13	$i$a$1$let	int
/*     */     //   58	32	14	$i$a$1$forEach	int
/*     */     //   26	69	15	$i$f$forEach	int
/*     */     //   22	75	16	$i$f$mapNotNullTo	int
/*     */     //   6	94	17	$i$f$mapNotNull	int
/*     */   }
/*     */   
/*     */   private static final String computeMultiFlavorName(List<? extends ProductFlavor> flavors)
/*     */   {
/* 614 */     boolean first = true;
/* 615 */     StringBuilder sb = new StringBuilder(flavors.size() * 20);
/* 616 */     for (ProductFlavor flavor : flavors) {
/* 617 */       if (first) {
/* 618 */         sb.append(flavor.getName());
/* 619 */         first = false;
/*     */       } else {
/* 621 */         StringHelper.appendCapitalized(sb, flavor.getName());
/*     */       }
/*     */     }
/*     */     
/* 625 */     String tmp85_82 = sb.toString();Intrinsics.checkExpressionValueIsNotNull(tmp85_82, "sb.toString()");return tmp85_82;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   private static final String computeVariantName(String buildTypeName, String multiFlavorName, com.android.builder.core.VariantType type, com.android.builder.core.VariantType testedType)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: new 126	java/lang/StringBuilder
/*     */     //   3: dup
/*     */     //   4: invokespecial 127	java/lang/StringBuilder:<init>	()V
/*     */     //   7: astore 4
/*     */     //   9: aload 4
/*     */     //   11: astore 5
/*     */     //   13: aload_1
/*     */     //   14: dup
/*     */     //   15: ifnull +29 -> 44
/*     */     //   18: checkcast 272	java/lang/CharSequence
/*     */     //   21: astore 6
/*     */     //   23: aload 6
/*     */     //   25: invokeinterface 275 1 0
/*     */     //   30: ifne +7 -> 37
/*     */     //   33: iconst_1
/*     */     //   34: goto +4 -> 38
/*     */     //   37: iconst_0
/*     */     //   38: ifne +30 -> 68
/*     */     //   41: goto +7 -> 48
/*     */     //   44: pop
/*     */     //   45: goto +23 -> 68
/*     */     //   48: aload 5
/*     */     //   50: aload_1
/*     */     //   51: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   54: pop
/*     */     //   55: aload 5
/*     */     //   57: aload_0
/*     */     //   58: invokestatic 281	kotlin/text/StringsKt:capitalize	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   61: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   64: pop
/*     */     //   65: goto +10 -> 75
/*     */     //   68: aload 5
/*     */     //   70: aload_0
/*     */     //   71: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   74: pop
/*     */     //   75: aload_2
/*     */     //   76: getstatic 287	com/android/builder/core/VariantType:FEATURE	Lcom/android/builder/core/VariantType;
/*     */     //   79: invokestatic 290	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   82: ifeq +12 -> 94
/*     */     //   85: aload 5
/*     */     //   87: ldc_w 292
/*     */     //   90: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   93: pop
/*     */     //   94: aload_2
/*     */     //   95: invokevirtual 295	com/android/builder/core/VariantType:isForTesting	()Z
/*     */     //   98: ifeq +32 -> 130
/*     */     //   101: aload_3
/*     */     //   102: getstatic 287	com/android/builder/core/VariantType:FEATURE	Lcom/android/builder/core/VariantType;
/*     */     //   105: invokestatic 290	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   108: ifeq +12 -> 120
/*     */     //   111: aload 5
/*     */     //   113: ldc_w 292
/*     */     //   116: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   119: pop
/*     */     //   120: aload 5
/*     */     //   122: aload_2
/*     */     //   123: invokevirtual 298	com/android/builder/core/VariantType:getSuffix	()Ljava/lang/String;
/*     */     //   126: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   129: pop
/*     */     //   130: nop
/*     */     //   131: aload 4
/*     */     //   133: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   136: dup
/*     */     //   137: ldc_w 300
/*     */     //   140: invokestatic 89	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   143: areturn
/*     */     // Line number table:
/*     */     //   Java source line #642	-> byte code offset #0
/*     */     //   Java source line #643	-> byte code offset #13
/*     */     //   Java source line #644	-> byte code offset #48
/*     */     //   Java source line #645	-> byte code offset #55
/*     */     //   Java source line #647	-> byte code offset #68
/*     */     //   Java source line #648	-> byte code offset #75
/*     */     //   Java source line #650	-> byte code offset #75
/*     */     //   Java source line #651	-> byte code offset #85
/*     */     //   Java source line #654	-> byte code offset #94
/*     */     //   Java source line #655	-> byte code offset #101
/*     */     //   Java source line #656	-> byte code offset #111
/*     */     //   Java source line #658	-> byte code offset #120
/*     */     //   Java source line #660	-> byte code offset #130
/*     */     //   Java source line #642	-> byte code offset #131
/*     */     //   Java source line #660	-> byte code offset #143
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	144	0	buildTypeName	String
/*     */     //   0	144	1	multiFlavorName	String
/*     */     //   0	144	2	type	com.android.builder.core.VariantType
/*     */     //   0	144	3	testedType	com.android.builder.core.VariantType
/*     */     //   13	117	5	$receiver	StringBuilder
/*     */     //   13	117	7	$i$a$1$buildString	int
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.VariantBuilderKt
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */