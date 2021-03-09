/*     */ package com.android.build.gradle.shrinker.parser;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ClassSpecification
/*     */ {
/*     */   private final List<NameSpecification> nameSpecs;
/*     */   private final ClassTypeSpecification classType;
/*     */   private final AnnotationSpecification annotation;
/*     */   private KeepModifier keepModifier;
/*     */   private ModifierSpecification modifier;
/*  32 */   private List<FieldSpecification> fieldSpecifications = Lists.newArrayList();
/*  33 */   private List<MethodSpecification> methodSpecifications = Lists.newArrayList();
/*     */   
/*     */   private InheritanceSpecification inheritanceSpecification;
/*     */   
/*     */   public ClassSpecification(List<NameSpecification> nameSpecs, ClassTypeSpecification classType, AnnotationSpecification annotation)
/*     */   {
/*  40 */     this.nameSpecs = nameSpecs;
/*  41 */     this.classType = classType;
/*  42 */     this.annotation = annotation;
/*  43 */     keepModifier = new KeepModifier();
/*     */   }
/*     */   
/*     */   public void setKeepModifier(KeepModifier keepModifier) {
/*  47 */     this.keepModifier = keepModifier;
/*     */   }
/*     */   
/*     */   public KeepModifier getKeepModifier()
/*     */   {
/*  52 */     return keepModifier;
/*     */   }
/*     */   
/*     */   public void setModifier(ModifierSpecification modifier) {
/*  56 */     this.modifier = modifier;
/*     */   }
/*     */   
/*     */   public ModifierSpecification getModifier()
/*     */   {
/*  61 */     return modifier;
/*     */   }
/*     */   
/*     */   public void add(FieldSpecification fieldSpecification) {
/*  65 */     fieldSpecifications.add(fieldSpecification);
/*     */   }
/*     */   
/*     */   public void add(MethodSpecification methodSpecification) {
/*  69 */     methodSpecifications.add(methodSpecification);
/*     */   }
/*     */   
/*     */   public List<MethodSpecification> getMethodSpecifications()
/*     */   {
/*  74 */     return methodSpecifications;
/*     */   }
/*     */   
/*     */   public List<NameSpecification> getNames() {
/*  78 */     return nameSpecs;
/*     */   }
/*     */   
/*     */   public ClassTypeSpecification getClassType()
/*     */   {
/*  83 */     return classType;
/*     */   }
/*     */   
/*     */   public AnnotationSpecification getAnnotation()
/*     */   {
/*  88 */     return annotation;
/*     */   }
/*     */   
/*     */   public List<FieldSpecification> getFieldSpecifications()
/*     */   {
/*  93 */     return fieldSpecifications;
/*     */   }
/*     */   
/*     */   public void setInheritance(InheritanceSpecification inheritanceSpecification) {
/*  97 */     this.inheritanceSpecification = inheritanceSpecification;
/*     */   }
/*     */   
/*     */   public InheritanceSpecification getInheritance()
/*     */   {
/* 102 */     return inheritanceSpecification;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.parser.ClassSpecification
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */