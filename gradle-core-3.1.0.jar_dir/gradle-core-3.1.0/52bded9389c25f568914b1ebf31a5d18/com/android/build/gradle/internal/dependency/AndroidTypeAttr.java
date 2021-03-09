/*    */ package com.android.build.gradle.internal.dependency;
/*    */ 
/*    */ import org.gradle.api.Named;
/*    */ import org.gradle.api.attributes.Attribute;
/*    */ 
/*    */ public abstract interface AndroidTypeAttr
/*    */   extends Named
/*    */ {
/* 23 */   public static final Attribute<AndroidTypeAttr> ATTRIBUTE = Attribute.of(AndroidTypeAttr.class);
/*    */   public static final String APK = "Apk";
/*    */   public static final String AAR = "Aar";
/*    */   public static final String FEATURE = "Feature";
/*    */   public static final String METADATA = "Metadata";
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.AndroidTypeAttr
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */