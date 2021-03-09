/*    */ package com.android.build.gradle.internal.errors;
/*    */ 
/*    */ import com.android.builder.model.SyncIssue;
/*    */ import kotlin.Metadata;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=2, d1={"\000\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\032\020\020\000\032\0020\0012\006\020\002\032\0020\003H\002¨\006\004"}, d2={"syncIssueKeyFrom", "Lcom/android/build/gradle/internal/errors/SyncIssueKey;", "syncIssue", "Lcom/android/builder/model/SyncIssue;", "gradle-core"})
/*    */ public final class SyncIssueHandlerImplKt
/*    */ {
/*    */   private static final SyncIssueKey syncIssueKeyFrom(SyncIssue syncIssue)
/*    */   {
/* 74 */     return new SyncIssueKey(syncIssue.getType(), syncIssue.getData());
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.errors.SyncIssueHandlerImplKt
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */