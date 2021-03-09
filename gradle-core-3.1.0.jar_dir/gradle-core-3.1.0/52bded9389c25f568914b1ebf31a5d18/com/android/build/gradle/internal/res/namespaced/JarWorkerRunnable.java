/*    */ package com.android.build.gradle.internal.res.namespaced;
/*    */ 
/*    */ import com.android.builder.packaging.JarMerger;
/*    */ import java.io.Closeable;
/*    */ import java.io.File;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import javax.inject.Inject;
/*    */ import kotlin.Metadata;
/*    */ import kotlin.Unit;
/*    */ import org.jetbrains.annotations.NotNull;
/*    */ 
/*    */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\030\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\000\030\0002\0020\001B\017\b\007\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\007\032\0020\bH\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\t"}, d2={"Lcom/android/build/gradle/internal/res/namespaced/JarWorkerRunnable;", "Ljava/lang/Runnable;", "params", "Lcom/android/build/gradle/internal/res/namespaced/JarRequest;", "(Lcom/android/build/gradle/internal/res/namespaced/JarRequest;)V", "getParams", "()Lcom/android/build/gradle/internal/res/namespaced/JarRequest;", "run", "", "gradle-core"})
/*    */ public final class JarWorkerRunnable
/*    */   implements Runnable
/*    */ {
/*    */   @NotNull
/*    */   private final JarRequest params;
/*    */   
/*    */   @Inject
/* 24 */   public JarWorkerRunnable(@NotNull JarRequest params) { this.params = params; } @NotNull
/* 24 */   public final JarRequest getParams() { return params; }
/*    */   
/* 26 */   public void run() { Closeable localCloseable = (Closeable)new JarMerger(params.getToFile().toPath());Throwable localThrowable1 = (Throwable)null; try { JarMerger out = (JarMerger)localCloseable;
/* 27 */       int $i$a$1$use; Iterable $receiver$iv = (Iterable)params.getFromDirectories();
/*    */       
/*    */       int $i$f$forEach;
/*    */       
/*    */       File dir;
/*    */       
/*    */       int $i$a$1$forEach;
/*    */       
/* 41 */       for (Object localObject1 = $receiver$iv.iterator(); ((Iterator)localObject1).hasNext(); out.addDirectory(dir.toPath()))
/*    */       {
/* 41 */         Object element$iv = ((Iterator)localObject1).next();dir = (File)element$iv;
/*    */       }
/* 28 */       Iterable $receiver$iv = (Iterable)params.getFromJars();
/*    */       
/*    */       int $i$f$forEach;
/*    */       
/*    */       File jar;
/*    */       
/*    */       int $i$a$2$forEach;
/*    */       
/* 43 */       for (localObject1 = $receiver$iv.iterator(); ((Iterator)localObject1).hasNext(); out.addJar(jar.toPath()))
/*    */       {
/* 43 */         element$iv = ((Iterator)localObject1).next();jar = (File)element$iv;
/*    */       }
/* 29 */       Map $receiver$iv = params.getFromFiles();
/*    */       
/*    */       int $i$f$forEach;
/*    */       
/* 45 */       localObject1 = $receiver$iv; File file; String path; for (Object element$iv = ((Map)localObject1).entrySet().iterator(); ((Iterator)element$iv).hasNext(); out.addFile(path, file.toPath()))
/*    */       {
/* 45 */         Map.Entry element$iv = (Map.Entry)((Iterator)element$iv).next();Map.Entry $path_file = element$iv; int $i$a$3$forEach; $i$f$forEach = $path_file;path = (String)$i$f$forEach.getKey();$i$f$forEach = $path_file;file = (File)$i$f$forEach.getValue();
/*    */       }
/* 26 */       out = 
/*    */       
/* 30 */         Unit.INSTANCE;
/*    */     }
/*    */     catch (Throwable localThrowable)
/*    */     {
/* 26 */       localThrowable1 = localThrowable; throw localThrowable; } finally { kotlin.io.CloseableKt.closeFinally(localCloseable, localThrowable1);
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.res.namespaced.JarWorkerRunnable
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */