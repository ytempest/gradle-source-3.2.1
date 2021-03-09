/*    */ package com.android.build.gradle.internal.api.sourcesets;
/*    */ 
/*    */ import com.google.common.collect.ImmutableMap;
/*    */ import java.util.Map;
/*    */ import java.util.function.Function;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.file.ConfigurableFileTree;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\020\n\000\n\002\030\002\n\000\n\002\020\000\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2={"<anonymous>", "Lorg/gradle/api/file/ConfigurableFileTree;", "sourceDir", "", "kotlin.jvm.PlatformType", "apply"})
/*    */ final class DefaultAndroidSourceDirectorySet$sourceDirectoryTrees$1<T, R>
/*    */   implements Function<T, R>
/*    */ {
/*    */   @NotNull
/*    */   public final ConfigurableFileTree apply(Object sourceDir)
/*    */   {
/* 87 */     ImmutableMap tmp31_28 = ImmutableMap.of(
/* 88 */       "dir", sourceDir, 
/* 89 */       "includes", this$0.getIncludes(), 
/* 90 */       "excludes", this$0.getExcludes());Intrinsics.checkExpressionValueIsNotNull(tmp31_28, "ImmutableMap.of(\n       …    \"excludes\", excludes)");return DefaultAndroidSourceDirectorySet.access$getFilesProvider$p(this$0).fileTree((Map)tmp31_28);
/*    */   }
/*    */   
/*    */   DefaultAndroidSourceDirectorySet$sourceDirectoryTrees$1(DefaultAndroidSourceDirectorySet paramDefaultAndroidSourceDirectorySet) {}
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.sourcesets.DefaultAndroidSourceDirectorySet.sourceDirectoryTrees.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */