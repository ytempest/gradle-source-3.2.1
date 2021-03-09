/*    */ package com.android.build.gradle.shrinker.parser;
/*    */ 
/*    */ public class InheritanceSpecification
/*    */ {
/*    */   private final NameSpecification mNameSpec;
/*    */   
/*    */   private final AnnotationSpecification mAnnotationType;
/*    */   
/*    */   public InheritanceSpecification(NameSpecification nameSpec, AnnotationSpecification annotationType)
/*    */   {
/* 27 */     mNameSpec = nameSpec;
/* 28 */     mAnnotationType = annotationType;
/*    */   }
/*    */   
/*    */   public NameSpecification getNameSpec() {
/* 32 */     return mNameSpec;
/*    */   }
/*    */   
/*    */   public AnnotationSpecification getAnnotationType() {
/* 36 */     return mAnnotationType;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.parser.InheritanceSpecification
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */