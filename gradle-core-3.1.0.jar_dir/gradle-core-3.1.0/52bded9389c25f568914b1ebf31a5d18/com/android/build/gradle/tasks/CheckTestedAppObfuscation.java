/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import com.android.build.gradle.internal.tasks.AndroidVariantTask;
/*    */ import java.io.File;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ import org.gradle.api.tasks.InputFiles;
/*    */ import org.gradle.api.tasks.Optional;
/*    */ import org.gradle.api.tasks.OutputFile;
/*    */ import org.gradle.api.tasks.TaskAction;
/*    */ 
/*    */ public class CheckTestedAppObfuscation
/*    */   extends AndroidVariantTask
/*    */ {
/*    */   FileCollection mappingFile;
/*    */   
/*    */   @InputFiles
/*    */   public FileCollection getMappingFile()
/*    */   {
/* 37 */     return mappingFile;
/*    */   }
/*    */   
/*    */   @OutputFile
/*    */   @Optional
/*    */   public File getDummyOutput()
/*    */   {
/* 45 */     return null;
/*    */   }
/*    */   
/*    */   @TaskAction
/*    */   void checkIfAppIsObfuscated() {
/* 50 */     if (!mappingFile.isEmpty())
/*    */     {
/* 57 */       throw new RuntimeException("Mapping file found in tested application. Proguard must also be enabled in test plugin with:\nandroid {\n    buildTypes {\n        " + getVariantName() + " {\n            minifyEnabled true\n            useProguard true\n        }\n    }\n}\n");
/*    */     }
/*    */   }
/*    */   
/*    */   public static class ConfigAction
/*    */     implements TaskConfigAction<CheckTestedAppObfuscation>
/*    */   {
/*    */     private final VariantScope scope;
/*    */     
/*    */     public ConfigAction(VariantScope scope)
/*    */     {
/* 72 */       this.scope = scope;
/*    */     }
/*    */     
/*    */     public String getName()
/*    */     {
/* 78 */       return scope.getTaskName("checkTestedAppObfuscation");
/*    */     }
/*    */     
/*    */     public Class<CheckTestedAppObfuscation> getType()
/*    */     {
/* 84 */       return CheckTestedAppObfuscation.class;
/*    */     }
/*    */     
/*    */     public void execute(CheckTestedAppObfuscation task)
/*    */     {
/* 89 */       task.setVariantName(scope.getFullVariantName());
/*    */       
/* 92 */       mappingFile = scope.getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactScope.ALL, AndroidArtifacts.ArtifactType.APK_MAPPING);
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.CheckTestedAppObfuscation
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */