/*    */ package com.android.build.gradle.tasks.ir;
/*    */ 
/*    */ import com.android.ide.common.build.ApkInfo;
/*    */ import java.io.File;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function2;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\020\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\020\000\032\004\030\0010\0012\006\020\002\032\0020\0032\006\020\004\032\0020\001H\n¢\006\002\b\005"}, d2={"<anonymous>", "Ljava/io/File;", "apkData", "Lcom/android/ide/common/build/ApkInfo;", "processedResources", "invoke"})
/*    */ final class InstantRunMainApkResourcesBuilder$doFullTaskAction$1
/*    */   extends Lambda
/*    */   implements Function2<ApkInfo, File, File>
/*    */ {
/*    */   @Nullable
/*    */   public final File invoke(@NotNull ApkInfo apkData, @NotNull File processedResources)
/*    */   {
/* 77 */     Intrinsics.checkParameterIsNotNull(apkData, "apkData");Intrinsics.checkParameterIsNotNull(processedResources, "processedResources");return this$0.processSplit(apkData, processedResources);
/*    */   }
/*    */   
/*    */   InstantRunMainApkResourcesBuilder$doFullTaskAction$1(InstantRunMainApkResourcesBuilder paramInstantRunMainApkResourcesBuilder)
/*    */   {
/*    */     super(2);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ir.InstantRunMainApkResourcesBuilder.doFullTaskAction.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */