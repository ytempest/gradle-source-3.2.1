/*    */ package com.android.build.gradle.internal.ndk;
/*    */ 
/*    */ import com.android.build.gradle.internal.core.Abi;
/*    */ import com.android.build.gradle.internal.core.Toolchain;
/*    */ import com.google.common.base.MoreObjects;
/*    */ import java.io.File;
/*    */ 
/*    */ public class NdkR11Info
/*    */   extends DefaultNdkInfo
/*    */ {
/*    */   public NdkR11Info(File root)
/*    */   {
/* 31 */     super(root);
/*    */   }
/*    */   
/*    */   public StlNativeToolSpecification getStlNativeToolSpecification(Stl stl, String stlVersion, Abi abi)
/*    */   {
/* 42 */     StlSpecification spec = new NdkR11StlSpecificationFactory().create(stl, 
/*    */     
/* 44 */       (String)MoreObjects.firstNonNull(stlVersion, 
/* 45 */       getDefaultToolchainVersion(Toolchain.GCC, abi)), abi);
/*    */     
/* 47 */     return new DefaultStlNativeToolSpecification(this, spec, stl);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ndk.NdkR11Info
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */