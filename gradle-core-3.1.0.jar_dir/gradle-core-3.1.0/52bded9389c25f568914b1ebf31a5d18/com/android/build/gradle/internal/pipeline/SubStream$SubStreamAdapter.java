/*     */ package com.android.build.gradle.internal.pipeline;
/*     */ 
/*     */ import com.android.build.api.transform.Format;
/*     */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.DefaultContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.api.transform.QualifiedContent.ScopeType;
/*     */ import com.android.build.gradle.internal.InternalScope;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.gson.TypeAdapter;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.Set;
/*     */ 
/*     */ final class SubStream$SubStreamAdapter
/*     */   extends TypeAdapter<SubStream>
/*     */ {
/*     */   public void write(JsonWriter out, SubStream value)
/*     */     throws IOException
/*     */   {
/* 198 */     if (value == null) {
/* 199 */       out.nullValue();
/* 200 */       return;
/*     */     }
/* 202 */     out.beginObject();
/*     */     
/* 204 */     out.name("name").value(value.getName());
/*     */     
/* 206 */     out.name("index").value(value.getIndex());
/*     */     
/* 208 */     out.name("scopes").beginArray();
/* 209 */     Set<? super QualifiedContent.Scope> scopes = value.getScopes();
/* 210 */     for (Object scope : scopes) {
/* 211 */       out.value(scope.toString());
/*     */     }
/* 213 */     out.endArray();
/*     */     
/* 215 */     out.name("types").beginArray();
/* 216 */     for (QualifiedContent.ContentType type : value.getTypes()) {
/* 217 */       out.value(type.toString());
/*     */     }
/* 219 */     out.endArray();
/*     */     
/* 221 */     out.name("format").value(value.getFormat().toString());
/*     */     
/* 223 */     out.name("present").value(SubStream.access$100(value));
/*     */     
/* 225 */     out.endObject();
/*     */   }
/*     */   
/*     */   public SubStream read(JsonReader in) throws IOException
/*     */   {
/* 230 */     in.beginObject();
/*     */     
/* 232 */     String name = null;
/* 233 */     int index = -1;
/* 234 */     Set<QualifiedContent.ScopeType> scopes = Sets.newHashSet();
/* 235 */     Set<QualifiedContent.ContentType> types = Sets.newHashSet();
/* 236 */     Format format = null;
/* 237 */     boolean present = false;
/*     */     
/* 239 */     while (in.hasNext()) {
/* 240 */       switch (in.nextName()) {
/*     */       case "name": 
/* 242 */         name = in.nextString();
/* 243 */         break;
/*     */       case "index": 
/* 245 */         index = in.nextInt();
/* 246 */         break;
/*     */       case "scopes": 
/* 248 */         readScopes(in, scopes);
/* 249 */         break;
/*     */       case "types": 
/* 251 */         readTypes(in, types);
/* 252 */         break;
/*     */       case "format": 
/* 254 */         format = Format.valueOf(in.nextString());
/* 255 */         break;
/*     */       case "present": 
/* 257 */         present = in.nextBoolean();
/*     */       }
/*     */       
/*     */     }
/* 261 */     in.endObject();
/*     */     
/* 263 */     Preconditions.checkNotNull(name);
/* 264 */     Preconditions.checkNotNull(format);
/* 265 */     Preconditions.checkState(index >= 0);
/*     */     
/* 267 */     return new SubStream(name, index, scopes, types, format, present);
/*     */   }
/*     */   
/*     */   private static void readScopes(JsonReader in, Set<QualifiedContent.ScopeType> scopes) throws IOException
/*     */   {
/* 272 */     in.beginArray();
/* 273 */     while (in.hasNext()) {
/* 274 */       String scopeName = in.nextString();
/*     */       QualifiedContent.ScopeType scope;
/*     */       try
/*     */       {
/* 278 */         scope = QualifiedContent.Scope.valueOf(scopeName);
/*     */       } catch (IllegalArgumentException e) { QualifiedContent.ScopeType scope;
/* 280 */         scope = InternalScope.valueOf(scopeName);
/*     */       }
/*     */       
/* 283 */       scopes.add(scope);
/*     */     }
/*     */     
/* 286 */     in.endArray();
/*     */   }
/*     */   
/*     */   private static void readTypes(JsonReader in, Set<QualifiedContent.ContentType> types) throws IOException
/*     */   {
/* 291 */     in.beginArray();
/* 292 */     while (in.hasNext()) {
/* 293 */       String typeName = in.nextString();
/*     */       QualifiedContent.ContentType type;
/*     */       try
/*     */       {
/* 297 */         type = QualifiedContent.DefaultContentType.valueOf(typeName);
/*     */       } catch (IllegalArgumentException e) { QualifiedContent.ContentType type;
/* 299 */         type = ExtendedContentType.valueOf(typeName);
/*     */       }
/*     */       
/* 302 */       types.add(type);
/*     */     }
/*     */     
/* 305 */     in.endArray();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.SubStream.SubStreamAdapter
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */