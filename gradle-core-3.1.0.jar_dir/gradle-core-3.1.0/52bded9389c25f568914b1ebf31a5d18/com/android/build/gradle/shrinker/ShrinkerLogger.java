/*    */ package com.android.build.gradle.shrinker;
/*    */ 
/*    */ import com.android.build.gradle.internal.incremental.ByteCodeUtils;
/*    */ import com.android.build.gradle.shrinker.parser.FilterSpecification;
/*    */ import com.android.utils.Pair;
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import org.slf4j.Logger;
/*    */ 
/*    */ public class ShrinkerLogger
/*    */ {
/*    */   private final List<FilterSpecification> mDontWarnSpecs;
/*    */   private final Logger mLogger;
/*    */   private final Set<Pair<String, String>> mWarningsEmitted;
/*    */   
/*    */   public ShrinkerLogger(List<FilterSpecification> dontWarnSpecs, Logger logger)
/*    */   {
/* 35 */     mDontWarnSpecs = dontWarnSpecs;
/* 36 */     mLogger = logger;
/* 37 */     mWarningsEmitted = Sets.newHashSet();
/*    */   }
/*    */   
/*    */   synchronized void invalidClassReference(String from, String to) {
/* 41 */     if (from.contains(".")) {
/* 42 */       from = ByteCodeUtils.getClassName(from);
/*    */     }
/*    */     
/* 45 */     if (mWarningsEmitted.contains(Pair.of(from, to))) {
/* 46 */       return;
/*    */     }
/*    */     
/* 49 */     for (FilterSpecification dontWarnSpec : mDontWarnSpecs) {
/* 50 */       if ((dontWarnSpec.matches(from)) || (dontWarnSpec.matches(to))) {
/* 51 */         return;
/*    */       }
/*    */     }
/*    */     
/* 55 */     mWarningsEmitted.add(Pair.of(from, to));
/* 56 */     mLogger.warn("{} references unknown class: {}", from, to);
/*    */   }
/*    */   
/*    */   synchronized void invalidMemberReference(String from, String to) {
/* 60 */     if (mWarningsEmitted.contains(Pair.of(from, to))) {
/*    */       return;
/*    */     }
/*    */     String fromClassName;
/*    */     String fromClassName;
/* 65 */     if (from.contains(".")) {
/* 66 */       fromClassName = ByteCodeUtils.getClassName(from);
/*    */     } else {
/* 68 */       fromClassName = from;
/*    */     }
/* 70 */     String toClassName = ByteCodeUtils.getClassName(to);
/* 71 */     for (FilterSpecification dontWarnSpec : mDontWarnSpecs) {
/* 72 */       if ((dontWarnSpec.matches(fromClassName)) || (dontWarnSpec.matches(toClassName))) {
/* 73 */         return;
/*    */       }
/*    */     }
/*    */     
/* 77 */     mWarningsEmitted.add(Pair.of(from, to));
/* 78 */     mLogger.warn("{} references unknown class member: {}", from, to);
/*    */   }
/*    */   
/*    */   public int getWarningsCount() {
/* 82 */     return getWarningsEmitted().size();
/*    */   }
/*    */   
/*    */   Set<Pair<String, String>> getWarningsEmitted()
/*    */   {
/* 87 */     return mWarningsEmitted;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.ShrinkerLogger
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */