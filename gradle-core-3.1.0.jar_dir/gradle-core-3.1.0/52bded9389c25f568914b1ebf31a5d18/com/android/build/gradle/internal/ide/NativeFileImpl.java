/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.builder.model.NativeFile;
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ import java.io.File;
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ 
/*    */ public final class NativeFileImpl
/*    */   implements NativeFile, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final File filePath;
/*    */   private final String settingsName;
/*    */   private final File workingDirectory;
/*    */   
/*    */   public NativeFileImpl(File filePath, String settingsName, File workingDirectory)
/*    */   {
/* 46 */     this.filePath = filePath;
/* 47 */     this.settingsName = settingsName;
/* 48 */     this.workingDirectory = workingDirectory;
/*    */   }
/*    */   
/*    */   public File getFilePath()
/*    */   {
/* 54 */     return filePath;
/*    */   }
/*    */   
/*    */   public String getSettingsName()
/*    */   {
/* 60 */     return settingsName;
/*    */   }
/*    */   
/*    */   public File getWorkingDirectory()
/*    */   {
/* 66 */     return workingDirectory;
/*    */   }
/*    */   
/*    */   public boolean equals(Object o)
/*    */   {
/* 71 */     if (this == o) {
/* 72 */       return true;
/*    */     }
/* 74 */     if ((o == null) || (getClass() != o.getClass())) {
/* 75 */       return false;
/*    */     }
/* 77 */     NativeFileImpl that = (NativeFileImpl)o;
/* 78 */     return (Objects.equals(filePath, filePath)) && 
/* 79 */       (Objects.equals(settingsName, settingsName)) && 
/* 80 */       (Objects.equals(workingDirectory, workingDirectory));
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 85 */     return Objects.hash(new Object[] { filePath, settingsName, workingDirectory });
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 90 */     return 
/*    */     
/* 94 */       MoreObjects.toStringHelper(this).add("filePath", filePath).add("settingsName", settingsName).add("workingDirectory", workingDirectory).toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.NativeFileImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */