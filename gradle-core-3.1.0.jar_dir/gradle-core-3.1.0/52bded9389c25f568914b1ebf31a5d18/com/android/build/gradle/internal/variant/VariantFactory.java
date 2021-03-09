/*    */ package com.android.build.gradle.internal.variant;
/*    */ 
/*    */ import com.android.build.VariantOutput;
/*    */ import com.android.build.gradle.internal.TaskManager;
/*    */ import com.android.build.gradle.internal.VariantModel;
/*    */ import com.android.build.gradle.internal.api.BaseVariantImpl;
/*    */ import com.android.build.gradle.internal.api.ReadOnlyObjectProvider;
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import com.android.build.gradle.internal.dsl.BuildType;
/*    */ import com.android.build.gradle.internal.dsl.ProductFlavor;
/*    */ import com.android.build.gradle.internal.dsl.SigningConfig;
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import com.android.builder.core.VariantType;
/*    */ import com.android.builder.profile.Recorder;
/*    */ import java.util.Collection;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ import org.gradle.api.Project;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ 
/*    */ public abstract interface VariantFactory
/*    */ {
/*    */   public abstract BaseVariantData createVariantData(GradleVariantConfiguration paramGradleVariantConfiguration, TaskManager paramTaskManager, Recorder paramRecorder);
/*    */   
/*    */   public abstract Class<? extends BaseVariantImpl> getVariantImplementationClass(BaseVariantData paramBaseVariantData);
/*    */   
/*    */   public BaseVariantImpl createVariantApi(ObjectFactory objectFactory, AndroidBuilder androidBuilder, BaseVariantData variantData, ReadOnlyObjectProvider readOnlyObjectProvider)
/*    */   {
/* 65 */     Class<? extends BaseVariantImpl> implementationClass = getVariantImplementationClass(variantData);
/* 66 */     if (implementationClass == null) {
/* 67 */       return null;
/*    */     }
/*    */     
/* 70 */     return (BaseVariantImpl)objectFactory.newInstance(implementationClass, new Object[] { variantData, objectFactory, androidBuilder, readOnlyObjectProvider, variantData
/*    */     
/* 77 */       .getScope()
/* 78 */       .getGlobalScope()
/* 79 */       .getProject()
/* 80 */       .container(VariantOutput.class) });
/*    */   }
/*    */   
/*    */   public abstract Collection<VariantType> getVariantConfigurationTypes();
/*    */   
/*    */   public abstract boolean hasTestScope();
/*    */   
/*    */   public abstract void validateModel(VariantModel paramVariantModel);
/*    */   
/*    */   public abstract void preVariantWork(Project paramProject);
/*    */   
/*    */   public abstract void createDefaultComponents(NamedDomainObjectContainer<BuildType> paramNamedDomainObjectContainer, NamedDomainObjectContainer<ProductFlavor> paramNamedDomainObjectContainer1, NamedDomainObjectContainer<SigningConfig> paramNamedDomainObjectContainer2);
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.VariantFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */