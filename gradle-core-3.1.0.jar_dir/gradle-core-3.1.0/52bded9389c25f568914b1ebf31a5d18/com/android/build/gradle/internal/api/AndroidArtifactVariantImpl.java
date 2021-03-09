/*    */ package com.android.build.gradle.internal.api;
/*    */ 
/*    */ import com.android.build.gradle.api.AndroidArtifactVariant;
/*    */ import com.android.build.gradle.api.BaseVariantOutput;
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import com.android.build.gradle.internal.variant.AndroidArtifactVariantData;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import com.android.builder.model.SigningConfig;
/*    */ import java.util.Set;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ 
/*    */ public abstract class AndroidArtifactVariantImpl
/*    */   extends BaseVariantImpl
/*    */   implements AndroidArtifactVariant
/*    */ {
/*    */   protected AndroidArtifactVariantImpl(ObjectFactory objectFactory, AndroidBuilder androidBuilder, ReadOnlyObjectProvider immutableObjectProvider, NamedDomainObjectContainer<BaseVariantOutput> outputs)
/*    */   {
/* 41 */     super(objectFactory, androidBuilder, immutableObjectProvider, outputs);
/*    */   }
/*    */   
/*    */   protected abstract AndroidArtifactVariantData getVariantData();
/*    */   
/*    */   public SigningConfig getSigningConfig()
/*    */   {
/* 50 */     return readOnlyObjectProvider.getSigningConfig(
/* 51 */       getVariantData().getVariantConfiguration().getSigningConfig());
/*    */   }
/*    */   
/*    */   public boolean isSigningReady()
/*    */   {
/* 56 */     return getVariantData().isSigned();
/*    */   }
/*    */   
/*    */   public String getVersionName()
/*    */   {
/* 62 */     return getVariantData().getVariantConfiguration().getVersionName();
/*    */   }
/*    */   
/*    */   public int getVersionCode()
/*    */   {
/* 67 */     return getVariantData().getVariantConfiguration().getVersionCode();
/*    */   }
/*    */   
/*    */   public Set<String> getCompatibleScreens()
/*    */   {
/* 73 */     return getVariantData().getCompatibleScreens();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.AndroidArtifactVariantImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */