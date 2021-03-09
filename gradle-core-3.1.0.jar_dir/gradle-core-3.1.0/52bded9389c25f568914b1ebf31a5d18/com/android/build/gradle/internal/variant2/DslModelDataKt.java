/*     */ package com.android.build.gradle.internal.variant2;
/*     */ 
/*     */ import com.android.builder.core.VariantType;
/*     */ import com.android.utils.StringHelper;
/*     */ import java.util.function.BinaryOperator;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=2, d1={"\000\030\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\032\030\020\000\032\0020\0012\006\020\002\032\0020\0012\006\020\003\032\0020\004H\002\032\024\020\005\032\b\022\004\022\002H\0070\006\"\004\b\000\020\007H\002¨\006\b"}, d2={"computeSourceSetName", "", "name", "variantType", "Lcom/android/builder/core/VariantType;", "toSingleItem", "Ljava/util/function/BinaryOperator;", "T", "gradle-core"})
/*     */ public final class DslModelDataKt
/*     */ {
/*     */   private static final String computeSourceSetName(String name, VariantType variantType)
/*     */   {
/* 479 */     if (Intrinsics.areEqual(name, "main")) {
/* 480 */       String tmp13_10 = variantType.getPrefix();Intrinsics.checkExpressionValueIsNotNull(tmp13_10, "variantType.prefix");CharSequence localCharSequence = (CharSequence)tmp13_10; if ((localCharSequence.length() == 0 ? 1 : 0) != 0) {
/* 481 */         return name;
/*     */       }
/* 483 */       String tmp46_43 = variantType.getPrefix();Intrinsics.checkExpressionValueIsNotNull(tmp46_43, "variantType.prefix");return tmp46_43;
/*     */     }
/*     */     
/* 486 */     Object newName = name; String 
/* 487 */       tmp60_57 = variantType.getSuffix();Intrinsics.checkExpressionValueIsNotNull(tmp60_57, "variantType.suffix"); String str; if (StringsKt.endsWith$default((String)newName, tmp60_57, false, 2, null)) {
/* 488 */       localObject1 = newName;int i = 0;int j = ((String)newName).length() - variantType.getSuffix().length(); Object tmp95_94 = localObject1; if (tmp95_94 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); String tmp116_113 = tmp95_94.substring(i, j);Intrinsics.checkExpressionValueIsNotNull(tmp116_113, "(this as java.lang.Strin…ing(startIndex, endIndex)");str = tmp116_113;newName = str;
/*     */     }
/*     */     
/* 491 */     String tmp131_128 = variantType.getPrefix();Intrinsics.checkExpressionValueIsNotNull(tmp131_128, "variantType.prefix");Object localObject1 = (CharSequence)tmp131_128; if ((((CharSequence)localObject1).length() == 0 ? 1 : 0) == 0) {
/* 492 */       localObject1 = new StringBuilder();Object $receiver = localObject1;
/* 493 */       int $i$a$1$buildString; ((StringBuilder)$receiver).append(variantType.getPrefix());
/* 494 */       StringHelper.appendCapitalized((StringBuilder)$receiver, (String)newName); String tmp190_187 = ((StringBuilder)localObject1).toString();Intrinsics.checkExpressionValueIsNotNull(tmp190_187, "StringBuilder().apply(builderAction).toString()");str = tmp190_187;newName = str;
/*     */     }
/*     */     
/* 498 */     return (String)newName;
/*     */   }
/*     */   
/*     */   private static final <T> BinaryOperator<T> toSingleItem()
/*     */   {
/* 525 */     return (BinaryOperator)toSingleItem.1.INSTANCE;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.DslModelDataKt
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */