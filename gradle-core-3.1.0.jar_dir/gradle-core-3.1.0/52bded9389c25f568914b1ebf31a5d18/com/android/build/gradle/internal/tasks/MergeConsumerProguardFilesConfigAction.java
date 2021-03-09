/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.build.gradle.ProguardFiles;
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import com.android.builder.errors.EvalIssueReporter.Type;
/*    */ import java.io.File;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import org.gradle.api.Project;
/*    */ import org.gradle.api.file.ConfigurableFileCollection;
/*    */ 
/*    */ public class MergeConsumerProguardFilesConfigAction
/*    */   implements TaskConfigAction<MergeFileTask>
/*    */ {
/*    */   private final Project project;
/*    */   private final VariantScope variantScope;
/*    */   private final File outputFile;
/*    */   
/*    */   public MergeConsumerProguardFilesConfigAction(Project project, VariantScope variantScope, File outputFile)
/*    */   {
/* 41 */     this.project = project;
/* 42 */     this.variantScope = variantScope;
/* 43 */     this.outputFile = outputFile;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 49 */     return variantScope.getTaskName("merge", "ConsumerProguardFiles");
/*    */   }
/*    */   
/*    */   public Class<MergeFileTask> getType()
/*    */   {
/* 55 */     return MergeFileTask.class;
/*    */   }
/*    */   
/*    */   public void execute(MergeFileTask mergeProguardFiles)
/*    */   {
/* 60 */     mergeProguardFiles.setVariantName(variantScope.getVariantConfiguration().getFullName());
/* 61 */     mergeProguardFiles.setOutputFile(outputFile);
/* 62 */     mergeProguardFiles.setInputFiles(project
/* 63 */       .files(new Object[] {variantScope.getConsumerProguardFiles() }).getFiles());
/*    */     
/* 66 */     Map<File, String> defaultFiles = new HashMap();
/* 67 */     for (Iterator localIterator = ProguardFiles.KNOWN_FILE_NAMES.iterator(); localIterator.hasNext();) { knownFileName = (String)localIterator.next();
/* 68 */       defaultFiles.put(
/* 69 */         ProguardFiles.getDefaultProguardFile(knownFileName, project), knownFileName);
/*    */     }
/*    */     String knownFileName;
/* 72 */     Object issueReporter = variantScope.getGlobalScope().getErrorHandler();
/*    */     
/* 74 */     for (File consumerFile : mergeProguardFiles.getInputFiles()) {
/* 75 */       if (defaultFiles.containsKey(consumerFile)) {
/* 76 */         ((EvalIssueReporter)issueReporter).reportError(EvalIssueReporter.Type.GENERIC, 
/*    */         
/* 78 */           String.format("Default file %s should not be used as a consumer configuration file.", new Object[] {defaultFiles
/*    */           
/* 80 */           .get(consumerFile) }));
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.MergeConsumerProguardFilesConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */