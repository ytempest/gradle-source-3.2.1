/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.builder.core.DesugarProcessBuilder;
/*    */ import com.android.utils.FileUtils;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.nio.file.CopyOption;
/*    */ import java.nio.file.Files;
/*    */ import org.gradle.api.file.ConfigurableFileCollection;
/*    */ import org.gradle.api.tasks.OutputFile;
/*    */ import org.gradle.api.tasks.TaskAction;
/*    */ 
/*    */ public class ExtractTryWithResourcesSupportJar
/*    */   extends AndroidVariantTask
/*    */ {
/*    */   public static final String TASK_NAME = "extractTryWithResourcesSupportJar";
/*    */   private ConfigurableFileCollection outputLocation;
/*    */   
/*    */   @TaskAction
/*    */   public void run()
/*    */     throws IOException
/*    */   {
/* 46 */     InputStream in = DesugarProcessBuilder.class.getClassLoader().getResourceAsStream("libthrowable_extension.jar");Throwable localThrowable3 = null;
/* 47 */     try { FileUtils.cleanOutputDir(outputLocation.getSingleFile().getParentFile());
/* 48 */       Files.copy(in, outputLocation.getSingleFile().toPath(), new CopyOption[0]);
/*    */     }
/*    */     catch (Throwable localThrowable1)
/*    */     {
/* 43 */       localThrowable3 = localThrowable1;throw localThrowable1;
/*    */     }
/*    */     finally
/*    */     {
/* 49 */       if (in != null) if (localThrowable3 != null) try { in.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else in.close();
/*    */     }
/*    */   }
/*    */   
/*    */   @OutputFile
/* 54 */   public File getOutputLocation() { return outputLocation.getSingleFile(); }
/*    */   
/*    */   public static class ConfigAction
/*    */     implements TaskConfigAction<ExtractTryWithResourcesSupportJar>
/*    */   {
/*    */     private final ConfigurableFileCollection outputLocation;
/*    */     
/*    */     private final String taskName;
/*    */     
/*    */     private final String variantName;
/*    */     
/*    */     public ConfigAction(ConfigurableFileCollection outputLocation, String taskName, String variantName)
/*    */     {
/* 68 */       this.outputLocation = outputLocation;
/* 69 */       this.taskName = taskName;
/* 70 */       this.variantName = variantName;
/*    */     }
/*    */     
/*    */     public String getName()
/*    */     {
/* 76 */       return taskName;
/*    */     }
/*    */     
/*    */     public Class<ExtractTryWithResourcesSupportJar> getType()
/*    */     {
/* 82 */       return ExtractTryWithResourcesSupportJar.class;
/*    */     }
/*    */     
/*    */     public void execute(ExtractTryWithResourcesSupportJar task)
/*    */     {
/* 87 */       outputLocation = outputLocation;
/* 88 */       task.setVariantName(variantName);
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.ExtractTryWithResourcesSupportJar
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */