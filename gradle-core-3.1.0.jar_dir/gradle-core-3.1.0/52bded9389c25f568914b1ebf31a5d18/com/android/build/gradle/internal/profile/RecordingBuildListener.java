/*    */ package com.android.build.gradle.internal.profile;
/*    */ 
/*    */ import com.android.build.gradle.internal.tasks.AndroidVariantTask;
/*    */ import com.android.builder.profile.ProcessProfileWriter;
/*    */ import com.android.builder.profile.ProfileRecordWriter;
/*    */ import com.android.tools.build.gradle.internal.profile.GradleTaskExecutionType;
/*    */ import com.google.wireless.android.sdk.stats.GradleBuildProfileSpan;
/*    */ import com.google.wireless.android.sdk.stats.GradleBuildProfileSpan.Builder;
/*    */ import com.google.wireless.android.sdk.stats.GradleBuildProfileSpan.ExecutionType;
/*    */ import com.google.wireless.android.sdk.stats.GradleTaskExecution;
/*    */ import com.google.wireless.android.sdk.stats.GradleTaskExecution.Builder;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import org.gradle.api.Project;
/*    */ import org.gradle.api.Task;
/*    */ import org.gradle.api.execution.TaskExecutionListener;
/*    */ import org.gradle.api.tasks.TaskState;
/*    */ 
/*    */ public class RecordingBuildListener
/*    */   implements TaskExecutionListener
/*    */ {
/*    */   private final ProfileRecordWriter recordWriter;
/* 43 */   private final Map<String, GradleBuildProfileSpan.Builder> taskRecords = new ConcurrentHashMap();
/*    */   
/*    */   RecordingBuildListener(ProfileRecordWriter recorder)
/*    */   {
/* 48 */     recordWriter = recorder;
/*    */   }
/*    */   
/*    */   public void beforeExecute(Task task)
/*    */   {
/* 53 */     GradleBuildProfileSpan.Builder builder = GradleBuildProfileSpan.newBuilder();
/* 54 */     builder.setType(GradleBuildProfileSpan.ExecutionType.TASK_EXECUTION);
/* 55 */     builder.setId(recordWriter.allocateRecordId());
/* 56 */     builder.setStartTimeInMs(System.currentTimeMillis());
/*    */     
/* 58 */     taskRecords.put(task.getPath(), builder);
/*    */   }
/*    */   
/*    */   public void afterExecute(Task task, TaskState taskState)
/*    */   {
/* 63 */     GradleBuildProfileSpan.Builder record = (GradleBuildProfileSpan.Builder)taskRecords.remove(task.getPath());
/*    */     
/* 65 */     record.setDurationInMs(System.currentTimeMillis() - record.getStartTimeInMs());
/*    */     
/* 68 */     record.setTask(
/* 69 */       GradleTaskExecution.newBuilder()
/* 70 */       .setType(AnalyticsUtil.getTaskExecutionType(task.getClass()).getNumber())
/* 71 */       .setDidWork(taskState.getDidWork())
/* 72 */       .setSkipped(taskState.getSkipped())
/* 73 */       .setUpToDate(taskState.getUpToDate())
/* 74 */       .setFailed(taskState.getFailure() != null));
/*    */     
/* 76 */     recordWriter.writeRecord(task.getProject().getPath(), getVariantName(task), record);
/* 77 */     ProcessProfileWriter.recordMemorySample();
/*    */   }
/*    */   
/*    */   private static String getVariantName(Task task)
/*    */   {
/* 82 */     if (!(task instanceof AndroidVariantTask)) {
/* 83 */       return null;
/*    */     }
/* 85 */     String variantName = ((AndroidVariantTask)task).getVariantName();
/* 86 */     if (variantName == null) {
/* 87 */       throw new IllegalStateException("Task with type " + task.getClass().getName() + " does not include a variantName");
/*    */     }
/*    */     
/* 90 */     if (variantName.isEmpty()) {
/* 91 */       return null;
/*    */     }
/* 93 */     return variantName;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.profile.RecordingBuildListener
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */