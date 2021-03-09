/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.function.Supplier;
/*     */ 
/*     */ class TaskInputHelper$Bypasser
/*     */   implements Supplier<Collection<File>>, Callable<Collection<File>>
/*     */ {
/*     */   private final Supplier<Collection<File>> supplier;
/*     */   
/*     */   public TaskInputHelper$Bypasser(Supplier<Collection<File>> supplier)
/*     */   {
/* 123 */     this.supplier = TaskInputHelper.memoize(supplier);
/*     */   }
/*     */   
/*     */   public Collection<File> get()
/*     */   {
/* 128 */     if (TaskInputHelper.bypassEnabled()) {
/* 129 */       return ImmutableList.of();
/*     */     }
/*     */     
/* 132 */     return (Collection)supplier.get();
/*     */   }
/*     */   
/*     */   public Collection<File> call()
/*     */   {
/* 137 */     return get();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.TaskInputHelper.Bypasser
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */