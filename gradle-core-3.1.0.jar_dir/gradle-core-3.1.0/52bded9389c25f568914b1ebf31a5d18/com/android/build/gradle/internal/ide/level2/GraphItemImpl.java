/*    */ package com.android.build.gradle.internal.ide.level2;
/*    */ 
/*    */ import com.android.builder.model.level2.GraphItem;
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ import java.util.Objects;
/*    */ 
/*    */ public final class GraphItemImpl
/*    */   implements GraphItem, Serializable
/*    */ {
/*    */   private final String address;
/*    */   private final List<GraphItem> dependencies;
/*    */   private final int hashcode;
/*    */   
/*    */   public GraphItemImpl(String address, List<GraphItem> dependencies)
/*    */   {
/* 40 */     this.address = address;
/* 41 */     this.dependencies = dependencies;
/* 42 */     hashcode = computeHashCode();
/*    */   }
/*    */   
/*    */   public String getArtifactAddress()
/*    */   {
/* 48 */     return address;
/*    */   }
/*    */   
/*    */   public String getRequestedCoordinates()
/*    */   {
/* 54 */     return null;
/*    */   }
/*    */   
/*    */   public List<GraphItem> getDependencies()
/*    */   {
/* 60 */     return dependencies;
/*    */   }
/*    */   
/*    */   public boolean equals(Object o)
/*    */   {
/* 65 */     if (this == o) {
/* 66 */       return true;
/*    */     }
/* 68 */     if ((o == null) || (getClass() != o.getClass())) {
/* 69 */       return false;
/*    */     }
/*    */     
/* 72 */     GraphItemImpl graphItem = (GraphItemImpl)o;
/*    */     
/* 74 */     return (hashcode == hashcode) && 
/* 75 */       (Objects.equals(address, address)) && 
/* 76 */       (Objects.equals(dependencies, dependencies));
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 82 */     return hashcode;
/*    */   }
/*    */   
/*    */   private int computeHashCode() {
/* 86 */     return Objects.hash(new Object[] { address, dependencies });
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 91 */     return 
/*    */     
/* 94 */       MoreObjects.toStringHelper(this).add("address", address).add("dependenciesSize", dependencies.size()).toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.level2.GraphItemImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */