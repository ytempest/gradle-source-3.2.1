/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.build.FilterData;
/*     */ import com.android.build.OutputFile;
/*     */ import com.android.build.VariantOutput.OutputType;
/*     */ import com.android.build.gradle.internal.scope.BuildOutput;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.OutputType;
/*     */ import com.android.ide.common.build.ApkInfo;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Type;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Collection;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import kotlin.sequences.SequencesKt;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000N\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\036\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\022\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\016\n\002\b\007\n\002\020\037\n\002\b\005\b\b\030\000 02\0020\0012\0020\002:\0010B3\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\f\020\007\032\b\022\004\022\0020\t0\b\022\006\020\n\032\0020\013\022\006\020\f\032\0020\r¢\006\002\020\016J\t\020\031\032\0020\004HÆ\003J\t\020\032\032\0020\006HÆ\003J\017\020\033\032\b\022\004\022\0020\t0\bHÆ\003J\t\020\034\032\0020\013HÆ\003J\t\020\035\032\0020\rHÆ\003JA\020\036\032\0020\0002\b\b\002\020\003\032\0020\0042\b\b\002\020\005\032\0020\0062\016\b\002\020\007\032\b\022\004\022\0020\t0\b2\b\b\002\020\n\032\0020\0132\b\b\002\020\f\032\0020\rHÆ\001J\023\020\037\032\0020 2\b\020!\032\004\030\0010\"HÖ\003J\020\020#\032\004\030\0010$2\006\020%\032\0020$J\016\020&\032\b\022\004\022\0020$0\bH\026J\016\020'\032\b\022\004\022\0020\t0\bH\026J\b\020(\032\0020\002H\026J\b\020)\032\0020\rH\026J\b\020*\032\0020$H\026J\020\020+\032\n\022\006\b\001\022\0020\0020,H\027J\b\020-\032\0020\013H\026J\t\020.\032\0020\013HÖ\001J\t\020/\032\0020$HÖ\001R\021\020\005\032\0020\006¢\006\b\n\000\032\004\b\017\020\020R\027\020\007\032\b\022\004\022\0020\t0\b¢\006\b\n\000\032\004\b\021\020\022R\021\020\f\032\0020\r¢\006\b\n\000\032\004\b\023\020\024R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\025\020\026R\021\020\n\032\0020\013¢\006\b\n\000\032\004\b\027\020\030¨\0061"}, d2={"Lcom/android/build/gradle/internal/ide/EarlySyncBuildOutput;", "Ljava/io/Serializable;", "Lcom/android/build/OutputFile;", "type", "Lcom/android/build/gradle/internal/scope/TaskOutputHolder$OutputType;", "apkType", "Lcom/android/build/VariantOutput$OutputType;", "filtersData", "", "Lcom/android/build/FilterData;", "version", "", "output", "Ljava/io/File;", "(Lcom/android/build/gradle/internal/scope/TaskOutputHolder$OutputType;Lcom/android/build/VariantOutput$OutputType;Ljava/util/Collection;ILjava/io/File;)V", "getApkType", "()Lcom/android/build/VariantOutput$OutputType;", "getFiltersData", "()Ljava/util/Collection;", "getOutput", "()Ljava/io/File;", "getType", "()Lcom/android/build/gradle/internal/scope/TaskOutputHolder$OutputType;", "getVersion", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "getFilter", "", "filterType", "getFilterTypes", "getFilters", "getMainOutputFile", "getOutputFile", "getOutputType", "getOutputs", "", "getVersionCode", "hashCode", "toString", "Companion", "gradle-core"})
/*     */ public final class EarlySyncBuildOutput implements java.io.Serializable, OutputFile
/*     */ {
/*     */   @NotNull
/*     */   private final TaskOutputHolder.OutputType type;
/*     */   @NotNull
/*     */   private final VariantOutput.OutputType apkType;
/*     */   @NotNull
/*     */   private final Collection<FilterData> filtersData;
/*     */   private final int version;
/*     */   @NotNull
/*     */   private final File output;
/*     */   public static final Companion Companion = new Companion(null);
/*     */   
/*     */   public EarlySyncBuildOutput(@NotNull TaskOutputHolder.OutputType type, @NotNull VariantOutput.OutputType apkType, @NotNull Collection<? extends FilterData> filtersData, int version, @NotNull File output)
/*     */   {
/*  42 */     this.type = type;this.apkType = apkType;this.filtersData = filtersData;this.version = version;this.output = output; } @NotNull
/*  43 */   public final TaskOutputHolder.OutputType getType() { return type; } @NotNull
/*  44 */   public final VariantOutput.OutputType getApkType() { return apkType; } @NotNull
/*  45 */   public final Collection<FilterData> getFiltersData() { return filtersData; }
/*  46 */   public final int getVersion() { return version; } @NotNull
/*  47 */   public final File getOutput() { return output; }
/*     */   @NotNull
/*  49 */   public File getOutputFile() { return output; } @NotNull
/*  50 */   public String getOutputType() { return apkType.name(); }
/*     */   
/*     */   @NotNull
/*  55 */   public Collection<String> getFilterTypes() { return (Collection)SequencesKt.toList(SequencesKt.map(CollectionsKt.asSequence((Iterable)filtersData), (Function1)getFilterTypes.1.INSTANCE)); }
/*     */   @NotNull
/*  57 */   public Collection<FilterData> getFilters() { return filtersData; } @NotNull
/*  58 */   public OutputFile getMainOutputFile() { return (OutputFile)this; }
/*     */   @NotNull
/*  60 */   public Collection<? extends OutputFile> getOutputs() { com.google.common.collect.ImmutableList tmp4_1 = com.google.common.collect.ImmutableList.of(this);Intrinsics.checkExpressionValueIsNotNull(tmp4_1, "ImmutableList.of<OutputFile>(this)");return (Collection)tmp4_1; }
/*  61 */   public int getVersionCode() { return version; }
/*     */   
/*     */   /* Error */
/*     */   @Nullable
/*     */   public final String getFilter(@NotNull String filterType)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 91
/*     */     //   3: invokestatic 94	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_0
/*     */     //   7: getfield 34	com/android/build/gradle/internal/ide/EarlySyncBuildOutput:filtersData	Ljava/util/Collection;
/*     */     //   10: checkcast 36	java/lang/Iterable
/*     */     //   13: invokestatic 42	kotlin/collections/CollectionsKt:asSequence	(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
/*     */     //   16: astore_2
/*     */     //   17: aload_2
/*     */     //   18: astore_3
/*     */     //   19: aload_3
/*     */     //   20: invokeinterface 100 1 0
/*     */     //   25: astore 4
/*     */     //   27: aload 4
/*     */     //   29: invokeinterface 106 1 0
/*     */     //   34: ifeq +41 -> 75
/*     */     //   37: aload 4
/*     */     //   39: invokeinterface 110 1 0
/*     */     //   44: astore 5
/*     */     //   46: aload 5
/*     */     //   48: checkcast 112	com/android/build/FilterData
/*     */     //   51: astore 6
/*     */     //   53: aload 6
/*     */     //   55: invokeinterface 115 1 0
/*     */     //   60: aload_1
/*     */     //   61: invokestatic 119	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
/*     */     //   64: ifeq +8 -> 72
/*     */     //   67: aload 5
/*     */     //   69: goto +7 -> 76
/*     */     //   72: goto -45 -> 27
/*     */     //   75: aconst_null
/*     */     //   76: checkcast 112	com/android/build/FilterData
/*     */     //   79: dup
/*     */     //   80: ifnull +11 -> 91
/*     */     //   83: invokeinterface 122 1 0
/*     */     //   88: goto +5 -> 93
/*     */     //   91: pop
/*     */     //   92: aconst_null
/*     */     //   93: areturn
/*     */     // Line number table:
/*     */     //   Java source line #63	-> byte code offset #6
/*     */     //   Java source line #63	-> byte code offset #53
/*     */     //   Java source line #63	-> byte code offset #64
/*     */     //   Java source line #63	-> byte code offset #93
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	94	0	this	EarlySyncBuildOutput
/*     */     //   0	94	1	filterType	String
/*     */     //   53	11	6	it	FilterData
/*     */     //   53	11	7	$i$a$1$find	int
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final TaskOutputHolder.OutputType component1()
/*     */   {
/*     */     return type;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final VariantOutput.OutputType component2()
/*     */   {
/*     */     return apkType;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Collection<FilterData> component3()
/*     */   {
/*     */     return filtersData;
/*     */   }
/*     */   
/*     */   public final int component4()
/*     */   {
/*     */     return version;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final File component5()
/*     */   {
/*     */     return output;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final EarlySyncBuildOutput copy(@NotNull TaskOutputHolder.OutputType type, @NotNull VariantOutput.OutputType apkType, @NotNull Collection<? extends FilterData> filtersData, int version, @NotNull File output)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(type, "type");
/*     */     Intrinsics.checkParameterIsNotNull(apkType, "apkType");
/*     */     Intrinsics.checkParameterIsNotNull(filtersData, "filtersData");
/*     */     Intrinsics.checkParameterIsNotNull(output, "output");
/*     */     return new EarlySyncBuildOutput(type, apkType, filtersData, version, output);
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/*     */     return "EarlySyncBuildOutput(type=" + type + ", apkType=" + apkType + ", filtersData=" + filtersData + ", version=" + version + ", output=" + output + ")";
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public int hashCode()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 134	com/android/build/gradle/internal/ide/EarlySyncBuildOutput:type	Lcom/android/build/gradle/internal/scope/TaskOutputHolder$OutputType;
/*     */     //   4: dup
/*     */     //   5: ifnull +9 -> 14
/*     */     //   8: invokevirtual 196	java/lang/Object:hashCode	()I
/*     */     //   11: goto +5 -> 16
/*     */     //   14: pop
/*     */     //   15: iconst_0
/*     */     //   16: bipush 31
/*     */     //   18: imul
/*     */     //   19: aload_0
/*     */     //   20: getfield 23	com/android/build/gradle/internal/ide/EarlySyncBuildOutput:apkType	Lcom/android/build/VariantOutput$OutputType;
/*     */     //   23: dup
/*     */     //   24: ifnull +9 -> 33
/*     */     //   27: invokevirtual 196	java/lang/Object:hashCode	()I
/*     */     //   30: goto +5 -> 35
/*     */     //   33: pop
/*     */     //   34: iconst_0
/*     */     //   35: iadd
/*     */     //   36: bipush 31
/*     */     //   38: imul
/*     */     //   39: aload_0
/*     */     //   40: getfield 34	com/android/build/gradle/internal/ide/EarlySyncBuildOutput:filtersData	Ljava/util/Collection;
/*     */     //   43: dup
/*     */     //   44: ifnull +9 -> 53
/*     */     //   47: invokevirtual 196	java/lang/Object:hashCode	()I
/*     */     //   50: goto +5 -> 55
/*     */     //   53: pop
/*     */     //   54: iconst_0
/*     */     //   55: iadd
/*     */     //   56: bipush 31
/*     */     //   58: imul
/*     */     //   59: aload_0
/*     */     //   60: getfield 86	com/android/build/gradle/internal/ide/EarlySyncBuildOutput:version	I
/*     */     //   63: invokestatic 201	java/lang/Integer:hashCode	(I)I
/*     */     //   66: iadd
/*     */     //   67: bipush 31
/*     */     //   69: imul
/*     */     //   70: aload_0
/*     */     //   71: getfield 15	com/android/build/gradle/internal/ide/EarlySyncBuildOutput:output	Ljava/io/File;
/*     */     //   74: dup
/*     */     //   75: ifnull +9 -> 84
/*     */     //   78: invokevirtual 196	java/lang/Object:hashCode	()I
/*     */     //   81: goto +5 -> 86
/*     */     //   84: pop
/*     */     //   85: iconst_0
/*     */     //   86: iadd
/*     */     //   87: ireturn
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/*     */     if (this != paramObject)
/*     */     {
/*     */       if ((paramObject instanceof EarlySyncBuildOutput))
/*     */       {
/*     */         EarlySyncBuildOutput localEarlySyncBuildOutput = (EarlySyncBuildOutput)paramObject;
/*     */         if ((Intrinsics.areEqual(type, type)) && (Intrinsics.areEqual(apkType, apkType)) && (Intrinsics.areEqual(filtersData, filtersData))) {
/*     */           if ((version == version ? 1 : 0) != 0) {
/*     */             if (!Intrinsics.areEqual(output, output)) {}
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/*     */       return true;
/*     */     }
/*     */     return false;
/*     */   }
/*     */   
/*     */   @kotlin.jvm.JvmStatic
/*     */   @NotNull
/*     */   public static final Collection<EarlySyncBuildOutput> load(@NotNull File folder)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(folder, "folder");
/*     */     return Companion.load(folder);
/*     */   }
/*     */   
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000*\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\036\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\b\003\030\0002\0020\001:\002\f\rB\007\b\002¢\006\002\020\002J\026\020\003\032\b\022\004\022\0020\0050\0042\006\020\006\032\0020\007H\007J\036\020\003\032\b\022\004\022\0020\0050\0042\006\020\b\032\0020\t2\006\020\n\032\0020\013H\002¨\006\016"}, d2={"Lcom/android/build/gradle/internal/ide/EarlySyncBuildOutput$Companion;", "", "()V", "load", "", "Lcom/android/build/gradle/internal/ide/EarlySyncBuildOutput;", "folder", "Ljava/io/File;", "projectPath", "Ljava/nio/file/Path;", "reader", "Ljava/io/Reader;", "ApkInfoAdapter", "OutputTypeTypeAdapter", "gradle-core"})
/*     */   public static final class Companion
/*     */   {
/*     */     /* Error */
/*     */     @kotlin.jvm.JvmStatic
/*     */     @NotNull
/*     */     public final Collection<EarlySyncBuildOutput> load(@NotNull File folder)
/*     */     {
/*     */       // Byte code:
/*     */       //   0: aload_1
/*     */       //   1: ldc 14
/*     */       //   3: invokestatic 20	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   6: getstatic 26	com/android/build/gradle/internal/scope/ExistingBuildElements:Companion	Lcom/android/build/gradle/internal/scope/ExistingBuildElements$Companion;
/*     */       //   9: aload_1
/*     */       //   10: invokevirtual 32	com/android/build/gradle/internal/scope/ExistingBuildElements$Companion:getMetadataFileIfPresent	(Ljava/io/File;)Ljava/io/File;
/*     */       //   13: astore_2
/*     */       //   14: aload_2
/*     */       //   15: ifnull +10 -> 25
/*     */       //   18: aload_2
/*     */       //   19: invokevirtual 38	java/io/File:exists	()Z
/*     */       //   22: ifne +16 -> 38
/*     */       //   25: invokestatic 44	com/google/common/collect/ImmutableList:of	()Lcom/google/common/collect/ImmutableList;
/*     */       //   28: dup
/*     */       //   29: ldc 46
/*     */       //   31: invokestatic 49	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   34: checkcast 51	java/util/Collection
/*     */       //   37: areturn
/*     */       //   38: nop
/*     */       //   39: new 53	java/io/FileReader
/*     */       //   42: dup
/*     */       //   43: aload_2
/*     */       //   44: invokespecial 57	java/io/FileReader:<init>	(Ljava/io/File;)V
/*     */       //   47: checkcast 59	java/io/Closeable
/*     */       //   50: astore_3
/*     */       //   51: aconst_null
/*     */       //   52: checkcast 10	java/lang/Throwable
/*     */       //   55: astore 4
/*     */       //   57: nop
/*     */       //   58: aload_3
/*     */       //   59: checkcast 53	java/io/FileReader
/*     */       //   62: astore 5
/*     */       //   64: getstatic 64	com/android/build/gradle/internal/ide/EarlySyncBuildOutput:Companion	Lcom/android/build/gradle/internal/ide/EarlySyncBuildOutput$Companion;
/*     */       //   67: aload_2
/*     */       //   68: invokevirtual 68	java/io/File:getParentFile	()Ljava/io/File;
/*     */       //   71: invokevirtual 72	java/io/File:toPath	()Ljava/nio/file/Path;
/*     */       //   74: dup
/*     */       //   75: ldc 74
/*     */       //   77: invokestatic 49	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   80: aload 5
/*     */       //   82: checkcast 76	java/io/Reader
/*     */       //   85: invokespecial 79	com/android/build/gradle/internal/ide/EarlySyncBuildOutput$Companion:load	(Ljava/nio/file/Path;Ljava/io/Reader;)Ljava/util/Collection;
/*     */       //   88: astore 5
/*     */       //   90: aload_3
/*     */       //   91: aload 4
/*     */       //   93: invokestatic 85	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
/*     */       //   96: aload 5
/*     */       //   98: goto +23 -> 121
/*     */       //   101: astore 5
/*     */       //   103: aload 5
/*     */       //   105: astore 4
/*     */       //   107: aload 5
/*     */       //   109: athrow
/*     */       //   110: astore 5
/*     */       //   112: aload_3
/*     */       //   113: aload 4
/*     */       //   115: invokestatic 85	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
/*     */       //   118: aload 5
/*     */       //   120: athrow
/*     */       //   121: astore_3
/*     */       //   122: goto +18 -> 140
/*     */       //   125: astore 4
/*     */       //   127: invokestatic 44	com/google/common/collect/ImmutableList:of	()Lcom/google/common/collect/ImmutableList;
/*     */       //   130: dup
/*     */       //   131: ldc 46
/*     */       //   133: invokestatic 49	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */       //   136: checkcast 51	java/util/Collection
/*     */       //   139: astore_3
/*     */       //   140: aload_3
/*     */       //   141: areturn
/*     */       // Line number table:
/*     */       //   Java source line #68	-> byte code offset #6
/*     */       //   Java source line #69	-> byte code offset #14
/*     */       //   Java source line #70	-> byte code offset #25
/*     */       //   Java source line #73	-> byte code offset #38
/*     */       //   Java source line #74	-> byte code offset #39
/*     */       //   Java source line #75	-> byte code offset #64
/*     */       //   Java source line #74	-> byte code offset #88
/*     */       //   Java source line #77	-> byte code offset #125
/*     */       //   Java source line #78	-> byte code offset #127
/*     */       //   Java source line #73	-> byte code offset #140
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	signature
/*     */       //   0	142	0	this	Companion
/*     */       //   0	142	1	folder	File
/*     */       //   14	128	2	metadataFile	File
/*     */       //   127	13	4	e	IOException
/*     */       //   64	24	5	reader	java.io.FileReader
/*     */       //   64	24	6	$i$a$1$use	int
/*     */       // Exception table:
/*     */       //   from	to	target	type
/*     */       //   57	90	101	java/lang/Throwable
/*     */       //   57	90	110	finally
/*     */       //   101	110	110	finally
/*     */       //   110	112	110	finally
/*     */       //   38	122	125	java/io/IOException
/*     */     }
/*     */     
/*     */     private final Collection<EarlySyncBuildOutput> load(Path projectPath, java.io.Reader reader)
/*     */     {
/*  85 */       GsonBuilder gsonBuilder = new GsonBuilder();
/*     */       
/*  88 */       gsonBuilder.registerTypeAdapter((Type)ApkInfo.class, new ApkInfoAdapter());
/*  89 */       gsonBuilder.registerTypeAdapter((Type)TaskOutputHolder.OutputType.class, 
/*  90 */         new OutputTypeTypeAdapter());
/*  91 */       com.google.gson.Gson gson = gsonBuilder.create();
/*  92 */       Type recordType = new com.google.gson.reflect.TypeToken() {}.getType();
/*  93 */       Collection buildOutputs = (Collection)gson.fromJson(reader, recordType); Collection 
/*     */       
/*  95 */         tmp75_73 = buildOutputs;Intrinsics.checkExpressionValueIsNotNull(tmp75_73, "buildOutputs");
/*     */       
/* 105 */       (Collection)SequencesKt.toList(SequencesKt.map(CollectionsKt.asSequence((Iterable)tmp75_73), (Function1)new Lambda(projectPath) { @NotNull
/*  98 */         public final EarlySyncBuildOutput invoke(@NotNull BuildOutput buildOutput) { Intrinsics.checkParameterIsNotNull(buildOutput, "buildOutput"); TaskOutputHolder.OutputType 
/*  99 */             tmp14_11 = buildOutput.getType();Intrinsics.checkExpressionValueIsNotNull(tmp14_11, "buildOutput.type"); ApkInfo 
/* 100 */             tmp24_21 = buildOutput.getApkInfo();Intrinsics.checkExpressionValueIsNotNull(tmp24_21, "buildOutput.apkInfo"); VariantOutput.OutputType tmp35_30 = tmp24_21.getType();Intrinsics.checkExpressionValueIsNotNull(tmp35_30, "buildOutput.apkInfo.type"); ApkInfo 
/* 101 */             tmp45_42 = buildOutput.getApkInfo();Intrinsics.checkExpressionValueIsNotNull(tmp45_42, "buildOutput.apkInfo"); Collection tmp56_51 = tmp45_42.getFilters();Intrinsics.checkExpressionValueIsNotNull(tmp56_51, "buildOutput.apkInfo.filters"); ApkInfo 
/* 102 */             tmp66_63 = buildOutput.getApkInfo();Intrinsics.checkExpressionValueIsNotNull(tmp66_63, "buildOutput.apkInfo"); File 
/* 103 */             tmp95_90 = $projectPath.resolve(buildOutput.getOutputPath()).toFile();Intrinsics.checkExpressionValueIsNotNull(tmp95_90, "projectPath.resolve(buil…tput.outputPath).toFile()");return new EarlySyncBuildOutput(tmp14_11, tmp35_30, tmp56_51, tmp66_63.getVersionCode(), tmp95_90);
/*     */         }
/*     */       }));
/*     */     }
/*     */     
/*     */     @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\b\000\030\0002\b\022\004\022\0020\0020\001B\005¢\006\002\020\003J\020\020\004\032\0020\0022\006\020\005\032\0020\006H\027J\036\020\007\032\0020\b2\006\020\005\032\0020\0062\f\020\t\032\b\022\004\022\0020\0130\nH\003J\032\020\f\032\0020\b2\006\020\r\032\0020\0162\b\020\017\032\004\030\0010\002H\027¨\006\020"}, d2={"Lcom/android/build/gradle/internal/ide/EarlySyncBuildOutput$Companion$ApkInfoAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/android/ide/common/build/ApkInfo;", "()V", "read", "in", "Lcom/google/gson/stream/JsonReader;", "readFilters", "", "filters", "Lcom/google/common/collect/ImmutableList$Builder;", "Lcom/android/build/FilterData;", "write", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "gradle-core"})
/*     */     public static final class ApkInfoAdapter extends com.google.gson.TypeAdapter<ApkInfo>
/*     */     {
/*     */       public void write(@NotNull JsonWriter out, @Nullable ApkInfo value) throws IOException {
/* 112 */         Intrinsics.checkParameterIsNotNull(out, "out");throw ((Throwable)new IOException("Unexpected call to write"));
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       @NotNull
/*     */       public ApkInfo read(@NotNull JsonReader in)
/*     */         throws IOException
/*     */       {
/*     */         // Byte code:
/*     */         //   0: aload_1
/*     */         //   1: ldc 44
/*     */         //   3: invokestatic 24	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */         //   6: aload_1
/*     */         //   7: invokevirtual 50	com/google/gson/stream/JsonReader:beginObject	()V
/*     */         //   10: aconst_null
/*     */         //   11: checkcast 52	java/lang/String
/*     */         //   14: astore_2
/*     */         //   15: invokestatic 58	com/google/common/collect/ImmutableList:builder	()Lcom/google/common/collect/ImmutableList$Builder;
/*     */         //   18: astore_3
/*     */         //   19: iconst_0
/*     */         //   20: istore 4
/*     */         //   22: aload_1
/*     */         //   23: invokevirtual 62	com/google/gson/stream/JsonReader:hasNext	()Z
/*     */         //   26: ifeq +166 -> 192
/*     */         //   29: aload_1
/*     */         //   30: invokevirtual 66	com/google/gson/stream/JsonReader:nextName	()Ljava/lang/String;
/*     */         //   33: astore 5
/*     */         //   35: aload 5
/*     */         //   37: dup
/*     */         //   38: ifnonnull +7 -> 45
/*     */         //   41: pop
/*     */         //   42: goto +142 -> 184
/*     */         //   45: invokevirtual 70	java/lang/String:hashCode	()I
/*     */         //   48: lookupswitch	default:+136->184, -1609594047:+83->131, -895858535:+44->92, 3575610:+57->105, 688591589:+70->118
/*     */         //   92: aload 5
/*     */         //   94: ldc 72
/*     */         //   96: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */         //   99: ifeq +85 -> 184
/*     */         //   102: goto +50 -> 152
/*     */         //   105: aload 5
/*     */         //   107: ldc 78
/*     */         //   109: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */         //   112: ifeq +72 -> 184
/*     */         //   115: goto +29 -> 144
/*     */         //   118: aload 5
/*     */         //   120: ldc 80
/*     */         //   122: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */         //   125: ifeq +59 -> 184
/*     */         //   128: goto +39 -> 167
/*     */         //   131: aload 5
/*     */         //   133: ldc 82
/*     */         //   135: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */         //   138: ifeq +46 -> 184
/*     */         //   141: goto +35 -> 176
/*     */         //   144: aload_1
/*     */         //   145: invokevirtual 85	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
/*     */         //   148: astore_2
/*     */         //   149: goto +40 -> 189
/*     */         //   152: aload_0
/*     */         //   153: aload_1
/*     */         //   154: aload_3
/*     */         //   155: dup
/*     */         //   156: ldc 87
/*     */         //   158: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */         //   161: invokespecial 94	com/android/build/gradle/internal/ide/EarlySyncBuildOutput$Companion$ApkInfoAdapter:readFilters	(Lcom/google/gson/stream/JsonReader;Lcom/google/common/collect/ImmutableList$Builder;)V
/*     */         //   164: goto +25 -> 189
/*     */         //   167: aload_1
/*     */         //   168: invokevirtual 97	com/google/gson/stream/JsonReader:nextInt	()I
/*     */         //   171: istore 4
/*     */         //   173: goto +16 -> 189
/*     */         //   176: aload_1
/*     */         //   177: invokevirtual 100	com/google/gson/stream/JsonReader:nextBoolean	()Z
/*     */         //   180: pop
/*     */         //   181: goto +8 -> 189
/*     */         //   184: aload_1
/*     */         //   185: invokevirtual 85	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
/*     */         //   188: pop
/*     */         //   189: goto -167 -> 22
/*     */         //   192: aload_1
/*     */         //   193: invokevirtual 103	com/google/gson/stream/JsonReader:endObject	()V
/*     */         //   196: aload_2
/*     */         //   197: ifnonnull +16 -> 213
/*     */         //   200: new 9	java/io/IOException
/*     */         //   203: dup
/*     */         //   204: ldc 105
/*     */         //   206: invokespecial 30	java/io/IOException:<init>	(Ljava/lang/String;)V
/*     */         //   209: checkcast 32	java/lang/Throwable
/*     */         //   212: athrow
/*     */         //   213: aload_2
/*     */         //   214: invokestatic 111	com/android/build/VariantOutput$OutputType:valueOf	(Ljava/lang/String;)Lcom/android/build/VariantOutput$OutputType;
/*     */         //   217: aload_3
/*     */         //   218: invokevirtual 117	com/google/common/collect/ImmutableList$Builder:build	()Lcom/google/common/collect/ImmutableList;
/*     */         //   221: checkcast 119	java/util/Collection
/*     */         //   224: iload 4
/*     */         //   226: invokestatic 123	com/android/ide/common/build/ApkInfo:of	(Lcom/android/build/VariantOutput$OutputType;Ljava/util/Collection;I)Lcom/android/ide/common/build/ApkInfo;
/*     */         //   229: dup
/*     */         //   230: ldc 125
/*     */         //   232: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */         //   235: areturn
/*     */         // Line number table:
/*     */         //   Java source line #117	-> byte code offset #6
/*     */         //   Java source line #118	-> byte code offset #10
/*     */         //   Java source line #119	-> byte code offset #15
/*     */         //   Java source line #120	-> byte code offset #19
/*     */         //   Java source line #122	-> byte code offset #22
/*     */         //   Java source line #123	-> byte code offset #29
/*     */         //   Java source line #124	-> byte code offset #144
/*     */         //   Java source line #125	-> byte code offset #152
/*     */         //   Java source line #126	-> byte code offset #167
/*     */         //   Java source line #127	-> byte code offset #176
/*     */         //   Java source line #128	-> byte code offset #184
/*     */         //   Java source line #129	-> byte code offset #189
/*     */         //   Java source line #122	-> byte code offset #189
/*     */         //   Java source line #131	-> byte code offset #192
/*     */         //   Java source line #133	-> byte code offset #196
/*     */         //   Java source line #134	-> byte code offset #200
/*     */         //   Java source line #136	-> byte code offset #213
/*     */         //   Java source line #137	-> byte code offset #213
/*     */         //   Java source line #138	-> byte code offset #217
/*     */         //   Java source line #139	-> byte code offset #224
/*     */         //   Java source line #136	-> byte code offset #226
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	236	0	this	ApkInfoAdapter
/*     */         //   0	236	1	in	JsonReader
/*     */         //   15	221	2	outputType	String
/*     */         //   19	217	3	filters	com.google.common.collect.ImmutableList.Builder
/*     */         //   22	214	4	versionCode	int
/*     */       }
/*     */       
/*     */       /* Error */
/*     */       private final void readFilters(JsonReader in, com.google.common.collect.ImmutableList.Builder<FilterData> filters)
/*     */         throws IOException
/*     */       {
/*     */         // Byte code:
/*     */         //   0: aload_1
/*     */         //   1: invokevirtual 133	com/google/gson/stream/JsonReader:beginArray	()V
/*     */         //   4: aload_1
/*     */         //   5: invokevirtual 62	com/google/gson/stream/JsonReader:hasNext	()Z
/*     */         //   8: ifeq +155 -> 163
/*     */         //   11: aload_1
/*     */         //   12: invokevirtual 50	com/google/gson/stream/JsonReader:beginObject	()V
/*     */         //   15: aconst_null
/*     */         //   16: checkcast 135	com/android/build/VariantOutput$FilterType
/*     */         //   19: astore_3
/*     */         //   20: aconst_null
/*     */         //   21: checkcast 52	java/lang/String
/*     */         //   24: astore 4
/*     */         //   26: aload_1
/*     */         //   27: invokevirtual 62	com/google/gson/stream/JsonReader:hasNext	()Z
/*     */         //   30: ifeq +102 -> 132
/*     */         //   33: aload_1
/*     */         //   34: invokevirtual 66	com/google/gson/stream/JsonReader:nextName	()Ljava/lang/String;
/*     */         //   37: astore 5
/*     */         //   39: aload 5
/*     */         //   41: dup
/*     */         //   42: ifnonnull +7 -> 49
/*     */         //   45: pop
/*     */         //   46: goto +83 -> 129
/*     */         //   49: invokevirtual 70	java/lang/String:hashCode	()I
/*     */         //   52: lookupswitch	default:+77->129, -1553050926:+28->80, 111972721:+41->93
/*     */         //   80: aload 5
/*     */         //   82: ldc -119
/*     */         //   84: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */         //   87: ifeq +42 -> 129
/*     */         //   90: goto +16 -> 106
/*     */         //   93: aload 5
/*     */         //   95: ldc -118
/*     */         //   97: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */         //   100: ifeq +29 -> 129
/*     */         //   103: goto +20 -> 123
/*     */         //   106: aload_1
/*     */         //   107: invokevirtual 85	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
/*     */         //   110: dup
/*     */         //   111: ldc -116
/*     */         //   113: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */         //   116: invokestatic 143	com/android/build/VariantOutput$FilterType:valueOf	(Ljava/lang/String;)Lcom/android/build/VariantOutput$FilterType;
/*     */         //   119: astore_3
/*     */         //   120: goto +9 -> 129
/*     */         //   123: aload_1
/*     */         //   124: invokevirtual 85	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
/*     */         //   127: astore 4
/*     */         //   129: goto -103 -> 26
/*     */         //   132: aload_3
/*     */         //   133: ifnull +23 -> 156
/*     */         //   136: aload 4
/*     */         //   138: ifnull +18 -> 156
/*     */         //   141: aload_2
/*     */         //   142: new 145	com/android/build/gradle/internal/ide/FilterDataImpl
/*     */         //   145: dup
/*     */         //   146: aload_3
/*     */         //   147: aload 4
/*     */         //   149: invokespecial 148	com/android/build/gradle/internal/ide/FilterDataImpl:<init>	(Lcom/android/build/VariantOutput$FilterType;Ljava/lang/String;)V
/*     */         //   152: invokevirtual 152	com/google/common/collect/ImmutableList$Builder:add	(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList$Builder;
/*     */         //   155: pop
/*     */         //   156: aload_1
/*     */         //   157: invokevirtual 103	com/google/gson/stream/JsonReader:endObject	()V
/*     */         //   160: goto -156 -> 4
/*     */         //   163: aload_1
/*     */         //   164: invokevirtual 155	com/google/gson/stream/JsonReader:endArray	()V
/*     */         //   167: return
/*     */         // Line number table:
/*     */         //   Java source line #146	-> byte code offset #0
/*     */         //   Java source line #147	-> byte code offset #4
/*     */         //   Java source line #148	-> byte code offset #11
/*     */         //   Java source line #149	-> byte code offset #15
/*     */         //   Java source line #150	-> byte code offset #20
/*     */         //   Java source line #151	-> byte code offset #26
/*     */         //   Java source line #152	-> byte code offset #33
/*     */         //   Java source line #153	-> byte code offset #106
/*     */         //   Java source line #154	-> byte code offset #123
/*     */         //   Java source line #155	-> byte code offset #129
/*     */         //   Java source line #151	-> byte code offset #129
/*     */         //   Java source line #157	-> byte code offset #132
/*     */         //   Java source line #158	-> byte code offset #141
/*     */         //   Java source line #160	-> byte code offset #156
/*     */         //   Java source line #147	-> byte code offset #160
/*     */         //   Java source line #162	-> byte code offset #163
/*     */         //   Java source line #163	-> byte code offset #167
/*     */         // Local variable table:
/*     */         //   start	length	slot	name	signature
/*     */         //   0	168	0	this	ApkInfoAdapter
/*     */         //   0	168	1	in	JsonReader
/*     */         //   0	168	2	filters	com.google.common.collect.ImmutableList.Builder
/*     */         //   20	140	3	filterType	com.android.build.VariantOutput.FilterType
/*     */         //   26	134	4	value	String
/*     */       }
/*     */     }
/*     */     
/*     */     @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000$\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\b\000\030\0002\b\022\004\022\0020\0020\001B\005¢\006\002\020\003J\020\020\004\032\0020\0022\006\020\005\032\0020\006H\027J\034\020\007\032\0020\b2\b\020\t\032\004\030\0010\n2\b\020\013\032\004\030\0010\002H\026¨\006\f"}, d2={"Lcom/android/build/gradle/internal/ide/EarlySyncBuildOutput$Companion$OutputTypeTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/android/build/gradle/internal/scope/TaskOutputHolder$OutputType;", "()V", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "gradle-core"})
/*     */     public static final class OutputTypeTypeAdapter
/*     */       extends com.google.gson.TypeAdapter<TaskOutputHolder.OutputType>
/*     */     {
/*     */       public void write(@Nullable JsonWriter out, @Nullable TaskOutputHolder.OutputType value)
/*     */       {
/* 168 */         throw ((Throwable)new IOException("Unexpected call to write"));
/*     */       }
/*     */       
/*     */       @NotNull
/*     */       public TaskOutputHolder.OutputType read(@NotNull JsonReader in) throws IOException {
/* 173 */         Intrinsics.checkParameterIsNotNull(in, "in");in.beginObject(); String 
/* 174 */           tmp14_11 = in.nextName();Intrinsics.checkExpressionValueIsNotNull(tmp14_11, "`in`.nextName()"); if (!kotlin.text.StringsKt.endsWith$default(tmp14_11, "type", false, 2, null)) {
/* 175 */           throw ((Throwable)new IOException("Invalid format"));
/*     */         }
/* 177 */         String nextString = in.nextString();
/*     */         Object localObject;
/* 179 */         try { String tmp51_50 = nextString;Intrinsics.checkExpressionValueIsNotNull(tmp51_50, "nextString");localObject = com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType.valueOf(tmp51_50);
/*     */         } catch (IllegalArgumentException e) {
/* 181 */           String tmp68_67 = nextString;Intrinsics.checkExpressionValueIsNotNull(tmp68_67, "nextString");localObject = com.android.build.gradle.internal.scope.TaskOutputHolder.AnchorOutputType.valueOf(tmp68_67);
/*     */         }
/* 178 */         TaskOutputHolder.OutputType outputType = (TaskOutputHolder.OutputType)localObject;
/*     */         
/* 183 */         in.endObject();
/* 184 */         return outputType;
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.EarlySyncBuildOutput
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */