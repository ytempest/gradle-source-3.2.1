/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import com.android.build.VariantOutput.OutputType;
/*     */ import com.android.ide.common.build.ApkData;
/*     */ import java.util.Objects;
/*     */ 
/*     */ final class OutputFactory$Main
/*     */   extends ApkData
/*     */ {
/*     */   private final String baseName;
/*     */   private final String fullName;
/*     */   private final String dirName;
/*     */   
/*     */   private OutputFactory$Main(String baseName, String fullName, String dirName, String fileName)
/*     */   {
/* 176 */     this.baseName = baseName;
/* 177 */     this.fullName = fullName;
/* 178 */     this.dirName = dirName;
/* 179 */     setOutputFileName(fileName);
/*     */   }
/*     */   
/*     */   public VariantOutput.OutputType getType()
/*     */   {
/* 185 */     return VariantOutput.OutputType.MAIN;
/*     */   }
/*     */   
/*     */   public String getFilterName()
/*     */   {
/* 191 */     return null;
/*     */   }
/*     */   
/*     */   public String getBaseName()
/*     */   {
/* 197 */     return baseName;
/*     */   }
/*     */   
/*     */   public String getFullName()
/*     */   {
/* 203 */     return fullName;
/*     */   }
/*     */   
/*     */   public String getDirName()
/*     */   {
/* 209 */     return dirName;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 214 */     return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), baseName, fullName, dirName });
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 219 */     if (this == o) {
/* 220 */       return true;
/*     */     }
/* 222 */     if ((o == null) || (getClass() != o.getClass())) {
/* 223 */       return false;
/*     */     }
/* 225 */     if (!super.equals(o)) {
/* 226 */       return false;
/*     */     }
/* 228 */     Main that = (Main)o;
/* 229 */     return (Objects.equals(baseName, baseName)) && 
/* 230 */       (Objects.equals(fullName, fullName)) && 
/* 231 */       (Objects.equals(dirName, dirName));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.OutputFactory.Main
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */