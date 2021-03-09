package com.android.build.gradle.internal.tasks;

import java.io.File;
import org.gradle.api.tasks.VerificationTask;

public abstract interface AndroidTestTask
  extends VerificationTask
{
  public abstract File getResultsDir();
  
  public abstract boolean getTestFailed();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.AndroidTestTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */