/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import java.net.URLClassLoader;
/*     */ import org.objectweb.asm.ClassWriter;
/*     */ 
/*     */ class FixStackFramesTransform$FixFramesVisitor
/*     */   extends ClassWriter
/*     */ {
/*     */   private final URLClassLoader classLoader;
/*     */   
/*     */   public FixStackFramesTransform$FixFramesVisitor(int flags, URLClassLoader classLoader)
/*     */   {
/*  95 */     super(flags);
/*  96 */     this.classLoader = classLoader;
/*     */   }
/*     */   
/*     */   protected String getCommonSuperClass(String type1, String type2)
/*     */   {
/* 103 */     ClassLoader classLoader = this.classLoader;
/*     */     try {
/* 105 */       Class<?> c = Class.forName(type1.replace('/', '.'), false, classLoader);
/* 106 */       d = Class.forName(type2.replace('/', '.'), false, classLoader);
/*     */     } catch (Exception e) {
/*     */       Class<?> d;
/* 109 */       throw new RuntimeException(String.format("Unable to find common supper type for %s and %s.", new Object[] { type1, type2 }), e);
/*     */     }
/*     */     Class<?> d;
/*     */     Class<?> c;
/* 113 */     if (c.isAssignableFrom(d)) {
/* 114 */       return type1;
/*     */     }
/* 116 */     if (d.isAssignableFrom(c)) {
/* 117 */       return type2;
/*     */     }
/* 119 */     if ((c.isInterface()) || (d.isInterface())) {
/* 120 */       return "java/lang/Object";
/*     */     }
/*     */     do {
/* 123 */       c = c.getSuperclass();
/* 124 */     } while (!c.isAssignableFrom(d));
/* 125 */     return c.getName().replace('.', '/');
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.FixStackFramesTransform.FixFramesVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */