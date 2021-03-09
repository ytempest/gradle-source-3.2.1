/*     */ package com.android.build.gradle.shrinker.parser;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import java.util.Collections;
/*     */ import java.util.EnumSet;
/*     */ 
/*     */ public class ModifierSpecification
/*     */   implements Matcher<MemberModifier>
/*     */ {
/*     */   public static enum ModifierTarget
/*     */   {
/*  30 */     FIELD, 
/*  31 */     METHOD, 
/*  32 */     CLASS;
/*     */     
/*     */     private ModifierTarget() {}
/*     */   }
/*     */   
/*     */   public static class MemberModifier {
/*     */     public final int modifier;
/*     */     public final ModifierSpecification.ModifierTarget modifierTarget;
/*     */     
/*  41 */     public MemberModifier(ModifierSpecification.ModifierTarget modifierTarget, int modifier) { this.modifier = modifier;
/*  42 */       this.modifierTarget = modifierTarget;
/*     */     }
/*     */   }
/*     */   
/*     */   public static enum AccessFlag {
/*  47 */     PUBLIC(1), 
/*  48 */     PRIVATE(2), 
/*  49 */     PROTECTED(4);
/*     */     
/*     */     private final int value;
/*     */     
/*     */     private AccessFlag(int value) {
/*  54 */       this.value = value;
/*     */     }
/*     */   }
/*     */   
/*     */   public static enum Modifier {
/*  59 */     STATIC(8), 
/*  60 */     FINAL(16), 
/*  61 */     SUPER(32), 
/*  62 */     SYNCHRONIZED(32), 
/*  63 */     VOLATILE(64), 
/*  64 */     BRIDGE(64), 
/*  65 */     TRANSIENT(128), 
/*  66 */     VARARGS(128), 
/*  67 */     NATIVE(256), 
/*  68 */     INTERFACE(512), 
/*  69 */     ABSTRACT(1024), 
/*  70 */     STRICTFP(2048), 
/*  71 */     SYNTHETIC(4096), 
/*  72 */     ANNOTATION(8192), 
/*  73 */     ENUM(16384);
/*     */     
/*     */     private final int value;
/*     */     
/*     */     private Modifier(int value) {
/*  78 */       this.value = value;
/*     */     }
/*     */   }
/*     */   
/*  83 */   private static final ImmutableMap<ModifierTarget, EnumSet<Modifier>> MODIFIERS_BY_TYPE = ImmutableMap.of(ModifierTarget.FIELD, 
/*     */   
/*  85 */     EnumSet.of(Modifier.STATIC, new Modifier[] { Modifier.FINAL, Modifier.TRANSIENT, Modifier.VOLATILE, Modifier.ENUM, Modifier.SYNTHETIC }), ModifierTarget.METHOD, 
/*     */     
/*  93 */     EnumSet.of(Modifier.STATIC, new Modifier[] { Modifier.NATIVE, Modifier.ABSTRACT, Modifier.FINAL, Modifier.SYNCHRONIZED, Modifier.BRIDGE, Modifier.SYNTHETIC, Modifier.STRICTFP, Modifier.VARARGS }), ModifierTarget.CLASS, 
/*     */     
/* 104 */     EnumSet.of(Modifier.STATIC, new Modifier[] { Modifier.FINAL, Modifier.ENUM, Modifier.SYNTHETIC, Modifier.ABSTRACT, Modifier.INTERFACE, Modifier.ANNOTATION, Modifier.SUPER, Modifier.STRICTFP }));
/*     */   
/*     */   private final EnumSet<Modifier> modifiers;
/*     */   
/*     */   private final EnumSet<Modifier> modifiersWithNegator;
/*     */   
/*     */   private final EnumSet<AccessFlag> accessFlags;
/*     */   
/*     */   public ModifierSpecification()
/*     */   {
/* 115 */     modifiers = EnumSet.noneOf(Modifier.class);
/*     */     
/* 117 */     modifiersWithNegator = EnumSet.noneOf(Modifier.class);
/*     */     
/* 119 */     accessFlags = EnumSet.noneOf(AccessFlag.class);
/*     */   }
/*     */   
/* 122 */   private final EnumSet<AccessFlag> accessFlagsWithNegator = EnumSet.noneOf(AccessFlag.class);
/*     */   
/*     */   public void addModifier(Modifier modifier, boolean hasNegator) {
/* 125 */     if (hasNegator) {
/* 126 */       modifiersWithNegator.add(modifier);
/*     */     } else {
/* 128 */       modifiers.add(modifier);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addAccessFlag(AccessFlag accessFlag, boolean hasNegator) {
/* 133 */     if (hasNegator) {
/* 134 */       accessFlagsWithNegator.add(accessFlag);
/*     */     } else {
/* 136 */       accessFlags.add(accessFlag);
/*     */     }
/*     */   }
/*     */   
/*     */   private static AccessFlag getAccessFlag(int toConvert)
/*     */   {
/* 142 */     for (AccessFlag accFlags : ) {
/* 143 */       if ((value & toConvert) != 0) {
/* 144 */         return accFlags;
/*     */       }
/*     */     }
/* 147 */     return null;
/*     */   }
/*     */   
/*     */   private static EnumSet<Modifier> getModifiers(int bitmask, EnumSet<Modifier> modifiers) {
/* 151 */     EnumSet<Modifier> result = EnumSet.noneOf(Modifier.class);
/*     */     
/* 153 */     for (Modifier modifier : modifiers) {
/* 154 */       if ((value & bitmask) != 0) {
/* 155 */         result.add(modifier);
/*     */       }
/*     */     }
/*     */     
/* 159 */     return result;
/*     */   }
/*     */   
/*     */   public boolean matches(MemberModifier candidate)
/*     */   {
/* 169 */     AccessFlag candidateAccFlag = getAccessFlag(modifier);
/*     */     
/* 173 */     if ((!accessFlags.isEmpty()) && 
/* 174 */       (!accessFlags.contains(candidateAccFlag))) {
/* 175 */       return false;
/*     */     }
/*     */     
/* 179 */     if (accessFlagsWithNegator.contains(candidateAccFlag)) {
/* 180 */       return false;
/*     */     }
/*     */     
/* 184 */     EnumSet<Modifier> candidateModifiers = getModifiers(modifier, (EnumSet)MODIFIERS_BY_TYPE.get(modifierTarget));
/*     */     
/* 186 */     return (candidateModifiers.containsAll(modifiers)) && 
/* 187 */       (Collections.disjoint(candidateModifiers, modifiersWithNegator));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.parser.ModifierSpecification
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */