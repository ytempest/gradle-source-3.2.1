/*    */ package com.android.build.gradle.internal.dsl;
/*    */ 
/*    */ import com.android.build.gradle.api.AndroidSourceSet;
/*    */ import com.android.build.gradle.internal.api.DefaultAndroidSourceSet;
/*    */ import org.gradle.api.NamedDomainObjectFactory;
/*    */ import org.gradle.api.Project;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ 
/*    */ public class AndroidSourceSetFactory
/*    */   implements NamedDomainObjectFactory<AndroidSourceSet>
/*    */ {
/*    */   private final ObjectFactory objectFactory;
/*    */   private final Project project;
/*    */   private final boolean publishPackage;
/*    */   
/*    */   public AndroidSourceSetFactory(ObjectFactory objectFactory, Project project, boolean publishPackage)
/*    */   {
/* 48 */     this.objectFactory = objectFactory;
/* 49 */     this.publishPackage = publishPackage;
/* 50 */     this.project = project;
/*    */   }
/*    */   
/*    */   public AndroidSourceSet create(String name)
/*    */   {
/* 56 */     return (AndroidSourceSet)objectFactory.newInstance(DefaultAndroidSourceSet.class, new Object[] { name, project, 
/* 57 */       Boolean.valueOf(publishPackage) });
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.AndroidSourceSetFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */