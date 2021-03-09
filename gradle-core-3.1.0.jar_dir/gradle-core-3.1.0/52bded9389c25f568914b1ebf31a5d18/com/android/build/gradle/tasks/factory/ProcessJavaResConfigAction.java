/*    */ package com.android.build.gradle.tasks.factory;
/*    */ 
/*    */ import com.android.build.gradle.api.AndroidSourceDirectorySet;
/*    */ import com.android.build.gradle.api.AndroidSourceSet;
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import com.android.builder.model.SourceProvider;
/*    */ import java.io.File;
/*    */ import org.gradle.api.tasks.Sync;
/*    */ 
/*    */ public class ProcessJavaResConfigAction implements TaskConfigAction<Sync>
/*    */ {
/*    */   private VariantScope scope;
/*    */   private final File destinationDir;
/*    */   
/*    */   public ProcessJavaResConfigAction(VariantScope scope, File destinationDir)
/*    */   {
/* 19 */     this.scope = scope;
/* 20 */     this.destinationDir = destinationDir;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 26 */     return scope.getTaskName("process", "JavaRes");
/*    */   }
/*    */   
/*    */   public Class<Sync> getType()
/*    */   {
/* 32 */     return Sync.class;
/*    */   }
/*    */   
/*    */   public void execute(Sync processResources)
/*    */   {
/* 39 */     for (SourceProvider sourceProvider : scope.getVariantConfiguration().getSortedSourceProviders()) {
/* 40 */       processResources.from(new Object[] {((AndroidSourceSet)sourceProvider)
/* 41 */         .getResources().getSourceFiles() });
/*    */     }
/*    */     
/* 44 */     processResources.setDestinationDir(destinationDir);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.factory.ProcessJavaResConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */