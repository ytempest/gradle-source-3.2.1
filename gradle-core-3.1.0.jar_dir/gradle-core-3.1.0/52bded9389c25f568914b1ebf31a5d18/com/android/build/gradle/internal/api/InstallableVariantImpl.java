/*    */ package com.android.build.gradle.internal.api;
/*    */ 
/*    */ import com.android.build.gradle.api.BaseVariantOutput;
/*    */ import com.android.build.gradle.api.InstallableVariant;
/*    */ import com.android.build.gradle.internal.variant.InstallableVariantData;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import org.gradle.api.DefaultTask;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ 
/*    */ public abstract class InstallableVariantImpl
/*    */   extends AndroidArtifactVariantImpl
/*    */   implements InstallableVariant
/*    */ {
/*    */   protected InstallableVariantImpl(ObjectFactory objectFactory, AndroidBuilder androidBuilder, ReadOnlyObjectProvider immutableObjectProvider, NamedDomainObjectContainer<BaseVariantOutput> outputs)
/*    */   {
/* 38 */     super(objectFactory, androidBuilder, immutableObjectProvider, outputs);
/*    */   }
/*    */   
/*    */   public abstract InstallableVariantData getVariantData();
/*    */   
/*    */   public DefaultTask getInstall()
/*    */   {
/* 47 */     return getVariantDatainstallTask;
/*    */   }
/*    */   
/*    */   public DefaultTask getUninstall()
/*    */   {
/* 52 */     return getVariantDatauninstallTask;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.InstallableVariantImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */