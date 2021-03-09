/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import java.util.Set;
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.model.ObjectFactory;
/*     */ 
/*     */ public class Splits
/*     */ {
/*     */   private final DensitySplitOptions density;
/*     */   private final AbiSplitOptions abi;
/*     */   private final LanguageSplitOptions language;
/*     */   
/*     */   @Inject
/*     */   public Splits(ObjectFactory objectFactory, DeprecationReporter deprecationReporter)
/*     */   {
/*  73 */     density = ((DensitySplitOptions)objectFactory.newInstance(DensitySplitOptions.class, new Object[] { deprecationReporter }));
/*  74 */     abi = ((AbiSplitOptions)objectFactory.newInstance(AbiSplitOptions.class, new Object[0]));
/*  75 */     language = ((LanguageSplitOptions)objectFactory.newInstance(LanguageSplitOptions.class, new Object[] { deprecationReporter }));
/*     */   }
/*     */   
/*     */   public DensitySplitOptions getDensity()
/*     */   {
/*  84 */     return density;
/*     */   }
/*     */   
/*     */   public void density(Action<DensitySplitOptions> action)
/*     */   {
/*  96 */     action.execute(density);
/*     */   }
/*     */   
/*     */   public AbiSplitOptions getAbi()
/*     */   {
/* 105 */     return abi;
/*     */   }
/*     */   
/*     */   public void abi(Action<AbiSplitOptions> action)
/*     */   {
/* 117 */     action.execute(abi);
/*     */   }
/*     */   
/*     */   public LanguageSplitOptions getLanguage()
/*     */   {
/* 131 */     return language;
/*     */   }
/*     */   
/*     */   public void language(Action<LanguageSplitOptions> action)
/*     */   {
/* 148 */     action.execute(language);
/*     */   }
/*     */   
/*     */   public Set<String> getDensityFilters()
/*     */   {
/* 163 */     return density.getApplicableFilters();
/*     */   }
/*     */   
/*     */   public Set<String> getAbiFilters()
/*     */   {
/* 176 */     return abi.getApplicableFilters();
/*     */   }
/*     */   
/*     */   public Set<String> getLanguageFilters()
/*     */   {
/* 190 */     return language.getApplicationFilters();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.Splits
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */