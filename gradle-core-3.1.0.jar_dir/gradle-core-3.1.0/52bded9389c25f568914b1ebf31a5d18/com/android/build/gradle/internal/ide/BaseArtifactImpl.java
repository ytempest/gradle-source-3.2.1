/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.builder.model.BaseArtifact;
/*     */ import com.android.builder.model.Dependencies;
/*     */ import com.android.builder.model.SourceProvider;
/*     */ import com.android.builder.model.level2.DependencyGraphs;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ 
/*     */ abstract class BaseArtifactImpl
/*     */   implements BaseArtifact, Serializable
/*     */ {
/*     */   private final Collection<File> generatedSourceFolders;
/*     */   private final String name;
/*     */   private final String assembleTaskName;
/*     */   private final String compileTaskName;
/*     */   private final File classesFolder;
/*     */   private final File javaResourcesFolder;
/*     */   private final Dependencies compileDependencies;
/*     */   private final DependencyGraphs dependencyGraphs;
/*     */   private final Set<File> additionalClassesFolders;
/*     */   private final SourceProvider variantSourceProvider;
/*     */   private final SourceProvider multiFlavorSourceProviders;
/*     */   
/*     */   BaseArtifactImpl(String name, String assembleTaskName, String compileTaskName, File classesFolder, Set<File> additionalClassesFolders, File javaResourcesFolder, Dependencies compileDependencies, DependencyGraphs dependencyGraphs, SourceProvider variantSourceProvider, SourceProvider multiFlavorSourceProviders, Collection<File> generatedSourceFolders)
/*     */   {
/*  60 */     this.name = name;
/*  61 */     this.assembleTaskName = assembleTaskName;
/*  62 */     this.compileTaskName = compileTaskName;
/*  63 */     this.classesFolder = classesFolder;
/*  64 */     this.additionalClassesFolders = additionalClassesFolders;
/*  65 */     this.javaResourcesFolder = javaResourcesFolder;
/*  66 */     this.compileDependencies = compileDependencies;
/*  67 */     this.dependencyGraphs = dependencyGraphs;
/*  68 */     this.variantSourceProvider = variantSourceProvider;
/*  69 */     this.multiFlavorSourceProviders = multiFlavorSourceProviders;
/*  70 */     this.generatedSourceFolders = generatedSourceFolders;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  76 */     return name;
/*     */   }
/*     */   
/*     */   public String getCompileTaskName()
/*     */   {
/*  82 */     return compileTaskName;
/*     */   }
/*     */   
/*     */   public String getAssembleTaskName()
/*     */   {
/*  88 */     return assembleTaskName;
/*     */   }
/*     */   
/*     */   public File getClassesFolder()
/*     */   {
/*  94 */     return classesFolder;
/*     */   }
/*     */   
/*     */   public File getJavaResourcesFolder()
/*     */   {
/* 100 */     return javaResourcesFolder;
/*     */   }
/*     */   
/*     */   public Dependencies getDependencies()
/*     */   {
/* 106 */     return compileDependencies;
/*     */   }
/*     */   
/*     */   public Dependencies getCompileDependencies()
/*     */   {
/* 112 */     return getDependencies();
/*     */   }
/*     */   
/*     */   public DependencyGraphs getDependencyGraphs()
/*     */   {
/* 118 */     return dependencyGraphs;
/*     */   }
/*     */   
/*     */   public SourceProvider getVariantSourceProvider()
/*     */   {
/* 124 */     return variantSourceProvider;
/*     */   }
/*     */   
/*     */   public SourceProvider getMultiFlavorSourceProvider()
/*     */   {
/* 130 */     return multiFlavorSourceProviders;
/*     */   }
/*     */   
/*     */   public Collection<File> getGeneratedSourceFolders()
/*     */   {
/* 136 */     return generatedSourceFolders;
/*     */   }
/*     */   
/*     */   public Set<File> getAdditionalClassesFolders()
/*     */   {
/* 142 */     return additionalClassesFolders;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 147 */     if (this == o) {
/* 148 */       return true;
/*     */     }
/* 150 */     if ((o == null) || (getClass() != o.getClass())) {
/* 151 */       return false;
/*     */     }
/* 153 */     BaseArtifactImpl that = (BaseArtifactImpl)o;
/* 154 */     return (Objects.equals(generatedSourceFolders, generatedSourceFolders)) && 
/* 155 */       (Objects.equals(name, name)) && 
/* 156 */       (Objects.equals(assembleTaskName, assembleTaskName)) && 
/* 157 */       (Objects.equals(compileTaskName, compileTaskName)) && 
/* 158 */       (Objects.equals(classesFolder, classesFolder)) && 
/* 159 */       (Objects.equals(additionalClassesFolders, additionalClassesFolders)) && 
/* 160 */       (Objects.equals(javaResourcesFolder, javaResourcesFolder)) && 
/* 161 */       (Objects.equals(compileDependencies, compileDependencies)) && 
/* 162 */       (Objects.equals(dependencyGraphs, dependencyGraphs)) && 
/* 163 */       (Objects.equals(variantSourceProvider, variantSourceProvider)) && 
/* 164 */       (Objects.equals(multiFlavorSourceProviders, multiFlavorSourceProviders));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 169 */     return Objects.hash(new Object[] { generatedSourceFolders, name, assembleTaskName, compileTaskName, classesFolder, additionalClassesFolders, javaResourcesFolder, compileDependencies, dependencyGraphs, variantSourceProvider, multiFlavorSourceProviders });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.BaseArtifactImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */