/*     */ package com.android.build.gradle.internal.api;
/*     */ 
/*     */ import com.android.builder.model.ProductFlavor;
/*     */ import java.util.ListIterator;
/*     */ 
/*     */ class ImmutableFlavorList$2
/*     */   implements ListIterator<ProductFlavor>
/*     */ {
/*     */   ImmutableFlavorList$2(ImmutableFlavorList this$0, ListIterator paramListIterator) {}
/*     */   
/*     */   public boolean hasNext()
/*     */   {
/* 201 */     return val$baseIterator.hasNext();
/*     */   }
/*     */   
/*     */   public ProductFlavor next()
/*     */   {
/* 206 */     return ImmutableFlavorList.access$000(this$0).getProductFlavor((ProductFlavor)val$baseIterator.next());
/*     */   }
/*     */   
/*     */   public boolean hasPrevious()
/*     */   {
/* 211 */     return val$baseIterator.hasPrevious();
/*     */   }
/*     */   
/*     */   public ProductFlavor previous()
/*     */   {
/* 216 */     return ImmutableFlavorList.access$000(this$0).getProductFlavor((ProductFlavor)val$baseIterator.previous());
/*     */   }
/*     */   
/*     */   public int nextIndex()
/*     */   {
/* 221 */     return val$baseIterator.nextIndex();
/*     */   }
/*     */   
/*     */   public int previousIndex()
/*     */   {
/* 226 */     return val$baseIterator.previousIndex();
/*     */   }
/*     */   
/*     */   public void remove()
/*     */   {
/* 231 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public void set(ProductFlavor productFlavor)
/*     */   {
/* 236 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public void add(ProductFlavor productFlavor)
/*     */   {
/* 241 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.ImmutableFlavorList.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */