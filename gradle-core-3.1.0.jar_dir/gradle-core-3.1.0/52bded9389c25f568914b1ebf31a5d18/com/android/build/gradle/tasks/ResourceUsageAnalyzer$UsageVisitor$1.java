/*      */ package com.android.build.gradle.tasks;
/*      */ 
/*      */ import com.android.ide.common.resources.usage.ResourceUsageModel;
/*      */ import com.android.ide.common.resources.usage.ResourceUsageModel.Resource;
/*      */ import org.objectweb.asm.AnnotationVisitor;
/*      */ import org.objectweb.asm.MethodVisitor;
/*      */ 
/*      */ class ResourceUsageAnalyzer$UsageVisitor$1
/*      */   extends MethodVisitor
/*      */ {
/*      */   ResourceUsageAnalyzer$UsageVisitor$1(ResourceUsageAnalyzer.UsageVisitor this$1, int x0)
/*      */   {
/* 1615 */     super(x0);
/*      */   }
/*      */   
/* 1618 */   public void visitLdcInsn(Object cst) { ResourceUsageAnalyzer.UsageVisitor.access$000(this$1, cst, "ldc"); }
/*      */   
/*      */   public void visitFieldInsn(int opcode, String owner, String name, String desc)
/*      */   {
/* 1623 */     if (opcode == 178) {
/* 1624 */       ResourceUsageModel.Resource resource = this$1.this$0.getResourceFromCode(owner, name);
/* 1625 */       if (resource != null) {
/* 1626 */         ResourceUsageModel.markReachable(resource);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf)
/*      */   {
/* 1634 */     super.visitMethodInsn(opcode, owner, name, desc, itf);
/* 1635 */     if ((owner.equals("android/content/res/Resources")) && 
/* 1636 */       (name.equals("getIdentifier")) && 
/* 1637 */       (desc.equals("(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I")))
/*      */     {
/* 1640 */       if ((ResourceUsageAnalyzer.UsageVisitor.access$200(this$1).equals(ResourceUsageAnalyzer.access$100(this$1.this$0))) || 
/* 1641 */         (ResourceUsageAnalyzer.UsageVisitor.access$200(this$1).equals(ResourceUsageAnalyzer.access$300(this$1.this$0))))
/*      */       {
/* 1644 */         return;
/*      */       }
/*      */       
/* 1647 */       ResourceUsageAnalyzer.access$402(this$1.this$0, true);
/*      */     }
/*      */     
/* 1652 */     if ((owner.equals("android/webkit/WebView")) && (name.startsWith("load"))) {
/* 1653 */       ResourceUsageAnalyzer.access$502(this$1.this$0, true);
/*      */     }
/*      */   }
/*      */   
/*      */   public AnnotationVisitor visitAnnotationDefault()
/*      */   {
/* 1659 */     return new ResourceUsageAnalyzer.UsageVisitor.AnnotationUsageVisitor(this$1);
/*      */   }
/*      */   
/*      */   public AnnotationVisitor visitAnnotation(String desc, boolean visible)
/*      */   {
/* 1664 */     return new ResourceUsageAnalyzer.UsageVisitor.AnnotationUsageVisitor(this$1);
/*      */   }
/*      */   
/*      */   public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible)
/*      */   {
/* 1670 */     return new ResourceUsageAnalyzer.UsageVisitor.AnnotationUsageVisitor(this$1);
/*      */   }
/*      */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ResourceUsageAnalyzer.UsageVisitor.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */