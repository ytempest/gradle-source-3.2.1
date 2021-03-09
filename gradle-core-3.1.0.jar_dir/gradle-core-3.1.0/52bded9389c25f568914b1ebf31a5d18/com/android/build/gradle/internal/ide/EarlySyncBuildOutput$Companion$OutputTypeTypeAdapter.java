/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.AnchorOutputType;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.google.gson.TypeAdapter;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import java.io.IOException;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000$\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\b\000\030\0002\b\022\004\022\0020\0020\001B\005¢\006\002\020\003J\020\020\004\032\0020\0022\006\020\005\032\0020\006H\027J\034\020\007\032\0020\b2\b\020\t\032\004\030\0010\n2\b\020\013\032\004\030\0010\002H\026¨\006\f"}, d2={"Lcom/android/build/gradle/internal/ide/EarlySyncBuildOutput$Companion$OutputTypeTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/android/build/gradle/internal/scope/TaskOutputHolder$OutputType;", "()V", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "gradle-core"})
/*     */ public final class EarlySyncBuildOutput$Companion$OutputTypeTypeAdapter
/*     */   extends TypeAdapter<TaskOutputHolder.OutputType>
/*     */ {
/*     */   public void write(@Nullable JsonWriter out, @Nullable TaskOutputHolder.OutputType value)
/*     */   {
/* 168 */     throw ((Throwable)new IOException("Unexpected call to write"));
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public TaskOutputHolder.OutputType read(@NotNull JsonReader in) throws IOException {
/* 173 */     Intrinsics.checkParameterIsNotNull(in, "in");in.beginObject(); String 
/* 174 */       tmp14_11 = in.nextName();Intrinsics.checkExpressionValueIsNotNull(tmp14_11, "`in`.nextName()"); if (!StringsKt.endsWith$default(tmp14_11, "type", false, 2, null)) {
/* 175 */       throw ((Throwable)new IOException("Invalid format"));
/*     */     }
/* 177 */     String nextString = in.nextString();
/*     */     Object localObject;
/* 179 */     try { String tmp51_50 = nextString;Intrinsics.checkExpressionValueIsNotNull(tmp51_50, "nextString");localObject = TaskOutputHolder.TaskOutputType.valueOf(tmp51_50);
/*     */     } catch (IllegalArgumentException e) {
/* 181 */       String tmp68_67 = nextString;Intrinsics.checkExpressionValueIsNotNull(tmp68_67, "nextString");localObject = TaskOutputHolder.AnchorOutputType.valueOf(tmp68_67);
/*     */     }
/* 178 */     TaskOutputHolder.OutputType outputType = (TaskOutputHolder.OutputType)localObject;
/*     */     
/* 183 */     in.endObject();
/* 184 */     return outputType;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.EarlySyncBuildOutput.Companion.OutputTypeTypeAdapter
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */