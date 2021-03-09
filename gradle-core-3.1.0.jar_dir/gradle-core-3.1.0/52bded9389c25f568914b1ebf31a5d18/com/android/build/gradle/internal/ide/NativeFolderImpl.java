/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.builder.model.NativeFolder;
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ import java.io.File;
/*    */ import java.io.Serializable;
/*    */ import java.util.Map;
/*    */ import java.util.Objects;
/*    */ 
/*    */ public final class NativeFolderImpl
/*    */   implements NativeFolder, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final File folderPath;
/*    */   private final Map<String, String> perLanguageSettings;
/*    */   private final File workingDirectory;
/*    */   
/*    */   public NativeFolderImpl(File folderPath, Map<String, String> perLanguageSettings, File workingDirectory)
/*    */   {
/* 48 */     this.folderPath = folderPath;
/* 49 */     this.perLanguageSettings = perLanguageSettings;
/* 50 */     this.workingDirectory = workingDirectory;
/*    */   }
/*    */   
/*    */   public File getFolderPath()
/*    */   {
/* 56 */     return folderPath;
/*    */   }
/*    */   
/*    */   public Map<String, String> getPerLanguageSettings()
/*    */   {
/* 62 */     return perLanguageSettings;
/*    */   }
/*    */   
/*    */   public File getWorkingDirectory()
/*    */   {
/* 68 */     return workingDirectory;
/*    */   }
/*    */   
/*    */   public boolean equals(Object o)
/*    */   {
/* 73 */     if (this == o) {
/* 74 */       return true;
/*    */     }
/* 76 */     if ((o == null) || (getClass() != o.getClass())) {
/* 77 */       return false;
/*    */     }
/* 79 */     NativeFolderImpl that = (NativeFolderImpl)o;
/* 80 */     return (Objects.equals(folderPath, folderPath)) && 
/* 81 */       (Objects.equals(perLanguageSettings, perLanguageSettings)) && 
/* 82 */       (Objects.equals(workingDirectory, workingDirectory));
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 87 */     return Objects.hash(new Object[] { folderPath, perLanguageSettings, workingDirectory });
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 92 */     return 
/*    */     
/* 96 */       MoreObjects.toStringHelper(this).add("folderPath", folderPath).add("perLanguageSettings", perLanguageSettings).add("workingDirectory", workingDirectory).toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.NativeFolderImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */