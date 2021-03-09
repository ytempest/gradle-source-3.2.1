/*     */ package com.android.build.gradle.internal.ide.level2;
/*     */ 
/*     */ import com.android.builder.model.level2.Library;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Objects;
/*     */ 
/*     */ public final class JavaLibraryImpl
/*     */   implements Library, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String address;
/*     */   private final File artifactFile;
/*     */   
/*     */   public JavaLibraryImpl(String address, File artifactFile)
/*     */   {
/*  38 */     this.address = address;
/*  39 */     this.artifactFile = artifactFile;
/*     */   }
/*     */   
/*     */   public int getType()
/*     */   {
/*  44 */     return 2;
/*     */   }
/*     */   
/*     */   public String getArtifactAddress()
/*     */   {
/*  50 */     return address;
/*     */   }
/*     */   
/*     */   public File getArtifact()
/*     */   {
/*  56 */     return artifactFile;
/*     */   }
/*     */   
/*     */   public String getVariant()
/*     */   {
/*  62 */     throw new UnsupportedOperationException("getVariant() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public String getBuildId()
/*     */   {
/*  69 */     throw new UnsupportedOperationException("getBuildId() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public String getProjectPath()
/*     */   {
/*  76 */     throw new UnsupportedOperationException("getProjectPath() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public File getFolder()
/*     */   {
/*  83 */     throw new UnsupportedOperationException("getFolder() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public String getManifest()
/*     */   {
/*  90 */     throw new UnsupportedOperationException("getManifest() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public String getJarFile()
/*     */   {
/*  97 */     throw new UnsupportedOperationException("getJarFile() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public String getResFolder()
/*     */   {
/* 104 */     throw new UnsupportedOperationException("getResFolder() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public String getAssetsFolder()
/*     */   {
/* 111 */     throw new UnsupportedOperationException("getAssetsFolder() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public Collection<String> getLocalJars()
/*     */   {
/* 118 */     throw new UnsupportedOperationException("getLocalJars() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public String getJniFolder()
/*     */   {
/* 125 */     throw new UnsupportedOperationException("getJniFolder() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public String getAidlFolder()
/*     */   {
/* 132 */     throw new UnsupportedOperationException("getAidlFolder() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public String getRenderscriptFolder()
/*     */   {
/* 139 */     throw new UnsupportedOperationException("getRenderscriptFolder() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public String getProguardRules()
/*     */   {
/* 146 */     throw new UnsupportedOperationException("getProguardRules() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public String getLintJar()
/*     */   {
/* 153 */     throw new UnsupportedOperationException("getLintJar() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public String getExternalAnnotations()
/*     */   {
/* 160 */     throw new UnsupportedOperationException("getExternalAnnotations() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public String getPublicResources()
/*     */   {
/* 167 */     throw new UnsupportedOperationException("getPublicResources() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public String getSymbolFile()
/*     */   {
/* 174 */     throw new UnsupportedOperationException("getSymbolFile() cannot be called when getType() returns LIBRARY_JAVA");
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 180 */     if (this == o) {
/* 181 */       return true;
/*     */     }
/* 183 */     if ((o == null) || (getClass() != o.getClass())) {
/* 184 */       return false;
/*     */     }
/* 186 */     JavaLibraryImpl that = (JavaLibraryImpl)o;
/* 187 */     return (Objects.equals(address, address)) && 
/* 188 */       (Objects.equals(artifactFile, artifactFile));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 193 */     return Objects.hash(new Object[] { address, artifactFile });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.level2.JavaLibraryImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */