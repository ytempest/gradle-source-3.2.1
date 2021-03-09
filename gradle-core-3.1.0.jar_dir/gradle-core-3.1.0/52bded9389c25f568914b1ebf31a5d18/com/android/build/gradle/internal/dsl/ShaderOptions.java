/*    */ package com.android.build.gradle.internal.dsl;
/*    */ 
/*    */ import com.google.common.collect.ArrayListMultimap;
/*    */ import com.google.common.collect.ListMultimap;
/*    */ import com.google.common.collect.Lists;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import javax.inject.Inject;
/*    */ 
/*    */ public class ShaderOptions
/*    */   implements CoreShaderOptions
/*    */ {
/* 32 */   List<String> args = Lists.newArrayListWithExpectedSize(2);
/* 33 */   ListMultimap<String, String> scopedArgs = ArrayListMultimap.create();
/*    */   
/*    */   public List<String> getGlslcArgs()
/*    */   {
/* 40 */     return args;
/*    */   }
/*    */   
/*    */   public ListMultimap<String, String> getScopedGlslcArgs()
/*    */   {
/* 45 */     return scopedArgs;
/*    */   }
/*    */   
/*    */   public void glslcArgs(String... options) {
/* 49 */     args.addAll(Arrays.asList(options));
/*    */   }
/*    */   
/*    */   public void glslcScopedArgs(String key, String... options) {
/* 53 */     scopedArgs.putAll(key, Arrays.asList(options));
/*    */   }
/*    */   
/*    */   void _initWith(CoreShaderOptions that) {
/* 57 */     args.clear();
/* 58 */     args.addAll(that.getGlslcArgs());
/*    */     
/* 60 */     scopedArgs.clear();
/* 61 */     scopedArgs.putAll(that.getScopedGlslcArgs());
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.ShaderOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */