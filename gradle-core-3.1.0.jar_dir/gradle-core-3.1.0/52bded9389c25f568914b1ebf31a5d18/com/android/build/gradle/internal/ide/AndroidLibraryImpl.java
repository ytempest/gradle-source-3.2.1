/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.builder.model.AndroidLibrary;
/*     */ import com.android.builder.model.JavaLibrary;
/*     */ import com.android.builder.model.MavenCoordinates;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import com.google.common.base.Objects;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ 
/*     */ final class AndroidLibraryImpl
/*     */   extends LibraryImpl
/*     */   implements AndroidLibrary, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String variant;
/*     */   private final File bundle;
/*     */   private final File folder;
/*     */   private final List<AndroidLibrary> androidLibraries;
/*     */   private final Collection<JavaLibrary> javaLibraries;
/*     */   private final Collection<File> localJars;
/*     */   private final int hashcode;
/*     */   
/*     */   AndroidLibraryImpl(MavenCoordinates coordinates, String buildId, String projectPath, File bundle, File extractedFolder, String variant, boolean isProvided, boolean isSkipped, List<AndroidLibrary> androidLibraries, Collection<JavaLibrary> javaLibraries, Collection<File> localJavaLibraries)
/*     */   {
/*  80 */     super(buildId, projectPath, null, coordinates, isSkipped, isProvided);
/*  81 */     this.androidLibraries = ImmutableList.copyOf(androidLibraries);
/*  82 */     this.javaLibraries = ImmutableList.copyOf(javaLibraries);
/*  83 */     localJars = ImmutableList.copyOf(localJavaLibraries);
/*  84 */     this.variant = variant;
/*  85 */     this.bundle = bundle;
/*  86 */     folder = extractedFolder;
/*  87 */     hashcode = computeHashCode();
/*     */   }
/*     */   
/*     */   public String getProjectVariant()
/*     */   {
/*  93 */     return variant;
/*     */   }
/*     */   
/*     */   public File getBundle()
/*     */   {
/*  99 */     return bundle;
/*     */   }
/*     */   
/*     */   public File getFolder()
/*     */   {
/* 105 */     return folder;
/*     */   }
/*     */   
/*     */   public List<? extends AndroidLibrary> getLibraryDependencies()
/*     */   {
/* 111 */     return androidLibraries;
/*     */   }
/*     */   
/*     */   public Collection<? extends JavaLibrary> getJavaDependencies()
/*     */   {
/* 117 */     return javaLibraries;
/*     */   }
/*     */   
/*     */   public Collection<File> getLocalJars()
/*     */   {
/* 123 */     return localJars;
/*     */   }
/*     */   
/*     */   public File getManifest()
/*     */   {
/* 129 */     return new File(folder, "AndroidManifest.xml");
/*     */   }
/*     */   
/*     */   public File getJarFile()
/*     */   {
/* 135 */     return FileUtils.join(folder, new String[] { "jars", "classes.jar" });
/*     */   }
/*     */   
/*     */   public File getResFolder()
/*     */   {
/* 141 */     return new File(folder, "res");
/*     */   }
/*     */   
/*     */   public File getAssetsFolder()
/*     */   {
/* 147 */     return new File(folder, "assets");
/*     */   }
/*     */   
/*     */   public File getJniFolder()
/*     */   {
/* 153 */     return new File(folder, "jni");
/*     */   }
/*     */   
/*     */   public File getAidlFolder()
/*     */   {
/* 159 */     return new File(folder, "aidl");
/*     */   }
/*     */   
/*     */   public File getRenderscriptFolder()
/*     */   {
/* 166 */     return new File(folder, "rs");
/*     */   }
/*     */   
/*     */   public File getProguardRules()
/*     */   {
/* 172 */     return new File(folder, "proguard.txt");
/*     */   }
/*     */   
/*     */   public File getLintJar()
/*     */   {
/* 178 */     return new File(getJarFile().getParentFile(), "lint.jar");
/*     */   }
/*     */   
/*     */   public File getExternalAnnotations()
/*     */   {
/* 185 */     return new File(folder, "annotations.zip");
/*     */   }
/*     */   
/*     */   public File getPublicResources()
/*     */   {
/* 192 */     return new File(folder, "public.txt");
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public boolean isOptional()
/*     */   {
/* 199 */     return isProvided();
/*     */   }
/*     */   
/*     */   public File getSymbolFile()
/*     */   {
/* 205 */     return new File(folder, "R.txt");
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 211 */     if (this == o) {
/* 212 */       return true;
/*     */     }
/* 214 */     if ((o == null) || (getClass() != o.getClass())) {
/* 215 */       return false;
/*     */     }
/*     */     
/* 218 */     AndroidLibraryImpl that = (AndroidLibraryImpl)o;
/*     */     
/* 221 */     if ((hashcode != hashcode) || (!super.equals(o))) {
/* 222 */       return false;
/*     */     }
/*     */     
/* 225 */     return (Objects.equal(variant, variant)) && 
/* 226 */       (Objects.equal(bundle, bundle)) && 
/* 227 */       (Objects.equal(folder, folder)) && 
/* 228 */       (Objects.equal(androidLibraries, androidLibraries)) && 
/* 229 */       (Objects.equal(javaLibraries, javaLibraries)) && 
/* 230 */       (Objects.equal(localJars, localJars));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 235 */     return hashcode;
/*     */   }
/*     */   
/*     */   private int computeHashCode() {
/* 239 */     return Objects.hashCode(new Object[] {
/* 240 */       Integer.valueOf(super.hashCode()), variant, bundle, folder, androidLibraries, javaLibraries, localJars });
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 251 */     return 
/*     */     
/* 261 */       MoreObjects.toStringHelper(this).add("name", getName()).add("project", getProject()).add("variant", variant).add("bundle", bundle).add("folder", folder).add("androidLibraries", androidLibraries).add("javaLibraries", javaLibraries).add("localJars", localJars).add("super", super.toString()).toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.AndroidLibraryImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */