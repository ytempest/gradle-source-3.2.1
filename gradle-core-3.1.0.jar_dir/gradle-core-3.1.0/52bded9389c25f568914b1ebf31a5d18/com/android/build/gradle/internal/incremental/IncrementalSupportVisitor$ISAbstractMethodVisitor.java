/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.objectweb.asm.AnnotationVisitor;
/*     */ import org.objectweb.asm.Label;
/*     */ import org.objectweb.asm.MethodVisitor;
/*     */ import org.objectweb.asm.Type;
/*     */ import org.objectweb.asm.commons.GeneratorAdapter;
/*     */ import org.objectweb.asm.tree.LabelNode;
/*     */ 
/*     */ abstract class IncrementalSupportVisitor$ISAbstractMethodVisitor
/*     */   extends GeneratorAdapter
/*     */ {
/* 286 */   protected boolean disableRedirection = false;
/*     */   protected int change;
/*     */   protected final List<Type> args;
/*     */   protected final List<Redirection> redirections;
/*     */   protected final Map<Label, Redirection> resolvedRedirections;
/*     */   protected final Label start;
/*     */   
/*     */   public IncrementalSupportVisitor$ISAbstractMethodVisitor(MethodVisitor mv, int access, String name, String desc) {
/* 294 */     super(327680, mv, access, name, desc);
/* 295 */     change = -1;
/* 296 */     redirections = new ArrayList();
/* 297 */     resolvedRedirections = new HashMap();
/* 298 */     args = new ArrayList(Arrays.asList(Type.getArgumentTypes(desc)));
/* 299 */     start = new Label();
/* 300 */     boolean isStatic = (access & 0x8) != 0;
/*     */     
/* 303 */     if (!isStatic) {
/* 304 */       args.add(0, Type.getType(Object.class));
/*     */     }
/*     */   }
/*     */   
/*     */   public AnnotationVisitor visitAnnotation(String desc, boolean visible)
/*     */   {
/* 310 */     if (desc.equals(IncrementalVisitor.DISABLE_ANNOTATION_TYPE.getDescriptor())) {
/* 311 */       disableRedirection = true;
/*     */     }
/* 313 */     return super.visitAnnotation(desc, visible);
/*     */   }
/*     */   
/*     */   public void visitCode()
/*     */   {
/* 327 */     if (!disableRedirection)
/*     */     {
/* 330 */       for (Redirection redirection : redirections) {
/* 331 */         resolvedRedirections.put(redirection.getPosition().getLabel(), redirection);
/*     */       }
/*     */       
/* 334 */       super.visitLabel(start);
/* 335 */       change = newLocal(IncrementalVisitor.CHANGE_TYPE);
/* 336 */       visitChangeField();
/* 337 */       storeLocal(change);
/*     */       
/* 339 */       redirectAt(start);
/*     */     }
/* 341 */     super.visitCode();
/*     */   }
/*     */   
/*     */   protected abstract void visitChangeField();
/*     */   
/*     */   public void visitLabel(Label label)
/*     */   {
/* 348 */     super.visitLabel(label);
/* 349 */     redirectAt(label);
/*     */   }
/*     */   
/*     */   protected void redirectAt(Label label) {
/* 353 */     if (disableRedirection) {
/* 354 */       return;
/*     */     }
/* 356 */     Redirection redirection = (Redirection)resolvedRedirections.get(label);
/* 357 */     if (redirection != null)
/*     */     {
/* 359 */       super.visitLineNumber(0, label);
/* 360 */       redirection.redirect(this, change);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addRedirection(Redirection redirection) {
/* 365 */     redirections.add(redirection);
/*     */   }
/*     */   
/*     */   public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index)
/*     */   {
/* 376 */     if ((!disableRedirection) && (index < args.size())) {
/* 377 */       start = this.start;
/*     */     }
/* 379 */     super.visitLocalVariable(name, desc, signature, start, end, index);
/*     */   }
/*     */   
/*     */   public Label getStartLabel() {
/* 383 */     return start;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.IncrementalSupportVisitor.ISAbstractMethodVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */