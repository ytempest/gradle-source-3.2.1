/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.builder.testing.ConnectedDevice;
/*     */ import com.android.builder.testing.api.DeviceConnector;
/*     */ import com.android.builder.testing.api.DeviceException;
/*     */ import com.android.builder.testing.api.DeviceProvider;
/*     */ import com.android.ddmlib.IDevice;
/*     */ import com.android.instantapp.provision.ProvisionException;
/*     */ import com.android.instantapp.provision.ProvisionListener;
/*     */ import com.android.instantapp.provision.ProvisionRunner;
/*     */ import com.google.common.annotations.VisibleForTesting;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import org.gradle.api.logging.Logger;
/*     */ 
/*     */ public class InstantAppProvisioner
/*     */ {
/*     */   private final File instantAppSdk;
/*     */   private final DeviceProvider deviceProvider;
/*     */   private final Logger logger;
/*     */   private ProvisionRunner fakeProvisionRunner;
/*     */   
/*     */   InstantAppProvisioner(File instantAppSdk, DeviceProvider deviceProvider, Logger logger)
/*     */   {
/*  50 */     this.instantAppSdk = instantAppSdk;
/*  51 */     this.deviceProvider = deviceProvider;
/*  52 */     this.logger = logger;
/*     */   }
/*     */   
/*     */   void provisionDevices() throws ProvisionException, DeviceException {
/*  56 */     ProvisionListener listener = new ProvisionListener()
/*     */     {
/*     */       public void printMessage(String message)
/*     */       {
/*  60 */         logger.info(message);
/*     */       }
/*     */       
/*     */       public void logMessage(String message, ProvisionException e)
/*     */       {
/*  66 */         if (e == null) {
/*  67 */           logger.debug(message);
/*     */         } else {
/*  69 */           logger.debug(message, e);
/*  70 */           logger.error(message, e);
/*     */         }
/*     */       }
/*     */       
/*     */       public void setProgress(double fraction) {}
/*     */       
/*     */       public boolean isCancelled()
/*     */       {
/*  79 */         return false;
/*     */       }
/*     */       
/*  82 */     };
/*  83 */     ProvisionRunner provisionRunner = fakeProvisionRunner == null ? new ProvisionRunner(instantAppSdk, listener) : fakeProvisionRunner;
/*     */     
/*  88 */     deviceProvider.init();
/*     */     
/*  90 */     List<? extends DeviceConnector> devices = deviceProvider.getDevices();
/*  91 */     List<IDevice> iDevices = Lists.newArrayList();
/*  92 */     for (DeviceConnector device : devices) {
/*  93 */       if ((device instanceof ConnectedDevice)) {
/*  94 */         iDevices.add(((ConnectedDevice)device).getIDevice());
/*     */       }
/*     */     }
/*     */     
/*  98 */     for (IDevice device : iDevices) {
/*  99 */       provisionRunner.runProvision(device);
/*     */     }
/*     */   }
/*     */   
/*     */   @VisibleForTesting
/*     */   void setFakeProvisionRunner(ProvisionRunner fakeProvisionRunner) {
/* 105 */     this.fakeProvisionRunner = fakeProvisionRunner;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.InstantAppProvisioner
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */