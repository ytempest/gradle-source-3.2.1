/*    */ package com.android.build.gradle.internal.api.sourcesets;
/*    */ 
/*    */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.NamedDomainObjectFactory;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0004\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\016\n\000\030\0002\b\022\004\022\0020\0020\001B-\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\b\022\006\020\t\032\0020\n\022\006\020\013\032\0020\f¢\006\002\020\rJ\020\020\016\032\0020\0022\006\020\017\032\0020\020H\026R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\013\032\0020\fX\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000¨\006\021"}, d2={"Lcom/android/build/gradle/internal/api/sourcesets/AndroidSourceSetFactory;", "Lorg/gradle/api/NamedDomainObjectFactory;", "Lcom/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceSet;", "filesProvider", "Lcom/android/build/gradle/internal/api/sourcesets/FilesProvider;", "publishPackage", "", "objectFactory", "Lorg/gradle/api/model/ObjectFactory;", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/build/gradle/internal/api/sourcesets/FilesProvider;ZLorg/gradle/api/model/ObjectFactory;Lcom/android/build/gradle/internal/errors/DeprecationReporter;Lcom/android/builder/errors/EvalIssueReporter;)V", "create", "name", "", "gradle-core"})
/*    */ public final class AndroidSourceSetFactory
/*    */   implements NamedDomainObjectFactory<DefaultAndroidSourceSet>
/*    */ {
/*    */   private final FilesProvider filesProvider;
/*    */   private final boolean publishPackage;
/*    */   private final ObjectFactory objectFactory;
/*    */   private final DeprecationReporter deprecationReporter;
/*    */   private final EvalIssueReporter issueReporter;
/*    */   
/*    */   public AndroidSourceSetFactory(@NotNull FilesProvider filesProvider, boolean publishPackage, @NotNull ObjectFactory objectFactory, @NotNull DeprecationReporter deprecationReporter, @NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 24 */     this.filesProvider = filesProvider;this.publishPackage = publishPackage;this.objectFactory = objectFactory;this.deprecationReporter = deprecationReporter;this.issueReporter = issueReporter;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public DefaultAndroidSourceSet create(@NotNull String name)
/*    */   {
/* 33 */     Intrinsics.checkParameterIsNotNull(name, "name"); Object tmp56_51 = objectFactory.newInstance(DefaultAndroidSourceSet.class, new Object[] {
/* 34 */       name, filesProvider, Boolean.valueOf(publishPackage), deprecationReporter, issueReporter });Intrinsics.checkExpressionValueIsNotNull(tmp56_51, "objectFactory.newInstanc…nReporter, issueReporter)");return (DefaultAndroidSourceSet)tmp56_51;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.sourcesets.AndroidSourceSetFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */