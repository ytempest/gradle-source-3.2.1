/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.objectweb.asm.tree.AnnotationNode;
/*     */ 
/*     */ public class InstantRunVerifier$AnnotationNodeComparator
/*     */   implements InstantRunVerifier.Comparator<AnnotationNode>
/*     */ {
/*     */   public boolean areEqual(AnnotationNode first, AnnotationNode second)
/*     */   {
/* 476 */     if ((first == null) || (second == null)) {
/* 477 */       return first == second;
/*     */     }
/*     */     
/* 480 */     if (!InstantRunVerifier.access$100().areEqual(desc, desc)) {
/* 481 */       return false;
/*     */     }
/*     */     
/* 495 */     if (desc.equals("Lkotlin/Metadata;")) {
/* 496 */       return true;
/*     */     }
/*     */     
/* 499 */     List firstEntries = InstantRunVerifier.access$200(values);
/* 500 */     List secondEntries = InstantRunVerifier.access$200(values);
/*     */     
/* 502 */     return InstantRunVerifier.diffList(firstEntries, secondEntries, InstantRunVerifier.access$300()) == InstantRunVerifier.Diff.NONE;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.InstantRunVerifier.AnnotationNodeComparator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */