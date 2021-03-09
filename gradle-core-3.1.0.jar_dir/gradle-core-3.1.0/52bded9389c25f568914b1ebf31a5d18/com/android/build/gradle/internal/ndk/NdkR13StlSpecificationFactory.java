/*    */ package com.android.build.gradle.internal.ndk;
/*    */ 
/*    */ import com.android.build.gradle.internal.core.Abi;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class NdkR13StlSpecificationFactory
/*    */   extends NdkR12StlSpecificationFactory
/*    */ {
/*    */   protected List<String> getLibcxxIncludes(Abi abi)
/*    */   {
/* 34 */     return ImmutableList.of("llvm-libc++/include", "llvm-libc++abi/include", "../android/support/include");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ndk.NdkR13StlSpecificationFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */