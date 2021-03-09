package com.android.build.gradle.internal.incremental;

import com.android.utils.ILogger;
import org.objectweb.asm.ClassVisitor;

public abstract interface IncrementalVisitor$VisitorBuilder
{
  public abstract IncrementalVisitor build(AsmClassNode paramAsmClassNode, ClassVisitor paramClassVisitor, ILogger paramILogger);
  
  public abstract String getMangledRelativeClassFilePath(String paramString);
  
  public abstract IncrementalVisitor.OutputType getOutputType();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.IncrementalVisitor.VisitorBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */