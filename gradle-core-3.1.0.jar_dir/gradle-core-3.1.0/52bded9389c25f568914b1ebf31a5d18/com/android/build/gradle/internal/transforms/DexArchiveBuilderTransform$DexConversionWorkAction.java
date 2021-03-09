/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.tooling.BuildException;
/*     */ 
/*     */ public class DexArchiveBuilderTransform$DexConversionWorkAction
/*     */   implements Runnable
/*     */ {
/*     */   private final DexArchiveBuilderTransform.DexConversionParameters dexConversionParameters;
/*     */   
/*     */   @Inject
/*     */   public DexArchiveBuilderTransform$DexConversionWorkAction(DexArchiveBuilderTransform.DexConversionParameters dexConversionParameters)
/*     */   {
/* 581 */     this.dexConversionParameters = dexConversionParameters;
/*     */   }
/*     */   
/*     */   public void run()
/*     */   {
/*     */     try {
/* 587 */       DexArchiveBuilderTransform.access$500(dexConversionParameters, System.out, System.err, 
/*     */       
/* 591 */         DexArchiveBuilderTransform.DexConversionParameters.access$400(dexConversionParameters));
/*     */     } catch (Exception e) {
/* 593 */       throw new BuildException(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.DexArchiveBuilderTransform.DexConversionWorkAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */