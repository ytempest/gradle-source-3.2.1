/*    */ package com.android.build.gradle.tasks;
/*    */ 
/*    */ import com.android.build.gradle.internal.core.Abi;
/*    */ import com.android.build.gradle.internal.ndk.NdkHandler;
/*    */ import com.android.builder.core.AndroidBuilder;
/*    */ import com.android.repository.Revision;
/*    */ import com.android.repository.Revision.Precision;
/*    */ import com.google.wireless.android.sdk.stats.GradleBuildVariant.Builder;
/*    */ import java.io.File;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ 
/*    */ class CmakeExternalNativeJsonGeneratorFactory
/*    */ {
/*    */   public static ExternalNativeJsonGenerator createCmakeStrategy(Revision cmakeRevision, NdkHandler ndkHandler, int minSdkVersion, String variantName, Collection<Abi> abis, AndroidBuilder androidBuilder, File sdkFolder, File ndkFolder, File soFolder, File objFolder, File jsonFolder, File makeFile, File cmakeInstallFolder, boolean debuggable, List<String> buildArguments, List<String> cFlags, List<String> cppFlags, List<File> nativeBuildConfigurationsJsons, GradleBuildVariant.Builder stats)
/*    */   {
/* 57 */     stats.setNativeCmakeVersion(cmakeRevision.toShortString());
/*    */     
/* 61 */     if (cmakeRevision.equals(
/* 62 */       Revision.parseRevision("3.6.0-rc2", Revision.Precision.MICRO)))
/*    */     {
/* 65 */       return new CmakeAndroidNinjaExternalNativeJsonGenerator(ndkHandler, minSdkVersion, variantName, abis, androidBuilder, sdkFolder, ndkFolder, soFolder, objFolder, jsonFolder, makeFile, cmakeInstallFolder, debuggable, buildArguments, cFlags, cppFlags, nativeBuildConfigurationsJsons, stats);
/*    */     }
/*    */     
/* 86 */     if ((cmakeRevision.getMajor() < 3) || (
/* 87 */       (cmakeRevision.getMajor() == 3) && (cmakeRevision.getMinor() <= 6)))
/*    */     {
/* 90 */       throw new RuntimeException("Unexpected/unsupported CMake version " + cmakeRevision.toString() + ". Try 3.7.0 or later.");
/*    */     }
/*    */     
/* 94 */     return new CmakeServerExternalNativeJsonGenerator(ndkHandler, minSdkVersion, variantName, abis, androidBuilder, sdkFolder, ndkFolder, soFolder, objFolder, jsonFolder, makeFile, cmakeInstallFolder, debuggable, buildArguments, cFlags, cppFlags, nativeBuildConfigurationsJsons, stats);
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.tasks.CmakeExternalNativeJsonGeneratorFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */