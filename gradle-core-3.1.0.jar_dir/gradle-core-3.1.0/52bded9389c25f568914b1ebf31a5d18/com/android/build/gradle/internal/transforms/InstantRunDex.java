/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.api.transform.DirectoryInput;
/*     */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.api.transform.Status;
/*     */ import com.android.build.api.transform.Transform;
/*     */ import com.android.build.api.transform.TransformException;
/*     */ import com.android.build.api.transform.TransformInput;
/*     */ import com.android.build.api.transform.TransformInvocation;
/*     */ import com.android.build.gradle.internal.LoggerWrapper;
/*     */ import com.android.build.gradle.internal.incremental.FileType;
/*     */ import com.android.build.gradle.internal.incremental.InstantRunBuildContext;
/*     */ import com.android.build.gradle.internal.incremental.InstantRunBuildContext.TaskType;
/*     */ import com.android.build.gradle.internal.pipeline.ExtendedContentType;
/*     */ import com.android.build.gradle.internal.scope.InstantRunVariantScope;
/*     */ import com.android.build.gradle.internal.scope.TransformGlobalScope;
/*     */ import com.android.builder.core.DexByteCodeConverter;
/*     */ import com.android.builder.core.DexOptions;
/*     */ import com.android.builder.model.OptionalCompilationStep;
/*     */ import com.android.ide.common.process.LoggedProcessOutputHandler;
/*     */ import com.android.ide.common.process.ProcessException;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.android.utils.ILogger;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableList.Builder;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.ImmutableMap.Builder;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.common.io.Files;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarOutputStream;
/*     */ import org.gradle.api.logging.Logger;
/*     */ 
/*     */ public class InstantRunDex
/*     */   extends Transform
/*     */ {
/*     */   private final Supplier<DexByteCodeConverter> dexByteCodeConverter;
/*     */   private final DexOptions dexOptions;
/*     */   private final ILogger logger;
/*     */   private final InstantRunVariantScope variantScope;
/*     */   private final int minSdkForDx;
/*     */   
/*     */   public InstantRunDex(InstantRunVariantScope transformVariantScope, Supplier<DexByteCodeConverter> dexByteCodeConverter, DexOptions dexOptions, Logger logger, int minSdkForDx)
/*     */   {
/*  90 */     variantScope = transformVariantScope;
/*  91 */     this.dexByteCodeConverter = dexByteCodeConverter;
/*  92 */     this.dexOptions = dexOptions;
/*  93 */     this.logger = new LoggerWrapper(logger);
/*  94 */     this.minSdkForDx = minSdkForDx;
/*     */   }
/*     */   
/*     */   public void transform(TransformInvocation invocation)
/*     */     throws IOException, TransformException, InterruptedException
/*     */   {
/* 101 */     File outputFolder = InstantRunBuildType.RELOAD.getOutputFolder(variantScope);
/*     */     
/* 104 */     boolean changesAreCompatible = variantScope.getInstantRunBuildContext().hasPassedVerification();
/*     */     
/* 106 */     boolean restartDexRequested = variantScope.getGlobalScope().isActive(OptionalCompilationStep.RESTART_ONLY);
/*     */     
/* 108 */     if ((!changesAreCompatible) || (restartDexRequested)) {
/* 109 */       FileUtils.cleanOutputDir(outputFolder);
/* 110 */       return;
/*     */     }
/*     */     
/* 114 */     File classesJar = new File(outputFolder, "classes.jar");
/* 115 */     if (classesJar.exists()) {
/* 116 */       FileUtils.delete(classesJar);
/*     */     }
/* 118 */     Files.createParentDirs(classesJar);
/* 119 */     JarClassesBuilder jarClassesBuilder = getJarClassBuilder(classesJar);
/*     */     try
/*     */     {
/* 122 */       for (TransformInput input : invocation.getReferencedInputs())
/* 123 */         for (DirectoryInput directoryInput : input.getDirectoryInputs())
/*     */         {
/* 125 */           if (directoryInput.getContentTypes().contains(ExtendedContentType.CLASSES_ENHANCED))
/*     */           {
/* 128 */             folder = directoryInput.getFile();
/* 129 */             Iterator localIterator3; if (invocation.isIncremental())
/*     */             {
/* 131 */               for (localIterator3 = directoryInput.getChangedFiles().entrySet().iterator(); localIterator3.hasNext();) { entry = (Map.Entry)localIterator3.next();
/* 132 */                 if (entry.getValue() != Status.REMOVED) {
/* 133 */                   File file = (File)entry.getKey();
/* 134 */                   if (file.isFile()) {
/* 135 */                     jarClassesBuilder.add(folder, file);
/*     */                   }
/*     */                 }
/*     */               }
/*     */             } else {
/* 140 */               Object files = FileUtils.getAllFiles(folder);
/* 141 */               for (File inputFile : (Iterable)files)
/* 142 */                 jarClassesBuilder.add(folder, inputFile);
/*     */             }
/*     */           } }
/*     */     } finally {
/*     */       File folder;
/*     */       Map.Entry<File, Status> entry;
/* 148 */       jarClassesBuilder.close();
/*     */     }
/*     */     
/* 152 */     if (jarClassesBuilder.isEmpty()) {
/* 153 */       FileUtils.cleanOutputDir(outputFolder);
/* 154 */       return;
/*     */     }
/* 156 */     Object inputFiles = ImmutableList.builder();
/* 157 */     ((ImmutableList.Builder)inputFiles).add(classesJar);
/*     */     
/*     */     try
/*     */     {
/* 162 */       variantScope.getInstantRunBuildContext().startRecording(InstantRunBuildContext.TaskType.INSTANT_RUN_DEX);
/* 163 */       convertByteCode(((ImmutableList.Builder)inputFiles).build(), outputFolder);
/* 164 */       variantScope
/* 165 */         .getInstantRunBuildContext()
/* 166 */         .addChangedFile(FileType.RELOAD_DEX, new File(outputFolder, "classes.dex"));
/*     */     } catch (ProcessException e) {
/* 168 */       throw new TransformException(e);
/*     */     }
/*     */     finally
/*     */     {
/* 172 */       variantScope.getInstantRunBuildContext().stopRecording(InstantRunBuildContext.TaskType.INSTANT_RUN_DEX);
/*     */     }
/*     */   }
/*     */   
/*     */   static class JarClassesBuilder implements Closeable
/*     */   {
/*     */     final File outputFile;
/*     */     private JarOutputStream jarOutputStream;
/* 180 */     boolean empty = true;
/*     */     
/*     */     private JarClassesBuilder(File outputFile) {
/* 183 */       this.outputFile = outputFile;
/*     */     }
/*     */     
/*     */     void add(File inputDir, File file) throws IOException {
/* 187 */       if (jarOutputStream == null) {
/* 188 */         jarOutputStream = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(outputFile)));
/*     */       }
/*     */       
/* 191 */       empty = false;
/* 192 */       InstantRunDex.copyFileInJar(inputDir, file, jarOutputStream);
/*     */     }
/*     */     
/*     */     public void close() throws IOException
/*     */     {
/* 197 */       if (jarOutputStream != null) {
/* 198 */         jarOutputStream.close();
/*     */       }
/*     */     }
/*     */     
/*     */     boolean isEmpty() {
/* 203 */       return empty;
/*     */     }
/*     */   }
/*     */   
/*     */   protected void convertByteCode(List<File> inputFiles, File outputFolder)
/*     */     throws InterruptedException, ProcessException, IOException
/*     */   {
/* 212 */     ((DexByteCodeConverter)dexByteCodeConverter.get()).convertByteCode(inputFiles, outputFolder, false, null, dexOptions, new LoggedProcessOutputHandler(logger), minSdkForDx);
/*     */   }
/*     */   
/*     */   protected JarClassesBuilder getJarClassBuilder(File outputFile)
/*     */   {
/* 224 */     return new JarClassesBuilder(outputFile, null);
/*     */   }
/*     */   
/*     */   private static void copyFileInJar(File inputDir, File inputFile, JarOutputStream jarOutputStream)
/*     */     throws IOException
/*     */   {
/* 230 */     String entryName = inputFile.getPath().substring(inputDir.getPath().length() + 1);
/* 231 */     JarEntry jarEntry = new JarEntry(entryName);
/* 232 */     jarOutputStream.putNextEntry(jarEntry);
/* 233 */     Files.copy(inputFile, jarOutputStream);
/* 234 */     jarOutputStream.closeEntry();
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 240 */     return "instantReloadDex";
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.ContentType> getInputTypes()
/*     */   {
/* 246 */     return ImmutableSet.of(ExtendedContentType.CLASSES_ENHANCED);
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.Scope> getScopes()
/*     */   {
/* 252 */     return ImmutableSet.of();
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.Scope> getReferencedScopes()
/*     */   {
/* 258 */     return Sets.immutableEnumSet(QualifiedContent.Scope.PROJECT, new QualifiedContent.Scope[0]);
/*     */   }
/*     */   
/*     */   public Map<String, Object> getParameterInputs()
/*     */   {
/* 264 */     ImmutableMap.Builder<String, Object> params = ImmutableMap.builder();
/* 265 */     params.put("changesAreCompatible", 
/*     */     
/* 267 */       Boolean.valueOf(variantScope.getInstantRunBuildContext().hasPassedVerification()));
/* 268 */     params.put("restartDexRequested", 
/*     */     
/* 270 */       Boolean.valueOf(variantScope.getGlobalScope().isActive(OptionalCompilationStep.RESTART_ONLY)));
/* 271 */     params.put("minSdkForDx", Integer.valueOf(minSdkForDx));
/* 272 */     return params.build();
/*     */   }
/*     */   
/*     */   public Collection<File> getSecondaryDirectoryOutputs()
/*     */   {
/* 278 */     return ImmutableList.of(InstantRunBuildType.RELOAD.getOutputFolder(variantScope));
/*     */   }
/*     */   
/*     */   public boolean isIncremental()
/*     */   {
/* 283 */     return true;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.InstantRunDex
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */