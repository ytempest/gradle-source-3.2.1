/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.model.ObjectFactory;
/*     */ 
/*     */ public class ExternalNativeBuildOptions
/*     */   implements CoreExternalNativeBuildOptions
/*     */ {
/*     */   private ExternalNativeNdkBuildOptions ndkBuildOptions;
/*     */   private ExternalNativeCmakeOptions cmakeOptions;
/*     */   
/*     */   public ExternalNativeBuildOptions()
/*     */   {
/*  69 */     ndkBuildOptions = new ExternalNativeNdkBuildOptions();
/*  70 */     cmakeOptions = new ExternalNativeCmakeOptions();
/*     */   }
/*     */   
/*     */   @Inject
/*     */   public ExternalNativeBuildOptions(ObjectFactory objectFactory) {
/*  75 */     ndkBuildOptions = ((ExternalNativeNdkBuildOptions)objectFactory.newInstance(ExternalNativeNdkBuildOptions.class, new Object[0]));
/*  76 */     cmakeOptions = ((ExternalNativeCmakeOptions)objectFactory.newInstance(ExternalNativeCmakeOptions.class, new Object[0]));
/*     */   }
/*     */   
/*     */   public void _initWith(ExternalNativeBuildOptions that) {
/*  80 */     ndkBuildOptions._initWith(that.getExternalNativeNdkBuildOptions());
/*  81 */     cmakeOptions._initWith(that.getExternalNativeCmakeOptions());
/*     */   }
/*     */   
/*     */   public CoreExternalNativeNdkBuildOptions getExternalNativeNdkBuildOptions()
/*     */   {
/*  87 */     return getNdkBuild();
/*     */   }
/*     */   
/*     */   public ExternalNativeNdkBuildOptions getNdkBuild()
/*     */   {
/*  99 */     return ndkBuildOptions;
/*     */   }
/*     */   
/*     */   public void ndkBuild(Action<CoreExternalNativeNdkBuildOptions> action) {
/* 103 */     action.execute(ndkBuildOptions);
/*     */   }
/*     */   
/*     */   public CoreExternalNativeCmakeOptions getExternalNativeCmakeOptions()
/*     */   {
/* 109 */     return getCmake();
/*     */   }
/*     */   
/*     */   public ExternalNativeCmakeOptions getCmake()
/*     */   {
/* 121 */     return cmakeOptions;
/*     */   }
/*     */   
/*     */   public void cmake(Action<CoreExternalNativeCmakeOptions> action) {
/* 125 */     action.execute(cmakeOptions);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.ExternalNativeBuildOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */