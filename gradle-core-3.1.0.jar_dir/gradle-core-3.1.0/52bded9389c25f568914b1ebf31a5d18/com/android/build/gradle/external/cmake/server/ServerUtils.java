/*     */ package com.android.build.gradle.external.cmake.server;
/*     */ 
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import com.google.gson.JsonSyntaxException;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.nio.file.Files;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ServerUtils
/*     */ {
/*     */   public static List<CompileCommand> getCompilationDatabase(File buildDirectory, String compileCommandsFilename)
/*     */     throws IOException, JsonSyntaxException
/*     */   {
/*  44 */     File compileCommandsFile = new File(buildDirectory, compileCommandsFilename);
/*  45 */     if (!compileCommandsFile.isFile()) {
/*  46 */       throw new RuntimeException(String.format("File %s not found", new Object[] { compileCommandsFile }));
/*     */     }
/*  48 */     return getCompilationDatabase(compileCommandsFile);
/*     */   }
/*     */   
/*     */   public static List<CompileCommand> getCompilationDatabase(File compileCommandsFile)
/*     */     throws IOException, JsonSyntaxException
/*     */   {
/*  64 */     String text = new String(Files.readAllBytes(compileCommandsFile.toPath()), StandardCharsets.UTF_8);
/*  65 */     Gson gson = new GsonBuilder().create();
/*     */     
/*  67 */     return Arrays.asList((Object[])gson.fromJson(text, CompileCommand[].class));
/*     */   }
/*     */   
/*     */   public static boolean isHelloResultValid(HelloResult helloResult)
/*     */   {
/*  77 */     if ((helloResult != null) && (type != null) && (supportedProtocolVersions != null)) {} return 
/*     */     
/*  80 */       (type.equals("hello")) && (supportedProtocolVersions.length >= 1);
/*     */   }
/*     */   
/*     */   public static boolean isHandshakeResultValid(HandshakeResult handshakeResult)
/*     */   {
/*  91 */     return (cookie != null) && (inReplyTo != null) && (type != null);
/*     */   }
/*     */   
/*     */   public static boolean isConfigureResultValid(ConfigureResult configureResult)
/*     */   {
/* 102 */     if ((configureResult != null) && (type != null) && (inReplyTo != null)) {} return 
/*     */     
/* 105 */       (type.equals("reply")) && 
/* 106 */       (inReplyTo.equals("configure"));
/*     */   }
/*     */   
/*     */   public static boolean isComputedResultValid(ComputeResult computeResult)
/*     */   {
/* 115 */     if ((inReplyTo != null) && (type != null)) {} return 
/*     */     
/* 117 */       (inReplyTo.equals("compute")) && 
/* 118 */       (type.equals("reply"));
/*     */   }
/*     */   
/*     */   public static boolean isCodeModelValid(CodeModel codeModel)
/*     */   {
/* 128 */     if ((type != null) && (inReplyTo != null))
/*     */     {
/* 130 */       if ((!inReplyTo.equals("codemodel")) || 
/* 131 */         (!type.equals("reply")) || (configurations == null)) {}
/*     */     }
/* 128 */     return 
/*     */     
/* 133 */       isCodeModelConfigurationsValid(configurations);
/*     */   }
/*     */   
/*     */   public static boolean isCmakeInputsResultValid(CmakeInputsResult cmakeInputsResult)
/*     */   {
/* 143 */     if ((type != null) && (inReplyTo != null)) {} return 
/*     */     
/* 145 */       inReplyTo.equals("cmakeInputs");
/*     */   }
/*     */   
/*     */   private static boolean isCodeModelConfigurationsValid(Configuration[] configurations)
/*     */   {
/* 155 */     if (configurations.length <= 0) {
/* 156 */       return false;
/*     */     }
/*     */     
/* 159 */     for (Configuration configuration : configurations) {
/* 160 */       if ((projects == null) || (projects.length <= 0)) {
/* 161 */         return false;
/*     */       }
/*     */       
/* 164 */       for (Project project : projects) {
/* 165 */         if (!isCodeModelProjectValid(project)) {
/* 166 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 171 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean isCodeModelProjectValid(Project project)
/*     */   {
/* 181 */     if ((project == null) || (buildDirectory == null) || (sourceDirectory == null)) {
/* 182 */       return false;
/*     */     }
/*     */     
/* 186 */     if (targets == null) {
/* 187 */       return true;
/*     */     }
/*     */     
/* 190 */     for (Target target : targets) {
/* 191 */       if (!isCodeModelTargetValid(target)) {
/* 192 */         return false;
/*     */       }
/*     */     }
/* 195 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean isCodeModelTargetValid(Target target)
/*     */   {
/* 207 */     if ((target != null) && ((artifacts == null) || (fileGroups == null))) {
/* 208 */       return true;
/*     */     }
/* 210 */     if ((target == null) || (name == null) || (buildDirectory == null)) {
/* 211 */       return false;
/*     */     }
/*     */     
/* 214 */     for (FileGroup fileGroup : fileGroups) {
/* 215 */       if (!isCodeModelFileGroupValid(fileGroup)) {
/* 216 */         return false;
/*     */       }
/*     */     }
/* 219 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean isCodeModelFileGroupValid(FileGroup fileGroup)
/*     */   {
/* 229 */     return (fileGroup != null) && (sources != null) && (sources.length > 0);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.server.ServerUtils
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */