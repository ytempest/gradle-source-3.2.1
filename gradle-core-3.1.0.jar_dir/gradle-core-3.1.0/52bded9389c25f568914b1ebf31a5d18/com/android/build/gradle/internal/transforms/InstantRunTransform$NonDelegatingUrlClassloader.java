/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import java.util.List;
/*     */ 
/*     */ class InstantRunTransform$NonDelegatingUrlClassloader
/*     */   extends URLClassLoader
/*     */ {
/*     */   public InstantRunTransform$NonDelegatingUrlClassloader(List<URL> urls)
/*     */   {
/* 543 */     super((URL[])urls.toArray(new URL[urls.size()]), null);
/*     */   }
/*     */   
/*     */   public URL getResource(String name)
/*     */   {
/* 549 */     return findResource(name);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.InstantRunTransform.NonDelegatingUrlClassloader
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */