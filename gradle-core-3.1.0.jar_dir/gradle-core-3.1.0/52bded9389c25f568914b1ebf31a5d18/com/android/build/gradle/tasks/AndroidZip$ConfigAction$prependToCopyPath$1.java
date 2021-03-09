/*     */ package com.android.build.gradle.tasks;
/*     */ 
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.file.CopySpec;
/*     */ import org.gradle.api.file.FileCopyDetails;
/*     */ import org.gradle.api.file.RelativePath;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2={"<anonymous>", "", "copySpec", "Lorg/gradle/api/file/CopySpec;", "execute"})
/*     */ final class AndroidZip$ConfigAction$prependToCopyPath$1<T>
/*     */   implements Action<CopySpec>
/*     */ {
/*     */   public final void execute(@NotNull CopySpec copySpec)
/*     */   {
/* 137 */     Intrinsics.checkParameterIsNotNull(copySpec, "copySpec");copySpec.eachFile(
/* 138 */       (Action)new Action() {
/*     */         public final void execute(@NotNull FileCopyDetails fileCopyDetails) {
/* 140 */           Intrinsics.checkParameterIsNotNull(fileCopyDetails, "fileCopyDetails");fileCopyDetails.setRelativePath(fileCopyDetails.getRelativePath().prepend(new String[] { this$0.$pathSegment }));
/*     */         }
/*     */       });
/*     */   }
/*     */   
/*     */   AndroidZip$ConfigAction$prependToCopyPath$1(String paramString) {}
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.AndroidZip.ConfigAction.prependToCopyPath.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */