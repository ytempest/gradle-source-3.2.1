/*     */ package com.android.build.gradle.internal.ide.level2;
/*     */ 
/*     */ import com.android.builder.model.level2.Library;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ 
/*     */ public final class AndroidLibraryImpl
/*     */   implements Library, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String address;
/*     */   private final File artifact;
/*     */   private final File folder;
/*     */   private final List<String> localJarPaths;
/*     */   
/*     */   public AndroidLibraryImpl(String address, File artifact, File folder, List<String> localJarPaths)
/*     */   {
/*  60 */     this.address = address;
/*  61 */     this.artifact = artifact;
/*  62 */     this.folder = folder;
/*  63 */     this.localJarPaths = ImmutableList.copyOf(localJarPaths);
/*     */   }
/*     */   
/*     */   public int getType()
/*     */   {
/*  68 */     return 1;
/*     */   }
/*     */   
/*     */   public String getArtifactAddress()
/*     */   {
/*  74 */     return address;
/*     */   }
/*     */   
/*     */   public File getArtifact()
/*     */   {
/*  80 */     return artifact;
/*     */   }
/*     */   
/*     */   public File getFolder()
/*     */   {
/*  86 */     return folder;
/*     */   }
/*     */   
/*     */   public String getManifest()
/*     */   {
/*  92 */     return "AndroidManifest.xml";
/*     */   }
/*     */   
/*     */   public String getJarFile()
/*     */   {
/*  98 */     return "jars" + File.separatorChar + "classes.jar";
/*     */   }
/*     */   
/*     */   public String getResFolder()
/*     */   {
/* 104 */     return "res";
/*     */   }
/*     */   
/*     */   public String getAssetsFolder()
/*     */   {
/* 110 */     return "assets";
/*     */   }
/*     */   
/*     */   public Collection<String> getLocalJars()
/*     */   {
/* 116 */     return localJarPaths;
/*     */   }
/*     */   
/*     */   public String getJniFolder()
/*     */   {
/* 122 */     return "jni";
/*     */   }
/*     */   
/*     */   public String getAidlFolder()
/*     */   {
/* 128 */     return "aidl";
/*     */   }
/*     */   
/*     */   public String getRenderscriptFolder()
/*     */   {
/* 134 */     return "rs";
/*     */   }
/*     */   
/*     */   public String getProguardRules()
/*     */   {
/* 140 */     return "proguard.txt";
/*     */   }
/*     */   
/*     */   public String getLintJar()
/*     */   {
/* 146 */     return "jars" + File.separatorChar + "lint.jar";
/*     */   }
/*     */   
/*     */   public String getExternalAnnotations()
/*     */   {
/* 152 */     return "jars" + File.separatorChar + "annotations.zip";
/*     */   }
/*     */   
/*     */   public String getPublicResources()
/*     */   {
/* 158 */     return "public.txt";
/*     */   }
/*     */   
/*     */   public String getSymbolFile()
/*     */   {
/* 164 */     return "R.txt";
/*     */   }
/*     */   
/*     */   public String getVariant()
/*     */   {
/* 170 */     throw new UnsupportedOperationException("getVariant() cannot be called when getType() returns ANDROID_LIBRARY");
/*     */   }
/*     */   
/*     */   public String getBuildId()
/*     */   {
/* 177 */     throw new UnsupportedOperationException("getBuildId() cannot be called when getType() returns ANDROID_LIBRARY");
/*     */   }
/*     */   
/*     */   public String getProjectPath()
/*     */   {
/* 184 */     throw new UnsupportedOperationException("getProjectPath() cannot be called when getType() returns ANDROID_LIBRARY");
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 190 */     if (this == o) {
/* 191 */       return true;
/*     */     }
/* 193 */     if ((o == null) || (getClass() != o.getClass())) {
/* 194 */       return false;
/*     */     }
/* 196 */     AndroidLibraryImpl that = (AndroidLibraryImpl)o;
/* 197 */     return (Objects.equals(address, address)) && 
/* 198 */       (Objects.equals(artifact, artifact)) && 
/* 199 */       (Objects.equals(folder, folder)) && 
/* 200 */       (Objects.equals(localJarPaths, localJarPaths));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 205 */     return Objects.hash(new Object[] { address, artifact, folder, localJarPaths });
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 210 */     return 
/*     */     
/* 215 */       MoreObjects.toStringHelper(this).add("address", address).add("artifact", artifact).add("folder", folder).add("localJarPath", localJarPaths).toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.level2.AndroidLibraryImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */