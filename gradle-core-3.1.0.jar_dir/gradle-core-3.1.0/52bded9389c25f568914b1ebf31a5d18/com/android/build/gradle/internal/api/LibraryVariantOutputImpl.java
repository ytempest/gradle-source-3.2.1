/*    */ package com.android.build.gradle.internal.api;
/*    */ 
/*    */ import com.android.build.gradle.api.LibraryVariantOutput;
/*    */ import com.android.build.gradle.internal.variant.TaskContainer;
/*    */ import com.android.build.gradle.tasks.AndroidZip;
/*    */ import com.android.ide.common.build.ApkData;
/*    */ import java.io.File;
/*    */ import javax.inject.Inject;
/*    */ import org.gradle.api.tasks.bundling.Zip;
/*    */ 
/*    */ public class LibraryVariantOutputImpl
/*    */   extends BaseVariantOutputImpl
/*    */   implements LibraryVariantOutput
/*    */ {
/*    */   @Inject
/*    */   public LibraryVariantOutputImpl(ApkData apkData, TaskContainer taskContainer)
/*    */   {
/* 40 */     super(apkData, taskContainer);
/*    */   }
/*    */   
/*    */   protected ApkData getApkData()
/*    */   {
/* 46 */     return apkData;
/*    */   }
/*    */   
/*    */   public Zip getPackageLibrary()
/*    */   {
/* 52 */     return (Zip)taskContainer.getTaskByType(AndroidZip.class);
/*    */   }
/*    */   
/*    */   public File getOutputFile()
/*    */   {
/* 58 */     Zip packageTask = getPackageLibrary();
/* 59 */     if (packageTask != null) {
/* 60 */       return new File(packageTask.getDestinationDir(), apkData.getOutputFileName());
/*    */     }
/* 62 */     return super.getOutputFile();
/*    */   }
/*    */   
/*    */   public int getVersionCode()
/*    */   {
/* 68 */     throw new RuntimeException("Libraries are not versioned");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.LibraryVariantOutputImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */