/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.api.artifact.ArtifactType;
/*     */ import com.android.build.api.artifact.BuildArtifactType;
/*     */ import com.android.build.api.artifact.BuildableArtifact;
/*     */ import com.android.build.gradle.internal.scope.BuildArtifactHolder;
/*     */ import com.android.build.gradle.internal.scope.GlobalScope;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.tasks.AndroidBuilderTask;
/*     */ import com.android.build.gradle.options.ProjectOptions;
/*     */ import com.android.build.gradle.options.StringOption;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonParser;
/*     */ import com.google.gson.annotations.SerializedName;
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.PrintStream;
/*     */ import java.io.Reader;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Pair;
/*     */ import kotlin.TuplesKt;
/*     */ import kotlin.Unit;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.collections.IndexedValue;
/*     */ import kotlin.collections.MapsKt;
/*     */ import kotlin.io.CloseableKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.ranges.RangesKt;
/*     */ import kotlin.text.StringsKt;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.Task;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ import org.gradle.api.tasks.TaskDependency;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0006\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\036\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\005\b\026\030\000 \0222\0020\001:\003\021\022\023B\005¢\006\002\020\002J(\020\n\032\0020\0132\006\020\003\032\0020\0042\f\020\007\032\b\022\004\022\0020\t0\b2\n\b\002\020\005\032\004\030\0010\006J\020\020\f\032\0020\r2\006\020\016\032\0020\017H\002J\b\020\020\032\0020\013H\007R\016\020\003\032\0020\004X.¢\006\002\n\000R\022\020\005\032\004\030\0010\0068\003X\016¢\006\002\n\000R\026\020\007\032\b\022\004\022\0020\t0\b8\003X.¢\006\002\n\000¨\006\024"}, d2={"Lcom/android/build/gradle/tasks/BuildArtifactReportTask;", "Lcom/android/build/gradle/internal/tasks/AndroidBuilderTask;", "()V", "buildArtifactHolder", "Lcom/android/build/gradle/internal/scope/BuildArtifactHolder;", "outputFile", "Ljava/io/File;", "types", "", "Lcom/android/build/api/artifact/ArtifactType;", "init", "", "newArtifact", "Lcom/android/build/gradle/tasks/BuildArtifactReportTask$BuildableArtifactData;", "artifact", "Lcom/android/build/api/artifact/BuildableArtifact;", "report", "BuildableArtifactData", "Companion", "ConfigAction", "gradle-core"})
/*     */ public class BuildArtifactReportTask
/*     */   extends AndroidBuilderTask
/*     */ {
/*     */   private BuildArtifactHolder buildArtifactHolder;
/*     */   private Collection<? extends ArtifactType> types;
/*     */   private File outputFile;
/*     */   public static final Companion Companion = new Companion(null);
/*     */   
/*     */   public final void init(@NotNull BuildArtifactHolder buildArtifactHolder, @NotNull Collection<? extends ArtifactType> types, @Nullable File outputFile)
/*     */   {
/*  65 */     Intrinsics.checkParameterIsNotNull(buildArtifactHolder, "buildArtifactHolder");Intrinsics.checkParameterIsNotNull(types, "types");this.buildArtifactHolder = buildArtifactHolder;
/*  66 */     this.types = types;
/*  67 */     this.outputFile = outputFile;
/*     */   }
/*     */   
/*     */   @TaskAction
/*     */   public final void report()
/*     */   {
/*  73 */     Collection tmp4_1 = types;
/*     */     
/*  73 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("types"); Iterable $receiver$iv = (Iterable)tmp4_1;
/*     */     
/*     */     int $i$f$associate;
/*     */     
/* 153 */     int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)), 16);
/* 154 */     Iterable localIterable1 = $receiver$iv;Map destination$iv$iv = (Map)new LinkedHashMap(capacity$iv);
/* 155 */     int $i$f$associateTo; Object $receiver$iv$iv; Map localMap1; Object $receiver$iv; Pair localPair; for (Iterator localIterator1 = ((Iterable)$receiver$iv$iv).iterator(); localIterator1.hasNext(); localMap1.put(localPair.getFirst(), localPair.getSecond()))
/*     */     {
/* 155 */       Object element$iv$iv = localIterator1.next();
/* 156 */       localMap1 = destination$iv$iv;ArtifactType it = (ArtifactType)element$iv$iv;
/*     */       int $i$a$1$associate;
/*  74 */       BuildArtifactHolder tmp93_90 = buildArtifactHolder;
/*     */       
/*  74 */       if (tmp93_90 == null) Intrinsics.throwUninitializedPropertyAccessException("buildArtifactHolder"); Iterable localIterable2 = (Iterable)tmp93_90.getHistory(it);BuildArtifactReportTask localBuildArtifactReportTask = this;ArtifactType localArtifactType1 = it;
/*     */       
/*     */       int $i$f$map;
/*     */       
/* 157 */       Object localObject1 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$receiver$iv, 10));
/* 158 */       int $i$f$mapTo; Iterable $receiver$iv$iv; BuildableArtifactData localBuildableArtifactData1; for (Iterator localIterator2 = $receiver$iv$iv.iterator(); localIterator2.hasNext(); ((Collection)localObject2).add(localBuildableArtifactData1))
/*     */       {
/* 158 */         Object item$iv$iv = localIterator2.next();
/* 159 */         BuildableArtifact localBuildableArtifact1 = (BuildableArtifact)item$iv$iv;localObject2 = destination$iv$iv;
/*     */         int $i$a$1$unknown;
/*     */         BuildableArtifact p1;
/*  74 */         localBuildableArtifactData1 = 
/*     */         
/* 159 */           ((BuildArtifactReportTask)localBuildArtifactReportTask).newArtifact(p1); }
/* 160 */       Object localObject2 = (List)destination$iv$iv;localPair = TuplesKt.to(localArtifactType1, localObject2);
/*     */     }
/*  72 */     Map reports = 
/*     */     
/* 161 */       destination$iv$iv;
/*     */     Gson gson;
/*     */     int $i$a$1$use;
/*     */     Object reportType;
/*  76 */     if (outputFile != null) {
/*  77 */       gson = new GsonBuilder().setPrettyPrinting().create();
/*  78 */       capacity$iv = (Closeable)new FileWriter(outputFile);$receiver$iv$iv = (Throwable)null; try { FileWriter writer = (FileWriter)capacity$iv;
/*  79 */         reportType = new BuildArtifactReportTask.report.1.reportType.1().getType();
/*  80 */         gson.toJson(reports, (Type)reportType, (Appendable)writer);writer = 
/*  81 */           Unit.INSTANCE;
/*     */       }
/*     */       catch (Throwable localThrowable)
/*     */       {
/*  78 */         $receiver$iv$iv = localThrowable; throw localThrowable; } finally { CloseableKt.closeFinally(capacity$iv, (Throwable)$receiver$iv$iv);
/*     */       }
/*     */     }
/*     */     
/*  83 */     for (capacity$iv = reports.entrySet().iterator(); capacity$iv.hasNext();) { gson = (Map.Entry)capacity$iv.next();reportType = gson;ArtifactType type = (ArtifactType)((Map.Entry)reportType).getKey();reportType = gson;List report = (List)((Map.Entry)reportType).getValue();
/*  84 */       reportType = type.name();System.out.println(reportType);
/*  85 */       reportType = StringsKt.repeat((CharSequence)"-", type.name().length());System.out.println(reportType);
/*  86 */       for ($i$a$1$use = CollectionsKt.withIndex((Iterable)report).iterator(); $i$a$1$use.hasNext(); 
/*     */           
/*  90 */           System.out.println($receiver$iv))
/*     */       {
/*  86 */         reportType = (IndexedValue)$i$a$1$use.next();int index = ((IndexedValue)reportType).component1();BuildableArtifactData artifact = (BuildableArtifactData)((IndexedValue)reportType).component2();
/*  87 */         $receiver$iv = "BuildableArtifact " + index;System.out.println($receiver$iv);
/*  88 */         $receiver$iv = "files: " + artifact.getFiles();System.out.println($receiver$iv);
/*  89 */         $receiver$iv = "builtBy: " + artifact.getBuiltBy();System.out.println($receiver$iv);
/*  90 */         $receiver$iv = ""; } } }
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000*\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\030\0002\b\022\004\022\0020\0020\001B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\020\020\b\032\0020\t2\006\020\n\032\0020\002H\026J\b\020\013\032\0020\fH\026J\016\020\r\032\b\022\004\022\0020\0020\016H\026R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\006\020\007¨\006\017"}, d2={"Lcom/android/build/gradle/tasks/BuildArtifactReportTask$ConfigAction;", "Lcom/android/build/gradle/internal/scope/TaskConfigAction;", "Lcom/android/build/gradle/tasks/BuildArtifactReportTask;", "scope", "Lcom/android/build/gradle/internal/scope/VariantScope;", "(Lcom/android/build/gradle/internal/scope/VariantScope;)V", "getScope", "()Lcom/android/build/gradle/internal/scope/VariantScope;", "execute", "", "task", "getName", "", "getType", "Ljava/lang/Class;", "gradle-core"})
/*     */   public static final class ConfigAction implements TaskConfigAction<BuildArtifactReportTask> { @NotNull
/*     */     private final VariantScope scope;
/*     */     @NotNull
/*  95 */     public final VariantScope getScope() { return scope; } public ConfigAction(@NotNull VariantScope scope) { this.scope = scope; } @NotNull
/*  96 */     public String getName() { return scope.getTaskName("reportBuildArtifacts"); }
/*     */     @NotNull
/*  98 */     public Class<BuildArtifactReportTask> getType() { return BuildArtifactReportTask.class; }
/*     */     
/*     */     public void execute(@NotNull BuildArtifactReportTask task) {
/* 101 */       Intrinsics.checkParameterIsNotNull(task, "task");task.setVariantName(scope.getFullVariantName()); GlobalScope 
/*     */       
/* 103 */         tmp28_23 = scope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp28_23, "scope.globalScope");String outputFileName = tmp28_23.getProjectOptions().get(StringOption.BUILD_ARTIFACT_REPORT_FILE); GlobalScope 
/*     */       
/* 106 */         tmp61_56 = scope.getGlobalScope();Intrinsics.checkExpressionValueIsNotNull(tmp61_56, "scope.globalScope");File outputFile = outputFileName == null ? null : tmp61_56.getProject().file(outputFileName); BuildArtifactHolder 
/*     */       
/* 110 */         tmp87_82 = scope.getBuildArtifactHolder();Intrinsics.checkExpressionValueIsNotNull(tmp87_82, "scope.buildArtifactHolder");
/* 111 */       BuildArtifactHolder localBuildArtifactHolder = tmp87_82;BuildArtifactReportTask localBuildArtifactReportTask = task;List localList = CollectionsKt.emptyList();localBuildArtifactReportTask.init(localBuildArtifactHolder, (Collection)localList, 
/* 112 */         outputFile); }
/*     */     
/*     */      }
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\020\000\n\000\n\002\020\036\n\002\030\002\n\000\n\002\020 \n\002\020\016\n\002\b\r\n\002\020\013\n\002\b\002\n\002\020\b\n\002\b\002\b\b\030\0002\0020\001B!\022\f\020\002\032\b\022\004\022\0020\0040\003\022\f\020\005\032\b\022\004\022\0020\0070\006¢\006\002\020\bJ\017\020\021\032\b\022\004\022\0020\0040\003HÆ\003J\017\020\022\032\b\022\004\022\0020\0070\006HÆ\003J)\020\023\032\0020\0002\016\b\002\020\002\032\b\022\004\022\0020\0040\0032\016\b\002\020\005\032\b\022\004\022\0020\0070\006HÆ\001J\023\020\024\032\0020\0252\b\020\026\032\004\030\0010\001HÖ\003J\t\020\027\032\0020\030HÖ\001J\t\020\031\032\0020\007HÖ\001R$\020\005\032\b\022\004\022\0020\0070\0068\006@\006X\016¢\006\016\n\000\032\004\b\t\020\n\"\004\b\013\020\fR$\020\002\032\b\022\004\022\0020\0040\0038\006@\006X\016¢\006\016\n\000\032\004\b\r\020\016\"\004\b\017\020\020¨\006\032"}, d2={"Lcom/android/build/gradle/tasks/BuildArtifactReportTask$BuildableArtifactData;", "", "files", "", "Ljava/io/File;", "builtBy", "", "", "(Ljava/util/Collection;Ljava/util/List;)V", "getBuiltBy", "()Ljava/util/List;", "setBuiltBy", "(Ljava/util/List;)V", "getFiles", "()Ljava/util/Collection;", "setFiles", "(Ljava/util/Collection;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "gradle-core"})
/* 116 */   public static final class BuildableArtifactData { public BuildableArtifactData(@NotNull Collection<? extends File> files, @NotNull List<String> builtBy) { this.files = files;this.builtBy = builtBy; } @NotNull
/* 117 */     public final Collection<File> getFiles() { return files; } public final void setFiles(@NotNull Collection<? extends File> <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");files = <set-?>; } @NotNull
/* 118 */     public final List<String> getBuiltBy() { return builtBy; } public final void setBuiltBy(@NotNull List<String> <set-?>) { Intrinsics.checkParameterIsNotNull(<set-?>, "<set-?>");builtBy = <set-?>;
/*     */     }
/*     */     
/*     */     @SerializedName("files")
/*     */     @NotNull
/*     */     private Collection<? extends File> files;
/*     */     @SerializedName("builtBy")
/*     */     @NotNull
/*     */     private List<String> builtBy;
/*     */     @NotNull
/*     */     public final Collection<File> component1()
/*     */     {
/*     */       return files;
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final List<String> component2()
/*     */     {
/*     */       return builtBy;
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final BuildableArtifactData copy(@NotNull Collection<? extends File> files, @NotNull List<String> builtBy)
/*     */     {
/*     */       Intrinsics.checkParameterIsNotNull(files, "files");
/*     */       Intrinsics.checkParameterIsNotNull(builtBy, "builtBy");
/*     */       return new BuildableArtifactData(files, builtBy);
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/*     */       return "BuildableArtifactData(files=" + files + ", builtBy=" + builtBy + ")";
/*     */     }
/*     */     
/*     */     /* Error */
/*     */     public int hashCode()
/*     */     {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: getfield 14	com/android/build/gradle/tasks/BuildArtifactReportTask$BuildableArtifactData:files	Ljava/util/Collection;
/*     */       //   4: dup
/*     */       //   5: ifnull +9 -> 14
/*     */       //   8: invokevirtual 76	java/lang/Object:hashCode	()I
/*     */       //   11: goto +5 -> 16
/*     */       //   14: pop
/*     */       //   15: iconst_0
/*     */       //   16: bipush 31
/*     */       //   18: imul
/*     */       //   19: aload_0
/*     */       //   20: getfield 33	com/android/build/gradle/tasks/BuildArtifactReportTask$BuildableArtifactData:builtBy	Ljava/util/List;
/*     */       //   23: dup
/*     */       //   24: ifnull +9 -> 33
/*     */       //   27: invokevirtual 76	java/lang/Object:hashCode	()I
/*     */       //   30: goto +5 -> 35
/*     */       //   33: pop
/*     */       //   34: iconst_0
/*     */       //   35: iadd
/*     */       //   36: ireturn
/*     */     }
/*     */     
/*     */     public boolean equals(Object paramObject)
/*     */     {
/*     */       if (this != paramObject)
/*     */       {
/*     */         if ((paramObject instanceof BuildableArtifactData))
/*     */         {
/*     */           BuildableArtifactData localBuildableArtifactData = (BuildableArtifactData)paramObject;
/*     */           if ((!Intrinsics.areEqual(files, files)) || (!Intrinsics.areEqual(builtBy, builtBy))) {}
/*     */         }
/*     */       }
/*     */       else {
/*     */         return true;
/*     */       }
/*     */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000(\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020$\n\002\030\002\n\002\020 \n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J$\020\003\032\030\022\004\022\0020\005\022\n\022\b\022\004\022\0020\0070\0060\004j\002`\b2\006\020\t\032\0020\n¨\006\013"}, d2={"Lcom/android/build/gradle/tasks/BuildArtifactReportTask$Companion;", "", "()V", "parseReport", "", "Lcom/android/build/api/artifact/ArtifactType;", "", "Lcom/android/build/gradle/tasks/BuildArtifactReportTask$BuildableArtifactData;", "Lcom/android/build/gradle/tasks/Report;", "file", "Ljava/io/File;", "gradle-core"})
/*     */   public static final class Companion
/*     */   {
/*     */     @NotNull
/*     */     public final Map<ArtifactType, List<BuildArtifactReportTask.BuildableArtifactData>> parseReport(@NotNull File file)
/*     */     {
/* 131 */       Intrinsics.checkParameterIsNotNull(file, "file");Map result = (Map)new LinkedHashMap();
/* 132 */       JsonParser parser = new JsonParser();
/* 133 */       Closeable localCloseable = (Closeable)new FileReader(file);Throwable localThrowable1 = (Throwable)null; try { FileReader reader = (FileReader)localCloseable;
/* 134 */         int $i$a$1$use; JsonElement tmp61_58 = parser.parse((Reader)reader);Intrinsics.checkExpressionValueIsNotNull(tmp61_58, "parser.parse(reader)"); List history; for (Iterator localIterator1 = tmp61_58.getAsJsonObject().entrySet().iterator(); localIterator1.hasNext(); 
/*     */             
/* 144 */             result.put(BuildArtifactType.valueOf(tmp532_530), history))
/*     */         {
/* 134 */           Map.Entry localEntry1 = (Map.Entry)localIterator1.next();Map.Entry localEntry2 = localEntry1;String key = (String)localEntry2.getKey();localEntry2 = localEntry1;JsonElement value = (JsonElement)localEntry2.getValue(); JsonElement 
/*     */           
/* 136 */             tmp136_134 = value;Intrinsics.checkExpressionValueIsNotNull(tmp136_134, "value"); JsonArray tmp145_142 = tmp136_134.getAsJsonArray();Intrinsics.checkExpressionValueIsNotNull(tmp145_142, "value.asJsonArray");Iterable $receiver$iv = (Iterable)tmp145_142;
/*     */           
/*     */           int $i$f$map;
/*     */           
/* 153 */           Iterable localIterable1 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 154 */           int $i$f$mapTo; Iterable $receiver$iv$iv; Collection localCollection1; BuildArtifactReportTask.BuildableArtifactData localBuildableArtifactData3; for (Iterator localIterator2 = $receiver$iv$iv.iterator(); localIterator2.hasNext(); localCollection1.add(localBuildableArtifactData3))
/*     */           {
/* 154 */             Object item$iv$iv = localIterator2.next();
/* 155 */             JsonElement localJsonElement1 = (JsonElement)item$iv$iv;localCollection1 = destination$iv$iv;
/*     */             int $i$a$1$map;
/*     */             JsonElement it;
/* 137 */             JsonElement tmp220_218 = it;Intrinsics.checkExpressionValueIsNotNull(tmp220_218, "it");JsonObject obj = tmp220_218.getAsJsonObject(); JsonArray 
/*     */             
/* 139 */               tmp242_239 = obj.getAsJsonArray("files");Intrinsics.checkExpressionValueIsNotNull(tmp242_239, "obj.getAsJsonArray(\"files\")");Iterable localIterable2 = (Iterable)tmp242_239;BuildArtifactReportTask.BuildableArtifactData localBuildableArtifactData2 = localBuildableArtifactData1 = new com/android/build/gradle/tasks/BuildArtifactReportTask$BuildableArtifactData;
/*     */             
/*     */             int $i$f$map;
/*     */             
/* 156 */             Iterable localIterable3 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 157 */             int $i$f$mapTo; JsonElement it; for (Iterator localIterator3 = $receiver$iv$iv.iterator(); localIterator3.hasNext(); ((Collection)localObject1).add(localObject2))
/*     */             {
/* 157 */               Object item$iv$iv = localIterator3.next();
/* 158 */               JsonElement localJsonElement2 = (JsonElement)item$iv$iv;localObject1 = destination$iv$iv;
/*     */               int $i$a$1$map;
/* 140 */               JsonElement tmp325_323 = it;Intrinsics.checkExpressionValueIsNotNull(tmp325_323, "it"); JsonElement tmp339_336 = tmp325_323.getAsJsonObject().get("path");Intrinsics.checkExpressionValueIsNotNull(tmp339_336, "it.asJsonObject.get(\"path\")");localObject2 = new File(tmp339_336.getAsString());
/*     */             }
/*     */             
/* 159 */             Object localObject1 = (List)destination$iv$iv; JsonArray tmp389_386 = obj.getAsJsonArray("builtBy");Intrinsics.checkExpressionValueIsNotNull(tmp389_386, "obj.getAsJsonArray(\"builtBy\")");Iterable $receiver$iv = (Iterable)tmp389_386;localObject1 = (Collection)localObject1;BuildArtifactReportTask.BuildableArtifactData localBuildableArtifactData1 = localBuildableArtifactData1;localBuildableArtifactData2 = localBuildableArtifactData2;
/* 160 */             int $i$f$map; Iterable $receiver$iv; Iterable $receiver$iv$iv = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 161 */             int $i$f$mapTo; Iterable $receiver$iv$iv; String str1; for (localIterator3 = $receiver$iv$iv.iterator(); localIterator3.hasNext(); ((Collection)localObject2).add(str1))
/*     */             {
/* 161 */               Object item$iv$iv = localIterator3.next();
/* 162 */               it = (JsonElement)item$iv$iv;localObject2 = destination$iv$iv;
/*     */               int $i$a$2$unknown;
/*     */               JsonElement p1;
/* 142 */               str1 = 
/*     */               
/* 162 */                 p1.getAsString();
/*     */             }
/*     */             
/* 163 */             Object localObject2 = (List)destination$iv$iv;localBuildableArtifactData1.<init>((Collection)localObject1, (List)localObject2);localBuildableArtifactData3 = localBuildableArtifactData2;
/*     */           }
/* 135 */           history = 
/*     */           
/* 164 */             (List)destination$iv$iv;Intrinsics.checkExpressionValueIsNotNull(key, "key");
/*     */         }
/* 133 */         reader = 
/*     */         
/* 146 */           Unit.INSTANCE;
/*     */       }
/*     */       catch (Throwable localThrowable)
/*     */       {
/* 133 */         localThrowable1 = localThrowable; throw localThrowable; } finally { CloseableKt.closeFinally(localCloseable, localThrowable1);
/*     */       }
/*     */       
/* 147 */       return result;
/*     */     }
/*     */   }
/*     */   
/*     */   private final BuildableArtifactData newArtifact(BuildableArtifact artifact)
/*     */   {
/* 126 */     Set tmp25_20 = artifact.getBuildDependencies().getDependencies(null);Intrinsics.checkExpressionValueIsNotNull(tmp25_20, "artifact.buildDependencies.getDependencies(null)");Iterable localIterable1 = (Iterable)tmp25_20;Collection localCollection1 = (Collection)artifact.getFiles(); BuildableArtifactData localBuildableArtifactData2; BuildableArtifactData localBuildableArtifactData1 = localBuildableArtifactData2 = new com/android/build/gradle/tasks/BuildArtifactReportTask$BuildableArtifactData;
/*     */     
/*     */     int $i$f$map;
/*     */     
/*     */     Iterable $receiver$iv;
/*     */     
/* 162 */     Iterable localIterable2 = $receiver$iv;Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
/* 163 */     int $i$f$mapTo; Iterable $receiver$iv$iv; String str; for (Iterator localIterator = $receiver$iv$iv.iterator(); localIterator.hasNext(); ((Collection)localObject1).add(str))
/*     */     {
/* 163 */       Object item$iv$iv = localIterator.next();
/* 164 */       Task localTask1 = (Task)item$iv$iv;localObject1 = destination$iv$iv;
/*     */       int $i$a$1$unknown;
/*     */       Task p1;
/* 126 */       str = 
/*     */       
/* 164 */         p1.getPath();
/*     */     }
/*     */     
/* 165 */     Object localObject1 = (List)destination$iv$iv;localBuildableArtifactData2.<init>(localCollection1, (List)localObject1);return localBuildableArtifactData1;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.BuildArtifactReportTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */