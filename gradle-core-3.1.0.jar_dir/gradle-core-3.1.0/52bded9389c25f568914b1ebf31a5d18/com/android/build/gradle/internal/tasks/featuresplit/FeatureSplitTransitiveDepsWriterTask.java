/*    */ package com.android.build.gradle.internal.tasks.featuresplit;
/*    */ 
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope;
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import com.android.build.gradle.internal.tasks.AndroidVariantTask;
/*    */ import com.android.utils.FileUtils;
/*    */ import com.google.common.base.Charsets;
/*    */ import com.google.common.base.Joiner;
/*    */ import com.google.common.io.CharSink;
/*    */ import com.google.common.io.FileWriteMode;
/*    */ import com.google.common.io.Files;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.Set;
/*    */ import java.util.function.Function;
/*    */ import java.util.stream.Collectors;
/*    */ import java.util.stream.Stream;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.artifacts.ArtifactCollection;
/*    */ import org.gradle.api.artifacts.result.ResolvedArtifactResult;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ import org.gradle.api.tasks.CacheableTask;
/*    */ import org.gradle.api.tasks.CompileClasspath;
/*    */ import org.gradle.api.tasks.TaskAction;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @CacheableTask
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000&\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\002\b\027\030\0002\0020\001:\001\013B\005¢\006\002\020\002J\b\020\007\032\0020\bH\007J\b\020\t\032\0020\nH\007R\020\020\003\032\0020\0048\003X.¢\006\002\n\000R\016\020\005\032\0020\006X.¢\006\002\n\000¨\006\f"}, d2={"Lcom/android/build/gradle/internal/tasks/featuresplit/FeatureSplitTransitiveDepsWriterTask;", "Lcom/android/build/gradle/internal/tasks/AndroidVariantTask;", "()V", "outputFile", "Ljava/io/File;", "runtimeJars", "Lorg/gradle/api/artifacts/ArtifactCollection;", "getInputJars", "Lorg/gradle/api/file/FileCollection;", "write", "", "ConfigAction", "gradle-core"})
/*    */ public class FeatureSplitTransitiveDepsWriterTask
/*    */   extends AndroidVariantTask
/*    */ {
/*    */   private ArtifactCollection runtimeJars;
/*    */   private File outputFile;
/*    */   
/*    */   @CompileClasspath
/*    */   @NotNull
/*    */   public final FileCollection getInputJars()
/*    */   {
/* 55 */     ArtifactCollection tmp4_1 = runtimeJars;
/*    */     
/* 55 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("runtimeJars"); FileCollection tmp18_13 = tmp4_1.getArtifactFiles();Intrinsics.checkExpressionValueIsNotNull(tmp18_13, "runtimeJars.artifactFiles");return tmp18_13;
/*    */   }
/*    */   
/*    */   @TaskAction
/*    */   public final void write() throws IOException
/*    */   {
/* 61 */     ArtifactCollection tmp4_1 = runtimeJars;
/*    */     
/* 61 */     if (tmp4_1 == null) { Intrinsics.throwUninitializedPropertyAccessException("runtimeJars");
/*    */     }
/*    */     
/* 64 */     Object tmp42_37 = tmp4_1.getArtifacts().stream().map((Function)write.content.1.INSTANCE).collect(Collectors.toSet());Intrinsics.checkExpressionValueIsNotNull(tmp42_37, "runtimeJars.artifacts\n  …llect(Collectors.toSet())");Set content = (Set)tmp42_37; File 
/*    */     
/* 66 */       tmp56_53 = outputFile;
/*    */     
/* 66 */     if (tmp56_53 == null) Intrinsics.throwUninitializedPropertyAccessException("outputFile"); FileUtils.mkdirs(tmp56_53.getParentFile()); File 
/* 67 */       tmp76_73 = outputFile;
/* 67 */     if (tmp76_73 == null) Intrinsics.throwUninitializedPropertyAccessException("outputFile");
/* 68 */     Files.asCharSink(tmp76_73, Charsets.UTF_8, new FileWriteMode[0]).write((CharSequence)Joiner.on(System.lineSeparator()).join((Iterable)content)); }
/*    */   
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006¢\006\002\020\007J\020\020\b\032\0020\t2\006\020\n\032\0020\002H\026J\b\020\013\032\0020\fH\026J\016\020\r\032\b\022\004\022\0020\0020\016H\026R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\017"}, d2={"Lcom/android/build/gradle/internal/tasks/featuresplit/FeatureSplitTransitiveDepsWriterTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/tasks/featuresplit/FeatureSplitTransitiveDepsWriterTask;", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "outputFile", "Ljava/io/File;", "(Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;)V", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/* 71 */   public static final class ConfigAction implements TaskConfigAction<FeatureSplitTransitiveDepsWriterTask> { public ConfigAction(@NotNull VariantScope variantScope, @NotNull File outputFile) { this.variantScope = variantScope;this.outputFile = outputFile;
/*    */     }
/*    */     
/*    */     @NotNull
/* 75 */     public String getName() { return variantScope.getTaskName("generate", "FeatureTransitiveDeps"); } @NotNull
/* 76 */     public Class<FeatureSplitTransitiveDepsWriterTask> getType() { return FeatureSplitTransitiveDepsWriterTask.class; }
/*    */     
/*    */     public void execute(@NotNull FeatureSplitTransitiveDepsWriterTask task) {
/* 79 */       Intrinsics.checkParameterIsNotNull(task, "task");task.setVariantName(variantScope.getFullVariantName());
/* 80 */       FeatureSplitTransitiveDepsWriterTask.access$setOutputFile$p(task, outputFile); ArtifactCollection 
/* 81 */         tmp46_41 = variantScope.getArtifactCollection(
/* 82 */         AndroidArtifacts.ConsumedConfigType.RUNTIME_CLASSPATH, 
/* 83 */         AndroidArtifacts.ArtifactScope.ALL, 
/* 84 */         AndroidArtifacts.ArtifactType.CLASSES);Intrinsics.checkExpressionValueIsNotNull(tmp46_41, "variantScope.getArtifact…cts.ArtifactType.CLASSES)");FeatureSplitTransitiveDepsWriterTask.access$setRuntimeJars$p(task, tmp46_41);
/*    */     }
/*    */     
/*    */     private final VariantScope variantScope;
/*    */     private final File outputFile;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.featuresplit.FeatureSplitTransitiveDepsWriterTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */