/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.api.transform.DirectoryInput;
/*     */ import com.android.build.api.transform.Format;
/*     */ import com.android.build.api.transform.JarInput;
/*     */ import com.android.build.api.transform.QualifiedContent;
/*     */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.DefaultContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.api.transform.SecondaryFile;
/*     */ import com.android.build.api.transform.TransformException;
/*     */ import com.android.build.api.transform.TransformInput;
/*     */ import com.android.build.api.transform.TransformInvocation;
/*     */ import com.android.build.api.transform.TransformOutputProvider;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.pipeline.TransformManager;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.tasks.SimpleWorkQueue;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.builder.tasks.Job;
/*     */ import com.android.builder.tasks.JobContext;
/*     */ import com.android.builder.tasks.Task;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.base.Joiner;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableList.Builder;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.util.concurrent.SettableFuture;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.logging.Logging;
/*     */ import proguard.ClassPath;
/*     */ import proguard.Configuration;
/*     */ 
/*     */ public class ProGuardTransform
/*     */   extends BaseProguardAction
/*     */ {
/*  64 */   private static final Logger LOG = Logging.getLogger(ProGuardTransform.class);
/*     */   
/*     */   private final VariantScope variantScope;
/*     */   
/*     */   private final File proguardOut;
/*     */   
/*     */   private final File printMapping;
/*     */   
/*     */   private final File dump;
/*     */   private final File printSeeds;
/*     */   private final File printUsage;
/*     */   private final ImmutableList<File> secondaryFileOutputs;
/*  76 */   private File testedMappingFile = null;
/*  77 */   private FileCollection testMappingConfiguration = null;
/*     */   
/*     */   public ProGuardTransform(VariantScope variantScope) {
/*  80 */     super(variantScope);
/*  81 */     this.variantScope = variantScope;
/*     */     
/*  83 */     GlobalScope globalScope = variantScope.getGlobalScope();
/*  84 */     proguardOut = new File(Joiner.on(File.separatorChar).join(
/*  85 */       String.valueOf(globalScope.getBuildDir()), "outputs", new Object[] { "mapping", variantScope
/*     */       
/*  88 */       .getVariantConfiguration().getDirName() }));
/*     */     
/*  90 */     printMapping = new File(proguardOut, "mapping.txt");
/*  91 */     dump = new File(proguardOut, "dump.txt");
/*  92 */     printSeeds = new File(proguardOut, "seeds.txt");
/*  93 */     printUsage = new File(proguardOut, "usage.txt");
/*  94 */     secondaryFileOutputs = ImmutableList.of(printMapping, dump, printSeeds, printUsage);
/*     */   }
/*     */   
/*     */   public File getMappingFile()
/*     */   {
/*  99 */     return printMapping;
/*     */   }
/*     */   
/*     */   public void applyTestedMapping(File testedMappingFile) {
/* 103 */     this.testedMappingFile = testedMappingFile;
/*     */   }
/*     */   
/*     */   public void applyTestedMapping(FileCollection testMappingConfiguration) {
/* 107 */     this.testMappingConfiguration = testMappingConfiguration;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 113 */     return "proguard";
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.ContentType> getInputTypes()
/*     */   {
/* 119 */     return TransformManager.CONTENT_JARS;
/*     */   }
/*     */   
/*     */   public Collection<SecondaryFile> getSecondaryFiles()
/*     */   {
/* 125 */     List<SecondaryFile> files = Lists.newArrayList();
/*     */     
/* 127 */     if ((testedMappingFile != null) && (testedMappingFile.isFile())) {
/* 128 */       files.add(SecondaryFile.nonIncremental(testedMappingFile));
/* 129 */     } else if (testMappingConfiguration != null) {
/* 130 */       files.add(SecondaryFile.nonIncremental(testMappingConfiguration));
/*     */     }
/*     */     
/* 134 */     files.add(SecondaryFile.nonIncremental(getAllConfigurationFiles()));
/*     */     
/* 136 */     return files;
/*     */   }
/*     */   
/*     */   public Collection<File> getSecondaryFileOutputs()
/*     */   {
/* 142 */     return secondaryFileOutputs;
/*     */   }
/*     */   
/*     */   public Map<String, Object> getParameterInputs()
/*     */   {
/* 148 */     return ImmutableMap.of("shrink", 
/* 149 */       Boolean.valueOf(configuration.shrink), "obfuscate", 
/* 150 */       Boolean.valueOf(configuration.obfuscate), "optimize", 
/* 151 */       Boolean.valueOf(configuration.optimize));
/*     */   }
/*     */   
/*     */   public boolean isIncremental()
/*     */   {
/* 156 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isCacheable()
/*     */   {
/* 161 */     return true;
/*     */   }
/*     */   
/*     */   public void transform(final TransformInvocation invocation)
/*     */     throws TransformException
/*     */   {
/* 167 */     final SettableFuture<TransformOutputProvider> resultFuture = SettableFuture.create();
/* 168 */     Job<Void> job = new Job(getName(), new Task()
/*     */     {
/*     */       public void run(Job<Void> job, JobContext<Void> context)
/*     */         throws IOException
/*     */       {
/* 173 */         ProGuardTransform.this.doMinification(invocation
/* 174 */           .getInputs(), invocation
/* 175 */           .getReferencedInputs(), invocation
/* 176 */           .getOutputProvider());
/*     */       }
/*     */       
/*     */       public void finished()
/*     */       {
/* 181 */         resultFuture.set(invocation.getOutputProvider());
/*     */       }
/*     */       
/* 186 */       public void error(Throwable e) { resultFuture.setException(e); } }, resultFuture);
/*     */     
/*     */     try
/*     */     {
/* 190 */       SimpleWorkQueue.push(job);
/*     */       
/*     */       try
/*     */       {
/* 194 */         job.awaitRethrowExceptions();
/*     */       } catch (ExecutionException e) {
/* 196 */         throw new RuntimeException("Job failed, see logs for details", e.getCause());
/*     */       }
/*     */     } catch (InterruptedException e) {
/* 199 */       Thread.currentThread().interrupt();
/* 200 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   private void doMinification(Collection<TransformInput> inputs, Collection<TransformInput> referencedInputs, TransformOutputProvider output)
/*     */     throws IOException
/*     */   {
/*     */     try
/*     */     {
/* 210 */       Preconditions.checkNotNull(output, "Missing output object for transform " + getName());
/* 211 */       Set<QualifiedContent.ContentType> outputTypes = getOutputTypes();
/* 212 */       Set<? super QualifiedContent.Scope> scopes = getScopes();
/*     */       
/* 214 */       File outFile = output.getContentLocation("combined_res_and_classes", outputTypes, scopes, Format.JAR);
/*     */       
/* 216 */       FileUtils.mkdirs(outFile.getParentFile());
/*     */       
/* 218 */       GlobalScope globalScope = variantScope.getGlobalScope();
/*     */       
/* 221 */       File testedMappingFile = computeMappingFile();
/* 222 */       if (testedMappingFile != null) {
/* 223 */         applyMapping(testedMappingFile);
/*     */       }
/*     */       
/* 227 */       addInputsToConfiguration(inputs, false);
/* 228 */       addInputsToConfiguration(referencedInputs, true);
/*     */       
/* 231 */       for (File runtimeJar : globalScope.getAndroidBuilder().getBootClasspath(true)) {
/* 232 */         libraryJar(runtimeJar);
/*     */       }
/*     */       
/* 236 */       outJar(outFile);
/*     */       
/* 240 */       FileUtils.mkdirs(proguardOut);
/*     */       
/* 242 */       for (File configFile : getAllConfigurationFiles()) {
/* 243 */         LOG.info("Applying ProGuard configuration file {}", configFile);
/* 244 */         applyConfigurationFile(configFile);
/*     */       }
/*     */       
/* 247 */       configuration.printMapping = printMapping;
/* 248 */       configuration.dump = dump;
/* 249 */       configuration.printSeeds = printSeeds;
/* 250 */       configuration.printUsage = printUsage;
/*     */       
/* 252 */       forceprocessing();
/* 253 */       runProguard();
/*     */     } catch (Exception e) {
/* 255 */       if ((e instanceof IOException)) {
/* 256 */         throw ((IOException)e);
/*     */       }
/*     */       
/* 259 */       throw new IOException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   private void addInputsToConfiguration(Collection<TransformInput> inputs, boolean referencedOnly)
/*     */   {
/*     */     List<String> baseFilter;
/*     */     ClassPath classPath;
/*     */     List<String> baseFilter;
/* 269 */     if (referencedOnly) {
/* 270 */       ClassPath classPath = configuration.libraryJars;
/* 271 */       baseFilter = JAR_FILTER;
/*     */     } else {
/* 273 */       classPath = configuration.programJars;
/* 274 */       baseFilter = null;
/*     */     }
/*     */     
/* 277 */     for (TransformInput transformInput : inputs) {
/* 278 */       for (JarInput jarInput : transformInput.getJarInputs()) {
/* 279 */         handleQualifiedContent(classPath, jarInput, baseFilter);
/*     */       }
/*     */       
/* 282 */       for (DirectoryInput directoryInput : transformInput.getDirectoryInputs()) {
/* 283 */         handleQualifiedContent(classPath, directoryInput, baseFilter);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void handleQualifiedContent(ClassPath classPath, QualifiedContent content, List<String> baseFilter)
/*     */   {
/* 292 */     List<String> filter = baseFilter;
/*     */     
/* 294 */     if (!content.getContentTypes().contains(QualifiedContent.DefaultContentType.CLASSES))
/*     */     {
/* 297 */       ImmutableList.Builder<String> builder = ImmutableList.builder();
/* 298 */       if (filter != null) {
/* 299 */         builder.addAll(filter);
/*     */       }
/* 301 */       builder.add("!**.class");
/* 302 */       filter = builder.build();
/* 303 */     } else if (!content.getContentTypes().contains(QualifiedContent.DefaultContentType.RESOURCES))
/*     */     {
/* 306 */       filter = ImmutableList.of("**.class");
/*     */     }
/*     */     
/* 309 */     inputJar(classPath, content.getFile(), filter);
/*     */   }
/*     */   
/*     */   private File computeMappingFile()
/*     */   {
/* 314 */     if ((testedMappingFile != null) && (testedMappingFile.isFile()))
/* 315 */       return testedMappingFile;
/* 316 */     if ((testMappingConfiguration != null) && (testMappingConfiguration.getSingleFile().isFile())) {
/* 317 */       return testMappingConfiguration.getSingleFile();
/*     */     }
/*     */     
/* 320 */     return null;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.ProGuardTransform
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */