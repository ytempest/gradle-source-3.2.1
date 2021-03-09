/*    */ package com.android.build.gradle.internal.cxx.stripping;
/*    */ 
/*    */ import com.android.build.gradle.internal.core.Abi;
/*    */ import com.android.build.gradle.internal.ndk.NdkHandler;
/*    */ import java.io.File;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ import kotlin.Metadata;
/*    */ import kotlin._Assertions;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=2, d1={"\000\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\032\016\020\000\032\0020\0012\006\020\002\032\0020\003¨\006\004"}, d2={"createSymbolStripExecutableFinder", "Lcom/android/build/gradle/internal/cxx/stripping/SymbolStripExecutableFinder;", "ndkHandler", "Lcom/android/build/gradle/internal/ndk/NdkHandler;", "gradle-core"})
/*    */ public final class SymbolStripExecutableFinderKt
/*    */ {
/*    */   @NotNull
/*    */   public static final SymbolStripExecutableFinder createSymbolStripExecutableFinder(@NotNull NdkHandler ndkHandler)
/*    */   {
/* 60 */     Intrinsics.checkParameterIsNotNull(ndkHandler, "ndkHandler");boolean bool = ndkHandler.isConfigured(); if ((_Assertions.ENABLED) && (!bool)) { String str = "Assertion failed";throw ((Throwable)new AssertionError(str)); }
/* 61 */     Map stripExecutables = (Map)new LinkedHashMap();
/* 62 */     Map localMap1; Abi localAbi1; File localFile; for (Iterator localIterator = ndkHandler.getSupportedAbis().iterator(); localIterator.hasNext(); 
/* 63 */         localMap1.put(localAbi1, localFile))
/*    */     {
/* 62 */       Abi abi = (Abi)localIterator.next();
/* 63 */       localMap1 = stripExecutables; Abi tmp80_79 = abi;Intrinsics.checkExpressionValueIsNotNull(tmp80_79, "abi");localAbi1 = tmp80_79; File tmp93_90 = ndkHandler.getStripExecutable(abi);Intrinsics.checkExpressionValueIsNotNull(tmp93_90, "ndkHandler.getStripExecutable(abi)");localFile = tmp93_90;
/*    */     }
/* 65 */     return new SymbolStripExecutableFinder(stripExecutables);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.cxx.stripping.SymbolStripExecutableFinderKt
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */