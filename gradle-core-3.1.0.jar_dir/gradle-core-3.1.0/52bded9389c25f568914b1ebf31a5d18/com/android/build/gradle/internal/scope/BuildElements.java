/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import com.android.build.VariantOutput.OutputType;
/*     */ import com.android.ide.common.build.ApkInfo;
/*     */ import com.android.ide.common.internal.WaitableExecutor;
/*     */ import com.android.ide.common.internal.WaitableExecutor.TaskResult;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.lang.reflect.Type;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.functions.Function2;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import kotlin.sequences.SequencesKt;
/*     */ import org.gradle.tooling.BuildException;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000j\n\002\030\002\n\002\020\034\n\002\030\002\n\000\n\002\020\036\n\002\b\004\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020(\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\005\b\026\030\0002\b\022\004\022\0020\0020\001:\002&'B\023\022\f\020\003\032\b\022\004\022\0020\0020\004¢\006\002\020\005J\020\020\n\032\004\030\0010\0022\006\020\013\032\0020\fJ\020\020\r\032\004\030\0010\0022\006\020\016\032\0020\017J\006\020\020\032\0020\021J\017\020\022\032\b\022\004\022\0020\0020\023H\002J\016\020\024\032\0020\0252\006\020\026\032\0020\027J\020\020\030\032\0020\0002\006\020\031\032\0020\032H\007J\006\020\033\032\0020\034J\f\020\035\032\b\022\004\022\0020\0020\036JB\020\037\032\0020 28\020!\0324\022\023\022\0210\f¢\006\f\b#\022\b\b$\022\004\b\b(\013\022\023\022\0210\032¢\006\f\b#\022\b\b$\022\004\b\b(%\022\006\022\004\030\0010\0320\"H\026R\027\020\003\032\b\022\004\022\0020\0020\004¢\006\b\n\000\032\004\b\006\020\007R\016\020\b\032\0020\tX\004¢\006\002\n\000¨\006("}, d2={"Lcom/android/build/gradle/internal/scope/BuildElements;", "", "Lcom/android/build/gradle/internal/scope/BuildOutput;", "elements", "", "(Ljava/util/Collection;)V", "getElements", "()Ljava/util/Collection;", "executor", "Lcom/android/ide/common/internal/WaitableExecutor;", "element", "apkInfo", "Lcom/android/ide/common/build/ApkInfo;", "elementByType", "type", "Lcom/android/build/VariantOutput$OutputType;", "isEmpty", "", "iterator", "", "persist", "", "projectPath", "Ljava/nio/file/Path;", "save", "folder", "Ljava/io/File;", "size", "", "stream", "Ljava/util/stream/Stream;", "transform", "Lcom/android/build/gradle/internal/scope/BuildElementActionScheduler;", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "input", "ActionItem", "ExecutorBasedScheduler", "gradle-core"})
/*     */ public class BuildElements
/*     */   implements Iterable<BuildOutput>, kotlin.jvm.internal.markers.KMappedMarker
/*     */ {
/*     */   private final WaitableExecutor executor;
/*     */   @NotNull
/*     */   private final Collection<BuildOutput> elements;
/*     */   
/*     */   @NotNull
/*  37 */   public final Collection<BuildOutput> getElements() { return elements; } public BuildElements(@NotNull Collection<BuildOutput> elements) { this.elements = elements; WaitableExecutor 
/*     */     
/*  39 */       tmp19_16 = WaitableExecutor.useGlobalSharedThreadPool();Intrinsics.checkExpressionValueIsNotNull(tmp19_16, "WaitableExecutor.useGlobalSharedThreadPool()");executor = tmp19_16; }
/*     */   @NotNull
/*  41 */   public Iterator<BuildOutput> iterator() { return elements.iterator(); }
/*     */   
/*     */   @Nullable
/*  44 */   public final BuildOutput element(@NotNull ApkInfo apkInfo) { Intrinsics.checkParameterIsNotNull(apkInfo, "apkInfo");Iterable localIterable1 = (Iterable)elements;Iterable localIterable2 = localIterable1; for (Iterator localIterator = localIterable2.iterator(); localIterator.hasNext();) { localObject = localIterator.next();BuildOutput it = (BuildOutput)localObject;
/*     */       
/*     */       int $i$a$1$find;
/*     */       
/*  48 */       ApkInfo tmp55_52 = it.getApkInfo();Intrinsics.checkExpressionValueIsNotNull(tmp55_52, "it.apkInfo"); if (Intrinsics.areEqual(tmp55_52.getType(), apkInfo.getType())) { ApkInfo tmp83_80 = it.getApkInfo();Intrinsics.checkExpressionValueIsNotNull(tmp83_80, "it.apkInfo"); if (Intrinsics.areEqual(tmp83_80.getFilters(), apkInfo.getFilters())) { Intrinsics.checkExpressionValueIsNotNull(it.getApkInfo(), "it.apkInfo");
/*     */         }
/*     */       }
/*     */     }
/*     */     Object localObject;
/*  44 */     return (BuildOutput)(
/*     */     
/*  48 */       (Intrinsics.areEqual(tmp111_108.getFullName(), apkInfo.getFullName()) ? 1 : 0) != 0 ? localObject : null);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public final BuildOutput elementByType(@NotNull VariantOutput.OutputType type)
/*     */   {
/*  53 */     Intrinsics.checkParameterIsNotNull(type, "type");Iterable localIterable1 = (Iterable)elements;Iterable localIterable2 = localIterable1; Object localObject; for (Iterator localIterator = localIterable2.iterator(); localIterator.hasNext(); 
/*  54 */         Intrinsics.checkExpressionValueIsNotNull(tmp55_52, "it.apkInfo"))
/*     */     {
/*  53 */       localObject = localIterator.next();BuildOutput it = (BuildOutput)localObject; int $i$a$1$find; } return (BuildOutput)(
/*  54 */       Intrinsics.areEqual(tmp55_52.getType(), type) ? localObject : null);
/*     */   }
/*     */   
/*  58 */   public final int size() { return elements.size(); }
/*  59 */   public final boolean isEmpty() { return elements.isEmpty(); } @NotNull
/*  60 */   public final java.util.stream.Stream<BuildOutput> stream() { java.util.stream.Stream tmp9_4 = elements.stream();Intrinsics.checkExpressionValueIsNotNull(tmp9_4, "elements.stream()");return tmp9_4;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public BuildElementActionScheduler transform(@NotNull Function2<? super ApkInfo, ? super File, ? extends File> action)
/*     */   {
/*  70 */     Intrinsics.checkParameterIsNotNull(action, "action");return (BuildElementActionScheduler)new ExecutorBasedScheduler(this, action);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final String persist(@NotNull Path projectPath)
/*     */   {
/*  80 */     Intrinsics.checkParameterIsNotNull(projectPath, "projectPath");GsonBuilder gsonBuilder = new GsonBuilder();
/*  81 */     gsonBuilder.registerTypeAdapter((Type)ApkInfo.class, new ExistingBuildElements.ApkInfoAdapter());
/*  82 */     gsonBuilder.registerTypeAdapter(
/*  83 */       (Type)TaskOutputHolder.TaskOutputType.class, new ExistingBuildElements.OutputTypeTypeAdapter());
/*  84 */     gsonBuilder.registerTypeAdapter(
/*  85 */       (Type)TaskOutputHolder.AnchorOutputType.class, 
/*  86 */       new ExistingBuildElements.OutputTypeTypeAdapter());
/*  87 */     Gson gson = gsonBuilder.create(); String 
/*     */     
/*  90 */       tmp101_98 = gson.toJson(
/*     */       
/*  98 */       SequencesKt.toList(SequencesKt.map(kotlin.collections.CollectionsKt.asSequence((Iterable)elements), (Function1)new Lambda(projectPath))));Intrinsics.checkExpressionValueIsNotNull(tmp101_98, "gson.toJson(elements\n   …               .toList())");return tmp101_98;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final BuildElements save(@NotNull File folder)
/*     */     throws java.io.IOException
/*     */   {
/* 103 */     Intrinsics.checkParameterIsNotNull(folder, "folder"); Path tmp11_8 = folder.toPath();Intrinsics.checkExpressionValueIsNotNull(tmp11_8, "folder.toPath()");String persistedOutput = persist(tmp11_8);
/* 104 */     java.io.Closeable localCloseable = (java.io.Closeable)new FileWriter(ExistingBuildElements.Companion.getMetadataFile(folder));Throwable localThrowable1 = (Throwable)null; try { FileWriter writer = (FileWriter)localCloseable; int $i$a$1$use; writer = 
/* 105 */         writer.append((CharSequence)persistedOutput);
/*     */     }
/*     */     catch (Throwable localThrowable)
/*     */     {
/* 104 */       localThrowable1 = localThrowable; throw localThrowable; } finally { kotlin.io.CloseableKt.closeFinally(localCloseable, localThrowable1);
/*     */     }
/*     */     
/* 107 */     return this; }
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000J\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\t\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\002\b\003\b\b\030\0002\0020\001BG\022\006\020\002\032\0020\003\0228\020\004\0324\022\023\022\0210\006¢\006\f\b\007\022\b\b\b\022\004\b\b(\t\022\023\022\0210\n¢\006\f\b\007\022\b\b\b\022\004\b\b(\002\022\006\022\004\030\0010\n0\005¢\006\002\020\013J\t\020\020\032\0020\003HÆ\003J;\020\021\0324\022\023\022\0210\006¢\006\f\b\007\022\b\b\b\022\004\b\b(\t\022\023\022\0210\n¢\006\f\b\007\022\b\b\b\022\004\b\b(\002\022\006\022\004\030\0010\n0\005HÆ\003JO\020\022\032\0020\0002\b\b\002\020\002\032\0020\0032:\b\002\020\004\0324\022\023\022\0210\006¢\006\f\b\007\022\b\b\b\022\004\b\b(\t\022\023\022\0210\n¢\006\f\b\007\022\b\b\b\022\004\b\b(\002\022\006\022\004\030\0010\n0\005HÆ\001J\023\020\023\032\0020\0242\b\020\025\032\004\030\0010\026HÖ\003J\t\020\027\032\0020\030HÖ\001J\020\020\031\032\0020\0032\006\020\032\032\0020\033H\027J\t\020\034\032\0020\035HÖ\001JJ\020\036\032\0020\0032\006\020\037\032\0020\03328\020\004\0324\022\023\022\0210\006¢\006\f\b\007\022\b\b\b\022\004\b\b(\t\022\023\022\0210\n¢\006\f\b\007\022\b\b\b\022\004\b\b(\002\022\006\022\004\030\0010\n0\005H\003RC\020\004\0324\022\023\022\0210\006¢\006\f\b\007\022\b\b\b\022\004\b\b(\t\022\023\022\0210\n¢\006\f\b\007\022\b\b\b\022\004\b\b(\002\022\006\022\004\030\0010\n0\005¢\006\b\n\000\032\004\b\f\020\rR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\016\020\017¨\006 "}, d2={"Lcom/android/build/gradle/internal/scope/BuildElements$ExecutorBasedScheduler;", "Lcom/android/build/gradle/internal/scope/BuildElementActionScheduler;", "input", "Lcom/android/build/gradle/internal/scope/BuildElements;", "action", "Lkotlin/Function2;", "Lcom/android/ide/common/build/ApkInfo;", "Lkotlin/ParameterName;", "name", "apkInfo", "Ljava/io/File;", "(Lcom/android/build/gradle/internal/scope/BuildElements;Lkotlin/jvm/functions/Function2;)V", "getAction", "()Lkotlin/jvm/functions/Function2;", "getInput", "()Lcom/android/build/gradle/internal/scope/BuildElements;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "into", "type", "Lcom/android/build/gradle/internal/scope/TaskOutputHolder$TaskOutputType;", "toString", "", "transform", "to", "gradle-core"})
/*     */   private static final class ExecutorBasedScheduler extends BuildElementActionScheduler { @NotNull
/* 110 */     public final BuildElements getInput() { return input; } @NotNull
/* 111 */     public final Function2<ApkInfo, File, File> getAction() { return action; } public ExecutorBasedScheduler(@NotNull BuildElements input, @NotNull Function2<? super ApkInfo, ? super File, ? extends File> action) { this.input = input;this.action = action;
/*     */     }
/*     */     
/*     */     @NotNull
/* 115 */     public BuildElements into(@NotNull TaskOutputHolder.TaskOutputType type) throws BuildException { Intrinsics.checkParameterIsNotNull(type, "type");return transform(type, action); }
/*     */     
/*     */     @NotNull
/*     */     private final BuildElements input;
/*     */     
/* 120 */     private final BuildElements transform(TaskOutputHolder.TaskOutputType to, Function2<? super ApkInfo, ? super File, ? extends File> action) throws BuildException { Iterable $receiver$iv = (Iterable)input.getElements();
/*     */       
/*     */       int $i$f$forEach;
/*     */       
/*     */       BuildOutput it;
/*     */       
/*     */       int $i$a$1$forEach;
/*     */       
/* 145 */       for (Object localObject1 = $receiver$iv.iterator(); ((Iterator)localObject1).hasNext(); BuildElements.access$getExecutor$p(input).execute((java.util.concurrent.Callable)new BuildElements.ExecutorBasedScheduler.transform..inlined.forEach.lambda.1(it, this, action)))
/*     */       {
/* 145 */         Object element$iv = ((Iterator)localObject1).next();it = (BuildOutput)element$iv;
/*     */       }
/*     */       try
/*     */       {
/* 125 */         localObject1 = BuildElements.access$getExecutor$p(input).waitForAllTasks();
/*     */       } catch (InterruptedException e) {
/* 127 */         Thread.currentThread().interrupt();
/* 128 */         throw ((Throwable)new RuntimeException((Throwable)e));
/*     */       }
/* 124 */       List tasksResults = (List)localObject1; List 
/*     */       
/* 131 */         tmp123_122 = tasksResults;Intrinsics.checkExpressionValueIsNotNull(tmp123_122, "tasksResults");new BuildElements(
/*     */       
/* 140 */         (Collection)SequencesKt.toList(SequencesKt.map(SequencesKt.filter(SequencesKt.onEach(kotlin.collections.CollectionsKt.asSequence((Iterable)tmp123_122), (Function1)transform.2.INSTANCE), (Function1)transform.3.INSTANCE), (Function1)new Lambda(to) {
/*     */           @NotNull
/* 138 */           public final BuildOutput invoke(WaitableExecutor.TaskResult<BuildElements.ActionItem> it) { WaitableExecutor.TaskResult tmp12_11 = it;Intrinsics.checkExpressionValueIsNotNull(tmp12_11, "it"); Object tmp21_18 = tmp12_11.getValue(); if (tmp21_18 == null) throw new TypeCastException("null cannot be cast to non-null type com.android.build.gradle.internal.scope.BuildElements.ActionItem");
/* 139 */             Object tmp45_42 = it.getValue();
/*     */             
/* 139 */             if (tmp45_42 == null) throw new TypeCastException("null cannot be cast to non-null type com.android.build.gradle.internal.scope.BuildElements.ActionItem"); File tmp65_62 = ((BuildElements.ActionItem)tmp45_42).getOutput();
/*     */             
/* 139 */             if (tmp65_62 == null) Intrinsics.throwNpe(); return new BuildOutput((TaskOutputHolder.OutputType)$to, ((BuildElements.ActionItem)tmp21_18).getApkInfo(), tmp65_62);
/*     */           }
/*     */         })));
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     private final Function2<ApkInfo, File, File> action;
/*     */     @NotNull
/*     */     public final BuildElements component1()
/*     */     {
/*     */       return input;
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final Function2<ApkInfo, File, File> component2()
/*     */     {
/*     */       return action;
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final ExecutorBasedScheduler copy(@NotNull BuildElements input, @NotNull Function2<? super ApkInfo, ? super File, ? extends File> action)
/*     */     {
/*     */       Intrinsics.checkParameterIsNotNull(input, "input");
/*     */       Intrinsics.checkParameterIsNotNull(action, "action");
/*     */       return new ExecutorBasedScheduler(input, action);
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/*     */       return "ExecutorBasedScheduler(input=" + input + ", action=" + action + ")";
/*     */     }
/*     */     
/*     */     /* Error */
/*     */     public int hashCode()
/*     */     {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: getfield 34	com/android/build/gradle/internal/scope/BuildElements$ExecutorBasedScheduler:input	Lcom/android/build/gradle/internal/scope/BuildElements;
/*     */       //   4: dup
/*     */       //   5: ifnull +9 -> 14
/*     */       //   8: invokevirtual 212	java/lang/Object:hashCode	()I
/*     */       //   11: goto +5 -> 16
/*     */       //   14: pop
/*     */       //   15: iconst_0
/*     */       //   16: bipush 31
/*     */       //   18: imul
/*     */       //   19: aload_0
/*     */       //   20: getfield 21	com/android/build/gradle/internal/scope/BuildElements$ExecutorBasedScheduler:action	Lkotlin/jvm/functions/Function2;
/*     */       //   23: dup
/*     */       //   24: ifnull +9 -> 33
/*     */       //   27: invokevirtual 212	java/lang/Object:hashCode	()I
/*     */       //   30: goto +5 -> 35
/*     */       //   33: pop
/*     */       //   34: iconst_0
/*     */       //   35: iadd
/*     */       //   36: ireturn
/*     */     }
/*     */     
/*     */     public boolean equals(Object paramObject)
/*     */     {
/*     */       if (this != paramObject)
/*     */       {
/*     */         if ((paramObject instanceof ExecutorBasedScheduler))
/*     */         {
/*     */           ExecutorBasedScheduler localExecutorBasedScheduler = (ExecutorBasedScheduler)paramObject;
/*     */           if ((!Intrinsics.areEqual(input, input)) || (!Intrinsics.areEqual(action, action))) {}
/*     */         }
/*     */       }
/*     */       else {
/*     */         return true;
/*     */       }
/*     */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000,\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\t\n\002\020\013\n\002\b\002\n\002\020\b\n\000\n\002\020\016\n\000\b\b\030\0002\0020\001B\027\022\006\020\002\032\0020\003\022\b\020\004\032\004\030\0010\005¢\006\002\020\006J\t\020\013\032\0020\003HÆ\003J\013\020\f\032\004\030\0010\005HÆ\003J\037\020\r\032\0020\0002\b\b\002\020\002\032\0020\0032\n\b\002\020\004\032\004\030\0010\005HÆ\001J\023\020\016\032\0020\0172\b\020\020\032\004\030\0010\001HÖ\003J\t\020\021\032\0020\022HÖ\001J\t\020\023\032\0020\024HÖ\001R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\007\020\bR\023\020\004\032\004\030\0010\005¢\006\b\n\000\032\004\b\t\020\n¨\006\025"}, d2={"Lcom/android/build/gradle/internal/scope/BuildElements$ActionItem;", "", "apkInfo", "Lcom/android/ide/common/build/ApkInfo;", "output", "Ljava/io/File;", "(Lcom/android/ide/common/build/ApkInfo;Ljava/io/File;)V", "getApkInfo", "()Lcom/android/ide/common/build/ApkInfo;", "getOutput", "()Ljava/io/File;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "gradle-core"})
/*     */   public static final class ActionItem
/*     */   {
/*     */     @NotNull
/*     */     private final ApkInfo apkInfo;
/*     */     @Nullable
/*     */     private final File output;
/*     */     
/*     */     public boolean equals(Object paramObject)
/*     */     {
/*     */       if (this != paramObject)
/*     */       {
/*     */         if ((paramObject instanceof ActionItem))
/*     */         {
/*     */           ActionItem localActionItem = (ActionItem)paramObject;
/*     */           if ((!Intrinsics.areEqual(apkInfo, apkInfo)) || (!Intrinsics.areEqual(output, output))) {}
/*     */         }
/*     */       }
/*     */       else {
/*     */         return true;
/*     */       }
/*     */       return false;
/*     */     }
/*     */     
/*     */     /* Error */
/*     */     public int hashCode()
/*     */     {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: getfield 11	com/android/build/gradle/internal/scope/BuildElements$ActionItem:apkInfo	Lcom/android/ide/common/build/ApkInfo;
/*     */       //   4: dup
/*     */       //   5: ifnull +9 -> 14
/*     */       //   8: invokevirtual 66	java/lang/Object:hashCode	()I
/*     */       //   11: goto +5 -> 16
/*     */       //   14: pop
/*     */       //   15: iconst_0
/*     */       //   16: bipush 31
/*     */       //   18: imul
/*     */       //   19: aload_0
/*     */       //   20: getfield 20	com/android/build/gradle/internal/scope/BuildElements$ActionItem:output	Ljava/io/File;
/*     */       //   23: dup
/*     */       //   24: ifnull +9 -> 33
/*     */       //   27: invokevirtual 66	java/lang/Object:hashCode	()I
/*     */       //   30: goto +5 -> 35
/*     */       //   33: pop
/*     */       //   34: iconst_0
/*     */       //   35: iadd
/*     */       //   36: ireturn
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/*     */       return "ActionItem(apkInfo=" + apkInfo + ", output=" + output + ")";
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final ActionItem copy(@NotNull ApkInfo apkInfo, @Nullable File output)
/*     */     {
/*     */       Intrinsics.checkParameterIsNotNull(apkInfo, "apkInfo");
/*     */       return new ActionItem(apkInfo, output);
/*     */     }
/*     */     
/*     */     @Nullable
/*     */     public final File component2()
/*     */     {
/*     */       return output;
/*     */     }
/*     */     
/*     */     @NotNull
/*     */     public final ApkInfo component1()
/*     */     {
/*     */       return apkInfo;
/*     */     }
/*     */     
/*     */     public ActionItem(@NotNull ApkInfo apkInfo, @Nullable File output)
/*     */     {
/* 143 */       this.apkInfo = apkInfo;this.output = output; } @Nullable
/* 143 */     public final File getOutput() { return output; } @NotNull
/* 143 */     public final ApkInfo getApkInfo() { return apkInfo; }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.BuildElements
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */