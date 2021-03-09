package com.android.build.gradle.internal.incremental;

import com.android.utils.ILogger;
import java.io.IOException;
import org.objectweb.asm.tree.ClassNode;

public abstract interface AsmUtils$ClassNodeProvider
{
  public abstract ClassNode loadClassNode(String paramString, ILogger paramILogger)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.AsmUtils.ClassNodeProvider
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */