/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.packaging.GradleKeystoreHelper;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.builder.model.SigningConfig;
/*     */ import com.android.builder.utils.ExceptionConsumer;
/*     */ import com.android.builder.utils.SynchronizedFile;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.base.Preconditions;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.security.KeyStore;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Task;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.specs.Spec;
/*     */ import org.gradle.api.tasks.OutputDirectory;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000(\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\007\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\013\n\002\b\006\b\026\030\0002\0020\001:\001\025B\005¢\006\002\020\002J\b\020\r\032\0020\016H\003J\b\020\017\032\0020\020H\007J\b\020\021\032\0020\020H\002J\b\020\022\032\0020\016H\007J\030\020\023\032\0020\020*\004\030\0010\0042\b\020\024\032\004\030\0010\004H\002R\016\020\003\032\0020\004X.¢\006\002\n\000R&\020\006\032\0020\0042\006\020\005\032\0020\0048\007@BX.¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\016\020\013\032\0020\fX.¢\006\002\n\000¨\006\026"}, d2={"Lcom/android/build/gradle/internal/tasks/ValidateSigningTask;", "Lcom/android/build/gradle/internal/tasks/AndroidVariantTask;", "()V", "defaultDebugKeystoreLocation", "Ljava/io/File;", "<set-?>", "dummyOutputDirectory", "getDummyOutputDirectory", "()Ljava/io/File;", "setDummyOutputDirectory", "(Ljava/io/File;)V", "signingConfig", "Lcom/android/builder/model/SigningConfig;", "createDefaultDebugKeystoreIfNeeded", "", "forceRerun", "", "isSigningConfigUsingTheDefaultDebugKeystore", "validate", "isSameFile", "other", "ConfigAction", "gradle-core"})
/*     */ public class ValidateSigningTask
/*     */   extends AndroidVariantTask
/*     */ {
/*     */   @NotNull
/*     */   private File dummyOutputDirectory;
/*     */   private SigningConfig signingConfig;
/*     */   private File defaultDebugKeystoreLocation;
/*     */   
/*     */   @OutputDirectory
/*     */   @NotNull
/*     */   public final File getDummyOutputDirectory()
/*     */   {
/*  51 */     File tmp4_1 = dummyOutputDirectory;
/*     */     
/*  51 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("dummyOutputDirectory"); return tmp4_1; } private final void setDummyOutputDirectory(File <set-?>) { dummyOutputDirectory = <set-?>; }
/*     */   
/*     */   private final void createDefaultDebugKeystoreIfNeeded()
/*     */     throws ExecutionException, IOException
/*     */   {
/*  79 */     SigningConfig tmp4_1 = signingConfig;
/*     */     
/*  79 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("signingConfig"); Preconditions.checkState(tmp4_1.isSigningReady(), "Debug signing config not ready.", new Object[0]); File 
/*  80 */       tmp31_28 = defaultDebugKeystoreLocation;
/*  80 */     if (tmp31_28 == null) Intrinsics.throwUninitializedPropertyAccessException("defaultDebugKeystoreLocation"); if (!tmp31_28.getParentFile().canWrite())
/*     */     {
/*  82 */       File tmp74_71 = defaultDebugKeystoreLocation;
/*     */       
/*  82 */       if (tmp74_71 == null) Intrinsics.throwUninitializedPropertyAccessException("defaultDebugKeystoreLocation"); File tmp86_83 = tmp74_71.getParentFile();Intrinsics.checkExpressionValueIsNotNull(tmp86_83, "defaultDebugKeystoreLocation.parentFile");throw ((Throwable)new IOException("Unable to create debug keystore in " + "" + tmp86_83.getAbsolutePath() + " because it is not writable."));
/*     */     }
/*     */     
/*  88 */     File tmp117_114 = defaultDebugKeystoreLocation;
/*     */     
/*  88 */     if (tmp117_114 == null) { Intrinsics.throwUninitializedPropertyAccessException("defaultDebugKeystoreLocation");
/*     */     }
/*  90 */     File tmp135_132 = defaultDebugKeystoreLocation;
/*     */     
/*  90 */     if (tmp135_132 == null) Intrinsics.throwUninitializedPropertyAccessException("defaultDebugKeystoreLocation");
/*  88 */     Preconditions.checkState(FileUtils.parentDirExists(tmp117_114), 
/*  89 */       "Parent directory of the default debug keystore '%s' does not exist", 
/*  90 */       tmp135_132); File 
/*     */     
/* 100 */       tmp151_148 = defaultDebugKeystoreLocation;
/*     */     
/* 100 */     if (tmp151_148 == null) Intrinsics.throwUninitializedPropertyAccessException("defaultDebugKeystoreLocation");
/* 101 */     SynchronizedFile.getInstanceWithMultiProcessLocking(tmp151_148).createIfAbsent((ExceptionConsumer)new ExceptionConsumer() { public final void accept(File it) { File tmp1_0 = it;Intrinsics.checkExpressionValueIsNotNull(tmp1_0, "it"); Logger tmp14_11 = this$0.getLogger();Intrinsics.checkExpressionValueIsNotNull(tmp14_11, "this.logger");GradleKeystoreHelper.createDefaultDebugStore(tmp1_0, tmp14_11);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private final boolean isSigningConfigUsingTheDefaultDebugKeystore()
/*     */   {
/* 111 */     SigningConfig tmp4_1 = signingConfig;
/*     */     
/* 111 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("signingConfig"); if (Intrinsics.areEqual(tmp4_1.getName(), "debug")) { SigningConfig tmp30_27 = signingConfig;
/*     */       
/* 111 */       if (tmp30_27 == null) Intrinsics.throwUninitializedPropertyAccessException("signingConfig"); if (Intrinsics.areEqual(tmp30_27.getKeyAlias(), "AndroidDebugKey")) { SigningConfig tmp56_53 = signingConfig;
/*     */         
/* 111 */         if (tmp56_53 == null) Intrinsics.throwUninitializedPropertyAccessException("signingConfig"); if (Intrinsics.areEqual(tmp56_53.getKeyPassword(), "android")) { SigningConfig tmp82_79 = signingConfig;
/*     */           
/* 111 */           if (tmp82_79 == null) Intrinsics.throwUninitializedPropertyAccessException("signingConfig"); if (Intrinsics.areEqual(tmp82_79.getStorePassword(), "android")) { SigningConfig tmp108_105 = signingConfig;
/*     */             
/* 111 */             if (tmp108_105 == null) Intrinsics.throwUninitializedPropertyAccessException("signingConfig");
/* 110 */             if (Intrinsics.areEqual(
/* 111 */               tmp108_105.getStoreType(), KeyStore.getDefaultType())) { if (signingConfig == null) Intrinsics.throwUninitializedPropertyAccessException("signingConfig"); if (defaultDebugKeystoreLocation == null) Intrinsics.throwUninitializedPropertyAccessException("defaultDebugKeystoreLocation"); } } } } } return isSameFile(tmp136_133.getStoreFile(), tmp154_151);
/*     */   }
/*     */   
/*     */   private final boolean isSameFile(@Nullable File $receiver, File other) {
/* 115 */     return ($receiver != null) && (other != null) && (FileUtils.isSameFile($receiver, other));
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   @org.gradle.api.tasks.TaskAction
/*     */   public final void validate()
/*     */     throws ExecutionException, IOException
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 38	com/android/build/gradle/internal/tasks/ValidateSigningTask:signingConfig	Lcom/android/builder/model/SigningConfig;
/*     */     //   4: dup
/*     */     //   5: ifnonnull +8 -> 13
/*     */     //   8: ldc 39
/*     */     //   10: invokestatic 19	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   13: invokeinterface 44 1 0
/*     */     //   18: ifnonnull +50 -> 68
/*     */     //   21: new 46	org/gradle/api/InvalidUserDataException
/*     */     //   24: dup
/*     */     //   25: new 48	java/lang/StringBuilder
/*     */     //   28: dup
/*     */     //   29: invokespecial 51	java/lang/StringBuilder:<init>	()V
/*     */     //   32: ldc 53
/*     */     //   34: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   37: aload_0
/*     */     //   38: getfield 38	com/android/build/gradle/internal/tasks/ValidateSigningTask:signingConfig	Lcom/android/builder/model/SigningConfig;
/*     */     //   41: dup
/*     */     //   42: ifnonnull +8 -> 50
/*     */     //   45: ldc 39
/*     */     //   47: invokestatic 19	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   50: invokeinterface 61 1 0
/*     */     //   55: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   58: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   61: invokespecial 66	org/gradle/api/InvalidUserDataException:<init>	(Ljava/lang/String;)V
/*     */     //   64: checkcast 68	java/lang/Throwable
/*     */     //   67: athrow
/*     */     //   68: aload_0
/*     */     //   69: invokespecial 72	com/android/build/gradle/internal/tasks/ValidateSigningTask:isSigningConfigUsingTheDefaultDebugKeystore	()Z
/*     */     //   72: ifeq +10 -> 82
/*     */     //   75: aload_0
/*     */     //   76: invokespecial 75	com/android/build/gradle/internal/tasks/ValidateSigningTask:createDefaultDebugKeystoreIfNeeded	()V
/*     */     //   79: goto +137 -> 216
/*     */     //   82: aload_0
/*     */     //   83: getfield 38	com/android/build/gradle/internal/tasks/ValidateSigningTask:signingConfig	Lcom/android/builder/model/SigningConfig;
/*     */     //   86: dup
/*     */     //   87: ifnonnull +8 -> 95
/*     */     //   90: ldc 39
/*     */     //   92: invokestatic 19	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   95: invokeinterface 44 1 0
/*     */     //   100: dup
/*     */     //   101: ifnull +13 -> 114
/*     */     //   104: invokevirtual 78	java/io/File:isFile	()Z
/*     */     //   107: iconst_1
/*     */     //   108: if_icmpne +13 -> 121
/*     */     //   111: goto +7 -> 118
/*     */     //   114: pop
/*     */     //   115: goto +6 -> 121
/*     */     //   118: goto +98 -> 216
/*     */     //   121: new 46	org/gradle/api/InvalidUserDataException
/*     */     //   124: dup
/*     */     //   125: new 48	java/lang/StringBuilder
/*     */     //   128: dup
/*     */     //   129: invokespecial 51	java/lang/StringBuilder:<init>	()V
/*     */     //   132: ldc 80
/*     */     //   134: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   137: aload_0
/*     */     //   138: getfield 38	com/android/build/gradle/internal/tasks/ValidateSigningTask:signingConfig	Lcom/android/builder/model/SigningConfig;
/*     */     //   141: dup
/*     */     //   142: ifnonnull +8 -> 150
/*     */     //   145: ldc 39
/*     */     //   147: invokestatic 19	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   150: invokeinterface 44 1 0
/*     */     //   155: dup
/*     */     //   156: ifnull +9 -> 165
/*     */     //   159: invokevirtual 83	java/io/File:getAbsolutePath	()Ljava/lang/String;
/*     */     //   162: goto +5 -> 167
/*     */     //   165: pop
/*     */     //   166: aconst_null
/*     */     //   167: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   170: ldc 85
/*     */     //   172: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   175: ldc 87
/*     */     //   177: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   180: aload_0
/*     */     //   181: getfield 38	com/android/build/gradle/internal/tasks/ValidateSigningTask:signingConfig	Lcom/android/builder/model/SigningConfig;
/*     */     //   184: dup
/*     */     //   185: ifnonnull +8 -> 193
/*     */     //   188: ldc 39
/*     */     //   190: invokestatic 19	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   193: invokeinterface 61 1 0
/*     */     //   198: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   201: ldc 89
/*     */     //   203: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   206: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   209: invokespecial 66	org/gradle/api/InvalidUserDataException:<init>	(Ljava/lang/String;)V
/*     */     //   212: checkcast 68	java/lang/Throwable
/*     */     //   215: athrow
/*     */     //   216: return
/*     */     // Line number table:
/*     */     //   Java source line #59	-> byte code offset #0
/*     */     //   Java source line #60	-> byte code offset #0
/*     */     //   Java source line #61	-> byte code offset #25
/*     */     //   Java source line #60	-> byte code offset #61
/*     */     //   Java source line #62	-> byte code offset #68
/*     */     //   Java source line #67	-> byte code offset #75
/*     */     //   Java source line #68	-> byte code offset #82
/*     */     //   Java source line #71	-> byte code offset #121
/*     */     //   Java source line #72	-> byte code offset #125
/*     */     //   Java source line #73	-> byte code offset #180
/*     */     //   Java source line #71	-> byte code offset #209
/*     */     //   Java source line #74	-> byte code offset #216
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	217	0	this	ValidateSigningTask
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public final boolean forceRerun()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 38	com/android/build/gradle/internal/tasks/ValidateSigningTask:signingConfig	Lcom/android/builder/model/SigningConfig;
/*     */     //   4: dup
/*     */     //   5: ifnonnull +8 -> 13
/*     */     //   8: ldc 39
/*     */     //   10: invokestatic 19	kotlin/jvm/internal/Intrinsics:throwUninitializedPropertyAccessException	(Ljava/lang/String;)V
/*     */     //   13: invokeinterface 44 1 0
/*     */     //   18: dup
/*     */     //   19: ifnull +13 -> 32
/*     */     //   22: invokevirtual 78	java/io/File:isFile	()Z
/*     */     //   25: iconst_1
/*     */     //   26: if_icmpeq +11 -> 37
/*     */     //   29: goto +4 -> 33
/*     */     //   32: pop
/*     */     //   33: iconst_1
/*     */     //   34: goto +4 -> 38
/*     */     //   37: iconst_0
/*     */     //   38: ireturn
/*     */     // Line number table:
/*     */     //   Java source line #124	-> byte code offset #0
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	39	0	this	ValidateSigningTask
/*     */   }
/*     */   
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006¢\006\002\020\007J\020\020\b\032\0020\t2\006\020\n\032\0020\002H\026J\b\020\013\032\0020\fH\026J\016\020\r\032\b\022\004\022\0020\0020\016H\026R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\017"}, d2={"Lcom/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/tasks/ValidateSigningTask;", "variantScope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "defaultDebugKeystoreLocation", "Ljava/io/File;", "(Lcom/android/build/gradle/internal/scope/VariantScope;Ljava/io/File;)V", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*     */   public static final class ConfigAction
/*     */     implements TaskConfigAction<ValidateSigningTask>
/*     */   {
/*     */     private final VariantScope variantScope;
/*     */     private final File defaultDebugKeystoreLocation;
/*     */     
/*     */     public ConfigAction(@NotNull VariantScope variantScope, @NotNull File defaultDebugKeystoreLocation)
/*     */     {
/* 126 */       this.variantScope = variantScope;this.defaultDebugKeystoreLocation = defaultDebugKeystoreLocation;
/*     */     }
/*     */     
/*     */     @NotNull
/* 131 */     public String getName() { return variantScope.getTaskName("validateSigning"); }
/*     */     @NotNull
/* 133 */     public Class<ValidateSigningTask> getType() { return ValidateSigningTask.class; }
/*     */     
/*     */     /* Error */
/*     */     public void execute(@NotNull ValidateSigningTask task)
/*     */     {
/*     */       // Byte code:
/*     */       //   0: aload_1
/*     */       //   1: ldc 35
/*     */       //   3: invokestatic 41	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   6: aload_1
/*     */       //   7: aload_0
/*     */       //   8: getfield 14	com/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction:variantScope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   11: invokeinterface 44 1 0
/*     */       //   16: invokevirtual 48	com/android/build/gradle/internal/tasks/ValidateSigningTask:setVariantName	(Ljava/lang/String;)V
/*     */       //   19: aload_1
/*     */       //   20: aload_0
/*     */       //   21: getfield 14	com/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction:variantScope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   24: invokeinterface 52 1 0
/*     */       //   29: dup
/*     */       //   30: ldc 54
/*     */       //   32: invokestatic 57	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   35: invokevirtual 63	com/android/build/gradle/internal/core/GradleVariantConfiguration:getSigningConfig	()Lcom/android/build/gradle/internal/dsl/CoreSigningConfig;
/*     */       //   38: dup
/*     */       //   39: ifnull +9 -> 48
/*     */       //   42: checkcast 65	com/android/builder/model/SigningConfig
/*     */       //   45: goto +42 -> 87
/*     */       //   48: pop
/*     */       //   49: new 67	java/lang/IllegalStateException
/*     */       //   52: dup
/*     */       //   53: new 69	java/lang/StringBuilder
/*     */       //   56: dup
/*     */       //   57: invokespecial 73	java/lang/StringBuilder:<init>	()V
/*     */       //   60: ldc 75
/*     */       //   62: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   65: aload_0
/*     */       //   66: getfield 14	com/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction:variantScope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   69: invokeinterface 44 1 0
/*     */       //   74: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   77: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */       //   80: invokespecial 84	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
/*     */       //   83: checkcast 86	java/lang/Throwable
/*     */       //   86: athrow
/*     */       //   87: invokestatic 90	com/android/build/gradle/internal/tasks/ValidateSigningTask:access$setSigningConfig$p	(Lcom/android/build/gradle/internal/tasks/ValidateSigningTask;Lcom/android/builder/model/SigningConfig;)V
/*     */       //   90: aload_1
/*     */       //   91: aload_0
/*     */       //   92: getfield 94	com/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction:defaultDebugKeystoreLocation	Ljava/io/File;
/*     */       //   95: invokestatic 98	com/android/build/gradle/internal/tasks/ValidateSigningTask:access$setDefaultDebugKeystoreLocation$p	(Lcom/android/build/gradle/internal/tasks/ValidateSigningTask;Ljava/io/File;)V
/*     */       //   98: aload_1
/*     */       //   99: aload_0
/*     */       //   100: getfield 14	com/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction:variantScope	Lcom/android/build/gradle/internal/scope/VariantScope;
/*     */       //   103: aload_0
/*     */       //   104: invokevirtual 100	com/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction:getName	()Ljava/lang/String;
/*     */       //   107: invokeinterface 104 2 0
/*     */       //   112: dup
/*     */       //   113: ldc 106
/*     */       //   115: invokestatic 57	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   118: invokestatic 109	com/android/build/gradle/internal/tasks/ValidateSigningTask:access$setDummyOutputDirectory$p	(Lcom/android/build/gradle/internal/tasks/ValidateSigningTask;Ljava/io/File;)V
/*     */       //   121: aload_1
/*     */       //   122: invokevirtual 113	com/android/build/gradle/internal/tasks/ValidateSigningTask:getOutputs	()Lorg/gradle/api/internal/TaskOutputsInternal;
/*     */       //   125: new 115	com/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction$execute$1
/*     */       //   128: dup
/*     */       //   129: aload_1
/*     */       //   130: invokespecial 117	com/android/build/gradle/internal/tasks/ValidateSigningTask$ConfigAction$execute$1:<init>	(Lcom/android/build/gradle/internal/tasks/ValidateSigningTask;)V
/*     */       //   133: checkcast 119	org/gradle/api/specs/Spec
/*     */       //   136: invokeinterface 125 2 0
/*     */       //   141: return
/*     */       // Line number table:
/*     */       //   Java source line #136	-> byte code offset #6
/*     */       //   Java source line #137	-> byte code offset #19
/*     */       //   Java source line #138	-> byte code offset #19
/*     */       //   Java source line #139	-> byte code offset #49
/*     */       //   Java source line #140	-> byte code offset #53
/*     */       //   Java source line #141	-> byte code offset #65
/*     */       //   Java source line #139	-> byte code offset #80
/*     */       //   Java source line #142	-> byte code offset #90
/*     */       //   Java source line #143	-> byte code offset #98
/*     */       //   Java source line #144	-> byte code offset #121
/*     */       //   Java source line #145	-> byte code offset #141
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	signature
/*     */       //   0	142	0	this	ConfigAction
/*     */       //   0	142	1	task	ValidateSigningTask
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.ValidateSigningTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */