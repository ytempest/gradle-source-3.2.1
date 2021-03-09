/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import com.google.common.base.Objects;
/*     */ import org.objectweb.asm.tree.FieldNode;
/*     */ 
/*     */ final class InstantRunVerifier$1
/*     */   implements InstantRunVerifier.Comparator<FieldNode>
/*     */ {
/*     */   public boolean areEqual(FieldNode first, FieldNode second)
/*     */   {
/* 233 */     if ((first == null) && (second == null)) {
/* 234 */       return true;
/*     */     }
/* 236 */     if ((first == null) || (second == null)) {
/* 237 */       return true;
/*     */     }
/* 239 */     if ((name.equals(name)) && 
/* 240 */       (desc.equals(desc)) && (access == access)) {}
/* 239 */     return 
/*     */     
/* 242 */       Objects.equal(value, value);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.InstantRunVerifier.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */