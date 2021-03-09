/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import com.google.common.base.Optional;
/*     */ import com.google.common.collect.ImmutableCollection;
/*     */ import com.google.common.collect.ImmutableMultimap;
/*     */ import com.google.common.collect.ImmutableMultimap.Builder;
/*     */ import com.google.common.collect.UnmodifiableIterator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.objectweb.asm.Type;
/*     */ import org.objectweb.asm.commons.Method;
/*     */ import org.objectweb.asm.tree.MethodNode;
/*     */ 
/*     */ public class InstantRunMethodVerifier
/*     */ {
/*     */   public static InstantRunVerifierStatus verifyMethod(MethodNode method)
/*     */   {
/*  42 */     VerifierMethodVisitor mv = new VerifierMethodVisitor(method);
/*  43 */     method.accept(mv);
/*  44 */     return (InstantRunVerifierStatus)incompatibleChange.or(InstantRunVerifierStatus.COMPATIBLE);
/*     */   }
/*     */   
/*     */   public static class VerifierMethodVisitor
/*     */     extends MethodNode
/*     */   {
/*  54 */     Optional<InstantRunVerifierStatus> incompatibleChange = Optional.absent();
/*     */     
/*     */     public VerifierMethodVisitor(MethodNode method) {
/*  57 */       super(access, name, desc, signature, 
/*  58 */         (String[])exceptions.toArray(new String[exceptions.size()]));
/*     */     }
/*     */     
/*     */     public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf)
/*     */     {
/*  65 */       Type receiver = Type.getObjectType(owner);
/*  66 */       UnmodifiableIterator localUnmodifiableIterator; if ((!incompatibleChange.isPresent()) && 
/*  67 */         (opcode == 182) && (InstantRunMethodVerifier.blackListedMethods.containsKey(receiver))) {
/*  68 */         for (localUnmodifiableIterator = InstantRunMethodVerifier.blackListedMethods.get(receiver).iterator(); localUnmodifiableIterator.hasNext();) { Method method = (Method)localUnmodifiableIterator.next();
/*  69 */           if ((method.getName().equals(name)) && (method.getDescriptor().equals(desc))) {
/*  70 */             incompatibleChange = Optional.of(InstantRunVerifierStatus.REFLECTION_USED);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*  76 */       super.visitMethodInsn(opcode, owner, name, desc, itf);
/*     */     }
/*     */   }
/*     */   
/*  87 */   private static final ImmutableMultimap<Type, Method> blackListedMethods = ImmutableMultimap.builder()
/*  88 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("Object get(Object)"))
/*  89 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("boolean getBoolean(Object)"))
/*  90 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("byte getByte(Object)"))
/*  91 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("char getChar(Object)"))
/*  92 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("double getDouble(Object)"))
/*  93 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("float getFloat(Object)"))
/*  94 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("int getInt(Object)"))
/*  95 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("long getLong(Object)"))
/*  96 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("short getShort(Object)"))
/*  97 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("void set(Object, Object)"))
/*  98 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("void setBoolean(Object, boolean)"))
/*  99 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("void setByte(Object, byte)"))
/* 100 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("void setChar(Object, char)"))
/* 101 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("void setDouble(Object, double)"))
/* 102 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("void setFloat(Object, float)"))
/* 103 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("void setInt(Object, int)"))
/* 104 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("void setLong(Object, long)"))
/* 105 */     .put(Type.getObjectType("java/lang/reflect/Field"), Method.getMethod("void setShort(Object, short)"))
/* 106 */     .put(Type.getObjectType("java/lang/reflect/Constructor"), Method.getMethod("Object newInstance(Object[])"))
/* 107 */     .put(Type.getObjectType("java/lang/Class"), Method.getMethod("Object newInstance()"))
/* 108 */     .put(Type.getObjectType("java/lang/reflect/Method"), Method.getMethod("Object invoke(Object, Object[])"))
/* 109 */     .build();
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.InstantRunMethodVerifier
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */