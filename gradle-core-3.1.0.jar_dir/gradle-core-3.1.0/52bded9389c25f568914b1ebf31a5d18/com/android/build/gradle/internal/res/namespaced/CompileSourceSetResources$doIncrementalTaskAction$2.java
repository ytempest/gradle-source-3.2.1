/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.gradle.workers.IsolationMode;
/*    */ import org.gradle.workers.WorkerConfiguration;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2={"<anonymous>", "", "it", "Lorg/gradle/workers/WorkerConfiguration;", "kotlin.jvm.PlatformType", "execute"})
/*    */ final class CompileSourceSetResources$doIncrementalTaskAction$2<T>
/*    */   implements Action<WorkerConfiguration>
/*    */ {
/*    */   public final void execute(WorkerConfiguration it)
/*    */   {
/* 90 */     WorkerConfiguration tmp1_0 = it;Intrinsics.checkExpressionValueIsNotNull(tmp1_0, "it");tmp1_0.setIsolationMode(IsolationMode.NONE);
/* 91 */     it.setParams(new Object[] { new Aapt2CompileDeleteRunnable.Params(
/* 92 */       this$0.getOutputDirectory(), 
/* 93 */       (Iterable)$deletes) });
/*    */   }
/*    */   
/*    */   CompileSourceSetResources$doIncrementalTaskAction$2(CompileSourceSetResources paramCompileSourceSetResources, List paramList) {}
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.CompileSourceSetResources.doIncrementalTaskAction.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */