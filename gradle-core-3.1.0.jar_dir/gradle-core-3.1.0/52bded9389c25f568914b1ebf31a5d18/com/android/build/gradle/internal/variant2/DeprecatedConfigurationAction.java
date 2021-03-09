/*     */ package com.android.build.gradle.internal.variant2;
/*     */ 
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter;
/*     */ import com.android.build.gradle.internal.errors.DeprecationReporter.DeprecationTarget;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.Action;
/*     */ import org.gradle.api.artifacts.Dependency;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\002\b\002\030\0002\b\022\004\022\0020\0020\001B'\022\006\020\003\032\0020\004\022\006\020\005\032\0020\004\022\006\020\006\032\0020\007\022\b\b\002\020\b\032\0020\t¢\006\002\020\nJ\020\020\r\032\0020\0162\006\020\017\032\0020\002H\026R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\013\032\0020\fX\016¢\006\002\n\000¨\006\020"}, d2={"Lcom/android/build/gradle/internal/variant2/DeprecatedConfigurationAction;", "Lorg/gradle/api/Action;", "Lorg/gradle/api/artifacts/Dependency;", "replacement", "", "oldName", "deprecationReporter", "Lcom/android/build/gradle/internal/errors/DeprecationReporter;", "deprecationTarget", "Lcom/android/build/gradle/internal/errors/DeprecationReporter$DeprecationTarget;", "(Ljava/lang/String;Ljava/lang/String;Lcom/android/build/gradle/internal/errors/DeprecationReporter;Lcom/android/build/gradle/internal/errors/DeprecationReporter$DeprecationTarget;)V", "warningPrintedAlready", "", "execute", "", "dependency", "gradle-core"})
/*     */ public final class DeprecatedConfigurationAction
/*     */   implements Action<Dependency>
/*     */ {
/*     */   private boolean warningPrintedAlready;
/*     */   private final String replacement;
/*     */   private final String oldName;
/*     */   private final DeprecationReporter deprecationReporter;
/*     */   private final DeprecationReporter.DeprecationTarget deprecationTarget;
/*     */   
/*     */   public DeprecatedConfigurationAction(@NotNull String replacement, @NotNull String oldName, @NotNull DeprecationReporter deprecationReporter, @NotNull DeprecationReporter.DeprecationTarget deprecationTarget)
/*     */   {
/* 501 */     this.replacement = replacement;this.oldName = oldName;this.deprecationReporter = deprecationReporter;this.deprecationTarget = deprecationTarget;
/*     */   }
/*     */   
/*     */   public void execute(@NotNull Dependency dependency)
/*     */   {
/* 509 */     Intrinsics.checkParameterIsNotNull(dependency, "dependency"); if (!warningPrintedAlready) {
/* 510 */       warningPrintedAlready = true;
/* 511 */       deprecationReporter.reportDeprecatedConfiguration(
/* 512 */         replacement, oldName, deprecationTarget);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.DeprecatedConfigurationAction
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */