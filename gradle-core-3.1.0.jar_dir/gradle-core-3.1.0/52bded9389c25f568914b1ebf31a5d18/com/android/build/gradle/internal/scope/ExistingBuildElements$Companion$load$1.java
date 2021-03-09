/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\016\n\000\n\002\020\013\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2={"<anonymous>", "", "it", "Lcom/android/build/gradle/internal/scope/BuildOutput;", "invoke"})
/*     */ final class ExistingBuildElements$Companion$load$1
/*     */   extends Lambda
/*     */   implements Function1<BuildOutput, Boolean>
/*     */ {
/*     */   public final boolean invoke(@NotNull BuildOutput it)
/*     */   {
/* 135 */     Intrinsics.checkParameterIsNotNull(it, "it");return ($outputType == null) || (Intrinsics.areEqual(it.getType(), $outputType));
/*     */   }
/*     */   
/*     */   ExistingBuildElements$Companion$load$1(TaskOutputHolder.OutputType paramOutputType)
/*     */   {
/*     */     super(1);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.ExistingBuildElements.Companion.load.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */