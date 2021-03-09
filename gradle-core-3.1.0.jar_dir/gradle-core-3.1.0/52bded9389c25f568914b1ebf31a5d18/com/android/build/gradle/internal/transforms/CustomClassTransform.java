/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.api.transform.DirectoryInput;
/*     */ import com.android.build.api.transform.Format;
/*     */ import com.android.build.api.transform.JarInput;
/*     */ import com.android.build.api.transform.QualifiedContent.ContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.DefaultContentType;
/*     */ import com.android.build.api.transform.QualifiedContent.Scope;
/*     */ import com.android.build.api.transform.SecondaryFile;
/*     */ import com.android.build.api.transform.Status;
/*     */ import com.android.build.api.transform.Transform;
/*     */ import com.android.build.api.transform.TransformInput;
/*     */ import com.android.build.api.transform.TransformInvocation;
/*     */ import com.android.build.api.transform.TransformOutputProvider;
/*     */ import com.android.build.gradle.internal.pipeline.ExtendedContentType;
/*     */ import com.android.build.gradle.internal.pipeline.TransformManager;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.common.io.ByteStreams;
/*     */ import com.google.common.io.Files;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.UncheckedIOException;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.ServiceLoader;
/*     */ import java.util.Set;
/*     */ import java.util.function.BiConsumer;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipInputStream;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ 
/*     */ public class CustomClassTransform
/*     */   extends Transform
/*     */ {
/*     */   private final String name;
/*     */   private final String path;
/*  84 */   public static final Set<QualifiedContent.Scope> SCOPE_EXTERNAL = Sets.immutableEnumSet(QualifiedContent.Scope.EXTERNAL_LIBRARIES, new QualifiedContent.Scope[0]);
/*     */   
/*     */   public CustomClassTransform(String path) {
/*  87 */     name = Files.getNameWithoutExtension(path);
/*  88 */     this.path = path;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/*  94 */     return name;
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.ContentType> getInputTypes()
/*     */   {
/* 100 */     return TransformManager.CONTENT_CLASS;
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.ContentType> getOutputTypes()
/*     */   {
/* 106 */     return ImmutableSet.of(QualifiedContent.DefaultContentType.CLASSES, ExtendedContentType.NATIVE_LIBS);
/*     */   }
/*     */   
/*     */   public Set<QualifiedContent.Scope> getScopes()
/*     */   {
/* 112 */     return TransformManager.SCOPE_FULL_PROJECT;
/*     */   }
/*     */   
/*     */   public Collection<SecondaryFile> getSecondaryFiles()
/*     */   {
/* 118 */     return ImmutableSet.of(SecondaryFile.nonIncremental(new File(path)));
/*     */   }
/*     */   
/*     */   public boolean isIncremental()
/*     */   {
/* 123 */     return true;
/*     */   }
/*     */   
/*     */   public void transform(TransformInvocation invocation)
/*     */     throws InterruptedException, IOException
/*     */   {
/* 129 */     TransformOutputProvider outputProvider = invocation.getOutputProvider();
/* 130 */     assert (outputProvider != null);
/*     */     
/*     */     Matcher matcher;
/*     */     File outputJar;
/* 134 */     if (!invocation.isIncremental()) {
/* 135 */       outputProvider.deleteAll();
/*     */       
/* 139 */       ZipInputStream zis = new ZipInputStream(new FileInputStream(path));Throwable localThrowable9 = null;
/*     */       try {
/* 141 */         Pattern pattern = Pattern.compile("dependencies/(.*)\\.jar");
/* 142 */         ZipEntry entry; while ((entry = zis.getNextEntry()) != null) {
/* 143 */           matcher = pattern.matcher(entry.getName());
/* 144 */           if (matcher.matches()) {
/* 145 */             String name = matcher.group(1);
/*     */             
/* 147 */             outputJar = outputProvider.getContentLocation(name, 
/* 148 */               getOutputTypes(), SCOPE_EXTERNAL, Format.JAR);
/* 149 */             Files.createParentDirs(outputJar);
/* 150 */             FileOutputStream fos = new FileOutputStream(outputJar);Throwable localThrowable10 = null;
/* 151 */             try { ByteStreams.copy(zis, fos);
/*     */             }
/*     */             catch (Throwable localThrowable1)
/*     */             {
/* 150 */               localThrowable10 = localThrowable1;throw localThrowable1;
/*     */             }
/*     */             finally {}
/*     */           }
/* 154 */           zis.closeEntry();
/*     */         }
/*     */       }
/*     */       catch (Throwable localThrowable4)
/*     */       {
/* 139 */         localThrowable9 = localThrowable4;throw localThrowable4;
/*     */       }
/*     */       finally
/*     */       {
/* 156 */         if (zis != null) if (localThrowable9 != null) try { zis.close(); } catch (Throwable localThrowable5) { localThrowable9.addSuppressed(localThrowable5); } else zis.close();
/*     */       }
/*     */     }
/* 159 */     URL url = new File(path).toURI().toURL();
/* 160 */     URLClassLoader loader = new URLClassLoader(new URL[] { url });localThrowable4 = null;
/* 161 */     try { function = loadTransformFunction(loader);
/*     */       
/* 163 */       for (TransformInput ti : invocation.getInputs()) {
/* 164 */         for (JarInput jarInput : ti.getJarInputs()) {
/* 165 */           File inputJar = jarInput.getFile();
/*     */           
/* 167 */           File outputJar = outputProvider.getContentLocation(jarInput
/* 168 */             .getName(), jarInput
/* 169 */             .getContentTypes(), jarInput
/* 170 */             .getScopes(), Format.JAR);
/*     */           
/* 173 */           if (invocation.isIncremental()) {
/* 174 */             switch (jarInput.getStatus()) {
/*     */             case NOTCHANGED: 
/*     */               break;
/*     */             case ADDED: 
/*     */             case CHANGED: 
/* 179 */               transformJar(function, inputJar, outputJar);
/* 180 */               break;
/*     */             case REMOVED: 
/* 182 */               FileUtils.delete(outputJar);
/*     */             }
/*     */             
/*     */           } else {
/* 186 */             transformJar(function, inputJar, outputJar);
/*     */           }
/*     */         }
/* 189 */         for (DirectoryInput di : ti.getDirectoryInputs()) {
/* 190 */           inputDir = di.getFile();
/*     */           
/* 192 */           outputDir = outputProvider.getContentLocation(di
/* 193 */             .getName(), di
/* 194 */             .getContentTypes(), di
/* 195 */             .getScopes(), Format.DIRECTORY);
/*     */           
/* 197 */           if (invocation.isIncremental()) {
/* 198 */             for (Map.Entry<File, Status> entry : di.getChangedFiles().entrySet()) {
/* 199 */               File inputFile = (File)entry.getKey();
/* 200 */               switch ((Status)entry.getValue()) {
/*     */               case NOTCHANGED: 
/*     */                 break;
/*     */               case ADDED: 
/*     */               case CHANGED: 
/* 205 */                 if (!inputFile.isDirectory())
/*     */                 {
/* 207 */                   if (inputFile.getName().endsWith(".class")) {
/* 208 */                     File out = toOutputFile(outputDir, inputDir, inputFile);
/* 209 */                     transformFile(function, inputFile, out); } }
/* 210 */                 break;
/*     */               
/*     */               case REMOVED: 
/* 213 */                 File outputFile = toOutputFile(outputDir, inputDir, inputFile);
/* 214 */                 FileUtils.deleteIfExists(outputFile);
/*     */               }
/*     */               
/*     */             }
/*     */           } else {
/* 219 */             for (File in : FileUtils.getAllFiles(inputDir)) {
/* 220 */               if (in.getName().endsWith(".class")) {
/* 221 */                 File out = toOutputFile(outputDir, inputDir, in);
/* 222 */                 transformFile(function, in, out);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable7)
/*     */     {
/*     */       BiConsumer<InputStream, OutputStream> function;
/*     */       File inputDir;
/*     */       File outputDir;
/* 160 */       localThrowable4 = localThrowable7;throw localThrowable7;
/*     */     }
/*     */     finally
/*     */     {
/* 228 */       if (loader != null) if (localThrowable4 != null) try { loader.close(); } catch (Throwable localThrowable8) { localThrowable4.addSuppressed(localThrowable8); } else loader.close();
/*     */     }
/*     */   }
/*     */   
/* 232 */   private BiConsumer<InputStream, OutputStream> loadTransformFunction(URLClassLoader loader) { ServiceLoader<BiConsumer> serviceLoader = ServiceLoader.load(BiConsumer.class, loader);
/* 233 */     ArrayList<BiConsumer> functions = Lists.newArrayList(serviceLoader.iterator());
/*     */     
/* 235 */     if (functions.isEmpty()) {
/* 236 */       throw new IllegalStateException("Custom transform does not provide a BiConsumer to apply");
/*     */     }
/* 238 */     if (functions.size() > 1) {
/* 239 */       throw new IllegalStateException("Custom transform provides more than one BiConsumer to apply");
/*     */     }
/*     */     
/* 242 */     BiConsumer uncheckedFunction = (BiConsumer)functions.get(0);
/*     */     
/* 244 */     Type[] types = uncheckedFunction.getClass().getGenericInterfaces();
/* 245 */     for (Type type : types) {
/* 246 */       if ((type instanceof ParameterizedType)) {
/* 247 */         ParameterizedType generic = (ParameterizedType)type;
/* 248 */         Type[] args = generic.getActualTypeArguments();
/* 249 */         if ((generic.getRawType().equals(BiConsumer.class)) && (args.length == 2))
/*     */         {
/* 251 */           if ((args[0].equals(InputStream.class)) && 
/* 252 */             (args[1].equals(OutputStream.class)))
/* 253 */             return uncheckedFunction;
/*     */         }
/*     */       }
/*     */     }
/* 257 */     throw new IllegalStateException("Custom transform must provide a BiConsumer<InputStream, OutputStream>");
/*     */   }
/*     */   
/*     */   private void transformJar(BiConsumer<InputStream, OutputStream> function, File inputJar, File outputJar)
/*     */     throws IOException
/*     */   {
/* 264 */     Files.createParentDirs(outputJar);
/* 265 */     FileInputStream fis = new FileInputStream(inputJar);Throwable localThrowable12 = null;
/* 266 */     try { ZipInputStream zis = new ZipInputStream(fis);Throwable localThrowable13 = null;
/* 267 */       try { FileOutputStream fos = new FileOutputStream(outputJar);Throwable localThrowable14 = null;
/* 268 */         try { ZipOutputStream zos = new ZipOutputStream(fos);Throwable localThrowable15 = null;
/* 269 */           try { ZipEntry entry = zis.getNextEntry();
/* 270 */             while (entry != null) {
/* 271 */               if ((!entry.isDirectory()) && (entry.getName().endsWith(".class"))) {
/* 272 */                 zos.putNextEntry(new ZipEntry(entry.getName()));
/* 273 */                 apply(function, zis, zos);
/*     */               }
/*     */               
/* 277 */               entry = zis.getNextEntry();
/*     */             }
/*     */           }
/*     */           catch (Throwable localThrowable1)
/*     */           {
/* 265 */             localThrowable15 = localThrowable1;throw localThrowable1; } finally {} } catch (Throwable localThrowable4) { localThrowable14 = localThrowable4;throw localThrowable4; } finally {} } catch (Throwable localThrowable7) { localThrowable13 = localThrowable7;throw localThrowable7; } finally {} } catch (Throwable localThrowable10) { localThrowable12 = localThrowable10;throw localThrowable10;
/*     */     }
/*     */     finally
/*     */     {
/* 279 */       if (fis != null) if (localThrowable12 != null) try { fis.close(); } catch (Throwable localThrowable11) { localThrowable12.addSuppressed(localThrowable11); } else fis.close();
/*     */     }
/*     */   }
/*     */   
/*     */   private void transformFile(BiConsumer<InputStream, OutputStream> function, File inputFile, File outputFile) throws IOException
/*     */   {
/* 285 */     Files.createParentDirs(outputFile);
/* 286 */     FileInputStream fis = new FileInputStream(inputFile);Throwable localThrowable6 = null;
/* 287 */     try { FileOutputStream fos = new FileOutputStream(outputFile);Throwable localThrowable7 = null;
/* 288 */       try { apply(function, fis, fos);
/*     */       }
/*     */       catch (Throwable localThrowable1)
/*     */       {
/* 286 */         localThrowable7 = localThrowable1;throw localThrowable1; } finally {} } catch (Throwable localThrowable4) { localThrowable6 = localThrowable4;throw localThrowable4;
/*     */     }
/*     */     finally {
/* 289 */       if (fis != null) if (localThrowable6 != null) try { fis.close(); } catch (Throwable localThrowable5) { localThrowable6.addSuppressed(localThrowable5); } else fis.close();
/*     */     }
/*     */   }
/*     */   
/*     */   private static File toOutputFile(File outputDir, File inputDir, File inputFile) {
/* 294 */     return new File(outputDir, FileUtils.relativePossiblyNonExistingPath(inputFile, inputDir));
/*     */   }
/*     */   
/*     */   private void apply(BiConsumer<InputStream, OutputStream> function, InputStream in, OutputStream out) throws IOException
/*     */   {
/*     */     try
/*     */     {
/* 301 */       function.accept(in, out);
/*     */     } catch (UncheckedIOException e) {
/* 303 */       throw e.getCause();
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.CustomClassTransform
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */