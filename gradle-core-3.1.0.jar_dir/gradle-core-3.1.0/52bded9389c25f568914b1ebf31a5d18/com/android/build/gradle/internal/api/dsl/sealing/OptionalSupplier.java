/*    */ package com.android.build.gradle.internal.api.dsl.sealing;
/*    */ 
/*    */ import com.android.build.api.dsl.Initializable;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function0;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000(\n\002\030\002\n\000\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\007\n\002\020\002\n\002\b\003\n\002\020\013\n\002\b\003\030\000*\016\b\000\020\001*\b\022\004\022\002H\0010\0022\0020\003B\023\022\f\020\004\032\b\022\004\022\0028\0000\005¢\006\002\020\006J\024\020\f\032\0020\r2\f\020\016\032\b\022\004\022\0028\0000\000J\023\020\017\032\0028\0002\006\020\020\032\0020\021¢\006\002\020\022J\006\020\023\032\0020\021R\023\020\007\032\004\030\0018\0008F¢\006\006\032\004\b\b\020\tR\024\020\004\032\b\022\004\022\0028\0000\005X\004¢\006\002\n\000R\022\020\n\032\004\030\0018\000X\016¢\006\004\n\002\020\013¨\006\024"}, d2={"Lcom/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier;", "T", "Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;", "", "instantiator", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "instance", "getInstance", "()Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;", "localInstance", "Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;", "copyFrom", "", "from", "get", "sealIt", "", "(Z)Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;", "hasInstance", "gradle-core"})
/*    */ public final class OptionalSupplier<T extends InitializableSealable<? super T>>
/*    */ {
/*    */   private T localInstance;
/*    */   private final Function0<T> instantiator;
/*    */   
/*    */   public OptionalSupplier(@NotNull Function0<? extends T> instantiator)
/*    */   {
/* 25 */     this.instantiator = instantiator;
/*    */   }
/*    */   
/*    */   public final void copyFrom(@NotNull OptionalSupplier<T> from)
/*    */   {
/* 41 */     Intrinsics.checkParameterIsNotNull(from, "from");InitializableSealable value = from.getInstance();
/*    */     
/* 43 */     if (value != null) {
/* 44 */       get(false).initWith((Initializable)value);
/*    */     } else {
/* 46 */       localInstance = ((InitializableSealable)null);
/*    */     }
/*    */   }
/*    */   
/*    */   @Nullable
/* 51 */   public final T getInstance() { return localInstance; }
/*    */   
/* 53 */   public final boolean hasInstance() { return localInstance != null; }
/*    */   
/*    */   /* Error */
/*    */   @NotNull
/*    */   public final T get(boolean sealIt)
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield 13	com/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier:localInstance	Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;
/*    */     //   4: ifnonnull +38 -> 42
/*    */     //   7: aload_0
/*    */     //   8: aload_0
/*    */     //   9: getfield 17	com/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier:instantiator	Lkotlin/jvm/functions/Function0;
/*    */     //   12: invokeinterface 23 1 0
/*    */     //   17: checkcast 25	com/android/build/gradle/internal/api/dsl/sealing/InitializableSealable
/*    */     //   20: putfield 13	com/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier:localInstance	Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;
/*    */     //   23: iload_1
/*    */     //   24: ifeq +18 -> 42
/*    */     //   27: aload_0
/*    */     //   28: getfield 13	com/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier:localInstance	Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;
/*    */     //   31: dup
/*    */     //   32: ifnull +9 -> 41
/*    */     //   35: invokevirtual 29	com/android/build/gradle/internal/api/dsl/sealing/InitializableSealable:seal	()V
/*    */     //   38: goto +4 -> 42
/*    */     //   41: pop
/*    */     //   42: aload_0
/*    */     //   43: getfield 13	com/android/build/gradle/internal/api/dsl/sealing/OptionalSupplier:localInstance	Lcom/android/build/gradle/internal/api/dsl/sealing/InitializableSealable;
/*    */     //   46: dup
/*    */     //   47: ifnonnull +6 -> 53
/*    */     //   50: invokestatic 34	kotlin/jvm/internal/Intrinsics:throwNpe	()V
/*    */     //   53: areturn
/*    */     // Line number table:
/*    */     //   Java source line #30	-> byte code offset #0
/*    */     //   Java source line #31	-> byte code offset #7
/*    */     //   Java source line #32	-> byte code offset #23
/*    */     //   Java source line #33	-> byte code offset #27
/*    */     //   Java source line #37	-> byte code offset #42
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	54	0	this	OptionalSupplier
/*    */     //   0	54	1	sealIt	boolean
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.sealing.OptionalSupplier
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */