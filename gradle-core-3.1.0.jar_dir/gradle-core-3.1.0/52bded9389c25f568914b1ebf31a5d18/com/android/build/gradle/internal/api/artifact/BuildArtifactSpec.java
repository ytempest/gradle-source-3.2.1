/*    */ package com.android.build.gradle.internal.api.artifact;
/*    */ 
/*    */ import com.android.build.api.artifact.ArtifactType;
/*    */ import com.android.build.api.artifact.BuildArtifactType;
/*    */ import java.util.Map;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.Pair;
/*    */ import kotlin.TuplesKt;
/*    */ import kotlin.collections.MapsKt;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000&\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\021\n\002\020\b\n\000\n\002\020\016\n\002\b\002\b\b\030\000 \0322\0020\001:\001\032B%\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\005\022\006\020\007\032\0020\005¢\006\002\020\bJ\t\020\017\032\0020\003HÆ\003J\t\020\020\032\0020\005HÆ\003J\t\020\021\032\0020\005HÆ\003J\t\020\022\032\0020\005HÆ\003J1\020\023\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\0052\b\b\002\020\006\032\0020\0052\b\b\002\020\007\032\0020\005HÆ\001J\023\020\024\032\0020\0052\b\020\025\032\004\030\0010\001HÖ\003J\t\020\026\032\0020\027HÖ\001J\t\020\030\032\0020\031HÖ\001R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\t\020\nR\021\020\006\032\0020\005¢\006\b\n\000\032\004\b\013\020\nR\021\020\007\032\0020\005¢\006\b\n\000\032\004\b\f\020\nR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\r\020\016¨\006\033"}, d2={"Lcom/android/build/gradle/internal/api/artifact/BuildArtifactSpec;", "", "type", "Lcom/android/build/api/artifact/ArtifactType;", "appendable", "", "replaceable", "singleFile", "(Lcom/android/build/api/artifact/ArtifactType;ZZZ)V", "getAppendable", "()Z", "getReplaceable", "getSingleFile", "getType", "()Lcom/android/build/api/artifact/ArtifactType;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "gradle-core"})
/*    */ public final class BuildArtifactSpec
/*    */ {
/*    */   public BuildArtifactSpec(@NotNull ArtifactType type, boolean appendable, boolean replaceable, boolean singleFile)
/*    */   {
/* 25 */     this.type = type;this.appendable = appendable;this.replaceable = replaceable;this.singleFile = singleFile; } @NotNull
/* 26 */   public final ArtifactType getType() { return type; }
/* 27 */   public final boolean getAppendable() { return appendable; }
/* 28 */   public final boolean getReplaceable() { return replaceable; }
/* 29 */   public final boolean getSingleFile() { return singleFile; }
/*    */   
/* 32 */   public static final Companion Companion = new Companion(null); private static final Map<ArtifactType, BuildArtifactSpec> specMap = MapsKt.mapOf(new Pair[] {
/*    */   
/* 34 */     Companion.spec((ArtifactType)BuildArtifactType.JAVAC_CLASSES, true, true, false), 
/* 35 */     Companion.spec((ArtifactType)BuildArtifactType.JAVA_COMPILE_CLASSPATH, true, false, false) });
/*    */   private final boolean singleFile;
/*    */   private final boolean replaceable;
/*    */   private final boolean appendable;
/*    */   @NotNull
/*    */   private final ArtifactType type;
/*    */   
/*    */   @NotNull
/*    */   public final ArtifactType component1()
/*    */   {
/*    */     return type;
/*    */   }
/*    */   
/*    */   public final boolean component2()
/*    */   {
/*    */     return appendable;
/*    */   }
/*    */   
/*    */   public final boolean component3()
/*    */   {
/*    */     return replaceable;
/*    */   }
/*    */   
/*    */   public final boolean component4()
/*    */   {
/*    */     return singleFile;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final BuildArtifactSpec copy(@NotNull ArtifactType type, boolean appendable, boolean replaceable, boolean singleFile)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(type, "type");
/*    */     return new BuildArtifactSpec(type, appendable, replaceable, singleFile);
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/*    */     return "BuildArtifactSpec(type=" + type + ", appendable=" + appendable + ", replaceable=" + replaceable + ", singleFile=" + singleFile + ")";
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public int hashCode()
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: getfield 11	com/android/build/gradle/internal/api/artifact/BuildArtifactSpec:type	Lcom/android/build/api/artifact/ArtifactType;
/*    */     //   4: dup
/*    */     //   5: ifnull +9 -> 14
/*    */     //   8: invokevirtual 92	java/lang/Object:hashCode	()I
/*    */     //   11: goto +5 -> 16
/*    */     //   14: pop
/*    */     //   15: iconst_0
/*    */     //   16: bipush 31
/*    */     //   18: imul
/*    */     //   19: aload_0
/*    */     //   20: getfield 19	com/android/build/gradle/internal/api/artifact/BuildArtifactSpec:appendable	Z
/*    */     //   23: dup
/*    */     //   24: ifeq +5 -> 29
/*    */     //   27: pop
/*    */     //   28: iconst_1
/*    */     //   29: iadd
/*    */     //   30: bipush 31
/*    */     //   32: imul
/*    */     //   33: aload_0
/*    */     //   34: getfield 23	com/android/build/gradle/internal/api/artifact/BuildArtifactSpec:replaceable	Z
/*    */     //   37: dup
/*    */     //   38: ifeq +5 -> 43
/*    */     //   41: pop
/*    */     //   42: iconst_1
/*    */     //   43: iadd
/*    */     //   44: bipush 31
/*    */     //   46: imul
/*    */     //   47: aload_0
/*    */     //   48: getfield 27	com/android/build/gradle/internal/api/artifact/BuildArtifactSpec:singleFile	Z
/*    */     //   51: dup
/*    */     //   52: ifeq +5 -> 57
/*    */     //   55: pop
/*    */     //   56: iconst_1
/*    */     //   57: iadd
/*    */     //   58: ireturn
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject)
/*    */   {
/*    */     if (this != paramObject)
/*    */     {
/*    */       if ((paramObject instanceof BuildArtifactSpec))
/*    */       {
/*    */         BuildArtifactSpec localBuildArtifactSpec = (BuildArtifactSpec)paramObject;
/*    */         if (Intrinsics.areEqual(type, type)) {
/*    */           if ((appendable == appendable ? 1 : 0) != 0) {
/*    */             if ((replaceable == replaceable ? 1 : 0) != 0) {
/*    */               if ((singleFile == singleFile ? 1 : 0) == 0) {}
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     else {
/*    */       return true;
/*    */     }
/*    */     return false;
/*    */   }
/*    */   
/*    */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000*\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020$\n\002\030\002\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\020\013\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\t\032\0020\0062\006\020\n\032\0020\005J2\020\013\032\016\022\004\022\0020\005\022\004\022\0020\0060\f2\006\020\n\032\0020\0052\006\020\r\032\0020\0162\006\020\017\032\0020\0162\006\020\020\032\0020\016R \020\003\032\016\022\004\022\0020\005\022\004\022\0020\0060\004X\004¢\006\b\n\000\032\004\b\007\020\b¨\006\021"}, d2={"Lcom/android/build/gradle/internal/api/artifact/BuildArtifactSpec$Companion;", "", "()V", "specMap", "", "Lcom/android/build/api/artifact/ArtifactType;", "Lcom/android/build/gradle/internal/api/artifact/BuildArtifactSpec;", "getSpecMap", "()Ljava/util/Map;", "get", "type", "spec", "Lkotlin/Pair;", "appendable", "", "replaceable", "singleFile", "gradle-core"})
/*    */   public static final class Companion
/*    */   {
/*    */     private final Map<ArtifactType, BuildArtifactSpec> getSpecMap()
/*    */     {
/* 32 */       return BuildArtifactSpec.access$getSpecMap$cp();
/*    */     }
/*    */     
/*    */     @NotNull
/*    */     public final Pair<ArtifactType, BuildArtifactSpec> spec(@NotNull ArtifactType type, boolean appendable, boolean replaceable, boolean singleFile)
/*    */     {
/* 42 */       Intrinsics.checkParameterIsNotNull(type, "type");return TuplesKt.to(type, new BuildArtifactSpec(type, appendable, replaceable, singleFile));
/*    */     }
/*    */     
/*    */     /* Error */
/*    */     @NotNull
/*    */     public final BuildArtifactSpec get(@NotNull ArtifactType type)
/*    */     {
/*    */       // Byte code:
/*    */       //   0: aload_1
/*    */       //   1: ldc 18
/*    */       //   3: invokestatic 24	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*    */       //   6: aload_0
/*    */       //   7: checkcast 2	com/android/build/gradle/internal/api/artifact/BuildArtifactSpec$Companion
/*    */       //   10: invokespecial 43	com/android/build/gradle/internal/api/artifact/BuildArtifactSpec$Companion:getSpecMap	()Ljava/util/Map;
/*    */       //   13: aload_1
/*    */       //   14: invokeinterface 48 2 0
/*    */       //   19: checkcast 8	com/android/build/gradle/internal/api/artifact/BuildArtifactSpec
/*    */       //   22: dup
/*    */       //   23: ifnull +6 -> 29
/*    */       //   26: goto +39 -> 65
/*    */       //   29: pop
/*    */       //   30: new 50	java/lang/RuntimeException
/*    */       //   33: dup
/*    */       //   34: new 52	java/lang/StringBuilder
/*    */       //   37: dup
/*    */       //   38: invokespecial 55	java/lang/StringBuilder:<init>	()V
/*    */       //   41: ldc 57
/*    */       //   43: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */       //   46: aload_1
/*    */       //   47: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */       //   50: ldc 66
/*    */       //   52: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */       //   55: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*    */       //   58: invokespecial 73	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
/*    */       //   61: checkcast 75	java/lang/Throwable
/*    */       //   64: athrow
/*    */       //   65: areturn
/*    */       // Line number table:
/*    */       //   Java source line #45	-> byte code offset #6
/*    */       //   Java source line #46	-> byte code offset #30
/*    */       // Local variable table:
/*    */       //   start	length	slot	name	signature
/*    */       //   0	66	0	this	Companion
/*    */       //   0	66	1	type	ArtifactType
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.artifact.BuildArtifactSpec
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */