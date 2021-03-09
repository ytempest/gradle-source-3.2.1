/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import com.android.build.gradle.api.AndroidSourceSet;
/*     */ import com.android.build.gradle.internal.dsl.AndroidSourceSetFactory;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*     */ import com.android.build.gradle.internal.variant2.DeprecatedConfigurationAction;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import java.util.Set;
/*     */ import kotlin.jvm.JvmOverloads;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.NamedDomainObjectContainer;
/*     */ import org.gradle.api.NamedDomainObjectFactory;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.artifacts.Configuration;
/*     */ import org.gradle.api.artifacts.ConfigurationContainer;
/*     */ import org.gradle.api.artifacts.DependencySet;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.logging.Logging;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\\\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020#\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\007\030\0002\0020\001B%\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\t¢\006\002\020\nJ\006\020\027\032\0020\030J\"\020\031\032\0020\0322\006\020\033\032\0020\0172\006\020\034\032\0020\0172\b\b\002\020\035\032\0020\005H\002J\030\020\036\032\0020\0302\006\020\037\032\0020\0242\006\020 \032\0020\005H\002J\032\020!\032\0020\0302\022\020\"\032\016\022\n\022\b\022\004\022\0020\0240\0230#J\030\020$\032\0020\0172\006\020\033\032\0020\0172\006\020%\032\0020\017H\002J \020&\032\0020\0172\006\020\033\032\0020\0172\006\020%\032\0020\0172\006\020'\032\0020\017H\002J\032\020(\032\0020\0242\006\020\033\032\0020\0172\b\b\002\020 \032\0020\005H\007J\016\020)\032\0020\0242\006\020\033\032\0020\017R\016\020\013\032\0020\fX\004¢\006\002\n\000R\024\020\r\032\b\022\004\022\0020\0170\016X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\020\032\0020\021X\004¢\006\002\n\000R\016\020\004\032\0020\005X\004¢\006\002\n\000R\027\020\022\032\b\022\004\022\0020\0240\023¢\006\b\n\000\032\004\b\025\020\026¨\006*"}, d2={"Lcom/android/build/gradle/internal/dependency/SourceSetManager;", "", "project", "Lorg/gradle/api/Project;", "publishPackage", "", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lorg/gradle/api/Project;ZLcom/android/build/gradle/internal/errors/DeprecationReporter;Lcom/android/builder/errors/EvalIssueReporter;)V", "configurations", "Lorg/gradle/api/artifacts/ConfigurationContainer;", "configuredSourceSets", "", "", "logger", "Lorg/gradle/api/logging/Logger;", "sourceSetsContainer", "Lorg/gradle/api/NamedDomainObjectContainer;", "Lcom/android/build/gradle/api/AndroidSourceSet;", "getSourceSetsContainer", "()Lorg/gradle/api/NamedDomainObjectContainer;", "checkForUnconfiguredSourceSets", "", "createConfiguration", "Lorg/gradle/api/artifacts/Configuration;", "name", "description", "canBeResolved", "createConfigurationsForSourceSet", "sourceSet", "isForTesting", "executeAction", "action", "Lorg/gradle/api/Action;", "getConfigDesc", "sourceSetName", "getDeprecatedConfigDesc", "replacement", "setUpSourceSet", "setUpTestSourceSet", "gradle-core"})
/*     */ public final class SourceSetManager
/*     */ {
/*     */   @NotNull
/*     */   private final NamedDomainObjectContainer<AndroidSourceSet> sourceSetsContainer;
/*     */   private final ConfigurationContainer configurations;
/*     */   private final Logger logger;
/*     */   private final Set<String> configuredSourceSets;
/*     */   private final boolean publishPackage;
/*     */   private final DeprecationReporter deprecationReporter;
/*     */   private final EvalIssueReporter issueReporter;
/*     */   
/*     */   @NotNull
/*     */   public final NamedDomainObjectContainer<AndroidSourceSet> getSourceSetsContainer()
/*     */   {
/*  38 */     return sourceSetsContainer;
/*     */   }
/*     */   
/*     */   public SourceSetManager(@NotNull Project project, boolean publishPackage, @NotNull DeprecationReporter deprecationReporter, @NotNull EvalIssueReporter issueReporter)
/*     */   {
/*  33 */     this.publishPackage = publishPackage;this.deprecationReporter = deprecationReporter;this.issueReporter = issueReporter; NamedDomainObjectContainer 
/*     */     
/*  38 */       tmp72_67 = project.container(
/*  39 */       AndroidSourceSet.class, 
/*  40 */       (NamedDomainObjectFactory)new AndroidSourceSetFactory(project.getObjects(), project, this.publishPackage));Intrinsics.checkExpressionValueIsNotNull(tmp72_67, "project.container(\n     …project, publishPackage))");sourceSetsContainer = tmp72_67; ConfigurationContainer 
/*  41 */       tmp89_84 = project.getConfigurations();Intrinsics.checkExpressionValueIsNotNull(tmp89_84, "project.configurations");configurations = tmp89_84; Logger 
/*  42 */       tmp107_104 = Logging.getLogger(getClass());Intrinsics.checkExpressionValueIsNotNull(tmp107_104, "Logging.getLogger(this.javaClass)");logger = tmp107_104;
/*     */     
/*  44 */     SourceSetManager localSourceSetManager = this;Set localSet = (Set)new java.util.LinkedHashSet();configuredSourceSets = localSet; }
/*     */   
/*     */   @NotNull
/*  47 */   public final AndroidSourceSet setUpTestSourceSet(@NotNull String name) { Intrinsics.checkParameterIsNotNull(name, "name");return setUpSourceSet(name, true);
/*     */   }
/*     */   
/*     */   @JvmOverloads
/*     */   @NotNull
/*  52 */   public final AndroidSourceSet setUpSourceSet(@NotNull String name, boolean isForTesting) { Intrinsics.checkParameterIsNotNull(name, "name");AndroidSourceSet sourceSet = (AndroidSourceSet)sourceSetsContainer.maybeCreate(name);
/*  53 */     if (!configuredSourceSets.contains(name)) {
/*  54 */       AndroidSourceSet tmp35_34 = sourceSet;Intrinsics.checkExpressionValueIsNotNull(tmp35_34, "sourceSet");createConfigurationsForSourceSet(tmp35_34, isForTesting);
/*  55 */       configuredSourceSets.add(name);
/*     */     }
/*  57 */     AndroidSourceSet tmp57_56 = sourceSet;Intrinsics.checkExpressionValueIsNotNull(tmp57_56, "sourceSet");return tmp57_56;
/*     */   }
/*     */   
/*     */   private final void createConfigurationsForSourceSet(AndroidSourceSet sourceSet, boolean isForTesting)
/*     */   {
/*  62 */     String implementationName = sourceSet.getImplementationConfigurationName();
/*  63 */     String runtimeOnlyName = sourceSet.getRuntimeOnlyConfigurationName();
/*  64 */     String compileOnlyName = sourceSet.getCompileOnlyConfigurationName();
/*     */     
/*  67 */     String compileName = sourceSet.getCompileConfigurationName(); String 
/*     */     
/*  72 */       tmp34_32 = compileName;Intrinsics.checkExpressionValueIsNotNull(tmp34_32, "compileName"); String 
/*  73 */       tmp49_44 = sourceSet.getName();Intrinsics.checkExpressionValueIsNotNull(tmp49_44, "sourceSet.name"); String tmp56_55 = implementationName;Intrinsics.checkExpressionValueIsNotNull(tmp56_55, "implementationName");Configuration compile = createConfiguration(tmp34_32, getDeprecatedConfigDesc("Compile", tmp49_44, tmp56_55), 
/*  74 */       (Intrinsics.areEqual("compile", compileName)) || (Intrinsics.areEqual("testCompile", compileName)));
/*  75 */     compile.getAllDependencies()
/*  76 */       .whenObjectAdded(
/*  77 */       (Action)new DeprecatedConfigurationAction(
/*  78 */       implementationName, 
/*  79 */       compileName, 
/*  80 */       deprecationReporter, 
/*  81 */       DeprecationReporter.DeprecationTarget.CONFIG_NAME));
/*     */     
/*     */     String packageConfigDescription;
/*  84 */     if (publishPackage)
/*     */     {
/*  86 */       String tmp144_139 = sourceSet.getName();Intrinsics.checkExpressionValueIsNotNull(tmp144_139, "sourceSet.name"); String 
/*  87 */         tmp152_150 = runtimeOnlyName;Intrinsics.checkExpressionValueIsNotNull(tmp152_150, "runtimeOnlyName");packageConfigDescription = getDeprecatedConfigDesc("Publish", tmp144_139, tmp152_150);
/*     */     }
/*     */     else {
/*  90 */       String tmp175_170 = sourceSet.getName();Intrinsics.checkExpressionValueIsNotNull(tmp175_170, "sourceSet.name"); String 
/*  91 */         tmp183_181 = runtimeOnlyName;Intrinsics.checkExpressionValueIsNotNull(tmp183_181, "runtimeOnlyName");packageConfigDescription = getDeprecatedConfigDesc("Apk", tmp175_170, tmp183_181);
/*     */     }
/*     */     
/*  94 */     String apkName = sourceSet.getPackageConfigurationName(); String 
/*  95 */       tmp205_203 = apkName;Intrinsics.checkExpressionValueIsNotNull(tmp205_203, "apkName");Configuration apk = createConfiguration$default(this, tmp205_203, packageConfigDescription, false, 4, null);
/*  96 */     apk.getAllDependencies()
/*  97 */       .whenObjectAdded(
/*  98 */       (Action)new DeprecatedConfigurationAction(
/*  99 */       runtimeOnlyName, 
/* 100 */       apkName, 
/* 101 */       deprecationReporter, 
/* 102 */       DeprecationReporter.DeprecationTarget.CONFIG_NAME));
/*     */     
/* 104 */     String providedName = sourceSet.getProvidedConfigurationName(); String 
/*     */     
/* 106 */       tmp266_264 = providedName;Intrinsics.checkExpressionValueIsNotNull(tmp266_264, "providedName"); String 
/* 107 */       tmp281_276 = sourceSet.getName();Intrinsics.checkExpressionValueIsNotNull(tmp281_276, "sourceSet.name"); String tmp289_287 = compileOnlyName;Intrinsics.checkExpressionValueIsNotNull(tmp289_287, "compileOnlyName");Configuration provided = createConfiguration$default(this, tmp266_264, getDeprecatedConfigDesc("Provided", tmp281_276, tmp289_287), false, 4, null);
/* 108 */     provided.getAllDependencies()
/* 109 */       .whenObjectAdded(
/* 110 */       (Action)new DeprecatedConfigurationAction(
/* 111 */       compileOnlyName, 
/* 112 */       providedName, 
/* 113 */       deprecationReporter, 
/* 114 */       DeprecationReporter.DeprecationTarget.CONFIG_NAME));
/*     */     
/* 117 */     String apiName = sourceSet.getApiConfigurationName(); String 
/* 118 */       tmp351_349 = apiName;Intrinsics.checkExpressionValueIsNotNull(tmp351_349, "apiName"); String tmp366_361 = sourceSet.getName();Intrinsics.checkExpressionValueIsNotNull(tmp366_361, "sourceSet.name");Configuration api = createConfiguration$default(this, tmp351_349, getConfigDesc("API", tmp366_361), false, 4, null);
/* 119 */     api.extendsFrom(new Configuration[] { compile });
/* 120 */     if (isForTesting)
/*     */     {
/* 122 */       api.getAllDependencies().whenObjectAdded(
/* 123 */         (Action)new DeprecatedConfigurationAction(
/* 124 */         implementationName, 
/* 125 */         apiName, 
/* 126 */         deprecationReporter, 
/* 127 */         DeprecationReporter.DeprecationTarget.CONFIG_NAME));
/*     */     }
/*     */     
/* 132 */     String tmp448_443 = sourceSet.getName();Intrinsics.checkExpressionValueIsNotNull(tmp448_443, "sourceSet.name");Configuration implementation = createConfiguration$default(this, implementationName, getConfigDesc("Implementation only", tmp448_443), false, 4, null);
/* 133 */     implementation.extendsFrom(new Configuration[] { api }); String 
/*     */     
/* 136 */       tmp494_489 = sourceSet.getName();Intrinsics.checkExpressionValueIsNotNull(tmp494_489, "sourceSet.name");Configuration runtimeOnly = createConfiguration$default(this, runtimeOnlyName, getConfigDesc("Runtime only", tmp494_489), false, 4, null);
/* 137 */     runtimeOnly.extendsFrom(new Configuration[] { apk }); String 
/*     */     
/* 140 */       tmp540_535 = sourceSet.getName();Intrinsics.checkExpressionValueIsNotNull(tmp540_535, "sourceSet.name");Configuration compileOnly = createConfiguration$default(this, compileOnlyName, getConfigDesc("Compile only", tmp540_535), false, 4, null);
/* 141 */     compileOnly.extendsFrom(new Configuration[] { provided }); String 
/*     */     
/* 145 */       tmp581_576 = sourceSet.getWearAppConfigurationName();Intrinsics.checkExpressionValueIsNotNull(tmp581_576, "sourceSet.wearAppConfigurationName");Configuration wearConfig = createConfiguration$default(this, tmp581_576, 
/* 146 */       "Link to a wear app to embed for object '" + sourceSet.getName() + "'.", false, 4, null); String 
/*     */     
/* 149 */       tmp631_626 = sourceSet.getAnnotationProcessorConfigurationName();Intrinsics.checkExpressionValueIsNotNull(tmp631_626, "sourceSet.annotationProcessorConfigurationName");createConfiguration$default(this, tmp631_626, 
/* 150 */       "Classpath for the annotation processor for '" + sourceSet.getName() + "'.", false, 4, null);
/*     */   }
/*     */   
/*     */   private final Configuration createConfiguration(String name, String description, boolean canBeResolved)
/*     */   {
/* 164 */     logger.info("Creating configuration {}", name);
/*     */     
/* 166 */     Configuration configuration = (Configuration)configurations.maybeCreate(name); Configuration 
/*     */     
/* 168 */       tmp29_27 = configuration;Intrinsics.checkExpressionValueIsNotNull(tmp29_27, "configuration");tmp29_27.setVisible(false);
/* 169 */     configuration.setDescription(description);
/* 170 */     configuration.setCanBeConsumed(false);
/* 171 */     configuration.setCanBeResolved(canBeResolved);
/*     */     
/* 173 */     return configuration;
/*     */   }
/*     */   
/*     */   private final String getConfigDesc(String name, String sourceSetName) {
/* 177 */     return "" + name + " dependencies for '" + sourceSetName + "' sources.";
/*     */   }
/*     */   
/*     */   private final String getDeprecatedConfigDesc(String name, String sourceSetName, String replacement)
/*     */   {
/* 183 */     return "" + name + " dependencies for '" + sourceSetName + "' sources " + "(deprecated: use '" + replacement + "' instead).";
/*     */   }
/*     */   
/*     */   public final void checkForUnconfiguredSourceSets()
/*     */   {
/* 189 */     Iterable $receiver$iv = (Iterable)sourceSetsContainer;
/*     */     
/*     */     int $i$f$forEach;
/*     */     
/* 203 */     for (Object element$iv : $receiver$iv) { AndroidSourceSet sourceSet = (AndroidSourceSet)element$iv;
/*     */       int $i$a$1$forEach;
/* 190 */       AndroidSourceSet tmp43_41 = sourceSet;Intrinsics.checkExpressionValueIsNotNull(tmp43_41, "sourceSet"); if (!configuredSourceSets.contains(tmp43_41.getName())) {
/* 191 */         String message = "The SourceSet '" + sourceSet.getName() + "' is not recognized " + "by the Android Gradle Plugin. Perhaps you misspelled something?";
/*     */         
/* 193 */         issueReporter.reportError(com.android.builder.errors.EvalIssueReporter.Type.GENERIC, message);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public final void executeAction(@NotNull Action<NamedDomainObjectContainer<AndroidSourceSet>> action) {
/* 199 */     Intrinsics.checkParameterIsNotNull(action, "action");action.execute(sourceSetsContainer);
/*     */   }
/*     */   
/*     */   @JvmOverloads
/*     */   @NotNull
/*     */   public final AndroidSourceSet setUpSourceSet(@NotNull String name)
/*     */   {
/*     */     return setUpSourceSet$default(???, name, false, 2, null);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.SourceSetManager
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */