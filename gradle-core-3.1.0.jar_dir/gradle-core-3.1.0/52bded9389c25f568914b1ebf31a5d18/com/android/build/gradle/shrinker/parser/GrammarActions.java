/*     */ package com.android.build.gradle.shrinker.parser;
/*     */ 
/*     */ import com.google.common.base.Preconditions;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
/*     */ import org.antlr.runtime.ANTLRFileStream;
/*     */ import org.antlr.runtime.ANTLRStringStream;
/*     */ import org.antlr.runtime.CharStream;
/*     */ import org.antlr.runtime.CommonTokenStream;
/*     */ import org.antlr.runtime.RecognitionException;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ public class GrammarActions
/*     */ {
/*  38 */   private static Logger logger = LoggerFactory.getLogger(GrammarActions.class);
/*     */   
/*     */   static enum FilterSeparator {
/*  41 */     GENERAL(".", ".*"), 
/*  42 */     FILE("[^/]", "[^/]*"), 
/*  43 */     CLASS("[^/]", "[^/]*"), 
/*  44 */     ATTRIBUTE(".", ".*");
/*     */     
/*     */     private final String singleCharWildcard;
/*     */     
/*     */     private final String multipleCharWildcard;
/*     */     
/*     */     private FilterSeparator(String singleCharWildcard, String multipleCharWildcard)
/*     */     {
/*  53 */       this.singleCharWildcard = singleCharWildcard;
/*  54 */       this.multipleCharWildcard = multipleCharWildcard;
/*     */     }
/*     */   }
/*     */   
/*     */   public static void parse(File proguardFile, ProguardFlags flags, UnsupportedFlagsHandler flagsHandler)
/*     */     throws RecognitionException
/*     */   {
/*  63 */     ProguardParser parser = createParserFromFile(proguardFile);
/*  64 */     parser.prog(flags, flagsHandler, proguardFile.getParentFile().getPath());
/*     */   }
/*     */   
/*     */   public static void parse(String input, ProguardFlags flags, UnsupportedFlagsHandler flagsHandler)
/*     */     throws RecognitionException
/*     */   {
/*  72 */     ProguardParser parser = createParserFromString(input);
/*  73 */     parser.prog(flags, flagsHandler, null);
/*     */   }
/*     */   
/*     */   static void include(String fileName, String baseDirectory, ProguardFlags flags, UnsupportedFlagsHandler flagsHandler)
/*     */     throws RecognitionException
/*     */   {
/*  82 */     parse(getFileFromBaseDir(baseDirectory, fileName), flags, flagsHandler);
/*     */   }
/*     */   
/*     */   static void dontWarn(ProguardFlags flags, List<FilterSpecification> classSpec)
/*     */   {
/*  87 */     flags.dontWarn(classSpec);
/*     */   }
/*     */   
/*     */   static void ignoreWarnings(ProguardFlags flags) {
/*  91 */     flags.setIgnoreWarnings(true);
/*     */   }
/*     */   
/*     */   static void addKeepClassMembers(ProguardFlags flags, ClassSpecification classSpecification, KeepModifier keepModifier)
/*     */   {
/*  98 */     classSpecification.setKeepModifier(keepModifier);
/*  99 */     flags.addKeepClassMembers(classSpecification);
/*     */   }
/*     */   
/*     */   static void addKeepClassSpecification(ProguardFlags flags, ClassSpecification classSpecification, KeepModifier keepModifier)
/*     */   {
/* 106 */     classSpecification.setKeepModifier(keepModifier);
/* 107 */     flags.addKeepClassSpecification(classSpecification);
/*     */   }
/*     */   
/*     */   static void addKeepClassesWithMembers(ProguardFlags flags, ClassSpecification classSpecification, KeepModifier keepModifier)
/*     */   {
/* 114 */     classSpecification.setKeepModifier(keepModifier);
/* 115 */     flags.addKeepClassesWithMembers(classSpecification);
/*     */   }
/*     */   
/*     */   static void addAccessFlag(ModifierSpecification modSpec, ModifierSpecification.AccessFlag accessFlag, boolean hasNegator)
/*     */   {
/* 122 */     modSpec.addAccessFlag(accessFlag, hasNegator);
/*     */   }
/*     */   
/*     */   static void addModifier(ModifierSpecification modSpec, ModifierSpecification.Modifier modifier, boolean hasNegator)
/*     */   {
/* 129 */     modSpec.addModifier(modifier, hasNegator);
/*     */   }
/*     */   
/*     */   static AnnotationSpecification annotation(String annotationName, boolean hasNameNegator)
/*     */   {
/* 135 */     NameSpecification name = name(annotationName, FilterSeparator.CLASS);
/* 136 */     name.setNegator(hasNameNegator);
/* 137 */     return new AnnotationSpecification(name);
/*     */   }
/*     */   
/*     */   static ClassSpecification classSpec(List<NameSpecification> classNames, ClassTypeSpecification classType, AnnotationSpecification annotation, ModifierSpecification modifier)
/*     */   {
/* 146 */     ClassSpecification classSpec = new ClassSpecification(classNames, classType, annotation);
/* 147 */     classSpec.setModifier(modifier);
/* 148 */     return classSpec;
/*     */   }
/*     */   
/*     */   static NameSpecification className(String name, boolean hasNameNegator) { NameSpecification nameSpec;
/*     */     NameSpecification nameSpec;
/* 153 */     if (name.equals("*")) {
/* 154 */       nameSpec = name("**", FilterSeparator.CLASS);
/*     */     } else {
/* 156 */       nameSpec = name(name, FilterSeparator.CLASS);
/*     */     }
/* 158 */     nameSpec.setNegator(hasNameNegator);
/* 159 */     return nameSpec;
/*     */   }
/*     */   
/*     */   static ClassTypeSpecification classType(int type, boolean hasNegator)
/*     */   {
/* 164 */     ClassTypeSpecification classSpec = new ClassTypeSpecification(type);
/* 165 */     classSpec.setNegator(hasNegator);
/* 166 */     return classSpec;
/*     */   }
/*     */   
/*     */   static InheritanceSpecification createInheritance(String className, boolean hasNameNegator, AnnotationSpecification annotationType)
/*     */   {
/* 174 */     NameSpecification nameSpec = name(className, FilterSeparator.CLASS);
/* 175 */     nameSpec.setNegator(hasNameNegator);
/* 176 */     return new InheritanceSpecification(nameSpec, annotationType);
/*     */   }
/*     */   
/*     */   static void field(ClassSpecification classSpec, AnnotationSpecification annotationType, String typeSignature, String name, ModifierSpecification modifier)
/*     */   {
/* 185 */     NameSpecification typeSignatureSpec = null;
/* 186 */     if (typeSignature != null) {
/* 187 */       typeSignatureSpec = name(typeSignature, FilterSeparator.CLASS);
/*     */     } else {
/* 189 */       Preconditions.checkState(name.equals("*"), "No type signature, but name is not <fields> or *.");
/* 190 */       name = "*";
/*     */     }
/*     */     
/* 193 */     classSpec.add(new FieldSpecification(
/*     */     
/* 195 */       name(name, FilterSeparator.GENERAL), modifier, typeSignatureSpec, annotationType));
/*     */   }
/*     */   
/*     */   static void fieldOrAnyMember(ClassSpecification classSpec, AnnotationSpecification annotationType, String typeSig, String name, ModifierSpecification modifier)
/*     */   {
/* 207 */     if (typeSig == null) {
/* 208 */       assert (name.equals("*"));
/*     */       
/* 210 */       method(classSpec, annotationType, 
/*     */       
/* 213 */         getSignature("***", 0), "*", "\\(" + 
/*     */         
/* 215 */         getSignature("...", 0) + "\\)", modifier);
/*     */     }
/*     */     
/* 218 */     field(classSpec, annotationType, typeSig, name, modifier);
/*     */   }
/*     */   
/*     */   static void filter(List<FilterSpecification> filter, boolean negator, String filterName, FilterSeparator separator)
/*     */   {
/* 226 */     filter.add(new FilterSpecification(name(filterName, separator), negator));
/*     */   }
/*     */   
/*     */   static String getSignature(String name, int dim)
/*     */   {
/* 231 */     StringBuilder sig = new StringBuilder();
/*     */     
/* 233 */     for (??? = 0; ??? < dim; ???++) {
/* 234 */       sig.append("\\[");
/*     */     }
/*     */     
/* 238 */     switch (name) {
/*     */     case "...": 
/* 240 */       sig.append(".*");
/* 241 */       break;
/*     */     
/*     */     case "***": 
/* 244 */       sig.append(".*");
/* 245 */       break;
/*     */     case "%": 
/* 247 */       sig.append("(B|C|D|F|I|J|S|Z)");
/* 248 */       break;
/*     */     case "boolean": 
/* 250 */       sig.append("Z");
/* 251 */       break;
/*     */     case "byte": 
/* 253 */       sig.append("B");
/* 254 */       break;
/*     */     case "char": 
/* 256 */       sig.append("C");
/* 257 */       break;
/*     */     case "short": 
/* 259 */       sig.append("S");
/* 260 */       break;
/*     */     case "int": 
/* 262 */       sig.append("I");
/* 263 */       break;
/*     */     case "float": 
/* 265 */       sig.append("F");
/* 266 */       break;
/*     */     case "double": 
/* 268 */       sig.append("D");
/* 269 */       break;
/*     */     case "long": 
/* 271 */       sig.append("J");
/* 272 */       break;
/*     */     case "void": 
/* 274 */       sig.append("V");
/* 275 */       break;
/*     */     
/*     */     default: 
/* 279 */       sig.append("L").append(convertNameToPattern(name, FilterSeparator.CLASS)).append(";");
/*     */     }
/*     */     
/*     */     
/* 283 */     return sig.toString();
/*     */   }
/*     */   
/*     */   static void method(ClassSpecification classSpec, AnnotationSpecification annotationType, String typeSig, String name, String signature, ModifierSpecification modifier)
/*     */   {
/* 293 */     String fullName = "^" + convertNameToPattern(name, FilterSeparator.CLASS);
/* 294 */     fullName = fullName + ":";
/* 295 */     fullName = fullName + signature;
/* 296 */     if (typeSig != null) {
/* 297 */       fullName = fullName + typeSig;
/*     */     } else {
/* 299 */       fullName = fullName + "V";
/*     */     }
/* 301 */     fullName = fullName + "$";
/* 302 */     Pattern pattern = Pattern.compile(fullName);
/* 303 */     classSpec.add(new MethodSpecification(new NameSpecification(pattern), modifier, annotationType));
/*     */   }
/*     */   
/*     */   static NameSpecification name(String name, FilterSeparator filterSeparator)
/*     */   {
/* 309 */     String transformedName = "^" + convertNameToPattern(name, filterSeparator) + "$";
/*     */     
/* 311 */     Pattern pattern = Pattern.compile(transformedName);
/* 312 */     return new NameSpecification(pattern);
/*     */   }
/*     */   
/*     */   static void unsupportedFlag(String flag)
/*     */   {
/* 317 */     throw new IllegalArgumentException(String.format("Flag %s is not supported by the built-in shrinker.", new Object[] { flag }));
/*     */   }
/*     */   
/*     */   static void ignoredFlag(String flag, boolean printWarning) {
/* 321 */     if (printWarning) {
/* 322 */       logger.warn("Flag {} is ignored by the built-in shrinker.", flag);
/*     */     }
/*     */   }
/*     */   
/*     */   static void target(ProguardFlags flags, String target) {
/* 327 */     flags.target(target);
/*     */   }
/*     */   
/*     */   static void whyAreYouKeeping(ProguardFlags flags, ClassSpecification classSpecification) {
/* 331 */     flags.whyAreYouKeeping(classSpecification);
/*     */   }
/*     */   
/*     */   static void dontOptimize(ProguardFlags flags) {
/* 335 */     flags.setDontOptimize(true);
/*     */   }
/*     */   
/*     */   static void dontShrink(ProguardFlags flags) {
/* 339 */     flags.setDontShrink(true);
/*     */   }
/*     */   
/*     */   static void dontObfuscate(ProguardFlags flags) {
/* 343 */     flags.setDontObfuscate(true);
/*     */   }
/*     */   
/*     */   private static String convertNameToPattern(String name, FilterSeparator separator)
/*     */   {
/* 349 */     StringBuilder sb = new StringBuilder();
/* 350 */     for (int i = 0; i < name.length(); i++) {
/* 351 */       char c = name.charAt(i);
/* 352 */       switch (c) {
/*     */       case '.': 
/* 354 */         if (separator == FilterSeparator.CLASS) {
/* 355 */           sb.append('/');
/*     */         } else {
/* 357 */           sb.append('.');
/*     */         }
/* 359 */         break;
/*     */       
/*     */       case '?': 
/* 363 */         sb.append(singleCharWildcard);
/* 364 */         break;
/*     */       case '*': 
/* 366 */         int j = i + 1;
/* 367 */         if ((j < name.length()) && (name.charAt(j) == '*'))
/*     */         {
/* 370 */           sb.append(".*");
/* 371 */           i++;
/*     */         }
/*     */         else
/*     */         {
/* 375 */           sb.append(multipleCharWildcard);
/*     */         }
/* 377 */         break;
/*     */       case '$': 
/* 379 */         sb.append("\\$");
/* 380 */         break;
/*     */       default: 
/* 382 */         sb.append(c);
/*     */       }
/*     */       
/*     */     }
/* 386 */     return sb.toString();
/*     */   }
/*     */   
/*     */   private static ProguardParser createParserCommon(CharStream stream)
/*     */   {
/* 391 */     ProguardLexer lexer = new ProguardLexer(stream);
/* 392 */     CommonTokenStream tokens = new CommonTokenStream(lexer);
/* 393 */     return new ProguardParser(tokens);
/*     */   }
/*     */   
/*     */   private static ProguardParser createParserFromFile(File file)
/*     */   {
/*     */     try {
/* 399 */       return createParserCommon(new ANTLRFileStream(file.getPath()));
/*     */     } catch (IOException e) {
/* 401 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   private static ProguardParser createParserFromString(String input)
/*     */   {
/* 407 */     return createParserCommon(new ANTLRStringStream(input));
/*     */   }
/*     */   
/*     */   private static File getFileFromBaseDir(String baseDir, String path)
/*     */   {
/* 412 */     File file = new File(path);
/* 413 */     if (!file.isAbsolute()) {
/* 414 */       file = new File(baseDir, path);
/*     */     }
/* 416 */     return file;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.parser.GrammarActions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */