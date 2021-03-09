package com.android.build.gradle.internal.variant2;

import kotlin.Metadata;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.NamedDomainObjectFactory;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 9}, bv={1, 0, 2}, k=1, d1={"\000\036\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\bf\030\0002\0020\001J0\020\002\032\b\022\004\022\002H\0040\003\"\004\b\000\020\0042\f\020\005\032\b\022\004\022\002H\0040\0062\f\020\007\032\b\022\004\022\002H\0040\bH&¨\006\t"}, d2={"Lcom/android/build/gradle/internal/variant2/ContainerFactory;", "", "createContainer", "Lorg/gradle/api/NamedDomainObjectContainer;", "T", "itemClass", "Ljava/lang/Class;", "factory", "Lorg/gradle/api/NamedDomainObjectFactory;", "gradle-core"})
public abstract interface ContainerFactory
{
  @NotNull
  public abstract <T> NamedDomainObjectContainer<T> createContainer(@NotNull Class<T> paramClass, @NotNull NamedDomainObjectFactory<T> paramNamedDomainObjectFactory);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.variant2.ContainerFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */