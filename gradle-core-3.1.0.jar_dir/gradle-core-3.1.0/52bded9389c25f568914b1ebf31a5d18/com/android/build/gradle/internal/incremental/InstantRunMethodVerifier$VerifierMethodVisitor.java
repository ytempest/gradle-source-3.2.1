/*    */ package com.android.build.gradle.internal.incremental;
/*    */ 
/*    */ import com.google.common.base.Optional;
/*    */ import com.google.common.collect.ImmutableCollection;
/*    */ import com.google.common.collect.ImmutableMultimap;
/*    */ import com.google.common.collect.UnmodifiableIterator;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.objectweb.asm.Type;
/*    */ import org.objectweb.asm.commons.Method;
/*    */ import org.objectweb.asm.tree.MethodNode;
/*    */ 
/*    */ public class InstantRunMethodVerifier$VerifierMethodVisitor
/*    */   extends MethodNode
/*    */ {
/* 54 */   Optional<InstantRunVerifierStatus> incompatibleChange = Optional.absent();
/*    */   
/*    */   public InstantRunMethodVerifier$VerifierMethodVisitor(MethodNode method) {
/* 57 */     super(327680, access, name, desc, signature, 
/* 58 */       (String[])exceptions.toArray(new String[exceptions.size()]));
/*    */   }
/*    */   
/*    */   public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf)
/*    */   {
/* 65 */     Type receiver = Type.getObjectType(owner);
/* 66 */     UnmodifiableIterator localUnmodifiableIterator; if ((!incompatibleChange.isPresent()) && 
/* 67 */       (opcode == 182) && (InstantRunMethodVerifier.access$000().containsKey(receiver))) {
/* 68 */       for (localUnmodifiableIterator = InstantRunMethodVerifier.access$000().get(receiver).iterator(); localUnmodifiableIterator.hasNext();) { Method method = (Method)localUnmodifiableIterator.next();
/* 69 */         if ((method.getName().equals(name)) && (method.getDescriptor().equals(desc))) {
/* 70 */           incompatibleChange = Optional.of(InstantRunVerifierStatus.REFLECTION_USED);
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 76 */     super.visitMethodInsn(opcode, owner, name, desc, itf);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.InstantRunMethodVerifier.VerifierMethodVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */