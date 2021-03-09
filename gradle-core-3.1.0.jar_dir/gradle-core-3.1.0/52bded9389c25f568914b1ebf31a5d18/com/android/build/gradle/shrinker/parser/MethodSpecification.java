/*    */ package com.android.build.gradle.shrinker.parser;
/*    */ 
/*    */ public class MethodSpecification
/*    */ {
/*    */   private final NameSpecification mNameSpecification;
/*    */   
/*    */   private final ModifierSpecification mModifiers;
/*    */   
/*    */   private final AnnotationSpecification mAnnotationType;
/*    */   
/*    */   public MethodSpecification(NameSpecification nameSpecification, ModifierSpecification modifiers, AnnotationSpecification annotationType)
/*    */   {
/* 33 */     mNameSpecification = nameSpecification;
/* 34 */     mModifiers = modifiers;
/* 35 */     mAnnotationType = annotationType;
/*    */   }
/*    */   
/*    */   public ModifierSpecification getModifiers()
/*    */   {
/* 40 */     return mModifiers;
/*    */   }
/*    */   
/*    */   public AnnotationSpecification getAnnotations()
/*    */   {
/* 45 */     return mAnnotationType;
/*    */   }
/*    */   
/*    */   public NameSpecification getName()
/*    */   {
/* 50 */     return mNameSpecification;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.parser.MethodSpecification
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */