/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.api.artifact.ArtifactType;
/*     */ import com.android.build.api.artifact.BuildArtifactType;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.Reader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Unit;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.io.CloseableKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000(\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020$\n\002\030\002\n\002\020 \n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J$\020\003\032\030\022\004\022\0020\005\022\n\022\b\022\004\022\0020\0070\0060\004j\002`\b2\006\020\t\032\0020\n¨\006\013"}, d2={"Lcom/android/build/gradle/tasks/BuildArtifactReportTask$Companion;", "", "()V", "parseReport", "", "Lcom/android/build/api/artifact/ArtifactType;", "", "Lcom/android/build/gradle/tasks/BuildArtifactReportTask$BuildableArtifactData;", "Lcom/android/build/gradle/tasks/Report;", "file", "Ljava/io/File;", "gradle-core"})
/*     */ public final class BuildArtifactReportTask$Companion
/*     */ {
/*     */   @NotNull
/*     */   public final Map<ArtifactType, List<BuildArtifactReportTask.BuildableArtifactData>> parseReport(@NotNull File file)
/*     */   {
/* 131 */     Intrinsics.checkParameterIsNotNull(file, "file");Map result = (Map)new LinkedHashMap();
/* 132 */     JsonParser parser = new JsonParser();
/* 133 */     Closeable localCloseable = (Closeable)new FileReader(file);Throwable localThrowable1 = (Throwable)null; try { FileReader reader = (FileReader)localCloseable;
/* 134 */       int $i$a$1$use; JsonElement tmp61_58 = parser.parse((Reader)reader);Intrinsics.checkExpressionValueIsNotNull(tmp61_58, "parser.parse(reader)"); List history; for (Iterator localIterator1 = tmp61_58.getAsJsonObject().entrySet().iterator(); localIterator1.hasNext(); 
/*     */           
/* 144 */           result.put(BuildArtifactType.valueOf(tmp532_530), history))
/*     */       {
/* 134 */         Map.Entry localEntry1 = (Map.Entry)localIterator1.next();Map.Entry localEntry2 = localEntry1;String key = (String)localEntry2.getKey();localEntry2 = localEntry1;JsonElement value = (JsonElement)localEntry2.getValue(); JsonElement 
/*     */         
/* 136 */           tmp136_134 = value;Intrinsics.checkExpressionValueIsNotNull(tmp136_134, "value"); JsonArray tmp145_142 = tmp136_134.getAsJsonArray();Intrinsics.checkExpressionValueIsNotNull(tmp145_142, "value.asJsonArray");Iterable $receiver$iv = (Iterable)tmp145_142;
/*     */         
/*     */         int $i$f$map;
/*     */         
/* 153 */         Iterable localIterable1 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 154 */         int $i$f$mapTo; Iterable $receiver$iv$iv; Collection localCollection1; BuildArtifactReportTask.BuildableArtifactData localBuildableArtifactData3; for (Iterator localIterator2 = $receiver$iv$iv.iterator(); localIterator2.hasNext(); localCollection1.add(localBuildableArtifactData3))
/*     */         {
/* 154 */           Object item$iv$iv = localIterator2.next();
/* 155 */           JsonElement localJsonElement1 = (JsonElement)item$iv$iv;localCollection1 = destination$iv$iv;
/*     */           int $i$a$1$map;
/*     */           JsonElement it;
/* 137 */           JsonElement tmp220_218 = it;Intrinsics.checkExpressionValueIsNotNull(tmp220_218, "it");JsonObject obj = tmp220_218.getAsJsonObject(); JsonArray 
/*     */           
/* 139 */             tmp242_239 = obj.getAsJsonArray("files");Intrinsics.checkExpressionValueIsNotNull(tmp242_239, "obj.getAsJsonArray(\"files\")");Iterable localIterable2 = (Iterable)tmp242_239;BuildArtifactReportTask.BuildableArtifactData localBuildableArtifactData2 = localBuildableArtifactData1 = new com/android/build/gradle/tasks/BuildArtifactReportTask$BuildableArtifactData;
/*     */           
/*     */           int $i$f$map;
/*     */           
/* 156 */           Iterable localIterable3 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 157 */           int $i$f$mapTo; JsonElement it; for (Iterator localIterator3 = $receiver$iv$iv.iterator(); localIterator3.hasNext(); ((Collection)localObject1).add(localObject2))
/*     */           {
/* 157 */             Object item$iv$iv = localIterator3.next();
/* 158 */             JsonElement localJsonElement2 = (JsonElement)item$iv$iv;localObject1 = destination$iv$iv;
/*     */             int $i$a$1$map;
/* 140 */             JsonElement tmp325_323 = it;Intrinsics.checkExpressionValueIsNotNull(tmp325_323, "it"); JsonElement tmp339_336 = tmp325_323.getAsJsonObject().get("path");Intrinsics.checkExpressionValueIsNotNull(tmp339_336, "it.asJsonObject.get(\"path\")");localObject2 = new File(tmp339_336.getAsString());
/*     */           }
/*     */           
/* 159 */           Object localObject1 = (List)destination$iv$iv; JsonArray tmp389_386 = obj.getAsJsonArray("builtBy");Intrinsics.checkExpressionValueIsNotNull(tmp389_386, "obj.getAsJsonArray(\"builtBy\")");Iterable $receiver$iv = (Iterable)tmp389_386;localObject1 = (Collection)localObject1;BuildArtifactReportTask.BuildableArtifactData localBuildableArtifactData1 = localBuildableArtifactData1;localBuildableArtifactData2 = localBuildableArtifactData2;
/* 160 */           int $i$f$map; Iterable $receiver$iv; Iterable $receiver$iv$iv = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 161 */           int $i$f$mapTo; Iterable $receiver$iv$iv; String str1; for (localIterator3 = $receiver$iv$iv.iterator(); localIterator3.hasNext(); ((Collection)localObject2).add(str1))
/*     */           {
/* 161 */             Object item$iv$iv = localIterator3.next();
/* 162 */             it = (JsonElement)item$iv$iv;localObject2 = destination$iv$iv;
/*     */             int $i$a$2$unknown;
/*     */             JsonElement p1;
/* 142 */             str1 = 
/*     */             
/* 162 */               p1.getAsString();
/*     */           }
/*     */           
/* 163 */           Object localObject2 = (List)destination$iv$iv;localBuildableArtifactData1.<init>((Collection)localObject1, (List)localObject2);localBuildableArtifactData3 = localBuildableArtifactData2;
/*     */         }
/* 135 */         history = 
/*     */         
/* 164 */           (List)destination$iv$iv;Intrinsics.checkExpressionValueIsNotNull(key, "key");
/*     */       }
/* 133 */       reader = 
/*     */       
/* 146 */         Unit.INSTANCE;
/*     */     }
/*     */     catch (Throwable localThrowable)
/*     */     {
/* 133 */       localThrowable1 = localThrowable; throw localThrowable; } finally { CloseableKt.closeFinally(localCloseable, localThrowable1);
/*     */     }
/*     */     
/* 147 */     return result;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.BuildArtifactReportTask.Companion
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */