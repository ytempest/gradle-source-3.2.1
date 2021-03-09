/*     */ package com.android.build.gradle.internal.pipeline;
/*     */ 
/*     */ import com.android.build.api.transform.Format;
/*     */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.DefaultContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.api.transform.QualifiedContent.ScopeType;
/*     */ import com.android.build.gradle.internal.InternalScope;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.common.io.CharSink;
/*     */ import com.google.common.io.FileWriteMode;
/*     */ import com.google.common.io.Files;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import com.google.gson.TypeAdapter;
/*     */ import com.google.gson.reflect.TypeToken;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ 
/*     */ public final class SubStream
/*     */ {
/*     */   public static final String FN_FOLDER_CONTENT = "__content__.json";
/*     */   private final String name;
/*     */   private final int index;
/*     */   private final String filename;
/*     */   private final Set<? super QualifiedContent.Scope> scopes;
/*     */   private final Set<QualifiedContent.ContentType> types;
/*     */   private final Format format;
/*     */   private final boolean present;
/*     */   
/*     */   SubStream(String name, int index, Set<? super QualifiedContent.Scope> scopes, Set<QualifiedContent.ContentType> types, Format format, boolean present)
/*     */   {
/*  75 */     this.name = name;
/*  76 */     this.index = index;
/*  77 */     this.scopes = scopes;
/*  78 */     this.types = types;
/*  79 */     this.format = format;
/*  80 */     this.present = present;
/*  81 */     filename = computeFilename();
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  86 */     return name;
/*     */   }
/*     */   
/*     */   public Set<? super QualifiedContent.Scope> getScopes()
/*     */   {
/*  91 */     return scopes;
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.ContentType> getTypes()
/*     */   {
/*  96 */     return types;
/*     */   }
/*     */   
/*     */   public Format getFormat()
/*     */   {
/* 101 */     return format;
/*     */   }
/*     */   
/*     */   public int getIndex() {
/* 105 */     return index;
/*     */   }
/*     */   
/*     */   public String getFilename() {
/* 109 */     return filename;
/*     */   }
/*     */   
/*     */   public boolean isPresent() {
/* 113 */     return present;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public static Collection<SubStream> loadSubStreams(File rootFolder)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: new 11	java/io/File
/*     */     //   3: dup
/*     */     //   4: aload_0
/*     */     //   5: ldc 13
/*     */     //   7: invokespecial 14	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
/*     */     //   10: astore_1
/*     */     //   11: aload_1
/*     */     //   12: invokevirtual 15	java/io/File:isFile	()Z
/*     */     //   15: ifne +7 -> 22
/*     */     //   18: invokestatic 16	com/google/common/collect/ImmutableList:of	()Lcom/google/common/collect/ImmutableList;
/*     */     //   21: areturn
/*     */     //   22: new 17	java/io/FileReader
/*     */     //   25: dup
/*     */     //   26: aload_1
/*     */     //   27: invokespecial 18	java/io/FileReader:<init>	(Ljava/io/File;)V
/*     */     //   30: astore_2
/*     */     //   31: aconst_null
/*     */     //   32: astore_3
/*     */     //   33: new 19	com/google/gson/GsonBuilder
/*     */     //   36: dup
/*     */     //   37: invokespecial 20	com/google/gson/GsonBuilder:<init>	()V
/*     */     //   40: astore 4
/*     */     //   42: aload 4
/*     */     //   44: ldc 12
/*     */     //   46: new 21	com/android/build/gradle/internal/pipeline/SubStream$SubStreamAdapter
/*     */     //   49: dup
/*     */     //   50: aconst_null
/*     */     //   51: invokespecial 22	com/android/build/gradle/internal/pipeline/SubStream$SubStreamAdapter:<init>	(Lcom/android/build/gradle/internal/pipeline/SubStream$1;)V
/*     */     //   54: invokevirtual 23	com/google/gson/GsonBuilder:registerTypeAdapter	(Ljava/lang/reflect/Type;Ljava/lang/Object;)Lcom/google/gson/GsonBuilder;
/*     */     //   57: pop
/*     */     //   58: aload 4
/*     */     //   60: invokevirtual 24	com/google/gson/GsonBuilder:create	()Lcom/google/gson/Gson;
/*     */     //   63: astore 5
/*     */     //   65: new 25	com/android/build/gradle/internal/pipeline/SubStream$1
/*     */     //   68: dup
/*     */     //   69: invokespecial 26	com/android/build/gradle/internal/pipeline/SubStream$1:<init>	()V
/*     */     //   72: invokevirtual 27	com/android/build/gradle/internal/pipeline/SubStream$1:getType	()Ljava/lang/reflect/Type;
/*     */     //   75: astore 6
/*     */     //   77: aload 5
/*     */     //   79: aload_2
/*     */     //   80: aload 6
/*     */     //   82: invokevirtual 28	com/google/gson/Gson:fromJson	(Ljava/io/Reader;Ljava/lang/reflect/Type;)Ljava/lang/Object;
/*     */     //   85: checkcast 29	java/util/Collection
/*     */     //   88: astore 7
/*     */     //   90: aload_2
/*     */     //   91: ifnull +29 -> 120
/*     */     //   94: aload_3
/*     */     //   95: ifnull +21 -> 116
/*     */     //   98: aload_2
/*     */     //   99: invokevirtual 30	java/io/FileReader:close	()V
/*     */     //   102: goto +18 -> 120
/*     */     //   105: astore 8
/*     */     //   107: aload_3
/*     */     //   108: aload 8
/*     */     //   110: invokevirtual 32	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
/*     */     //   113: goto +7 -> 120
/*     */     //   116: aload_2
/*     */     //   117: invokevirtual 30	java/io/FileReader:close	()V
/*     */     //   120: aload 7
/*     */     //   122: areturn
/*     */     //   123: astore 4
/*     */     //   125: aload 4
/*     */     //   127: astore_3
/*     */     //   128: aload 4
/*     */     //   130: athrow
/*     */     //   131: astore 9
/*     */     //   133: aload_2
/*     */     //   134: ifnull +29 -> 163
/*     */     //   137: aload_3
/*     */     //   138: ifnull +21 -> 159
/*     */     //   141: aload_2
/*     */     //   142: invokevirtual 30	java/io/FileReader:close	()V
/*     */     //   145: goto +18 -> 163
/*     */     //   148: astore 10
/*     */     //   150: aload_3
/*     */     //   151: aload 10
/*     */     //   153: invokevirtual 32	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
/*     */     //   156: goto +7 -> 163
/*     */     //   159: aload_2
/*     */     //   160: invokevirtual 30	java/io/FileReader:close	()V
/*     */     //   163: aload 9
/*     */     //   165: athrow
/*     */     //   166: astore_2
/*     */     //   167: new 34	java/lang/RuntimeException
/*     */     //   170: dup
/*     */     //   171: aload_2
/*     */     //   172: invokespecial 35	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
/*     */     //   175: athrow
/*     */     // Line number table:
/*     */     //   Java source line #117	-> byte code offset #0
/*     */     //   Java source line #118	-> byte code offset #11
/*     */     //   Java source line #119	-> byte code offset #18
/*     */     //   Java source line #122	-> byte code offset #22
/*     */     //   Java source line #124	-> byte code offset #33
/*     */     //   Java source line #125	-> byte code offset #42
/*     */     //   Java source line #126	-> byte code offset #58
/*     */     //   Java source line #128	-> byte code offset #65
/*     */     //   Java source line #129	-> byte code offset #77
/*     */     //   Java source line #130	-> byte code offset #90
/*     */     //   Java source line #129	-> byte code offset #120
/*     */     //   Java source line #122	-> byte code offset #123
/*     */     //   Java source line #130	-> byte code offset #131
/*     */     //   Java source line #131	-> byte code offset #167
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	176	0	rootFolder	File
/*     */     //   10	17	1	jsonFile	File
/*     */     //   30	130	2	reader	java.io.FileReader
/*     */     //   166	6	2	e	IOException
/*     */     //   32	119	3	localThrowable3	Throwable
/*     */     //   40	19	4	gsonBuilder	GsonBuilder
/*     */     //   123	6	4	localThrowable1	Throwable
/*     */     //   63	15	5	gson	Gson
/*     */     //   75	6	6	recordType	java.lang.reflect.Type
/*     */     //   105	4	8	localThrowable	Throwable
/*     */     //   131	33	9	localObject	Object
/*     */     //   148	4	10	localThrowable2	Throwable
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   98	102	105	java/lang/Throwable
/*     */     //   33	90	123	java/lang/Throwable
/*     */     //   33	90	131	finally
/*     */     //   123	133	131	finally
/*     */     //   141	145	148	java/lang/Throwable
/*     */     //   22	120	166	java/io/IOException
/*     */     //   123	166	166	java/io/IOException
/*     */   }
/*     */   
/*     */   public static void save(Collection<SubStream> subStreams, File rootFolder)
/*     */     throws IOException
/*     */   {
/* 137 */     GsonBuilder gsonBuilder = new GsonBuilder();
/* 138 */     gsonBuilder.registerTypeAdapter(SubStream.class, new SubStreamAdapter(null));
/* 139 */     Gson gson = gsonBuilder.create();
/*     */     
/* 142 */     FileUtils.mkdirs(rootFolder);
/* 143 */     Files.asCharSink(new File(rootFolder, "__content__.json"), Charsets.UTF_8, new FileWriteMode[0])
/* 144 */       .write(gson.toJson(subStreams));
/*     */   }
/*     */   
/*     */   private String computeFilename() {
/* 148 */     if (format == Format.DIRECTORY) {
/* 149 */       return Integer.toString(index);
/*     */     }
/*     */     
/* 152 */     return Integer.toString(index) + ".jar";
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 157 */     if (this == o) {
/* 158 */       return true;
/*     */     }
/* 160 */     if ((o == null) || (getClass() != o.getClass())) {
/* 161 */       return false;
/*     */     }
/* 163 */     SubStream subStream = (SubStream)o;
/* 164 */     if ((index == index) && (present == present)) {} return 
/*     */     
/* 166 */       (Objects.equals(name, name)) && 
/* 167 */       (Objects.equals(scopes, scopes)) && 
/* 168 */       (Objects.equals(types, types)) && (format == format);
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 174 */     return Objects.hash(new Object[] { name, Integer.valueOf(index), scopes, types, format, Boolean.valueOf(present) });
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 179 */     return 
/*     */     
/* 187 */       MoreObjects.toStringHelper(this).add("name", name).add("index", index).add("filename", filename).add("scopes", scopes).add("types", types).add("format", format).add("present", present).toString();
/*     */   }
/*     */   
/*     */   public SubStream duplicateWithPresent(boolean exists) {
/* 191 */     return new SubStream(name, index, scopes, types, format, exists);
/*     */   }
/*     */   
/*     */   private static final class SubStreamAdapter extends TypeAdapter<SubStream>
/*     */   {
/*     */     public void write(JsonWriter out, SubStream value) throws IOException
/*     */     {
/* 198 */       if (value == null) {
/* 199 */         out.nullValue();
/* 200 */         return;
/*     */       }
/* 202 */       out.beginObject();
/*     */       
/* 204 */       out.name("name").value(value.getName());
/*     */       
/* 206 */       out.name("index").value(value.getIndex());
/*     */       
/* 208 */       out.name("scopes").beginArray();
/* 209 */       Set<? super QualifiedContent.Scope> scopes = value.getScopes();
/* 210 */       for (Object scope : scopes) {
/* 211 */         out.value(scope.toString());
/*     */       }
/* 213 */       out.endArray();
/*     */       
/* 215 */       out.name("types").beginArray();
/* 216 */       for (QualifiedContent.ContentType type : value.getTypes()) {
/* 217 */         out.value(type.toString());
/*     */       }
/* 219 */       out.endArray();
/*     */       
/* 221 */       out.name("format").value(value.getFormat().toString());
/*     */       
/* 223 */       out.name("present").value(present);
/*     */       
/* 225 */       out.endObject();
/*     */     }
/*     */     
/*     */     public SubStream read(JsonReader in) throws IOException
/*     */     {
/* 230 */       in.beginObject();
/*     */       
/* 232 */       String name = null;
/* 233 */       int index = -1;
/* 234 */       Set<QualifiedContent.ScopeType> scopes = Sets.newHashSet();
/* 235 */       Set<QualifiedContent.ContentType> types = Sets.newHashSet();
/* 236 */       Format format = null;
/* 237 */       boolean present = false;
/*     */       
/* 239 */       while (in.hasNext()) {
/* 240 */         switch (in.nextName()) {
/*     */         case "name": 
/* 242 */           name = in.nextString();
/* 243 */           break;
/*     */         case "index": 
/* 245 */           index = in.nextInt();
/* 246 */           break;
/*     */         case "scopes": 
/* 248 */           readScopes(in, scopes);
/* 249 */           break;
/*     */         case "types": 
/* 251 */           readTypes(in, types);
/* 252 */           break;
/*     */         case "format": 
/* 254 */           format = Format.valueOf(in.nextString());
/* 255 */           break;
/*     */         case "present": 
/* 257 */           present = in.nextBoolean();
/*     */         }
/*     */         
/*     */       }
/* 261 */       in.endObject();
/*     */       
/* 263 */       Preconditions.checkNotNull(name);
/* 264 */       Preconditions.checkNotNull(format);
/* 265 */       Preconditions.checkState(index >= 0);
/*     */       
/* 267 */       return new SubStream(name, index, scopes, types, format, present);
/*     */     }
/*     */     
/*     */     private static void readScopes(JsonReader in, Set<QualifiedContent.ScopeType> scopes) throws IOException
/*     */     {
/* 272 */       in.beginArray();
/* 273 */       while (in.hasNext()) {
/* 274 */         String scopeName = in.nextString();
/*     */         QualifiedContent.ScopeType scope;
/*     */         try
/*     */         {
/* 278 */           scope = QualifiedContent.Scope.valueOf(scopeName);
/*     */         } catch (IllegalArgumentException e) { QualifiedContent.ScopeType scope;
/* 280 */           scope = InternalScope.valueOf(scopeName);
/*     */         }
/*     */         
/* 283 */         scopes.add(scope);
/*     */       }
/*     */       
/* 286 */       in.endArray();
/*     */     }
/*     */     
/*     */     private static void readTypes(JsonReader in, Set<QualifiedContent.ContentType> types) throws IOException
/*     */     {
/* 291 */       in.beginArray();
/* 292 */       while (in.hasNext()) {
/* 293 */         String typeName = in.nextString();
/*     */         QualifiedContent.ContentType type;
/*     */         try
/*     */         {
/* 297 */           type = QualifiedContent.DefaultContentType.valueOf(typeName);
/*     */         } catch (IllegalArgumentException e) { QualifiedContent.ContentType type;
/* 299 */           type = ExtendedContentType.valueOf(typeName);
/*     */         }
/*     */         
/* 302 */         types.add(type);
/*     */       }
/*     */       
/* 305 */       in.endArray();
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.pipeline.SubStream
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */