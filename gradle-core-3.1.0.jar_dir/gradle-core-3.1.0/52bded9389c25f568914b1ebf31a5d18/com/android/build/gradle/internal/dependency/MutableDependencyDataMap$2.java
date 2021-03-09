/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import com.android.builder.dependency.level2.Dependency;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.util.List;
/*     */ 
/*     */ final class MutableDependencyDataMap$2
/*     */   implements MutableDependencyDataMap
/*     */ {
/*     */   public void skip(Dependency dependency)
/*     */   {
/* 104 */     throw new RuntimeException(String.format("cannot set skipped attribute on a dependency with another scope than Package : %1$s", new Object[] { dependency }));
/*     */   }
/*     */   
/*     */   public boolean isSkipped(Dependency library)
/*     */   {
/* 110 */     return false;
/*     */   }
/*     */   
/*     */   public void setProvided(Dependency dependency)
/*     */   {
/* 115 */     throw new RuntimeException(String.format("cannot set skipped attribute on a dependency with another scope than Compile : %1$s", new Object[] { dependency }));
/*     */   }
/*     */   
/*     */   public boolean isProvided(Dependency dependency)
/*     */   {
/* 121 */     return false;
/*     */   }
/*     */   
/*     */   public List<String> getProvidedList()
/*     */   {
/* 127 */     return ImmutableList.of();
/*     */   }
/*     */   
/*     */   public List<String> getSkippedList()
/*     */   {
/* 133 */     return ImmutableList.of();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.MutableDependencyDataMap.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */