/*    */ package com.android.build.gradle.internal.pipeline;
/*    */ 
/*    */ import com.android.build.api.transform.DirectoryInput;
/*    */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*    */ import com.android.build.api.transform.QualifiedContent.Scope;
/*    */ import com.android.build.api.transform.Status;
/*    */ import com.google.common.base.Splitter;
/*    */ import com.google.common.collect.Lists;
/*    */ import com.google.common.collect.Maps;
/*    */ import java.io.File;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ class MutableDirectoryInput
/*    */   extends QualifiedContentImpl
/*    */ {
/* 38 */   private final Map<File, Status> changedFiles = Maps.newHashMap();
/*    */   
/* 40 */   private List<String> rootLocationSegments = null;
/*    */   
/*    */   MutableDirectoryInput(String name, File file, Set<QualifiedContent.ContentType> contentTypes, Set<? super QualifiedContent.Scope> scopes)
/*    */   {
/* 47 */     super(name, file, contentTypes, scopes);
/*    */   }
/*    */   
/*    */   DirectoryInput asImmutable()
/*    */   {
/* 52 */     return new ImmutableDirectoryInput(
/* 53 */       getName(), getFile(), getContentTypes(), getScopes(), changedFiles);
/*    */   }
/*    */   
/*    */   boolean processForChangedFile(File file, List<String> fileSegments, Status status)
/*    */   {
/* 72 */     if (rootLocationSegments == null) {
/* 73 */       rootLocationSegments = Lists.newArrayList(
/* 74 */         Splitter.on(File.separatorChar).split(getFile().getAbsolutePath()));
/*    */     }
/*    */     
/* 77 */     if (fileSegments.size() <= rootLocationSegments.size()) {
/* 78 */       return false;
/*    */     }
/*    */     
/* 83 */     for (int i = rootLocationSegments.size() - 1; i >= 0; i--) {
/* 84 */       if (!((String)rootLocationSegments.get(i)).equals(fileSegments.get(i))) {
/* 85 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 90 */     addChangedFile(file, status);
/* 91 */     return true;
/*    */   }
/*    */   
/*    */   void addChangedFile(File file, Status status) {
/* 95 */     changedFiles.put(file, status);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.MutableDirectoryInput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */