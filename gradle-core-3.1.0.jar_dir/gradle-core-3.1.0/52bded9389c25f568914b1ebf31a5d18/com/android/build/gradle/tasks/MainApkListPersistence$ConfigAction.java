/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.OutputScope;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*    */ import com.android.build.gradle.internal.scope.VariantScope;
/*    */ import java.io.File;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000*\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\020\020\b\032\0020\t2\006\020\n\032\0020\002H\026J\b\020\013\032\0020\fH\026J\016\020\r\032\b\022\004\022\0020\0020\016H\026R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\006\020\007¨\006\017"}, d2={"Lcom/android/build/gradle/tasks/MainApkListPersistence$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/tasks/MainApkListPersistence;", "scope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "(Lcom/android/build/gradle/internal/scope/VariantScope;)V", "getScope", "()Lcom/android/build/gradle/internal/scope/VariantScope;", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*    */ public final class MainApkListPersistence$ConfigAction
/*    */   implements TaskConfigAction<MainApkListPersistence>
/*    */ {
/*    */   @NotNull
/*    */   private final VariantScope scope;
/*    */   
/* 52 */   public MainApkListPersistence$ConfigAction(@NotNull VariantScope scope) { this.scope = scope; } @NotNull
/* 53 */   public final VariantScope getScope() { return scope; }
/*    */   @NotNull
/* 55 */   public String getName() { return scope.getTaskName("mainApkListPersistence"); }
/*    */   @NotNull
/* 57 */   public Class<MainApkListPersistence> getType() { return MainApkListPersistence.class; }
/*    */   
/*    */   public void execute(@NotNull MainApkListPersistence task)
/*    */   {
/* 61 */     Intrinsics.checkParameterIsNotNull(task, "task");task.setVariantName(scope.getFullVariantName()); OutputScope 
/* 62 */       tmp29_24 = scope.getOutputScope();Intrinsics.checkExpressionValueIsNotNull(tmp29_24, "scope.outputScope"); List tmp38_35 = tmp29_24.getApkDatas();Intrinsics.checkExpressionValueIsNotNull(tmp38_35, "scope.outputScope.apkDatas");task.setApkData((Collection)tmp38_35);
/*    */     
/* 64 */     task.setOutputFile(new File(
/* 65 */       new File(scope.getSplitSupportDirectory(), "apk-list"), 
/* 66 */       "apk-list.gson"));
/* 67 */     scope.addTaskOutput(TaskOutputHolder.TaskOutputType.APK_LIST, 
/* 68 */       task.getOutputFile(), 
/* 69 */       getName());
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.MainApkListPersistence.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */