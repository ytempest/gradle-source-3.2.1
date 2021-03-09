/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.gradle.shrinker.parser.UnsupportedFlagsHandler;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import org.gradle.api.InvalidUserDataException;
/*     */ import org.slf4j.Logger;
/*     */ 
/*     */ class BuiltInShrinkerTransform$ShrinkerFlagsHandler
/*     */   implements UnsupportedFlagsHandler
/*     */ {
/* 320 */   private static final ImmutableSet<String> UNSUPPORTED_FLAGS = ImmutableSet.of("-dump", "-forceprocessing", "-injars", "-keepdirectories", "-libraryjars", "-microedition", new String[] { "-outjars", "-printconfiguration", "-printmapping", "-printseeds", "-printusage" });
/*     */   
/* 334 */   private static final ImmutableSet<String> IGNORED_FLAGS = ImmutableSet.of("-optimizations", "-adaptclassstrings", "-adaptresourcefilecontents", "-adaptresourcefilenames", "-allowaccessmodification", "-applymapping", new String[] { "-assumenosideeffects", "-classobfuscationdictionary", "-flattenpackagehierarchy", "-mergeinterfacesaggressively", "-obfuscationdictionary", "-optimizationpasses", "-overloadaggressively", "-packageobfuscationdictionary", "-renamesourcefileattribute", "-repackageclasses", "-useuniqueclassmembernames" });
/*     */   
/*     */   public void unsupportedFlag(String flagName)
/*     */   {
/* 355 */     if (UNSUPPORTED_FLAGS.contains(flagName)) {
/* 356 */       throw new InvalidUserDataException(flagName + " is not supported by the built-in class shrinker.");
/*     */     }
/* 358 */     if (IGNORED_FLAGS.contains(flagName)) {
/* 359 */       BuiltInShrinkerTransform.access$100().warn(flagName + " is ignored by the built-in class shrinker.");
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.BuiltInShrinkerTransform.ShrinkerFlagsHandler
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */