/*    */ package com.android.build.gradle.internal.coverage;
/*    */ 
/*    */ import org.gradle.api.Project;
/*    */ import org.gradle.api.artifacts.Configuration;
/*    */ import org.gradle.api.artifacts.ConfigurationContainer;
/*    */ import org.gradle.api.artifacts.dsl.DependencyHandler;
/*    */ 
/*    */ public final class JacocoConfigurations
/*    */ {
/*    */   public static final String ANT_CONFIGURATION_NAME = "androidJacocoAnt";
/*    */   public static final String VERSION_FOR_DX = "0.7.4.201502262128";
/*    */   
/*    */   public static String getAgentRuntimeDependency(String jacocoVersion)
/*    */   {
/* 32 */     return "org.jacoco:org.jacoco.agent:" + jacocoVersion + ":runtime";
/*    */   }
/*    */   
/*    */   public static Configuration getJacocoAntTaskConfiguration(Project project, String jacocoVersion)
/*    */   {
/* 43 */     Configuration configuration = (Configuration)project.getConfigurations().findByName("androidJacocoAnt");
/* 44 */     if (configuration != null) {
/* 45 */       return configuration;
/*    */     }
/*    */     
/* 48 */     configuration = (Configuration)project.getConfigurations().create("androidJacocoAnt");
/*    */     
/* 50 */     configuration.setVisible(false);
/* 51 */     configuration.setTransitive(true);
/* 52 */     configuration.setCanBeConsumed(false);
/* 53 */     configuration.setDescription("The Jacoco agent to use to get coverage data.");
/*    */     
/* 55 */     project.getDependencies()
/* 56 */       .add("androidJacocoAnt", "org.jacoco:org.jacoco.ant:" + jacocoVersion);
/* 57 */     return configuration;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.coverage.JacocoConfigurations
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */