/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.build.FilterData;
/*    */ import com.android.build.VariantOutput.FilterType;
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ 
/*    */ public final class FilterDataImpl
/*    */   implements FilterData, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final String filterType;
/*    */   private final String identifier;
/*    */   
/*    */   public static VariantOutput.FilterType getType(FilterData filter)
/*    */   {
/* 39 */     return VariantOutput.FilterType.valueOf(filter.getFilterType());
/*    */   }
/*    */   
/*    */   public FilterDataImpl(VariantOutput.FilterType filterType, String identifier) {
/* 43 */     this(filterType.name(), identifier);
/*    */   }
/*    */   
/*    */   public FilterDataImpl(String filterType, String identifier) {
/* 47 */     this.filterType = filterType;
/* 48 */     this.identifier = identifier;
/*    */   }
/*    */   
/*    */   public String getIdentifier()
/*    */   {
/* 54 */     return identifier;
/*    */   }
/*    */   
/*    */   public String getFilterType()
/*    */   {
/* 60 */     return filterType;
/*    */   }
/*    */   
/*    */   public static FilterData build(String filterType, String identifier) {
/* 64 */     return new FilterDataImpl(filterType, identifier);
/*    */   }
/*    */   
/*    */   public boolean equals(Object o)
/*    */   {
/* 69 */     if (this == o) {
/* 70 */       return true;
/*    */     }
/* 72 */     if ((o == null) || (getClass() != o.getClass())) {
/* 73 */       return false;
/*    */     }
/* 75 */     FilterDataImpl that = (FilterDataImpl)o;
/* 76 */     return (Objects.equals(filterType, filterType)) && 
/* 77 */       (Objects.equals(identifier, identifier));
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 82 */     return Objects.hash(new Object[] { filterType, identifier });
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 87 */     return 
/*    */     
/* 90 */       MoreObjects.toStringHelper(FilterData.class).add("type", filterType).add("value", identifier).toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.FilterDataImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */