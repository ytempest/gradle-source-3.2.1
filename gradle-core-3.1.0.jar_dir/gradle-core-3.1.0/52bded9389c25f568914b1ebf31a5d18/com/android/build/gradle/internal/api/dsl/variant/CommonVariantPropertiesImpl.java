/*    */ package com.android.build.gradle.internal.api.dsl.variant;
/*    */ 
/*    */ import com.android.build.api.sourcesets.AndroidSourceSet;
/*    */ import com.android.build.gradle.internal.api.sourcesets.DefaultAndroidSourceSet;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.util.List;
/*    */ import org.gradle.api.Action;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000@\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\020 \n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\013\n\002\020\002\n\000\n\002\030\002\n\002\b\002\030\0002\0020\0012\0020\002BM\022\006\020\003\032\0020\004\022\006\020\005\032\0020\004\022\f\020\006\032\b\022\004\022\0020\0040\007\022\f\020\b\032\b\022\004\022\0020\t0\007\022\b\020\n\032\004\030\0010\013\022\b\020\f\032\004\030\0010\013\022\006\020\r\032\0020\016¢\006\002\020\017J\026\020\f\032\0020\0322\f\020\033\032\b\022\004\022\0020\t0\034H\026J\b\020\035\032\0020\032H\026J\026\020\n\032\0020\0322\f\020\033\032\b\022\004\022\0020\t0\034H\026R\032\020\020\032\b\022\004\022\0020\t0\007X\004¢\006\b\n\000\032\004\b\021\020\022R\024\020\005\032\0020\004X\004¢\006\b\n\000\032\004\b\023\020\024R\032\020\006\032\b\022\004\022\0020\0040\007X\004¢\006\b\n\000\032\004\b\025\020\022R\026\020\f\032\004\030\0010\013X\004¢\006\b\n\000\032\004\b\026\020\027R\024\020\003\032\0020\004X\004¢\006\b\n\000\032\004\b\030\020\024R\026\020\n\032\004\030\0010\013X\004¢\006\b\n\000\032\004\b\031\020\027¨\006\036"}, d2={"Lcom/android/build/gradle/internal/api/dsl/variant/CommonVariantPropertiesImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/variant/CommonVariantProperties;", "name", "", "buildTypeName", "flavorNames", "", "sourceSets", "Lcom/android/build/api/sourcesets/AndroidSourceSet;", "variantSourceSet", "Lcom/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet;", "multiFlavorSourceSet", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet;Lcom/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet;Lcom/android/builder/errors/EvalIssueReporter;)V", "baseSourceSets", "getBaseSourceSets", "()Ljava/util/List;", "getBuildTypeName", "()Ljava/lang/String;", "getFlavorNames", "getMultiFlavorSourceSet", "()Lcom/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet;", "getName", "getVariantSourceSet", "", "action", "Lorg/gradle/api/Action;", "seal", "gradle-core"})
/*    */ public final class CommonVariantPropertiesImpl
/*    */   extends com.android.build.gradle.internal.api.dsl.sealing.SealableObject
/*    */   implements com.android.build.api.dsl.variant.CommonVariantProperties
/*    */ {
/*    */   @NotNull
/*    */   private final List<String> flavorNames;
/*    */   @NotNull
/*    */   private final List<AndroidSourceSet> baseSourceSets;
/*    */   @NotNull
/*    */   private final String name;
/*    */   @NotNull
/*    */   private final String buildTypeName;
/*    */   @Nullable
/*    */   private final DefaultAndroidSourceSet variantSourceSet;
/*    */   @Nullable
/*    */   private final DefaultAndroidSourceSet multiFlavorSourceSet;
/*    */   
/*    */   @NotNull
/* 30 */   public String getName() { return name; } @NotNull
/* 31 */   public String getBuildTypeName() { return buildTypeName; }
/*    */   
/*    */   @Nullable
/* 34 */   public DefaultAndroidSourceSet getVariantSourceSet() { return variantSourceSet; } @Nullable
/* 35 */   public DefaultAndroidSourceSet getMultiFlavorSourceSet() { return multiFlavorSourceSet; }
/*    */   
/*    */   @NotNull
/* 39 */   public List<String> getFlavorNames() { return flavorNames; } @NotNull
/* 40 */   public List<AndroidSourceSet> getBaseSourceSets() { return baseSourceSets; }
/*    */   
/*    */   public CommonVariantPropertiesImpl(@NotNull String name, @NotNull String buildTypeName, @NotNull List<String> flavorNames, @NotNull List<? extends AndroidSourceSet> sourceSets, @Nullable DefaultAndroidSourceSet variantSourceSet, @Nullable DefaultAndroidSourceSet multiFlavorSourceSet, @NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 37 */     super(issueReporter);this.name = name;this.buildTypeName = buildTypeName;this.variantSourceSet = variantSourceSet;this.multiFlavorSourceSet = multiFlavorSourceSet; com.google.common.collect.ImmutableList 
/*    */     
/* 39 */       tmp68_65 = com.google.common.collect.ImmutableList.copyOf((java.util.Collection)flavorNames);kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(tmp68_65, "ImmutableList.copyOf(flavorNames)");this.flavorNames = ((List)tmp68_65); com.google.common.collect.ImmutableList 
/* 40 */       tmp89_86 = com.google.common.collect.ImmutableList.copyOf((java.util.Collection)sourceSets);kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(tmp89_86, "ImmutableList.copyOf(sourceSets)");baseSourceSets = ((List)tmp89_86);
/*    */   }
/*    */   
/* 43 */   public void variantSourceSet(@NotNull Action<AndroidSourceSet> action) { kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action"); if (getVariantSourceSet() != null) {
/* 44 */       action.execute(getVariantSourceSet());
/*    */     } else {
/* 46 */       getIssueReporter().reportError(
/* 47 */         com.android.builder.errors.EvalIssueReporter.Type.GENERIC, 
/* 48 */         "Calling variantSourceSet(Action) with a null variantSourceSet");
/*    */     }
/*    */   }
/*    */   
/*    */   public void multiFlavorSourceSet(@NotNull Action<AndroidSourceSet> action) {
/* 53 */     kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action"); if (getMultiFlavorSourceSet() != null) {
/* 54 */       action.execute(getMultiFlavorSourceSet());
/*    */     } else {
/* 56 */       getIssueReporter().reportError(
/* 57 */         com.android.builder.errors.EvalIssueReporter.Type.GENERIC, 
/* 58 */         "Calling multiFlavorSourceSet(Action) with a null multiFlavorSourceSet");
/*    */     }
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public void seal()
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokespecial 70	com/android/build/gradle/internal/api/dsl/sealing/SealableObject:seal	()V
/*    */     //   4: aload_0
/*    */     //   5: invokevirtual 35	com/android/build/gradle/internal/api/dsl/variant/CommonVariantPropertiesImpl:getVariantSourceSet	()Lcom/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet;
/*    */     //   8: dup
/*    */     //   9: ifnull +9 -> 18
/*    */     //   12: invokevirtual 73	com/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet:seal	()V
/*    */     //   15: goto +4 -> 19
/*    */     //   18: pop
/*    */     //   19: aload_0
/*    */     //   20: invokevirtual 64	com/android/build/gradle/internal/api/dsl/variant/CommonVariantPropertiesImpl:getMultiFlavorSourceSet	()Lcom/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet;
/*    */     //   23: dup
/*    */     //   24: ifnull +9 -> 33
/*    */     //   27: invokevirtual 73	com/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet:seal	()V
/*    */     //   30: goto +4 -> 34
/*    */     //   33: pop
/*    */     //   34: return
/*    */     // Line number table:
/*    */     //   Java source line #63	-> byte code offset #0
/*    */     //   Java source line #65	-> byte code offset #4
/*    */     //   Java source line #66	-> byte code offset #19
/*    */     //   Java source line #67	-> byte code offset #34
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	35	0	this	CommonVariantPropertiesImpl
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.variant.CommonVariantPropertiesImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */