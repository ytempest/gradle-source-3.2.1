/*     */ package com.android.build.gradle.internal.core;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableList.Builder;
/*     */ import java.util.Collection;
/*     */ 
/*     */ public enum Abi
/*     */ {
/*  29 */   ARMEABI("armeabi", "arm", "arm-linux-androideabi", "arm-linux-androideabi", false, false), 
/*     */   
/*  36 */   ARMEABI_V7A("armeabi-v7a", "arm", "arm-linux-androideabi", "arm-linux-androideabi", false, true), 
/*     */   
/*  43 */   ARM64_V8A("arm64-v8a", "arm64", "aarch64-linux-android", "aarch64-linux-android", true, true), 
/*     */   
/*  50 */   X86("x86", "x86", "x86", "i686-linux-android", false, true), 
/*     */   
/*  57 */   X86_64("x86_64", "x86_64", "x86_64", "x86_64-linux-android", true, true), 
/*     */   
/*  64 */   MIPS("mips", "mips", "mipsel-linux-android", "mipsel-linux-android", false, false), 
/*     */   
/*  71 */   MIPS64("mips64", "mips64", "mips64el-linux-android", "mips64el-linux-android", true, false);
/*     */   
/*     */   private final String name;
/*     */   
/*     */   final String architecture;
/*     */   
/*     */   private final String gccToolchainPrefix;
/*     */   
/*     */   private final String gccExecutablePrefix;
/*     */   
/*     */   private final boolean supports64Bits;
/*     */   
/*     */   private final boolean isDefault;
/*     */   
/*  91 */   private static ImmutableList<Abi> defaultValues = null;
/*     */   
/*     */   private Abi(String name, String architecture, String gccToolchainPrefix, String gccExecutablePrefix, boolean supports64Bits, boolean isDefault)
/*     */   {
/* 100 */     this.name = name;
/* 101 */     this.architecture = architecture;
/* 102 */     this.gccToolchainPrefix = gccToolchainPrefix;
/* 103 */     this.gccExecutablePrefix = gccExecutablePrefix;
/* 104 */     this.supports64Bits = supports64Bits;
/* 105 */     this.isDefault = isDefault;
/*     */   }
/*     */   
/*     */   public static Abi getByName(String name)
/*     */   {
/* 113 */     for (Abi abi : ) {
/* 114 */       if (name.equals(name)) {
/* 115 */         return abi;
/*     */       }
/*     */     }
/* 118 */     return null;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 126 */     return name;
/*     */   }
/*     */   
/*     */   public String getArchitecture()
/*     */   {
/* 134 */     return architecture;
/*     */   }
/*     */   
/*     */   public String getGccToolchainPrefix()
/*     */   {
/* 142 */     return gccToolchainPrefix;
/*     */   }
/*     */   
/*     */   public String getGccExecutablePrefix()
/*     */   {
/* 150 */     return gccExecutablePrefix;
/*     */   }
/*     */   
/*     */   public boolean supports64Bits()
/*     */   {
/* 157 */     return supports64Bits;
/*     */   }
/*     */   
/*     */   public static Collection<Abi> getDefaultValues()
/*     */   {
/* 166 */     if (defaultValues != null) {
/* 167 */       return defaultValues;
/*     */     }
/*     */     
/* 170 */     ImmutableList.Builder<Abi> builder = ImmutableList.builder();
/* 171 */     for (Abi abi : values()) {
/* 172 */       if (isDefault) {
/* 173 */         builder.add(abi);
/*     */       }
/*     */     }
/* 176 */     defaultValues = builder.build();
/* 177 */     return defaultValues;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.core.Abi
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */