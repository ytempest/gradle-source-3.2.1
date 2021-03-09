/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.api.transform.DirectoryInput;
/*     */ import com.android.build.api.transform.Format;
/*     */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.api.transform.Status;
/*     */ import com.android.build.api.transform.Transform;
/*     */ import com.android.build.api.transform.TransformException;
/*     */ import com.android.build.api.transform.TransformInput;
/*     */ import com.android.build.api.transform.TransformInvocation;
/*     */ import com.android.build.api.transform.TransformOutputProvider;
/*     */ import com.android.build.gradle.internal.LoggerWrapper;
/*     */ import com.android.build.gradle.internal.incremental.InstantRunBuildContext;
/*     */ import com.android.build.gradle.internal.pipeline.TransformManager;
/*     */ import com.android.build.gradle.internal.scope.InstantRunVariantScope;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.android.utils.ILogger;
/*     */ import com.google.common.annotations.VisibleForTesting;
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.common.collect.TreeTraverser;
/*     */ import com.google.common.io.Files;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.objectweb.asm.ClassWriter;
/*     */ 
/*     */ public class InstantRunSlicer
/*     */   extends Transform
/*     */ {
/*     */   @VisibleForTesting
/*     */   static final String PACKAGE_FOR_GUARD_CLASS = "com/android/tools/ir/dummy";
/*     */   public static final int NUMBER_OF_SLICES_FOR_PROJECT_CLASSES = 10;
/*     */   private final ILogger logger;
/*     */   private final InstantRunVariantScope variantScope;
/*     */   
/*     */   public InstantRunSlicer(Logger logger, InstantRunVariantScope variantScope)
/*     */   {
/*  75 */     this.logger = new LoggerWrapper(logger);
/*  76 */     this.variantScope = variantScope;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  82 */     return "instantRunSlicer";
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.ContentType> getInputTypes()
/*     */   {
/*  88 */     return TransformManager.CONTENT_CLASS;
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.ContentType> getOutputTypes()
/*     */   {
/*  94 */     return TransformManager.CONTENT_CLASS;
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.Scope> getScopes()
/*     */   {
/* 100 */     return Sets.immutableEnumSet(QualifiedContent.Scope.PROJECT, new QualifiedContent.Scope[] { QualifiedContent.Scope.SUB_PROJECTS });
/*     */   }
/*     */   
/*     */   public boolean isIncremental()
/*     */   {
/* 105 */     return true;
/*     */   }
/*     */   
/*     */   public void transform(TransformInvocation transformInvocation)
/*     */     throws IOException, TransformException, InterruptedException
/*     */   {
/* 112 */     TransformOutputProvider outputProvider = transformInvocation.getOutputProvider();
/* 113 */     boolean isIncremental = transformInvocation.isIncremental();
/* 114 */     Collection<TransformInput> inputs = transformInvocation.getInputs();
/* 115 */     if (outputProvider == null) {
/* 116 */       logger.error(null, "null TransformOutputProvider for InstantRunSlicer", new Object[0]);
/* 117 */       return;
/*     */     }
/*     */     
/* 120 */     Slices slices = new Slices(null);
/*     */     
/* 122 */     if (isIncremental) {
/* 123 */       processCodeChanges(inputs, outputProvider, slices);
/*     */     } else {
/* 125 */       slice(inputs, outputProvider, slices);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void slice(Collection<TransformInput> inputs, TransformOutputProvider outputProvider, Slices slices)
/*     */     throws IOException, TransformException, InterruptedException
/*     */   {
/* 145 */     for (TransformInput input : inputs) {
/* 146 */       for (DirectoryInput directoryInput : input.getDirectoryInputs()) {
/* 147 */         inputDir = directoryInput.getFile();
/* 148 */         for (File file : Files.fileTreeTraverser()
/* 149 */           .breadthFirstTraversal(directoryInput.getFile())) {
/* 150 */           if (!file.isDirectory())
/*     */           {
/* 154 */             String packagePath = FileUtils.relativePossiblyNonExistingPath(file.getParentFile(), inputDir);
/* 155 */             slices.addElement(packagePath, file);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     File inputDir;
/* 161 */     slices.writeTo(outputProvider);
/*     */   }
/*     */   
/*     */   private void processCodeChanges(Collection<TransformInput> inputs, TransformOutputProvider outputProvider, Slices slices)
/*     */     throws TransformException, InterruptedException, IOException
/*     */   {
/* 171 */     for (TransformInput input : inputs) {
/* 172 */       for (localIterator2 = input.getDirectoryInputs().iterator(); localIterator2.hasNext();) { directoryInput = (DirectoryInput)localIterator2.next();
/* 173 */         for (Map.Entry<File, Status> changedFile : directoryInput.getChangedFiles()
/* 174 */           .entrySet())
/*     */         {
/* 176 */           File fileToProcess = (File)changedFile.getKey();
/* 177 */           Status status = (Status)changedFile.getValue();
/* 178 */           File sliceOutputLocation = getOutputStreamForFile(outputProvider, directoryInput, fileToProcess, slices);
/*     */           
/* 187 */           if (fileToProcess.isFile())
/*     */           {
/* 189 */             if ((!sliceOutputLocation.exists()) && (!sliceOutputLocation.mkdirs())) {
/* 190 */               throw new IOException("Cannot create folder " + sliceOutputLocation);
/*     */             }
/*     */             
/* 193 */             Files.write(
/* 194 */               String.valueOf(variantScope
/* 195 */               .getInstantRunBuildContext().getBuildId()), new File(sliceOutputLocation, "buildId.txt"), Charsets.UTF_8);
/*     */             
/* 198 */             logger.verbose("Writing buildId in %s because of %s", new Object[] {sliceOutputLocation
/* 199 */               .getAbsolutePath(), changedFile
/* 200 */               .toString() });
/*     */           }
/*     */           
/* 204 */           String relativePath = FileUtils.relativePossiblyNonExistingPath(fileToProcess, directoryInput
/* 205 */             .getFile());
/*     */           
/* 207 */           File outputFile = new File(sliceOutputLocation, relativePath);
/* 208 */           switch (status) {
/*     */           case ADDED: 
/*     */           case CHANGED: 
/* 211 */             if (fileToProcess.isFile()) {
/* 212 */               Files.createParentDirs(outputFile);
/* 213 */               Files.copy(fileToProcess, outputFile);
/* 214 */               logger.verbose("Copied %s to %s", new Object[] { fileToProcess, outputFile });
/*     */             }
/*     */             
/*     */             break;
/*     */           case REMOVED: 
/* 220 */             if (outputFile.exists()) {
/* 221 */               if (outputFile.isDirectory()) {
/* 222 */                 FileUtils.deleteDirectoryContents(outputFile);
/*     */               }
/* 224 */               if (!outputFile.delete())
/*     */               {
/* 226 */                 throw new TransformException(String.format("Cannot delete file %1$s", new Object[] {outputFile
/* 227 */                   .getAbsolutePath() }));
/*     */               }
/* 229 */               logger.verbose("Deleted %s", new Object[] { outputFile });
/*     */             }
/*     */             break;
/*     */           default: 
/* 233 */             throw new TransformException("Unhandled status " + status);
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     Iterator localIterator2;
/*     */     
/*     */     DirectoryInput directoryInput;
/*     */   }
/*     */   
/*     */   private static File getOutputStreamForFile(TransformOutputProvider transformOutputProvider, DirectoryInput input, File file, Slices slices)
/*     */   {
/* 247 */     String relativePackagePath = FileUtils.relativePossiblyNonExistingPath(file.getParentFile(), input
/* 248 */       .getFile());
/*     */     
/* 250 */     Slice slice = slices.getSliceFor(new InstantRunSlicer.Slice.SlicedElement(relativePackagePath, file, null));
/* 251 */     return transformOutputProvider.getContentLocation(name, TransformManager.CONTENT_CLASS, 
/*     */     
/* 253 */       Sets.immutableEnumSet(QualifiedContent.Scope.PROJECT, new QualifiedContent.Scope[] { QualifiedContent.Scope.SUB_PROJECTS }), Format.DIRECTORY);
/*     */   }
/*     */   
/*     */   private static class Slices
/*     */   {
/* 258 */     private final List<InstantRunSlicer.Slice> slices = new ArrayList();
/*     */     
/*     */     private Slices()
/*     */     {
/* 262 */       for (int i = 0; i < 10; i++) {
/* 263 */         InstantRunSlicer.Slice newSlice = new InstantRunSlicer.Slice("slice_" + i, i, null);
/* 264 */         slices.add(newSlice);
/*     */       }
/*     */     }
/*     */     
/*     */     private void addElement(String packagePath, File file) {
/* 269 */       InstantRunSlicer.Slice.SlicedElement slicedElement = new InstantRunSlicer.Slice.SlicedElement(packagePath, file, null);
/* 270 */       InstantRunSlicer.Slice slice = getSliceFor(slicedElement);
/* 271 */       slice.add(slicedElement);
/*     */     }
/*     */     
/*     */     private void writeTo(TransformOutputProvider outputProvider) throws IOException {
/* 275 */       for (InstantRunSlicer.Slice slice : slices) {
/* 276 */         slice.writeTo(outputProvider);
/*     */       }
/*     */     }
/*     */     
/* 281 */     private InstantRunSlicer.Slice getSliceFor(InstantRunSlicer.Slice.SlicedElement slicedElement) { return (InstantRunSlicer.Slice)slices.get(slicedElement.getHashBucket()); }
/*     */   }
/*     */   
/*     */   private static class Slice {
/*     */     private final String name;
/*     */     private final int hashBucket;
/*     */     private final List<SlicedElement> slicedElements;
/*     */     
/*     */     private static class SlicedElement {
/*     */       private final String packagePath;
/*     */       private final File slicedFile;
/*     */       
/*     */       private SlicedElement(String packagePath, File slicedFile) {
/* 294 */         this.packagePath = packagePath;
/* 295 */         this.slicedFile = slicedFile;
/*     */       }
/*     */       
/*     */       public int getHashBucket()
/*     */       {
/* 305 */         String hashTarget = Strings.isNullOrEmpty(packagePath) ? slicedFile.getName() : packagePath;
/*     */         
/* 307 */         return Math.abs(hashTarget.hashCode() % 10);
/*     */       }
/*     */       
/*     */       public String toString()
/*     */       {
/* 312 */         return packagePath + slicedFile.getName();
/*     */       }
/*     */     }
/*     */     
/*     */     private Slice(String name, int hashBucket)
/*     */     {
/* 322 */       this.name = name;
/* 323 */       this.hashBucket = hashBucket;
/* 324 */       slicedElements = new ArrayList();
/*     */     }
/*     */     
/*     */     private void add(SlicedElement slicedElement) {
/* 328 */       if (hashBucket != slicedElement.getHashBucket()) {
/* 329 */         throw new RuntimeException("Wrong bucket for " + slicedElement);
/*     */       }
/* 331 */       slicedElements.add(slicedElement);
/*     */     }
/*     */     
/*     */     private void writeTo(TransformOutputProvider outputProvider) throws IOException
/*     */     {
/* 336 */       File sliceOutputLocation = outputProvider.getContentLocation(name, TransformManager.CONTENT_CLASS, 
/*     */       
/* 338 */         Sets.immutableEnumSet(QualifiedContent.Scope.PROJECT, new QualifiedContent.Scope[] { QualifiedContent.Scope.SUB_PROJECTS }), Format.DIRECTORY);
/*     */       
/* 341 */       FileUtils.cleanOutputDir(sliceOutputLocation);
/*     */       
/* 345 */       InstantRunSlicer.createGuardClass(name, sliceOutputLocation);
/*     */       
/* 348 */       for (SlicedElement slicedElement : slicedElements)
/*     */       {
/* 350 */         File outputFile = new File(sliceOutputLocation, new File(packagePath, slicedFile.getName()).getPath());
/* 351 */         Files.createParentDirs(outputFile);
/* 352 */         Files.copy(slicedFile, outputFile);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void createGuardClass(String name, File outputDir)
/*     */     throws IOException
/*     */   {
/* 360 */     ClassWriter cw = new ClassWriter(0);
/*     */     
/* 362 */     File packageDir = new File(outputDir, "com/android/tools/ir/dummy");
/* 363 */     File outputFile = new File(packageDir, name + ".class");
/* 364 */     Files.createParentDirs(outputFile);
/*     */     
/* 367 */     String appInfoOwner = "com/android/tools/ir/dummy/" + name;
/* 368 */     cw.visit(50, 33, appInfoOwner, null, "java/lang/Object", null);
/* 369 */     cw.visitEnd();
/*     */     
/* 371 */     Files.write(cw.toByteArray(), outputFile);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.InstantRunSlicer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */