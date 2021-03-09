/*     */ package com.android.build.gradle.internal.variant2;
/*     */ 
/*     */ import com.android.build.api.dsl.model.ProductFlavor;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Named;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000$\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020 \n\002\b\007\b\002\030\0002\0020\001B\035\022\b\020\002\032\004\030\0010\003\022\f\020\004\032\b\022\004\022\0020\0060\005¢\006\002\020\007R\027\020\b\032\b\022\004\022\0020\0030\t¢\006\b\n\000\032\004\b\n\020\013R\027\020\004\032\b\022\004\022\0020\0060\005¢\006\b\n\000\032\004\b\f\020\rR\023\020\002\032\004\030\0010\003¢\006\b\n\000\032\004\b\016\020\017¨\006\020"}, d2={"Lcom/android/build/gradle/internal/variant2/FlavorCombination;", "", "name", "", "flavors", "Lcom/google/common/collect/ImmutableList;", "Lcom/android/build/api/dsl/model/ProductFlavor;", "(Ljava/lang/String;Lcom/google/common/collect/ImmutableList;)V", "flavorNames", "", "getFlavorNames", "()Ljava/util/List;", "getFlavors", "()Lcom/google/common/collect/ImmutableList;", "getName", "()Ljava/lang/String;", "gradle-core"})
/*     */ final class FlavorCombination
/*     */ {
/*     */   @NotNull
/*     */   private final List<String> flavorNames;
/*     */   @Nullable
/*     */   private final String name;
/*     */   @NotNull
/*     */   private final ImmutableList<ProductFlavor> flavors;
/*     */   
/*     */   @Nullable
/* 485 */   public final String getName() { return name; } @NotNull
/* 485 */   public final ImmutableList<ProductFlavor> getFlavors() { return flavors; } @NotNull
/* 486 */   public final List<String> getFlavorNames() { return flavorNames; }
/*     */   
/*     */   public FlavorCombination(@Nullable String name, @NotNull ImmutableList<ProductFlavor> flavors)
/*     */   {
/* 485 */     this.name = name;this.flavors = flavors;
/* 486 */     Iterable localIterable1 = (Iterable)this.flavors;FlavorCombination localFlavorCombination = this;
/*     */     
/*     */     int $i$f$map;
/*     */     
/*     */     Iterable $receiver$iv;
/*     */     
/* 663 */     Iterable localIterable2 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 664 */     int $i$f$mapTo; Iterable $receiver$iv$iv; String str; for (Iterator localIterator = $receiver$iv$iv.iterator(); localIterator.hasNext(); ((Collection)localObject1).add(str))
/*     */     {
/* 664 */       Object item$iv$iv = localIterator.next();
/* 665 */       Named localNamed1 = (Named)item$iv$iv;localObject1 = destination$iv$iv;
/*     */       int $i$a$1$unknown;
/*     */       Named p1;
/* 486 */       str = 
/*     */       
/* 665 */         p1.getName();
/*     */     }
/*     */     
/* 666 */     Object localObject1 = (List)destination$iv$iv; ImmutableList tmp130_127 = ImmutableList.copyOf((Collection)localObject1);Intrinsics.checkExpressionValueIsNotNull(tmp130_127, "ImmutableList.copyOf(flavors.map(Named::getName))");flavorNames = ((List)tmp130_127);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.FlavorCombination
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */