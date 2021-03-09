/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.build.gradle.internal.workeractions.WorkerActionServiceRegistry.ServiceKey;
/*    */ import com.android.builder.internal.aapt.v2.Aapt2DaemonManager;
/*    */ import com.android.repository.Revision;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0006\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\005\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\b\n\000\n\002\020\016\n\000\b\b\030\0002\b\022\004\022\0020\0020\001B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\t\020\f\032\0020\004HÆ\003J\023\020\r\032\0020\0002\b\b\002\020\003\032\0020\004HÆ\001J\023\020\016\032\0020\0172\b\020\020\032\004\030\0010\021HÖ\003J\t\020\022\032\0020\023HÖ\001J\t\020\024\032\0020\025HÖ\001R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\006\020\007R\032\020\b\032\b\022\004\022\0020\0020\t8VX\004¢\006\006\032\004\b\n\020\013¨\006\026"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/AaptServiceKey;", "Lcom/android/build/gradle/internal/workeractions/WorkerActionServiceRegistry$ServiceKey;", "Lcom/android/builder/internal/aapt/v2/Aapt2DaemonManager;", "aapt2Version", "Lcom/android/repository/Revision;", "(Lcom/android/repository/Revision;)V", "getAapt2Version", "()Lcom/android/repository/Revision;", "type", "Ljava/lang/Class;", "getType", "()Ljava/lang/Class;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "gradle-core"})
/*    */ final class AaptServiceKey
/*    */   implements WorkerActionServiceRegistry.ServiceKey<Aapt2DaemonManager>
/*    */ {
/*    */   @NotNull
/*    */   private final Revision aapt2Version;
/*    */   
/*    */   public boolean equals(Object paramObject)
/*    */   {
/*    */     if (this != paramObject)
/*    */     {
/*    */       if ((paramObject instanceof AaptServiceKey))
/*    */       {
/*    */         AaptServiceKey localAaptServiceKey = (AaptServiceKey)paramObject;
/*    */         if (!Intrinsics.areEqual(aapt2Version, aapt2Version)) {}
/*    */       }
/*    */     }
/*    */     else {
/*    */       return true;
/*    */     }
/*    */     return false;
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public int hashCode()
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield 20	com/android/build/gradle/internal/res/namespaced/AaptServiceKey:aapt2Version	Lcom/android/repository/Revision;
/*    */     //   4: dup
/*    */     //   5: ifnull +9 -> 14
/*    */     //   8: invokevirtual 63	java/lang/Object:hashCode	()I
/*    */     //   11: goto +5 -> 16
/*    */     //   14: pop
/*    */     //   15: iconst_0
/*    */     //   16: ireturn
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/*    */     return "AaptServiceKey(aapt2Version=" + aapt2Version + ")";
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final AaptServiceKey copy(@NotNull Revision aapt2Version)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(aapt2Version, "aapt2Version");
/*    */     return new AaptServiceKey(aapt2Version);
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final Revision component1()
/*    */   {
/*    */     return aapt2Version;
/*    */   }
/*    */   
/* 43 */   public AaptServiceKey(@NotNull Revision aapt2Version) { this.aapt2Version = aapt2Version; } @NotNull
/* 43 */   public final Revision getAapt2Version() { return aapt2Version; }
/*    */   @NotNull
/* 45 */   public Class<Aapt2DaemonManager> getType() { return Aapt2DaemonManager.class; }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.AaptServiceKey
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */