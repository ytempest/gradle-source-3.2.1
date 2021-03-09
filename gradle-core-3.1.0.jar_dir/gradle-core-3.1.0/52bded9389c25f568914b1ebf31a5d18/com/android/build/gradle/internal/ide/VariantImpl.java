/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.builder.model.AndroidArtifact;
/*     */ import com.android.builder.model.JavaArtifact;
/*     */ import com.android.builder.model.ProductFlavor;
/*     */ import com.android.builder.model.TestedTargetVariant;
/*     */ import com.android.builder.model.Variant;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ 
/*     */ final class VariantImpl
/*     */   implements Variant, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final String name;
/*     */   private final String displayName;
/*     */   private final String buildTypeName;
/*     */   private final List<String> productFlavorNames;
/*     */   private final ProductFlavor mergedFlavor;
/*     */   private final AndroidArtifact mainArtifactInfo;
/*     */   private final Collection<AndroidArtifact> extraAndroidArtifacts;
/*     */   private final Collection<JavaArtifact> extraJavaArtifacts;
/*     */   private final Collection<TestedTargetVariant> testedTargetVariants;
/*     */   
/*     */   VariantImpl(String name, String displayName, String buildTypeName, List<String> productFlavorNames, ProductFlavorImpl mergedFlavor, AndroidArtifact mainArtifactInfo, Collection<AndroidArtifact> extraAndroidArtifacts, Collection<JavaArtifact> extraJavaArtifacts, Collection<TestedTargetVariant> testedTargetVariants)
/*     */   {
/*  67 */     this.name = name;
/*  68 */     this.displayName = displayName;
/*  69 */     this.buildTypeName = buildTypeName;
/*  70 */     this.productFlavorNames = productFlavorNames;
/*  71 */     this.mergedFlavor = mergedFlavor;
/*  72 */     this.mainArtifactInfo = mainArtifactInfo;
/*  73 */     this.extraAndroidArtifacts = extraAndroidArtifacts;
/*  74 */     this.extraJavaArtifacts = extraJavaArtifacts;
/*  75 */     this.testedTargetVariants = testedTargetVariants;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  81 */     return name;
/*     */   }
/*     */   
/*     */   public String getDisplayName()
/*     */   {
/*  87 */     return displayName;
/*     */   }
/*     */   
/*     */   public String getBuildType()
/*     */   {
/*  93 */     return buildTypeName;
/*     */   }
/*     */   
/*     */   public List<String> getProductFlavors()
/*     */   {
/*  99 */     return productFlavorNames;
/*     */   }
/*     */   
/*     */   public ProductFlavor getMergedFlavor()
/*     */   {
/* 105 */     return mergedFlavor;
/*     */   }
/*     */   
/*     */   public AndroidArtifact getMainArtifact()
/*     */   {
/* 111 */     return mainArtifactInfo;
/*     */   }
/*     */   
/*     */   public Collection<AndroidArtifact> getExtraAndroidArtifacts()
/*     */   {
/* 117 */     return extraAndroidArtifacts;
/*     */   }
/*     */   
/*     */   public Collection<JavaArtifact> getExtraJavaArtifacts()
/*     */   {
/* 123 */     return extraJavaArtifacts;
/*     */   }
/*     */   
/*     */   public Collection<TestedTargetVariant> getTestedTargetVariants()
/*     */   {
/* 129 */     return testedTargetVariants;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 134 */     if (this == o) {
/* 135 */       return true;
/*     */     }
/* 137 */     if ((o == null) || (getClass() != o.getClass())) {
/* 138 */       return false;
/*     */     }
/* 140 */     VariantImpl variant = (VariantImpl)o;
/* 141 */     return (Objects.equals(name, name)) && 
/* 142 */       (Objects.equals(displayName, displayName)) && 
/* 143 */       (Objects.equals(buildTypeName, buildTypeName)) && 
/* 144 */       (Objects.equals(productFlavorNames, productFlavorNames)) && 
/* 145 */       (Objects.equals(mergedFlavor, mergedFlavor)) && 
/* 146 */       (Objects.equals(mainArtifactInfo, mainArtifactInfo)) && 
/* 147 */       (Objects.equals(extraAndroidArtifacts, extraAndroidArtifacts)) && 
/* 148 */       (Objects.equals(extraJavaArtifacts, extraJavaArtifacts)) && 
/* 149 */       (Objects.equals(testedTargetVariants, testedTargetVariants));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 154 */     return Objects.hash(new Object[] { name, displayName, buildTypeName, productFlavorNames, mergedFlavor, mainArtifactInfo, extraAndroidArtifacts, extraJavaArtifacts, testedTargetVariants });
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 160 */     return 
/*     */     
/* 170 */       MoreObjects.toStringHelper(this).add("name", name).add("displayName", displayName).add("buildTypeName", buildTypeName).add("productFlavorNames", productFlavorNames).add("mergedFlavor", mergedFlavor).add("mainArtifactInfo", mainArtifactInfo).add("extraAndroidArtifacts", extraAndroidArtifacts).add("extraJavaArtifacts", extraJavaArtifacts).add("testedTargetVariants", testedTargetVariants).toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.VariantImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */