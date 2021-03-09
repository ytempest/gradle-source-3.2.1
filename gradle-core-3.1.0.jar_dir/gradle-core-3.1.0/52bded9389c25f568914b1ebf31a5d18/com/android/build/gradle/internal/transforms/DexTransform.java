/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.api.transform.Format;
/*     */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.api.transform.SecondaryFile;
/*     */ import com.android.build.api.transform.Transform;
/*     */ import com.android.build.api.transform.TransformException;
/*     */ import com.android.build.api.transform.TransformInvocation;
/*     */ import com.android.build.api.transform.TransformOutputProvider;
/*     */ import com.android.build.gradle.internal.LoggerWrapper;
/*     */ import com.android.build.gradle.internal.pipeline.TransformManager;
/*     */ import com.android.builder.core.DexByteCodeConverter;
/*     */ import com.android.builder.core.DexOptions;
/*     */ import com.android.builder.dexing.DexingType;
/*     */ import com.android.builder.sdk.TargetInfo;
/*     */ import com.android.ide.common.blame.Message.Kind;
/*     */ import com.android.ide.common.blame.MessageReceiver;
/*     */ import com.android.ide.common.blame.ParsingProcessOutputHandler;
/*     */ import com.android.ide.common.blame.parser.DexParser;
/*     */ import com.android.ide.common.blame.parser.ToolOutputParser;
/*     */ import com.android.ide.common.process.ProcessOutputHandler;
/*     */ import com.android.repository.Revision;
/*     */ import com.android.sdklib.BuildToolInfo;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ 
/*     */ public class DexTransform
/*     */   extends Transform
/*     */ {
/*  68 */   private static final LoggerWrapper logger = LoggerWrapper.getLogger(DexTransform.class);
/*     */   
/*     */   private final DexOptions dexOptions;
/*     */   
/*     */   private final DexingType dexingType;
/*     */   
/*     */   private boolean preDexEnabled;
/*     */   
/*     */   private final FileCollection mainDexListFile;
/*     */   
/*     */   private final TargetInfo targetInfo;
/*     */   
/*     */   private final DexByteCodeConverter dexByteCodeConverter;
/*     */   
/*     */   private final MessageReceiver messageReceiver;
/*     */   
/*     */   private final int minSdkVersion;
/*     */   
/*     */   public DexTransform(DexOptions dexOptions, DexingType dexingType, boolean preDexEnabled, FileCollection mainDexListFile, TargetInfo targetInfo, DexByteCodeConverter dexByteCodeConverter, MessageReceiver messageReceiver, int minSdkVersion)
/*     */   {
/*  92 */     this.dexOptions = dexOptions;
/*  93 */     this.dexingType = dexingType;
/*  94 */     this.preDexEnabled = preDexEnabled;
/*  95 */     this.mainDexListFile = mainDexListFile;
/*  96 */     this.targetInfo = targetInfo;
/*  97 */     this.dexByteCodeConverter = dexByteCodeConverter;
/*  98 */     this.messageReceiver = messageReceiver;
/*  99 */     this.minSdkVersion = minSdkVersion;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 105 */     return "dex";
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.ContentType> getInputTypes()
/*     */   {
/* 111 */     if (!preDexEnabled)
/*     */     {
/* 113 */       return TransformManager.CONTENT_CLASS;
/*     */     }
/*     */     
/* 116 */     return TransformManager.CONTENT_DEX;
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.ContentType> getOutputTypes()
/*     */   {
/* 123 */     return TransformManager.CONTENT_DEX;
/*     */   }
/*     */   
/*     */   public Set<? super QualifiedContent.Scope> getScopes()
/*     */   {
/* 129 */     return TransformManager.SCOPE_FULL_WITH_IR_FOR_DEXING;
/*     */   }
/*     */   
/*     */   public Collection<SecondaryFile> getSecondaryFiles()
/*     */   {
/* 135 */     if (mainDexListFile != null) {
/* 136 */       return ImmutableList.of(SecondaryFile.nonIncremental(mainDexListFile));
/*     */     }
/*     */     
/* 139 */     return ImmutableList.of();
/*     */   }
/*     */   
/*     */   public Map<String, Object> getParameterInputs()
/*     */   {
/*     */     try
/*     */     {
/* 148 */       Map<String, Object> params = Maps.newHashMapWithExpectedSize(8);
/*     */       
/* 150 */       params.put("optimize", Boolean.valueOf(true));
/* 151 */       params.put("predex", Boolean.valueOf(preDexEnabled));
/* 152 */       params.put("jumbo", Boolean.valueOf(dexOptions.getJumboMode()));
/* 153 */       params.put("dexing-mode", dexingType.name());
/* 154 */       params.put("java-max-heap-size", dexOptions.getJavaMaxHeapSize());
/* 155 */       params.put("additional-parameters", 
/*     */       
/* 157 */         Iterables.toString(dexOptions.getAdditionalParameters()));
/*     */       
/* 159 */       BuildToolInfo buildTools = targetInfo.getBuildTools();
/* 160 */       params.put("build-tools", buildTools.getRevision().toString());
/* 161 */       params.put("min-sdk-version", Integer.valueOf(minSdkVersion));
/*     */       
/* 163 */       return params;
/*     */     } catch (Exception e) {
/* 165 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isIncremental()
/*     */   {
/* 171 */     return false;
/*     */   }
/*     */   
/*     */   public void transform(TransformInvocation transformInvocation)
/*     */     throws TransformException, IOException, InterruptedException
/*     */   {
/* 177 */     TransformOutputProvider outputProvider = transformInvocation.getOutputProvider();
/* 178 */     Preconditions.checkNotNull(outputProvider, "Missing output object for transform " + 
/* 179 */       getName());
/*     */     
/* 181 */     if ((!dexOptions.getKeepRuntimeAnnotatedClasses()) && (mainDexListFile == null)) {
/* 182 */       logger.info("DexOptions.keepRuntimeAnnotatedClasses has no affect in native multidex.", new Object[0]);
/*     */     }
/*     */     
/* 185 */     ProcessOutputHandler outputHandler = new ParsingProcessOutputHandler(new ToolOutputParser(new DexParser(), Message.Kind.ERROR, logger), new ToolOutputParser(new DexParser(), logger), new MessageReceiver[] { messageReceiver });
/*     */     
/* 191 */     outputProvider.deleteAll();
/*     */     
/*     */     try
/*     */     {
/* 196 */       Collection<File> transformInputs = TransformInputUtil.getAllFiles(transformInvocation.getInputs());
/*     */       
/* 199 */       File outputDir = outputProvider.getContentLocation("main", 
/*     */       
/* 201 */         getOutputTypes(), TransformManager.SCOPE_FULL_PROJECT, Format.DIRECTORY);
/*     */       
/* 206 */       FileUtils.cleanOutputDir(outputDir);
/*     */       
/* 208 */       File mainDexList = null;
/* 209 */       if ((mainDexListFile != null) && (dexingType == DexingType.LEGACY_MULTIDEX)) {
/* 210 */         mainDexList = mainDexListFile.getSingleFile();
/*     */       }
/*     */       
/* 213 */       dexByteCodeConverter.convertByteCode(transformInputs, outputDir, dexingType
/*     */       
/* 216 */         .isMultiDex(), mainDexList, dexOptions, outputHandler, minSdkVersion);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 222 */       throw new TransformException(e);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.DexTransform
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */