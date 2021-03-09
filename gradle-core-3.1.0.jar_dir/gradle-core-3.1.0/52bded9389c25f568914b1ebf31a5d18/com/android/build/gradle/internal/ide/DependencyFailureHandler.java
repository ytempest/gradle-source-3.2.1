/*    */ package com.android.build.gradle.internal.ide;
/*    */ 
/*    */ import com.android.builder.errors.EvalIssueReporter.Severity;
/*    */ import com.android.builder.errors.EvalIssueReporter.Type;
/*    */ import com.android.builder.model.SyncIssue;
/*    */ import com.google.common.collect.ArrayListMultimap;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import com.google.common.collect.ListMultimap;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map.Entry;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.Unit;
/*    */ import kotlin.jvm.functions.Function1;
/*    */ import kotlin.jvm.functions.Function2;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.jvm.internal.Lambda;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000(\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\020\016\n\002\020\003\n\002\b\003\n\002\020\036\n\000\n\002\030\002\n\000\030\0002\0020\001B\005¢\006\002\020\002J\034\020\007\032\0020\0002\006\020\b\032\0020\0052\f\020\t\032\b\022\004\022\0020\0060\nJ\f\020\013\032\b\022\004\022\0020\f0\nR\032\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0060\004X\004¢\006\002\n\000¨\006\r"}, d2={"Lcom/android/build/gradle/internal/ide/DependencyFailureHandler;", "", "()V", "failures", "Lcom/google/common/collect/ListMultimap;", "", "", "addErrors", "name", "throwables", "", "collectIssues", "Lcom/android/builder/model/SyncIssue;", "gradle-core"})
/*    */ public final class DependencyFailureHandler
/*    */ {
/*    */   private final ListMultimap<String, Throwable> failures;
/*    */   
/*    */   public DependencyFailureHandler()
/*    */   {
/* 35 */     ArrayListMultimap tmp8_5 = ArrayListMultimap.create();Intrinsics.checkExpressionValueIsNotNull(tmp8_5, "ArrayListMultimap.create()");failures = ((ListMultimap)tmp8_5); }
/*    */   
/*    */   @NotNull
/* 38 */   public final DependencyFailureHandler addErrors(@NotNull String name, @NotNull Collection<? extends Throwable> throwables) { Intrinsics.checkParameterIsNotNull(name, "name");Intrinsics.checkParameterIsNotNull(throwables, "throwables");Iterable $receiver$iv = (Iterable)throwables;
/*    */     
/*    */     int $i$f$forEach;
/*    */     
/*    */     Throwable t;
/*    */     
/*    */     int $i$a$1$forEach;
/*    */     
/* ?6 */     for (Iterator localIterator = $receiver$iv.iterator(); localIterator.hasNext(); failures.put(name, t))
/*    */     {
/* ?6 */       Object element$iv = localIterator.next();t = (Throwable)element$iv;
/*    */     }
/* 41 */     return this;
/*    */   }
/*    */   
/*    */   @NotNull
/* 45 */   public final Collection<SyncIssue> collectIssues() { if (failures.isEmpty()) {
/* 46 */       ImmutableList tmp15_12 = ImmutableList.of();Intrinsics.checkExpressionValueIsNotNull(tmp15_12, "ImmutableList.of()");return (Collection)tmp15_12;
/*    */     }
/*    */     
/* 49 */     final List issues = (List)new ArrayList();
/*    */     String key;
/* 51 */     for (Iterator localIterator = failures.entries().iterator(); localIterator.hasNext(); 
/* 52 */         DependencyFailureHandlerKt.access$processDependencyThrowable(
/* 53 */           tmp102_100, 
/* 54 */           (Function1)collectIssues.1.INSTANCE, 
/* 55 */           (Function2)new Lambda(key) {
/* 56 */           public final void invoke(@Nullable String data, @NotNull List<String> messages) { Intrinsics.checkParameterIsNotNull(messages, "messages");SyncIssueImpl issue = data != null ? 
/* 57 */               new SyncIssueImpl(
/* 58 */               EvalIssueReporter.Type.UNRESOLVED_DEPENDENCY, 
/* 59 */               EvalIssueReporter.Severity.ERROR, 
/* 60 */               data, 
/* 61 */               "Unable to resolve dependency " + data, 
/* 62 */               null) : 
/*    */               
/* 64 */               new SyncIssueImpl(
/* 65 */               EvalIssueReporter.Type.UNRESOLVED_DEPENDENCY, 
/* 66 */               EvalIssueReporter.Severity.ERROR, 
/* 67 */               null, 
/* 68 */               "Unable to resolve dependency for '" + $key + "': " + (String)messages.get(0), 
/* 69 */               messages);
/*    */             
/* 72 */             issues.add(issue);
/*    */           }
/* 55 */         }))
/*    */     {
/* 51 */       Map.Entry localEntry1 = (Map.Entry)localIterator.next();Map.Entry localEntry2 = localEntry1;key = (String)localEntry2.getKey();localEntry2 = localEntry1;Throwable value = (Throwable)localEntry2.getValue();
/*    */       
/* 53 */       Intrinsics.checkExpressionValueIsNotNull(value, "value");
/*    */     }
/*    */     
/* 77 */     return (Collection)issues;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.DependencyFailureHandler
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */