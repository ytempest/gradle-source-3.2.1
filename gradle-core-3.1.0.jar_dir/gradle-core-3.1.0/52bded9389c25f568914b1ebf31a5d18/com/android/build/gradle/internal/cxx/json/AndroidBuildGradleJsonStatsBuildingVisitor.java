/*    */ package com.android.build.gradle.internal.cxx.json;
/*    */ 
/*    */ import com.google.wireless.android.sdk.stats.GradleBuildVariant.NativeBuildConfigInfo.Builder;
/*    */ import com.google.wireless.android.sdk.stats.GradleBuildVariant.NativeLibraryInfo;
/*    */ import com.google.wireless.android.sdk.stats.GradleBuildVariant.NativeLibraryInfo.Builder;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class AndroidBuildGradleJsonStatsBuildingVisitor
/*    */   extends AndroidBuildGradleJsonStreamingVisitor
/*    */ {
/*    */   private final GradleBuildVariant.NativeBuildConfigInfo.Builder config;
/* 30 */   private GradleBuildVariant.NativeLibraryInfo.Builder libraryInfo = GradleBuildVariant.NativeLibraryInfo.newBuilder();
/*    */   
/* 32 */   private int runningSourceFileCount = 0;
/* 33 */   private boolean sawFirstFlags = false;
/*    */   
/*    */   public AndroidBuildGradleJsonStatsBuildingVisitor(GradleBuildVariant.NativeBuildConfigInfo.Builder config)
/*    */   {
/* 37 */     this.config = config;
/*    */   }
/*    */   
/*    */   public GradleBuildVariant.NativeBuildConfigInfo.Builder getConfig() throws IOException {
/* 41 */     return config;
/*    */   }
/*    */   
/*    */   protected void beginLibrary(String libraryName)
/*    */   {
/* 46 */     libraryInfo = GradleBuildVariant.NativeLibraryInfo.newBuilder();
/* 47 */     runningSourceFileCount = 0;
/* 48 */     sawFirstFlags = false;
/*    */   }
/*    */   
/*    */   protected void endLibrary()
/*    */   {
/* 53 */     libraryInfo.setSourceFileCount(runningSourceFileCount);
/* 54 */     config.addLibraries(libraryInfo);
/* 55 */     super.endLibrary();
/*    */   }
/*    */   
/*    */   protected void visitLibraryBuildType(String buildType)
/*    */   {
/* 60 */     super.visitLibraryBuildType(buildType);
/*    */   }
/*    */   
/*    */   protected void visitLibraryFileSrc(String src)
/*    */   {
/* 65 */     super.visitLibraryFileSrc(src);
/* 66 */     runningSourceFileCount += 1;
/*    */   }
/*    */   
/*    */   protected void visitLibraryFileFlags(String flags)
/*    */   {
/* 71 */     super.visitLibraryFileFlags(flags);
/* 72 */     if (!sawFirstFlags)
/*    */     {
/* 75 */       libraryInfo.setHasGlldbFlag(flags.contains("-glldb"));
/* 76 */       sawFirstFlags = true;
/*    */     }
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.cxx.json.AndroidBuildGradleJsonStatsBuildingVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */