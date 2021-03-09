/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import com.google.common.base.Objects;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ 
/*     */ final class IncrementalShrinker$State<T>
/*     */ {
/*     */   final ImmutableSet<String> members;
/*     */   final ImmutableSet<T> interfaces;
/*     */   final ImmutableSet<T> typesFromGenericSignatures;
/*     */   
/*     */   public IncrementalShrinker$State(Iterable<String> members, Iterable<T> interfaces, Iterable<T> typesFromGenericSignatures)
/*     */   {
/* 362 */     this.members = ImmutableSet.copyOf(members);
/* 363 */     this.interfaces = ImmutableSet.copyOf(interfaces);
/* 364 */     this.typesFromGenericSignatures = ImmutableSet.copyOf(typesFromGenericSignatures);
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 369 */     if (this == o) {
/* 370 */       return true;
/*     */     }
/* 372 */     if ((o == null) || (getClass() != o.getClass())) {
/* 373 */       return false;
/*     */     }
/* 375 */     State<?> state = (State)o;
/* 376 */     return (Objects.equal(members, members)) && 
/* 377 */       (Objects.equal(interfaces, interfaces)) && 
/* 378 */       (Objects.equal(typesFromGenericSignatures, typesFromGenericSignatures));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 383 */     return Objects.hashCode(new Object[] { members, interfaces, typesFromGenericSignatures });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.IncrementalShrinker.State
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */