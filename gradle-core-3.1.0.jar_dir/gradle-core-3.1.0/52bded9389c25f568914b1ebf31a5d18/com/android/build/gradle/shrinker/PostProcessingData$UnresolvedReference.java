/*    */ package com.android.build.gradle.shrinker;
/*    */ 
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ 
/*    */ class PostProcessingData$UnresolvedReference<T>
/*    */ {
/*    */   final T method;
/*    */   final T target;
/*    */   final boolean invokespecial;
/*    */   final DependencyType dependencyType;
/*    */   
/*    */   public PostProcessingData$UnresolvedReference(T referencingMethod, T target, boolean invokespecial, DependencyType dependencyType)
/*    */   {
/* 69 */     method = referencingMethod;
/* 70 */     this.target = target;
/* 71 */     this.dependencyType = dependencyType;
/* 72 */     this.invokespecial = invokespecial;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 77 */     return 
/*    */     
/* 81 */       MoreObjects.toStringHelper(this).add("method", method).add("target", target).add("invokespecial", invokespecial).toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.PostProcessingData.UnresolvedReference
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */