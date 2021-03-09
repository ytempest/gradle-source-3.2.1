/*    */ package com.android.build.gradle.internal.cxx.json;
/*    */ 
/*    */ import com.google.common.collect.Lists;
/*    */ import com.google.common.collect.Maps;
/*    */ import java.io.File;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class NativeBuildConfigValueMini
/*    */ {
/* 34 */   public List<File> buildFiles = Lists.newArrayList();
/* 35 */   public List<String> cleanCommands = Lists.newArrayList();
/* 36 */   public Map<String, NativeLibraryValueMini> libraries = Maps.newHashMap();
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.cxx.json.NativeBuildConfigValueMini
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */