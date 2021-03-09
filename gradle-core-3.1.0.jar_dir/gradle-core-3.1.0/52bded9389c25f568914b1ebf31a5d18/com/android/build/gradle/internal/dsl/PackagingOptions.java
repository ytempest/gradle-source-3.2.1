/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.Set;
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.api.tasks.Input;
/*     */ 
/*     */ public class PackagingOptions
/*     */   implements com.android.builder.model.PackagingOptions
/*     */ {
/*     */   @Inject
/*     */   public PackagingOptions()
/*     */   {
/* 143 */     exclude("/META-INF/LICENSE");
/* 144 */     exclude("/META-INF/LICENSE.txt");
/* 145 */     exclude("/META-INF/MANIFEST.MF");
/* 146 */     exclude("/META-INF/NOTICE");
/* 147 */     exclude("/META-INF/NOTICE.txt");
/* 148 */     exclude("/META-INF/*.DSA");
/* 149 */     exclude("/META-INF/*.EC");
/* 150 */     exclude("/META-INF/*.SF");
/* 151 */     exclude("/META-INF/*.RSA");
/* 152 */     exclude("/META-INF/maven/**");
/* 153 */     exclude("/NOTICE");
/* 154 */     exclude("/NOTICE.txt");
/* 155 */     exclude("/LICENSE.txt");
/* 156 */     exclude("/LICENSE");
/*     */     
/* 160 */     exclude("**/.svn/**");
/* 161 */     exclude("**/CVS/**");
/* 162 */     exclude("**/SCCS/**");
/*     */     
/* 165 */     exclude("**/.*/**");
/* 166 */     exclude("**/.*");
/* 167 */     exclude("**/*~");
/*     */     
/* 170 */     exclude("**/thumbs.db");
/* 171 */     exclude("**/picasa.ini");
/*     */     
/* 174 */     exclude("**/about.html");
/* 175 */     exclude("**/package.html");
/* 176 */     exclude("**/overview.html");
/*     */     
/* 179 */     exclude("**/_*");
/* 180 */     exclude("**/_*/**");
/*     */     
/* 183 */     merge("/META-INF/services/**");
/*     */   }
/*     */   
/* 190 */   private Set<String> excludes = Sets.newHashSet();
/* 191 */   private Set<String> pickFirsts = Sets.newHashSet();
/* 192 */   private Set<String> merges = Sets.newHashSet();
/* 193 */   private Set<String> doNotStrip = Sets.newHashSet();
/*     */   
/*     */   @Input
/*     */   public Set<String> getExcludes()
/*     */   {
/* 202 */     return Sets.newHashSet(excludes);
/*     */   }
/*     */   
/*     */   public void setExcludes(Set<String> excludes) {
/* 206 */     this.excludes = Sets.newHashSet(excludes);
/*     */   }
/*     */   
/*     */   public void exclude(String pattern)
/*     */   {
/* 215 */     excludes.add(pattern);
/*     */   }
/*     */   
/*     */   @Input
/*     */   public Set<String> getPickFirsts()
/*     */   {
/* 226 */     return Sets.newHashSet(pickFirsts);
/*     */   }
/*     */   
/*     */   public void pickFirst(String pattern)
/*     */   {
/* 235 */     pickFirsts.add(pattern);
/*     */   }
/*     */   
/*     */   public void setPickFirsts(Set<String> pickFirsts) {
/* 239 */     this.pickFirsts = Sets.newHashSet(pickFirsts);
/*     */   }
/*     */   
/*     */   @Input
/*     */   public Set<String> getMerges()
/*     */   {
/* 249 */     return Sets.newHashSet(merges);
/*     */   }
/*     */   
/*     */   public void setMerges(Set<String> merges) {
/* 253 */     this.merges = Sets.newHashSet(merges);
/*     */   }
/*     */   
/*     */   public void merge(String pattern)
/*     */   {
/* 262 */     merges.add(pattern);
/*     */   }
/*     */   
/*     */   @Input
/*     */   public Set<String> getDoNotStrip()
/*     */   {
/* 275 */     return Sets.newHashSet(doNotStrip);
/*     */   }
/*     */   
/*     */   public void setDoNotStrip(Set<String> doNotStrip)
/*     */   {
/* 280 */     this.doNotStrip = Sets.newHashSet(doNotStrip);
/*     */   }
/*     */   
/*     */   public void doNotStrip(String pattern)
/*     */   {
/* 290 */     doNotStrip.add(pattern);
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.PackagingOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */