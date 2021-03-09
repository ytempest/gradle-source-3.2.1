/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.OutputScope;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.ide.common.build.ApkData;
/*     */ import java.io.File;
/*     */ import java.util.concurrent.Callable;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\b\n\000\n\002\030\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2={"<anonymous>", "Ljava/io/File;", "call"})
/*     */ final class AndroidZip$ConfigAction$execute$2<V>
/*     */   implements Callable<File>
/*     */ {
/*     */   @NotNull
/*     */   public final File call()
/*     */   {
/* 125 */     OutputScope tmp28_23 = AndroidZip.ConfigAction.access$getVariantScope$p(this$0).getOutputScope();Intrinsics.checkExpressionValueIsNotNull(tmp28_23, "variantScope\n           …             .outputScope"); ApkData tmp37_34 = tmp28_23.getMainSplit();Intrinsics.checkExpressionValueIsNotNull(tmp37_34, "variantScope\n           …               .mainSplit");
/*     */     
/* 128 */     return new File(AndroidZip.ConfigAction.access$getVariantScope$p(this$0).getAarLocation(), tmp37_34.getOutputFileName());
/*     */   }
/*     */   
/*     */   AndroidZip$ConfigAction$execute$2(AndroidZip.ConfigAction paramConfigAction) {}
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.AndroidZip.ConfigAction.execute.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */