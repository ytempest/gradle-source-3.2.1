/*    */ package com.android.build.gradle.internal.api.dsl.sealing;
/*    */ 
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import java.util.ListIterator;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.markers.KMutableListIterator;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0002\n\002\030\002\n\000\n\002\030\002\n\002\020+\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\003\n\002\020\013\n\002\b\004\n\002\020\b\n\002\b\005\030\000*\004\b\000\020\0012\0020\0022\b\022\004\022\002H\0010\003B\033\022\f\020\004\032\b\022\004\022\0028\0000\003\022\006\020\005\032\0020\006¢\006\002\020\007J\025\020\b\032\0020\t2\006\020\n\032\0028\000H\026¢\006\002\020\013J\t\020\f\032\0020\rH\002J\b\020\016\032\0020\rH\026J\016\020\017\032\0028\000H\002¢\006\002\020\020J\b\020\021\032\0020\022H\026J\r\020\023\032\0028\000H\026¢\006\002\020\020J\b\020\024\032\0020\022H\026J\b\020\025\032\0020\tH\026J\025\020\026\032\0020\t2\006\020\n\032\0028\000H\026¢\006\002\020\013R\024\020\004\032\b\022\004\022\0028\0000\003X\004¢\006\002\n\000¨\006\027"}, d2={"Lcom/android/build/gradle/internal/api/dsl/sealing/SealableMutableListIterator;", "T", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "", "iterator", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Ljava/util/ListIterator;Lcom/android/builder/errors/EvalIssueReporter;)V", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "", "previous", "previousIndex", "remove", "set", "gradle-core"})
/*    */ public final class SealableMutableListIterator<T>
/*    */   extends SealableObject
/*    */   implements ListIterator<T>, KMutableListIterator
/*    */ {
/*    */   private final ListIterator<T> iterator;
/*    */   
/*    */   public SealableMutableListIterator(@NotNull ListIterator<T> iterator, @NotNull EvalIssueReporter issueReporter)
/*    */   {
/* 24 */     super(issueReporter);this.iterator = iterator; }
/*    */   
/* 26 */   public boolean hasPrevious() { return iterator.hasPrevious(); }
/*    */   
/* 28 */   public int nextIndex() { return iterator.nextIndex(); }
/*    */   
/* 30 */   public T previous() { return (T)iterator.previous(); }
/*    */   
/* 32 */   public int previousIndex() { return iterator.previousIndex(); }
/*    */   
/*    */   public void add(T element) {
/* 35 */     if (checkSeal()) {
/* 36 */       iterator.add(element);
/*    */     }
/*    */   }
/*    */   
/* 40 */   public boolean hasNext() { return iterator.hasNext(); }
/*    */   
/* 42 */   public T next() { return (T)iterator.next(); }
/*    */   
/*    */   public void remove() {
/* 45 */     if (checkSeal()) {
/* 46 */       iterator.remove();
/*    */     }
/*    */   }
/*    */   
/*    */   public void set(T element) {
/* 51 */     if (checkSeal()) {
/* 52 */       iterator.set(element);
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.sealing.SealableMutableListIterator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */