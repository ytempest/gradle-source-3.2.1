/*    */ package com.android.build.gradle.internal.errors;
/*    */ 
/*    */ import com.android.ide.common.blame.Message;
/*    */ import com.android.ide.common.blame.SourceFilePosition;
/*    */ import com.google.common.base.Joiner;
/*    */ import com.google.common.base.Optional;
/*    */ import com.google.common.collect.Iterables;
/*    */ import java.util.List;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.jvm.internal.Intrinsics;
/*    */ import kotlin.text.StringsKt;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=2, d1={"\000\016\n\000\n\002\020\016\n\000\n\002\030\002\n\000\032\020\020\000\032\0020\0012\006\020\002\032\0020\003H\002¨\006\004"}, d2={"humanReadableMessage", "", "message", "Lcom/android/ide/common/blame/Message;", "gradle-core"})
/*    */ public final class MessageReceiverImplKt
/*    */ {
/*    */   private static final String humanReadableMessage(Message message)
/*    */   {
/* 80 */     StringBuilder errorStringBuilder = new StringBuilder();
/* 81 */     List positions = message.getSourceFilePositions();
/* 82 */     if ((positions.size() != 1) || ((Intrinsics.areEqual(SourceFilePosition.UNKNOWN, (SourceFilePosition)Iterables.getOnlyElement((Iterable)positions)) ^ true))) {
/* 83 */       errorStringBuilder.append(Joiner.on(' ').join((Iterable)positions));
/*    */     }
/* 85 */     CharSequence localCharSequence = (CharSequence)errorStringBuilder; if ((localCharSequence.length() > 0 ? 1 : 0) != 0) {
/* 86 */       errorStringBuilder.append(": ");
/*    */     }
/* 88 */     Optional tmp94_91 = message.getToolName();Intrinsics.checkExpressionValueIsNotNull(tmp94_91, "message.toolName"); if (tmp94_91.isPresent()) {
/* 89 */       errorStringBuilder.append((String)message.getToolName().get()).append(": ");
/*    */     }
/* 91 */     errorStringBuilder.append(message.getText());
/*    */     
/* 93 */     String rawMessage = message.getRawMessage();
/* 94 */     if ((Intrinsics.areEqual(message.getText(), message.getRawMessage()) ^ true)) {
/* 95 */       String separator = System.lineSeparator(); String 
/*    */       
/* 97 */         tmp168_167 = rawMessage;Intrinsics.checkExpressionValueIsNotNull(tmp168_167, "rawMessage"); String tmp176_174 = separator;Intrinsics.checkExpressionValueIsNotNull(tmp176_174, "separator");errorStringBuilder.append("\n    ").append(StringsKt.replace$default(tmp168_167, tmp176_174, separator + "    ", false, 4, null));
/*    */     }
/* 99 */     String tmp216_213 = errorStringBuilder.toString();Intrinsics.checkExpressionValueIsNotNull(tmp216_213, "errorStringBuilder.toString()");return tmp216_213;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.errors.MessageReceiverImplKt
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */