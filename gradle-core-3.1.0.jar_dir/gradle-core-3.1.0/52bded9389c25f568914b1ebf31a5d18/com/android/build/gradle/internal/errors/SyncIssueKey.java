/*    */ package com.android.build.gradle.internal.errors;
/*    */ 
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000 \n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\000\n\002\020\016\n\002\b\005\n\002\020\013\n\002\b\004\b\b\030\0002\0020\001B\027\022\006\020\002\032\0020\003\022\b\020\004\032\004\030\0010\005¢\006\002\020\006J\t\020\007\032\0020\003HÂ\003J\013\020\b\032\004\030\0010\005HÂ\003J\037\020\t\032\0020\0002\b\b\002\020\002\032\0020\0032\n\b\002\020\004\032\004\030\0010\005HÆ\001J\023\020\n\032\0020\0132\b\020\f\032\004\030\0010\001HÖ\003J\t\020\r\032\0020\003HÖ\001J\b\020\016\032\0020\005H\026R\020\020\004\032\004\030\0010\005X\004¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\017"}, d2={"Lcom/android/build/gradle/internal/errors/SyncIssueKey;", "", "type", "", "data", "", "(ILjava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "gradle-core"})
/*    */ public final class SyncIssueKey
/*    */ {
/*    */   private final int type;
/*    */   private final String data;
/*    */   
/*    */   public boolean equals(Object paramObject)
/*    */   {
/*    */     if (this != paramObject)
/*    */     {
/*    */       if ((paramObject instanceof SyncIssueKey))
/*    */       {
/*    */         SyncIssueKey localSyncIssueKey = (SyncIssueKey)paramObject;
/*    */         if ((type == type ? 1 : 0) != 0) {
/*    */           if (!Intrinsics.areEqual(data, data)) {}
/*    */         }
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
/*    */     //   1: getfield 18	com/android/build/gradle/internal/errors/SyncIssueKey:type	I
/*    */     //   4: invokestatic 67	java/lang/Integer:hashCode	(I)I
/*    */     //   7: bipush 31
/*    */     //   9: imul
/*    */     //   10: aload_0
/*    */     //   11: getfield 29	com/android/build/gradle/internal/errors/SyncIssueKey:data	Ljava/lang/String;
/*    */     //   14: dup
/*    */     //   15: ifnull +9 -> 24
/*    */     //   18: invokevirtual 69	java/lang/Object:hashCode	()I
/*    */     //   21: goto +5 -> 26
/*    */     //   24: pop
/*    */     //   25: iconst_0
/*    */     //   26: iadd
/*    */     //   27: ireturn
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final SyncIssueKey copy(int type, @Nullable String data)
/*    */   {
/*    */     return new SyncIssueKey(type, data);
/*    */   }
/*    */   
/*    */   private final String component2()
/*    */   {
/*    */     return data;
/*    */   }
/*    */   
/*    */   private final int component1()
/*    */   {
/*    */     return type;
/*    */   }
/*    */   
/*    */   public SyncIssueKey(int type, @Nullable String data)
/*    */   {
/* 78 */     this.type = type;this.data = data;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public String toString()
/*    */   {
/* 86 */     String tmp25_22 = MoreObjects.toStringHelper(this).add("type", type).add("data", data).toString();Intrinsics.checkExpressionValueIsNotNull(tmp25_22, "MoreObjects.toStringHelp…              .toString()");return tmp25_22;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.errors.SyncIssueKey
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */