/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import org.objectweb.asm.AnnotationVisitor;
/*     */ import org.objectweb.asm.Type;
/*     */ 
/*     */ class DependencyFinderVisitor$DependencyFinderAnnotationVisitor
/*     */   extends AnnotationVisitor
/*     */ {
/*     */   private final String mAnnotationName;
/*     */   private final T mSource;
/*     */   
/*     */   DependencyFinderVisitor$DependencyFinderAnnotationVisitor(String arg1, T annotationName, AnnotationVisitor source)
/*     */   {
/* 496 */     super(327680, av);
/* 497 */     mAnnotationName = annotationName;
/* 498 */     mSource = source;
/*     */   }
/*     */   
/*     */   public void visit(String name, Object value)
/*     */   {
/* 503 */     if ((value instanceof Type)) {
/* 504 */       DependencyFinderVisitor.access$400(this$0, mSource, (Type)value);
/*     */     }
/* 506 */     super.visit(name, value);
/*     */   }
/*     */   
/*     */   public void visitEnum(String name, String desc, String value)
/*     */   {
/* 511 */     String internalName = DependencyFinderVisitor.access$100(Type.getType(desc));
/* 512 */     if (internalName != null) {
/* 513 */       this$0.handleDependency(mSource, 
/*     */       
/* 515 */         DependencyFinderVisitor.access$200(this$0).getClassReference(internalName), DependencyType.REQUIRED_CLASS_STRUCTURE);
/*     */       
/* 517 */       this$0.handleDependency(mSource, 
/*     */       
/* 519 */         DependencyFinderVisitor.access$200(this$0).getMemberReference(internalName, value, desc), DependencyType.REQUIRED_CLASS_STRUCTURE);
/*     */     }
/*     */     
/* 523 */     super.visitEnum(name, desc, value);
/*     */   }
/*     */   
/*     */   public AnnotationVisitor visitAnnotation(String name, String desc)
/*     */   {
/* 528 */     String internalName = DependencyFinderVisitor.access$100(Type.getType(desc));
/* 529 */     if (internalName != null) {
/* 530 */       this$0.handleDependency(mSource, 
/*     */       
/* 532 */         DependencyFinderVisitor.access$200(this$0).getClassReference(internalName), DependencyType.REQUIRED_CLASS_STRUCTURE);
/*     */     }
/*     */     
/* 535 */     return new DependencyFinderAnnotationVisitor(this$0, mAnnotationName, mSource, 
/* 536 */       super.visitAnnotation(name, desc));
/*     */   }
/*     */   
/*     */   public AnnotationVisitor visitArray(String name)
/*     */   {
/* 541 */     return new DependencyFinderAnnotationVisitor(this$0, mAnnotationName, mSource, 
/* 542 */       super.visitArray(name));
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.DependencyFinderVisitor.DependencyFinderAnnotationVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */