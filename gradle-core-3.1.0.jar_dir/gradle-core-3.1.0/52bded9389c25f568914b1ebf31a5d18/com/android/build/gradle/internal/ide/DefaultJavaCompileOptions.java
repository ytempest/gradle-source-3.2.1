/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.build.gradle.internal.CompileOptions;
/*    */ import com.android.builder.model.JavaCompileOptions;
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ import org.gradle.api.JavaVersion;
/*    */ 
/*    */ final class DefaultJavaCompileOptions
/*    */   implements JavaCompileOptions, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final String sourceCompatibility;
/*    */   private final String targetCompatibility;
/*    */   private final String encoding;
/*    */   
/*    */   DefaultJavaCompileOptions(CompileOptions options)
/*    */   {
/* 40 */     sourceCompatibility = options.getSourceCompatibility().toString();
/* 41 */     targetCompatibility = options.getTargetCompatibility().toString();
/* 42 */     encoding = options.getEncoding();
/*    */   }
/*    */   
/*    */   public String getSourceCompatibility()
/*    */   {
/* 48 */     return sourceCompatibility;
/*    */   }
/*    */   
/*    */   public String getTargetCompatibility()
/*    */   {
/* 54 */     return targetCompatibility;
/*    */   }
/*    */   
/*    */   public String getEncoding()
/*    */   {
/* 60 */     return encoding;
/*    */   }
/*    */   
/*    */   public boolean equals(Object o)
/*    */   {
/* 65 */     if (this == o) {
/* 66 */       return true;
/*    */     }
/* 68 */     if ((o == null) || (getClass() != o.getClass())) {
/* 69 */       return false;
/*    */     }
/* 71 */     DefaultJavaCompileOptions that = (DefaultJavaCompileOptions)o;
/* 72 */     return (Objects.equals(sourceCompatibility, sourceCompatibility)) && 
/* 73 */       (Objects.equals(targetCompatibility, targetCompatibility)) && 
/* 74 */       (Objects.equals(encoding, encoding));
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 79 */     return Objects.hash(new Object[] { sourceCompatibility, targetCompatibility, encoding });
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.DefaultJavaCompileOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */