/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ final class JavaSerializationShrinkerGraph$Counter
/*     */   implements Serializable
/*     */ {
/* 566 */   int required = 0;
/* 567 */   int ifClassKept = 0;
/* 568 */   int classIsKept = 0;
/* 569 */   int superInterfaceKept = 0;
/* 570 */   int interfaceImplemented = 0;
/*     */   
/*     */   synchronized boolean incrementAndCheck(DependencyType type) {
/* 573 */     boolean before = isReachable();
/* 574 */     switch (JavaSerializationShrinkerGraph.2.$SwitchMap$com$android$build$gradle$shrinker$DependencyType[type.ordinal()]) {
/*     */     case 1: 
/*     */     case 2: 
/*     */     case 3: 
/*     */     case 4: 
/* 579 */       required += 1;
/* 580 */       break;
/*     */     case 5: 
/* 582 */       ifClassKept += 1;
/* 583 */       break;
/*     */     case 6: 
/* 585 */       classIsKept += 1;
/* 586 */       break;
/*     */     case 7: 
/* 588 */       superInterfaceKept += 1;
/* 589 */       break;
/*     */     case 8: 
/* 591 */       interfaceImplemented += 1;
/* 592 */       break;
/*     */     default: 
/* 594 */       throw new IllegalArgumentException("Unknown dependency type.");
/*     */     }
/* 596 */     boolean after = isReachable();
/* 597 */     return before != after;
/*     */   }
/*     */   
/*     */   synchronized boolean isReachable() {
/* 601 */     return (required > 0) || ((ifClassKept > 0) && (classIsKept > 0)) || ((superInterfaceKept > 0) && (interfaceImplemented > 0));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.JavaSerializationShrinkerGraph.Counter
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */