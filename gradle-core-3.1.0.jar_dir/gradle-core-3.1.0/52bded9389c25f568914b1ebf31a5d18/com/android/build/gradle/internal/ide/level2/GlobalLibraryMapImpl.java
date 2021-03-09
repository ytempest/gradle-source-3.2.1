/*    */ package com.android.build.gradle.internal.ide.level2;
/*    */ 
/*    */ import com.android.builder.model.level2.GlobalLibraryMap;
/*    */ import com.android.builder.model.level2.Library;
/*    */ import com.google.common.collect.ImmutableMap;
/*    */ import java.io.Serializable;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class GlobalLibraryMapImpl
/*    */   implements GlobalLibraryMap, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final Map<String, Library> map;
/*    */   
/*    */   public GlobalLibraryMapImpl(Map<String, Library> map)
/*    */   {
/* 34 */     this.map = ImmutableMap.copyOf(map);
/*    */   }
/*    */   
/*    */   public Map<String, Library> getLibraries()
/*    */   {
/* 40 */     return map;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.level2.GlobalLibraryMapImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */