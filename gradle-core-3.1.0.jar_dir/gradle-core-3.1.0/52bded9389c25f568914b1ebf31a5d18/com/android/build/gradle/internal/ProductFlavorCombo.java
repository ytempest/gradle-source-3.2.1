/*     */ package com.android.build.gradle.internal;
/*     */ 
/*     */ import com.android.builder.model.DimensionAware;
/*     */ import com.android.utils.StringHelper;
/*     */ import com.google.common.base.Predicates;
/*     */ import com.google.common.collect.ArrayListMultimap;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.google.common.collect.ListMultimap;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.gradle.api.Named;
/*     */ 
/*     */ public class ProductFlavorCombo<T extends DimensionAware,  extends Named>
/*     */ {
/*     */   private String name;
/*     */   private final List<T> flavorList;
/*     */   
/*     */   public ProductFlavorCombo(T... flavors)
/*     */   {
/*  46 */     flavorList = ImmutableList.copyOf(flavors);
/*     */   }
/*     */   
/*     */   public ProductFlavorCombo(Iterable<T> flavors) {
/*  50 */     flavorList = ImmutableList.copyOf(flavors);
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  55 */     if (name == null) {
/*  56 */       boolean first = true;
/*  57 */       StringBuilder sb = new StringBuilder();
/*  58 */       for (T flavor : flavorList) {
/*  59 */         if (first) {
/*  60 */           sb.append(((Named)flavor).getName());
/*  61 */           first = false;
/*     */         } else {
/*  63 */           StringHelper.appendCapitalized(sb, ((Named)flavor).getName());
/*     */         }
/*     */       }
/*  66 */       name = sb.toString();
/*     */     }
/*  68 */     return name;
/*     */   }
/*     */   
/*     */   public List<T> getFlavorList()
/*     */   {
/*  73 */     return flavorList;
/*     */   }
/*     */   
/*     */   public static <S extends DimensionAware,  extends Named> List<ProductFlavorCombo<S>> createCombinations(List<String> flavorDimensions, Iterable<S> productFlavors)
/*     */   {
/*  87 */     List<ProductFlavorCombo<S>> result = Lists.newArrayList();
/*  88 */     Iterator localIterator; S flavor; if ((flavorDimensions == null) || (flavorDimensions.isEmpty())) {
/*  89 */       for (localIterator = productFlavors.iterator(); localIterator.hasNext();) { flavor = (DimensionAware)localIterator.next();
/*  90 */         result.add(new ProductFlavorCombo(ImmutableList.of(flavor)));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  95 */       Object map = ArrayListMultimap.create();
/*  96 */       for (S flavor : productFlavors) {
/*  97 */         String flavorDimension = flavor.getDimension();
/*     */         
/*  99 */         if (flavorDimension == null) {
/* 100 */           throw new RuntimeException(String.format("Flavor '%1$s' has no flavor dimension.", new Object[] {((Named)flavor)
/* 101 */             .getName() }));
/*     */         }
/* 103 */         if (!flavorDimensions.contains(flavorDimension)) {
/* 104 */           throw new RuntimeException(String.format("Flavor '%1$s' has unknown dimension '%2$s'.", new Object[] {((Named)flavor)
/*     */           
/* 106 */             .getName(), flavor.getDimension() }));
/*     */         }
/*     */         
/* 109 */         ((ArrayListMultimap)map).put(flavorDimension, flavor);
/*     */       }
/*     */       
/* 112 */       createProductFlavorCombinations(result, 
/* 113 */         Lists.newArrayListWithCapacity(flavorDimensions.size()), 0, flavorDimensions, (ListMultimap)map);
/*     */     }
/*     */     
/* 116 */     return result;
/*     */   }
/*     */   
/*     */   private static <S extends DimensionAware,  extends Named> void createProductFlavorCombinations(List<ProductFlavorCombo<S>> flavorGroups, List<S> group, int index, List<String> flavorDimensionList, ListMultimap<String, S> map)
/*     */   {
/* 125 */     if (index == flavorDimensionList.size()) {
/* 126 */       flavorGroups.add(new ProductFlavorCombo(Iterables.filter(group, Predicates.notNull())));
/* 127 */       return;
/*     */     }
/*     */     
/* 132 */     String dimension = (String)flavorDimensionList.get(index);
/*     */     
/* 135 */     List<S> flavorList = map.get(dimension);
/*     */     
/* 139 */     if (flavorList.isEmpty()) {
/* 140 */       throw new RuntimeException(String.format("No flavor is associated with flavor dimension '%1$s'.", new Object[] { dimension }));
/*     */     }
/*     */     
/* 143 */     for (S flavor : flavorList) {
/* 144 */       group.add(flavor);
/* 145 */       createProductFlavorCombinations(flavorGroups, group, index + 1, flavorDimensionList, map);
/*     */       
/* 147 */       group.remove(group.size() - 1);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ProductFlavorCombo
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */