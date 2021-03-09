/*    */ package com.android.build.gradle.internal.api.artifact;
/*    */ 
/*    */ import com.android.build.api.artifact.ArtifactType;
/*    */ import java.util.Map;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.Pair;
/*    */ import kotlin.TuplesKt;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000*\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020$\n\002\030\002\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\020\013\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\t\032\0020\0062\006\020\n\032\0020\005J2\020\013\032\016\022\004\022\0020\005\022\004\022\0020\0060\f2\006\020\n\032\0020\0052\006\020\r\032\0020\0162\006\020\017\032\0020\0162\006\020\020\032\0020\016R \020\003\032\016\022\004\022\0020\005\022\004\022\0020\0060\004X\004¢\006\b\n\000\032\004\b\007\020\b¨\006\021"}, d2={"Lcom/android/build/gradle/internal/api/artifact/BuildArtifactSpec$Companion;", "", "()V", "specMap", "", "Lcom/android/build/api/artifact/ArtifactType;", "Lcom/android/build/gradle/internal/api/artifact/BuildArtifactSpec;", "getSpecMap", "()Ljava/util/Map;", "get", "type", "spec", "Lkotlin/Pair;", "appendable", "", "replaceable", "singleFile", "gradle-core"})
/*    */ public final class BuildArtifactSpec$Companion
/*    */ {
/*    */   private final Map<ArtifactType, BuildArtifactSpec> getSpecMap()
/*    */   {
/* 32 */     return BuildArtifactSpec.access$getSpecMap$cp();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final Pair<ArtifactType, BuildArtifactSpec> spec(@NotNull ArtifactType type, boolean appendable, boolean replaceable, boolean singleFile)
/*    */   {
/* 42 */     Intrinsics.checkParameterIsNotNull(type, "type");return TuplesKt.to(type, new BuildArtifactSpec(type, appendable, replaceable, singleFile));
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   @NotNull
/*    */   public final BuildArtifactSpec get(@NotNull ArtifactType type)
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: ldc 18
/*    */     //   3: invokestatic 24	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload_0
/*    */     //   7: checkcast 2	com/android/build/gradle/internal/api/artifact/BuildArtifactSpec$Companion
/*    */     //   10: invokespecial 43	com/android/build/gradle/internal/api/artifact/BuildArtifactSpec$Companion:getSpecMap	()Ljava/util/Map;
/*    */     //   13: aload_1
/*    */     //   14: invokeinterface 48 2 0
/*    */     //   19: checkcast 8	com/android/build/gradle/internal/api/artifact/BuildArtifactSpec
/*    */     //   22: dup
/*    */     //   23: ifnull +6 -> 29
/*    */     //   26: goto +39 -> 65
/*    */     //   29: pop
/*    */     //   30: new 50	java/lang/RuntimeException
/*    */     //   33: dup
/*    */     //   34: new 52	java/lang/StringBuilder
/*    */     //   37: dup
/*    */     //   38: invokespecial 55	java/lang/StringBuilder:<init>	()V
/*    */     //   41: ldc 57
/*    */     //   43: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   46: aload_1
/*    */     //   47: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*    */     //   50: ldc 66
/*    */     //   52: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   55: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*    */     //   58: invokespecial 73	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
/*    */     //   61: checkcast 75	java/lang/Throwable
/*    */     //   64: athrow
/*    */     //   65: areturn
/*    */     // Line number table:
/*    */     //   Java source line #45	-> byte code offset #6
/*    */     //   Java source line #46	-> byte code offset #30
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	66	0	this	Companion
/*    */     //   0	66	1	type	ArtifactType
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.artifact.BuildArtifactSpec.Companion
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */