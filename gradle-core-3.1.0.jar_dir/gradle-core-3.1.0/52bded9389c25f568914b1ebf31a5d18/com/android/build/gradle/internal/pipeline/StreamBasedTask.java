/*    */ package com.android.build.gradle.internal.pipeline;
/*    */ 
/*    */ import android.databinding.tool.util.Preconditions;
/*    */ import com.android.build.gradle.internal.tasks.AndroidBuilderTask;
/*    */ import com.google.common.collect.Iterables;
/*    */ import java.io.File;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import org.gradle.api.internal.TaskInputsInternal;
/*    */ import org.gradle.api.tasks.Optional;
/*    */ import org.gradle.api.tasks.OutputDirectory;
/*    */ import org.gradle.api.tasks.PathSensitivity;
/*    */ import org.gradle.api.tasks.TaskInputFilePropertyBuilder;
/*    */ 
/*    */ public class StreamBasedTask
/*    */   extends AndroidBuilderTask
/*    */ {
/*    */   protected Collection<TransformStream> consumedInputStreams;
/*    */   protected Collection<TransformStream> referencedInputStreams;
/*    */   protected IntermediateStream outputStream;
/*    */   
/*    */   @Optional
/*    */   @OutputDirectory
/*    */   public File getStreamOutputFolder()
/*    */   {
/* 49 */     if (outputStream != null) {
/* 50 */       return outputStream.getRootLocation();
/*    */     }
/*    */     
/* 53 */     return null;
/*    */   }
/*    */   
/*    */   protected void registerConsumedAndReferencedStreamInputs()
/*    */   {
/* 69 */     Preconditions.checkNotNull(consumedInputStreams, "Consumed input streams not set.", new Object[0]);
/* 70 */     Preconditions.checkNotNull(referencedInputStreams, "Referenced input streams not set.", new Object[0]);
/*    */     
/* 72 */     List<String> inputNames = new ArrayList(consumedInputStreams.size() + referencedInputStreams.size());
/*    */     
/* 74 */     for (TransformStream stream : Iterables.concat(consumedInputStreams, referencedInputStreams))
/*    */     {
/* 79 */       getInputs().files(new Object[] { stream.getAsFileTree() }).withPathSensitivity(PathSensitivity.ABSOLUTE);
/*    */       
/* 81 */       inputNames.add(stream.getName());
/*    */     }
/*    */     
/* 85 */     Collections.sort(inputNames);
/* 86 */     getInputs().property("transformInputNames", inputNames);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.StreamBasedTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */