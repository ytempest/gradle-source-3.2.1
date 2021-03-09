/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.gradle.api.Task;
/*    */ 
/*    */ public abstract interface BinaryFileProviderTask
/*    */   extends Task
/*    */ {
/*    */   public abstract Artifact getArtifact();
/*    */   
/*    */   public static enum BinaryArtifactType
/*    */   {
/* 29 */     JAR,  JACK;
/*    */     
/*    */     private BinaryArtifactType() {}
/*    */   }
/*    */   
/*    */   public static final class Artifact
/*    */   {
/*    */     private final BinaryFileProviderTask.BinaryArtifactType binaryArtifactType;
/*    */     private final File artifactFile;
/*    */     
/*    */     public Artifact(BinaryFileProviderTask.BinaryArtifactType binaryArtifactType, File artifactFile) {
/* 40 */       this.binaryArtifactType = binaryArtifactType;
/* 41 */       this.artifactFile = artifactFile;
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.BinaryFileProviderTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */