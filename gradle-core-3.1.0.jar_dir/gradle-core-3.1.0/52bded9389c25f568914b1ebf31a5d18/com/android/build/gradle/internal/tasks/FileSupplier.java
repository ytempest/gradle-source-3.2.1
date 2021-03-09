package com.android.build.gradle.internal.tasks;

import com.google.common.base.Supplier;
import java.io.File;
import org.gradle.api.Task;

public abstract interface FileSupplier
  extends Supplier<File>
{
  public abstract Task getTask();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.FileSupplier
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */