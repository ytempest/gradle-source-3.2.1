/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.builder.model.SourceProvider;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Objects;
/*     */ 
/*     */ final class SourceProviderImpl
/*     */   implements SourceProvider, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String name;
/*     */   private final File manifestFile;
/*     */   private final Collection<File> javaDirs;
/*     */   private final Collection<File> resourcesDirs;
/*     */   private final Collection<File> aidlDirs;
/*     */   private final Collection<File> rsDirs;
/*     */   private final Collection<File> cDirs;
/*     */   private final Collection<File> cppDirs;
/*     */   private final Collection<File> resDirs;
/*     */   private final Collection<File> assetsDirs;
/*     */   private final Collection<File> libsDirs;
/*     */   private final Collection<File> shaderDirs;
/*     */   
/*     */   public SourceProviderImpl(SourceProvider sourceProvider)
/*     */   {
/*  62 */     name = sourceProvider.getName();
/*  63 */     manifestFile = sourceProvider.getManifestFile();
/*  64 */     javaDirs = sourceProvider.getJavaDirectories();
/*  65 */     resourcesDirs = sourceProvider.getResourcesDirectories();
/*  66 */     aidlDirs = sourceProvider.getAidlDirectories();
/*  67 */     rsDirs = sourceProvider.getRenderscriptDirectories();
/*  68 */     cDirs = sourceProvider.getCDirectories();
/*  69 */     cppDirs = sourceProvider.getCDirectories();
/*  70 */     resDirs = sourceProvider.getResDirectories();
/*  71 */     assetsDirs = sourceProvider.getAssetsDirectories();
/*  72 */     libsDirs = sourceProvider.getJniLibsDirectories();
/*  73 */     shaderDirs = sourceProvider.getShadersDirectories();
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  79 */     return name;
/*     */   }
/*     */   
/*     */   public File getManifestFile()
/*     */   {
/*  85 */     return manifestFile;
/*     */   }
/*     */   
/*     */   public Collection<File> getJavaDirectories()
/*     */   {
/*  91 */     return javaDirs;
/*     */   }
/*     */   
/*     */   public Collection<File> getResourcesDirectories()
/*     */   {
/*  97 */     return resourcesDirs;
/*     */   }
/*     */   
/*     */   public Collection<File> getAidlDirectories()
/*     */   {
/* 103 */     return aidlDirs;
/*     */   }
/*     */   
/*     */   public Collection<File> getRenderscriptDirectories()
/*     */   {
/* 109 */     return rsDirs;
/*     */   }
/*     */   
/*     */   public Collection<File> getCDirectories()
/*     */   {
/* 115 */     return cDirs;
/*     */   }
/*     */   
/*     */   public Collection<File> getCppDirectories()
/*     */   {
/* 121 */     return cppDirs;
/*     */   }
/*     */   
/*     */   public Collection<File> getResDirectories()
/*     */   {
/* 127 */     return resDirs;
/*     */   }
/*     */   
/*     */   public Collection<File> getAssetsDirectories()
/*     */   {
/* 133 */     return assetsDirs;
/*     */   }
/*     */   
/*     */   public Collection<File> getJniLibsDirectories()
/*     */   {
/* 139 */     return libsDirs;
/*     */   }
/*     */   
/*     */   public Collection<File> getShadersDirectories()
/*     */   {
/* 145 */     return shaderDirs;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 150 */     if (this == o) {
/* 151 */       return true;
/*     */     }
/* 153 */     if ((o == null) || (getClass() != o.getClass())) {
/* 154 */       return false;
/*     */     }
/* 156 */     SourceProviderImpl that = (SourceProviderImpl)o;
/* 157 */     return (Objects.equals(name, name)) && 
/* 158 */       (Objects.equals(manifestFile, manifestFile)) && 
/* 159 */       (Objects.equals(javaDirs, javaDirs)) && 
/* 160 */       (Objects.equals(resourcesDirs, resourcesDirs)) && 
/* 161 */       (Objects.equals(aidlDirs, aidlDirs)) && 
/* 162 */       (Objects.equals(rsDirs, rsDirs)) && 
/* 163 */       (Objects.equals(cDirs, cDirs)) && 
/* 164 */       (Objects.equals(cppDirs, cppDirs)) && 
/* 165 */       (Objects.equals(resDirs, resDirs)) && 
/* 166 */       (Objects.equals(assetsDirs, assetsDirs)) && 
/* 167 */       (Objects.equals(libsDirs, libsDirs)) && 
/* 168 */       (Objects.equals(shaderDirs, shaderDirs));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 173 */     return 
/* 174 */       Objects.hash(new Object[] { name, manifestFile, javaDirs, resourcesDirs, aidlDirs, rsDirs, cDirs, cppDirs, resDirs, assetsDirs, libsDirs, shaderDirs });
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 180 */     return 
/*     */     
/* 193 */       MoreObjects.toStringHelper(this).add("name", name).add("manifestFile", manifestFile).add("javaDirs", javaDirs).add("resourcesDirs", resourcesDirs).add("aidlDirs", aidlDirs).add("rsDirs", rsDirs).add("cDirs", cDirs).add("cppDirs", cppDirs).add("resDirs", resDirs).add("assetsDirs", assetsDirs).add("libsDirs", libsDirs).add("shaderDirs", shaderDirs).toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.SourceProviderImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */