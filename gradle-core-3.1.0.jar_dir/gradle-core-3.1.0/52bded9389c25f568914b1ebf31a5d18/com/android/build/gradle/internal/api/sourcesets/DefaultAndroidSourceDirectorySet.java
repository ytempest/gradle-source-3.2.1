/*     */ package com.android.build.gradle.internal.api.sourcesets;
/*     */ 
/*     */ import com.android.build.api.sourcesets.AndroidSourceDirectorySet;
/*     */ import com.android.build.gradle.internal.api.dsl.sealing.SealableObject;
/*     */ import com.android.builder.errors.EvalIssueReporter;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.Lists;
/*     */ import groovy.lang.Closure;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.function.Function;
/*     */ import java.util.stream.Stream;
/*     */ import kotlin.Metadata;
/*     */ import kotlin.TypeCastException;
/*     */ import kotlin.jvm.internal.Intrinsics;
/*     */ import org.gradle.api.file.ConfigurableFileCollection;
/*     */ import org.gradle.api.file.ConfigurableFileTree;
/*     */ import org.gradle.api.file.FileTree;
/*     */ import org.gradle.api.file.FileTreeElement;
/*     */ import org.gradle.api.specs.Spec;
/*     */ import org.gradle.api.tasks.util.PatternFilterable;
/*     */ import org.gradle.api.tasks.util.PatternSet;
/*     */ import org.jetbrains.annotations.NotNull;
/*     */ 
/*     */ @Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\001\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020 \n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\"\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\020\021\n\000\n\002\020\034\n\002\030\002\n\002\030\002\n\002\b\t\n\002\020\002\n\002\b\004\030\0002\0020\0012\0020\002B\035\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\b¢\006\002\020\tJ\024\020\"\032\0020\r2\n\020#\032\006\022\002\b\0030$H\026J!\020\"\032\0020\r2\022\020%\032\n\022\006\b\001\022\0020\0040&\"\0020\004H\026¢\006\002\020'J\026\020\"\032\0020\r2\f\020%\032\b\022\004\022\0020\0040(H\026J\026\020\"\032\0020\r2\f\020#\032\b\022\004\022\0020*0)H\026J\016\020+\032\b\022\004\022\0020\0040\036H\026J\016\020,\032\b\022\004\022\0020\0040\036H\026J\b\020-\032\0020\004H\026J\024\020.\032\0020\r2\n\020/\032\006\022\002\b\0030$H\026J!\020.\032\0020\r2\022\0200\032\n\022\006\b\001\022\0020\0040&\"\0020\004H\026¢\006\002\020'J\026\020.\032\0020\r2\f\0200\032\b\022\004\022\0020\0040(H\026J\026\020.\032\0020\r2\f\020/\032\b\022\004\022\0020*0)H\026J\026\0201\032\0020\r2\f\020%\032\b\022\004\022\0020\0040(H\026J\026\0202\032\0020\r2\f\0200\032\b\022\004\022\0020\0040(H\026J\024\0203\032\002042\n\020\035\032\006\022\002\b\0030(H\026J\020\0205\032\002042\006\0205\032\0020\022H\026J!\020\035\032\002042\022\020\035\032\n\022\006\b\001\022\0020\0220&\"\0020\022H\026¢\006\002\0206J\b\0207\032\0020\004H\026R\016\020\n\032\0020\013X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\024\020\f\032\0020\r8VX\004¢\006\006\032\004\b\016\020\017R\016\020\003\032\0020\004X\004¢\006\002\n\000R2\020\020\032&\022\f\022\n \023*\004\030\0010\0220\022 \023*\022\022\f\022\n \023*\004\030\0010\0220\022\030\0010\0210\021X\004¢\006\002\n\000R\032\020\024\032\b\022\004\022\0020\0260\0258VX\004¢\006\006\032\004\b\027\020\030R\024\020\031\032\0020\0328VX\004¢\006\006\032\004\b\033\020\034R\032\020\035\032\b\022\004\022\0020\0370\0368VX\004¢\006\006\032\004\b \020!¨\0068"}, d2={"Lcom/android/build/gradle/internal/api/sourcesets/DefaultAndroidSourceDirectorySet;", "Lcom/android/build/gradle/internal/api/dsl/sealing/SealableObject;", "Lcom/android/build/api/sourcesets/AndroidSourceDirectorySet;", "name", "", "filesProvider", "Lcom/android/build/gradle/internal/api/sourcesets/FilesProvider;", "issueReporter", "Lcom/android/builder/errors/EvalIssueReporter;", "(Ljava/lang/String;Lcom/android/build/gradle/internal/api/sourcesets/FilesProvider;Lcom/android/builder/errors/EvalIssueReporter;)V", "_filter", "Lorg/gradle/api/tasks/util/PatternSet;", "filter", "Lorg/gradle/api/tasks/util/PatternFilterable;", "getFilter", "()Lorg/gradle/api/tasks/util/PatternFilterable;", "source", "Ljava/util/ArrayList;", "", "kotlin.jvm.PlatformType", "sourceDirectoryTrees", "", "Lorg/gradle/api/file/ConfigurableFileTree;", "getSourceDirectoryTrees", "()Ljava/util/List;", "sourceFiles", "Lorg/gradle/api/file/FileTree;", "getSourceFiles", "()Lorg/gradle/api/file/FileTree;", "srcDirs", "", "Ljava/io/File;", "getSrcDirs", "()Ljava/util/Set;", "exclude", "excludeSpec", "Lgroovy/lang/Closure;", "excludes", "", "([Ljava/lang/String;)Lorg/gradle/api/tasks/util/PatternFilterable;", "", "Lorg/gradle/api/specs/Spec;", "Lorg/gradle/api/file/FileTreeElement;", "getExcludes", "getIncludes", "getName", "include", "includeSpec", "includes", "setExcludes", "setIncludes", "setSrcDirs", "", "srcDir", "([Ljava/lang/Object;)V", "toString", "gradle-core"})
/*     */ public final class DefaultAndroidSourceDirectorySet extends SealableObject implements AndroidSourceDirectorySet
/*     */ {
/*     */   private final ArrayList<Object> source;
/*     */   private final PatternSet _filter;
/*     */   private final String name;
/*     */   private final FilesProvider filesProvider;
/*     */   
/*     */   public DefaultAndroidSourceDirectorySet(@NotNull String name, @NotNull FilesProvider filesProvider, @NotNull EvalIssueReporter issueReporter)
/*     */   {
/*  43 */     super(issueReporter);this.name = name;this.filesProvider = filesProvider;
/*  44 */     source = Lists.newArrayList();
/*  45 */     _filter = new PatternSet(); }
/*     */   
/*     */   @NotNull
/*  48 */   public String getName() { return name; }
/*     */   
/*     */   public void srcDir(@NotNull Object srcDir)
/*     */   {
/*  52 */     Intrinsics.checkParameterIsNotNull(srcDir, "srcDir"); if (checkSeal()) {
/*  53 */       source.add(srcDir);
/*     */     }
/*     */   }
/*     */   
/*     */   public void srcDirs(@NotNull Object... srcDirs) {
/*  58 */     Intrinsics.checkParameterIsNotNull(srcDirs, "srcDirs"); if (checkSeal()) {
/*  59 */       Object[] tmp21_20 = srcDirs;Collections.addAll((Collection)source, Arrays.copyOf(tmp21_20, tmp21_20.length));
/*     */     }
/*     */   }
/*     */   
/*     */   public void setSrcDirs(@NotNull Iterable<?> srcDirs) {
/*  64 */     Intrinsics.checkParameterIsNotNull(srcDirs, "srcDirs"); if (checkSeal()) {
/*  65 */       source.clear();
/*  66 */       for (Object srcDir : srcDirs) {
/*  67 */         source.add(srcDir);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public FileTree getSourceFiles() {
/*  74 */     FileTree src = (FileTree)null;
/*  75 */     Set sources = getSrcDirs();
/*  76 */     if (!sources.isEmpty()) {
/*  77 */       src = filesProvider.files(new Object[] { new ArrayList((Collection)sources) }).getAsFileTree().matching(getFilter());
/*     */     }
/*  79 */     FileTree tmp83_78 = filesProvider.files(new Object[0]).getAsFileTree();Intrinsics.checkExpressionValueIsNotNull(tmp83_78, "filesProvider.files().asFileTree");return src == null ? tmp83_78 : src;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public List<ConfigurableFileTree> getSourceDirectoryTrees()
/*     */   {
/*  92 */     Object tmp31_26 = source.stream().map((Function)new Function()).collect(ImmutableList.toImmutableList());Intrinsics.checkExpressionValueIsNotNull(tmp31_26, "source\n                .…leList.toImmutableList())");return (List)tmp31_26;
/*     */   }
/*     */   
/*     */   @NotNull
/*  98 */   public PatternFilterable getFilter() { return (PatternFilterable)_filter; }
/*     */   
/*     */   @NotNull
/* 101 */   public String toString() { String tmp7_4 = source.toString();Intrinsics.checkExpressionValueIsNotNull(tmp7_4, "source.toString()");return tmp7_4;
/*     */   }
/*     */   
/*     */   @NotNull
/* 105 */   public Set<String> getIncludes() { Set tmp9_4 = getFilter().getIncludes();Intrinsics.checkExpressionValueIsNotNull(tmp9_4, "filter.includes");return tmp9_4;
/*     */   }
/*     */   
/*     */   @NotNull
/* 109 */   public Set<String> getExcludes() { Set tmp9_4 = getFilter().getExcludes();Intrinsics.checkExpressionValueIsNotNull(tmp9_4, "filter.excludes");return tmp9_4;
/*     */   }
/*     */   
/*     */   @NotNull
/* 113 */   public PatternFilterable setIncludes(@NotNull Iterable<String> includes) { Intrinsics.checkParameterIsNotNull(includes, "includes");getFilter().setIncludes(includes);
/* 114 */     return (PatternFilterable)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 118 */   public PatternFilterable setExcludes(@NotNull Iterable<String> excludes) { Intrinsics.checkParameterIsNotNull(excludes, "excludes");getFilter().setExcludes(excludes);
/* 119 */     return (PatternFilterable)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 123 */   public PatternFilterable include(@NotNull String... includes) { Intrinsics.checkParameterIsNotNull(includes, "includes"); String[] tmp11_10 = includes;getFilter().include((String[])Arrays.copyOf(tmp11_10, tmp11_10.length));
/* 124 */     return (PatternFilterable)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 128 */   public PatternFilterable include(@NotNull Iterable<String> includes) { Intrinsics.checkParameterIsNotNull(includes, "includes");getFilter().include(includes);
/* 129 */     return (PatternFilterable)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 133 */   public PatternFilterable include(@NotNull Spec<FileTreeElement> includeSpec) { Intrinsics.checkParameterIsNotNull(includeSpec, "includeSpec");getFilter().include(includeSpec);
/* 134 */     return (PatternFilterable)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 138 */   public PatternFilterable include(@NotNull Closure<?> includeSpec) { Intrinsics.checkParameterIsNotNull(includeSpec, "includeSpec");getFilter().include(includeSpec);
/* 139 */     return (PatternFilterable)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 143 */   public PatternFilterable exclude(@NotNull Iterable<String> excludes) { Intrinsics.checkParameterIsNotNull(excludes, "excludes");getFilter().exclude(excludes);
/* 144 */     return (PatternFilterable)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 148 */   public PatternFilterable exclude(@NotNull String... excludes) { Intrinsics.checkParameterIsNotNull(excludes, "excludes"); String[] tmp11_10 = excludes;getFilter().exclude((String[])Arrays.copyOf(tmp11_10, tmp11_10.length));
/* 149 */     return (PatternFilterable)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 153 */   public PatternFilterable exclude(@NotNull Spec<FileTreeElement> excludeSpec) { Intrinsics.checkParameterIsNotNull(excludeSpec, "excludeSpec");getFilter().exclude(excludeSpec);
/* 154 */     return (PatternFilterable)this;
/*     */   }
/*     */   
/*     */   @NotNull
/* 158 */   public PatternFilterable exclude(@NotNull Closure<?> excludeSpec) { Intrinsics.checkParameterIsNotNull(excludeSpec, "excludeSpec");getFilter().exclude(excludeSpec);
/* 159 */     return (PatternFilterable)this;
/*     */   }
/*     */   
/*     */   @NotNull
/*     */   public Set<File> getSrcDirs()
/*     */   {
/*  95 */     ArrayList tmp8_5 = source;Intrinsics.checkExpressionValueIsNotNull(tmp8_5, "source");Collection localCollection1 = (Collection)tmp8_5;FilesProvider localFilesProvider = filesProvider;
/*     */     
/*     */     int $i$f$toTypedArray;
/*     */     
/*     */     Collection $receiver$iv;
/*     */     
/* 163 */     Collection tmp21_20 = $receiver$iv;
/*     */     
/* 163 */     if (tmp21_20 == null) throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>"); Collection thisCollection$iv = tmp21_20; Object[] 
/* 164 */       tmp51_46 = thisCollection$iv.toArray(new Object[thisCollection$iv.size()]);
/* 164 */     if (tmp51_46 == null) throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>"); Object[] arrayOfObject = tmp51_46; Object[] tmp71_69 = arrayOfObject; ImmutableSet tmp92_89 = ImmutableSet.copyOf((Collection)localFilesProvider.files(Arrays.copyOf(tmp71_69, tmp71_69.length)).getFiles());Intrinsics.checkExpressionValueIsNotNull(tmp92_89, "ImmutableSet.copyOf(file…ce.toTypedArray()).files)");return (Set)tmp92_89;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.sourcesets.DefaultAndroidSourceDirectorySet
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */