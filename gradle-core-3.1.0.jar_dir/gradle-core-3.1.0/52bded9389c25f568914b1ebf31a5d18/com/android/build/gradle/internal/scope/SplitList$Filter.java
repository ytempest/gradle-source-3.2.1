/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ public final class SplitList$Filter
/*     */ {
/*     */   private final String value;
/*     */   
/*     */   private final String simplifiedName;
/*     */   
/*     */   public SplitList$Filter(String value, String simplifiedName)
/*     */   {
/* 169 */     this.value = value;
/* 170 */     this.simplifiedName = simplifiedName;
/*     */   }
/*     */   
/*     */   public SplitList$Filter(String value) {
/* 174 */     this(value, null);
/*     */   }
/*     */   
/*     */   public String getValue()
/*     */   {
/* 179 */     return value;
/*     */   }
/*     */   
/*     */   public String getDisplayName()
/*     */   {
/* 184 */     return simplifiedName != null ? simplifiedName : value;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.SplitList.Filter
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */