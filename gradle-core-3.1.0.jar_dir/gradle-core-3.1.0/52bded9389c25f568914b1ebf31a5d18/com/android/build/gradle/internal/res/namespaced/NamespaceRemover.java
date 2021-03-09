/*     */ package com.android.build.gradle.internal.res.namespaced;
/*     */ 
/*     */ import com.android.ide.common.res2.CompileResourceRequest;
/*     */ import com.android.ide.common.res2.QueueableResourceCompiler;
/*     */ import com.android.ide.common.xml.XmlFormatPreferences;
/*     */ import com.android.ide.common.xml.XmlFormatStyle;
/*     */ import com.android.ide.common.xml.XmlPrettyPrinter;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.android.utils.PositionXmlParser;
/*     */ import com.google.common.util.concurrent.Futures;
/*     */ import com.google.common.util.concurrent.ListenableFuture;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.OpenOption;
/*     */ import java.nio.file.Path;
/*     */ import java.util.concurrent.Future;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.io.CloseableKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.Charsets;
/*     */ import kotlin.text.StringsKt;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000B\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\b\020\003\032\0020\004H\027J\026\020\005\032\b\022\004\022\0020\0070\0062\006\020\b\032\0020\tH\027J\020\020\n\032\0020\0072\006\020\b\032\0020\tH\026J\020\020\013\032\0020\f2\006\020\r\032\0020\fH\002J\020\020\016\032\0020\0042\006\020\017\032\0020\020H\002J\032\020\021\032\0020\f2\006\020\022\032\0020\0232\b\b\002\020\024\032\0020\fH\007J\030\020\021\032\0020\0042\006\020\022\032\0020\0252\006\020\026\032\0020\025H\003¨\006\027"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/NamespaceRemover;", "Lcom/android/ide/common/res2/QueueableResourceCompiler;", "()V", "close", "", "compile", "Ljava/util/concurrent/Future;", "Ljava/io/File;", "request", "Lcom/android/ide/common/res2/CompileResourceRequest;", "compileOutputFor", "removeNamespace", "", "content", "removeNamespaces", "node", "Lorg/w3c/dom/Node;", "rewrite", "input", "Ljava/io/InputStream;", "lineSeparator", "Ljava/nio/file/Path;", "output", "gradle-core"})
/*     */ public final class NamespaceRemover
/*     */   implements QueueableResourceCompiler
/*     */ {
/*     */   @NotNull
/*     */   public Future<File> compile(@NotNull CompileResourceRequest request)
/*     */     throws Exception
/*     */   {
/*  44 */     Intrinsics.checkParameterIsNotNull(request, "request");File input = request.getInputFile();
/*  45 */     File output = compileOutputFor(request);
/*  46 */     FileUtils.mkdirs(output.getParentFile()); String 
/*     */     
/*  48 */       tmp29_26 = input.getName();Intrinsics.checkExpressionValueIsNotNull(tmp29_26, "input.name"); if (StringsKt.endsWith$default(tmp29_26, ".xml", false, 2, null))
/*     */     {
/*  50 */       Path tmp51_48 = input.toPath();Intrinsics.checkExpressionValueIsNotNull(tmp51_48, "input.toPath()"); Path tmp61_58 = output.toPath();Intrinsics.checkExpressionValueIsNotNull(tmp61_58, "output.toPath()");rewrite(tmp51_48, tmp61_58);
/*     */     }
/*     */     else {
/*  53 */       FileUtils.copyFile(input, output);
/*     */     }
/*     */     
/*  56 */     ListenableFuture tmp82_79 = Futures.immediateFuture(output);Intrinsics.checkExpressionValueIsNotNull(tmp82_79, "Futures.immediateFuture(output)");return (Future)tmp82_79;
/*     */   }
/*     */   
/*     */   @NotNull
/*  60 */   public File compileOutputFor(@NotNull CompileResourceRequest request) { Intrinsics.checkParameterIsNotNull(request, "request");File parentDir = new File(request.getOutputDirectory(), request.getInputDirectoryName());
/*  61 */     return new File(parentDir, request.getInputFile().getName());
/*     */   }
/*     */   
/*     */   public void close()
/*     */     throws IOException
/*     */   {}
/*     */   
/*     */   private final void rewrite(Path input, Path output)
/*     */     throws IOException, ParserConfigurationException, SAXException
/*     */   {
/*  74 */     Closeable localCloseable = (Closeable)new BufferedInputStream(
/*  75 */       Files.newInputStream(input, new OpenOption[0]));Throwable localThrowable1 = (Throwable)null; try { BufferedInputStream is = (BufferedInputStream)localCloseable;
/*  76 */       int $i$a$1$use; String str = rewrite$default(this, (InputStream)is, null, 2, null);Path localPath = output;Charset localCharset = Charsets.UTF_8; String tmp56_54 = str; if (tmp56_54 == null) { throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
/*     */       }
/*     */       
/*  76 */       byte[] tmp75_72 = tmp56_54.getBytes(localCharset);Intrinsics.checkExpressionValueIsNotNull(tmp75_72, "(this as java.lang.String).getBytes(charset)");byte[] arrayOfByte = tmp75_72;is = Files.write(localPath, arrayOfByte, new OpenOption[0]);
/*     */     }
/*     */     catch (Throwable localThrowable)
/*     */     {
/*  75 */       localThrowable1 = localThrowable; throw localThrowable; } finally { CloseableKt.closeFinally(localCloseable, localThrowable1);
/*     */     }
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final String rewrite(@NotNull InputStream input, @NotNull String lineSeparator)
/*     */     throws ParserConfigurationException, SAXException, IOException
/*     */   {
/*  86 */     Intrinsics.checkParameterIsNotNull(input, "input");Intrinsics.checkParameterIsNotNull(lineSeparator, "lineSeparator");Document doc = PositionXmlParser.parse(input); Document 
/*     */     
/*  88 */       tmp19_18 = doc;Intrinsics.checkExpressionValueIsNotNull(tmp19_18, "doc");removeNamespaces((Node)tmp19_18); String 
/*     */     
/*  90 */       tmp50_47 = XmlPrettyPrinter.prettyPrint(
/*  91 */       (Node)doc, 
/*  92 */       XmlFormatPreferences.defaults(), 
/*  93 */       XmlFormatStyle.get((Node)doc), 
/*  94 */       lineSeparator, 
/*  95 */       false);Intrinsics.checkExpressionValueIsNotNull(tmp50_47, "XmlPrettyPrinter.prettyP…r,\n                false)");return tmp50_47;
/*     */   }
/*     */   
/*     */   private final void removeNamespaces(Node node)
/*     */   {
/* 103 */     if (node.getNodeType() == 3)
/*     */     {
/* 106 */       String content = node.getTextContent(); String 
/* 107 */         tmp19_18 = content;Intrinsics.checkExpressionValueIsNotNull(tmp19_18, "content");String nonNamespacedContent = removeNamespace(tmp19_18);
/* 108 */       if ((Intrinsics.areEqual(content, nonNamespacedContent) ^ true)) {
/* 109 */         node.setTextContent(nonNamespacedContent);
/*     */       }
/* 111 */     } else if (node.getNodeType() == 2) {
/* 112 */       String prefix = node.getPrefix();
/* 113 */       if ((prefix != null) && (Intrinsics.areEqual(prefix, "xmlns")))
/*     */       {
/* 116 */         ns = node.getLocalName();
/*     */         
/* 119 */         if (((Intrinsics.areEqual(ns, "android") ^ true)) && ((Intrinsics.areEqual(ns, "tools") ^ true)) && ((Intrinsics.areEqual(ns, "aapt") ^ true))) {
/* 120 */           node.setTextContent("http://schemas.android.com/apk/res-auto");
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 126 */     NamedNodeMap attributes = node.getAttributes();
/* 127 */     String ns = this;NamespaceRemover $receiver = (NamespaceRemover)ns;
/* 128 */     int $i$a$1$run; int i = 0;
/* 129 */     while ((attributes != null) && (i < attributes.getLength())) {
/* 130 */       Node tmp172_167 = attributes.item(i);Intrinsics.checkExpressionValueIsNotNull(tmp172_167, "attributes.item(i)");$receiver.removeNamespaces(tmp172_167);
/* 131 */       i++;
/*     */     }
/*     */     
/* 136 */     NodeList children = node.getChildNodes();
/* 137 */     $receiver = 0; NodeList tmp202_201 = children;Intrinsics.checkExpressionValueIsNotNull(tmp202_201, "children"); int i; for (i = tmp202_201.getLength(); $receiver < i; i++) {
/* 138 */       Node tmp232_227 = children.item(i);Intrinsics.checkExpressionValueIsNotNull(tmp232_227, "children.item(i)");removeNamespaces(tmp232_227);
/*     */     }
/*     */   }
/*     */   
/*     */   private final String removeNamespace(String content)
/*     */   {
/* 154 */     if ((StringsKt.startsWith$default(content, "@", false, 2, null)) && (StringsKt.contains$default((CharSequence)content, (CharSequence)":", false, 2, null))) {
/* 155 */       String str1 = content;int i = 1;int j = StringsKt.indexOf$default((CharSequence)content, ':', 0, false, 6, null); String tmp54_53 = str1; if (tmp54_53 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); String tmp75_72 = tmp54_53.substring(i, j);Intrinsics.checkExpressionValueIsNotNull(tmp75_72, "(this as java.lang.Strin…ing(startIndex, endIndex)");String ns = tmp75_72;
/*     */       
/* 157 */       if (((Intrinsics.areEqual(ns, "android") ^ true)) && ((Intrinsics.areEqual(ns, "tools") ^ true))) {
/* 158 */         str1 = content;i = StringsKt.indexOf$default((CharSequence)content, ':', 0, false, 6, null) + 1;StringBuilder localStringBuilder = new StringBuilder().append("@"); String tmp141_140 = str1; if (tmp141_140 == null) throw new TypeCastException("null cannot be cast to non-null type java.lang.String"); String tmp160_157 = tmp141_140.substring(i);Intrinsics.checkExpressionValueIsNotNull(tmp160_157, "(this as java.lang.String).substring(startIndex)");String str2 = tmp160_157;return str2;
/*     */       }
/*     */     }
/* 161 */     return content;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.NamespaceRemover
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */