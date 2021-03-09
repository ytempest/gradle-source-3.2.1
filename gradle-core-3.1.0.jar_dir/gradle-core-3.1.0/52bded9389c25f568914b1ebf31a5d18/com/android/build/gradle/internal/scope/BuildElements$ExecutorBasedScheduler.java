/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import com.android.ide.common.build.ApkInfo;
/*     */ import com.android.ide.common.internal.WaitableExecutor;
/*     */ import com.android.ide.common.internal.WaitableExecutor.TaskResult;
/*     */ import java.io.File;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.Unit;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.functions.Function2;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import kotlin.sequences.SequencesKt;
/*     */ import org.gradle.tooling.BuildException;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000J\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\t\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\002\b\003\b\b\030\0002\0020\001BG\022\006\020\002\032\0020\003\0228\020\004\0324\022\023\022\0210\006¢\006\f\b\007\022\b\b\b\022\004\b\b(\t\022\023\022\0210\n¢\006\f\b\007\022\b\b\b\022\004\b\b(\002\022\006\022\004\030\0010\n0\005¢\006\002\020\013J\t\020\020\032\0020\003HÆ\003J;\020\021\0324\022\023\022\0210\006¢\006\f\b\007\022\b\b\b\022\004\b\b(\t\022\023\022\0210\n¢\006\f\b\007\022\b\b\b\022\004\b\b(\002\022\006\022\004\030\0010\n0\005HÆ\003JO\020\022\032\0020\0002\b\b\002\020\002\032\0020\0032:\b\002\020\004\0324\022\023\022\0210\006¢\006\f\b\007\022\b\b\b\022\004\b\b(\t\022\023\022\0210\n¢\006\f\b\007\022\b\b\b\022\004\b\b(\002\022\006\022\004\030\0010\n0\005HÆ\001J\023\020\023\032\0020\0242\b\020\025\032\004\030\0010\026HÖ\003J\t\020\027\032\0020\030HÖ\001J\020\020\031\032\0020\0032\006\020\032\032\0020\033H\027J\t\020\034\032\0020\035HÖ\001JJ\020\036\032\0020\0032\006\020\037\032\0020\03328\020\004\0324\022\023\022\0210\006¢\006\f\b\007\022\b\b\b\022\004\b\b(\t\022\023\022\0210\n¢\006\f\b\007\022\b\b\b\022\004\b\b(\002\022\006\022\004\030\0010\n0\005H\003RC\020\004\0324\022\023\022\0210\006¢\006\f\b\007\022\b\b\b\022\004\b\b(\t\022\023\022\0210\n¢\006\f\b\007\022\b\b\b\022\004\b\b(\002\022\006\022\004\030\0010\n0\005¢\006\b\n\000\032\004\b\f\020\rR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\016\020\017¨\006 "}, d2={"Lcom/android/build/gradle/internal/scope/BuildElements$ExecutorBasedScheduler;", "Lcom/android/build/gradle/internal/scope/BuildElementActionScheduler;", "input", "Lcom/android/build/gradle/internal/scope/BuildElements;", "action", "Lkotlin/Function2;", "Lcom/android/ide/common/build/ApkInfo;", "Lkotlin/ParameterName;", "name", "apkInfo", "Ljava/io/File;", "(Lcom/android/build/gradle/internal/scope/BuildElements;Lkotlin/jvm/functions/Function2;)V", "getAction", "()Lkotlin/jvm/functions/Function2;", "getInput", "()Lcom/android/build/gradle/internal/scope/BuildElements;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "into", "type", "Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;", "toString", "", "transform", "to", "gradle-core"})
/*     */ final class BuildElements$ExecutorBasedScheduler
/*     */   extends BuildElementActionScheduler
/*     */ {
/*     */   @NotNull
/*     */   private final BuildElements input;
/*     */   @NotNull
/*     */   private final Function2<ApkInfo, File, File> action;
/*     */   
/*     */   @NotNull
/* 110 */   public final BuildElements getInput() { return input; } @NotNull
/* 111 */   public final Function2<ApkInfo, File, File> getAction() { return action; } public BuildElements$ExecutorBasedScheduler(@NotNull BuildElements input, @NotNull Function2<? super ApkInfo, ? super File, ? extends File> action) { this.input = input;this.action = action;
/*     */   }
/*     */   
/*     */   @NotNull
/* 115 */   public BuildElements into(@NotNull TaskOutputHolder.TaskOutputType type) throws BuildException { Intrinsics.checkParameterIsNotNull(type, "type");return transform(type, action);
/*     */   }
/*     */   
/*     */   private final BuildElements transform(TaskOutputHolder.TaskOutputType to, Function2<? super ApkInfo, ? super File, ? extends File> action) throws BuildException
/*     */   {
/* 120 */     Iterable $receiver$iv = (Iterable)input.getElements();
/*     */     
/*     */     int $i$f$forEach;
/*     */     
/*     */     BuildOutput it;
/*     */     
/*     */     int $i$a$1$forEach;
/*     */     
/* 145 */     for (Object localObject1 = $receiver$iv.iterator(); ((Iterator)localObject1).hasNext(); BuildElements.access$getExecutor$p(input).execute((Callable)new BuildElements.ExecutorBasedScheduler.transform..inlined.forEach.lambda.1(it, this, action)))
/*     */     {
/* 145 */       Object element$iv = ((Iterator)localObject1).next();it = (BuildOutput)element$iv;
/*     */     }
/*     */     try
/*     */     {
/* 125 */       localObject1 = BuildElements.access$getExecutor$p(input).waitForAllTasks();
/*     */     } catch (InterruptedException e) {
/* 127 */       Thread.currentThread().interrupt();
/* 128 */       throw ((Throwable)new RuntimeException((Throwable)e));
/*     */     }
/* 124 */     List tasksResults = (List)localObject1; List 
/*     */     
/* 131 */       tmp123_122 = tasksResults;Intrinsics.checkExpressionValueIsNotNull(tmp123_122, "tasksResults");new BuildElements(
/*     */     
/* 140 */       (Collection)SequencesKt.toList(SequencesKt.map(SequencesKt.filter(SequencesKt.onEach(CollectionsKt.asSequence((Iterable)tmp123_122), (Function1)transform.2.INSTANCE), (Function1)transform.3.INSTANCE), (Function1)new Lambda(to) {
/*     */         @NotNull
/* 138 */         public final BuildOutput invoke(WaitableExecutor.TaskResult<BuildElements.ActionItem> it) { WaitableExecutor.TaskResult tmp12_11 = it;Intrinsics.checkExpressionValueIsNotNull(tmp12_11, "it"); Object tmp21_18 = tmp12_11.getValue(); if (tmp21_18 == null) throw new TypeCastException("null cannot be cast to non-null type com.android.build.gradle.internal.scope.BuildElements.ActionItem");
/* 139 */           Object tmp45_42 = it.getValue();
/*     */           
/* 139 */           if (tmp45_42 == null) throw new TypeCastException("null cannot be cast to non-null type com.android.build.gradle.internal.scope.BuildElements.ActionItem"); File tmp65_62 = ((BuildElements.ActionItem)tmp45_42).getOutput();
/*     */           
/* 139 */           if (tmp65_62 == null) Intrinsics.throwNpe(); return new BuildOutput((TaskOutputHolder.OutputType)$to, ((BuildElements.ActionItem)tmp21_18).getApkInfo(), tmp65_62);
/*     */         }
/*     */       })));
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BuildElements component1()
/*     */   {
/*     */     return input;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final Function2<ApkInfo, File, File> component2()
/*     */   {
/*     */     return action;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final ExecutorBasedScheduler copy(@NotNull BuildElements input, @NotNull Function2<? super ApkInfo, ? super File, ? extends File> action)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(input, "input");
/*     */     Intrinsics.checkParameterIsNotNull(action, "action");
/*     */     return new ExecutorBasedScheduler(input, action);
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/*     */     return "ExecutorBasedScheduler(input=" + input + ", action=" + action + ")";
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public int hashCode()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 34	com/android/build/gradle/internal/scope/BuildElements$ExecutorBasedScheduler:input	Lcom/android/build/gradle/internal/scope/BuildElements;
/*     */     //   4: dup
/*     */     //   5: ifnull +9 -> 14
/*     */     //   8: invokevirtual 212	java/lang/Object:hashCode	()I
/*     */     //   11: goto +5 -> 16
/*     */     //   14: pop
/*     */     //   15: iconst_0
/*     */     //   16: bipush 31
/*     */     //   18: imul
/*     */     //   19: aload_0
/*     */     //   20: getfield 21	com/android/build/gradle/internal/scope/BuildElements$ExecutorBasedScheduler:action	Lkotlin/jvm/functions/Function2;
/*     */     //   23: dup
/*     */     //   24: ifnull +9 -> 33
/*     */     //   27: invokevirtual 212	java/lang/Object:hashCode	()I
/*     */     //   30: goto +5 -> 35
/*     */     //   33: pop
/*     */     //   34: iconst_0
/*     */     //   35: iadd
/*     */     //   36: ireturn
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/*     */     if (this != paramObject)
/*     */     {
/*     */       if ((paramObject instanceof ExecutorBasedScheduler))
/*     */       {
/*     */         ExecutorBasedScheduler localExecutorBasedScheduler = (ExecutorBasedScheduler)paramObject;
/*     */         if ((!Intrinsics.areEqual(input, input)) || (!Intrinsics.areEqual(action, action))) {}
/*     */       }
/*     */     }
/*     */     else {
/*     */       return true;
/*     */     }
/*     */     return false;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.BuildElements.ExecutorBasedScheduler
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */