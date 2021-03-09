/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import com.google.gson.TypeAdapter;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import java.io.IOException;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000$\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\b\000\030\0002\b\022\004\022\0020\0020\001B\005¢\006\002\020\003J\020\020\004\032\0020\0022\006\020\005\032\0020\006H\027J\030\020\007\032\0020\b2\006\020\t\032\0020\n2\006\020\013\032\0020\002H\027¨\006\f"}, d2={"Lcom/android/build/gradle/internal/scope/ExistingBuildElements$OutputTypeTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/android/build/gradle/internal/scope/TaskOutputHolder$OutputType;", "()V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "gradle-core"})
/*     */ public final class ExistingBuildElements$OutputTypeTypeAdapter
/*     */   extends TypeAdapter<TaskOutputHolder.OutputType>
/*     */ {
/*     */   public void write(@NotNull JsonWriter out, @NotNull TaskOutputHolder.OutputType value)
/*     */     throws IOException
/*     */   {
/* 251 */     Intrinsics.checkParameterIsNotNull(out, "out");Intrinsics.checkParameterIsNotNull(value, "value");out.beginObject();
/* 252 */     out.name("type").value(value.name());
/* 253 */     out.endObject();
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public TaskOutputHolder.OutputType read(@NotNull JsonReader reader) throws IOException {
/* 258 */     Intrinsics.checkParameterIsNotNull(reader, "reader");reader.beginObject(); String 
/* 259 */       tmp14_11 = reader.nextName();Intrinsics.checkExpressionValueIsNotNull(tmp14_11, "reader.nextName()"); if (!StringsKt.endsWith$default(tmp14_11, "type", false, 2, null)) {
/* 260 */       throw ((Throwable)new IOException("Invalid format"));
/*     */     }
/* 262 */     String nextString = reader.nextString();
/*     */     Object localObject;
/* 264 */     try { String tmp51_50 = nextString;Intrinsics.checkExpressionValueIsNotNull(tmp51_50, "nextString");localObject = TaskOutputHolder.TaskOutputType.valueOf(tmp51_50);
/*     */     } catch (IllegalArgumentException e) {
/* 266 */       String tmp68_67 = nextString;Intrinsics.checkExpressionValueIsNotNull(tmp68_67, "nextString");localObject = TaskOutputHolder.AnchorOutputType.valueOf(tmp68_67);
/*     */     }
/* 263 */     TaskOutputHolder.OutputType outputType = (TaskOutputHolder.OutputType)localObject;
/*     */     
/* 269 */     reader.endObject();
/* 270 */     return outputType;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.ExistingBuildElements.OutputTypeTypeAdapter
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */