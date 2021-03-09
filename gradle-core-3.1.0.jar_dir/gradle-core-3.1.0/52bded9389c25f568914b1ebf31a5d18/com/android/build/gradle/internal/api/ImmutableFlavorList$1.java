/*    */ package com.android.build.gradle.internal.api;
/*    */ 
/*    */ import com.android.builder.model.ProductFlavor;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ class ImmutableFlavorList$1
/*    */   implements Iterator<ProductFlavor>
/*    */ {
/*    */   ImmutableFlavorList$1(ImmutableFlavorList this$0, Iterator paramIterator) {}
/*    */   
/*    */   public boolean hasNext()
/*    */   {
/* 68 */     return val$baseIterator.hasNext();
/*    */   }
/*    */   
/*    */   public ProductFlavor next()
/*    */   {
/* 73 */     return ImmutableFlavorList.access$000(this$0).getProductFlavor((ProductFlavor)val$baseIterator.next());
/*    */   }
/*    */   
/*    */   public void remove()
/*    */   {
/* 78 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.ImmutableFlavorList.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */