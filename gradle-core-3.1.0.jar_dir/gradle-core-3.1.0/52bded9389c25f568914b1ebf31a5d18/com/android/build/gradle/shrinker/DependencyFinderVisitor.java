/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import com.android.build.gradle.internal.incremental.ByteCodeUtils;
/*     */ import com.google.common.base.Objects;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.ImmutableMap.Builder;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Deque;
/*     */ import org.objectweb.asm.AnnotationVisitor;
/*     */ import org.objectweb.asm.ClassVisitor;
/*     */ import org.objectweb.asm.FieldVisitor;
/*     */ import org.objectweb.asm.Handle;
/*     */ import org.objectweb.asm.Label;
/*     */ import org.objectweb.asm.MethodVisitor;
/*     */ import org.objectweb.asm.Type;
/*     */ import org.objectweb.asm.signature.SignatureReader;
/*     */ import org.objectweb.asm.signature.SignatureVisitor;
/*     */ 
/*     */ abstract class DependencyFinderVisitor<T>
/*     */   extends ClassVisitor
/*     */ {
/*     */   private final ShrinkerGraph<T> mGraph;
/*     */   private String mClassName;
/*     */   private boolean mIsAnnotation;
/*     */   private T mKlass;
/*     */   
/*     */   DependencyFinderVisitor(ShrinkerGraph<T> graph, ClassVisitor cv)
/*     */   {
/*  53 */     super(327680, cv);
/*  54 */     mGraph = graph;
/*     */   }
/*     */   
/*     */   public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
/*     */   {
/*  65 */     if (interfaces == null) {
/*  66 */       interfaces = new String[0];
/*     */     }
/*     */     
/*  69 */     mKlass = mGraph.getClassReference(name);
/*  70 */     if ((superName != null) && (!AbstractShrinker.isSdkPackage(superName)))
/*     */     {
/*  72 */       handleDependency(mKlass, mGraph
/*     */       
/*  74 */         .getClassReference(superName), DependencyType.REQUIRED_CLASS_STRUCTURE);
/*     */     }
/*     */     
/*  78 */     if (interfaces.length > 0) {
/*  79 */       handleInterfaceInheritance(mKlass);
/*     */       
/*  81 */       if (!Objects.equal(superName, "java/lang/Object"))
/*     */       {
/*  84 */         handleMultipleInheritance(mKlass);
/*     */       }
/*     */     }
/*     */     
/*  88 */     mClassName = name;
/*  89 */     mIsAnnotation = ((access & 0x2000) != 0);
/*     */     
/*  91 */     if (signature != null) {
/*  92 */       SignatureReader reader = new SignatureReader(signature);
/*  93 */       SignatureVisitor visitor = new DependencyFinderSignatureVisitor();
/*  94 */       reader.accept(visitor);
/*     */     }
/*     */     
/*  97 */     super.visit(version, access, name, signature, superName, interfaces);
/*     */   }
/*     */   
/*     */   public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
/*     */   {
/* 103 */     T method = mGraph.getMemberReference(mClassName, name, desc);
/*     */     
/* 105 */     if (((access & 0x8) == 0) && (!name.equals("<init>"))) {
/* 106 */       handleVirtualMethod(method);
/*     */     }
/*     */     
/* 111 */     if ((name.equals("<clinit>")) || (
/* 112 */       (name.equals("<init>")) && (desc.equals("()V")))) {
/* 113 */       handleDependency(mKlass, method, DependencyType.REQUIRED_CLASS_STRUCTURE);
/*     */     }
/*     */     
/* 116 */     if (mIsAnnotation)
/*     */     {
/* 118 */       handleDependency(mKlass, method, DependencyType.REQUIRED_CLASS_STRUCTURE);
/*     */     }
/*     */     
/* 121 */     if (signature != null) {
/* 122 */       SignatureReader reader = new SignatureReader(signature);
/* 123 */       SignatureVisitor visitor = new DependencyFinderSignatureVisitor();
/* 124 */       reader.accept(visitor);
/*     */     }
/*     */     
/* 127 */     return new DependencyFinderMethodVisitor(method, desc, 
/* 128 */       super.visitMethod(access, name, desc, signature, exceptions));
/*     */   }
/*     */   
/*     */   public FieldVisitor visitField(int access, String name, String desc, String signature, Object value)
/*     */   {
/* 134 */     T field = mGraph.getMemberReference(mClassName, name, desc);
/* 135 */     Type fieldType = Type.getType(desc);
/* 136 */     handleDeclarationType(field, fieldType);
/*     */     
/* 138 */     if (signature != null) {
/* 139 */       SignatureReader reader = new SignatureReader(signature);
/* 140 */       SignatureVisitor visitor = new DependencyFinderSignatureVisitor();
/* 141 */       reader.acceptType(visitor);
/*     */     }
/*     */     
/* 144 */     return super.visitField(access, name, desc, signature, value);
/*     */   }
/*     */   
/*     */   public AnnotationVisitor visitAnnotation(String desc, boolean visible)
/*     */   {
/* 149 */     if (!visible) {
/* 150 */       return super.visitAnnotation(desc, false);
/*     */     }
/* 152 */     return handleAnnotation(mKlass, desc);
/*     */   }
/*     */   
/*     */   private AnnotationVisitor handleAnnotation(T source, String desc)
/*     */   {
/* 158 */     Type type = Type.getType(desc);
/* 159 */     handleDeclarationType(source, type);
/* 160 */     return new DependencyFinderAnnotationVisitor(type
/* 161 */       .getInternalName(), source, super.visitAnnotation(desc, true));
/*     */   }
/*     */   
/*     */   public void visitInnerClass(String name, String outerName, String innerName, int access)
/*     */   {
/* 166 */     if ((mClassName.equals(name)) && (outerName != null))
/*     */     {
/* 168 */       handleDependency(mKlass, mGraph
/*     */       
/* 170 */         .getClassReference(outerName), DependencyType.REQUIRED_CLASS_STRUCTURE);
/*     */     }
/*     */     
/* 173 */     super.visitInnerClass(name, outerName, innerName, access);
/*     */   }
/*     */   
/*     */   private void handleDeclarationType(T member, Type type) {
/* 177 */     String className = getTargetClassName(type);
/* 178 */     if (className != null) {
/* 179 */       T classReference = mGraph.getClassReference(className);
/* 180 */       handleDependency(member, classReference, DependencyType.REQUIRED_CLASS_STRUCTURE);
/*     */     }
/*     */   }
/*     */   
/*     */   private static String getTargetClassName(Type type)
/*     */   {
/* 194 */     switch (type.getSort()) {
/*     */     case 0: 
/*     */     case 1: 
/*     */     case 2: 
/*     */     case 3: 
/*     */     case 4: 
/*     */     case 5: 
/*     */     case 6: 
/*     */     case 7: 
/*     */     case 8: 
/* 204 */       return null;
/*     */     case 9: 
/* 206 */       return getTargetClassName(type.getElementType());
/*     */     case 10: 
/* 208 */       String name = type.getInternalName();
/* 209 */       return AbstractShrinker.isSdkPackage(name) ? null : name;
/*     */     case 11: 
/* 211 */       throw new IllegalArgumentException("Can't extract one class from a METHOD Type.");
/*     */     }
/* 213 */     throw new AssertionError("Unknown Type sort " + type.getSort());
/*     */   }
/*     */   
/*     */   protected abstract void handleDependency(T paramT1, T paramT2, DependencyType paramDependencyType);
/*     */   
/*     */   protected abstract void handleMultipleInheritance(T paramT);
/*     */   
/*     */   protected abstract void handleVirtualMethod(T paramT);
/*     */   
/*     */   protected abstract void handleInterfaceInheritance(T paramT);
/*     */   
/*     */   protected abstract void handleUnresolvedReference(PostProcessingData.UnresolvedReference<T> paramUnresolvedReference);
/*     */   
/*     */   private class DependencyFinderMethodVisitor
/*     */     extends MethodVisitor
/*     */   {
/*     */     private final T mMethod;
/*     */     private final Deque<Object> mLastLdcs;
/*     */     
/*     */     DependencyFinderMethodVisitor(String method, MethodVisitor desc)
/*     */     {
/* 240 */       super(mv);
/* 241 */       mMethod = method;
/* 242 */       mLastLdcs = new ArrayDeque();
/* 243 */       visitType(Type.getMethodType(desc));
/*     */     }
/*     */     
/*     */     public AnnotationVisitor visitAnnotation(String desc, boolean visible)
/*     */     {
/* 248 */       if (!visible) {
/* 249 */         return super.visitAnnotation(desc, false);
/*     */       }
/* 251 */       return DependencyFinderVisitor.this.handleAnnotation(mMethod, desc);
/*     */     }
/*     */     
/*     */     public AnnotationVisitor visitAnnotationDefault()
/*     */     {
/* 257 */       return new DependencyFinderVisitor.DependencyFinderAnnotationVisitor(DependencyFinderVisitor.this, null, mMethod, 
/* 258 */         super.visitAnnotationDefault());
/*     */     }
/*     */     
/*     */     public void visitTypeInsn(int opcode, String type)
/*     */     {
/* 263 */       String className = DependencyFinderVisitor.getTargetClassName(Type.getObjectType(type));
/* 264 */       if (className != null) {
/* 265 */         T classReference = mGraph.getClassReference(className);
/* 266 */         handleDependency(mMethod, classReference, DependencyType.REQUIRED_CODE_REFERENCE);
/*     */       }
/*     */       
/* 269 */       mLastLdcs.clear();
/* 270 */       super.visitTypeInsn(opcode, type);
/*     */     }
/*     */     
/*     */     public void visitFieldInsn(int opcode, String owner, String name, String desc)
/*     */     {
/* 275 */       if (!AbstractShrinker.isSdkPackage(owner)) {
/* 276 */         handleDependency(mMethod, 
/*     */         
/* 278 */           mGraph.getClassReference(owner), DependencyType.REQUIRED_CODE_REFERENCE);
/*     */         
/* 280 */         T target = mGraph.getMemberReference(owner, name, desc);
/* 281 */         handleUnresolvedReference(new PostProcessingData.UnresolvedReference(mMethod, target, false, DependencyType.REQUIRED_CODE_REFERENCE));
/*     */       }
/*     */       
/* 286 */       mLastLdcs.clear();
/* 287 */       super.visitFieldInsn(opcode, owner, name, desc);
/*     */     }
/*     */     
/*     */     public void visitLdcInsn(Object cst)
/*     */     {
/* 292 */       if ((cst instanceof Type)) {
/* 293 */         Type type = Type.getObjectType(((Type)cst).getInternalName());
/* 294 */         String className = DependencyFinderVisitor.getTargetClassName(type);
/* 295 */         if (className != null) {
/* 296 */           T classReference = mGraph.getClassReference(className);
/* 297 */           handleDependency(mMethod, classReference, DependencyType.REQUIRED_CODE_REFERENCE);
/*     */         }
/*     */       }
/*     */       
/* 302 */       mLastLdcs.push(cst);
/* 303 */       super.visitLdcInsn(cst);
/*     */     }
/*     */     
/*     */     public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf)
/*     */     {
/* 312 */       Type type = Type.getObjectType(owner);
/* 313 */       if ((type.getSort() != 9) && (!AbstractShrinker.isSdkPackage(owner))) {
/* 314 */         handleDependency(mMethod, 
/*     */         
/* 316 */           mGraph.getClassReference(owner), DependencyType.REQUIRED_CODE_REFERENCE);
/*     */         
/* 319 */         T target = mGraph.getMemberReference(owner, name, desc);
/*     */         
/* 321 */         if ((opcode == 183) && (
/* 322 */           (name.equals("<init>")) || (owner.equals(mClassName))))
/*     */         {
/* 325 */           handleDependency(mMethod, target, DependencyType.REQUIRED_CODE_REFERENCE);
/*     */         }
/*     */         else
/*     */         {
/* 329 */           handleUnresolvedReference(new PostProcessingData.UnresolvedReference(mMethod, target, opcode == 183, DependencyType.REQUIRED_CODE_REFERENCE));
/*     */         }
/*     */       }
/*     */       
/* 339 */       DependencyFinderVisitor.ReflectionMethod reflectionMethod = DependencyFinderVisitor.ReflectionMethod.findBySignature(new DependencyFinderVisitor.Signature(owner, name, desc));
/*     */       
/* 341 */       if (reflectionMethod != null) {
/* 342 */         Deque<Object> stackCopy = new ArrayDeque(mLastLdcs);
/* 343 */         T target = reflectionMethod.getMember(mGraph, stackCopy);
/* 344 */         if (target != null) {
/* 345 */           if (reflectionMethod == DependencyFinderVisitor.ReflectionMethod.CLASS_FOR_NAME)
/*     */           {
/* 347 */             handleDependency(mMethod, target, DependencyType.REQUIRED_CODE_REFERENCE_REFLECTION);
/*     */           }
/*     */           else
/*     */           {
/* 351 */             handleUnresolvedReference(new PostProcessingData.UnresolvedReference(mMethod, target, false, DependencyType.REQUIRED_CODE_REFERENCE_REFLECTION));
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 361 */       mLastLdcs.clear();
/* 362 */       super.visitMethodInsn(opcode, owner, name, desc, itf);
/*     */     }
/*     */     
/*     */     public void visitMultiANewArrayInsn(String desc, int dims)
/*     */     {
/* 367 */       String className = DependencyFinderVisitor.getTargetClassName(Type.getType(desc));
/* 368 */       if (className != null) {
/* 369 */         handleDependency(mMethod, 
/*     */         
/* 371 */           mGraph.getClassReference(className), DependencyType.REQUIRED_CODE_REFERENCE);
/*     */       }
/*     */       
/* 375 */       mLastLdcs.clear();
/* 376 */       super.visitMultiANewArrayInsn(desc, dims);
/*     */     }
/*     */     
/*     */     public void visitTryCatchBlock(Label start, Label end, Label handler, String type)
/*     */     {
/* 381 */       if ((type != null) && (!AbstractShrinker.isSdkPackage(type))) {
/* 382 */         handleDependency(mMethod, 
/*     */         
/* 384 */           mGraph.getClassReference(type), DependencyType.REQUIRED_CODE_REFERENCE);
/*     */       }
/*     */       
/* 388 */       mLastLdcs.clear();
/* 389 */       super.visitTryCatchBlock(start, end, handler, type);
/*     */     }
/*     */     
/*     */     public void visitInsn(int opcode)
/*     */     {
/* 394 */       mLastLdcs.clear();
/* 395 */       super.visitInsn(opcode);
/*     */     }
/*     */     
/*     */     public void visitIntInsn(int opcode, int operand)
/*     */     {
/* 400 */       mLastLdcs.clear();
/* 401 */       super.visitIntInsn(opcode, operand);
/*     */     }
/*     */     
/*     */     public void visitVarInsn(int opcode, int var)
/*     */     {
/* 406 */       mLastLdcs.clear();
/* 407 */       super.visitVarInsn(opcode, var);
/*     */     }
/*     */     
/*     */     public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs)
/*     */     {
/* 413 */       visitType(Type.getMethodType(desc));
/* 414 */       visitConstantHandle(bsm);
/*     */       
/* 416 */       for (Object bsmArg : bsmArgs) {
/* 417 */         if ((bsmArg instanceof Type)) {
/* 418 */           visitType((Type)bsmArg);
/* 419 */         } else if ((bsmArg instanceof Handle)) {
/* 420 */           visitConstantHandle((Handle)bsmArg);
/*     */         }
/*     */       }
/*     */       
/* 424 */       mLastLdcs.clear();
/* 425 */       super.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
/*     */     }
/*     */     
/*     */     private void visitType(Type type) {
/* 429 */       if (type.getSort() == 11) {
/* 430 */         visitType(type.getReturnType());
/* 431 */         for (Type argType : type.getArgumentTypes()) {
/* 432 */           visitType(argType);
/*     */         }
/*     */       } else {
/* 435 */         String className = DependencyFinderVisitor.getTargetClassName(type);
/* 436 */         if (className != null) {
/* 437 */           handleDependency(mMethod, 
/*     */           
/* 439 */             mGraph.getClassReference(className), DependencyType.REQUIRED_CODE_REFERENCE);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     private void visitConstantHandle(Handle bsm)
/*     */     {
/* 447 */       visitType(Type.getMethodType(bsm.getDesc()));
/*     */       
/* 449 */       if (!AbstractShrinker.isSdkPackage(bsm.getOwner()))
/*     */       {
/* 451 */         T targetMethod = mGraph.getMemberReference(bsm.getOwner(), bsm.getName(), bsm.getDesc());
/*     */         
/* 453 */         if (bsm.getTag() == 7)
/*     */         {
/* 455 */           handleDependency(mMethod, targetMethod, DependencyType.REQUIRED_CODE_REFERENCE);
/*     */         } else {
/* 457 */           handleUnresolvedReference(new PostProcessingData.UnresolvedReference(mMethod, targetMethod, bsm
/*     */           
/* 461 */             .getTag() == 7, DependencyType.REQUIRED_CODE_REFERENCE));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public void visitIincInsn(int var, int increment)
/*     */     {
/* 469 */       mLastLdcs.clear();
/* 470 */       super.visitIincInsn(var, increment);
/*     */     }
/*     */     
/*     */     public void visitJumpInsn(int opcode, Label label)
/*     */     {
/* 475 */       mLastLdcs.clear();
/* 476 */       super.visitJumpInsn(opcode, label);
/*     */     }
/*     */     
/*     */     public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index)
/*     */     {
/* 482 */       if (signature != null) {
/* 483 */         SignatureReader reader = new SignatureReader(signature);
/* 484 */         SignatureVisitor visitor = new DependencyFinderVisitor.DependencyFinderSignatureVisitor(DependencyFinderVisitor.this);
/* 485 */         reader.acceptType(visitor);
/*     */       }
/* 487 */       super.visitLocalVariable(name, desc, signature, start, end, index);
/*     */     }
/*     */   }
/*     */   
/*     */   private class DependencyFinderAnnotationVisitor extends AnnotationVisitor {
/*     */     private final String mAnnotationName;
/*     */     private final T mSource;
/*     */     
/*     */     DependencyFinderAnnotationVisitor(T annotationName, AnnotationVisitor source) {
/* 496 */       super(av);
/* 497 */       mAnnotationName = annotationName;
/* 498 */       mSource = source;
/*     */     }
/*     */     
/*     */     public void visit(String name, Object value)
/*     */     {
/* 503 */       if ((value instanceof Type)) {
/* 504 */         DependencyFinderVisitor.this.handleDeclarationType(mSource, (Type)value);
/*     */       }
/* 506 */       super.visit(name, value);
/*     */     }
/*     */     
/*     */     public void visitEnum(String name, String desc, String value)
/*     */     {
/* 511 */       String internalName = DependencyFinderVisitor.getTargetClassName(Type.getType(desc));
/* 512 */       if (internalName != null) {
/* 513 */         handleDependency(mSource, 
/*     */         
/* 515 */           mGraph.getClassReference(internalName), DependencyType.REQUIRED_CLASS_STRUCTURE);
/*     */         
/* 517 */         handleDependency(mSource, 
/*     */         
/* 519 */           mGraph.getMemberReference(internalName, value, desc), DependencyType.REQUIRED_CLASS_STRUCTURE);
/*     */       }
/*     */       
/* 523 */       super.visitEnum(name, desc, value);
/*     */     }
/*     */     
/*     */     public AnnotationVisitor visitAnnotation(String name, String desc)
/*     */     {
/* 528 */       String internalName = DependencyFinderVisitor.getTargetClassName(Type.getType(desc));
/* 529 */       if (internalName != null) {
/* 530 */         handleDependency(mSource, 
/*     */         
/* 532 */           mGraph.getClassReference(internalName), DependencyType.REQUIRED_CLASS_STRUCTURE);
/*     */       }
/*     */       
/* 535 */       return new DependencyFinderAnnotationVisitor(DependencyFinderVisitor.this, mAnnotationName, mSource, 
/* 536 */         super.visitAnnotation(name, desc));
/*     */     }
/*     */     
/*     */     public AnnotationVisitor visitArray(String name)
/*     */     {
/* 541 */       return new DependencyFinderAnnotationVisitor(DependencyFinderVisitor.this, mAnnotationName, mSource, 
/* 542 */         super.visitArray(name));
/*     */     }
/*     */   }
/*     */   
/*     */   private class DependencyFinderSignatureVisitor extends SignatureVisitor
/*     */   {
/*     */     DependencyFinderSignatureVisitor() {
/* 549 */       super();
/*     */     }
/*     */     
/*     */     public void visitClassType(String name)
/*     */     {
/* 554 */       if (!AbstractShrinker.isSdkPackage(name)) {
/* 555 */         mGraph.addTypeFromGenericSignature(mKlass, mGraph.getClassReference(name));
/*     */       }
/* 557 */       super.visitClassType(name);
/*     */     }
/*     */     
/*     */     public void visitInnerClassType(String name)
/*     */     {
/* 562 */       if (!AbstractShrinker.isSdkPackage(name)) {
/* 563 */         mGraph.addTypeFromGenericSignature(mKlass, mGraph.getClassReference(name));
/*     */       }
/* 565 */       super.visitInnerClassType(name);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Signature
/*     */   {
/*     */     private final String owner;
/*     */     private final String name;
/*     */     private final String desc;
/*     */     
/*     */     Signature(String owner, String name, String desc) {
/* 576 */       this.owner = owner;
/* 577 */       this.name = name;
/* 578 */       this.desc = desc;
/*     */     }
/*     */     
/*     */     public boolean equals(Object o)
/*     */     {
/* 583 */       if (this == o) {
/* 584 */         return true;
/*     */       }
/* 586 */       if ((o == null) || (getClass() != o.getClass())) {
/* 587 */         return false;
/*     */       }
/* 589 */       Signature method = (Signature)o;
/* 590 */       return (Objects.equal(owner, owner)) && 
/* 591 */         (Objects.equal(name, name)) && 
/* 592 */         (Objects.equal(desc, desc));
/*     */     }
/*     */     
/*     */     public int hashCode()
/*     */     {
/* 597 */       return Objects.hashCode(new Object[] { owner, name, desc });
/*     */     }
/*     */   }
/*     */   
/*     */   private static abstract enum ReflectionMethod
/*     */   {
/* 603 */     CLASS_FOR_NAME("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;"), 
/*     */     
/* 613 */     ATOMIC_INTEGER_FIELD_UPDATER("java/util/concurrent/atomic/AtomicIntegerFieldUpdater", "newUpdater", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;"), 
/*     */     
/* 623 */     ATOMIC_LONG_FIELD_UPDATER("java/util/concurrent/atomic/AtomicLongFieldUpdater", "newUpdater", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicLongFieldUpdater;"), 
/*     */     
/* 633 */     ATOMIC_REFERENCE_FIELD_UPDATER("java/util/concurrent/atomic/AtomicReferenceFieldUpdater", "newUpdater", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;");
/*     */     
/*     */     private static final ImmutableMap<DependencyFinderVisitor.Signature, ReflectionMethod> BY_SIGNATURE;
/*     */     
/*     */     private DependencyFinderVisitor.Signature mSignature;
/*     */     
/*     */     static
/*     */     {
/* 664 */       ImmutableMap.Builder<DependencyFinderVisitor.Signature, ReflectionMethod> builder = ImmutableMap.builder();
/* 665 */       for (ReflectionMethod reflectionMethod : values()) {
/* 666 */         builder.put(reflectionMethod.getSignature(), reflectionMethod);
/*     */       }
/* 668 */       BY_SIGNATURE = builder.build();
/*     */     }
/*     */     
/*     */     public static ReflectionMethod findBySignature(DependencyFinderVisitor.Signature signature)
/*     */     {
/* 679 */       return (ReflectionMethod)BY_SIGNATURE.get(signature);
/*     */     }
/*     */     
/*     */     private ReflectionMethod(String owner, String name, String desc)
/*     */     {
/* 685 */       mSignature = new DependencyFinderVisitor.Signature(owner, name, desc);
/*     */     }
/*     */     
/*     */     public DependencyFinderVisitor.Signature getSignature()
/*     */     {
/* 690 */       return mSignature;
/*     */     }
/*     */     
/*     */     private static <T> T primitiveFieldUpdater(ShrinkerGraph<T> graph, Deque<Object> stack, String desc)
/*     */     {
/* 719 */       if (!(stack.peek() instanceof String)) {
/* 720 */         return null;
/*     */       }
/* 722 */       String fieldName = (String)stack.pop();
/*     */       
/* 724 */       if (!(stack.peek() instanceof Type)) {
/* 725 */         return null;
/*     */       }
/* 727 */       Type type = (Type)stack.pop();
/*     */       
/* 729 */       return (T)graph.getMemberReference(type.getInternalName(), fieldName, desc);
/*     */     }
/*     */     
/*     */     public abstract <T> T getMember(ShrinkerGraph<T> paramShrinkerGraph, Deque<Object> paramDeque);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.DependencyFinderVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */