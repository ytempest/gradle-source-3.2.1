/*    */ package com.android.build.gradle.internal.api;
/*    */ 
/*    */ import com.android.build.gradle.api.AndroidSourceFile;
/*    */ import java.io.File;
/*    */ import org.gradle.api.Project;
/*    */ 
/*    */ public class DefaultAndroidSourceFile
/*    */   implements AndroidSourceFile
/*    */ {
/*    */   private final String name;
/*    */   private final Project project;
/*    */   private Object source;
/*    */   
/*    */   DefaultAndroidSourceFile(String name, Project project)
/*    */   {
/* 32 */     this.name = name;
/* 33 */     this.project = project;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 38 */     return name;
/*    */   }
/*    */   
/*    */   public AndroidSourceFile srcFile(Object o)
/*    */   {
/* 43 */     source = o;
/* 44 */     return this;
/*    */   }
/*    */   
/*    */   public File getSrcFile()
/*    */   {
/* 49 */     return project.file(source);
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 54 */     return source.toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.DefaultAndroidSourceFile
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */