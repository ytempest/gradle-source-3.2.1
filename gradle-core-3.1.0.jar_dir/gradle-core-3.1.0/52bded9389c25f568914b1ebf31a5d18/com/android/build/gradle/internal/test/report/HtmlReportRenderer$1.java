/*    */ package com.android.build.gradle.internal.test.report;
/*    */ 
/*    */ import com.google.common.io.ByteStreams;
/*    */ import java.io.BufferedOutputStream;
/*    */ import java.io.File;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import java.io.Writer;
/*    */ import java.net.URL;
/*    */ import java.net.URLConnection;
/*    */ 
/*    */ class HtmlReportRenderer$1
/*    */   extends TextReportRenderer<T>
/*    */ {
/*    */   HtmlReportRenderer$1(HtmlReportRenderer this$0, HtmlReportRenderer.TextReportRendererImpl paramTextReportRendererImpl) {}
/*    */   
/*    */   protected void writeTo(T model, Writer out)
/*    */     throws Exception
/*    */   {
/* 49 */     val$renderer.writeTo(model, out);
/*    */   }
/*    */   
/*    */   public void writeTo(T model, File file)
/*    */   {
/* 54 */     super.writeTo(model, file);
/* 55 */     for (URL resource : HtmlReportRenderer.access$100(this$0)) {
/* 56 */       String name = HtmlReportRenderer.substringAfterLast(resource.getPath(), "/");
/* 57 */       String type = HtmlReportRenderer.substringAfterLast(resource.getPath(), ".");
/* 58 */       File destFile = new File(file.getParentFile(), String.format("%s/%s", new Object[] { type, name }));
/* 59 */       if (!destFile.exists()) {
/* 60 */         destFile.getParentFile().mkdirs();
/*    */         try {
/* 62 */           URLConnection urlConnection = resource.openConnection();
/* 63 */           urlConnection.setUseCaches(false);
/* 64 */           InputStream inputStream = null;
/*    */           try {
/* 66 */             inputStream = urlConnection.getInputStream();
/* 67 */             OutputStream outputStream = null;
/*    */             try {
/* 69 */               outputStream = new BufferedOutputStream(new FileOutputStream(destFile));
/*    */               
/* 71 */               ByteStreams.copy(inputStream, outputStream);
/*    */             }
/*    */             finally {}
/*    */           }
/*    */           finally
/*    */           {
/* 78 */             if (inputStream != null) {
/* 79 */               inputStream.close();
/*    */             }
/*    */           }
/*    */         }
/*    */         catch (IOException e) {
/* 84 */           throw new RuntimeException(e);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.HtmlReportRenderer.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */