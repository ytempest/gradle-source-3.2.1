/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.builder.model.NativeAndroidProject;
/*     */ import com.android.builder.model.NativeArtifact;
/*     */ import com.android.builder.model.NativeSettings;
/*     */ import com.android.builder.model.NativeToolchain;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ 
/*     */ public final class NativeAndroidProjectImpl
/*     */   implements NativeAndroidProject, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final int apiVersion;
/*     */   private final String modelVersion;
/*     */   private final String name;
/*     */   private final Collection<File> buildFiles;
/*     */   private final Collection<NativeArtifact> artifacts;
/*     */   private final Collection<NativeToolchain> toolChains;
/*     */   private final Collection<NativeSettings> settings;
/*     */   private final Map<String, String> fileExtensions;
/*     */   private final Collection<String> buildSystems;
/*     */   
/*     */   public NativeAndroidProjectImpl(String modelVersion, String name, Collection<File> buildFiles, Collection<NativeArtifact> artifacts, Collection<NativeToolchain> toolChains, Collection<NativeSettings> settings, Map<String, String> fileExtensions, Collection<String> buildSystems, int apiVersion)
/*     */   {
/*  67 */     this.modelVersion = modelVersion;
/*  68 */     this.name = name;
/*  69 */     this.buildFiles = buildFiles;
/*  70 */     this.artifacts = artifacts;
/*  71 */     this.toolChains = toolChains;
/*  72 */     this.settings = settings;
/*  73 */     this.fileExtensions = fileExtensions;
/*  74 */     this.buildSystems = buildSystems;
/*  75 */     this.apiVersion = apiVersion;
/*     */   }
/*     */   
/*     */   public int getApiVersion()
/*     */   {
/*  80 */     return apiVersion;
/*     */   }
/*     */   
/*     */   public String getModelVersion()
/*     */   {
/*  86 */     return modelVersion;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  92 */     return name;
/*     */   }
/*     */   
/*     */   public Collection<File> getBuildFiles()
/*     */   {
/*  98 */     return buildFiles;
/*     */   }
/*     */   
/*     */   public Collection<NativeArtifact> getArtifacts()
/*     */   {
/* 104 */     return artifacts;
/*     */   }
/*     */   
/*     */   public Collection<NativeToolchain> getToolChains()
/*     */   {
/* 110 */     return toolChains;
/*     */   }
/*     */   
/*     */   public Collection<NativeSettings> getSettings()
/*     */   {
/* 116 */     return settings;
/*     */   }
/*     */   
/*     */   public Map<String, String> getFileExtensions()
/*     */   {
/* 122 */     return fileExtensions;
/*     */   }
/*     */   
/*     */   public Collection<String> getBuildSystems()
/*     */   {
/* 128 */     return buildSystems;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 133 */     if (this == o) {
/* 134 */       return true;
/*     */     }
/* 136 */     if ((o == null) || (getClass() != o.getClass())) {
/* 137 */       return false;
/*     */     }
/* 139 */     NativeAndroidProjectImpl that = (NativeAndroidProjectImpl)o;
/* 140 */     return (apiVersion == apiVersion) && 
/* 141 */       (Objects.equals(modelVersion, modelVersion)) && 
/* 142 */       (Objects.equals(name, name)) && 
/* 143 */       (Objects.equals(buildFiles, buildFiles)) && 
/* 144 */       (Objects.equals(artifacts, artifacts)) && 
/* 145 */       (Objects.equals(toolChains, toolChains)) && 
/* 146 */       (Objects.equals(settings, settings)) && 
/* 147 */       (Objects.equals(fileExtensions, fileExtensions)) && 
/* 148 */       (Objects.equals(buildSystems, buildSystems));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 153 */     return 
/* 154 */       Objects.hash(new Object[] { Integer.valueOf(apiVersion), modelVersion, name, buildFiles, artifacts, toolChains, settings, fileExtensions, buildSystems });
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 160 */     return 
/*     */     
/* 170 */       MoreObjects.toStringHelper(this).add("apiVersion", apiVersion).add("modelVersion", modelVersion).add("name", name).add("buildFiles", buildFiles).add("artifacts", artifacts).add("toolChains", toolChains).add("settings", settings).add("fileExtensions", fileExtensions).add("buildSystems", buildSystems).toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.NativeAndroidProjectImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */