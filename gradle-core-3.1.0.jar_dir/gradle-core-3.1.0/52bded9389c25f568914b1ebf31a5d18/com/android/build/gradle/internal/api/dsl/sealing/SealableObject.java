/*    */ package com.android.build.gradle.internal.api.dsl.sealing;
/*    */ 
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import com.android.builder.errors.EvalIssueReporter.Type;
/*    */ import kotlin.Metadata;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000(\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\004\n\002\020\013\n\002\b\004\n\002\020\002\n\000\b&\030\0002\0020\001B\017\b\026\022\006\020\002\032\0020\003¢\006\002\020\004B\027\022\006\020\002\032\0020\003\022\b\020\005\032\004\030\0010\006¢\006\002\020\007J\006\020\f\032\0020\013J\b\020\r\032\0020\006H\002J\006\020\016\032\0020\013J\b\020\017\032\0020\020H\026R\024\020\002\032\0020\003X\004¢\006\b\n\000\032\004\b\b\020\tR\020\020\005\032\004\030\0010\006X\004¢\006\002\n\000R\016\020\n\032\0020\013X\016¢\006\002\n\000¨\006\021"}, d2={"Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/gradle/internal/api/dsl/sealing/Sealable;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "name", "", "(Lcom/android/builder/errors/EvalIssueReporter;Ljava/lang/String;)V", "getIssueReporter", "()Lcom/android/builder/errors/EvalIssueReporter;", "sealed", "", "checkSeal", "computeName", "isSealed", "seal", "", "gradle-core"})
/*    */ public abstract class SealableObject
/*    */   implements Sealable
/*    */ {
/*    */   private boolean sealed;
/*    */   @NotNull
/*    */   private final EvalIssueReporter issueReporter;
/*    */   private final String name;
/*    */   
/*    */   public SealableObject(@NotNull EvalIssueReporter issueReporter, @Nullable String name)
/*    */   {
/* 23 */     this.issueReporter = issueReporter;this.name = name; } @NotNull
/* 24 */   protected final EvalIssueReporter getIssueReporter() { return issueReporter; }
/*    */   
/*    */   public SealableObject(@NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 28 */     this(issueReporter, null);
/*    */   }
/*    */   
/*    */   public void seal()
/*    */   {
/* 33 */     if (sealed)
/*    */     {
/* 35 */       String className = getClass().getName();
/* 36 */       String itemNameStr = computeName();
/* 37 */       issueReporter.reportError(
/* 38 */         EvalIssueReporter.Type.GENERIC, 
/* 39 */         "Attempting to seal object" + itemNameStr + " of type " + className + " after it's been sealed.");
/*    */     }
/*    */     
/* 42 */     sealed = true;
/*    */   }
/*    */   
/* 45 */   public final boolean isSealed() { return sealed; }
/*    */   
/*    */   public final boolean checkSeal() {
/* 48 */     if (sealed)
/*    */     {
/* 50 */       String className = getClass().getName();
/* 51 */       String itemNameStr = computeName();
/*    */       
/* 53 */       issueReporter.reportError(
/* 54 */         EvalIssueReporter.Type.GENERIC, 
/* 55 */         "Attempting to modify object" + itemNameStr + " of type " + className + " after it's been sealed.", 
/* 56 */         className);
/*    */       
/* 58 */       return false;
/*    */     }
/*    */     
/* 61 */     return true;
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   private final String computeName()
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield 75	com/android/build/gradle/internal/api/dsl/sealing/SealableObject:name	Ljava/lang/String;
/*    */     //   4: dup
/*    */     //   5: ifnull +6 -> 11
/*    */     //   8: goto +19 -> 27
/*    */     //   11: pop
/*    */     //   12: aload_0
/*    */     //   13: instanceof 77
/*    */     //   16: ifeq +10 -> 26
/*    */     //   19: aload_0
/*    */     //   20: getfield 75	com/android/build/gradle/internal/api/dsl/sealing/SealableObject:name	Ljava/lang/String;
/*    */     //   23: goto +4 -> 27
/*    */     //   26: aconst_null
/*    */     //   27: astore_1
/*    */     //   28: aload_1
/*    */     //   29: ifnull +30 -> 59
/*    */     //   32: new 37	java/lang/StringBuilder
/*    */     //   35: dup
/*    */     //   36: invokespecial 40	java/lang/StringBuilder:<init>	()V
/*    */     //   39: ldc 79
/*    */     //   41: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   44: aload_1
/*    */     //   45: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   48: bipush 39
/*    */     //   50: invokevirtual 82	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
/*    */     //   53: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*    */     //   56: goto +5 -> 61
/*    */     //   59: ldc 84
/*    */     //   61: areturn
/*    */     // Line number table:
/*    */     //   Java source line #65	-> byte code offset #0
/*    */     //   Java source line #66	-> byte code offset #28
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	62	0	this	SealableObject
/*    */     //   28	34	1	itemName	String
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.sealing.SealableObject
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */