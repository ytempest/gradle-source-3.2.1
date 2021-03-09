/*    */ package com.android.build.gradle.internal.tasks.featuresplit;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.GsonBuilder;
/*    */ import java.io.File;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ import org.apache.commons.io.FileUtils;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ import org.gradle.api.file.FileTree;
/*    */ 
/*    */ public class FeatureSplitDeclaration
/*    */ {
/*    */   static final String PERSISTED_FILE_NAME = "feature-split.json";
/*    */   private final String uniqueIdentifier;
/*    */   
/*    */   public FeatureSplitDeclaration(String uniqueIdentifier)
/*    */   {
/* 42 */     this.uniqueIdentifier = uniqueIdentifier;
/*    */   }
/*    */   
/*    */   public String getUniqueIdentifier()
/*    */   {
/* 47 */     return uniqueIdentifier;
/*    */   }
/*    */   
/*    */   public void save(File outputDirectory) throws IOException {
/* 51 */     File outputFile = new File(outputDirectory, "feature-split.json");
/* 52 */     GsonBuilder gsonBuilder = new GsonBuilder();
/* 53 */     Gson gson = gsonBuilder.create();
/* 54 */     FileUtils.write(outputFile, gson.toJson(this));
/*    */   }
/*    */   
/*    */   public static FeatureSplitDeclaration load(FileCollection input) throws IOException
/*    */   {
/* 59 */     File persistedFile = getOutputFile(input);
/* 60 */     if (persistedFile == null) {
/* 61 */       throw new FileNotFoundException("No feature split declaration present");
/*    */     }
/* 63 */     return load(persistedFile);
/*    */   }
/*    */   
/*    */   public static FeatureSplitDeclaration load(File input) throws IOException
/*    */   {
/* 68 */     GsonBuilder gsonBuilder = new GsonBuilder();
/* 69 */     Gson gson = gsonBuilder.create();
/* 70 */     FileReader fileReader = new FileReader(input);Throwable localThrowable3 = null;
/* 71 */     try { return (FeatureSplitDeclaration)gson.fromJson(fileReader, FeatureSplitDeclaration.class);
/*    */     }
/*    */     catch (Throwable localThrowable4)
/*    */     {
/* 70 */       localThrowable3 = localThrowable4;throw localThrowable4;
/*    */     } finally {
/* 72 */       if (fileReader != null) if (localThrowable3 != null) try { fileReader.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else fileReader.close();
/*    */     }
/*    */   }
/*    */   
/*    */   private static File getOutputFile(FileCollection input) {
/* 77 */     for (File file : input.getAsFileTree().getFiles()) {
/* 78 */       if (file.getName().equals("feature-split.json")) {
/* 79 */         return file;
/*    */       }
/*    */     }
/* 82 */     return null;
/*    */   }
/*    */   
/*    */   public static File getOutputFile(File directory)
/*    */   {
/* 87 */     return new File(directory, "feature-split.json");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.featuresplit.FeatureSplitDeclaration
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */