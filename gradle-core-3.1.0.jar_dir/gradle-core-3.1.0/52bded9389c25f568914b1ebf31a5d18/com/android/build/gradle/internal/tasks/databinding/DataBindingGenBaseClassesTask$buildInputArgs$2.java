/*     */ package com.android.build.gradle.internal.tasks.databinding;
/*     */ 
/*     */ import com.android.utils.FileUtils;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.text.StringsKt;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.tasks.incremental.InputFileDetails;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2={"<anonymous>", "", "inputFileDetails", "Lorg/gradle/api/tasks/incremental/InputFileDetails;", "kotlin.jvm.PlatformType", "execute"})
/*     */ final class DataBindingGenBaseClassesTask$buildInputArgs$2<T>
/*     */   implements Action<InputFileDetails>
/*     */ {
/*     */   public final void execute(InputFileDetails inputFileDetails)
/*     */   {
/* 103 */     InputFileDetails tmp1_0 = inputFileDetails;Intrinsics.checkExpressionValueIsNotNull(tmp1_0, "inputFileDetails"); if (FileUtils.isFileInDirectory(tmp1_0.getFile(), 
/* 104 */       this$0.getXmlInfoFolder())) { File tmp31_26 = inputFileDetails.getFile();Intrinsics.checkExpressionValueIsNotNull(tmp31_26, "inputFileDetails.file"); String tmp40_37 = tmp31_26.getName();Intrinsics.checkExpressionValueIsNotNull(tmp40_37, "inputFileDetails.file.name"); if (StringsKt.endsWith$default(tmp40_37, ".xml", false, 2, null)) {
/* 105 */         $removed.add(inputFileDetails.getFile());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   DataBindingGenBaseClassesTask$buildInputArgs$2(DataBindingGenBaseClassesTask paramDataBindingGenBaseClassesTask, ArrayList paramArrayList) {}
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.tasks.databinding.DataBindingGenBaseClassesTask.buildInputArgs.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */