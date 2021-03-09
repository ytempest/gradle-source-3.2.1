/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ final class JavaSerializationShrinkerGraph$ClassInfo
/*     */   implements Serializable
/*     */ {
/*     */   final File classFile;
/*     */   final String superclass;
/*     */   final String[] interfaces;
/*     */   
/*     */   private JavaSerializationShrinkerGraph$ClassInfo(File classFile, String superclass, String[] interfaces)
/*     */   {
/* 530 */     this.classFile = classFile;
/* 531 */     this.superclass = superclass;
/* 532 */     this.interfaces = interfaces;
/*     */   }
/*     */   
/*     */   boolean isLibraryClass() {
/* 536 */     return classFile == null;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.JavaSerializationShrinkerGraph.ClassInfo
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */