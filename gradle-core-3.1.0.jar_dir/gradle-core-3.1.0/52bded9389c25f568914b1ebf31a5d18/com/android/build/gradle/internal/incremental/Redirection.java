/*    */ package com.android.build.gradle.internal.incremental;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.objectweb.asm.Label;
/*    */ import org.objectweb.asm.Type;
/*    */ import org.objectweb.asm.commons.GeneratorAdapter;
/*    */ import org.objectweb.asm.tree.LabelNode;
/*    */ 
/*    */ public abstract class Redirection
/*    */ {
/*    */   private final LabelNode label;
/*    */   protected final List<Type> types;
/*    */   public final Type type;
/*    */   
/*    */   Redirection(LabelNode label, List<Type> types, Type type)
/*    */   {
/* 50 */     this.label = label;
/* 51 */     this.types = types;
/* 52 */     this.type = type;
/*    */   }
/*    */   
/*    */   void redirect(GeneratorAdapter mv, int change)
/*    */   {
/* 72 */     Label l0 = new Label();
/* 73 */     mv.loadLocal(change);
/* 74 */     mv.visitJumpInsn(198, l0);
/*    */     
/* 76 */     doRedirect(mv, change);
/*    */     
/* 79 */     if (type == Type.VOID_TYPE) {
/* 80 */       mv.pop();
/*    */     } else {
/* 82 */       ByteCodeUtils.unbox(mv, type);
/*    */     }
/* 84 */     mv.returnValue();
/*    */     
/* 88 */     mv.visitLabel(l0);
/*    */   }
/*    */   
/*    */   abstract void doRedirect(GeneratorAdapter paramGeneratorAdapter, int paramInt);
/*    */   
/*    */   public LabelNode getPosition() {
/* 94 */     return label;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.Redirection
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */