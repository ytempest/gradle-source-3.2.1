/*    */ package com.android.build.gradle.internal.transforms;
/*    */ 
/*    */ import java.lang.management.ManagementFactory;
/*    */ import java.lang.management.RuntimeMXBean;
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.List;
/*    */ import javax.inject.Inject;
/*    */ import org.gradle.api.logging.Logger;
/*    */ 
/*    */ public class DesugarWorkerItem$DesugarAction
/*    */   implements Runnable
/*    */ {
/*    */   private final List<String> args;
/*    */   
/*    */   @Inject
/*    */   public DesugarWorkerItem$DesugarAction(List<String> args)
/*    */   {
/* 80 */     this.args = args;
/*    */   }
/*    */   
/*    */   public void run()
/*    */   {
/*    */     try {
/* 86 */       if (DesugarWorkerItem.access$000().isDebugEnabled()) {
/* 87 */         DesugarWorkerItem.access$000().debug("New desugar in {}", 
/* 88 */           ManagementFactory.getRuntimeMXBean().getName());
/*    */       }
/* 90 */       Class<?> clazz = Class.forName("com.google.devtools.build.android.desugar.Desugar");
/* 91 */       Method mainMethod = clazz.getMethod("main", new Class[] { String[].class });
/* 92 */       mainMethod.setAccessible(true);
/*    */       
/* 94 */       mainMethod.invoke(null, new Object[] { args.toArray(new String[args.size()]) });
/*    */     } catch (Exception e) {
/* 96 */       DesugarWorkerItem.access$000().error("Error while running desugar ", e);
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.DesugarWorkerItem.DesugarAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */