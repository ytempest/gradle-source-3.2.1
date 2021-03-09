/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.core.VariantConfiguration;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import org.gradle.api.artifacts.Configuration;
/*    */ import org.gradle.api.logging.LogLevel;
/*    */ import org.gradle.api.logging.Logger;
/*    */ import org.gradle.api.tasks.TaskAction;
/*    */ import proguard.ParseException;
/*    */ import proguard.gradle.ProGuardTask;
/*    */ 
/*    */ public class TestModuleProGuardTask
/*    */   extends ProGuardTask
/*    */ {
/*    */   private Logger logger;
/*    */   private Configuration mappingConfiguration;
/*    */   private VariantConfiguration variantConfiguration;
/*    */   
/*    */   public void setMappingConfiguration(Configuration configuration)
/*    */   {
/* 42 */     mappingConfiguration = configuration;
/* 43 */     dependsOn(new Object[] { configuration });
/*    */   }
/*    */   
/*    */   public void setClassesConfiguration(Configuration configuration)
/*    */   {
/* 50 */     dependsOn(new Object[] { configuration });
/*    */   }
/*    */   
/*    */   public void setVariantConfiguration(VariantConfiguration variantConfiguration)
/*    */   {
/* 56 */     this.variantConfiguration = variantConfiguration;
/*    */   }
/*    */   
/*    */   public void setLogger(Logger logger) {
/* 60 */     this.logger = logger;
/*    */   }
/*    */   
/*    */   @TaskAction
/*    */   public void proguard() throws ParseException, IOException
/*    */   {
/* 66 */     if (logger.isEnabled(LogLevel.INFO)) {
/* 67 */       logger.info("test module mapping file " + mappingConfiguration.getSingleFile());
/*    */     }
/*    */     
/* 77 */     if (mappingConfiguration.getSingleFile().isFile()) {
/* 78 */       applymapping(mappingConfiguration.getSingleFile());
/*    */     }
/* 80 */     super.proguard();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.TestModuleProGuardTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */