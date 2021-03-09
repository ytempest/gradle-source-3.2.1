/*    */ package com.android.build.gradle.shrinker;
/*    */ 
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ import com.google.common.base.Objects;
/*    */ import com.google.common.base.Preconditions;
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public final class Dependency<T>
/*    */   implements Serializable
/*    */ {
/*    */   final T target;
/*    */   final DependencyType type;
/*    */   
/*    */   public Dependency(T target, DependencyType type)
/*    */   {
/* 33 */     this.target = Preconditions.checkNotNull(target);
/* 34 */     this.type = ((DependencyType)Preconditions.checkNotNull(type));
/*    */   }
/*    */   
/*    */   public boolean equals(Object object)
/*    */   {
/* 39 */     if ((object instanceof Dependency)) {
/* 40 */       Dependency<?> that = (Dependency)object;
/* 41 */       return (Objects.equal(target, target)) && (type == type);
/*    */     }
/* 43 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 48 */     return Objects.hashCode(new Object[] { target, type });
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 53 */     return MoreObjects.toStringHelper(this).add("target", target).add("type", type).toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.Dependency
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */