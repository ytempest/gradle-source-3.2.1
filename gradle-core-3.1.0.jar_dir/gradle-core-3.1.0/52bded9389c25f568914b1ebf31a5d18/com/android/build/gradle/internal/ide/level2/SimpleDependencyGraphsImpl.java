/*    */ package com.android.build.gradle.internal.ide.level2;
/*    */ 
/*    */ import com.android.builder.model.level2.DependencyGraphs;
/*    */ import com.android.builder.model.level2.GraphItem;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import java.io.Serializable;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ 
/*    */ public class SimpleDependencyGraphsImpl
/*    */   implements DependencyGraphs, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final List<GraphItem> items;
/*    */   private final List<String> providedLibraries;
/*    */   private final int hashCode;
/*    */   
/*    */   public SimpleDependencyGraphsImpl(List<GraphItem> items, List<String> providedLibraries)
/*    */   {
/* 37 */     this.items = items;
/* 38 */     this.providedLibraries = ImmutableList.copyOf(providedLibraries);
/* 39 */     hashCode = computeHashCode();
/*    */   }
/*    */   
/*    */   public List<GraphItem> getCompileDependencies()
/*    */   {
/* 45 */     return items;
/*    */   }
/*    */   
/*    */   public List<GraphItem> getPackageDependencies()
/*    */   {
/* 51 */     return Collections.emptyList();
/*    */   }
/*    */   
/*    */   public List<String> getProvidedLibraries()
/*    */   {
/* 57 */     return providedLibraries;
/*    */   }
/*    */   
/*    */   public List<String> getSkippedLibraries()
/*    */   {
/* 63 */     return Collections.emptyList();
/*    */   }
/*    */   
/*    */   public boolean equals(Object o)
/*    */   {
/* 68 */     if (this == o) {
/* 69 */       return true;
/*    */     }
/* 71 */     if ((o == null) || (getClass() != o.getClass())) {
/* 72 */       return false;
/*    */     }
/*    */     
/* 75 */     SimpleDependencyGraphsImpl that = (SimpleDependencyGraphsImpl)o;
/*    */     
/* 77 */     return (items.equals(items)) && (providedLibraries.equals(providedLibraries));
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 83 */     return hashCode;
/*    */   }
/*    */   
/*    */   private int computeHashCode() {
/* 87 */     int result = items.hashCode();
/* 88 */     result = 31 * result + providedLibraries.hashCode();
/* 89 */     return result;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.level2.SimpleDependencyGraphsImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */