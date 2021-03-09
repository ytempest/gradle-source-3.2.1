/*    */ package com.android.build.gradle.internal.dsl;
/*    */ 
/*    */ import com.android.builder.core.DefaultVectorDrawablesOptions;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ public class VectorDrawablesOptions
/*    */   extends DefaultVectorDrawablesOptions
/*    */ {
/*    */   public void generatedDensities(String... densities)
/*    */   {
/* 28 */     setGeneratedDensities(Arrays.asList(densities));
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.VectorDrawablesOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */