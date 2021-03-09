/*    */ package com.android.build.gradle.internal.api.dsl.sealing;
/*    */ 
/*    */ import com.android.build.api.dsl.Initializable;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import kotlin.Metadata;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\030\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\b&\030\000*\020\b\000\020\001 \000*\b\022\004\022\002H\0010\0022\0020\0032\b\022\004\022\002H\0010\002B\r\022\006\020\004\032\0020\005¢\006\002\020\006¨\006\007"}, d2={"Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;", "T", "Lcom/android/build/api/dsl/Initializable;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "gradle-core"})
/*    */ public abstract class InitializableSealable<T extends Initializable<? super T>>
/*    */   extends SealableObject
/*    */   implements Initializable<T>
/*    */ {
/*    */   public InitializableSealable(@NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 57 */     super(issueReporter);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.sealing.InitializableSealable
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */