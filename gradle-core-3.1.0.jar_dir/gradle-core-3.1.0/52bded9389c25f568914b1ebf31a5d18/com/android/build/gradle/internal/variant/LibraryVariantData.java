/*     */ package com.android.build.gradle.internal.variant;
/*     */ 
/*     */ import com.android.build.gradle.AndroidConfig;
/*     */ import com.android.build.gradle.internal.TaskManager;
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.dsl.CoreBuildType;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.OutputFactory;
/*     */ import com.android.build.gradle.tasks.ExtractAnnotations;
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.builder.profile.Recorder;
/*     */ import com.android.utils.StringHelper;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import org.gradle.api.Task;
/*     */ import org.gradle.api.tasks.bundling.Zip;
/*     */ 
/*     */ public class LibraryVariantData
/*     */   extends BaseVariantData
/*     */   implements TestedVariantData
/*     */ {
/*     */   private final Map<VariantType, TestVariantData> testVariants;
/*     */   public Zip packageLibTask;
/*  43 */   public ExtractAnnotations generateAnnotationsTask = null;
/*     */   
/*     */   public LibraryVariantData(GlobalScope globalScope, AndroidConfig androidConfig, TaskManager taskManager, GradleVariantConfiguration config, Recorder recorder)
/*     */   {
/*  52 */     super(globalScope, androidConfig, taskManager, config, recorder);
/*  53 */     testVariants = Maps.newEnumMap(VariantType.class);
/*     */     
/*  56 */     getOutputFactory()
/*  57 */       .addMainOutput(globalScope
/*  58 */       .getProjectBaseName() + "-" + 
/*     */       
/*  60 */       getVariantConfiguration().getBaseName() + "." + "aar");
/*     */   }
/*     */   
/*     */   public String getDescription()
/*     */   {
/*  68 */     GradleVariantConfiguration config = getVariantConfiguration();
/*     */     
/*  70 */     if (config.hasFlavors()) {
/*  71 */       StringBuilder sb = new StringBuilder(50);
/*  72 */       StringHelper.appendCapitalized(sb, ((CoreBuildType)config.getBuildType()).getName());
/*  73 */       sb.append(" build for flavor ");
/*  74 */       StringHelper.appendCapitalized(sb, config.getFlavorName());
/*  75 */       return sb.toString();
/*     */     }
/*  77 */     return StringHelper.capitalizeWithSuffix(((CoreBuildType)config.getBuildType()).getName(), " build");
/*     */   }
/*     */   
/*     */   public TestVariantData getTestVariantData(VariantType type)
/*     */   {
/*  84 */     return (TestVariantData)testVariants.get(type);
/*     */   }
/*     */   
/*     */   public void setTestVariantData(TestVariantData testVariantData, VariantType type)
/*     */   {
/*  90 */     testVariants.put(type, testVariantData);
/*     */   }
/*     */   
/*     */   public void registerJavaGeneratingTask(Task task, File... generatedSourceFolders)
/*     */   {
/*  97 */     super.registerJavaGeneratingTask(task, generatedSourceFolders);
/*  98 */     if (generateAnnotationsTask != null) {
/*  99 */       for (File f : generatedSourceFolders) {
/* 100 */         generateAnnotationsTask.source(new Object[] { f });
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void registerJavaGeneratingTask(Task task, Collection<File> generatedSourceFolders)
/*     */   {
/* 109 */     super.registerJavaGeneratingTask(task, generatedSourceFolders);
/* 110 */     if (generateAnnotationsTask != null) {
/* 111 */       for (File f : generatedSourceFolders) {
/* 112 */         generateAnnotationsTask.source(new Object[] { f });
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant.LibraryVariantData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */