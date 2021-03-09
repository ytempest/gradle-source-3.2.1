/*    */ package com.android.build.gradle.internal.incremental;
/*    */ 
/*    */ import com.android.utils.ILogger;
/*    */ import org.objectweb.asm.ClassVisitor;
/*    */ 
/*    */ final class IncrementalSupportVisitor$VisitorBuilder
/*    */   implements IncrementalVisitor.VisitorBuilder
/*    */ {
/*    */   public IncrementalVisitor build(AsmClassNode classNode, ClassVisitor classVisitor, ILogger logger)
/*    */   {
/* 78 */     return new IncrementalSupportVisitor(classNode, classVisitor, logger);
/*    */   }
/*    */   
/*    */   public String getMangledRelativeClassFilePath(String originalClassFilePath)
/*    */   {
/* 84 */     return originalClassFilePath;
/*    */   }
/*    */   
/*    */   public IncrementalVisitor.OutputType getOutputType()
/*    */   {
/* 90 */     return IncrementalVisitor.OutputType.INSTRUMENT;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.IncrementalSupportVisitor.VisitorBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */