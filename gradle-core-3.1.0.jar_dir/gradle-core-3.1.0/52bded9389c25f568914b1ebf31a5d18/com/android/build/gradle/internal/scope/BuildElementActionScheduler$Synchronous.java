/*    */ package com.android.build.gradle.internal.scope;
/*    */ 
/*    */ import com.android.ide.common.build.ApkInfo;
/*    */ import java.io.File;
/*    */ import java.util.Collection;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.collections.CollectionsKt;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.functions.Function2;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import kotlin.sequences.SequencesKt;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000.\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\b\n\002\030\002\n\000\030\0002\0020\001BG\022\006\020\002\032\0020\003\0228\020\004\0324\022\023\022\0210\006¢\006\f\b\007\022\b\b\b\022\004\b\b(\t\022\023\022\0210\n¢\006\f\b\007\022\b\b\b\022\004\b\b(\013\022\006\022\004\030\0010\n0\005¢\006\002\020\fJ\020\020\021\032\0020\0032\006\020\022\032\0020\023H\026RC\020\004\0324\022\023\022\0210\006¢\006\f\b\007\022\b\b\b\022\004\b\b(\t\022\023\022\0210\n¢\006\f\b\007\022\b\b\b\022\004\b\b(\013\022\006\022\004\030\0010\n0\005¢\006\b\n\000\032\004\b\r\020\016R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\017\020\020¨\006\024"}, d2={"Lcom/android/build/gradle/internal/scope/BuildElementActionScheduler$Synchronous;", "Lcom/android/build/gradle/internal/scope/BuildElementActionScheduler;", "elements", "Lcom/android/build/gradle/internal/scope/BuildElements;", "action", "Lkotlin/Function2;", "Lcom/android/ide/common/build/ApkInfo;", "Lkotlin/ParameterName;", "name", "apkInfo", "Ljava/io/File;", "input", "(Lcom/android/build/gradle/internal/scope/BuildElements;Lkotlin/jvm/functions/Function2;)V", "getAction", "()Lkotlin/jvm/functions/Function2;", "getElements", "()Lcom/android/build/gradle/internal/scope/BuildElements;", "into", "type", "Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;", "gradle-core"})
/*    */ public final class BuildElementActionScheduler$Synchronous
/*    */   extends BuildElementActionScheduler
/*    */ {
/*    */   @NotNull
/*    */   private final BuildElements elements;
/*    */   @NotNull
/*    */   private final Function2<ApkInfo, File, File> action;
/*    */   
/*    */   @NotNull
/* 36 */   public final BuildElements getElements() { return elements; } @NotNull
/* 37 */   public final Function2<ApkInfo, File, File> getAction() { return action; } public BuildElementActionScheduler$Synchronous(@NotNull BuildElements elements, @NotNull Function2<? super ApkInfo, ? super File, ? extends File> action) { this.elements = elements;this.action = action; }
/*    */   
/*    */   @NotNull
/* 40 */   public BuildElements into(@NotNull final TaskOutputHolder.TaskOutputType type) { Intrinsics.checkParameterIsNotNull(type, "type");new BuildElements(
/*    */     
/* 51 */       (Collection)SequencesKt.toList(SequencesKt.filterNotNull(SequencesKt.map(CollectionsKt.asSequence((Iterable)elements), (Function1)new Lambda(type) { @Nullable
/* 43 */         public final BuildOutput invoke(@NotNull BuildOutput input) { Intrinsics.checkParameterIsNotNull(input, "input"); ApkInfo tmp17_14 = input.getApkInfo();Intrinsics.checkExpressionValueIsNotNull(tmp17_14, "input.apkInfo"); File tmp27_24 = input.getOutputFile();Intrinsics.checkExpressionValueIsNotNull(tmp27_24, "input.outputFile");File output = (File)this$0.getAction().invoke(tmp17_14, tmp27_24);
/*    */           
/* 48 */           return output == null ? null : new BuildOutput((TaskOutputHolder.OutputType)type, input.getApkInfo(), output);
/*    */         }
/*    */       }))));
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.BuildElementActionScheduler.Synchronous
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */