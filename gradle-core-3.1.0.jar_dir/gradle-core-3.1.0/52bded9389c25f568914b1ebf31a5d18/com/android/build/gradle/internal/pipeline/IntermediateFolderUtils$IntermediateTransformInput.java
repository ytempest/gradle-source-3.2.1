/*     */ package com.android.build.gradle.internal.pipeline;
/*     */ 
/*     */ import com.android.build.api.transform.Format;
/*     */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.api.transform.Status;
/*     */ import com.google.common.base.Splitter;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.common.collect.Sets.SetView;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.logging.Logging;
/*     */ 
/*     */ class IntermediateFolderUtils$IntermediateTransformInput
/*     */   extends IncrementalTransformInput
/*     */ {
/*     */   private final File inputRoot;
/* 166 */   private List<String> rootLocationSegments = null;
/*     */   
/*     */   IntermediateFolderUtils$IntermediateTransformInput(IntermediateFolderUtils this$0, File inputRoot) {
/* 169 */     this.inputRoot = inputRoot;
/*     */   }
/*     */   
/*     */   protected boolean checkRemovedFolder(Set<? super QualifiedContent.Scope> transformScopes, Set<QualifiedContent.ContentType> transformInputTypes, File file, List<String> fileSegments)
/*     */   {
/* 178 */     if (!checkRootSegments(fileSegments)) {
/* 179 */       return false;
/*     */     }
/*     */     
/* 184 */     if (fileSegments.size() < rootLocationSegments.size() + 2) {
/* 185 */       return false;
/*     */     }
/*     */     
/* 189 */     int index = rootLocationSegments.size();
/* 190 */     String foldername = (String)fileSegments.get(index);
/*     */     
/* 193 */     for (SubStream subStream : IntermediateFolderUtils.access$000(this$0)) {
/* 194 */       if ((subStream.getFilename().equals(foldername)) && 
/* 195 */         (subStream.getFormat() == Format.DIRECTORY))
/*     */       {
/* 203 */         MutableDirectoryInput folder = new MutableDirectoryInput(subStream.getName(), new File(IntermediateFolderUtils.access$100(this$0), foldername), subStream.getTypes(), subStream.getScopes());
/*     */         
/* 205 */         Logging.getLogger(TransformManager.class)
/* 206 */           .info("Tagged" + file.getAbsolutePath() + " as removed");
/* 207 */         folder.addChangedFile(file, Status.REMOVED);
/*     */         
/* 210 */         addFolderInput(folder);
/*     */         
/* 212 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 218 */     for (SubStream subStream : IntermediateFolderUtils.access$200(this$0)) {
/* 219 */       if ((subStream.getFilename().equals(foldername)) && 
/* 220 */         (subStream.getFormat() == Format.DIRECTORY))
/*     */       {
/* 223 */         if (!Sets.intersection(transformInputTypes, subStream.getTypes()).isEmpty())
/*     */         {
/* 225 */           if (!Sets.intersection(transformScopes, subStream.getScopes()).isEmpty())
/*     */           {
/* 232 */             MutableDirectoryInput folder = new MutableDirectoryInput(subStream.getName(), new File(IntermediateFolderUtils.access$100(this$0), foldername), subStream.getTypes(), subStream.getScopes());
/*     */             
/* 234 */             Logging.getLogger(TransformManager.class)
/* 235 */               .info("Tagged" + file.getAbsolutePath() + " as removed");
/* 236 */             folder.addChangedFile(file, Status.REMOVED);
/*     */             
/* 239 */             addFolderInput(folder);
/*     */           }
/*     */         }
/*     */         
/* 244 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 250 */     for (SubStream subStream : IntermediateFolderUtils.access$300(this$0)) {
/* 251 */       if ((subStream.getFilename().equals(foldername)) && 
/* 252 */         (subStream.getFormat() == Format.DIRECTORY)) {
/* 253 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 257 */     return false;
/*     */   }
/*     */   
/*     */   boolean checkRemovedJarFile(Set<? super QualifiedContent.Scope> transformScopes, Set<QualifiedContent.ContentType> transformInputTypes, File file, List<String> fileSegments)
/*     */   {
/* 266 */     if (!checkRootSegments(fileSegments)) {
/* 267 */       return false;
/*     */     }
/*     */     
/* 271 */     if (fileSegments.size() != rootLocationSegments.size() + 1) {
/* 272 */       return false;
/*     */     }
/*     */     
/* 275 */     String filename = file.getName();
/*     */     
/* 278 */     if (!filename.endsWith(".jar")) {
/* 279 */       return false;
/*     */     }
/*     */     
/* 283 */     for (SubStream subStream : IntermediateFolderUtils.access$000(this$0)) {
/* 284 */       if ((subStream.getFilename().equals(filename)) && 
/* 285 */         (subStream.getFormat() == Format.JAR))
/*     */       {
/* 287 */         addImmutableJar(new ImmutableJarInput(subStream
/*     */         
/* 289 */           .getName(), file, Status.REMOVED, subStream
/*     */           
/* 292 */           .getTypes(), subStream
/* 293 */           .getScopes()));
/* 294 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 300 */     for (SubStream subStream : IntermediateFolderUtils.access$200(this$0)) {
/* 301 */       if ((subStream.getFilename().equals(filename)) && 
/* 302 */         (subStream.getFormat() == Format.JAR))
/*     */       {
/* 305 */         if (!Sets.intersection(transformInputTypes, subStream.getTypes()).isEmpty())
/*     */         {
/* 307 */           if (!Sets.intersection(transformScopes, subStream.getScopes()).isEmpty()) {
/* 308 */             addImmutableJar(new ImmutableJarInput(subStream
/*     */             
/* 310 */               .getName(), file, Status.REMOVED, subStream
/*     */               
/* 313 */               .getTypes(), subStream
/* 314 */               .getScopes()));
/*     */           }
/*     */         }
/*     */         
/* 319 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 325 */     for (SubStream subStream : IntermediateFolderUtils.access$300(this$0)) {
/* 326 */       if ((subStream.getFilename().equals(filename)) && 
/* 327 */         (subStream.getFormat() == Format.JAR)) {
/* 328 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 332 */     return false;
/*     */   }
/*     */   
/*     */   private boolean checkRootSegments(List<String> fileSegments) {
/* 336 */     if (rootLocationSegments == null) {
/* 337 */       rootLocationSegments = Lists.newArrayList(
/* 338 */         Splitter.on(File.separatorChar).split(inputRoot.getAbsolutePath()));
/*     */     }
/*     */     
/* 341 */     if (fileSegments.size() <= rootLocationSegments.size()) {
/* 342 */       return false;
/*     */     }
/*     */     
/* 347 */     for (int i = rootLocationSegments.size() - 1; i >= 0; i--) {
/* 348 */       if (!((String)rootLocationSegments.get(i)).equals(fileSegments.get(i))) {
/* 349 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 353 */     return true;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.IntermediateFolderUtils.IntermediateTransformInput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */