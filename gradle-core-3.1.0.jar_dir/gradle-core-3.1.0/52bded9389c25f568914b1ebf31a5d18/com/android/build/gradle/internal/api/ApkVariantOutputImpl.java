/*     */ package com.android.build.gradle.internal.api;
/*     */ 
/*     */ import com.android.build.FilterData;
/*     */ import com.android.build.VariantOutput.FilterType;
/*     */ import com.android.build.gradle.api.ApkVariantOutput;
/*     */ import com.android.build.gradle.internal.variant.TaskContainer;
/*     */ import com.android.build.gradle.tasks.PackageAndroidArtifact;
/*     */ import com.android.ide.common.build.ApkData;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import java.io.File;
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.api.Task;
/*     */ 
/*     */ public class ApkVariantOutputImpl
/*     */   extends BaseVariantOutputImpl
/*     */   implements ApkVariantOutput
/*     */ {
/*     */   @Inject
/*     */   public ApkVariantOutputImpl(ApkData apkData, TaskContainer taskContainer)
/*     */   {
/*  42 */     super(apkData, taskContainer);
/*     */   }
/*     */   
/*     */   public PackageAndroidArtifact getPackageApplication()
/*     */   {
/*  48 */     return (PackageAndroidArtifact)taskContainer.getTaskByType(PackageAndroidArtifact.class);
/*     */   }
/*     */   
/*     */   public File getOutputFile()
/*     */   {
/*  54 */     PackageAndroidArtifact packageAndroidArtifact = getPackageApplication();
/*  55 */     if (packageAndroidArtifact != null) {
/*  56 */       return new File(packageAndroidArtifact
/*  57 */         .getOutputDirectory(), apkData.getOutputFileName());
/*     */     }
/*  59 */     return super.getOutputFile();
/*     */   }
/*     */   
/*     */   public Task getZipAlign()
/*     */   {
/*  66 */     return getPackageApplication();
/*     */   }
/*     */   
/*     */   public void setVersionCodeOverride(int versionCodeOverride)
/*     */   {
/*  71 */     apkData.setVersionCode(versionCodeOverride);
/*     */   }
/*     */   
/*     */   public int getVersionCodeOverride()
/*     */   {
/*  76 */     return apkData.getVersionCode();
/*     */   }
/*     */   
/*     */   public void setVersionNameOverride(String versionNameOverride)
/*     */   {
/*  81 */     apkData.setVersionName(versionNameOverride);
/*     */   }
/*     */   
/*     */   public String getVersionNameOverride()
/*     */   {
/*  86 */     return apkData.getVersionName();
/*     */   }
/*     */   
/*     */   public int getVersionCode()
/*     */   {
/*  91 */     return apkData.getVersionCode();
/*     */   }
/*     */   
/*     */   public String getFilter(VariantOutput.FilterType filterType)
/*     */   {
/*  96 */     FilterData filterData = apkData.getFilter(filterType);
/*  97 */     return filterData != null ? filterData.getIdentifier() : null;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 102 */     return MoreObjects.toStringHelper(this).add("apkData", apkData).toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.ApkVariantOutputImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */