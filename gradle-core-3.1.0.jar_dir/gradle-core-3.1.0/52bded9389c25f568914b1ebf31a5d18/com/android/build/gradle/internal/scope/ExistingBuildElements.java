/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import com.android.build.FilterData;
/*     */ import com.android.build.VariantOutput.OutputType;
/*     */ import com.android.ide.common.build.ApkInfo;
/*     */ import com.android.ide.common.internal.WaitableExecutor;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import com.google.gson.TypeAdapter;
/*     */ import com.google.gson.reflect.TypeToken;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.lang.reflect.Type;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.io.CloseableKt;
/*     */ import kotlin.jvm.JvmStatic;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import kotlin.sequences.SequencesKt;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.file.FileTree;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\f\n\002\030\002\n\002\020\000\n\002\b\005\030\000 \0042\0020\001:\003\003\004\005B\005¢\006\002\020\002¨\006\006"}, d2={"Lcom/android/build/gradle/internal/scope/ExistingBuildElements;", "", "()V", "ApkInfoAdapter", "Companion", "OutputTypeTypeAdapter", "gradle-core"})
/*     */ public final class ExistingBuildElements
/*     */ {
/*     */   static
/*     */   {
/*  44 */     WaitableExecutor tmp14_11 = WaitableExecutor.useGlobalSharedThreadPool();Intrinsics.checkExpressionValueIsNotNull(tmp14_11, "WaitableExecutor.useGlobalSharedThreadPool()"); } public static final Companion Companion = new Companion(null); @NotNull
/*  44 */   private static final WaitableExecutor executor = tmp14_11; @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000V\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\020\036\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\032\020\007\032\0020\b2\006\020\t\032\0020\n2\b\020\013\032\004\030\0010\fH\002J\030\020\r\032\0020\b2\006\020\t\032\0020\n2\006\020\r\032\0020\fH\007J\030\020\r\032\0020\b2\006\020\t\032\0020\n2\006\020\r\032\0020\016H\007J\020\020\017\032\0020\f2\006\020\020\032\0020\fH\007J\022\020\021\032\004\030\0010\f2\006\020\020\032\0020\fH\007J\022\020\021\032\004\030\0010\f2\006\020\022\032\0020\016H\002J(\020\023\032\b\022\004\022\0020\0250\0242\006\020\026\032\0020\0272\b\020\030\032\004\030\0010\n2\006\020\031\032\0020\032H\007J\026\020\033\032\b\022\004\022\0020\0340\0242\006\020\035\032\0020\fH\007J\026\020\036\032\0020\0372\f\020 \032\b\022\004\022\0020\0340\024H\007R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006!"}, d2={"Lcom/android/build/gradle/internal/scope/ExistingBuildElements$Companion;", "", "()V", "executor", "Lcom/android/ide/common/internal/WaitableExecutor;", "getExecutor", "()Lcom/android/ide/common/internal/WaitableExecutor;", "_from", "Lcom/android/build/gradle/internal/scope/BuildElements;", "elementType", "Lcom/android/build/gradle/internal/scope/TaskOutputHolder$OutputType;", "metadataFile", "Ljava/io/File;", "from", "Lorg/gradle/api/file/FileCollection;", "getMetadataFile", "folder", "getMetadataFileIfPresent", "fileCollection", "load", "", "Lcom/android/build/gradle/internal/scope/BuildOutput;", "projectPath", "Ljava/nio/file/Path;", "outputType", "reader", "Ljava/io/Reader;", "loadApkList", "Lcom/android/ide/common/build/ApkInfo;", "file", "persistApkList", "", "apkInfos", "gradle-core"})
/*     */   public static final class Companion { @NotNull
/*  44 */     public final WaitableExecutor getExecutor() { return ExistingBuildElements.access$getExecutor$cp(); }
/*     */     
/*     */     @JvmStatic
/*     */     @NotNull
/*     */     public final BuildElements from(@NotNull TaskOutputHolder.OutputType elementType, @NotNull FileCollection from)
/*     */     {
/*  52 */       Intrinsics.checkParameterIsNotNull(elementType, "elementType");Intrinsics.checkParameterIsNotNull(from, "from");File metadataFile = ((Companion)this).getMetadataFileIfPresent(from);
/*  53 */       return ((Companion)this)._from(elementType, metadataFile);
/*     */     }
/*     */     
/*     */     @JvmStatic
/*     */     @NotNull
/*     */     public final BuildElements from(@NotNull TaskOutputHolder.OutputType elementType, @NotNull File from)
/*     */     {
/*  64 */       Intrinsics.checkParameterIsNotNull(elementType, "elementType");Intrinsics.checkParameterIsNotNull(from, "from");File metadataFile = ((Companion)this).getMetadataFileIfPresent(from);
/*  65 */       return ((Companion)this)._from(elementType, metadataFile);
/*     */     }
/*     */     
/*     */     private final BuildElements _from(TaskOutputHolder.OutputType elementType, File metadataFile)
/*     */     {
/*  70 */       if ((metadataFile == null) || (!metadataFile.exists())) {
/*  71 */         ImmutableList tmp18_15 = ImmutableList.of();Intrinsics.checkExpressionValueIsNotNull(tmp18_15, "ImmutableList.of()");return new BuildElements((Collection)tmp18_15);
/*     */       }
/*     */       try {
/*  74 */         Closeable localCloseable = (Closeable)new FileReader(metadataFile);Throwable localThrowable1 = (Throwable)null; try { FileReader reader = (FileReader)localCloseable;
/*  75 */           int $i$a$1$use; Path tmp71_68 = metadataFile.getParentFile().toPath();Intrinsics.checkExpressionValueIsNotNull(tmp71_68, "metadataFile.parentFile.toPath()");return new BuildElements(ExistingBuildElements.Companion.load(tmp71_68, 
/*  76 */             elementType, 
/*  77 */             (Reader)reader));
/*     */         }
/*     */         catch (Throwable localThrowable)
/*     */         {
/*  74 */           localThrowable1 = localThrowable; throw localThrowable; } finally { CloseableKt.closeFinally(localCloseable, localThrowable1);
/*     */         }
/*     */         
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/*  80 */         Intrinsics.checkExpressionValueIsNotNull(ImmutableList.of(), "ImmutableList.of<BuildOutput>()"); } return new BuildElements((Collection)tmp128_125);
/*     */     }
/*     */     
/*     */     private final File getMetadataFileIfPresent(FileCollection fileCollection)
/*     */     {
/*  85 */       FileTree tmp6_1 = fileCollection.getAsFileTree();Intrinsics.checkExpressionValueIsNotNull(tmp6_1, "fileCollection.asFileTree"); Set tmp17_12 = tmp6_1.getFiles();Intrinsics.checkExpressionValueIsNotNull(tmp17_12, "fileCollection.asFileTree.files");Iterable localIterable1 = (Iterable)tmp17_12;Iterable localIterable2 = localIterable1; Object localObject; for (Iterator localIterator = localIterable2.iterator(); localIterator.hasNext(); Intrinsics.checkExpressionValueIsNotNull(tmp65_63, "it")) { localObject = localIterator.next();File it = (File)localObject; int $i$a$1$find; } return (File)(Intrinsics.areEqual(tmp65_63.getName(), "output.json") ? localObject : null);
/*     */     }
/*     */     
/*     */     @JvmStatic
/*     */     @Nullable
/*  90 */     public final File getMetadataFileIfPresent(@NotNull File folder) { Intrinsics.checkParameterIsNotNull(folder, "folder");File outputFile = ((Companion)this).getMetadataFile(folder);
/*  91 */       return outputFile.exists() ? outputFile : null;
/*     */     }
/*     */     
/*     */     @JvmStatic
/*     */     @NotNull
/*  96 */     public final File getMetadataFile(@NotNull File folder) { Intrinsics.checkParameterIsNotNull(folder, "folder");return new File(folder, "output.json");
/*     */     }
/*     */     
/*     */     @JvmStatic
/*     */     @NotNull
/* 101 */     public final String persistApkList(@NotNull Collection<? extends ApkInfo> apkInfos) { Intrinsics.checkParameterIsNotNull(apkInfos, "apkInfos");GsonBuilder gsonBuilder = new GsonBuilder();
/* 102 */       gsonBuilder.registerTypeHierarchyAdapter(ApkInfo.class, new ExistingBuildElements.ApkInfoAdapter());
/* 103 */       Gson gson = gsonBuilder.create(); String 
/* 104 */         tmp38_35 = gson.toJson(apkInfos);Intrinsics.checkExpressionValueIsNotNull(tmp38_35, "gson.toJson(apkInfos)");return tmp38_35;
/*     */     }
/*     */     
/*     */     @JvmStatic
/*     */     @NotNull
/*     */     public final Collection<ApkInfo> loadApkList(@NotNull File file) throws FileNotFoundException {
/* 110 */       Intrinsics.checkParameterIsNotNull(file, "file");GsonBuilder gsonBuilder = new GsonBuilder();
/* 111 */       gsonBuilder.registerTypeHierarchyAdapter(ApkInfo.class, new ExistingBuildElements.ApkInfoAdapter());
/* 112 */       gsonBuilder.registerTypeAdapter((Type)TaskOutputHolder.OutputType.class, 
/* 113 */         new ExistingBuildElements.OutputTypeTypeAdapter());
/* 114 */       Gson gson = gsonBuilder.create();
/* 115 */       Type recordType = new TypeToken() {}.getType(); Object tmp79_76 = gson.fromJson((Reader)new FileReader(file), recordType);Intrinsics.checkExpressionValueIsNotNull(tmp79_76, "gson.fromJson(FileReader(file), recordType)");return (Collection)tmp79_76;
/*     */     }
/*     */     
/*     */     @JvmStatic
/*     */     @NotNull
/*     */     public final Collection<BuildOutput> load(@NotNull Path projectPath, @Nullable TaskOutputHolder.OutputType outputType, @NotNull Reader reader)
/*     */     {
/* 124 */       Intrinsics.checkParameterIsNotNull(projectPath, "projectPath");Intrinsics.checkParameterIsNotNull(reader, "reader");GsonBuilder gsonBuilder = new GsonBuilder();
/*     */       
/* 126 */       gsonBuilder.registerTypeAdapter((Type)ApkInfo.class, new ExistingBuildElements.ApkInfoAdapter());
/* 127 */       gsonBuilder.registerTypeAdapter((Type)TaskOutputHolder.OutputType.class, 
/* 128 */         new ExistingBuildElements.OutputTypeTypeAdapter());
/* 129 */       Gson gson = gsonBuilder.create();
/* 130 */       Type recordType = new TypeToken() {}.getType();
/* 131 */       Collection buildOutputs = (Collection)gson.fromJson(reader, recordType); Collection 
/*     */       
/* 133 */         tmp91_89 = buildOutputs;Intrinsics.checkExpressionValueIsNotNull(tmp91_89, "buildOutputs");
/*     */       
/* 143 */       (Collection)SequencesKt.toList(SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence((Iterable)tmp91_89), (Function1)new Lambda(outputType) { public final boolean invoke(@NotNull BuildOutput it) { Intrinsics.checkParameterIsNotNull(it, "it");return ($outputType == null) || (Intrinsics.areEqual(it.getType(), $outputType));
/* 136 */         } }), (Function1)new Lambda(projectPath) { @NotNull
/* 137 */         public final BuildOutput invoke(@NotNull BuildOutput buildOutput) { Intrinsics.checkParameterIsNotNull(buildOutput, "buildOutput");
/*     */           
/* 141 */           return new BuildOutput(buildOutput.getType(), buildOutput.getApkInfo(), $projectPath.resolve(buildOutput.getOutputPath()), buildOutput.getProperties());
/*     */         }
/*     */       }));
/*     */     } }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final BuildElements from(@NotNull TaskOutputHolder.OutputType elementType, @NotNull FileCollection from) { Intrinsics.checkParameterIsNotNull(elementType, "elementType");
/*     */     Intrinsics.checkParameterIsNotNull(from, "from");
/*     */     return Companion.from(elementType, from); }
/*     */   
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\b\000\030\0002\b\022\004\022\0020\0020\001B\005¢\006\002\020\003J\020\020\004\032\0020\0022\006\020\005\032\0020\006H\027J\036\020\007\032\0020\b2\006\020\005\032\0020\0062\f\020\t\032\b\022\004\022\0020\0130\nH\003J\032\020\f\032\0020\b2\006\020\r\032\0020\0162\b\020\017\032\004\030\0010\002H\027¨\006\020"}, d2={"Lcom/android/build/gradle/internal/scope/ExistingBuildElements$ApkInfoAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/android/ide/common/build/ApkInfo;", "()V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "readFilters", "", "filters", "Lcom/google/common/collect/ImmutableList$Builder;", "Lcom/android/build/FilterData;", "write", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "gradle-core"})
/* 151 */   public static final class ApkInfoAdapter extends TypeAdapter<ApkInfo> { public void write(@NotNull JsonWriter out, @Nullable ApkInfo value) throws IOException { Intrinsics.checkParameterIsNotNull(out, "out"); if (value == null) {
/* 152 */         out.nullValue();
/* 153 */         return;
/*     */       }
/* 155 */       out.beginObject();
/* 156 */       out.name("type").value(value.getType().toString());
/* 157 */       out.name("splits").beginArray();
/* 158 */       for (FilterData filter : value.getFilters()) {
/* 159 */         out.beginObject(); FilterData 
/* 160 */           tmp96_95 = filter;Intrinsics.checkExpressionValueIsNotNull(tmp96_95, "filter");out.name("filterType").value(tmp96_95.getFilterType());
/* 161 */         out.name("value").value(filter.getIdentifier());
/* 162 */         out.endObject();
/*     */       }
/* 164 */       out.endArray();
/* 165 */       out.name("versionCode").value(value.getVersionCode());
/* 166 */       if (value.getVersionName() != null) {
/* 167 */         out.name("versionName").value(value.getVersionName());
/*     */       }
/* 169 */       out.name("enabled").value(value.isEnabled());
/* 170 */       if (value.getFilterName() != null) {
/* 171 */         out.name("filterName").value(value.getFilterName());
/*     */       }
/* 173 */       if (value.getOutputFileName() != null) {
/* 174 */         out.name("outputFile").value(value.getOutputFileName());
/*     */       }
/* 176 */       out.name("fullName").value(value.getFullName());
/* 177 */       out.name("baseName").value(value.getBaseName());
/* 178 */       out.endObject();
/*     */     }
/*     */     
/*     */     /* Error */
/*     */     @NotNull
/*     */     public ApkInfo read(@NotNull JsonReader reader)
/*     */       throws IOException
/*     */     {
/*     */       // Byte code:
/*     */       //   0: aload_1
/*     */       //   1: ldc -103
/*     */       //   3: invokestatic 24	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   6: aload_1
/*     */       //   7: invokevirtual 158	com/google/gson/stream/JsonReader:beginObject	()V
/*     */       //   10: aconst_null
/*     */       //   11: checkcast 160	java/lang/String
/*     */       //   14: astore_2
/*     */       //   15: invokestatic 166	com/google/common/collect/ImmutableList:builder	()Lcom/google/common/collect/ImmutableList$Builder;
/*     */       //   18: astore_3
/*     */       //   19: iconst_0
/*     */       //   20: istore 4
/*     */       //   22: aconst_null
/*     */       //   23: checkcast 160	java/lang/String
/*     */       //   26: astore 5
/*     */       //   28: iconst_1
/*     */       //   29: istore 6
/*     */       //   31: aconst_null
/*     */       //   32: checkcast 160	java/lang/String
/*     */       //   35: astore 7
/*     */       //   37: aconst_null
/*     */       //   38: checkcast 160	java/lang/String
/*     */       //   41: astore 8
/*     */       //   43: aconst_null
/*     */       //   44: checkcast 160	java/lang/String
/*     */       //   47: astore 9
/*     */       //   49: aconst_null
/*     */       //   50: checkcast 160	java/lang/String
/*     */       //   53: astore 10
/*     */       //   55: aload_1
/*     */       //   56: invokevirtual 167	com/google/gson/stream/JsonReader:hasNext	()Z
/*     */       //   59: ifeq +308 -> 367
/*     */       //   62: aload_1
/*     */       //   63: invokevirtual 170	com/google/gson/stream/JsonReader:nextName	()Ljava/lang/String;
/*     */       //   66: astore 11
/*     */       //   68: aload 11
/*     */       //   70: dup
/*     */       //   71: ifnonnull +7 -> 78
/*     */       //   74: pop
/*     */       //   75: goto +289 -> 364
/*     */       //   78: invokevirtual 173	java/lang/String:hashCode	()I
/*     */       //   81: lookupswitch	default:+283->364, -1721686788:+161->242, -1609594047:+187->268, -1553252829:+109->190, -1274275299:+83->164, -895858535:+96->177, 3575610:+135->216, 688591589:+174->255, 688906115:+148->229, 1330852282:+122->203
/*     */       //   164: aload 11
/*     */       //   166: ldc -125
/*     */       //   168: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */       //   171: ifeq +193 -> 364
/*     */       //   174: goto +157 -> 331
/*     */       //   177: aload 11
/*     */       //   179: ldc 54
/*     */       //   181: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */       //   184: ifeq +180 -> 364
/*     */       //   187: goto +102 -> 289
/*     */       //   190: aload 11
/*     */       //   192: ldc 126
/*     */       //   194: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */       //   197: ifeq +167 -> 364
/*     */       //   200: goto +140 -> 340
/*     */       //   203: aload 11
/*     */       //   205: ldc -123
/*     */       //   207: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */       //   210: ifeq +154 -> 364
/*     */       //   213: goto +145 -> 358
/*     */       //   216: aload 11
/*     */       //   218: ldc 35
/*     */       //   220: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */       //   223: ifeq +141 -> 364
/*     */       //   226: goto +55 -> 281
/*     */       //   229: aload 11
/*     */       //   231: ldc 113
/*     */       //   233: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */       //   236: ifeq +128 -> 364
/*     */       //   239: goto +74 -> 313
/*     */       //   242: aload 11
/*     */       //   244: ldc -118
/*     */       //   246: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */       //   249: ifeq +115 -> 364
/*     */       //   252: goto +97 -> 349
/*     */       //   255: aload 11
/*     */       //   257: ldc 101
/*     */       //   259: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */       //   262: ifeq +102 -> 364
/*     */       //   265: goto +39 -> 304
/*     */       //   268: aload 11
/*     */       //   270: ldc 115
/*     */       //   272: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */       //   275: ifeq +89 -> 364
/*     */       //   278: goto +44 -> 322
/*     */       //   281: aload_1
/*     */       //   282: invokevirtual 180	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
/*     */       //   285: astore_2
/*     */       //   286: goto +78 -> 364
/*     */       //   289: aload_0
/*     */       //   290: aload_1
/*     */       //   291: aload_3
/*     */       //   292: dup
/*     */       //   293: ldc -74
/*     */       //   295: invokestatic 86	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   298: invokespecial 186	com/android/build/gradle/internal/scope/ExistingBuildElements$ApkInfoAdapter:readFilters	(Lcom/google/gson/stream/JsonReader;Lcom/google/common/collect/ImmutableList$Builder;)V
/*     */       //   301: goto +63 -> 364
/*     */       //   304: aload_1
/*     */       //   305: invokevirtual 189	com/google/gson/stream/JsonReader:nextInt	()I
/*     */       //   308: istore 4
/*     */       //   310: goto +54 -> 364
/*     */       //   313: aload_1
/*     */       //   314: invokevirtual 180	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
/*     */       //   317: astore 5
/*     */       //   319: goto +45 -> 364
/*     */       //   322: aload_1
/*     */       //   323: invokevirtual 192	com/google/gson/stream/JsonReader:nextBoolean	()Z
/*     */       //   326: istore 6
/*     */       //   328: goto +36 -> 364
/*     */       //   331: aload_1
/*     */       //   332: invokevirtual 180	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
/*     */       //   335: astore 7
/*     */       //   337: goto +27 -> 364
/*     */       //   340: aload_1
/*     */       //   341: invokevirtual 180	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
/*     */       //   344: astore 10
/*     */       //   346: goto +18 -> 364
/*     */       //   349: aload_1
/*     */       //   350: invokevirtual 180	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
/*     */       //   353: astore 9
/*     */       //   355: goto +9 -> 364
/*     */       //   358: aload_1
/*     */       //   359: invokevirtual 180	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
/*     */       //   362: astore 8
/*     */       //   364: goto -309 -> 55
/*     */       //   367: aload_1
/*     */       //   368: invokevirtual 194	com/google/gson/stream/JsonReader:endObject	()V
/*     */       //   371: aload_3
/*     */       //   372: invokevirtual 200	com/google/common/collect/ImmutableList$Builder:build	()Lcom/google/common/collect/ImmutableList;
/*     */       //   375: astore 11
/*     */       //   377: aload_2
/*     */       //   378: dup
/*     */       //   379: ifnonnull +6 -> 385
/*     */       //   382: invokestatic 203	kotlin/jvm/internal/Intrinsics:throwNpe	()V
/*     */       //   385: invokestatic 207	com/android/build/VariantOutput$OutputType:valueOf	(Ljava/lang/String;)Lcom/android/build/VariantOutput$OutputType;
/*     */       //   388: astore 12
/*     */       //   390: aload 12
/*     */       //   392: aload 11
/*     */       //   394: checkcast 63	java/util/Collection
/*     */       //   397: iload 4
/*     */       //   399: aload 5
/*     */       //   401: aload 10
/*     */       //   403: aload 7
/*     */       //   405: aload 8
/*     */       //   407: aload 9
/*     */       //   409: iload 6
/*     */       //   411: invokestatic 211	com/android/ide/common/build/ApkInfo:of	(Lcom/android/build/VariantOutput$OutputType;Ljava/util/Collection;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/android/ide/common/build/ApkInfo;
/*     */       //   414: dup
/*     */       //   415: ldc -43
/*     */       //   417: invokestatic 86	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   420: areturn
/*     */       // Line number table:
/*     */       //   Java source line #183	-> byte code offset #6
/*     */       //   Java source line #184	-> byte code offset #10
/*     */       //   Java source line #185	-> byte code offset #15
/*     */       //   Java source line #186	-> byte code offset #19
/*     */       //   Java source line #187	-> byte code offset #22
/*     */       //   Java source line #188	-> byte code offset #28
/*     */       //   Java source line #189	-> byte code offset #31
/*     */       //   Java source line #190	-> byte code offset #37
/*     */       //   Java source line #191	-> byte code offset #43
/*     */       //   Java source line #192	-> byte code offset #49
/*     */       //   Java source line #194	-> byte code offset #55
/*     */       //   Java source line #195	-> byte code offset #62
/*     */       //   Java source line #196	-> byte code offset #281
/*     */       //   Java source line #197	-> byte code offset #289
/*     */       //   Java source line #198	-> byte code offset #304
/*     */       //   Java source line #199	-> byte code offset #313
/*     */       //   Java source line #200	-> byte code offset #322
/*     */       //   Java source line #201	-> byte code offset #331
/*     */       //   Java source line #202	-> byte code offset #340
/*     */       //   Java source line #203	-> byte code offset #349
/*     */       //   Java source line #204	-> byte code offset #358
/*     */       //   Java source line #205	-> byte code offset #364
/*     */       //   Java source line #194	-> byte code offset #364
/*     */       //   Java source line #207	-> byte code offset #367
/*     */       //   Java source line #209	-> byte code offset #371
/*     */       //   Java source line #210	-> byte code offset #377
/*     */       //   Java source line #212	-> byte code offset #390
/*     */       //   Java source line #213	-> byte code offset #390
/*     */       //   Java source line #214	-> byte code offset #392
/*     */       //   Java source line #215	-> byte code offset #397
/*     */       //   Java source line #216	-> byte code offset #399
/*     */       //   Java source line #217	-> byte code offset #401
/*     */       //   Java source line #218	-> byte code offset #403
/*     */       //   Java source line #219	-> byte code offset #405
/*     */       //   Java source line #220	-> byte code offset #407
/*     */       //   Java source line #221	-> byte code offset #409
/*     */       //   Java source line #212	-> byte code offset #411
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	signature
/*     */       //   0	421	0	this	ApkInfoAdapter
/*     */       //   0	421	1	reader	JsonReader
/*     */       //   15	406	2	outputType	String
/*     */       //   19	402	3	filters	com.google.common.collect.ImmutableList.Builder
/*     */       //   22	399	4	versionCode	int
/*     */       //   28	393	5	versionName	String
/*     */       //   31	390	6	enabled	boolean
/*     */       //   37	384	7	outputFile	String
/*     */       //   43	378	8	fullName	String
/*     */       //   49	372	9	baseName	String
/*     */       //   55	366	10	filterName	String
/*     */       //   377	44	11	filterData	ImmutableList
/*     */       //   390	31	12	apkType	VariantOutput.OutputType
/*     */     }
/*     */     
/*     */     /* Error */
/*     */     private final void readFilters(JsonReader reader, com.google.common.collect.ImmutableList.Builder<FilterData> filters)
/*     */       throws IOException
/*     */     {
/*     */       // Byte code:
/*     */       //   0: aload_1
/*     */       //   1: invokevirtual 225	com/google/gson/stream/JsonReader:beginArray	()V
/*     */       //   4: aload_1
/*     */       //   5: invokevirtual 167	com/google/gson/stream/JsonReader:hasNext	()Z
/*     */       //   8: ifeq +155 -> 163
/*     */       //   11: aload_1
/*     */       //   12: invokevirtual 158	com/google/gson/stream/JsonReader:beginObject	()V
/*     */       //   15: aconst_null
/*     */       //   16: checkcast 227	com/android/build/VariantOutput$FilterType
/*     */       //   19: astore_3
/*     */       //   20: aconst_null
/*     */       //   21: checkcast 160	java/lang/String
/*     */       //   24: astore 4
/*     */       //   26: aload_1
/*     */       //   27: invokevirtual 167	com/google/gson/stream/JsonReader:hasNext	()Z
/*     */       //   30: ifeq +102 -> 132
/*     */       //   33: aload_1
/*     */       //   34: invokevirtual 170	com/google/gson/stream/JsonReader:nextName	()Ljava/lang/String;
/*     */       //   37: astore 5
/*     */       //   39: aload 5
/*     */       //   41: dup
/*     */       //   42: ifnonnull +7 -> 49
/*     */       //   45: pop
/*     */       //   46: goto +83 -> 129
/*     */       //   49: invokevirtual 173	java/lang/String:hashCode	()I
/*     */       //   52: lookupswitch	default:+77->129, -1553050926:+28->80, 111972721:+41->93
/*     */       //   80: aload 5
/*     */       //   82: ldc 81
/*     */       //   84: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */       //   87: ifeq +42 -> 129
/*     */       //   90: goto +16 -> 106
/*     */       //   93: aload 5
/*     */       //   95: ldc 90
/*     */       //   97: invokevirtual 177	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */       //   100: ifeq +29 -> 129
/*     */       //   103: goto +20 -> 123
/*     */       //   106: aload_1
/*     */       //   107: invokevirtual 180	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
/*     */       //   110: dup
/*     */       //   111: ldc -27
/*     */       //   113: invokestatic 86	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   116: invokestatic 232	com/android/build/VariantOutput$FilterType:valueOf	(Ljava/lang/String;)Lcom/android/build/VariantOutput$FilterType;
/*     */       //   119: astore_3
/*     */       //   120: goto +9 -> 129
/*     */       //   123: aload_1
/*     */       //   124: invokevirtual 180	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
/*     */       //   127: astore 4
/*     */       //   129: goto -103 -> 26
/*     */       //   132: aload_3
/*     */       //   133: ifnull +23 -> 156
/*     */       //   136: aload 4
/*     */       //   138: ifnull +18 -> 156
/*     */       //   141: aload_2
/*     */       //   142: new 234	com/android/build/gradle/internal/ide/FilterDataImpl
/*     */       //   145: dup
/*     */       //   146: aload_3
/*     */       //   147: aload 4
/*     */       //   149: invokespecial 238	com/android/build/gradle/internal/ide/FilterDataImpl:<init>	(Lcom/android/build/VariantOutput$FilterType;Ljava/lang/String;)V
/*     */       //   152: invokevirtual 242	com/google/common/collect/ImmutableList$Builder:add	(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList$Builder;
/*     */       //   155: pop
/*     */       //   156: aload_1
/*     */       //   157: invokevirtual 194	com/google/gson/stream/JsonReader:endObject	()V
/*     */       //   160: goto -156 -> 4
/*     */       //   163: aload_1
/*     */       //   164: invokevirtual 244	com/google/gson/stream/JsonReader:endArray	()V
/*     */       //   167: return
/*     */       // Line number table:
/*     */       //   Java source line #227	-> byte code offset #0
/*     */       //   Java source line #228	-> byte code offset #4
/*     */       //   Java source line #229	-> byte code offset #11
/*     */       //   Java source line #230	-> byte code offset #15
/*     */       //   Java source line #231	-> byte code offset #20
/*     */       //   Java source line #232	-> byte code offset #26
/*     */       //   Java source line #233	-> byte code offset #33
/*     */       //   Java source line #234	-> byte code offset #106
/*     */       //   Java source line #235	-> byte code offset #123
/*     */       //   Java source line #236	-> byte code offset #129
/*     */       //   Java source line #232	-> byte code offset #129
/*     */       //   Java source line #238	-> byte code offset #132
/*     */       //   Java source line #239	-> byte code offset #141
/*     */       //   Java source line #241	-> byte code offset #156
/*     */       //   Java source line #228	-> byte code offset #160
/*     */       //   Java source line #243	-> byte code offset #163
/*     */       //   Java source line #244	-> byte code offset #167
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	signature
/*     */       //   0	168	0	this	ApkInfoAdapter
/*     */       //   0	168	1	reader	JsonReader
/*     */       //   0	168	2	filters	com.google.common.collect.ImmutableList.Builder
/*     */       //   20	140	3	filterType	com.android.build.VariantOutput.FilterType
/*     */       //   26	134	4	value	String
/*     */     }
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final BuildElements from(@NotNull TaskOutputHolder.OutputType elementType, @NotNull File from)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(elementType, "elementType");
/*     */     Intrinsics.checkParameterIsNotNull(from, "from");
/*     */     return Companion.from(elementType, from);
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @Nullable
/*     */   public static final File getMetadataFileIfPresent(@NotNull File folder)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(folder, "folder");
/*     */     return Companion.getMetadataFileIfPresent(folder);
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final File getMetadataFile(@NotNull File folder)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(folder, "folder");
/*     */     return Companion.getMetadataFile(folder);
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final String persistApkList(@NotNull Collection<? extends ApkInfo> apkInfos)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(apkInfos, "apkInfos");
/*     */     return Companion.persistApkList(apkInfos);
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final Collection<ApkInfo> loadApkList(@NotNull File file)
/*     */     throws FileNotFoundException
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(file, "file");
/*     */     return Companion.loadApkList(file);
/*     */   }
/*     */   
/*     */   @JvmStatic
/*     */   @NotNull
/*     */   public static final Collection<BuildOutput> load(@NotNull Path projectPath, @Nullable TaskOutputHolder.OutputType outputType, @NotNull Reader reader)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(projectPath, "projectPath");
/*     */     Intrinsics.checkParameterIsNotNull(reader, "reader");
/*     */     return Companion.load(projectPath, outputType, reader);
/*     */   }
/*     */   
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000$\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\b\000\030\0002\b\022\004\022\0020\0020\001B\005¢\006\002\020\003J\020\020\004\032\0020\0022\006\020\005\032\0020\006H\027J\030\020\007\032\0020\b2\006\020\t\032\0020\n2\006\020\013\032\0020\002H\027¨\006\f"}, d2={"Lcom/android/build/gradle/internal/scope/ExistingBuildElements$OutputTypeTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/android/build/gradle/internal/scope/TaskOutputHolder$OutputType;", "()V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "gradle-core"})
/*     */   public static final class OutputTypeTypeAdapter
/*     */     extends TypeAdapter<TaskOutputHolder.OutputType>
/*     */   {
/*     */     public void write(@NotNull JsonWriter out, @NotNull TaskOutputHolder.OutputType value)
/*     */       throws IOException
/*     */     {
/* 251 */       Intrinsics.checkParameterIsNotNull(out, "out");Intrinsics.checkParameterIsNotNull(value, "value");out.beginObject();
/* 252 */       out.name("type").value(value.name());
/* 253 */       out.endObject();
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public TaskOutputHolder.OutputType read(@NotNull JsonReader reader) throws IOException {
/* 258 */       Intrinsics.checkParameterIsNotNull(reader, "reader");reader.beginObject(); String 
/* 259 */         tmp14_11 = reader.nextName();Intrinsics.checkExpressionValueIsNotNull(tmp14_11, "reader.nextName()"); if (!kotlin.text.StringsKt.endsWith$default(tmp14_11, "type", false, 2, null)) {
/* 260 */         throw ((Throwable)new IOException("Invalid format"));
/*     */       }
/* 262 */       String nextString = reader.nextString();
/*     */       Object localObject;
/* 264 */       try { String tmp51_50 = nextString;Intrinsics.checkExpressionValueIsNotNull(tmp51_50, "nextString");localObject = TaskOutputHolder.TaskOutputType.valueOf(tmp51_50);
/*     */       } catch (IllegalArgumentException e) {
/* 266 */         String tmp68_67 = nextString;Intrinsics.checkExpressionValueIsNotNull(tmp68_67, "nextString");localObject = TaskOutputHolder.AnchorOutputType.valueOf(tmp68_67);
/*     */       }
/* 263 */       TaskOutputHolder.OutputType outputType = (TaskOutputHolder.OutputType)localObject;
/*     */       
/* 269 */       reader.endObject();
/* 270 */       return outputType;
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.ExistingBuildElements
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */