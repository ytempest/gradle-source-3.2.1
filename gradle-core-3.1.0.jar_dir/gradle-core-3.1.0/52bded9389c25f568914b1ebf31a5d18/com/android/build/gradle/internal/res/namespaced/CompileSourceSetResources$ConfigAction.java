/*     */ package com.android.build.gradle.internal.res.namespaced;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*     */ import com.android.build.gradle.internal.dsl.CoreBuildType;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import java.io.File;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\003\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B-\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\006\022\006\020\b\032\0020\t\022\006\020\n\032\0020\006¢\006\002\020\013J\020\020\f\032\0020\r2\006\020\016\032\0020\002H\026J\b\020\017\032\0020\004H\026J\016\020\020\032\b\022\004\022\0020\0020\021H\026R\016\020\n\032\0020\006X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\006X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000¨\006\022"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/CompileSourceSetResources$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/res/namespaced/CompileSourceSetResources;", "name", "", "inputDirectory", "Ljava/io/File;", "outputDirectory", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "aaptIntermediateDirectory", "(Ljava/lang/String;Ljava/io/File;Ljava/io/File;Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;)V", "execute", "", "task", "getName", "getType", "Ljava/lang/Class;", "gradle-core"})
/*     */ public final class CompileSourceSetResources$ConfigAction
/*     */   implements TaskConfigAction<CompileSourceSetResources>
/*     */ {
/*     */   private final String name;
/*     */   private final File inputDirectory;
/*     */   private final File outputDirectory;
/*     */   private final VariantScope variantScope;
/*     */   private final File aaptIntermediateDirectory;
/*     */   
/*     */   public CompileSourceSetResources$ConfigAction(@NotNull String name, @NotNull File inputDirectory, @NotNull File outputDirectory, @NotNull VariantScope variantScope, @NotNull File aaptIntermediateDirectory)
/*     */   {
/* 125 */     this.name = name;this.inputDirectory = inputDirectory;this.outputDirectory = outputDirectory;this.variantScope = variantScope;this.aaptIntermediateDirectory = aaptIntermediateDirectory;
/*     */   }
/*     */   
/*     */   @NotNull
/* 131 */   public String getName() { return name; } @NotNull
/* 132 */   public Class<CompileSourceSetResources> getType() { return CompileSourceSetResources.class; }
/*     */   
/* 134 */   public void execute(@NotNull CompileSourceSetResources task) { Intrinsics.checkParameterIsNotNull(task, "task");CompileSourceSetResources.access$setInputDirectory$p(task, inputDirectory);
/* 135 */     CompileSourceSetResources.access$setOutputDirectory$p(task, outputDirectory);
/* 136 */     task.setVariantName(variantScope.getFullVariantName());
/* 137 */     CompileSourceSetResources.access$setPngCrunching$p(task, variantScope.isCrunchPngs()); BaseVariantData 
/* 138 */       tmp58_53 = variantScope.getVariantData();Intrinsics.checkExpressionValueIsNotNull(tmp58_53, "variantScope.variantData"); GradleVariantConfiguration tmp67_64 = tmp58_53.getVariantConfiguration();Intrinsics.checkExpressionValueIsNotNull(tmp67_64, "variantScope.variantData.variantConfiguration"); CoreBuildType tmp79_76 = ((CoreBuildType)tmp67_64.getBuildType());Intrinsics.checkExpressionValueIsNotNull(tmp79_76, "variantScope.variantData…ntConfiguration.buildType");CompileSourceSetResources.access$setPseudoLocalize$p(task, tmp79_76.isPseudoLocalesEnabled());
/* 139 */     CompileSourceSetResources.access$setAaptIntermediateDirectory$p(task, aaptIntermediateDirectory); GlobalScope 
/* 140 */       tmp111_106 = variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp111_106, "variantScope.globalScope");task.setAndroidBuilder(tmp111_106.getAndroidBuilder());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.CompileSourceSetResources.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */