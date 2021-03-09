/*      */ package com.android.build.gradle.internal.incremental;
/*      */ 
/*      */ import java.io.PrintStream;
/*      */ import org.objectweb.asm.Handle;
/*      */ import org.objectweb.asm.Label;
/*      */ import org.objectweb.asm.MethodVisitor;
/*      */ import org.objectweb.asm.Type;
/*      */ import org.objectweb.asm.commons.GeneratorAdapter;
/*      */ import org.objectweb.asm.commons.Method;
/*      */ import org.objectweb.asm.tree.MethodNode;
/*      */ 
/*      */ public class IncrementalChangeVisitor$ISVisitor
/*      */   extends GeneratorAdapter
/*      */ {
/*      */   private final boolean isStatic;
/*      */   private final boolean isConstructor;
/*      */   
/*      */   public IncrementalChangeVisitor$ISVisitor(IncrementalChangeVisitor this$0, MethodVisitor mv, int access, String name, String desc, boolean isStatic, boolean isConstructor)
/*      */   {
/*  298 */     super(327680, mv, access, name, desc);
/*  299 */     this.isStatic = isStatic;
/*  300 */     this.isConstructor = isConstructor;
/*      */   }
/*      */   
/*      */   public void visitFieldInsn(int opcode, String owner, String name, String desc)
/*      */   {
/*      */     IncrementalVisitor.AccessRight accessRight;
/*      */     
/*      */     IncrementalVisitor.AccessRight accessRight;
/*      */     
/*  310 */     if (!owner.equals(this$0.visitedClassName))
/*      */     {
/*  321 */       accessRight = IncrementalVisitor.AccessRight.PUBLIC;
/*      */     }
/*      */     else {
/*  324 */       accessRight = this$0.getFieldAccessRightByName(name);
/*  325 */       if (accessRight == null)
/*      */       {
/*  328 */         accessRight = IncrementalVisitor.AccessRight.PACKAGE_PRIVATE;
/*      */       }
/*      */     }
/*      */     
/*  332 */     boolean handled = false;
/*  333 */     switch (opcode) {
/*      */     case 178: 
/*      */     case 179: 
/*  336 */       handled = visitStaticFieldAccess(opcode, owner, name, desc, accessRight);
/*  337 */       break;
/*      */     case 180: 
/*      */     case 181: 
/*  340 */       handled = visitFieldAccess(opcode, owner, name, desc, accessRight);
/*  341 */       break;
/*      */     default: 
/*  343 */       System.out.println("Unhandled field opcode " + opcode);
/*      */     }
/*  345 */     if (!handled) {
/*  346 */       super.visitFieldInsn(opcode, owner, name, desc);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean visitFieldAccess(int opcode, String owner, String name, String desc, IncrementalVisitor.AccessRight accessRight)
/*      */   {
/*  388 */     boolean useReflection = accessRight != IncrementalVisitor.AccessRight.PUBLIC;
/*      */     
/*  393 */     if (!useReflection) {
/*  394 */       useReflection = (isConstructor) && (owner.equals(this$0.visitedClassName));
/*      */     }
/*      */     
/*  397 */     if (useReflection)
/*      */     {
/*  400 */       switch (opcode)
/*      */       {
/*      */       case 180: 
/*  406 */         visitLdcInsn(Type.getType("L" + owner + ";"));
/*      */         
/*  410 */         push(name);
/*      */         
/*  415 */         invokeStatic(IncrementalVisitor.RUNTIME_TYPE, 
/*  416 */           Method.getMethod("Object getPrivateField(Object, Class, String)"));
/*      */         
/*  418 */         ByteCodeUtils.unbox(this, Type.getType(desc));
/*  419 */         break;
/*      */       
/*      */       case 181: 
/*  427 */         box(Type.getType(desc));
/*      */         
/*  430 */         visitLdcInsn(Type.getType("L" + owner + ";"));
/*      */         
/*  432 */         push(name);
/*      */         
/*  437 */         invokeStatic(IncrementalVisitor.RUNTIME_TYPE, 
/*  438 */           Method.getMethod("void setPrivateField(Object, Object, Class, String)"));
/*      */         
/*  440 */         break;
/*      */       default: 
/*  442 */         throw new RuntimeException("VisitFieldAccess called with wrong opcode " + opcode);
/*      */       }
/*      */       
/*  445 */       return true;
/*      */     }
/*      */     
/*  449 */     return false;
/*      */   }
/*      */   
/*      */   private boolean visitStaticFieldAccess(int opcode, String owner, String name, String desc, IncrementalVisitor.AccessRight accessRight)
/*      */   {
/*  492 */     if (accessRight != IncrementalVisitor.AccessRight.PUBLIC) {
/*  493 */       switch (opcode)
/*      */       {
/*      */       case 178: 
/*  499 */         visitLdcInsn(Type.getType("L" + owner + ";"));
/*  500 */         push(name);
/*      */         
/*  503 */         invokeStatic(IncrementalVisitor.RUNTIME_TYPE, 
/*  504 */           Method.getMethod("Object getStaticPrivateField(Class, String)"));
/*      */         
/*  506 */         ByteCodeUtils.unbox(this, Type.getType(desc));
/*  507 */         return true;
/*      */       
/*      */       case 179: 
/*  514 */         box(Type.getType(desc));
/*  515 */         visitLdcInsn(Type.getType("L" + owner + ";"));
/*  516 */         push(name);
/*      */         
/*  520 */         invokeStatic(IncrementalVisitor.RUNTIME_TYPE, 
/*  521 */           Method.getMethod("void setStaticPrivateField(Object, Class, String)"));
/*      */         
/*  523 */         return true; }
/*      */       
/*  525 */       throw new RuntimeException("VisitStaticFieldAccess called with wrong opcode " + opcode);
/*      */     }
/*      */     
/*  529 */     return false;
/*      */   }
/*      */   
/*      */   public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf)
/*      */   {
/*  540 */     boolean opcodeHandled = false;
/*  541 */     if (opcode == 183) {
/*  542 */       opcodeHandled = handleSpecialOpcode(owner, name, desc, itf);
/*  543 */     } else if (opcode == 182) {
/*  544 */       opcodeHandled = handleVirtualOpcode(owner, name, desc, itf);
/*  545 */     } else if (opcode == 184) {
/*  546 */       opcodeHandled = handleStaticOpcode(owner, name, desc, itf);
/*      */     }
/*      */     
/*  551 */     if (!opcodeHandled) {
/*  552 */       mv.visitMethodInsn(opcode, owner, name, desc, itf);
/*      */     }
/*      */   }
/*      */   
/*      */   public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs)
/*      */   {
/*  627 */     Object bsmArg = bsmArgs[1];
/*  628 */     if ((bsmArg instanceof Handle)) {
/*  629 */       bsmArgs[1] = rewriteHandleOwner((Handle)bsmArg);
/*      */     }
/*  631 */     super.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
/*      */   }
/*      */   
/*      */   private Handle rewriteHandleOwner(Handle handle)
/*      */   {
/*  643 */     if (handle.getOwner().equals(this$0.visitedClassName))
/*      */     {
/*  647 */       MethodNode lambdaMethod = IncrementalVisitor.getMethodByNameInClass(handle
/*  648 */         .getName(), handle.getDesc(), this$0.classAndInterfaceNode);
/*  649 */       if (lambdaMethod == null)
/*      */       {
/*  651 */         throw new RuntimeException(String.format("Internal instant-run error while locating lambda %sin class %s, please file a bug", new Object[] {handle
/*      */         
/*  654 */           .getName(), this$0.visitedClassName }));
/*      */       }
/*      */       
/*  662 */       String desc = (access & 0x8) == 0 ? "(L" + this$0.visitedClassName + ";" + handle.getDesc().substring(1) : handle.getDesc();
/*      */       
/*  664 */       return new Handle(6, this$0.visitedClassName + "$override", handle
/*      */       
/*  669 */         .getName(), desc, false);
/*      */     }
/*      */     
/*  673 */     return handle;
/*      */   }
/*      */   
/*      */   private boolean handleSpecialOpcode(String owner, String name, String desc, boolean itf)
/*      */   {
/*  688 */     if (name.equals("<init>")) {
/*  689 */       return handleConstructor(owner, name, desc);
/*      */     }
/*  691 */     if (owner.equals(this$0.visitedClassName))
/*      */     {
/*  697 */       String newDesc = IncrementalChangeVisitor.access$000(this$0, desc, false);
/*  698 */       super.visitMethodInsn(184, owner + "$override", name, newDesc, itf);
/*  699 */       return true;
/*      */     }
/*      */     
/*  705 */     int arr = boxParametersToNewLocalArray(Type.getArgumentTypes(desc));
/*  706 */     if (itf) {
/*  707 */       push(owner + "." + name + "." + desc);
/*      */     } else {
/*  709 */       push(name + "." + desc);
/*      */     }
/*  711 */     loadLocal(arr);
/*  712 */     mv.visitMethodInsn(184, this$0.visitedClassName, "access$super", 
/*  713 */       IncrementalChangeVisitor.access$100(this$0) + "Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;", false);
/*      */     
/*  716 */     handleReturnType(desc);
/*      */     
/*  718 */     return true;
/*      */   }
/*      */   
/*      */   private boolean handleVirtualOpcode(String owner, String name, String desc, boolean itf)
/*      */   {
/*  744 */     IncrementalVisitor.AccessRight accessRight = getMethodAccessRight(owner, name, desc);
/*  745 */     if (accessRight == IncrementalVisitor.AccessRight.PUBLIC) {
/*  746 */       return false;
/*      */     }
/*      */     
/*  756 */     pushMethodRedirectArgumentsOnStack(name, desc);
/*      */     
/*  762 */     invokeStatic(IncrementalVisitor.RUNTIME_TYPE, Method.getMethod("Object invokeProtectedMethod(Object, Object[], Class[], String)"));
/*      */     
/*  765 */     handleReturnType(desc);
/*  766 */     return true;
/*      */   }
/*      */   
/*      */   private boolean handleStaticOpcode(String owner, String name, String desc, boolean itf)
/*      */   {
/*  791 */     IncrementalVisitor.AccessRight accessRight = getMethodAccessRight(owner, name, desc);
/*  792 */     if (accessRight == IncrementalVisitor.AccessRight.PUBLIC) {
/*  793 */       return false;
/*      */     }
/*      */     
/*  803 */     pushMethodRedirectArgumentsOnStack(name, desc);
/*      */     
/*  806 */     visitLdcInsn(Type.getType("L" + owner + ";"));
/*      */     
/*  812 */     invokeStatic(IncrementalVisitor.RUNTIME_TYPE, Method.getMethod("Object invokeProtectedStaticMethod(Object[], Class[], String, Class)"));
/*      */     
/*  815 */     handleReturnType(desc);
/*  816 */     return true;
/*      */   }
/*      */   
/*      */   public void visitTypeInsn(int opcode, String s)
/*      */   {
/*  821 */     if (opcode == 187)
/*      */     {
/*  823 */       if (IncrementalChangeVisitor.access$200(this$0) == IncrementalChangeVisitor.MachineState.AFTER_NEW) {
/*  824 */         throw new RuntimeException("Panic, two NEW opcode without a DUP");
/*      */       }
/*      */       
/*  827 */       if (IncrementalChangeVisitor.access$300(this$0, s))
/*      */       {
/*  831 */         IncrementalChangeVisitor.access$202(this$0, IncrementalChangeVisitor.MachineState.AFTER_NEW);
/*      */         
/*  834 */         return;
/*      */       }
/*      */     }
/*  837 */     super.visitTypeInsn(opcode, s);
/*      */   }
/*      */   
/*      */   public void visitInsn(int opcode)
/*      */   {
/*  845 */     if ((opcode == 89) && (IncrementalChangeVisitor.access$200(this$0) == IncrementalChangeVisitor.MachineState.AFTER_NEW))
/*      */     {
/*  847 */       IncrementalChangeVisitor.access$202(this$0, IncrementalChangeVisitor.MachineState.NORMAL);
/*  848 */       return;
/*      */     }
/*  850 */     super.visitInsn(opcode);
/*      */   }
/*      */   
/*      */   private boolean handleConstructor(String owner, String name, String desc)
/*      */   {
/*  871 */     if (IncrementalChangeVisitor.access$300(this$0, owner))
/*      */     {
/*  873 */       Type expectedType = Type.getType("L" + owner + ";");
/*  874 */       pushMethodRedirectArgumentsOnStack(name, desc);
/*      */       
/*  877 */       pop();
/*  878 */       visitLdcInsn(expectedType);
/*      */       
/*  880 */       invokeStatic(IncrementalVisitor.RUNTIME_TYPE, Method.getMethod("Object newForClass(Object[], Class[], Class)"));
/*      */       
/*  883 */       checkCast(expectedType);
/*  884 */       ByteCodeUtils.unbox(this, expectedType);
/*  885 */       return true;
/*      */     }
/*  887 */     return false;
/*      */   }
/*      */   
/*      */   public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index)
/*      */   {
/*  899 */     if ("this".equals(name)) {
/*  900 */       name = "$this";
/*      */     }
/*  902 */     super.visitLocalVariable(name, desc, signature, start, end, index);
/*      */   }
/*      */   
/*      */   public void visitEnd() {}
/*      */   
/*      */   private IncrementalVisitor.AccessRight getMethodAccessRight(String owner, String name, String desc)
/*      */   {
/*  921 */     if (owner.equals(this$0.visitedClassName)) {
/*  922 */       IncrementalVisitor.AccessRight accessRight = this$0.getMethodAccessRightByName(name, desc);
/*  923 */       if (accessRight == null)
/*      */       {
/*  927 */         return IncrementalVisitor.AccessRight.PROTECTED;
/*      */       }
/*  929 */       return accessRight;
/*      */     }
/*      */     
/*  933 */     return IncrementalVisitor.AccessRight.PUBLIC;
/*      */   }
/*      */   
/*      */   private void pushMethodRedirectArgumentsOnStack(String name, String desc)
/*      */   {
/*  959 */     Type[] parameterTypes = Type.getArgumentTypes(desc);
/*      */     
/*  962 */     int parameters = boxParametersToNewLocalArray(parameterTypes);
/*      */     
/*  964 */     loadLocal(parameters);
/*      */     
/*  967 */     pushParameterTypesOnStack(parameterTypes);
/*      */     
/*  969 */     push(name);
/*      */   }
/*      */   
/*      */   private void pushParameterTypesOnStack(Type[] parameterTypes)
/*      */   {
/*  985 */     push(parameterTypes.length);
/*  986 */     newArray(Type.getType(Class.class));
/*      */     
/*  988 */     for (int i = 0; i < parameterTypes.length; i++) {
/*  989 */       dup();
/*  990 */       push(i);
/*  991 */       switch (parameterTypes[i].getSort()) {
/*      */       case 9: 
/*      */       case 10: 
/*  994 */         visitLdcInsn(parameterTypes[i]);
/*  995 */         break;
/*      */       case 1: 
/*      */       case 2: 
/*      */       case 3: 
/*      */       case 4: 
/*      */       case 5: 
/*      */       case 6: 
/*      */       case 7: 
/*      */       case 8: 
/* 1004 */         push(parameterTypes[i]);
/* 1005 */         break;
/*      */       default: 
/* 1007 */         throw new RuntimeException("Unexpected parameter type " + parameterTypes[i]);
/*      */       }
/*      */       
/*      */       
/* 1011 */       arrayStore(Type.getType(Class.class));
/*      */     }
/*      */   }
/*      */   
/*      */   private void handleReturnType(String desc)
/*      */   {
/* 1020 */     Type ret = Type.getReturnType(desc);
/* 1021 */     if (ret.getSort() == 0) {
/* 1022 */       pop();
/*      */     } else {
/* 1024 */       ByteCodeUtils.unbox(this, ret);
/*      */     }
/*      */   }
/*      */   
/*      */   private int boxParametersToNewLocalArray(Type[] parameterTypes) {
/* 1029 */     int parameters = newLocal(Type.getType("[Ljava/lang.Object;"));
/* 1030 */     push(parameterTypes.length);
/* 1031 */     newArray(Type.getType(Object.class));
/* 1032 */     storeLocal(parameters);
/*      */     
/* 1034 */     for (int i = parameterTypes.length - 1; i >= 0; i--) {
/* 1035 */       loadLocal(parameters);
/* 1036 */       swap(parameterTypes[i], Type.getType(Object.class));
/* 1037 */       push(i);
/* 1038 */       swap(parameterTypes[i], Type.INT_TYPE);
/* 1039 */       box(parameterTypes[i]);
/* 1040 */       arrayStore(Type.getType(Object.class));
/*      */     }
/* 1042 */     return parameters;
/*      */   }
/*      */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.IncrementalChangeVisitor.ISVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */