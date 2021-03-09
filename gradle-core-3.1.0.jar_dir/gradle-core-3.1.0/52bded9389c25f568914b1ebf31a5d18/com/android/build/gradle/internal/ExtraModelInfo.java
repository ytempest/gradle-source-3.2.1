/*     */ package com.android.build.gradle.internal;
/*     */ 
/*     */ import com.android.build.gradle.api.BaseVariant;
/*     */ import com.android.build.gradle.internal.dependency.ConfigurationDependencyGraphs;
/*     */ import com.android.build.gradle.internal.dsl.CoreBuildType;
/*     */ import com.android.build.gradle.internal.dsl.CoreProductFlavor;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporterImpl;
/*     */ import com.android.build.gradle.internal.errors.MessageReceiverImpl;
/*     */ import com.android.build.gradle.internal.errors.SyncIssueHandler;
/*     */ import com.android.build.gradle.internal.errors.SyncIssueHandlerImpl;
/*     */ import com.android.build.gradle.internal.ide.ArtifactMetaDataImpl;
/*     */ import com.android.build.gradle.internal.ide.JavaArtifactImpl;
/*     */ import com.android.build.gradle.internal.variant.DefaultSourceProviderContainer;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.build.gradle.options.SyncOptions;
/*     */ import com.android.builder.model.AndroidArtifact;
/*     */ import com.android.builder.model.ArtifactMetaData;
/*     */ import com.android.builder.model.JavaArtifact;
/*     */ import com.android.builder.model.SourceProvider;
/*     */ import com.android.builder.model.SourceProviderContainer;
/*     */ import com.google.common.collect.ArrayListMultimap;
/*     */ import com.google.common.collect.ListMultimap;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import org.gradle.api.artifacts.Configuration;
/*     */ import org.gradle.api.logging.Logger;
/*     */ 
/*     */ public class ExtraModelInfo
/*     */ {
/*     */   private final DeprecationReporter deprecationReporter;
/*     */   private final SyncIssueHandler syncIssueHandler;
/*     */   private final MessageReceiverImpl messageReceiver;
/*  57 */   private final Map<String, ArtifactMetaData> extraArtifactMap = Maps.newHashMap();
/*  58 */   private final ListMultimap<String, AndroidArtifact> extraAndroidArtifacts = ArrayListMultimap.create();
/*  59 */   private final ListMultimap<String, JavaArtifact> extraJavaArtifacts = ArrayListMultimap.create();
/*     */   
/*  61 */   private final ListMultimap<String, SourceProviderContainer> extraBuildTypeSourceProviders = ArrayListMultimap.create();
/*  62 */   private final ListMultimap<String, SourceProviderContainer> extraProductFlavorSourceProviders = ArrayListMultimap.create();
/*  63 */   private final ListMultimap<String, SourceProviderContainer> extraMultiFlavorSourceProviders = ArrayListMultimap.create();
/*     */   
/*     */   public ExtraModelInfo(String projectPath, ProjectOptions projectOptions, Logger logger)
/*     */   {
/*  72 */     syncIssueHandler = new SyncIssueHandlerImpl(SyncOptions.getModelQueryMode(projectOptions), logger);
/*  73 */     deprecationReporter = new DeprecationReporterImpl(syncIssueHandler, projectPath);
/*  74 */     messageReceiver = new MessageReceiverImpl(projectOptions, logger);
/*     */   }
/*     */   
/*     */   public DeprecationReporter getDeprecationReporter() {
/*  78 */     return deprecationReporter;
/*     */   }
/*     */   
/*     */   public MessageReceiverImpl getMessageReceiver() {
/*  82 */     return messageReceiver;
/*     */   }
/*     */   
/*     */   public SyncIssueHandler getSyncIssueHandler() {
/*  86 */     return syncIssueHandler;
/*     */   }
/*     */   
/*     */   public Collection<ArtifactMetaData> getExtraArtifacts() {
/*  90 */     return extraArtifactMap.values();
/*     */   }
/*     */   
/*     */   public Collection<AndroidArtifact> getExtraAndroidArtifacts(String variantName) {
/*  94 */     return extraAndroidArtifacts.get(variantName);
/*     */   }
/*     */   
/*     */   public Collection<JavaArtifact> getExtraJavaArtifacts(String variantName) {
/*  98 */     return extraJavaArtifacts.get(variantName);
/*     */   }
/*     */   
/*     */   public Collection<SourceProviderContainer> getExtraFlavorSourceProviders(String flavorName)
/*     */   {
/* 103 */     return extraProductFlavorSourceProviders.get(flavorName);
/*     */   }
/*     */   
/*     */   public Collection<SourceProviderContainer> getExtraBuildTypeSourceProviders(String buildTypeName)
/*     */   {
/* 108 */     return extraBuildTypeSourceProviders.get(buildTypeName);
/*     */   }
/*     */   
/*     */   public void registerArtifactType(String name, boolean isTest, int artifactType)
/*     */   {
/* 115 */     if (extraArtifactMap.get(name) != null)
/*     */     {
/* 117 */       throw new IllegalArgumentException(String.format("Artifact with name %1$s already registered.", new Object[] { name }));
/*     */     }
/*     */     
/* 120 */     extraArtifactMap.put(name, new ArtifactMetaDataImpl(name, isTest, artifactType));
/*     */   }
/*     */   
/*     */   public void registerBuildTypeSourceProvider(String name, CoreBuildType buildType, SourceProvider sourceProvider)
/*     */   {
/* 126 */     if (extraArtifactMap.get(name) == null) {
/* 127 */       throw new IllegalArgumentException(String.format("Artifact with name %1$s is not yet registered. Use registerArtifactType()", new Object[] { name }));
/*     */     }
/*     */     
/* 132 */     extraBuildTypeSourceProviders.put(buildType.getName(), new DefaultSourceProviderContainer(name, sourceProvider));
/*     */   }
/*     */   
/*     */   public void registerProductFlavorSourceProvider(String name, CoreProductFlavor productFlavor, SourceProvider sourceProvider)
/*     */   {
/* 140 */     if (extraArtifactMap.get(name) == null) {
/* 141 */       throw new IllegalArgumentException(String.format("Artifact with name %1$s is not yet registered. Use registerArtifactType()", new Object[] { name }));
/*     */     }
/*     */     
/* 146 */     extraProductFlavorSourceProviders.put(productFlavor.getName(), new DefaultSourceProviderContainer(name, sourceProvider));
/*     */   }
/*     */   
/*     */   public void registerMultiFlavorSourceProvider(String name, String flavorName, SourceProvider sourceProvider)
/*     */   {
/* 154 */     if (extraArtifactMap.get(name) == null) {
/* 155 */       throw new IllegalArgumentException(String.format("Artifact with name %1$s is not yet registered. Use registerArtifactType()", new Object[] { name }));
/*     */     }
/*     */     
/* 160 */     extraMultiFlavorSourceProviders.put(flavorName, new DefaultSourceProviderContainer(name, sourceProvider));
/*     */   }
/*     */   
/*     */   public void registerJavaArtifact(String name, BaseVariant variant, String assembleTaskName, String javaCompileTaskName, Collection<File> generatedSourceFolders, Iterable<String> ideSetupTaskNames, Configuration configuration, File classesFolder, File javaResourcesFolder, SourceProvider sourceProvider)
/*     */   {
/* 175 */     ArtifactMetaData artifactMetaData = (ArtifactMetaData)extraArtifactMap.get(name);
/* 176 */     if (artifactMetaData == null) {
/* 177 */       throw new IllegalArgumentException(String.format("Artifact with name %1$s is not yet registered. Use registerArtifactType()", new Object[] { name }));
/*     */     }
/*     */     
/* 181 */     if (artifactMetaData.getType() != 2)
/*     */     {
/* 183 */       throw new IllegalArgumentException(String.format("Artifact with name %1$s is not of type JAVA", new Object[] { name }));
/*     */     }
/*     */     
/* 194 */     JavaArtifact artifact = new JavaArtifactImpl(name, assembleTaskName, javaCompileTaskName, ideSetupTaskNames, generatedSourceFolders, classesFolder, Collections.emptySet(), javaResourcesFolder, null, new ConfigurationDependencies(configuration), new ConfigurationDependencyGraphs(configuration), sourceProvider, null);
/*     */     
/* 202 */     extraJavaArtifacts.put(variant.getName(), artifact);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ExtraModelInfo
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */