/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.builder.model.NativeArtifact;
/*     */ import com.android.builder.model.NativeFile;
/*     */ import com.android.builder.model.NativeFolder;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Objects;
/*     */ 
/*     */ public final class NativeArtifactImpl
/*     */   implements NativeArtifact, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String name;
/*     */   private final String toolChain;
/*     */   private final String groupName;
/*     */   private final String assembleTaskName;
/*     */   private final Collection<NativeFolder> sourceFolders;
/*     */   private final Collection<NativeFile> sourceFiles;
/*     */   private final Collection<File> exportedHeaders;
/*     */   private final File outputFile;
/*     */   private final Collection<File> runtimeFiles;
/*     */   private final String abi;
/*     */   private final String targetName;
/*     */   
/*     */   public NativeArtifactImpl(String name, String toolChain, String groupName, String assembleTaskName, Collection<NativeFolder> sourceFolders, Collection<NativeFile> sourceFiles, Collection<File> exportedHeaders, File outputFile, Collection<File> runtimeFiles, String abi, String targetName)
/*     */   {
/*  72 */     this.name = name;
/*  73 */     this.toolChain = toolChain;
/*  74 */     this.groupName = groupName;
/*  75 */     this.assembleTaskName = assembleTaskName;
/*  76 */     this.sourceFolders = sourceFolders;
/*  77 */     this.sourceFiles = sourceFiles;
/*  78 */     this.exportedHeaders = exportedHeaders;
/*  79 */     this.outputFile = outputFile;
/*  80 */     this.runtimeFiles = runtimeFiles;
/*  81 */     this.abi = abi;
/*  82 */     this.targetName = targetName;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  88 */     return name;
/*     */   }
/*     */   
/*     */   public String getToolChain()
/*     */   {
/*  94 */     return toolChain;
/*     */   }
/*     */   
/*     */   public String getGroupName()
/*     */   {
/* 100 */     return groupName;
/*     */   }
/*     */   
/*     */   public String getAssembleTaskName()
/*     */   {
/* 106 */     return assembleTaskName;
/*     */   }
/*     */   
/*     */   public Collection<NativeFolder> getSourceFolders()
/*     */   {
/* 112 */     return sourceFolders;
/*     */   }
/*     */   
/*     */   public Collection<NativeFile> getSourceFiles()
/*     */   {
/* 118 */     return sourceFiles;
/*     */   }
/*     */   
/*     */   public Collection<File> getExportedHeaders()
/*     */   {
/* 124 */     return exportedHeaders;
/*     */   }
/*     */   
/*     */   public File getOutputFile()
/*     */   {
/* 130 */     return outputFile;
/*     */   }
/*     */   
/*     */   public Collection<File> getRuntimeFiles()
/*     */   {
/* 136 */     return runtimeFiles;
/*     */   }
/*     */   
/*     */   public String getAbi()
/*     */   {
/* 142 */     return abi;
/*     */   }
/*     */   
/*     */   public String getTargetName()
/*     */   {
/* 148 */     return targetName;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 153 */     if (this == o) {
/* 154 */       return true;
/*     */     }
/* 156 */     if ((o == null) || (getClass() != o.getClass())) {
/* 157 */       return false;
/*     */     }
/* 159 */     NativeArtifactImpl that = (NativeArtifactImpl)o;
/* 160 */     return (Objects.equals(name, name)) && 
/* 161 */       (Objects.equals(toolChain, toolChain)) && 
/* 162 */       (Objects.equals(groupName, groupName)) && 
/* 163 */       (Objects.equals(assembleTaskName, assembleTaskName)) && 
/* 164 */       (Objects.equals(sourceFolders, sourceFolders)) && 
/* 165 */       (Objects.equals(sourceFiles, sourceFiles)) && 
/* 166 */       (Objects.equals(exportedHeaders, exportedHeaders)) && 
/* 167 */       (Objects.equals(outputFile, outputFile)) && 
/* 168 */       (Objects.equals(runtimeFiles, runtimeFiles)) && 
/* 169 */       (Objects.equals(abi, abi)) && 
/* 170 */       (Objects.equals(targetName, targetName));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 175 */     return 
/* 176 */       Objects.hash(new Object[] { name, toolChain, groupName, assembleTaskName, sourceFolders, sourceFiles, exportedHeaders, outputFile, runtimeFiles, abi, targetName });
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 182 */     return 
/*     */     
/* 192 */       MoreObjects.toStringHelper(getClass()).add("Name", name).add("ToolChain", toolChain).add("GroupName", groupName).add("AssembleTaskName", assembleTaskName).add("SourceFoldersCount", sourceFolders.size()).add("SourceFilesCount", sourceFiles.size()).add("ExportedHeadersSize", exportedHeaders.size()).add("OutputFile", outputFile).add("RuntimeFiles", getRuntimeFiles()).toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.NativeArtifactImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */