/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ class InstantRunVerifier$AnnotationEntryAndValue
/*     */ {
/*     */   private final String name;
/*     */   private final Object value;
/*     */   
/*     */   InstantRunVerifier$AnnotationEntryAndValue(String name, Object value)
/*     */   {
/* 573 */     this.name = name;
/* 574 */     this.value = value;
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj)
/*     */   {
/* 579 */     if (!(obj instanceof AnnotationEntryAndValue)) {
/* 580 */       return false;
/*     */     }
/*     */     
/* 583 */     AnnotationEntryAndValue other = (AnnotationEntryAndValue)obj;
/* 584 */     if (!InstantRunVerifier.access$100().areEqual(name, name)) {
/* 585 */       return false;
/*     */     }
/*     */     
/* 591 */     Object otherValue = value;
/* 592 */     if (((value instanceof byte[])) && ((otherValue instanceof byte[])))
/* 593 */       return Arrays.equals((byte[])value, (byte[])otherValue);
/* 594 */     if (((value instanceof boolean[])) && ((otherValue instanceof boolean[])))
/* 595 */       return Arrays.equals((boolean[])value, (boolean[])otherValue);
/* 596 */     if (((value instanceof short[])) && ((otherValue instanceof short[])))
/* 597 */       return Arrays.equals((short[])value, (short[])otherValue);
/* 598 */     if (((value instanceof char[])) && ((otherValue instanceof char[])))
/* 599 */       return Arrays.equals((char[])value, (char[])otherValue);
/* 600 */     if (((value instanceof int[])) && ((otherValue instanceof int[])))
/* 601 */       return Arrays.equals((int[])value, (int[])otherValue);
/* 602 */     if (((value instanceof long[])) && ((otherValue instanceof long[])))
/* 603 */       return Arrays.equals((long[])value, (long[])otherValue);
/* 604 */     if (((value instanceof float[])) && ((otherValue instanceof float[])))
/* 605 */       return Arrays.equals((float[])value, (float[])otherValue);
/* 606 */     if (((value instanceof double[])) && ((otherValue instanceof double[])))
/* 607 */       return Arrays.equals((double[])value, (double[])otherValue);
/* 608 */     if (((value instanceof String[])) && ((otherValue instanceof String[])))
/*     */     {
/* 611 */       return Arrays.equals((String[])value, (String[])otherValue);
/*     */     }
/*     */     
/* 614 */     if (((value instanceof List)) && ((otherValue instanceof List)))
/*     */     {
/* 616 */       List list = (List)value;
/* 617 */       List otherList = (List)otherValue;
/* 618 */       if (list.size() != otherList.size()) {
/* 619 */         return false;
/*     */       }
/*     */       
/* 622 */       Iterator iterator = list.iterator();
/* 623 */       Iterator otherIterator = otherList.iterator();
/* 624 */       while ((iterator.hasNext()) && (otherIterator.hasNext())) {
/* 625 */         if (!InstantRunVerifier.access$400().areEqual(iterator.next(), otherIterator.next())) {
/* 626 */           return false;
/*     */         }
/*     */       }
/* 629 */       return true;
/*     */     }
/*     */     
/* 632 */     return InstantRunVerifier.access$400().areEqual(value, otherValue);
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 637 */     return name.hashCode();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.InstantRunVerifier.AnnotationEntryAndValue
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */