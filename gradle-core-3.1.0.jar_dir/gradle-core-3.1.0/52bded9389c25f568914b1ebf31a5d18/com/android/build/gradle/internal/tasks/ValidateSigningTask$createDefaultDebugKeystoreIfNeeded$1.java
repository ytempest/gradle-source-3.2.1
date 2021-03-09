/*     */ package com.android.build.gradle.internal.tasks;
/*     */ 
/*     */ import com.android.build.gradle.internal.packaging.GradleKeystoreHelper;
/*     */ import com.android.builder.utils.ExceptionConsumer;
/*     */ import java.io.File;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.logging.Logger;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2={"<anonymous>", "", "it", "Ljava/io/File;", "kotlin.jvm.PlatformType", "accept"})
/*     */ final class ValidateSigningTask$createDefaultDebugKeystoreIfNeeded$1<T>
/*     */   implements ExceptionConsumer<File>
/*     */ {
/*     */   public final void accept(File it)
/*     */   {
/* 101 */     File tmp1_0 = it;Intrinsics.checkExpressionValueIsNotNull(tmp1_0, "it"); Logger tmp14_11 = this$0.getLogger();Intrinsics.checkExpressionValueIsNotNull(tmp14_11, "this.logger");GradleKeystoreHelper.createDefaultDebugStore(tmp1_0, tmp14_11);
/*     */   }
/*     */   
/*     */   ValidateSigningTask$createDefaultDebugKeystoreIfNeeded$1(ValidateSigningTask paramValidateSigningTask) {}
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.ValidateSigningTask.createDefaultDebugKeystoreIfNeeded.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */