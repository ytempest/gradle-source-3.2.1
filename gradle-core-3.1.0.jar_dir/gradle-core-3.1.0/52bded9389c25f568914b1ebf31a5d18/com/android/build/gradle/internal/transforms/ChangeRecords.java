/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.api.transform.Status;
/*     */ import com.android.build.api.transform.TransformException;
/*     */ import com.android.utils.FileUtils;
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.ImmutableSet.Builder;
/*     */ import com.google.common.io.Files;
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.StringTokenizer;
/*     */ 
/*     */ public class ChangeRecords
/*     */ {
/*  42 */   Map<String, Status> records = new HashMap();
/*     */   
/*     */   public synchronized void add(Status status, String filePath) {
/*  45 */     records.put(filePath, status);
/*     */   }
/*     */   
/*     */   public synchronized void addAll(ChangeRecords changeRecords)
/*     */   {
/*  55 */     for (Map.Entry<String, Status> changeRecord : records.entrySet()) {
/*  56 */       if (!records.containsKey(changeRecord.getKey())) {
/*  57 */         records.put(changeRecord.getKey(), changeRecord.getValue());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   synchronized Status getChangeFor(String filePath)
/*     */   {
/*  67 */     return (Status)records.get(filePath);
/*     */   }
/*     */   
/*     */   void write(File file)
/*     */     throws IOException
/*     */   {
/*  76 */     Files.createParentDirs(file);
/*  77 */     FileWriter fileWriter = new FileWriter(file);Throwable localThrowable3 = null;
/*  78 */     try { for (Map.Entry<String, Status> record : records.entrySet()) {
/*  79 */         fileWriter.write(String.format("%s,%s", new Object[] { record.getValue(), record.getKey() }));
/*  80 */         fileWriter.write("\n");
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable5)
/*     */     {
/*  77 */       localThrowable3 = localThrowable5;throw localThrowable5;
/*     */     }
/*     */     finally
/*     */     {
/*  82 */       if (fileWriter != null) { if (localThrowable3 != null) try { fileWriter.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else { fileWriter.close();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   synchronized Set<String> getFilesForStatus(Status status)
/*     */   {
/*  91 */     ImmutableSet.Builder<String> builder = ImmutableSet.builder();
/*  92 */     for (String s : records.keySet()) {
/*  93 */       if (getChangeFor(s) == status) {
/*  94 */         builder.add(s);
/*     */       }
/*     */     }
/*  97 */     return builder.build();
/*     */   }
/*     */   
/*     */   public static void process(File incrementalFile, RecordHandler handler)
/*     */     throws IOException, TransformException
/*     */   {
/* 121 */     if (!incrementalFile.isFile()) {
/* 122 */       return;
/*     */     }
/* 124 */     Map<String, Status> changeRecords = loadrecords;
/*     */     
/* 126 */     FileUtils.delete(incrementalFile);
/* 127 */     if (changeRecords.isEmpty()) {
/* 128 */       return;
/*     */     }
/*     */     
/* 131 */     for (Map.Entry<String, Status> changeRecord : changeRecords.entrySet()) {
/* 132 */       handler.handle((String)changeRecord.getKey(), (Status)changeRecord.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   static ChangeRecords load(File file)
/*     */     throws IOException
/*     */   {
/* 141 */     ChangeRecords changeRecords = new ChangeRecords();
/* 142 */     List<String> rawRecords = Files.readLines(file, Charsets.UTF_8);
/* 143 */     for (String rawRecord : rawRecords) {
/* 144 */       StringTokenizer st = new StringTokenizer(rawRecord, ",");
/* 145 */       if (st.countTokens() != 2) {
/* 146 */         throw new IOException("Invalid incremental change record : " + rawRecord);
/*     */       }
/* 148 */       changeRecords.add(Status.valueOf(st.nextToken()), st.nextToken());
/*     */     }
/* 150 */     return changeRecords;
/*     */   }
/*     */   
/*     */   public static abstract interface RecordHandler
/*     */   {
/*     */     public abstract void handle(String paramString, Status paramStatus)
/*     */       throws IOException, TransformException;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.ChangeRecords
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */