/*    */ package com.android.build.gradle.internal.api.dsl.model;
/*    */ 
/*    */ import com.android.build.api.dsl.ApiVersion;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000&\n\002\030\002\n\002\030\002\n\000\n\002\020\b\n\000\n\002\020\016\n\002\b\013\n\002\020\013\n\000\n\002\020\000\n\002\b\004\b\b\030\000 \0262\0020\001:\001\026B\027\022\006\020\002\032\0020\003\022\b\020\004\032\004\030\0010\005¢\006\002\020\006J\t\020\r\032\0020\003HÆ\003J\013\020\016\032\004\030\0010\005HÆ\003J\037\020\017\032\0020\0002\b\b\002\020\002\032\0020\0032\n\b\002\020\004\032\004\030\0010\005HÆ\001J\023\020\020\032\0020\0212\b\020\022\032\004\030\0010\023HÖ\003J\t\020\024\032\0020\003HÖ\001J\t\020\025\032\0020\005HÖ\001R\024\020\002\032\0020\003X\004¢\006\b\n\000\032\004\b\007\020\bR\024\020\t\032\0020\0058VX\004¢\006\006\032\004\b\n\020\013R\026\020\004\032\004\030\0010\005X\004¢\006\b\n\000\032\004\b\f\020\013¨\006\027"}, d2={"Lcom/android/build/gradle/internal/api/dsl/model/ApiVersionImpl;", "Lcom/android/build/api/dsl/ApiVersion;", "apiLevel", "", "codename", "", "(ILjava/lang/String;)V", "getApiLevel", "()Ljava/lang/Integer;", "apiString", "getApiString", "()Ljava/lang/String;", "getCodename", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "gradle-core"})
/*    */ public final class ApiVersionImpl
/*    */   implements ApiVersion
/*    */ {
/*    */   private final int apiLevel;
/*    */   @Nullable
/*    */   private final String codename;
/*    */   public static final Companion Companion = new Companion(null);
/*    */   
/*    */   @NotNull
/* 23 */   public Integer getApiLevel() { return Integer.valueOf(apiLevel); } public ApiVersionImpl(int apiLevel, @Nullable String codename) { this.apiLevel = apiLevel;this.codename = codename; } @Nullable
/* 24 */   public String getCodename() { return codename; }
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\036\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\000\n\002\020\016\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\003\032\0020\0042\006\020\005\032\0020\006J\016\020\003\032\0020\0042\006\020\007\032\0020\b¨\006\t"}, d2={"Lcom/android/build/gradle/internal/api/dsl/model/ApiVersionImpl$Companion;", "", "()V", "of", "Lcom/android/build/api/dsl/ApiVersion;", "apiLevel", "", "codename", "", "gradle-core"})
/*    */   public static final class Companion { @NotNull
/* 27 */     public final ApiVersion of(int apiLevel) { return (ApiVersion)new ApiVersionImpl(apiLevel, null); }
/*    */     @NotNull
/* 29 */     public final ApiVersion of(@NotNull String codename) { Intrinsics.checkParameterIsNotNull(codename, "codename");return (ApiVersion)new ApiVersionImpl(1, codename);
/*    */     } }
/*    */   
/*    */   @NotNull
/* 33 */   public String getApiString() { return "android-" + getApiLevel().intValue(); }
/*    */   
/*    */   public final int component1()
/*    */   {
/*    */     return getApiLevel().intValue();
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public final String component2()
/*    */   {
/*    */     return getCodename();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final ApiVersionImpl copy(int apiLevel, @Nullable String codename)
/*    */   {
/*    */     return new ApiVersionImpl(apiLevel, codename);
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/*    */     return "ApiVersionImpl(apiLevel=" + getApiLevel() + ", codename=" + getCodename() + ")";
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public int hashCode()
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokevirtual 31	com/android/build/gradle/internal/api/dsl/model/ApiVersionImpl:getApiLevel	()Ljava/lang/Integer;
/*    */     //   4: invokevirtual 37	java/lang/Integer:intValue	()I
/*    */     //   7: invokestatic 85	java/lang/Integer:hashCode	(I)I
/*    */     //   10: bipush 31
/*    */     //   12: imul
/*    */     //   13: aload_0
/*    */     //   14: invokevirtual 12	com/android/build/gradle/internal/api/dsl/model/ApiVersionImpl:getCodename	()Ljava/lang/String;
/*    */     //   17: dup
/*    */     //   18: ifnull +9 -> 27
/*    */     //   21: invokevirtual 87	java/lang/Object:hashCode	()I
/*    */     //   24: goto +5 -> 29
/*    */     //   27: pop
/*    */     //   28: iconst_0
/*    */     //   29: iadd
/*    */     //   30: ireturn
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject)
/*    */   {
/*    */     if (this != paramObject)
/*    */     {
/*    */       if ((paramObject instanceof ApiVersionImpl))
/*    */       {
/*    */         ApiVersionImpl localApiVersionImpl = (ApiVersionImpl)paramObject;
/*    */         if ((getApiLevel().intValue() == localApiVersionImpl.getApiLevel().intValue() ? 1 : 0) != 0) {
/*    */           if (!Intrinsics.areEqual(getCodename(), localApiVersionImpl.getCodename())) {}
/*    */         }
/*    */       }
/*    */     }
/*    */     else {
/*    */       return true;
/*    */     }
/*    */     return false;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.model.ApiVersionImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */