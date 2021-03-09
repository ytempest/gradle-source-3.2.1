/*    */ package com.android.build.gradle.shrinker.parser;
/*    */ 
/*    */ public class FieldSpecification
/*    */ {
/*    */   private final NameSpecification mName;
/*    */   
/*    */   private final ModifierSpecification mModifier;
/*    */   
/*    */   private final NameSpecification mTypeSignature;
/*    */   
/*    */   private final AnnotationSpecification mAnnotationType;
/*    */   
/*    */   public FieldSpecification(NameSpecification name, ModifierSpecification modifier, NameSpecification typeSignature, AnnotationSpecification annotationType)
/*    */   {
/* 35 */     mName = name;
/* 36 */     mModifier = modifier;
/* 37 */     mTypeSignature = typeSignature;
/* 38 */     mAnnotationType = annotationType;
/*    */   }
/*    */   
/*    */   public NameSpecification getName()
/*    */   {
/* 43 */     return mName;
/*    */   }
/*    */   
/*    */   public ModifierSpecification getModifier()
/*    */   {
/* 48 */     return mModifier;
/*    */   }
/*    */   
/*    */   public NameSpecification getTypeSignature()
/*    */   {
/* 53 */     return mTypeSignature;
/*    */   }
/*    */   
/*    */   public AnnotationSpecification getAnnotations()
/*    */   {
/* 58 */     return mAnnotationType;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.parser.FieldSpecification
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */