/*    */ package com.android.build.gradle.internal.variant2;
/*    */ 
/*    */ import com.android.build.api.sourcesets.AndroidSourceSet;
/*    */ import com.android.builder.core.VariantType;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000$\n\002\030\002\n\000\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\006\n\002\030\002\n\000\030\000*\006\b\000\020\001 \0012\0020\002B1\022\006\020\003\032\0028\000\022\006\020\004\032\0020\005\022\b\020\006\032\004\030\0010\005\022\b\020\007\032\004\030\0010\005\022\006\020\b\032\0020\t¢\006\002\020\nJ\020\020\016\032\004\030\0010\0052\006\020\017\032\0020\020R\020\020\006\032\004\030\0010\005X\004¢\006\002\n\000R\023\020\003\032\0028\000¢\006\n\n\002\020\r\032\004\b\013\020\fR\016\020\004\032\0020\005X\004¢\006\002\n\000R\020\020\007\032\004\030\0010\005X\004¢\006\002\n\000¨\006\021"}, d2={"Lcom/android/build/gradle/internal/variant2/DimensionData;", "T", "", "dimensionObject", "sourceSet", "Lcom/android/build/api/sourcesets/AndroidSourceSet;", "androidTestSourceSet", "unitTestSourceSet", "configurationContainer", "Lorg/gradle/api/artifacts/ConfigurationContainer;", "(Ljava/lang/Object;Lcom/android/build/api/sourcesets/AndroidSourceSet;Lcom/android/build/api/sourcesets/AndroidSourceSet;Lcom/android/build/api/sourcesets/AndroidSourceSet;Lorg/gradle/api/artifacts/ConfigurationContainer;)V", "getDimensionObject", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSourceSet", "type", "Lcom/android/builder/core/VariantType;", "gradle-core"})
/*    */ public final class DimensionData<T>
/*    */ {
/*    */   private final T dimensionObject;
/*    */   private final AndroidSourceSet sourceSet;
/*    */   private final AndroidSourceSet androidTestSourceSet;
/*    */   private final AndroidSourceSet unitTestSourceSet;
/*    */   
/*    */   /* Error */
/*    */   public DimensionData(T dimensionObject, @NotNull AndroidSourceSet sourceSet, @Nullable AndroidSourceSet androidTestSourceSet, @Nullable AndroidSourceSet unitTestSourceSet, @NotNull org.gradle.api.artifacts.ConfigurationContainer configurationContainer)
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_2
/*    */     //   1: ldc 54
/*    */     //   3: invokestatic 17	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   6: aload 5
/*    */     //   8: ldc 56
/*    */     //   10: invokestatic 17	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
/*    */     //   13: aload_0
/*    */     //   14: invokespecial 59	java/lang/Object:<init>	()V
/*    */     //   17: aload_0
/*    */     //   18: aload_1
/*    */     //   19: putfield 51	com/android/build/gradle/internal/variant2/DimensionData:dimensionObject	Ljava/lang/Object;
/*    */     //   22: aload_0
/*    */     //   23: aload_2
/*    */     //   24: putfield 39	com/android/build/gradle/internal/variant2/DimensionData:sourceSet	Lcom/android/build/api/sourcesets/AndroidSourceSet;
/*    */     //   27: aload_0
/*    */     //   28: aload_3
/*    */     //   29: putfield 33	com/android/build/gradle/internal/variant2/DimensionData:androidTestSourceSet	Lcom/android/build/api/sourcesets/AndroidSourceSet;
/*    */     //   32: aload_0
/*    */     //   33: aload 4
/*    */     //   35: putfield 36	com/android/build/gradle/internal/variant2/DimensionData:unitTestSourceSet	Lcom/android/build/api/sourcesets/AndroidSourceSet;
/*    */     //   38: aload_0
/*    */     //   39: getfield 33	com/android/build/gradle/internal/variant2/DimensionData:androidTestSourceSet	Lcom/android/build/api/sourcesets/AndroidSourceSet;
/*    */     //   42: dup
/*    */     //   43: ifnull +24 -> 67
/*    */     //   46: astore 6
/*    */     //   48: aload 6
/*    */     //   50: astore 7
/*    */     //   52: aload_0
/*    */     //   53: getfield 39	com/android/build/gradle/internal/variant2/DimensionData:sourceSet	Lcom/android/build/api/sourcesets/AndroidSourceSet;
/*    */     //   56: aload 7
/*    */     //   58: aload 5
/*    */     //   60: invokestatic 65	com/android/build/gradle/internal/variant2/DimensionDataKt:access$makeTestExtendMain	(Lcom/android/build/api/sourcesets/AndroidSourceSet;Lcom/android/build/api/sourcesets/AndroidSourceSet;Lorg/gradle/api/artifacts/ConfigurationContainer;)V
/*    */     //   63: nop
/*    */     //   64: goto +4 -> 68
/*    */     //   67: pop
/*    */     //   68: aload_0
/*    */     //   69: getfield 36	com/android/build/gradle/internal/variant2/DimensionData:unitTestSourceSet	Lcom/android/build/api/sourcesets/AndroidSourceSet;
/*    */     //   72: dup
/*    */     //   73: ifnull +24 -> 97
/*    */     //   76: astore 6
/*    */     //   78: aload 6
/*    */     //   80: astore 7
/*    */     //   82: aload_0
/*    */     //   83: getfield 39	com/android/build/gradle/internal/variant2/DimensionData:sourceSet	Lcom/android/build/api/sourcesets/AndroidSourceSet;
/*    */     //   86: aload 7
/*    */     //   88: aload 5
/*    */     //   90: invokestatic 65	com/android/build/gradle/internal/variant2/DimensionDataKt:access$makeTestExtendMain	(Lcom/android/build/api/sourcesets/AndroidSourceSet;Lcom/android/build/api/sourcesets/AndroidSourceSet;Lorg/gradle/api/artifacts/ConfigurationContainer;)V
/*    */     //   93: nop
/*    */     //   94: goto +4 -> 98
/*    */     //   97: pop
/*    */     //   98: return
/*    */     // Line number table:
/*    */     //   Java source line #27	-> byte code offset #13
/*    */     //   Java source line #35	-> byte code offset #38
/*    */     //   Java source line #36	-> byte code offset #52
/*    */     //   Java source line #37	-> byte code offset #63
/*    */     //   Java source line #35	-> byte code offset #64
/*    */     //   Java source line #39	-> byte code offset #68
/*    */     //   Java source line #40	-> byte code offset #82
/*    */     //   Java source line #41	-> byte code offset #93
/*    */     //   Java source line #39	-> byte code offset #94
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	99	0	this	DimensionData
/*    */     //   0	99	1	dimensionObject	Object
/*    */     //   0	99	2	sourceSet	AndroidSourceSet
/*    */     //   0	99	3	androidTestSourceSet	AndroidSourceSet
/*    */     //   0	99	4	unitTestSourceSet	AndroidSourceSet
/*    */     //   0	99	5	configurationContainer	org.gradle.api.artifacts.ConfigurationContainer
/*    */     //   52	11	7	it	AndroidSourceSet
/*    */     //   82	11	7	it	AndroidSourceSet
/*    */     //   52	11	8	$i$a$1$let	int
/*    */     //   82	11	8	$i$a$2$let	int
/*    */   }
/*    */   
/*    */   public final T getDimensionObject()
/*    */   {
/* 28 */     return (T)dimensionObject;
/*    */   }
/*    */   
/*    */   @Nullable
/*    */   public final AndroidSourceSet getSourceSet(@NotNull VariantType type)
/*    */   {
/* 44 */     Intrinsics.checkParameterIsNotNull(type, "type"); switch (DimensionData.WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
/*    */     case 1: 
/*    */       break;
/*    */     case 2:  break; }
/* 48 */     return sourceSet;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.DimensionData
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */