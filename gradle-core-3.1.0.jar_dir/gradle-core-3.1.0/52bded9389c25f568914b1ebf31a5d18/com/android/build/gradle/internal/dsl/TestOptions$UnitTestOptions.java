/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import groovy.lang.Closure;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.DomainObjectSet;
/*     */ import org.gradle.api.internal.DefaultDomainObjectSet;
/*     */ import org.gradle.api.tasks.testing.Test;
/*     */ import org.gradle.util.ConfigureUtil;
/*     */ 
/*     */ public class TestOptions$UnitTestOptions
/*     */ {
/* 149 */   private DomainObjectSet<Test> testTasks = new DefaultDomainObjectSet(Test.class);
/*     */   
/*     */   private boolean returnDefaultValues;
/*     */   
/*     */   private boolean includeAndroidResources;
/*     */   
/*     */   public boolean isReturnDefaultValues()
/*     */   {
/* 165 */     return returnDefaultValues;
/*     */   }
/*     */   
/*     */   public void setReturnDefaultValues(boolean returnDefaultValues) {
/* 169 */     this.returnDefaultValues = returnDefaultValues;
/*     */   }
/*     */   
/*     */   public boolean isIncludeAndroidResources()
/*     */   {
/* 200 */     return includeAndroidResources;
/*     */   }
/*     */   
/*     */   public void setIncludeAndroidResources(boolean includeAndroidResources) {
/* 204 */     this.includeAndroidResources = includeAndroidResources;
/*     */   }
/*     */   
/*     */   public void all(final Closure<Test> configClosure)
/*     */   {
/* 231 */     testTasks.all(new Action()
/*     */     {
/*     */       public void execute(Test testTask)
/*     */       {
/* 235 */         ConfigureUtil.configure(configClosure, testTask);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void applyConfiguration(Test task)
/*     */   {
/* 251 */     testTasks.add(task);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.TestOptions.UnitTestOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */