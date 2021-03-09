/*    */ package com.android.build.gradle.internal.feature;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.file.FileVisitDetails;
/*    */ import org.gradle.api.file.RelativePath;
/*    */ import org.gradle.api.file.ReproducibleFileVisitor;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000!\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002*\001\000\b\n\030\0002\0020\001B\005¢\006\002\020\002J\b\020\003\032\0020\004H\026J\020\020\005\032\0020\0062\006\020\007\032\0020\bH\026J\020\020\t\032\0020\0062\006\020\007\032\0020\bH\026¨\006\n"}, d2={"com/android/build/gradle/internal/feature/BundleFeatureClasses$merge$collector$1", "Lorg/gradle/api/file/ReproducibleFileVisitor;", "(Ljava/util/HashMap;)V", "isReproducibleFileOrder", "", "visitDir", "", "fileVisitDetails", "Lorg/gradle/api/file/FileVisitDetails;", "visitFile", "gradle-core"})
/*    */ public final class BundleFeatureClasses$merge$collector$1
/*    */   implements ReproducibleFileVisitor
/*    */ {
/* 57 */   public boolean isReproducibleFileOrder() { return true; }
/*    */   
/* 59 */   public void visitFile(@NotNull FileVisitDetails fileVisitDetails) { Intrinsics.checkParameterIsNotNull(fileVisitDetails, "fileVisitDetails"); RelativePath tmp16_11 = fileVisitDetails.getRelativePath();Intrinsics.checkExpressionValueIsNotNull(tmp16_11, "fileVisitDetails.relativePath");$files.put(tmp16_11.getPathString(), fileVisitDetails.getFile());
/*    */   }
/*    */   
/* 62 */   public void visitDir(@NotNull FileVisitDetails fileVisitDetails) { Intrinsics.checkParameterIsNotNull(fileVisitDetails, "fileVisitDetails"); }
/*    */   
/*    */   BundleFeatureClasses$merge$collector$1(HashMap $captured_local_variable$0) {}
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.feature.BundleFeatureClasses.merge.collector.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */