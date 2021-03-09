/*     */ package com.android.build.gradle.external.cmake.server;
/*     */ 
/*     */ import com.android.build.gradle.external.cmake.server.receiver.DeserializationMonitor;
/*     */ import com.android.build.gradle.external.cmake.server.receiver.DiagnosticReceiver;
/*     */ import com.android.build.gradle.external.cmake.server.receiver.InteractiveMessage;
/*     */ import com.android.build.gradle.external.cmake.server.receiver.InteractiveProgress;
/*     */ import com.android.build.gradle.external.cmake.server.receiver.MessageReceiver;
/*     */ import com.android.build.gradle.external.cmake.server.receiver.ProgressReceiver;
/*     */ import com.android.build.gradle.external.cmake.server.receiver.ServerReceiver;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.GsonBuilder;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class ServerProtocolV1
/*     */   implements Server
/*     */ {
/*     */   public static final String CMAKE_SERVER_HEADER_MSG = "[== \"CMake Server\" ==[";
/*     */   public static final String CMAKE_SERVER_FOOTER_MSG = "]== \"CMake Server\" ==]";
/*     */   public static final String CMAKE_SERVER_C_COMPILER_PREFIX = "Check for working C compiler: ";
/*     */   public static final String CMAKE_SERVER_CXX_COMPILER_PREFIX = "Check for working CXX compiler: ";
/*     */   public static final String CMAKE_SERVER_C_COMPILER_SUFFIX = " -- works";
/*     */   private BufferedReader input;
/*     */   private BufferedWriter output;
/*     */   private final File cmakeInstallPath;
/*     */   private final ServerReceiver serverReceiver;
/*  64 */   private HelloResult helloResult = null;
/*     */   
/*  66 */   private boolean connected = false;
/*     */   
/*  68 */   private boolean configured = false;
/*     */   
/*  70 */   private boolean computed = false;
/*     */   
/*     */   private List<InteractiveMessage> configureMessages;
/*     */   
/*  75 */   Process process = null;
/*     */   
/*     */   ServerProtocolV1(File cmakeInstallPath, ServerReceiver serverReceiver) {
/*  78 */     this.cmakeInstallPath = cmakeInstallPath;
/*  79 */     this.serverReceiver = serverReceiver;
/*     */   }
/*     */   
/*     */   ServerProtocolV1(File cmakeInstallPath, ServerReceiver serverReceiver, Process process, BufferedReader input, BufferedWriter output)
/*     */   {
/*  93 */     this.cmakeInstallPath = cmakeInstallPath;
/*  94 */     this.serverReceiver = serverReceiver;
/*  95 */     this.process = process;
/*  96 */     this.input = input;
/*  97 */     this.output = output;
/*     */   }
/*     */   
/*     */   public void finalize()
/*     */   {
/*     */     try {
/* 103 */       disconnect();
/*     */     } catch (IOException e) {
/* 105 */       diagnostic("Error when disconnecting from Cmake server: %s", new Object[] { e.toString() });
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean connect() throws IOException
/*     */   {
/* 111 */     init();
/* 112 */     helloResult = ((HelloResult)decodeResponse(HelloResult.class));
/* 113 */     connected = ServerUtils.isHelloResultValid(helloResult);
/* 114 */     return connected;
/*     */   }
/*     */   
/*     */   public void disconnect() throws IOException
/*     */   {
/* 119 */     if (input != null) {
/* 120 */       input.close();
/* 121 */       input = null;
/*     */     }
/* 123 */     if (output != null) {
/* 124 */       output.close();
/* 125 */       output = null;
/*     */     }
/*     */     
/* 128 */     if (process != null) {
/* 129 */       process.destroy();
/* 130 */       process = null;
/*     */     }
/*     */     
/* 133 */     connected = false;
/* 134 */     configured = false;
/* 135 */     computed = false;
/* 136 */     configureMessages = null;
/* 137 */     helloResult = null;
/*     */   }
/*     */   
/*     */   public boolean isConnected()
/*     */   {
/* 142 */     return connected;
/*     */   }
/*     */   
/*     */   public List<ProtocolVersion> getSupportedVersion()
/*     */   {
/* 148 */     if ((helloResult == null) || (helloResult.supportedProtocolVersions == null)) {
/* 149 */       return null;
/*     */     }
/* 151 */     List<ProtocolVersion> result = new ArrayList();
/* 152 */     for (ProtocolVersion protocolVersion : helloResult.supportedProtocolVersions)
/*     */     {
/* 154 */       if (major.intValue() == 1) {
/* 155 */         result.add(protocolVersion);
/* 156 */         break;
/*     */       }
/*     */     }
/* 159 */     return result;
/*     */   }
/*     */   
/*     */   public HandshakeResult handshake(HandshakeRequest handshakeRequest)
/*     */     throws IOException
/*     */   {
/* 166 */     throwIfNotConnected("handshake");
/* 167 */     writeMessage(new GsonBuilder().setPrettyPrinting().create().toJson(handshakeRequest));
/* 168 */     return (HandshakeResult)decodeResponse(HandshakeResult.class);
/*     */   }
/*     */   
/*     */   public ConfigureCommandResult configure(String... cacheArguments)
/*     */     throws IOException
/*     */   {
/* 174 */     throwIfNotConnected("configure");
/*     */     
/* 176 */     ConfigureRequest configureRequest = new ConfigureRequest();
/*     */     
/* 180 */     cacheArguments = new String[cacheArguments.length + 1];
/* 181 */     cacheArguments[0] = "";
/* 182 */     System.arraycopy(cacheArguments, 0, cacheArguments, 1, cacheArguments.length);
/*     */     
/* 185 */     writeMessage(new GsonBuilder().setPrettyPrinting().create().toJson(configureRequest));
/* 186 */     configureMessages = new ArrayList();
/* 187 */     ConfigureResult configureResult = (ConfigureResult)decodeResponse(ConfigureResult.class, configureMessages);
/* 188 */     configured = ServerUtils.isConfigureResultValid(configureResult);
/*     */     
/* 190 */     return new ConfigureCommandResult(configureResult, 
/*     */     
/* 192 */       !configureMessages.isEmpty() ? 
/* 193 */       getInteractiveMessagesAsString(configureMessages) : "");
/*     */   }
/*     */   
/*     */   public ComputeResult compute()
/*     */     throws IOException
/*     */   {
/* 200 */     throwIfNotConnected("compute");
/* 201 */     throwIfNotConfigured("compute");
/*     */     
/* 203 */     writeMessage("{\"type\":\"compute\"}");
/* 204 */     ComputeResult computeResult = (ComputeResult)decodeResponse(ComputeResult.class);
/* 205 */     computed = ServerUtils.isComputedResultValid(computeResult);
/* 206 */     return computeResult;
/*     */   }
/*     */   
/*     */   public CodeModel codemodel()
/*     */     throws IOException
/*     */   {
/* 212 */     throwIfNotConnected("codemodel");
/* 213 */     throwIfNotComputed("codemodel");
/*     */     
/* 215 */     writeMessage("{\"type\":\"codemodel\"}");
/* 216 */     return (CodeModel)decodeResponse(CodeModel.class);
/*     */   }
/*     */   
/*     */   public CacheResult cache()
/*     */     throws IOException
/*     */   {
/* 222 */     throwIfNotConnected("cache");
/*     */     
/* 224 */     CacheRequest request = new CacheRequest();
/* 225 */     writeMessage(new GsonBuilder().setPrettyPrinting().create().toJson(request));
/* 226 */     return (CacheResult)decodeResponse(CacheResult.class);
/*     */   }
/*     */   
/*     */   public GlobalSettings globalSettings()
/*     */     throws IOException
/*     */   {
/* 232 */     throwIfNotConnected("globalSettings");
/*     */     
/* 234 */     writeMessage("{\"type\":\"globalSettings\"}");
/* 235 */     return (GlobalSettings)decodeResponse(GlobalSettings.class);
/*     */   }
/*     */   
/*     */   public CmakeInputsResult cmakeInputs()
/*     */     throws IOException
/*     */   {
/* 241 */     throwIfNotConnected("cmakeInputs");
/* 242 */     throwIfNotConfigured("cmakeInputs");
/*     */     
/* 244 */     writeMessage("{\"type\":\"cmakeInputs\"}");
/* 245 */     return (CmakeInputsResult)decodeResponse(CmakeInputsResult.class);
/*     */   }
/*     */   
/*     */   public String getCCompilerExecutable()
/*     */   {
/* 251 */     String prefixMessage = "Check for working C compiler: ";
/* 252 */     String suffixMessage = " -- works";
/*     */     
/* 254 */     return hackyGetLangExecutable("Check for working C compiler: ", " -- works");
/*     */   }
/*     */   
/*     */   public String getCppCompilerExecutable()
/*     */   {
/* 260 */     String prefixMessage = "Check for working CXX compiler: ";
/* 261 */     String suffixMessage = " -- works";
/*     */     
/* 263 */     return hackyGetLangExecutable("Check for working CXX compiler: ", " -- works");
/*     */   }
/*     */   
/*     */   public String getCmakePath()
/*     */   {
/* 269 */     return cmakeInstallPath.getAbsolutePath();
/*     */   }
/*     */   
/*     */   public HelloResult getHelloResult()
/*     */   {
/* 274 */     return helloResult;
/*     */   }
/*     */   
/*     */   private void throwIfNotConnected(String operation)
/*     */   {
/* 281 */     if (!connected) {
/* 282 */       throwError("Need to connect to CMake server before requesting for", operation);
/*     */     }
/*     */   }
/*     */   
/*     */   private void throwIfNotConfigured(String operation) {
/* 287 */     if (!configured) {
/* 288 */       throwError("Need to configure before requesting for", operation);
/*     */     }
/*     */   }
/*     */   
/*     */   private void throwIfNotComputed(String operation) {
/* 293 */     if (!computed) {
/* 294 */       throwError("Need to compute before requesting for", operation);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void throwError(String message, String operation) {
/* 299 */     throw new RuntimeException(message + " " + operation + ".");
/*     */   }
/*     */   
/*     */   private String hackyGetLangExecutable(String prefixMessage, String suffixMessage)
/*     */   {
/* 314 */     if ((configureMessages == null) || (configureMessages.isEmpty())) {
/* 315 */       return "";
/*     */     }
/*     */     
/* 318 */     for (InteractiveMessage message : configureMessages) {
/* 319 */       if ((message != null) && 
/* 320 */         (message.startsWith(prefixMessage)) && 
/* 321 */         (message.endsWith(suffixMessage)))
/*     */       {
/* 324 */         return message.substring(prefixMessage
/* 325 */           .length(), message.length() - suffixMessage.length());
/*     */       }
/*     */     }
/* 328 */     return "";
/*     */   }
/*     */   
/*     */   private void init()
/*     */     throws IOException
/*     */   {
/* 337 */     if (process == null) {
/* 338 */       ProcessBuilder processBuilder = getCmakeServerProcessBuilder();
/* 339 */       processBuilder.environment().putAll(new ProcessBuilder(new String[0]).environment());
/* 340 */       process = processBuilder.start();
/*     */     }
/*     */     
/* 343 */     if (input == null) {
/* 344 */       input = new BufferedReader(new InputStreamReader(process.getInputStream()));
/*     */     }
/* 346 */     if (output == null) {
/* 347 */       output = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
/*     */     }
/*     */   }
/*     */   
/*     */   private void diagnostic(String format, Object... args)
/*     */   {
/* 358 */     if (serverReceiver.getDiagnosticReceiver() != null) {
/* 359 */       serverReceiver.getDiagnosticReceiver().receive(String.format(format, args));
/*     */     }
/*     */   }
/*     */   
/*     */   private ProcessBuilder getCmakeServerProcessBuilder()
/*     */   {
/* 369 */     String cmakeBinPath = new File(cmakeInstallPath, "cmake").getPath();
/* 370 */     return new ProcessBuilder(new String[] { cmakeBinPath, "-E", "server", "--experimental", "--debug" });
/*     */   }
/*     */   
/*     */   private <T> T decodeResponse(Class<T> clazz)
/*     */     throws IOException
/*     */   {
/* 381 */     return (T)decodeResponse(clazz, null);
/*     */   }
/*     */   
/*     */   private <T> T decodeResponse(Class<T> clazz, List<InteractiveMessage> interactiveMessages) throws IOException
/*     */   {
/* 386 */     Gson gson = new GsonBuilder().create();
/* 387 */     String message = readMessage();
/* 388 */     String messageType = fromJsontype;
/*     */     
/* 390 */     List supportedTypes = Arrays.asList(new String[] { "message", "progress", "signal" });
/*     */     
/* 398 */     while (supportedTypes.contains(messageType)) {
/* 399 */       switch (messageType) {
/*     */       case "message": 
/* 401 */         if (serverReceiver.getMessageReceiver() != null)
/*     */         {
/* 403 */           InteractiveMessage interactiveMessage = (InteractiveMessage)gson.fromJson(message, InteractiveMessage.class);
/* 404 */           serverReceiver.getMessageReceiver().receive(interactiveMessage);
/*     */           
/* 406 */           if (interactiveMessages != null) {
/* 407 */             serverReceiver.getMessageReceiver().receive(interactiveMessage);
/* 408 */             interactiveMessages.add(interactiveMessage);
/*     */           } }
/* 410 */         break;
/*     */       
/*     */       case "progress": 
/* 413 */         if (serverReceiver.getProgressReceiver() != null)
/*     */         {
/* 416 */           serverReceiver.getProgressReceiver().receive((InteractiveProgress)gson.fromJson(message, InteractiveProgress.class)); }
/* 417 */         break;
/*     */       
/*     */       case "signal": 
/* 421 */         if (serverReceiver.getProgressReceiver() != null)
/*     */         {
/* 424 */           serverReceiver.getProgressReceiver().receive((InteractiveProgress)gson.fromJson(message, InteractiveProgress.class));
/*     */         }
/*     */         break;
/*     */       }
/* 428 */       message = readMessage();
/* 429 */       messageType = fromJsontype;
/*     */     }
/*     */     
/* 433 */     switch (messageType) {
/*     */     case "hello": 
/*     */     case "reply": 
/* 436 */       if (serverReceiver.getDeserializationMonitor() != null) {
/* 437 */         serverReceiver.getDeserializationMonitor().receive(message, clazz);
/*     */       }
/* 439 */       return (T)gson.fromJson(message, clazz);
/*     */     case "error": 
/* 441 */       if (serverReceiver.getMessageReceiver() != null)
/*     */       {
/* 443 */         InteractiveMessage interactiveMessage = (InteractiveMessage)gson.fromJson(message, InteractiveMessage.class);
/* 444 */         serverReceiver.getMessageReceiver().receive(interactiveMessage);
/*     */       }
/* 446 */       return (T)gson.fromJson(message, clazz);
/*     */     }
/* 448 */     throw new RuntimeException("Unsupported message type " + messageType + " received from CMake server.");
/*     */   }
/*     */   
/*     */   private static String getInteractiveMessagesAsString(List<InteractiveMessage> interactiveMessages)
/*     */   {
/* 462 */     StringBuilder result = new StringBuilder();
/* 463 */     for (InteractiveMessage interactiveMessage : interactiveMessages) {
/* 464 */       result.append(message).append("\n");
/*     */     }
/*     */     
/* 467 */     return result.toString();
/*     */   }
/*     */   
/*     */   private String readLine()
/*     */     throws IOException
/*     */   {
/* 477 */     String line = input.readLine();
/* 478 */     diagnostic(line + "\n", new Object[0]);
/* 479 */     return line;
/*     */   }
/*     */   
/*     */   private void writeLine(String message)
/*     */     throws IOException
/*     */   {
/* 488 */     diagnostic("%s\n", new Object[] { message });
/* 489 */     output.write(message);
/* 490 */     output.newLine();
/*     */   }
/*     */   
/*     */   private void readExpected(String expectedString)
/*     */     throws IOException
/*     */   {
/* 501 */     String line = readLine();
/* 502 */     while (!line.equals(expectedString))
/*     */     {
/* 504 */       if ((!line.isEmpty()) && (serverReceiver.getDiagnosticReceiver() != null)) {
/* 505 */         serverReceiver.getDiagnosticReceiver().receive(line);
/*     */       }
/* 507 */       line = readLine();
/*     */     }
/*     */   }
/*     */   
/*     */   private String readMessage()
/*     */     throws IOException
/*     */   {
/* 530 */     readExpected("[== \"CMake Server\" ==[");
/* 531 */     String line = readLine();
/* 532 */     readExpected("]== \"CMake Server\" ==]");
/* 533 */     return line;
/*     */   }
/*     */   
/*     */   private void writeMessage(String message)
/*     */     throws IOException
/*     */   {
/* 543 */     writeLine("[== \"CMake Server\" ==[");
/* 544 */     writeLine(message);
/* 545 */     writeLine("]== \"CMake Server\" ==]");
/* 546 */     output.flush();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.external.cmake.server.ServerProtocolV1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */