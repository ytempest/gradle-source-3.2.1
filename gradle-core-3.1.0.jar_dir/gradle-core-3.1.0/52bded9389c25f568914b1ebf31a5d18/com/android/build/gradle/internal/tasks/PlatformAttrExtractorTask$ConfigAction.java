/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.scope.GlobalScope;
/*    */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import com.android.sdklib.IAndroidTarget;
/*    */ import java.io.File;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006¢\006\002\020\007J\020\020\f\032\0020\r2\006\020\016\032\0020\002H\026J\b\020\017\032\0020\020H\026J\016\020\021\032\b\022\004\022\0020\0020\022H\026R\021\020\005\032\0020\006¢\006\b\n\000\032\004\b\b\020\tR\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\n\020\013¨\006\023"}, d2={"Lcom/android/build/gradle/internal/tasks/PlatformAttrExtractorTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/internal/tasks/PlatformAttrExtractorTask;", "scope", "Lcom/android/build/gradle/internal/scope/GlobalScope;", "output", "Ljava/io/File;", "(Lcom/android/build/gradle/internal/scope/GlobalScope;Ljava/io/File;)V", "getOutput", "()Ljava/io/File;", "getScope", "()Lcom/android/build/gradle/internal/scope/GlobalScope;", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*    */ public final class PlatformAttrExtractorTask$ConfigAction
/*    */   implements TaskConfigAction<PlatformAttrExtractorTask>
/*    */ {
/*    */   @NotNull
/*    */   private final GlobalScope scope;
/*    */   @NotNull
/*    */   private final File output;
/*    */   
/*    */   @NotNull
/* 60 */   public final GlobalScope getScope() { return scope; } @NotNull
/* 60 */   public final File getOutput() { return output; } public PlatformAttrExtractorTask$ConfigAction(@NotNull GlobalScope scope, @NotNull File output) { this.scope = scope;this.output = output; }
/*    */   
/*    */   @NotNull
/* 63 */   public String getName() { return "platformAttrExtractor"; }
/*    */   @NotNull
/* 65 */   public Class<PlatformAttrExtractorTask> getType() { return PlatformAttrExtractorTask.class; }
/*    */   
/*    */   public void execute(@NotNull PlatformAttrExtractorTask task) {
/* 68 */     Intrinsics.checkParameterIsNotNull(task, "task"); AndroidBuilder 
/* 69 */       tmp18_15 = scope.getAndroidBuilder();Intrinsics.checkExpressionValueIsNotNull(tmp18_15, "scope.androidBuilder");PlatformAttrExtractorTask.access$setInputFile$p(task, new File(tmp18_15.getTarget()
/*    */     
/* 71 */       .getPath(1)));
/*    */     
/* 73 */     PlatformAttrExtractorTask.access$setOutputFile$p(task, output);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.PlatformAttrExtractorTask.ConfigAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */