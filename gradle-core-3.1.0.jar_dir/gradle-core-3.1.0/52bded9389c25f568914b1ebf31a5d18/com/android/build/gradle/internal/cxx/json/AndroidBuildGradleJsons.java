/*     */ package com.android.build.gradle.internal.cxx.json;
/*     */ 
/*     */ import com.android.build.gradle.tasks.ExternalNativeBuildTaskUtils;
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.wireless.android.sdk.stats.GradleBuildVariant.Builder;
/*     */ import com.google.wireless.android.sdk.stats.GradleBuildVariant.NativeBuildConfigInfo;
/*     */ import com.google.wireless.android.sdk.stats.GradleBuildVariant.NativeBuildConfigInfo.Builder;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.OpenOption;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class AndroidBuildGradleJsons
/*     */ {
/*     */   public static NativeBuildConfigValueMini parseToMiniConfigAndGatherStatistics(JsonReader reader, GradleBuildVariant.Builder stats)
/*     */     throws IOException
/*     */   {
/*  51 */     GradleBuildVariant.NativeBuildConfigInfo.Builder config = GradleBuildVariant.NativeBuildConfigInfo.newBuilder();
/*  52 */     AndroidBuildGradleJsonStatsBuildingVisitor statsVisitor = new AndroidBuildGradleJsonStatsBuildingVisitor(config);
/*     */     
/*  54 */     MiniConfigBuildingVisitor miniConfigVisitor = new MiniConfigBuildingVisitor();
/*  55 */     AndroidBuildGradleJsonCompositeVisitor composite = new AndroidBuildGradleJsonCompositeVisitor(new AndroidBuildGradleJsonStreamingVisitor[] { statsVisitor, miniConfigVisitor });
/*     */     
/*  58 */     AndroidBuildGradleJsonStreamingParser parser = new AndroidBuildGradleJsonStreamingParser(reader, composite);Throwable localThrowable3 = null;
/*     */     try {
/*  60 */       parser.parse();
/*  61 */       stats.addNativeBuildConfig(config);
/*  62 */       return miniConfig;
/*     */     }
/*     */     catch (Throwable localThrowable4)
/*     */     {
/*  58 */       localThrowable3 = localThrowable4;throw localThrowable4;
/*     */     }
/*     */     finally
/*     */     {
/*  63 */       if (parser != null) { if (localThrowable3 != null) try { parser.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else { parser.close();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static NativeBuildConfigValueMini parseToMiniConfig(JsonReader reader)
/*     */     throws IOException
/*     */   {
/*  77 */     MiniConfigBuildingVisitor miniConfigVisitor = new MiniConfigBuildingVisitor();
/*  78 */     AndroidBuildGradleJsonStreamingParser parser = new AndroidBuildGradleJsonStreamingParser(reader, miniConfigVisitor);Throwable localThrowable3 = null;
/*     */     try {
/*  80 */       parser.parse();
/*  81 */       return miniConfig;
/*     */     }
/*     */     catch (Throwable localThrowable4)
/*     */     {
/*  78 */       localThrowable3 = localThrowable4;throw localThrowable4;
/*     */     }
/*     */     finally
/*     */     {
/*  82 */       if (parser != null) { if (localThrowable3 != null) try { parser.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else { parser.close();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static List<NativeBuildConfigValueMini> getNativeBuildMiniConfigs(List<File> jsons, GradleBuildVariant.Builder stats)
/*     */     throws IOException
/*     */   {
/*  93 */     List<NativeBuildConfigValueMini> miniConfigs = Lists.newArrayList();
/*     */     
/*  95 */     for (File json : jsons) {
/*  96 */       miniConfigs.add(getNativeBuildMiniConfig(json, stats));
/*     */     }
/*  98 */     return miniConfigs;
/*     */   }
/*     */   
/*     */   public static NativeBuildConfigValueMini getNativeBuildMiniConfig(File json, GradleBuildVariant.Builder stats)
/*     */     throws IOException
/*     */   {
/* 113 */     File persistedMiniConfig = ExternalNativeBuildTaskUtils.getJsonMiniConfigFile(json);
/* 114 */     if (ExternalNativeBuildTaskUtils.fileIsUpToDate(json, persistedMiniConfig))
/*     */     {
/* 117 */       JsonReader reader = new JsonReader(new FileReader(persistedMiniConfig));Throwable localThrowable6 = null;
/* 118 */       try { return parseToMiniConfig(reader);
/*     */       }
/*     */       catch (Throwable localThrowable7)
/*     */       {
/* 117 */         localThrowable6 = localThrowable7;throw localThrowable7;
/*     */       } finally {
/* 119 */         if (reader != null) if (localThrowable6 != null) try { reader.close(); } catch (Throwable localThrowable2) { localThrowable6.addSuppressed(localThrowable2); } else reader.close();
/*     */       }
/*     */     }
/* 122 */     JsonReader reader = new JsonReader(new FileReader(json));Throwable localThrowable8 = null;
/*     */     
/*     */     try
/*     */     {
/* 126 */       result = stats == null ? parseToMiniConfig(reader) : parseToMiniConfigAndGatherStatistics(reader, stats);
/*     */     }
/*     */     catch (Throwable localThrowable4)
/*     */     {
/*     */       NativeBuildConfigValueMini result;
/* 122 */       localThrowable8 = localThrowable4;throw localThrowable4;
/*     */     }
/*     */     finally
/*     */     {
/* 127 */       if (reader != null) if (localThrowable8 != null) try { reader.close(); } catch (Throwable localThrowable5) { localThrowable8.addSuppressed(localThrowable5); } else reader.close(); }
/* 128 */     NativeBuildConfigValueMini result; writeNativeBuildMiniConfigValueToJsonFile(persistedMiniConfig, result);
/* 129 */     return result;
/*     */   }
/*     */   
/*     */   public static void writeNativeBuildConfigValueToJsonFile(File outputJson, NativeBuildConfigValue nativeBuildConfigValue)
/*     */     throws IOException
/*     */   {
/* 145 */     Gson gson = new GsonBuilder().registerTypeAdapter(File.class, new PlainFileGsonTypeAdaptor()).disableHtmlEscaping().setPrettyPrinting().create();
/*     */     
/* 147 */     FileWriter jsonWriter = new FileWriter(outputJson);Throwable localThrowable3 = null;
/* 148 */     try { gson.toJson(nativeBuildConfigValue, jsonWriter);
/*     */     }
/*     */     catch (Throwable localThrowable1)
/*     */     {
/* 147 */       localThrowable3 = localThrowable1;throw localThrowable1;
/*     */     } finally {
/* 149 */       if (jsonWriter != null) { if (localThrowable3 != null) try { jsonWriter.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else { jsonWriter.close();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void writeNativeBuildMiniConfigValueToJsonFile(File outputJson, NativeBuildConfigValueMini miniConfig)
/*     */     throws IOException
/*     */   {
/* 165 */     String actualResult = new GsonBuilder().registerTypeAdapter(File.class, new PlainFileGsonTypeAdaptor()).setPrettyPrinting().create().toJson(miniConfig);
/* 166 */     Files.write(outputJson.toPath(), actualResult.getBytes(Charsets.UTF_8), new OpenOption[0]);
/*     */   }
/*     */   
/*     */   private static class MiniConfigBuildingVisitor
/*     */     extends AndroidBuildGradleJsonStreamingVisitor
/*     */   {
/*     */     private final NativeBuildConfigValueMini miniConfig;
/*     */     private String libraryName;
/*     */     
/*     */     MiniConfigBuildingVisitor()
/*     */     {
/* 178 */       miniConfig = new NativeBuildConfigValueMini();
/* 179 */       libraryName = null;
/*     */     }
/*     */     
/*     */     protected void beginLibrary(String libraryName)
/*     */     {
/* 184 */       super.beginLibrary(libraryName);
/* 185 */       this.libraryName = libraryName;
/* 186 */       miniConfig.libraries.put(libraryName, new NativeLibraryValueMini());
/*     */     }
/*     */     
/*     */     protected void visitLibraryAbi(String abi)
/*     */     {
/* 191 */       super.visitLibraryAbi(abi);
/* 192 */       miniConfig.libraries.get(libraryName)).abi = abi;
/*     */     }
/*     */     
/*     */     protected void visitLibraryArtifactName(String artifactName)
/*     */     {
/* 197 */       super.visitLibraryArtifactName(artifactName);
/* 198 */       miniConfig.libraries.get(libraryName)).artifactName = artifactName;
/*     */     }
/*     */     
/*     */     protected void visitLibraryBuildCommand(String buildCommand)
/*     */     {
/* 203 */       super.visitLibraryBuildCommand(buildCommand);
/* 204 */       miniConfig.libraries.get(libraryName)).buildCommand = buildCommand;
/*     */     }
/*     */     
/*     */     protected void visitCleanCommands(String cleanCommand)
/*     */     {
/* 209 */       super.visitCleanCommands(cleanCommand);
/* 210 */       miniConfig.cleanCommands.add(cleanCommand);
/*     */     }
/*     */     
/*     */     protected void visitLibraryOutput(String output)
/*     */     {
/* 215 */       super.visitLibraryOutput(output);
/* 216 */       miniConfig.libraries.get(libraryName)).output = new File(output);
/*     */     }
/*     */     
/*     */     protected void visitBuildFile(String buildFile)
/*     */     {
/* 221 */       super.visitBuildFile(buildFile);
/* 222 */       miniConfig.buildFiles.add(new File(buildFile));
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.cxx.json.AndroidBuildGradleJsons
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */