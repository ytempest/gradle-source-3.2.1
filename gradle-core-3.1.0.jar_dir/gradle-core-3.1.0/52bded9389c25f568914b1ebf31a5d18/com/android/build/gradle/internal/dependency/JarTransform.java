/*    */ package com.android.build.gradle.internal.dependency;
/*    */ 
/*    */ import com.android.build.gradle.internal.publishing.AndroidArtifacts.ArtifactType;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import java.io.File;
/*    */ import java.util.List;
/*    */ import javax.inject.Inject;
/*    */ import org.gradle.api.artifacts.transform.ArtifactTransform;
/*    */ 
/*    */ public class JarTransform
/*    */   extends ArtifactTransform
/*    */ {
/*    */   public static String[] getTransformTargets()
/*    */   {
/* 34 */     return new String[] { AndroidArtifacts.ArtifactType.CLASSES.getType(), AndroidArtifacts.ArtifactType.JAVA_RES.getType() };
/*    */   }
/*    */   
/*    */   public List<File> transform(File file)
/*    */   {
/* 42 */     return ImmutableList.of(file);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.JarTransform
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */