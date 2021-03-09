/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import org.objectweb.asm.ClassReader;
/*     */ import org.objectweb.asm.ClassWriter;
/*     */ 
/*     */ final class IncrementalVisitor$1
/*     */   extends ClassWriter
/*     */ {
/*     */   IncrementalVisitor$1(ClassReader x0, int x1)
/*     */   {
/* 271 */     super(x0, x1);
/*     */   }
/*     */   
/*     */   protected String getCommonSuperClass(String type1, String type2) {
/* 275 */     ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
/*     */     try {
/* 277 */       Class<?> c = Class.forName(type1.replace('/', '.'), false, classLoader);
/* 278 */       d = Class.forName(type2.replace('/', '.'), false, classLoader);
/*     */     }
/*     */     catch (ClassNotFoundException e)
/*     */     {
/*     */       Class<?> d;
/* 283 */       return "instant/run/NoCommonSuperClass";
/*     */     } catch (Exception e) {
/* 285 */       throw new RuntimeException(e); }
/*     */     Class<?> d;
/* 287 */     Class<?> c; if (c.isAssignableFrom(d)) {
/* 288 */       return type1;
/*     */     }
/* 290 */     if (d.isAssignableFrom(c)) {
/* 291 */       return type2;
/*     */     }
/* 293 */     if ((c.isInterface()) || (d.isInterface())) {
/* 294 */       return "java/lang/Object";
/*     */     }
/*     */     do {
/* 297 */       c = c.getSuperclass();
/* 298 */     } while (!c.isAssignableFrom(d));
/* 299 */     return c.getName().replace('.', '/');
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.IncrementalVisitor.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */