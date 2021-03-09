/*    */ package com.android.build.gradle.internal;
/*    */ 
/*    */ import com.android.build.gradle.internal.ide.JavaLibraryImpl;
/*    */ import com.android.builder.dependency.MavenCoordinatesImpl;
/*    */ import com.android.builder.model.AndroidLibrary;
/*    */ import com.android.builder.model.Dependencies;
/*    */ import com.android.builder.model.Dependencies.ProjectIdentifier;
/*    */ import com.android.builder.model.JavaLibrary;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import com.google.common.collect.Sets;
/*    */ import java.io.File;
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ import java.util.Set;
/*    */ import org.gradle.api.artifacts.Configuration;
/*    */ 
/*    */ public class ConfigurationDependencies
/*    */   implements Dependencies
/*    */ {
/*    */   private final Configuration configuration;
/*    */   
/*    */   public ConfigurationDependencies(Configuration configuration)
/*    */   {
/* 46 */     this.configuration = configuration;
/*    */   }
/*    */   
/*    */   public Collection<AndroidLibrary> getLibraries()
/*    */   {
/* 52 */     return Collections.emptyList();
/*    */   }
/*    */   
/*    */   public Collection<JavaLibrary> getJavaLibraries()
/*    */   {
/* 58 */     Set<File> files = configuration.getFiles();
/* 59 */     if (files.isEmpty()) {
/* 60 */       return Collections.emptySet();
/*    */     }
/* 62 */     Set<JavaLibrary> javaLibraries = Sets.newHashSet();
/* 63 */     int index = 1;
/* 64 */     for (File file : files) {
/* 65 */       javaLibraries.add(new JavaLibraryImpl(file, null, null, 
/*    */       
/* 70 */         ImmutableList.of(), null, new MavenCoordinatesImpl("unknown-" + configuration
/*    */         
/* 73 */         .getName(), "unknown" + index++, "unspecified"), false, false));
/*    */     }
/*    */     
/* 79 */     return javaLibraries;
/*    */   }
/*    */   
/*    */   public Collection<String> getProjects()
/*    */   {
/* 85 */     return Collections.emptyList();
/*    */   }
/*    */   
/*    */   public Collection<Dependencies.ProjectIdentifier> getJavaModules()
/*    */   {
/* 91 */     return Collections.emptyList();
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.ConfigurationDependencies
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */