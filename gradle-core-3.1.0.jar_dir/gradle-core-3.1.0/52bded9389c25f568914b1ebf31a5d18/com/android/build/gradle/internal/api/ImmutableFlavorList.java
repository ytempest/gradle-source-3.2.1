/*     */ package com.android.build.gradle.internal.api;
/*     */ 
/*     */ import com.android.builder.model.ProductFlavor;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ 
/*     */ public class ImmutableFlavorList
/*     */   implements List<ProductFlavor>
/*     */ {
/*     */   private final List<? extends ProductFlavor> list;
/*     */   private final ReadOnlyObjectProvider immutableObjectProvider;
/*     */   
/*     */   ImmutableFlavorList(List<? extends ProductFlavor> list, ReadOnlyObjectProvider immutableObjectProvider)
/*     */   {
/*  42 */     this.list = list;
/*  43 */     this.immutableObjectProvider = immutableObjectProvider;
/*     */   }
/*     */   
/*     */   public int size()
/*     */   {
/*  48 */     return list.size();
/*     */   }
/*     */   
/*     */   public boolean isEmpty()
/*     */   {
/*  53 */     return list.isEmpty();
/*     */   }
/*     */   
/*     */   public boolean contains(Object o)
/*     */   {
/*  58 */     return list.contains(o);
/*     */   }
/*     */   
/*     */   public Iterator<ProductFlavor> iterator()
/*     */   {
/*  64 */     final Iterator<? extends ProductFlavor> baseIterator = list.iterator();
/*  65 */     new Iterator()
/*     */     {
/*     */       public boolean hasNext() {
/*  68 */         return baseIterator.hasNext();
/*     */       }
/*     */       
/*     */       public ProductFlavor next()
/*     */       {
/*  73 */         return immutableObjectProvider.getProductFlavor((ProductFlavor)baseIterator.next());
/*     */       }
/*     */       
/*     */       public void remove()
/*     */       {
/*  78 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   public Object[] toArray()
/*     */   {
/*  86 */     int count = list.size();
/*  87 */     Object[] array = new Object[list.size()];
/*     */     
/*  89 */     for (int i = 0; i < count; i++) {
/*  90 */       array[i] = immutableObjectProvider.getProductFlavor((ProductFlavor)list.get(i));
/*     */     }
/*     */     
/*  93 */     return array;
/*     */   }
/*     */   
/*     */   public <T> T[] toArray(T[] array)
/*     */   {
/*  99 */     int count = list.size();
/* 100 */     if (array.length < count)
/*     */     {
/* 102 */       array = (Object[])Array.newInstance(array.getClass().getComponentType(), count);
/*     */     }
/*     */     
/* 105 */     for (int i = 0; i < count; i++)
/*     */     {
/* 107 */       array[i] = immutableObjectProvider.getProductFlavor((ProductFlavor)list.get(i));
/*     */     }
/*     */     
/* 110 */     for (int i = count; i < array.length; i++) {
/* 111 */       array[i] = null;
/*     */     }
/*     */     
/* 114 */     return array;
/*     */   }
/*     */   
/*     */   public boolean add(ProductFlavor e)
/*     */   {
/* 119 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public boolean remove(Object o)
/*     */   {
/* 124 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public boolean containsAll(Collection<?> objects)
/*     */   {
/* 129 */     return list.containsAll(objects);
/*     */   }
/*     */   
/*     */   public boolean addAll(Collection<? extends ProductFlavor> es)
/*     */   {
/* 134 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public boolean addAll(int i, Collection<? extends ProductFlavor> es)
/*     */   {
/* 139 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public boolean removeAll(Collection<?> objects)
/*     */   {
/* 144 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public boolean retainAll(Collection<?> objects)
/*     */   {
/* 149 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public void clear()
/*     */   {
/* 154 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public ProductFlavor get(int i)
/*     */   {
/* 159 */     ProductFlavor gpf = (ProductFlavor)list.get(i);
/* 160 */     return immutableObjectProvider.getProductFlavor(gpf);
/*     */   }
/*     */   
/*     */   public ProductFlavor set(int i, ProductFlavor e)
/*     */   {
/* 165 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public void add(int i, ProductFlavor e)
/*     */   {
/* 170 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public ProductFlavor remove(int i)
/*     */   {
/* 175 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public int indexOf(Object o)
/*     */   {
/* 180 */     if ((o instanceof ReadOnlyProductFlavor)) {
/* 181 */       return list.indexOf(productFlavor);
/*     */     }
/* 183 */     return list.indexOf(o);
/*     */   }
/*     */   
/*     */   public int lastIndexOf(Object o)
/*     */   {
/* 188 */     if ((o instanceof ReadOnlyProductFlavor)) {
/* 189 */       return list.lastIndexOf(productFlavor);
/*     */     }
/* 191 */     return list.lastIndexOf(o);
/*     */   }
/*     */   
/*     */   public ListIterator<ProductFlavor> listIterator()
/*     */   {
/* 197 */     final ListIterator<? extends ProductFlavor> baseIterator = list.listIterator();
/* 198 */     new ListIterator()
/*     */     {
/*     */       public boolean hasNext() {
/* 201 */         return baseIterator.hasNext();
/*     */       }
/*     */       
/*     */       public ProductFlavor next()
/*     */       {
/* 206 */         return immutableObjectProvider.getProductFlavor((ProductFlavor)baseIterator.next());
/*     */       }
/*     */       
/*     */       public boolean hasPrevious()
/*     */       {
/* 211 */         return baseIterator.hasPrevious();
/*     */       }
/*     */       
/*     */       public ProductFlavor previous()
/*     */       {
/* 216 */         return immutableObjectProvider.getProductFlavor((ProductFlavor)baseIterator.previous());
/*     */       }
/*     */       
/*     */       public int nextIndex()
/*     */       {
/* 221 */         return baseIterator.nextIndex();
/*     */       }
/*     */       
/*     */       public int previousIndex()
/*     */       {
/* 226 */         return baseIterator.previousIndex();
/*     */       }
/*     */       
/*     */       public void remove()
/*     */       {
/* 231 */         throw new UnsupportedOperationException();
/*     */       }
/*     */       
/*     */       public void set(ProductFlavor productFlavor)
/*     */       {
/* 236 */         throw new UnsupportedOperationException();
/*     */       }
/*     */       
/*     */       public void add(ProductFlavor productFlavor)
/*     */       {
/* 241 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   public ListIterator<ProductFlavor> listIterator(int i)
/*     */   {
/* 249 */     final ListIterator<? extends ProductFlavor> baseIterator = list.listIterator(i);
/* 250 */     new ListIterator()
/*     */     {
/*     */       public boolean hasNext() {
/* 253 */         return baseIterator.hasNext();
/*     */       }
/*     */       
/*     */       public ProductFlavor next()
/*     */       {
/* 258 */         return immutableObjectProvider.getProductFlavor((ProductFlavor)baseIterator.next());
/*     */       }
/*     */       
/*     */       public boolean hasPrevious()
/*     */       {
/* 263 */         return baseIterator.hasPrevious();
/*     */       }
/*     */       
/*     */       public ProductFlavor previous()
/*     */       {
/* 268 */         return immutableObjectProvider.getProductFlavor((ProductFlavor)baseIterator.previous());
/*     */       }
/*     */       
/*     */       public int nextIndex()
/*     */       {
/* 273 */         return baseIterator.nextIndex();
/*     */       }
/*     */       
/*     */       public int previousIndex()
/*     */       {
/* 278 */         return baseIterator.previousIndex();
/*     */       }
/*     */       
/*     */       public void remove()
/*     */       {
/* 283 */         throw new UnsupportedOperationException();
/*     */       }
/*     */       
/*     */       public void set(ProductFlavor productFlavor)
/*     */       {
/* 288 */         throw new UnsupportedOperationException();
/*     */       }
/*     */       
/*     */       public void add(ProductFlavor productFlavor)
/*     */       {
/* 293 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   public List<ProductFlavor> subList(int i, int i2)
/*     */   {
/* 301 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.ImmutableFlavorList
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */