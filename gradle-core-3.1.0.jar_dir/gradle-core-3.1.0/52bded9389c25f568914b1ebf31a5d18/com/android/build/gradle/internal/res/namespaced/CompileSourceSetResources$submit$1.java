/*     */ package com.android.build.gradle.internal.res.namespaced;
/*     */ 
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.ide.common.res2.CompileResourceRequest;
/*     */ import com.android.repository.Revision;
/*     */ import com.android.sdklib.BuildToolInfo;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.workers.IsolationMode;
/*     */ import org.gradle.workers.WorkerConfiguration;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2={"<anonymous>", "", "it", "Lorg/gradle/workers/WorkerConfiguration;", "kotlin.jvm.PlatformType", "execute"})
/*     */ final class CompileSourceSetResources$submit$1<T>
/*     */   implements Action<WorkerConfiguration>
/*     */ {
/*     */   public final void execute(WorkerConfiguration it)
/*     */   {
/* 113 */     WorkerConfiguration tmp1_0 = it;Intrinsics.checkExpressionValueIsNotNull(tmp1_0, "it");tmp1_0.setIsolationMode(IsolationMode.NONE); Object[] 
/* 114 */       tmp20_17 = new Object[1]; AndroidBuilder 
/* 115 */       tmp33_30 = CompileSourceSetResources.access$getBuilder(this$0);Intrinsics.checkExpressionValueIsNotNull(tmp33_30, "builder"); BuildToolInfo tmp42_39 = tmp33_30.getBuildToolInfo();Intrinsics.checkExpressionValueIsNotNull(tmp42_39, "builder.buildToolInfo"); Revision tmp51_48 = tmp42_39.getRevision();Intrinsics.checkExpressionValueIsNotNull(tmp51_48, "builder.buildToolInfo.revision");tmp20_17[0] = new Aapt2CompileRunnable.Params(tmp51_48, 
/* 116 */       CollectionsKt.listOf($request), 
/* 117 */       this$0.getOutputDirectory());it.setParams(tmp20_17);
/*     */   }
/*     */   
/*     */   CompileSourceSetResources$submit$1(CompileSourceSetResources paramCompileSourceSetResources, CompileResourceRequest paramCompileResourceRequest) {}
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.CompileSourceSetResources.submit.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */