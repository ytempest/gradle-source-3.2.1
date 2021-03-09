/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.builder.internal.aapt.v2.Aapt2DaemonImpl;
/*    */ import java.nio.file.Path;
/*    */ import java.nio.file.Paths;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\016\n\000\n\002\030\002\n\000\n\002\020\b\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2={"<anonymous>", "Lcom/android/builder/internal/aapt/v2/Aapt2DaemonImpl;", "displayId", "", "invoke"})
/*    */ final class Aapt2DaemonManagerService$registerAaptService$1$manager$1
/*    */   extends Lambda
/*    */   implements Function1<Integer, Aapt2DaemonImpl>
/*    */ {
/*    */   @NotNull
/*    */   public final Aapt2DaemonImpl invoke(int displayId)
/*    */   {
/* 74 */     Path tmp34_31 = Paths.get($aaptExecutablePath, new String[0]);Intrinsics.checkExpressionValueIsNotNull(tmp34_31, "Paths.get(aaptExecutablePath)");
/*    */     
/* 76 */     return new Aapt2DaemonImpl('#' + displayId, tmp34_31, Aapt2DaemonManagerService.access$getDaemonTimeouts$p(), this$0.$logger);
/*    */   }
/*    */   
/*    */   Aapt2DaemonManagerService$registerAaptService$1$manager$1(Aapt2DaemonManagerService.registerAaptService.1 param1, String paramString)
/*    */   {
/*    */     super(1);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.Aapt2DaemonManagerService.registerAaptService.1.manager.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */