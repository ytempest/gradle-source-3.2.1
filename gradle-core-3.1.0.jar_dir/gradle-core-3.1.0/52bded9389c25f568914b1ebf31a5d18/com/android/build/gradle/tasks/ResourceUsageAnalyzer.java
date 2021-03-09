/*      */ package com.android.build.gradle.tasks;
/*      */ 
/*      */ import com.android.build.gradle.internal.incremental.ByteCodeUtils;
/*      */ import com.android.ide.common.resources.usage.ResourceUsageModel;
/*      */ import com.android.ide.common.resources.usage.ResourceUsageModel.Resource;
/*      */ import com.android.resources.FolderTypeRelationship;
/*      */ import com.android.resources.ResourceFolderType;
/*      */ import com.android.resources.ResourceType;
/*      */ import com.android.utils.Pair;
/*      */ import com.android.utils.SdkUtils;
/*      */ import com.android.utils.XmlUtils;
/*      */ import com.google.common.base.Charsets;
/*      */ import com.google.common.base.Joiner;
/*      */ import com.google.common.collect.Maps;
/*      */ import com.google.common.collect.Sets;
/*      */ import com.google.common.io.ByteStreams;
/*      */ import com.google.common.io.Closeables;
/*      */ import com.google.common.io.Files;
/*      */ import java.io.BufferedInputStream;
/*      */ import java.io.BufferedOutputStream;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.PrintStream;
/*      */ import java.io.PrintWriter;
/*      */ import java.io.StringWriter;
/*      */ import java.nio.file.Path;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.jar.JarEntry;
/*      */ import java.util.jar.JarInputStream;
/*      */ import java.util.jar.JarOutputStream;
/*      */ import java.util.regex.Matcher;
/*      */ import java.util.regex.Pattern;
/*      */ import java.util.regex.PatternSyntaxException;
/*      */ import java.util.zip.ZipEntry;
/*      */ import java.util.zip.ZipInputStream;
/*      */ import javax.xml.parsers.ParserConfigurationException;
/*      */ import org.objectweb.asm.AnnotationVisitor;
/*      */ import org.objectweb.asm.ClassReader;
/*      */ import org.objectweb.asm.ClassVisitor;
/*      */ import org.objectweb.asm.FieldVisitor;
/*      */ import org.objectweb.asm.MethodVisitor;
/*      */ import org.w3c.dom.Document;
/*      */ import org.w3c.dom.Element;
/*      */ import org.w3c.dom.Node;
/*      */ import org.xml.sax.SAXException;
/*      */ 
/*      */ public class ResourceUsageAnalyzer
/*      */ {
/*      */   private static final String ANDROID_RES = "android_res/";
/*      */   public static final boolean REPLACE_DELETED_WITH_EMPTY = true;
/*      */   public static final boolean TWO_PASS_AAPT = false;
/*      */   static final String NO_MATCH = "-nomatch-";
/*      */   private final File mResourceClassDir;
/*      */   private final File mProguardMapping;
/*      */   private final Iterable<File> mClasses;
/*      */   private final File mMergedManifest;
/*      */   private final File mMergedResourceDir;
/*      */   private final File mReportFile;
/*      */   private final StringWriter mDebugOutput;
/*      */   private final PrintWriter mDebugPrinter;
/*      */   private boolean mVerbose;
/*      */   private boolean mDebug;
/*      */   private boolean mDryRun;
/*      */   private List<ResourceUsageModel.Resource> mUnused;
/*  214 */   private Map<String, Pair<ResourceType, Map<String, String>>> mResourceObfuscation = Maps.newHashMapWithExpectedSize(30);
/*      */   
/*      */   private String mSuggestionsAdapter;
/*      */   
/*      */   private String mResourcesWrapper;
/*      */   
/*      */   public ResourceUsageAnalyzer(File rDir, Iterable<File> classes, File manifest, File mapping, File resources, File reportFile)
/*      */   {
/*  229 */     mResourceClassDir = rDir;
/*  230 */     mProguardMapping = mapping;
/*  231 */     mClasses = classes;
/*  232 */     mMergedManifest = manifest;
/*  233 */     mMergedResourceDir = resources;
/*      */     
/*  235 */     mReportFile = reportFile;
/*  236 */     if ((reportFile != null) || (mDebug)) {
/*  237 */       mDebugOutput = new StringWriter(8192);
/*  238 */       mDebugPrinter = new PrintWriter(mDebugOutput);
/*      */     } else {
/*  240 */       mDebugOutput = null;
/*  241 */       mDebugPrinter = null;
/*      */     }
/*      */   }
/*      */   
/*      */   public void dispose() {
/*  246 */     if (mDebugOutput != null) {
/*  247 */       String output = mDebugOutput.toString();
/*      */       
/*  249 */       if (mDebug) {
/*  250 */         System.out.println(output);
/*      */       }
/*      */       
/*  253 */       if (mReportFile != null) {
/*  254 */         File dir = mReportFile.getParentFile();
/*  255 */         if ((dir != null) && 
/*  256 */           ((dir.exists()) || (dir.mkdir())) && (dir.canWrite())) {
/*      */           try {
/*  258 */             Files.write(output, mReportFile, Charsets.UTF_8);
/*      */           }
/*      */           catch (IOException localIOException) {}
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void analyze() throws IOException, ParserConfigurationException, SAXException
/*      */   {
/*  268 */     gatherResourceValues(mResourceClassDir);
/*  269 */     recordMapping(mProguardMapping);
/*      */     
/*  271 */     for (File jarOrDir : mClasses) {
/*  272 */       recordClassUsages(jarOrDir);
/*      */     }
/*      */     
/*  275 */     recordManifestUsages(mMergedManifest);
/*  276 */     recordResources(mMergedResourceDir);
/*  277 */     keepPossiblyReferencedResources();
/*  278 */     dumpReferences();
/*  279 */     mModel.processToolsAttributes();
/*  280 */     mUnused = mModel.findUnused();
/*      */   }
/*      */   
/*      */   public boolean isDryRun() {
/*  284 */     return mDryRun;
/*      */   }
/*      */   
/*      */   public void setDryRun(boolean dryRun) {
/*  288 */     mDryRun = dryRun;
/*      */   }
/*      */   
/*      */   public boolean isVerbose() {
/*  292 */     return mVerbose;
/*      */   }
/*      */   
/*      */   public void setVerbose(boolean verbose) {
/*  296 */     mVerbose = verbose;
/*      */   }
/*      */   
/*      */   public boolean isDebug()
/*      */   {
/*  301 */     return mDebug;
/*      */   }
/*      */   
/*      */   public void setDebug(boolean verbose) {
/*  305 */     mDebug = verbose;
/*      */   }
/*      */   
/*  309 */   public static final byte[] TINY_PNG = { -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 1, 0, 0, 0, 1, 8, 0, 0, 0, 0, 58, 126, -101, 85, 0, 0, 0, 10, 73, 68, 65, 84, 120, -38, 99, 96, 0, 0, 0, 2, 0, 1, -27, 39, -34, -4, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126 };
/*      */   
/*      */   public static final long TINY_PNG_CRC = 2293408688L;
/*      */   
/*  327 */   public static final byte[] TINY_9PNG = { -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 3, 0, 0, 0, 3, 8, 6, 0, 0, 0, 86, 40, -75, -65, 0, 0, 0, 20, 73, 68, 65, 84, 120, -38, 99, 96, Byte.MIN_VALUE, Byte.MIN_VALUE, -1, 12, 48, 6, 8, -96, 8, Byte.MIN_VALUE, 8, 0, -107, -111, 7, -7, -64, -82, 8, 0, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126 };
/*      */   
/*      */   public static final long TINY_9PNG_CRC = 289995143L;
/*      */   
/*  346 */   public static final byte[] TINY_XML = { 3, 0, 8, 0, 104, 0, 0, 0, 1, 0, 28, 0, 36, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 120, 0, 2, 1, 16, 0, 36, 0, 0, 0, 1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 1, 16, 0, 24, 0, 0, 0, 1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0 };
/*      */   
/*      */   public static final long TINY_XML_CRC = 3622196803L;
/*      */   
/*      */   public void rewriteResourceZip(File source, File dest)
/*      */     throws IOException
/*      */   {
/*  380 */     if (dest.exists()) {
/*  381 */       boolean deleted = dest.delete();
/*  382 */       if (!deleted) {
/*  383 */         throw new IOException("Could not delete " + dest);
/*      */       }
/*      */     }
/*      */     
/*  387 */     JarInputStream zis = new JarInputStream(new BufferedInputStream(new FileInputStream(source)));Throwable localThrowable6 = null;
/*      */     try {
/*  389 */       JarOutputStream zos = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(dest)));Throwable localThrowable7 = null;
/*      */       
/*      */       try
/*      */       {
/*  395 */         zos.setLevel(9);
/*      */         
/*  397 */         ZipEntry entry = zis.getNextEntry();
/*  398 */         while (entry != null) {
/*  399 */           String name = entry.getName();
/*  400 */           boolean directory = entry.isDirectory();
/*  401 */           ResourceUsageModel.Resource resource = getResourceByJarPath(name);
/*  402 */           if ((resource == null) || (resource.isReachable())) {
/*  403 */             copyToOutput(zis, zos, entry, name, directory);
/*      */           } else {
/*  405 */             if (!directory)
/*      */             {
/*  408 */               if (!name.equals("res/raw/keep.xml")) {
/*  409 */                 replaceWithDummyEntry(zos, entry, name);
/*  410 */                 break label277; } } if ((isVerbose()) || (mDebugPrinter != null))
/*      */             {
/*  412 */               String message = "Skipped unused resource " + name + ": " + entry.getSize() + " bytes";
/*  413 */               if (isVerbose()) {
/*  414 */                 System.out.println(message);
/*      */               }
/*  416 */               if (mDebugPrinter != null)
/*  417 */                 mDebugPrinter.println(message);
/*      */             } }
/*      */           label277:
/*  420 */           entry = zis.getNextEntry();
/*      */         }
/*  422 */         zos.flush();
/*      */       }
/*      */       catch (Throwable localThrowable1)
/*      */       {
/*  387 */         localThrowable7 = localThrowable1;throw localThrowable1; } finally {} } catch (Throwable localThrowable4) { localThrowable6 = localThrowable4;throw localThrowable4;
/*      */     }
/*      */     finally
/*      */     {
/*  423 */       if (zis != null) { if (localThrowable6 != null) try { zis.close(); } catch (Throwable localThrowable5) { localThrowable6.addSuppressed(localThrowable5); } else { zis.close();
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  430 */     long before = source.length();
/*  431 */     long after = dest.length();
/*  432 */     if (after > before) {
/*  433 */       String message = "Resource shrinking did not work (grew from " + before + " to " + after + "); using original instead";
/*      */       
/*  435 */       if (isVerbose()) {
/*  436 */         System.out.println(message);
/*      */       }
/*  438 */       if (mDebugPrinter != null) {
/*  439 */         mDebugPrinter.println(message);
/*      */       }
/*      */       
/*  442 */       Files.copy(source, dest);
/*      */     }
/*      */   }
/*      */   
/*      */   private void replaceWithDummyEntry(JarOutputStream zos, ZipEntry entry, String name)
/*      */     throws IOException
/*      */   {
/*      */     long crc;
/*      */     
/*      */     byte[] bytes;
/*      */     
/*      */     long crc;
/*      */     
/*  456 */     if (name.endsWith(".9.png")) {
/*  457 */       byte[] bytes = TINY_9PNG;
/*  458 */       crc = 289995143L; } else { long crc;
/*  459 */       if (name.endsWith(".png")) {
/*  460 */         byte[] bytes = TINY_PNG;
/*  461 */         crc = 2293408688L; } else { long crc;
/*  462 */         if (name.endsWith(".xml")) {
/*  463 */           byte[] bytes = TINY_XML;
/*  464 */           crc = 3622196803L;
/*      */         } else {
/*  466 */           bytes = new byte[0];
/*  467 */           crc = 0L;
/*      */         } } }
/*  469 */     JarEntry outEntry = new JarEntry(name);
/*  470 */     if (entry.getTime() != -1L) {
/*  471 */       outEntry.setTime(entry.getTime());
/*      */     }
/*  473 */     if (entry.getMethod() == 0) {
/*  474 */       outEntry.setMethod(0);
/*  475 */       outEntry.setSize(bytes.length);
/*  476 */       outEntry.setCrc(crc);
/*      */     }
/*  478 */     zos.putNextEntry(outEntry);
/*  479 */     zos.write(bytes);
/*  480 */     zos.closeEntry();
/*      */     
/*  482 */     if ((isVerbose()) || (mDebugPrinter != null))
/*      */     {
/*  487 */       String message = "Skipped unused resource " + name + ": " + entry.getSize() + " bytes (replaced with small dummy file of size " + bytes.length + " bytes)";
/*      */       
/*  491 */       if (isVerbose()) {
/*  492 */         System.out.println(message);
/*      */       }
/*  494 */       if (mDebugPrinter != null) {
/*  495 */         mDebugPrinter.println(message);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private static void copyToOutput(JarInputStream zis, JarOutputStream zos, ZipEntry entry, String name, boolean directory)
/*      */     throws IOException
/*      */   {
/*      */     JarEntry outEntry;
/*      */     
/*      */     JarEntry outEntry;
/*      */     
/*  509 */     if (entry.getMethod() == 0) {
/*  510 */       outEntry = new JarEntry(entry);
/*      */     }
/*      */     else {
/*  513 */       outEntry = new JarEntry(name);
/*  514 */       if (entry.getTime() != -1L) {
/*  515 */         outEntry.setTime(entry.getTime());
/*      */       }
/*      */     }
/*      */     
/*  519 */     zos.putNextEntry(outEntry);
/*      */     
/*  521 */     if (!directory) {
/*  522 */       byte[] bytes = ByteStreams.toByteArray(zis);
/*  523 */       if (bytes != null) {
/*  524 */         zos.write(bytes);
/*      */       }
/*      */     }
/*      */     
/*  528 */     zos.closeEntry();
/*      */   }
/*      */   
/*      */   public void emitWhitelist(Path destination) throws IOException
/*      */   {
/*  533 */     File destinationFile = destination.toFile();
/*  534 */     if (!destinationFile.exists()) {
/*  535 */       destinationFile.getParentFile().mkdirs();
/*  536 */       boolean success = destinationFile.createNewFile();
/*  537 */       if (!success) {
/*  538 */         throw new IOException("Could not create " + destination);
/*      */       }
/*      */     }
/*  541 */     Files.write(mModel.dumpWhitelistedResources(), destinationFile, Charsets.UTF_8);
/*      */   }
/*      */   
/*      */   public void removeUnused(File destination)
/*      */     throws IOException, ParserConfigurationException, SAXException
/*      */   {
/*  682 */     if (!$assertionsDisabled) { throw new AssertionError();
/*      */     }
/*      */   }
/*      */   
/*      */   private static void filteredCopy(File source, File destination, Set<File> skip, Map<File, String> replace)
/*      */     throws IOException
/*      */   {
/*  715 */     if (!$assertionsDisabled) { throw new AssertionError();
/*      */     }
/*      */   }
/*      */   
/*      */   private void stripUnused(Element element, List<String> removed)
/*      */   {
/*  797 */     if (!$assertionsDisabled) { throw new AssertionError();
/*      */     }
/*      */   }
/*      */   
/*      */   private ResourceUsageModel.Resource getResourceByJarPath(String path)
/*      */   {
/*  803 */     if (!path.startsWith("res/")) {
/*  804 */       return null;
/*      */     }
/*      */     
/*  808 */     int folderStart = 4;
/*  809 */     int folderEnd = path.indexOf('/', folderStart);
/*  810 */     if (folderEnd == -1) {
/*  811 */       return null;
/*      */     }
/*      */     
/*  814 */     String folderName = path.substring(folderStart, folderEnd);
/*  815 */     ResourceFolderType folderType = ResourceFolderType.getFolderType(folderName);
/*  816 */     if (folderType == null) {
/*  817 */       return null;
/*      */     }
/*      */     
/*  820 */     int nameStart = folderEnd + 1;
/*  821 */     int nameEnd = path.indexOf('.', nameStart);
/*  822 */     if (nameEnd == -1) {
/*  823 */       nameEnd = path.length();
/*      */     }
/*      */     
/*  826 */     String name = path.substring(nameStart, nameEnd);
/*  827 */     for (ResourceType type : FolderTypeRelationship.getRelatedResourceTypes(folderType)) {
/*  828 */       if (type != ResourceType.ID)
/*      */       {
/*  832 */         ResourceUsageModel.Resource resource = mModel.getResource(type, name);
/*  833 */         if (resource != null) {
/*  834 */           return resource;
/*      */         }
/*      */       }
/*      */     }
/*  838 */     return null;
/*      */   }
/*      */   
/*      */   private void dumpReferences() {
/*  842 */     if (mDebugPrinter != null) {
/*  843 */       mDebugPrinter.print(mModel.dumpReferences());
/*      */     }
/*      */   }
/*      */   
/*      */   private void keepPossiblyReferencedResources() {
/*  848 */     if (((!mFoundGetIdentifier) && (!mFoundWebContent)) || (mStrings == null))
/*      */     {
/*  851 */       return;
/*      */     }
/*      */     
/*  854 */     if (!mModel.isSafeMode()) {
/*      */       return;
/*      */     }
/*      */     
/*      */     Iterator localIterator1;
/*      */     
/*  860 */     if (mDebugPrinter != null) {
/*  861 */       List<String> strings = new ArrayList(mStrings);
/*  862 */       Collections.sort(strings);
/*  863 */       mDebugPrinter.println("android.content.res.Resources#getIdentifier present: " + mFoundGetIdentifier);
/*      */       
/*  865 */       mDebugPrinter.println("Web content present: " + mFoundWebContent);
/*  866 */       mDebugPrinter.println("Referenced Strings:");
/*  867 */       for (localIterator1 = strings.iterator(); localIterator1.hasNext();) { s = (String)localIterator1.next();
/*  868 */         s = s.trim().replace("\n", "\\n");
/*  869 */         if (s.length() > 40)
/*  870 */           s = s.substring(0, 37) + "..."; else {
/*  871 */           if (s.isEmpty())
/*      */             continue;
/*      */         }
/*  874 */         mDebugPrinter.println("  " + s);
/*      */       }
/*      */     }
/*      */     String s;
/*  878 */     int shortest = Integer.MAX_VALUE;
/*  879 */     Object names = Sets.newHashSetWithExpectedSize(50);
/*  880 */     for (ResourceUsageModel.Resource resource : mModel.getResources()) {
/*  881 */       String name = name;
/*  882 */       ((Set)names).add(name);
/*  883 */       int length = name.length();
/*  884 */       if (length < shortest) {
/*  885 */         shortest = length;
/*      */       }
/*      */     }
/*      */     
/*  889 */     for (String string : mStrings) {
/*  890 */       if (string.length() >= shortest)
/*      */       {
/*      */         ResourceUsageModel.Resource resource;
/*      */         
/*      */         String name;
/*      */         
/*  906 */         if (mFoundWebContent) {
/*  907 */           resource = mModel.getResourceFromFilePath(string);
/*  908 */           if (resource != null) {
/*  909 */             ResourceUsageModel.markReachable(resource);
/*  910 */             continue;
/*      */           }
/*  912 */           int start = 0;
/*  913 */           int slash = string.lastIndexOf('/');
/*  914 */           if (slash != -1) {
/*  915 */             start = slash + 1;
/*      */           }
/*  917 */           int dot = string.indexOf('.', start);
/*  918 */           name = string.substring(start, dot != -1 ? dot : string.length());
/*  919 */           if (((Set)names).contains(name)) {
/*  920 */             for (Map<String, ResourceUsageModel.Resource> map : mModel.getResourceMaps()) {
/*  921 */               resource = (ResourceUsageModel.Resource)map.get(name);
/*  922 */               if ((mDebug) && (resource != null)) {
/*  923 */                 mDebugPrinter.println("Marking " + resource + " used because it matches string pool constant " + string);
/*      */               }
/*      */               
/*  926 */               ResourceUsageModel.markReachable(resource);
/*  927 */               mModel.addResourceToWhitelist(resource);
/*      */             }
/*      */           }
/*      */         }
/*      */         
/*  934 */         int n = string.length();
/*  935 */         boolean justName = true;
/*  936 */         boolean formatting = false;
/*  937 */         boolean haveSlash = false;
/*  938 */         char c; for (int i = 0; i < n; i++) {
/*  939 */           c = string.charAt(i);
/*  940 */           if (c == '/') {
/*  941 */             haveSlash = true;
/*  942 */             justName = false;
/*  943 */           } else if ((c == '.') || (c == ':') || (c == '%')) {
/*  944 */             justName = false;
/*  945 */             if (c == '%') {
/*  946 */               formatting = true;
/*      */             }
/*  948 */           } else if (!Character.isJavaIdentifierPart(c))
/*      */           {
/*  951 */             if ($assertionsDisabled) break; throw new AssertionError(string); } }
/*      */         String name;
/*      */         Iterator localIterator3;
/*      */         ResourceUsageModel.Resource resource;
/*      */         int slash;
/*      */         String name;
/*  957 */         if (justName)
/*      */         {
/*  959 */           name = string;
/*      */           
/*  963 */           for (localIterator3 = mModel.getResources().iterator(); localIterator3.hasNext();) { resource = (ResourceUsageModel.Resource)localIterator3.next();
/*  964 */             if (name.startsWith(name)) {
/*  965 */               if (mDebugPrinter != null) {
/*  966 */                 mDebugPrinter.println("Marking " + resource + " used because its prefix matches string pool constant " + string);
/*      */               }
/*      */               
/*  969 */               ResourceUsageModel.markReachable(resource);
/*      */             }
/*      */           }
/*  972 */         } else { if (!haveSlash) {
/*  973 */             if (!formatting) {
/*      */               continue;
/*      */             }
/*      */             Pattern pattern;
/*      */             try
/*      */             {
/*  979 */               pattern = Pattern.compile(convertFormatStringToRegexp(string));
/*  980 */               for (ResourceUsageModel.Resource resource : mModel.getResources()) {
/*  981 */                 if (pattern.matcher(name).matches()) {
/*  982 */                   if (mDebugPrinter != null) {
/*  983 */                     mDebugPrinter.println("Marking " + resource + " used because it format-string matches string pool constant " + string);
/*      */                   }
/*      */                   
/*  987 */                   ResourceUsageModel.markReachable(resource);
/*      */                 }
/*      */               }
/*      */             }
/*      */             catch (PatternSyntaxException localPatternSyntaxException1) {}
/*  992 */             continue;
/*      */           }
/*      */           
/* 1001 */           slash = string.indexOf('/');
/* 1002 */           assert (slash != -1);
/* 1003 */           name = string.substring(slash + 1);
/* 1004 */           if ((name.isEmpty()) || (!((Set)names).contains(name))) {
/*      */             continue;
/*      */           }
/*      */           
/* 1008 */           if (slash > 0) {
/* 1009 */             int colon = string.indexOf(':');
/* 1010 */             String typeName = string.substring(colon != -1 ? colon + 1 : 0, slash);
/* 1011 */             ResourceType type = ResourceType.getEnum(typeName);
/* 1012 */             if (type == null) {
/*      */               continue;
/*      */             }
/* 1015 */             ResourceUsageModel.Resource resource = mModel.getResource(type, name);
/* 1016 */             if ((mDebug) && (resource != null)) {
/* 1017 */               mDebugPrinter.println("Marking " + resource + " used because it matches string pool constant " + string);
/*      */             }
/*      */             
/* 1020 */             ResourceUsageModel.markReachable(resource);
/* 1021 */             continue;
/*      */           }
/*      */         }
/*      */         
/* 1027 */         if (((Set)names).contains(name)) {
/* 1028 */           for (Map<String, ResourceUsageModel.Resource> map : mModel.getResourceMaps()) {
/* 1029 */             ResourceUsageModel.Resource resource = (ResourceUsageModel.Resource)map.get(name);
/* 1030 */             if ((mDebug) && (resource != null)) {
/* 1031 */               mDebugPrinter.println("Marking " + resource + " used because it matches string pool constant " + string);
/*      */             }
/*      */             
/* 1034 */             ResourceUsageModel.markReachable(resource);
/*      */           }
/* 1036 */         } else if (Character.isDigit(name.charAt(0)))
/*      */         {
/*      */           try
/*      */           {
/* 1042 */             int id = Integer.parseInt(name);
/* 1043 */             if (id != 0) {
/* 1044 */               ResourceUsageModel.markReachable(mModel.getResource(Integer.valueOf(id)));
/*      */             }
/*      */           }
/*      */           catch (NumberFormatException localNumberFormatException1) {}
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/* 1055 */   public static final Pattern FORMAT = Pattern.compile("%(\\d+\\$)?([-+#, 0(<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])");
/*      */   
/*      */   private Set<String> mStrings;
/*      */   
/*      */   private boolean mFoundGetIdentifier;
/*      */   
/*      */   private boolean mFoundWebContent;
/*      */   
/*      */   static String convertFormatStringToRegexp(String formatString)
/*      */   {
/* 1080 */     StringBuilder regexp = new StringBuilder();
/* 1081 */     int from = 0;
/* 1082 */     boolean hasEscapedLetters = false;
/* 1083 */     Matcher matcher = FORMAT.matcher(formatString);
/* 1084 */     int length = formatString.length();
/* 1085 */     while (matcher.find(from)) {
/* 1086 */       int start = matcher.start();
/* 1087 */       int end = matcher.end();
/* 1088 */       if ((start == 0) && (end == length))
/*      */       {
/* 1092 */         return "-nomatch-";
/*      */       }
/* 1094 */       if (start > from) {
/* 1095 */         hasEscapedLetters |= appendEscapedPattern(formatString, regexp, from, start);
/*      */       }
/* 1097 */       String pattern = ".*";
/* 1098 */       String conversion = matcher.group(6);
/* 1099 */       String timePrefix = matcher.group(5);
/*      */       
/* 1102 */       if (timePrefix == null)
/*      */       {
/* 1104 */         if ((conversion != null) && (conversion.length() == 1)) {
/* 1105 */           char type = conversion.charAt(0);
/* 1106 */           switch (type)
/*      */           {
/*      */           case 'S': 
/*      */           case 'T': 
/*      */           case 's': 
/*      */           case 't': 
/*      */             break;
/*      */           case '%': 
/* 1114 */             pattern = "%"; break;
/*      */           case 'n': 
/* 1116 */             pattern = "\n"; break;
/*      */           case 'C': 
/*      */           case 'c': 
/* 1119 */             pattern = "."; break;
/*      */           case 'X': 
/*      */           case 'x': 
/* 1122 */             pattern = "\\p{XDigit}+"; break;
/*      */           case 'd': 
/*      */           case 'o': 
/* 1125 */             pattern = "\\p{Digit}+"; break;
/*      */           case 'b': 
/* 1127 */             pattern = "(true|false)"; break;
/*      */           case 'B': 
/* 1129 */             pattern = "(TRUE|FALSE)"; break;
/*      */           case 'H': 
/*      */           case 'h': 
/* 1132 */             pattern = "(null|\\p{XDigit}+)"; break;
/*      */           case 'f': 
/* 1134 */             pattern = "-?[\\p{XDigit},.]+"; break;
/*      */           case 'e': 
/* 1136 */             pattern = "-?\\p{Digit}+[,.]\\p{Digit}+e\\+?\\p{Digit}+"; break;
/*      */           case 'E': 
/* 1138 */             pattern = "-?\\p{Digit}+[,.]\\p{Digit}+E\\+?\\p{Digit}+"; break;
/*      */           case 'a': 
/* 1140 */             pattern = "0x[\\p{XDigit},.+p]+"; break;
/*      */           case 'A': 
/* 1142 */             pattern = "0X[\\p{XDigit},.+P]+"; break;
/*      */           case 'G': 
/*      */           case 'g': 
/* 1145 */             pattern = "-?[\\p{XDigit},.+eE]+";
/*      */           }
/*      */           
/*      */           
/* 1149 */           if (!".*".equals(pattern)) {
/* 1150 */             String width = matcher.group(3);
/*      */             
/* 1152 */             if (width != null) {
/* 1153 */               String flags = matcher.group(2);
/* 1154 */               if ("0".equals(flags)) {
/* 1155 */                 pattern = "0*" + pattern;
/*      */               } else {
/* 1157 */                 pattern = " " + pattern;
/*      */               }
/*      */             }
/*      */           }
/*      */           
/* 1164 */           int regexLength = regexp.length();
/* 1165 */           if ((!".*".equals(pattern)) || (regexLength < 2) || 
/*      */           
/* 1167 */             (regexp.charAt(regexLength - 1) != '*') || 
/* 1168 */             (regexp.charAt(regexLength - 2) != '.'))
/* 1169 */             regexp.append(pattern);
/*      */         }
/*      */       }
/* 1172 */       from = end;
/*      */     }
/*      */     
/* 1175 */     if (from < length) {
/* 1176 */       hasEscapedLetters |= appendEscapedPattern(formatString, regexp, from, length);
/*      */     }
/*      */     
/* 1179 */     if (!hasEscapedLetters)
/*      */     {
/* 1185 */       return "-nomatch-";
/*      */     }
/*      */     
/* 1188 */     return regexp.toString();
/*      */   }
/*      */   
/*      */   private static boolean appendEscapedPattern(String formatString, StringBuilder regexp, int from, int to)
/*      */   {
/* 1198 */     regexp.append(Pattern.quote(formatString.substring(from, to)));
/*      */     
/* 1200 */     for (int i = from; i < to; i++) {
/* 1201 */       if (Character.isLetter(formatString.charAt(i))) {
/* 1202 */         return true;
/*      */       }
/*      */     }
/*      */     
/* 1206 */     return false;
/*      */   }
/*      */   
/*      */   private void recordResources(File resDir) throws IOException, SAXException, ParserConfigurationException
/*      */   {
/* 1211 */     File[] resourceFolders = resDir.listFiles();
/* 1212 */     if (resourceFolders != null) {
/* 1213 */       for (File folder : resourceFolders) {
/* 1214 */         ResourceFolderType folderType = ResourceFolderType.getFolderType(folder.getName());
/* 1215 */         if (folderType != null) {
/* 1216 */           recordResources(folderType, folder);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void recordResources(ResourceFolderType folderType, File folder) throws ParserConfigurationException, SAXException, IOException
/*      */   {
/* 1224 */     File[] files = folder.listFiles();
/* 1225 */     if (files != null) {
/* 1226 */       for (File file : files) {
/* 1227 */         String path = file.getPath();
/* 1228 */         mModel.file = file;
/*      */         try {
/* 1230 */           boolean isXml = SdkUtils.endsWithIgnoreCase(path, ".xml");
/* 1231 */           if (isXml) {
/* 1232 */             String xml = Files.toString(file, Charsets.UTF_8);
/* 1233 */             Document document = XmlUtils.parseDocument(xml, true);
/* 1234 */             mModel.visitXmlDocument(file, folderType, document);
/*      */           } else {
/* 1236 */             mModel.visitBinaryResource(folderType, file);
/*      */           }
/*      */         } finally {
/* 1239 */           mModel.file = null;
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   void recordMapping(File mapping) throws IOException
/*      */   {
/* 1247 */     if ((mapping == null) || (!mapping.exists())) {
/* 1248 */       return;
/*      */     }
/* 1250 */     String ARROW = " -> ";
/* 1251 */     String RESOURCE = ".R$";
/* 1252 */     Map<String, String> nameMap = null;
/* 1253 */     for (String line : Files.readLines(mapping, Charsets.UTF_8))
/* 1254 */       if ((line.startsWith(" ")) || (line.startsWith("\t"))) {
/* 1255 */         if (nameMap != null)
/*      */         {
/* 1257 */           int n = line.length();
/* 1258 */           for (int i = 0; 
/* 1259 */               i < n; i++) {
/* 1260 */             if (!Character.isWhitespace(line.charAt(i))) {
/*      */               break;
/*      */             }
/*      */           }
/* 1264 */           if ((i < n) && (line.startsWith("int", i))) {
/* 1265 */             int start = line.indexOf(' ', i + 3) + 1;
/* 1266 */             int arrow = line.indexOf(" -> ");
/* 1267 */             if ((start > 0) && (arrow != -1)) {
/* 1268 */               int end = line.indexOf(' ', start + 1);
/* 1269 */               if (end != -1) {
/* 1270 */                 String oldName = line.substring(start, end);
/* 1271 */                 String newName = line.substring(arrow + " -> ".length()).trim();
/* 1272 */                 if (!newName.equals(oldName)) {
/* 1273 */                   nameMap.put(newName, oldName);
/*      */                 }
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */       else {
/* 1281 */         nameMap = null;
/*      */         
/* 1283 */         int index = line.indexOf(".R$");
/* 1284 */         if (index == -1)
/*      */         {
/* 1288 */           if (line.startsWith("android.support.v7.widget.SuggestionsAdapter "))
/*      */           {
/* 1291 */             mSuggestionsAdapter = (line.substring(line.indexOf(" -> ") + " -> ".length(), line.indexOf(':') != -1 ? line.indexOf(':') : line.length()).trim().replace('.', '/') + ".class");
/* 1292 */           } else if ((line.startsWith("android.support.v7.internal.widget.ResourcesWrapper ")) || 
/* 1293 */             (line.startsWith("android.support.v7.widget.ResourcesWrapper ")) || ((mResourcesWrapper == null) && 
/*      */             
/* 1295 */             (line.startsWith("android.support.v7.widget.TintContextWrapper$TintResources "))))
/*      */           {
/* 1298 */             mResourcesWrapper = (line.substring(line.indexOf(" -> ") + " -> ".length(), line.indexOf(':') != -1 ? line.indexOf(':') : line.length()).trim().replace('.', '/') + ".class");
/*      */           }
/*      */         }
/*      */         else {
/* 1302 */           int arrow = line.indexOf(" -> ", index + 3);
/* 1303 */           if (arrow != -1)
/*      */           {
/* 1306 */             String typeName = line.substring(index + ".R$".length(), arrow);
/* 1307 */             ResourceType type = ResourceType.getEnum(typeName);
/* 1308 */             if (type != null)
/*      */             {
/* 1311 */               int end = line.indexOf(':', arrow + " -> ".length());
/* 1312 */               if (end == -1) {
/* 1313 */                 end = line.length();
/*      */               }
/* 1315 */               String target = line.substring(arrow + " -> ".length(), end).trim();
/* 1316 */               String ownerName = ByteCodeUtils.toInternalName(target);
/*      */               
/* 1318 */               nameMap = Maps.newHashMap();
/* 1319 */               Pair<ResourceType, Map<String, String>> pair = Pair.of(type, nameMap);
/* 1320 */               mResourceObfuscation.put(ownerName, pair);
/*      */               
/* 1322 */               mResourceObfuscation.put(ownerName + ".class", pair);
/*      */             }
/*      */           }
/*      */         }
/*      */       } }
/*      */   
/* 1328 */   private void recordManifestUsages(File manifest) throws IOException, ParserConfigurationException, SAXException { String xml = Files.toString(manifest, Charsets.UTF_8);
/* 1329 */     Document document = XmlUtils.parseDocument(xml, true);
/* 1330 */     mModel.visitXmlDocument(manifest, null, document);
/*      */   }
/*      */   
/*      */   private void referencedString(String string)
/*      */   {
/* 1341 */     if ((string.isEmpty()) || (string.length() > 80)) {
/* 1342 */       return;
/*      */     }
/* 1344 */     boolean haveIdentifierChar = false;
/* 1345 */     int i = 0; for (int n = string.length(); i < n; i++) {
/* 1346 */       char c = string.charAt(i);
/* 1347 */       boolean identifierChar = Character.isJavaIdentifierPart(c);
/* 1348 */       if ((!identifierChar) && (c != '.') && (c != ':') && (c != '/') && (c != '%'))
/*      */       {
/* 1351 */         return; }
/* 1352 */       if (identifierChar) {
/* 1353 */         haveIdentifierChar = true;
/*      */       }
/*      */     }
/* 1356 */     if (!haveIdentifierChar) {
/* 1357 */       return;
/*      */     }
/*      */     
/* 1360 */     if (mStrings == null) {
/* 1361 */       mStrings = Sets.newHashSetWithExpectedSize(300);
/*      */     }
/* 1363 */     mStrings.add(string);
/*      */     
/* 1365 */     if ((!mFoundWebContent) && (string.contains("android_res/"))) {
/* 1366 */       mFoundWebContent = true;
/*      */     }
/*      */   }
/*      */   
/*      */   private void recordClassUsages(File file) throws IOException {
/* 1371 */     if (file.isDirectory()) {
/* 1372 */       File[] children = file.listFiles();
/* 1373 */       if (children != null) {
/* 1374 */         for (File child : children) {
/* 1375 */           recordClassUsages(child);
/*      */         }
/*      */       }
/* 1378 */     } else if (file.isFile()) {
/* 1379 */       if (file.getPath().endsWith(".class")) {
/* 1380 */         byte[] bytes = Files.toByteArray(file);
/* 1381 */         recordClassUsages(file, file.getName(), bytes);
/* 1382 */       } else if (file.getPath().endsWith(".jar")) {
/* 1383 */         ZipInputStream zis = null;
/*      */         try {
/* 1385 */           FileInputStream fis = new FileInputStream(file);
/*      */           try {
/* 1387 */             zis = new ZipInputStream(fis);
/* 1388 */             ZipEntry entry = zis.getNextEntry();
/* 1389 */             while (entry != null) {
/* 1390 */               String name = entry.getName();
/* 1391 */               if (name.endsWith(".class"))
/*      */               {
/* 1396 */                 if (!isResourceClass(name)) {
/* 1397 */                   byte[] bytes = ByteStreams.toByteArray(zis);
/* 1398 */                   if (bytes != null) {
/* 1399 */                     recordClassUsages(file, name, bytes);
/*      */                   }
/*      */                 }
/*      */               }
/* 1403 */               entry = zis.getNextEntry();
/*      */             }
/*      */           }
/*      */           finally {}
/*      */         }
/*      */         finally {
/* 1409 */           Closeables.close(zis, true);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void recordClassUsages(File file, String name, byte[] bytes) {
/* 1416 */     ClassReader classReader = new ClassReader(bytes);
/* 1417 */     classReader.accept(new UsageVisitor(file, name), 6);
/*      */   }
/*      */   
/*      */   boolean isResourceClass(String name)
/*      */   {
/* 1423 */     if (mResourceObfuscation.containsKey(name)) {
/* 1424 */       return true;
/*      */     }
/* 1426 */     assert (name.endsWith(".class")) : name;
/* 1427 */     int index = name.lastIndexOf('/');
/* 1428 */     if ((index != -1) && (name.startsWith("R$", index + 1))) {
/* 1429 */       String typeName = name.substring(index + 3, name.length() - ".class".length());
/* 1430 */       return ResourceType.getEnum(typeName) != null;
/*      */     }
/*      */     
/* 1433 */     return false;
/*      */   }
/*      */   
/*      */   ResourceUsageModel.Resource getResourceFromCode(String owner, String name)
/*      */   {
/* 1439 */     Pair<ResourceType, Map<String, String>> pair = (Pair)mResourceObfuscation.get(owner);
/* 1440 */     if (pair != null) {
/* 1441 */       ResourceType type = (ResourceType)pair.getFirst();
/* 1442 */       Map<String, String> nameMap = (Map)pair.getSecond();
/* 1443 */       String renamedField = (String)nameMap.get(name);
/* 1444 */       if (renamedField != null) {
/* 1445 */         name = renamedField;
/*      */       }
/* 1447 */       return mModel.getResource(type, name);
/*      */     }
/* 1449 */     return null;
/*      */   }
/*      */   
/*      */   private void gatherResourceValues(File file) throws IOException {
/* 1453 */     if (file.isDirectory()) {
/* 1454 */       File[] children = file.listFiles();
/* 1455 */       if (children != null) {
/* 1456 */         for (File child : children) {
/* 1457 */           gatherResourceValues(child);
/*      */         }
/*      */       }
/* 1460 */     } else if ((file.isFile()) && (file.getName().equals("R.java"))) {
/* 1461 */       parseResourceClass(file);
/*      */     }
/*      */   }
/*      */   
/*      */   private void parseResourceClass(File file) throws IOException
/*      */   {
/* 1467 */     String s = Files.toString(file, Charsets.UTF_8);
/*      */     
/* 1469 */     String pkg = null;
/* 1470 */     int index = s.indexOf("package ");
/* 1471 */     if (index != -1) {
/* 1472 */       int end = s.indexOf(';', index);
/* 1473 */       pkg = s.substring(index + "package ".length(), end).trim().replace('.', '/');
/*      */     }
/* 1475 */     index = 0;
/* 1476 */     int length = s.length();
/* 1477 */     String classDeclaration = "public static final class ";
/*      */     for (;;) {
/* 1479 */       index = s.indexOf(classDeclaration, index);
/* 1480 */       if (index == -1) {
/*      */         break;
/*      */       }
/* 1483 */       int start = index + classDeclaration.length();
/* 1484 */       int end = s.indexOf(' ', start);
/* 1485 */       if (end == -1) {
/*      */         break;
/*      */       }
/* 1488 */       String typeName = s.substring(start, end);
/* 1489 */       ResourceType type = ResourceType.getEnum(typeName);
/* 1490 */       if (type == null) {
/*      */         break;
/*      */       }
/*      */       
/* 1494 */       if (pkg != null) {
/* 1495 */         String owner = pkg + "/R$" + type.getName();
/* 1496 */         Pair<ResourceType, Map<String, String>> pair = (Pair)mResourceObfuscation.get(owner);
/* 1497 */         if (pair == null) {
/* 1498 */           Map<String, String> nameMap = Maps.newHashMap();
/* 1499 */           pair = Pair.of(type, nameMap);
/*      */         }
/* 1501 */         mResourceObfuscation.put(owner, pair);
/*      */       }
/*      */       
/* 1504 */       for (index = end; 
/*      */           
/* 1507 */           index < length - 1; index++) {
/* 1508 */         char c = s.charAt(index);
/* 1509 */         if (!Character.isWhitespace(c))
/*      */         {
/* 1514 */           if (c == '/') {
/* 1515 */             char next = s.charAt(index + 1);
/* 1516 */             if (next == '*')
/*      */             {
/* 1518 */               end = index + 2;
/* 1519 */               while (end < length - 2) {
/* 1520 */                 c = s.charAt(end);
/* 1521 */                 if ((c == '*') && (s.charAt(end + 1) == '/')) {
/* 1522 */                   end++;
/* 1523 */                   break;
/*      */                 }
/* 1525 */                 end++;
/*      */               }
/*      */               
/* 1528 */               index = end;
/* 1529 */             } else if (next == '/')
/*      */             {
/* 1531 */               if (!$assertionsDisabled) throw new AssertionError(s.substring(index - 1, index + 50));
/*      */             }
/* 1533 */             else if (!$assertionsDisabled) { throw new AssertionError(s.substring(index - 1, index + 50));
/*      */             }
/* 1535 */           } else if ((c == 'p') && (s.startsWith("public ", index))) {
/* 1536 */             if (type == ResourceType.STYLEABLE) {
/* 1537 */               start = s.indexOf(" int", index);
/* 1538 */               if (s.startsWith(" int[] ", start)) {
/* 1539 */                 start += " int[] ".length();
/* 1540 */                 end = s.indexOf('=', start);
/* 1541 */                 assert (end != -1);
/* 1542 */                 String styleable = s.substring(start, end).trim();
/* 1543 */                 mModel.addResource(ResourceType.DECLARE_STYLEABLE, styleable, null);
/* 1544 */                 mModel.addResource(ResourceType.STYLEABLE, styleable, null);
/*      */                 
/* 1547 */                 index = s.indexOf(';', index);
/* 1548 */                 if (index == -1) {
/*      */                   break;
/*      */                 }
/* 1551 */               } else if (s.startsWith(" int ", start))
/*      */               {
/* 1558 */                 index = s.indexOf(';', index);
/* 1559 */                 if (index == -1) {
/*      */                   break;
/*      */                 }
/*      */               }
/*      */             }
/*      */             else {
/* 1565 */               start = s.indexOf(" int ", index);
/* 1566 */               if (start != -1) {
/* 1567 */                 start += " int ".length();
/*      */                 
/* 1569 */                 end = s.indexOf('=', start);
/* 1570 */                 assert (end != -1);
/* 1571 */                 String name = s.substring(start, end).trim();
/* 1572 */                 start = end + 1;
/* 1573 */                 end = s.indexOf(';', start);
/* 1574 */                 assert (end != -1);
/* 1575 */                 String value = s.substring(start, end).trim();
/* 1576 */                 mModel.addResource(type, name, value);
/*      */               }
/*      */             }
/* 1579 */           } else { if (c == '}')
/*      */               break;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public int getUnusedResourceCount() {
/* 1588 */     return mUnused.size();
/*      */   }
/*      */   
/*      */   ResourceUsageModel getModel()
/*      */   {
/* 1593 */     return mModel;
/*      */   }
/*      */   
/*      */   private class UsageVisitor
/*      */     extends ClassVisitor
/*      */   {
/*      */     private final File mJarFile;
/*      */     
/*      */     private final String mCurrentClass;
/*      */     
/*      */     public UsageVisitor(File jarFile, String name)
/*      */     {
/* 1607 */       super();
/* 1608 */       mJarFile = jarFile;
/* 1609 */       mCurrentClass = name;
/*      */     }
/*      */     
/*      */     public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
/*      */     {
/* 1615 */       new MethodVisitor(327680)
/*      */       {
/*      */         public void visitLdcInsn(Object cst) {
/* 1618 */           ResourceUsageAnalyzer.UsageVisitor.this.handleCodeConstant(cst, "ldc");
/*      */         }
/*      */         
/*      */         public void visitFieldInsn(int opcode, String owner, String name, String desc)
/*      */         {
/* 1623 */           if (opcode == 178) {
/* 1624 */             ResourceUsageModel.Resource resource = getResourceFromCode(owner, name);
/* 1625 */             if (resource != null) {
/* 1626 */               ResourceUsageModel.markReachable(resource);
/*      */             }
/*      */           }
/*      */         }
/*      */         
/*      */         public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf)
/*      */         {
/* 1634 */           super.visitMethodInsn(opcode, owner, name, desc, itf);
/* 1635 */           if ((owner.equals("android/content/res/Resources")) && 
/* 1636 */             (name.equals("getIdentifier")) && 
/* 1637 */             (desc.equals("(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I")))
/*      */           {
/* 1640 */             if ((mCurrentClass.equals(mResourcesWrapper)) || 
/* 1641 */               (mCurrentClass.equals(mSuggestionsAdapter)))
/*      */             {
/* 1644 */               return;
/*      */             }
/*      */             
/* 1647 */             mFoundGetIdentifier = true;
/*      */           }
/*      */           
/* 1652 */           if ((owner.equals("android/webkit/WebView")) && (name.startsWith("load"))) {
/* 1653 */             mFoundWebContent = true;
/*      */           }
/*      */         }
/*      */         
/*      */         public AnnotationVisitor visitAnnotationDefault()
/*      */         {
/* 1659 */           return new ResourceUsageAnalyzer.UsageVisitor.AnnotationUsageVisitor(ResourceUsageAnalyzer.UsageVisitor.this);
/*      */         }
/*      */         
/*      */         public AnnotationVisitor visitAnnotation(String desc, boolean visible)
/*      */         {
/* 1664 */           return new ResourceUsageAnalyzer.UsageVisitor.AnnotationUsageVisitor(ResourceUsageAnalyzer.UsageVisitor.this);
/*      */         }
/*      */         
/*      */         public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible)
/*      */         {
/* 1670 */           return new ResourceUsageAnalyzer.UsageVisitor.AnnotationUsageVisitor(ResourceUsageAnalyzer.UsageVisitor.this);
/*      */         }
/*      */       };
/*      */     }
/*      */     
/*      */     public AnnotationVisitor visitAnnotation(String desc, boolean visible)
/*      */     {
/* 1677 */       return new AnnotationUsageVisitor();
/*      */     }
/*      */     
/*      */     public FieldVisitor visitField(int access, String name, String desc, String signature, Object value)
/*      */     {
/* 1683 */       handleCodeConstant(value, "field");
/* 1684 */       new FieldVisitor(327680)
/*      */       {
/*      */         public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
/* 1687 */           return new ResourceUsageAnalyzer.UsageVisitor.AnnotationUsageVisitor(ResourceUsageAnalyzer.UsageVisitor.this);
/*      */         }
/*      */       };
/*      */     }
/*      */     
/*      */     private class AnnotationUsageVisitor extends AnnotationVisitor {
/*      */       public AnnotationUsageVisitor() {
/* 1694 */         super();
/*      */       }
/*      */       
/*      */       public AnnotationVisitor visitAnnotation(String name, String desc)
/*      */       {
/* 1699 */         return new AnnotationUsageVisitor(ResourceUsageAnalyzer.UsageVisitor.this);
/*      */       }
/*      */       
/*      */       public AnnotationVisitor visitArray(String name)
/*      */       {
/* 1704 */         return new AnnotationUsageVisitor(ResourceUsageAnalyzer.UsageVisitor.this);
/*      */       }
/*      */       
/*      */       public void visit(String name, Object value)
/*      */       {
/* 1709 */         ResourceUsageAnalyzer.UsageVisitor.this.handleCodeConstant(value, "annotation");
/* 1710 */         super.visit(name, value);
/*      */       }
/*      */     }
/*      */     
/*      */     private void handleCodeConstant(Object cst, String context) {
/*      */       ResourceUsageModel.Resource resource;
/* 1716 */       if ((cst instanceof Integer)) {
/* 1717 */         Integer value = (Integer)cst;
/* 1718 */         resource = mModel.getResource(value);
/* 1719 */         if ((ResourceUsageModel.markReachable(resource)) && (mDebug)) {
/* 1720 */           assert (mDebugPrinter != null) : "mDebug is true, but mDebugPrinter is null.";
/* 1721 */           mDebugPrinter.println("Marking " + resource + " reachable: referenced from " + context + " in " + mJarFile + ":" + mCurrentClass);
/*      */         }
/*      */       }
/* 1724 */       else if ((cst instanceof int[])) {
/* 1725 */         int[] values = (int[])cst;
/* 1726 */         for (int value : values) {
/* 1727 */           ResourceUsageModel.Resource resource = mModel.getResource(Integer.valueOf(value));
/* 1728 */           if ((ResourceUsageModel.markReachable(resource)) && (mDebug)) {
/* 1729 */             assert (mDebugPrinter != null) : "mDebug is true, but mDebugPrinter is null.";
/* 1730 */             mDebugPrinter.println("Marking " + resource + " reachable: referenced from " + context + " in " + mJarFile + ":" + mCurrentClass);
/*      */           }
/*      */         }
/*      */       }
/* 1734 */       else if ((cst instanceof String)) {
/* 1735 */         String string = (String)cst;
/* 1736 */         ResourceUsageAnalyzer.this.referencedString(string);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/* 1741 */   private final ResourceShrinkerUsageModel mModel = new ResourceShrinkerUsageModel(null);
/*      */   
/*      */   private class ResourceShrinkerUsageModel
/*      */     extends ResourceUsageModel
/*      */   {
/*      */     public File file;
/*      */     
/*      */     private ResourceShrinkerUsageModel() {}
/*      */     
/*      */     protected boolean ignoreToolsAttributes()
/*      */     {
/* 1757 */       return true;
/*      */     }
/*      */     
/*      */     protected List<ResourceUsageModel.Resource> findRoots(List<ResourceUsageModel.Resource> resources)
/*      */     {
/* 1763 */       List<ResourceUsageModel.Resource> roots = super.findRoots(resources);
/* 1764 */       if (mDebugPrinter != null) {
/* 1765 */         mDebugPrinter.println("\nThe root reachable resources are:\n" + 
/* 1766 */           Joiner.on(",\n   ").join(roots));
/*      */       }
/*      */       
/* 1769 */       return roots;
/*      */     }
/*      */     
/*      */     protected ResourceUsageModel.Resource declareResource(ResourceType type, String name, Node node)
/*      */     {
/* 1774 */       ResourceUsageModel.Resource resource = super.declareResource(type, name, node);
/* 1775 */       resource.addLocation(file);
/* 1776 */       return resource;
/*      */     }
/*      */     
/*      */     protected void referencedString(String string)
/*      */     {
/* 1781 */       ResourceUsageAnalyzer.this.referencedString(string);
/* 1782 */       mFoundWebContent = true;
/*      */     }
/*      */   }
/*      */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ResourceUsageAnalyzer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */