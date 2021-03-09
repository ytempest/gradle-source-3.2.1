/*     */ package com.android.build.gradle.tasks.ir;
/*     */ 
/*     */ import com.android.build.gradle.internal.incremental.InstantRunBuildContext;
/*     */ import com.android.build.gradle.internal.scope.BuildElements;
/*     */ import com.android.build.gradle.internal.scope.BuildOutput;
/*     */ import com.android.build.gradle.internal.scope.ExistingBuildElements;
/*     */ import com.android.build.gradle.internal.scope.TaskConfigAction;
/*     */ import com.android.build.gradle.internal.scope.TaskOutputHolder.TaskOutputType;
/*     */ import com.android.build.gradle.internal.scope.TransformVariantScope;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.android.build.gradle.internal.tasks.AndroidBuilderTask;
/*     */ import com.android.utils.XmlUtils;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import java.util.jar.JarOutputStream;
/*     */ import java.util.zip.ZipEntry;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.gradle.api.file.FileCollection;
/*     */ import org.gradle.api.tasks.Input;
/*     */ import org.gradle.api.tasks.InputFiles;
/*     */ import org.gradle.api.tasks.OutputFile;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ import org.gradle.tooling.BuildException;
/*     */ import org.objectweb.asm.ClassWriter;
/*     */ import org.objectweb.asm.FieldVisitor;
/*     */ import org.objectweb.asm.Label;
/*     */ import org.objectweb.asm.MethodVisitor;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ public class GenerateInstantRunAppInfoTask
/*     */   extends AndroidBuilderTask
/*     */ {
/*     */   private static final String SERVER_PACKAGE = "com/android/tools/ir/server";
/*     */   private File outputFile;
/*     */   private FileCollection mergedManifests;
/*     */   private InstantRunBuildContext buildContext;
/*     */   
/*     */   @OutputFile
/*     */   public File getOutputFile()
/*     */   {
/*  78 */     return outputFile;
/*     */   }
/*     */   
/*     */   void setOutputFile(File outputFile)
/*     */   {
/*  83 */     this.outputFile = outputFile;
/*     */   }
/*     */   
/*     */   @InputFiles
/*     */   public FileCollection getMergedManifests() {
/*  88 */     return mergedManifests;
/*     */   }
/*     */   
/*     */   void setMergedManifests(FileCollection mergedManifests)
/*     */   {
/*  93 */     this.mergedManifests = mergedManifests;
/*     */   }
/*     */   
/*     */   void setBuildContext(InstantRunBuildContext buildContext)
/*     */   {
/*  98 */     this.buildContext = buildContext;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public long getSecretToken() {
/* 103 */     return buildContext.getSecretToken();
/*     */   }
/*     */   
/*     */   @TaskAction
/*     */   public void generateInfoTask()
/*     */     throws IOException
/*     */   {
/* 110 */     BuildElements buildElements = ExistingBuildElements.from(TaskOutputHolder.TaskOutputType.INSTANT_RUN_MERGED_MANIFESTS, 
/*     */     
/* 112 */       getMergedManifests());
/*     */     
/* 114 */     if (buildElements.isEmpty()) {
/* 115 */       throw new RuntimeException("Cannot find the package-id from the merged manifest, please file a bug, a clean build should fix the issue.");
/*     */     }
/*     */     
/* 121 */     BuildOutput buildOutput = (BuildOutput)buildElements.iterator().next();
/* 122 */     File manifestFile = buildOutput.getOutputFile();
/*     */     
/* 124 */     if (manifestFile.exists()) {
/*     */       try
/*     */       {
/* 127 */         Document document = XmlUtils.parseUtfXmlFile(manifestFile, true);
/* 128 */         Element root = document.getDocumentElement();
/* 129 */         if (root != null) {
/* 130 */           String applicationId = root.getAttribute("package");
/* 131 */           if (!applicationId.isEmpty())
/*     */           {
/* 133 */             writeAppInfoClass(applicationId, getSecretToken());
/*     */           }
/*     */         }
/*     */       } catch (ParserConfigurationException|IOException|SAXException e) {
/* 137 */         throw new BuildException("Failed to inject bootstrapping application", e);
/*     */       }
/*     */     } else {
/* 140 */       throw new FileNotFoundException("Cannot find " + manifestFile.getAbsolutePath());
/*     */     }
/*     */   }
/*     */   
/*     */   void writeAppInfoClass(String applicationId, long token)
/*     */     throws IOException
/*     */   {
/* 148 */     ClassWriter cw = new ClassWriter(0);
/*     */     
/* 152 */     String appInfoOwner = "com/android/tools/ir/server/AppInfo";
/* 153 */     cw.visit(50, 33, appInfoOwner, null, "java/lang/Object", null);
/*     */     
/* 155 */     FieldVisitor fv = cw.visitField(9, "applicationId", "Ljava/lang/String;", null, null);
/* 156 */     fv.visitEnd();
/* 157 */     fv = cw.visitField(9, "token", "J", null, null);
/* 158 */     fv.visitEnd();
/* 159 */     MethodVisitor mv = cw.visitMethod(1, "<init>", "()V", null, null);
/* 160 */     mv.visitCode();
/* 161 */     Label l0 = new Label();
/* 162 */     mv.visitLabel(l0);
/* 163 */     mv.visitVarInsn(25, 0);
/* 164 */     mv.visitMethodInsn(183, "java/lang/Object", "<init>", "()V", false);
/* 165 */     mv.visitInsn(177);
/* 166 */     Label l1 = new Label();
/* 167 */     mv.visitLabel(l1);
/* 168 */     mv.visitLocalVariable("this", "L" + appInfoOwner + ";", null, l0, l1, 0);
/* 169 */     mv.visitMaxs(1, 1);
/* 170 */     mv.visitEnd();
/* 171 */     mv = cw.visitMethod(8, "<clinit>", "()V", null, null);
/* 172 */     mv.visitCode();
/* 173 */     mv.visitLdcInsn(applicationId);
/* 174 */     mv.visitFieldInsn(179, appInfoOwner, "applicationId", "Ljava/lang/String;");
/* 175 */     if (token != 0L) {
/* 176 */       mv.visitLdcInsn(Long.valueOf(token));
/*     */     } else {
/* 178 */       mv.visitInsn(9);
/*     */     }
/* 180 */     mv.visitFieldInsn(179, appInfoOwner, "token", "J");
/*     */     
/* 182 */     mv.visitInsn(177);
/* 183 */     mv.visitMaxs(2, 0);
/* 184 */     mv.visitEnd();
/* 185 */     cw.visitEnd();
/*     */     
/* 187 */     byte[] bytes = cw.toByteArray();
/*     */     
/* 190 */     JarOutputStream outputStream = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(getOutputFile())));Throwable localThrowable3 = null;
/*     */     try {
/* 191 */       outputStream.putNextEntry(new ZipEntry("com/android/tools/ir/server/AppInfo.class"));
/* 192 */       outputStream.write(bytes);
/* 193 */       outputStream.closeEntry();
/*     */     }
/*     */     catch (Throwable localThrowable1)
/*     */     {
/* 189 */       localThrowable3 = localThrowable1;throw localThrowable1;
/*     */     }
/*     */     finally
/*     */     {
/* 194 */       if (outputStream != null) if (localThrowable3 != null) try { outputStream.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else outputStream.close();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ConfigAction
/*     */     implements TaskConfigAction<GenerateInstantRunAppInfoTask>
/*     */   {
/*     */     private final VariantScope variantScope;
/*     */     private final TransformVariantScope transformVariantScope;
/*     */     private final FileCollection manifests;
/*     */     
/*     */     public ConfigAction(TransformVariantScope transformVariantScope, VariantScope variantScope, FileCollection manifests)
/*     */     {
/* 207 */       this.transformVariantScope = transformVariantScope;
/* 208 */       this.variantScope = variantScope;
/* 209 */       this.manifests = manifests;
/*     */     }
/*     */     
/*     */     public String getName()
/*     */     {
/* 215 */       return transformVariantScope.getTaskName("generate", "InstantRunAppInfo");
/*     */     }
/*     */     
/*     */     public Class<GenerateInstantRunAppInfoTask> getType()
/*     */     {
/* 221 */       return GenerateInstantRunAppInfoTask.class;
/*     */     }
/*     */     
/*     */     public void execute(GenerateInstantRunAppInfoTask task)
/*     */     {
/* 226 */       task.setVariantName(variantScope.getFullVariantName());
/* 227 */       buildContext = variantScope.getInstantRunBuildContext();
/* 228 */       outputFile = new File(variantScope
/* 229 */         .getIncrementalApplicationSupportDir(), "instant-run-bootstrap.jar");
/*     */       
/* 232 */       mergedManifests = manifests;
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ir.GenerateInstantRunAppInfoTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */