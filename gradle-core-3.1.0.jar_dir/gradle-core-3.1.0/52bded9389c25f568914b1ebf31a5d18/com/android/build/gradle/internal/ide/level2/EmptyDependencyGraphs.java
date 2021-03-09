/*    */ package com.android.build.gradle.internal.ide.level2;
/*    */ 
/*    */ import com.android.builder.model.level2.DependencyGraphs;
/*    */ import com.android.builder.model.level2.GraphItem;
/*    */ import java.io.Serializable;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ 
/*    */ public class EmptyDependencyGraphs
/*    */   implements DependencyGraphs, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public List<GraphItem> getCompileDependencies()
/*    */   {
/* 36 */     return Collections.emptyList();
/*    */   }
/*    */   
/*    */   public List<GraphItem> getPackageDependencies()
/*    */   {
/* 42 */     return Collections.emptyList();
/*    */   }
/*    */   
/*    */   public List<String> getProvidedLibraries()
/*    */   {
/* 48 */     return Collections.emptyList();
/*    */   }
/*    */   
/*    */   public List<String> getSkippedLibraries()
/*    */   {
/* 54 */     return Collections.emptyList();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.level2.EmptyDependencyGraphs
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */