/*    */ package com.android.build.gradle.internal.pipeline;
/*    */ 
/*    */ import com.android.build.api.transform.QualifiedContent;
/*    */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*    */ import com.android.build.api.transform.QualifiedContent.Scope;
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ import com.google.common.collect.ImmutableSet;
/*    */ import java.io.File;
/*    */ import java.io.Serializable;
/*    */ import java.util.Set;
/*    */ 
/*    */ class QualifiedContentImpl
/*    */   implements QualifiedContent, Serializable
/*    */ {
/*    */   private final String name;
/*    */   private final File file;
/*    */   private final Set<QualifiedContent.ContentType> contentTypes;
/*    */   private final Set<? super QualifiedContent.Scope> scopes;
/*    */   
/*    */   protected QualifiedContentImpl(String name, File file, Set<QualifiedContent.ContentType> contentTypes, Set<? super QualifiedContent.Scope> scopes)
/*    */   {
/* 46 */     this.name = name;
/* 47 */     this.file = file;
/* 48 */     this.contentTypes = ImmutableSet.copyOf(contentTypes);
/* 49 */     this.scopes = ImmutableSet.copyOf(scopes);
/*    */   }
/*    */   
/*    */   protected QualifiedContentImpl(QualifiedContent qualifiedContent) {
/* 53 */     name = qualifiedContent.getName();
/* 54 */     file = qualifiedContent.getFile();
/* 55 */     contentTypes = qualifiedContent.getContentTypes();
/* 56 */     scopes = qualifiedContent.getScopes();
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 62 */     return name;
/*    */   }
/*    */   
/*    */   public File getFile()
/*    */   {
/* 68 */     return file;
/*    */   }
/*    */   
/*    */   public Set<QualifiedContent.ContentType> getContentTypes()
/*    */   {
/* 74 */     return contentTypes;
/*    */   }
/*    */   
/*    */   public Set<? super QualifiedContent.Scope> getScopes()
/*    */   {
/* 80 */     return scopes;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 85 */     return 
/*    */     
/* 90 */       MoreObjects.toStringHelper(this).add("name", name).add("file", file).add("contentTypes", contentTypes).add("scopes", scopes).toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.QualifiedContentImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */