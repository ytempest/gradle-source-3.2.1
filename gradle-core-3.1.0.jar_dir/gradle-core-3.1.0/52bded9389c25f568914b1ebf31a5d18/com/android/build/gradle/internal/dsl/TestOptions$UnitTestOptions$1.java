/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import groovy.lang.Closure;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.tasks.testing.Test;
/*     */ import org.gradle.util.ConfigureUtil;
/*     */ 
/*     */ class TestOptions$UnitTestOptions$1
/*     */   implements Action<Test>
/*     */ {
/*     */   TestOptions$UnitTestOptions$1(TestOptions.UnitTestOptions this$0, Closure paramClosure) {}
/*     */   
/*     */   public void execute(Test testTask)
/*     */   {
/* 235 */     ConfigureUtil.configure(val$configClosure, testTask);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.TestOptions.UnitTestOptions.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */