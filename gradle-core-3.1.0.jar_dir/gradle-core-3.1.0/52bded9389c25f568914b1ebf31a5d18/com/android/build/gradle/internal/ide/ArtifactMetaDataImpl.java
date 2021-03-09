/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.builder.model.ArtifactMetaData;
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ 
/*    */ public final class ArtifactMetaDataImpl
/*    */   implements ArtifactMetaData, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final String name;
/*    */   private final boolean isTest;
/*    */   private final int type;
/*    */   
/*    */   public ArtifactMetaDataImpl(String name, boolean isTest, int type)
/*    */   {
/* 38 */     this.name = name;
/* 39 */     this.isTest = isTest;
/* 40 */     this.type = type;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 46 */     return name;
/*    */   }
/*    */   
/*    */   public boolean isTest()
/*    */   {
/* 51 */     return isTest;
/*    */   }
/*    */   
/*    */   public int getType()
/*    */   {
/* 56 */     return type;
/*    */   }
/*    */   
/*    */   public boolean equals(Object o)
/*    */   {
/* 61 */     if (this == o) {
/* 62 */       return true;
/*    */     }
/* 64 */     if ((o == null) || (getClass() != o.getClass())) {
/* 65 */       return false;
/*    */     }
/* 67 */     ArtifactMetaDataImpl that = (ArtifactMetaDataImpl)o;
/* 68 */     if ((isTest == isTest) && (type == type)) {} return 
/*    */     
/* 70 */       Objects.equals(name, name);
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 75 */     return Objects.hash(new Object[] { name, Boolean.valueOf(isTest), Integer.valueOf(type) });
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.ArtifactMetaDataImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */