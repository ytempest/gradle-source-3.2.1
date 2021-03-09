/*    */ package com.android.build.gradle.external.gnumake;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import joptsimple.OptionParser;
/*    */ import joptsimple.OptionSpecBuilder;
/*    */ 
/*    */ public class CompilerParser
/*    */ {
/* 30 */   static final OptionParser PARSER = new OptionParser();
/*    */   
/* 40 */   static final List<String> WITH_REQUIRED_ARG_FLAGS = Arrays.asList(new String[] { "target", "MF", "gcc-toolchain", "f", "m", "O", "D", "I", "std", "isystem", "o", "sysroot", "l", "L", "U", "include", "macros" });
/*    */   
/* 66 */   static final List<String> WITH_NO_ARG_FLAGS = Arrays.asList(new String[] { "c", "g", "MMD", "MP", "nostdlib", "no-canonical-prefixes", "shared", "pie" });
/*    */   
/*    */   static
/*    */   {
/* 80 */     PARSER.allowsUnrecognizedOptions();
/*    */     
/* 83 */     PARSER.recognizeAlternativeLongOptions(true);
/*    */     
/* 85 */     for (String flag : WITH_REQUIRED_ARG_FLAGS) {
/* 86 */       PARSER.accepts(flag).withRequiredArg();
/*    */     }
/*    */     
/* 89 */     for (String flag : WITH_NO_ARG_FLAGS) {
/* 90 */       PARSER.accepts(flag);
/*    */     }
/*    */   }
/*    */   
/*    */   static OptionParser get()
/*    */   {
/* 96 */     return PARSER;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.gnumake.CompilerParser
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */