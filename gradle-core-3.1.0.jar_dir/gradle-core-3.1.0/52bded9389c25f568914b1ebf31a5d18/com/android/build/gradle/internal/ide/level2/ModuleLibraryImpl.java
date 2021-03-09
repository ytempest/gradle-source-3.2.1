/*     */ package com.android.build.gradle.internal.ide.level2;
/*     */ 
/*     */ import com.android.builder.model.level2.Library;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Objects;
/*     */ 
/*     */ public final class ModuleLibraryImpl
/*     */   implements Library, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String address;
/*     */   private final String buildId;
/*     */   private final String projectPath;
/*     */   private final String variant;
/*     */   
/*     */   public ModuleLibraryImpl(String address, String buildId, String projectPath, String variant)
/*     */   {
/*  45 */     this.address = address;
/*  46 */     this.buildId = buildId;
/*  47 */     this.projectPath = projectPath;
/*  48 */     this.variant = variant;
/*     */   }
/*     */   
/*     */   public int getType()
/*     */   {
/*  53 */     return 3;
/*     */   }
/*     */   
/*     */   public String getArtifactAddress()
/*     */   {
/*  59 */     return address;
/*     */   }
/*     */   
/*     */   public File getArtifact()
/*     */   {
/*  65 */     throw new UnsupportedOperationException("getArtifact() cannot be called when getType() returns LIBRARY_MODULE");
/*     */   }
/*     */   
/*     */   public String getBuildId()
/*     */   {
/*  72 */     return buildId;
/*     */   }
/*     */   
/*     */   public String getProjectPath()
/*     */   {
/*  78 */     return projectPath;
/*     */   }
/*     */   
/*     */   public String getVariant()
/*     */   {
/*  84 */     return variant;
/*     */   }
/*     */   
/*     */   public File getFolder()
/*     */   {
/*  90 */     throw new UnsupportedOperationException("getFolder() cannot be called when getType() returns LIBRARY_MODULE");
/*     */   }
/*     */   
/*     */   public String getManifest()
/*     */   {
/*  97 */     throw new UnsupportedOperationException("getManifest() cannot be called when getType() returns LIBRARY_MODULE");
/*     */   }
/*     */   
/*     */   public String getJarFile()
/*     */   {
/* 104 */     throw new UnsupportedOperationException("getJarFile() cannot be called when getType() returns LIBRARY_MODULE");
/*     */   }
/*     */   
/*     */   public String getResFolder()
/*     */   {
/* 111 */     throw new UnsupportedOperationException("getResFolder() cannot be called when getType() returns LIBRARY_MODULE");
/*     */   }
/*     */   
/*     */   public String getAssetsFolder()
/*     */   {
/* 118 */     throw new UnsupportedOperationException("getAssetsFolder() cannot be called when getType() returns LIBRARY_MODULE");
/*     */   }
/*     */   
/*     */   public Collection<String> getLocalJars()
/*     */   {
/* 125 */     throw new UnsupportedOperationException("getLocalJars() cannot be called when getType() returns LIBRARY_MODULE");
/*     */   }
/*     */   
/*     */   public String getJniFolder()
/*     */   {
/* 132 */     throw new UnsupportedOperationException("getJniFolder() cannot be called when getType() returns LIBRARY_MODULE");
/*     */   }
/*     */   
/*     */   public String getAidlFolder()
/*     */   {
/* 139 */     throw new UnsupportedOperationException("getAidlFolder() cannot be called when getType() returns LIBRARY_MODULE");
/*     */   }
/*     */   
/*     */   public String getRenderscriptFolder()
/*     */   {
/* 146 */     throw new UnsupportedOperationException("getRenderscriptFolder() cannot be called when getType() returns LIBRARY_MODULE");
/*     */   }
/*     */   
/*     */   public String getProguardRules()
/*     */   {
/* 153 */     throw new UnsupportedOperationException("getProguardRules() cannot be called when getType() returns LIBRARY_MODULE");
/*     */   }
/*     */   
/*     */   public String getLintJar()
/*     */   {
/* 160 */     throw new UnsupportedOperationException("getLintJar() cannot be called when getType() returns LIBRARY_MODULE");
/*     */   }
/*     */   
/*     */   public String getExternalAnnotations()
/*     */   {
/* 167 */     throw new UnsupportedOperationException("getExternalAnnotations() cannot be called when getType() returns LIBRARY_MODULE");
/*     */   }
/*     */   
/*     */   public String getPublicResources()
/*     */   {
/* 174 */     throw new UnsupportedOperationException("getPublicResources() cannot be called when getType() returns LIBRARY_MODULE");
/*     */   }
/*     */   
/*     */   public String getSymbolFile()
/*     */   {
/* 181 */     throw new UnsupportedOperationException("getSymbolFile() cannot be called when getType() returns LIBRARY_MODULE");
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 187 */     if (this == o) {
/* 188 */       return true;
/*     */     }
/* 190 */     if ((o == null) || (getClass() != o.getClass())) {
/* 191 */       return false;
/*     */     }
/* 193 */     ModuleLibraryImpl that = (ModuleLibraryImpl)o;
/* 194 */     return (Objects.equals(address, address)) && 
/* 195 */       (Objects.equals(buildId, buildId)) && 
/* 196 */       (Objects.equals(projectPath, projectPath)) && 
/* 197 */       (Objects.equals(variant, variant));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 202 */     return Objects.hash(new Object[] { address, buildId, projectPath, variant });
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 207 */     return 
/*     */     
/* 212 */       MoreObjects.toStringHelper(this).add("address", address).add("buildId", buildId).add("projectPath", projectPath).add("variant", variant).toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.level2.ModuleLibraryImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */