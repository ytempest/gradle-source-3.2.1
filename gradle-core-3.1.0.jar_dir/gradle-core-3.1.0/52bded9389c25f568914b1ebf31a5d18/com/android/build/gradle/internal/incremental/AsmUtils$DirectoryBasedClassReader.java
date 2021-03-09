/*    */ package com.android.build.gradle.internal.incremental;
/*    */ 
/*    */ import com.android.utils.ILogger;
/*    */ import java.io.BufferedInputStream;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import org.objectweb.asm.ClassReader;
/*    */ import org.objectweb.asm.tree.ClassNode;
/*    */ 
/*    */ public class AsmUtils$DirectoryBasedClassReader
/*    */   implements AsmUtils.ClassNodeProvider
/*    */ {
/*    */   private final File binaryFolder;
/*    */   
/*    */   public AsmUtils$DirectoryBasedClassReader(File binaryFolder)
/*    */   {
/* 64 */     this.binaryFolder = binaryFolder;
/*    */   }
/*    */   
/*    */   public ClassNode loadClassNode(String className, ILogger logger)
/*    */   {
/* 70 */     File outerClassFile = new File(binaryFolder, className + ".class");
/* 71 */     if (outerClassFile.exists()) {
/* 72 */       logger.verbose("Parsing %s", new Object[] { outerClassFile });
/* 73 */       try { InputStream outerClassInputStream = new BufferedInputStream(new FileInputStream(outerClassFile));Throwable localThrowable3 = null;
/*    */         try {
/* 75 */           return AsmUtils.readClass(new ClassReader(outerClassInputStream));
/*    */         }
/*    */         catch (Throwable localThrowable4)
/*    */         {
/* 73 */           localThrowable3 = localThrowable4;throw localThrowable4;
/*    */         }
/*    */         finally {
/* 76 */           if (outerClassInputStream != null) { if (localThrowable3 != null) try { outerClassInputStream.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else { outerClassInputStream.close();
/*    */             }
/*    */           }
/*    */         }
/* 80 */         return null;
/*    */       }
/*    */       catch (IOException e)
/*    */       {
/* 77 */         logger.error(e, "Cannot parse %s", new Object[] { className });
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.AsmUtils.DirectoryBasedClassReader
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */