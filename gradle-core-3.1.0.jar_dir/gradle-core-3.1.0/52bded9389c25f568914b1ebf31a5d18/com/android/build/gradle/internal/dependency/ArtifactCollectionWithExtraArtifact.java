/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import com.android.build.gradle.api.TestedComponentIdentifier;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import java.util.Spliterator;
/*     */ import java.util.function.Consumer;
/*     */ import org.gradle.api.artifacts.ArtifactCollection;
/*     */ import org.gradle.api.artifacts.component.ComponentArtifactIdentifier;
/*     */ import org.gradle.api.artifacts.component.ComponentIdentifier;
/*     */ import org.gradle.api.artifacts.result.ResolvedArtifactResult;
/*     */ import org.gradle.api.artifacts.result.ResolvedVariantResult;
/*     */ import org.gradle.api.component.Artifact;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ 
/*     */ public class ArtifactCollectionWithExtraArtifact
/*     */   implements ArtifactCollection
/*     */ {
/*     */   private final ArtifactCollection parentArtifacts;
/*     */   private final FileCollection extraArtifact;
/*     */   private final ExtraArtifactType extraArtifactType;
/*     */   private final String projectPath;
/*     */   private final String variantName;
/*     */   private final FileCollection combinedCollection;
/*     */   
/*     */   public static abstract interface ExtraComponentIdentifier
/*     */     extends ComponentIdentifier
/*     */   {}
/*     */   
/*     */   private static enum ExtraArtifactType
/*     */   {
/*  52 */     TEST, 
/*  53 */     OTHER;
/*     */     
/*     */     private ExtraArtifactType() {}
/*     */   }
/*     */   
/*  69 */   private Set<ResolvedArtifactResult> artifactResults = null;
/*     */   
/*     */   public static ArtifactCollectionWithExtraArtifact makeExtraCollectionForTest(ArtifactCollection parentArtifacts, FileCollection extraArtifact, String projectPath, String variantName)
/*     */   {
/*  77 */     return new ArtifactCollectionWithExtraArtifact(parentArtifacts, extraArtifact, ExtraArtifactType.TEST, projectPath, variantName);
/*     */   }
/*     */   
/*     */   public static ArtifactCollectionWithExtraArtifact makeExtraCollection(ArtifactCollection parentArtifacts, FileCollection extraArtifact, String projectPath)
/*     */   {
/*  86 */     return new ArtifactCollectionWithExtraArtifact(parentArtifacts, extraArtifact, ExtraArtifactType.OTHER, projectPath, null);
/*     */   }
/*     */   
/*     */   private ArtifactCollectionWithExtraArtifact(ArtifactCollection parentArtifacts, FileCollection extraArtifact, ExtraArtifactType extraArtifactType, String projectPath, String variantName)
/*     */   {
/*  96 */     Preconditions.checkState((variantName != null) || (extraArtifactType != ExtraArtifactType.TEST), "variant name should not be null for test extra type");
/*     */     
/*  99 */     this.parentArtifacts = parentArtifacts;
/* 100 */     this.extraArtifact = extraArtifact;
/* 101 */     this.extraArtifactType = extraArtifactType;
/* 102 */     this.projectPath = projectPath;
/* 103 */     this.variantName = variantName;
/*     */     
/* 105 */     combinedCollection = parentArtifacts.getArtifactFiles().plus(extraArtifact);
/*     */   }
/*     */   
/*     */   public FileCollection getArtifactFiles()
/*     */   {
/* 110 */     return combinedCollection;
/*     */   }
/*     */   
/*     */   public Set<ResolvedArtifactResult> getArtifacts()
/*     */   {
/* 115 */     if (artifactResults == null) {
/* 116 */       artifactResults = Sets.newLinkedHashSet();
/*     */       
/* 118 */       artifactResults.addAll(computeExtraArtifactResults());
/* 119 */       artifactResults.addAll(parentArtifacts.getArtifacts());
/*     */     }
/*     */     
/* 122 */     return artifactResults;
/*     */   }
/*     */   
/*     */   public Collection<Throwable> getFailures()
/*     */   {
/* 127 */     return parentArtifacts.getFailures();
/*     */   }
/*     */   
/*     */   public Iterator<ResolvedArtifactResult> iterator()
/*     */   {
/* 133 */     return getArtifacts().iterator();
/*     */   }
/*     */   
/*     */   public void forEach(Consumer<? super ResolvedArtifactResult> action)
/*     */   {
/* 138 */     getArtifacts().forEach(action);
/*     */   }
/*     */   
/*     */   public Spliterator<ResolvedArtifactResult> spliterator()
/*     */   {
/* 143 */     return getArtifacts().spliterator();
/*     */   }
/*     */   
/*     */   public ArtifactCollection getParentArtifacts()
/*     */   {
/* 149 */     return parentArtifacts;
/*     */   }
/*     */   
/*     */   private List<ResolvedArtifactResult> computeExtraArtifactResults()
/*     */   {
/* 154 */     Set<File> testedFiles = extraArtifact.getFiles();
/* 155 */     List<ResolvedArtifactResult> list = Lists.newArrayListWithCapacity(testedFiles.size());
/*     */     
/* 158 */     ExtraComponentArtifactIdentifier artifactId = new ExtraComponentArtifactIdentifier(extraArtifactType == ExtraArtifactType.TEST ? new TestedComponentIdentifierImpl(projectPath, variantName) : new ExtraComponentIdentifierImpl(projectPath));
/*     */     
/* 164 */     for (File file : testedFiles) {
/* 165 */       list.add(new ExtraResolvedArtifactResult(file, artifactId, null));
/*     */     }
/*     */     
/* 168 */     return list;
/*     */   }
/*     */   
/*     */   private static final class ExtraResolvedArtifactResult implements ResolvedArtifactResult
/*     */   {
/*     */     private final File artifactFile;
/*     */     private final ArtifactCollectionWithExtraArtifact.ExtraComponentArtifactIdentifier artifactId;
/*     */     
/*     */     private ExtraResolvedArtifactResult(File artifactFile, ArtifactCollectionWithExtraArtifact.ExtraComponentArtifactIdentifier artifactId)
/*     */     {
/* 178 */       this.artifactFile = artifactFile;
/* 179 */       this.artifactId = artifactId;
/*     */     }
/*     */     
/*     */     public File getFile()
/*     */     {
/* 184 */       return artifactFile;
/*     */     }
/*     */     
/*     */     public ResolvedVariantResult getVariant()
/*     */     {
/* 189 */       throw new UnsupportedOperationException("Call to ExtraResolvedArtifactResult.getVariant is not allowed");
/*     */     }
/*     */     
/*     */     public ComponentArtifactIdentifier getId()
/*     */     {
/* 195 */       return artifactId;
/*     */     }
/*     */     
/*     */     public Class<? extends Artifact> getType()
/*     */     {
/* 200 */       throw new UnsupportedOperationException("Call to ExtraResolvedArtifactResult.getType is not allowed");
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class ExtraComponentArtifactIdentifier
/*     */     implements ComponentArtifactIdentifier
/*     */   {
/*     */     private final ComponentIdentifier id;
/*     */     
/*     */     public ExtraComponentArtifactIdentifier(ComponentIdentifier id)
/*     */     {
/* 211 */       this.id = id;
/*     */     }
/*     */     
/*     */     public ComponentIdentifier getComponentIdentifier()
/*     */     {
/* 216 */       return id;
/*     */     }
/*     */     
/*     */     public String getDisplayName()
/*     */     {
/* 221 */       return id.getDisplayName();
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class TestedComponentIdentifierImpl
/*     */     implements TestedComponentIdentifier, ArtifactCollectionWithExtraArtifact.ExtraComponentIdentifier
/*     */   {
/*     */     private final String projectPath;
/*     */     private final String variantName;
/*     */     
/*     */     public TestedComponentIdentifierImpl(String projectPath, String variantName)
/*     */     {
/* 233 */       this.projectPath = projectPath;
/* 234 */       this.variantName = variantName;
/*     */     }
/*     */     
/*     */     public String getVariantName()
/*     */     {
/* 240 */       return variantName;
/*     */     }
/*     */     
/*     */     public String getDisplayName()
/*     */     {
/* 245 */       return "__tested_artifact__:" + projectPath;
/*     */     }
/*     */     
/*     */     public boolean equals(Object o)
/*     */     {
/* 250 */       if (this == o) {
/* 251 */         return true;
/*     */       }
/* 253 */       if ((o == null) || (getClass() != o.getClass())) {
/* 254 */         return false;
/*     */       }
/* 256 */       TestedComponentIdentifierImpl that = (TestedComponentIdentifierImpl)o;
/* 257 */       return (Objects.equals(projectPath, projectPath)) && 
/* 258 */         (Objects.equals(variantName, variantName));
/*     */     }
/*     */     
/*     */     public int hashCode()
/*     */     {
/* 263 */       return Objects.hash(new Object[] { projectPath, variantName });
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class ExtraComponentIdentifierImpl implements ArtifactCollectionWithExtraArtifact.ExtraComponentIdentifier
/*     */   {
/*     */     private final String projectPath;
/*     */     
/*     */     public ExtraComponentIdentifierImpl(String projectPath) {
/* 272 */       this.projectPath = projectPath;
/*     */     }
/*     */     
/*     */     public String getDisplayName()
/*     */     {
/* 277 */       return "__extra_artifact__:" + projectPath;
/*     */     }
/*     */     
/*     */     public boolean equals(Object o)
/*     */     {
/* 282 */       if (this == o) {
/* 283 */         return true;
/*     */       }
/* 285 */       if ((o == null) || (getClass() != o.getClass())) {
/* 286 */         return false;
/*     */       }
/* 288 */       ExtraComponentIdentifierImpl that = (ExtraComponentIdentifierImpl)o;
/* 289 */       return Objects.equals(projectPath, projectPath);
/*     */     }
/*     */     
/*     */     public int hashCode()
/*     */     {
/* 294 */       return Objects.hash(new Object[] { projectPath });
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.ArtifactCollectionWithExtraArtifact
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */