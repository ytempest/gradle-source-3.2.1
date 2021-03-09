/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.builder.model.Dependencies;
/*     */ import com.android.builder.model.JavaArtifact;
/*     */ import com.android.builder.model.SourceProvider;
/*     */ import com.android.builder.model.level2.DependencyGraphs;
/*     */ import com.google.common.base.Objects;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Set;
/*     */ 
/*     */ public final class JavaArtifactImpl
/*     */   extends BaseArtifactImpl
/*     */   implements JavaArtifact, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final Set<String> ideSetupTaskNames;
/*     */   private final File mockablePlatformJar;
/*     */   
/*     */   public static JavaArtifactImpl clone(JavaArtifact javaArtifact, int modelLevel, boolean modelWithFullDependency)
/*     */   {
/*  45 */     SourceProvider variantSP = javaArtifact.getVariantSourceProvider();
/*  46 */     SourceProvider flavorsSP = javaArtifact.getMultiFlavorSourceProvider();
/*     */     
/*  48 */     return new JavaArtifactImpl(javaArtifact
/*  49 */       .getName(), javaArtifact
/*  50 */       .getAssembleTaskName(), javaArtifact
/*  51 */       .getCompileTaskName(), javaArtifact
/*  52 */       .getIdeSetupTaskNames(), javaArtifact
/*  53 */       .getGeneratedSourceFolders(), javaArtifact
/*  54 */       .getClassesFolder(), javaArtifact
/*  55 */       .getAdditionalClassesFolders(), javaArtifact
/*  56 */       .getJavaResourcesFolder(), javaArtifact
/*  57 */       .getMockablePlatformJar(), 
/*  58 */       ArtifactDependencyGraph.clone(javaArtifact.getDependencies(), modelLevel), 
/*  59 */       ArtifactDependencyGraph.clone(javaArtifact
/*  60 */       .getDependencyGraphs(), modelLevel, modelWithFullDependency), variantSP != null ? new SourceProviderImpl(variantSP) : null, flavorsSP != null ? new SourceProviderImpl(flavorsSP) : null);
/*     */   }
/*     */   
/*     */   public JavaArtifactImpl(String name, String assembleTaskName, String compileTaskName, Iterable<String> ideSetupTaskNames, Collection<File> generatedSourceFolders, File classesFolder, Set<File> additionalClassesFolders, File javaResourcesFolder, File mockablePlatformJar, Dependencies compileDependencies, DependencyGraphs dependencyGraphs, SourceProvider variantSourceProvider, SourceProvider multiFlavorSourceProviders)
/*     */   {
/*  79 */     super(name, assembleTaskName, compileTaskName, classesFolder, additionalClassesFolders, javaResourcesFolder, compileDependencies, dependencyGraphs, variantSourceProvider, multiFlavorSourceProviders, generatedSourceFolders);
/*     */     
/*  91 */     this.mockablePlatformJar = mockablePlatformJar;
/*  92 */     this.ideSetupTaskNames = Sets.newHashSet(ideSetupTaskNames);
/*     */   }
/*     */   
/*     */   public Set<String> getIdeSetupTaskNames()
/*     */   {
/*  98 */     return ideSetupTaskNames;
/*     */   }
/*     */   
/*     */   public File getMockablePlatformJar()
/*     */   {
/* 104 */     return mockablePlatformJar;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 109 */     if (this == o) {
/* 110 */       return true;
/*     */     }
/* 112 */     if ((o == null) || (getClass() != o.getClass())) {
/* 113 */       return false;
/*     */     }
/* 115 */     if (!super.equals(o)) {
/* 116 */       return false;
/*     */     }
/* 118 */     JavaArtifactImpl that = (JavaArtifactImpl)o;
/* 119 */     return (Objects.equal(ideSetupTaskNames, ideSetupTaskNames)) && 
/* 120 */       (Objects.equal(mockablePlatformJar, mockablePlatformJar));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 125 */     return Objects.hashCode(new Object[] { Integer.valueOf(super.hashCode()), ideSetupTaskNames, mockablePlatformJar });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.JavaArtifactImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */