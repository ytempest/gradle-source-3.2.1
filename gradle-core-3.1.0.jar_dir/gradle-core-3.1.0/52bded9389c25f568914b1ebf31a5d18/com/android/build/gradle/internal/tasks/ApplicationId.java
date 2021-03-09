/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.GsonBuilder;
/*    */ import java.io.File;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ import org.apache.commons.io.FileUtils;
/*    */ 
/*    */ public class ApplicationId
/*    */ {
/*    */   static final String PERSISTED_FILE_NAME = "application-id.json";
/*    */   private final String applicationId;
/*    */   
/*    */   public ApplicationId(String applicationId)
/*    */   {
/* 37 */     this.applicationId = applicationId;
/*    */   }
/*    */   
/*    */   public String getApplicationId()
/*    */   {
/* 42 */     return applicationId;
/*    */   }
/*    */   
/*    */   public void save(File outputDirectory) throws IOException {
/* 46 */     File outputFile = new File(outputDirectory, "application-id.json");
/* 47 */     GsonBuilder gsonBuilder = new GsonBuilder();
/* 48 */     Gson gson = gsonBuilder.create();
/* 49 */     FileUtils.write(outputFile, gson.toJson(this));
/*    */   }
/*    */   
/*    */   public static ApplicationId load(File input) throws IOException
/*    */   {
/* 54 */     if (!input.getName().equals("application-id.json")) {
/* 55 */       throw new FileNotFoundException("No application declaration present.");
/*    */     }
/* 57 */     GsonBuilder gsonBuilder = new GsonBuilder();
/* 58 */     Gson gson = gsonBuilder.create();
/* 59 */     FileReader fileReader = new FileReader(input);Throwable localThrowable3 = null;
/* 60 */     try { return (ApplicationId)gson.fromJson(fileReader, ApplicationId.class);
/*    */     }
/*    */     catch (Throwable localThrowable4)
/*    */     {
/* 59 */       localThrowable3 = localThrowable4;throw localThrowable4;
/*    */     } finally {
/* 61 */       if (fileReader != null) if (localThrowable3 != null) try { fileReader.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else fileReader.close();
/*    */     }
/*    */   }
/*    */   
/*    */   public static File getOutputFile(File directory) {
/* 66 */     return new File(directory, "application-id.json");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.ApplicationId
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */