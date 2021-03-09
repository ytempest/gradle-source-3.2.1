/*    */ package com.android.build.gradle.internal.api;
/*    */ 
/*    */ import com.android.build.gradle.api.ApkVariant;
/*    */ import com.android.build.gradle.api.BaseVariantOutput;
/*    */ import com.android.build.gradle.internal.variant.InstallableVariantData;
/*    */ import com.android.build.gradle.tasks.PackageAndroidArtifact;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ 
/*    */ public abstract class ApkVariantImpl
/*    */   extends InstallableVariantImpl
/*    */   implements ApkVariant
/*    */ {
/*    */   protected ApkVariantImpl(ObjectFactory objectFactory, AndroidBuilder androidBuilder, ReadOnlyObjectProvider immutableObjectProvider, NamedDomainObjectContainer<BaseVariantOutput> outputs)
/*    */   {
/* 41 */     super(objectFactory, androidBuilder, immutableObjectProvider, outputs);
/*    */   }
/*    */   
/*    */   public Object getDex()
/*    */   {
/* 47 */     throw new RuntimeException("Access to the dex task is now impossible, starting with 1.4.0\n1.4.0 introduces a new Transform API allowing manipulation of the .class files.\nSee more information: https://developer.android.com/studio/plugins/index.html");
/*    */   }
/*    */   
/*    */   public PackageAndroidArtifact getPackageApplication()
/*    */   {
/* 55 */     return (PackageAndroidArtifact)getVariantData().getTaskByType(PackageAndroidArtifact.class);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.ApkVariantImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */