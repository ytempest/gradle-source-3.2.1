/*     */ package com.android.build.gradle.internal.scope;
/*     */ 
/*     */ import com.android.ide.common.build.ApkInfo;
/*     */ import java.io.File;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000,\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\t\n\002\020\013\n\002\b\002\n\002\020\b\n\000\n\002\020\016\n\000\b\b\030\0002\0020\001B\027\022\006\020\002\032\0020\003\022\b\020\004\032\004\030\0010\005¢\006\002\020\006J\t\020\013\032\0020\003HÆ\003J\013\020\f\032\004\030\0010\005HÆ\003J\037\020\r\032\0020\0002\b\b\002\020\002\032\0020\0032\n\b\002\020\004\032\004\030\0010\005HÆ\001J\023\020\016\032\0020\0172\b\020\020\032\004\030\0010\001HÖ\003J\t\020\021\032\0020\022HÖ\001J\t\020\023\032\0020\024HÖ\001R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\007\020\bR\023\020\004\032\004\030\0010\005¢\006\b\n\000\032\004\b\t\020\n¨\006\025"}, d2={"Lcom/android/build/gradle/internal/scope/BuildElements$ActionItem;", "", "apkInfo", "Lcom/android/ide/common/build/ApkInfo;", "output", "Ljava/io/File;", "(Lcom/android/ide/common/build/ApkInfo;Ljava/io/File;)V", "getApkInfo", "()Lcom/android/ide/common/build/ApkInfo;", "getOutput", "()Ljava/io/File;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "gradle-core"})
/*     */ public final class BuildElements$ActionItem
/*     */ {
/*     */   @NotNull
/*     */   private final ApkInfo apkInfo;
/*     */   @Nullable
/*     */   private final File output;
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/*     */     if (this != paramObject)
/*     */     {
/*     */       if ((paramObject instanceof ActionItem))
/*     */       {
/*     */         ActionItem localActionItem = (ActionItem)paramObject;
/*     */         if ((!Intrinsics.areEqual(apkInfo, apkInfo)) || (!Intrinsics.areEqual(output, output))) {}
/*     */       }
/*     */     }
/*     */     else {
/*     */       return true;
/*     */     }
/*     */     return false;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public int hashCode()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 11	com/android/build/gradle/internal/scope/BuildElements$ActionItem:apkInfo	Lcom/android/ide/common/build/ApkInfo;
/*     */     //   4: dup
/*     */     //   5: ifnull +9 -> 14
/*     */     //   8: invokevirtual 66	java/lang/Object:hashCode	()I
/*     */     //   11: goto +5 -> 16
/*     */     //   14: pop
/*     */     //   15: iconst_0
/*     */     //   16: bipush 31
/*     */     //   18: imul
/*     */     //   19: aload_0
/*     */     //   20: getfield 20	com/android/build/gradle/internal/scope/BuildElements$ActionItem:output	Ljava/io/File;
/*     */     //   23: dup
/*     */     //   24: ifnull +9 -> 33
/*     */     //   27: invokevirtual 66	java/lang/Object:hashCode	()I
/*     */     //   30: goto +5 -> 35
/*     */     //   33: pop
/*     */     //   34: iconst_0
/*     */     //   35: iadd
/*     */     //   36: ireturn
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/*     */     return "ActionItem(apkInfo=" + apkInfo + ", output=" + output + ")";
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final ActionItem copy(@NotNull ApkInfo apkInfo, @Nullable File output)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(apkInfo, "apkInfo");
/*     */     return new ActionItem(apkInfo, output);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public final File component2()
/*     */   {
/*     */     return output;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final ApkInfo component1()
/*     */   {
/*     */     return apkInfo;
/*     */   }
/*     */   
/*     */   public BuildElements$ActionItem(@NotNull ApkInfo apkInfo, @Nullable File output)
/*     */   {
/* 143 */     this.apkInfo = apkInfo;this.output = output; } @Nullable
/* 143 */   public final File getOutput() { return output; } @NotNull
/* 143 */   public final ApkInfo getApkInfo() { return apkInfo; }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.scope.BuildElements.ActionItem
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */