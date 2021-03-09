package com.android.build.gradle.internal.transforms;

import com.android.builder.dexing.DexMergerTool;
import com.android.builder.dexing.DexingType;
import com.android.ide.common.blame.MessageReceiver;
import com.android.ide.common.process.ProcessOutput;
import java.io.File;
import java.nio.file.Path;
import java.util.concurrent.ForkJoinPool;

public abstract interface DexMergerTransformCallable$Factory
{
  public abstract DexMergerTransformCallable create(MessageReceiver paramMessageReceiver, DexingType paramDexingType, ProcessOutput paramProcessOutput, File paramFile, Iterable<Path> paramIterable, Path paramPath, ForkJoinPool paramForkJoinPool, DexMergerTool paramDexMergerTool, int paramInt, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.DexMergerTransformCallable.Factory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */