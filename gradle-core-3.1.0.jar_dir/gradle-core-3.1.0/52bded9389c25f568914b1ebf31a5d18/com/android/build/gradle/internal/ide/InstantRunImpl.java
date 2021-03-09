/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.builder.model.InstantRun;
/*    */ import java.io.File;
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ 
/*    */ final class InstantRunImpl
/*    */   implements InstantRun, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final File infoFile;
/*    */   private final int supportStatus;
/*    */   
/*    */   public InstantRunImpl(File infoFile, int supportStatus)
/*    */   {
/* 38 */     this.infoFile = infoFile;
/* 39 */     this.supportStatus = supportStatus;
/*    */   }
/*    */   
/*    */   public File getInfoFile()
/*    */   {
/* 45 */     return infoFile;
/*    */   }
/*    */   
/*    */   public boolean isSupportedByArtifact()
/*    */   {
/* 50 */     return supportStatus == 0;
/*    */   }
/*    */   
/*    */   public int getSupportStatus()
/*    */   {
/* 55 */     return supportStatus;
/*    */   }
/*    */   
/*    */   public boolean equals(Object o)
/*    */   {
/* 60 */     if (this == o) {
/* 61 */       return true;
/*    */     }
/* 63 */     if ((o == null) || (getClass() != o.getClass())) {
/* 64 */       return false;
/*    */     }
/* 66 */     InstantRunImpl that = (InstantRunImpl)o;
/* 67 */     return (supportStatus == supportStatus) && 
/* 68 */       (Objects.equals(infoFile, infoFile));
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 73 */     return Objects.hash(new Object[] { infoFile, Integer.valueOf(supportStatus) });
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.InstantRunImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */