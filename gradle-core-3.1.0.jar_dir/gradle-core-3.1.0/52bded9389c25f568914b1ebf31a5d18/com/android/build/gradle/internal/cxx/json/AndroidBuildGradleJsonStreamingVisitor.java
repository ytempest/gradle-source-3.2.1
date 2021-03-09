package com.android.build.gradle.internal.cxx.json;

public abstract class AndroidBuildGradleJsonStreamingVisitor
{
  protected void beginLibrary(String libraryName) {}
  
  protected void endLibrary() {}
  
  protected void beginLibraryFile() {}
  
  protected void endLibraryFile() {}
  
  protected void beginToolchain(String toolchain) {}
  
  protected void endToolchain() {}
  
  protected void visitBuildFile(String buildFile) {}
  
  protected void visitLibraryAbi(String abi) {}
  
  protected void visitLibraryArtifactName(String artifact) {}
  
  protected void visitLibraryBuildCommand(String buildCommand) {}
  
  protected void visitLibraryBuildType(String buildType) {}
  
  protected void visitLibraryOutput(String output) {}
  
  protected void visitLibraryToolchain(String toolchain) {}
  
  protected void visitLibraryGroupName(String groupName) {}
  
  protected void visitToolchainCCompilerExecutable(String executable) {}
  
  protected void visitToolchainCppCompilerExecutable(String executable) {}
  
  protected void visitLibraryFileFlags(String flags) {}
  
  protected void visitLibraryFileSrc(String src) {}
  
  protected void visitLibraryFileWorkingDirectory(String workingDirectory) {}
  
  protected void visitCleanCommands(String cleanCommand) {}
  
  protected void visitCFileExtensions(String buildFile) {}
  
  protected void visitCppFileExtensions(String buildFile) {}
  
  protected void visitLibraryRuntimeFile(String runtimeFile) {}
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.cxx.json.AndroidBuildGradleJsonStreamingVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */