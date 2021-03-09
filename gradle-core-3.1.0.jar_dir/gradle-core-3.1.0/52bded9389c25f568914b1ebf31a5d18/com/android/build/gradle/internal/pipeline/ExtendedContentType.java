/*    */ package com.android.build.gradle.internal.pipeline;
/*    */ 
/*    */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*    */ import com.android.build.api.transform.QualifiedContent.DefaultContentType;
/*    */ import com.google.common.collect.ImmutableSet;
/*    */ import com.google.common.collect.ImmutableSet.Builder;
/*    */ import java.util.Set;
/*    */ 
/*    */ public enum ExtendedContentType
/*    */   implements QualifiedContent.ContentType
/*    */ {
/* 32 */   DEX(4096), 
/*    */   
/* 37 */   NATIVE_LIBS(8192), 
/*    */   
/* 45 */   CLASSES_ENHANCED(16384), 
/*    */   
/* 50 */   DATA_BINDING(65536), 
/*    */   
/* 53 */   JAVA_SOURCES(131072), 
/*    */   
/* 57 */   DEX_ARCHIVE(262144), 
/*    */   
/* 60 */   DATA_BINDING_BASE_CLASS_LOG(1048576);
/*    */   
/*    */   private final int value;
/*    */   private static final Set<QualifiedContent.ContentType> allContentTypes;
/*    */   
/*    */   private ExtendedContentType(int value) {
/* 66 */     this.value = value;
/*    */   }
/*    */   
/*    */   public int getValue()
/*    */   {
/* 71 */     return value;
/*    */   }
/*    */   
/*    */   public static Set<QualifiedContent.ContentType> getAllContentTypes()
/*    */   {
/* 80 */     return allContentTypes;
/*    */   }
/*    */   
/*    */   static
/*    */   {
/* 86 */     ImmutableSet.Builder<QualifiedContent.ContentType> builder = ImmutableSet.builder();
/* 87 */     for (QualifiedContent.DefaultContentType contentType : QualifiedContent.DefaultContentType.values()) {
/* 88 */       builder.add(contentType);
/*    */     }
/* 90 */     for (ExtendedContentType extendedContentType : values()) {
/* 91 */       builder.add(extendedContentType);
/*    */     }
/* 93 */     allContentTypes = builder.build();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.ExtendedContentType
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */