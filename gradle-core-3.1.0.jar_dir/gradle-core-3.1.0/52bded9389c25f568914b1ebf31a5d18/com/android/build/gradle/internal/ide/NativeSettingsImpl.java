/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.builder.model.NativeSettings;
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ import java.util.Objects;
/*    */ 
/*    */ public final class NativeSettingsImpl
/*    */   implements NativeSettings, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final String name;
/*    */   private final List<String> compilerFlags;
/*    */   
/*    */   public NativeSettingsImpl(String name, List<String> compilerFlags)
/*    */   {
/* 40 */     this.name = name;
/* 41 */     this.compilerFlags = compilerFlags;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 47 */     return name;
/*    */   }
/*    */   
/*    */   public List<String> getCompilerFlags()
/*    */   {
/* 53 */     return compilerFlags;
/*    */   }
/*    */   
/*    */   public boolean equals(Object o)
/*    */   {
/* 58 */     if (this == o) {
/* 59 */       return true;
/*    */     }
/* 61 */     if ((o == null) || (getClass() != o.getClass())) {
/* 62 */       return false;
/*    */     }
/* 64 */     NativeSettingsImpl that = (NativeSettingsImpl)o;
/* 65 */     return (Objects.equals(name, name)) && 
/* 66 */       (Objects.equals(compilerFlags, compilerFlags));
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 71 */     return Objects.hash(new Object[] { name, compilerFlags });
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 76 */     return 
/*    */     
/* 79 */       MoreObjects.toStringHelper(this).add("name", name).add("compilerFlags", compilerFlags).toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.NativeSettingsImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */