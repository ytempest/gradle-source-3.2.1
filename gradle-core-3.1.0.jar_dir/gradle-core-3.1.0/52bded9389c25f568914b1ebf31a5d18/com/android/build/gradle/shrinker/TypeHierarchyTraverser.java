/*    */ package com.android.build.gradle.shrinker;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import com.google.common.collect.TreeTraverser;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ 
/*    */ public class TypeHierarchyTraverser<T>
/*    */   extends TreeTraverser<T>
/*    */ {
/*    */   private final ShrinkerGraph<T> mGraph;
/*    */   private final ShrinkerLogger mShrinkerLogger;
/*    */   private final boolean mIncludeInterfaces;
/*    */   private final boolean mIncludeSuperclasses;
/*    */   
/*    */   private TypeHierarchyTraverser(ShrinkerGraph<T> graph, ShrinkerLogger shrinkerLogger, boolean includeSuperclasses, boolean includeInterfaces)
/*    */   {
/* 41 */     mGraph = graph;
/* 42 */     mShrinkerLogger = shrinkerLogger;
/* 43 */     mIncludeSuperclasses = includeSuperclasses;
/* 44 */     mIncludeInterfaces = includeInterfaces;
/*    */   }
/*    */   
/*    */   public static <T> TypeHierarchyTraverser<T> superclassesAndInterfaces(ShrinkerGraph<T> graph, ShrinkerLogger shrinkerLogger)
/*    */   {
/* 49 */     return new TypeHierarchyTraverser(graph, shrinkerLogger, true, true);
/*    */   }
/*    */   
/*    */   public static <T> TypeHierarchyTraverser<T> superclasses(ShrinkerGraph<T> graph, ShrinkerLogger shrinkerLogger)
/*    */   {
/* 54 */     return new TypeHierarchyTraverser(graph, shrinkerLogger, true, false);
/*    */   }
/*    */   
/*    */   public static <T> TypeHierarchyTraverser<T> interfaces(ShrinkerGraph<T> graph, ShrinkerLogger shrinkerLogger)
/*    */   {
/* 59 */     return new TypeHierarchyTraverser(graph, shrinkerLogger, false, true);
/*    */   }
/*    */   
/*    */   public Iterable<T> children(T klass)
/*    */   {
/* 64 */     List<T> result = Lists.newArrayList();
/* 65 */     if (mIncludeSuperclasses) {
/*    */       try {
/* 67 */         T superclass = mGraph.getSuperclass(klass);
/* 68 */         if (superclass != null) {
/* 69 */           if (!mGraph.isClassKnown(superclass)) {
/* 70 */             throw new ClassLookupException(mGraph.getClassName(superclass));
/*    */           }
/* 72 */           result.add(superclass);
/*    */         }
/*    */       } catch (ClassLookupException e) {
/* 75 */         mShrinkerLogger.invalidClassReference(mGraph.getClassName(klass), e.getClassName());
/* 76 */         return Collections.emptyList();
/*    */       }
/*    */     }
/*    */     
/* 80 */     if (mIncludeInterfaces) {
/*    */       try {
/* 82 */         T[] interfaces = mGraph.getInterfaces(klass);
/* 83 */         for (T iface : interfaces) {
/* 84 */           if (!mGraph.isClassKnown(iface)) {
/* 85 */             mShrinkerLogger.invalidClassReference(mGraph
/* 86 */               .getClassName(klass), mGraph.getClassName(iface));
/*    */           } else {
/* 88 */             result.add(iface);
/*    */           }
/*    */         }
/*    */       } catch (ClassLookupException e) {
/* 92 */         mShrinkerLogger.invalidClassReference(mGraph.getClassName(klass), e.getClassName());
/*    */       }
/*    */     }
/*    */     
/* 96 */     return result;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.TypeHierarchyTraverser
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */