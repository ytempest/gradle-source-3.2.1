/*    */ package com.android.build.gradle.internal.ndk;
/*    */ 
/*    */ import com.android.build.gradle.internal.core.Abi;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class NdkR11StlSpecificationFactory
/*    */   extends DefaultStlSpecificationFactory
/*    */ {
/*    */   public StlSpecification create(Stl stl, String stlVersion, Abi abi)
/*    */   {
/* 31 */     switch (stl) {
/*    */     case SYSTEM: 
/*    */     case GNUSTL_SHARED: 
/*    */     case GNUSTL_STATIC: 
/*    */     case STLPORT_SHARED: 
/*    */     case STLPORT_STATIC: 
/*    */     case CPP_SHARED: 
/*    */     case CPP_STATIC: 
/* 39 */       return super.create(stl, stlVersion, abi);
/*    */     case GABIPP_SHARED: 
/*    */     case GABIPP_STATIC: 
/* 42 */       throw new RuntimeException("gabi++ is not available beginning with NDK r11.");
/*    */     }
/* 44 */     throw new RuntimeException("Unreachable.  Unknown STL: " + stl + ".");
/*    */   }
/*    */   
/*    */   protected List<String> getLibcxxIncludes(Abi abi)
/*    */   {
/* 52 */     return ImmutableList.of("llvm-libc++/libcxx/include", "llvm-libc++abi/libcxxabi/include", "../android/support/include");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ndk.NdkR11StlSpecificationFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */