/*     */ package com.android.build.gradle.external.cmake;
/*     */ 
/*     */ import com.android.build.gradle.external.cmake.server.CodeModel;
/*     */ import com.android.build.gradle.external.cmake.server.Configuration;
/*     */ import com.android.build.gradle.external.cmake.server.FileGroup;
/*     */ import com.android.build.gradle.external.cmake.server.Project;
/*     */ import com.android.build.gradle.external.cmake.server.Target;
/*     */ import com.android.build.gradle.internal.cxx.json.NativeToolchainValue;
/*     */ import com.android.build.gradle.internal.cxx.json.PlainFileGsonTypeAdaptor;
/*     */ import com.android.repository.Revision;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class CmakeUtils
/*     */ {
/*     */   private static final String CMAKE_VERSION_LINE_PREFIX = "cmake version ";
/*     */   
/*     */   public static Revision getVersion(File cmakeInstallPath)
/*     */     throws IOException
/*     */   {
/*  50 */     String versionString = getVersionString(cmakeInstallPath);
/*  51 */     return Revision.parseRevision(versionString);
/*     */   }
/*     */   
/*     */   public static Revision getVersion(String cmakeVersionString)
/*     */   {
/*  56 */     return Revision.parseRevision(cmakeVersionString);
/*     */   }
/*     */   
/*     */   public static String getBuildCommand(File cmakeExecutable, File outputFolder, String targetName)
/*     */   {
/*  66 */     return 
/*     */     
/*  68 */       cmakeExecutable.getAbsolutePath() + " --build " + outputFolder.getAbsolutePath() + " --target " + targetName;
/*     */   }
/*     */   
/*     */   public static String getCleanCommand(File cmakeExecutable, File outputFolder)
/*     */   {
/*  80 */     return 
/*     */     
/*  82 */       cmakeExecutable.getAbsolutePath() + " --build " + outputFolder.getAbsolutePath() + " --target clean";
/*     */   }
/*     */   
/*     */   public static Set<String> getCppExtensionSet(CodeModel codeModel)
/*     */   {
/*  89 */     return getLangExtensions(codeModel, "CXX");
/*     */   }
/*     */   
/*     */   public static Set<String> getCExtensionSet(CodeModel codeModel)
/*     */   {
/*  95 */     return getLangExtensions(codeModel, "C");
/*     */   }
/*     */   
/*     */   public static int getToolchainHash(NativeToolchainValue toolchainValue)
/*     */   {
/* 103 */     StringBuilder toolchainString = new StringBuilder();
/* 104 */     if (cppCompilerExecutable != null)
/*     */     {
/* 108 */       toolchainString = toolchainString.append(cppCompilerExecutable.getAbsolutePath()).append(" ");
/*     */     }
/* 110 */     if (cCompilerExecutable != null)
/*     */     {
/* 112 */       toolchainString = toolchainString.append(cCompilerExecutable.getAbsolutePath());
/*     */     }
/*     */     
/* 115 */     return toolchainString.toString().hashCode();
/*     */   }
/*     */   
/*     */   public static <ContentType> String getObjectToString(ContentType content)
/*     */   {
/* 129 */     Gson gson = new GsonBuilder().registerTypeAdapter(File.class, new PlainFileGsonTypeAdaptor()).disableHtmlEscaping().setPrettyPrinting().create();
/* 130 */     return gson.toJson(content);
/*     */   }
/*     */   
/*     */   private static String getVersionString(File cmakeInstallPath)
/*     */     throws IOException
/*     */   {
/* 142 */     String versionOutput = getCmakeVersionLinePrefix(cmakeInstallPath);
/* 143 */     if (!versionOutput.startsWith("cmake version ")) {
/* 144 */       throw new RuntimeException("Did not recognize stdout line as a cmake version: " + versionOutput);
/*     */     }
/*     */     
/* 147 */     return versionOutput.substring("cmake version ".length());
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   private static String getCmakeVersionLinePrefix(File cmakeInstallPath)
/*     */     throws IOException
/*     */   {
/*     */     // Byte code:
/*     */     //   0: new 21	java/io/File
/*     */     //   3: dup
/*     */     //   4: aload_0
/*     */     //   5: ldc 38
/*     */     //   7: invokespecial 39	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
/*     */     //   10: astore_1
/*     */     //   11: new 40	java/lang/ProcessBuilder
/*     */     //   14: dup
/*     */     //   15: iconst_2
/*     */     //   16: anewarray 41	java/lang/String
/*     */     //   19: dup
/*     */     //   20: iconst_0
/*     */     //   21: aload_1
/*     */     //   22: invokevirtual 6	java/io/File:getAbsolutePath	()Ljava/lang/String;
/*     */     //   25: aastore
/*     */     //   26: dup
/*     */     //   27: iconst_1
/*     */     //   28: ldc 42
/*     */     //   30: aastore
/*     */     //   31: invokespecial 43	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
/*     */     //   34: astore_2
/*     */     //   35: aload_2
/*     */     //   36: invokevirtual 44	java/lang/ProcessBuilder:redirectErrorStream	()Z
/*     */     //   39: pop
/*     */     //   40: aload_2
/*     */     //   41: invokevirtual 45	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
/*     */     //   44: astore_3
/*     */     //   45: aconst_null
/*     */     //   46: astore 4
/*     */     //   48: aconst_null
/*     */     //   49: astore 5
/*     */     //   51: new 46	java/io/InputStreamReader
/*     */     //   54: dup
/*     */     //   55: aload_3
/*     */     //   56: invokevirtual 47	java/lang/Process:getInputStream	()Ljava/io/InputStream;
/*     */     //   59: invokespecial 48	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
/*     */     //   62: astore 5
/*     */     //   64: new 49	java/io/BufferedReader
/*     */     //   67: dup
/*     */     //   68: aload 5
/*     */     //   70: invokespecial 50	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
/*     */     //   73: astore 4
/*     */     //   75: aload 4
/*     */     //   77: invokevirtual 51	java/io/BufferedReader:readLine	()Ljava/lang/String;
/*     */     //   80: astore 6
/*     */     //   82: aload 4
/*     */     //   84: ifnull +8 -> 92
/*     */     //   87: aload 4
/*     */     //   89: invokevirtual 52	java/io/BufferedReader:close	()V
/*     */     //   92: aload 5
/*     */     //   94: ifnull +8 -> 102
/*     */     //   97: aload 5
/*     */     //   99: invokevirtual 53	java/io/InputStreamReader:close	()V
/*     */     //   102: aload 6
/*     */     //   104: areturn
/*     */     //   105: astore 7
/*     */     //   107: aload 4
/*     */     //   109: ifnull +8 -> 117
/*     */     //   112: aload 4
/*     */     //   114: invokevirtual 52	java/io/BufferedReader:close	()V
/*     */     //   117: aload 7
/*     */     //   119: athrow
/*     */     //   120: astore 8
/*     */     //   122: aload 5
/*     */     //   124: ifnull +8 -> 132
/*     */     //   127: aload 5
/*     */     //   129: invokevirtual 53	java/io/InputStreamReader:close	()V
/*     */     //   132: aload 8
/*     */     //   134: athrow
/*     */     // Line number table:
/*     */     //   Java source line #166	-> byte code offset #0
/*     */     //   Java source line #167	-> byte code offset #11
/*     */     //   Java source line #168	-> byte code offset #22
/*     */     //   Java source line #169	-> byte code offset #35
/*     */     //   Java source line #170	-> byte code offset #40
/*     */     //   Java source line #171	-> byte code offset #45
/*     */     //   Java source line #172	-> byte code offset #48
/*     */     //   Java source line #174	-> byte code offset #51
/*     */     //   Java source line #176	-> byte code offset #64
/*     */     //   Java source line #177	-> byte code offset #75
/*     */     //   Java source line #179	-> byte code offset #82
/*     */     //   Java source line #180	-> byte code offset #87
/*     */     //   Java source line #184	-> byte code offset #92
/*     */     //   Java source line #185	-> byte code offset #97
/*     */     //   Java source line #177	-> byte code offset #102
/*     */     //   Java source line #179	-> byte code offset #105
/*     */     //   Java source line #180	-> byte code offset #112
/*     */     //   Java source line #184	-> byte code offset #120
/*     */     //   Java source line #185	-> byte code offset #127
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	135	0	cmakeInstallPath	File
/*     */     //   10	12	1	cmakeExecutable	File
/*     */     //   34	7	2	processBuilder	ProcessBuilder
/*     */     //   44	12	3	process	Process
/*     */     //   46	67	4	bufferedReader	java.io.BufferedReader
/*     */     //   49	79	5	inputStreamReader	java.io.InputStreamReader
/*     */     //   80	23	6	str	String
/*     */     //   105	13	7	localObject1	Object
/*     */     //   120	13	8	localObject2	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   64	82	105	finally
/*     */     //   105	107	105	finally
/*     */     //   51	92	120	finally
/*     */     //   105	122	120	finally
/*     */   }
/*     */   
/*     */   private static Set<String> getLangExtensions(CodeModel codeModel, String language)
/*     */   {
/* 201 */     Set<String> languageSet = new HashSet();
/* 202 */     if (configurations == null) {
/* 203 */       return languageSet;
/*     */     }
/* 205 */     for (Configuration configuration : configurations) {
/* 206 */       if (projects != null)
/*     */       {
/* 209 */         for (Project project : projects) {
/* 210 */           if (targets != null)
/*     */           {
/* 213 */             for (Target target : targets) {
/* 214 */               if (fileGroups != null)
/*     */               {
/* 217 */                 for (FileGroup fileGroup : fileGroups)
/* 218 */                   if ((sources != null) && (language != null))
/*     */                   {
/* 220 */                     if (language.equals(language))
/*     */                     {
/* 223 */                       for (String source : sources) {
/* 224 */                         String extension = source.substring(source.lastIndexOf('.') + 1).trim();
/* 225 */                         languageSet.add(extension);
/*     */                       } } } }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 232 */     return languageSet;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.CmakeUtils
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */