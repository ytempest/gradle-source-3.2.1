/*    */ package com.android.build.gradle.shrinker;
/*    */ 
/*    */ import com.android.build.gradle.shrinker.parser.GrammarActions;
/*    */ import com.android.build.gradle.shrinker.parser.ProguardFlags;
/*    */ import com.android.build.gradle.shrinker.parser.UnsupportedFlagsHandler;
/*    */ import java.io.File;
/*    */ import org.antlr.runtime.RecognitionException;
/*    */ 
/*    */ public class ProguardConfig
/*    */ {
/* 29 */   private final ProguardFlags mFlags = new ProguardFlags();
/*    */   
/*    */   public void parse(File configFile, UnsupportedFlagsHandler flagsHandler) {
/*    */     try {
/* 33 */       GrammarActions.parse(configFile, mFlags, flagsHandler);
/*    */     } catch (RecognitionException e) {
/* 35 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */   
/*    */   public void parse(String input) {
/*    */     try {
/* 41 */       GrammarActions.parse(input, mFlags, UnsupportedFlagsHandler.NO_OP);
/*    */     } catch (RecognitionException e) {
/* 43 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */   
/*    */   public ProguardFlags getFlags()
/*    */   {
/* 49 */     return mFlags;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.ProguardConfig
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */