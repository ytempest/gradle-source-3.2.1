/*     */ package com.android.build.gradle.internal.dependency;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\026\n\002\030\002\n\002\020\000\n\002\b\003\n\002\030\002\n\002\030\002\n\000\b6\030\0002\0020\001:\002\003\004B\007\b\002¢\006\002\020\002\001\002\005\006¨\006\007"}, d2={"Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$Request;", "", "()V", "RequestExternal", "RequestProject", "Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$Request$RequestProject;", "Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$Request$RequestExternal;", "gradle-core"})
/*     */ public abstract class AndroidTestResourceArtifactCollection$Request
/*     */ {
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000&\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\006\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\b\n\002\b\002\b\b\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\t\020\007\032\0020\003HÆ\003J\023\020\b\032\0020\0002\b\b\002\020\002\032\0020\003HÆ\001J\023\020\t\032\0020\n2\b\020\013\032\004\030\0010\fHÖ\003J\t\020\r\032\0020\016HÖ\001J\t\020\017\032\0020\003HÖ\001R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\020"}, d2={"Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$Request$RequestProject;", "Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$Request;", "projectPath", "", "(Ljava/lang/String;)V", "getProjectPath", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "gradle-core"})
/*     */   public static final class RequestProject
/*     */     extends AndroidTestResourceArtifactCollection.Request
/*     */   {
/*     */     @NotNull
/*     */     private final String projectPath;
/*     */     
/*     */     public boolean equals(Object paramObject)
/*     */     {
/*     */       if (this != paramObject)
/*     */       {
/*     */         if ((paramObject instanceof RequestProject))
/*     */         {
/*     */           RequestProject localRequestProject = (RequestProject)paramObject;
/*     */           if (!Intrinsics.areEqual(projectPath, projectPath)) {}
/*     */         }
/*     */       }
/*     */       else {
/*     */         return true;
/*     */       }
/*     */       return false;
/*     */     }
/*     */     
/*     */     /* Error */
/*     */     public int hashCode()
/*     */     {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: getfield 11	com/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$Request$RequestProject:projectPath	Ljava/lang/String;
/*     */       //   4: dup
/*     */       //   5: ifnull +9 -> 14
/*     */       //   8: invokevirtual 56	java/lang/Object:hashCode	()I
/*     */       //   11: goto +5 -> 16
/*     */       //   14: pop
/*     */       //   15: iconst_0
/*     */       //   16: ireturn
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/*     */       return "RequestProject(projectPath=" + projectPath + ")";
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final RequestProject copy(@NotNull String projectPath)
/*     */     {
/*     */       Intrinsics.checkParameterIsNotNull(projectPath, "projectPath");
/*     */       return new RequestProject(projectPath);
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final String component1()
/*     */     {
/*     */       return projectPath;
/*     */     }
/*     */     
/*     */     public RequestProject(@NotNull String projectPath)
/*     */     {
/* 165 */       super();this.projectPath = projectPath; } @NotNull
/* 165 */     public final String getProjectPath() { return projectPath; }
/*     */   }
/*     */   
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000&\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\t\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\b\n\002\b\002\b\b\030\0002\0020\001B\027\022\b\020\002\032\004\030\0010\003\022\006\020\004\032\0020\003¢\006\002\020\005J\013\020\t\032\004\030\0010\003HÆ\003J\t\020\n\032\0020\003HÆ\003J\037\020\013\032\0020\0002\n\b\002\020\002\032\004\030\0010\0032\b\b\002\020\004\032\0020\003HÆ\001J\023\020\f\032\0020\r2\b\020\016\032\004\030\0010\017HÖ\003J\t\020\020\032\0020\021HÖ\001J\t\020\022\032\0020\003HÖ\001R\023\020\002\032\004\030\0010\003¢\006\b\n\000\032\004\b\006\020\007R\021\020\004\032\0020\003¢\006\b\n\000\032\004\b\b\020\007¨\006\023"}, d2={"Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$Request$RequestExternal;", "Lcom/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$Request;", "group", "", "module", "(Ljava/lang/String;Ljava/lang/String;)V", "getGroup", "()Ljava/lang/String;", "getModule", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "gradle-core"})
/*     */   public static final class RequestExternal
/*     */     extends AndroidTestResourceArtifactCollection.Request
/*     */   {
/*     */     @Nullable
/*     */     private final String group;
/*     */     @NotNull
/*     */     private final String module;
/*     */     
/*     */     public boolean equals(Object paramObject)
/*     */     {
/*     */       if (this != paramObject)
/*     */       {
/*     */         if ((paramObject instanceof RequestExternal))
/*     */         {
/*     */           RequestExternal localRequestExternal = (RequestExternal)paramObject;
/*     */           if ((!Intrinsics.areEqual(group, group)) || (!Intrinsics.areEqual(module, module))) {}
/*     */         }
/*     */       }
/*     */       else {
/*     */         return true;
/*     */       }
/*     */       return false;
/*     */     }
/*     */     
/*     */     /* Error */
/*     */     public int hashCode()
/*     */     {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: getfield 11	com/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$Request$RequestExternal:group	Ljava/lang/String;
/*     */       //   4: dup
/*     */       //   5: ifnull +9 -> 14
/*     */       //   8: invokevirtual 64	java/lang/Object:hashCode	()I
/*     */       //   11: goto +5 -> 16
/*     */       //   14: pop
/*     */       //   15: iconst_0
/*     */       //   16: bipush 31
/*     */       //   18: imul
/*     */       //   19: aload_0
/*     */       //   20: getfield 18	com/android/build/gradle/internal/dependency/AndroidTestResourceArtifactCollection$Request$RequestExternal:module	Ljava/lang/String;
/*     */       //   23: dup
/*     */       //   24: ifnull +9 -> 33
/*     */       //   27: invokevirtual 64	java/lang/Object:hashCode	()I
/*     */       //   30: goto +5 -> 35
/*     */       //   33: pop
/*     */       //   34: iconst_0
/*     */       //   35: iadd
/*     */       //   36: ireturn
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/*     */       return "RequestExternal(group=" + group + ", module=" + module + ")";
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final RequestExternal copy(@Nullable String group, @NotNull String module)
/*     */     {
/*     */       Intrinsics.checkParameterIsNotNull(module, "module");
/*     */       return new RequestExternal(group, module);
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final String component2()
/*     */     {
/*     */       return module;
/*     */     }
/*     */     
/*     */     @Nullable
/*     */     public final String component1()
/*     */     {
/*     */       return group;
/*     */     }
/*     */     
/*     */     public RequestExternal(@Nullable String group, @NotNull String module)
/*     */     {
/* 166 */       super();this.group = group;this.module = module; } @NotNull
/* 166 */     public final String getModule() { return module; } @Nullable
/* 166 */     public final String getGroup() { return group; }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.AndroidTestResourceArtifactCollection.Request
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */