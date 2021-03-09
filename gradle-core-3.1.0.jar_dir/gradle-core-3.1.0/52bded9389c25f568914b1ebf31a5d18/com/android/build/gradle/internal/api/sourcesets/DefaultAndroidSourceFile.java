/*    */ package com.android.build.gradle.internal.api.sourcesets;
/*    */ 
/*    */ import com.android.build.api.sourcesets.AndroidSourceFile;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.io.File;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\b\n\002\020\000\n\002\b\002\030\0002\0020\0012\0020\002B\037\b\000\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\b¢\006\002\020\tJ\b\020\022\032\0020\004H\026J\020\020\r\032\0020\0022\006\020\023\032\0020\024H\026J\b\020\025\032\0020\004H\026R\016\020\n\032\0020\013X.¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000R$\020\r\032\0020\0132\006\020\f\032\0020\0138V@VX\016¢\006\f\032\004\b\016\020\017\"\004\b\020\020\021¨\006\026"}, d2={"Lcom/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceFile;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/sourcesets/AndroidSourceFile;", "name", "", "filesProvider", "Lcom/android/build/gradle/internal/api/sourcesets/FilesProvider;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Ljava/lang/String;Lcom/android/build/gradle/internal/api/sourcesets/FilesProvider;Lcom/android/builder/errors/EvalIssueReporter;)V", "_srcFile", "Ljava/io/File;", "value", "srcFile", "getSrcFile", "()Ljava/io/File;", "setSrcFile", "(Ljava/io/File;)V", "getName", "srcPath", "", "toString", "gradle-core"})
/*    */ public final class DefaultAndroidSourceFile
/*    */   extends SealableObject
/*    */   implements AndroidSourceFile
/*    */ {
/*    */   private File _srcFile;
/*    */   private final String name;
/*    */   private final FilesProvider filesProvider;
/*    */   
/*    */   public DefaultAndroidSourceFile(@NotNull String name, @NotNull FilesProvider filesProvider, @NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 29 */     super(issueReporter);this.name = name;this.filesProvider = filesProvider;
/*    */   }
/*    */   
/*    */   @NotNull
/* 34 */   public String getName() { return name; }
/*    */   
/*    */   @NotNull
/*    */   public File getSrcFile() {
/* 38 */     File tmp4_1 = _srcFile;
/*    */     
/* 38 */     if (tmp4_1 == null) Intrinsics.throwUninitializedPropertyAccessException("_srcFile"); return tmp4_1; }
/*    */   
/* 40 */   public void setSrcFile(@NotNull File value) { Intrinsics.checkParameterIsNotNull(value, "value"); if (checkSeal())
/* 41 */       _srcFile = value;
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public AndroidSourceFile srcFile(@NotNull Object srcPath) {
/* 46 */     Intrinsics.checkParameterIsNotNull(srcPath, "srcPath");setSrcFile(filesProvider.file(srcPath));
/* 47 */     return (AndroidSourceFile)this;
/*    */   }
/*    */   
/*    */   @NotNull
/* 51 */   public String toString() { String tmp7_4 = getSrcFile().toString();Intrinsics.checkExpressionValueIsNotNull(tmp7_4, "srcFile.toString()");return tmp7_4;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.sourcesets.DefaultAndroidSourceFile
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */