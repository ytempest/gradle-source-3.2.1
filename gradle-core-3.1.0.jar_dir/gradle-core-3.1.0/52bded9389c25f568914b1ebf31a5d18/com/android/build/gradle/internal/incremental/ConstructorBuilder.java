/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.objectweb.asm.Type;
/*     */ import org.objectweb.asm.commons.GeneratorAdapter;
/*     */ import org.objectweb.asm.tree.AbstractInsnNode;
/*     */ import org.objectweb.asm.tree.InsnList;
/*     */ import org.objectweb.asm.tree.LabelNode;
/*     */ import org.objectweb.asm.tree.LineNumberNode;
/*     */ import org.objectweb.asm.tree.LocalVariableNode;
/*     */ import org.objectweb.asm.tree.MethodInsnNode;
/*     */ import org.objectweb.asm.tree.MethodNode;
/*     */ import org.objectweb.asm.tree.TryCatchBlockNode;
/*     */ import org.objectweb.asm.tree.VarInsnNode;
/*     */ import org.objectweb.asm.tree.analysis.Analyzer;
/*     */ import org.objectweb.asm.tree.analysis.AnalyzerException;
/*     */ import org.objectweb.asm.tree.analysis.BasicInterpreter;
/*     */ import org.objectweb.asm.tree.analysis.BasicValue;
/*     */ import org.objectweb.asm.tree.analysis.Frame;
/*     */ import org.objectweb.asm.tree.analysis.Value;
/*     */ 
/*     */ public class ConstructorBuilder
/*     */ {
/*     */   public static class LocalValue
/*     */     extends BasicValue
/*     */   {
/*     */     public LocalValue(Type type)
/*     */     {
/*  74 */       super();
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/*  79 */       return "*";
/*     */     }
/*     */   }
/*     */   
/*     */   public static Constructor build(String owner, MethodNode method)
/*     */   {
/* 127 */     BasicInterpreter interpreter = new BasicInterpreter() {
/* 128 */       boolean done = false;
/*     */       
/*     */       public BasicValue newValue(Type type)
/*     */       {
/* 133 */         if (type == null)
/* 134 */           return BasicValue.UNINITIALIZED_VALUE;
/* 135 */         if (type.getSort() == 0) {
/* 136 */           return null;
/*     */         }
/*     */         
/* 140 */         BasicValue ret = done ? super.newValue(type) : new ConstructorBuilder.LocalValue(type);
/* 141 */         done = true;
/* 142 */         return ret;
/*     */       }
/*     */       
/* 146 */     };
/* 147 */     Analyzer analyzer = new Analyzer(interpreter);
/* 148 */     AbstractInsnNode[] instructions = instructions.toArray();
/*     */     try {
/* 150 */       Frame[] frames = analyzer.analyze(owner, method);
/* 151 */       if (frames.length != instructions.length)
/*     */       {
/* 153 */         throw new IllegalStateException("The number of frames is not equals to the number of instructions");
/*     */       }
/*     */       
/* 156 */       int stackAtThis = -1;
/* 157 */       boolean poppedThis = false;
/* 158 */       int firstLocal = 1;
/* 159 */       for (Type type : Type.getArgumentTypes(desc)) {
/* 160 */         firstLocal += type.getSize();
/*     */       }
/*     */       
/* 163 */       Object variables = new LinkedHashSet();
/* 164 */       VarInsnNode lastThis = null;
/* 165 */       int localsAtLastThis = 0;
/*     */       
/* 171 */       int recentLine = -1;
/* 172 */       for (int i = 0; i < instructions.length; i++) {
/* 173 */         AbstractInsnNode insn = instructions[i];
/* 174 */         Frame frame = frames[i];
/* 175 */         if (frame.getStackSize() < stackAtThis) {
/* 176 */           poppedThis = true;
/*     */         }
/* 178 */         if ((insn instanceof MethodInsnNode))
/*     */         {
/* 180 */           MethodInsnNode methodhInsn = (MethodInsnNode)insn;
/* 181 */           Type[] types = Type.getArgumentTypes(desc);
/* 182 */           Value value = frame.getStack(frame.getStackSize() - types.length - 1);
/* 183 */           if (((value instanceof LocalValue)) && (name.equals("<init>"))) {
/* 184 */             if (poppedThis) {
/* 185 */               throw new IllegalStateException("Unexpected constructor structure.");
/*     */             }
/* 187 */             return split(owner, method, lastThis, methodhInsn, recentLine, new ArrayList((Collection)variables), localsAtLastThis);
/*     */           }
/*     */         }
/* 190 */         else if ((insn instanceof VarInsnNode)) {
/* 191 */           VarInsnNode var = (VarInsnNode)insn;
/* 192 */           if (var == 0) {
/* 193 */             lastThis = var;
/* 194 */             localsAtLastThis = ((LinkedHashSet)variables).size();
/* 195 */             stackAtThis = frame.getStackSize();
/* 196 */             poppedThis = false;
/*     */           }
/* 198 */           Type type = ByteCodeUtils.getTypeForStoreOpcode(var.getOpcode());
/* 199 */           if ((type != null) && (var >= firstLocal))
/*     */           {
/* 202 */             ((LinkedHashSet)variables).add(new LocalVariable(type, var));
/*     */           }
/* 204 */         } else if ((insn instanceof LineNumberNode))
/*     */         {
/* 208 */           LineNumberNode lineNumberNode = (LineNumberNode)insn;
/* 209 */           recentLine = line;
/*     */         }
/*     */       }
/* 212 */       throw new IllegalStateException("Unexpected constructor structure.");
/*     */     } catch (AnalyzerException e) {
/* 214 */       throw new IllegalStateException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   private static Constructor split(String owner, MethodNode method, VarInsnNode loadThis, MethodInsnNode delegation, int loadThisLine, List<LocalVariable> variables, int localsAtLoadThis)
/*     */   {
/* 225 */     String[] exceptions = (String[])exceptions.toArray(new String[exceptions.size()]);
/*     */     
/* 228 */     String newDesc = desc.replace(")V", ")Ljava/lang/Object;");
/* 229 */     newDesc = newDesc.replace("(", "([L" + owner + ";");
/*     */     
/* 231 */     Type[] argumentTypes = Type.getArgumentTypes(newDesc);
/*     */     
/* 234 */     List<AbstractInsnNode> fixed = Lists.newLinkedList();
/* 235 */     AbstractInsnNode insn = instructions.getFirst();
/* 236 */     while (insn != loadThis) {
/* 237 */       fixed.add(insn);
/* 238 */       insn = insn.getNext();
/*     */     }
/* 240 */     fixed.add(loadThis);
/*     */     
/* 242 */     MethodNode initArgs = new MethodNode(9, "init$args", newDesc, null, exceptions);
/* 243 */     GeneratorAdapter mv = new GeneratorAdapter(initArgs, access, name, desc);
/* 244 */     int newArgument = mv.newLocal(Type.getType("[Ljava/lang/Object;"));
/*     */     
/* 246 */     mv.loadLocal(newArgument);
/* 247 */     ByteCodeUtils.restoreVariables(mv, variables.subList(0, localsAtLoadThis));
/*     */     
/* 250 */     insn = loadThis.getNext();
/* 251 */     while (insn != delegation) {
/* 252 */       insn.accept(mv);
/* 253 */       insn = insn.getNext();
/*     */     }
/* 255 */     LabelNode labelBefore = new LabelNode();
/* 256 */     labelBefore.accept(mv);
/*     */     
/* 259 */     Type[] returnTypes = Type.getArgumentTypes(desc);
/*     */     
/* 261 */     mv.push(returnTypes.length + 2);
/* 262 */     mv.newArray(Type.getType(Object.class));
/* 263 */     int args = mv.newLocal(Type.getType("[Ljava/lang/Object;"));
/* 264 */     mv.storeLocal(args);
/* 265 */     for (int i = returnTypes.length - 1; i >= 0; i--) {
/* 266 */       Type type = returnTypes[i];
/* 267 */       mv.loadLocal(args);
/* 268 */       mv.swap(type, Type.getType(Object.class));
/* 269 */       mv.push(i + 2);
/* 270 */       mv.swap(type, Type.INT_TYPE);
/* 271 */       mv.box(type);
/* 272 */       mv.arrayStore(Type.getType(Object.class));
/*     */     }
/*     */     
/* 276 */     mv.loadLocal(args);
/* 277 */     mv.push(1);
/* 278 */     mv.push(owner + "." + desc);
/* 279 */     mv.arrayStore(Type.getType(Object.class));
/*     */     
/* 282 */     mv.loadLocal(args);
/* 283 */     mv.push(0);
/* 284 */     mv.push(argumentTypes.length + 1);
/* 285 */     mv.newArray(Type.getType(Object.class));
/* 286 */     ByteCodeUtils.loadVariableArray(mv, ByteCodeUtils.toLocalVariables(Arrays.asList(argumentTypes)), 0);
/*     */     
/* 288 */     mv.dup();
/* 289 */     mv.push(argumentTypes.length);
/* 290 */     ByteCodeUtils.newVariableArray(mv, variables);
/* 291 */     mv.arrayStore(Type.getType(Object.class));
/*     */     
/* 293 */     mv.arrayStore(Type.getType(Object.class));
/*     */     
/* 295 */     mv.loadLocal(args);
/* 296 */     mv.returnValue();
/*     */     
/* 299 */     desc = desc.replace(")", "[Ljava/lang/Object;)");
/*     */     
/* 301 */     newDesc = desc.replace("(", "(L" + owner + ";");
/* 302 */     MethodNode body = new MethodNode(9, "init$body", newDesc, null, exceptions);
/*     */     
/* 304 */     mv = new GeneratorAdapter(body, access, name, desc);
/* 305 */     newArgument = mv.newLocal(Type.getType("[Ljava/lang/Object;"));
/*     */     
/* 307 */     LabelNode labelAfter = new LabelNode();
/* 308 */     labelAfter.accept(body);
/* 309 */     Set<LabelNode> bodyLabels = new HashSet();
/*     */     
/* 311 */     mv.loadLocal(newArgument);
/* 312 */     ByteCodeUtils.restoreVariables(mv, variables);
/*     */     
/* 314 */     insn = delegation.getNext();
/* 315 */     while (insn != null) {
/* 316 */       if ((insn instanceof LabelNode)) {
/* 317 */         bodyLabels.add((LabelNode)insn);
/*     */       }
/* 319 */       insn.accept(mv);
/* 320 */       insn = insn.getNext();
/*     */     }
/*     */     
/* 327 */     for (TryCatchBlockNode tryCatch : tryCatchBlocks) {
/* 328 */       tryCatch.accept(mv);
/*     */     }
/*     */     
/* 332 */     for (LocalVariableNode variable : localVariables) {
/* 333 */       boolean startsInBody = bodyLabels.contains(start);
/* 334 */       boolean endsInBody = bodyLabels.contains(end);
/* 335 */       if ((!startsInBody) && (!endsInBody)) {
/* 336 */         if (index != 0) {
/* 337 */           variable.accept(initArgs);
/*     */         }
/* 339 */       } else if ((startsInBody) && (endsInBody)) {
/* 340 */         variable.accept(body);
/* 341 */       } else if ((!startsInBody) && (endsInBody))
/*     */       {
/* 343 */         if (index != 0) {
/* 344 */           LocalVariableNode var0 = new LocalVariableNode(name, desc, signature, start, labelBefore, index);
/*     */           
/* 347 */           var0.accept(initArgs);
/*     */         }
/* 349 */         LocalVariableNode var1 = new LocalVariableNode(name, desc, signature, labelAfter, end, index);
/*     */         
/* 352 */         var1.accept(body);
/*     */       } else {
/* 354 */         throw new IllegalStateException("Local variable starts after it ends.");
/*     */       }
/*     */     }
/*     */     
/* 358 */     desc = desc.replace(")", "[Ljava/lang/Object;)");
/*     */     
/* 360 */     return new Constructor(owner, fixed, loadThis, loadThisLine, initArgs, delegation, body, variables, localsAtLoadThis);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.ConstructorBuilder
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */