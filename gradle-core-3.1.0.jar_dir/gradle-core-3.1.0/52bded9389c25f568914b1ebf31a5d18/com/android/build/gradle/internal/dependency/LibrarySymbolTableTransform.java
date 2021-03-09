/*    */ package com.android.build.gradle.internal.dependency;
/*    */ 
/*    */ import com.android.ide.common.symbols.SymbolIo;
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.UncheckedIOException;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.LinkOption;
/*    */ import java.nio.file.Path;
/*    */ import java.nio.file.attribute.FileAttribute;
/*    */ import java.util.List;
/*    */ import javax.inject.Inject;
/*    */ import org.gradle.api.artifacts.transform.ArtifactTransform;
/*    */ 
/*    */ public class LibrarySymbolTableTransform
/*    */   extends ArtifactTransform
/*    */ {
/*    */   public List<File> transform(File explodedAar)
/*    */   {
/*    */     try
/*    */     {
/* 52 */       Path result = transform(explodedAar.toPath(), getOutputDirectory().toPath());
/* 53 */       return result != null ? ImmutableList.of(result.toFile()) : ImmutableList.of();
/*    */     } catch (IOException e) {
/* 55 */       throw new UncheckedIOException(e);
/*    */     }
/*    */   }
/*    */   
/*    */   private static Path transform(Path explodedAar, Path outputDirectory)
/*    */     throws IOException
/*    */   {
/* 62 */     Path manifest = explodedAar.resolve("AndroidManifest.xml");
/* 63 */     if (!Files.exists(manifest, new LinkOption[0])) {
/* 64 */       return null;
/*    */     }
/*    */     
/* 67 */     Path rTxt = explodedAar.resolve("R.txt");
/* 68 */     Files.createDirectories(outputDirectory, new FileAttribute[0]);
/* 69 */     Path outputFile = outputDirectory.resolve("package-aware-r.txt");
/* 70 */     SymbolIo.writeSymbolTableWithPackage(rTxt, manifest, outputFile);
/* 71 */     return outputFile;
/*    */   }
/*    */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.dependency.LibrarySymbolTableTransform
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */