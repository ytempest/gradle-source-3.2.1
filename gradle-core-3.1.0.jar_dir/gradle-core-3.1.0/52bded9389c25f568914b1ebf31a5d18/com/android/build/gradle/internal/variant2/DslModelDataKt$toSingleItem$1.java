/*     */ package com.android.build.gradle.internal.variant2;
/*     */ 
/*     */ import java.util.function.BinaryOperator;
/*     */ import kotlin.Metadata;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\n\n\000\n\002\020\001\n\002\b\005\020\000\032\0020\001\"\004\b\000\020\0022\006\020\003\032\002H\0022\006\020\004\032\002H\002H\n¢\006\004\b\005\020\006"}, d2={"<anonymous>", "", "T", "name1", "<anonymous parameter 1>", "apply", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Void;"})
/*     */ final class DslModelDataKt$toSingleItem$1<T>
/*     */   implements BinaryOperator<T>
/*     */ {
/*     */   public static final 1 INSTANCE = new 1();
/*     */   
/*     */   @NotNull
/*     */   public final Void apply(T name1, T $noName_1)
/*     */   {
/* 525 */     throw ((Throwable)new IllegalArgumentException("Duplicate objects with name: " + name1));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.DslModelDataKt.toSingleItem.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */