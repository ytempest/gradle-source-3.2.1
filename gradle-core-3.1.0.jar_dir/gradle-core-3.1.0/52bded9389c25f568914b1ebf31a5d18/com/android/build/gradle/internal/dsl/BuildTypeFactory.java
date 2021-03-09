/*    */ package com.android.build.gradle.internal.dsl;
/*    */ 
/*    */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import org.gradle.api.NamedDomainObjectFactory;
/*    */ import org.gradle.api.Project;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ 
/*    */ public class BuildTypeFactory
/*    */   implements NamedDomainObjectFactory<BuildType>
/*    */ {
/*    */   private final ObjectFactory objectFactory;
/*    */   private final Project project;
/*    */   private final EvalIssueReporter issueReporter;
/*    */   private final DeprecationReporter deprecationReporter;
/*    */   
/*    */   public BuildTypeFactory(ObjectFactory objectFactory, Project project, EvalIssueReporter issueReporter, DeprecationReporter deprecationReporter)
/*    */   {
/* 39 */     this.objectFactory = objectFactory;
/* 40 */     this.project = project;
/* 41 */     this.issueReporter = issueReporter;
/* 42 */     this.deprecationReporter = deprecationReporter;
/*    */   }
/*    */   
/*    */   public BuildType create(String name)
/*    */   {
/* 48 */     return (BuildType)objectFactory.newInstance(BuildType.class, new Object[] { name, project, objectFactory, issueReporter, deprecationReporter });
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.BuildTypeFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */