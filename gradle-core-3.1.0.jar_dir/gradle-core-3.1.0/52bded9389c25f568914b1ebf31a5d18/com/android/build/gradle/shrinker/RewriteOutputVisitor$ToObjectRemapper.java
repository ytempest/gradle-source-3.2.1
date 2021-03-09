/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import java.util.function.Predicate;
/*     */ import org.objectweb.asm.commons.Remapper;
/*     */ 
/*     */ class RewriteOutputVisitor$ToObjectRemapper
/*     */   extends Remapper
/*     */ {
/*     */   private RewriteOutputVisitor$ToObjectRemapper(RewriteOutputVisitor paramRewriteOutputVisitor) {}
/*     */   
/*     */   public String map(String type)
/*     */   {
/* 141 */     if (RewriteOutputVisitor.access$200(this$0).test(type)) {
/* 142 */       return type;
/*     */     }
/* 144 */     return "java/lang/Object";
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.RewriteOutputVisitor.ToObjectRemapper
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */