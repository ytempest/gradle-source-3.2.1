/*    */ package com.android.build.gradle.internal.errors;
/*    */ 
/*    */ import kotlin.Metadata;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\022\n\002\030\002\n\002\020\020\n\000\n\002\020\016\n\002\b\n\b\001\030\0002\b\022\004\022\0020\0000\001B\017\b\002\022\006\020\002\032\0020\003¢\006\002\020\004R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006j\002\b\007j\002\b\bj\002\b\tj\002\b\nj\002\b\013j\002\b\f¨\006\r"}, d2={"Lcom/android/build/gradle/internal/errors/DeprecationReporter$DeprecationTarget;", "", "removalTime", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRemovalTime", "()Ljava/lang/String;", "CONFIG_NAME", "OLD_DSL", "DEX_OPTIONS", "AUTO_SPLITS_OR_RES_CONFIG", "AAPT", "LEGACY_DEXER", "gradle-core"})
/*    */ public enum DeprecationReporter$DeprecationTarget
/*    */ {
/*    */   @NotNull
/*    */   private final String removalTime;
/*    */   
/* 31 */   protected DeprecationReporter$DeprecationTarget(@NotNull String removalTime) { this.removalTime = removalTime; } @NotNull
/* 31 */   public final String getRemovalTime() { return removalTime; }
/*    */   
/* 33 */   static { DeprecationTarget[] tmp6_2 = new DeprecationTarget[6];tmp6_2[0] = (CONFIG_NAME = new DeprecationTarget("CONFIG_NAME", 0, "at the end of 2018")); DeprecationTarget[] tmp25_6 = tmp6_2;tmp25_6[1] = 
/*    */     
/* 35 */       (OLD_DSL = new DeprecationTarget("OLD_DSL", 1, "at the end of 2018")); DeprecationTarget[] tmp44_25 = tmp25_6;tmp44_25[2] = 
/*    */     
/* 37 */       (DEX_OPTIONS = new DeprecationTarget("DEX_OPTIONS", 2, "at the end of 2018")); DeprecationTarget[] tmp63_44 = tmp44_25;tmp63_44[3] = 
/*    */     
/* 39 */       (AUTO_SPLITS_OR_RES_CONFIG = new DeprecationTarget("AUTO_SPLITS_OR_RES_CONFIG", 3, "at the end of 2018")); DeprecationTarget[] tmp82_63 = tmp63_44;tmp82_63[4] = 
/*    */     
/* 41 */       (AAPT = new DeprecationTarget("AAPT", 4, "at the end of 2018")); DeprecationTarget[] tmp101_82 = tmp82_63;tmp101_82[5] = 
/*    */     
/* 43 */       (LEGACY_DEXER = new DeprecationTarget("LEGACY_DEXER", 5, "in AGP version 3.3"));
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */