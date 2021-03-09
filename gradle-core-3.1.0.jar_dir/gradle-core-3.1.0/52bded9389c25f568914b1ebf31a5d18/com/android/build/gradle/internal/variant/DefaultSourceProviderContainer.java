/*    */ package com.android.build.gradle.internal.variant;
/*    */ 
/*    */ import com.android.builder.model.SourceProvider;
/*    */ import com.android.builder.model.SourceProviderContainer;
/*    */ 
/*    */ public class DefaultSourceProviderContainer
/*    */   implements SourceProviderContainer
/*    */ {
/*    */   private final String name;
/*    */   private final SourceProvider sourceProvider;
/*    */   
/*    */   public DefaultSourceProviderContainer(String name, SourceProvider sourceProvider)
/*    */   {
/* 36 */     this.name = name;
/* 37 */     this.sourceProvider = sourceProvider;
/*    */   }
/*    */   
/*    */   public String getArtifactName()
/*    */   {
/* 43 */     return name;
/*    */   }
/*    */   
/*    */   public SourceProvider getSourceProvider()
/*    */   {
/* 49 */     return sourceProvider;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.DefaultSourceProviderContainer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */