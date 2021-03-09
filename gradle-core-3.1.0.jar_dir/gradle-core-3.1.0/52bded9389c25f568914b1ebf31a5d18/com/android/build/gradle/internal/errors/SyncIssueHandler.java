package com.android.build.gradle.internal.errors;

import com.android.builder.errors.EvalIssueReporter;
import com.android.builder.errors.EvalIssueReporter.DefaultImpls;
import com.android.builder.errors.EvalIssueReporter.Severity;
import com.android.builder.errors.EvalIssueReporter.Type;
import com.android.builder.model.SyncIssue;
import com.google.common.collect.ImmutableList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\"\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\013\n\000\n\002\030\002\n\000\bf\030\0002\0020\001J\020\020\007\032\0020\b2\006\020\t\032\0020\nH&R\030\020\002\032\b\022\004\022\0020\0040\003X¦\004¢\006\006\032\004\b\005\020\006¨\006\013"}, d2={"Lcom/android/build/gradle/internal/errors/SyncIssueHandler;", "Lcom/android/builder/errors/EvalIssueReporter;", "syncIssues", "Lcom/google/common/collect/ImmutableList;", "Lcom/android/builder/model/SyncIssue;", "getSyncIssues", "()Lcom/google/common/collect/ImmutableList;", "hasSyncIssue", "", "type", "Lcom/android/builder/errors/EvalIssueReporter$Type;", "gradle-core"})
public abstract interface SyncIssueHandler
  extends EvalIssueReporter
{
  @NotNull
  public abstract ImmutableList<SyncIssue> getSyncIssues();
  
  public abstract boolean hasSyncIssue(@NotNull EvalIssueReporter.Type paramType);
  
  @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3)
  public static final class DefaultImpls
  {
    @NotNull
    public static SyncIssue reportError(@NotNull SyncIssueHandler $this, @NotNull EvalIssueReporter.Type type, String msg)
    {
      Intrinsics.checkParameterIsNotNull(type, "type");
      Intrinsics.checkParameterIsNotNull(msg, "msg");
      return EvalIssueReporter.DefaultImpls.reportError((EvalIssueReporter)$this, type, msg);
    }
    
    @NotNull
    public static SyncIssue reportError(@NotNull SyncIssueHandler $this, @NotNull EvalIssueReporter.Type type, @Nullable String msg, String data)
    {
      Intrinsics.checkParameterIsNotNull(type, "type");
      Intrinsics.checkParameterIsNotNull(msg, "msg");
      return EvalIssueReporter.DefaultImpls.reportError((EvalIssueReporter)$this, type, msg, data);
    }
    
    @NotNull
    public static SyncIssue reportIssue(@NotNull SyncIssueHandler $this, @NotNull EvalIssueReporter.Type type, @NotNull EvalIssueReporter.Severity severity, String msg)
    {
      Intrinsics.checkParameterIsNotNull(type, "type");
      Intrinsics.checkParameterIsNotNull(severity, "severity");
      Intrinsics.checkParameterIsNotNull(msg, "msg");
      return EvalIssueReporter.DefaultImpls.reportIssue((EvalIssueReporter)$this, type, severity, msg);
    }
    
    @NotNull
    public static SyncIssue reportWarning(@NotNull SyncIssueHandler $this, @NotNull EvalIssueReporter.Type type, String msg)
    {
      Intrinsics.checkParameterIsNotNull(type, "type");
      Intrinsics.checkParameterIsNotNull(msg, "msg");
      return EvalIssueReporter.DefaultImpls.reportWarning((EvalIssueReporter)$this, type, msg);
    }
    
    @NotNull
    public static SyncIssue reportWarning(@NotNull SyncIssueHandler $this, @NotNull EvalIssueReporter.Type type, @Nullable String msg, String data)
    {
      Intrinsics.checkParameterIsNotNull(type, "type");
      Intrinsics.checkParameterIsNotNull(msg, "msg");
      return EvalIssueReporter.DefaultImpls.reportWarning((EvalIssueReporter)$this, type, msg, data);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.errors.SyncIssueHandler
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */