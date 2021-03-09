/*     */ package com.android.build.gradle.internal.incremental;
/*     */ 
/*     */ import com.google.common.base.MoreObjects;
/*     */ import com.google.common.base.MoreObjects.ToStringHelper;
/*     */ import java.io.File;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NamedNodeMap;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ public class InstantRunBuildContext$Artifact
/*     */ {
/*     */   private final FileType fileType;
/*     */   private File location;
/*     */   
/*     */   public InstantRunBuildContext$Artifact(FileType fileType, File location)
/*     */   {
/* 223 */     this.fileType = fileType;
/* 224 */     this.location = location;
/*     */   }
/*     */   
/*     */   public Node toXml(Document document)
/*     */   {
/* 229 */     Element artifact = document.createElement("artifact");
/* 230 */     artifact.setAttribute("type", fileType.name());
/* 231 */     artifact.setAttribute("location", location.getAbsolutePath());
/* 232 */     return artifact;
/*     */   }
/*     */   
/*     */   public static Artifact fromXml(Node artifactNode)
/*     */   {
/* 237 */     NamedNodeMap attributes = artifactNode.getAttributes();
/* 238 */     return new Artifact(
/* 239 */       FileType.valueOf(attributes.getNamedItem("type").getNodeValue()), new File(attributes
/* 240 */       .getNamedItem("location").getNodeValue()));
/*     */   }
/*     */   
/*     */   public File getLocation()
/*     */   {
/* 245 */     return location;
/*     */   }
/*     */   
/*     */   public boolean isAccumulative()
/*     */   {
/* 253 */     return fileType != FileType.RELOAD_DEX;
/*     */   }
/*     */   
/*     */   public void setLocation(File location) {
/* 257 */     this.location = location;
/*     */   }
/*     */   
/*     */   public FileType getType()
/*     */   {
/* 262 */     return fileType;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 267 */     return 
/*     */     
/* 270 */       MoreObjects.toStringHelper(this).add("fileType", fileType).add("location", location).toString();
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.incremental.InstantRunBuildContext.Artifact
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */