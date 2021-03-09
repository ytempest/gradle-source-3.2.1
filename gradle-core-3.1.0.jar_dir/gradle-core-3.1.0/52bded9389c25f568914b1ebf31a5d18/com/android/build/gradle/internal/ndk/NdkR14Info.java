/*    */ package com.android.build.gradle.internal.ndk;
/*    */ 
/*    */ import com.android.build.gradle.internal.core.Abi;
/*    */ import com.android.build.gradle.internal.core.Toolchain;
/*    */ import com.google.common.base.MoreObjects;
/*    */ import java.io.File;
/*    */ 
/*    */ public class NdkR14Info
/*    */   extends DefaultNdkInfo
/*    */ {
/*    */   public NdkR14Info(File root)
/*    */   {
/* 31 */     super(root);
/*    */   }
/*    */   
/*    */   protected Abi getToolchainAbi(Abi abi)
/*    */   {
/* 37 */     if (abi == Abi.MIPS) {
/* 38 */       return Abi.MIPS64;
/*    */     }
/* 40 */     return abi;
/*    */   }
/*    */   
/*    */   public StlNativeToolSpecification getStlNativeToolSpecification(Stl stl, String stlVersion, Abi abi)
/*    */   {
/* 49 */     StlSpecification spec = new NdkR14StlSpecificationFactory().create(stl, 
/*    */     
/* 51 */       (String)MoreObjects.firstNonNull(stlVersion, 
/*    */       
/* 53 */       getDefaultToolchainVersion(Toolchain.GCC, abi)), abi);
/*    */     
/* 55 */     return new DefaultStlNativeToolSpecification(this, spec, stl);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ndk.NdkR14Info
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */