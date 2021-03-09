/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Deque;
/*     */ import org.objectweb.asm.AnnotationVisitor;
/*     */ import org.objectweb.asm.Handle;
/*     */ import org.objectweb.asm.Label;
/*     */ import org.objectweb.asm.MethodVisitor;
/*     */ import org.objectweb.asm.Type;
/*     */ import org.objectweb.asm.signature.SignatureReader;
/*     */ import org.objectweb.asm.signature.SignatureVisitor;
/*     */ 
/*     */ class DependencyFinderVisitor$DependencyFinderMethodVisitor
/*     */   extends MethodVisitor
/*     */ {
/*     */   private final T mMethod;
/*     */   private final Deque<Object> mLastLdcs;
/*     */   
/*     */   DependencyFinderVisitor$DependencyFinderMethodVisitor(T arg1, String method, MethodVisitor desc)
/*     */   {
/* 240 */     super(327680, mv);
/* 241 */     mMethod = method;
/* 242 */     mLastLdcs = new ArrayDeque();
/* 243 */     visitType(Type.getMethodType(desc));
/*     */   }
/*     */   
/*     */   public AnnotationVisitor visitAnnotation(String desc, boolean visible)
/*     */   {
/* 248 */     if (!visible) {
/* 249 */       return super.visitAnnotation(desc, false);
/*     */     }
/* 251 */     return DependencyFinderVisitor.access$000(this$0, mMethod, desc);
/*     */   }
/*     */   
/*     */   public AnnotationVisitor visitAnnotationDefault()
/*     */   {
/* 257 */     return new DependencyFinderVisitor.DependencyFinderAnnotationVisitor(this$0, null, mMethod, 
/* 258 */       super.visitAnnotationDefault());
/*     */   }
/*     */   
/*     */   public void visitTypeInsn(int opcode, String type)
/*     */   {
/* 263 */     String className = DependencyFinderVisitor.access$100(Type.getObjectType(type));
/* 264 */     if (className != null) {
/* 265 */       T classReference = DependencyFinderVisitor.access$200(this$0).getClassReference(className);
/* 266 */       this$0.handleDependency(mMethod, classReference, DependencyType.REQUIRED_CODE_REFERENCE);
/*     */     }
/*     */     
/* 269 */     mLastLdcs.clear();
/* 270 */     super.visitTypeInsn(opcode, type);
/*     */   }
/*     */   
/*     */   public void visitFieldInsn(int opcode, String owner, String name, String desc)
/*     */   {
/* 275 */     if (!AbstractShrinker.isSdkPackage(owner)) {
/* 276 */       this$0.handleDependency(mMethod, 
/*     */       
/* 278 */         DependencyFinderVisitor.access$200(this$0).getClassReference(owner), DependencyType.REQUIRED_CODE_REFERENCE);
/*     */       
/* 280 */       T target = DependencyFinderVisitor.access$200(this$0).getMemberReference(owner, name, desc);
/* 281 */       this$0.handleUnresolvedReference(new PostProcessingData.UnresolvedReference(mMethod, target, false, DependencyType.REQUIRED_CODE_REFERENCE));
/*     */     }
/*     */     
/* 286 */     mLastLdcs.clear();
/* 287 */     super.visitFieldInsn(opcode, owner, name, desc);
/*     */   }
/*     */   
/*     */   public void visitLdcInsn(Object cst)
/*     */   {
/* 292 */     if ((cst instanceof Type)) {
/* 293 */       Type type = Type.getObjectType(((Type)cst).getInternalName());
/* 294 */       String className = DependencyFinderVisitor.access$100(type);
/* 295 */       if (className != null) {
/* 296 */         T classReference = DependencyFinderVisitor.access$200(this$0).getClassReference(className);
/* 297 */         this$0.handleDependency(mMethod, classReference, DependencyType.REQUIRED_CODE_REFERENCE);
/*     */       }
/*     */     }
/*     */     
/* 302 */     mLastLdcs.push(cst);
/* 303 */     super.visitLdcInsn(cst);
/*     */   }
/*     */   
/*     */   public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf)
/*     */   {
/* 312 */     Type type = Type.getObjectType(owner);
/* 313 */     if ((type.getSort() != 9) && (!AbstractShrinker.isSdkPackage(owner))) {
/* 314 */       this$0.handleDependency(mMethod, 
/*     */       
/* 316 */         DependencyFinderVisitor.access$200(this$0).getClassReference(owner), DependencyType.REQUIRED_CODE_REFERENCE);
/*     */       
/* 319 */       T target = DependencyFinderVisitor.access$200(this$0).getMemberReference(owner, name, desc);
/*     */       
/* 321 */       if ((opcode == 183) && (
/* 322 */         (name.equals("<init>")) || (owner.equals(DependencyFinderVisitor.access$300(this$0)))))
/*     */       {
/* 325 */         this$0.handleDependency(mMethod, target, DependencyType.REQUIRED_CODE_REFERENCE);
/*     */       }
/*     */       else
/*     */       {
/* 329 */         this$0.handleUnresolvedReference(new PostProcessingData.UnresolvedReference(mMethod, target, opcode == 183, DependencyType.REQUIRED_CODE_REFERENCE));
/*     */       }
/*     */     }
/*     */     
/* 339 */     DependencyFinderVisitor.ReflectionMethod reflectionMethod = DependencyFinderVisitor.ReflectionMethod.findBySignature(new DependencyFinderVisitor.Signature(owner, name, desc));
/*     */     
/* 341 */     if (reflectionMethod != null) {
/* 342 */       Deque<Object> stackCopy = new ArrayDeque(mLastLdcs);
/* 343 */       T target = reflectionMethod.getMember(DependencyFinderVisitor.access$200(this$0), stackCopy);
/* 344 */       if (target != null) {
/* 345 */         if (reflectionMethod == DependencyFinderVisitor.ReflectionMethod.CLASS_FOR_NAME)
/*     */         {
/* 347 */           this$0.handleDependency(mMethod, target, DependencyType.REQUIRED_CODE_REFERENCE_REFLECTION);
/*     */         }
/*     */         else
/*     */         {
/* 351 */           this$0.handleUnresolvedReference(new PostProcessingData.UnresolvedReference(mMethod, target, false, DependencyType.REQUIRED_CODE_REFERENCE_REFLECTION));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 361 */     mLastLdcs.clear();
/* 362 */     super.visitMethodInsn(opcode, owner, name, desc, itf);
/*     */   }
/*     */   
/*     */   public void visitMultiANewArrayInsn(String desc, int dims)
/*     */   {
/* 367 */     String className = DependencyFinderVisitor.access$100(Type.getType(desc));
/* 368 */     if (className != null) {
/* 369 */       this$0.handleDependency(mMethod, 
/*     */       
/* 371 */         DependencyFinderVisitor.access$200(this$0).getClassReference(className), DependencyType.REQUIRED_CODE_REFERENCE);
/*     */     }
/*     */     
/* 375 */     mLastLdcs.clear();
/* 376 */     super.visitMultiANewArrayInsn(desc, dims);
/*     */   }
/*     */   
/*     */   public void visitTryCatchBlock(Label start, Label end, Label handler, String type)
/*     */   {
/* 381 */     if ((type != null) && (!AbstractShrinker.isSdkPackage(type))) {
/* 382 */       this$0.handleDependency(mMethod, 
/*     */       
/* 384 */         DependencyFinderVisitor.access$200(this$0).getClassReference(type), DependencyType.REQUIRED_CODE_REFERENCE);
/*     */     }
/*     */     
/* 388 */     mLastLdcs.clear();
/* 389 */     super.visitTryCatchBlock(start, end, handler, type);
/*     */   }
/*     */   
/*     */   public void visitInsn(int opcode)
/*     */   {
/* 394 */     mLastLdcs.clear();
/* 395 */     super.visitInsn(opcode);
/*     */   }
/*     */   
/*     */   public void visitIntInsn(int opcode, int operand)
/*     */   {
/* 400 */     mLastLdcs.clear();
/* 401 */     super.visitIntInsn(opcode, operand);
/*     */   }
/*     */   
/*     */   public void visitVarInsn(int opcode, int var)
/*     */   {
/* 406 */     mLastLdcs.clear();
/* 407 */     super.visitVarInsn(opcode, var);
/*     */   }
/*     */   
/*     */   public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs)
/*     */   {
/* 413 */     visitType(Type.getMethodType(desc));
/* 414 */     visitConstantHandle(bsm);
/*     */     
/* 416 */     for (Object bsmArg : bsmArgs) {
/* 417 */       if ((bsmArg instanceof Type)) {
/* 418 */         visitType((Type)bsmArg);
/* 419 */       } else if ((bsmArg instanceof Handle)) {
/* 420 */         visitConstantHandle((Handle)bsmArg);
/*     */       }
/*     */     }
/*     */     
/* 424 */     mLastLdcs.clear();
/* 425 */     super.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
/*     */   }
/*     */   
/*     */   private void visitType(Type type) {
/* 429 */     if (type.getSort() == 11) {
/* 430 */       visitType(type.getReturnType());
/* 431 */       for (Type argType : type.getArgumentTypes()) {
/* 432 */         visitType(argType);
/*     */       }
/*     */     } else {
/* 435 */       String className = DependencyFinderVisitor.access$100(type);
/* 436 */       if (className != null) {
/* 437 */         this$0.handleDependency(mMethod, 
/*     */         
/* 439 */           DependencyFinderVisitor.access$200(this$0).getClassReference(className), DependencyType.REQUIRED_CODE_REFERENCE);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void visitConstantHandle(Handle bsm)
/*     */   {
/* 447 */     visitType(Type.getMethodType(bsm.getDesc()));
/*     */     
/* 449 */     if (!AbstractShrinker.isSdkPackage(bsm.getOwner()))
/*     */     {
/* 451 */       T targetMethod = DependencyFinderVisitor.access$200(this$0).getMemberReference(bsm.getOwner(), bsm.getName(), bsm.getDesc());
/*     */       
/* 453 */       if (bsm.getTag() == 7)
/*     */       {
/* 455 */         this$0.handleDependency(mMethod, targetMethod, DependencyType.REQUIRED_CODE_REFERENCE);
/*     */       } else {
/* 457 */         this$0.handleUnresolvedReference(new PostProcessingData.UnresolvedReference(mMethod, targetMethod, bsm
/*     */         
/* 461 */           .getTag() == 7, DependencyType.REQUIRED_CODE_REFERENCE));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void visitIincInsn(int var, int increment)
/*     */   {
/* 469 */     mLastLdcs.clear();
/* 470 */     super.visitIincInsn(var, increment);
/*     */   }
/*     */   
/*     */   public void visitJumpInsn(int opcode, Label label)
/*     */   {
/* 475 */     mLastLdcs.clear();
/* 476 */     super.visitJumpInsn(opcode, label);
/*     */   }
/*     */   
/*     */   public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index)
/*     */   {
/* 482 */     if (signature != null) {
/* 483 */       SignatureReader reader = new SignatureReader(signature);
/* 484 */       SignatureVisitor visitor = new DependencyFinderVisitor.DependencyFinderSignatureVisitor(this$0);
/* 485 */       reader.acceptType(visitor);
/*     */     }
/* 487 */     super.visitLocalVariable(name, desc, signature, start, end, index);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.DependencyFinderVisitor.DependencyFinderMethodVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */