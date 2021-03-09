/*    */ package com.android.build.gradle.internal.pipeline;
/*    */ 
/*    */ import com.android.build.api.transform.DirectoryInput;
/*    */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*    */ import com.android.build.api.transform.QualifiedContent.Scope;
/*    */ import com.android.build.api.transform.Status;
/*    */ import com.google.common.base.Joiner;
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ import com.google.common.collect.ImmutableMap;
/*    */ import java.io.File;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ class ImmutableDirectoryInput
/*    */   extends QualifiedContentImpl
/*    */   implements DirectoryInput
/*    */ {
/*    */   private final Map<File, Status> changedFiles;
/*    */   
/*    */   ImmutableDirectoryInput(String name, File file, Set<QualifiedContent.ContentType> contentTypes, Set<? super QualifiedContent.Scope> scopes)
/*    */   {
/* 44 */     super(name, file, contentTypes, scopes);
/* 45 */     changedFiles = ImmutableMap.of();
/*    */   }
/*    */   
/*    */   protected ImmutableDirectoryInput(String name, File file, Set<QualifiedContent.ContentType> contentTypes, Set<? super QualifiedContent.Scope> scopes, Map<File, Status> changedFiles)
/*    */   {
/* 54 */     super(name, file, contentTypes, scopes);
/* 55 */     this.changedFiles = ImmutableMap.copyOf(changedFiles);
/*    */   }
/*    */   
/*    */   public Map<File, Status> getChangedFiles()
/*    */   {
/* 61 */     return changedFiles;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 66 */     return 
/*    */     
/* 72 */       MoreObjects.toStringHelper(this).add("name", getName()).add("file", getFile()).add("contentTypes", Joiner.on(',').join(getContentTypes())).add("scopes", Joiner.on(',').join(getScopes())).add("changedFiles", changedFiles).toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.ImmutableDirectoryInput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */