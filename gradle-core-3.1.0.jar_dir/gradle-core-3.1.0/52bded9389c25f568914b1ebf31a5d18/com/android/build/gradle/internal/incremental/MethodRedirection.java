/*    */ package com.android.build.gradle.internal.incremental;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.objectweb.asm.Type;
/*    */ import org.objectweb.asm.commons.GeneratorAdapter;
/*    */ import org.objectweb.asm.commons.Method;
/*    */ import org.objectweb.asm.tree.LabelNode;
/*    */ 
/*    */ public class MethodRedirection
/*    */   extends Redirection
/*    */ {
/*    */   private final String name;
/*    */   
/*    */   MethodRedirection(LabelNode label, String name, List<Type> types, Type type)
/*    */   {
/* 35 */     super(label, types, type);
/* 36 */     this.name = name;
/*    */   }
/*    */   
/*    */   protected void doRedirect(GeneratorAdapter mv, int change)
/*    */   {
/* 42 */     mv.loadLocal(change);
/* 43 */     mv.push(name);
/* 44 */     ByteCodeUtils.newVariableArray(mv, ByteCodeUtils.toLocalVariables(types));
/*    */     
/* 47 */     mv.invokeInterface(IncrementalVisitor.CHANGE_TYPE, Method.getMethod("Object access$dispatch(String, Object[])"));
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.MethodRedirection
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */