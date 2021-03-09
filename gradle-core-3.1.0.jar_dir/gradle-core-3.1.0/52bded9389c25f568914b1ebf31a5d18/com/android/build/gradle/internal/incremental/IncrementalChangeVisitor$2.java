/*      */ package com.android.build.gradle.internal.incremental;
/*      */ 
/*      */ import java.util.Map;
/*      */ import org.objectweb.asm.Type;
/*      */ import org.objectweb.asm.commons.GeneratorAdapter;
/*      */ import org.objectweb.asm.tree.MethodNode;
/*      */ 
/*      */ class IncrementalChangeVisitor$2
/*      */   extends StringSwitch
/*      */ {
/*      */   IncrementalChangeVisitor$2(IncrementalChangeVisitor this$0, GeneratorAdapter paramGeneratorAdapter, Map paramMap) {}
/*      */   
/*      */   void visitString()
/*      */   {
/* 1116 */     val$mv.visitVarInsn(25, 1);
/*      */   }
/*      */   
/*      */   void visitCase(String methodName)
/*      */   {
/* 1121 */     MethodNode methodNode = (MethodNode)val$methods.get(methodName);
/* 1122 */     String name = name;
/* 1123 */     boolean isStatic = (access & 0x8) != 0;
/*      */     
/* 1125 */     String newDesc = IncrementalChangeVisitor.access$000(this$0, desc, isStatic);
/*      */     
/* 1127 */     if (IncrementalVisitor.TRACING_ENABLED) {
/* 1128 */       IncrementalVisitor.trace(val$mv, "M: " + name + " P:" + newDesc);
/*      */     }
/* 1130 */     Type[] args = Type.getArgumentTypes(newDesc);
/* 1131 */     int argc = 0;
/* 1132 */     for (Type t : args) {
/* 1133 */       val$mv.visitVarInsn(25, 2);
/* 1134 */       val$mv.push(argc);
/* 1135 */       val$mv.visitInsn(50);
/* 1136 */       ByteCodeUtils.unbox(val$mv, t);
/* 1137 */       argc++;
/*      */     }
/* 1139 */     val$mv.visitMethodInsn(184, this$0.visitedClassName + "$override", isStatic ? 
/* 1140 */       IncrementalChangeVisitor.access$400(this$0, name, desc) : name, newDesc, false);
/*      */     
/* 1142 */     Type ret = Type.getReturnType(desc);
/* 1143 */     if (ret.getSort() == 0) {
/* 1144 */       val$mv.visitInsn(1);
/*      */     } else {
/* 1146 */       val$mv.box(ret);
/*      */     }
/* 1148 */     val$mv.visitInsn(176);
/*      */   }
/*      */   
/*      */   void visitDefault()
/*      */   {
/* 1153 */     writeMissingMessageWithHash(val$mv, this$0.visitedClassName);
/*      */   }
/*      */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.IncrementalChangeVisitor.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */