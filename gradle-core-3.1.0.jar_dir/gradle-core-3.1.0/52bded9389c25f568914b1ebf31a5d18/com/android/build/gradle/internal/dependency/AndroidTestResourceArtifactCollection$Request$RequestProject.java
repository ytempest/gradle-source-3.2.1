/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000&\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\006\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\b\n\002\b\002\b\b\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\t\020\007\032\0020\003HÆ\003J\023\020\b\032\0020\0002\b\b\002\020\002\032\0020\003HÆ\001J\023\020\t\032\0020\n2\b\020\013\032\004\030\0010\fHÖ\003J\t\020\r\032\0020\016HÖ\001J\t\020\017\032\0020\003HÖ\001R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\020"}, d2={"Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$Request$RequestProject;", "Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$Request;", "projectPath", "", "(Ljava/lang/String;)V", "getProjectPath", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "gradle-core"})
/*     */ public final class AndroidTestResourceArtifactCollection$Request$RequestProject
/*     */   extends AndroidTestResourceArtifactCollection.Request
/*     */ {
/*     */   @NotNull
/*     */   private final String projectPath;
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/*     */     if (this != paramObject)
/*     */     {
/*     */       if ((paramObject instanceof RequestProject))
/*     */       {
/*     */         RequestProject localRequestProject = (RequestProject)paramObject;
/*     */         if (!Intrinsics.areEqual(projectPath, projectPath)) {}
/*     */       }
/*     */     }
/*     */     else {
/*     */       return true;
/*     */     }
/*     */     return false;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public int hashCode()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 11	com/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$Request$RequestProject:projectPath	Ljava/lang/String;
/*     */     //   4: dup
/*     */     //   5: ifnull +9 -> 14
/*     */     //   8: invokevirtual 56	java/lang/Object:hashCode	()I
/*     */     //   11: goto +5 -> 16
/*     */     //   14: pop
/*     */     //   15: iconst_0
/*     */     //   16: ireturn
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/*     */     return "RequestProject(projectPath=" + projectPath + ")";
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final RequestProject copy(@NotNull String projectPath)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(projectPath, "projectPath");
/*     */     return new RequestProject(projectPath);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final String component1()
/*     */   {
/*     */     return projectPath;
/*     */   }
/*     */   
/*     */   public AndroidTestResourceArtifactCollection$Request$RequestProject(@NotNull String projectPath)
/*     */   {
/* 165 */     super(null);this.projectPath = projectPath; } @NotNull
/* 165 */   public final String getProjectPath() { return projectPath; }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.AndroidTestResourceArtifactCollection.Request.RequestProject
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */