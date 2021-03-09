/*     */ package com.android.build.gradle.internal.ide;
/*     */ 
/*     */ import com.android.builder.errors.EvalIssueReporter.Severity;
/*     */ import com.android.builder.errors.EvalIssueReporter.Type;
/*     */ import com.android.builder.model.SyncIssue;
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ 
/*     */ public final class SyncIssueImpl
/*     */   implements SyncIssue, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final int type;
/*     */   private final int severity;
/*     */   private final String data;
/*     */   private final String message;
/*     */   private final List<String> multiLineMessage;
/*     */   
/*     */   public SyncIssueImpl(EvalIssueReporter.Type type, EvalIssueReporter.Severity severity, String data, String message)
/*     */   {
/*  49 */     this(type, severity, data, message, null);
/*     */   }
/*     */   
/*     */   public SyncIssueImpl(EvalIssueReporter.Type type, EvalIssueReporter.Severity severity, String data, String message, List<String> multiLineMessage)
/*     */   {
/*  58 */     this.type = type.getType();
/*  59 */     this.severity = severity.getSeverity();
/*  60 */     this.data = data;
/*  61 */     this.message = message;
/*  62 */     this.multiLineMessage = (multiLineMessage == null ? null : 
/*  63 */       ImmutableList.copyOf(multiLineMessage));
/*     */   }
/*     */   
/*     */   public int getSeverity()
/*     */   {
/*  68 */     return severity;
/*     */   }
/*     */   
/*     */   public int getType()
/*     */   {
/*  73 */     return type;
/*     */   }
/*     */   
/*     */   public String getData()
/*     */   {
/*  79 */     return data;
/*     */   }
/*     */   
/*     */   public String getMessage()
/*     */   {
/*  85 */     return message;
/*     */   }
/*     */   
/*     */   public List<String> getMultiLineMessage()
/*     */   {
/*  91 */     return multiLineMessage;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/*  96 */     if (this == o) {
/*  97 */       return true;
/*     */     }
/*  99 */     if ((o == null) || (getClass() != o.getClass())) {
/* 100 */       return false;
/*     */     }
/* 102 */     SyncIssueImpl syncIssue = (SyncIssueImpl)o;
/* 103 */     if ((type == type) && (severity == severity)) {} return 
/*     */     
/* 105 */       (Objects.equals(data, data)) && 
/* 106 */       (Objects.equals(message, message)) && 
/* 107 */       (Objects.equals(multiLineMessage, multiLineMessage));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 112 */     return Objects.hash(new Object[] { Integer.valueOf(type), Integer.valueOf(severity), data, message, multiLineMessage });
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 117 */     return 
/*     */     
/* 122 */       MoreObjects.toStringHelper(this).add("type", type).add("severity", severity).add("data", data).add("message", message).toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ide.SyncIssueImpl
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */