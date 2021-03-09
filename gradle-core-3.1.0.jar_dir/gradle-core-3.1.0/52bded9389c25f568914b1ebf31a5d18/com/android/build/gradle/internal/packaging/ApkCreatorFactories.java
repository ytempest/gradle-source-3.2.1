/*    */ package com.android.build.gradle.internal.packaging;
/*    */ 
/*    */ import com.android.apkzlib.zfile.ApkCreatorFactory;
/*    */ import com.android.apkzlib.zfile.ApkZFileCreatorFactory;
/*    */ import com.android.apkzlib.zip.ZFileOptions;
/*    */ import com.android.apkzlib.zip.compress.BestAndDefaultDeflateExecutorCompressor;
/*    */ import com.android.apkzlib.zip.compress.DeflateExecutionCompressor;
/*    */ import com.android.build.gradle.AndroidGradleOptions;
/*    */ import java.util.concurrent.LinkedBlockingDeque;
/*    */ import java.util.concurrent.ThreadPoolExecutor;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import org.gradle.api.Project;
/*    */ 
/*    */ public final class ApkCreatorFactories
/*    */ {
/*    */   private static final long BACKGROUND_THREAD_DISCARD_TIME_MS = 100L;
/*    */   private static final int MAXIMUM_COMPRESSION_THREADS = 2;
/*    */   
/*    */   public static ApkCreatorFactory fromProjectProperties(Project project, boolean debuggableBuild)
/*    */   {
/* 69 */     boolean keepTimestamps = AndroidGradleOptions.keepTimestampsInApk(project);
/*    */     
/* 71 */     ZFileOptions options = new ZFileOptions();
/* 72 */     options.setNoTimestamps(!keepTimestamps);
/* 73 */     options.setCoverEmptySpaceUsingExtraField(true);
/*    */     
/* 75 */     ThreadPoolExecutor compressionExecutor = new ThreadPoolExecutor(0, 2, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque());
/*    */     
/* 83 */     if (debuggableBuild) {
/* 84 */       options.setCompressor(new DeflateExecutionCompressor(compressionExecutor, options
/*    */       
/* 87 */         .getTracker(), 1));
/*    */     }
/*    */     else {
/* 90 */       options.setCompressor(new BestAndDefaultDeflateExecutorCompressor(compressionExecutor, options
/*    */       
/* 93 */         .getTracker(), 1.0D));
/*    */       
/* 95 */       options.setAutoSortFiles(true);
/*    */     }
/*    */     
/* 98 */     return new ApkZFileCreatorFactory(options);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.packaging.ApkCreatorFactories
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */