package com.android.build.gradle.external.gnumake;

abstract interface CommandClassifier$BuildTool
{
  public abstract BuildStepInfo createCommand(CommandLine paramCommandLine);
  
  public abstract boolean isMatch(CommandLine paramCommandLine);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.external.gnumake.CommandClassifier.BuildTool
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */