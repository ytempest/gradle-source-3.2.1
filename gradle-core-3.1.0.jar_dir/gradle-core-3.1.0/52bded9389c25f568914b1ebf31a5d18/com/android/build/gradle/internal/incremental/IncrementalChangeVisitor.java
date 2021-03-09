/*      */ package com.android.build.gradle.internal.incremental;
/*      */ 
/*      */ import com.android.utils.ILogger;
/*      */ import java.io.PrintStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import org.objectweb.asm.AnnotationVisitor;
/*      */ import org.objectweb.asm.ClassVisitor;
/*      */ import org.objectweb.asm.FieldVisitor;
/*      */ import org.objectweb.asm.Handle;
/*      */ import org.objectweb.asm.Label;
/*      */ import org.objectweb.asm.MethodVisitor;
/*      */ import org.objectweb.asm.Type;
/*      */ import org.objectweb.asm.commons.GeneratorAdapter;
/*      */ import org.objectweb.asm.commons.JSRInlinerAdapter;
/*      */ import org.objectweb.asm.commons.Method;
/*      */ import org.objectweb.asm.tree.ClassNode;
/*      */ import org.objectweb.asm.tree.MethodNode;
/*      */ 
/*      */ public class IncrementalChangeVisitor
/*      */   extends IncrementalVisitor
/*      */ {
/*   53 */   public static final IncrementalVisitor.VisitorBuilder VISITOR_BUILDER = new IncrementalVisitor.VisitorBuilder()
/*      */   {
/*      */     public IncrementalVisitor build(AsmClassNode classNode, ClassVisitor classVisitor, ILogger logger)
/*      */     {
/*   61 */       return new IncrementalChangeVisitor(classNode, classVisitor, logger);
/*      */     }
/*      */     
/*      */     public String getMangledRelativeClassFilePath(String path)
/*      */     {
/*   68 */       return path.substring(0, path.length() - 6) + "$override" + ".class";
/*      */     }
/*      */     
/*      */     public IncrementalVisitor.OutputType getOutputType()
/*      */     {
/*   74 */       return IncrementalVisitor.OutputType.OVERRIDE;
/*      */     }
/*      */   };
/*      */   
/*      */   private static final boolean DEBUG = false;
/*      */   
/*      */   public static final String OVERRIDE_SUFFIX = "$override";
/*      */   
/*      */   private static final String METHOD_MANGLE_PREFIX = "static$";
/*      */   
/*   86 */   private MachineState state = MachineState.NORMAL;
/*   87 */   private boolean instantRunDisabled = false;
/*      */   
/*      */   private String instanceToStaticDescPrefix;
/*      */   
/*   94 */   List<MethodNode> addedMethods = new ArrayList();
/*      */   
/*      */   private static enum MachineState {
/*   97 */     NORMAL,  AFTER_NEW;
/*      */     
/*      */     private MachineState() {}
/*      */   }
/*      */   
/*      */   public IncrementalChangeVisitor(AsmClassNode classNode, ClassVisitor classVisitor, ILogger logger)
/*      */   {
/*  104 */     super(classNode, classVisitor, logger);
/*      */   }
/*      */   
/*      */   public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
/*      */   {
/*  118 */     super.visit(version, 33, name + "$override", signature, "java/lang/Object", new String[] {CHANGE_TYPE
/*      */     
/*  120 */       .getInternalName() });
/*      */     
/*  126 */     visitedClassName = name;
/*  127 */     visitedSuperName = superName;
/*  128 */     instanceToStaticDescPrefix = ("(L" + visitedClassName + ";");
/*      */     
/*  132 */     MethodVisitor mv = super.visitMethod(1, "<init>", "()V", null, null);
/*  133 */     mv.visitCode();
/*  134 */     mv.visitVarInsn(25, 0);
/*  135 */     mv.visitMethodInsn(183, "java/lang/Object", "<init>", "()V", false);
/*      */     
/*  137 */     mv.visitInsn(177);
/*  138 */     mv.visitMaxs(0, 0);
/*  139 */     mv.visitEnd();
/*      */     
/*  141 */     super.visitField(4105, "$obsolete", "Z", null, null);
/*      */   }
/*      */   
/*      */   public void visitOuterClass(String owner, String name, String desc) {}
/*      */   
/*      */   public void visitInnerClass(String name, String outerName, String innerName, int access) {}
/*      */   
/*      */   public AnnotationVisitor visitAnnotation(String desc, boolean visible)
/*      */   {
/*  157 */     if (DISABLE_ANNOTATION_TYPE.getDescriptor().equals(desc)) {
/*  158 */       instantRunDisabled = true;
/*      */     }
/*  160 */     return super.visitAnnotation(desc, visible);
/*      */   }
/*      */   
/*      */   public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
/*      */   {
/*  178 */     if ((instantRunDisabled) || (!isAccessCompatibleWithInstantRun(access)))
/*      */     {
/*  180 */       return null;
/*      */     }
/*  182 */     if (name.equals("<clinit>"))
/*      */     {
/*  184 */       return null;
/*      */     }
/*      */     
/*  187 */     boolean isStatic = (access & 0x8) != 0;
/*  188 */     String newDesc = computeOverrideMethodDesc(desc, isStatic);
/*      */     
/*  204 */     access = 9;
/*  205 */     if (name.equals("<init>")) {
/*  206 */       MethodNode method = getMethodByNameInClass(name, desc, classAndInterfaceNode);
/*  207 */       if (method == null) {
/*  208 */         logger.warning("Cannot find {} method in class {}", new Object[] { name, 
/*      */         
/*  211 */           classAndInterfaceNode.getClassNode().name });
/*  212 */         return null;
/*      */       }
/*  214 */       Constructor constructor = ConstructorBuilder.build(visitedClassName, method);
/*      */       
/*  216 */       MethodVisitor mv = createMethodAdapter(access, args.name, args.desc, args.desc, args.signature, exceptions, isStatic, true);
/*      */       
/*  219 */       args.accept(mv);
/*      */       
/*  221 */       mv = createMethodAdapter(access, body.name, body.desc, newDesc, body.signature, exceptions, isStatic, true);
/*      */       
/*  224 */       body.accept(mv);
/*      */       
/*  227 */       addedMethods.add(args);
/*  228 */       addedMethods.add(body);
/*  229 */       return null;
/*      */     }
/*  231 */     String newName = isStatic ? computeOverrideMethodName(name, desc) : name;
/*  232 */     return createMethodAdapter(access, newName, newDesc, newDesc, signature, exceptions, isStatic, false);
/*      */   }
/*      */   
/*      */   private MethodVisitor createMethodAdapter(int access, String name, String originalDesc, String newDesc, String signature, String[] exceptions, boolean isStatic, boolean isConstructor)
/*      */   {
/*  261 */     MethodVisitor methodVisitor = super.visitMethod(access, name, originalDesc, signature, exceptions);
/*  262 */     methodVisitor = new ISVisitor(methodVisitor, access, name, newDesc, isStatic, isConstructor);
/*      */     
/*  266 */     return new JSRInlinerAdapter(methodVisitor, access, name, newDesc, signature, exceptions);
/*      */   }
/*      */   
/*      */   public FieldVisitor visitField(int access, String name, String desc, String signature, Object value)
/*      */   {
/*  274 */     return null;
/*      */   }
/*      */   
/*      */   public class ISVisitor
/*      */     extends GeneratorAdapter
/*      */   {
/*      */     private final boolean isStatic;
/*      */     
/*      */     private final boolean isConstructor;
/*      */     
/*      */     public ISVisitor(MethodVisitor mv, int access, String name, String desc, boolean isStatic, boolean isConstructor)
/*      */     {
/*  298 */       super(mv, access, name, desc);
/*  299 */       this.isStatic = isStatic;
/*  300 */       this.isConstructor = isConstructor;
/*      */     }
/*      */     
/*      */     public void visitFieldInsn(int opcode, String owner, String name, String desc)
/*      */     {
/*      */       IncrementalVisitor.AccessRight accessRight;
/*      */       
/*      */       IncrementalVisitor.AccessRight accessRight;
/*      */       
/*  310 */       if (!owner.equals(visitedClassName))
/*      */       {
/*  321 */         accessRight = IncrementalVisitor.AccessRight.PUBLIC;
/*      */       }
/*      */       else {
/*  324 */         accessRight = getFieldAccessRightByName(name);
/*  325 */         if (accessRight == null)
/*      */         {
/*  328 */           accessRight = IncrementalVisitor.AccessRight.PACKAGE_PRIVATE;
/*      */         }
/*      */       }
/*      */       
/*  332 */       boolean handled = false;
/*  333 */       switch (opcode) {
/*      */       case 178: 
/*      */       case 179: 
/*  336 */         handled = visitStaticFieldAccess(opcode, owner, name, desc, accessRight);
/*  337 */         break;
/*      */       case 180: 
/*      */       case 181: 
/*  340 */         handled = visitFieldAccess(opcode, owner, name, desc, accessRight);
/*  341 */         break;
/*      */       default: 
/*  343 */         System.out.println("Unhandled field opcode " + opcode);
/*      */       }
/*  345 */       if (!handled) {
/*  346 */         super.visitFieldInsn(opcode, owner, name, desc);
/*      */       }
/*      */     }
/*      */     
/*      */     private boolean visitFieldAccess(int opcode, String owner, String name, String desc, IncrementalVisitor.AccessRight accessRight)
/*      */     {
/*  388 */       boolean useReflection = accessRight != IncrementalVisitor.AccessRight.PUBLIC;
/*      */       
/*  393 */       if (!useReflection) {
/*  394 */         useReflection = (isConstructor) && (owner.equals(visitedClassName));
/*      */       }
/*      */       
/*  397 */       if (useReflection)
/*      */       {
/*  400 */         switch (opcode)
/*      */         {
/*      */         case 180: 
/*  406 */           visitLdcInsn(Type.getType("L" + owner + ";"));
/*      */           
/*  410 */           push(name);
/*      */           
/*  415 */           invokeStatic(IncrementalVisitor.RUNTIME_TYPE, 
/*  416 */             Method.getMethod("Object getPrivateField(Object, Class, String)"));
/*      */           
/*  418 */           ByteCodeUtils.unbox(this, Type.getType(desc));
/*  419 */           break;
/*      */         
/*      */         case 181: 
/*  427 */           box(Type.getType(desc));
/*      */           
/*  430 */           visitLdcInsn(Type.getType("L" + owner + ";"));
/*      */           
/*  432 */           push(name);
/*      */           
/*  437 */           invokeStatic(IncrementalVisitor.RUNTIME_TYPE, 
/*  438 */             Method.getMethod("void setPrivateField(Object, Object, Class, String)"));
/*      */           
/*  440 */           break;
/*      */         default: 
/*  442 */           throw new RuntimeException("VisitFieldAccess called with wrong opcode " + opcode);
/*      */         }
/*      */         
/*  445 */         return true;
/*      */       }
/*      */       
/*  449 */       return false;
/*      */     }
/*      */     
/*      */     private boolean visitStaticFieldAccess(int opcode, String owner, String name, String desc, IncrementalVisitor.AccessRight accessRight)
/*      */     {
/*  492 */       if (accessRight != IncrementalVisitor.AccessRight.PUBLIC) {
/*  493 */         switch (opcode)
/*      */         {
/*      */         case 178: 
/*  499 */           visitLdcInsn(Type.getType("L" + owner + ";"));
/*  500 */           push(name);
/*      */           
/*  503 */           invokeStatic(IncrementalVisitor.RUNTIME_TYPE, 
/*  504 */             Method.getMethod("Object getStaticPrivateField(Class, String)"));
/*      */           
/*  506 */           ByteCodeUtils.unbox(this, Type.getType(desc));
/*  507 */           return true;
/*      */         
/*      */         case 179: 
/*  514 */           box(Type.getType(desc));
/*  515 */           visitLdcInsn(Type.getType("L" + owner + ";"));
/*  516 */           push(name);
/*      */           
/*  520 */           invokeStatic(IncrementalVisitor.RUNTIME_TYPE, 
/*  521 */             Method.getMethod("void setStaticPrivateField(Object, Class, String)"));
/*      */           
/*  523 */           return true; }
/*      */         
/*  525 */         throw new RuntimeException("VisitStaticFieldAccess called with wrong opcode " + opcode);
/*      */       }
/*      */       
/*  529 */       return false;
/*      */     }
/*      */     
/*      */     public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf)
/*      */     {
/*  540 */       boolean opcodeHandled = false;
/*  541 */       if (opcode == 183) {
/*  542 */         opcodeHandled = handleSpecialOpcode(owner, name, desc, itf);
/*  543 */       } else if (opcode == 182) {
/*  544 */         opcodeHandled = handleVirtualOpcode(owner, name, desc, itf);
/*  545 */       } else if (opcode == 184) {
/*  546 */         opcodeHandled = handleStaticOpcode(owner, name, desc, itf);
/*      */       }
/*      */       
/*  551 */       if (!opcodeHandled) {
/*  552 */         mv.visitMethodInsn(opcode, owner, name, desc, itf);
/*      */       }
/*      */     }
/*      */     
/*      */     public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs)
/*      */     {
/*  627 */       Object bsmArg = bsmArgs[1];
/*  628 */       if ((bsmArg instanceof Handle)) {
/*  629 */         bsmArgs[1] = rewriteHandleOwner((Handle)bsmArg);
/*      */       }
/*  631 */       super.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
/*      */     }
/*      */     
/*      */     private Handle rewriteHandleOwner(Handle handle)
/*      */     {
/*  643 */       if (handle.getOwner().equals(visitedClassName))
/*      */       {
/*  647 */         MethodNode lambdaMethod = IncrementalVisitor.getMethodByNameInClass(handle
/*  648 */           .getName(), handle.getDesc(), classAndInterfaceNode);
/*  649 */         if (lambdaMethod == null)
/*      */         {
/*  651 */           throw new RuntimeException(String.format("Internal instant-run error while locating lambda %sin class %s, please file a bug", new Object[] {handle
/*      */           
/*  654 */             .getName(), visitedClassName }));
/*      */         }
/*      */         
/*  662 */         String desc = (access & 0x8) == 0 ? "(L" + visitedClassName + ";" + handle.getDesc().substring(1) : handle.getDesc();
/*      */         
/*  664 */         return new Handle(6, visitedClassName + "$override", handle
/*      */         
/*  669 */           .getName(), desc, false);
/*      */       }
/*      */       
/*  673 */       return handle;
/*      */     }
/*      */     
/*      */     private boolean handleSpecialOpcode(String owner, String name, String desc, boolean itf)
/*      */     {
/*  688 */       if (name.equals("<init>")) {
/*  689 */         return handleConstructor(owner, name, desc);
/*      */       }
/*  691 */       if (owner.equals(visitedClassName))
/*      */       {
/*  697 */         String newDesc = IncrementalChangeVisitor.this.computeOverrideMethodDesc(desc, false);
/*  698 */         super.visitMethodInsn(184, owner + "$override", name, newDesc, itf);
/*  699 */         return true;
/*      */       }
/*      */       
/*  705 */       int arr = boxParametersToNewLocalArray(Type.getArgumentTypes(desc));
/*  706 */       if (itf) {
/*  707 */         push(owner + "." + name + "." + desc);
/*      */       } else {
/*  709 */         push(name + "." + desc);
/*      */       }
/*  711 */       loadLocal(arr);
/*  712 */       mv.visitMethodInsn(184, visitedClassName, "access$super", 
/*  713 */         instanceToStaticDescPrefix + "Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;", false);
/*      */       
/*  716 */       handleReturnType(desc);
/*      */       
/*  718 */       return true;
/*      */     }
/*      */     
/*      */     private boolean handleVirtualOpcode(String owner, String name, String desc, boolean itf)
/*      */     {
/*  744 */       IncrementalVisitor.AccessRight accessRight = getMethodAccessRight(owner, name, desc);
/*  745 */       if (accessRight == IncrementalVisitor.AccessRight.PUBLIC) {
/*  746 */         return false;
/*      */       }
/*      */       
/*  756 */       pushMethodRedirectArgumentsOnStack(name, desc);
/*      */       
/*  762 */       invokeStatic(IncrementalVisitor.RUNTIME_TYPE, Method.getMethod("Object invokeProtectedMethod(Object, Object[], Class[], String)"));
/*      */       
/*  765 */       handleReturnType(desc);
/*  766 */       return true;
/*      */     }
/*      */     
/*      */     private boolean handleStaticOpcode(String owner, String name, String desc, boolean itf)
/*      */     {
/*  791 */       IncrementalVisitor.AccessRight accessRight = getMethodAccessRight(owner, name, desc);
/*  792 */       if (accessRight == IncrementalVisitor.AccessRight.PUBLIC) {
/*  793 */         return false;
/*      */       }
/*      */       
/*  803 */       pushMethodRedirectArgumentsOnStack(name, desc);
/*      */       
/*  806 */       visitLdcInsn(Type.getType("L" + owner + ";"));
/*      */       
/*  812 */       invokeStatic(IncrementalVisitor.RUNTIME_TYPE, Method.getMethod("Object invokeProtectedStaticMethod(Object[], Class[], String, Class)"));
/*      */       
/*  815 */       handleReturnType(desc);
/*  816 */       return true;
/*      */     }
/*      */     
/*      */     public void visitTypeInsn(int opcode, String s)
/*      */     {
/*  821 */       if (opcode == 187)
/*      */       {
/*  823 */         if (state == IncrementalChangeVisitor.MachineState.AFTER_NEW) {
/*  824 */           throw new RuntimeException("Panic, two NEW opcode without a DUP");
/*      */         }
/*      */         
/*  827 */         if (IncrementalChangeVisitor.this.isInSamePackage(s))
/*      */         {
/*  831 */           state = IncrementalChangeVisitor.MachineState.AFTER_NEW;
/*      */           
/*  834 */           return;
/*      */         }
/*      */       }
/*  837 */       super.visitTypeInsn(opcode, s);
/*      */     }
/*      */     
/*      */     public void visitInsn(int opcode)
/*      */     {
/*  845 */       if ((opcode == 89) && (state == IncrementalChangeVisitor.MachineState.AFTER_NEW))
/*      */       {
/*  847 */         state = IncrementalChangeVisitor.MachineState.NORMAL;
/*  848 */         return;
/*      */       }
/*  850 */       super.visitInsn(opcode);
/*      */     }
/*      */     
/*      */     private boolean handleConstructor(String owner, String name, String desc)
/*      */     {
/*  871 */       if (IncrementalChangeVisitor.this.isInSamePackage(owner))
/*      */       {
/*  873 */         Type expectedType = Type.getType("L" + owner + ";");
/*  874 */         pushMethodRedirectArgumentsOnStack(name, desc);
/*      */         
/*  877 */         pop();
/*  878 */         visitLdcInsn(expectedType);
/*      */         
/*  880 */         invokeStatic(IncrementalVisitor.RUNTIME_TYPE, Method.getMethod("Object newForClass(Object[], Class[], Class)"));
/*      */         
/*  883 */         checkCast(expectedType);
/*  884 */         ByteCodeUtils.unbox(this, expectedType);
/*  885 */         return true;
/*      */       }
/*  887 */       return false;
/*      */     }
/*      */     
/*      */     public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index)
/*      */     {
/*  899 */       if ("this".equals(name)) {
/*  900 */         name = "$this";
/*      */       }
/*  902 */       super.visitLocalVariable(name, desc, signature, start, end, index);
/*      */     }
/*      */     
/*      */     public void visitEnd() {}
/*      */     
/*      */     private IncrementalVisitor.AccessRight getMethodAccessRight(String owner, String name, String desc)
/*      */     {
/*  921 */       if (owner.equals(visitedClassName)) {
/*  922 */         IncrementalVisitor.AccessRight accessRight = getMethodAccessRightByName(name, desc);
/*  923 */         if (accessRight == null)
/*      */         {
/*  927 */           return IncrementalVisitor.AccessRight.PROTECTED;
/*      */         }
/*  929 */         return accessRight;
/*      */       }
/*      */       
/*  933 */       return IncrementalVisitor.AccessRight.PUBLIC;
/*      */     }
/*      */     
/*      */     private void pushMethodRedirectArgumentsOnStack(String name, String desc)
/*      */     {
/*  959 */       Type[] parameterTypes = Type.getArgumentTypes(desc);
/*      */       
/*  962 */       int parameters = boxParametersToNewLocalArray(parameterTypes);
/*      */       
/*  964 */       loadLocal(parameters);
/*      */       
/*  967 */       pushParameterTypesOnStack(parameterTypes);
/*      */       
/*  969 */       push(name);
/*      */     }
/*      */     
/*      */     private void pushParameterTypesOnStack(Type[] parameterTypes)
/*      */     {
/*  985 */       push(parameterTypes.length);
/*  986 */       newArray(Type.getType(Class.class));
/*      */       
/*  988 */       for (int i = 0; i < parameterTypes.length; i++) {
/*  989 */         dup();
/*  990 */         push(i);
/*  991 */         switch (parameterTypes[i].getSort()) {
/*      */         case 9: 
/*      */         case 10: 
/*  994 */           visitLdcInsn(parameterTypes[i]);
/*  995 */           break;
/*      */         case 1: 
/*      */         case 2: 
/*      */         case 3: 
/*      */         case 4: 
/*      */         case 5: 
/*      */         case 6: 
/*      */         case 7: 
/*      */         case 8: 
/* 1004 */           push(parameterTypes[i]);
/* 1005 */           break;
/*      */         default: 
/* 1007 */           throw new RuntimeException("Unexpected parameter type " + parameterTypes[i]);
/*      */         }
/*      */         
/*      */         
/* 1011 */         arrayStore(Type.getType(Class.class));
/*      */       }
/*      */     }
/*      */     
/*      */     private void handleReturnType(String desc)
/*      */     {
/* 1020 */       Type ret = Type.getReturnType(desc);
/* 1021 */       if (ret.getSort() == 0) {
/* 1022 */         pop();
/*      */       } else {
/* 1024 */         ByteCodeUtils.unbox(this, ret);
/*      */       }
/*      */     }
/*      */     
/*      */     private int boxParametersToNewLocalArray(Type[] parameterTypes) {
/* 1029 */       int parameters = newLocal(Type.getType("[Ljava/lang.Object;"));
/* 1030 */       push(parameterTypes.length);
/* 1031 */       newArray(Type.getType(Object.class));
/* 1032 */       storeLocal(parameters);
/*      */       
/* 1034 */       for (int i = parameterTypes.length - 1; i >= 0; i--) {
/* 1035 */         loadLocal(parameters);
/* 1036 */         swap(parameterTypes[i], Type.getType(Object.class));
/* 1037 */         push(i);
/* 1038 */         swap(parameterTypes[i], Type.INT_TYPE);
/* 1039 */         box(parameterTypes[i]);
/* 1040 */         arrayStore(Type.getType(Object.class));
/*      */       }
/* 1042 */       return parameters;
/*      */     }
/*      */   }
/*      */   
/*      */   public void visitEnd()
/*      */   {
/* 1048 */     addDispatchMethod();
/*      */   }
/*      */   
/*      */   private void addDispatchMethod()
/*      */   {
/* 1077 */     int access = 129;
/* 1078 */     Method m = new Method("access$dispatch", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;");
/* 1079 */     MethodVisitor visitor = super.visitMethod(access, m
/* 1080 */       .getName(), m
/* 1081 */       .getDescriptor(), null, null);
/*      */     
/* 1084 */     final GeneratorAdapter mv = new GeneratorAdapter(access, m, visitor);
/*      */     
/* 1086 */     if (TRACING_ENABLED) {
/* 1087 */       mv.push("Redirecting ");
/* 1088 */       mv.loadArg(0);
/* 1089 */       trace(mv, 2);
/*      */     }
/*      */     
/* 1092 */     List<MethodNode> allMethods = new ArrayList();
/*      */     
/* 1096 */     if (!instantRunDisabled)
/*      */     {
/* 1098 */       allMethods.addAll(classAndInterfaceNode.getClassNode().methods);
/* 1099 */       allMethods.addAll(addedMethods);
/*      */     }
/*      */     
/* 1102 */     final Map<String, MethodNode> methods = new HashMap();
/* 1103 */     for (MethodNode methodNode : allMethods) {
/* 1104 */       if ((!name.equals("<clinit>")) && (!name.equals("<init>")) && 
/*      */       
/* 1107 */         (isAccessCompatibleWithInstantRun(access)))
/*      */       {
/* 1110 */         methods.put(name + "." + desc, methodNode);
/*      */       }
/*      */     }
/*      */     
/* 1155 */     new StringSwitch()
/*      */     {
/*      */       void visitString()
/*      */       {
/* 1116 */         mv.visitVarInsn(25, 1);
/*      */       }
/*      */       
/*      */       void visitCase(String methodName)
/*      */       {
/* 1121 */         MethodNode methodNode = (MethodNode)methods.get(methodName);
/* 1122 */         String name = name;
/* 1123 */         boolean isStatic = (access & 0x8) != 0;
/*      */         
/* 1125 */         String newDesc = IncrementalChangeVisitor.this.computeOverrideMethodDesc(desc, isStatic);
/*      */         
/* 1127 */         if (IncrementalVisitor.TRACING_ENABLED) {
/* 1128 */           IncrementalVisitor.trace(mv, "M: " + name + " P:" + newDesc);
/*      */         }
/* 1130 */         Type[] args = Type.getArgumentTypes(newDesc);
/* 1131 */         int argc = 0;
/* 1132 */         for (Type t : args) {
/* 1133 */           mv.visitVarInsn(25, 2);
/* 1134 */           mv.push(argc);
/* 1135 */           mv.visitInsn(50);
/* 1136 */           ByteCodeUtils.unbox(mv, t);
/* 1137 */           argc++;
/*      */         }
/* 1139 */         mv.visitMethodInsn(184, visitedClassName + "$override", isStatic ? IncrementalChangeVisitor.this
/* 1140 */           .computeOverrideMethodName(name, desc) : name, newDesc, false);
/*      */         
/* 1142 */         Type ret = Type.getReturnType(desc);
/* 1143 */         if (ret.getSort() == 0) {
/* 1144 */           mv.visitInsn(1);
/*      */         } else {
/* 1146 */           mv.box(ret);
/*      */         }
/* 1148 */         mv.visitInsn(176);
/*      */       }
/*      */       
/* 1153 */       void visitDefault() { writeMissingMessageWithHash(mv, visitedClassName); } }
/*      */     
/* 1155 */       .visit(mv, methods.keySet());
/*      */     
/* 1157 */     mv.visitMaxs(0, 0);
/* 1158 */     mv.visitEnd();
/*      */     
/* 1160 */     super.visitEnd();
/*      */   }
/*      */   
/*      */   private boolean isInSamePackage(String type)
/*      */   {
/* 1171 */     if (type.charAt(0) == '[') {
/* 1172 */       return false;
/*      */     }
/* 1174 */     return getPackage(visitedClassName).equals(getPackage(type));
/*      */   }
/*      */   
/*      */   private static String getPackage(String className)
/*      */   {
/* 1179 */     int i = className.lastIndexOf('/');
/* 1180 */     return i == -1 ? "" : className.substring(0, i);
/*      */   }
/*      */   
/*      */   private String computeOverrideMethodDesc(String desc, boolean isStatic)
/*      */   {
/* 1189 */     if (isStatic) {
/* 1190 */       return desc;
/*      */     }
/* 1192 */     return instanceToStaticDescPrefix + desc.substring(1);
/*      */   }
/*      */   
/*      */   private String computeOverrideMethodName(String name, String desc)
/*      */   {
/* 1206 */     if ((desc.startsWith(instanceToStaticDescPrefix)) && 
/* 1207 */       (!name.equals("init$args")) && 
/* 1208 */       (!name.equals("init$body"))) {
/* 1209 */       return "static$" + name;
/*      */     }
/* 1211 */     return name;
/*      */   }
/*      */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.IncrementalChangeVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */