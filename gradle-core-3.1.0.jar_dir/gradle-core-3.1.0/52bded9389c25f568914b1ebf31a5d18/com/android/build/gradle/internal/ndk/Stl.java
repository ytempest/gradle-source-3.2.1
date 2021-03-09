/*    */ package com.android.build.gradle.internal.ndk;
/*    */ 
/*    */ import com.google.common.base.Strings;
/*    */ import org.gradle.api.InvalidUserDataException;
/*    */ 
/*    */ public enum Stl
/*    */ {
/* 28 */   SYSTEM("system", "system", true), 
/* 29 */   STLPORT_STATIC("stlport_static", "stlport", true), 
/* 30 */   STLPORT_SHARED("stlport_shared", "stlport", false), 
/* 31 */   GNUSTL_STATIC("gnustl_static", "gnustl", true), 
/* 32 */   GNUSTL_SHARED("gnustl_shared", "gnustl", false), 
/* 33 */   GABIPP_STATIC("gabi++_static", "gabi++", true), 
/* 34 */   GABIPP_SHARED("gabi++_shared", "gabi++", false), 
/* 35 */   CPP_STATIC("c++_static", "c++", true), 
/* 36 */   CPP_SHARED("c++_shared", "c++", false);
/*    */   
/* 38 */   public static final Stl DEFAULT = SYSTEM;
/*    */   
/*    */   private String id;
/*    */   
/*    */   private String name;
/*    */   private boolean istStatic;
/*    */   
/*    */   private Stl(String id, String name, boolean isStatic)
/*    */   {
/* 47 */     this.id = id;
/* 48 */     this.name = name;
/* 49 */     istStatic = isStatic;
/*    */   }
/*    */   
/*    */   public String getId() {
/* 53 */     return id;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 57 */     return name;
/*    */   }
/*    */   
/*    */   public boolean isStatic() {
/* 61 */     return istStatic;
/*    */   }
/*    */   
/*    */   public static Stl getById(String id)
/*    */   {
/* 80 */     if (Strings.isNullOrEmpty(id)) {
/* 81 */       return DEFAULT;
/*    */     }
/* 83 */     for (Stl stl : values()) {
/* 84 */       if (id.equals(id)) {
/* 85 */         return stl;
/*    */       }
/*    */     }
/* 88 */     throw new InvalidUserDataException("Invalid STL: " + id);
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 93 */     return getId();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ndk.Stl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */