/*    */ package com.android.build.gradle.internal.dependency;
/*    */ 
/*    */ import com.android.build.api.attributes.BuildTypeAttr;
/*    */ import com.android.build.api.attributes.ProductFlavorAttr;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.inject.Inject;
/*    */ import org.gradle.api.Named;
/*    */ import org.gradle.api.attributes.AttributeCompatibilityRule;
/*    */ import org.gradle.api.attributes.CompatibilityCheckDetails;
/*    */ 
/*    */ public class AlternateCompatibilityRule<T extends Named>
/*    */   implements AttributeCompatibilityRule<T>
/*    */ {
/*    */   private final Map<String, List<String>> alternates;
/*    */   
/*    */   protected AlternateCompatibilityRule(Map<String, List<String>> alternates)
/*    */   {
/* 35 */     this.alternates = alternates;
/*    */   }
/*    */   
/*    */   public void execute(CompatibilityCheckDetails<T> details)
/*    */   {
/* 40 */     T producerValue = (Named)details.getProducerValue();
/* 41 */     T consumerValue = (Named)details.getConsumerValue();
/* 42 */     if (producerValue.equals(consumerValue)) {
/* 43 */       details.compatible();
/*    */     } else {
/* 45 */       List<String> alternatesForValue = (List)alternates.get(consumerValue.getName());
/* 46 */       if ((alternatesForValue != null) && 
/* 47 */         (alternatesForValue.contains(producerValue.getName()))) {
/* 48 */         details.compatible();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public static class BuildTypeRule extends AlternateCompatibilityRule<BuildTypeAttr>
/*    */   {
/*    */     @Inject
/*    */     public BuildTypeRule(Map<String, List<String>> alternates) {
/* 57 */       super();
/*    */     }
/*    */   }
/*    */   
/*    */   public static class ProductFlavorRule extends AlternateCompatibilityRule<ProductFlavorAttr>
/*    */   {
/*    */     @Inject
/*    */     public ProductFlavorRule(Map<String, List<String>> alternates) {
/* 65 */       super();
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.AlternateCompatibilityRule
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */