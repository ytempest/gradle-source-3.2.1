/*    */ package com.android.build.gradle.external.cmake.server;
/*    */ 
/*    */ import com.android.build.gradle.external.cmake.CmakeUtils;
/*    */ import com.android.build.gradle.external.cmake.server.receiver.ServerReceiver;
/*    */ import com.android.repository.Revision;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class ServerFactory
/*    */ {
/*    */   public static Server create(File cmakeInstallPath, ServerReceiver serverReceiver)
/*    */     throws IOException
/*    */   {
/* 42 */     return create(CmakeUtils.getVersion(cmakeInstallPath), cmakeInstallPath, serverReceiver);
/*    */   }
/*    */   
/*    */   public static Server create(Revision version, File cmakeInstallPath, ServerReceiver serverReceiver)
/*    */   {
/* 59 */     if ((version.getMajor() >= 3) && (version.getMinor() >= 7)) {
/* 60 */       return new ServerProtocolV1(cmakeInstallPath, serverReceiver);
/*    */     }
/* 62 */     return null;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.server.ServerFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */