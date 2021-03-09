/*    */ package com.android.build.gradle.internal.scope;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.GsonBuilder;
/*    */ import java.io.File;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import org.apache.commons.io.FileUtils;
/*    */ 
/*    */ public class InstantAppOutputScope
/*    */ {
/*    */   private static final String PERSISTED_FILE_NAME = "instant-app.json";
/*    */   private final String applicationId;
/*    */   private final File instantAppBundle;
/*    */   private final List<File> apkDirectories;
/*    */   
/*    */   public InstantAppOutputScope(String applicationId, File instantAppBundle, List<File> apkDirectories)
/*    */   {
/* 53 */     this.applicationId = applicationId;
/* 54 */     this.instantAppBundle = instantAppBundle;
/* 55 */     this.apkDirectories = apkDirectories;
/*    */   }
/*    */   
/*    */   public String getApplicationId()
/*    */   {
/* 60 */     return applicationId;
/*    */   }
/*    */   
/*    */   public File getInstantAppBundle()
/*    */   {
/* 65 */     return instantAppBundle;
/*    */   }
/*    */   
/*    */   public List<File> getApkDirectories()
/*    */   {
/* 70 */     return apkDirectories;
/*    */   }
/*    */   
/*    */   public void save(File outputDirectory) throws IOException {
/* 74 */     File outputFile = new File(outputDirectory, "instant-app.json");
/* 75 */     GsonBuilder gsonBuilder = new GsonBuilder();
/* 76 */     Gson gson = gsonBuilder.create();
/* 77 */     FileUtils.write(outputFile, gson.toJson(this));
/*    */   }
/*    */   
/*    */   public static InstantAppOutputScope load(File directory) throws IOException
/*    */   {
/* 82 */     File input = new File(directory, "instant-app.json");
/*    */     
/* 84 */     if (!input.exists()) {
/* 85 */       return null;
/*    */     }
/*    */     
/* 88 */     GsonBuilder gsonBuilder = new GsonBuilder();
/* 89 */     Gson gson = gsonBuilder.create();
/*    */     
/* 91 */     FileReader fr = new FileReader(input);Throwable localThrowable3 = null;
/* 92 */     try { return (InstantAppOutputScope)gson.fromJson(fr, InstantAppOutputScope.class);
/*    */     }
/*    */     catch (Throwable localThrowable4)
/*    */     {
/* 91 */       localThrowable3 = localThrowable4;throw localThrowable4;
/*    */     } finally {
/* 93 */       if (fr != null) if (localThrowable3 != null) try { fr.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else fr.close();
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.InstantAppOutputScope
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */