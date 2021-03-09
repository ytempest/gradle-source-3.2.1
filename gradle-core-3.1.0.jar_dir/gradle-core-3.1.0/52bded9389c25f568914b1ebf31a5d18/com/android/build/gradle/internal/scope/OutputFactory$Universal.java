/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import com.android.build.FilterData;
/*     */ import com.android.build.VariantOutput.OutputType;
/*     */ import com.android.ide.common.build.ApkData;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.Objects;
/*     */ 
/*     */ class OutputFactory$Universal
/*     */   extends ApkData
/*     */ {
/*     */   private final String baseName;
/*     */   private final String fullName;
/*     */   
/*     */   private OutputFactory$Universal(String baseName, String fullName, String fileName)
/*     */   {
/* 239 */     this.baseName = baseName;
/* 240 */     this.fullName = fullName;
/* 241 */     setOutputFileName(fileName);
/*     */   }
/*     */   
/*     */   public VariantOutput.OutputType getType()
/*     */   {
/* 247 */     return VariantOutput.OutputType.FULL_SPLIT;
/*     */   }
/*     */   
/*     */   public String getFilterName()
/*     */   {
/* 253 */     return "universal";
/*     */   }
/*     */   
/*     */   public String getBaseName()
/*     */   {
/* 259 */     return baseName;
/*     */   }
/*     */   
/*     */   public String getFullName()
/*     */   {
/* 265 */     return fullName;
/*     */   }
/*     */   
/*     */   public String getDirName()
/*     */   {
/* 271 */     if (getFilters().isEmpty()) {
/* 272 */       return "universal";
/*     */     }
/* 274 */     StringBuilder sb = new StringBuilder();
/* 275 */     for (FilterData filter : getFilters()) {
/* 276 */       sb.append(filter.getIdentifier()).append(File.separatorChar);
/*     */     }
/* 278 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 283 */     if (this == o) {
/* 284 */       return true;
/*     */     }
/* 286 */     if ((o == null) || (getClass() != o.getClass())) {
/* 287 */       return false;
/*     */     }
/* 289 */     if (!super.equals(o)) {
/* 290 */       return false;
/*     */     }
/* 292 */     Universal that = (Universal)o;
/* 293 */     return (Objects.equals(baseName, baseName)) && 
/* 294 */       (Objects.equals(fullName, fullName));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 299 */     return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), baseName, fullName });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.OutputFactory.Universal
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */