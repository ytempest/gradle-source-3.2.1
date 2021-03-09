/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import android.databinding.tool.LayoutXmlProcessor;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.ide.common.res2.SingleFileProcessor;
/*     */ import java.io.File;
/*     */ import javax.xml.bind.JAXBException;
/*     */ 
/*     */ class MergeResources$ConfigAction$1
/*     */   implements SingleFileProcessor
/*     */ {
/* 865 */   final LayoutXmlProcessor processor = val$variantData
/* 866 */     .getLayoutXmlProcessor();
/*     */   
/*     */   MergeResources$ConfigAction$1(MergeResources.ConfigAction this$0, BaseVariantData paramBaseVariantData, MergeResources paramMergeResources) {}
/*     */   
/* 870 */   public boolean processSingleFile(File file, File out) throws Exception { return processor.processSingleFile(file, out); }
/*     */   
/*     */   public void processRemovedFile(File file)
/*     */   {
/* 875 */     processor.processRemovedFile(file);
/*     */   }
/*     */   
/*     */   public void end() throws JAXBException
/*     */   {
/* 880 */     processor.writeLayoutInfoFiles(
/* 881 */       MergeResources.access$1800(val$mergeResourcesTask));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.MergeResources.ConfigAction.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */