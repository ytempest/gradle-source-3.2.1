/*    */ package com.android.build.gradle.internal.transforms;
/*    */ 
/*    */ import com.android.build.api.transform.QualifiedContent;
/*    */ import java.io.File;
/*    */ import java.nio.file.Path;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ 
/*    */ final class DexArchiveBuilderCacheHandler$CacheableItem
/*    */ {
/*    */   final QualifiedContent input;
/*    */   final Collection<File> cachable;
/*    */   final List<Path> dependencies;
/*    */   
/*    */   DexArchiveBuilderCacheHandler$CacheableItem(QualifiedContent input, Collection<File> cachable, List<Path> dependencies)
/*    */   {
/* 66 */     this.input = input;
/* 67 */     this.cachable = cachable;
/* 68 */     this.dependencies = dependencies;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.DexArchiveBuilderCacheHandler.CacheableItem
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */