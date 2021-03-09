/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0008\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020 \n\002\b\002\n\002\020$\n\002\020\016\n\002\b\016\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\b\n\002\b\002\b\b\030\0002\0020\001BC\022\006\020\002\032\0020\003\022\016\b\002\020\004\032\b\022\004\022\0020\0030\005\022\016\b\002\020\006\032\b\022\004\022\0020\0030\005\022\024\b\002\020\007\032\016\022\004\022\0020\t\022\004\022\0020\0030\b¢\006\002\020\nJ\t\020\022\032\0020\003HÆ\003J\017\020\023\032\b\022\004\022\0020\0030\005HÆ\003J\017\020\024\032\b\022\004\022\0020\0030\005HÆ\003J\025\020\025\032\016\022\004\022\0020\t\022\004\022\0020\0030\bHÆ\003JI\020\026\032\0020\0002\b\b\002\020\002\032\0020\0032\016\b\002\020\004\032\b\022\004\022\0020\0030\0052\016\b\002\020\006\032\b\022\004\022\0020\0030\0052\024\b\002\020\007\032\016\022\004\022\0020\t\022\004\022\0020\0030\bHÆ\001J\023\020\027\032\0020\0302\b\020\031\032\004\030\0010\032HÖ\003J\t\020\033\032\0020\034HÖ\001J\t\020\035\032\0020\tHÖ\001R\027\020\004\032\b\022\004\022\0020\0030\005¢\006\b\n\000\032\004\b\013\020\fR\035\020\007\032\016\022\004\022\0020\t\022\004\022\0020\0030\b¢\006\b\n\000\032\004\b\r\020\016R\027\020\006\032\b\022\004\022\0020\0030\005¢\006\b\n\000\032\004\b\017\020\fR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\020\020\021¨\006\036"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/JarRequest;", "Ljava/io/Serializable;", "toFile", "Ljava/io/File;", "fromDirectories", "", "fromJars", "fromFiles", "", "", "(Ljava/io/File;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getFromDirectories", "()Ljava/util/List;", "getFromFiles", "()Ljava/util/Map;", "getFromJars", "getToFile", "()Ljava/io/File;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "gradle-core"})
/*    */ public final class JarRequest
/*    */   implements Serializable
/*    */ {
/*    */   @NotNull
/*    */   private final File toFile;
/*    */   @NotNull
/*    */   private final List<File> fromDirectories;
/*    */   @NotNull
/*    */   private final List<File> fromJars;
/*    */   @NotNull
/*    */   private final Map<String, File> fromFiles;
/*    */   
/*    */   public JarRequest(@NotNull File toFile, @NotNull List<? extends File> fromDirectories, @NotNull List<? extends File> fromJars, @NotNull Map<String, ? extends File> fromFiles)
/*    */   {
/* 34 */     this.toFile = toFile;this.fromDirectories = fromDirectories;this.fromJars = fromJars;this.fromFiles = fromFiles; } @NotNull
/* 35 */   public final File getToFile() { return toFile; } @NotNull
/* 36 */   public final List<File> getFromDirectories() { return fromDirectories; } @NotNull
/* 37 */   public final List<File> getFromJars() { return fromJars; } @NotNull
/* 38 */   public final Map<String, File> getFromFiles() { return fromFiles; }
/*    */   
/*    */   @NotNull
/*    */   public final File component1()
/*    */   {
/*    */     return toFile;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final List<File> component2()
/*    */   {
/*    */     return fromDirectories;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final List<File> component3()
/*    */   {
/*    */     return fromJars;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final Map<String, File> component4()
/*    */   {
/*    */     return fromFiles;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final JarRequest copy(@NotNull File toFile, @NotNull List<? extends File> fromDirectories, @NotNull List<? extends File> fromJars, @NotNull Map<String, ? extends File> fromFiles)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(toFile, "toFile");
/*    */     Intrinsics.checkParameterIsNotNull(fromDirectories, "fromDirectories");
/*    */     Intrinsics.checkParameterIsNotNull(fromJars, "fromJars");
/*    */     Intrinsics.checkParameterIsNotNull(fromFiles, "fromFiles");
/*    */     return new JarRequest(toFile, fromDirectories, fromJars, fromFiles);
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/*    */     return "JarRequest(toFile=" + toFile + ", fromDirectories=" + fromDirectories + ", fromJars=" + fromJars + ", fromFiles=" + fromFiles + ")";
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public int hashCode()
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield 13	com/android/build/gradle/internal/res/namespaced/JarRequest:toFile	Ljava/io/File;
/*    */     //   4: dup
/*    */     //   5: ifnull +9 -> 14
/*    */     //   8: invokevirtual 99	java/lang/Object:hashCode	()I
/*    */     //   11: goto +5 -> 16
/*    */     //   14: pop
/*    */     //   15: iconst_0
/*    */     //   16: bipush 31
/*    */     //   18: imul
/*    */     //   19: aload_0
/*    */     //   20: getfield 22	com/android/build/gradle/internal/res/namespaced/JarRequest:fromDirectories	Ljava/util/List;
/*    */     //   23: dup
/*    */     //   24: ifnull +9 -> 33
/*    */     //   27: invokevirtual 99	java/lang/Object:hashCode	()I
/*    */     //   30: goto +5 -> 35
/*    */     //   33: pop
/*    */     //   34: iconst_0
/*    */     //   35: iadd
/*    */     //   36: bipush 31
/*    */     //   38: imul
/*    */     //   39: aload_0
/*    */     //   40: getfield 26	com/android/build/gradle/internal/res/namespaced/JarRequest:fromJars	Ljava/util/List;
/*    */     //   43: dup
/*    */     //   44: ifnull +9 -> 53
/*    */     //   47: invokevirtual 99	java/lang/Object:hashCode	()I
/*    */     //   50: goto +5 -> 55
/*    */     //   53: pop
/*    */     //   54: iconst_0
/*    */     //   55: iadd
/*    */     //   56: bipush 31
/*    */     //   58: imul
/*    */     //   59: aload_0
/*    */     //   60: getfield 33	com/android/build/gradle/internal/res/namespaced/JarRequest:fromFiles	Ljava/util/Map;
/*    */     //   63: dup
/*    */     //   64: ifnull +9 -> 73
/*    */     //   67: invokevirtual 99	java/lang/Object:hashCode	()I
/*    */     //   70: goto +5 -> 75
/*    */     //   73: pop
/*    */     //   74: iconst_0
/*    */     //   75: iadd
/*    */     //   76: ireturn
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject)
/*    */   {
/*    */     if (this != paramObject)
/*    */     {
/*    */       if ((paramObject instanceof JarRequest))
/*    */       {
/*    */         JarRequest localJarRequest = (JarRequest)paramObject;
/*    */         if ((!Intrinsics.areEqual(toFile, toFile)) || (!Intrinsics.areEqual(fromDirectories, fromDirectories)) || (!Intrinsics.areEqual(fromJars, fromJars)) || (!Intrinsics.areEqual(fromFiles, fromFiles))) {}
/*    */       }
/*    */     }
/*    */     else {
/*    */       return true;
/*    */     }
/*    */     return false;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.JarRequest
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */