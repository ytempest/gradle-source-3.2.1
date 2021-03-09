/*     */ package com.android.build.gradle.tasks.factory;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.api.AnnotationProcessorOptions;
/*     */ import com.android.build.gradle.api.JavaCompileOptions;
/*     */ import com.android.build.gradle.internal.LoggerWrapper;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*     */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.build.gradle.options.BooleanOption;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.builder.model.DataBindingOptions;
/*     */ import com.android.sdklib.BuildToolInfo;
/*     */ import com.android.sdklib.BuildToolInfo.PathId;
/*     */ import com.android.utils.ILogger;
/*     */ import com.google.common.base.Joiner;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.file.ConfigurableFileTree;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ 
/*     */ public class JavaCompileConfigAction implements TaskConfigAction<AndroidJavaCompile>
/*     */ {
/*  34 */   private static final ILogger LOG = LoggerWrapper.getLogger(JavaCompileConfigAction.class);
/*     */   private final VariantScope scope;
/*     */   private final File outputFolder;
/*     */   
/*     */   public JavaCompileConfigAction(VariantScope scope, File outputFolder)
/*     */   {
/*  40 */     this.scope = scope;
/*  41 */     this.outputFolder = outputFolder;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  47 */     return scope.getTaskName("compile", "JavaWithJavac");
/*     */   }
/*     */   
/*     */   public Class<AndroidJavaCompile> getType()
/*     */   {
/*  53 */     return AndroidJavaCompile.class;
/*     */   }
/*     */   
/*     */   public void execute(AndroidJavaCompile javacTask)
/*     */   {
/*  58 */     scope.getVariantData().javacTask = javacTask;
/*  59 */     scope.getVariantData().javaCompilerTask = javacTask;
/*  60 */     GlobalScope globalScope = scope.getGlobalScope();
/*  61 */     Project project = globalScope.getProject();
/*  62 */     compileSdkVersion = globalScope.getExtension().getCompileSdkVersion();
/*  63 */     mInstantRunBuildContext = scope.getInstantRunBuildContext();
/*     */     
/*  68 */     for (ConfigurableFileTree fileTree : scope.getVariantData().getJavaSources()) {
/*  69 */       javacTask.source(new Object[] { fileTree });
/*     */     }
/*     */     
/*  72 */     FileCollection classpath = scope.getJavaClasspath(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactType.CLASSES);
/*  73 */     if (globalScope.getProjectOptions().get(BooleanOption.ENABLE_CORE_LAMBDA_STUBS))
/*     */     {
/*  79 */       File coreLambdaStubsJar = new File(globalScope.getAndroidBuilder().getBuildToolInfo().getPath(BuildToolInfo.PathId.CORE_LAMBDA_STUBS));
/*  80 */       javacTask
/*  81 */         .getOptions()
/*  82 */         .setBootstrapClasspath(project
/*  83 */         .files(new Object[] {globalScope
/*  84 */         .getAndroidBuilder().getBootClasspath(false), coreLambdaStubsJar }));
/*     */     }
/*     */     else {
/*  87 */       boolean keepDefaultBootstrap = scope.keepDefaultBootstrap();
/*     */       
/*  89 */       if (!keepDefaultBootstrap)
/*     */       {
/*  95 */         javacTask.getOptions().setBootstrapClasspath(project
/*  96 */           .files(new Object[] {globalScope
/*  97 */           .getAndroidBuilder().getBootClasspath(false) }));
/*     */       }
/*  99 */       if (keepDefaultBootstrap)
/*     */       {
/* 101 */         classpath = classpath.plus(project
/* 102 */           .files(new Object[] {globalScope
/* 103 */           .getAndroidBuilder().getBootClasspath(false) }));
/*     */       }
/*     */     }
/* 106 */     javacTask.setClasspath(classpath);
/*     */     
/* 108 */     javacTask.setDestinationDir(outputFolder);
/*     */     
/* 110 */     com.android.build.gradle.internal.CompileOptions compileOptions = globalScope.getExtension().getCompileOptions();
/*     */     
/* 112 */     AbstractCompilesUtil.configureLanguageLevel(javacTask, compileOptions, globalScope
/*     */     
/* 115 */       .getExtension().getCompileSdkVersion(), scope
/* 116 */       .getJava8LangSupportType());
/*     */     
/* 118 */     javacTask.getOptions().setEncoding(compileOptions.getEncoding());
/*     */     
/* 124 */     Boolean includeCompileClasspath = scope.getVariantConfiguration().getJavaCompileOptions().getAnnotationProcessorOptions().getIncludeCompileClasspath();
/*     */     
/* 127 */     FileCollection processorPath = scope.getArtifactFileCollection(AndroidArtifacts.ConsumedConfigType.ANNOTATION_PROCESSOR, AndroidArtifacts.ArtifactScope.ALL, AndroidArtifacts.ArtifactType.JAR);
/* 128 */     if (Boolean.TRUE.equals(includeCompileClasspath))
/*     */     {
/* 130 */       processorPath = processorPath.plus(scope.getJavaClasspath(AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, AndroidArtifacts.ArtifactType.JAR));
/*     */     }
/*     */     
/* 133 */     javacTask.getOptions().setAnnotationProcessorPath(processorPath);
/*     */     
/* 135 */     boolean incremental = AbstractCompilesUtil.isIncremental(project, scope, compileOptions, null, LOG);
/*     */     
/* 142 */     if (incremental) {
/* 143 */       LOG.verbose("Using incremental javac compilation for %1$s %2$s.", new Object[] {project
/* 144 */         .getPath(), scope.getFullVariantName() });
/* 145 */       javacTask.getOptions().setIncremental(true);
/*     */     } else {
/* 147 */       LOG.verbose("Not using incremental javac compilation for %1$s %2$s.", new Object[] {project
/* 148 */         .getPath(), scope.getFullVariantName() });
/*     */     }
/*     */     
/* 154 */     AnnotationProcessorOptions annotationProcessorOptions = scope.getVariantConfiguration().getJavaCompileOptions().getAnnotationProcessorOptions();
/*     */     
/* 156 */     if (!annotationProcessorOptions.getClassNames().isEmpty()) {
/* 157 */       javacTask.getOptions().getCompilerArgs().add("-processor");
/* 158 */       javacTask.getOptions().getCompilerArgs().add(
/* 159 */         Joiner.on(',').join(annotationProcessorOptions.getClassNames()));
/*     */     }
/* 161 */     if (!annotationProcessorOptions.getArguments().isEmpty())
/*     */     {
/* 163 */       for (Map.Entry<String, String> arg : annotationProcessorOptions.getArguments().entrySet()) {
/* 164 */         javacTask.getOptions().getCompilerArgs().add("-A" + 
/* 165 */           (String)arg.getKey() + "=" + (String)arg.getValue());
/*     */       }
/*     */     }
/*     */     
/* 171 */     javacTask.getOptions().setAnnotationProcessorGeneratedSourcesDirectory(scope
/* 172 */       .getAnnotationProcessorOutputDir());
/* 173 */     annotationProcessorOutputFolder = scope.getAnnotationProcessorOutputDir();
/*     */     
/* 175 */     if (scope.getGlobalScope().getExtension().getDataBinding().isEnabled()) {
/* 176 */       if (scope.hasOutput(TaskOutputHolder.TaskOutputType.DATA_BINDING_DEPENDENCY_ARTIFACTS))
/*     */       {
/* 181 */         dataBindingDependencyArtifacts = scope.getOutput(TaskOutputHolder.TaskOutputType.DATA_BINDING_DEPENDENCY_ARTIFACTS);
/*     */       }
/* 183 */       if (scope.hasOutput(TaskOutputHolder.TaskOutputType.DATA_BINDING_BASE_CLASS_LOG_ARTIFACT))
/*     */       {
/* 185 */         dataBindingClassLogDir = scope.getOutput(TaskOutputHolder.TaskOutputType.DATA_BINDING_BASE_CLASS_LOG_ARTIFACT);
/*     */       }
/*     */       
/* 190 */       dataBindingArtifactOutputDirectory = scope.getBundleArtifactFolderForDataBinding();
/* 191 */       scope.addTaskOutput(TaskOutputHolder.TaskOutputType.DATA_BINDING_ARTIFACT, dataBindingArtifactOutputDirectory, javacTask
/*     */       
/* 194 */         .getName());
/*     */     }
/*     */     
/* 197 */     processorListFile = scope.getOutput(TaskOutputHolder.TaskOutputType.ANNOTATION_PROCESSOR_LIST);
/* 198 */     variantName = scope.getFullVariantName();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.factory.JavaCompileConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */