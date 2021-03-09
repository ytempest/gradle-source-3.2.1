/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.build.gradle.internal.cxx.json.AndroidBuildGradleJsonStreamingVisitor;
/*     */ import com.android.builder.model.NativeFile;
/*     */ import com.android.builder.model.NativeSettings;
/*     */ import com.android.utils.StringHelper;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ class NativeAndroidProjectBuilder$JsonStreamingVisitor
/*     */   extends AndroidBuildGradleJsonStreamingVisitor
/*     */ {
/*     */   private final NativeAndroidProjectBuilder builder;
/*     */   private final String variantName;
/* 116 */   private String currentToolchain = null;
/* 117 */   private String currentCExecutable = null;
/* 118 */   private String currentCppExecutable = null;
/* 119 */   private String currentLibraryName = null;
/* 120 */   private String currentLibraryToolchain = null;
/* 121 */   private String currentLibraryOutput = null;
/* 122 */   private String currentLibraryAbi = null;
/* 123 */   private String currentLibraryArtifactName = null;
/* 124 */   private List<File> currentLibraryRuntimeFiles = null;
/* 125 */   private List<NativeFile> currentLibrarySourceFiles = null;
/* 126 */   private String currentLibraryFileSettingsName = null;
/* 127 */   private String currentLibraryFilePath = null;
/* 128 */   private String currentLibraryFileWorkingDirectory = null;
/*     */   
/*     */   NativeAndroidProjectBuilder$JsonStreamingVisitor(NativeAndroidProjectBuilder builder, String variantName)
/*     */   {
/* 132 */     this.variantName = variantName;
/* 133 */     this.builder = builder;
/*     */   }
/*     */   
/*     */   public void visitBuildFile(String buildFile)
/*     */   {
/* 138 */     NativeAndroidProjectBuilder.access$000(builder).add(new File(buildFile));
/*     */   }
/*     */   
/*     */   public void beginLibrary(String libraryName)
/*     */   {
/* 143 */     currentLibraryName = libraryName;
/* 144 */     currentLibraryRuntimeFiles = Lists.newArrayList();
/* 145 */     currentLibrarySourceFiles = Lists.newArrayList();
/*     */   }
/*     */   
/*     */   public void endLibrary()
/*     */   {
/* 150 */     Preconditions.checkNotNull(currentLibraryName);
/* 151 */     Preconditions.checkNotNull(currentLibraryToolchain);
/* 152 */     Preconditions.checkNotNull(currentLibrarySourceFiles);
/* 153 */     Preconditions.checkNotNull(currentLibraryOutput);
/* 154 */     Preconditions.checkNotNull(currentLibraryRuntimeFiles);
/* 155 */     Preconditions.checkNotNull(currentLibraryAbi);
/* 156 */     Preconditions.checkNotNull(currentLibraryArtifactName);
/*     */     
/* 158 */     NativeAndroidProjectBuilder.access$100(builder).add(new NativeArtifactImpl(currentLibraryName, currentLibraryToolchain, variantName, "", 
/*     */     
/* 164 */       ImmutableList.of(), currentLibrarySourceFiles, 
/*     */       
/* 166 */       ImmutableList.of(), 
/* 167 */       newFileOrNull(currentLibraryOutput), currentLibraryRuntimeFiles, currentLibraryAbi, currentLibraryArtifactName));
/*     */     
/* 172 */     currentLibraryName = null;
/* 173 */     currentLibraryToolchain = null;
/* 174 */     currentLibraryOutput = null;
/* 175 */     currentLibraryAbi = null;
/* 176 */     currentLibraryArtifactName = null;
/* 177 */     currentLibraryRuntimeFiles = null;
/* 178 */     currentLibrarySourceFiles = null;
/*     */   }
/*     */   
/*     */   public void beginToolchain(String toolchain)
/*     */   {
/* 183 */     currentToolchain = toolchain;
/*     */   }
/*     */   
/*     */   public void endToolchain()
/*     */   {
/* 188 */     Preconditions.checkNotNull(currentToolchain);
/* 189 */     NativeAndroidProjectBuilder.access$200(builder).add(new NativeToolchainImpl(currentToolchain, 
/*     */     
/* 192 */       newFileOrNull(currentCExecutable), 
/* 193 */       newFileOrNull(currentCppExecutable)));
/* 194 */     currentToolchain = null;
/* 195 */     currentCExecutable = null;
/* 196 */     currentCppExecutable = null;
/*     */   }
/*     */   
/*     */   private File newFileOrNull(String filename)
/*     */   {
/* 201 */     if (filename == null) {
/* 202 */       return null;
/*     */     }
/* 204 */     return new File(filename);
/*     */   }
/*     */   
/*     */   public void visitLibraryAbi(String abi)
/*     */   {
/* 209 */     currentLibraryAbi = abi;
/*     */   }
/*     */   
/*     */   public void visitLibraryArtifactName(String artifact)
/*     */   {
/* 214 */     currentLibraryArtifactName = artifact;
/*     */   }
/*     */   
/*     */   public void visitLibraryOutput(String output)
/*     */   {
/* 219 */     currentLibraryOutput = output;
/*     */   }
/*     */   
/*     */   public void visitLibraryToolchain(String toolchain)
/*     */   {
/* 224 */     currentLibraryToolchain = toolchain;
/*     */   }
/*     */   
/*     */   public void visitToolchainCCompilerExecutable(String executable)
/*     */   {
/* 229 */     currentCExecutable = executable;
/*     */   }
/*     */   
/*     */   public void visitToolchainCppCompilerExecutable(String executable)
/*     */   {
/* 234 */     currentCppExecutable = executable;
/*     */   }
/*     */   
/*     */   public void visitLibraryFileFlags(String flags)
/*     */   {
/* 240 */     currentLibraryFileSettingsName = getSettingsName(StringHelper.tokenizeCommandLineToEscaped(flags));
/*     */   }
/*     */   
/*     */   public void visitLibraryFileSrc(String src)
/*     */   {
/* 245 */     currentLibraryFilePath = src;
/*     */   }
/*     */   
/*     */   public void visitLibraryFileWorkingDirectory(String workingDirectory)
/*     */   {
/* 250 */     currentLibraryFileWorkingDirectory = workingDirectory;
/*     */   }
/*     */   
/*     */   public void visitCFileExtensions(String extension)
/*     */   {
/* 255 */     NativeAndroidProjectBuilder.access$300(builder).put(extension, "c");
/*     */   }
/*     */   
/*     */   public void visitCppFileExtensions(String extension)
/*     */   {
/* 260 */     NativeAndroidProjectBuilder.access$300(builder).put(extension, "c++");
/*     */   }
/*     */   
/*     */   public void visitLibraryRuntimeFile(String runtimeFile)
/*     */   {
/* 265 */     Preconditions.checkNotNull(currentLibraryRuntimeFiles);
/* 266 */     currentLibraryRuntimeFiles.add(new File(runtimeFile));
/*     */   }
/*     */   
/*     */   public void endLibraryFile()
/*     */   {
/* 271 */     Preconditions.checkNotNull(currentLibrarySourceFiles);
/* 272 */     Preconditions.checkNotNull(currentLibraryFilePath);
/*     */     
/* 274 */     if (currentLibraryFileSettingsName != null)
/*     */     {
/* 279 */       currentLibrarySourceFiles.add(new NativeFileImpl(new File(currentLibraryFilePath), currentLibraryFileSettingsName, 
/*     */       
/* 283 */         newFileOrNull(currentLibraryFileWorkingDirectory)));
/*     */     }
/*     */     
/* 286 */     currentLibraryFilePath = null;
/* 287 */     currentLibraryFileSettingsName = null;
/* 288 */     currentLibraryFileWorkingDirectory = null;
/*     */   }
/*     */   
/*     */   private String getSettingsName(List<String> flags)
/*     */   {
/* 293 */     List<String> flagsCopy = ImmutableList.copyOf(flags);
/* 294 */     NativeSettings setting = (NativeSettings)NativeAndroidProjectBuilder.access$400(builder).get(flags);
/* 295 */     if (setting == null) {
/* 296 */       setting = new NativeSettingsImpl("setting" + builder.settingIndex, flagsCopy);
/* 297 */       NativeAndroidProjectBuilder.access$400(builder).put(flagsCopy, setting);
/* 298 */       builder.settingIndex += 1;
/*     */     }
/* 300 */     return setting.getName();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.NativeAndroidProjectBuilder.JsonStreamingVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */