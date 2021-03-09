package com.android.build.gradle.external.cmake.server;

import java.io.IOException;
import java.util.List;

public abstract interface Server
{
  public abstract boolean connect()
    throws IOException;
  
  public abstract void disconnect()
    throws IOException;
  
  public abstract boolean isConnected();
  
  public abstract List<ProtocolVersion> getSupportedVersion();
  
  public abstract HandshakeResult handshake(HandshakeRequest paramHandshakeRequest)
    throws IOException;
  
  public abstract ConfigureCommandResult configure(String... paramVarArgs)
    throws IOException;
  
  public abstract ComputeResult compute()
    throws IOException;
  
  public abstract CodeModel codemodel()
    throws IOException;
  
  public abstract CacheResult cache()
    throws IOException;
  
  public abstract CmakeInputsResult cmakeInputs()
    throws IOException;
  
  public abstract GlobalSettings globalSettings()
    throws IOException;
  
  public abstract String getCCompilerExecutable();
  
  public abstract String getCppCompilerExecutable();
  
  public abstract String getCmakePath();
}

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.server.Server
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */