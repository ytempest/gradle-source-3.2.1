/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.builder.model.Dependencies.ProjectIdentifier;
/*    */ import java.io.Serializable;
/*    */ import java.util.Objects;
/*    */ 
/*    */ public class DependenciesImpl$ProjectIdentifierImpl
/*    */   implements Dependencies.ProjectIdentifier, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final String buildId;
/*    */   private final String projectPath;
/*    */   
/*    */   public DependenciesImpl$ProjectIdentifierImpl(String buildId, String projectPath)
/*    */   {
/* 46 */     this.buildId = buildId;
/* 47 */     this.projectPath = projectPath;
/*    */   }
/*    */   
/*    */   public String getBuildId()
/*    */   {
/* 53 */     return buildId;
/*    */   }
/*    */   
/*    */   public String getProjectPath()
/*    */   {
/* 59 */     return projectPath;
/*    */   }
/*    */   
/*    */   public boolean equals(Object o)
/*    */   {
/* 64 */     if (this == o) {
/* 65 */       return true;
/*    */     }
/* 67 */     if ((o == null) || (getClass() != o.getClass())) {
/* 68 */       return false;
/*    */     }
/* 70 */     ProjectIdentifierImpl that = (ProjectIdentifierImpl)o;
/* 71 */     return (Objects.equals(buildId, buildId)) && 
/* 72 */       (Objects.equals(projectPath, projectPath));
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 77 */     return Objects.hash(new Object[] { buildId, projectPath });
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.DependenciesImpl.ProjectIdentifierImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */