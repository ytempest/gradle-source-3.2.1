package com.android.build.gradle.internal.tasks;

import com.android.builder.testing.TestRunner;
import com.android.ide.common.process.ProcessExecutor;
import java.io.File;
import org.gradle.api.Nullable;

abstract interface DeviceProviderInstrumentTestTask$TestRunnerFactory
{
  public abstract TestRunner build(@Nullable File paramFile, ProcessExecutor paramProcessExecutor);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.DeviceProviderInstrumentTestTask.TestRunnerFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */