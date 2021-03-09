/*    */ package com.android.build.gradle.internal.api.dsl.model;
/*    */ 
/*    */ import com.android.build.api.dsl.ApiVersion;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\036\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\000\n\002\020\016\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\003\032\0020\0042\006\020\005\032\0020\006J\016\020\003\032\0020\0042\006\020\007\032\0020\b¨\006\t"}, d2={"Lcom/android/build/gradle/internal/api/dsl/model/ApiVersionImpl$Companion;", "", "()V", "of", "Lcom/android/build/api/dsl/ApiVersion;", "apiLevel", "", "codename", "", "gradle-core"})
/*    */ public final class ApiVersionImpl$Companion
/*    */ {
/*    */   @NotNull
/* 27 */   public final ApiVersion of(int apiLevel) { return (ApiVersion)new ApiVersionImpl(apiLevel, null); }
/*    */   @NotNull
/* 29 */   public final ApiVersion of(@NotNull String codename) { Intrinsics.checkParameterIsNotNull(codename, "codename");return (ApiVersion)new ApiVersionImpl(1, codename);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.model.ApiVersionImpl.Companion
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */