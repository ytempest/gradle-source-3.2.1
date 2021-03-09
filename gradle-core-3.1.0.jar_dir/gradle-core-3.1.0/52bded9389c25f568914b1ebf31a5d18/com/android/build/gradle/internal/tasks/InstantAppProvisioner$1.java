/*    */ package com.android.build.gradle.internal.tasks;
/*    */ 
/*    */ import com.android.instantapp.provision.ProvisionException;
/*    */ import com.android.instantapp.provision.ProvisionListener;
/*    */ import org.gradle.api.logging.Logger;
/*    */ 
/*    */ class InstantAppProvisioner$1
/*    */   implements ProvisionListener
/*    */ {
/*    */   InstantAppProvisioner$1(InstantAppProvisioner this$0) {}
/*    */   
/*    */   public void printMessage(String message)
/*    */   {
/* 60 */     InstantAppProvisioner.access$000(this$0).info(message);
/*    */   }
/*    */   
/*    */   public void logMessage(String message, ProvisionException e)
/*    */   {
/* 66 */     if (e == null) {
/* 67 */       InstantAppProvisioner.access$000(this$0).debug(message);
/*    */     } else {
/* 69 */       InstantAppProvisioner.access$000(this$0).debug(message, e);
/* 70 */       InstantAppProvisioner.access$000(this$0).error(message, e);
/*    */     }
/*    */   }
/*    */   
/*    */   public void setProgress(double fraction) {}
/*    */   
/*    */   public boolean isCancelled()
/*    */   {
/* 79 */     return false;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.InstantAppProvisioner.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */