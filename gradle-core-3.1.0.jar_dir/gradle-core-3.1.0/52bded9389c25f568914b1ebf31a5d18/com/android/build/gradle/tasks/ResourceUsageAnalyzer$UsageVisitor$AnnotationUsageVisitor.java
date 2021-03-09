/*      */ package com.android.build.gradle.tasks;
/*      */ 
/*      */ import org.objectweb.asm.AnnotationVisitor;
/*      */ 
/*      */ class ResourceUsageAnalyzer$UsageVisitor$AnnotationUsageVisitor
/*      */   extends AnnotationVisitor
/*      */ {
/*      */   public ResourceUsageAnalyzer$UsageVisitor$AnnotationUsageVisitor(ResourceUsageAnalyzer.UsageVisitor paramUsageVisitor)
/*      */   {
/* 1694 */     super(327680);
/*      */   }
/*      */   
/*      */   public AnnotationVisitor visitAnnotation(String name, String desc)
/*      */   {
/* 1699 */     return new AnnotationUsageVisitor(this$1);
/*      */   }
/*      */   
/*      */   public AnnotationVisitor visitArray(String name)
/*      */   {
/* 1704 */     return new AnnotationUsageVisitor(this$1);
/*      */   }
/*      */   
/*      */   public void visit(String name, Object value)
/*      */   {
/* 1709 */     ResourceUsageAnalyzer.UsageVisitor.access$000(this$1, value, "annotation");
/* 1710 */     super.visit(name, value);
/*      */   }
/*      */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ResourceUsageAnalyzer.UsageVisitor.AnnotationUsageVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */