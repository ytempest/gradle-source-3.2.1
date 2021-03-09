/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.LinkOption;
/*    */ import java.nio.file.Path;
/*    */ import java.util.List;
/*    */ import java.util.function.Consumer;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3, d1={"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2={"<anonymous>", "", "resFile", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "accept"})
/*    */ final class CompileSourceSetResources$doFullTaskAction$1$1<T>
/*    */   implements Consumer<Path>
/*    */ {
/*    */   public final void accept(Path resFile)
/*    */   {
/* 62 */     if (Files.isRegularFile(resFile, new LinkOption[0])) {
/* 63 */       File tmp31_26 = resFile.toFile();Intrinsics.checkExpressionValueIsNotNull(tmp31_26, "resFile.toFile()");this$0.$requests.add(CompileSourceSetResources.compileRequest$default(this$0.this$0, tmp31_26, null, 2, null));
/*    */     }
/*    */   }
/*    */   
/*    */   CompileSourceSetResources$doFullTaskAction$1$1(CompileSourceSetResources.doFullTaskAction.1 param1) {}
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.CompileSourceSetResources.doFullTaskAction.1.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */