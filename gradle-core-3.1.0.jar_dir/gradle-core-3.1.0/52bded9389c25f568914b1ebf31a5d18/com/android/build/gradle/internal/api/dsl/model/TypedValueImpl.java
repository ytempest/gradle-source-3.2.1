/*    */ package com.android.build.gradle.internal.api.dsl.model;
/*    */ 
/*    */ import com.android.build.api.dsl.model.TypedValue;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000&\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\f\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\b\n\002\b\002\b\b\030\0002\0020\001B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003¢\006\002\020\006J\t\020\013\032\0020\003HÆ\003J\t\020\f\032\0020\003HÆ\003J\t\020\r\032\0020\003HÆ\003J'\020\016\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\0032\b\b\002\020\005\032\0020\003HÆ\001J\023\020\017\032\0020\0202\b\020\021\032\004\030\0010\022HÖ\003J\t\020\023\032\0020\024HÖ\001J\t\020\025\032\0020\003HÖ\001R\024\020\004\032\0020\003X\004¢\006\b\n\000\032\004\b\007\020\bR\024\020\002\032\0020\003X\004¢\006\b\n\000\032\004\b\t\020\bR\024\020\005\032\0020\003X\004¢\006\b\n\000\032\004\b\n\020\b¨\006\026"}, d2={"Lcom/android/build/gradle/internal/api/dsl/model/TypedValueImpl;", "Lcom/android/build/api/dsl/model/TypedValue;", "type", "", "name", "value", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getType", "getValue", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "gradle-core"})
/*    */ public final class TypedValueImpl
/*    */   implements TypedValue
/*    */ {
/*    */   @NotNull
/*    */   private final String type;
/*    */   @NotNull
/*    */   private final String name;
/*    */   @NotNull
/*    */   private final String value;
/*    */   
/*    */   public TypedValueImpl(@NotNull String type, @NotNull String name, @NotNull String value)
/*    */   {
/* 21 */     this.type = type;this.name = name;this.value = value; } @NotNull
/* 22 */   public String getType() { return type; } @NotNull
/* 23 */   public String getName() { return name; } @NotNull
/* 24 */   public String getValue() { return value; }
/*    */   
/*    */   @NotNull
/*    */   public final String component1()
/*    */   {
/*    */     return getType();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final String component2()
/*    */   {
/*    */     return getName();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final String component3()
/*    */   {
/*    */     return getValue();
/*    */   }
/*    */   
/*    */   @NotNull
/*    */   public final TypedValueImpl copy(@NotNull String type, @NotNull String name, @NotNull String value)
/*    */   {
/*    */     Intrinsics.checkParameterIsNotNull(type, "type");
/*    */     Intrinsics.checkParameterIsNotNull(name, "name");
/*    */     Intrinsics.checkParameterIsNotNull(value, "value");
/*    */     return new TypedValueImpl(type, name, value);
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/*    */     return "TypedValueImpl(type=" + getType() + ", name=" + getName() + ", value=" + getValue() + ")";
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public int hashCode()
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: invokevirtual 40	com/android/build/gradle/internal/api/dsl/model/TypedValueImpl:getType	()Ljava/lang/String;
/*    */     //   4: dup
/*    */     //   5: ifnull +9 -> 14
/*    */     //   8: invokevirtual 76	java/lang/Object:hashCode	()I
/*    */     //   11: goto +5 -> 16
/*    */     //   14: pop
/*    */     //   15: iconst_0
/*    */     //   16: bipush 31
/*    */     //   18: imul
/*    */     //   19: aload_0
/*    */     //   20: invokevirtual 43	com/android/build/gradle/internal/api/dsl/model/TypedValueImpl:getName	()Ljava/lang/String;
/*    */     //   23: dup
/*    */     //   24: ifnull +9 -> 33
/*    */     //   27: invokevirtual 76	java/lang/Object:hashCode	()I
/*    */     //   30: goto +5 -> 35
/*    */     //   33: pop
/*    */     //   34: iconst_0
/*    */     //   35: iadd
/*    */     //   36: bipush 31
/*    */     //   38: imul
/*    */     //   39: aload_0
/*    */     //   40: invokevirtual 46	com/android/build/gradle/internal/api/dsl/model/TypedValueImpl:getValue	()Ljava/lang/String;
/*    */     //   43: dup
/*    */     //   44: ifnull +9 -> 53
/*    */     //   47: invokevirtual 76	java/lang/Object:hashCode	()I
/*    */     //   50: goto +5 -> 55
/*    */     //   53: pop
/*    */     //   54: iconst_0
/*    */     //   55: iadd
/*    */     //   56: ireturn
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject)
/*    */   {
/*    */     if (this != paramObject)
/*    */     {
/*    */       if ((paramObject instanceof TypedValueImpl))
/*    */       {
/*    */         TypedValueImpl localTypedValueImpl = (TypedValueImpl)paramObject;
/*    */         if ((!Intrinsics.areEqual(getType(), localTypedValueImpl.getType())) || (!Intrinsics.areEqual(getName(), localTypedValueImpl.getName())) || (!Intrinsics.areEqual(getValue(), localTypedValueImpl.getValue()))) {}
/*    */       }
/*    */     }
/*    */     else {
/*    */       return true;
/*    */     }
/*    */     return false;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.dsl.model.TypedValueImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */