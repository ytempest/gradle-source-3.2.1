/*     */ package com.android.build.gradle.internal.cxx.json;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ class AndroidBuildGradleJsons$MiniConfigBuildingVisitor
/*     */   extends AndroidBuildGradleJsonStreamingVisitor
/*     */ {
/*     */   private final NativeBuildConfigValueMini miniConfig;
/*     */   private String libraryName;
/*     */   
/*     */   AndroidBuildGradleJsons$MiniConfigBuildingVisitor()
/*     */   {
/* 178 */     miniConfig = new NativeBuildConfigValueMini();
/* 179 */     libraryName = null;
/*     */   }
/*     */   
/*     */   protected void beginLibrary(String libraryName)
/*     */   {
/* 184 */     super.beginLibrary(libraryName);
/* 185 */     this.libraryName = libraryName;
/* 186 */     miniConfig.libraries.put(libraryName, new NativeLibraryValueMini());
/*     */   }
/*     */   
/*     */   protected void visitLibraryAbi(String abi)
/*     */   {
/* 191 */     super.visitLibraryAbi(abi);
/* 192 */     miniConfig.libraries.get(libraryName)).abi = abi;
/*     */   }
/*     */   
/*     */   protected void visitLibraryArtifactName(String artifactName)
/*     */   {
/* 197 */     super.visitLibraryArtifactName(artifactName);
/* 198 */     miniConfig.libraries.get(libraryName)).artifactName = artifactName;
/*     */   }
/*     */   
/*     */   protected void visitLibraryBuildCommand(String buildCommand)
/*     */   {
/* 203 */     super.visitLibraryBuildCommand(buildCommand);
/* 204 */     miniConfig.libraries.get(libraryName)).buildCommand = buildCommand;
/*     */   }
/*     */   
/*     */   protected void visitCleanCommands(String cleanCommand)
/*     */   {
/* 209 */     super.visitCleanCommands(cleanCommand);
/* 210 */     miniConfig.cleanCommands.add(cleanCommand);
/*     */   }
/*     */   
/*     */   protected void visitLibraryOutput(String output)
/*     */   {
/* 215 */     super.visitLibraryOutput(output);
/* 216 */     miniConfig.libraries.get(libraryName)).output = new File(output);
/*     */   }
/*     */   
/*     */   protected void visitBuildFile(String buildFile)
/*     */   {
/* 221 */     super.visitBuildFile(buildFile);
/* 222 */     miniConfig.buildFiles.add(new File(buildFile));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.cxx.json.AndroidBuildGradleJsons.MiniConfigBuildingVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */