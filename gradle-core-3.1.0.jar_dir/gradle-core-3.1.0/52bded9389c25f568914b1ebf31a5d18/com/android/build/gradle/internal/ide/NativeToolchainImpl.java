/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.builder.model.NativeToolchain;
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ import java.io.File;
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ 
/*    */ public final class NativeToolchainImpl
/*    */   implements NativeToolchain, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final String name;
/*    */   private final File cCompilerExecutable;
/*    */   private final File cppCompilerExecutable;
/*    */   
/*    */   public NativeToolchainImpl(String name, File cCompilerExecutable, File cppCompilerExecutable)
/*    */   {
/* 46 */     this.name = name;
/* 47 */     this.cCompilerExecutable = cCompilerExecutable;
/* 48 */     this.cppCompilerExecutable = cppCompilerExecutable;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 54 */     return name;
/*    */   }
/*    */   
/*    */   public File getCCompilerExecutable()
/*    */   {
/* 60 */     return cCompilerExecutable;
/*    */   }
/*    */   
/*    */   public File getCppCompilerExecutable()
/*    */   {
/* 66 */     return cppCompilerExecutable;
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
/* 77 */     NativeToolchainImpl that = (NativeToolchainImpl)o;
/* 78 */     return (Objects.equals(name, name)) && 
/* 79 */       (Objects.equals(cCompilerExecutable, cCompilerExecutable)) && 
/* 80 */       (Objects.equals(cppCompilerExecutable, cppCompilerExecutable));
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 85 */     return Objects.hash(new Object[] { name, cCompilerExecutable, cppCompilerExecutable });
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 90 */     return 
/*    */     
/* 94 */       MoreObjects.toStringHelper(this).add("name", name).add("cCompilerExecutable", cCompilerExecutable).add("cppCompilerExecutable", cppCompilerExecutable).toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.NativeToolchainImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */