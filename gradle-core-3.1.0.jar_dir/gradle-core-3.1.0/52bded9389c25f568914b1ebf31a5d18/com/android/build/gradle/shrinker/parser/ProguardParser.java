/*      */ package com.android.build.gradle.shrinker.parser;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import org.antlr.runtime.BitSet;
/*      */ import org.antlr.runtime.MismatchedSetException;
/*      */ import org.antlr.runtime.NoViableAltException;
/*      */ import org.antlr.runtime.Parser;
/*      */ import org.antlr.runtime.ParserRuleReturnScope;
/*      */ import org.antlr.runtime.RecognitionException;
/*      */ import org.antlr.runtime.RecognizerSharedState;
/*      */ import org.antlr.runtime.Token;
/*      */ import org.antlr.runtime.TokenStream;
/*      */ 
/*      */ public class ProguardParser extends Parser
/*      */ {
/*   17 */   public static final String[] tokenNames = { "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LINE_COMMENT", "NAME", "NEGATOR", "WS", "'%'", "'('", "')'", "','", "'-adaptclassstrings'", "'-adaptresourcefilecontents'", "'-adaptresourcefilenames'", "'-allowaccessmodification'", "'-applymapping'", "'-assumenosideeffects'", "'-basedirectory'", "'-classobfuscationdictionary'", "'-dontnote'", "'-dontobfuscate'", "'-dontoptimize'", "'-dontpreverify'", "'-dontshrink'", "'-dontskipnonpubliclibraryclasses'", "'-dontskipnonpubliclibraryclassmembers'", "'-dontusemixedcaseclassnames'", "'-dontwarn'", "'-dump'", "'-flattenpackagehierarchy'", "'-forceprocessing'", "'-ignorewarnings'", "'-include'", "'-injars'", "'-keep'", "'-keepattributes'", "'-keepclasseswithmembernames'", "'-keepclasseswithmembers'", "'-keepclassmembernames'", "'-keepclassmembers'", "'-keepdirectories'", "'-keepnames'", "'-keeppackagenames'", "'-keepparameternames'", "'-libraryjars'", "'-mergeinterfacesaggressively'", "'-microedition'", "'-obfuscationdictionary'", "'-optimizationpasses'", "'-optimizations'", "'-outjars'", "'-overloadaggressively'", "'-packageobfuscationdictionary'", "'-printconfiguration'", "'-printmapping'", "'-printseeds'", "'-printusage'", "'-renamesourcefileattribute'", "'-repackageclasses'", "'-skipnonpubliclibraryclasses'", "'-target'", "'-useuniqueclassmembernames'", "'-verbose'", "'-whyareyoukeeping'", "':'", "';'", "'<fields>'", "'<init>'", "'<methods>'", "'@'", "'[]'", "'\\''", "'abstract'", "'allowobfuscation'", "'allowoptimization'", "'allowshrinking'", "'bridge'", "'class'", "'enum'", "'extends'", "'final'", "'implements'", "'includedescriptorclasses'", "'interface'", "'native'", "'private'", "'protected'", "'public'", "'static'", "'strictfp'", "'synchronized'", "'synthetic'", "'transient'", "'varargs'", "'volatile'", "'{'", "'}'" };
/*      */   
/*      */   public static final int EOF = -1;
/*      */   
/*      */   public static final int T__8 = 8;
/*      */   
/*      */   public static final int T__9 = 9;
/*      */   
/*      */   public static final int T__10 = 10;
/*      */   
/*      */   public static final int T__11 = 11;
/*      */   
/*      */   public static final int T__12 = 12;
/*      */   
/*      */   public static final int T__13 = 13;
/*      */   
/*      */   public static final int T__14 = 14;
/*      */   
/*      */   public static final int T__15 = 15;
/*      */   
/*      */   public static final int T__16 = 16;
/*      */   
/*      */   public static final int T__17 = 17;
/*      */   
/*      */   public static final int T__18 = 18;
/*      */   
/*      */   public static final int T__19 = 19;
/*      */   
/*      */   public static final int T__20 = 20;
/*      */   
/*      */   public static final int T__21 = 21;
/*      */   
/*      */   public static final int T__22 = 22;
/*      */   
/*      */   public static final int T__23 = 23;
/*      */   
/*      */   public static final int T__24 = 24;
/*      */   
/*      */   public static final int T__25 = 25;
/*      */   
/*      */   public static final int T__26 = 26;
/*      */   
/*      */   public static final int T__27 = 27;
/*      */   
/*      */   public static final int T__28 = 28;
/*      */   
/*      */   public static final int T__29 = 29;
/*      */   
/*      */   public static final int T__30 = 30;
/*      */   public static final int T__31 = 31;
/*      */   public static final int T__32 = 32;
/*      */   public static final int T__33 = 33;
/*      */   public static final int T__34 = 34;
/*      */   public static final int T__35 = 35;
/*      */   public static final int T__36 = 36;
/*      */   public static final int T__37 = 37;
/*      */   public static final int T__38 = 38;
/*      */   public static final int T__39 = 39;
/*      */   public static final int T__40 = 40;
/*      */   public static final int T__41 = 41;
/*      */   public static final int T__42 = 42;
/*      */   public static final int T__43 = 43;
/*      */   public static final int T__44 = 44;
/*      */   public static final int T__45 = 45;
/*      */   public static final int T__46 = 46;
/*      */   public static final int T__47 = 47;
/*      */   public static final int T__48 = 48;
/*      */   public static final int T__49 = 49;
/*      */   public static final int T__50 = 50;
/*      */   public static final int T__51 = 51;
/*      */   public static final int T__52 = 52;
/*      */   public static final int T__53 = 53;
/*      */   public static final int T__54 = 54;
/*      */   public static final int T__55 = 55;
/*      */   public static final int T__56 = 56;
/*      */   public static final int T__57 = 57;
/*      */   public static final int T__58 = 58;
/*      */   public static final int T__59 = 59;
/*      */   public static final int T__60 = 60;
/*      */   public static final int T__61 = 61;
/*      */   public static final int T__62 = 62;
/*      */   public static final int T__63 = 63;
/*      */   public static final int T__64 = 64;
/*      */   public static final int T__65 = 65;
/*      */   public static final int T__66 = 66;
/*      */   public static final int T__67 = 67;
/*      */   public static final int T__68 = 68;
/*      */   public static final int T__69 = 69;
/*      */   public static final int T__70 = 70;
/*      */   public static final int T__71 = 71;
/*      */   public static final int T__72 = 72;
/*      */   public static final int T__73 = 73;
/*      */   public static final int T__74 = 74;
/*      */   public static final int T__75 = 75;
/*      */   public static final int T__76 = 76;
/*      */   public static final int T__77 = 77;
/*      */   public static final int T__78 = 78;
/*      */   public static final int T__79 = 79;
/*      */   public static final int T__80 = 80;
/*      */   public static final int T__81 = 81;
/*      */   public static final int T__82 = 82;
/*      */   public static final int T__83 = 83;
/*      */   public static final int T__84 = 84;
/*      */   public static final int T__85 = 85;
/*      */   public static final int T__86 = 86;
/*      */   public static final int T__87 = 87;
/*      */   public static final int T__88 = 88;
/*      */   public static final int T__89 = 89;
/*      */   public static final int T__90 = 90;
/*      */   public static final int T__91 = 91;
/*      */   public static final int T__92 = 92;
/*      */   public static final int T__93 = 93;
/*      */   public static final int T__94 = 94;
/*      */   public static final int T__95 = 95;
/*      */   public static final int T__96 = 96;
/*      */   public static final int T__97 = 97;
/*      */   public static final int LINE_COMMENT = 4;
/*      */   public static final int NAME = 5;
/*      */   public static final int NEGATOR = 6;
/*      */   public static final int WS = 7;
/*      */   
/*      */   public Parser[] getDelegates()
/*      */   {
/*  140 */     return new Parser[0];
/*      */   }
/*      */   
/*      */   public ProguardParser(TokenStream input)
/*      */   {
/*  147 */     this(input, new RecognizerSharedState());
/*      */   }
/*      */   
/*  150 */   public ProguardParser(TokenStream input, RecognizerSharedState state) { super(input, state); }
/*      */   
/*  153 */   public String[] getTokenNames() { return tokenNames; }
/*  154 */   public String getGrammarFileName() { return "Proguard.g"; }
/*      */   
/*      */   public void emitErrorMessage(String msg)
/*      */   {
/*  159 */     throw new ProguardParserException(msg);
/*      */   }
/*      */   
/*      */   public final void prog(ProguardFlags flags, UnsupportedFlagsHandler flagsHandler, String baseDirectory)
/*      */     throws RecognitionException
/*      */   {
/*  167 */     Token baseDir = null;
/*  168 */     Token proguardFile = null;
/*  169 */     Token target = null;
/*  170 */     KeepModifier keepModifier = null;
/*  171 */     ClassSpecification classSpec = null;
/*  172 */     ParserRuleReturnScope unFlag = null;
/*      */     
/*      */     try
/*      */     {
/*      */       for (;;)
/*      */       {
/*  181 */         int alt1 = 14;
/*  182 */         switch (input.LA(1))
/*      */         {
/*      */         case 18: 
/*  185 */           alt1 = 1;
/*      */           
/*  187 */           break;
/*      */         
/*      */         case 33: 
/*      */         case 70: 
/*  191 */           alt1 = 2;
/*      */           
/*  193 */           break;
/*      */         
/*      */         case 40: 
/*  196 */           alt1 = 3;
/*      */           
/*  198 */           break;
/*      */         
/*      */         case 38: 
/*  201 */           alt1 = 4;
/*      */           
/*  203 */           break;
/*      */         
/*      */         case 35: 
/*  206 */           alt1 = 5;
/*      */           
/*  208 */           break;
/*      */         
/*      */         case 12: 
/*      */         case 13: 
/*      */         case 14: 
/*      */         case 15: 
/*      */         case 16: 
/*      */         case 17: 
/*      */         case 19: 
/*      */         case 20: 
/*      */         case 23: 
/*      */         case 25: 
/*      */         case 26: 
/*      */         case 27: 
/*      */         case 29: 
/*      */         case 30: 
/*      */         case 31: 
/*      */         case 34: 
/*      */         case 36: 
/*      */         case 37: 
/*      */         case 39: 
/*      */         case 41: 
/*      */         case 42: 
/*      */         case 43: 
/*      */         case 44: 
/*      */         case 45: 
/*      */         case 46: 
/*      */         case 47: 
/*      */         case 48: 
/*      */         case 49: 
/*      */         case 50: 
/*      */         case 51: 
/*      */         case 52: 
/*      */         case 53: 
/*      */         case 54: 
/*      */         case 55: 
/*      */         case 56: 
/*      */         case 57: 
/*      */         case 58: 
/*      */         case 59: 
/*      */         case 60: 
/*      */         case 62: 
/*      */         case 63: 
/*  251 */           alt1 = 6;
/*      */           
/*  253 */           break;
/*      */         
/*      */         case 28: 
/*  256 */           alt1 = 7;
/*      */           
/*  258 */           break;
/*      */         
/*      */         case 32: 
/*  261 */           alt1 = 8;
/*      */           
/*  263 */           break;
/*      */         
/*      */         case 61: 
/*  266 */           alt1 = 9;
/*      */           
/*  268 */           break;
/*      */         
/*      */         case 64: 
/*  271 */           alt1 = 10;
/*      */           
/*  273 */           break;
/*      */         
/*      */         case 24: 
/*  276 */           alt1 = 11;
/*      */           
/*  278 */           break;
/*      */         
/*      */         case 22: 
/*  281 */           alt1 = 12;
/*      */           
/*  283 */           break;
/*      */         
/*      */         case 21: 
/*  286 */           alt1 = 13;
/*      */         }
/*      */         
/*      */         
/*  290 */         switch (alt1)
/*      */         {
/*      */         case 1: 
/*  297 */           match(input, 18, FOLLOW_18_in_prog81);
/*  298 */           baseDir = (Token)match(input, 5, FOLLOW_NAME_in_prog85);
/*  299 */           baseDirectory = baseDir != null ? baseDir.getText() : null;
/*      */           
/*  303 */           break;
/*      */         
/*      */         case 2: 
/*  307 */           if ((input.LA(1) == 33) || (input.LA(1) == 70)) {
/*  308 */             input.consume();
/*  309 */             state.errorRecovery = false;
/*      */           }
/*      */           else {
/*  312 */             MismatchedSetException mse = new MismatchedSetException(null, input);
/*  313 */             throw mse;
/*      */           }
/*  315 */           proguardFile = (Token)match(input, 5, FOLLOW_NAME_in_prog104);
/*  316 */           GrammarActions.include(proguardFile != null ? proguardFile.getText() : null, baseDirectory, flags, flagsHandler);
/*      */           
/*  318 */           break;
/*      */         
/*      */         case 3: 
/*  325 */           match(input, 40, FOLLOW_40_in_prog115);
/*  326 */           pushFollow(FOLLOW_keepOptionModifier_in_prog119);
/*  327 */           keepModifier = keepOptionModifier();
/*  328 */           state._fsp -= 1;
/*      */           
/*  330 */           pushFollow(FOLLOW_classSpecification_in_prog123);
/*  331 */           classSpec = classSpecification();
/*  332 */           state._fsp -= 1;
/*      */           
/*  334 */           GrammarActions.addKeepClassMembers(flags, classSpec, keepModifier);
/*      */           
/*  338 */           break;
/*      */         
/*      */         case 4: 
/*  345 */           match(input, 38, FOLLOW_38_in_prog135);
/*  346 */           pushFollow(FOLLOW_keepOptionModifier_in_prog139);
/*  347 */           keepModifier = keepOptionModifier();
/*  348 */           state._fsp -= 1;
/*      */           
/*  350 */           pushFollow(FOLLOW_classSpecification_in_prog143);
/*  351 */           classSpec = classSpecification();
/*  352 */           state._fsp -= 1;
/*      */           
/*  354 */           GrammarActions.addKeepClassesWithMembers(flags, classSpec, keepModifier);
/*      */           
/*  358 */           break;
/*      */         
/*      */         case 5: 
/*  365 */           match(input, 35, FOLLOW_35_in_prog155);
/*  366 */           pushFollow(FOLLOW_keepOptionModifier_in_prog159);
/*  367 */           keepModifier = keepOptionModifier();
/*  368 */           state._fsp -= 1;
/*      */           
/*  370 */           pushFollow(FOLLOW_classSpecification_in_prog163);
/*  371 */           classSpec = classSpecification();
/*  372 */           state._fsp -= 1;
/*      */           
/*  374 */           GrammarActions.addKeepClassSpecification(flags, classSpec, keepModifier);
/*      */           
/*  378 */           break;
/*      */         
/*      */         case 6: 
/*  385 */           pushFollow(FOLLOW_unsupportedFlag_in_prog177);
/*  386 */           unFlag = unsupportedFlag();
/*  387 */           state._fsp -= 1;
/*      */           
/*  389 */           flagsHandler.unsupportedFlag(unFlag != null ? input.toString(start, stop) : null);
/*      */           
/*  393 */           break;
/*      */         
/*      */         case 7: 
/*  400 */           match(input, 28, FOLLOW_28_in_prog189);
/*  401 */           List<FilterSpecification> class_filter = new ArrayList();
/*  402 */           pushFollow(FOLLOW_filter_in_prog193);
/*  403 */           filter(class_filter, GrammarActions.FilterSeparator.CLASS);
/*  404 */           state._fsp -= 1;
/*      */           
/*  406 */           GrammarActions.dontWarn(flags, class_filter);
/*      */           
/*  410 */           break;
/*      */         
/*      */         case 8: 
/*  417 */           match(input, 32, FOLLOW_32_in_prog206);
/*  418 */           GrammarActions.ignoreWarnings(flags);
/*      */           
/*  422 */           break;
/*      */         
/*      */         case 9: 
/*  429 */           match(input, 61, FOLLOW_61_in_prog218);
/*  430 */           target = (Token)match(input, 5, FOLLOW_NAME_in_prog222);
/*  431 */           GrammarActions.target(flags, target != null ? target.getText() : null);
/*      */           
/*  435 */           break;
/*      */         
/*      */         case 10: 
/*  442 */           match(input, 64, FOLLOW_64_in_prog234);
/*  443 */           pushFollow(FOLLOW_classSpecification_in_prog238);
/*  444 */           classSpec = classSpecification();
/*  445 */           state._fsp -= 1;
/*      */           
/*  447 */           GrammarActions.whyAreYouKeeping(flags, classSpec);
/*      */           
/*  451 */           break;
/*      */         
/*      */         case 11: 
/*  458 */           match(input, 24, FOLLOW_24_in_prog250);
/*  459 */           GrammarActions.dontShrink(flags);
/*      */           
/*  463 */           break;
/*      */         
/*      */         case 12: 
/*  470 */           match(input, 22, FOLLOW_22_in_prog263);
/*  471 */           GrammarActions.dontOptimize(flags);
/*      */           
/*  475 */           break;
/*      */         
/*      */         case 13: 
/*  482 */           match(input, 21, FOLLOW_21_in_prog276);
/*  483 */           GrammarActions.dontObfuscate(flags);
/*      */           
/*  487 */           break;
/*      */         default: 
/*      */           break label1144;
/*      */         }
/*      */         
/*      */       }
/*      */       label1144:
/*  494 */       match(input, -1, FOLLOW_EOF_in_prog288);
/*      */     }
/*      */     catch (RecognitionException e)
/*      */     {
/*  498 */       e = 
/*      */       
/*  506 */         e;throw e;
/*      */     }
/*      */     finally {}
/*      */   }
/*      */   
/*      */   public final unsupportedFlag_return unsupportedFlag()
/*      */     throws RecognitionException
/*      */   {
/*  518 */     unsupportedFlag_return retval = new unsupportedFlag_return();
/*  519 */     start = input.LT(1);
/*      */     
/*  521 */     Token classObfuscationDictionary = null;
/*  522 */     Token obfuscationDictionary = null;
/*  523 */     Token packageObfuscationDictionary = null;
/*  524 */     Token outputMapping = null;
/*  525 */     Token mapping = null;
/*  526 */     Token newPackage = null;
/*  527 */     Token seedOutputFile = null;
/*  528 */     Token sourceFile = null;
/*  529 */     KeepModifier keepModifier = null;
/*  530 */     ClassSpecification classSpec = null;
/*      */     
/*      */     try
/*      */     {
/*  537 */       int alt11 = 41;
/*  538 */       switch (input.LA(1))
/*      */       {
/*      */       case 15: 
/*  541 */         alt11 = 1;
/*      */         
/*  543 */         break;
/*      */       
/*      */       case 19: 
/*  546 */         alt11 = 2;
/*      */         
/*  548 */         break;
/*      */       
/*      */       case 23: 
/*  551 */         alt11 = 3;
/*      */         
/*  553 */         break;
/*      */       
/*      */       case 25: 
/*  556 */         alt11 = 4;
/*      */         
/*  558 */         break;
/*      */       
/*      */       case 26: 
/*  561 */         alt11 = 5;
/*      */         
/*  563 */         break;
/*      */       
/*      */       case 27: 
/*  566 */         alt11 = 6;
/*      */         
/*  568 */         break;
/*      */       
/*      */       case 31: 
/*  571 */         alt11 = 7;
/*      */         
/*  573 */         break;
/*      */       
/*      */       case 34: 
/*  576 */         alt11 = 8;
/*      */         
/*  578 */         break;
/*      */       
/*      */       case 44: 
/*  581 */         alt11 = 9;
/*      */         
/*  583 */         break;
/*      */       
/*      */       case 45: 
/*  586 */         alt11 = 10;
/*      */         
/*  588 */         break;
/*      */       
/*      */       case 46: 
/*  591 */         alt11 = 11;
/*      */         
/*  593 */         break;
/*      */       
/*      */       case 47: 
/*  596 */         alt11 = 12;
/*      */         
/*  598 */         break;
/*      */       
/*      */       case 48: 
/*  601 */         alt11 = 13;
/*      */         
/*  603 */         break;
/*      */       
/*      */       case 51: 
/*  606 */         alt11 = 14;
/*      */         
/*  608 */         break;
/*      */       
/*      */       case 52: 
/*  611 */         alt11 = 15;
/*      */         
/*  613 */         break;
/*      */       
/*      */       case 53: 
/*  616 */         alt11 = 16;
/*      */         
/*  618 */         break;
/*      */       
/*      */       case 55: 
/*  621 */         alt11 = 17;
/*      */         
/*  623 */         break;
/*      */       
/*      */       case 60: 
/*  626 */         alt11 = 18;
/*      */         
/*  628 */         break;
/*      */       
/*      */       case 62: 
/*  631 */         alt11 = 19;
/*      */         
/*  633 */         break;
/*      */       
/*      */       case 63: 
/*  636 */         alt11 = 20;
/*      */         
/*  638 */         break;
/*      */       
/*      */       case 12: 
/*  641 */         alt11 = 21;
/*      */         
/*  643 */         break;
/*      */       
/*      */       case 13: 
/*  646 */         alt11 = 22;
/*      */         
/*  648 */         break;
/*      */       
/*      */       case 14: 
/*  651 */         alt11 = 23;
/*      */         
/*  653 */         break;
/*      */       
/*      */       case 16: 
/*  656 */         alt11 = 24;
/*      */         
/*  658 */         break;
/*      */       
/*      */       case 17: 
/*  661 */         alt11 = 25;
/*      */         
/*  663 */         break;
/*      */       
/*      */       case 20: 
/*  666 */         alt11 = 26;
/*      */         
/*  668 */         break;
/*      */       
/*      */       case 29: 
/*  671 */         alt11 = 27;
/*      */         
/*  673 */         break;
/*      */       
/*      */       case 30: 
/*  676 */         alt11 = 28;
/*      */         
/*  678 */         break;
/*      */       
/*      */       case 36: 
/*  681 */         alt11 = 29;
/*      */         
/*  683 */         break;
/*      */       
/*      */       case 37: 
/*  686 */         alt11 = 30;
/*      */         
/*  688 */         break;
/*      */       
/*      */       case 39: 
/*  691 */         alt11 = 31;
/*      */         
/*  693 */         break;
/*      */       
/*      */       case 41: 
/*  696 */         alt11 = 32;
/*      */         
/*  698 */         break;
/*      */       
/*      */       case 42: 
/*  701 */         alt11 = 33;
/*      */         
/*  703 */         break;
/*      */       
/*      */       case 43: 
/*  706 */         alt11 = 34;
/*      */         
/*  708 */         break;
/*      */       
/*      */       case 49: 
/*  711 */         alt11 = 35;
/*      */         
/*  713 */         break;
/*      */       
/*      */       case 50: 
/*  716 */         alt11 = 36;
/*      */         
/*  718 */         break;
/*      */       
/*      */       case 54: 
/*  721 */         alt11 = 37;
/*      */         
/*  723 */         break;
/*      */       
/*      */       case 56: 
/*  726 */         alt11 = 38;
/*      */         
/*  728 */         break;
/*      */       
/*      */       case 57: 
/*  731 */         alt11 = 39;
/*      */         
/*  733 */         break;
/*      */       
/*      */       case 58: 
/*  736 */         alt11 = 40;
/*      */         
/*  738 */         break;
/*      */       
/*      */       case 59: 
/*  741 */         alt11 = 41;
/*      */         
/*  743 */         break;
/*      */       case 18: case 21: case 22: case 24: case 28: case 32: case 33: case 35: case 38: case 40: case 61: default: 
/*  745 */         NoViableAltException nvae = new NoViableAltException("", 11, 0, input);
/*      */         
/*  747 */         throw nvae;
/*      */       }
/*  749 */       switch (alt11)
/*      */       {
/*      */       case 1: 
/*  753 */         match(input, 15, FOLLOW_15_in_unsupportedFlag321);
/*      */         
/*  755 */         break;
/*      */       
/*      */       case 2: 
/*  759 */         match(input, 19, FOLLOW_19_in_unsupportedFlag329);
/*  760 */         classObfuscationDictionary = (Token)match(input, 5, FOLLOW_NAME_in_unsupportedFlag333);
/*      */         
/*  762 */         break;
/*      */       
/*      */       case 3: 
/*  766 */         match(input, 23, FOLLOW_23_in_unsupportedFlag341);
/*      */         
/*  768 */         break;
/*      */       
/*      */       case 4: 
/*  772 */         match(input, 25, FOLLOW_25_in_unsupportedFlag349);
/*      */         
/*  774 */         break;
/*      */       
/*      */       case 5: 
/*  778 */         match(input, 26, FOLLOW_26_in_unsupportedFlag357);
/*      */         
/*  780 */         break;
/*      */       
/*      */       case 6: 
/*  784 */         match(input, 27, FOLLOW_27_in_unsupportedFlag365);
/*      */         
/*  786 */         break;
/*      */       
/*      */       case 7: 
/*  790 */         match(input, 31, FOLLOW_31_in_unsupportedFlag373);
/*      */         
/*  792 */         break;
/*      */       
/*      */       case 8: 
/*  796 */         match(input, 34, FOLLOW_34_in_unsupportedFlag381);
/*  797 */         pushFollow(FOLLOW_classpath_in_unsupportedFlag385);
/*  798 */         classpath();
/*  799 */         state._fsp -= 1;
/*      */         
/*  802 */         break;
/*      */       
/*      */       case 9: 
/*  806 */         match(input, 44, FOLLOW_44_in_unsupportedFlag393);
/*      */         
/*  808 */         break;
/*      */       
/*      */       case 10: 
/*  812 */         match(input, 45, FOLLOW_45_in_unsupportedFlag401);
/*  813 */         pushFollow(FOLLOW_classpath_in_unsupportedFlag405);
/*  814 */         classpath();
/*  815 */         state._fsp -= 1;
/*      */         
/*  818 */         break;
/*      */       
/*      */       case 11: 
/*  822 */         match(input, 46, FOLLOW_46_in_unsupportedFlag413);
/*      */         
/*  824 */         break;
/*      */       
/*      */       case 12: 
/*  828 */         match(input, 47, FOLLOW_47_in_unsupportedFlag421);
/*      */         
/*  830 */         break;
/*      */       
/*      */       case 13: 
/*  834 */         match(input, 48, FOLLOW_48_in_unsupportedFlag429);
/*  835 */         obfuscationDictionary = (Token)match(input, 5, FOLLOW_NAME_in_unsupportedFlag433);
/*      */         
/*  837 */         break;
/*      */       
/*      */       case 14: 
/*  841 */         match(input, 51, FOLLOW_51_in_unsupportedFlag441);
/*  842 */         pushFollow(FOLLOW_classpath_in_unsupportedFlag445);
/*  843 */         classpath();
/*  844 */         state._fsp -= 1;
/*      */         
/*  847 */         break;
/*      */       
/*      */       case 15: 
/*  851 */         match(input, 52, FOLLOW_52_in_unsupportedFlag453);
/*      */         
/*  853 */         break;
/*      */       
/*      */       case 16: 
/*  857 */         match(input, 53, FOLLOW_53_in_unsupportedFlag461);
/*  858 */         packageObfuscationDictionary = (Token)match(input, 5, FOLLOW_NAME_in_unsupportedFlag465);
/*      */         
/*  860 */         break;
/*      */       
/*      */       case 17: 
/*  864 */         match(input, 55, FOLLOW_55_in_unsupportedFlag473);
/*      */         
/*  866 */         int alt2 = 2;
/*  867 */         int LA2_0 = input.LA(1);
/*  868 */         if (LA2_0 == 5) {
/*  869 */           alt2 = 1;
/*      */         }
/*  871 */         switch (alt2)
/*      */         {
/*      */         case 1: 
/*  875 */           outputMapping = (Token)match(input, 5, FOLLOW_NAME_in_unsupportedFlag477);
/*      */         }
/*      */         
/*      */         
/*  882 */         break;
/*      */       
/*      */       case 18: 
/*  886 */         match(input, 60, FOLLOW_60_in_unsupportedFlag486);
/*      */         
/*  888 */         break;
/*      */       
/*      */       case 19: 
/*  892 */         match(input, 62, FOLLOW_62_in_unsupportedFlag494);
/*      */         
/*  894 */         break;
/*      */       
/*      */       case 20: 
/*  898 */         match(input, 63, FOLLOW_63_in_unsupportedFlag502);
/*      */         
/*  900 */         break;
/*      */       
/*      */       case 21: 
/*  907 */         match(input, 12, FOLLOW_12_in_unsupportedFlag511);
/*  908 */         List<FilterSpecification> filter = new ArrayList();
/*  909 */         pushFollow(FOLLOW_filter_in_unsupportedFlag515);
/*  910 */         filter(filter, GrammarActions.FilterSeparator.GENERAL);
/*  911 */         state._fsp -= 1;
/*      */         
/*  916 */         break;
/*      */       
/*      */       case 22: 
/*  923 */         match(input, 13, FOLLOW_13_in_unsupportedFlag526);
/*  924 */         List<FilterSpecification> file_filter = new ArrayList();
/*  925 */         pushFollow(FOLLOW_filter_in_unsupportedFlag530);
/*  926 */         filter(file_filter, GrammarActions.FilterSeparator.FILE);
/*  927 */         state._fsp -= 1;
/*      */         
/*  932 */         break;
/*      */       
/*      */       case 23: 
/*  939 */         match(input, 14, FOLLOW_14_in_unsupportedFlag542);
/*  940 */         List<FilterSpecification> file_filter = new ArrayList();
/*  941 */         pushFollow(FOLLOW_filter_in_unsupportedFlag546);
/*  942 */         filter(file_filter, GrammarActions.FilterSeparator.FILE);
/*  943 */         state._fsp -= 1;
/*      */         
/*  948 */         break;
/*      */       
/*      */       case 24: 
/*  955 */         match(input, 16, FOLLOW_16_in_unsupportedFlag558);
/*  956 */         mapping = (Token)match(input, 5, FOLLOW_NAME_in_unsupportedFlag562);
/*      */         
/*  960 */         break;
/*      */       
/*      */       case 25: 
/*  967 */         match(input, 17, FOLLOW_17_in_unsupportedFlag573);
/*  968 */         pushFollow(FOLLOW_classSpecification_in_unsupportedFlag575);
/*  969 */         classSpecification();
/*  970 */         state._fsp -= 1;
/*      */         
/*  975 */         break;
/*      */       
/*      */       case 26: 
/*  982 */         match(input, 20, FOLLOW_20_in_unsupportedFlag585);
/*  983 */         List<FilterSpecification> class_filter = new ArrayList();
/*  984 */         pushFollow(FOLLOW_filter_in_unsupportedFlag589);
/*  985 */         filter(class_filter, GrammarActions.FilterSeparator.CLASS);
/*  986 */         state._fsp -= 1;
/*      */         
/*  991 */         break;
/*      */       
/*      */       case 27: 
/*  998 */         match(input, 29, FOLLOW_29_in_unsupportedFlag600);
/*      */         
/* 1000 */         int alt3 = 2;
/* 1001 */         int LA3_0 = input.LA(1);
/* 1002 */         if (LA3_0 == 5) {
/* 1003 */           alt3 = 1;
/*      */         }
/* 1005 */         switch (alt3)
/*      */         {
/*      */         case 1: 
/* 1009 */           match(input, 5, FOLLOW_NAME_in_unsupportedFlag602);
/*      */         }
/*      */         
/*      */         
/* 1018 */         break;
/*      */       
/*      */       case 28: 
/* 1025 */         match(input, 30, FOLLOW_30_in_unsupportedFlag614);
/*      */         
/* 1027 */         int alt5 = 2;
/* 1028 */         int LA5_0 = input.LA(1);
/* 1029 */         if (LA5_0 == 72) {
/* 1030 */           alt5 = 1;
/*      */         }
/* 1032 */         switch (alt5)
/*      */         {
/*      */         case 1: 
/* 1036 */           match(input, 72, FOLLOW_72_in_unsupportedFlag617);
/*      */           
/* 1038 */           int alt4 = 2;
/* 1039 */           int LA4_0 = input.LA(1);
/* 1040 */           if (LA4_0 == 5) {
/* 1041 */             alt4 = 1;
/*      */           }
/* 1043 */           switch (alt4)
/*      */           {
/*      */           case 1: 
/* 1047 */             newPackage = (Token)match(input, 5, FOLLOW_NAME_in_unsupportedFlag621);
/*      */           }
/*      */           
/*      */           
/* 1053 */           match(input, 72, FOLLOW_72_in_unsupportedFlag624);
/*      */         }
/*      */         
/*      */         
/* 1062 */         break;
/*      */       
/*      */       case 29: 
/* 1069 */         match(input, 36, FOLLOW_36_in_unsupportedFlag637);
/* 1070 */         List<FilterSpecification> attribute_filter = new ArrayList();
/* 1071 */         pushFollow(FOLLOW_filter_in_unsupportedFlag641);
/* 1072 */         filter(attribute_filter, GrammarActions.FilterSeparator.ATTRIBUTE);
/* 1073 */         state._fsp -= 1;
/*      */         
/* 1078 */         break;
/*      */       
/*      */       case 30: 
/* 1085 */         match(input, 37, FOLLOW_37_in_unsupportedFlag653);
/* 1086 */         pushFollow(FOLLOW_keepOptionModifier_in_unsupportedFlag657);
/* 1087 */         keepModifier = keepOptionModifier();
/* 1088 */         state._fsp -= 1;
/*      */         
/* 1090 */         pushFollow(FOLLOW_classSpecification_in_unsupportedFlag661);
/* 1091 */         classSpec = classSpecification();
/* 1092 */         state._fsp -= 1;
/*      */         
/* 1097 */         break;
/*      */       
/*      */       case 31: 
/* 1104 */         match(input, 39, FOLLOW_39_in_unsupportedFlag673);
/* 1105 */         pushFollow(FOLLOW_classSpecification_in_unsupportedFlag677);
/* 1106 */         classSpec = classSpecification();
/* 1107 */         state._fsp -= 1;
/*      */         
/* 1112 */         break;
/*      */       
/*      */       case 32: 
/* 1119 */         match(input, 41, FOLLOW_41_in_unsupportedFlag689);
/* 1120 */         List<FilterSpecification> directory_filter = new ArrayList();
/* 1121 */         pushFollow(FOLLOW_filter_in_unsupportedFlag693);
/* 1122 */         filter(directory_filter, GrammarActions.FilterSeparator.FILE);
/* 1123 */         state._fsp -= 1;
/*      */         
/* 1128 */         break;
/*      */       
/*      */       case 33: 
/* 1135 */         match(input, 42, FOLLOW_42_in_unsupportedFlag704);
/* 1136 */         pushFollow(FOLLOW_classSpecification_in_unsupportedFlag708);
/* 1137 */         classSpec = classSpecification();
/* 1138 */         state._fsp -= 1;
/*      */         
/* 1143 */         break;
/*      */       
/*      */       case 34: 
/* 1150 */         match(input, 43, FOLLOW_43_in_unsupportedFlag719);
/* 1151 */         List<FilterSpecification> package_filter = new ArrayList();
/* 1152 */         pushFollow(FOLLOW_filter_in_unsupportedFlag723);
/* 1153 */         filter(package_filter, GrammarActions.FilterSeparator.GENERAL);
/* 1154 */         state._fsp -= 1;
/*      */         
/* 1159 */         break;
/*      */       
/*      */       case 35: 
/* 1166 */         match(input, 49, FOLLOW_49_in_unsupportedFlag735);
/* 1167 */         match(input, 5, FOLLOW_NAME_in_unsupportedFlag737);
/*      */         
/* 1171 */         break;
/*      */       
/*      */       case 36: 
/* 1178 */         match(input, 50, FOLLOW_50_in_unsupportedFlag748);
/* 1179 */         List<FilterSpecification> optimization_filter = new ArrayList();
/* 1180 */         pushFollow(FOLLOW_filter_in_unsupportedFlag752);
/* 1181 */         filter(optimization_filter, GrammarActions.FilterSeparator.GENERAL);
/* 1182 */         state._fsp -= 1;
/*      */         
/* 1187 */         break;
/*      */       
/*      */       case 37: 
/* 1194 */         match(input, 54, FOLLOW_54_in_unsupportedFlag763);
/*      */         
/* 1196 */         int alt6 = 2;
/* 1197 */         int LA6_0 = input.LA(1);
/* 1198 */         if (LA6_0 == 5) {
/* 1199 */           alt6 = 1;
/*      */         }
/* 1201 */         switch (alt6)
/*      */         {
/*      */         case 1: 
/* 1205 */           match(input, 5, FOLLOW_NAME_in_unsupportedFlag765);
/*      */         }
/*      */         
/*      */         
/* 1214 */         break;
/*      */       
/*      */       case 38: 
/* 1221 */         match(input, 56, FOLLOW_56_in_unsupportedFlag777);
/*      */         
/* 1223 */         int alt7 = 2;
/* 1224 */         int LA7_0 = input.LA(1);
/* 1225 */         if (LA7_0 == 5) {
/* 1226 */           alt7 = 1;
/*      */         }
/* 1228 */         switch (alt7)
/*      */         {
/*      */         case 1: 
/* 1232 */           seedOutputFile = (Token)match(input, 5, FOLLOW_NAME_in_unsupportedFlag781);
/*      */         }
/*      */         
/*      */         
/* 1241 */         break;
/*      */       
/*      */       case 39: 
/* 1248 */         match(input, 57, FOLLOW_57_in_unsupportedFlag793);
/* 1249 */         match(input, 5, FOLLOW_NAME_in_unsupportedFlag795);
/*      */         
/* 1253 */         break;
/*      */       
/*      */       case 40: 
/* 1260 */         match(input, 58, FOLLOW_58_in_unsupportedFlag806);
/*      */         
/* 1262 */         int alt8 = 2;
/* 1263 */         int LA8_0 = input.LA(1);
/* 1264 */         if (LA8_0 == 5) {
/* 1265 */           alt8 = 1;
/*      */         }
/* 1267 */         switch (alt8)
/*      */         {
/*      */         case 1: 
/* 1271 */           sourceFile = (Token)match(input, 5, FOLLOW_NAME_in_unsupportedFlag810);
/*      */         }
/*      */         
/*      */         
/* 1280 */         break;
/*      */       
/*      */       case 41: 
/* 1287 */         match(input, 59, FOLLOW_59_in_unsupportedFlag821);
/*      */         
/* 1289 */         int alt10 = 2;
/* 1290 */         int LA10_0 = input.LA(1);
/* 1291 */         if (LA10_0 == 72) {
/* 1292 */           alt10 = 1;
/*      */         }
/* 1294 */         switch (alt10)
/*      */         {
/*      */         case 1: 
/* 1298 */           match(input, 72, FOLLOW_72_in_unsupportedFlag824);
/*      */           
/* 1300 */           int alt9 = 2;
/* 1301 */           int LA9_0 = input.LA(1);
/* 1302 */           if (LA9_0 == 5) {
/* 1303 */             alt9 = 1;
/*      */           }
/* 1305 */           switch (alt9)
/*      */           {
/*      */           case 1: 
/* 1309 */             newPackage = (Token)match(input, 5, FOLLOW_NAME_in_unsupportedFlag828);
/*      */           }
/*      */           
/*      */           
/* 1315 */           match(input, 72, FOLLOW_72_in_unsupportedFlag831);
/*      */         }
/*      */         
/*      */         
/*      */         break;
/*      */       }
/*      */       
/*      */       
/* 1330 */       stop = input.LT(-1);
/*      */     }
/*      */     catch (RecognitionException re) {
/* 1333 */       re = 
/*      */       
/* 1339 */         re;reportError(re);recover(input, re); } finally {}
/* 1340 */     return retval;
/*      */   }
/*      */   
/*      */   public final void classpath()
/*      */     throws RecognitionException
/*      */   {
/*      */     try
/*      */     {
/* 1353 */       match(input, 5, FOLLOW_NAME_in_classpath855);
/*      */       
/* 1355 */       int alt12 = 2;
/* 1356 */       int LA12_0 = input.LA(1);
/* 1357 */       if ((LA12_0 >= 65) && (LA12_0 <= 66)) {
/* 1358 */         alt12 = 1;
/*      */       }
/* 1360 */       switch (alt12)
/*      */       {
/*      */       case 1: 
/* 1364 */         if ((input.LA(1) >= 65) && (input.LA(1) <= 66)) {
/* 1365 */           input.consume();
/* 1366 */           state.errorRecovery = false;
/*      */         }
/*      */         else {
/* 1369 */           MismatchedSetException mse = new MismatchedSetException(null, input);
/* 1370 */           throw mse;
/*      */         }
/* 1372 */         pushFollow(FOLLOW_classpath_in_classpath864);
/* 1373 */         classpath();
/* 1374 */         state._fsp -= 1;
/*      */       
/*      */       }
/*      */       
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/* 1384 */       re = 
/*      */       
/* 1390 */         re;reportError(re);recover(input, re);
/*      */     }
/*      */     finally {}
/*      */   }
/*      */   
/*      */   public final void filter(List<FilterSpecification> filter, GrammarActions.FilterSeparator separator)
/*      */     throws RecognitionException
/*      */   {
/*      */     try
/*      */     {
/* 1401 */       int alt13 = 2;
/* 1402 */       int LA13_0 = input.LA(1);
/* 1403 */       if ((LA13_0 >= 5) && (LA13_0 <= 6)) {
/* 1404 */         alt13 = 1;
/*      */       }
/* 1406 */       else if ((LA13_0 == -1) || ((LA13_0 >= 12) && (LA13_0 <= 64)) || (LA13_0 == 70)) {
/* 1407 */         alt13 = 2;
/*      */       }
/*      */       else
/*      */       {
/* 1411 */         NoViableAltException nvae = new NoViableAltException("", 13, 0, input);
/*      */         
/* 1413 */         throw nvae;
/*      */       }
/*      */       
/* 1416 */       switch (alt13)
/*      */       {
/*      */       case 1: 
/* 1420 */         pushFollow(FOLLOW_nonEmptyFilter_in_filter885);
/* 1421 */         nonEmptyFilter(filter, separator);
/* 1422 */         state._fsp -= 1;
/*      */         
/* 1425 */         break;
/*      */       
/*      */       case 2: 
/* 1429 */         GrammarActions.filter(filter, false, "**", separator);
/*      */       }
/*      */       
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/* 1435 */       re = 
/*      */       
/* 1441 */         re;reportError(re);recover(input, re);
/*      */     }
/*      */     finally {}
/*      */   }
/*      */   
/*      */   public final void nonEmptyFilter(List<FilterSpecification> filter, GrammarActions.FilterSeparator separator)
/*      */     throws RecognitionException
/*      */   {
/* 1450 */     Token NAME1 = null;
/*      */     
/* 1453 */     boolean negator = false;
/*      */     
/*      */     try
/*      */     {
/* 1463 */       int alt14 = 2;
/* 1464 */       int LA14_0 = input.LA(1);
/* 1465 */       if (LA14_0 == 6) {
/* 1466 */         alt14 = 1;
/*      */       }
/* 1468 */       switch (alt14)
/*      */       {
/*      */       case 1: 
/* 1472 */         match(input, 6, FOLLOW_NEGATOR_in_nonEmptyFilter919);
/* 1473 */         negator = true;
/*      */       }
/*      */       
/*      */       
/* 1479 */       NAME1 = (Token)match(input, 5, FOLLOW_NAME_in_nonEmptyFilter925);
/* 1480 */       GrammarActions.filter(filter, negator, NAME1 != null ? NAME1.getText() : null, separator);
/*      */       
/* 1482 */       int alt15 = 2;
/* 1483 */       int LA15_0 = input.LA(1);
/* 1484 */       if (LA15_0 == 11) {
/* 1485 */         alt15 = 1;
/*      */       }
/* 1487 */       switch (alt15)
/*      */       {
/*      */       case 1: 
/* 1491 */         match(input, 11, FOLLOW_11_in_nonEmptyFilter930);
/* 1492 */         pushFollow(FOLLOW_nonEmptyFilter_in_nonEmptyFilter932);
/* 1493 */         nonEmptyFilter(filter, separator);
/* 1494 */         state._fsp -= 1;
/*      */       
/*      */       }
/*      */       
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/* 1506 */       re = 
/*      */       
/* 1512 */         re;reportError(re);recover(input, re);
/*      */     }
/*      */     finally {}
/*      */   }
/*      */   
/*      */   public final ClassSpecification classSpecification()
/*      */     throws RecognitionException
/*      */   {
/* 1521 */     ClassSpecification classSpec = null;
/*      */     
/* 1524 */     ClassTypeSpecification cType = null;
/* 1525 */     InheritanceSpecification inheritanceSpec = null;
/* 1526 */     List<NameSpecification> classNames2 = null;
/* 1527 */     AnnotationSpecification annotation3 = null;
/*      */     
/* 1530 */     ModifierSpecification modifier = new ModifierSpecification();
/* 1531 */     boolean hasNameNegator = false;
/*      */     
/*      */     try
/*      */     {
/* 1538 */       int alt16 = 2;
/* 1539 */       int LA16_0 = input.LA(1);
/* 1540 */       if (LA16_0 == 70) {
/* 1541 */         int LA16_1 = input.LA(2);
/* 1542 */         if ((LA16_1 >= 5) && (LA16_1 <= 6)) {
/* 1543 */           alt16 = 1;
/*      */         }
/*      */       }
/* 1546 */       switch (alt16)
/*      */       {
/*      */       case 1: 
/* 1550 */         pushFollow(FOLLOW_annotation_in_classSpecification962);
/* 1551 */         annotation3 = annotation();
/* 1552 */         state._fsp -= 1;
/*      */       }
/*      */       
/*      */       
/* 1559 */       pushFollow(FOLLOW_classModifierAndType_in_classSpecification970);
/* 1560 */       cType = classModifierAndType(modifier);
/* 1561 */       state._fsp -= 1;
/*      */       
/* 1563 */       pushFollow(FOLLOW_classNames_in_classSpecification975);
/* 1564 */       classNames2 = classNames();
/* 1565 */       state._fsp -= 1;
/*      */       
/* 1567 */       classSpec = GrammarActions.classSpec(classNames2, cType, annotation3, modifier);
/*      */       
/* 1569 */       int alt17 = 2;
/* 1570 */       int LA17_0 = input.LA(1);
/* 1571 */       if ((LA17_0 == 80) || (LA17_0 == 82)) {
/* 1572 */         alt17 = 1;
/*      */       }
/* 1574 */       switch (alt17)
/*      */       {
/*      */       case 1: 
/* 1578 */         pushFollow(FOLLOW_inheritance_in_classSpecification984);
/* 1579 */         inheritanceSpec = inheritance();
/* 1580 */         state._fsp -= 1;
/*      */         
/* 1582 */         classSpec.setInheritance(inheritanceSpec);
/*      */       }
/*      */       
/*      */       
/* 1589 */       int alt18 = 2;
/* 1590 */       int LA18_0 = input.LA(1);
/* 1591 */       if (LA18_0 == 96) {
/* 1592 */         alt18 = 1;
/*      */       }
/* 1594 */       switch (alt18)
/*      */       {
/*      */       case 1: 
/* 1598 */         pushFollow(FOLLOW_members_in_classSpecification992);
/* 1599 */         members(classSpec);
/* 1600 */         state._fsp -= 1;
/*      */       
/*      */       }
/*      */       
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/* 1610 */       re = 
/*      */       
/* 1616 */         re;reportError(re);recover(input, re); } finally {}
/* 1617 */     return classSpec;
/*      */   }
/*      */   
/*      */   public final List<NameSpecification> classNames()
/*      */     throws RecognitionException
/*      */   {
/* 1626 */     List<NameSpecification> names = null;
/*      */     
/* 1629 */     NameSpecification firstName = null;
/* 1630 */     NameSpecification otherName = null;
/*      */     
/* 1633 */     names = new ArrayList();
/*      */     
/*      */     try
/*      */     {
/* 1639 */       pushFollow(FOLLOW_className_in_classNames1021);
/* 1640 */       firstName = className();
/* 1641 */       state._fsp -= 1;
/*      */       
/* 1643 */       names.add(firstName);
/*      */       
/*      */       for (;;)
/*      */       {
/* 1647 */         int alt19 = 2;
/* 1648 */         int LA19_0 = input.LA(1);
/* 1649 */         if (LA19_0 == 11) {
/* 1650 */           alt19 = 1;
/*      */         }
/*      */         
/* 1653 */         switch (alt19)
/*      */         {
/*      */         case 1: 
/* 1657 */           match(input, 11, FOLLOW_11_in_classNames1028);
/* 1658 */           pushFollow(FOLLOW_className_in_classNames1032);
/* 1659 */           otherName = className();
/* 1660 */           state._fsp -= 1;
/*      */           
/* 1662 */           names.add(otherName);
/*      */           
/* 1664 */           break;
/*      */         default: 
/*      */           break label148;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/*      */       label148:
/* 1674 */       re = 
/*      */       
/* 1680 */         re;
/* 1675 */       reportError(re);
/* 1676 */       recover(input, re);
/*      */     }
/*      */     finally {}
/*      */     
/* 1681 */     return names;
/*      */   }
/*      */   
/*      */   public final NameSpecification className()
/*      */     throws RecognitionException
/*      */   {
/* 1690 */     NameSpecification nameSpec = null;
/*      */     
/* 1693 */     Token NAME4 = null;
/*      */     
/* 1696 */     boolean hasNameNegator = false;
/*      */     
/*      */     try
/*      */     {
/* 1703 */       int alt20 = 2;
/* 1704 */       int LA20_0 = input.LA(1);
/* 1705 */       if (LA20_0 == 6) {
/* 1706 */         alt20 = 1;
/*      */       }
/* 1708 */       switch (alt20)
/*      */       {
/*      */       case 1: 
/* 1712 */         match(input, 6, FOLLOW_NEGATOR_in_className1061);
/* 1713 */         hasNameNegator = true;
/*      */       }
/*      */       
/*      */       
/* 1719 */       NAME4 = (Token)match(input, 5, FOLLOW_NAME_in_className1069);
/* 1720 */       nameSpec = GrammarActions.className(NAME4 != null ? NAME4.getText() : null, hasNameNegator);
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/* 1724 */       re = 
/*      */       
/* 1730 */         re;reportError(re);recover(input, re); } finally {}
/* 1731 */     return nameSpec;
/*      */   }
/*      */   
/*      */   public final ClassTypeSpecification classModifierAndType(ModifierSpecification modifier)
/*      */     throws RecognitionException
/*      */   {
/* 1740 */     ClassTypeSpecification cType = null;
/*      */     
/* 1743 */     ClassTypeSpecification cmat = null;
/* 1744 */     int classType5 = 0;
/*      */     
/* 1747 */     boolean hasNegator = false;
/*      */     
/*      */     try
/*      */     {
/* 1754 */       int alt21 = 2;
/* 1755 */       int LA21_0 = input.LA(1);
/* 1756 */       if (LA21_0 == 6) {
/* 1757 */         alt21 = 1;
/*      */       }
/* 1759 */       switch (alt21)
/*      */       {
/*      */       case 1: 
/* 1763 */         match(input, 6, FOLLOW_NEGATOR_in_classModifierAndType1096);
/* 1764 */         hasNegator = true;
/*      */       }
/*      */       
/*      */       
/* 1771 */       int alt22 = 4;
/* 1772 */       switch (input.LA(1))
/*      */       {
/*      */       case 88: 
/* 1775 */         alt22 = 1;
/*      */         
/* 1777 */         break;
/*      */       
/*      */       case 73: 
/* 1780 */         alt22 = 2;
/*      */         
/* 1782 */         break;
/*      */       
/*      */       case 81: 
/* 1785 */         alt22 = 3;
/*      */         
/* 1787 */         break;
/*      */       
/*      */       case 70: 
/*      */       case 78: 
/*      */       case 79: 
/*      */       case 84: 
/* 1793 */         alt22 = 4;
/*      */         
/* 1795 */         break;
/*      */       case 71: case 72: case 74: case 75: case 76: case 77: case 80: case 82: case 83: case 85: case 86: case 87: default: 
/* 1797 */         NoViableAltException nvae = new NoViableAltException("", 22, 0, input);
/*      */         
/* 1799 */         throw nvae;
/*      */       }
/* 1801 */       switch (alt22)
/*      */       {
/*      */       case 1: 
/* 1805 */         match(input, 88, FOLLOW_88_in_classModifierAndType1108);
/* 1806 */         GrammarActions.addAccessFlag(modifier, ModifierSpecification.AccessFlag.PUBLIC, hasNegator);
/* 1807 */         pushFollow(FOLLOW_classModifierAndType_in_classModifierAndType1114);
/* 1808 */         cmat = classModifierAndType(modifier);
/* 1809 */         state._fsp -= 1;
/*      */         
/* 1811 */         cType = cmat;
/*      */         
/* 1813 */         break;
/*      */       
/*      */       case 2: 
/* 1817 */         match(input, 73, FOLLOW_73_in_classModifierAndType1123);
/* 1818 */         GrammarActions.addModifier(modifier, ModifierSpecification.Modifier.ABSTRACT, hasNegator);
/* 1819 */         pushFollow(FOLLOW_classModifierAndType_in_classModifierAndType1129);
/* 1820 */         cmat = classModifierAndType(modifier);
/* 1821 */         state._fsp -= 1;
/*      */         
/* 1823 */         cType = cmat;
/*      */         
/* 1825 */         break;
/*      */       
/*      */       case 3: 
/* 1829 */         match(input, 81, FOLLOW_81_in_classModifierAndType1138);
/* 1830 */         GrammarActions.addModifier(modifier, ModifierSpecification.Modifier.FINAL, hasNegator);
/* 1831 */         pushFollow(FOLLOW_classModifierAndType_in_classModifierAndType1144);
/* 1832 */         cmat = classModifierAndType(modifier);
/* 1833 */         state._fsp -= 1;
/*      */         
/* 1835 */         cType = cmat;
/*      */         
/* 1837 */         break;
/*      */       
/*      */       case 4: 
/* 1841 */         pushFollow(FOLLOW_classType_in_classModifierAndType1153);
/* 1842 */         classType5 = classType();
/* 1843 */         state._fsp -= 1;
/*      */         
/* 1845 */         cType = GrammarActions.classType(classType5, hasNegator);
/*      */       
/*      */       }
/*      */       
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/* 1854 */       re = 
/*      */       
/* 1860 */         re;reportError(re);recover(input, re); } finally {}
/* 1861 */     return cType;
/*      */   }
/*      */   
/*      */   public final int classType()
/*      */     throws RecognitionException
/*      */   {
/* 1870 */     int type = 0;
/*      */     
/* 1874 */     type = 0;
/*      */     
/*      */     try
/*      */     {
/* 1881 */       int alt23 = 2;
/* 1882 */       int LA23_0 = input.LA(1);
/* 1883 */       if (LA23_0 == 70) {
/* 1884 */         alt23 = 1;
/*      */       }
/* 1886 */       switch (alt23)
/*      */       {
/*      */       case 1: 
/* 1890 */         match(input, 70, FOLLOW_70_in_classType1186);
/* 1891 */         type |= 0x2000;
/*      */       }
/*      */       
/*      */       
/* 1898 */       int alt24 = 3;
/* 1899 */       switch (input.LA(1))
/*      */       {
/*      */       case 84: 
/* 1902 */         alt24 = 1;
/*      */         
/* 1904 */         break;
/*      */       
/*      */       case 79: 
/* 1907 */         alt24 = 2;
/*      */         
/* 1909 */         break;
/*      */       
/*      */       case 78: 
/* 1912 */         alt24 = 3;
/*      */         
/* 1914 */         break;
/*      */       default: 
/* 1916 */         NoViableAltException nvae = new NoViableAltException("", 24, 0, input);
/*      */         
/* 1918 */         throw nvae;
/*      */       }
/* 1920 */       switch (alt24)
/*      */       {
/*      */       case 1: 
/* 1924 */         match(input, 84, FOLLOW_84_in_classType1195);
/* 1925 */         type |= 0x200;
/*      */         
/* 1927 */         break;
/*      */       
/*      */       case 2: 
/* 1931 */         match(input, 79, FOLLOW_79_in_classType1203);
/* 1932 */         type |= 0x4000;
/*      */         
/* 1934 */         break;
/*      */       
/*      */       case 3: 
/* 1938 */         match(input, 78, FOLLOW_78_in_classType1211);
/*      */       
/*      */       }
/*      */       
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/* 1947 */       re = 
/*      */       
/* 1953 */         re;reportError(re);recover(input, re); } finally {}
/* 1954 */     return type;
/*      */   }
/*      */   
/*      */   public final void members(ClassSpecification classSpec)
/*      */     throws RecognitionException
/*      */   {
/*      */     try
/*      */     {
/* 1967 */       match(input, 96, FOLLOW_96_in_members1234);
/*      */       
/*      */       for (;;)
/*      */       {
/* 1971 */         int alt25 = 2;
/* 1972 */         int LA25_0 = input.LA(1);
/* 1973 */         if (((LA25_0 >= 5) && (LA25_0 <= 6)) || (LA25_0 == 8) || ((LA25_0 >= 67) && (LA25_0 <= 70)) || (LA25_0 == 73) || (LA25_0 == 77) || (LA25_0 == 81) || ((LA25_0 >= 85) && (LA25_0 <= 95))) {
/* 1974 */           alt25 = 1;
/*      */         }
/*      */         
/* 1977 */         switch (alt25)
/*      */         {
/*      */         case 1: 
/* 1981 */           pushFollow(FOLLOW_member_in_members1240);
/* 1982 */           member(classSpec);
/* 1983 */           state._fsp -= 1;
/*      */           
/* 1986 */           break;
/*      */         default: 
/*      */           break label142;
/*      */         }
/*      */         
/*      */       }
/*      */       label142:
/* 1993 */       match(input, 97, FOLLOW_97_in_members1246);
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/* 1997 */       re = 
/*      */       
/* 2003 */         re;reportError(re);recover(input, re);
/*      */     }
/*      */     finally {}
/*      */   }
/*      */   
/*      */   public final void member(ClassSpecification classSpec)
/*      */     throws RecognitionException
/*      */   {
/* 2012 */     Token name = null;
/* 2013 */     String typeSig = null;
/* 2014 */     String signature = null;
/* 2015 */     AnnotationSpecification annotation6 = null;
/* 2016 */     ModifierSpecification modifiers7 = null;
/*      */     
/*      */     try
/*      */     {
/* 2023 */       int alt26 = 2;
/* 2024 */       int LA26_0 = input.LA(1);
/* 2025 */       if (LA26_0 == 70) {
/* 2026 */         alt26 = 1;
/*      */       }
/* 2028 */       switch (alt26)
/*      */       {
/*      */       case 1: 
/* 2032 */         pushFollow(FOLLOW_annotation_in_member1267);
/* 2033 */         annotation6 = annotation();
/* 2034 */         state._fsp -= 1;
/*      */       }
/*      */       
/*      */       
/* 2041 */       pushFollow(FOLLOW_modifiers_in_member1270);
/* 2042 */       modifiers7 = modifiers();
/* 2043 */       state._fsp -= 1;
/*      */       
/* 2046 */       int alt31 = 3;
/* 2047 */       switch (input.LA(1))
/*      */       {
/*      */       case 5: 
/* 2050 */         switch (input.LA(2))
/*      */         {
/*      */         case 71: 
/* 2053 */           switch (input.LA(3))
/*      */           {
/*      */           case 5: 
/*      */           case 68: 
/* 2057 */             alt31 = 1;
/*      */             
/* 2059 */             break;
/*      */           
/*      */           case 71: 
/* 2062 */             alt31 = 1;
/*      */             
/* 2064 */             break;
/*      */           
/*      */           case 69: 
/* 2067 */             alt31 = 2;
/*      */             
/* 2069 */             break;
/*      */           
/*      */           case 67: 
/* 2072 */             alt31 = 3;
/*      */             
/* 2074 */             break;
/*      */           default: 
/* 2076 */             int nvaeMark = input.mark();
/*      */             try {
/* 2078 */               for (int nvaeConsume = 0; nvaeConsume < 2; nvaeConsume++) {
/* 2079 */                 input.consume();
/*      */               }
/* 2081 */               NoViableAltException nvae = new NoViableAltException("", 31, 6, input);
/*      */               
/* 2083 */               throw nvae;
/*      */             } finally {
/* 2085 */               input.rewind(nvaeMark);
/*      */             }
/*      */           }
/*      */           
/* 2089 */           break;
/*      */         
/*      */         case 5: 
/*      */         case 9: 
/*      */         case 66: 
/*      */         case 68: 
/* 2095 */           alt31 = 1;
/*      */           
/* 2097 */           break;
/*      */         
/*      */         case 69: 
/* 2100 */           alt31 = 2;
/*      */           
/* 2102 */           break;
/*      */         
/*      */         case 67: 
/* 2105 */           alt31 = 3;
/*      */           
/* 2107 */           break;
/*      */         default: 
/* 2109 */           int nvaeMark = input.mark();
/*      */           try {
/* 2111 */             input.consume();
/* 2112 */             NoViableAltException nvae = new NoViableAltException("", 31, 1, input);
/*      */             
/* 2114 */             throw nvae;
/*      */           } finally {
/* 2116 */             input.rewind(nvaeMark);
/*      */           }
/*      */         }
/*      */         
/* 2120 */         break;
/*      */       
/*      */       case 8: 
/* 2123 */         switch (input.LA(2))
/*      */         {
/*      */         case 71: 
/* 2126 */           switch (input.LA(3))
/*      */           {
/*      */           case 5: 
/*      */           case 68: 
/* 2130 */             alt31 = 1;
/*      */             
/* 2132 */             break;
/*      */           
/*      */           case 71: 
/* 2135 */             alt31 = 1;
/*      */             
/* 2137 */             break;
/*      */           
/*      */           case 69: 
/* 2140 */             alt31 = 2;
/*      */             
/* 2142 */             break;
/*      */           
/*      */           case 67: 
/* 2145 */             alt31 = 3;
/*      */             
/* 2147 */             break;
/*      */           default: 
/* 2149 */             int nvaeMark = input.mark();
/*      */             try {
/* 2151 */               for (int nvaeConsume = 0; nvaeConsume < 2; nvaeConsume++) {
/* 2152 */                 input.consume();
/*      */               }
/* 2154 */               NoViableAltException nvae = new NoViableAltException("", 31, 12, input);
/*      */               
/* 2156 */               throw nvae;
/*      */             } finally {
/* 2158 */               input.rewind(nvaeMark);
/*      */             }
/*      */           }
/*      */           
/* 2162 */           break;
/*      */         
/*      */         case 5: 
/*      */         case 68: 
/* 2166 */           alt31 = 1;
/*      */           
/* 2168 */           break;
/*      */         
/*      */         case 69: 
/* 2171 */           alt31 = 2;
/*      */           
/* 2173 */           break;
/*      */         
/*      */         case 67: 
/* 2176 */           alt31 = 3;
/*      */           
/* 2178 */           break;
/*      */         default: 
/* 2180 */           int nvaeMark = input.mark();
/*      */           try {
/* 2182 */             input.consume();
/* 2183 */             NoViableAltException nvae = new NoViableAltException("", 31, 2, input);
/*      */             
/* 2185 */             throw nvae;
/*      */           } finally {
/* 2187 */             input.rewind(nvaeMark);
/*      */           }
/*      */         }
/*      */         
/* 2191 */         break;
/*      */       
/*      */       case 68: 
/* 2194 */         alt31 = 1;
/*      */         
/* 2196 */         break;
/*      */       
/*      */       case 69: 
/* 2199 */         alt31 = 2;
/*      */         
/* 2201 */         break;
/*      */       
/*      */       case 67: 
/* 2204 */         alt31 = 3;
/*      */         
/* 2206 */         break;
/*      */       default: 
/* 2208 */         NoViableAltException nvae = new NoViableAltException("", 31, 0, input);
/*      */         
/* 2210 */         throw nvae;
/*      */       }
/* 2212 */       switch (alt31)
/*      */       {
/*      */       case 1: 
/* 2217 */         int alt27 = 2;
/* 2218 */         int LA27_0 = input.LA(1);
/* 2219 */         if (LA27_0 == 5) {
/* 2220 */           int LA27_1 = input.LA(2);
/* 2221 */           if ((LA27_1 == 5) || (LA27_1 == 68) || (LA27_1 == 71)) {
/* 2222 */             alt27 = 1;
/*      */           }
/*      */         }
/* 2225 */         else if (LA27_0 == 8) {
/* 2226 */           alt27 = 1;
/*      */         }
/* 2228 */         switch (alt27)
/*      */         {
/*      */         case 1: 
/* 2232 */           pushFollow(FOLLOW_type_in_member1287);
/* 2233 */           typeSig = type();
/* 2234 */           state._fsp -= 1;
/*      */         }
/*      */         
/*      */         
/* 2241 */         name = input.LT(1);
/* 2242 */         if ((input.LA(1) == 5) || (input.LA(1) == 68)) {
/* 2243 */           input.consume();
/* 2244 */           state.errorRecovery = false;
/*      */         }
/*      */         else {
/* 2247 */           MismatchedSetException mse = new MismatchedSetException(null, input);
/* 2248 */           throw mse;
/*      */         }
/*      */         
/* 2251 */         int alt28 = 2;
/* 2252 */         int LA28_0 = input.LA(1);
/* 2253 */         if (LA28_0 == 9) {
/* 2254 */           alt28 = 1;
/*      */         }
/* 2256 */         else if (LA28_0 == 66) {
/* 2257 */           alt28 = 2;
/*      */         }
/*      */         else
/*      */         {
/* 2261 */           NoViableAltException nvae = new NoViableAltException("", 28, 0, input);
/*      */           
/* 2263 */           throw nvae;
/*      */         }
/*      */         
/* 2266 */         switch (alt28)
/*      */         {
/*      */         case 1: 
/* 2270 */           pushFollow(FOLLOW_arguments_in_member1302);
/* 2271 */           signature = arguments();
/* 2272 */           state._fsp -= 1;
/*      */           
/* 2274 */           GrammarActions.method(classSpec, annotation6, typeSig, name != null ? name.getText() : null, signature, modifiers7);
/*      */           
/* 2276 */           break;
/*      */         
/*      */         case 2: 
/* 2280 */           GrammarActions.fieldOrAnyMember(classSpec, annotation6, typeSig, name != null ? name.getText() : null, modifiers7);
/*      */         }
/*      */         
/*      */         
/* 2287 */         break;
/*      */       
/*      */       case 2: 
/* 2292 */         int alt29 = 2;
/* 2293 */         int LA29_0 = input.LA(1);
/* 2294 */         if ((LA29_0 == 5) || (LA29_0 == 8)) {
/* 2295 */           alt29 = 1;
/*      */         }
/* 2297 */         switch (alt29)
/*      */         {
/*      */         case 1: 
/* 2301 */           pushFollow(FOLLOW_type_in_member1337);
/* 2302 */           type();
/* 2303 */           state._fsp -= 1;
/*      */         }
/*      */         
/*      */         
/* 2310 */         match(input, 69, FOLLOW_69_in_member1340);
/* 2311 */         GrammarActions.method(classSpec, annotation6, 
/* 2312 */           GrammarActions.getSignature("***", 0), "*", "\\(" + GrammarActions.getSignature("...", 0) + "\\)", modifiers7);
/*      */         
/* 2315 */         break;
/*      */       
/*      */       case 3: 
/* 2320 */         int alt30 = 2;
/* 2321 */         int LA30_0 = input.LA(1);
/* 2322 */         if ((LA30_0 == 5) || (LA30_0 == 8)) {
/* 2323 */           alt30 = 1;
/*      */         }
/* 2325 */         switch (alt30)
/*      */         {
/*      */         case 1: 
/* 2329 */           pushFollow(FOLLOW_type_in_member1352);
/* 2330 */           type();
/* 2331 */           state._fsp -= 1;
/*      */         }
/*      */         
/*      */         
/* 2338 */         match(input, 67, FOLLOW_67_in_member1355);
/* 2339 */         GrammarActions.field(classSpec, annotation6, null, "*", modifiers7);
/*      */       }
/*      */       
/*      */       
/* 2345 */       match(input, 66, FOLLOW_66_in_member1365);
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/* 2349 */       re = 
/*      */       
/* 2355 */         re;reportError(re);recover(input, re);
/*      */     }
/*      */     finally {}
/*      */   }
/*      */   
/*      */   public final AnnotationSpecification annotation()
/*      */     throws RecognitionException
/*      */   {
/* 2364 */     AnnotationSpecification annotSpec = null;
/*      */     
/* 2367 */     Token NAME8 = null;
/*      */     
/* 2370 */     boolean hasNameNegator = false;
/*      */     
/*      */     try
/*      */     {
/* 2376 */       match(input, 70, FOLLOW_70_in_annotation1389);
/*      */       
/* 2378 */       int alt32 = 2;
/* 2379 */       int LA32_0 = input.LA(1);
/* 2380 */       if (LA32_0 == 6) {
/* 2381 */         alt32 = 1;
/*      */       }
/* 2383 */       switch (alt32)
/*      */       {
/*      */       case 1: 
/* 2387 */         match(input, 6, FOLLOW_NEGATOR_in_annotation1392);
/* 2388 */         hasNameNegator = true;
/*      */       }
/*      */       
/*      */       
/* 2394 */       NAME8 = (Token)match(input, 5, FOLLOW_NAME_in_annotation1398);
/* 2395 */       annotSpec = GrammarActions.annotation(NAME8 != null ? NAME8.getText() : null, hasNameNegator);
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/* 2399 */       re = 
/*      */       
/* 2405 */         re;reportError(re);recover(input, re); } finally {}
/* 2406 */     return annotSpec;
/*      */   }
/*      */   
/*      */   public final ModifierSpecification modifiers()
/*      */     throws RecognitionException
/*      */   {
/* 2415 */     ModifierSpecification modifiers = null;
/*      */     
/* 2419 */     modifiers = new ModifierSpecification();
/*      */     
/*      */     try
/*      */     {
/*      */       for (;;)
/*      */       {
/* 2428 */         int alt33 = 2;
/* 2429 */         int LA33_0 = input.LA(1);
/* 2430 */         if ((LA33_0 == 6) || (LA33_0 == 73) || (LA33_0 == 77) || (LA33_0 == 81) || ((LA33_0 >= 85) && (LA33_0 <= 95))) {
/* 2431 */           alt33 = 1;
/*      */         }
/*      */         
/* 2434 */         switch (alt33)
/*      */         {
/*      */         case 1: 
/* 2438 */           pushFollow(FOLLOW_modifier_in_modifiers1422);
/* 2439 */           modifier(modifiers);
/* 2440 */           state._fsp -= 1;
/*      */           
/* 2443 */           break;
/*      */         default: 
/*      */           break label114;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/*      */       label114:
/* 2453 */       re = 
/*      */       
/* 2459 */         re;
/* 2454 */       reportError(re);
/* 2455 */       recover(input, re);
/*      */     }
/*      */     finally {}
/*      */     
/* 2460 */     return modifiers;
/*      */   }
/*      */   
/*      */   public final void modifier(ModifierSpecification modifiers)
/*      */     throws RecognitionException
/*      */   {
/* 2470 */     boolean hasNegator = false;
/*      */     
/*      */     try
/*      */     {
/* 2477 */       int alt34 = 2;
/* 2478 */       int LA34_0 = input.LA(1);
/* 2479 */       if (LA34_0 == 6) {
/* 2480 */         alt34 = 1;
/*      */       }
/* 2482 */       switch (alt34)
/*      */       {
/*      */       case 1: 
/* 2486 */         match(input, 6, FOLLOW_NEGATOR_in_modifier1448);
/* 2487 */         hasNegator = true;
/*      */       }
/*      */       
/*      */       
/* 2494 */       int alt35 = 14;
/* 2495 */       switch (input.LA(1))
/*      */       {
/*      */       case 88: 
/* 2498 */         alt35 = 1;
/*      */         
/* 2500 */         break;
/*      */       
/*      */       case 86: 
/* 2503 */         alt35 = 2;
/*      */         
/* 2505 */         break;
/*      */       
/*      */       case 87: 
/* 2508 */         alt35 = 3;
/*      */         
/* 2510 */         break;
/*      */       
/*      */       case 89: 
/* 2513 */         alt35 = 4;
/*      */         
/* 2515 */         break;
/*      */       
/*      */       case 91: 
/* 2518 */         alt35 = 5;
/*      */         
/* 2520 */         break;
/*      */       
/*      */       case 95: 
/* 2523 */         alt35 = 6;
/*      */         
/* 2525 */         break;
/*      */       
/*      */       case 85: 
/* 2528 */         alt35 = 7;
/*      */         
/* 2530 */         break;
/*      */       
/*      */       case 73: 
/* 2533 */         alt35 = 8;
/*      */         
/* 2535 */         break;
/*      */       
/*      */       case 90: 
/* 2538 */         alt35 = 9;
/*      */         
/* 2540 */         break;
/*      */       
/*      */       case 81: 
/* 2543 */         alt35 = 10;
/*      */         
/* 2545 */         break;
/*      */       
/*      */       case 93: 
/* 2548 */         alt35 = 11;
/*      */         
/* 2550 */         break;
/*      */       
/*      */       case 92: 
/* 2553 */         alt35 = 12;
/*      */         
/* 2555 */         break;
/*      */       
/*      */       case 77: 
/* 2558 */         alt35 = 13;
/*      */         
/* 2560 */         break;
/*      */       
/*      */       case 94: 
/* 2563 */         alt35 = 14;
/*      */         
/* 2565 */         break;
/*      */       case 74: case 75: case 76: case 78: case 79: case 80: case 82: case 83: case 84: default: 
/* 2567 */         NoViableAltException nvae = new NoViableAltException("", 35, 0, input);
/*      */         
/* 2569 */         throw nvae;
/*      */       }
/* 2571 */       switch (alt35)
/*      */       {
/*      */       case 1: 
/* 2575 */         match(input, 88, FOLLOW_88_in_modifier1462);
/* 2576 */         modifiers.addAccessFlag(ModifierSpecification.AccessFlag.PUBLIC, hasNegator);
/*      */         
/* 2578 */         break;
/*      */       
/*      */       case 2: 
/* 2582 */         match(input, 86, FOLLOW_86_in_modifier1472);
/* 2583 */         modifiers.addAccessFlag(ModifierSpecification.AccessFlag.PRIVATE, hasNegator);
/*      */         
/* 2585 */         break;
/*      */       
/*      */       case 3: 
/* 2589 */         match(input, 87, FOLLOW_87_in_modifier1482);
/* 2590 */         modifiers.addAccessFlag(ModifierSpecification.AccessFlag.PROTECTED, hasNegator);
/*      */         
/* 2592 */         break;
/*      */       
/*      */       case 4: 
/* 2596 */         match(input, 89, FOLLOW_89_in_modifier1492);
/* 2597 */         modifiers.addModifier(ModifierSpecification.Modifier.STATIC, hasNegator);
/*      */         
/* 2599 */         break;
/*      */       
/*      */       case 5: 
/* 2603 */         match(input, 91, FOLLOW_91_in_modifier1502);
/* 2604 */         modifiers.addModifier(ModifierSpecification.Modifier.SYNCHRONIZED, hasNegator);
/*      */         
/* 2606 */         break;
/*      */       
/*      */       case 6: 
/* 2610 */         match(input, 95, FOLLOW_95_in_modifier1512);
/* 2611 */         modifiers.addModifier(ModifierSpecification.Modifier.VOLATILE, hasNegator);
/*      */         
/* 2613 */         break;
/*      */       
/*      */       case 7: 
/* 2617 */         match(input, 85, FOLLOW_85_in_modifier1522);
/* 2618 */         modifiers.addModifier(ModifierSpecification.Modifier.NATIVE, hasNegator);
/*      */         
/* 2620 */         break;
/*      */       
/*      */       case 8: 
/* 2624 */         match(input, 73, FOLLOW_73_in_modifier1532);
/* 2625 */         modifiers.addModifier(ModifierSpecification.Modifier.ABSTRACT, hasNegator);
/*      */         
/* 2627 */         break;
/*      */       
/*      */       case 9: 
/* 2631 */         match(input, 90, FOLLOW_90_in_modifier1542);
/* 2632 */         modifiers.addModifier(ModifierSpecification.Modifier.STRICTFP, hasNegator);
/*      */         
/* 2634 */         break;
/*      */       
/*      */       case 10: 
/* 2638 */         match(input, 81, FOLLOW_81_in_modifier1552);
/* 2639 */         modifiers.addModifier(ModifierSpecification.Modifier.FINAL, hasNegator);
/*      */         
/* 2641 */         break;
/*      */       
/*      */       case 11: 
/* 2645 */         match(input, 93, FOLLOW_93_in_modifier1562);
/* 2646 */         modifiers.addModifier(ModifierSpecification.Modifier.TRANSIENT, hasNegator);
/*      */         
/* 2648 */         break;
/*      */       
/*      */       case 12: 
/* 2652 */         match(input, 92, FOLLOW_92_in_modifier1572);
/* 2653 */         modifiers.addModifier(ModifierSpecification.Modifier.SYNTHETIC, hasNegator);
/*      */         
/* 2655 */         break;
/*      */       
/*      */       case 13: 
/* 2659 */         match(input, 77, FOLLOW_77_in_modifier1582);
/* 2660 */         modifiers.addModifier(ModifierSpecification.Modifier.BRIDGE, hasNegator);
/*      */         
/* 2662 */         break;
/*      */       
/*      */       case 14: 
/* 2666 */         match(input, 94, FOLLOW_94_in_modifier1592);
/* 2667 */         modifiers.addModifier(ModifierSpecification.Modifier.VARARGS, hasNegator);
/*      */       
/*      */       }
/*      */       
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/* 2676 */       re = 
/*      */       
/* 2682 */         re;reportError(re);recover(input, re);
/*      */     }
/*      */     finally {}
/*      */   }
/*      */   
/*      */   public final InheritanceSpecification inheritance()
/*      */     throws RecognitionException
/*      */   {
/* 2691 */     InheritanceSpecification inheritanceSpec = null;
/*      */     
/* 2694 */     Token NAME9 = null;
/* 2695 */     AnnotationSpecification annotation10 = null;
/*      */     
/* 2698 */     boolean hasNameNegator = false;
/*      */     
/*      */     try
/*      */     {
/* 2704 */       if ((input.LA(1) == 80) || (input.LA(1) == 82)) {
/* 2705 */         input.consume();
/* 2706 */         state.errorRecovery = false;
/*      */       }
/*      */       else {
/* 2709 */         MismatchedSetException mse = new MismatchedSetException(null, input);
/* 2710 */         throw mse;
/*      */       }
/*      */       
/* 2713 */       int alt36 = 2;
/* 2714 */       int LA36_0 = input.LA(1);
/* 2715 */       if (LA36_0 == 70) {
/* 2716 */         alt36 = 1;
/*      */       }
/* 2718 */       switch (alt36)
/*      */       {
/*      */       case 1: 
/* 2722 */         pushFollow(FOLLOW_annotation_in_inheritance1633);
/* 2723 */         annotation10 = annotation();
/* 2724 */         state._fsp -= 1;
/*      */       }
/*      */       
/*      */       
/* 2732 */       int alt37 = 2;
/* 2733 */       int LA37_0 = input.LA(1);
/* 2734 */       if (LA37_0 == 6) {
/* 2735 */         alt37 = 1;
/*      */       }
/* 2737 */       switch (alt37)
/*      */       {
/*      */       case 1: 
/* 2741 */         match(input, 6, FOLLOW_NEGATOR_in_inheritance1637);
/* 2742 */         hasNameNegator = true;
/*      */       }
/*      */       
/*      */       
/* 2748 */       NAME9 = (Token)match(input, 5, FOLLOW_NAME_in_inheritance1643);
/* 2749 */       inheritanceSpec = GrammarActions.createInheritance(NAME9 != null ? NAME9.getText() : null, hasNameNegator, annotation10);
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/* 2753 */       re = 
/*      */       
/* 2759 */         re;reportError(re);recover(input, re); } finally {}
/* 2760 */     return inheritanceSpec;
/*      */   }
/*      */   
/*      */   public final String arguments()
/*      */     throws RecognitionException
/*      */   {
/* 2769 */     String signature = null;
/*      */     
/* 2772 */     String parameterSig = null;
/*      */     
/*      */     try
/*      */     {
/* 2778 */       match(input, 9, FOLLOW_9_in_arguments1663);
/* 2779 */       signature = "\\(";
/*      */       
/* 2784 */       int alt39 = 2;
/* 2785 */       int LA39_0 = input.LA(1);
/* 2786 */       if ((LA39_0 == 5) || (LA39_0 == 8)) {
/* 2787 */         alt39 = 1;
/*      */       }
/* 2789 */       switch (alt39)
/*      */       {
/*      */       case 1: 
/* 2793 */         pushFollow(FOLLOW_type_in_arguments1691);
/* 2794 */         parameterSig = type();
/* 2795 */         state._fsp -= 1;
/*      */         
/* 2797 */         signature = signature + parameterSig;
/*      */         
/*      */         for (;;)
/*      */         {
/* 2801 */           int alt38 = 2;
/* 2802 */           int LA38_0 = input.LA(1);
/* 2803 */           if (LA38_0 == 11) {
/* 2804 */             alt38 = 1;
/*      */           }
/*      */           
/* 2807 */           switch (alt38)
/*      */           {
/*      */           case 1: 
/* 2811 */             match(input, 11, FOLLOW_11_in_arguments1704);
/* 2812 */             pushFollow(FOLLOW_type_in_arguments1708);
/* 2813 */             parameterSig = type();
/* 2814 */             state._fsp -= 1;
/*      */             
/* 2816 */             signature = signature + parameterSig;
/*      */             
/* 2818 */             break;
/*      */           default: 
/*      */             break label223;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       
/*      */       
/*      */       label223:
/*      */       
/* 2832 */       match(input, 10, FOLLOW_10_in_arguments1737);
/* 2833 */       signature = signature + "\\)";
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/* 2837 */       re = 
/*      */       
/* 2843 */         re;reportError(re);recover(input, re); } finally {}
/* 2844 */     return signature;
/*      */   }
/*      */   
/*      */   public final String type()
/*      */     throws RecognitionException
/*      */   {
/* 2853 */     String signature = null;
/*      */     
/* 2856 */     Token typeName = null;
/*      */     
/* 2859 */     int dim = 0;
/*      */     
/*      */     try
/*      */     {
/* 2868 */       typeName = input.LT(1);
/* 2869 */       if ((input.LA(1) == 5) || (input.LA(1) == 8)) {
/* 2870 */         input.consume();
/* 2871 */         state.errorRecovery = false;
/*      */       }
/*      */       else {
/* 2874 */         MismatchedSetException mse = new MismatchedSetException(null, input);
/* 2875 */         throw mse;
/*      */       }
/*      */       
/*      */       for (;;)
/*      */       {
/* 2880 */         int alt40 = 2;
/* 2881 */         int LA40_0 = input.LA(1);
/* 2882 */         if (LA40_0 == 71) {
/* 2883 */           alt40 = 1;
/*      */         }
/*      */         
/* 2886 */         switch (alt40)
/*      */         {
/*      */         case 1: 
/* 2890 */           match(input, 71, FOLLOW_71_in_type1782);
/* 2891 */           dim++;
/*      */           
/* 2893 */           break;
/*      */         default: 
/*      */           break label154;
/*      */         }
/*      */         
/*      */       }
/*      */       label154:
/* 2900 */       String sig = typeName != null ? typeName.getText() : null; signature = GrammarActions.getSignature(sig == null ? "" : sig, dim);
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/* 2906 */       re = 
/*      */       
/* 2912 */         re;reportError(re);recover(input, re); } finally {}
/* 2913 */     return signature;
/*      */   }
/*      */   
/*      */   public final KeepModifier keepOptionModifier()
/*      */     throws RecognitionException
/*      */   {
/* 2922 */     KeepModifier modifier = null;
/*      */     
/* 2926 */     modifier = new KeepModifier();
/*      */     
/*      */     try
/*      */     {
/*      */       for (;;)
/*      */       {
/* 2935 */         int alt42 = 2;
/* 2936 */         int LA42_0 = input.LA(1);
/* 2937 */         if (LA42_0 == 11) {
/* 2938 */           alt42 = 1;
/*      */         }
/*      */         
/* 2941 */         switch (alt42)
/*      */         {
/*      */         case 1: 
/* 2945 */           match(input, 11, FOLLOW_11_in_keepOptionModifier1817);
/*      */           
/* 2947 */           int alt41 = 4;
/* 2948 */           switch (input.LA(1))
/*      */           {
/*      */           case 76: 
/* 2951 */             alt41 = 1;
/*      */             
/* 2953 */             break;
/*      */           
/*      */           case 75: 
/* 2956 */             alt41 = 2;
/*      */             
/* 2958 */             break;
/*      */           
/*      */           case 83: 
/* 2961 */             alt41 = 3;
/*      */             
/* 2963 */             break;
/*      */           
/*      */           case 74: 
/* 2966 */             alt41 = 4;
/*      */             
/* 2968 */             break;
/*      */           case 77: case 78: case 79: case 80: case 81: case 82: default: 
/* 2970 */             NoViableAltException nvae = new NoViableAltException("", 41, 0, input);
/*      */             
/* 2972 */             throw nvae;
/*      */           }
/* 2974 */           switch (alt41)
/*      */           {
/*      */           case 1: 
/* 2978 */             match(input, 76, FOLLOW_76_in_keepOptionModifier1822);
/* 2979 */             modifier.setAllowShrinking();
/*      */             
/* 2981 */             break;
/*      */           
/*      */           case 2: 
/* 2985 */             match(input, 75, FOLLOW_75_in_keepOptionModifier1830);
/*      */             
/* 2987 */             break;
/*      */           
/*      */           case 3: 
/* 2991 */             match(input, 83, FOLLOW_83_in_keepOptionModifier1837);
/*      */             
/* 2993 */             break;
/*      */           
/*      */           case 4: 
/* 2997 */             match(input, 74, FOLLOW_74_in_keepOptionModifier1844);
/* 2998 */             modifier.setAllowObfuscation();
/*      */           }
/*      */           
/*      */           
/* 3005 */           break;
/*      */         default: 
/*      */           break label292;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (RecognitionException re)
/*      */     {
/*      */       label292:
/* 3015 */       re = 
/*      */       
/* 3021 */         re;
/* 3016 */       reportError(re);
/* 3017 */       recover(input, re);
/*      */     }
/*      */     finally {}
/*      */     
/* 3022 */     return modifier;
/*      */   }
/*      */   
/* 3030 */   public static final BitSet FOLLOW_18_in_prog81 = new BitSet(new long[] { 32L });
/* 3031 */   public static final BitSet FOLLOW_NAME_in_prog85 = new BitSet(new long[] { -4096L, 65L });
/* 3032 */   public static final BitSet FOLLOW_set_in_prog96 = new BitSet(new long[] { 32L });
/* 3033 */   public static final BitSet FOLLOW_NAME_in_prog104 = new BitSet(new long[] { -4096L, 65L });
/* 3034 */   public static final BitSet FOLLOW_40_in_prog115 = new BitSet(new long[] { 2112L, 18006592L });
/* 3035 */   public static final BitSet FOLLOW_keepOptionModifier_in_prog119 = new BitSet(new long[] { 64L, 18006592L });
/* 3036 */   public static final BitSet FOLLOW_classSpecification_in_prog123 = new BitSet(new long[] { -4096L, 65L });
/* 3037 */   public static final BitSet FOLLOW_38_in_prog135 = new BitSet(new long[] { 2112L, 18006592L });
/* 3038 */   public static final BitSet FOLLOW_keepOptionModifier_in_prog139 = new BitSet(new long[] { 64L, 18006592L });
/* 3039 */   public static final BitSet FOLLOW_classSpecification_in_prog143 = new BitSet(new long[] { -4096L, 65L });
/* 3040 */   public static final BitSet FOLLOW_35_in_prog155 = new BitSet(new long[] { 2112L, 18006592L });
/* 3041 */   public static final BitSet FOLLOW_keepOptionModifier_in_prog159 = new BitSet(new long[] { 64L, 18006592L });
/* 3042 */   public static final BitSet FOLLOW_classSpecification_in_prog163 = new BitSet(new long[] { -4096L, 65L });
/* 3043 */   public static final BitSet FOLLOW_unsupportedFlag_in_prog177 = new BitSet(new long[] { -4096L, 65L });
/* 3044 */   public static final BitSet FOLLOW_28_in_prog189 = new BitSet(new long[] { -4000L, 65L });
/* 3045 */   public static final BitSet FOLLOW_filter_in_prog193 = new BitSet(new long[] { -4096L, 65L });
/* 3046 */   public static final BitSet FOLLOW_32_in_prog206 = new BitSet(new long[] { -4096L, 65L });
/* 3047 */   public static final BitSet FOLLOW_61_in_prog218 = new BitSet(new long[] { 32L });
/* 3048 */   public static final BitSet FOLLOW_NAME_in_prog222 = new BitSet(new long[] { -4096L, 65L });
/* 3049 */   public static final BitSet FOLLOW_64_in_prog234 = new BitSet(new long[] { 64L, 18006592L });
/* 3050 */   public static final BitSet FOLLOW_classSpecification_in_prog238 = new BitSet(new long[] { -4096L, 65L });
/* 3051 */   public static final BitSet FOLLOW_24_in_prog250 = new BitSet(new long[] { -4096L, 65L });
/* 3052 */   public static final BitSet FOLLOW_22_in_prog263 = new BitSet(new long[] { -4096L, 65L });
/* 3053 */   public static final BitSet FOLLOW_21_in_prog276 = new BitSet(new long[] { -4096L, 65L });
/* 3054 */   public static final BitSet FOLLOW_EOF_in_prog288 = new BitSet(new long[] { 2L });
/* 3055 */   public static final BitSet FOLLOW_15_in_unsupportedFlag321 = new BitSet(new long[] { 2L });
/* 3056 */   public static final BitSet FOLLOW_19_in_unsupportedFlag329 = new BitSet(new long[] { 32L });
/* 3057 */   public static final BitSet FOLLOW_NAME_in_unsupportedFlag333 = new BitSet(new long[] { 2L });
/* 3058 */   public static final BitSet FOLLOW_23_in_unsupportedFlag341 = new BitSet(new long[] { 2L });
/* 3059 */   public static final BitSet FOLLOW_25_in_unsupportedFlag349 = new BitSet(new long[] { 2L });
/* 3060 */   public static final BitSet FOLLOW_26_in_unsupportedFlag357 = new BitSet(new long[] { 2L });
/* 3061 */   public static final BitSet FOLLOW_27_in_unsupportedFlag365 = new BitSet(new long[] { 2L });
/* 3062 */   public static final BitSet FOLLOW_31_in_unsupportedFlag373 = new BitSet(new long[] { 2L });
/* 3063 */   public static final BitSet FOLLOW_34_in_unsupportedFlag381 = new BitSet(new long[] { 32L });
/* 3064 */   public static final BitSet FOLLOW_classpath_in_unsupportedFlag385 = new BitSet(new long[] { 2L });
/* 3065 */   public static final BitSet FOLLOW_44_in_unsupportedFlag393 = new BitSet(new long[] { 2L });
/* 3066 */   public static final BitSet FOLLOW_45_in_unsupportedFlag401 = new BitSet(new long[] { 32L });
/* 3067 */   public static final BitSet FOLLOW_classpath_in_unsupportedFlag405 = new BitSet(new long[] { 2L });
/* 3068 */   public static final BitSet FOLLOW_46_in_unsupportedFlag413 = new BitSet(new long[] { 2L });
/* 3069 */   public static final BitSet FOLLOW_47_in_unsupportedFlag421 = new BitSet(new long[] { 2L });
/* 3070 */   public static final BitSet FOLLOW_48_in_unsupportedFlag429 = new BitSet(new long[] { 32L });
/* 3071 */   public static final BitSet FOLLOW_NAME_in_unsupportedFlag433 = new BitSet(new long[] { 2L });
/* 3072 */   public static final BitSet FOLLOW_51_in_unsupportedFlag441 = new BitSet(new long[] { 32L });
/* 3073 */   public static final BitSet FOLLOW_classpath_in_unsupportedFlag445 = new BitSet(new long[] { 2L });
/* 3074 */   public static final BitSet FOLLOW_52_in_unsupportedFlag453 = new BitSet(new long[] { 2L });
/* 3075 */   public static final BitSet FOLLOW_53_in_unsupportedFlag461 = new BitSet(new long[] { 32L });
/* 3076 */   public static final BitSet FOLLOW_NAME_in_unsupportedFlag465 = new BitSet(new long[] { 2L });
/* 3077 */   public static final BitSet FOLLOW_55_in_unsupportedFlag473 = new BitSet(new long[] { 34L });
/* 3078 */   public static final BitSet FOLLOW_NAME_in_unsupportedFlag477 = new BitSet(new long[] { 2L });
/* 3079 */   public static final BitSet FOLLOW_60_in_unsupportedFlag486 = new BitSet(new long[] { 2L });
/* 3080 */   public static final BitSet FOLLOW_62_in_unsupportedFlag494 = new BitSet(new long[] { 2L });
/* 3081 */   public static final BitSet FOLLOW_63_in_unsupportedFlag502 = new BitSet(new long[] { 2L });
/* 3082 */   public static final BitSet FOLLOW_12_in_unsupportedFlag511 = new BitSet(new long[] { 96L });
/* 3083 */   public static final BitSet FOLLOW_filter_in_unsupportedFlag515 = new BitSet(new long[] { 2L });
/* 3084 */   public static final BitSet FOLLOW_13_in_unsupportedFlag526 = new BitSet(new long[] { 96L });
/* 3085 */   public static final BitSet FOLLOW_filter_in_unsupportedFlag530 = new BitSet(new long[] { 2L });
/* 3086 */   public static final BitSet FOLLOW_14_in_unsupportedFlag542 = new BitSet(new long[] { 96L });
/* 3087 */   public static final BitSet FOLLOW_filter_in_unsupportedFlag546 = new BitSet(new long[] { 2L });
/* 3088 */   public static final BitSet FOLLOW_16_in_unsupportedFlag558 = new BitSet(new long[] { 32L });
/* 3089 */   public static final BitSet FOLLOW_NAME_in_unsupportedFlag562 = new BitSet(new long[] { 2L });
/* 3090 */   public static final BitSet FOLLOW_17_in_unsupportedFlag573 = new BitSet(new long[] { 64L, 18006592L });
/* 3091 */   public static final BitSet FOLLOW_classSpecification_in_unsupportedFlag575 = new BitSet(new long[] { 2L });
/* 3092 */   public static final BitSet FOLLOW_20_in_unsupportedFlag585 = new BitSet(new long[] { 96L });
/* 3093 */   public static final BitSet FOLLOW_filter_in_unsupportedFlag589 = new BitSet(new long[] { 2L });
/* 3094 */   public static final BitSet FOLLOW_29_in_unsupportedFlag600 = new BitSet(new long[] { 34L });
/* 3095 */   public static final BitSet FOLLOW_NAME_in_unsupportedFlag602 = new BitSet(new long[] { 2L });
/* 3096 */   public static final BitSet FOLLOW_30_in_unsupportedFlag614 = new BitSet(new long[] { 2L, 256L });
/* 3097 */   public static final BitSet FOLLOW_72_in_unsupportedFlag617 = new BitSet(new long[] { 32L, 256L });
/* 3098 */   public static final BitSet FOLLOW_NAME_in_unsupportedFlag621 = new BitSet(new long[] { 0L, 256L });
/* 3099 */   public static final BitSet FOLLOW_72_in_unsupportedFlag624 = new BitSet(new long[] { 2L });
/* 3100 */   public static final BitSet FOLLOW_36_in_unsupportedFlag637 = new BitSet(new long[] { 96L });
/* 3101 */   public static final BitSet FOLLOW_filter_in_unsupportedFlag641 = new BitSet(new long[] { 2L });
/* 3102 */   public static final BitSet FOLLOW_37_in_unsupportedFlag653 = new BitSet(new long[] { 2112L, 18006592L });
/* 3103 */   public static final BitSet FOLLOW_keepOptionModifier_in_unsupportedFlag657 = new BitSet(new long[] { 64L, 18006592L });
/* 3104 */   public static final BitSet FOLLOW_classSpecification_in_unsupportedFlag661 = new BitSet(new long[] { 2L });
/* 3105 */   public static final BitSet FOLLOW_39_in_unsupportedFlag673 = new BitSet(new long[] { 64L, 18006592L });
/* 3106 */   public static final BitSet FOLLOW_classSpecification_in_unsupportedFlag677 = new BitSet(new long[] { 2L });
/* 3107 */   public static final BitSet FOLLOW_41_in_unsupportedFlag689 = new BitSet(new long[] { 96L });
/* 3108 */   public static final BitSet FOLLOW_filter_in_unsupportedFlag693 = new BitSet(new long[] { 2L });
/* 3109 */   public static final BitSet FOLLOW_42_in_unsupportedFlag704 = new BitSet(new long[] { 64L, 18006592L });
/* 3110 */   public static final BitSet FOLLOW_classSpecification_in_unsupportedFlag708 = new BitSet(new long[] { 2L });
/* 3111 */   public static final BitSet FOLLOW_43_in_unsupportedFlag719 = new BitSet(new long[] { 96L });
/* 3112 */   public static final BitSet FOLLOW_filter_in_unsupportedFlag723 = new BitSet(new long[] { 2L });
/* 3113 */   public static final BitSet FOLLOW_49_in_unsupportedFlag735 = new BitSet(new long[] { 32L });
/* 3114 */   public static final BitSet FOLLOW_NAME_in_unsupportedFlag737 = new BitSet(new long[] { 2L });
/* 3115 */   public static final BitSet FOLLOW_50_in_unsupportedFlag748 = new BitSet(new long[] { 96L });
/* 3116 */   public static final BitSet FOLLOW_filter_in_unsupportedFlag752 = new BitSet(new long[] { 2L });
/* 3117 */   public static final BitSet FOLLOW_54_in_unsupportedFlag763 = new BitSet(new long[] { 34L });
/* 3118 */   public static final BitSet FOLLOW_NAME_in_unsupportedFlag765 = new BitSet(new long[] { 2L });
/* 3119 */   public static final BitSet FOLLOW_56_in_unsupportedFlag777 = new BitSet(new long[] { 34L });
/* 3120 */   public static final BitSet FOLLOW_NAME_in_unsupportedFlag781 = new BitSet(new long[] { 2L });
/* 3121 */   public static final BitSet FOLLOW_57_in_unsupportedFlag793 = new BitSet(new long[] { 32L });
/* 3122 */   public static final BitSet FOLLOW_NAME_in_unsupportedFlag795 = new BitSet(new long[] { 2L });
/* 3123 */   public static final BitSet FOLLOW_58_in_unsupportedFlag806 = new BitSet(new long[] { 34L });
/* 3124 */   public static final BitSet FOLLOW_NAME_in_unsupportedFlag810 = new BitSet(new long[] { 2L });
/* 3125 */   public static final BitSet FOLLOW_59_in_unsupportedFlag821 = new BitSet(new long[] { 2L, 256L });
/* 3126 */   public static final BitSet FOLLOW_72_in_unsupportedFlag824 = new BitSet(new long[] { 32L, 256L });
/* 3127 */   public static final BitSet FOLLOW_NAME_in_unsupportedFlag828 = new BitSet(new long[] { 0L, 256L });
/* 3128 */   public static final BitSet FOLLOW_72_in_unsupportedFlag831 = new BitSet(new long[] { 2L });
/* 3129 */   public static final BitSet FOLLOW_NAME_in_classpath855 = new BitSet(new long[] { 2L, 6L });
/* 3130 */   public static final BitSet FOLLOW_set_in_classpath858 = new BitSet(new long[] { 32L });
/* 3131 */   public static final BitSet FOLLOW_classpath_in_classpath864 = new BitSet(new long[] { 2L });
/* 3132 */   public static final BitSet FOLLOW_nonEmptyFilter_in_filter885 = new BitSet(new long[] { 2L });
/* 3133 */   public static final BitSet FOLLOW_NEGATOR_in_nonEmptyFilter919 = new BitSet(new long[] { 32L });
/* 3134 */   public static final BitSet FOLLOW_NAME_in_nonEmptyFilter925 = new BitSet(new long[] { 2050L });
/* 3135 */   public static final BitSet FOLLOW_11_in_nonEmptyFilter930 = new BitSet(new long[] { 96L });
/* 3136 */   public static final BitSet FOLLOW_nonEmptyFilter_in_nonEmptyFilter932 = new BitSet(new long[] { 2L });
/* 3137 */   public static final BitSet FOLLOW_annotation_in_classSpecification962 = new BitSet(new long[] { 64L, 18006592L });
/* 3138 */   public static final BitSet FOLLOW_classModifierAndType_in_classSpecification970 = new BitSet(new long[] { 96L });
/* 3139 */   public static final BitSet FOLLOW_classNames_in_classSpecification975 = new BitSet(new long[] { 2L, 4295294976L });
/* 3140 */   public static final BitSet FOLLOW_inheritance_in_classSpecification984 = new BitSet(new long[] { 2L, 4294967296L });
/* 3141 */   public static final BitSet FOLLOW_members_in_classSpecification992 = new BitSet(new long[] { 2L });
/* 3142 */   public static final BitSet FOLLOW_className_in_classNames1021 = new BitSet(new long[] { 2050L });
/* 3143 */   public static final BitSet FOLLOW_11_in_classNames1028 = new BitSet(new long[] { 96L });
/* 3144 */   public static final BitSet FOLLOW_className_in_classNames1032 = new BitSet(new long[] { 2050L });
/* 3145 */   public static final BitSet FOLLOW_NEGATOR_in_className1061 = new BitSet(new long[] { 32L });
/* 3146 */   public static final BitSet FOLLOW_NAME_in_className1069 = new BitSet(new long[] { 2L });
/* 3147 */   public static final BitSet FOLLOW_NEGATOR_in_classModifierAndType1096 = new BitSet(new long[] { 0L, 18006592L });
/* 3148 */   public static final BitSet FOLLOW_88_in_classModifierAndType1108 = new BitSet(new long[] { 64L, 18006592L });
/* 3149 */   public static final BitSet FOLLOW_classModifierAndType_in_classModifierAndType1114 = new BitSet(new long[] { 2L });
/* 3150 */   public static final BitSet FOLLOW_73_in_classModifierAndType1123 = new BitSet(new long[] { 64L, 18006592L });
/* 3151 */   public static final BitSet FOLLOW_classModifierAndType_in_classModifierAndType1129 = new BitSet(new long[] { 2L });
/* 3152 */   public static final BitSet FOLLOW_81_in_classModifierAndType1138 = new BitSet(new long[] { 64L, 18006592L });
/* 3153 */   public static final BitSet FOLLOW_classModifierAndType_in_classModifierAndType1144 = new BitSet(new long[] { 2L });
/* 3154 */   public static final BitSet FOLLOW_classType_in_classModifierAndType1153 = new BitSet(new long[] { 2L });
/* 3155 */   public static final BitSet FOLLOW_70_in_classType1186 = new BitSet(new long[] { 0L, 1097728L });
/* 3156 */   public static final BitSet FOLLOW_84_in_classType1195 = new BitSet(new long[] { 2L });
/* 3157 */   public static final BitSet FOLLOW_79_in_classType1203 = new BitSet(new long[] { 2L });
/* 3158 */   public static final BitSet FOLLOW_78_in_classType1211 = new BitSet(new long[] { 2L });
/* 3159 */   public static final BitSet FOLLOW_96_in_members1234 = new BitSet(new long[] { 352L, 12882944632L });
/* 3160 */   public static final BitSet FOLLOW_member_in_members1240 = new BitSet(new long[] { 352L, 12882944632L });
/* 3161 */   public static final BitSet FOLLOW_97_in_members1246 = new BitSet(new long[] { 2L });
/* 3162 */   public static final BitSet FOLLOW_annotation_in_member1267 = new BitSet(new long[] { 352L, 4293009976L });
/* 3163 */   public static final BitSet FOLLOW_modifiers_in_member1270 = new BitSet(new long[] { 288L, 56L });
/* 3164 */   public static final BitSet FOLLOW_type_in_member1287 = new BitSet(new long[] { 32L, 16L });
/* 3165 */   public static final BitSet FOLLOW_set_in_member1293 = new BitSet(new long[] { 512L, 4L });
/* 3166 */   public static final BitSet FOLLOW_arguments_in_member1302 = new BitSet(new long[] { 0L, 4L });
/* 3167 */   public static final BitSet FOLLOW_type_in_member1337 = new BitSet(new long[] { 0L, 32L });
/* 3168 */   public static final BitSet FOLLOW_69_in_member1340 = new BitSet(new long[] { 0L, 4L });
/* 3169 */   public static final BitSet FOLLOW_type_in_member1352 = new BitSet(new long[] { 0L, 8L });
/* 3170 */   public static final BitSet FOLLOW_67_in_member1355 = new BitSet(new long[] { 0L, 4L });
/* 3171 */   public static final BitSet FOLLOW_66_in_member1365 = new BitSet(new long[] { 2L });
/* 3172 */   public static final BitSet FOLLOW_70_in_annotation1389 = new BitSet(new long[] { 96L });
/* 3173 */   public static final BitSet FOLLOW_NEGATOR_in_annotation1392 = new BitSet(new long[] { 32L });
/* 3174 */   public static final BitSet FOLLOW_NAME_in_annotation1398 = new BitSet(new long[] { 2L });
/* 3175 */   public static final BitSet FOLLOW_modifier_in_modifiers1422 = new BitSet(new long[] { 66L, 4293009920L });
/* 3176 */   public static final BitSet FOLLOW_NEGATOR_in_modifier1448 = new BitSet(new long[] { 0L, 4293009920L });
/* 3177 */   public static final BitSet FOLLOW_88_in_modifier1462 = new BitSet(new long[] { 2L });
/* 3178 */   public static final BitSet FOLLOW_86_in_modifier1472 = new BitSet(new long[] { 2L });
/* 3179 */   public static final BitSet FOLLOW_87_in_modifier1482 = new BitSet(new long[] { 2L });
/* 3180 */   public static final BitSet FOLLOW_89_in_modifier1492 = new BitSet(new long[] { 2L });
/* 3181 */   public static final BitSet FOLLOW_91_in_modifier1502 = new BitSet(new long[] { 2L });
/* 3182 */   public static final BitSet FOLLOW_95_in_modifier1512 = new BitSet(new long[] { 2L });
/* 3183 */   public static final BitSet FOLLOW_85_in_modifier1522 = new BitSet(new long[] { 2L });
/* 3184 */   public static final BitSet FOLLOW_73_in_modifier1532 = new BitSet(new long[] { 2L });
/* 3185 */   public static final BitSet FOLLOW_90_in_modifier1542 = new BitSet(new long[] { 2L });
/* 3186 */   public static final BitSet FOLLOW_81_in_modifier1552 = new BitSet(new long[] { 2L });
/* 3187 */   public static final BitSet FOLLOW_93_in_modifier1562 = new BitSet(new long[] { 2L });
/* 3188 */   public static final BitSet FOLLOW_92_in_modifier1572 = new BitSet(new long[] { 2L });
/* 3189 */   public static final BitSet FOLLOW_77_in_modifier1582 = new BitSet(new long[] { 2L });
/* 3190 */   public static final BitSet FOLLOW_94_in_modifier1592 = new BitSet(new long[] { 2L });
/* 3191 */   public static final BitSet FOLLOW_set_in_inheritance1623 = new BitSet(new long[] { 96L, 64L });
/* 3192 */   public static final BitSet FOLLOW_annotation_in_inheritance1633 = new BitSet(new long[] { 96L });
/* 3193 */   public static final BitSet FOLLOW_NEGATOR_in_inheritance1637 = new BitSet(new long[] { 32L });
/* 3194 */   public static final BitSet FOLLOW_NAME_in_inheritance1643 = new BitSet(new long[] { 2L });
/* 3195 */   public static final BitSet FOLLOW_9_in_arguments1663 = new BitSet(new long[] { 1312L });
/* 3196 */   public static final BitSet FOLLOW_type_in_arguments1691 = new BitSet(new long[] { 3072L });
/* 3197 */   public static final BitSet FOLLOW_11_in_arguments1704 = new BitSet(new long[] { 288L });
/* 3198 */   public static final BitSet FOLLOW_type_in_arguments1708 = new BitSet(new long[] { 3072L });
/* 3199 */   public static final BitSet FOLLOW_10_in_arguments1737 = new BitSet(new long[] { 2L });
/* 3200 */   public static final BitSet FOLLOW_set_in_type1773 = new BitSet(new long[] { 2L, 128L });
/* 3201 */   public static final BitSet FOLLOW_71_in_type1782 = new BitSet(new long[] { 2L, 128L });
/* 3202 */   public static final BitSet FOLLOW_11_in_keepOptionModifier1817 = new BitSet(new long[] { 0L, 531456L });
/* 3203 */   public static final BitSet FOLLOW_76_in_keepOptionModifier1822 = new BitSet(new long[] { 2050L });
/* 3204 */   public static final BitSet FOLLOW_75_in_keepOptionModifier1830 = new BitSet(new long[] { 2050L });
/* 3205 */   public static final BitSet FOLLOW_83_in_keepOptionModifier1837 = new BitSet(new long[] { 2050L });
/* 3206 */   public static final BitSet FOLLOW_74_in_keepOptionModifier1844 = new BitSet(new long[] { 2050L });
/*      */   
/*      */   public static class unsupportedFlag_return
/*      */     extends ParserRuleReturnScope
/*      */   {}
/*      */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.parser.ProguardParser
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */