/*    */ package com.android.build.gradle.internal.api.dsl.extensions;
/*    */ 
/*    */ import com.android.build.api.dsl.extension.BuildProperties;
/*    */ import com.android.build.api.sourcesets.AndroidSourceSet;
/*    */ import com.android.build.api.transform.Transform;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*    */ import com.android.build.gradle.internal.variant2.DslModelData;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.NotImplementedError;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.gradle.api.NamedDomainObjectContainer;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000h\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\f\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020 \n\002\030\002\n\002\b\003\n\002\020\000\n\002\b\002\n\002\020\002\n\002\b\002\n\002\020\021\n\002\b\002\n\002\020\b\n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\000\030\0002\0020\0012\0020\002B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006¢\006\002\020\007J\020\020\"\032\0020#2\006\020$\032\0020\034H\026J)\020\"\032\0020#2\006\020$\032\0020\0342\022\020%\032\n\022\006\b\001\022\0020 0&\"\0020 H\027¢\006\002\020'J\020\020\021\032\0020#2\006\020(\032\0020)H\026J\034\020\025\032\0020#2\022\020*\032\016\022\n\022\b\022\004\022\0020\0270\0260+H\026J\020\020,\032\0020#2\006\020-\032\0020\tH\026J\030\020,\032\0020#2\006\020-\032\0020\t2\006\020.\032\0020/H\026R(\020\n\032\004\030\0010\t2\b\020\b\032\004\030\0010\t@VX\016¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016R(\020\017\032\004\030\0010\t2\b\020\b\032\004\030\0010\t@VX\016¢\006\016\n\000\032\004\b\020\020\f\"\004\b\021\020\016R(\020\022\032\004\030\0010\t2\b\020\b\032\004\030\0010\t8V@VX\016¢\006\f\032\004\b\023\020\f\"\004\b\024\020\016R\032\020\025\032\b\022\004\022\0020\0270\026X\004¢\006\b\n\000\032\004\b\030\020\031R\032\020\032\032\b\022\004\022\0020\0340\0338VX\004¢\006\006\032\004\b\035\020\036R \020\037\032\016\022\n\022\b\022\004\022\0020 0\0330\0338VX\004¢\006\006\032\004\b!\020\036¨\0060"}, d2={"Lcom/android/build/gradle/internal/api/dsl/extensions/BuildPropertiesImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/extension/BuildProperties;", "dslModelData", "Lcom/android/build/gradle/internal/variant2/DslModelData;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/build/gradle/internal/variant2/DslModelData;Lcom/android/builder/errors/EvalIssueReporter;)V", "value", "", "buildToolsVersion", "getBuildToolsVersion", "()Ljava/lang/String;", "setBuildToolsVersion", "(Ljava/lang/String;)V", "compileSdkVersion", "getCompileSdkVersion", "setCompileSdkVersion", "resourcePrefix", "getResourcePrefix", "setResourcePrefix", "sourceSets", "Lorg/gradle/api/NamedDomainObjectContainer;", "Lcom/android/build/api/sourcesets/AndroidSourceSet;", "getSourceSets", "()Lorg/gradle/api/NamedDomainObjectContainer;", "transforms", "", "Lcom/android/build/api/transform/Transform;", "getTransforms", "()Ljava/util/List;", "transformsDependencies", "", "getTransformsDependencies", "registerTransform", "", "transform", "dependencies", "", "(Lcom/android/build/api/transform/Transform;[Ljava/lang/Object;)V", "apiLevel", "", "action", "Lorg/gradle/api/Action;", "useLibrary", "name", "required", "", "gradle-core"})
/*    */ public final class BuildPropertiesImpl
/*    */   extends SealableObject
/*    */   implements BuildProperties
/*    */ {
/*    */   @NotNull
/*    */   private final NamedDomainObjectContainer<AndroidSourceSet> sourceSets;
/*    */   @Nullable
/*    */   private String buildToolsVersion;
/*    */   @Nullable
/*    */   private String compileSdkVersion;
/*    */   
/*    */   @NotNull
/*    */   public NamedDomainObjectContainer<AndroidSourceSet> getSourceSets()
/*    */   {
/* 35 */     return sourceSets;
/*    */   }
/*    */   
/*    */   public BuildPropertiesImpl(@NotNull DslModelData dslModelData, @NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 33 */     super(issueReporter);
/*    */     
/* 35 */     sourceSets = dslModelData.getSourceSets();
/*    */   }
/*    */   
/* 38 */   public void sourceSets(@NotNull Action<NamedDomainObjectContainer<AndroidSourceSet>> action) { Intrinsics.checkParameterIsNotNull(action, "action");action.execute(getSourceSets()); }
/*    */   
/*    */   @Nullable
/* 41 */   public String getBuildToolsVersion() { return buildToolsVersion; }
/*    */   
/* 43 */   public void setBuildToolsVersion(@Nullable String value) { if (checkSeal())
/* 44 */       buildToolsVersion = value;
/*    */   }
/*    */   
/*    */   @Nullable
/* 48 */   public String getCompileSdkVersion() { return compileSdkVersion; }
/*    */   
/* 50 */   public void setCompileSdkVersion(@Nullable String value) { if (checkSeal()) {
/* 51 */       compileSdkVersion = value;
/*    */     }
/*    */   }
/*    */   
/*    */   public void setCompileSdkVersion(int apiLevel) {
/* 56 */     setCompileSdkVersion("android-" + apiLevel);
/*    */   }
/*    */   
/*    */   public void useLibrary(@NotNull String name) {
/* 60 */     Intrinsics.checkParameterIsNotNull(name, "name");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   public void useLibrary(@NotNull String name, boolean required) {
/* 64 */     Intrinsics.checkParameterIsNotNull(name, "name");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   @Nullable
/* 68 */   public String getResourcePrefix() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   public void registerTransform(@NotNull Transform transform) {
/* 72 */     Intrinsics.checkParameterIsNotNull(transform, "transform");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   @NotNull
/* 76 */   public List<Transform> getTransforms() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str)); }
/*    */   @NotNull
/* 78 */   public List<List<Object>> getTransformsDependencies() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   public void registerTransform(@NotNull Transform transform, @NotNull Object... dependencies)
/*    */   {
/* 84 */     Intrinsics.checkParameterIsNotNull(transform, "transform");Intrinsics.checkParameterIsNotNull(dependencies, "dependencies");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   public void setResourcePrefix(@Nullable String value) {}
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.extensions.BuildPropertiesImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */