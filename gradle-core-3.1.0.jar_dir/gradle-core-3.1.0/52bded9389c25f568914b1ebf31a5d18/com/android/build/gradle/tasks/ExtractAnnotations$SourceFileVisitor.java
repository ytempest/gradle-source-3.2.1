/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import org.gradle.api.file.EmptyFileVisitor;
/*     */ import org.gradle.api.file.FileVisitDetails;
/*     */ import org.gradle.api.file.RelativePath;
/*     */ 
/*     */ class ExtractAnnotations$SourceFileVisitor
/*     */   extends EmptyFileVisitor
/*     */ {
/* 358 */   private final List<File> sourceUnits = Lists.newArrayListWithExpectedSize(100);
/* 359 */   private final List<File> sourceRoots = Lists.newArrayList();
/*     */   
/* 361 */   private String mostRecentRoot = "\000";
/*     */   
/*     */   public List<File> getSourceFiles()
/*     */   {
/* 367 */     return sourceUnits;
/*     */   }
/*     */   
/*     */   public List<File> getSourceRoots() {
/* 371 */     return sourceRoots;
/*     */   }
/*     */   
/* 374 */   private static final String BUILD_GENERATED = File.separator + "build" + File.separator + "generated" + File.separator;
/*     */   
/*     */   public void visitFile(FileVisitDetails details)
/*     */   {
/* 379 */     File file = details.getFile();
/* 380 */     String path = file.getPath();
/* 381 */     if ((path.endsWith(".java")) && (!path.contains(BUILD_GENERATED)))
/*     */     {
/* 384 */       if (!path.startsWith(mostRecentRoot)) {
/* 385 */         RelativePath relativePath = details.getRelativePath();
/* 386 */         String pathString = relativePath.getPathString();
/*     */         
/* 389 */         pathString = pathString.replace('/', File.separatorChar);
/*     */         
/* 391 */         if (path.endsWith(pathString)) {
/* 392 */           String root = path.substring(0, path.length() - pathString.length());
/* 393 */           File rootFile = new File(root);
/* 394 */           if (!sourceRoots.contains(rootFile)) {
/* 395 */             mostRecentRoot = rootFile.getPath();
/* 396 */             sourceRoots.add(rootFile);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 401 */       sourceUnits.add(file);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ExtractAnnotations.SourceFileVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */