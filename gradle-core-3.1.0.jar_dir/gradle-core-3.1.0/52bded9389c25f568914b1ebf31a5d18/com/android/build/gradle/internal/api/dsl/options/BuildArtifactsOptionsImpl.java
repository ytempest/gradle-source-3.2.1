/*     */ package com.android.build.gradle.internal.api.dsl.options;
/*     */ 
/*     */ import com.android.build.api.artifact.ArtifactType;
/*     */ import com.android.build.api.artifact.BuildArtifactTransformBuilder;
/*     */ import com.android.build.api.artifact.BuildArtifactTransformBuilder.ConfigurationAction;
/*     */ import com.android.build.api.artifact.BuildArtifactTransformBuilder.OperationType;
/*     */ import com.android.build.api.artifact.BuildArtifactTransformBuilder.SimpleConfigurationAction;
/*     */ import com.android.build.api.artifact.BuildableArtifact;
/*     */ import com.android.build.api.artifact.InputArtifactProvider;
/*     */ import com.android.build.api.artifact.OutputFileProvider;
/*     */ import com.android.build.api.dsl.options.BuildArtifactsOptions;
/*     */ import com.android.build.gradle.internal.api.artifact.BuildArtifactTransformBuilderImpl;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.NestedSealable;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*     */ import com.android.build.gradle.internal.scope.BuildArtifactHolder;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import java.io.File;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.functions.Function3;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.Task;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000n\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\006\030\0002\0020\0012\0020\002:\001&B\035\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\b¢\006\002\020\tJU\020\n\032\0020\013\"\b\b\000\020\f*\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\0212\f\020\022\032\b\022\004\022\002H\f0\0232#\020\024\032\037\022\004\022\002H\f\022\004\022\0020\026\022\004\022\0020\027\022\004\022\0020\0130\025¢\006\002\b\030H\026J>\020\n\032\0020\013\"\b\b\000\020\f*\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\0212\f\020\022\032\b\022\004\022\002H\f0\0232\f\020\024\032\b\022\004\022\002H\f0\031H\026Jg\020\n\032\0020\013\"\b\b\000\020\f*\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\0212\f\020\022\032\b\022\004\022\002H\f0\0232\016\020\032\032\n\022\004\022\002H\f\030\0010\0312%\020\033\032!\022\004\022\002H\f\022\004\022\0020\026\022\004\022\0020\027\022\004\022\0020\013\030\0010\025¢\006\002\b\030H\002J.\020\034\032\b\022\004\022\002H\f0\035\"\b\b\000\020\f*\0020\r2\006\020\020\032\0020\0212\f\020\022\032\b\022\004\022\002H\f0\023H\026Jq\020\036\032\037\022\004\022\002H\f\022\004\022\0020\037\022\004\022\0020 \022\004\022\0020\0130\025¢\006\002\b\030\"\004\b\000\020\f2C\b\004\020\033\032=\022\004\022\002H\f\022\023\022\0210\026¢\006\f\b!\022\b\b\"\022\004\b\b(#\022\023\022\0210\027¢\006\f\b!\022\b\b\"\022\004\b\b($\022\004\022\0020\0130\025¢\006\002\b\030H\bJU\020%\032\0020\013\"\b\b\000\020\f*\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\0212\f\020\022\032\b\022\004\022\002H\f0\0232#\020\024\032\037\022\004\022\002H\f\022\004\022\0020\026\022\004\022\0020\027\022\004\022\0020\0130\025¢\006\002\b\030H\026J>\020%\032\0020\013\"\b\b\000\020\f*\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\0212\f\020\022\032\b\022\004\022\002H\f0\0232\f\020\024\032\b\022\004\022\002H\f0\031H\026Je\020%\032\0020\013\"\b\b\000\020\f*\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\0212\f\020\022\032\b\022\004\022\002H\f0\0232\016\020\032\032\n\022\004\022\002H\f\030\0010\0312%\020\033\032!\022\004\022\002H\f\022\004\022\0020\026\022\004\022\0020\027\022\004\022\0020\013\030\0010\025¢\006\002\b\030R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006'"}, d2={"Lcom/android/build/gradle/internal/api/dsl/options/BuildArtifactsOptionsImpl;", "Lcom/android/build/api/dsl/options/BuildArtifactsOptions;", "Lcom/android/build/gradle/internal/api/dsl/sealing/NestedSealable;", "project", "Lorg/gradle/api/Project;", "artifactHolder", "Lcom/android/build/gradle/internal/scope/BuildArtifactHolder;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lorg/gradle/api/Project;Lcom/android/build/gradle/internal/scope/BuildArtifactHolder;Lcom/android/builder/errors/EvalIssueReporter;)V", "appendTo", "", "T", "Lorg/gradle/api/Task;", "artifactType", "Lcom/android/build/api/artifact/ArtifactType;", "taskName", "", "taskType", "Ljava/lang/Class;", "configurationAction", "Lkotlin/Function3;", "Lcom/android/build/api/artifact/BuildableArtifact;", "Ljava/io/File;", "Lkotlin/ExtensionFunctionType;", "Lcom/android/build/api/artifact/BuildArtifactTransformBuilder$SimpleConfigurationAction;", "action", "function", "builder", "Lcom/android/build/api/artifact/BuildArtifactTransformBuilder;", "convertFunction", "Lcom/android/build/api/artifact/InputArtifactProvider;", "Lcom/android/build/api/artifact/OutputFileProvider;", "Lkotlin/ParameterName;", "name", "input", "output", "replace", "ConfigurationActionWrapper", "gradle-core"})
/*     */ public final class BuildArtifactsOptionsImpl
/*     */   extends NestedSealable
/*     */   implements BuildArtifactsOptions
/*     */ {
/*     */   private final Project project;
/*     */   private final BuildArtifactHolder artifactHolder;
/*     */   
/*     */   public BuildArtifactsOptionsImpl(@NotNull Project project, @NotNull BuildArtifactHolder artifactHolder, @NotNull EvalIssueReporter issueReporter)
/*     */   {
/*  40 */     super(issueReporter);this.project = project;this.artifactHolder = artifactHolder; }
/*     */   
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000.\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\b\002\030\000*\n\b\000\020\001 \000*\0020\0022\b\022\004\022\002H\0010\003B\023\022\f\020\004\032\b\022\004\022\0028\0000\005¢\006\002\020\006J%\020\t\032\0020\n2\006\020\013\032\0028\0002\006\020\f\032\0020\r2\006\020\016\032\0020\017H\026¢\006\002\020\020R\027\020\004\032\b\022\004\022\0028\0000\005¢\006\b\n\000\032\004\b\007\020\b¨\006\021"}, d2={"Lcom/android/build/gradle/internal/api/dsl/options/BuildArtifactsOptionsImpl$ConfigurationActionWrapper;", "T", "Lorg/gradle/api/Task;", "Lcom/android/build/api/artifact/BuildArtifactTransformBuilder$ConfigurationAction;", "action", "Lcom/android/build/api/artifact/BuildArtifactTransformBuilder$SimpleConfigurationAction;", "(Lcom/android/build/api/artifact/BuildArtifactTransformBuilder$SimpleConfigurationAction;)V", "getAction", "()Lcom/android/build/api/artifact/BuildArtifactTransformBuilder$SimpleConfigurationAction;", "accept", "", "task", "input", "Lcom/android/build/api/artifact/InputArtifactProvider;", "output", "Lcom/android/build/api/artifact/OutputFileProvider;", "(Lorg/gradle/api/Task;Lcom/android/build/api/artifact/InputArtifactProvider;Lcom/android/build/api/artifact/OutputFileProvider;)V", "gradle-core"})
/*     */   private static final class ConfigurationActionWrapper<T extends Task> implements BuildArtifactTransformBuilder.ConfigurationAction<T> { @NotNull
/*     */     private final BuildArtifactTransformBuilder.SimpleConfigurationAction<T> action;
/*     */     
/*  46 */     public ConfigurationActionWrapper(@NotNull BuildArtifactTransformBuilder.SimpleConfigurationAction<? super T> action) { this.action = action; } @NotNull
/*  47 */     public final BuildArtifactTransformBuilder.SimpleConfigurationAction<T> getAction() { return action; }
/*     */     
/*     */     public void accept(@NotNull T task, @NotNull InputArtifactProvider input, @NotNull OutputFileProvider output) {
/*  50 */       Intrinsics.checkParameterIsNotNull(task, "task");Intrinsics.checkParameterIsNotNull(input, "input");Intrinsics.checkParameterIsNotNull(output, "output");action.accept(task, input.getArtifact(), output.getFile());
/*     */     }
/*     */   }
/*     */   
/*     */   private final <T> Function3<T, InputArtifactProvider, OutputFileProvider, Unit> convertFunction(Function3<? super T, ? super BuildableArtifact, ? super File, Unit> function)
/*     */   {
/*     */     ;
/*     */     
/*  61 */     (Function3)new Lambda(function) { public final void invoke(T $receiver, @NotNull InputArtifactProvider input, @NotNull OutputFileProvider output) { Intrinsics.checkParameterIsNotNull(input, "input");Intrinsics.checkParameterIsNotNull(output, "output");$function.invoke($receiver, input.getArtifact(), output.getFile());
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   public <T extends Task> void appendTo(@NotNull ArtifactType artifactType, @NotNull String taskName, @NotNull Class<T> taskType, @NotNull BuildArtifactTransformBuilder.SimpleConfigurationAction<? super T> configurationAction)
/*     */   {
/*  68 */     Intrinsics.checkParameterIsNotNull(artifactType, "artifactType");Intrinsics.checkParameterIsNotNull(taskName, "taskName");Intrinsics.checkParameterIsNotNull(taskType, "taskType");Intrinsics.checkParameterIsNotNull(configurationAction, "configurationAction");appendTo(artifactType, taskName, taskType, configurationAction, null);
/*     */   }
/*     */   
/*     */   public <T extends Task> void appendTo(@NotNull ArtifactType artifactType, @NotNull String taskName, @NotNull Class<T> taskType, @NotNull Function3<? super T, ? super BuildableArtifact, ? super File, Unit> configurationAction)
/*     */   {
/*  76 */     Intrinsics.checkParameterIsNotNull(artifactType, "artifactType");Intrinsics.checkParameterIsNotNull(taskName, "taskName");Intrinsics.checkParameterIsNotNull(taskType, "taskType");Intrinsics.checkParameterIsNotNull(configurationAction, "configurationAction");appendTo(artifactType, taskName, taskType, null, configurationAction);
/*     */   }
/*     */   
/*     */   private final <T extends Task> void appendTo(ArtifactType artifactType, String taskName, Class<T> taskType, BuildArtifactTransformBuilder.SimpleConfigurationAction<? super T> action, Function3<? super T, ? super BuildableArtifact, ? super File, Unit> function)
/*     */   {
/*  84 */     BuildArtifactTransformBuilder builder = 
/*  85 */       new BuildArtifactTransformBuilderImpl(
/*  86 */       project, 
/*  87 */       artifactHolder, 
/*  88 */       taskName, 
/*  89 */       taskType, 
/*  90 */       getIssueReporter())
/*  91 */       .input(artifactType)
/*  92 */       .output(artifactType, BuildArtifactTransformBuilder.OperationType.APPEND)
/*  93 */       .outputFile(artifactType.name(), new ArtifactType[] { artifactType });
/*     */     
/*  95 */     if (action != null) { builder.create((BuildArtifactTransformBuilder.ConfigurationAction)new ConfigurationActionWrapper(action));
/*  96 */     } else if (function != null) { BuildArtifactsOptionsImpl localBuildArtifactsOptionsImpl1 = this;BuildArtifactTransformBuilder localBuildArtifactTransformBuilder1 = builder;
/*     */       
/*     */       int $i$f$convertFunction;
/*     */       
/*     */       BuildArtifactsOptionsImpl this_$iv;
/*     */       
/* 148 */       Function3 localFunction3 = (Function3)new Lambda(function)
/*     */       {
/*     */         public final void invoke(T $receiver, @NotNull InputArtifactProvider input, @NotNull OutputFileProvider output)
/*     */         {
/*  61 */           Intrinsics.checkParameterIsNotNull(input, "input");Intrinsics.checkParameterIsNotNull(output, "output");$function.invoke($receiver, input.getArtifact(), output.getFile());
/*     */         }
/*     */         
/*  96 */       };
/*     */       
/* 148 */       localBuildArtifactTransformBuilder1.create(localFunction3);
/*     */     }
/*     */     else
/*     */     {
/*  97 */       throw ((Throwable)new RuntimeException("unreachable"));
/*     */     }
/*     */   }
/*     */   
/*     */   public <T extends Task> void replace(@NotNull ArtifactType artifactType, @NotNull String taskName, @NotNull Class<T> taskType, @NotNull BuildArtifactTransformBuilder.SimpleConfigurationAction<? super T> configurationAction)
/*     */   {
/* 106 */     Intrinsics.checkParameterIsNotNull(artifactType, "artifactType");Intrinsics.checkParameterIsNotNull(taskName, "taskName");Intrinsics.checkParameterIsNotNull(taskType, "taskType");Intrinsics.checkParameterIsNotNull(configurationAction, "configurationAction");replace(artifactType, taskName, taskType, configurationAction, null);
/*     */   }
/*     */   
/*     */   public <T extends Task> void replace(@NotNull ArtifactType artifactType, @NotNull String taskName, @NotNull Class<T> taskType, @NotNull Function3<? super T, ? super BuildableArtifact, ? super File, Unit> configurationAction)
/*     */   {
/* 114 */     Intrinsics.checkParameterIsNotNull(artifactType, "artifactType");Intrinsics.checkParameterIsNotNull(taskName, "taskName");Intrinsics.checkParameterIsNotNull(taskType, "taskType");Intrinsics.checkParameterIsNotNull(configurationAction, "configurationAction");replace(artifactType, taskName, taskType, null, configurationAction);
/*     */   }
/*     */   
/*     */   public final <T extends Task> void replace(@NotNull ArtifactType artifactType, @NotNull String taskName, @NotNull Class<T> taskType, @Nullable BuildArtifactTransformBuilder.SimpleConfigurationAction<? super T> action, @Nullable Function3<? super T, ? super BuildableArtifact, ? super File, Unit> function)
/*     */   {
/* 122 */     Intrinsics.checkParameterIsNotNull(artifactType, "artifactType");Intrinsics.checkParameterIsNotNull(taskName, "taskName");Intrinsics.checkParameterIsNotNull(taskType, "taskType");BuildArtifactTransformBuilder builder = new BuildArtifactTransformBuilderImpl(
/* 123 */       project, 
/* 124 */       artifactHolder, 
/* 125 */       taskName, 
/* 126 */       taskType, 
/* 127 */       getIssueReporter())
/* 128 */       .input(artifactType)
/* 129 */       .output(artifactType, BuildArtifactTransformBuilder.OperationType.REPLACE)
/* 130 */       .outputFile(artifactType.name(), new ArtifactType[] { artifactType });
/*     */     
/* 132 */     if (action != null) { builder.create((BuildArtifactTransformBuilder.ConfigurationAction)new ConfigurationActionWrapper(action));
/* 133 */     } else if (function != null) { BuildArtifactsOptionsImpl localBuildArtifactsOptionsImpl1 = this;BuildArtifactTransformBuilder localBuildArtifactTransformBuilder1 = builder;
/*     */       
/*     */       int $i$f$convertFunction;
/*     */       
/*     */       BuildArtifactsOptionsImpl this_$iv;
/*     */       
/* 149 */       Function3 localFunction3 = (Function3)new Lambda(function)
/*     */       {
/*     */         public final void invoke(T $receiver, @NotNull InputArtifactProvider input, @NotNull OutputFileProvider output)
/*     */         {
/*  61 */           Intrinsics.checkParameterIsNotNull(input, "input");Intrinsics.checkParameterIsNotNull(output, "output");$function.invoke($receiver, input.getArtifact(), output.getFile());
/*     */         }
/*     */         
/* 133 */       };
/*     */       
/* 149 */       localBuildArtifactTransformBuilder1.create(localFunction3);
/*     */     }
/*     */     else
/*     */     {
/* 134 */       throw ((Throwable)new RuntimeException("unreachable"));
/*     */     }
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public <T extends Task> BuildArtifactTransformBuilder<T> builder(@NotNull String taskName, @NotNull Class<T> taskType) {
/* 140 */     Intrinsics.checkParameterIsNotNull(taskName, "taskName");Intrinsics.checkParameterIsNotNull(taskType, "taskType");
/*     */     
/* 146 */     return (BuildArtifactTransformBuilder)handleSealableSubItem((SealableObject)new BuildArtifactTransformBuilderImpl(project, artifactHolder, taskName, taskType, getIssueReporter()));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.options.BuildArtifactsOptionsImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */