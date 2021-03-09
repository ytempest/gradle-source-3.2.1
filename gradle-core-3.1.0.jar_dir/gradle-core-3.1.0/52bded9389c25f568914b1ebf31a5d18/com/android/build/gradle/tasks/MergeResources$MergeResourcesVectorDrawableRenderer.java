/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.builder.png.VectorDrawableRenderer;
/*     */ import com.android.ide.common.vectordrawable.ResourcesNotSupportedException;
/*     */ import com.android.resources.Density;
/*     */ import com.android.utils.ILogger;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import java.util.function.Supplier;
/*     */ import org.gradle.api.GradleException;
/*     */ 
/*     */ class MergeResources$MergeResourcesVectorDrawableRenderer
/*     */   extends VectorDrawableRenderer
/*     */ {
/*     */   public MergeResources$MergeResourcesVectorDrawableRenderer(int minSdk, boolean supportLibraryIsUsed, File outputDir, Collection<Density> densities, Supplier<ILogger> loggerSupplier)
/*     */   {
/* 420 */     super(minSdk, supportLibraryIsUsed, outputDir, densities, loggerSupplier);
/*     */   }
/*     */   
/*     */   public void generateFile(File toBeGenerated, File original) throws IOException
/*     */   {
/*     */     try
/*     */     {
/* 427 */       super.generateFile(toBeGenerated, original);
/*     */     }
/*     */     catch (ResourcesNotSupportedException e)
/*     */     {
/* 431 */       throw new GradleException(String.format("Can't process attribute %1$s=\"%2$s\": references to other resources are not supported by build-time PNG generation. See http://developer.android.com/tools/help/vector-asset-studio.html for details.", new Object[] {e
/*     */       
/* 437 */         .getName(), e.getValue() }));
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.MergeResources.MergeResourcesVectorDrawableRenderer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */