/*    */ package com.android.build.gradle.internal.dsl;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=2, d1={"\000\f\n\000\n\002\030\002\n\002\030\002\n\000\032\n\020\000\032\0020\001*\0020\002¨\006\003"}, d2={"convert", "Lcom/android/builder/internal/aapt/AaptOptions;", "Lcom/android/build/gradle/internal/dsl/AaptOptions;", "gradle-core"})
/*    */ public final class DslAdaptersKt
/*    */ {
/*    */   @NotNull
/*    */   public static final com.android.builder.internal.aapt.AaptOptions convert(@NotNull AaptOptions $receiver)
/*    */   {
/* 22 */     Intrinsics.checkParameterIsNotNull($receiver, "$receiver");return new com.android.builder.internal.aapt.AaptOptions($receiver.getNoCompress(), $receiver.getFailOnMissingConfigEntry(), $receiver.getAdditionalParameters());
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.DslAdaptersKt
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */