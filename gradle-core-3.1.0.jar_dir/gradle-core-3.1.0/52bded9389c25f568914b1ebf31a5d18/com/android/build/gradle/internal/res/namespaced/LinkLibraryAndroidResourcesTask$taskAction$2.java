/*     */ package com.android.build.gradle.internal.res.namespaced;
/*     */ 
/*     */ import com.android.builder.internal.aapt.AaptPackageConfig;
/*     */ import com.android.repository.Revision;
/*     */ import com.android.sdklib.BuildToolInfo;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.workers.IsolationMode;
/*     */ import org.gradle.workers.WorkerConfiguration;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2={"<anonymous>", "", "it", "Lorg/gradle/workers/WorkerConfiguration;", "kotlin.jvm.PlatformType", "execute"})
/*     */ final class LinkLibraryAndroidResourcesTask$taskAction$2<T>
/*     */   implements Action<WorkerConfiguration>
/*     */ {
/*     */   public final void execute(WorkerConfiguration it)
/*     */   {
/* 105 */     WorkerConfiguration tmp1_0 = it;Intrinsics.checkExpressionValueIsNotNull(tmp1_0, "it");tmp1_0.setIsolationMode(IsolationMode.NONE); Object[] 
/* 106 */       tmp20_17 = new Object[1]; BuildToolInfo tmp33_30 = LinkLibraryAndroidResourcesTask.access$getBuildTools(this$0);Intrinsics.checkExpressionValueIsNotNull(tmp33_30, "buildTools"); Revision tmp42_39 = tmp33_30.getRevision();Intrinsics.checkExpressionValueIsNotNull(tmp42_39, "buildTools.revision");tmp20_17[0] = new Aapt2LinkRunnable.Params(tmp42_39, $request);it.setParams(tmp20_17);
/*     */   }
/*     */   
/*     */   LinkLibraryAndroidResourcesTask$taskAction$2(LinkLibraryAndroidResourcesTask paramLinkLibraryAndroidResourcesTask, AaptPackageConfig paramAaptPackageConfig) {}
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.LinkLibraryAndroidResourcesTask.taskAction.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */