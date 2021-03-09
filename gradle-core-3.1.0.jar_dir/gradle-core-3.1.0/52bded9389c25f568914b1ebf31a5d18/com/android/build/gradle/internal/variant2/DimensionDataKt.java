/*    */ package com.android.build.gradle.internal.variant2;
/*    */ 
/*    */ import com.android.build.api.sourcesets.AndroidSourceSet;
/*    */ import kotlin.Metadata;
/*    */ import org.gradle.api.artifacts.Configuration;
/*    */ import org.gradle.api.artifacts.ConfigurationContainer;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=2, d1={"\000\036\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\002\032 \020\000\032\0020\0012\006\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\002\032 \020\007\032\0020\0012\006\020\b\032\0020\t2\006\020\n\032\0020\t2\006\020\002\032\0020\003H\002¨\006\013"}, d2={"linkConfiguration", "", "configurations", "Lorg/gradle/api/artifacts/ConfigurationContainer;", "mainConfigName", "", "testConfigName", "makeTestExtendMain", "mainSourceSet", "Lcom/android/build/api/sourcesets/AndroidSourceSet;", "testSourceSet", "gradle-core"})
/*    */ public final class DimensionDataKt
/*    */ {
/*    */   private static final void makeTestExtendMain(AndroidSourceSet mainSourceSet, AndroidSourceSet testSourceSet, ConfigurationContainer configurations)
/*    */   {
/* 55 */     linkConfiguration(
/* 56 */       configurations, mainSourceSet.getImplementationConfigurationName(), testSourceSet.getImplementationConfigurationName());
/* 57 */     linkConfiguration(
/* 58 */       configurations, mainSourceSet.getRuntimeOnlyConfigurationName(), testSourceSet.getRuntimeOnlyConfigurationName());
/*    */   }
/*    */   
/*    */   private static final void linkConfiguration(ConfigurationContainer configurations, String mainConfigName, String testConfigName)
/*    */   {
/* 65 */     configurations.getByName(testConfigName).extendsFrom(new Configuration[] { configurations.getByName(mainConfigName) });
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.DimensionDataKt
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */