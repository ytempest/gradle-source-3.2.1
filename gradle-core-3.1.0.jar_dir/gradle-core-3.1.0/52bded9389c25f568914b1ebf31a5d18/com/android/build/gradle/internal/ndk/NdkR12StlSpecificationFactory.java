/*    */ package com.android.build.gradle.internal.ndk;
/*    */ 
/*    */ import com.android.build.gradle.internal.core.Abi;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import com.google.common.collect.ImmutableList.Builder;
/*    */ import java.util.List;
/*    */ 
/*    */ public class NdkR12StlSpecificationFactory
/*    */   extends NdkR11StlSpecificationFactory
/*    */ {
/*    */   protected List<String> getLibcxxStaticLibs(Abi abi, boolean staticStl)
/*    */   {
/* 38 */     ImmutableList.Builder<String> builder = ImmutableList.builder();
/* 39 */     if (staticStl) {
/* 40 */       builder.add("libc++_static.a");
/* 41 */       builder.add("libc++abi.a");
/*    */     }
/*    */     
/* 44 */     builder.add("libandroid_support.a");
/*    */     
/* 46 */     if ((abi == Abi.ARMEABI) || (abi == Abi.ARMEABI_V7A)) {
/* 47 */       builder.add("libunwind.a");
/*    */     }
/*    */     
/* 51 */     if (abi == Abi.ARMEABI) {
/* 52 */       builder.add("libatomic.a");
/*    */     }
/*    */     
/* 55 */     return builder.build();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ndk.NdkR12StlSpecificationFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */