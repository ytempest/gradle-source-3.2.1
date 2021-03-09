package com.android.build.gradle.internal.errors;

import com.android.builder.errors.EvalIssueReporter;
import com.android.builder.errors.EvalIssueReporter.DefaultImpls;
import com.android.builder.errors.EvalIssueReporter.Severity;
import com.android.builder.errors.EvalIssueReporter.Type;
import com.android.builder.model.SyncIssue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=3)
public final class SyncIssueHandler$DefaultImpls
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

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.errors.SyncIssueHandler.DefaultImpls
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */