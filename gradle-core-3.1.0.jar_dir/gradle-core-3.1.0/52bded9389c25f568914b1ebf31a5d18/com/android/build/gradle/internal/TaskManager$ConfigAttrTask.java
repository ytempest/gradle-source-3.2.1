/*     */ package com.android.build.gradle.internal;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import org.gradle.api.DefaultTask;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.artifacts.Configuration;
/*     */ import org.gradle.api.artifacts.ConfigurationPublications;
/*     */ import org.gradle.api.artifacts.ConfigurationVariant;
/*     */ import org.gradle.api.artifacts.PublishArtifact;
/*     */ import org.gradle.api.attributes.Attribute;
/*     */ import org.gradle.api.attributes.AttributeContainer;
/*     */ import org.gradle.api.tasks.TaskAction;
/*     */ 
/*     */ public class TaskManager$ConfigAttrTask
/*     */   extends DefaultTask
/*     */ {
/* 542 */   boolean consumable = false;
/* 543 */   boolean resolvable = false;
/*     */   
/*     */   @TaskAction
/* 546 */   public void run() { for (Configuration config : getProject().getConfigurations()) {
/* 547 */       AttributeContainer attributes = config.getAttributes();
/* 548 */       if (((consumable) && (config.isCanBeConsumed())) || ((resolvable) && 
/* 549 */         (config.isCanBeResolved()))) {
/* 550 */         System.out.println(config.getName());
/* 551 */         System.out.println("\tcanBeResolved: " + config.isCanBeResolved());
/* 552 */         System.out.println("\tcanBeConsumed: " + config.isCanBeConsumed());
/* 553 */         for (Attribute<?> attr : attributes.keySet()) {
/* 554 */           System.out.println("\t" + attr
/* 555 */             .getName() + ": " + attributes.getAttribute(attr));
/*     */         }
/* 557 */         if ((consumable) && (config.isCanBeConsumed())) {
/* 558 */           for (PublishArtifact artifact : config.getArtifacts()) {
/* 559 */             System.out.println("\tArtifact: " + artifact.getName() + " (" + artifact.getFile().getName() + ")");
/*     */           }
/* 561 */           for (ConfigurationVariant cv : config.getOutgoing().getVariants()) {
/* 562 */             System.out.println("\tConfigurationVariant: " + cv.getName());
/* 563 */             for (PublishArtifact pa : cv.getArtifacts()) {
/* 564 */               System.out.println("\t\tArtifact: " + pa.getFile());
/* 565 */               System.out.println("\t\tType:" + pa.getType());
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.TaskManager.ConfigAttrTask
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */