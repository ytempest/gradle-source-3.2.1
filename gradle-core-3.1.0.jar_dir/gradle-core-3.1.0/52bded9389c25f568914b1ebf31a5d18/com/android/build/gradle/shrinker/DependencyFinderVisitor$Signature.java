/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import com.google.common.base.Objects;
/*     */ 
/*     */ class DependencyFinderVisitor$Signature
/*     */ {
/*     */   private final String owner;
/*     */   private final String name;
/*     */   private final String desc;
/*     */   
/*     */   DependencyFinderVisitor$Signature(String owner, String name, String desc)
/*     */   {
/* 576 */     this.owner = owner;
/* 577 */     this.name = name;
/* 578 */     this.desc = desc;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 583 */     if (this == o) {
/* 584 */       return true;
/*     */     }
/* 586 */     if ((o == null) || (getClass() != o.getClass())) {
/* 587 */       return false;
/*     */     }
/* 589 */     Signature method = (Signature)o;
/* 590 */     return (Objects.equal(owner, owner)) && 
/* 591 */       (Objects.equal(name, name)) && 
/* 592 */       (Objects.equal(desc, desc));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 597 */     return Objects.hashCode(new Object[] { owner, name, desc });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.DependencyFinderVisitor.Signature
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */