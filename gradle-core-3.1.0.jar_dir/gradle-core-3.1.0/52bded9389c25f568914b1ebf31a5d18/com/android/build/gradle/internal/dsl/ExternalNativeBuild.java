/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.android.build.gradle.internal.model.CoreExternalNativeBuild;
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.model.ObjectFactory;
/*     */ 
/*     */ public class ExternalNativeBuild
/*     */   implements CoreExternalNativeBuild
/*     */ {
/*     */   private NdkBuildOptions ndkBuild;
/*     */   private CmakeOptions cmake;
/*     */   
/*     */   @Inject
/*     */   public ExternalNativeBuild(ObjectFactory objectFactory, Project project)
/*     */   {
/*  54 */     ndkBuild = ((NdkBuildOptions)objectFactory.newInstance(NdkBuildOptions.class, new Object[] { project }));
/*  55 */     cmake = ((CmakeOptions)objectFactory.newInstance(CmakeOptions.class, new Object[] { project }));
/*     */   }
/*     */   
/*     */   public NdkBuildOptions getNdkBuild()
/*     */   {
/*  66 */     return ndkBuild;
/*     */   }
/*     */   
/*     */   public NdkBuildOptions ndkBuild(Action<NdkBuildOptions> action)
/*     */   {
/*  77 */     action.execute(ndkBuild);
/*  78 */     return ndkBuild;
/*     */   }
/*     */   
/*     */   public CmakeOptions getCmake()
/*     */   {
/*  89 */     return cmake;
/*     */   }
/*     */   
/*     */   public CmakeOptions cmake(Action<CmakeOptions> action)
/*     */   {
/* 100 */     action.execute(cmake);
/* 101 */     return cmake;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.ExternalNativeBuild
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */