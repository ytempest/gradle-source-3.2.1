/*    */ package com.android.build.gradle.internal.api.dsl.extensions;
/*    */ 
/*    */ import com.android.build.api.dsl.extension.OnDeviceTestProperties;
/*    */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*    */ import com.android.builder.errors.EvalIssueReporter;
/*    */ import com.android.builder.model.AdbOptions;
/*    */ import com.android.builder.testing.api.DeviceProvider;
/*    */ import com.android.builder.testing.api.TestServer;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.NotImplementedError;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.gradle.api.Action;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000>\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020!\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\030\0002\0020\0012\0020\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005J\026\020\006\032\0020\0262\f\020\027\032\b\022\004\022\0020\0070\030H\026R\024\020\006\032\0020\0078VX\004¢\006\006\032\004\b\b\020\tR0\020\r\032\b\022\004\022\0020\f0\0132\f\020\n\032\b\022\004\022\0020\f0\0138V@VX\016¢\006\f\032\004\b\016\020\017\"\004\b\020\020\021R0\020\023\032\b\022\004\022\0020\0220\0132\f\020\n\032\b\022\004\022\0020\0220\0138V@VX\016¢\006\f\032\004\b\024\020\017\"\004\b\025\020\021¨\006\031"}, d2={"Lcom/android/build/gradle/internal/api/dsl/extensions/OnDeviceTestPropertiesImpl;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/dsl/extension/OnDeviceTestProperties;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "adbOptions", "Lcom/android/builder/model/AdbOptions;", "getAdbOptions", "()Lcom/android/builder/model/AdbOptions;", "value", "", "Lcom/android/builder/testing/api/DeviceProvider;", "deviceProviders", "getDeviceProviders", "()Ljava/util/List;", "setDeviceProviders", "(Ljava/util/List;)V", "Lcom/android/builder/testing/api/TestServer;", "testServers", "getTestServers", "setTestServers", "", "action", "Lorg/gradle/api/Action;", "gradle-core"})
/*    */ public final class OnDeviceTestPropertiesImpl
/*    */   extends SealableObject
/*    */   implements OnDeviceTestProperties
/*    */ {
/* 28 */   public OnDeviceTestPropertiesImpl(@NotNull EvalIssueReporter issueReporter) { super(issueReporter); }
/*    */   
/*    */   @NotNull
/* 31 */   public AdbOptions getAdbOptions() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/* 34 */   public void adbOptions(@NotNull Action<AdbOptions> action) { Intrinsics.checkParameterIsNotNull(action, "action");String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str));
/*    */   }
/*    */   
/*    */   @NotNull
/* 38 */   public List<DeviceProvider> getDeviceProviders() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str)); }
/* 39 */   public void setDeviceProviders(@NotNull List<DeviceProvider> value) { Intrinsics.checkParameterIsNotNull(value, "value"); }
/*    */   @NotNull
/* 41 */   public List<TestServer> getTestServers() { String str = "not implemented";throw ((Throwable)new NotImplementedError("An operation is not implemented: " + str)); }
/* 42 */   public void setTestServers(@NotNull List<TestServer> value) { Intrinsics.checkParameterIsNotNull(value, "value"); }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.extensions.OnDeviceTestPropertiesImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */