/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.builder.model.Library;
/*     */ import com.android.builder.model.MavenCoordinates;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import com.google.common.base.Objects;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ abstract class LibraryImpl
/*     */   implements Library, Serializable
/*     */ {
/*     */   private final String buildId;
/*     */   private final String project;
/*     */   private final String name;
/*     */   private final MavenCoordinates requestedCoordinates;
/*     */   private final MavenCoordinates resolvedCoordinates;
/*     */   private final boolean isSkipped;
/*     */   private final boolean isProvided;
/*     */   
/*     */   LibraryImpl(String buildId, String project, MavenCoordinates requestedCoordinates, MavenCoordinates resolvedCoordinates, boolean isSkipped, boolean isProvided)
/*     */   {
/*  55 */     name = resolvedCoordinates.toString();
/*  56 */     this.buildId = buildId;
/*  57 */     this.project = project;
/*  58 */     this.requestedCoordinates = requestedCoordinates;
/*  59 */     this.resolvedCoordinates = resolvedCoordinates;
/*  60 */     this.isSkipped = isSkipped;
/*  61 */     this.isProvided = isProvided;
/*     */   }
/*     */   
/*     */   protected LibraryImpl(Library clonedLibrary, boolean isSkipped) {
/*  65 */     name = clonedLibrary.getName();
/*  66 */     buildId = clonedLibrary.getBuildId();
/*  67 */     project = clonedLibrary.getProject();
/*  68 */     requestedCoordinates = clonedLibrary.getRequestedCoordinates();
/*  69 */     resolvedCoordinates = clonedLibrary.getResolvedCoordinates();
/*  70 */     this.isSkipped = isSkipped;
/*  71 */     isProvided = clonedLibrary.isProvided();
/*     */   }
/*     */   
/*     */   public String getBuildId()
/*     */   {
/*  77 */     return buildId;
/*     */   }
/*     */   
/*     */   public String getProject()
/*     */   {
/*  83 */     return project;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  89 */     return name;
/*     */   }
/*     */   
/*     */   public MavenCoordinates getRequestedCoordinates()
/*     */   {
/*  95 */     return requestedCoordinates;
/*     */   }
/*     */   
/*     */   public MavenCoordinates getResolvedCoordinates()
/*     */   {
/* 101 */     return resolvedCoordinates;
/*     */   }
/*     */   
/*     */   public boolean isSkipped()
/*     */   {
/* 106 */     return isSkipped;
/*     */   }
/*     */   
/*     */   public boolean isProvided()
/*     */   {
/* 111 */     return isProvided;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 116 */     if (this == o) {
/* 117 */       return true;
/*     */     }
/* 119 */     if ((o == null) || (getClass() != o.getClass())) {
/* 120 */       return false;
/*     */     }
/* 122 */     LibraryImpl library = (LibraryImpl)o;
/* 123 */     if ((isSkipped == isSkipped) && (isProvided == isProvided)) {} return 
/*     */     
/* 125 */       (Objects.equal(buildId, buildId)) && 
/* 126 */       (Objects.equal(project, project)) && 
/* 127 */       (Objects.equal(name, name)) && 
/* 128 */       (Objects.equal(requestedCoordinates, requestedCoordinates)) && 
/* 129 */       (Objects.equal(resolvedCoordinates, resolvedCoordinates));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 134 */     return Objects.hashCode(new Object[] { buildId, project, name, requestedCoordinates, resolvedCoordinates, 
/*     */     
/* 140 */       Boolean.valueOf(isSkipped), 
/* 141 */       Boolean.valueOf(isProvided) });
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 146 */     return 
/*     */     
/* 154 */       MoreObjects.toStringHelper(this).add("name", name).add("buildId", buildId).add("project", project).add("requestedCoordinates", requestedCoordinates).add("resolvedCoordinates", resolvedCoordinates).add("isSkipped", isSkipped).add("isProvided", isProvided).toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.LibraryImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */