/*    */ package com.android.build.gradle.internal.incremental;
/*    */ 
/*    */ import com.android.utils.ILogger;
/*    */ import org.objectweb.asm.ClassVisitor;
/*    */ 
/*    */ final class IncrementalChangeVisitor$1
/*    */   implements IncrementalVisitor.VisitorBuilder
/*    */ {
/*    */   public IncrementalVisitor build(AsmClassNode classNode, ClassVisitor classVisitor, ILogger logger)
/*    */   {
/* 61 */     return new IncrementalChangeVisitor(classNode, classVisitor, logger);
/*    */   }
/*    */   
/*    */   public String getMangledRelativeClassFilePath(String path)
/*    */   {
/* 68 */     return path.substring(0, path.length() - 6) + "$override" + ".class";
/*    */   }
/*    */   
/*    */   public IncrementalVisitor.OutputType getOutputType()
/*    */   {
/* 74 */     return IncrementalVisitor.OutputType.OVERRIDE;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.IncrementalChangeVisitor.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */