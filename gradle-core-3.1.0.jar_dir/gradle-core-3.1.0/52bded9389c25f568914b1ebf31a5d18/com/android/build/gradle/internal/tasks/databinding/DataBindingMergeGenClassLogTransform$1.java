/*     */ package com.android.build.gradle.internal.tasks.databinding;
/*     */ 
/*     */ import java.io.File;
/*     */ import org.apache.commons.io.filefilter.IOFileFilter;
/*     */ 
/*     */ class DataBindingMergeGenClassLogTransform$1
/*     */   implements IOFileFilter
/*     */ {
/*     */   DataBindingMergeGenClassLogTransform$1(DataBindingMergeGenClassLogTransform this$0) {}
/*     */   
/*     */   public boolean accept(File file)
/*     */   {
/* 148 */     return DataBindingMergeGenClassLogTransform.access$000(file.getName());
/*     */   }
/*     */   
/*     */   public boolean accept(File dir, String name)
/*     */   {
/* 153 */     return DataBindingMergeGenClassLogTransform.access$000(name);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.databinding.DataBindingMergeGenClassLogTransform.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */