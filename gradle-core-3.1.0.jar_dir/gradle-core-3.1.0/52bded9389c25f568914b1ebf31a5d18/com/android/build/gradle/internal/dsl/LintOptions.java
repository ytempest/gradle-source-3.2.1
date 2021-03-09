/*     */ package com.android.build.gradle.internal.dsl;
/*     */ 
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import javax.inject.Inject;
/*     */ import org.gradle.api.GradleException;
/*     */ import org.gradle.api.tasks.Input;
/*     */ import org.gradle.api.tasks.InputFile;
/*     */ import org.gradle.api.tasks.Optional;
/*     */ import org.gradle.api.tasks.OutputFile;
/*     */ 
/*     */ public class LintOptions
/*     */   implements com.android.builder.model.LintOptions, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  40 */   private Set<String> disable = Sets.newHashSet();
/*  41 */   private Set<String> enable = Sets.newHashSet();
/*  42 */   private Set<String> check = Sets.newHashSet();
/*  43 */   private boolean abortOnError = true;
/*  44 */   private boolean absolutePaths = true;
/*     */   private boolean noLines;
/*     */   private boolean quiet;
/*     */   private boolean checkAllWarnings;
/*     */   private boolean ignoreWarnings;
/*     */   private boolean warningsAsErrors;
/*     */   private boolean showAll;
/*  51 */   private boolean checkReleaseBuilds = true;
/*  52 */   private boolean explainIssues = true;
/*     */   
/*     */   private boolean checkTestSources;
/*     */   
/*     */   private boolean checkGeneratedSources;
/*     */   private boolean checkDependencies;
/*     */   private File lintConfig;
/*     */   private boolean textReport;
/*     */   private File textOutput;
/*  61 */   private boolean htmlReport = true;
/*     */   
/*     */   private File htmlOutput;
/*  64 */   private boolean xmlReport = true;
/*     */   
/*     */   private File xmlOutput;
/*     */   
/*  68 */   private Map<String, Integer> severities = Maps.newHashMap();
/*     */   
/*     */   private File baselineFile;
/*     */   
/*     */   @Inject
/*     */   public LintOptions() {}
/*     */   
/*     */   public LintOptions(Set<String> disable, Set<String> enable, Set<String> check, File lintConfig, boolean textReport, File textOutput, boolean htmlReport, File htmlOutput, boolean xmlReport, File xmlOutput, boolean abortOnError, boolean absolutePaths, boolean noLines, boolean quiet, boolean checkAllWarnings, boolean ignoreWarnings, boolean warningsAsErrors, boolean showAll, boolean explainIssues, boolean checkReleaseBuilds, boolean checkTestSources, boolean checkGeneratedSources, boolean checkDependencies, File baselineFile, Map<String, Integer> severityOverrides)
/*     */   {
/* 100 */     this.disable = disable;
/* 101 */     this.enable = enable;
/* 102 */     this.check = check;
/* 103 */     this.lintConfig = lintConfig;
/* 104 */     this.textReport = textReport;
/* 105 */     this.textOutput = textOutput;
/* 106 */     this.htmlReport = htmlReport;
/* 107 */     this.htmlOutput = htmlOutput;
/* 108 */     this.xmlReport = xmlReport;
/* 109 */     this.xmlOutput = xmlOutput;
/* 110 */     this.abortOnError = abortOnError;
/* 111 */     this.absolutePaths = absolutePaths;
/* 112 */     this.noLines = noLines;
/* 113 */     this.quiet = quiet;
/* 114 */     this.checkAllWarnings = checkAllWarnings;
/* 115 */     this.ignoreWarnings = ignoreWarnings;
/* 116 */     this.warningsAsErrors = warningsAsErrors;
/* 117 */     this.showAll = showAll;
/* 118 */     this.explainIssues = explainIssues;
/* 119 */     this.checkReleaseBuilds = checkReleaseBuilds;
/* 120 */     this.checkTestSources = checkTestSources;
/* 121 */     this.checkGeneratedSources = checkGeneratedSources;
/* 122 */     this.checkDependencies = checkDependencies;
/* 123 */     this.baselineFile = baselineFile;
/*     */     
/* 125 */     if (severityOverrides != null) {
/* 126 */       for (Map.Entry<String, Integer> entry : severityOverrides.entrySet()) {
/* 127 */         severities.put(entry.getKey(), entry.getValue());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static com.android.builder.model.LintOptions create(com.android.builder.model.LintOptions source)
/*     */   {
/* 134 */     return new LintOptions(source
/* 135 */       .getDisable(), source
/* 136 */       .getEnable(), source
/* 137 */       .getCheck(), source
/* 138 */       .getLintConfig(), source
/* 139 */       .getTextReport(), source
/* 140 */       .getTextOutput(), source
/* 141 */       .getHtmlReport(), source
/* 142 */       .getHtmlOutput(), source
/* 143 */       .getXmlReport(), source
/* 144 */       .getXmlOutput(), source
/* 145 */       .isAbortOnError(), source
/* 146 */       .isAbsolutePaths(), source
/* 147 */       .isNoLines(), source
/* 148 */       .isQuiet(), source
/* 149 */       .isCheckAllWarnings(), source
/* 150 */       .isIgnoreWarnings(), source
/* 151 */       .isWarningsAsErrors(), source
/* 152 */       .isShowAll(), source
/* 153 */       .isExplainIssues(), source
/* 154 */       .isCheckReleaseBuilds(), source
/* 155 */       .isCheckTestSources(), source
/* 156 */       .isCheckGeneratedSources(), source
/* 157 */       .isCheckDependencies(), source
/* 158 */       .getBaselineFile(), source
/* 159 */       .getSeverityOverrides());
/*     */   }
/*     */   
/*     */   @Input
/*     */   public Set<String> getDisable()
/*     */   {
/* 170 */     return disable;
/*     */   }
/*     */   
/*     */   public void setDisable(Set<String> ids)
/*     */   {
/* 178 */     disable.addAll(ids);
/*     */   }
/*     */   
/*     */   @Input
/*     */   public Set<String> getEnable()
/*     */   {
/* 189 */     return enable;
/*     */   }
/*     */   
/*     */   public void setEnable(Set<String> ids)
/*     */   {
/* 197 */     enable.addAll(ids);
/*     */   }
/*     */   
/*     */   @Optional
/*     */   @Input
/*     */   public Set<String> getCheck()
/*     */   {
/* 210 */     return check;
/*     */   }
/*     */   
/*     */   public void setCheck(Set<String> ids)
/*     */   {
/* 218 */     check.addAll(ids);
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean isAbortOnError()
/*     */   {
/* 225 */     return abortOnError;
/*     */   }
/*     */   
/*     */   public void setAbortOnError(boolean abortOnError)
/*     */   {
/* 230 */     this.abortOnError = abortOnError;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean isAbsolutePaths()
/*     */   {
/* 240 */     return absolutePaths;
/*     */   }
/*     */   
/*     */   public void setAbsolutePaths(boolean absolutePaths)
/*     */   {
/* 248 */     this.absolutePaths = absolutePaths;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean isNoLines()
/*     */   {
/* 258 */     return noLines;
/*     */   }
/*     */   
/*     */   public void setNoLines(boolean noLines)
/*     */   {
/* 266 */     this.noLines = noLines;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean isQuiet()
/*     */   {
/* 276 */     return quiet;
/*     */   }
/*     */   
/*     */   public void setQuiet(boolean quiet)
/*     */   {
/* 284 */     this.quiet = quiet;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean isCheckAllWarnings()
/*     */   {
/* 291 */     return checkAllWarnings;
/*     */   }
/*     */   
/*     */   public void setCheckAllWarnings(boolean warnAll)
/*     */   {
/* 296 */     checkAllWarnings = warnAll;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean isIgnoreWarnings()
/*     */   {
/* 303 */     return ignoreWarnings;
/*     */   }
/*     */   
/*     */   public void setIgnoreWarnings(boolean noWarnings)
/*     */   {
/* 308 */     ignoreWarnings = noWarnings;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean isWarningsAsErrors()
/*     */   {
/* 315 */     return warningsAsErrors;
/*     */   }
/*     */   
/*     */   public void setWarningsAsErrors(boolean allErrors)
/*     */   {
/* 320 */     warningsAsErrors = allErrors;
/*     */   }
/*     */   
/*     */   public boolean isCheckTestSources()
/*     */   {
/* 325 */     return checkTestSources;
/*     */   }
/*     */   
/*     */   public void setCheckTestSources(boolean checkTestSources)
/*     */   {
/* 330 */     this.checkTestSources = checkTestSources;
/*     */   }
/*     */   
/*     */   public boolean isCheckGeneratedSources()
/*     */   {
/* 335 */     return checkGeneratedSources;
/*     */   }
/*     */   
/*     */   public void setCheckGeneratedSources(boolean checkGeneratedSources)
/*     */   {
/* 340 */     this.checkGeneratedSources = checkGeneratedSources;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean isCheckDependencies()
/*     */   {
/* 346 */     return checkDependencies;
/*     */   }
/*     */   
/*     */   public void setCheckDependencies(boolean checkDependencies)
/*     */   {
/* 351 */     this.checkDependencies = checkDependencies;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean isExplainIssues()
/*     */   {
/* 359 */     return explainIssues;
/*     */   }
/*     */   
/*     */   public void setExplainIssues(boolean explainIssues) {
/* 363 */     this.explainIssues = explainIssues;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean isShowAll()
/*     */   {
/* 373 */     return showAll;
/*     */   }
/*     */   
/*     */   public void setShowAll(boolean showAll)
/*     */   {
/* 381 */     this.showAll = showAll;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean isCheckReleaseBuilds()
/*     */   {
/* 391 */     return checkReleaseBuilds;
/*     */   }
/*     */   
/*     */   public void setCheckReleaseBuilds(boolean checkReleaseBuilds) {
/* 395 */     this.checkReleaseBuilds = checkReleaseBuilds;
/*     */   }
/*     */   
/*     */   @Optional
/*     */   @InputFile
/*     */   public File getLintConfig()
/*     */   {
/* 405 */     return lintConfig;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean getTextReport()
/*     */   {
/* 413 */     return textReport;
/*     */   }
/*     */   
/*     */   public void setTextReport(boolean textReport) {
/* 417 */     this.textReport = textReport;
/*     */   }
/*     */   
/*     */   public void setHtmlReport(boolean htmlReport) {
/* 421 */     this.htmlReport = htmlReport;
/*     */   }
/*     */   
/*     */   public void setHtmlOutput(File htmlOutput) {
/* 425 */     this.htmlOutput = htmlOutput;
/*     */   }
/*     */   
/*     */   public void setXmlReport(boolean xmlReport) {
/* 429 */     this.xmlReport = xmlReport;
/*     */   }
/*     */   
/*     */   public void setXmlOutput(File xmlOutput) {
/* 433 */     if (xmlOutput.getName().equals("lint.xml")) {
/* 434 */       throw new GradleException("Don't set the xmlOutput file to \"lint.xml\"; that's a reserved filename used for for lint configuration files, not reports.");
/*     */     }
/*     */     
/* 437 */     this.xmlOutput = xmlOutput;
/*     */   }
/*     */   
/*     */   @Optional
/*     */   @Input
/*     */   public File getTextOutput()
/*     */   {
/* 449 */     return textOutput;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean getHtmlReport()
/*     */   {
/* 457 */     return htmlReport;
/*     */   }
/*     */   
/*     */   @Optional
/*     */   @OutputFile
/*     */   public File getHtmlOutput()
/*     */   {
/* 466 */     return htmlOutput;
/*     */   }
/*     */   
/*     */   @Input
/*     */   public boolean getXmlReport()
/*     */   {
/* 474 */     return xmlReport;
/*     */   }
/*     */   
/*     */   @Optional
/*     */   @OutputFile
/*     */   public File getXmlOutput()
/*     */   {
/* 483 */     return xmlOutput;
/*     */   }
/*     */   
/*     */   public void setLintConfig(File lintConfig)
/*     */   {
/* 491 */     this.lintConfig = lintConfig;
/*     */   }
/*     */   
/*     */   public File getBaselineFile()
/*     */   {
/* 496 */     return baselineFile;
/*     */   }
/*     */   
/*     */   public void setBaselineFile(File baselineFile) {
/* 500 */     this.baselineFile = baselineFile;
/*     */   }
/*     */   
/*     */   public void baseline(String baseline)
/*     */   {
/* 505 */     File file = new File(baseline);
/* 506 */     if (!file.isAbsolute())
/*     */     {
/* 509 */       file = file.getAbsoluteFile();
/*     */     }
/* 511 */     baselineFile = file;
/*     */   }
/*     */   
/*     */   public void baseline(File baselineFile) {
/* 515 */     this.baselineFile = baselineFile;
/*     */   }
/*     */   
/*     */   public Map<String, Integer> getSeverityOverrides()
/*     */   {
/* 529 */     if ((severities == null) || (severities.isEmpty())) {
/* 530 */       return null;
/*     */     }
/*     */     
/* 533 */     return severities;
/*     */   }
/*     */   
/*     */   public void check(String id)
/*     */   {
/* 542 */     check.add(id);
/*     */   }
/*     */   
/*     */   public void check(String... ids)
/*     */   {
/* 549 */     for (String id : ids) {
/* 550 */       check(id);
/*     */     }
/*     */   }
/*     */   
/*     */   public void enable(String id)
/*     */   {
/* 558 */     enable.add(id);
/* 559 */     severities.put(id, Integer.valueOf(6));
/*     */   }
/*     */   
/*     */   public void enable(String... ids)
/*     */   {
/* 566 */     for (String id : ids) {
/* 567 */       enable(id);
/*     */     }
/*     */   }
/*     */   
/*     */   public void disable(String id)
/*     */   {
/* 575 */     disable.add(id);
/* 576 */     severities.put(id, Integer.valueOf(5));
/*     */   }
/*     */   
/*     */   public void disable(String... ids)
/*     */   {
/* 583 */     for (String id : ids) {
/* 584 */       disable(id);
/*     */     }
/*     */   }
/*     */   
/*     */   public void textOutput(String textOutput)
/*     */   {
/* 591 */     this.textOutput = new File(textOutput);
/*     */   }
/*     */   
/*     */   public void textOutput(File textOutput)
/*     */   {
/* 597 */     this.textOutput = textOutput;
/*     */   }
/*     */   
/*     */   public void fatal(String id)
/*     */   {
/* 604 */     severities.put(id, Integer.valueOf(1));
/*     */   }
/*     */   
/*     */   public void fatal(String... ids)
/*     */   {
/* 611 */     for (String id : ids) {
/* 612 */       fatal(id);
/*     */     }
/*     */   }
/*     */   
/*     */   public void error(String id)
/*     */   {
/* 620 */     severities.put(id, Integer.valueOf(2));
/*     */   }
/*     */   
/*     */   public void error(String... ids)
/*     */   {
/* 627 */     for (String id : ids) {
/* 628 */       error(id);
/*     */     }
/*     */   }
/*     */   
/*     */   public void warning(String id)
/*     */   {
/* 636 */     severities.put(id, Integer.valueOf(3));
/*     */   }
/*     */   
/*     */   public void warning(String... ids)
/*     */   {
/* 643 */     for (String id : ids) {
/* 644 */       warning(id);
/*     */     }
/*     */   }
/*     */   
/*     */   public void ignore(String id)
/*     */   {
/* 652 */     severities.put(id, Integer.valueOf(5));
/*     */   }
/*     */   
/*     */   public void ignore(String... ids)
/*     */   {
/* 659 */     for (String id : ids) {
/* 660 */       ignore(id);
/*     */     }
/*     */   }
/*     */   
/*     */   public void informational(String id)
/*     */   {
/* 668 */     severities.put(id, Integer.valueOf(4));
/*     */   }
/*     */   
/*     */   public void informational(String... ids)
/*     */   {
/* 676 */     for (String id : ids) {
/* 677 */       informational(id);
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dsl.LintOptions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */