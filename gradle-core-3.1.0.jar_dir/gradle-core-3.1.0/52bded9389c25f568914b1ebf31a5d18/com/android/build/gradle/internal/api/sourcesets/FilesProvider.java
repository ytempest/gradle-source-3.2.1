package com.android.build.gradle.internal.api.sourcesets;

import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.ConfigurableFileTree;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000,\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020$\n\002\020\016\n\000\n\002\030\002\n\002\020\021\n\002\b\002\bf\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\002\032\0020\001H&J\032\020\004\032\0020\0052\020\020\006\032\f\022\004\022\0020\b\022\002\b\0030\007H&J!\020\t\032\0020\n2\022\020\t\032\n\022\006\b\001\022\0020\0010\013\"\0020\001H&¢\006\002\020\f¨\006\r"}, d2={"Lcom/android/build/gradle/internal/api/sourcesets/FilesProvider;", "", "file", "Ljava/io/File;", "fileTree", "Lorg/gradle/api/file/ConfigurableFileTree;", "args", "", "", "files", "Lorg/gradle/api/file/ConfigurableFileCollection;", "", "([Ljava/lang/Object;)Lorg/gradle/api/file/ConfigurableFileCollection;", "gradle-core"})
public abstract interface FilesProvider
{
  @NotNull
  public abstract File file(@NotNull Object paramObject);
  
  @NotNull
  public abstract ConfigurableFileCollection files(@NotNull Object... paramVarArgs);
  
  @NotNull
  public abstract ConfigurableFileTree fileTree(@NotNull Map<String, ?> paramMap);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.api.sourcesets.FilesProvider
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */