/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import com.android.build.gradle.shrinker.parser.BytecodeVersion;
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.function.Predicate;
/*     */ import org.objectweb.asm.ClassVisitor;
/*     */ import org.objectweb.asm.FieldVisitor;
/*     */ import org.objectweb.asm.Label;
/*     */ import org.objectweb.asm.MethodVisitor;
/*     */ import org.objectweb.asm.commons.Remapper;
/*     */ 
/*     */ public class RewriteOutputVisitor
/*     */   extends ClassVisitor
/*     */ {
/*     */   private final Set<String> mMembers;
/*     */   private final Predicate<String> mClassKeptPredicate;
/*     */   private final Remapper mRemapper;
/*     */   private final BytecodeVersion mBytecodeVersion;
/*     */   
/*     */   public RewriteOutputVisitor(Set<String> members, Predicate<String> classKeptPredicate, BytecodeVersion bytecodeVersion, ClassVisitor cv)
/*     */   {
/*  51 */     super(327680, cv);
/*     */     
/*  55 */     mMembers = members;
/*  56 */     mClassKeptPredicate = classKeptPredicate;
/*  57 */     mBytecodeVersion = bytecodeVersion;
/*  58 */     mRemapper = new ToObjectRemapper(null);
/*     */   }
/*     */   
/*     */   public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
/*     */   {
/*  69 */     List<String> interfacesToKeep = Lists.newArrayList();
/*  70 */     for (String iface : interfaces) {
/*  71 */       if (mClassKeptPredicate.test(iface)) {
/*  72 */         interfacesToKeep.add(iface);
/*     */       }
/*     */     }
/*     */     
/*  77 */     if (mBytecodeVersion != null) {
/*  78 */       version = mBytecodeVersion.getBytes();
/*     */     }
/*     */     
/*  81 */     signature = mRemapper.mapSignature(signature, false);
/*     */     
/*  83 */     super.visit(version, access, name, signature, superName, 
/*     */     
/*  89 */       (String[])Iterables.toArray(interfacesToKeep, String.class));
/*     */   }
/*     */   
/*     */   public FieldVisitor visitField(int access, String name, String desc, String signature, Object value)
/*     */   {
/*  95 */     signature = mRemapper.mapSignature(signature, true);
/*     */     
/*  97 */     if (mMembers.contains(name + ":" + desc)) {
/*  98 */       return super.visitField(access, name, desc, signature, value);
/*     */     }
/* 100 */     return null;
/*     */   }
/*     */   
/*     */   public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
/*     */   {
/* 107 */     signature = mRemapper.mapSignature(signature, false);
/*     */     
/* 109 */     if (!mMembers.contains(name + ":" + desc)) {
/* 110 */       return null;
/*     */     }
/* 112 */     new MethodVisitor(327680, 
/* 113 */       super.visitMethod(access, name, desc, signature, exceptions))
/*     */       {
/*     */         public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index)
/*     */         {
/* 122 */           signature = mRemapper.mapSignature(signature, true);
/* 123 */           super.visitLocalVariable(name, desc, signature, start, end, index);
/*     */         }
/*     */       };
/*     */     }
/*     */     
/*     */     public void visitInnerClass(String name, String outerName, String innerName, int access)
/*     */     {
/* 132 */       if (mClassKeptPredicate.test(name)) {
/* 133 */         super.visitInnerClass(name, outerName, innerName, access);
/*     */       }
/*     */     }
/*     */     
/*     */     private class ToObjectRemapper extends Remapper {
/*     */       private ToObjectRemapper() {}
/*     */       
/*     */       public String map(String type) {
/* 141 */         if (mClassKeptPredicate.test(type)) {
/* 142 */           return type;
/*     */         }
/* 144 */         return "java/lang/Object";
/*     */       }
/*     */     }
/*     */   }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.RewriteOutputVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */