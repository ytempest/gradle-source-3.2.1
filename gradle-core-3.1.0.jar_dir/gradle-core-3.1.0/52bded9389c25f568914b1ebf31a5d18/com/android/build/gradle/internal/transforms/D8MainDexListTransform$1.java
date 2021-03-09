/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import java.io.File;
/*     */ import java.nio.file.Path;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\016\n\000\n\002\020 \n\002\030\002\n\002\b\002\020\000\032\020\022\f\022\n \003*\004\030\0010\0020\0020\001H\n¢\006\002\b\004"}, d2={"<anonymous>", "", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "get"})
/*     */ final class D8MainDexListTransform$1<T>
/*     */   implements Supplier<List<? extends Path>>
/*     */ {
/*     */   @NotNull
/*     */   public final List<Path> get()
/*     */   {
/*  60 */     GlobalScope tmp9_4 = $variantScope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp9_4, "variantScope\n           …             .globalScope"); List 
/*     */     
/*  63 */       tmp22_19 = tmp9_4.getAndroidBuilder().getBootClasspath(true);Intrinsics.checkExpressionValueIsNotNull(tmp22_19, "variantScope\n           …  .getBootClasspath(true)");Iterable localIterable1 = (Iterable)tmp22_19;
/*     */     
/*     */     int $i$f$map;
/*     */     
/*     */     Iterable $receiver$iv;
/*     */     
/* 132 */     Iterable localIterable2 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 133 */     int $i$f$mapTo; Iterable $receiver$iv$iv; Collection localCollection1; Path localPath; for (Iterator localIterator = $receiver$iv$iv.iterator(); localIterator.hasNext(); localCollection1.add(localPath))
/*     */     {
/* 133 */       Object item$iv$iv = localIterator.next();
/* 134 */       File localFile1 = (File)item$iv$iv;localCollection1 = destination$iv$iv;
/*     */       int $i$a$1$map;
/*     */       File it;
/*  64 */       localPath = it.toPath(); } return 
/*     */     
/* 135 */       (List)destination$iv$iv;
/*     */   }
/*     */   
/*     */   D8MainDexListTransform$1(VariantScope paramVariantScope) {}
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.D8MainDexListTransform.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */