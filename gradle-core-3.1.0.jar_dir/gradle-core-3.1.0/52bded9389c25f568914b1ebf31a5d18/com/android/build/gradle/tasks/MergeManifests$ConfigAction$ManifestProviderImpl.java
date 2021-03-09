/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.manifmerger.ManifestProvider;
/*     */ import java.io.File;
/*     */ 
/*     */ public class MergeManifests$ConfigAction$ManifestProviderImpl
/*     */   implements ManifestProvider
/*     */ {
/*     */   private final File manifest;
/*     */   private final String name;
/*     */   
/*     */   public MergeManifests$ConfigAction$ManifestProviderImpl(File manifest, String name)
/*     */   {
/* 535 */     this.manifest = manifest;
/* 536 */     this.name = name;
/*     */   }
/*     */   
/*     */   public File getManifest()
/*     */   {
/* 542 */     return manifest;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 548 */     return name;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.MergeManifests.ConfigAction.ManifestProviderImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */