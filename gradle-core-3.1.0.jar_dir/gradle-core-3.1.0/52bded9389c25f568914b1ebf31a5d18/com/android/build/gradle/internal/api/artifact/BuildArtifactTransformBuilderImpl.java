/*     */ package com.android.build.gradle.internal.api.artifact;
/*     */ 
/*     */ import com.android.build.api.artifact.ArtifactType;
/*     */ import com.android.build.api.artifact.BuildArtifactTransformBuilder;
/*     */ import com.android.build.api.artifact.BuildArtifactTransformBuilder.ConfigurationAction;
/*     */ import com.android.build.api.artifact.BuildArtifactTransformBuilder.OperationType;
/*     */ import com.android.build.api.artifact.InputArtifactProvider;
/*     */ import com.android.build.api.artifact.OutputFileProvider;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*     */ import com.android.build.gradle.internal.scope.BuildArtifactHolder;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import com.android.builder.errors.EvalIssueReporter.Type;
/*     */ import com.google.common.collect.HashMultimap;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.functions.Function3;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.Task;
/*     */ import org.gradle.api.tasks.TaskContainer;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000x\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020!\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\030\002\n\002\030\002\n\002\020\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\003\n\002\020\021\n\002\b\002\030\000*\n\b\000\020\001 \001*\0020\0022\0020\0032\b\022\004\022\002H\0010\004B3\022\006\020\005\032\0020\006\022\006\020\007\032\0020\b\022\006\020\t\032\0020\n\022\f\020\013\032\b\022\004\022\0028\0000\f\022\006\020\r\032\0020\016¢\006\002\020\017J2\020\031\032\0028\0002#\020\032\032\037\022\004\022\0028\000\022\004\022\0020\034\022\004\022\0020\035\022\004\022\0020\0360\033¢\006\002\b\037H\026¢\006\002\020 J\033\020\031\032\0028\0002\f\020!\032\b\022\004\022\0028\0000\"H\026¢\006\002\020#J?\020\031\032\0028\0002\016\020!\032\n\022\004\022\0028\000\030\0010\"2 \020\032\032\034\022\004\022\0028\000\022\004\022\0020\034\022\004\022\0020\035\022\004\022\0020\036\030\0010\033H\002¢\006\002\020$J\026\020%\032\b\022\004\022\0028\0000\0042\006\020&\032\0020\022H\026J\036\020'\032\b\022\004\022\0028\0000\0042\006\020&\032\0020\0222\006\020(\032\0020)H\026J/\020*\032\b\022\004\022\0028\0000\0042\006\020+\032\0020\n2\022\020,\032\n\022\006\b\001\022\0020\0220-\"\0020\022H\026¢\006\002\020.R\024\020\020\032\b\022\004\022\0020\0220\021X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\024\020\023\032\b\022\004\022\0020\0220\021X\004¢\006\002\n\000RN\020\024\032B\022\f\022\n \026*\004\030\0010\0220\022\022\f\022\n \026*\004\030\0010\n0\n \026* \022\f\022\n \026*\004\030\0010\0220\022\022\f\022\n \026*\004\030\0010\n0\n\030\0010\0250\025X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\024\020\027\032\b\022\004\022\0020\0220\021X\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\024\020\013\032\b\022\004\022\0028\0000\fX\004¢\006\002\n\000R\024\020\030\032\b\022\004\022\0020\n0\021X\004¢\006\002\n\000¨\006/"}, d2={"Lcom/android/build/gradle/internal/api/artifact/BuildArtifactTransformBuilderImpl;", "T", "Lorg/gradle/api/Task;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/artifact/BuildArtifactTransformBuilder;", "project", "Lorg/gradle/api/Project;", "artifactHolder", "Lcom/android/build/gradle/internal/scope/BuildArtifactHolder;", "taskNamePrefix", "", "taskType", "Ljava/lang/Class;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lorg/gradle/api/Project;Lcom/android/build/gradle/internal/scope/BuildArtifactHolder;Ljava/lang/String;Ljava/lang/Class;Lcom/android/builder/errors/EvalIssueReporter;)V", "appendedOutput", "", "Lcom/android/build/api/artifact/ArtifactType;", "inputs", "outputFiles", "Lcom/google/common/collect/HashMultimap;", "kotlin.jvm.PlatformType", "replacedOutput", "unassociatedFiles", "create", "function", "Lkotlin/Function3;", "Lcom/android/build/api/artifact/InputArtifactProvider;", "Lcom/android/build/api/artifact/OutputFileProvider;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)Lorg/gradle/api/Task;", "action", "Lcom/android/build/api/artifact/BuildArtifactTransformBuilder$ConfigurationAction;", "(Lcom/android/build/api/artifact/BuildArtifactTransformBuilder$ConfigurationAction;)Lorg/gradle/api/Task;", "(Lcom/android/build/api/artifact/BuildArtifactTransformBuilder$ConfigurationAction;Lkotlin/jvm/functions/Function3;)Lorg/gradle/api/Task;", "input", "artifactType", "output", "operationType", "Lcom/android/build/api/artifact/BuildArtifactTransformBuilder$OperationType;", "outputFile", "filename", "consumers", "", "(Ljava/lang/String;[Lcom/android/build/api/artifact/ArtifactType;)Lcom/android/build/api/artifact/BuildArtifactTransformBuilder;", "gradle-core"})
/*     */ public final class BuildArtifactTransformBuilderImpl<T extends Task> extends SealableObject implements BuildArtifactTransformBuilder<T>
/*     */ {
/*     */   private final List<ArtifactType> inputs;
/*     */   private final HashMultimap<ArtifactType, String> outputFiles;
/*     */   private final List<ArtifactType> replacedOutput;
/*     */   private final List<ArtifactType> appendedOutput;
/*     */   private final List<String> unassociatedFiles;
/*     */   private final Project project;
/*     */   private final BuildArtifactHolder artifactHolder;
/*     */   private final String taskNamePrefix;
/*     */   private final Class<T> taskType;
/*     */   
/*     */   public BuildArtifactTransformBuilderImpl(@NotNull Project project, @NotNull BuildArtifactHolder artifactHolder, @NotNull String taskNamePrefix, @NotNull Class<T> taskType, @NotNull EvalIssueReporter issueReporter)
/*     */   {
/*  40 */     super(issueReporter);this.project = project;this.artifactHolder = artifactHolder;this.taskNamePrefix = taskNamePrefix;this.taskType = taskType;
/*     */     
/*  42 */     BuildArtifactTransformBuilderImpl localBuildArtifactTransformBuilderImpl = this;List localList = (List)new ArrayList();inputs = localList;
/*  43 */     outputFiles = HashMultimap.create();
/*  44 */     localBuildArtifactTransformBuilderImpl = this;localList = (List)new ArrayList();replacedOutput = localList;
/*  45 */     localBuildArtifactTransformBuilderImpl = this;localList = (List)new ArrayList();appendedOutput = localList;
/*  46 */     localBuildArtifactTransformBuilderImpl = this;localList = (List)new ArrayList();unassociatedFiles = localList;
/*     */   }
/*     */   
/*     */   @NotNull
/*  50 */   public BuildArtifactTransformBuilder<T> output(@NotNull ArtifactType artifactType, @NotNull BuildArtifactTransformBuilder.OperationType operationType) { Intrinsics.checkParameterIsNotNull(artifactType, "artifactType");Intrinsics.checkParameterIsNotNull(operationType, "operationType"); if (!checkSeal()) {
/*  51 */       return (BuildArtifactTransformBuilder)this;
/*     */     }
/*  53 */     if ((replacedOutput.contains(artifactType)) || (appendedOutput.contains(artifactType))) {
/*  54 */       getIssueReporter().reportError(
/*  55 */         EvalIssueReporter.Type.GENERIC, 
/*  56 */         "Output type '" + artifactType + "' was already specified as an output.");
/*  57 */       return (BuildArtifactTransformBuilder)this;
/*     */     }
/*  59 */     BuildArtifactSpec spec = BuildArtifactSpec.Companion.get(artifactType);
/*  60 */     switch (BuildArtifactTransformBuilderImpl.WhenMappings.$EnumSwitchMapping$0[operationType.ordinal()]) {
/*     */     case 1: 
/*  62 */       if (!spec.getReplaceable()) {
/*  63 */         getIssueReporter().reportError(
/*  64 */           EvalIssueReporter.Type.GENERIC, 
/*  65 */           "Replacing ArtifactType '" + artifactType + "' is not allowed.");
/*  66 */         return (BuildArtifactTransformBuilder)this;
/*     */       }
/*  68 */       replacedOutput.add(artifactType); break;
/*     */     
/*     */     case 2: 
/*  71 */       if (!spec.getAppendable()) {
/*  72 */         getIssueReporter().reportError(
/*  73 */           EvalIssueReporter.Type.GENERIC, 
/*  74 */           "Append to ArtifactType '" + artifactType + "' is not allowed.");
/*  75 */         return (BuildArtifactTransformBuilder)this;
/*     */       }
/*  77 */       appendedOutput.add(artifactType);
/*     */     }
/*     */     
/*  80 */     return (BuildArtifactTransformBuilder)this;
/*     */   }
/*     */   
/*     */   @NotNull
/*  84 */   public BuildArtifactTransformBuilder<T> input(@NotNull ArtifactType artifactType) { Intrinsics.checkParameterIsNotNull(artifactType, "artifactType"); if (!checkSeal()) {
/*  85 */       return (BuildArtifactTransformBuilder)this;
/*     */     }
/*  87 */     if (inputs.contains(artifactType)) {
/*  88 */       getIssueReporter().reportError(
/*  89 */         EvalIssueReporter.Type.GENERIC, 
/*  90 */         "Output type '" + artifactType + "' was already specified as an input.");
/*  91 */       return (BuildArtifactTransformBuilder)this;
/*     */     }
/*  93 */     inputs.add(artifactType);
/*  94 */     return (BuildArtifactTransformBuilder)this;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public BuildArtifactTransformBuilder<T> outputFile(@NotNull String filename, @NotNull ArtifactType... consumers) {
/*  99 */     Intrinsics.checkParameterIsNotNull(filename, "filename");Intrinsics.checkParameterIsNotNull(consumers, "consumers"); if (!checkSeal()) {
/* 100 */       return (BuildArtifactTransformBuilder)this;
/*     */     }
/* 102 */     if (outputFiles.containsValue(filename)) {
/* 103 */       getIssueReporter().reportError(
/* 104 */         EvalIssueReporter.Type.GENERIC, 
/* 105 */         "Output file '" + filename + "' was already created.");
/* 106 */       return (BuildArtifactTransformBuilder)this;
/*     */     }
/* 108 */     Object[] arrayOfObject = (Object[])consumers; if ((arrayOfObject.length == 0 ? 1 : 0) != 0) {
/* 109 */       unassociatedFiles.add(filename);
/*     */     } else {
/* 111 */       for (int i = 0; i < consumers.length; i++) { ArtifactType consumer = consumers[i];
/* 112 */         outputFiles.put(consumer, filename);
/*     */         
/* 114 */         BuildArtifactSpec spec = BuildArtifactSpec.Companion.get(consumer);
/* 115 */         if ((spec.getSingleFile()) && (outputFiles.get(consumer).size() > 1)) {
/* 116 */           getIssueReporter().reportError(
/* 117 */             EvalIssueReporter.Type.GENERIC, 
/* 118 */             "OutputType '" + consumer + "' does not support multiple output files.");
/*     */         }
/*     */       }
/*     */     }
/* 122 */     return (BuildArtifactTransformBuilder)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 126 */   public T create(@NotNull BuildArtifactTransformBuilder.ConfigurationAction<? super T> action) { Intrinsics.checkParameterIsNotNull(action, "action");return create(action, null);
/*     */   }
/*     */   
/*     */   @NotNull
/* 130 */   public T create(@NotNull Function3<? super T, ? super InputArtifactProvider, ? super OutputFileProvider, Unit> function) { Intrinsics.checkParameterIsNotNull(function, "function");return create(null, function);
/*     */   }
/*     */   
/*     */   private final T create(BuildArtifactTransformBuilder.ConfigurationAction<? super T> action, Function3<? super T, ? super InputArtifactProvider, ? super OutputFileProvider, Unit> function)
/*     */   {
/* 136 */     String taskName = artifactHolder.getTaskName(taskNamePrefix);
/* 137 */     Task task = project.getTasks().create(taskName, taskType);
/* 138 */     if (!checkSeal()) {
/* 139 */       Task tmp42_40 = task;Intrinsics.checkExpressionValueIsNotNull(tmp42_40, "task");return tmp42_40;
/*     */     }
/* 141 */     InputArtifactProviderImpl inputProvider = new InputArtifactProviderImpl(artifactHolder, (Collection)inputs, getIssueReporter()); HashMultimap 
/*     */     
/* 147 */       tmp99_96 = outputFiles;Intrinsics.checkExpressionValueIsNotNull(tmp99_96, "outputFiles");OutputFileProviderImpl outputProvider = new OutputFileProviderImpl(artifactHolder, (Collection)replacedOutput, (Collection)appendedOutput, (com.google.common.collect.Multimap)tmp99_96, 
/* 148 */       (Collection)unassociatedFiles, 
/* 149 */       taskName, 
/* 150 */       getIssueReporter());
/*     */     try
/*     */     {
/* 153 */       if (action != null) { Task tmp133_131 = task;Intrinsics.checkExpressionValueIsNotNull(tmp133_131, "task");action.accept(tmp133_131, (InputArtifactProvider)inputProvider, (OutputFileProvider)outputProvider);
/* 154 */       } else if (function != null) { Task tmp164_162 = task;Intrinsics.checkExpressionValueIsNotNull(tmp164_162, "task");function.invoke(tmp164_162, inputProvider, outputProvider);
/*     */       }
/*     */     } catch (Exception e) {
/* 157 */       getIssueReporter().reportError(
/* 158 */         EvalIssueReporter.Type.GENERIC, 
/*     */         
/* 161 */         kotlin.text.StringsKt.trimMargin$default("Exception thrown while configuring task '" + taskName + "'.\n                            |Type: " + e.getClass().getName() + "\n                            |Message: " + e.getMessage(), null, 1, null));
/*     */     }
/* 163 */     Task tmp257_255 = task;Intrinsics.checkExpressionValueIsNotNull(tmp257_255, "task");return tmp257_255;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.artifact.BuildArtifactTransformBuilderImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */