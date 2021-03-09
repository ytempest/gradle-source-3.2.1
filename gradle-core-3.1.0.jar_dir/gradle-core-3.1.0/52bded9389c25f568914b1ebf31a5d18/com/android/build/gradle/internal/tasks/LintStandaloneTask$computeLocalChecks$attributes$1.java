/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts;
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.gradle.api.attributes.AttributeContainer;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2={"<anonymous>", "", "container", "Lorg/gradle/api/attributes/AttributeContainer;", "execute"})
/*    */ final class LintStandaloneTask$computeLocalChecks$attributes$1<T>
/*    */   implements Action<AttributeContainer>
/*    */ {
/*    */   public static final 1 INSTANCE = new 1();
/*    */   
/*    */   public final void execute(@NotNull AttributeContainer container)
/*    */   {
/* 62 */     Intrinsics.checkParameterIsNotNull(container, "container");container.attribute(
/* 63 */       AndroidArtifacts.ARTIFACT_TYPE, AndroidArtifacts.ArtifactType.JAR.getType());
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.LintStandaloneTask.computeLocalChecks.attributes.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */