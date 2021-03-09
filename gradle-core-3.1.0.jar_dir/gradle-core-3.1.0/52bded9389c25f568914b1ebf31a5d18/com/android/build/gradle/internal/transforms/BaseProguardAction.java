/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.gradle.internal.PostprocessingFeatures;
/*     */ import com.android.build.gradle.internal.scope.VariantScope;
/*     */ import com.google.common.collect.ArrayListMultimap;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ListMultimap;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import proguard.ClassPath;
/*     */ import proguard.ClassPathEntry;
/*     */ import proguard.ClassSpecification;
/*     */ import proguard.Configuration;
/*     */ import proguard.ConfigurationParser;
/*     */ import proguard.KeepClassSpecification;
/*     */ import proguard.ParseException;
/*     */ import proguard.ProGuard;
/*     */ import proguard.classfile.util.ClassUtil;
/*     */ import proguard.util.ListUtil;
/*     */ 
/*     */ public abstract class BaseProguardAction
/*     */   extends ProguardConfigurable
/*     */ {
/*  43 */   protected static final List<String> JAR_FILTER = ImmutableList.of("!META-INF/MANIFEST.MF");
/*     */   
/*  45 */   protected final Configuration configuration = new Configuration();
/*     */   
/*  50 */   ListMultimap<File, List<String>> fileToFilter = ArrayListMultimap.create();
/*     */   
/*     */   public BaseProguardAction(VariantScope scope)
/*     */   {
/*  54 */     super(scope);
/*  55 */     configuration.useMixedCaseClassNames = false;
/*  56 */     configuration.programJars = new ClassPath();
/*  57 */     configuration.libraryJars = new ClassPath();
/*     */   }
/*     */   
/*     */   public void runProguard() throws IOException {
/*  61 */     new ProGuard(configuration).execute();
/*  62 */     fileToFilter.clear();
/*     */   }
/*     */   
/*     */   public void keep(String keep)
/*     */   {
/*  67 */     if (configuration.keep == null) {
/*  68 */       configuration.keep = Lists.newArrayList();
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  73 */       ConfigurationParser parser = new ConfigurationParser(new String[] { keep }, null);
/*  74 */       classSpecification = parser.parseClassSpecificationArguments();
/*     */     } catch (IOException e) {
/*     */       ClassSpecification classSpecification;
/*  77 */       throw new AssertionError(e);
/*     */     } catch (ParseException e) {
/*  79 */       throw new RuntimeException(e);
/*     */     }
/*     */     
/*     */     ClassSpecification classSpecification;
/*  83 */     configuration.keep.add(new KeepClassSpecification(true, false, false, false, false, false, classSpecification));
/*     */   }
/*     */   
/*     */   public void dontpreverify()
/*     */   {
/*  94 */     configuration.preverify = false;
/*     */   }
/*     */   
/*     */   public void keepattributes() {
/*  98 */     configuration.keepAttributes = Lists.newArrayListWithExpectedSize(0);
/*     */   }
/*     */   
/*     */   public void dontwarn(String dontwarn)
/*     */   {
/* 103 */     if (configuration.warn == null) {
/* 104 */       configuration.warn = Lists.newArrayList();
/*     */     }
/*     */     
/* 107 */     dontwarn = ClassUtil.internalClassName(dontwarn);
/*     */     
/* 110 */     configuration.warn.addAll(ListUtil.commaSeparatedList(dontwarn));
/*     */   }
/*     */   
/*     */   public void setActions(PostprocessingFeatures actions)
/*     */   {
/* 115 */     configuration.obfuscate = actions.isObfuscate();
/* 116 */     configuration.optimize = actions.isOptimize();
/* 117 */     configuration.shrink = actions.isRemoveUnusedCode();
/*     */   }
/*     */   
/*     */   public void dontwarn() {
/* 121 */     configuration.warn = Lists.newArrayList(new String[] { "**" });
/*     */   }
/*     */   
/*     */   public void dontnote() {
/* 125 */     configuration.note = Lists.newArrayList(new String[] { "**" });
/*     */   }
/*     */   
/*     */   public void forceprocessing() {
/* 129 */     configuration.lastModified = Long.MAX_VALUE;
/*     */   }
/*     */   
/*     */   protected void applyMapping(File testedMappingFile) {
/* 133 */     configuration.applyMapping = testedMappingFile;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void applyConfigurationFile(File file)
/*     */     throws IOException, ParseException
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokevirtual 52	java/io/File:isFile	()Z
/*     */     //   4: ifne +4 -> 8
/*     */     //   7: return
/*     */     //   8: new 18	proguard/ConfigurationParser
/*     */     //   11: dup
/*     */     //   12: aload_1
/*     */     //   13: invokestatic 53	java/lang/System:getProperties	()Ljava/util/Properties;
/*     */     //   16: invokespecial 54	proguard/ConfigurationParser:<init>	(Ljava/io/File;Ljava/util/Properties;)V
/*     */     //   19: astore_2
/*     */     //   20: aload_2
/*     */     //   21: aload_0
/*     */     //   22: getfield 4	com/android/build/gradle/internal/transforms/BaseProguardAction:configuration	Lproguard/Configuration;
/*     */     //   25: invokevirtual 55	proguard/ConfigurationParser:parse	(Lproguard/Configuration;)V
/*     */     //   28: aload_2
/*     */     //   29: invokevirtual 56	proguard/ConfigurationParser:close	()V
/*     */     //   32: goto +10 -> 42
/*     */     //   35: astore_3
/*     */     //   36: aload_2
/*     */     //   37: invokevirtual 56	proguard/ConfigurationParser:close	()V
/*     */     //   40: aload_3
/*     */     //   41: athrow
/*     */     //   42: return
/*     */     // Line number table:
/*     */     //   Java source line #139	-> byte code offset #0
/*     */     //   Java source line #140	-> byte code offset #7
/*     */     //   Java source line #143	-> byte code offset #8
/*     */     //   Java source line #144	-> byte code offset #13
/*     */     //   Java source line #146	-> byte code offset #20
/*     */     //   Java source line #148	-> byte code offset #28
/*     */     //   Java source line #149	-> byte code offset #32
/*     */     //   Java source line #148	-> byte code offset #35
/*     */     //   Java source line #150	-> byte code offset #42
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	43	0	this	BaseProguardAction
/*     */     //   0	43	1	file	File
/*     */     //   19	18	2	parser	ConfigurationParser
/*     */     //   35	6	3	localObject	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   20	28	35	finally
/*     */   }
/*     */   
/*     */   public void printconfiguration(File file)
/*     */   {
/* 153 */     configuration.printConfiguration = file;
/*     */   }
/*     */   
/*     */   protected void inJar(File jarFile, List<String> filter) {
/* 157 */     inputJar(configuration.programJars, jarFile, filter);
/*     */   }
/*     */   
/*     */   protected void outJar(File file) {
/* 161 */     ClassPathEntry classPathEntry = new ClassPathEntry(file, true);
/* 162 */     configuration.programJars.add(classPathEntry);
/*     */   }
/*     */   
/*     */   protected void libraryJar(File jarFile) {
/* 166 */     inputJar(configuration.libraryJars, jarFile, null);
/*     */   }
/*     */   
/*     */   protected void inputJar(ClassPath classPath, File file, List<String> filter)
/*     */   {
/* 172 */     if ((!file.exists()) || (fileToFilter.containsEntry(file, filter))) {
/* 173 */       return;
/*     */     }
/*     */     
/* 176 */     fileToFilter.put(file, filter);
/*     */     
/* 178 */     ClassPathEntry classPathEntry = new ClassPathEntry(file, false);
/*     */     
/* 180 */     if (filter != null) {
/* 181 */       classPathEntry.setFilter(filter);
/*     */     }
/*     */     
/* 184 */     classPath.add(classPathEntry);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.BaseProguardAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */