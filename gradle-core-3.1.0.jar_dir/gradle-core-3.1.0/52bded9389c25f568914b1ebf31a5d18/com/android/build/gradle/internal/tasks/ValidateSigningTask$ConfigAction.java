/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import java.io.File;
/*     */ import kotlin.Metadata;
/*     */ import org.gradle.api.Task;
/*     */ import org.gradle.api.specs.Spec;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006¢\006\002\020\007J\020\020\b\032\0020\t2\006\020\n\032\0020\002H\026J\b\020\013\032\0020\fH\026J\016\020\r\032\b\022\004\022\0020\0020\016H\026R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\017"}, d2={"Lcom/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/tasks/ValidateSigningTask;", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "defaultDebugKeystoreLocation", "Ljava/io/File;", "(Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;)V", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*     */ public final class ValidateSigningTask$ConfigAction
/*     */   implements TaskConfigAction<ValidateSigningTask>
/*     */ {
/*     */   private final VariantScope variantScope;
/*     */   private final File defaultDebugKeystoreLocation;
/*     */   
/*     */   public ValidateSigningTask$ConfigAction(@NotNull VariantScope variantScope, @NotNull File defaultDebugKeystoreLocation)
/*     */   {
/* 126 */     this.variantScope = variantScope;this.defaultDebugKeystoreLocation = defaultDebugKeystoreLocation;
/*     */   }
/*     */   
/*     */   @NotNull
/* 131 */   public String getName() { return variantScope.getTaskName("validateSigning"); }
/*     */   @NotNull
/* 133 */   public Class<ValidateSigningTask> getType() { return ValidateSigningTask.class; }
/*     */   
/*     */   /* Error */
/*     */   public void execute(@NotNull ValidateSigningTask task)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 35
/*     */     //   3: invokestatic 41	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_1
/*     */     //   7: aload_0
/*     */     //   8: getfield 14	com/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction:variantScope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */     //   11: invokeinterface 44 1 0
/*     */     //   16: invokevirtual 48	com/android/build/gradle/internal/tasks/ValidateSigningTask:setVariantName	(Ljava/lang/String;)V
/*     */     //   19: aload_1
/*     */     //   20: aload_0
/*     */     //   21: getfield 14	com/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction:variantScope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */     //   24: invokeinterface 52 1 0
/*     */     //   29: dup
/*     */     //   30: ldc 54
/*     */     //   32: invokestatic 57	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   35: invokevirtual 63	com/android/build/gradle/internal/core/GradleVariantConfiguration:getSigningConfig	()Lcom/android/build/gradle/internal/dsl/CoreSigningConfig;
/*     */     //   38: dup
/*     */     //   39: ifnull +9 -> 48
/*     */     //   42: checkcast 65	com/android/builder/model/SigningConfig
/*     */     //   45: goto +42 -> 87
/*     */     //   48: pop
/*     */     //   49: new 67	java/lang/IllegalStateException
/*     */     //   52: dup
/*     */     //   53: new 69	java/lang/StringBuilder
/*     */     //   56: dup
/*     */     //   57: invokespecial 73	java/lang/StringBuilder:<init>	()V
/*     */     //   60: ldc 75
/*     */     //   62: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   65: aload_0
/*     */     //   66: getfield 14	com/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction:variantScope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */     //   69: invokeinterface 44 1 0
/*     */     //   74: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   77: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   80: invokespecial 84	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
/*     */     //   83: checkcast 86	java/lang/Throwable
/*     */     //   86: athrow
/*     */     //   87: invokestatic 90	com/android/build/gradle/internal/tasks/ValidateSigningTask:access$setSigningConfig$p	(Lcom/android/build/gradle/internal/tasks/ValidateSigningTask;Lcom/android/builder/model/SigningConfig;)V
/*     */     //   90: aload_1
/*     */     //   91: aload_0
/*     */     //   92: getfield 94	com/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction:defaultDebugKeystoreLocation	Ljava/io/File;
/*     */     //   95: invokestatic 98	com/android/build/gradle/internal/tasks/ValidateSigningTask:access$setDefaultDebugKeystoreLocation$p	(Lcom/android/build/gradle/internal/tasks/ValidateSigningTask;Ljava/io/File;)V
/*     */     //   98: aload_1
/*     */     //   99: aload_0
/*     */     //   100: getfield 14	com/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction:variantScope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */     //   103: aload_0
/*     */     //   104: invokevirtual 100	com/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction:getName	()Ljava/lang/String;
/*     */     //   107: invokeinterface 104 2 0
/*     */     //   112: dup
/*     */     //   113: ldc 106
/*     */     //   115: invokestatic 57	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   118: invokestatic 109	com/android/build/gradle/internal/tasks/ValidateSigningTask:access$setDummyOutputDirectory$p	(Lcom/android/build/gradle/internal/tasks/ValidateSigningTask;Ljava/io/File;)V
/*     */     //   121: aload_1
/*     */     //   122: invokevirtual 113	com/android/build/gradle/internal/tasks/ValidateSigningTask:getOutputs	()Lorg/gradle/api/internal/TaskOutputsInternal;
/*     */     //   125: new 115	com/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction$execute$1
/*     */     //   128: dup
/*     */     //   129: aload_1
/*     */     //   130: invokespecial 117	com/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction$execute$1:<init>	(Lcom/android/build/gradle/internal/tasks/ValidateSigningTask;)V
/*     */     //   133: checkcast 119	org/gradle/api/specs/Spec
/*     */     //   136: invokeinterface 125 2 0
/*     */     //   141: return
/*     */     // Line number table:
/*     */     //   Java source line #136	-> byte code offset #6
/*     */     //   Java source line #137	-> byte code offset #19
/*     */     //   Java source line #138	-> byte code offset #19
/*     */     //   Java source line #139	-> byte code offset #49
/*     */     //   Java source line #140	-> byte code offset #53
/*     */     //   Java source line #141	-> byte code offset #65
/*     */     //   Java source line #139	-> byte code offset #80
/*     */     //   Java source line #142	-> byte code offset #90
/*     */     //   Java source line #143	-> byte code offset #98
/*     */     //   Java source line #144	-> byte code offset #121
/*     */     //   Java source line #145	-> byte code offset #141
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	142	0	this	ConfigAction
/*     */     //   0	142	1	task	ValidateSigningTask
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.ValidateSigningTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */