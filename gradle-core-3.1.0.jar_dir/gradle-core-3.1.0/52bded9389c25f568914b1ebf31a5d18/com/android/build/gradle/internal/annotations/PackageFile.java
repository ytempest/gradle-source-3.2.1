package com.android.build.gradle.internal.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface PackageFile {}

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.annotations.PackageFile
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */