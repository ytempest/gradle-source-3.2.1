/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.google.common.base.Splitter;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.function.BiConsumer;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.Unit;
/*     */ import kotlin.jvm.functions.Function1;
/*     */ import kotlin.jvm.functions.Function2;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import kotlin.jvm.internal.Lambda;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ import org.jetbrains.annotations.Nullable;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=2, d1={"\000:\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\002\n\002\020\002\n\000\n\002\020\003\n\000\n\002\030\002\n\000\n\002\030\002\n\002\020 \n\002\030\002\n\000\032\022\020\006\032\004\030\0010\0072\006\020\b\032\0020\007H\002\032H\020\t\032\0020\n2\006\020\013\032\0020\f2\024\020\r\032\020\022\004\022\0020\007\022\006\022\004\030\0010\0070\0162 \020\017\032\034\022\006\022\004\030\0010\007\022\n\022\b\022\004\022\0020\0070\021\022\004\022\0020\n0\020H\002\032@\020\t\032\0020\n2\006\020\013\032\0020\f2\024\020\r\032\020\022\004\022\0020\007\022\006\022\004\030\0010\0070\0162\032\020\017\032\026\022\006\022\004\030\0010\007\022\n\022\b\022\004\022\0020\0070\0210\022\"\026\020\000\032\n \002*\004\030\0010\0010\001X\004¢\006\002\n\000\"\026\020\003\032\n \002*\004\030\0010\0040\004X\004¢\006\002\n\000\"\026\020\005\032\n \002*\004\030\0010\0040\004X\004¢\006\002\n\000¨\006\023"}, d2={"LINE_SPLITTER", "Lcom/google/common/base/Splitter;", "kotlin.jvm.PlatformType", "pattern", "Ljava/util/regex/Pattern;", "pattern2", "checkForData", "", "message", "processDependencyThrowable", "", "throwable", "", "dataExtractor", "Lkotlin/Function1;", "resultConsumer", "Lkotlin/Function2;", "", "Ljava/util/function/BiConsumer;", "gradle-core"})
/*     */ public final class DependencyFailureHandlerKt
/*     */ {
/*  29 */   private static final Pattern pattern = Pattern.compile(".*any matches for ([a-zA-Z0-9:\\-.+]+) .*", 32);
/*  30 */   private static final Pattern pattern2 = Pattern.compile(".*Could not find ([a-zA-Z0-9:\\-.]+)\\..*", 32);
/*  31 */   private static final Splitter LINE_SPLITTER = Splitter.on(System.lineSeparator());
/*     */   
/*     */   public static final void processDependencyThrowable(@NotNull Throwable throwable, @NotNull Function1<? super String, String> dataExtractor, @NotNull BiConsumer<String, List<String>> resultConsumer)
/*     */   {
/*  86 */     Intrinsics.checkParameterIsNotNull(throwable, "throwable");Intrinsics.checkParameterIsNotNull(dataExtractor, "dataExtractor");Intrinsics.checkParameterIsNotNull(resultConsumer, "resultConsumer");processDependencyThrowable(throwable, 
/*  87 */       dataExtractor, 
/*  88 */       (Function2)new Lambda(resultConsumer) { public final void invoke(@Nullable String data, @NotNull List<String> messages) { Intrinsics.checkParameterIsNotNull(messages, "messages");$resultConsumer.accept(data, messages);
/*     */         }
/*     */       });
/*     */   }
/*     */   
/*     */   private static final void processDependencyThrowable(Throwable throwable, Function1<? super String, String> dataExtractor, Function2<? super String, ? super List<String>, Unit> resultConsumer)
/*     */   {
/*  97 */     Throwable cause = throwable;
/*     */     
/* 100 */     List messages = (List)new ArrayList();
/* 101 */     String firstIndent = " > ";
/* 102 */     String allIndent = "";
/*     */     
/* 104 */     String data = (String)null;
/*     */     
/* 106 */     while (cause != null) {
/* 107 */       String message = cause.getMessage();
/* 108 */       if (message != null) {
/* 109 */         ImmutableList lines = ImmutableList.copyOf(LINE_SPLITTER.split((CharSequence)message)); Object 
/*     */         
/* 112 */           tmp66_63 = lines.get(0);Intrinsics.checkExpressionValueIsNotNull(tmp66_63, "lines[0]");data = (String)dataExtractor.invoke(tmp66_63);
/*     */         
/* 114 */         if (data != null) {
/*     */           break;
/*     */         }
/*     */         
/* 119 */         int i = 0;
/* 120 */         int count = lines.size();
/* 121 */         while (i < count) {
/* 122 */           String line = (String)lines.get(i);
/*     */           
/* 125 */           CharSequence localCharSequence = (CharSequence)allIndent; if ((localCharSequence.length() == 0 ? 1 : 0) != 0) { String tmp148_146 = line;Intrinsics.checkExpressionValueIsNotNull(tmp148_146, "line");messages.add(tmp148_146);
/* 126 */           } else if (i == 0) { messages.add(firstIndent + line);
/* 127 */           } else { messages.add(allIndent + line);
/*     */           }
/* 129 */           i++;
/*     */         }
/*     */         
/* 133 */         firstIndent = allIndent + firstIndent;
/* 134 */         allIndent = allIndent + "   ";
/*     */       }
/*     */       
/* 137 */       cause = cause.getCause();
/*     */     }
/*     */     
/* 140 */     resultConsumer.invoke(data, messages);
/*     */   }
/*     */   
/*     */   private static final String checkForData(String message) {
/* 144 */     Matcher m = pattern.matcher((CharSequence)message);
/* 145 */     if (m.matches()) {
/* 146 */       return m.group(1);
/*     */     }
/*     */     
/* 149 */     m = pattern2.matcher((CharSequence)message);
/* 150 */     if (m.matches()) {
/* 151 */       return m.group(1);
/*     */     }
/*     */     
/* 154 */     return null;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.DependencyFailureHandlerKt
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */