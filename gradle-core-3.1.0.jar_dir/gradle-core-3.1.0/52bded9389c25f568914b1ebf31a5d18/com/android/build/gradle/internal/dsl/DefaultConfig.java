/*    */ package com.android.build.gradle.internal.dsl;
/*    */ 
/*    */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*    */ import javax.inject.Inject;
/*    */ import org.gradle.api.Project;
/*    */ import org.gradle.api.logging.Logger;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ 
/*    */ public class DefaultConfig
/*    */   extends BaseFlavor
/*    */ {
/*    */   @Inject
/*    */   public DefaultConfig(String name, Project project, ObjectFactory objectFactory, DeprecationReporter deprecationReporter, Logger logger)
/*    */   {
/* 36 */     super(name, project, objectFactory, deprecationReporter, logger);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.DefaultConfig
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */