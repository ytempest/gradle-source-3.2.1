/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import com.android.build.gradle.internal.incremental.ByteCodeUtils;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.ImmutableMap.Builder;
/*     */ import java.util.Deque;
/*     */ import org.objectweb.asm.Type;
/*     */ 
/*     */  enum DependencyFinderVisitor$ReflectionMethod
/*     */ {
/* 603 */   CLASS_FOR_NAME("java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;"), 
/*     */   
/* 613 */   ATOMIC_INTEGER_FIELD_UPDATER("java/util/concurrent/atomic/AtomicIntegerFieldUpdater", "newUpdater", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicIntegerFieldUpdater;"), 
/*     */   
/* 623 */   ATOMIC_LONG_FIELD_UPDATER("java/util/concurrent/atomic/AtomicLongFieldUpdater", "newUpdater", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicLongFieldUpdater;"), 
/*     */   
/* 633 */   ATOMIC_REFERENCE_FIELD_UPDATER("java/util/concurrent/atomic/AtomicReferenceFieldUpdater", "newUpdater", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;");
/*     */   
/*     */   private static final ImmutableMap<DependencyFinderVisitor.Signature, ReflectionMethod> BY_SIGNATURE;
/*     */   
/*     */   private DependencyFinderVisitor.Signature mSignature;
/*     */   
/*     */   static
/*     */   {
/* 664 */     ImmutableMap.Builder<DependencyFinderVisitor.Signature, ReflectionMethod> builder = ImmutableMap.builder();
/* 665 */     for (ReflectionMethod reflectionMethod : values()) {
/* 666 */       builder.put(reflectionMethod.getSignature(), reflectionMethod);
/*     */     }
/* 668 */     BY_SIGNATURE = builder.build();
/*     */   }
/*     */   
/*     */   public static ReflectionMethod findBySignature(DependencyFinderVisitor.Signature signature)
/*     */   {
/* 679 */     return (ReflectionMethod)BY_SIGNATURE.get(signature);
/*     */   }
/*     */   
/*     */   private DependencyFinderVisitor$ReflectionMethod(String owner, String name, String desc)
/*     */   {
/* 685 */     mSignature = new DependencyFinderVisitor.Signature(owner, name, desc);
/*     */   }
/*     */   
/*     */   public DependencyFinderVisitor.Signature getSignature()
/*     */   {
/* 690 */     return mSignature;
/*     */   }
/*     */   
/*     */   private static <T> T primitiveFieldUpdater(ShrinkerGraph<T> graph, Deque<Object> stack, String desc)
/*     */   {
/* 719 */     if (!(stack.peek() instanceof String)) {
/* 720 */       return null;
/*     */     }
/* 722 */     String fieldName = (String)stack.pop();
/*     */     
/* 724 */     if (!(stack.peek() instanceof Type)) {
/* 725 */       return null;
/*     */     }
/* 727 */     Type type = (Type)stack.pop();
/*     */     
/* 729 */     return (T)graph.getMemberReference(type.getInternalName(), fieldName, desc);
/*     */   }
/*     */   
/*     */   public abstract <T> T getMember(ShrinkerGraph<T> paramShrinkerGraph, Deque<Object> paramDeque);
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.DependencyFinderVisitor.ReflectionMethod
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */