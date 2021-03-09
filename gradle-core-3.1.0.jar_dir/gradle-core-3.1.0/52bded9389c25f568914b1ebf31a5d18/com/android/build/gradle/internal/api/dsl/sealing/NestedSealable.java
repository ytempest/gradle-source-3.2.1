/*    */ package com.android.build.gradle.internal.api.dsl.sealing;
/*    */ 
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.lang.ref.WeakReference;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000$\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020!\n\002\030\002\n\002\b\005\n\002\020\002\n\000\b\026\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\037\020\b\032\002H\t\"\b\b\000\020\t*\0020\0012\006\020\n\032\002H\tH\004¢\006\002\020\013J\b\020\f\032\0020\rH\026R\034\020\005\032\020\022\n\022\b\022\004\022\0020\0010\007\030\0010\006X\016¢\006\002\n\000¨\006\016"}, d2={"Lcom/android/build/gradle/internal/api/dsl/sealing/NestedSealable;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "toBeSealed", "", "Ljava/lang/ref/WeakReference;", "handleSealableSubItem", "T", "sealableObject", "(Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;)Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "seal", "", "gradle-core"})
/*    */ public class NestedSealable
/*    */   extends SealableObject
/*    */ {
/*    */   private List<WeakReference<SealableObject>> toBeSealed;
/*    */   
/*    */   public NestedSealable(@NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 28 */     super(issueReporter);
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public void seal()
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokespecial 26	com/android/build/gradle/internal/api/dsl/sealing/SealableObject:seal	()V
/*    */     //   4: aload_0
/*    */     //   5: getfield 28	com/android/build/gradle/internal/api/dsl/sealing/NestedSealable:toBeSealed	Ljava/util/List;
/*    */     //   8: dup
/*    */     //   9: ifnull +62 -> 71
/*    */     //   12: checkcast 52	java/lang/Iterable
/*    */     //   15: astore_1
/*    */     //   16: aload_1
/*    */     //   17: invokeinterface 56 1 0
/*    */     //   22: astore_2
/*    */     //   23: aload_2
/*    */     //   24: invokeinterface 61 1 0
/*    */     //   29: ifeq +39 -> 68
/*    */     //   32: aload_2
/*    */     //   33: invokeinterface 65 1 0
/*    */     //   38: astore_3
/*    */     //   39: aload_3
/*    */     //   40: checkcast 40	java/lang/ref/WeakReference
/*    */     //   43: astore 4
/*    */     //   45: aload 4
/*    */     //   47: invokevirtual 68	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
/*    */     //   50: checkcast 4	com/android/build/gradle/internal/api/dsl/sealing/SealableObject
/*    */     //   53: dup
/*    */     //   54: ifnull +9 -> 63
/*    */     //   57: invokevirtual 26	com/android/build/gradle/internal/api/dsl/sealing/SealableObject:seal	()V
/*    */     //   60: goto +4 -> 64
/*    */     //   63: pop
/*    */     //   64: nop
/*    */     //   65: goto -42 -> 23
/*    */     //   68: goto +4 -> 72
/*    */     //   71: pop
/*    */     //   72: aload_0
/*    */     //   73: aconst_null
/*    */     //   74: checkcast 35	java/util/List
/*    */     //   77: putfield 28	com/android/build/gradle/internal/api/dsl/sealing/NestedSealable:toBeSealed	Ljava/util/List;
/*    */     //   80: return
/*    */     // Line number table:
/*    */     //   Java source line #51	-> byte code offset #0
/*    */     //   Java source line #55	-> byte code offset #4
/*    */     //   Java source line #60	-> byte code offset #16
/*    */     //   Java source line #55	-> byte code offset #45
/*    */     //   Java source line #61	-> byte code offset #68
/*    */     //   Java source line #56	-> byte code offset #72
/*    */     //   Java source line #57	-> byte code offset #80
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	81	0	this	NestedSealable
/*    */     //   16	52	1	$receiver$iv	Iterable
/*    */     //   39	26	3	element$iv	Object
/*    */     //   45	19	4	it	WeakReference
/*    */     //   45	19	5	$i$a$1$forEach	int
/*    */     //   16	52	6	$i$f$forEach	int
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   protected final <T extends SealableObject> T handleSealableSubItem(@NotNull T sealableObject)
/*    */   {
/* 34 */     Intrinsics.checkParameterIsNotNull(sealableObject, "sealableObject"); if (isSealed()) {
/* 35 */       sealableObject.seal();
/*    */     }
/*    */     else {
/* 38 */       if (toBeSealed == null) {
/* 39 */         toBeSealed = ((List)new ArrayList());
/*    */       }
/*    */       
/* 44 */       List tmp45_42 = toBeSealed;
/*    */       
/* 44 */       if (tmp45_42 == null) Intrinsics.throwNpe(); tmp45_42.add(new WeakReference(sealableObject));
/*    */     }
/*    */     
/* 47 */     return sealableObject;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.sealing.NestedSealable
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */