/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.ExistingBuildElements;
/*    */ import com.android.build.gradle.internal.scope.ExistingBuildElements.Companion;
/*    */ import com.android.build.gradle.internal.scope.OutputScope;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import com.android.build.gradle.internal.tasks.AndroidVariantTask;
/*    */ import com.android.ide.common.build.ApkData;
/*    */ import com.android.utils.FileUtils;
/*    */ import java.io.File;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.tasks.Input;
/*    */ import org.gradle.api.tasks.OutputFile;
/*    */ import org.gradle.api.tasks.TaskAction;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000(\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\036\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\002\b\026\030\0002\0020\001:\001\022B\005¢\006\002\020\002J\b\020\020\032\0020\021H\007R\"\020\003\032\b\022\004\022\0020\0050\0048\007X.¢\006\016\n\000\032\004\b\006\020\007\"\004\b\b\020\tR\034\020\n\032\0020\0138\007X.¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017¨\006\023"}, d2={"Lcom/android/build/gradle/tasks/MainApkListPersistence;", "Lcom/android/build/gradle/internal/tasks/AndroidVariantTask;", "()V", "apkData", "", "Lcom/android/ide/common/build/ApkData;", "getApkData", "()Ljava/util/Collection;", "setApkData", "(Ljava/util/Collection;)V", "outputFile", "Ljava/io/File;", "getOutputFile", "()Ljava/io/File;", "setOutputFile", "(Ljava/io/File;)V", "fullTaskAction", "", "ConfigAction", "gradle-core"})
/*    */ public class MainApkListPersistence
/*    */   extends AndroidVariantTask
/*    */ {
/*    */   @NotNull
/*    */   public File outputFile;
/*    */   @NotNull
/*    */   public Collection<? extends ApkData> apkData;
/*    */   
/*    */   @OutputFile
/*    */   @NotNull
/*    */   public final File getOutputFile()
/*    */   {
/* 40 */     File tmp4_1 = outputFile;
/*    */     
/* 40 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("outputFile"); return tmp4_1; } public final void setOutputFile(@NotNull File <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");outputFile = <set-?>; } @Input
/*    */   @NotNull
/* 42 */   public final Collection<ApkData> getApkData() { Collection tmp4_1 = apkData;
/*    */     
/* 42 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("apkData"); return tmp4_1; } public final void setApkData(@NotNull Collection<? extends ApkData> <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");apkData = <set-?>;
/*    */   }
/*    */   
/*    */   @TaskAction
/*    */   public final void fullTaskAction() {
/* 47 */     File tmp4_1 = outputFile;
/*    */     
/* 47 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("outputFile"); FileUtils.deleteIfExists(tmp4_1); Collection 
/* 48 */       tmp23_20 = apkData;
/* 48 */     if (tmp23_20 == null) Intrinsics.throwUninitializedPropertyAccessException("apkData"); String apkDataList = ExistingBuildElements.Companion.persistApkList(tmp23_20); File 
/* 49 */       tmp40_37 = outputFile;
/* 49 */     if (tmp40_37 == null) Intrinsics.throwUninitializedPropertyAccessException("outputFile"); FileUtils.createFile(tmp40_37, apkDataList); }
/*    */   
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000*\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\020\020\b\032\0020\t2\006\020\n\032\0020\002H\026J\b\020\013\032\0020\fH\026J\016\020\r\032\b\022\004\022\0020\0020\016H\026R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\006\020\007¨\006\017"}, d2={"Lcom/android/build/gradle/tasks/MainApkListPersistence$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/tasks/MainApkListPersistence;", "scope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "(Lcom/android/build/gradle/internal/scope/VariantScope;)V", "getScope", "()Lcom/android/build/gradle/internal/scope/VariantScope;", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/* 52 */   public static final class ConfigAction implements TaskConfigAction<MainApkListPersistence> { public ConfigAction(@NotNull VariantScope scope) { this.scope = scope; } @NotNull
/* 53 */     public final VariantScope getScope() { return scope; }
/*    */     @NotNull
/* 55 */     public String getName() { return scope.getTaskName("mainApkListPersistence"); }
/*    */     @NotNull
/* 57 */     public Class<MainApkListPersistence> getType() { return MainApkListPersistence.class; }
/*    */     
/*    */     @NotNull
/*    */     private final VariantScope scope;
/* 61 */     public void execute(@NotNull MainApkListPersistence task) { Intrinsics.checkParameterIsNotNull(task, "task");task.setVariantName(scope.getFullVariantName()); OutputScope 
/* 62 */         tmp29_24 = scope.getOutputScope();Intrinsics.checkExpressionValueIsNotNull(tmp29_24, "scope.outputScope"); List tmp38_35 = tmp29_24.getApkDatas();Intrinsics.checkExpressionValueIsNotNull(tmp38_35, "scope.outputScope.apkDatas");task.setApkData((Collection)tmp38_35);
/*    */       
/* 64 */       task.setOutputFile(new File(
/* 65 */         new File(scope.getSplitSupportDirectory(), "apk-list"), 
/* 66 */         "apk-list.gson"));
/* 67 */       scope.addTaskOutput(TaskOutputHolder.TaskOutputType.APK_LIST, 
/* 68 */         task.getOutputFile(), 
/* 69 */         getName());
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.MainApkListPersistence
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */