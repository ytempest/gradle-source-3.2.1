/*    */ package com.android.build.gradle.internal.pipeline;
/*    */ 
/*    */ import com.android.build.api.transform.JarInput;
/*    */ import com.android.build.api.transform.QualifiedContent;
/*    */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*    */ import com.android.build.api.transform.QualifiedContent.Scope;
/*    */ import com.android.build.api.transform.Status;
/*    */ import com.google.common.base.Joiner;
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ import java.io.File;
/*    */ import java.util.Set;
/*    */ 
/*    */ class ImmutableJarInput
/*    */   extends QualifiedContentImpl
/*    */   implements JarInput
/*    */ {
/*    */   private final Status status;
/*    */   
/*    */   ImmutableJarInput(String name, File file, Status status, Set<QualifiedContent.ContentType> contentTypes, Set<? super QualifiedContent.Scope> scopes)
/*    */   {
/* 44 */     super(name, file, contentTypes, scopes);
/* 45 */     this.status = status;
/*    */   }
/*    */   
/*    */   ImmutableJarInput(QualifiedContent qualifiedContent, Status status)
/*    */   {
/* 51 */     super(qualifiedContent);
/* 52 */     this.status = status;
/*    */   }
/*    */   
/*    */   public Status getStatus()
/*    */   {
/* 58 */     return status;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 63 */     return 
/*    */     
/* 69 */       MoreObjects.toStringHelper(this).add("name", getName()).add("file", getFile()).add("contentTypes", Joiner.on(',').join(getContentTypes())).add("scopes", Joiner.on(',').join(getScopes())).add("status", status).toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.ImmutableJarInput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */