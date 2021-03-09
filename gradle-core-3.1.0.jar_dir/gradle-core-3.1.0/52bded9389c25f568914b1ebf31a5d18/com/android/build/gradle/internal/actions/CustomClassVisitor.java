/*    */ package com.android.build.gradle.internal.actions;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import org.objectweb.asm.ClassVisitor;
/*    */ import org.objectweb.asm.FieldVisitor;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\0002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020!\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\b\n\000\n\002\020\016\n\002\b\003\n\002\020\000\n\000\030\0002\0020\001B\005¢\006\002\020\002J:\020\b\032\004\030\0010\t2\006\020\n\032\0020\0132\b\020\f\032\004\030\0010\r2\b\020\016\032\004\030\0010\r2\b\020\017\032\004\030\0010\r2\b\020\020\032\004\030\0010\021H\026R\027\020\003\032\b\022\004\022\0020\0050\004¢\006\b\n\000\032\004\b\006\020\007¨\006\022"}, d2={"Lcom/android/build/gradle/internal/actions/CustomClassVisitor;", "Lorg/objectweb/asm/ClassVisitor;", "()V", "attributes", "", "Lcom/android/build/gradle/internal/actions/AttributeValue;", "getAttributes", "()Ljava/util/List;", "visitField", "Lorg/objectweb/asm/FieldVisitor;", "access", "", "name", "", "desc", "signature", "value", "", "gradle-core"})
/*    */ public final class CustomClassVisitor
/*    */   extends ClassVisitor
/*    */ {
/*    */   @NotNull
/*    */   private final List<AttributeValue> attributes;
/*    */   
/*    */   @NotNull
/*    */   public final List<AttributeValue> getAttributes()
/*    */   {
/* 70 */     return attributes;
/*    */   }
/*    */   
/*    */   public CustomClassVisitor()
/*    */   {
/* 68 */     super(327680); ArrayList 
/*    */     
/* 70 */       tmp10_7 = Lists.newArrayList();Intrinsics.checkExpressionValueIsNotNull(tmp10_7, "Lists.newArrayList()");attributes = ((List)tmp10_7); }
/*    */   
/*    */   @Nullable
/* 73 */   public FieldVisitor visitField(int access, @Nullable String name, @Nullable String desc, @Nullable String signature, @Nullable Object value) { if ((value instanceof Integer)) {
/* 74 */       String tmp17_16 = name;
/*    */       
/* 74 */       if (tmp17_16 == null) Intrinsics.throwNpe(); attributes.add(new AttributeValue(tmp17_16, ((Number)value).intValue()));
/*    */     }
/* 76 */     return null;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.actions.CustomClassVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */