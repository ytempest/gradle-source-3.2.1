/*    */ package com.android.build.gradle.internal.dsl;
/*    */ 
/*    */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*    */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*    */ import com.android.builder.core.DefaultDexOptions;
/*    */ import java.util.Arrays;
/*    */ import javax.inject.Inject;
/*    */ 
/*    */ public class DexOptions
/*    */   extends DefaultDexOptions
/*    */ {
/*    */   private final DeprecationReporter deprecationReporter;
/*    */   
/*    */   @Inject
/*    */   public DexOptions(DeprecationReporter deprecationReporter)
/*    */   {
/* 35 */     this.deprecationReporter = deprecationReporter;
/*    */   }
/*    */   
/*    */   @Deprecated
/*    */   public boolean getIncremental()
/*    */   {
/* 41 */     deprecationReporter.reportObsoleteUsage("DexOptions.incremental", DeprecationReporter.DeprecationTarget.DEX_OPTIONS);
/*    */     
/* 43 */     return false;
/*    */   }
/*    */   
/*    */   public void setIncremental(boolean ignored) {
/* 47 */     deprecationReporter.reportObsoleteUsage("DexOptions.incremental", DeprecationReporter.DeprecationTarget.DEX_OPTIONS);
/*    */   }
/*    */   
/*    */   public void additionalParameters(String... parameters)
/*    */   {
/* 52 */     setAdditionalParameters(Arrays.asList(parameters));
/*    */   }
/*    */   
/*    */   @Deprecated
/*    */   public void setOptimize(Boolean optimize)
/*    */   {
/* 60 */     deprecationReporter.reportObsoleteUsage("DexOptions.optimize", DeprecationReporter.DeprecationTarget.DEX_OPTIONS);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.DexOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */