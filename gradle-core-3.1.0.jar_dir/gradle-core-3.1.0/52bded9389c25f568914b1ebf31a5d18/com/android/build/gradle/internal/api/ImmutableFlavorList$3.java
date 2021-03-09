/*     */ package com.android.build.gradle.internal.api;
/*     */ 
/*     */ import com.android.builder.model.ProductFlavor;
/*     */ import java.util.ListIterator;
/*     */ 
/*     */ class ImmutableFlavorList$3
/*     */   implements ListIterator<ProductFlavor>
/*     */ {
/*     */   ImmutableFlavorList$3(ImmutableFlavorList this$0, ListIterator paramListIterator) {}
/*     */   
/*     */   public boolean hasNext()
/*     */   {
/* 253 */     return val$baseIterator.hasNext();
/*     */   }
/*     */   
/*     */   public ProductFlavor next()
/*     */   {
/* 258 */     return ImmutableFlavorList.access$000(this$0).getProductFlavor((ProductFlavor)val$baseIterator.next());
/*     */   }
/*     */   
/*     */   public boolean hasPrevious()
/*     */   {
/* 263 */     return val$baseIterator.hasPrevious();
/*     */   }
/*     */   
/*     */   public ProductFlavor previous()
/*     */   {
/* 268 */     return ImmutableFlavorList.access$000(this$0).getProductFlavor((ProductFlavor)val$baseIterator.previous());
/*     */   }
/*     */   
/*     */   public int nextIndex()
/*     */   {
/* 273 */     return val$baseIterator.nextIndex();
/*     */   }
/*     */   
/*     */   public int previousIndex()
/*     */   {
/* 278 */     return val$baseIterator.previousIndex();
/*     */   }
/*     */   
/*     */   public void remove()
/*     */   {
/* 283 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public void set(ProductFlavor productFlavor)
/*     */   {
/* 288 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public void add(ProductFlavor productFlavor)
/*     */   {
/* 293 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.ImmutableFlavorList.3
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */