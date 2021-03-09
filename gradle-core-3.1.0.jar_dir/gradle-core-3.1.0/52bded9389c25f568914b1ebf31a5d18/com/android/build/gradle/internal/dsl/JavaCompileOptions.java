/*    */ package com.android.build.gradle.internal.dsl;
/*    */ 
/*    */ import com.google.common.base.MoreObjects;
/*    */ import com.google.common.base.MoreObjects.ToStringHelper;
/*    */ import javax.inject.Inject;
/*    */ import org.gradle.api.Action;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ 
/*    */ public class JavaCompileOptions
/*    */   implements com.android.build.gradle.api.JavaCompileOptions
/*    */ {
/*    */   private AnnotationProcessorOptions annotationProcessorOptions;
/*    */   
/*    */   public JavaCompileOptions()
/*    */   {
/* 34 */     annotationProcessorOptions = new AnnotationProcessorOptions();
/*    */   }
/*    */   
/*    */   @Inject
/*    */   public JavaCompileOptions(ObjectFactory objectFactory) {
/* 39 */     annotationProcessorOptions = ((AnnotationProcessorOptions)objectFactory.newInstance(AnnotationProcessorOptions.class, new Object[0]));
/*    */   }
/*    */   
/*    */   public AnnotationProcessorOptions getAnnotationProcessorOptions()
/*    */   {
/* 48 */     return annotationProcessorOptions;
/*    */   }
/*    */   
/*    */   public void annotationProcessorOptions(Action<AnnotationProcessorOptions> configAction)
/*    */   {
/* 55 */     configAction.execute(annotationProcessorOptions);
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 60 */     return 
/*    */     
/* 62 */       MoreObjects.toStringHelper(this).add("annotationProcessorOptions", annotationProcessorOptions).toString();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.JavaCompileOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */