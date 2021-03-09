/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.gradle.internal.dsl.PackagingOptions;
/*     */ import com.android.build.gradle.internal.packaging.PackagingFileAction;
/*     */ import com.android.build.gradle.internal.packaging.ParsedPackagingOptions;
/*     */ import com.android.builder.packaging.ZipAbortException;
/*     */ import com.android.builder.packaging.ZipEntryFilter;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.base.Joiner;
/*     */ import com.google.common.base.Optional;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableList.Builder;
/*     */ import com.google.common.io.Files;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.List;
/*     */ 
/*     */ public class FileFilter
/*     */   implements ZipEntryFilter
/*     */ {
/*     */   private final ParsedPackagingOptions packagingOptions;
/*     */   private final List<SubStream> expandedFolders;
/*     */   
/*     */   private static abstract interface FolderAction
/*     */   {
/*     */     public abstract File on(File paramFile);
/*     */   }
/*     */   
/*     */   public static class SubStream
/*     */   {
/*     */     private final File folder;
/*     */     private final String name;
/*     */     
/*     */     SubStream(File folder, String name)
/*     */     {
/*  52 */       this.folder = folder;
/*  53 */       this.name = name;
/*     */     }
/*     */     
/*     */     public File getFolder() {
/*  57 */       return folder;
/*     */     }
/*     */     
/*     */     public String getName() {
/*  61 */       return name;
/*     */     }
/*     */   }
/*     */   
/*     */   public FileFilter(List<SubStream> expandedFolders, PackagingOptions packagingOptions)
/*     */   {
/*  73 */     this.expandedFolders = ImmutableList.copyOf(expandedFolders);
/*  74 */     this.packagingOptions = new ParsedPackagingOptions(packagingOptions);
/*     */   }
/*     */   
/*     */   public boolean checkEntry(String archivePath)
/*     */     throws ZipAbortException
/*     */   {
/*  87 */     PackagingFileAction action = getPackagingAction(archivePath);
/*  88 */     switch (action) {
/*     */     case EXCLUDE: 
/*  90 */       return false;
/*     */     case PICK_FIRST: 
/*  92 */       List<File> allFiles = getAllFiles(archivePath);
/*  93 */       return allFiles.isEmpty();
/*     */     case MERGE: 
/*     */     case NONE: 
/*  96 */       return true;
/*     */     }
/*  98 */     throw new RuntimeException("Unhandled action " + action);
/*     */   }
/*     */   
/*     */   void handleChanged(File outputDir, File changedFile)
/*     */     throws IOException
/*     */   {
/* 116 */     String archivePath = getArchivePath(changedFile);
/* 117 */     PackagingFileAction action = getPackagingAction(archivePath);
/* 118 */     switch (action)
/*     */     {
/*     */     case EXCLUDE: 
/*     */       
/*     */     case MERGE: 
/* 123 */       mergeAll(outputDir, archivePath);
/* 124 */       return;
/*     */     case PICK_FIRST: 
/* 126 */       copy(changedFile, outputDir, archivePath);
/* 127 */       return;
/*     */     case NONE: 
/* 129 */       copy(changedFile, outputDir, archivePath);
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */   public void handleRemoved(File outputDir, String removedFilePath)
/*     */     throws IOException
/*     */   {
/* 149 */     File outFile = new File(outputDir, removedFilePath);
/* 150 */     if ((outFile.exists()) && 
/* 151 */       (!outFile.delete())) {
/* 152 */       throw new IOException("Cannot delete " + outFile.getAbsolutePath());
/*     */     }
/*     */     
/* 155 */     PackagingFileAction itemAction = getPackagingAction(removedFilePath);
/*     */     
/* 157 */     switch (itemAction)
/*     */     {
/*     */     case PICK_FIRST: 
/*     */     case NONE: 
/* 161 */       Optional<File> firstPick = getFirstPick(removedFilePath);
/* 162 */       if (firstPick.isPresent()) {
/* 163 */         copy((File)firstPick.get(), outputDir, removedFilePath);
/*     */       }
/* 165 */       return;
/*     */     
/*     */     case MERGE: 
/* 168 */       mergeAll(outputDir, removedFilePath);
/* 169 */       return;
/*     */     
/*     */     case EXCLUDE: 
/* 172 */       return;
/*     */     }
/* 174 */     throw new RuntimeException("Unhandled package option" + itemAction);
/*     */   }
/*     */   
/*     */   private static void copy(File inputFile, File outputDir, String archivePath)
/*     */     throws IOException
/*     */   {
/* 184 */     File outputFile = new File(outputDir, archivePath);
/* 185 */     FileUtils.mkdirs(outputFile.getParentFile());
/* 186 */     Files.copy(inputFile, outputFile);
/*     */   }
/*     */   
/*     */   private void mergeAll(File outputDir, String archivePath)
/*     */     throws IOException
/*     */   {
/* 192 */     File outputFile = new File(outputDir, archivePath);
/* 193 */     FileUtils.deleteIfExists(outputFile);
/* 194 */     FileUtils.mkdirs(outputFile.getParentFile());
/* 195 */     List<File> allFiles = getAllFiles(archivePath);
/* 196 */     if (!allFiles.isEmpty()) {
/* 197 */       OutputStream os = null;
/*     */       try {
/* 199 */         os = new BufferedOutputStream(new FileOutputStream(outputFile));
/*     */         
/* 201 */         for (File file : allFiles) {
/* 202 */           Files.copy(file, os);
/*     */         }
/*     */       } finally {
/* 205 */         if (os != null) {
/* 206 */           os.close();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private Optional<File> getFirstPick(final String archivePath)
/*     */   {
/* 222 */     Optional.fromNullable(
/* 223 */       forEachExpansionFolder(new FolderAction()
/*     */       {
/*     */         public File on(File folder)
/*     */         {
/* 227 */           File expandedFile = new File(folder, archivePath);
/* 228 */           if (expandedFile.exists()) {
/* 229 */             return expandedFile;
/*     */           }
/* 231 */           return null;
/*     */         }
/*     */       }));
/*     */   }
/*     */   
/*     */   private List<File> getAllFiles(final String archivePath)
/*     */   {
/* 243 */     final ImmutableList.Builder<File> matchingFiles = ImmutableList.builder();
/* 244 */     forEachExpansionFolder(new FolderAction()
/*     */     {
/*     */       public File on(File folder)
/*     */       {
/* 248 */         File expandedFile = new File(folder, archivePath);
/* 249 */         if (expandedFile.exists()) {
/* 250 */           matchingFiles.add(expandedFile);
/*     */         }
/* 252 */         return null;
/*     */       }
/* 254 */     });
/* 255 */     return matchingFiles.build();
/*     */   }
/*     */   
/*     */   private File forEachExpansionFolder(FolderAction action)
/*     */   {
/* 280 */     for (SubStream subStream : expandedFolders) {
/* 281 */       if (subStream.getFolder().isDirectory()) {
/* 282 */         File value = action.on(subStream.getFolder());
/* 283 */         if (value != null) {
/* 284 */           return value;
/*     */         }
/*     */       }
/*     */     }
/* 288 */     return null;
/*     */   }
/*     */   
/*     */   private File getExpansionFolder(final File expandedFile)
/*     */   {
/* 299 */     File expansionFolder = forEachExpansionFolder(new FolderAction()
/*     */     {
/*     */       public File on(File folder)
/*     */       {
/* 303 */         return expandedFile.getAbsolutePath().startsWith(folder.getAbsolutePath()) ? folder : null;
/*     */       }
/*     */     });
/*     */     
/* 307 */     if (expansionFolder == null)
/*     */     {
/* 309 */       throw new RuntimeException("Cannot determine expansion folder for " + expandedFile + " with folders " + Joiner.on(",").join(expandedFolders));
/*     */     }
/* 311 */     return expansionFolder;
/*     */   }
/*     */   
/*     */   private String getArchivePath(File expandedFile)
/*     */   {
/* 323 */     File expansionFolder = getExpansionFolder(expandedFile);
/* 324 */     return expandedFile.getAbsolutePath()
/* 325 */       .substring(expansionFolder.getAbsolutePath().length() + 1);
/*     */   }
/*     */   
/*     */   private PackagingFileAction getPackagingAction(String archivePath)
/*     */   {
/* 335 */     if (packagingOptions != null) {
/* 336 */       return packagingOptions.getAction(archivePath);
/*     */     }
/* 338 */     return PackagingFileAction.NONE;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.FileFilter
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */