/*    */ package com.android.build.gradle.internal.cxx.json;
/*    */ 
/*    */ import com.google.gson.TypeAdapter;
/*    */ import com.google.gson.stream.JsonReader;
/*    */ import com.google.gson.stream.JsonWriter;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class PlainFileGsonTypeAdaptor
/*    */   extends TypeAdapter<File>
/*    */ {
/*    */   public void write(JsonWriter jsonWriter, File file)
/*    */     throws IOException
/*    */   {
/* 31 */     if ((file == null) || (file.getPath() == null)) {
/* 32 */       jsonWriter.nullValue();
/* 33 */       return;
/*    */     }
/* 35 */     jsonWriter.value(file.getPath());
/*    */   }
/*    */   
/*    */   public File read(JsonReader jsonReader) throws IOException
/*    */   {
/* 40 */     String path = jsonReader.nextString();
/* 41 */     return new File(path);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.cxx.json.PlainFileGsonTypeAdaptor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */