/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import com.android.build.FilterData;
/*     */ import com.android.build.VariantOutput.FilterType;
/*     */ import com.android.build.VariantOutput.OutputType;
/*     */ import com.android.ide.common.build.ApkData;
/*     */ import com.android.utils.StringHelper;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.UnmodifiableIterator;
/*     */ import java.io.File;
/*     */ import java.util.Iterator;
/*     */ import java.util.Objects;
/*     */ 
/*     */ class OutputFactory$FullSplit
/*     */   extends OutputFactory.Universal
/*     */ {
/*     */   private final ImmutableList<FilterData> filters;
/*     */   private final String filterName;
/*     */   
/*     */   private OutputFactory$FullSplit(String filterName, String baseName, String fullName, String fileName, ImmutableList<FilterData> filters)
/*     */   {
/* 313 */     super(baseName, fullName, fileName, null);
/* 314 */     this.filterName = filterName;
/* 315 */     this.filters = filters;
/*     */   }
/*     */   
/*     */   private static String _getFilterName(ImmutableList<FilterData> filters) {
/* 319 */     StringBuilder sb = new StringBuilder();
/* 320 */     String densityFilter = ApkData.getFilter(filters, VariantOutput.FilterType.DENSITY);
/* 321 */     if (densityFilter != null) {
/* 322 */       sb.append(densityFilter);
/*     */     }
/* 324 */     String abiFilter = getFilter(filters, VariantOutput.FilterType.ABI);
/* 325 */     if (abiFilter != null) {
/* 326 */       StringHelper.appendCamelCase(sb, abiFilter);
/*     */     }
/* 328 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public VariantOutput.OutputType getType()
/*     */   {
/* 334 */     return VariantOutput.OutputType.FULL_SPLIT;
/*     */   }
/*     */   
/*     */   public ImmutableList<FilterData> getFilters()
/*     */   {
/* 340 */     return filters;
/*     */   }
/*     */   
/*     */   public String getFilterName()
/*     */   {
/* 346 */     return filterName;
/*     */   }
/*     */   
/*     */   public String getDirName()
/*     */   {
/* 352 */     StringBuilder sb = new StringBuilder();
/* 353 */     for (UnmodifiableIterator localUnmodifiableIterator = getFilters().iterator(); localUnmodifiableIterator.hasNext();) { FilterData filter = (FilterData)localUnmodifiableIterator.next();
/* 354 */       sb.append(filter.getIdentifier()).append(File.separatorChar);
/*     */     }
/* 356 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 361 */     if (this == o) {
/* 362 */       return true;
/*     */     }
/* 364 */     if ((o == null) || (getClass() != o.getClass())) {
/* 365 */       return false;
/*     */     }
/* 367 */     if (!super.equals(o)) {
/* 368 */       return false;
/*     */     }
/* 370 */     FullSplit that = (FullSplit)o;
/* 371 */     return (Objects.equals(filterName, filterName)) && 
/* 372 */       (Objects.equals(filters, filters));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 377 */     return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), filterName, filters });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.OutputFactory.FullSplit
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */