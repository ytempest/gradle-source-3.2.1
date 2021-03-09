/*      */ package com.android.build.gradle.tasks;
/*      */ 
/*      */ import com.android.ide.common.resources.usage.ResourceUsageModel;
/*      */ import com.android.ide.common.resources.usage.ResourceUsageModel.Resource;
/*      */ import java.io.File;
/*      */ import java.io.PrintWriter;
/*      */ import org.objectweb.asm.AnnotationVisitor;
/*      */ import org.objectweb.asm.ClassVisitor;
/*      */ import org.objectweb.asm.FieldVisitor;
/*      */ import org.objectweb.asm.MethodVisitor;
/*      */ 
/*      */ class ResourceUsageAnalyzer$UsageVisitor
/*      */   extends ClassVisitor
/*      */ {
/*      */   private final File mJarFile;
/*      */   private final String mCurrentClass;
/*      */   
/*      */   public ResourceUsageAnalyzer$UsageVisitor(ResourceUsageAnalyzer paramResourceUsageAnalyzer, File jarFile, String name)
/*      */   {
/* 1607 */     super(327680);
/* 1608 */     mJarFile = jarFile;
/* 1609 */     mCurrentClass = name;
/*      */   }
/*      */   
/*      */   public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions)
/*      */   {
/* 1615 */     new MethodVisitor(327680)
/*      */     {
/*      */       public void visitLdcInsn(Object cst) {
/* 1618 */         ResourceUsageAnalyzer.UsageVisitor.this.handleCodeConstant(cst, "ldc");
/*      */       }
/*      */       
/*      */       public void visitFieldInsn(int opcode, String owner, String name, String desc)
/*      */       {
/* 1623 */         if (opcode == 178) {
/* 1624 */           ResourceUsageModel.Resource resource = this$0.getResourceFromCode(owner, name);
/* 1625 */           if (resource != null) {
/* 1626 */             ResourceUsageModel.markReachable(resource);
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */       public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf)
/*      */       {
/* 1634 */         super.visitMethodInsn(opcode, owner, name, desc, itf);
/* 1635 */         if ((owner.equals("android/content/res/Resources")) && 
/* 1636 */           (name.equals("getIdentifier")) && 
/* 1637 */           (desc.equals("(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I")))
/*      */         {
/* 1640 */           if ((mCurrentClass.equals(ResourceUsageAnalyzer.access$100(this$0))) || 
/* 1641 */             (mCurrentClass.equals(ResourceUsageAnalyzer.access$300(this$0))))
/*      */           {
/* 1644 */             return;
/*      */           }
/*      */           
/* 1647 */           ResourceUsageAnalyzer.access$402(this$0, true);
/*      */         }
/*      */         
/* 1652 */         if ((owner.equals("android/webkit/WebView")) && (name.startsWith("load"))) {
/* 1653 */           ResourceUsageAnalyzer.access$502(this$0, true);
/*      */         }
/*      */       }
/*      */       
/*      */       public AnnotationVisitor visitAnnotationDefault()
/*      */       {
/* 1659 */         return new ResourceUsageAnalyzer.UsageVisitor.AnnotationUsageVisitor(ResourceUsageAnalyzer.UsageVisitor.this);
/*      */       }
/*      */       
/*      */       public AnnotationVisitor visitAnnotation(String desc, boolean visible)
/*      */       {
/* 1664 */         return new ResourceUsageAnalyzer.UsageVisitor.AnnotationUsageVisitor(ResourceUsageAnalyzer.UsageVisitor.this);
/*      */       }
/*      */       
/*      */       public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible)
/*      */       {
/* 1670 */         return new ResourceUsageAnalyzer.UsageVisitor.AnnotationUsageVisitor(ResourceUsageAnalyzer.UsageVisitor.this);
/*      */       }
/*      */     };
/*      */   }
/*      */   
/*      */   public AnnotationVisitor visitAnnotation(String desc, boolean visible)
/*      */   {
/* 1677 */     return new AnnotationUsageVisitor();
/*      */   }
/*      */   
/*      */   public FieldVisitor visitField(int access, String name, String desc, String signature, Object value)
/*      */   {
/* 1683 */     handleCodeConstant(value, "field");
/* 1684 */     new FieldVisitor(327680)
/*      */     {
/*      */       public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
/* 1687 */         return new ResourceUsageAnalyzer.UsageVisitor.AnnotationUsageVisitor(ResourceUsageAnalyzer.UsageVisitor.this);
/*      */       }
/*      */     };
/*      */   }
/*      */   
/*      */   private class AnnotationUsageVisitor extends AnnotationVisitor {
/*      */     public AnnotationUsageVisitor() {
/* 1694 */       super();
/*      */     }
/*      */     
/*      */     public AnnotationVisitor visitAnnotation(String name, String desc)
/*      */     {
/* 1699 */       return new AnnotationUsageVisitor(ResourceUsageAnalyzer.UsageVisitor.this);
/*      */     }
/*      */     
/*      */     public AnnotationVisitor visitArray(String name)
/*      */     {
/* 1704 */       return new AnnotationUsageVisitor(ResourceUsageAnalyzer.UsageVisitor.this);
/*      */     }
/*      */     
/*      */     public void visit(String name, Object value)
/*      */     {
/* 1709 */       ResourceUsageAnalyzer.UsageVisitor.this.handleCodeConstant(value, "annotation");
/* 1710 */       super.visit(name, value);
/*      */     }
/*      */   }
/*      */   
/*      */   private void handleCodeConstant(Object cst, String context) {
/*      */     ResourceUsageModel.Resource resource;
/* 1716 */     if ((cst instanceof Integer)) {
/* 1717 */       Integer value = (Integer)cst;
/* 1718 */       resource = ResourceUsageAnalyzer.access$600(this$0).getResource(value);
/* 1719 */       if ((ResourceUsageModel.markReachable(resource)) && (ResourceUsageAnalyzer.access$700(this$0))) {
/* 1720 */         assert (ResourceUsageAnalyzer.access$800(this$0) != null) : "mDebug is true, but mDebugPrinter is null.";
/* 1721 */         ResourceUsageAnalyzer.access$800(this$0).println("Marking " + resource + " reachable: referenced from " + context + " in " + mJarFile + ":" + mCurrentClass);
/*      */       }
/*      */     }
/* 1724 */     else if ((cst instanceof int[])) {
/* 1725 */       int[] values = (int[])cst;
/* 1726 */       for (int value : values) {
/* 1727 */         ResourceUsageModel.Resource resource = ResourceUsageAnalyzer.access$600(this$0).getResource(Integer.valueOf(value));
/* 1728 */         if ((ResourceUsageModel.markReachable(resource)) && (ResourceUsageAnalyzer.access$700(this$0))) {
/* 1729 */           assert (ResourceUsageAnalyzer.access$800(this$0) != null) : "mDebug is true, but mDebugPrinter is null.";
/* 1730 */           ResourceUsageAnalyzer.access$800(this$0).println("Marking " + resource + " reachable: referenced from " + context + " in " + mJarFile + ":" + mCurrentClass);
/*      */         }
/*      */       }
/*      */     }
/* 1734 */     else if ((cst instanceof String)) {
/* 1735 */       String string = (String)cst;
/* 1736 */       ResourceUsageAnalyzer.access$900(this$0, string);
/*      */     }
/*      */   }
/*      */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ResourceUsageAnalyzer.UsageVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */