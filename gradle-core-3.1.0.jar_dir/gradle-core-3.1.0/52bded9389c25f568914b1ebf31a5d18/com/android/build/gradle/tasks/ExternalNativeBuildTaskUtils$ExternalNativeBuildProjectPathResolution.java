/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.google.common.base.Preconditions;
/*     */ import java.io.File;
/*     */ 
/*     */ public class ExternalNativeBuildTaskUtils$ExternalNativeBuildProjectPathResolution
/*     */ {
/*     */   public final String errorText;
/*     */   public final NativeBuildSystem buildSystem;
/*     */   public final File makeFile;
/*     */   public final File externalNativeBuildDir;
/*     */   
/*     */   private ExternalNativeBuildTaskUtils$ExternalNativeBuildProjectPathResolution(NativeBuildSystem buildSystem, File makeFile, File externalNativeBuildDir, String errorText)
/*     */   {
/* 423 */     Preconditions.checkArgument((makeFile == null) || (buildSystem != null), "Expected path and buildSystem together, no taskClass");
/*     */     
/* 426 */     Preconditions.checkArgument((makeFile != null) || (buildSystem == null), "Expected path and buildSystem together, no path");
/*     */     
/* 429 */     Preconditions.checkArgument((makeFile == null) || (errorText == null), "Expected path or error but both existed");
/*     */     
/* 432 */     this.buildSystem = buildSystem;
/* 433 */     this.makeFile = makeFile;
/* 434 */     this.externalNativeBuildDir = externalNativeBuildDir;
/* 435 */     this.errorText = errorText;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ExternalNativeBuildTaskUtils.ExternalNativeBuildProjectPathResolution
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */