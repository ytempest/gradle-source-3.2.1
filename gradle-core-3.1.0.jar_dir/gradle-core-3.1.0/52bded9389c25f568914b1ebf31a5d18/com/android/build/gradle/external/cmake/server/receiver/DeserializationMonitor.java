package com.android.build.gradle.external.cmake.server.receiver;

public abstract interface DeserializationMonitor
{
  public abstract <T> void receive(String paramString, Class<T> paramClass);
}

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.server.receiver.DeserializationMonitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */