/*    */ package com.android.build.gradle.internal.dependency;
/*    */ 
/*    */ import com.android.build.api.attributes.BuildTypeAttr;
/*    */ import com.android.build.api.attributes.ProductFlavorAttr;
/*    */ import com.google.common.collect.Maps;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import javax.inject.Inject;
/*    */ import org.gradle.api.Named;
/*    */ import org.gradle.api.attributes.AttributeDisambiguationRule;
/*    */ import org.gradle.api.attributes.MultipleCandidatesDetails;
/*    */ 
/*    */ public class AlternateDisambiguationRule<T extends Named>
/*    */   implements AttributeDisambiguationRule<T>
/*    */ {
/*    */   private final Map<String, List<String>> alternates;
/*    */   
/*    */   protected AlternateDisambiguationRule(Map<String, List<String>> alternates)
/*    */   {
/* 39 */     this.alternates = alternates;
/*    */   }
/*    */   
/*    */   public void execute(MultipleCandidatesDetails<T> details)
/*    */   {
/* 44 */     T consumerValue = (Named)details.getConsumerValue();
/*    */     
/* 46 */     List<String> alternatesForValue = (List)alternates.get(consumerValue.getName());
/* 47 */     if (alternatesForValue == null) {
/* 48 */       return;
/*    */     }
/*    */     
/* 51 */     Set<T> candidates = details.getCandidateValues();
/*    */     Map<String, T> map;
/* 53 */     if (candidates.contains(consumerValue)) {
/* 54 */       details.closestMatch(consumerValue);
/*    */     } else { String fallback;
/* 56 */       if (alternatesForValue.size() == 1) {
/* 57 */         fallback = (String)alternatesForValue.get(0);
/*    */         
/* 59 */         for (T candidate : candidates) {
/* 60 */           if (candidate.getName().equals(fallback)) {
/* 61 */             details.closestMatch(candidate);
/* 62 */             return;
/*    */           }
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 68 */         map = Maps.newHashMapWithExpectedSize(candidates.size());
/* 69 */         for (T candidate : candidates) {
/* 70 */           map.put(candidate.getName(), candidate);
/*    */         }
/*    */         
/* 74 */         for (String fallback : alternatesForValue) {
/* 75 */           T candidate = (Named)map.get(fallback);
/* 76 */           if (candidate != null) {
/* 77 */             details.closestMatch(candidate);
/* 78 */             return;
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public static class BuildTypeRule extends AlternateDisambiguationRule<BuildTypeAttr> {
/*    */     @Inject
/*    */     public BuildTypeRule(Map<String, List<String>> alternates) {
/* 88 */       super();
/*    */     }
/*    */   }
/*    */   
/*    */   public static class ProductFlavorRule extends AlternateDisambiguationRule<ProductFlavorAttr>
/*    */   {
/*    */     @Inject
/*    */     public ProductFlavorRule(Map<String, List<String>> alternates) {
/* 96 */       super();
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.AlternateDisambiguationRule
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */