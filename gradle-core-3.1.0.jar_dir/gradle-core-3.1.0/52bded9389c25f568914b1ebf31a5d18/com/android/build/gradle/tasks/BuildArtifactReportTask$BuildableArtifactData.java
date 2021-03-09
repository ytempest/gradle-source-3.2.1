/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.google.gson.annotations.SerializedName;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\020\000\n\000\n\002\020\036\n\002\030\002\n\000\n\002\020 \n\002\020\016\n\002\b\r\n\002\020\013\n\002\b\002\n\002\020\b\n\002\b\002\b\b\030\0002\0020\001B!\022\f\020\002\032\b\022\004\022\0020\0040\003\022\f\020\005\032\b\022\004\022\0020\0070\006¢\006\002\020\bJ\017\020\021\032\b\022\004\022\0020\0040\003HÆ\003J\017\020\022\032\b\022\004\022\0020\0070\006HÆ\003J)\020\023\032\0020\0002\016\b\002\020\002\032\b\022\004\022\0020\0040\0032\016\b\002\020\005\032\b\022\004\022\0020\0070\006HÆ\001J\023\020\024\032\0020\0252\b\020\026\032\004\030\0010\001HÖ\003J\t\020\027\032\0020\030HÖ\001J\t\020\031\032\0020\007HÖ\001R$\020\005\032\b\022\004\022\0020\0070\0068\006@\006X\016¢\006\016\n\000\032\004\b\t\020\n\"\004\b\013\020\fR$\020\002\032\b\022\004\022\0020\0040\0038\006@\006X\016¢\006\016\n\000\032\004\b\r\020\016\"\004\b\017\020\020¨\006\032"}, d2={"Lcom/android/build/gradle/tasks/BuildArtifactReportTask$BuildableArtifactData;", "", "files", "", "Ljava/io/File;", "builtBy", "", "", "(Ljava/util/Collection;Ljava/util/List;)V", "getBuiltBy", "()Ljava/util/List;", "setBuiltBy", "(Ljava/util/List;)V", "getFiles", "()Ljava/util/Collection;", "setFiles", "(Ljava/util/Collection;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "gradle-core"})
/*     */ public final class BuildArtifactReportTask$BuildableArtifactData
/*     */ {
/*     */   @SerializedName("files")
/*     */   @NotNull
/*     */   private Collection<? extends File> files;
/*     */   @SerializedName("builtBy")
/*     */   @NotNull
/*     */   private List<String> builtBy;
/*     */   
/*     */   public BuildArtifactReportTask$BuildableArtifactData(@NotNull Collection<? extends File> files, @NotNull List<String> builtBy)
/*     */   {
/* 116 */     this.files = files;this.builtBy = builtBy; } @NotNull
/* 117 */   public final Collection<File> getFiles() { return files; } public final void setFiles(@NotNull Collection<? extends File> <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");files = <set-?>; } @NotNull
/* 118 */   public final List<String> getBuiltBy() { return builtBy; } public final void setBuiltBy(@NotNull List<String> <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");builtBy = <set-?>;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Collection<File> component1()
/*     */   {
/*     */     return files;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final List<String> component2()
/*     */   {
/*     */     return builtBy;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BuildableArtifactData copy(@NotNull Collection<? extends File> files, @NotNull List<String> builtBy)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(files, "files");
/*     */     Intrinsics.checkParameterIsNotNull(builtBy, "builtBy");
/*     */     return new BuildableArtifactData(files, builtBy);
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/*     */     return "BuildableArtifactData(files=" + files + ", builtBy=" + builtBy + ")";
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public int hashCode()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 14	com/android/build/gradle/tasks/BuildArtifactReportTask$BuildableArtifactData:files	Ljava/util/Collection;
/*     */     //   4: dup
/*     */     //   5: ifnull +9 -> 14
/*     */     //   8: invokevirtual 76	java/lang/Object:hashCode	()I
/*     */     //   11: goto +5 -> 16
/*     */     //   14: pop
/*     */     //   15: iconst_0
/*     */     //   16: bipush 31
/*     */     //   18: imul
/*     */     //   19: aload_0
/*     */     //   20: getfield 33	com/android/build/gradle/tasks/BuildArtifactReportTask$BuildableArtifactData:builtBy	Ljava/util/List;
/*     */     //   23: dup
/*     */     //   24: ifnull +9 -> 33
/*     */     //   27: invokevirtual 76	java/lang/Object:hashCode	()I
/*     */     //   30: goto +5 -> 35
/*     */     //   33: pop
/*     */     //   34: iconst_0
/*     */     //   35: iadd
/*     */     //   36: ireturn
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/*     */     if (this != paramObject)
/*     */     {
/*     */       if ((paramObject instanceof BuildableArtifactData))
/*     */       {
/*     */         BuildableArtifactData localBuildableArtifactData = (BuildableArtifactData)paramObject;
/*     */         if ((!Intrinsics.areEqual(files, files)) || (!Intrinsics.areEqual(builtBy, builtBy))) {}
/*     */       }
/*     */     }
/*     */     else {
/*     */       return true;
/*     */     }
/*     */     return false;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.BuildArtifactReportTask.BuildableArtifactData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */