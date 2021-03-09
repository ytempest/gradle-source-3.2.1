/*     */ package com.android.build.gradle.internal.test.report;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ public class SimpleMarkupWriter
/*     */   extends Writer
/*     */ {
/*  32 */   private static final String LINE_SEPARATOR = System.getProperty("line.separator");
/*     */   private final Writer output;
/*     */   
/*  35 */   private static enum Context { Outside,  Text,  CData,  StartTag,  ElementContent;
/*     */     
/*     */     private Context() {} }
/*     */   
/*  39 */   private final LinkedList<String> elements = new LinkedList();
/*  40 */   private Context context = Context.Outside;
/*     */   private int squareBrackets;
/*     */   private final String indent;
/*     */   
/*     */   protected SimpleMarkupWriter(Writer writer, String indent) throws IOException {
/*  45 */     this.indent = indent;
/*  46 */     output = writer;
/*     */   }
/*     */   
/*     */   public void write(char[] chars, int offset, int length) throws IOException
/*     */   {
/*  51 */     characters(chars, offset, length);
/*     */   }
/*     */   
/*     */   public void flush() throws IOException
/*     */   {
/*  56 */     output.flush();
/*     */   }
/*     */   
/*     */   public void close()
/*     */     throws IOException
/*     */   {}
/*     */   
/*     */   public SimpleMarkupWriter characters(char[] characters) throws IOException
/*     */   {
/*  65 */     characters(characters, 0, characters.length);
/*  66 */     return this;
/*     */   }
/*     */   
/*     */   public SimpleMarkupWriter characters(char[] characters, int start, int count) throws IOException {
/*  70 */     if (context == Context.CData) {
/*  71 */       writeCDATA(characters, start, count);
/*     */     } else {
/*  73 */       maybeStartText();
/*  74 */       writeXmlEncoded(characters, start, count);
/*     */     }
/*  76 */     return this;
/*     */   }
/*     */   
/*     */   public SimpleMarkupWriter characters(CharSequence characters) throws IOException {
/*  80 */     if (context == Context.CData) {
/*  81 */       writeCDATA(characters);
/*     */     } else {
/*  83 */       maybeStartText();
/*  84 */       writeXmlEncoded(characters);
/*     */     }
/*  86 */     return this;
/*     */   }
/*     */   
/*     */   private void maybeStartText() throws IOException {
/*  90 */     if (context == Context.Outside) {
/*  91 */       throw new IllegalStateException("Cannot write text, as there are no started elements.");
/*     */     }
/*  93 */     if (context == Context.StartTag) {
/*  94 */       writeRaw(">");
/*     */     }
/*  96 */     context = Context.Text;
/*     */   }
/*     */   
/*     */   private void maybeFinishStartTag() throws IOException {
/* 100 */     if (context == Context.StartTag) {
/* 101 */       writeRaw(">");
/* 102 */       context = Context.ElementContent;
/*     */     }
/*     */   }
/*     */   
/*     */   public SimpleMarkupWriter startElement(String name) throws IOException {
/* 107 */     if (!isValidXmlName(name)) {
/* 108 */       throw new IllegalArgumentException(String.format("Invalid element name: '%s'", new Object[] { name }));
/*     */     }
/* 110 */     if (context == Context.CData) {
/* 111 */       throw new IllegalStateException("Cannot start element, as current CDATA node has not been closed.");
/*     */     }
/* 113 */     maybeFinishStartTag();
/* 114 */     if (indent != null) {
/* 115 */       writeRaw(LINE_SEPARATOR);
/* 116 */       for (int i = 0; i < elements.size(); i++) {
/* 117 */         writeRaw(indent);
/*     */       }
/*     */     }
/* 120 */     context = Context.StartTag;
/* 121 */     elements.add(name);
/* 122 */     writeRaw("<");
/* 123 */     writeRaw(name);
/* 124 */     return this;
/*     */   }
/*     */   
/*     */   public SimpleMarkupWriter endElement() throws IOException {
/* 128 */     if (context == Context.Outside) {
/* 129 */       throw new IllegalStateException("Cannot end element, as there are no started elements.");
/*     */     }
/* 131 */     if (context == Context.CData) {
/* 132 */       throw new IllegalStateException("Cannot end element, as current CDATA node has not been closed.");
/*     */     }
/* 134 */     if (context == Context.StartTag) {
/* 135 */       writeRaw("/>");
/* 136 */       elements.removeLast();
/*     */     } else {
/* 138 */       if ((context != Context.Text) && (indent != null)) {
/* 139 */         writeRaw(LINE_SEPARATOR);
/* 140 */         for (int i = 1; i < elements.size(); i++) {
/* 141 */           writeRaw(indent);
/*     */         }
/*     */       }
/* 144 */       writeRaw("</");
/* 145 */       writeRaw((String)elements.removeLast());
/* 146 */       writeRaw(">");
/*     */     }
/* 148 */     if (elements.isEmpty()) {
/* 149 */       if (indent != null) {
/* 150 */         writeRaw(LINE_SEPARATOR);
/*     */       }
/* 152 */       output.flush();
/* 153 */       context = Context.Outside;
/*     */     } else {
/* 155 */       context = Context.ElementContent;
/*     */     }
/* 157 */     return this;
/*     */   }
/*     */   
/*     */   private void writeCDATA(char[] cdata, int offset, int count) throws IOException {
/* 161 */     int end = offset + count;
/* 162 */     for (int i = offset; i < end; i++) {
/* 163 */       writeCDATA(cdata[i]);
/*     */     }
/*     */   }
/*     */   
/*     */   private void writeCDATA(CharSequence cdata) throws IOException {
/* 168 */     int len = cdata.length();
/* 169 */     for (int i = 0; i < len; i++) {
/* 170 */       writeCDATA(cdata.charAt(i));
/*     */     }
/*     */   }
/*     */   
/*     */   private void writeCDATA(char ch) throws IOException {
/* 175 */     if (needsCDATAEscaping(ch)) {
/* 176 */       writeRaw("]]><![CDATA[>");
/* 177 */     } else if (!isLegalCharacter(ch)) {
/* 178 */       writeRaw('?');
/* 179 */     } else if (isRestrictedCharacter(ch)) {
/* 180 */       writeRaw("]]>");
/* 181 */       writeCharacterReference(ch);
/* 182 */       writeRaw("<![CDATA[");
/*     */     } else {
/* 184 */       writeRaw(ch);
/*     */     }
/*     */   }
/*     */   
/*     */   private void writeCharacterReference(char ch) throws IOException {
/* 189 */     writeRaw("&#x");
/* 190 */     writeRaw(Integer.toHexString(ch));
/* 191 */     writeRaw(";");
/*     */   }
/*     */   
/*     */   private boolean needsCDATAEscaping(char ch) {
/* 195 */     switch (ch) {
/*     */     case ']': 
/* 197 */       squareBrackets += 1;
/* 198 */       return false;
/*     */     case '>': 
/* 200 */       if (squareBrackets >= 2) {
/* 201 */         squareBrackets = 0;
/* 202 */         return true;
/*     */       }
/* 204 */       return false;
/*     */     }
/* 206 */     squareBrackets = 0;
/* 207 */     return false;
/*     */   }
/*     */   
/*     */   public SimpleMarkupWriter startCDATA() throws IOException
/*     */   {
/* 212 */     if (context == Context.CData) {
/* 213 */       throw new IllegalStateException("Cannot start CDATA node, as current CDATA node has not been closed.");
/*     */     }
/* 215 */     maybeFinishStartTag();
/* 216 */     writeRaw("<![CDATA[");
/* 217 */     context = Context.CData;
/* 218 */     squareBrackets = 0;
/* 219 */     return this;
/*     */   }
/*     */   
/*     */   public SimpleMarkupWriter endCDATA() throws IOException {
/* 223 */     if (context != Context.CData) {
/* 224 */       throw new IllegalStateException("Cannot end CDATA node, as not currently in a CDATA node.");
/*     */     }
/* 226 */     writeRaw("]]>");
/* 227 */     context = Context.Text;
/* 228 */     return this;
/*     */   }
/*     */   
/*     */   public SimpleMarkupWriter attribute(String name, String value) throws IOException {
/* 232 */     if (!isValidXmlName(name)) {
/* 233 */       throw new IllegalArgumentException(String.format("Invalid attribute name: '%s'", new Object[] { name }));
/*     */     }
/* 235 */     if (context != Context.StartTag) {
/* 236 */       throw new IllegalStateException("Cannot write attribute [" + name + ":" + value + "]. You should write start element first.");
/*     */     }
/*     */     
/* 239 */     writeRaw(" ");
/* 240 */     writeRaw(name);
/* 241 */     writeRaw("=\"");
/* 242 */     writeXmlAttributeEncoded(value);
/* 243 */     writeRaw("\"");
/* 244 */     return this;
/*     */   }
/*     */   
/*     */   private static boolean isValidXmlName(String name) {
/* 248 */     int length = name.length();
/* 249 */     if (length == 0) {
/* 250 */       return false;
/*     */     }
/* 252 */     char ch = name.charAt(0);
/* 253 */     if (!isValidNameStartChar(ch)) {
/* 254 */       return false;
/*     */     }
/* 256 */     for (int i = 1; i < length; i++) {
/* 257 */       ch = name.charAt(i);
/* 258 */       if (!isValidNameChar(ch)) {
/* 259 */         return false;
/*     */       }
/*     */     }
/* 262 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean isValidNameChar(char ch) {
/* 266 */     if (isValidNameStartChar(ch)) {
/* 267 */       return true;
/*     */     }
/* 269 */     if ((ch >= '0') && (ch <= '9')) {
/* 270 */       return true;
/*     */     }
/* 272 */     if ((ch == '-') || (ch == '.') || (ch == '·')) {
/* 273 */       return true;
/*     */     }
/* 275 */     if ((ch >= '̀') && (ch <= 'ͯ')) {
/* 276 */       return true;
/*     */     }
/* 278 */     if ((ch >= '‿') && (ch <= '⁀')) {
/* 279 */       return true;
/*     */     }
/* 281 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean isValidNameStartChar(char ch) {
/* 285 */     if ((ch >= 'A') && (ch <= 'Z')) {
/* 286 */       return true;
/*     */     }
/* 288 */     if ((ch >= 'a') && (ch <= 'z')) {
/* 289 */       return true;
/*     */     }
/* 291 */     if ((ch == ':') || (ch == '_')) {
/* 292 */       return true;
/*     */     }
/* 294 */     if ((ch >= 'À') && (ch <= 'Ö')) {
/* 295 */       return true;
/*     */     }
/* 297 */     if ((ch >= 'Ø') && (ch <= 'ö')) {
/* 298 */       return true;
/*     */     }
/* 300 */     if ((ch >= 'ø') && (ch <= '˿')) {
/* 301 */       return true;
/*     */     }
/* 303 */     if ((ch >= 'Ͱ') && (ch <= 'ͽ')) {
/* 304 */       return true;
/*     */     }
/* 306 */     if ((ch >= 'Ϳ') && (ch <= '῿')) {
/* 307 */       return true;
/*     */     }
/* 309 */     if ((ch >= '‌') && (ch <= '‍')) {
/* 310 */       return true;
/*     */     }
/* 312 */     if ((ch >= '⁰') && (ch <= '↏')) {
/* 313 */       return true;
/*     */     }
/* 315 */     if ((ch >= 'Ⰰ') && (ch <= '⿯')) {
/* 316 */       return true;
/*     */     }
/* 318 */     if ((ch >= '、') && (ch <= 55295)) {
/* 319 */       return true;
/*     */     }
/* 321 */     if ((ch >= 63744) && (ch <= 64975)) {
/* 322 */       return true;
/*     */     }
/* 324 */     if ((ch >= 65008) && (ch <= 65533)) {
/* 325 */       return true;
/*     */     }
/* 327 */     return false;
/*     */   }
/*     */   
/*     */   private void writeRaw(char c) throws IOException {
/* 331 */     output.write(c);
/*     */   }
/*     */   
/*     */   private boolean isLegalCharacter(char c) {
/* 335 */     if (c == 0)
/* 336 */       return false;
/* 337 */     if (c <= 55295)
/* 338 */       return true;
/* 339 */     if (c < 57344)
/* 340 */       return false;
/* 341 */     if (c <= 65533) {
/* 342 */       return true;
/*     */     }
/* 344 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isRestrictedCharacter(char c) {
/* 348 */     if ((c == '\t') || (c == '\n') || (c == '\r') || (c == ''))
/* 349 */       return false;
/* 350 */     if (c <= '\037')
/* 351 */       return true;
/* 352 */     if (c < '')
/* 353 */       return false;
/* 354 */     if (c <= '') {
/* 355 */       return true;
/*     */     }
/* 357 */     return false;
/*     */   }
/*     */   
/*     */   protected void writeRaw(String message) throws IOException {
/* 361 */     output.write(message);
/*     */   }
/*     */   
/*     */   private void writeXmlEncoded(char[] message, int offset, int count) throws IOException {
/* 365 */     int end = offset + count;
/* 366 */     for (int i = offset; i < end; i++) {
/* 367 */       writeXmlEncoded(message[i]);
/*     */     }
/*     */   }
/*     */   
/*     */   private void writeXmlAttributeEncoded(CharSequence message) throws IOException {
/* 372 */     assert (message != null);
/* 373 */     int len = message.length();
/* 374 */     for (int i = 0; i < len; i++) {
/* 375 */       writeXmlAttributeEncoded(message.charAt(i));
/*     */     }
/*     */   }
/*     */   
/*     */   private void writeXmlAttributeEncoded(char ch) throws IOException {
/* 380 */     if (ch == '\t') {
/* 381 */       writeRaw("&#9;");
/* 382 */     } else if (ch == '\n') {
/* 383 */       writeRaw("&#10;");
/* 384 */     } else if (ch == '\r') {
/* 385 */       writeRaw("&#13;");
/*     */     } else {
/* 387 */       writeXmlEncoded(ch);
/*     */     }
/*     */   }
/*     */   
/*     */   private void writeXmlEncoded(CharSequence message) throws IOException {
/* 392 */     assert (message != null);
/* 393 */     int len = message.length();
/* 394 */     for (int i = 0; i < len; i++) {
/* 395 */       writeXmlEncoded(message.charAt(i));
/*     */     }
/*     */   }
/*     */   
/*     */   private void writeXmlEncoded(char ch) throws IOException {
/* 400 */     if (ch == '<') {
/* 401 */       writeRaw("&lt;");
/* 402 */     } else if (ch == '>') {
/* 403 */       writeRaw("&gt;");
/* 404 */     } else if (ch == '&') {
/* 405 */       writeRaw("&amp;");
/* 406 */     } else if (ch == '"') {
/* 407 */       writeRaw("&quot;");
/* 408 */     } else if (!isLegalCharacter(ch)) {
/* 409 */       writeRaw('?');
/* 410 */     } else if (isRestrictedCharacter(ch)) {
/* 411 */       writeCharacterReference(ch);
/*     */     } else {
/* 413 */       writeRaw(ch);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.test.report.SimpleMarkupWriter
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */