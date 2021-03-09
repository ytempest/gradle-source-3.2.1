/*    */ package com.android.build.gradle.shrinker.parser;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ 
/*    */ public class ClassTypeSpecification
/*    */   extends MatcherWithNegator<Integer>
/*    */ {
/*    */   private static final int CLASS_TYPE_FLAGS = 16896;
/*    */   private final int mSpec;
/*    */   
/*    */   public ClassTypeSpecification(int spec)
/*    */   {
/* 32 */     Preconditions.checkState((spec & 0x6200) == spec);
/* 33 */     mSpec = spec;
/*    */   }
/*    */   
/*    */   protected boolean matchesWithoutNegator(Integer toCheck)
/*    */   {
/* 38 */     int modifiers = toCheck.intValue();
/*    */     
/* 41 */     if (((mSpec & 0x2000) != 0) && ((modifiers & 0x2000) == 0))
/*    */     {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     if ((mSpec & 0x4200) == 0)
/*    */     {
/* 48 */       return true;
/*    */     }
/*    */     
/* 51 */     return (modifiers & 0x4200) == (mSpec & 0x4200);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.parser.ClassTypeSpecification
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */