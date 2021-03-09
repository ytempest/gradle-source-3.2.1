/*     */ package com.android.build.gradle.internal.test.report;
/*     */ 
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.io.ByteStreams;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Writer;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import org.gradle.reporting.ReportRenderer;
/*     */ 
/*     */ public class HtmlReportRenderer
/*     */ {
/*  35 */   private final Set<URL> resources = new HashSet();
/*     */   
/*     */   public void requireResource(URL resource) {
/*  38 */     resources.add(resource);
/*     */   }
/*     */   
/*     */   public <T> TextReportRenderer<T> renderer(ReportRenderer<T, SimpleHtmlWriter> renderer) {
/*  42 */     return renderer(new TextReportRendererImpl(renderer, null));
/*     */   }
/*     */   
/*     */   public <T> TextReportRenderer<T> renderer(final TextReportRendererImpl<T> renderer) {
/*  46 */     new TextReportRenderer()
/*     */     {
/*     */       protected void writeTo(T model, Writer out) throws Exception {
/*  49 */         renderer.writeTo(model, out);
/*     */       }
/*     */       
/*     */       public void writeTo(T model, File file)
/*     */       {
/*  54 */         super.writeTo(model, file);
/*  55 */         for (URL resource : resources) {
/*  56 */           String name = HtmlReportRenderer.substringAfterLast(resource.getPath(), "/");
/*  57 */           String type = HtmlReportRenderer.substringAfterLast(resource.getPath(), ".");
/*  58 */           File destFile = new File(file.getParentFile(), String.format("%s/%s", new Object[] { type, name }));
/*  59 */           if (!destFile.exists()) {
/*  60 */             destFile.getParentFile().mkdirs();
/*     */             try {
/*  62 */               URLConnection urlConnection = resource.openConnection();
/*  63 */               urlConnection.setUseCaches(false);
/*  64 */               InputStream inputStream = null;
/*     */               try {
/*  66 */                 inputStream = urlConnection.getInputStream();
/*  67 */                 OutputStream outputStream = null;
/*     */                 try {
/*  69 */                   outputStream = new BufferedOutputStream(new FileOutputStream(destFile));
/*     */                   
/*  71 */                   ByteStreams.copy(inputStream, outputStream);
/*     */                 }
/*     */                 finally {}
/*     */               }
/*     */               finally
/*     */               {
/*  78 */                 if (inputStream != null) {
/*  79 */                   inputStream.close();
/*     */                 }
/*     */               }
/*     */             }
/*     */             catch (IOException e) {
/*  84 */               throw new RuntimeException(e);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   private static class TextReportRendererImpl<T> extends TextReportRenderer<T> {
/*     */     private final ReportRenderer<T, SimpleHtmlWriter> delegate;
/*     */     
/*     */     private TextReportRendererImpl(ReportRenderer<T, SimpleHtmlWriter> delegate) {
/*  96 */       this.delegate = delegate;
/*     */     }
/*     */     
/*     */     protected void writeTo(T model, Writer writer) throws Exception
/*     */     {
/* 101 */       SimpleHtmlWriter htmlWriter = new SimpleHtmlWriter(writer, "");
/* 102 */       htmlWriter.startElement("html");
/* 103 */       delegate.render(model, htmlWriter);
/* 104 */       htmlWriter.endElement();
/*     */     }
/*     */   }
/*     */   
/*     */   public static String substringAfterLast(String string, String separator)
/*     */   {
/* 121 */     Preconditions.checkNotNull(string);
/* 122 */     Preconditions.checkNotNull(separator);
/* 123 */     int pos = string.lastIndexOf(separator);
/* 124 */     if ((pos == -1) || (pos == string.length() - separator.length())) {
/* 125 */       return "";
/*     */     }
/* 127 */     return string.substring(pos + separator.length());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.HtmlReportRenderer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */