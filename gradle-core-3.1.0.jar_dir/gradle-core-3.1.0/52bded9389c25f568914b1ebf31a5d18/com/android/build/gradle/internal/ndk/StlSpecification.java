/*    */ package com.android.build.gradle.internal.ndk;
/*    */ 
/*    */ import java.util.Collection;
/*    */ 
/*    */ public final class StlSpecification
/*    */ {
/*    */   private final Collection<String> includes;
/*    */   private final Collection<String> staticLibs;
/*    */   private final Collection<String> sharedLibs;
/*    */   
/*    */   public StlSpecification(Collection<String> includes, Collection<String> staticLibs, Collection<String> sharedLibs)
/*    */   {
/* 37 */     this.includes = includes;
/* 38 */     this.staticLibs = staticLibs;
/* 39 */     this.sharedLibs = sharedLibs;
/*    */   }
/*    */   
/*    */   public Collection<String> getIncludes()
/*    */   {
/* 44 */     return includes;
/*    */   }
/*    */   
/*    */   public Collection<String> getStaticLibs()
/*    */   {
/* 49 */     return staticLibs;
/*    */   }
/*    */   
/*    */   public Collection<String> getSharedLibs()
/*    */   {
/* 54 */     return sharedLibs;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ndk.StlSpecification
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */