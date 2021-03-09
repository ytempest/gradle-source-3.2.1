/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import com.android.build.FilterData;
/*     */ import com.android.build.VariantOutput.OutputType;
/*     */ import com.android.ide.common.build.ApkData;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.util.Objects;
/*     */ 
/*     */ public class OutputFactory$ConfigurationSplitApkData
/*     */   extends ApkData
/*     */ {
/*     */   private final String filterName;
/*     */   private final String baseName;
/*     */   private final String fullName;
/*     */   private final String dirName;
/*     */   private final ImmutableList<FilterData> filters;
/*     */   
/*     */   public OutputFactory$ConfigurationSplitApkData(String filterName, String baseName, String fullName, String dirName, String fileName, ImmutableList<FilterData> filters)
/*     */   {
/* 393 */     this.filters = filters;
/* 394 */     this.filterName = filterName;
/* 395 */     this.baseName = baseName;
/* 396 */     this.fullName = fullName;
/* 397 */     this.dirName = dirName;
/* 398 */     setOutputFileName(fileName);
/*     */   }
/*     */   
/*     */   public VariantOutput.OutputType getType()
/*     */   {
/* 404 */     return VariantOutput.OutputType.SPLIT;
/*     */   }
/*     */   
/*     */   public boolean requiresAapt()
/*     */   {
/* 409 */     return false;
/*     */   }
/*     */   
/*     */   public String getFilterName()
/*     */   {
/* 415 */     return filterName;
/*     */   }
/*     */   
/*     */   public ImmutableList<FilterData> getFilters()
/*     */   {
/* 421 */     return filters;
/*     */   }
/*     */   
/*     */   public String getBaseName()
/*     */   {
/* 427 */     return baseName;
/*     */   }
/*     */   
/*     */   public String getFullName()
/*     */   {
/* 433 */     return fullName;
/*     */   }
/*     */   
/*     */   public String getDirName()
/*     */   {
/* 439 */     return dirName;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 444 */     if (this == o) {
/* 445 */       return true;
/*     */     }
/* 447 */     if ((o == null) || (getClass() != o.getClass())) {
/* 448 */       return false;
/*     */     }
/* 450 */     if (!super.equals(o)) {
/* 451 */       return false;
/*     */     }
/* 453 */     ConfigurationSplitApkData that = (ConfigurationSplitApkData)o;
/* 454 */     if ((Objects.equals(baseName, baseName)) && 
/* 455 */       (Objects.equals(fullName, fullName)) && 
/* 456 */       (Objects.equals(dirName, dirName))) {}
/* 454 */     return 
/*     */     
/* 458 */       Objects.equals(filterName, filterName);
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 463 */     return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), baseName, fullName, dirName, filterName });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.OutputFactory.ConfigurationSplitApkData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */