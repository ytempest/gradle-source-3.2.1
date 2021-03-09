/*     */ package com.android.build.gradle.internal.plugin;
/*     */ 
/*     */ import com.android.build.gradle.internal.api.sourcesets.FilesProvider;
/*     */ import com.android.build.gradle.internal.variant2.ContainerFactory;
/*     */ import java.io.File;
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.NamedDomainObjectContainer;
/*     */ import org.gradle.api.NamedDomainObjectFactory;
/*     */ import org.gradle.api.Project;
/*     */ import org.gradle.api.file.ConfigurableFileCollection;
/*     */ import org.gradle.api.file.ConfigurableFileTree;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000P\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020$\n\002\020\016\n\000\n\002\030\002\n\002\020\021\n\002\b\002\030\0002\0020\0012\0020\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005J0\020\006\032\b\022\004\022\002H\b0\007\"\004\b\000\020\b2\f\020\t\032\b\022\004\022\002H\b0\n2\f\020\013\032\b\022\004\022\002H\b0\fH\026J\020\020\r\032\0020\0162\006\020\r\032\0020\017H\026J\032\020\020\032\0020\0212\020\020\022\032\f\022\004\022\0020\024\022\002\b\0030\023H\026J!\020\025\032\0020\0262\022\020\025\032\n\022\006\b\001\022\0020\0170\027\"\0020\017H\026¢\006\002\020\030R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\031"}, d2={"Lcom/android/build/gradle/internal/plugin/ProjectWrapper;", "Lcom/android/build/gradle/internal/api/sourcesets/FilesProvider;", "Lcom/android/build/gradle/internal/variant2/ContainerFactory;", "project", "Lorg/gradle/api/Project;", "(Lorg/gradle/api/Project;)V", "createContainer", "Lorg/gradle/api/NamedDomainObjectContainer;", "T", "itemClass", "Ljava/lang/Class;", "factory", "Lorg/gradle/api/NamedDomainObjectFactory;", "file", "Ljava/io/File;", "", "fileTree", "Lorg/gradle/api/file/ConfigurableFileTree;", "args", "", "", "files", "Lorg/gradle/api/file/ConfigurableFileCollection;", "", "([Ljava/lang/Object;)Lorg/gradle/api/file/ConfigurableFileCollection;", "gradle-core"})
/*     */ public final class ProjectWrapper
/*     */   implements FilesProvider, ContainerFactory
/*     */ {
/*     */   private final Project project;
/*     */   
/*     */   public ProjectWrapper(@NotNull Project project)
/*     */   {
/* 195 */     this.project = project;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public File file(@NotNull Object file) {
/* 200 */     Intrinsics.checkParameterIsNotNull(file, "file"); File tmp16_11 = project.file(file);Intrinsics.checkExpressionValueIsNotNull(tmp16_11, "project.file(file)");return tmp16_11;
/*     */   }
/*     */   
/*     */   @NotNull
/* 204 */   public ConfigurableFileCollection files(@NotNull Object... files) { Intrinsics.checkParameterIsNotNull(files, "files"); Object[] tmp11_10 = files; ConfigurableFileCollection tmp21_16 = project.files(Arrays.copyOf(tmp11_10, tmp11_10.length));Intrinsics.checkExpressionValueIsNotNull(tmp21_16, "project.files(*files)");return tmp21_16;
/*     */   }
/*     */   
/*     */   @NotNull
/* 208 */   public ConfigurableFileTree fileTree(@NotNull Map<String, ?> args) { Intrinsics.checkParameterIsNotNull(args, "args"); ConfigurableFileTree tmp16_11 = project.fileTree(args);Intrinsics.checkExpressionValueIsNotNull(tmp16_11, "project.fileTree(args)");return tmp16_11;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public <T> NamedDomainObjectContainer<T> createContainer(@NotNull Class<T> itemClass, @NotNull NamedDomainObjectFactory<T> factory)
/*     */   {
/* 216 */     Intrinsics.checkParameterIsNotNull(itemClass, "itemClass");Intrinsics.checkParameterIsNotNull(factory, "factory"); NamedDomainObjectContainer tmp23_18 = project.container(itemClass, factory);Intrinsics.checkExpressionValueIsNotNull(tmp23_18, "project.container(itemClass, factory)");return tmp23_18;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.plugin.ProjectWrapper
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */