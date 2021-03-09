/*    */ package com.android.build.gradle.internal.pipeline;
/*    */ 
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import com.google.common.collect.ImmutableList.Builder;
/*    */ import com.google.common.collect.UnmodifiableIterator;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import org.gradle.api.Project;
/*    */ import org.gradle.api.file.ConfigurableFileCollection;
/*    */ import org.gradle.api.file.FileCollection;
/*    */ 
/*    */ public abstract class FilterableStreamCollection
/*    */ {
/*    */   abstract Project getProject();
/*    */   
/*    */   abstract Collection<TransformStream> getStreams();
/*    */   
/*    */   public ImmutableList<TransformStream> getStreams(StreamFilter streamFilter)
/*    */   {
/* 38 */     ImmutableList.Builder<TransformStream> streamsByType = ImmutableList.builder();
/* 39 */     for (TransformStream s : getStreams()) {
/* 40 */       if (streamFilter.accept(s.getContentTypes(), s.getScopes())) {
/* 41 */         streamsByType.add(s);
/*    */       }
/*    */     }
/*    */     
/* 45 */     return streamsByType.build();
/*    */   }
/*    */   
/*    */   public FileCollection getPipelineOutputAsFileCollection(StreamFilter streamFilter)
/*    */   {
/* 57 */     Project project = getProject();
/*    */     
/* 59 */     ImmutableList<TransformStream> streams = getStreams(streamFilter);
/* 60 */     if (streams.isEmpty()) {
/* 61 */       return project.files(new Object[0]);
/*    */     }
/*    */     
/* 64 */     if (streams.size() == 1) {
/* 65 */       return ((TransformStream)streams.get(0)).getOutputFileCollection(project, streamFilter);
/*    */     }
/*    */     
/* 69 */     ConfigurableFileCollection collection = project.files(new Object[0]);
/*    */     
/* 71 */     for (UnmodifiableIterator localUnmodifiableIterator = streams.iterator(); localUnmodifiableIterator.hasNext();) { TransformStream stream = (TransformStream)localUnmodifiableIterator.next();
/* 72 */       collection.from(new Object[] { stream.getOutputFileCollection(project, streamFilter) });
/*    */     }
/*    */     
/* 75 */     return collection;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.FilterableStreamCollection
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */