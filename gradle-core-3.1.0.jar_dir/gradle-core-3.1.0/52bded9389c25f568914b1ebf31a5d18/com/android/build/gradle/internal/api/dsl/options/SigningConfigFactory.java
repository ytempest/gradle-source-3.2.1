/*    */ package com.android.build.gradle.internal.api.dsl.options;
/*    */ 
/*    */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.io.File;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.NamedDomainObjectFactory;
/*    */ import org.gradle.api.model.ObjectFactory;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000.\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\016\n\000\030\0002\b\022\004\022\0020\0020\001B%\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\b\022\006\020\t\032\0020\n¢\006\002\020\013J\020\020\f\032\0020\0022\006\020\r\032\0020\016H\026R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\017"}, d2={"Lcom/android/build/gradle/internal/api/dsl/options/SigningConfigFactory;", "Lorg/gradle/api/NamedDomainObjectFactory;", "Lcom/android/build/gradle/internal/api/dsl/options/SigningConfigImpl;", "objectFactory", "Lorg/gradle/api/model/ObjectFactory;", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "defaultDebugKeystoreLocation", "Ljava/io/File;", "(Lorg/gradle/api/model/ObjectFactory;Lcom/android/build/gradle/internal/errors/DeprecationReporter;Lcom/android/builder/errors/EvalIssueReporter;Ljava/io/File;)V", "create", "name", "", "gradle-core"})
/*    */ public final class SigningConfigFactory
/*    */   implements NamedDomainObjectFactory<SigningConfigImpl>
/*    */ {
/*    */   private final ObjectFactory objectFactory;
/*    */   private final DeprecationReporter deprecationReporter;
/*    */   private final EvalIssueReporter issueReporter;
/*    */   private final File defaultDebugKeystoreLocation;
/*    */   
/*    */   public SigningConfigFactory(@NotNull ObjectFactory objectFactory, @NotNull DeprecationReporter deprecationReporter, @NotNull EvalIssueReporter issueReporter, @NotNull File defaultDebugKeystoreLocation)
/*    */   {
/* 29 */     this.objectFactory = objectFactory;this.deprecationReporter = deprecationReporter;this.issueReporter = issueReporter;this.defaultDebugKeystoreLocation = defaultDebugKeystoreLocation;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public SigningConfigImpl create(@NotNull String name)
/*    */   {
/* 37 */     Intrinsics.checkParameterIsNotNull(name, "name");SigningConfigImpl newInstance = (SigningConfigImpl)objectFactory.newInstance(SigningConfigImpl.class, new Object[] {
/* 38 */       name, deprecationReporter, issueReporter });
/*    */     
/* 40 */     if (Intrinsics.areEqual("debug", name)) {
/* 41 */       newInstance.setStoreFile(defaultDebugKeystoreLocation);
/* 42 */       newInstance.setStorePassword(SigningConfigFactoryKt.access$getDEFAULT_PASSWORD$p());
/* 43 */       newInstance.setKeyAlias(SigningConfigFactoryKt.access$getDEFAULT_ALIAS$p());
/* 44 */       newInstance.setKeyPassword(SigningConfigFactoryKt.access$getDEFAULT_PASSWORD$p());
/*    */     }
/*    */     
/* 47 */     SigningConfigImpl tmp82_81 = newInstance;Intrinsics.checkExpressionValueIsNotNull(tmp82_81, "newInstance");return tmp82_81;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.options.SigningConfigFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */