/*    */ package com.android.build.gradle.internal;
/*    */ 
/*    */ import com.android.build.gradle.internal.api.DefaultAndroidSourceSet;
/*    */ import com.android.build.gradle.internal.dsl.CoreBuildType;
/*    */ import org.gradle.api.DefaultTask;
/*    */ 
/*    */ public class BuildTypeData
/*    */   extends VariantDimensionData
/*    */ {
/*    */   private final CoreBuildType buildType;
/*    */   private DefaultTask assembleTask;
/*    */   
/*    */   BuildTypeData(CoreBuildType buildType, DefaultAndroidSourceSet sourceSet, DefaultAndroidSourceSet androidTestSourceSet, DefaultAndroidSourceSet unitTestSourceSet)
/*    */   {
/* 36 */     super(sourceSet, androidTestSourceSet, unitTestSourceSet);
/*    */     
/* 38 */     this.buildType = buildType;
/*    */   }
/*    */   
/*    */   public CoreBuildType getBuildType() {
/* 42 */     return buildType;
/*    */   }
/*    */   
/*    */   public DefaultTask getAssembleTask()
/*    */   {
/* 47 */     return assembleTask;
/*    */   }
/*    */   
/*    */   public void setAssembleTask(DefaultTask assembleTask) {
/* 51 */     this.assembleTask = assembleTask;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.BuildTypeData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */