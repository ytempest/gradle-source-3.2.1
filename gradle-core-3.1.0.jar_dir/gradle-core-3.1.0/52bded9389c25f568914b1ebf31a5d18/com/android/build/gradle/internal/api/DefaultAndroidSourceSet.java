/*     */ package com.android.build.gradle.internal.api;
/*     */ 
/*     */ import com.android.build.gradle.api.AndroidSourceDirectorySet;
/*     */ import com.android.build.gradle.api.AndroidSourceFile;
/*     */ import com.android.build.gradle.api.AndroidSourceSet;
/*     */ import com.android.builder.model.SourceProvider;
/*     */ import groovy.lang.Closure;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Set;
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.tasks.util.PatternFilterable;
/*     */ import org.gradle.util.ConfigureUtil;
/*     */ import org.gradle.util.GUtil;
/*     */ 
/*     */ public class DefaultAndroidSourceSet
/*     */   implements AndroidSourceSet, SourceProvider
/*     */ {
/*     */   private final String name;
/*     */   private final boolean publishPackage;
/*     */   private final AndroidSourceDirectorySet javaSource;
/*     */   private final AndroidSourceDirectorySet javaResources;
/*     */   private final AndroidSourceFile manifest;
/*     */   private final AndroidSourceDirectorySet assets;
/*     */   private final AndroidSourceDirectorySet res;
/*     */   private final AndroidSourceDirectorySet aidl;
/*     */   private final AndroidSourceDirectorySet renderscript;
/*     */   private final AndroidSourceDirectorySet jni;
/*     */   private final AndroidSourceDirectorySet jniLibs;
/*     */   private final AndroidSourceDirectorySet shaders;
/*     */   private final String displayName;
/*     */   
/*     */   @Inject
/*     */   public DefaultAndroidSourceSet(String name, Project project, boolean publishPackage)
/*     */   {
/*  69 */     this.name = name;
/*  70 */     this.publishPackage = publishPackage;
/*  71 */     displayName = GUtil.toWords(this.name);
/*     */     
/*  73 */     String javaSrcDisplayName = displayName + " Java source";
/*     */     
/*  75 */     javaSource = new DefaultAndroidSourceDirectorySet(javaSrcDisplayName, project);
/*  76 */     javaSource.getFilter().include(new String[] { "**/*.java" });
/*     */     
/*  78 */     String javaResourcesDisplayName = displayName + " Java resources";
/*  79 */     javaResources = new DefaultAndroidSourceDirectorySet(javaResourcesDisplayName, project);
/*  80 */     javaResources.getFilter().exclude(new String[] { "**/*.java" });
/*     */     
/*  82 */     String manifestDisplayName = displayName + " manifest";
/*  83 */     manifest = new DefaultAndroidSourceFile(manifestDisplayName, project);
/*     */     
/*  85 */     String assetsDisplayName = displayName + " assets";
/*  86 */     assets = new DefaultAndroidSourceDirectorySet(assetsDisplayName, project);
/*     */     
/*  88 */     String resourcesDisplayName = displayName + " resources";
/*  89 */     res = new DefaultAndroidSourceDirectorySet(resourcesDisplayName, project);
/*     */     
/*  91 */     String aidlDisplayName = displayName + " aidl";
/*  92 */     aidl = new DefaultAndroidSourceDirectorySet(aidlDisplayName, project);
/*     */     
/*  94 */     String renderscriptDisplayName = displayName + " renderscript";
/*  95 */     renderscript = new DefaultAndroidSourceDirectorySet(renderscriptDisplayName, project);
/*     */     
/*  97 */     String jniDisplayName = displayName + " jni";
/*  98 */     jni = new DefaultAndroidSourceDirectorySet(jniDisplayName, project);
/*     */     
/* 100 */     String libsDisplayName = displayName + " jniLibs";
/* 101 */     jniLibs = new DefaultAndroidSourceDirectorySet(libsDisplayName, project);
/*     */     
/* 103 */     String shaderDisplayName = displayName + " shaders";
/* 104 */     shaders = new DefaultAndroidSourceDirectorySet(shaderDisplayName, project);
/*     */     
/* 106 */     setRoot("src/" + getName());
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 112 */     return name;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 118 */     return "source set " + getDisplayName();
/*     */   }
/*     */   
/*     */   public String getDisplayName() {
/* 122 */     return displayName;
/*     */   }
/*     */   
/*     */   public String getApiConfigurationName()
/*     */   {
/* 128 */     if (name.equals("main")) {
/* 129 */       return "api";
/*     */     }
/* 131 */     return name + "Api";
/*     */   }
/*     */   
/*     */   public String getCompileOnlyConfigurationName()
/*     */   {
/* 138 */     if (name.equals("main")) {
/* 139 */       return "compileOnly";
/*     */     }
/* 141 */     return name + "CompileOnly";
/*     */   }
/*     */   
/*     */   public String getImplementationConfigurationName()
/*     */   {
/* 148 */     if (name.equals("main")) {
/* 149 */       return "implementation";
/*     */     }
/* 151 */     return name + "Implementation";
/*     */   }
/*     */   
/*     */   public String getRuntimeOnlyConfigurationName()
/*     */   {
/* 158 */     if (name.equals("main")) {
/* 159 */       return "runtimeOnly";
/*     */     }
/* 161 */     return name + "RuntimeOnly";
/*     */   }
/*     */   
/*     */   public String getCompileConfigurationName()
/*     */   {
/* 168 */     if (name.equals("main")) {
/* 169 */       return "compile";
/*     */     }
/* 171 */     return name + "Compile";
/*     */   }
/*     */   
/*     */   public String getPackageConfigurationName()
/*     */   {
/* 178 */     if (publishPackage) {
/* 179 */       if (name.equals("main")) {
/* 180 */         return "publish";
/*     */       }
/* 182 */       return name + "Publish";
/*     */     }
/*     */     
/* 186 */     if (name.equals("main")) {
/* 187 */       return "apk";
/*     */     }
/* 189 */     return name + "Apk";
/*     */   }
/*     */   
/*     */   public String getProvidedConfigurationName()
/*     */   {
/* 196 */     if (name.equals("main")) {
/* 197 */       return "provided";
/*     */     }
/* 199 */     return name + "Provided";
/*     */   }
/*     */   
/*     */   public String getWearAppConfigurationName()
/*     */   {
/* 206 */     if (name.equals("main")) {
/* 207 */       return "wearApp";
/*     */     }
/* 209 */     return name + "WearApp";
/*     */   }
/*     */   
/*     */   public String getAnnotationProcessorConfigurationName()
/*     */   {
/* 216 */     if (name.equals("main")) {
/* 217 */       return "annotationProcessor";
/*     */     }
/* 219 */     return name + "AnnotationProcessor";
/*     */   }
/*     */   
/*     */   public AndroidSourceFile getManifest()
/*     */   {
/* 226 */     return manifest;
/*     */   }
/*     */   
/*     */   public AndroidSourceSet manifest(Closure configureClosure)
/*     */   {
/* 232 */     ConfigureUtil.configure(configureClosure, getManifest());
/* 233 */     return this;
/*     */   }
/*     */   
/*     */   public AndroidSourceDirectorySet getRes()
/*     */   {
/* 239 */     return res;
/*     */   }
/*     */   
/*     */   public AndroidSourceSet res(Closure configureClosure)
/*     */   {
/* 245 */     ConfigureUtil.configure(configureClosure, getRes());
/* 246 */     return this;
/*     */   }
/*     */   
/*     */   public AndroidSourceDirectorySet getAssets()
/*     */   {
/* 252 */     return assets;
/*     */   }
/*     */   
/*     */   public AndroidSourceSet assets(Closure configureClosure)
/*     */   {
/* 258 */     ConfigureUtil.configure(configureClosure, getAssets());
/* 259 */     return this;
/*     */   }
/*     */   
/*     */   public AndroidSourceDirectorySet getAidl()
/*     */   {
/* 265 */     return aidl;
/*     */   }
/*     */   
/*     */   public AndroidSourceSet aidl(Closure configureClosure)
/*     */   {
/* 271 */     ConfigureUtil.configure(configureClosure, getAidl());
/* 272 */     return this;
/*     */   }
/*     */   
/*     */   public AndroidSourceDirectorySet getRenderscript()
/*     */   {
/* 278 */     return renderscript;
/*     */   }
/*     */   
/*     */   public AndroidSourceSet renderscript(Closure configureClosure)
/*     */   {
/* 284 */     ConfigureUtil.configure(configureClosure, getRenderscript());
/* 285 */     return this;
/*     */   }
/*     */   
/*     */   public AndroidSourceDirectorySet getJni()
/*     */   {
/* 291 */     return jni;
/*     */   }
/*     */   
/*     */   public AndroidSourceSet jni(Closure configureClosure)
/*     */   {
/* 297 */     ConfigureUtil.configure(configureClosure, getJni());
/* 298 */     return this;
/*     */   }
/*     */   
/*     */   public AndroidSourceDirectorySet getJniLibs()
/*     */   {
/* 304 */     return jniLibs;
/*     */   }
/*     */   
/*     */   public AndroidSourceSet jniLibs(Closure configureClosure)
/*     */   {
/* 310 */     ConfigureUtil.configure(configureClosure, getJniLibs());
/* 311 */     return this;
/*     */   }
/*     */   
/*     */   public AndroidSourceSet shaders(Closure configureClosure)
/*     */   {
/* 317 */     ConfigureUtil.configure(configureClosure, getShaders());
/* 318 */     return this;
/*     */   }
/*     */   
/*     */   public AndroidSourceDirectorySet getShaders()
/*     */   {
/* 324 */     return shaders;
/*     */   }
/*     */   
/*     */   public AndroidSourceDirectorySet getJava()
/*     */   {
/* 330 */     return javaSource;
/*     */   }
/*     */   
/*     */   public AndroidSourceSet java(Closure configureClosure)
/*     */   {
/* 336 */     ConfigureUtil.configure(configureClosure, getJava());
/* 337 */     return this;
/*     */   }
/*     */   
/*     */   public AndroidSourceDirectorySet getResources()
/*     */   {
/* 344 */     return javaResources;
/*     */   }
/*     */   
/*     */   public AndroidSourceSet resources(Closure configureClosure)
/*     */   {
/* 350 */     ConfigureUtil.configure(configureClosure, getResources());
/* 351 */     return this;
/*     */   }
/*     */   
/*     */   public AndroidSourceSet setRoot(String path)
/*     */   {
/* 357 */     javaSource.setSrcDirs(Collections.singletonList(path + "/java"));
/* 358 */     javaResources.setSrcDirs(Collections.singletonList(path + "/resources"));
/* 359 */     res.setSrcDirs(Collections.singletonList(path + "/" + "res"));
/* 360 */     assets.setSrcDirs(Collections.singletonList(path + "/" + "assets"));
/* 361 */     manifest.srcFile(path + "/" + "AndroidManifest.xml");
/* 362 */     aidl.setSrcDirs(Collections.singletonList(path + "/aidl"));
/* 363 */     renderscript.setSrcDirs(Collections.singletonList(path + "/rs"));
/* 364 */     jni.setSrcDirs(Collections.singletonList(path + "/jni"));
/* 365 */     jniLibs.setSrcDirs(Collections.singletonList(path + "/jniLibs"));
/* 366 */     shaders.setSrcDirs(Collections.singletonList(path + "/shaders"));
/* 367 */     return this;
/*     */   }
/*     */   
/*     */   public Set<File> getJavaDirectories()
/*     */   {
/* 375 */     return getJava().getSrcDirs();
/*     */   }
/*     */   
/*     */   public Set<File> getResourcesDirectories()
/*     */   {
/* 381 */     return getResources().getSrcDirs();
/*     */   }
/*     */   
/*     */   public File getManifestFile()
/*     */   {
/* 387 */     return getManifest().getSrcFile();
/*     */   }
/*     */   
/*     */   public Set<File> getAidlDirectories()
/*     */   {
/* 393 */     return getAidl().getSrcDirs();
/*     */   }
/*     */   
/*     */   public Set<File> getRenderscriptDirectories()
/*     */   {
/* 399 */     return getRenderscript().getSrcDirs();
/*     */   }
/*     */   
/*     */   public Set<File> getCDirectories()
/*     */   {
/* 405 */     return getJni().getSrcDirs();
/*     */   }
/*     */   
/*     */   public Set<File> getCppDirectories()
/*     */   {
/* 413 */     return getJni().getSrcDirs();
/*     */   }
/*     */   
/*     */   public Set<File> getResDirectories()
/*     */   {
/* 419 */     return getRes().getSrcDirs();
/*     */   }
/*     */   
/*     */   public Set<File> getAssetsDirectories()
/*     */   {
/* 425 */     return getAssets().getSrcDirs();
/*     */   }
/*     */   
/*     */   public Collection<File> getJniLibsDirectories()
/*     */   {
/* 431 */     return getJniLibs().getSrcDirs();
/*     */   }
/*     */   
/*     */   public Collection<File> getShadersDirectories()
/*     */   {
/* 437 */     return getShaders().getSrcDirs();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.DefaultAndroidSourceSet
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */