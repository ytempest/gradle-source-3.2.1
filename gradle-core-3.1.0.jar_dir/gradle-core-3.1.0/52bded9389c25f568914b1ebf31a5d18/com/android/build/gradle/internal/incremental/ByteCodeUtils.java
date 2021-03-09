/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import com.google.common.base.Joiner;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.google.common.base.Splitter;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import org.objectweb.asm.Type;
/*     */ import org.objectweb.asm.commons.GeneratorAdapter;
/*     */ import org.objectweb.asm.commons.Method;
/*     */ import org.objectweb.asm.tree.AnnotationNode;
/*     */ import org.objectweb.asm.tree.MethodNode;
/*     */ import org.objectweb.asm.util.Textifier;
/*     */ import org.objectweb.asm.util.TraceMethodVisitor;
/*     */ 
/*     */ public class ByteCodeUtils
/*     */ {
/*     */   public static final String CONSTRUCTOR = "<init>";
/*     */   public static final String CLASS_INITIALIZER = "<clinit>";
/*  42 */   private static final Type NUMBER_TYPE = Type.getObjectType("java/lang/Number");
/*  43 */   private static final Method SHORT_VALUE = Method.getMethod("short shortValue()");
/*  44 */   private static final Method BYTE_VALUE = Method.getMethod("byte byteValue()");
/*     */   
/*     */   public static void unbox(GeneratorAdapter mv, Type type)
/*     */   {
/*  58 */     if (type.equals(Type.SHORT_TYPE)) {
/*  59 */       mv.checkCast(NUMBER_TYPE);
/*  60 */       mv.invokeVirtual(NUMBER_TYPE, SHORT_VALUE);
/*  61 */     } else if (type.equals(Type.BYTE_TYPE)) {
/*  62 */       mv.checkCast(NUMBER_TYPE);
/*  63 */       mv.invokeVirtual(NUMBER_TYPE, BYTE_VALUE);
/*     */     } else {
/*  65 */       mv.unbox(type);
/*     */     }
/*     */   }
/*     */   
/*     */   public static String textify(MethodNode method)
/*     */   {
/*  73 */     Textifier textifier = new Textifier();
/*  74 */     TraceMethodVisitor trace = new TraceMethodVisitor(textifier);
/*  75 */     method.accept(trace);
/*  76 */     String ret = "";
/*  77 */     for (Object line : textifier.getText()) {
/*  78 */       ret = ret + line;
/*     */     }
/*  80 */     return ret;
/*     */   }
/*     */   
/*     */   static void newVariableArray(GeneratorAdapter mv, List<LocalVariable> variables)
/*     */   {
/*  89 */     mv.push(variables.size());
/*  90 */     mv.newArray(Type.getType(Object.class));
/*  91 */     loadVariableArray(mv, variables, 0);
/*     */   }
/*     */   
/*     */   static void loadVariableArray(GeneratorAdapter mv, List<LocalVariable> variables, int offset)
/*     */   {
/* 103 */     for (int i = offset; i < variables.size(); i++) {
/* 104 */       LocalVariable variable = (LocalVariable)variables.get(i);
/*     */       
/* 106 */       mv.dup();
/*     */       
/* 108 */       mv.push(i);
/*     */       
/* 110 */       mv.visitVarInsn(type.getOpcode(21), var);
/*     */       
/* 112 */       mv.box(type);
/*     */       
/* 114 */       mv.arrayStore(Type.getType(Object.class));
/*     */     }
/*     */   }
/*     */   
/*     */   static void restoreVariables(GeneratorAdapter mv, List<LocalVariable> variables)
/*     */   {
/* 125 */     for (int i = 0; i < variables.size(); i++) {
/* 126 */       LocalVariable variable = (LocalVariable)variables.get(i);
/*     */       
/* 128 */       mv.dup();
/*     */       
/* 130 */       mv.push(i);
/*     */       
/* 132 */       mv.arrayLoad(Type.getType(Object.class));
/*     */       
/* 134 */       mv.unbox(type);
/*     */       
/* 136 */       mv.visitVarInsn(type.getOpcode(54), var);
/*     */     }
/*     */     
/* 139 */     mv.pop();
/*     */   }
/*     */   
/*     */   static List<LocalVariable> toLocalVariables(List<Type> types)
/*     */   {
/* 146 */     List<LocalVariable> variables = Lists.newArrayList();
/* 147 */     int stack = 0;
/* 148 */     for (int i = 0; i < types.size(); i++) {
/* 149 */       Type type = (Type)types.get(i);
/* 150 */       variables.add(new LocalVariable(type, stack));
/* 151 */       stack += type.getSize();
/*     */     }
/* 153 */     return variables;
/*     */   }
/*     */   
/*     */   static Type getTypeForStoreOpcode(int opcode)
/*     */   {
/* 161 */     switch (opcode) {
/*     */     case 54: 
/* 163 */       return Type.INT_TYPE;
/*     */     case 55: 
/* 165 */       return Type.LONG_TYPE;
/*     */     case 56: 
/* 167 */       return Type.FLOAT_TYPE;
/*     */     case 57: 
/* 169 */       return Type.DOUBLE_TYPE;
/*     */     case 58: 
/* 171 */       return Type.getType(Object.class);
/*     */     }
/* 173 */     return null;
/*     */   }
/*     */   
/*     */   public static String toInternalName(String className)
/*     */   {
/* 182 */     return className.replace('.', '/');
/*     */   }
/*     */   
/*     */   public static String getClassName(String memberName)
/*     */   {
/* 190 */     Preconditions.checkArgument(memberName.contains(":"), "Class name passed as argument.");
/* 191 */     return memberName.substring(0, memberName.indexOf('.'));
/*     */   }
/*     */   
/*     */   public static Optional<String> getPackageName(String internalName)
/*     */   {
/* 202 */     List<String> parts = Splitter.on('/').splitToList(internalName);
/* 203 */     if (parts.size() == 1) {
/* 204 */       return Optional.empty();
/*     */     }
/*     */     
/* 207 */     return Optional.of(Joiner.on('.').join(parts.subList(0, parts.size() - 1)));
/*     */   }
/*     */   
/*     */   public static boolean isAnnotatedWith(MethodNode method, String annotationInternalName)
/*     */   {
/* 217 */     List<AnnotationNode> annotations = invisibleAnnotations;
/* 218 */     if ((annotations != null) && (isAnnotationPartOf(annotations, annotationInternalName))) {
/* 219 */       return true;
/*     */     }
/* 221 */     annotations = visibleAnnotations;
/* 222 */     return (annotations != null) && (isAnnotationPartOf(annotations, annotationInternalName));
/*     */   }
/*     */   
/*     */   private static boolean isAnnotationPartOf(List<AnnotationNode> annotations, String annotationInternalName)
/*     */   {
/* 228 */     for (AnnotationNode annotation : annotations) {
/* 229 */       if (desc.equals(annotationInternalName)) {
/* 230 */         return true;
/*     */       }
/*     */     }
/* 233 */     return false;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.ByteCodeUtils
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */