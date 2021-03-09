/*    */ package com.android.build.gradle.shrinker;
/*    */ 
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.Set;
/*    */ 
/*    */ class PostProcessingData<T>
/*    */ {
/*    */   private final Set<T> virtualMethods;
/*    */   private final Set<T> multipleInheritance;
/*    */   private final Set<T> interfaceInheritance;
/*    */   
/*    */   PostProcessingData()
/*    */   {
/* 31 */     virtualMethods = Sets.newConcurrentHashSet();
/* 32 */     multipleInheritance = Sets.newConcurrentHashSet();
/* 33 */     interfaceInheritance = Sets.newConcurrentHashSet();
/*    */   }
/*    */   
/* 36 */   private final Set<UnresolvedReference<T>> unresolvedReferences = Sets.newConcurrentHashSet();
/*    */   
/*    */   Set<T> getVirtualMethods()
/*    */   {
/* 40 */     return virtualMethods;
/*    */   }
/*    */   
/*    */   Set<T> getMultipleInheritance()
/*    */   {
/* 45 */     return multipleInheritance;
/*    */   }
/*    */   
/*    */   Set<T> getInterfaceInheritance()
/*    */   {
/* 50 */     return interfaceInheritance;
/*    */   }
/*    */   
/*    */   Set<UnresolvedReference<T>> getUnresolvedReferences()
/*    */   {
/* 55 */     return unresolvedReferences;
/*    */   }
/*    */   
/*    */   static class UnresolvedReference<T>
/*    */   {
/*    */     final T method;
/*    */     
/*    */     final T target;
/*    */     final boolean invokespecial;
/*    */     final DependencyType dependencyType;
/*    */     
/*    */     public UnresolvedReference(T referencingMethod, T target, boolean invokespecial, DependencyType dependencyType)
/*    */     {
/* 69 */       method = referencingMethod;
/* 70 */       this.target = target;
/* 71 */       this.dependencyType = dependencyType;
/* 72 */       this.invokespecial = invokespecial;
/*    */     }
/*    */     
/*    */     public String toString()
/*    */     {
/* 77 */       return 
/*    */       
/* 81 */         MoreObjects.toStringHelper(this).add("method", method).add("target", target).add("invokespecial", invokespecial).toString();
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.PostProcessingData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */