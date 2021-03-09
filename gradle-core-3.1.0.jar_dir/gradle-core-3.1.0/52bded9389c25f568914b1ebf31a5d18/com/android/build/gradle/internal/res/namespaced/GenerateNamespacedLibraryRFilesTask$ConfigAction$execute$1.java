/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.build.gradle.internal.core.GradleVariantConfiguration;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.functions.Function0;
/*    */ import kotlin.jvm.internal.FunctionReference;
/*    */ import kotlin.jvm.internal.Reflection;
/*    */ import kotlin.reflect.KDeclarationContainer;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\b\n\000\n\002\020\016\n\000\020\000\032\0020\001¢\006\002\b\002"}, d2={"<anonymous>", "", "invoke"})
/*    */ final class GenerateNamespacedLibraryRFilesTask$ConfigAction$execute$1
/*    */   extends FunctionReference
/*    */   implements Function0<String>
/*    */ {
/*    */   @NotNull
/*    */   public final String invoke()
/*    */   {
/* 88 */     return ((GradleVariantConfiguration)receiver).getOriginalApplicationId();
/*    */   }
/*    */   
/*    */   public final KDeclarationContainer getOwner()
/*    */   {
/*    */     return Reflection.getOrCreateKotlinClass(GradleVariantConfiguration.class);
/*    */   }
/*    */   
/*    */   public final String getName()
/*    */   {
/*    */     return "getOriginalApplicationId";
/*    */   }
/*    */   
/*    */   public final String getSignature()
/*    */   {
/*    */     return "getOriginalApplicationId()Ljava/lang/String;";
/*    */   }
/*    */   
/*    */   GenerateNamespacedLibraryRFilesTask$ConfigAction$execute$1(GradleVariantConfiguration paramGradleVariantConfiguration)
/*    */   {
/*    */     super(0, paramGradleVariantConfiguration);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.GenerateNamespacedLibraryRFilesTask.ConfigAction.execute.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */