/*    */ package com.android.build.gradle.internal.feature;
/*    */ 
/*    */ import com.android.build.gradle.AndroidConfig;
/*    */ import com.android.build.gradle.internal.dsl.AaptOptions;
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*    */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*    */ import java.io.File;
/*    */ import java.util.HashMap;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ import org.gradle.api.file.FileVisitDetails;
/*    */ import org.gradle.api.file.RelativePath;
/*    */ import org.gradle.api.file.ReproducibleFileVisitor;
/*    */ import org.gradle.api.tasks.InputFiles;
/*    */ import org.gradle.api.tasks.OutputFile;
/*    */ import org.gradle.workers.WorkerConfiguration;
/*    */ import org.gradle.workers.WorkerExecutor;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000*\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\f\n\002\020\002\n\002\b\002\b\026\030\0002\0020\001:\001\033B\017\b\007\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\031\032\0020\032H\007R\022\020\005\032\004\030\0010\0068\003X\016¢\006\002\n\000R\034\020\007\032\0020\0068\007X.¢\006\016\n\000\032\004\b\b\020\t\"\004\b\n\020\013R\034\020\f\032\0020\r8\007X.¢\006\016\n\000\032\004\b\016\020\017\"\004\b\020\020\021R\034\020\022\032\0020\0068\007X.¢\006\016\n\000\032\004\b\023\020\t\"\004\b\024\020\013R\034\020\025\032\0020\0068\007X.¢\006\016\n\000\032\004\b\026\020\t\"\004\b\027\020\013R\022\020\030\032\004\030\0010\0068\003X\016¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\034"}, d2={"Lcom/android/build/gradle/internal/feature/BundleFeatureClasses;", "Lorg/gradle/api/DefaultTask;", "workerExecutor", "Lorg/gradle/workers/WorkerExecutor;", "(Lorg/gradle/workers/WorkerExecutor;)V", "dependencyRClassClasses", "Lorg/gradle/api/file/FileCollection;", "javacClasses", "getJavacClasses", "()Lorg/gradle/api/file/FileCollection;", "setJavacClasses", "(Lorg/gradle/api/file/FileCollection;)V", "outputJar", "Ljava/io/File;", "getOutputJar", "()Ljava/io/File;", "setOutputJar", "(Ljava/io/File;)V", "postJavacClasses", "getPostJavacClasses", "setPostJavacClasses", "preJavacClasses", "getPreJavacClasses", "setPreJavacClasses", "thisRClassClasses", "merge", "", "ConfigAction", "gradle-core"})
/*    */ public class BundleFeatureClasses
/*    */   extends org.gradle.api.DefaultTask
/*    */ {
/*    */   @NotNull
/*    */   public File outputJar;
/*    */   @NotNull
/*    */   public FileCollection javacClasses;
/*    */   @NotNull
/*    */   public FileCollection preJavacClasses;
/*    */   @NotNull
/*    */   public FileCollection postJavacClasses;
/*    */   private FileCollection thisRClassClasses;
/*    */   private FileCollection dependencyRClassClasses;
/*    */   private final WorkerExecutor workerExecutor;
/*    */   
/*    */   @javax.inject.Inject
/* 43 */   public BundleFeatureClasses(@NotNull WorkerExecutor workerExecutor) { this.workerExecutor = workerExecutor; } @OutputFile
/*    */   @NotNull
/* 45 */   public final File getOutputJar() { File tmp4_1 = outputJar;
/*    */     
/* 45 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("outputJar"); return tmp4_1; } public final void setOutputJar(@NotNull File <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");outputJar = <set-?>; } @InputFiles
/*    */   @NotNull
/* 47 */   public final FileCollection getJavacClasses() { FileCollection tmp4_1 = javacClasses;
/*    */     
/* 47 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("javacClasses"); return tmp4_1; } public final void setJavacClasses(@NotNull FileCollection <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");javacClasses = <set-?>; } @InputFiles
/*    */   @NotNull
/* 48 */   public final FileCollection getPreJavacClasses() { FileCollection tmp4_1 = preJavacClasses;
/*    */     
/* 48 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("preJavacClasses"); return tmp4_1; } public final void setPreJavacClasses(@NotNull FileCollection <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");preJavacClasses = <set-?>; } @InputFiles
/*    */   @NotNull
/* 49 */   public final FileCollection getPostJavacClasses() { FileCollection tmp4_1 = postJavacClasses;
/*    */     
/* 49 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("postJavacClasses"); return tmp4_1; } public final void setPostJavacClasses(@NotNull FileCollection <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");postJavacClasses = <set-?>;
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   @org.gradle.api.tasks.TaskAction
/*    */   public final void merge()
/*    */   {
/*    */     // Byte code:
/*    */     //   0: new 62	java/util/HashMap
/*    */     //   3: dup
/*    */     //   4: invokespecial 65	java/util/HashMap:<init>	()V
/*    */     //   7: astore_1
/*    */     //   8: new 67	com/android/build/gradle/internal/feature/BundleFeatureClasses$merge$collector$1
/*    */     //   11: dup
/*    */     //   12: aload_1
/*    */     //   13: invokespecial 70	com/android/build/gradle/internal/feature/BundleFeatureClasses$merge$collector$1:<init>	(Ljava/util/HashMap;)V
/*    */     //   16: astore_2
/*    */     //   17: aload_0
/*    */     //   18: getfield 38	com/android/build/gradle/internal/feature/BundleFeatureClasses:javacClasses	Lorg/gradle/api/file/FileCollection;
/*    */     //   21: dup
/*    */     //   22: ifnonnull +8 -> 30
/*    */     //   25: ldc 39
/*    */     //   27: invokestatic 19	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*    */     //   30: invokeinterface 74 1 0
/*    */     //   35: aload_2
/*    */     //   36: checkcast 76	org/gradle/api/file/FileVisitor
/*    */     //   39: invokeinterface 82 2 0
/*    */     //   44: pop
/*    */     //   45: aload_0
/*    */     //   46: getfield 47	com/android/build/gradle/internal/feature/BundleFeatureClasses:preJavacClasses	Lorg/gradle/api/file/FileCollection;
/*    */     //   49: dup
/*    */     //   50: ifnonnull +8 -> 58
/*    */     //   53: ldc 48
/*    */     //   55: invokestatic 19	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*    */     //   58: invokeinterface 74 1 0
/*    */     //   63: aload_2
/*    */     //   64: checkcast 76	org/gradle/api/file/FileVisitor
/*    */     //   67: invokeinterface 82 2 0
/*    */     //   72: pop
/*    */     //   73: aload_0
/*    */     //   74: getfield 53	com/android/build/gradle/internal/feature/BundleFeatureClasses:postJavacClasses	Lorg/gradle/api/file/FileCollection;
/*    */     //   77: dup
/*    */     //   78: ifnonnull +8 -> 86
/*    */     //   81: ldc 54
/*    */     //   83: invokestatic 19	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*    */     //   86: invokeinterface 74 1 0
/*    */     //   91: aload_2
/*    */     //   92: checkcast 76	org/gradle/api/file/FileVisitor
/*    */     //   95: invokeinterface 82 2 0
/*    */     //   100: pop
/*    */     //   101: aload_0
/*    */     //   102: getfield 84	com/android/build/gradle/internal/feature/BundleFeatureClasses:thisRClassClasses	Lorg/gradle/api/file/FileCollection;
/*    */     //   105: dup
/*    */     //   106: ifnull +25 -> 131
/*    */     //   109: invokeinterface 74 1 0
/*    */     //   114: dup
/*    */     //   115: ifnull +16 -> 131
/*    */     //   118: aload_2
/*    */     //   119: checkcast 76	org/gradle/api/file/FileVisitor
/*    */     //   122: invokeinterface 82 2 0
/*    */     //   127: pop
/*    */     //   128: goto +4 -> 132
/*    */     //   131: pop
/*    */     //   132: aload_0
/*    */     //   133: getfield 88	com/android/build/gradle/internal/feature/BundleFeatureClasses:workerExecutor	Lorg/gradle/workers/WorkerExecutor;
/*    */     //   136: ldc 90
/*    */     //   138: new 92	com/android/build/gradle/internal/feature/BundleFeatureClasses$merge$1
/*    */     //   141: dup
/*    */     //   142: aload_0
/*    */     //   143: aload_1
/*    */     //   144: invokespecial 95	com/android/build/gradle/internal/feature/BundleFeatureClasses$merge$1:<init>	(Lcom/android/build/gradle/internal/feature/BundleFeatureClasses;Ljava/util/HashMap;)V
/*    */     //   147: checkcast 97	org/gradle/api/Action
/*    */     //   150: invokeinterface 103 3 0
/*    */     //   155: return
/*    */     // Line number table:
/*    */     //   Java source line #55	-> byte code offset #0
/*    */     //   Java source line #56	-> byte code offset #8
/*    */     //   Java source line #64	-> byte code offset #17
/*    */     //   Java source line #65	-> byte code offset #45
/*    */     //   Java source line #66	-> byte code offset #73
/*    */     //   Java source line #67	-> byte code offset #101
/*    */     //   Java source line #69	-> byte code offset #132
/*    */     //   Java source line #77	-> byte code offset #155
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	156	0	this	BundleFeatureClasses
/*    */     //   8	148	1	files	HashMap
/*    */     //   17	139	2	collector	merge.collector.1
/*    */   }
/*    */   
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006¢\006\002\020\007J\020\020\b\032\0020\t2\006\020\n\032\0020\002H\026J\b\020\013\032\0020\fH\026J\016\020\r\032\b\022\004\022\0020\0020\016H\026R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\017"}, d2={"Lcom/android/build/gradle/internal/feature/BundleFeatureClasses$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/feature/BundleFeatureClasses;", "scope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "classesJar", "Ljava/io/File;", "(Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;)V", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*    */   public static final class ConfigAction
/*    */     implements TaskConfigAction<BundleFeatureClasses>
/*    */   {
/*    */     private final VariantScope scope;
/*    */     private final File classesJar;
/*    */     
/*    */     public ConfigAction(@NotNull VariantScope scope, @NotNull File classesJar)
/*    */     {
/* 79 */       this.scope = scope;this.classesJar = classesJar; }
/*    */     
/*    */     @NotNull
/* 82 */     public String getName() { return scope.getTaskName("bundle", "Classes"); }
/*    */     @NotNull
/* 84 */     public Class<BundleFeatureClasses> getType() { return BundleFeatureClasses.class; }
/*    */     
/*    */     public void execute(@NotNull BundleFeatureClasses task) {
/* 87 */       Intrinsics.checkParameterIsNotNull(task, "task");task.setOutputJar(classesJar); FileCollection 
/* 88 */         tmp30_25 = scope.getOutput((TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.JAVAC);Intrinsics.checkExpressionValueIsNotNull(tmp30_25, "scope.getOutput(TaskOutp…der.TaskOutputType.JAVAC)");task.setJavacClasses(tmp30_25); BaseVariantData 
/* 89 */         tmp49_44 = scope.getVariantData();Intrinsics.checkExpressionValueIsNotNull(tmp49_44, "scope.variantData"); FileCollection tmp58_55 = tmp49_44.getAllPreJavacGeneratedBytecode();Intrinsics.checkExpressionValueIsNotNull(tmp58_55, "scope.variantData.allPreJavacGeneratedBytecode");task.setPreJavacClasses(tmp58_55); BaseVariantData 
/* 90 */         tmp77_72 = scope.getVariantData();Intrinsics.checkExpressionValueIsNotNull(tmp77_72, "scope.variantData"); FileCollection tmp86_83 = tmp77_72.getAllPostJavacGeneratedBytecode();Intrinsics.checkExpressionValueIsNotNull(tmp86_83, "scope.variantData.allPostJavacGeneratedBytecode");task.setPostJavacClasses(tmp86_83);
/* 91 */       GlobalScope globalScope = scope.getGlobalScope(); GlobalScope 
/* 92 */         tmp109_108 = globalScope;Intrinsics.checkExpressionValueIsNotNull(tmp109_108, "globalScope"); AndroidConfig tmp118_115 = tmp109_108.getExtension();Intrinsics.checkExpressionValueIsNotNull(tmp118_115, "globalScope.extension"); AaptOptions tmp129_124 = tmp118_115.getAaptOptions();Intrinsics.checkExpressionValueIsNotNull(tmp129_124, "globalScope.extension.aaptOptions"); if (Intrinsics.areEqual(Boolean.TRUE, tmp129_124.getNamespaced()))
/*    */       {
/* 94 */         BundleFeatureClasses.access$setThisRClassClasses$p(task, scope.getOutput(
/* 95 */           (TaskOutputHolder.OutputType)TaskOutputHolder.TaskOutputType.COMPILE_ONLY_NAMESPACED_R_CLASS_JAR));
/* 96 */         BundleFeatureClasses.access$setDependencyRClassClasses$p(task, scope.getArtifactFileCollection(
/* 97 */           com.android.build.gradle.internal.publishing.AndroidArtifacts.ConsumedConfigType.COMPILE_CLASSPATH, 
/* 98 */           com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactScope.ALL, 
/* 99 */           com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType.COMPILE_ONLY_NAMESPACED_R_CLASS_JAR));
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.feature.BundleFeatureClasses
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */