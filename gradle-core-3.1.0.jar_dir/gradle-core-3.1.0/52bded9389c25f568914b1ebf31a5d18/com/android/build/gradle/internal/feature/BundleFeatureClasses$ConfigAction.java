/*    */ package com.android.build.gradle.internal.feature;
/*    */ 
/*    */ import com.android.build.gradle.AndroidConfig;
/*    */ import com.android.build.gradle.internal.dsl.AaptOptions;
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*    */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*    */ import java.io.File;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006¢\006\002\020\007J\020\020\b\032\0020\t2\006\020\n\032\0020\002H\026J\b\020\013\032\0020\fH\026J\016\020\r\032\b\022\004\022\0020\0020\016H\026R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\017"}, d2={"Lcom/android/build/gradle/internal/feature/BundleFeatureClasses$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/feature/BundleFeatureClasses;", "scope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "classesJar", "Ljava/io/File;", "(Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;)V", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*    */ public final class BundleFeatureClasses$ConfigAction
/*    */   implements TaskConfigAction<BundleFeatureClasses>
/*    */ {
/*    */   private final VariantScope scope;
/*    */   private final File classesJar;
/*    */   
/*    */   public BundleFeatureClasses$ConfigAction(@NotNull VariantScope scope, @NotNull File classesJar)
/*    */   {
/* 79 */     this.scope = scope;this.classesJar = classesJar; }
/*    */   
/*    */   @NotNull
/* 82 */   public String getName() { return scope.getTaskName("bundle", "Classes"); }
/*    */   @NotNull
/* 84 */   public Class<BundleFeatureClasses> getType() { return BundleFeatureClasses.class; }
/*    */   
/*    */   public void execute(@NotNull BundleFeatureClasses task) {
/* 87 */     Intrinsics.checkParameterIsNotNull(task, "task");task.setOutputJar(classesJar); FileCollection 
/* 88 */       tmp30_25 = scope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.JAVAC);Intrinsics.checkExpressionValueIsNotNull(tmp30_25, "scope.getOutput(TaskOutp…der.TaskOutputType.JAVAC)");task.setJavacClasses(tmp30_25); BaseVariantData 
/* 89 */       tmp49_44 = scope.getVariantData();Intrinsics.checkExpressionValueIsNotNull(tmp49_44, "scope.variantData"); FileCollection tmp58_55 = tmp49_44.getAllPreJavacGeneratedBytecode();Intrinsics.checkExpressionValueIsNotNull(tmp58_55, "scope.variantData.allPreJavacGeneratedBytecode");task.setPreJavacClasses(tmp58_55); BaseVariantData 
/* 90 */       tmp77_72 = scope.getVariantData();Intrinsics.checkExpressionValueIsNotNull(tmp77_72, "scope.variantData"); FileCollection tmp86_83 = tmp77_72.getAllPostJavacGeneratedBytecode();Intrinsics.checkExpressionValueIsNotNull(tmp86_83, "scope.variantData.allPostJavacGeneratedBytecode");task.setPostJavacClasses(tmp86_83);
/* 91 */     GlobalScope globalScope = scope.getGlobalScope(); GlobalScope 
/* 92 */       tmp109_108 = globalScope;Intrinsics.checkExpressionValueIsNotNull(tmp109_108, "globalScope"); AndroidConfig tmp118_115 = tmp109_108.getExtension();Intrinsics.checkExpressionValueIsNotNull(tmp118_115, "globalScope.extension"); AaptOptions tmp129_124 = tmp118_115.getAaptOptions();Intrinsics.checkExpressionValueIsNotNull(tmp129_124, "globalScope.extension.aaptOptions"); if (Intrinsics.areEqual(Boolean.TRUE, tmp129_124.getNamespaced()))
/*    */     {
/* 94 */       BundleFeatureClasses.access$setThisRClassClasses$p(task, scope.getOutput(
/* 95 */         (TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.COMPILE_ONLY_NAMESPACED_R_CLASS_JAR));
/* 96 */       BundleFeatureClasses.access$setDependencyRClassClasses$p(task, scope.getArtifactFileCollection(
/* 97 */         AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, 
/* 98 */         AndroidArtifacts.ArtifactScope.ALL, 
/* 99 */         AndroidArtifacts.ArtifactType.COMPILE_ONLY_NAMESPACED_R_CLASS_JAR));
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.feature.BundleFeatureClasses.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */