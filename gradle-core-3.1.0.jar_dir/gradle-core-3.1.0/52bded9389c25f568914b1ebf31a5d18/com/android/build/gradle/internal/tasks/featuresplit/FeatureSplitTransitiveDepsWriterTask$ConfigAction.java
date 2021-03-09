/*    */ package com.android.build.gradle.internal.tasks.featuresplit;
/*    */ 
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import java.io.File;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.artifacts.ArtifactCollection;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006¢\006\002\020\007J\020\020\b\032\0020\t2\006\020\n\032\0020\002H\026J\b\020\013\032\0020\fH\026J\016\020\r\032\b\022\004\022\0020\0020\016H\026R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\017"}, d2={"Lcom/android/build/gradle/internal/tasks/featuresplit/FeatureSplitTransitiveDepsWriterTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/tasks/featuresplit/FeatureSplitTransitiveDepsWriterTask;", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "outputFile", "Ljava/io/File;", "(Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;)V", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*    */ public final class FeatureSplitTransitiveDepsWriterTask$ConfigAction
/*    */   implements TaskConfigAction<FeatureSplitTransitiveDepsWriterTask>
/*    */ {
/*    */   private final VariantScope variantScope;
/*    */   private final File outputFile;
/*    */   
/*    */   public FeatureSplitTransitiveDepsWriterTask$ConfigAction(@NotNull VariantScope variantScope, @NotNull File outputFile)
/*    */   {
/* 71 */     this.variantScope = variantScope;this.outputFile = outputFile;
/*    */   }
/*    */   
/*    */   @NotNull
/* 75 */   public String getName() { return variantScope.getTaskName("generate", "FeatureTransitiveDeps"); } @NotNull
/* 76 */   public Class<FeatureSplitTransitiveDepsWriterTask> getType() { return FeatureSplitTransitiveDepsWriterTask.class; }
/*    */   
/*    */   public void execute(@NotNull FeatureSplitTransitiveDepsWriterTask task) {
/* 79 */     Intrinsics.checkParameterIsNotNull(task, "task");task.setVariantName(variantScope.getFullVariantName());
/* 80 */     FeatureSplitTransitiveDepsWriterTask.access$setOutputFile$p(task, outputFile); ArtifactCollection 
/* 81 */       tmp46_41 = variantScope.getArtifactCollection(
/* 82 */       AndroidArtifacts.ConsumedConfigType.RUNTIME_CLASSPATH, 
/* 83 */       AndroidArtifacts.ArtifactScope.ALL, 
/* 84 */       AndroidArtifacts.ArtifactType.CLASSES);Intrinsics.checkExpressionValueIsNotNull(tmp46_41, "variantScope.getArtifact…cts.ArtifactType.CLASSES)");FeatureSplitTransitiveDepsWriterTask.access$setRuntimeJars$p(task, tmp46_41);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.featuresplit.FeatureSplitTransitiveDepsWriterTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */