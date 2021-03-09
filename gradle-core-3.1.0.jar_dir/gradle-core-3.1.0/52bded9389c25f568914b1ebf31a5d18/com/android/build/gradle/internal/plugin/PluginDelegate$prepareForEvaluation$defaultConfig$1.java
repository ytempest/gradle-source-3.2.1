/*     */ package com.android.build.gradle.internal.plugin;
/*     */ 
/*     */ import com.android.build.api.dsl.options.PostProcessingFilesOptions;
/*     */ import com.android.build.gradle.internal.api.dsl.model.BaseFlavorImpl;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.functions.Function0;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\020\000\032\0020\001\"\n\b\000\020\002 \001*\0020\003H\n¢\006\002\b\004"}, d2={"<anonymous>", "Lcom/android/build/api/dsl/options/PostProcessingFilesOptions;", "E", "Lcom/android/build/gradle/internal/api/dsl/extensions/BaseExtension2;", "invoke"})
/*     */ final class PluginDelegate$prepareForEvaluation$defaultConfig$1
/*     */   extends Lambda
/*     */   implements Function0<PostProcessingFilesOptions>
/*     */ {
/*     */   @NotNull
/*     */   public final PostProcessingFilesOptions invoke()
/*     */   {
/* 112 */     return $baseFlavor.getPostProcessing();
/*     */   }
/*     */   
/*     */   PluginDelegate$prepareForEvaluation$defaultConfig$1(BaseFlavorImpl paramBaseFlavorImpl)
/*     */   {
/*     */     super(0);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.plugin.PluginDelegate.prepareForEvaluation.defaultConfig.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */