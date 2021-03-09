/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectStreamClass;
/*     */ 
/*     */ final class JavaSerializationShrinkerGraph$1
/*     */   extends ObjectInputStream
/*     */ {
/*     */   JavaSerializationShrinkerGraph$1(InputStream x0, ClassLoader paramClassLoader)
/*     */   {
/* 135 */     super(x0);
/*     */   }
/*     */   
/*     */   protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
/* 139 */     return Class.forName(desc.getName(), false, val$classLoader);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.JavaSerializationShrinkerGraph.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */