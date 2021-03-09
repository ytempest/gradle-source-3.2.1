/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.objectweb.asm.Type;
/*     */ import org.objectweb.asm.commons.GeneratorAdapter;
/*     */ import org.objectweb.asm.commons.Method;
/*     */ import org.objectweb.asm.tree.LabelNode;
/*     */ import org.objectweb.asm.tree.MethodNode;
/*     */ 
/*     */ public class ConstructorRedirection
/*     */   extends Redirection
/*     */ {
/*  68 */   static final String DISPATCHING_THIS_SIGNATURE = "([Ljava/lang/Object;" + IncrementalVisitor.INSTANT_RELOAD_EXCEPTION
/*     */   
/*  70 */     .getDescriptor() + ")V";
/*     */   
/*     */   private final Constructor constructor;
/*     */   
/*     */   ConstructorRedirection(LabelNode label, Constructor constructor, List<Type> types)
/*     */   {
/*  81 */     super(label, types, Type.VOID_TYPE);
/*  82 */     this.constructor = constructor;
/*     */   }
/*     */   
/*     */   protected void doRedirect(GeneratorAdapter mv, int change)
/*     */   {
/*  87 */     mv.loadLocal(change);
/*  88 */     mv.push("init$args." + constructor.args.desc);
/*     */     
/*  90 */     Type arrayType = Type.getType("[Ljava/lang/Object;");
/*     */     
/*  92 */     mv.push(types.size() + 1);
/*  93 */     mv.newArray(Type.getType(Object.class));
/*     */     
/*  95 */     int array = mv.newLocal(arrayType);
/*  96 */     mv.dup();
/*  97 */     mv.storeLocal(array);
/*     */     
/* 100 */     mv.dup();
/* 101 */     mv.push(0);
/* 102 */     mv.visitInsn(1);
/* 103 */     mv.arrayStore(Type.getType(Object.class));
/*     */     
/* 106 */     ByteCodeUtils.loadVariableArray(mv, ByteCodeUtils.toLocalVariables(types), 1);
/*     */     
/* 109 */     mv.dup();
/*     */     
/* 111 */     mv.push(types.size());
/*     */     
/* 113 */     ByteCodeUtils.newVariableArray(mv, constructor.variables.subList(0, constructor.localsAtLoadThis));
/* 114 */     mv.arrayStore(Type.getType(Object.class));
/*     */     
/* 116 */     mv.invokeInterface(IncrementalVisitor.CHANGE_TYPE, Method.getMethod("Object access$dispatch(String, Object[])"));
/* 117 */     mv.visitTypeInsn(192, "[Ljava/lang/Object;");
/*     */     
/* 125 */     mv.dup();
/* 126 */     mv.push(0);
/* 127 */     mv.arrayLoad(Type.getType("[Ljava/lang/Object;"));
/* 128 */     mv.visitTypeInsn(192, "[Ljava/lang/Object;");
/* 129 */     mv.storeLocal(array);
/*     */     
/* 133 */     mv.visitVarInsn(25, 0);
/* 134 */     mv.swap();
/*     */     
/* 136 */     mv.visitInsn(1);
/*     */     
/* 138 */     mv.visitMethodInsn(183, constructor.owner, "<init>", DISPATCHING_THIS_SIGNATURE, false);
/*     */     
/* 141 */     mv.loadLocal(change);
/* 142 */     mv.push("init$body." + constructor.body.desc);
/* 143 */     mv.loadLocal(array);
/*     */     
/* 146 */     mv.dup();
/* 147 */     mv.push(0);
/* 148 */     mv.visitVarInsn(25, 0);
/* 149 */     mv.arrayStore(Type.getType(Object.class));
/*     */     
/* 151 */     mv.invokeInterface(IncrementalVisitor.CHANGE_TYPE, Method.getMethod("Object access$dispatch(String, Object[])"));
/* 152 */     mv.pop();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.ConstructorRedirection
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */