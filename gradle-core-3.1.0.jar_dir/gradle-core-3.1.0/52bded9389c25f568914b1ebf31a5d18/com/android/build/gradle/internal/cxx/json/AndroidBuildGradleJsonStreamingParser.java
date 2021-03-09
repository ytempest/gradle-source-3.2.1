/*     */ package com.android.build.gradle.internal.cxx.json;
/*     */ 
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonToken;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class AndroidBuildGradleJsonStreamingParser
/*     */   implements Closeable
/*     */ {
/*     */   private final JsonReader reader;
/*     */   private final AndroidBuildGradleJsonStreamingVisitor visitor;
/*     */   
/*     */   public AndroidBuildGradleJsonStreamingParser(JsonReader reader, AndroidBuildGradleJsonStreamingVisitor visitor)
/*     */   {
/*  36 */     this.reader = reader;
/*  37 */     this.visitor = visitor;
/*     */   }
/*     */   
/*     */   public void parse() throws IOException
/*     */   {
/*  42 */     reader.beginObject();
/*  43 */     while (reader.hasNext()) {
/*  44 */       String name = reader.nextName();
/*  45 */       switch (name) {
/*     */       case "buildFiles": 
/*  47 */         parseBuildFiles();
/*  48 */         break;
/*     */       case "cleanCommands": 
/*  50 */         parseCleanCommands();
/*  51 */         break;
/*     */       case "cFileExtensions": 
/*  53 */         parseCFileExtensions();
/*  54 */         break;
/*     */       case "cppFileExtensions": 
/*  56 */         parseCppFileExtensions();
/*  57 */         break;
/*     */       case "libraries": 
/*  59 */         parseLibraries();
/*  60 */         break;
/*     */       case "toolchains": 
/*  62 */         parseToolchains();
/*  63 */         break;
/*     */       default: 
/*  65 */         parseUnknown();
/*     */       }
/*     */       
/*     */     }
/*  69 */     reader.endObject();
/*     */   }
/*     */   
/*     */   private void parseUnknown()
/*     */     throws IOException
/*     */   {
/*  79 */     JsonToken peek = reader.peek();
/*  80 */     switch (peek) {
/*     */     case BEGIN_OBJECT: 
/*  82 */       parseUnknownObject();
/*  83 */       break;
/*     */     case BEGIN_ARRAY: 
/*  85 */       parseUnknownArray();
/*  86 */       break;
/*     */     case STRING: 
/*  88 */       reader.nextString();
/*  89 */       break;
/*     */     case NAME: 
/*  91 */       reader.nextName();
/*  92 */       break;
/*     */     case NULL: 
/*  94 */       reader.nextNull();
/*  95 */       break;
/*     */     case NUMBER: 
/*  97 */       reader.nextString();
/*  98 */       break;
/*     */     case BOOLEAN: 
/* 100 */       reader.nextBoolean();
/* 101 */       break;
/*     */     
/*     */     default: 
/* 107 */       throw new RuntimeException(String.format("Unexpected: Saw Gson token '%s' while parsing new and unrecognized Json section. ", new Object[] {peek
/*     */       
/* 110 */         .toString() }));
/*     */     }
/*     */   }
/*     */   
/*     */   private void parseUnknownArray() throws IOException {
/* 115 */     reader.beginArray();
/* 116 */     while (reader.hasNext()) {
/* 117 */       parseUnknown();
/*     */     }
/* 119 */     reader.endArray();
/*     */   }
/*     */   
/*     */   private void parseUnknownObject() throws IOException {
/* 123 */     reader.beginObject();
/* 124 */     while (reader.hasNext()) {
/* 125 */       parseUnknown();
/*     */     }
/* 127 */     reader.endObject();
/*     */   }
/*     */   
/*     */   private void parseLibraryObject() throws IOException {
/* 131 */     reader.beginObject();
/* 132 */     while (reader.hasNext()) {
/* 133 */       String name = reader.nextName();
/* 134 */       switch (name) {
/*     */       case "abi": 
/* 136 */         visitor.visitLibraryAbi(reader.nextString());
/* 137 */         break;
/*     */       case "artifactName": 
/* 139 */         visitor.visitLibraryArtifactName(reader.nextString());
/* 140 */         break;
/*     */       case "buildCommand": 
/* 142 */         visitor.visitLibraryBuildCommand(reader.nextString());
/* 143 */         break;
/*     */       case "buildType": 
/* 145 */         visitor.visitLibraryBuildType(reader.nextString());
/* 146 */         break;
/*     */       case "output": 
/* 148 */         visitor.visitLibraryOutput(reader.nextString());
/* 149 */         break;
/*     */       case "toolchain": 
/* 151 */         visitor.visitLibraryToolchain(reader.nextString());
/* 152 */         break;
/*     */       case "groupName": 
/* 154 */         visitor.visitLibraryGroupName(reader.nextString());
/* 155 */         break;
/*     */       case "files": 
/* 157 */         parseLibraryFiles();
/* 158 */         break;
/*     */       case "runtimeFiles": 
/* 160 */         parseLibraryRuntimeFiles();
/* 161 */         break;
/*     */       default: 
/* 163 */         parseUnknown();
/*     */       }
/*     */       
/*     */     }
/* 167 */     reader.endObject();
/*     */   }
/*     */   
/*     */   private void parseToolchainObject() throws IOException {
/* 171 */     reader.beginObject();
/* 172 */     while (reader.hasNext()) {
/* 173 */       String name = reader.nextName();
/* 174 */       switch (name) {
/*     */       case "cCompilerExecutable": 
/* 176 */         visitor.visitToolchainCCompilerExecutable(reader.nextString());
/* 177 */         break;
/*     */       case "cppCompilerExecutable": 
/* 179 */         visitor.visitToolchainCppCompilerExecutable(reader.nextString());
/* 180 */         break;
/*     */       default: 
/* 182 */         parseUnknown();
/*     */       }
/*     */       
/*     */     }
/* 186 */     reader.endObject();
/*     */   }
/*     */   
/*     */   private void parseLibraryFileObject() throws IOException {
/* 190 */     reader.beginObject();
/* 191 */     while (reader.hasNext()) {
/* 192 */       String name = reader.nextName();
/* 193 */       switch (name) {
/*     */       case "flags": 
/* 195 */         visitor.visitLibraryFileFlags(reader.nextString());
/* 196 */         break;
/*     */       case "src": 
/* 198 */         visitor.visitLibraryFileSrc(reader.nextString());
/* 199 */         break;
/*     */       case "workingDirectory": 
/* 201 */         visitor.visitLibraryFileWorkingDirectory(reader.nextString());
/* 202 */         break;
/*     */       default: 
/* 204 */         parseUnknown();
/*     */       }
/*     */       
/*     */     }
/* 208 */     reader.endObject();
/*     */   }
/*     */   
/*     */   private void parseBuildFiles() throws IOException {
/* 212 */     reader.beginArray();
/* 213 */     while (reader.hasNext()) {
/* 214 */       JsonToken peek = reader.peek();
/* 215 */       switch (reader.peek()) {
/*     */       case STRING: 
/* 217 */         visitor.visitBuildFile(reader.nextString());
/* 218 */         break;
/*     */       case BEGIN_OBJECT: 
/* 220 */         reader.beginObject();
/* 221 */         String name = reader.nextName();
/* 222 */         switch (name) {
/*     */         case "path": 
/* 224 */           visitor.visitBuildFile(reader.nextString());
/* 225 */           break;
/*     */         default: 
/* 227 */           parseUnknown();
/*     */         }
/*     */         
/* 230 */         reader.endObject();
/* 231 */         break;
/*     */       default: 
/* 233 */         parseUnknown();
/*     */       }
/*     */       
/*     */     }
/* 237 */     reader.endArray();
/*     */   }
/*     */   
/*     */   private void parseCleanCommands() throws IOException {
/* 241 */     reader.beginArray();
/* 242 */     while (reader.hasNext()) {
/* 243 */       String value = reader.nextString();
/* 244 */       visitor.visitCleanCommands(value);
/*     */     }
/* 246 */     reader.endArray();
/*     */   }
/*     */   
/*     */   private void parseCFileExtensions() throws IOException {
/* 250 */     reader.beginArray();
/* 251 */     while (reader.hasNext()) {
/* 252 */       String value = reader.nextString();
/* 253 */       visitor.visitCFileExtensions(value);
/*     */     }
/* 255 */     reader.endArray();
/*     */   }
/*     */   
/*     */   private void parseCppFileExtensions() throws IOException {
/* 259 */     reader.beginArray();
/* 260 */     while (reader.hasNext()) {
/* 261 */       String value = reader.nextString();
/* 262 */       visitor.visitCppFileExtensions(value);
/*     */     }
/* 264 */     reader.endArray();
/*     */   }
/*     */   
/*     */   private void parseLibraries() throws IOException {
/* 268 */     reader.beginObject();
/* 269 */     while (reader.hasNext()) {
/* 270 */       String name = reader.nextName();
/* 271 */       visitor.beginLibrary(name);
/* 272 */       parseLibraryObject();
/* 273 */       visitor.endLibrary();
/*     */     }
/* 275 */     reader.endObject();
/*     */   }
/*     */   
/*     */   private void parseToolchains() throws IOException {
/* 279 */     reader.beginObject();
/* 280 */     while (reader.hasNext()) {
/* 281 */       String name = reader.nextName();
/* 282 */       visitor.beginToolchain(name);
/* 283 */       parseToolchainObject();
/* 284 */       visitor.endToolchain();
/*     */     }
/* 286 */     reader.endObject();
/*     */   }
/*     */   
/*     */   private void parseLibraryFiles() throws IOException {
/* 290 */     reader.beginArray();
/* 291 */     while (reader.hasNext()) {
/* 292 */       visitor.beginLibraryFile();
/* 293 */       parseLibraryFileObject();
/* 294 */       visitor.endLibraryFile();
/*     */     }
/* 296 */     reader.endArray();
/*     */   }
/*     */   
/*     */   private void parseLibraryRuntimeFiles() throws IOException {
/* 300 */     reader.beginArray();
/* 301 */     while (reader.hasNext()) {
/* 302 */       visitor.visitLibraryRuntimeFile(reader.nextString());
/*     */     }
/* 304 */     reader.endArray();
/*     */   }
/*     */   
/*     */   public void close() throws IOException
/*     */   {
/* 309 */     reader.close();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.cxx.json.AndroidBuildGradleJsonStreamingParser
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */