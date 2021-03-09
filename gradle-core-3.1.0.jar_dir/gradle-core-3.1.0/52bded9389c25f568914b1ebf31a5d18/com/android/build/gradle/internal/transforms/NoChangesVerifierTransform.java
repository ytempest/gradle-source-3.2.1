/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.api.transform.DirectoryInput;
/*     */ import com.android.build.api.transform.JarInput;
/*     */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.DefaultContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.api.transform.Status;
/*     */ import com.android.build.api.transform.Transform;
/*     */ import com.android.build.api.transform.TransformException;
/*     */ import com.android.build.api.transform.TransformInput;
/*     */ import com.android.build.api.transform.TransformInvocation;
/*     */ import com.android.build.gradle.internal.incremental.InstantRunBuildContext;
/*     */ import com.android.build.gradle.internal.incremental.InstantRunVerifierStatus;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.common.collect.Sets.SetView;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class NoChangesVerifierTransform
/*     */   extends Transform
/*     */ {
/*     */   private final String transformName;
/*     */   private final InstantRunBuildContext buildContext;
/*     */   private final Set<QualifiedContent.ContentType> inputTypes;
/*     */   private final Set<? super QualifiedContent.Scope> mergeScopes;
/*     */   private final InstantRunVerifierStatus failureStatus;
/*     */   
/*     */   public NoChangesVerifierTransform(String transformName, InstantRunBuildContext buildContext, Set<QualifiedContent.ContentType> inputTypes, Set<? super QualifiedContent.Scope> mergeScopes, InstantRunVerifierStatus failureStatus)
/*     */   {
/*  60 */     this.transformName = transformName;
/*  61 */     this.buildContext = buildContext;
/*  62 */     this.inputTypes = inputTypes;
/*  63 */     this.mergeScopes = mergeScopes;
/*  64 */     this.failureStatus = failureStatus;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  70 */     return transformName;
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.ContentType> getInputTypes()
/*     */   {
/*  76 */     return inputTypes;
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.Scope> getScopes()
/*     */   {
/*  82 */     return ImmutableSet.of();
/*     */   }
/*     */   
/*     */   public Set<? super QualifiedContent.Scope> getReferencedScopes()
/*     */   {
/*  88 */     return mergeScopes;
/*     */   }
/*     */   
/*     */   public boolean isIncremental()
/*     */   {
/*  93 */     return true;
/*     */   }
/*     */   
/*     */   public void transform(TransformInvocation transformInvocation)
/*     */     throws TransformException, InterruptedException, IOException
/*     */   {
/* 102 */     if ((!transformInvocation.isIncremental()) || 
/* 103 */       (hasChangedInputs(transformInvocation.getReferencedInputs()))) {
/* 104 */       buildContext.setVerifierStatus(failureStatus);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean hasChangedInputs(Collection<TransformInput> inputs)
/*     */   {
/* 110 */     for (TransformInput input : inputs) {
/* 111 */       for (DirectoryInput directoryInput : input.getDirectoryInputs()) {
/* 112 */         if ((!Sets.intersection(directoryInput.getContentTypes(), inputTypes).isEmpty()) && 
/* 113 */           (!directoryInput.getChangedFiles().isEmpty())) {
/* 114 */           if (inputTypes.contains(QualifiedContent.DefaultContentType.CLASSES)) {
/* 115 */             return true;
/*     */           }
/* 117 */           for (File file : directoryInput.getChangedFiles().keySet()) {
/* 118 */             if (!file.getPath().endsWith(".class")) {
/* 119 */               return true;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 126 */       for (JarInput jarInput : input.getJarInputs()) {
/* 127 */         if ((!Sets.intersection(jarInput.getContentTypes(), inputTypes).isEmpty()) && 
/* 128 */           (jarInput.getStatus() != Status.NOTCHANGED)) {
/* 129 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 134 */     return false;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.NoChangesVerifierTransform
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */