/*    */ package com.android.build.gradle.internal.pipeline;
/*    */ 
/*    */ import com.android.build.api.transform.DirectoryInput;
/*    */ import com.android.build.api.transform.JarInput;
/*    */ import com.android.build.api.transform.TransformInput;
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import java.io.File;
/*    */ import java.util.Collection;
/*    */ 
/*    */ class ImmutableTransformInput
/*    */   implements TransformInput
/*    */ {
/*    */   private File optionalRootLocation;
/*    */   private final Collection<JarInput> jarInputs;
/*    */   private final Collection<DirectoryInput> directoryInputs;
/*    */   
/*    */   ImmutableTransformInput(Collection<JarInput> jarInputs, Collection<DirectoryInput> directoryInputs, File optionalRootLocation)
/*    */   {
/* 44 */     this.jarInputs = ImmutableList.copyOf(jarInputs);
/* 45 */     this.directoryInputs = ImmutableList.copyOf(directoryInputs);
/* 46 */     this.optionalRootLocation = optionalRootLocation;
/*    */   }
/*    */   
/*    */   public Collection<JarInput> getJarInputs()
/*    */   {
/* 52 */     return jarInputs;
/*    */   }
/*    */   
/*    */   public Collection<DirectoryInput> getDirectoryInputs()
/*    */   {
/* 58 */     return directoryInputs;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 63 */     return 
/*    */     
/* 67 */       MoreObjects.toStringHelper(this).add("rootLocation", optionalRootLocation).add("jarInputs", jarInputs).add("folderInputs", directoryInputs).toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.ImmutableTransformInput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */