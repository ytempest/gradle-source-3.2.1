/*    */ package com.android.build.gradle.external.cmake;
/*    */ 
/*    */ import com.android.repository.Revision;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class Cmake
/*    */ {
/*    */   private final File cmakeInstallPath;
/*    */   private final Map<String, String> cmakeProcessEnvironment;
/*    */   
/*    */   public Cmake(File cmakeInstallPath)
/*    */   {
/* 30 */     this.cmakeInstallPath = cmakeInstallPath;
/* 31 */     cmakeProcessEnvironment = new ProcessBuilder(new String[0]).environment();
/*    */   }
/*    */   
/*    */   public Map<String, String> environment()
/*    */   {
/* 39 */     return cmakeProcessEnvironment;
/*    */   }
/*    */   
/*    */   public Revision getVersion()
/*    */     throws IOException
/*    */   {
/* 49 */     return CmakeUtils.getVersion(cmakeInstallPath);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.Cmake
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */