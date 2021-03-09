/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ public class InstantRunBuildContext$Build
/*     */ {
/*     */   private final long buildId;
/*     */   private InstantRunVerifierStatus verifierStatus;
/* 126 */   private List<InstantRunVerifierStatus> allStatuses = new ArrayList();
/*     */   private InstantRunVerifierStatus eligibilityStatus;
/*     */   private InstantRunBuildMode buildMode;
/* 129 */   private final List<InstantRunBuildContext.Artifact> artifacts = new ArrayList();
/*     */   
/*     */   public InstantRunBuildContext$Build(long buildId, InstantRunVerifierStatus verifierStatus, InstantRunBuildMode buildMode, InstantRunVerifierStatus eligibilityStatus)
/*     */   {
/* 136 */     this.buildId = buildId;
/* 137 */     this.verifierStatus = verifierStatus;
/* 138 */     this.buildMode = buildMode;
/* 139 */     this.eligibilityStatus = eligibilityStatus;
/*     */   }
/*     */   
/*     */   public InstantRunBuildContext.Artifact getArtifactForType(FileType fileType)
/*     */   {
/* 144 */     for (InstantRunBuildContext.Artifact artifact : artifacts) {
/* 145 */       if (InstantRunBuildContext.Artifact.access$000(artifact) == fileType) {
/* 146 */         return artifact;
/*     */       }
/*     */     }
/* 149 */     return null;
/*     */   }
/*     */   
/*     */   private Element toXml(Document document) {
/* 153 */     Element build = document.createElement("build");
/* 154 */     toXml(document, build);
/* 155 */     return build;
/*     */   }
/*     */   
/*     */   private void toXml(Document document, Element element) {
/* 159 */     element.setAttribute("timestamp", String.valueOf(buildId));
/* 160 */     element.setAttribute("verifier", verifierStatus.name());
/* 161 */     element.setAttribute("build-mode", buildMode.name());
/* 162 */     if (eligibilityStatus != null) {
/* 163 */       element.setAttribute("ir-eligibility", eligibilityStatus.name());
/*     */     }
/* 165 */     for (InstantRunBuildContext.Artifact artifact : artifacts) {
/* 166 */       element.appendChild(artifact.toXml(document));
/*     */     }
/*     */   }
/*     */   
/*     */   public static Build fromXml(Node buildNode)
/*     */   {
/* 172 */     NamedNodeMap attributes = buildNode.getAttributes();
/* 173 */     Node verifierAttribute = attributes.getNamedItem("verifier");
/* 174 */     Node buildModeAttribute = attributes.getNamedItem("build-mode");
/* 175 */     Node eligibilityAttribute = attributes.getNamedItem("ir-eligibility");
/*     */     
/* 179 */     InstantRunVerifierStatus eligibility = eligibilityAttribute == null ? null : InstantRunVerifierStatus.valueOf(eligibilityAttribute.getNodeValue());
/*     */     
/* 184 */     Build build = new Build(Long.parseLong(attributes.getNamedItem("timestamp").getNodeValue()), InstantRunVerifierStatus.valueOf(verifierAttribute.getNodeValue()), InstantRunBuildMode.valueOf(buildModeAttribute.getNodeValue()), eligibility);
/*     */     
/* 186 */     NodeList childNodes = buildNode.getChildNodes();
/* 187 */     for (int i = 0; i < childNodes.getLength(); i++) {
/* 188 */       Node artifactNode = childNodes.item(i);
/* 189 */       if (artifactNode.getNodeName().equals("artifact")) {
/* 190 */         InstantRunBuildContext.Artifact artifact = InstantRunBuildContext.Artifact.fromXml(artifactNode);
/* 191 */         artifacts.add(artifact);
/*     */       }
/*     */     }
/* 194 */     return build;
/*     */   }
/*     */   
/*     */   public long getBuildId() {
/* 198 */     return buildId;
/*     */   }
/*     */   
/*     */   public List<InstantRunBuildContext.Artifact> getArtifacts()
/*     */   {
/* 203 */     return artifacts;
/*     */   }
/*     */   
/*     */   public InstantRunVerifierStatus getVerifierStatus()
/*     */   {
/* 208 */     return verifierStatus;
/*     */   }
/*     */   
/*     */   public InstantRunBuildMode getBuildMode()
/*     */   {
/* 213 */     return buildMode;
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.InstantRunBuildContext.Build
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */