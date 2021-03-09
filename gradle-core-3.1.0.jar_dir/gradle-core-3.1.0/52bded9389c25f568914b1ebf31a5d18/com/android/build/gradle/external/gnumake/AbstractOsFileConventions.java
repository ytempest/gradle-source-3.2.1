/*    */ package com.android.build.gradle.external.gnumake;
/*    */ 
/*    */ import com.android.SdkConstants;
/*    */ import java.io.File;
/*    */ 
/*    */ abstract class AbstractOsFileConventions
/*    */   implements OsFileConventions
/*    */ {
/*    */   public static OsFileConventions createForCurrentHost()
/*    */   {
/* 34 */     return 2 == SdkConstants.currentPlatform() ? new WindowsFileConventions() : new PosixFileConventions();
/*    */   }
/*    */   
/*    */   public boolean isPathAbsolute(String file)
/*    */   {
/* 41 */     return new File(file).isAbsolute();
/*    */   }
/*    */   
/*    */   public String getFileParent(String filename)
/*    */   {
/* 47 */     return new File(filename).getParent();
/*    */   }
/*    */   
/*    */   public String getFileName(String filename)
/*    */   {
/* 53 */     return new File(filename).getName();
/*    */   }
/*    */   
/*    */   public File toFile(String filename)
/*    */   {
/* 59 */     return new File(filename);
/*    */   }
/*    */   
/*    */   public File toFile(File parent, String child)
/*    */   {
/* 65 */     return new File(parent, child);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.gnumake.AbstractOsFileConventions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */