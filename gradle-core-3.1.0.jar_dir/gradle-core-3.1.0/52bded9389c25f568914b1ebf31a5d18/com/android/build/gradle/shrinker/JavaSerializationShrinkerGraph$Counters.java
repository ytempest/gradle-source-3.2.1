/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import com.google.common.cache.CacheBuilder;
/*     */ import com.google.common.cache.CacheLoader;
/*     */ import com.google.common.cache.LoadingCache;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ 
/*     */ final class JavaSerializationShrinkerGraph$Counters
/*     */   implements Serializable
/*     */ {
/*     */   private final LoadingCache<String, JavaSerializationShrinkerGraph.Counter> mReferenceCounters;
/*     */   private final ConcurrentMap<String, DependencyType> mRoots;
/*     */   
/*     */   public JavaSerializationShrinkerGraph$Counters(ConcurrentMap<String, DependencyType> roots, Map<String, JavaSerializationShrinkerGraph.Counter> counters)
/*     */   {
/* 547 */     mRoots = roots;
/*     */     
/* 552 */     mReferenceCounters = CacheBuilder.newBuilder().build(new CacheLoader()
/*     */     {
/*     */       public JavaSerializationShrinkerGraph.Counter load(String unused)
/*     */         throws Exception
/*     */       {
/* 557 */         return new JavaSerializationShrinkerGraph.Counter(null);
/*     */       }
/*     */       
/* 560 */     });
/* 561 */     mReferenceCounters.putAll(counters);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.JavaSerializationShrinkerGraph.Counters
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */