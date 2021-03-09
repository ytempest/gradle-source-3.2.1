/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.ide.common.build.ApkInfo;
/*     */ import com.google.gson.TypeAdapter;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import java.io.IOException;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\b\000\030\0002\b\022\004\022\0020\0020\001B\005¢\006\002\020\003J\020\020\004\032\0020\0022\006\020\005\032\0020\006H\027J\036\020\007\032\0020\b2\006\020\005\032\0020\0062\f\020\t\032\b\022\004\022\0020\0130\nH\003J\032\020\f\032\0020\b2\006\020\r\032\0020\0162\b\020\017\032\004\030\0010\002H\027¨\006\020"}, d2={"Lcom/android/build/gradle/internal/ide/EarlySyncBuildOutput$Companion$ApkInfoAdapter;", "Lcom/google/gson/TypeAdapter;", "Lcom/android/ide/common/build/ApkInfo;", "()V", "read", "in", "Lcom/google/gson/stream/JsonReader;", "readFilters", "", "filters", "Lcom/google/common/collect/ImmutableList$Builder;", "Lcom/android/build/FilterData;", "write", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "gradle-core"})
/*     */ public final class EarlySyncBuildOutput$Companion$ApkInfoAdapter
/*     */   extends TypeAdapter<ApkInfo>
/*     */ {
/*     */   public void write(@NotNull JsonWriter out, @Nullable ApkInfo value)
/*     */     throws IOException
/*     */   {
/* 112 */     Intrinsics.checkParameterIsNotNull(out, "out");throw ((Throwable)new IOException("Unexpected call to write"));
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   @NotNull
/*     */   public ApkInfo read(@NotNull com.google.gson.stream.JsonReader in)
/*     */     throws IOException
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ldc 44
/*     */     //   3: invokestatic 24	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   6: aload_1
/*     */     //   7: invokevirtual 50	com/google/gson/stream/JsonReader:beginObject	()V
/*     */     //   10: aconst_null
/*     */     //   11: checkcast 52	java/lang/String
/*     */     //   14: astore_2
/*     */     //   15: invokestatic 58	com/google/common/collect/ImmutableList:builder	()Lcom/google/common/collect/ImmutableList$Builder;
/*     */     //   18: astore_3
/*     */     //   19: iconst_0
/*     */     //   20: istore 4
/*     */     //   22: aload_1
/*     */     //   23: invokevirtual 62	com/google/gson/stream/JsonReader:hasNext	()Z
/*     */     //   26: ifeq +166 -> 192
/*     */     //   29: aload_1
/*     */     //   30: invokevirtual 66	com/google/gson/stream/JsonReader:nextName	()Ljava/lang/String;
/*     */     //   33: astore 5
/*     */     //   35: aload 5
/*     */     //   37: dup
/*     */     //   38: ifnonnull +7 -> 45
/*     */     //   41: pop
/*     */     //   42: goto +142 -> 184
/*     */     //   45: invokevirtual 70	java/lang/String:hashCode	()I
/*     */     //   48: lookupswitch	default:+136->184, -1609594047:+83->131, -895858535:+44->92, 3575610:+57->105, 688591589:+70->118
/*     */     //   92: aload 5
/*     */     //   94: ldc 72
/*     */     //   96: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */     //   99: ifeq +85 -> 184
/*     */     //   102: goto +50 -> 152
/*     */     //   105: aload 5
/*     */     //   107: ldc 78
/*     */     //   109: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */     //   112: ifeq +72 -> 184
/*     */     //   115: goto +29 -> 144
/*     */     //   118: aload 5
/*     */     //   120: ldc 80
/*     */     //   122: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */     //   125: ifeq +59 -> 184
/*     */     //   128: goto +39 -> 167
/*     */     //   131: aload 5
/*     */     //   133: ldc 82
/*     */     //   135: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */     //   138: ifeq +46 -> 184
/*     */     //   141: goto +35 -> 176
/*     */     //   144: aload_1
/*     */     //   145: invokevirtual 85	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
/*     */     //   148: astore_2
/*     */     //   149: goto +40 -> 189
/*     */     //   152: aload_0
/*     */     //   153: aload_1
/*     */     //   154: aload_3
/*     */     //   155: dup
/*     */     //   156: ldc 87
/*     */     //   158: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   161: invokespecial 94	com/android/build/gradle/internal/ide/EarlySyncBuildOutput$Companion$ApkInfoAdapter:readFilters	(Lcom/google/gson/stream/JsonReader;Lcom/google/common/collect/ImmutableList$Builder;)V
/*     */     //   164: goto +25 -> 189
/*     */     //   167: aload_1
/*     */     //   168: invokevirtual 97	com/google/gson/stream/JsonReader:nextInt	()I
/*     */     //   171: istore 4
/*     */     //   173: goto +16 -> 189
/*     */     //   176: aload_1
/*     */     //   177: invokevirtual 100	com/google/gson/stream/JsonReader:nextBoolean	()Z
/*     */     //   180: pop
/*     */     //   181: goto +8 -> 189
/*     */     //   184: aload_1
/*     */     //   185: invokevirtual 85	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
/*     */     //   188: pop
/*     */     //   189: goto -167 -> 22
/*     */     //   192: aload_1
/*     */     //   193: invokevirtual 103	com/google/gson/stream/JsonReader:endObject	()V
/*     */     //   196: aload_2
/*     */     //   197: ifnonnull +16 -> 213
/*     */     //   200: new 9	java/io/IOException
/*     */     //   203: dup
/*     */     //   204: ldc 105
/*     */     //   206: invokespecial 30	java/io/IOException:<init>	(Ljava/lang/String;)V
/*     */     //   209: checkcast 32	java/lang/Throwable
/*     */     //   212: athrow
/*     */     //   213: aload_2
/*     */     //   214: invokestatic 111	com/android/build/VariantOutput$OutputType:valueOf	(Ljava/lang/String;)Lcom/android/build/VariantOutput$OutputType;
/*     */     //   217: aload_3
/*     */     //   218: invokevirtual 117	com/google/common/collect/ImmutableList$Builder:build	()Lcom/google/common/collect/ImmutableList;
/*     */     //   221: checkcast 119	java/util/Collection
/*     */     //   224: iload 4
/*     */     //   226: invokestatic 123	com/android/ide/common/build/ApkInfo:of	(Lcom/android/build/VariantOutput$OutputType;Ljava/util/Collection;I)Lcom/android/ide/common/build/ApkInfo;
/*     */     //   229: dup
/*     */     //   230: ldc 125
/*     */     //   232: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   235: areturn
/*     */     // Line number table:
/*     */     //   Java source line #117	-> byte code offset #6
/*     */     //   Java source line #118	-> byte code offset #10
/*     */     //   Java source line #119	-> byte code offset #15
/*     */     //   Java source line #120	-> byte code offset #19
/*     */     //   Java source line #122	-> byte code offset #22
/*     */     //   Java source line #123	-> byte code offset #29
/*     */     //   Java source line #124	-> byte code offset #144
/*     */     //   Java source line #125	-> byte code offset #152
/*     */     //   Java source line #126	-> byte code offset #167
/*     */     //   Java source line #127	-> byte code offset #176
/*     */     //   Java source line #128	-> byte code offset #184
/*     */     //   Java source line #129	-> byte code offset #189
/*     */     //   Java source line #122	-> byte code offset #189
/*     */     //   Java source line #131	-> byte code offset #192
/*     */     //   Java source line #133	-> byte code offset #196
/*     */     //   Java source line #134	-> byte code offset #200
/*     */     //   Java source line #136	-> byte code offset #213
/*     */     //   Java source line #137	-> byte code offset #213
/*     */     //   Java source line #138	-> byte code offset #217
/*     */     //   Java source line #139	-> byte code offset #224
/*     */     //   Java source line #136	-> byte code offset #226
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	236	0	this	ApkInfoAdapter
/*     */     //   0	236	1	in	com.google.gson.stream.JsonReader
/*     */     //   15	221	2	outputType	String
/*     */     //   19	217	3	filters	com.google.common.collect.ImmutableList.Builder
/*     */     //   22	214	4	versionCode	int
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   private final void readFilters(com.google.gson.stream.JsonReader in, com.google.common.collect.ImmutableList.Builder<com.android.build.FilterData> filters)
/*     */     throws IOException
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokevirtual 133	com/google/gson/stream/JsonReader:beginArray	()V
/*     */     //   4: aload_1
/*     */     //   5: invokevirtual 62	com/google/gson/stream/JsonReader:hasNext	()Z
/*     */     //   8: ifeq +155 -> 163
/*     */     //   11: aload_1
/*     */     //   12: invokevirtual 50	com/google/gson/stream/JsonReader:beginObject	()V
/*     */     //   15: aconst_null
/*     */     //   16: checkcast 135	com/android/build/VariantOutput$FilterType
/*     */     //   19: astore_3
/*     */     //   20: aconst_null
/*     */     //   21: checkcast 52	java/lang/String
/*     */     //   24: astore 4
/*     */     //   26: aload_1
/*     */     //   27: invokevirtual 62	com/google/gson/stream/JsonReader:hasNext	()Z
/*     */     //   30: ifeq +102 -> 132
/*     */     //   33: aload_1
/*     */     //   34: invokevirtual 66	com/google/gson/stream/JsonReader:nextName	()Ljava/lang/String;
/*     */     //   37: astore 5
/*     */     //   39: aload 5
/*     */     //   41: dup
/*     */     //   42: ifnonnull +7 -> 49
/*     */     //   45: pop
/*     */     //   46: goto +83 -> 129
/*     */     //   49: invokevirtual 70	java/lang/String:hashCode	()I
/*     */     //   52: lookupswitch	default:+77->129, -1553050926:+28->80, 111972721:+41->93
/*     */     //   80: aload 5
/*     */     //   82: ldc -119
/*     */     //   84: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */     //   87: ifeq +42 -> 129
/*     */     //   90: goto +16 -> 106
/*     */     //   93: aload 5
/*     */     //   95: ldc -118
/*     */     //   97: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */     //   100: ifeq +29 -> 129
/*     */     //   103: goto +20 -> 123
/*     */     //   106: aload_1
/*     */     //   107: invokevirtual 85	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
/*     */     //   110: dup
/*     */     //   111: ldc -116
/*     */     //   113: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*     */     //   116: invokestatic 143	com/android/build/VariantOutput$FilterType:valueOf	(Ljava/lang/String;)Lcom/android/build/VariantOutput$FilterType;
/*     */     //   119: astore_3
/*     */     //   120: goto +9 -> 129
/*     */     //   123: aload_1
/*     */     //   124: invokevirtual 85	com/google/gson/stream/JsonReader:nextString	()Ljava/lang/String;
/*     */     //   127: astore 4
/*     */     //   129: goto -103 -> 26
/*     */     //   132: aload_3
/*     */     //   133: ifnull +23 -> 156
/*     */     //   136: aload 4
/*     */     //   138: ifnull +18 -> 156
/*     */     //   141: aload_2
/*     */     //   142: new 145	com/android/build/gradle/internal/ide/FilterDataImpl
/*     */     //   145: dup
/*     */     //   146: aload_3
/*     */     //   147: aload 4
/*     */     //   149: invokespecial 148	com/android/build/gradle/internal/ide/FilterDataImpl:<init>	(Lcom/android/build/VariantOutput$FilterType;Ljava/lang/String;)V
/*     */     //   152: invokevirtual 152	com/google/common/collect/ImmutableList$Builder:add	(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList$Builder;
/*     */     //   155: pop
/*     */     //   156: aload_1
/*     */     //   157: invokevirtual 103	com/google/gson/stream/JsonReader:endObject	()V
/*     */     //   160: goto -156 -> 4
/*     */     //   163: aload_1
/*     */     //   164: invokevirtual 155	com/google/gson/stream/JsonReader:endArray	()V
/*     */     //   167: return
/*     */     // Line number table:
/*     */     //   Java source line #146	-> byte code offset #0
/*     */     //   Java source line #147	-> byte code offset #4
/*     */     //   Java source line #148	-> byte code offset #11
/*     */     //   Java source line #149	-> byte code offset #15
/*     */     //   Java source line #150	-> byte code offset #20
/*     */     //   Java source line #151	-> byte code offset #26
/*     */     //   Java source line #152	-> byte code offset #33
/*     */     //   Java source line #153	-> byte code offset #106
/*     */     //   Java source line #154	-> byte code offset #123
/*     */     //   Java source line #155	-> byte code offset #129
/*     */     //   Java source line #151	-> byte code offset #129
/*     */     //   Java source line #157	-> byte code offset #132
/*     */     //   Java source line #158	-> byte code offset #141
/*     */     //   Java source line #160	-> byte code offset #156
/*     */     //   Java source line #147	-> byte code offset #160
/*     */     //   Java source line #162	-> byte code offset #163
/*     */     //   Java source line #163	-> byte code offset #167
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	168	0	this	ApkInfoAdapter
/*     */     //   0	168	1	in	com.google.gson.stream.JsonReader
/*     */     //   0	168	2	filters	com.google.common.collect.ImmutableList.Builder
/*     */     //   20	140	3	filterType	com.android.build.VariantOutput.FilterType
/*     */     //   26	134	4	value	String
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.EarlySyncBuildOutput.Companion.ApkInfoAdapter
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */