/*    */ package com.android.build.gradle.internal.api.dsl.model;
/*    */ 
/*    */ import com.android.build.api.dsl.options.PostProcessingOptions;
/*    */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function0;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.gradle.api.NamedDomainObjectFactory;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000(\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\016\n\000\030\0002\b\022\004\022\0020\0020\001B\035\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\b¢\006\002\020\tJ\020\020\n\032\0020\0022\006\020\013\032\0020\fH\026R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\r"}, d2={"Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeFactory;", "Lorg/gradle/api/NamedDomainObjectFactory;", "Lcom/android/build/gradle/internal/api/dsl/model/BuildTypeImpl;", "objectFactory", "Lorg/gradle/api/model/ObjectFactory;", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lorg/gradle/api/model/ObjectFactory;Lcom/android/build/gradle/internal/errors/DeprecationReporter;Lcom/android/builder/errors/EvalIssueReporter;)V", "create", "name", "", "gradle-core"})
/*    */ public final class BuildTypeFactory
/*    */   implements NamedDomainObjectFactory<BuildTypeImpl>
/*    */ {
/*    */   private final ObjectFactory objectFactory;
/*    */   private final DeprecationReporter deprecationReporter;
/*    */   private final EvalIssueReporter issueReporter;
/*    */   
/*    */   public BuildTypeFactory(@NotNull ObjectFactory objectFactory, @NotNull DeprecationReporter deprecationReporter, @NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 24 */     this.objectFactory = objectFactory;this.deprecationReporter = deprecationReporter;this.issueReporter = issueReporter;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public BuildTypeImpl create(@NotNull String name)
/*    */   {
/* 31 */     Intrinsics.checkParameterIsNotNull(name, "name");BuildTypeOrVariantImpl buildTypeOrVariant = new BuildTypeOrVariantImpl(
/* 32 */       "BuildType", 
/* 33 */       deprecationReporter, 
/* 34 */       issueReporter); Object 
/*    */     
/* 36 */       tmp124_119 = objectFactory.newInstance(BuildTypeImpl.class, new Object[] {
/* 37 */       name, 
/* 38 */       new VariantPropertiesImpl(issueReporter), 
/* 39 */       new BuildTypeOrProductFlavorImpl(deprecationReporter, issueReporter, (Function0)new Lambda(buildTypeOrVariant)), 
/* 40 */       buildTypeOrVariant, 
/* 41 */       new FallbackStrategyImpl(deprecationReporter, issueReporter), 
/* 42 */       deprecationReporter, 
/* 43 */       issueReporter });Intrinsics.checkExpressionValueIsNotNull(tmp124_119, "objectFactory.newInstanc…           issueReporter)");return (BuildTypeImpl)tmp124_119;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.model.BuildTypeFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */