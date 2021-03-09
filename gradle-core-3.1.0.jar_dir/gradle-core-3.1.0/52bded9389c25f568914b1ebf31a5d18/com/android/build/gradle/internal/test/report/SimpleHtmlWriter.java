/*    */ package com.android.build.gradle.internal.test.report;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
/*    */ 
/*    */ public class SimpleHtmlWriter
/*    */   extends SimpleMarkupWriter
/*    */ {
/*    */   public SimpleHtmlWriter(Writer writer)
/*    */     throws IOException
/*    */   {
/* 28 */     this(writer, null);
/*    */   }
/*    */   
/*    */   public SimpleHtmlWriter(Writer writer, String indent) throws IOException {
/* 32 */     super(writer, indent);
/* 33 */     writeHtmlHeader();
/*    */   }
/*    */   
/*    */   private void writeHtmlHeader() throws IOException {
/* 37 */     writeRaw("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">");
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.SimpleHtmlWriter
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */