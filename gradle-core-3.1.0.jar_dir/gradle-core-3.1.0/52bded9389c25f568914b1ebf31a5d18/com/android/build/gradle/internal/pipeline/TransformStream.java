/*     */ package com.android.build.gradle.internal.pipeline;
/*     */ 
/*     */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.DefaultContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.api.transform.TransformInput;
/*     */ import com.google.common.collect.Iterables;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.file.FileTree;
/*     */ import org.gradle.api.tasks.util.PatternSet;
/*     */ 
/*     */ public abstract class TransformStream
/*     */ {
/*  53 */   private static final PatternSet INCLUDE_CLASSES = new PatternSet()
/*     */   
/*  55 */     .include(new String[] { "**/*.class" })
/*  56 */     .include(new String[] { "**/*.jar" })
/*  57 */     .include(new String[] { "META-INF/*.kotlin_module" });
/*  58 */   private static final PatternSet EXCLUDE_CLASSES = new PatternSet().exclude(new String[] { "**/*.class" });
/*  59 */   private static final PatternSet INCLUDE_SO = new PatternSet()
/*  60 */     .include(new String[] { "**/*.so" }).include(new String[] { "**/*.jar" });
/*  61 */   private static final PatternSet INCLUDE_DEX = new PatternSet()
/*  62 */     .include(new String[] { "**/*.dex" }).include(new String[] { "**/*.jar" });
/*  63 */   private static final PatternSet INCLUDE_DATABINDING_BIN = new PatternSet();
/*  64 */   private static final PatternSet INCLUDE_DATABINDING_BASE_LOG = new PatternSet();
/*     */   
/*     */   private final String name;
/*     */   
/*     */   private final Set<QualifiedContent.ContentType> contentTypes;
/*     */   
/*     */   private final Set<? super QualifiedContent.Scope> scopes;
/*     */   
/*     */   private final FileCollection fileCollection;
/*     */   
/*     */   protected TransformStream(String name, Set<QualifiedContent.ContentType> contentTypes, Set<? super QualifiedContent.Scope> scopes, FileCollection fileCollection)
/*     */   {
/*  86 */     this.name = name;
/*  87 */     this.contentTypes = contentTypes;
/*  88 */     this.scopes = scopes;
/*  89 */     this.fileCollection = fileCollection;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  94 */     return name;
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.ContentType> getContentTypes()
/*     */   {
/* 105 */     return contentTypes;
/*     */   }
/*     */   
/*     */   public Set<? super QualifiedContent.Scope> getScopes()
/*     */   {
/* 116 */     return scopes;
/*     */   }
/*     */   
/*     */   public FileCollection getFileCollection()
/*     */   {
/* 122 */     return fileCollection;
/*     */   }
/*     */   
/*     */   public FileTree getAsFileTree()
/*     */   {
/* 135 */     FileTree fileTree = fileCollection.getAsFileTree();
/*     */     
/* 137 */     PatternSet pattern = getPatternSet();
/* 138 */     if (pattern != null) {
/* 139 */       return fileTree.matching(pattern);
/*     */     }
/*     */     
/* 142 */     return fileTree;
/*     */   }
/*     */   
/*     */   private PatternSet getPatternSet()
/*     */   {
/* 147 */     if (contentTypes.size() == 1) {
/* 148 */       return getSingleTypePatternSet((QualifiedContent.ContentType)Iterables.getOnlyElement(contentTypes));
/*     */     }
/*     */     
/* 153 */     if ((contentTypes.size() == 2) && 
/* 154 */       (contentTypes.contains(ExtendedContentType.NATIVE_LIBS)) && 
/* 155 */       (contentTypes.contains(QualifiedContent.DefaultContentType.RESOURCES)))
/*     */     {
/* 157 */       return EXCLUDE_CLASSES;
/*     */     }
/*     */     
/* 162 */     return null;
/*     */   }
/*     */   
/*     */   private static PatternSet getSingleTypePatternSet(QualifiedContent.ContentType type)
/*     */   {
/* 167 */     if ((type instanceof QualifiedContent.DefaultContentType)) {
/* 168 */       switch ((QualifiedContent.DefaultContentType)type) {
/*     */       case CLASSES: 
/* 170 */         return INCLUDE_CLASSES;
/*     */       
/*     */       case RESOURCES: 
/* 174 */         return EXCLUDE_CLASSES;
/*     */       }
/* 176 */       throw new RuntimeException("Unsupported DefaultContentType value: " + type);
/*     */     }
/*     */     
/* 179 */     if ((type instanceof ExtendedContentType)) {
/* 180 */       switch ((ExtendedContentType)type) {
/*     */       case DEX: 
/*     */       case DEX_ARCHIVE: 
/* 183 */         return INCLUDE_DEX;
/*     */       case NATIVE_LIBS: 
/* 185 */         return INCLUDE_SO;
/*     */       case CLASSES_ENHANCED: 
/* 187 */         return INCLUDE_CLASSES;
/*     */       case DATA_BINDING: 
/* 189 */         return INCLUDE_DATABINDING_BIN;
/*     */       case DATA_BINDING_BASE_CLASS_LOG: 
/* 191 */         return INCLUDE_DATABINDING_BASE_LOG;
/*     */       }
/* 193 */       throw new RuntimeException("Unsupported ExtendedContentType value: " + type);
/*     */     }
/*     */     
/* 198 */     throw new RuntimeException("Unsupported ContentType implementation: " + type.getClass().getCanonicalName());
/*     */   }
/*     */   
/*     */   abstract TransformInput asNonIncrementalInput();
/*     */   
/*     */   abstract IncrementalTransformInput asIncrementalInput();
/*     */   
/*     */   abstract TransformStream makeRestrictedCopy(Set<QualifiedContent.ContentType> paramSet, Set<? super QualifiedContent.Scope> paramSet1);
/*     */   
/*     */   FileCollection getOutputFileCollection(Project project, StreamFilter streamFilter)
/*     */   {
/* 237 */     return fileCollection;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.TransformStream
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */