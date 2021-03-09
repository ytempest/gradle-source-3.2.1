/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.builder.model.JavaLibrary;
/*    */ import com.android.builder.model.MavenCoordinates;
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import java.io.File;
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ import java.util.Objects;
/*    */ 
/*    */ public final class JavaLibraryImpl
/*    */   extends LibraryImpl
/*    */   implements JavaLibrary, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final File jarFile;
/*    */   private final List<JavaLibrary> dependencies;
/*    */   
/*    */   public JavaLibraryImpl(File jarFile, String buildId, String project, List<JavaLibrary> dependencies, MavenCoordinates requestedCoordinates, MavenCoordinates resolvedCoordinates, boolean isSkipped, boolean isProvided)
/*    */   {
/* 50 */     super(buildId, project, requestedCoordinates, resolvedCoordinates, isSkipped, isProvided);
/* 51 */     this.jarFile = jarFile;
/* 52 */     this.dependencies = ImmutableList.copyOf(dependencies);
/*    */   }
/*    */   
/*    */   public File getJarFile()
/*    */   {
/* 58 */     return jarFile;
/*    */   }
/*    */   
/*    */   public List<? extends JavaLibrary> getDependencies()
/*    */   {
/* 64 */     return dependencies;
/*    */   }
/*    */   
/*    */   public boolean equals(Object o)
/*    */   {
/* 69 */     if (this == o) {
/* 70 */       return true;
/*    */     }
/* 72 */     if ((o == null) || (getClass() != o.getClass())) {
/* 73 */       return false;
/*    */     }
/* 75 */     if (!super.equals(o)) {
/* 76 */       return false;
/*    */     }
/* 78 */     JavaLibraryImpl that = (JavaLibraryImpl)o;
/* 79 */     return (Objects.equals(jarFile, jarFile)) && 
/* 80 */       (Objects.equals(dependencies, dependencies));
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 85 */     return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), jarFile, dependencies });
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 90 */     return 
/*    */     
/* 94 */       MoreObjects.toStringHelper(this).add("super", super.toString()).add("jarFile", jarFile).add("dependencies", dependencies).toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.JavaLibraryImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */