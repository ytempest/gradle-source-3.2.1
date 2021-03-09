/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableList.Builder;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */  enum JacocoTransform$Action
/*     */ {
/* 232 */   COPY(new Pattern[] { JacocoTransform.access$000() }), 
/*     */   
/* 235 */   IGNORE(new Pattern[0]), 
/*     */   
/* 238 */   INSTRUMENT(new Pattern[] { JacocoTransform.access$100() });
/*     */   
/*     */   private final ImmutableList<Pattern> patterns;
/*     */   
/*     */   private JacocoTransform$Action(Pattern... patterns)
/*     */   {
/* 247 */     ImmutableList.Builder<Pattern> builder = new ImmutableList.Builder();
/* 248 */     for (Pattern pattern : patterns) {
/* 249 */       Preconditions.checkNotNull(pattern);
/* 250 */       builder.add(pattern);
/*     */     }
/* 252 */     this.patterns = builder.build();
/*     */   }
/*     */   
/*     */   ImmutableList<Pattern> getPatterns()
/*     */   {
/* 257 */     return patterns;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.JacocoTransform.Action
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */