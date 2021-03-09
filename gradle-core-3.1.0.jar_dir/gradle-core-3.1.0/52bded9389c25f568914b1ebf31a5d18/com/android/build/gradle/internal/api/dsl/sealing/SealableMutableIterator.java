/*    */ package com.android.build.gradle.internal.api.dsl.sealing;
/*    */ 
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.util.Iterator;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.markers.KMutableIterator;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000(\n\002\030\002\n\000\n\002\030\002\n\002\020)\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\003\n\002\020\002\n\000\030\000*\006\b\000\020\001 \0012\0020\0022\b\022\004\022\002H\0010\003B\033\022\f\020\004\032\b\022\004\022\0028\0000\003\022\006\020\005\032\0020\006¢\006\002\020\007J\t\020\b\032\0020\tH\002J\016\020\n\032\0028\000H\002¢\006\002\020\013J\b\020\f\032\0020\rH\026R\024\020\004\032\b\022\004\022\0028\0000\003X\004¢\006\002\n\000¨\006\016"}, d2={"Lcom/android/build/gradle/internal/api/dsl/sealing/SealableMutableIterator;", "T", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "", "iterator", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Ljava/util/Iterator;Lcom/android/builder/errors/EvalIssueReporter;)V", "hasNext", "", "next", "()Ljava/lang/Object;", "remove", "", "gradle-core"})
/*    */ public final class SealableMutableIterator<T>
/*    */   extends SealableObject
/*    */   implements Iterator<T>, KMutableIterator
/*    */ {
/*    */   private final Iterator<T> iterator;
/*    */   
/*    */   public SealableMutableIterator(@NotNull Iterator<? extends T> iterator, @NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 24 */     super(issueReporter);this.iterator = iterator;
/*    */   }
/*    */   
/* 27 */   public void remove() { if (checkSeal()) {
/* 28 */       iterator.remove();
/*    */     }
/*    */   }
/*    */   
/* 32 */   public boolean hasNext() { return iterator.hasNext(); }
/*    */   
/* 34 */   public T next() { return (T)iterator.next(); }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.sealing.SealableMutableIterator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */