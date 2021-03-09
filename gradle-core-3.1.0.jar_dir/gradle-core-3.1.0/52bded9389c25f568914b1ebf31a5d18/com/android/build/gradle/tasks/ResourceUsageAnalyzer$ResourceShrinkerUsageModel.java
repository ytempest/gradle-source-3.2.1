/*      */ package com.android.build.gradle.tasks;
/*      */ 
/*      */ import com.android.ide.common.resources.usage.ResourceUsageModel;
/*      */ import com.android.ide.common.resources.usage.ResourceUsageModel.Resource;
/*      */ import com.android.resources.ResourceType;
/*      */ import com.google.common.base.Joiner;
/*      */ import java.io.File;
/*      */ import java.io.PrintWriter;
/*      */ import java.util.List;
/*      */ import org.w3c.dom.Node;
/*      */ 
/*      */ class ResourceUsageAnalyzer$ResourceShrinkerUsageModel
/*      */   extends ResourceUsageModel
/*      */ {
/*      */   public File file;
/*      */   
/*      */   private ResourceUsageAnalyzer$ResourceShrinkerUsageModel(ResourceUsageAnalyzer paramResourceUsageAnalyzer) {}
/*      */   
/*      */   protected boolean ignoreToolsAttributes()
/*      */   {
/* 1757 */     return true;
/*      */   }
/*      */   
/*      */   protected List<ResourceUsageModel.Resource> findRoots(List<ResourceUsageModel.Resource> resources)
/*      */   {
/* 1763 */     List<ResourceUsageModel.Resource> roots = super.findRoots(resources);
/* 1764 */     if (ResourceUsageAnalyzer.access$800(this$0) != null) {
/* 1765 */       ResourceUsageAnalyzer.access$800(this$0).println("\nThe root reachable resources are:\n" + 
/* 1766 */         Joiner.on(",\n   ").join(roots));
/*      */     }
/*      */     
/* 1769 */     return roots;
/*      */   }
/*      */   
/*      */   protected ResourceUsageModel.Resource declareResource(ResourceType type, String name, Node node)
/*      */   {
/* 1774 */     ResourceUsageModel.Resource resource = super.declareResource(type, name, node);
/* 1775 */     resource.addLocation(file);
/* 1776 */     return resource;
/*      */   }
/*      */   
/*      */   protected void referencedString(String string)
/*      */   {
/* 1781 */     ResourceUsageAnalyzer.access$900(this$0, string);
/* 1782 */     ResourceUsageAnalyzer.access$502(this$0, true);
/*      */   }
/*      */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.ResourceUsageAnalyzer.ResourceShrinkerUsageModel
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */