/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import com.google.common.collect.FluentIterable;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.Callable;
/*     */ 
/*     */ class FullRunShrinker$1
/*     */   implements Callable<Void>
/*     */ {
/* 252 */   final Set<T> methods = this$0mGraph.getMethods(val$klass);
/*     */   
/*     */   FullRunShrinker$1(FullRunShrinker this$0, Object paramObject) {}
/*     */   
/*     */   public Void call() throws Exception {
/*     */     try {
/* 258 */       T superclass = this$0.mGraph.getSuperclass(val$klass);
/*     */       
/* 260 */       if ((superclass == null) || (!this$0.isProgramClass(superclass)))
/*     */       {
/* 262 */         return null;
/*     */       }
/*     */       
/* 268 */       Iterable<T> interfaces = TypeHierarchyTraverser.interfaces(this$0.mGraph, this$0.mShrinkerLogger).preOrderTraversal(val$klass).skip(1);
/*     */       
/* 270 */       for (T iface : interfaces) {
/* 271 */         for (T method : this$0.mGraph.getMethods(iface)) {
/* 272 */           handleMethod(method);
/*     */         }
/*     */       }
/* 275 */       return null;
/*     */     } catch (ClassLookupException e) {
/* 277 */       this$0.mShrinkerLogger.invalidClassReference(this$0.mGraph
/* 278 */         .getClassName(val$klass), e.getClassName()); }
/* 279 */     return null;
/*     */   }
/*     */   
/*     */   private void handleMethod(T method)
/*     */   {
/* 284 */     if (methods.contains(method))
/*     */     {
/* 287 */       return;
/*     */     }
/*     */     
/* 295 */     FluentIterable<T> superclasses = TypeHierarchyTraverser.superclasses(this$0.mGraph, this$0.mShrinkerLogger).preOrderTraversal(val$klass).skip(1);
/*     */     
/* 297 */     for (T current : superclasses) {
/* 298 */       if (!this$0.isProgramClass(current))
/*     */       {
/* 300 */         return;
/*     */       }
/*     */       
/* 303 */       T matchingMethod = this$0.mGraph.findMatchingMethod(current, method);
/* 304 */       if (matchingMethod != null)
/*     */       {
/* 306 */         String name = this$0.mGraph.getMemberName(method) + "$shrinker_fake";
/* 307 */         String desc = this$0.mGraph.getMemberDescriptor(method);
/*     */         
/* 309 */         T fakeMethod = this$0.mGraph.addMember(val$klass, name, desc, this$0.mGraph
/* 310 */           .getModifiers(method));
/*     */         
/* 313 */         this$0.mGraph.addDependency(fakeMethod, matchingMethod, DependencyType.REQUIRED_CLASS_STRUCTURE);
/*     */         
/* 318 */         if (!this$0.isProgramClass(this$0.mGraph.getOwnerClass(method))) {
/* 319 */           this$0.mGraph.addDependency(val$klass, fakeMethod, DependencyType.REQUIRED_CLASS_STRUCTURE);
/*     */         }
/*     */         else
/*     */         {
/* 324 */           this$0.mGraph.addDependency(val$klass, fakeMethod, DependencyType.CLASS_IS_KEPT);
/*     */           
/* 326 */           this$0.mGraph.addDependency(method, fakeMethod, DependencyType.IF_CLASS_KEPT);
/*     */         }
/*     */         
/* 330 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.FullRunShrinker.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */