/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.ndk.NdkHandler;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.tasks.AndroidBuilderTask;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.ide.common.process.LoggedProcessOutputHandler;
/*     */ import com.android.repository.Revision;
/*     */ import com.android.sdklib.BuildToolInfo;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.file.ConfigurableFileCollection;
/*     */ import org.gradle.api.file.FileTree;
/*     */ import org.gradle.api.tasks.CacheableTask;
/*     */ import org.gradle.api.tasks.Input;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.OutputDirectory;
/*     */ import org.gradle.api.tasks.PathSensitive;
/*     */ import org.gradle.api.tasks.PathSensitivity;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ import org.gradle.api.tasks.util.PatternSet;
/*     */ 
/*     */ @CacheableTask
/*     */ public class ShaderCompile
/*     */   extends AndroidBuilderTask
/*     */ {
/*  47 */   private static final PatternSet PATTERN_SET = new PatternSet()
/*  48 */     .include(new String[] { "**/*.vert" })
/*  49 */     .include(new String[] { "**/*.tesc" })
/*  50 */     .include(new String[] { "**/*.tese" })
/*  51 */     .include(new String[] { "**/*.geom" })
/*  52 */     .include(new String[] { "**/*.frag" })
/*  53 */     .include(new String[] { "**/*.comp" });
/*     */   
/*     */   private File outputDir;
/*     */   
/*     */   private File sourceDir;
/*     */   
/*     */   @Input
/*     */   public String getBuildToolsVersion()
/*     */   {
/*  62 */     return getBuildTools().getRevision().toString();
/*     */   }
/*     */   
/*  68 */   private List<String> defaultArgs = ImmutableList.of();
/*  69 */   private Map<String, List<String>> scopedArgs = ImmutableMap.of();
/*     */   private File ndkLocation;
/*     */   
/*     */   @InputFiles
/*     */   @PathSensitive(PathSensitivity.RELATIVE)
/*     */   public FileTree getSourceFiles()
/*     */   {
/*  76 */     FileTree src = null;
/*  77 */     if (sourceDir.isDirectory()) {
/*  78 */       src = getProject().files(new Object[] { sourceDir }).getAsFileTree().matching(PATTERN_SET);
/*     */     }
/*  80 */     return src == null ? getProject().files(new Object[0]).getAsFileTree() : src;
/*     */   }
/*     */   
/*     */   @TaskAction
/*     */   protected void compileShaders() throws IOException
/*     */   {
/*  86 */     File destinationDir = getOutputDir();
/*  87 */     FileUtils.cleanOutputDir(destinationDir);
/*     */     
/*     */     try
/*     */     {
/*  91 */       getBuilder().compileAllShaderFiles(sourceDir, 
/*     */       
/*  93 */         getOutputDir(), defaultArgs, scopedArgs, ndkLocation, new LoggedProcessOutputHandler(
/*     */         
/*  97 */         getILogger()));
/*     */     } catch (Exception e) {
/*  99 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   @OutputDirectory
/*     */   public File getOutputDir() {
/* 105 */     return outputDir;
/*     */   }
/*     */   
/*     */   public void setOutputDir(File sourceOutputDir) {
/* 109 */     outputDir = sourceOutputDir;
/*     */   }
/*     */   
/*     */   public void setSourceDir(File sourceDir) {
/* 113 */     this.sourceDir = sourceDir;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public List<String> getDefaultArgs()
/*     */   {
/* 119 */     return defaultArgs;
/*     */   }
/*     */   
/*     */   public void setDefaultArgs(List<String> defaultArgs) {
/* 123 */     this.defaultArgs = ImmutableList.copyOf(defaultArgs);
/*     */   }
/*     */   
/*     */   @Input
/*     */   public Map<String, List<String>> getScopedArgs()
/*     */   {
/* 129 */     return scopedArgs;
/*     */   }
/*     */   
/*     */   public void setScopedArgs(Map<String, List<String>> scopedArgs) {
/* 133 */     this.scopedArgs = ImmutableMap.copyOf(scopedArgs);
/*     */   }
/*     */   
/*     */   public static class ConfigAction implements TaskConfigAction<ShaderCompile>
/*     */   {
/*     */     VariantScope scope;
/*     */     File outputDir;
/*     */     
/*     */     public ConfigAction(VariantScope scope, File outputDir)
/*     */     {
/* 143 */       this.scope = scope;
/* 144 */       this.outputDir = outputDir;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 150 */       return scope.getTaskName("compile", "Shaders");
/*     */     }
/*     */     
/*     */     public Class<ShaderCompile> getType()
/*     */     {
/* 156 */       return ShaderCompile.class;
/*     */     }
/*     */     
/*     */     public void execute(ShaderCompile compileTask)
/*     */     {
/* 161 */       GradleVariantConfiguration variantConfiguration = scope.getVariantConfiguration();
/*     */       
/* 163 */       scope.getVariantData().shaderCompileTask = compileTask;
/*     */       
/* 165 */       compileTask.setAndroidBuilder(scope.getGlobalScope().getAndroidBuilder());
/* 166 */       compileTask.setVariantName(variantConfiguration.getFullName());
/*     */       
/* 168 */       ndkLocation = scope.getGlobalScope().getNdkHandler().getNdkDirectory();
/*     */       
/* 170 */       compileTask.setSourceDir(scope.getMergeShadersOutputDir());
/* 171 */       compileTask.setOutputDir(outputDir);
/* 172 */       compileTask.setDefaultArgs(variantConfiguration.getDefautGlslcArgs());
/* 173 */       compileTask.setScopedArgs(variantConfiguration.getScopedGlslcArgs());
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ShaderCompile
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */