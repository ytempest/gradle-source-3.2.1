/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import java.util.Set;
/*     */ import org.objectweb.asm.ClassVisitor;
/*     */ 
/*     */ class FullRunShrinker$2
/*     */   extends DependencyFinderVisitor<T>
/*     */ {
/*     */   FullRunShrinker$2(FullRunShrinker this$0, ShrinkerGraph graph, ClassVisitor cv, PostProcessingData paramPostProcessingData)
/*     */   {
/* 426 */     super(graph, cv);
/*     */   }
/*     */   
/* 429 */   protected void handleDependency(T source, T target, DependencyType type) { this$0.mGraph.addDependency(source, target, type); }
/*     */   
/*     */   protected void handleMultipleInheritance(T klass)
/*     */   {
/* 434 */     val$postProcessingData.getMultipleInheritance().add(klass);
/*     */   }
/*     */   
/*     */   protected void handleVirtualMethod(T method)
/*     */   {
/* 439 */     val$postProcessingData.getVirtualMethods().add(method);
/*     */   }
/*     */   
/*     */   protected void handleInterfaceInheritance(T klass)
/*     */   {
/* 444 */     val$postProcessingData.getInterfaceInheritance().add(klass);
/*     */   }
/*     */   
/*     */   protected void handleUnresolvedReference(PostProcessingData.UnresolvedReference<T> reference)
/*     */   {
/* 450 */     val$postProcessingData.getUnresolvedReferences().add(reference);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.FullRunShrinker.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */