/*     */ package com.android.build.gradle.internal.transforms;
/*     */ 
/*     */ import com.android.build.api.transform.TransformOutputProvider;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ class InstantRunSlicer$Slices
/*     */ {
/* 258 */   private final List<InstantRunSlicer.Slice> slices = new ArrayList();
/*     */   
/*     */   private InstantRunSlicer$Slices()
/*     */   {
/* 262 */     for (int i = 0; i < 10; i++) {
/* 263 */       InstantRunSlicer.Slice newSlice = new InstantRunSlicer.Slice("slice_" + i, i, null);
/* 264 */       slices.add(newSlice);
/*     */     }
/*     */   }
/*     */   
/*     */   private void addElement(String packagePath, File file) {
/* 269 */     InstantRunSlicer.Slice.SlicedElement slicedElement = new InstantRunSlicer.Slice.SlicedElement(packagePath, file, null);
/* 270 */     InstantRunSlicer.Slice slice = getSliceFor(slicedElement);
/* 271 */     InstantRunSlicer.Slice.access$700(slice, slicedElement);
/*     */   }
/*     */   
/*     */   private void writeTo(TransformOutputProvider outputProvider) throws IOException {
/* 275 */     for (InstantRunSlicer.Slice slice : slices) {
/* 276 */       InstantRunSlicer.Slice.access$800(slice, outputProvider);
/*     */     }
/*     */   }
/*     */   
/*     */   private InstantRunSlicer.Slice getSliceFor(InstantRunSlicer.Slice.SlicedElement slicedElement) {
/* 281 */     return (InstantRunSlicer.Slice)slices.get(slicedElement.getHashBucket());
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.internal.transforms.InstantRunSlicer.Slices
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */