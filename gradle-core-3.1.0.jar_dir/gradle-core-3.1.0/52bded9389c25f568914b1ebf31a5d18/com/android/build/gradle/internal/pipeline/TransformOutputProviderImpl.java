/*    */ package com.android.build.gradle.internal.pipeline;
/*    */ 
/*    */ import com.android.build.api.transform.Format;
/*    */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*    */ import com.android.build.api.transform.QualifiedContent.Scope;
/*    */ import com.android.build.api.transform.TransformOutputProvider;
/*    */ import com.android.utils.FileUtils;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.Set;
/*    */ 
/*    */ class TransformOutputProviderImpl
/*    */   implements TransformOutputProvider
/*    */ {
/*    */   private final IntermediateFolderUtils folderUtils;
/*    */   
/*    */   TransformOutputProviderImpl(IntermediateFolderUtils folderUtils)
/*    */   {
/* 36 */     this.folderUtils = folderUtils;
/*    */   }
/*    */   
/*    */   public void deleteAll() throws IOException
/*    */   {
/* 41 */     FileUtils.cleanOutputDir(folderUtils.getRootFolder());
/*    */   }
/*    */   
/*    */   public File getContentLocation(String name, Set<QualifiedContent.ContentType> types, Set<? super QualifiedContent.Scope> scopes, Format format)
/*    */   {
/* 51 */     return folderUtils.getContentLocation(name, types, scopes, format);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.TransformOutputProviderImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */