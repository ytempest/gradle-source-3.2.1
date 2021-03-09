/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.ide.common.res2.FileStatus;
/*    */ import java.io.File;
/*    */ import java.util.List;
/*    */ import java.util.function.BiConsumer;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\024\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\0032\006\020\004\032\0020\005H\n¢\006\002\b\006"}, d2={"<anonymous>", "", "file", "Ljava/io/File;", "status", "Lcom/android/ide/common/res2/FileStatus;", "accept"})
/*    */ final class CompileSourceSetResources$doIncrementalTaskAction$1<T, U>
/*    */   implements BiConsumer<File, FileStatus>
/*    */ {
/*    */   public final void accept(@NotNull File file, @NotNull FileStatus status)
/*    */   {
/* 77 */     Intrinsics.checkParameterIsNotNull(file, "file");Intrinsics.checkParameterIsNotNull(status, "status"); if (CompileSourceSetResources.access$willCompile(this$0, file)) { File tmp34_31 = file.getParentFile();Intrinsics.checkExpressionValueIsNotNull(tmp34_31, "file.parentFile"); if (Intrinsics.areEqual(this$0.getInputDirectory(), tmp34_31.getParentFile())) {
/* 78 */         switch (CompileSourceSetResources.WhenMappings.$EnumSwitchMapping$0[status.ordinal()]) {
/*    */         case 1: case 2: 
/* 80 */           $requests.add(CompileSourceSetResources.compileRequest$default(this$0, file, null, 2, null)); break;
/*    */         
/*    */         case 3: 
/* 83 */           $deletes.add(file);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   CompileSourceSetResources$doIncrementalTaskAction$1(CompileSourceSetResources paramCompileSourceSetResources, List paramList1, List paramList2) {}
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.CompileSourceSetResources.doIncrementalTaskAction.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */