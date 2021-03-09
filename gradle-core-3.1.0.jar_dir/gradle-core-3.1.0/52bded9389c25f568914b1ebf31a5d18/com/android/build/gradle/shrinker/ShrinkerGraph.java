package com.android.build.gradle.shrinker;

import com.android.ide.common.internal.WaitableExecutor;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public abstract interface ShrinkerGraph<T>
{
  public abstract File getSourceFile(T paramT);
  
  public abstract Iterable<T> getAllProgramClasses();
  
  public abstract Set<T> getReachableClasses(AbstractShrinker.CounterSet paramCounterSet);
  
  public abstract Set<String> getReachableMembersLocalNames(T paramT, AbstractShrinker.CounterSet paramCounterSet);
  
  public abstract Set<Dependency<T>> getDependencies(T paramT);
  
  public abstract Set<T> getMethods(T paramT);
  
  public abstract Set<T> getFields(T paramT);
  
  public abstract T addClass(String paramString1, String paramString2, String[] paramArrayOfString, int paramInt, File paramFile);
  
  public abstract T addMember(T paramT, String paramString1, String paramString2, int paramInt);
  
  public abstract T getOwnerClass(T paramT);
  
  public abstract T getClassReference(String paramString);
  
  public abstract T getMemberReference(String paramString1, String paramString2, String paramString3);
  
  public abstract boolean incrementAndCheck(T paramT, DependencyType paramDependencyType, AbstractShrinker.CounterSet paramCounterSet);
  
  public abstract void addDependency(T paramT1, T paramT2, DependencyType paramDependencyType);
  
  public abstract void saveState()
    throws IOException;
  
  public abstract boolean isReachable(T paramT, AbstractShrinker.CounterSet paramCounterSet);
  
  public abstract void removeAllCodeDependencies(T paramT);
  
  public abstract T getSuperclass(T paramT)
    throws ClassLookupException;
  
  public abstract T findMatchingMethod(T paramT1, T paramT2);
  
  public abstract boolean isProgramClass(T paramT);
  
  public abstract T[] getInterfaces(T paramT)
    throws ClassLookupException;
  
  public abstract String getClassName(T paramT);
  
  public abstract String getMemberName(T paramT);
  
  public abstract String getFullMemberName(T paramT);
  
  public abstract String getMemberDescriptor(T paramT);
  
  public abstract int getModifiers(T paramT);
  
  public abstract void addAnnotation(T paramT, String paramString);
  
  public abstract Iterable<String> getAnnotations(T paramT);
  
  public abstract void addRoots(Map<T, DependencyType> paramMap, AbstractShrinker.CounterSet paramCounterSet);
  
  public abstract Map<T, DependencyType> getRoots(AbstractShrinker.CounterSet paramCounterSet);
  
  public abstract void clearCounters(WaitableExecutor paramWaitableExecutor);
  
  public abstract boolean isClassKnown(T paramT);
  
  public abstract void checkDependencies(ShrinkerLogger paramShrinkerLogger);
  
  public abstract void addTypeFromGenericSignature(T paramT1, T paramT2);
  
  public abstract Set<T> getTypesFromGenericSignatures(T paramT);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.ShrinkerGraph
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */