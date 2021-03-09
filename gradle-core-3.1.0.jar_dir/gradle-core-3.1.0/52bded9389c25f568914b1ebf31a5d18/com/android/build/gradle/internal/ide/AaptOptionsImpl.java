/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.builder.model.AaptOptions.Namespacing;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ 
/*     */ public final class AaptOptionsImpl
/*     */   implements com.android.builder.model.AaptOptions, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String ignoreAssets;
/*     */   private final Collection<String> noCompress;
/*     */   private final boolean failOnMissingConfigEntry;
/*     */   private final List<String> additionalParameters;
/*     */   private final AaptOptions.Namespacing namespacing;
/*     */   
/*     */   public static com.android.builder.model.AaptOptions create(com.android.build.gradle.internal.dsl.AaptOptions aaptOptions)
/*     */   {
/*  55 */     return new AaptOptionsImpl(aaptOptions
/*  56 */       .getIgnoreAssets(), aaptOptions
/*  57 */       .getNoCompress(), aaptOptions
/*  58 */       .getFailOnMissingConfigEntry(), aaptOptions
/*  59 */       .getAdditionalParameters(), Boolean.TRUE
/*  60 */       .equals(aaptOptions.getNamespaced()) ? AaptOptions.Namespacing.REQUIRED : AaptOptions.Namespacing.DISABLED);
/*     */   }
/*     */   
/*     */   public static com.android.builder.model.AaptOptions createDummy()
/*     */   {
/*  66 */     return new AaptOptionsImpl("", 
/*  67 */       Collections.emptyList(), false, Collections.emptyList(), AaptOptions.Namespacing.DISABLED);
/*     */   }
/*     */   
/*     */   public AaptOptionsImpl(String ignoreAssets, Collection<String> noCompress, boolean failOnMissingConfigEntry, List<String> additionalParameters, AaptOptions.Namespacing namespacing)
/*     */   {
/*  76 */     this.ignoreAssets = ignoreAssets;
/*  77 */     this.failOnMissingConfigEntry = failOnMissingConfigEntry;
/*  78 */     this.noCompress = (noCompress == null ? null : 
/*  79 */       ImmutableList.copyOf(noCompress));
/*  80 */     this.additionalParameters = (additionalParameters == null ? 
/*  81 */       ImmutableList.of() : additionalParameters);
/*  82 */     this.namespacing = namespacing;
/*     */   }
/*     */   
/*     */   public String getIgnoreAssets()
/*     */   {
/*  88 */     return ignoreAssets;
/*     */   }
/*     */   
/*     */   public Collection<String> getNoCompress()
/*     */   {
/*  94 */     return noCompress;
/*     */   }
/*     */   
/*     */   public boolean getFailOnMissingConfigEntry()
/*     */   {
/*  99 */     return failOnMissingConfigEntry;
/*     */   }
/*     */   
/*     */   public List<String> getAdditionalParameters()
/*     */   {
/* 105 */     return additionalParameters;
/*     */   }
/*     */   
/*     */   public AaptOptions.Namespacing getNamespacing()
/*     */   {
/* 111 */     return namespacing;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 115 */     return 
/*     */     
/* 121 */       MoreObjects.toStringHelper(this).add("ignoreAssets", ignoreAssets).add("noCompress", noCompress).add("failOnMissingConfigEntry", failOnMissingConfigEntry).add("additionalParameters", additionalParameters).add("namespacing", namespacing).toString();
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 126 */     if (this == o) {
/* 127 */       return true;
/*     */     }
/* 129 */     if (!(o instanceof AaptOptionsImpl)) {
/* 130 */       return false;
/*     */     }
/* 132 */     AaptOptionsImpl that = (AaptOptionsImpl)o;
/* 133 */     return (failOnMissingConfigEntry == failOnMissingConfigEntry) && 
/* 134 */       (Objects.equals(ignoreAssets, ignoreAssets)) && 
/* 135 */       (Objects.equals(noCompress, noCompress)) && 
/* 136 */       (Objects.equals(additionalParameters, additionalParameters)) && (namespacing == namespacing);
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 142 */     return Objects.hash(new Object[] { ignoreAssets, noCompress, 
/*     */     
/* 145 */       Boolean.valueOf(failOnMissingConfigEntry), additionalParameters, namespacing });
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.AaptOptionsImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */