/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.builder.model.NativeLibrary;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ 
/*     */ public final class NativeLibraryImpl
/*     */   implements NativeLibrary, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String name;
/*     */   private final String toolchainName;
/*     */   private final String abi;
/*     */   private final List<File> cIncludeDirs;
/*     */   private final List<File> cppIncludeDirs;
/*     */   private final List<File> cSystemIncludeDirs;
/*     */   private final List<File> cppSystemIncludeDirs;
/*     */   private final List<String> cDefines;
/*     */   private final List<String> cppDefines;
/*     */   private final List<String> cCompilerFlags;
/*     */   private final List<String> cppCompilerFlags;
/*     */   private final List<File> debuggableLibraryFolders;
/*     */   
/*     */   public NativeLibraryImpl(String name, String toolchainName, String abi, List<File> cIncludeDirs, List<File> cppIncludeDirs, List<File> cSystemIncludeDirs, List<File> cppSystemIncludeDirs, List<String> cDefines, List<String> cppDefines, List<String> cCompilerFlags, List<String> cppCompilerFlags, List<File> debuggableLibraryFolders)
/*     */   {
/*  73 */     this.name = name;
/*  74 */     this.toolchainName = toolchainName;
/*  75 */     this.abi = abi;
/*  76 */     this.cIncludeDirs = cIncludeDirs;
/*  77 */     this.cppIncludeDirs = cppIncludeDirs;
/*  78 */     this.cSystemIncludeDirs = cSystemIncludeDirs;
/*  79 */     this.cppSystemIncludeDirs = cppSystemIncludeDirs;
/*  80 */     this.cDefines = cDefines;
/*  81 */     this.cppDefines = cppDefines;
/*  82 */     this.cCompilerFlags = cCompilerFlags;
/*  83 */     this.cppCompilerFlags = cppCompilerFlags;
/*  84 */     this.debuggableLibraryFolders = debuggableLibraryFolders;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  90 */     return name;
/*     */   }
/*     */   
/*     */   public String getToolchainName()
/*     */   {
/*  96 */     return toolchainName;
/*     */   }
/*     */   
/*     */   public String getAbi()
/*     */   {
/* 102 */     return abi;
/*     */   }
/*     */   
/*     */   public List<File> getCIncludeDirs()
/*     */   {
/* 108 */     return cIncludeDirs;
/*     */   }
/*     */   
/*     */   public List<File> getCppIncludeDirs()
/*     */   {
/* 114 */     return cppIncludeDirs;
/*     */   }
/*     */   
/*     */   public List<File> getCSystemIncludeDirs()
/*     */   {
/* 120 */     return cSystemIncludeDirs;
/*     */   }
/*     */   
/*     */   public List<File> getCppSystemIncludeDirs()
/*     */   {
/* 126 */     return cppSystemIncludeDirs;
/*     */   }
/*     */   
/*     */   public List<String> getCDefines()
/*     */   {
/* 132 */     return cDefines;
/*     */   }
/*     */   
/*     */   public List<String> getCppDefines()
/*     */   {
/* 138 */     return cppDefines;
/*     */   }
/*     */   
/*     */   public List<String> getCCompilerFlags()
/*     */   {
/* 144 */     return cCompilerFlags;
/*     */   }
/*     */   
/*     */   public List<String> getCppCompilerFlags()
/*     */   {
/* 150 */     return cppCompilerFlags;
/*     */   }
/*     */   
/*     */   public List<File> getDebuggableLibraryFolders()
/*     */   {
/* 156 */     return debuggableLibraryFolders;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 161 */     if (this == o) {
/* 162 */       return true;
/*     */     }
/* 164 */     if ((o == null) || (getClass() != o.getClass())) {
/* 165 */       return false;
/*     */     }
/* 167 */     NativeLibraryImpl that = (NativeLibraryImpl)o;
/* 168 */     return (Objects.equals(name, name)) && 
/* 169 */       (Objects.equals(toolchainName, toolchainName)) && 
/* 170 */       (Objects.equals(abi, abi)) && 
/* 171 */       (Objects.equals(cIncludeDirs, cIncludeDirs)) && 
/* 172 */       (Objects.equals(cppIncludeDirs, cppIncludeDirs)) && 
/* 173 */       (Objects.equals(cSystemIncludeDirs, cSystemIncludeDirs)) && 
/* 174 */       (Objects.equals(cppSystemIncludeDirs, cppSystemIncludeDirs)) && 
/* 175 */       (Objects.equals(cDefines, cDefines)) && 
/* 176 */       (Objects.equals(cppDefines, cppDefines)) && 
/* 177 */       (Objects.equals(cCompilerFlags, cCompilerFlags)) && 
/* 178 */       (Objects.equals(cppCompilerFlags, cppCompilerFlags)) && 
/* 179 */       (Objects.equals(debuggableLibraryFolders, debuggableLibraryFolders));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 184 */     return 
/* 185 */       Objects.hash(new Object[] { name, toolchainName, abi, cIncludeDirs, cppIncludeDirs, cSystemIncludeDirs, cppSystemIncludeDirs, cDefines, cppDefines, cCompilerFlags, cppCompilerFlags, debuggableLibraryFolders });
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 193 */     return 
/*     */     
/* 206 */       MoreObjects.toStringHelper(this).add("name", name).add("toolchainName", toolchainName).add("abi", abi).add("cIncludeDirs", cIncludeDirs).add("cppIncludeDirs", cppIncludeDirs).add("cSystemIncludeDirs", cSystemIncludeDirs).add("cppSystemIncludeDirs", cppSystemIncludeDirs).add("cDefines", cDefines).add("cppDefines", cppDefines).add("cCompilerFlags", cCompilerFlags).add("cppCompilerFlags", cppCompilerFlags).add("debuggableLibraryFolders", debuggableLibraryFolders).toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.NativeLibraryImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */