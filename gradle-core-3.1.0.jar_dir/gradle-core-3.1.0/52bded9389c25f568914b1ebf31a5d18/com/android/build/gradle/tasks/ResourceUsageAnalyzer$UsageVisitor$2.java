/*      */ package com.android.build.gradle.tasks;
/*      */ 
/*      */ import org.objectweb.asm.AnnotationVisitor;
/*      */ import org.objectweb.asm.FieldVisitor;
/*      */ 
/*      */ class ResourceUsageAnalyzer$UsageVisitor$2
/*      */   extends FieldVisitor
/*      */ {
/*      */   ResourceUsageAnalyzer$UsageVisitor$2(ResourceUsageAnalyzer.UsageVisitor this$1, int x0)
/*      */   {
/* 1684 */     super(x0);
/*      */   }
/*      */   
/* 1687 */   public AnnotationVisitor visitAnnotation(String desc, boolean visible) { return new ResourceUsageAnalyzer.UsageVisitor.AnnotationUsageVisitor(this$1); }
/*      */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ResourceUsageAnalyzer.UsageVisitor.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */