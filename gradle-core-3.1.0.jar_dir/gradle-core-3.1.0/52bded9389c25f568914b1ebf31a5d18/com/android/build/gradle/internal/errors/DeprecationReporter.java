/*    */ package com.android.build.gradle.internal.errors;
/*    */ 
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000(\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\013\bf\030\0002\0020\001:\001\030J \020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\0052\006\020\007\032\0020\bH&J\"\020\t\032\0020\0032\006\020\n\032\0020\0052\b\020\013\032\004\030\0010\0052\006\020\007\032\0020\bH&J\"\020\f\032\0020\0032\030\020\r\032\024\022\004\022\0020\005\022\004\022\0020\005\022\004\022\0020\b0\016H&J \020\017\032\0020\0032\006\020\020\032\0020\0052\006\020\021\032\0020\0052\006\020\007\032\0020\bH&J(\020\017\032\0020\0032\006\020\020\032\0020\0052\006\020\021\032\0020\0052\006\020\022\032\0020\0052\006\020\007\032\0020\bH&J4\020\023\032\0020\0032\006\020\024\032\0020\0052\006\020\025\032\0020\0052\b\020\026\032\004\030\0010\0052\b\020\022\032\004\030\0010\0052\006\020\007\032\0020\bH&J\030\020\027\032\0020\0032\006\020\021\032\0020\0052\006\020\007\032\0020\bH&J \020\027\032\0020\0032\006\020\021\032\0020\0052\006\020\022\032\0020\0052\006\020\007\032\0020\bH&¨\006\031"}, d2={"Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "", "reportDeprecatedConfiguration", "", "newConfiguration", "", "oldConfiguration", "deprecationTarget", "Lcom/android/build/gradle/internal/errors/DeprecationReporter$DeprecationTarget;", "reportDeprecatedOption", "option", "value", "reportDeprecatedOptions", "options", "Lcom/google/common/collect/ImmutableTable;", "reportDeprecatedUsage", "newDslElement", "oldDslElement", "url", "reportDeprecatedValue", "dslElement", "oldValue", "newValue", "reportObsoleteUsage", "DeprecationTarget", "gradle-core"})
/*    */ public abstract interface DeprecationReporter
/*    */ {
/*    */   public abstract void reportDeprecatedUsage(@NotNull String paramString1, @NotNull String paramString2, @NotNull DeprecationTarget paramDeprecationTarget);
/*    */   
/*    */   public abstract void reportDeprecatedUsage(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull DeprecationTarget paramDeprecationTarget);
/*    */   
/*    */   public abstract void reportDeprecatedValue(@NotNull String paramString1, @NotNull String paramString2, @org.jetbrains.annotations.Nullable String paramString3, @org.jetbrains.annotations.Nullable String paramString4, @NotNull DeprecationTarget paramDeprecationTarget);
/*    */   
/*    */   public abstract void reportObsoleteUsage(@NotNull String paramString, @NotNull DeprecationTarget paramDeprecationTarget);
/*    */   
/*    */   public abstract void reportObsoleteUsage(@NotNull String paramString1, @NotNull String paramString2, @NotNull DeprecationTarget paramDeprecationTarget);
/*    */   
/*    */   public abstract void reportDeprecatedConfiguration(@NotNull String paramString1, @NotNull String paramString2, @NotNull DeprecationTarget paramDeprecationTarget);
/*    */   
/*    */   public abstract void reportDeprecatedOption(@NotNull String paramString1, @org.jetbrains.annotations.Nullable String paramString2, @NotNull DeprecationTarget paramDeprecationTarget);
/*    */   
/*    */   public abstract void reportDeprecatedOptions(@NotNull com.google.common.collect.ImmutableTable<String, String, DeprecationTarget> paramImmutableTable);
/*    */   
/*    */   @kotlin.Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\022\n\002\030\002\n\002\020\020\n\000\n\002\020\016\n\002\b\n\b\001\030\0002\b\022\004\022\0020\0000\001B\017\b\002\022\006\020\002\032\0020\003¢\006\002\020\004R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006j\002\b\007j\002\b\bj\002\b\tj\002\b\nj\002\b\013j\002\b\f¨\006\r"}, d2={"Lcom/android/build/gradle/internal/errors/DeprecationReporter$DeprecationTarget;", "", "removalTime", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRemovalTime", "()Ljava/lang/String;", "CONFIG_NAME", "OLD_DSL", "DEX_OPTIONS", "AUTO_SPLITS_OR_RES_CONFIG", "AAPT", "LEGACY_DEXER", "gradle-core"})
/*    */   public static enum DeprecationTarget
/*    */   {
/*    */     @NotNull
/*    */     private final String removalTime;
/*    */     
/* 31 */     protected DeprecationTarget(@NotNull String removalTime) { this.removalTime = removalTime; } @NotNull
/* 31 */     public final String getRemovalTime() { return removalTime; }
/*    */     
/* 33 */     static { DeprecationTarget[] tmp6_2 = new DeprecationTarget[6];tmp6_2[0] = (CONFIG_NAME = new DeprecationTarget("CONFIG_NAME", 0, "at the end of 2018")); DeprecationTarget[] tmp25_6 = tmp6_2;tmp25_6[1] = 
/*    */       
/* 35 */         (OLD_DSL = new DeprecationTarget("OLD_DSL", 1, "at the end of 2018")); DeprecationTarget[] tmp44_25 = tmp25_6;tmp44_25[2] = 
/*    */       
/* 37 */         (DEX_OPTIONS = new DeprecationTarget("DEX_OPTIONS", 2, "at the end of 2018")); DeprecationTarget[] tmp63_44 = tmp44_25;tmp63_44[3] = 
/*    */       
/* 39 */         (AUTO_SPLITS_OR_RES_CONFIG = new DeprecationTarget("AUTO_SPLITS_OR_RES_CONFIG", 3, "at the end of 2018")); DeprecationTarget[] tmp82_63 = tmp63_44;tmp82_63[4] = 
/*    */       
/* 41 */         (AAPT = new DeprecationTarget("AAPT", 4, "at the end of 2018")); DeprecationTarget[] tmp101_82 = tmp82_63;tmp101_82[5] = 
/*    */       
/* 43 */         (LEGACY_DEXER = new DeprecationTarget("LEGACY_DEXER", 5, "in AGP version 3.3"));
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.errors.DeprecationReporter
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */