/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.collections.CollectionsKt;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ import org.gradle.workers.IsolationMode;
/*    */ import org.gradle.workers.WorkerConfiguration;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2={"<anonymous>", "", "it", "Lorg/gradle/workers/WorkerConfiguration;", "kotlin.jvm.PlatformType", "execute"})
/*    */ final class JarRClassTask$jar$1<T>
/*    */   implements Action<WorkerConfiguration>
/*    */ {
/*    */   public final void execute(WorkerConfiguration it)
/*    */   {
/* 43 */     WorkerConfiguration tmp1_0 = it;Intrinsics.checkExpressionValueIsNotNull(tmp1_0, "it");tmp1_0.setIsolationMode(IsolationMode.NONE);
/* 44 */     it.setParams(new Object[] {
/* 45 */       new JarRequest(
/* 46 */       this$0.getRClassJar(), 
/* 47 */       CollectionsKt.listOf(this$0.getRClassClasses().getSingleFile()), null, null, 12, null) });
/*    */   }
/*    */   
/*    */   JarRClassTask$jar$1(JarRClassTask paramJarRClassTask) {}
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.JarRClassTask.jar.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */