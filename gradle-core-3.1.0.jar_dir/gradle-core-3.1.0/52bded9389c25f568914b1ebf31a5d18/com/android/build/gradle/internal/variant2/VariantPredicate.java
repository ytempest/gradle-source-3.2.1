/*     */ package com.android.build.gradle.internal.variant2;
/*     */ 
/*     */ import com.android.build.api.dsl.variant.Variant;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import com.android.builder.errors.EvalIssueReporter.Type;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.collections.CollectionsKt;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000>\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\002\b\002\n\002\020 \n\002\b\t\n\002\020\013\n\000\n\002\030\002\n\002\b\023\n\002\020\b\n\002\b\002\b\b\030\0002\0020\001B\017\b\020\022\006\020\002\032\0020\003¢\006\002\020\004B?\022\b\020\005\032\004\030\0010\006\022\f\020\007\032\b\022\002\b\003\030\0010\b\022\b\020\t\032\004\030\0010\006\022\016\020\n\032\n\022\004\022\0020\006\030\0010\013\022\006\020\002\032\0020\003¢\006\002\020\fJ\016\020\024\032\0020\0252\006\020\026\032\0020\027J\025\020\030\032\0020\0002\006\020\t\032\0020\006H\000¢\006\002\b\031J\031\020\032\032\0020\0002\n\020\033\032\006\022\002\b\0030\bH\000¢\006\002\b\034J\025\020\035\032\0020\0002\006\020\036\032\0020\006H\000¢\006\002\b\037J\025\020 \032\0020\0002\006\020\005\032\0020\006H\000¢\006\002\b!J\013\020\"\032\004\030\0010\006HÆ\003J\017\020#\032\b\022\002\b\003\030\0010\bHÆ\003J\013\020$\032\004\030\0010\006HÆ\003J\021\020%\032\n\022\004\022\0020\006\030\0010\013HÆ\003J\t\020&\032\0020\003HÂ\003JM\020'\032\0020\0002\n\b\002\020\005\032\004\030\0010\0062\016\b\002\020\007\032\b\022\002\b\003\030\0010\b2\n\b\002\020\t\032\004\030\0010\0062\020\b\002\020\n\032\n\022\004\022\0020\006\030\0010\0132\b\b\002\020\002\032\0020\003HÆ\001J\023\020(\032\0020\0252\b\020)\032\004\030\0010\001HÖ\003J\t\020*\032\0020+HÖ\001J\t\020,\032\0020\006HÖ\001R\023\020\t\032\004\030\0010\006¢\006\b\n\000\032\004\b\r\020\016R\031\020\n\032\n\022\004\022\0020\006\030\0010\013¢\006\b\n\000\032\004\b\017\020\020R\016\020\002\032\0020\003X\004¢\006\002\n\000R\023\020\005\032\004\030\0010\006¢\006\b\n\000\032\004\b\021\020\016R\027\020\007\032\b\022\002\b\003\030\0010\b¢\006\b\n\000\032\004\b\022\020\023¨\006-"}, d2={"Lcom/android/build/gradle/internal/variant2/VariantPredicate;", "", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Lcom/android/builder/errors/EvalIssueReporter;)V", "name", "", "theClass", "Ljava/lang/Class;", "buildTypeName", "flavorNames", "", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/util/List;Lcom/android/builder/errors/EvalIssueReporter;)V", "getBuildTypeName", "()Ljava/lang/String;", "getFlavorNames", "()Ljava/util/List;", "getName", "getTheClass", "()Ljava/lang/Class;", "accept", "", "variant", "Lcom/android/build/api/dsl/variant/Variant;", "cloneWithBuildType", "cloneWithBuildType$gradle_core", "cloneWithClass", "variantClass", "cloneWithClass$gradle_core", "cloneWithFlavor", "flavorName", "cloneWithFlavor$gradle_core", "cloneWithName", "cloneWithName$gradle_core", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "gradle-core"})
/*     */ public final class VariantPredicate
/*     */ {
/*     */   @Nullable
/*     */   private final String name;
/*     */   @Nullable
/*     */   private final Class<?> theClass;
/*     */   @Nullable
/*     */   private final String buildTypeName;
/*     */   @Nullable
/*     */   private final List<String> flavorNames;
/*     */   private final EvalIssueReporter issueReporter;
/*     */   
/*     */   public VariantPredicate(@Nullable String name, @Nullable Class<?> theClass, @Nullable String buildTypeName, @Nullable List<String> flavorNames, @NotNull EvalIssueReporter issueReporter)
/*     */   {
/*  94 */     this.name = name;this.theClass = theClass;this.buildTypeName = buildTypeName;this.flavorNames = flavorNames;this.issueReporter = issueReporter; } @Nullable
/*  95 */   public final String getName() { return name; } @Nullable
/*  96 */   public final Class<?> getTheClass() { return theClass; } @Nullable
/*  97 */   public final String getBuildTypeName() { return buildTypeName; } @Nullable
/*  98 */   public final List<String> getFlavorNames() { return flavorNames; }
/*     */   
/* 101 */   public VariantPredicate(@NotNull EvalIssueReporter issueReporter) { this(null, null, null, null, issueReporter); }
/*     */   
/*     */   public final boolean accept(@NotNull Variant variant) {
/* 104 */     Intrinsics.checkParameterIsNotNull(variant, "variant"); if ((name != null) && ((Intrinsics.areEqual(variant.getName(), name) ^ true))) {
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     if ((theClass != null) && (!theClass.isInstance(variant))) {
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     if ((buildTypeName != null) && ((Intrinsics.areEqual(variant.getBuildTypeName(), buildTypeName) ^ true))) {
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     if (flavorNames != null) { Collection localCollection = (Collection)flavorNames; if ((!localCollection.isEmpty() ? 1 : 0) != 0) if (!variant.getFlavorNames().containsAll((Collection)flavorNames)) {
/* 117 */           return false;
/*     */         }
/*     */     }
/* 120 */     return true;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final VariantPredicate cloneWithName$gradle_core(@NotNull String name)
/*     */   {
/* 127 */     Intrinsics.checkParameterIsNotNull(name, "name"); if (this.name != null) {
/* 128 */       issueReporter.reportError(
/* 129 */         EvalIssueReporter.Type.GENERIC, "Already filtered on variant name");
/*     */     }
/*     */     
/* 132 */     return new VariantPredicate(
/* 133 */       name, 
/* 134 */       theClass, 
/* 135 */       buildTypeName, 
/* 136 */       flavorNames, 
/* 137 */       issueReporter);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final VariantPredicate cloneWithClass$gradle_core(@NotNull Class<?> variantClass)
/*     */   {
/* 144 */     Intrinsics.checkParameterIsNotNull(variantClass, "variantClass"); if (theClass != null) {
/* 145 */       issueReporter.reportError(
/* 146 */         EvalIssueReporter.Type.GENERIC, "Already filtered on variant type");
/*     */     }
/*     */     
/* 149 */     return new VariantPredicate(
/* 150 */       name, 
/* 151 */       variantClass, 
/* 152 */       buildTypeName, 
/* 153 */       flavorNames, 
/* 154 */       issueReporter);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final VariantPredicate cloneWithBuildType$gradle_core(@NotNull String buildTypeName)
/*     */   {
/* 162 */     Intrinsics.checkParameterIsNotNull(buildTypeName, "buildTypeName"); if (this.buildTypeName != null) {
/* 163 */       issueReporter.reportError(
/* 164 */         EvalIssueReporter.Type.GENERIC, "Already filtered on build type name");
/*     */     }
/*     */     
/* 167 */     return new VariantPredicate(
/* 168 */       name, 
/* 169 */       theClass, 
/* 170 */       buildTypeName, 
/* 171 */       flavorNames, 
/* 172 */       issueReporter);
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final VariantPredicate cloneWithFlavor$gradle_core(@NotNull String flavorName)
/*     */   {
/* 180 */     Intrinsics.checkParameterIsNotNull(flavorName, "flavorName"); if ((flavorNames == null) || (flavorNames.isEmpty())) {
/* 181 */       return new VariantPredicate(
/* 182 */         name, 
/* 183 */         theClass, 
/* 184 */         buildTypeName, 
/* 185 */         CollectionsKt.listOf(flavorName), 
/* 186 */         issueReporter);
/*     */     }
/*     */     
/* 191 */     ArrayList flavors = new ArrayList((Collection)flavorNames);
/* 192 */     flavors.add(flavorName);
/*     */     
/* 194 */     return new VariantPredicate(
/* 195 */       name, 
/* 196 */       theClass, 
/* 197 */       buildTypeName, 
/* 198 */       (List)flavors, 
/* 199 */       issueReporter);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public final String component1()
/*     */   {
/*     */     return name;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public final Class<?> component2()
/*     */   {
/*     */     return theClass;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public final String component3()
/*     */   {
/*     */     return buildTypeName;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public final List<String> component4()
/*     */   {
/*     */     return flavorNames;
/*     */   }
/*     */   
/*     */   private final EvalIssueReporter component5()
/*     */   {
/*     */     return issueReporter;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public final VariantPredicate copy(@Nullable String name, @Nullable Class<?> theClass, @Nullable String buildTypeName, @Nullable List<String> flavorNames, @NotNull EvalIssueReporter issueReporter)
/*     */   {
/*     */     Intrinsics.checkParameterIsNotNull(issueReporter, "issueReporter");
/*     */     return new VariantPredicate(name, theClass, buildTypeName, flavorNames, issueReporter);
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/*     */     return "VariantPredicate(name=" + name + ", theClass=" + theClass + ", buildTypeName=" + buildTypeName + ", flavorNames=" + flavorNames + ", issueReporter=" + issueReporter + ")";
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public int hashCode()
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 19	com/android/build/gradle/internal/variant2/VariantPredicate:name	Ljava/lang/String;
/*     */     //   4: dup
/*     */     //   5: ifnull +9 -> 14
/*     */     //   8: invokevirtual 174	java/lang/Object:hashCode	()I
/*     */     //   11: goto +5 -> 16
/*     */     //   14: pop
/*     */     //   15: iconst_0
/*     */     //   16: bipush 31
/*     */     //   18: imul
/*     */     //   19: aload_0
/*     */     //   20: getfield 33	com/android/build/gradle/internal/variant2/VariantPredicate:theClass	Ljava/lang/Class;
/*     */     //   23: dup
/*     */     //   24: ifnull +9 -> 33
/*     */     //   27: invokevirtual 174	java/lang/Object:hashCode	()I
/*     */     //   30: goto +5 -> 35
/*     */     //   33: pop
/*     */     //   34: iconst_0
/*     */     //   35: iadd
/*     */     //   36: bipush 31
/*     */     //   38: imul
/*     */     //   39: aload_0
/*     */     //   40: getfield 42	com/android/build/gradle/internal/variant2/VariantPredicate:buildTypeName	Ljava/lang/String;
/*     */     //   43: dup
/*     */     //   44: ifnull +9 -> 53
/*     */     //   47: invokevirtual 174	java/lang/Object:hashCode	()I
/*     */     //   50: goto +5 -> 55
/*     */     //   53: pop
/*     */     //   54: iconst_0
/*     */     //   55: iadd
/*     */     //   56: bipush 31
/*     */     //   58: imul
/*     */     //   59: aload_0
/*     */     //   60: getfield 49	com/android/build/gradle/internal/variant2/VariantPredicate:flavorNames	Ljava/util/List;
/*     */     //   63: dup
/*     */     //   64: ifnull +9 -> 73
/*     */     //   67: invokevirtual 174	java/lang/Object:hashCode	()I
/*     */     //   70: goto +5 -> 75
/*     */     //   73: pop
/*     */     //   74: iconst_0
/*     */     //   75: iadd
/*     */     //   76: bipush 31
/*     */     //   78: imul
/*     */     //   79: aload_0
/*     */     //   80: getfield 75	com/android/build/gradle/internal/variant2/VariantPredicate:issueReporter	Lcom/android/builder/errors/EvalIssueReporter;
/*     */     //   83: dup
/*     */     //   84: ifnull +9 -> 93
/*     */     //   87: invokevirtual 174	java/lang/Object:hashCode	()I
/*     */     //   90: goto +5 -> 95
/*     */     //   93: pop
/*     */     //   94: iconst_0
/*     */     //   95: iadd
/*     */     //   96: ireturn
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/*     */     if (this != paramObject)
/*     */     {
/*     */       if ((paramObject instanceof VariantPredicate))
/*     */       {
/*     */         VariantPredicate localVariantPredicate = (VariantPredicate)paramObject;
/*     */         if ((!Intrinsics.areEqual(name, name)) || (!Intrinsics.areEqual(theClass, theClass)) || (!Intrinsics.areEqual(buildTypeName, buildTypeName)) || (!Intrinsics.areEqual(flavorNames, flavorNames)) || (!Intrinsics.areEqual(issueReporter, issueReporter))) {}
/*     */       }
/*     */     }
/*     */     else {
/*     */       return true;
/*     */     }
/*     */     return false;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.VariantPredicate
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */