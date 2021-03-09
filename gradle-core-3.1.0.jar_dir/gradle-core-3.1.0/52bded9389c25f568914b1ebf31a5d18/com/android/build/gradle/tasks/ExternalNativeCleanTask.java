/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.core.Abi;
/*     */ import com.android.build.gradle.internal.cxx.json.AndroidBuildGradleJsons;
/*     */ import com.android.build.gradle.internal.cxx.json.NativeBuildConfigValueMini;
/*     */ import com.android.build.gradle.internal.cxx.json.NativeLibraryValueMini;
/*     */ import com.android.build.gradle.internal.ndk.NdkHandler;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.tasks.AndroidBuilderTask;
/*     */ import com.android.build.gradle.internal.variant.BaseVariantData;
/*     */ import com.android.builder.core.AndroidBuilder;
/*     */ import com.android.ide.common.process.ProcessException;
/*     */ import com.android.ide.common.process.ProcessInfoBuilder;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.android.utils.StringHelper;
/*     */ import com.google.common.base.Joiner;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.logging.Logger;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ 
/*     */ public class ExternalNativeCleanTask
/*     */   extends AndroidBuilderTask
/*     */ {
/*     */   private List<File> nativeBuildConfigurationsJsons;
/*     */   private File objFolder;
/*     */   private Map<Abi, File> stlSharedObjectFiles;
/*     */   
/*     */   protected void diagnostic(String format, Object... args)
/*     */   {
/*  62 */     getLogger().info(String.format(getName() + ": " + format, args));
/*     */   }
/*     */   
/*     */   @TaskAction
/*     */   void clean() throws ProcessException, IOException {
/*  67 */     diagnostic("starting clean", new Object[0]);
/*  68 */     diagnostic("finding existing JSONs", new Object[0]);
/*     */     
/*  70 */     List<File> existingJsons = Lists.newArrayList();
/*  71 */     for (File json : nativeBuildConfigurationsJsons) {
/*  72 */       if (json.isFile()) {
/*  73 */         existingJsons.add(json);
/*     */       }
/*     */     }
/*     */     
/*  78 */     Object configValueList = AndroidBuildGradleJsons.getNativeBuildMiniConfigs(existingJsons, null);
/*  79 */     List<String> cleanCommands = Lists.newArrayList();
/*  80 */     List<String> targetNames = Lists.newArrayList();
/*  81 */     for (NativeBuildConfigValueMini config : (List)configValueList) {
/*  82 */       cleanCommands.addAll(cleanCommands);
/*  83 */       Set<String> targets = Sets.newHashSet();
/*  84 */       for (NativeLibraryValueMini library : libraries.values()) {
/*  85 */         targets.add(String.format("%s %s", new Object[] { artifactName, abi }));
/*     */       }
/*  87 */       targetNames.add(Joiner.on(",").join(targets));
/*     */     }
/*  89 */     diagnostic("about to execute %s clean commands", new Object[] { Integer.valueOf(cleanCommands.size()) });
/*  90 */     executeProcessBatch(cleanCommands, targetNames);
/*     */     
/*  92 */     if (!stlSharedObjectFiles.isEmpty()) {
/*  93 */       diagnostic("remove STL shared object files", new Object[0]);
/*  94 */       for (Abi abi : stlSharedObjectFiles.keySet()) {
/*  95 */         File stlSharedObjectFile = (File)Preconditions.checkNotNull(stlSharedObjectFiles.get(abi));
/*  96 */         File objAbi = FileUtils.join(objFolder, new String[] { abi.getName(), stlSharedObjectFile
/*  97 */           .getName() });
/*     */         
/*  99 */         if (objAbi.delete()) {
/* 100 */           diagnostic("removed file %s", new Object[] { objAbi });
/*     */         } else {
/* 102 */           diagnostic("failed to remove file %s", new Object[] { objAbi });
/*     */         }
/*     */       }
/*     */     }
/* 106 */     diagnostic("clean complete", new Object[0]);
/*     */   }
/*     */   
/*     */   protected void executeProcessBatch(List<String> commands, List<String> targetNames)
/*     */     throws ProcessException, IOException
/*     */   {
/* 115 */     for (int commandIndex = 0; commandIndex < commands.size(); commandIndex++) {
/* 116 */       String command = (String)commands.get(commandIndex);
/* 117 */       String target = (String)targetNames.get(commandIndex);
/* 118 */       getLogger().lifecycle(String.format("Clean %s", new Object[] { target }));
/* 119 */       List<String> tokens = StringHelper.tokenizeCommandLineToEscaped(command);
/* 120 */       ProcessInfoBuilder processBuilder = new ProcessInfoBuilder();
/* 121 */       processBuilder.setExecutable((String)tokens.get(0));
/* 122 */       for (int i = 1; i < tokens.size(); i++) {
/* 123 */         processBuilder.addArgs((String)tokens.get(i));
/*     */       }
/* 125 */       diagnostic("%s", new Object[] { processBuilder });
/* 126 */       ExternalNativeBuildTaskUtils.executeBuildProcessAndLogError(
/* 127 */         getBuilder(), processBuilder, true);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ConfigAction
/*     */     implements TaskConfigAction<ExternalNativeCleanTask>
/*     */   {
/*     */     private final ExternalNativeJsonGenerator generator;
/*     */     
/*     */     private final VariantScope scope;
/*     */     
/*     */     private final AndroidBuilder androidBuilder;
/*     */     
/*     */     public ConfigAction(ExternalNativeJsonGenerator generator, VariantScope scope, AndroidBuilder androidBuilder)
/*     */     {
/* 145 */       this.generator = generator;
/* 146 */       this.scope = scope;
/* 147 */       this.androidBuilder = androidBuilder;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 153 */       return scope.getTaskName("externalNativeBuildClean");
/*     */     }
/*     */     
/*     */     public Class<ExternalNativeCleanTask> getType()
/*     */     {
/* 159 */       return ExternalNativeCleanTask.class;
/*     */     }
/*     */     
/*     */     public void execute(ExternalNativeCleanTask task)
/*     */     {
/* 164 */       BaseVariantData variantData = scope.getVariantData();
/* 165 */       task.setVariantName(variantData.getName());
/*     */       
/* 170 */       List<String> abiNames = Lists.newArrayList();
/* 171 */       for (Abi abi : NdkHandler.getAbiList()) {
/* 172 */         abiNames.add(abi.getName());
/*     */       }
/* 174 */       task.setAndroidBuilder(androidBuilder);
/* 175 */       nativeBuildConfigurationsJsons = 
/* 176 */         ExternalNativeBuildTaskUtils.getOutputJsons(generator
/* 177 */         .getJsonFolder(), abiNames);
/* 178 */       stlSharedObjectFiles = generator.getStlSharedObjectFiles();
/* 179 */       objFolder = generator.getObjFolder();
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ExternalNativeCleanTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */