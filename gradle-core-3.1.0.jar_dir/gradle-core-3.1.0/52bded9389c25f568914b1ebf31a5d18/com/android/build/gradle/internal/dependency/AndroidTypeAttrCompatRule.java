/*    */ package com.android.build.gradle.internal.dependency;
/*    */ 
/*    */ import com.google.common.collect.ImmutableSet;
/*    */ import java.util.Set;
/*    */ import javax.inject.Inject;
/*    */ import org.gradle.api.attributes.AttributeCompatibilityRule;
/*    */ import org.gradle.api.attributes.CompatibilityCheckDetails;
/*    */ 
/*    */ public final class AndroidTypeAttrCompatRule
/*    */   implements AttributeCompatibilityRule<AndroidTypeAttr>
/*    */ {
/* 30 */   private static final Set<String> FEATURE_OR_APK = ImmutableSet.of("Feature", "Apk");
/*    */   
/*    */   public void execute(CompatibilityCheckDetails<AndroidTypeAttr> details)
/*    */   {
/* 37 */     AndroidTypeAttr producerValue = (AndroidTypeAttr)details.getProducerValue();
/* 38 */     AndroidTypeAttr consumerValue = (AndroidTypeAttr)details.getConsumerValue();
/* 39 */     if (producerValue.equals(consumerValue)) {
/* 40 */       details.compatible();
/*    */     }
/* 44 */     else if (("Aar".equals(producerValue.getName())) && 
/* 45 */       (FEATURE_OR_APK.contains(consumerValue.getName()))) {
/* 46 */       details.compatible();
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.AndroidTypeAttrCompatRule
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */