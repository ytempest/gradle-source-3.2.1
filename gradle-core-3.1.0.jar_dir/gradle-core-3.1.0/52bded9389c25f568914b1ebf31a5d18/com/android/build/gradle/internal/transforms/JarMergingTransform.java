/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.api.transform.DirectoryInput;
/*     */ import com.android.build.api.transform.Format;
/*     */ import com.android.build.api.transform.JarInput;
/*     */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.api.transform.Transform;
/*     */ import com.android.build.api.transform.TransformException;
/*     */ import com.android.build.api.transform.TransformInput;
/*     */ import com.android.build.api.transform.TransformInvocation;
/*     */ import com.android.build.api.transform.TransformOutputProvider;
/*     */ import com.android.build.gradle.internal.pipeline.TransformManager;
/*     */ import com.android.builder.packaging.JarMerger;
/*     */ import com.android.builder.packaging.ZipEntryFilter;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class JarMergingTransform
/*     */   extends Transform
/*     */ {
/*     */   private final ImmutableSet<QualifiedContent.Scope> scopes;
/*     */   
/*     */   public JarMergingTransform(Set<QualifiedContent.Scope> scopes)
/*     */   {
/*  54 */     this.scopes = ImmutableSet.copyOf(scopes);
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  60 */     return "jarMerging";
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.ContentType> getInputTypes()
/*     */   {
/*  66 */     return TransformManager.CONTENT_CLASS;
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.Scope> getScopes()
/*     */   {
/*  72 */     return scopes;
/*     */   }
/*     */   
/*     */   public boolean isIncremental()
/*     */   {
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public void transform(TransformInvocation invocation)
/*     */     throws TransformException, IOException
/*     */   {
/*  83 */     TransformOutputProvider outputProvider = invocation.getOutputProvider();
/*  84 */     Preconditions.checkNotNull(outputProvider, "Missing output object for transform " + getName());
/*     */     
/*  89 */     File jarFile = outputProvider.getContentLocation("combined_classes", 
/*  90 */       getOutputTypes(), getScopes(), Format.JAR);
/*  91 */     FileUtils.mkdirs(jarFile.getParentFile());
/*  92 */     FileUtils.deleteIfExists(jarFile);
/*     */     try {
/*  94 */       JarMerger jarMerger = new JarMerger(jarFile.toPath(), ZipEntryFilter.CLASSES_ONLY);Throwable localThrowable3 = null;
/*  95 */       try { for (TransformInput input : invocation.getInputs()) {
/*  96 */           for (JarInput jarInput : input.getJarInputs()) {
/*  97 */             jarMerger.addJar(jarInput.getFile().toPath());
/*     */           }
/*     */           
/* 100 */           for (DirectoryInput directoryInput : input.getDirectoryInputs()) {
/* 101 */             jarMerger.addDirectory(directoryInput.getFile().toPath());
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (Throwable localThrowable5)
/*     */       {
/*  94 */         localThrowable3 = localThrowable5;throw localThrowable5;
/*     */       }
/*     */       finally
/*     */       {
/* 104 */         if (jarMerger != null) if (localThrowable3 != null) try { jarMerger.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else jarMerger.close();
/* 105 */       } } catch (IOException e) { throw new TransformException(e);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.JarMergingTransform
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */