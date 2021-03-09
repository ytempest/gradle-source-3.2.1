/*     */ package com.android.build.gradle.shrinker;
/*     */ 
/*     */ import com.google.common.base.Verify;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.Collection;
/*     */ import java.util.Set;
/*     */ import org.objectweb.asm.AnnotationVisitor;
/*     */ import org.objectweb.asm.FieldVisitor;
/*     */ import org.objectweb.asm.MethodVisitor;
/*     */ import org.objectweb.asm.Type;
/*     */ 
/*     */ class IncrementalRunVisitor<T>
/*     */   extends DependencyFinderVisitor<T>
/*     */ {
/*     */   private final ShrinkerGraph<T> mGraph;
/*     */   private final Collection<T> mModifiedClasses;
/*     */   private final Collection<PostProcessingData.UnresolvedReference<T>> mUnresolvedReferences;
/*     */   private String mClassName;
/*     */   private Set<T> mMethods;
/*     */   private Set<T> mFields;
/*     */   private Set<String> mAnnotations;
/*     */   
/*     */   public IncrementalRunVisitor(ShrinkerGraph<T> graph, Collection<T> modifiedClasses, Collection<PostProcessingData.UnresolvedReference<T>> unresolvedReferences)
/*     */   {
/*  53 */     super(graph, null);
/*  54 */     mGraph = graph;
/*  55 */     mModifiedClasses = modifiedClasses;
/*  56 */     mUnresolvedReferences = unresolvedReferences;
/*     */   }
/*     */   
/*     */   public void visit(int version, int access, String name, String signature, String superName, String[] interfaces)
/*     */   {
/*  67 */     T klass = mGraph.getClassReference(name);
/*  68 */     mClassName = name;
/*     */     
/*  70 */     checkSuperclass(klass, superName);
/*  71 */     checkInterfaces(klass, interfaces);
/*  72 */     checkModifiers(klass, access);
/*     */     
/*  74 */     mMethods = mGraph.getMethods(klass);
/*  75 */     mFields = mGraph.getFields(klass);
/*  76 */     mAnnotations = Sets.newHashSet(mGraph.getAnnotations(klass));
/*  77 */     mModifiedClasses.add(klass);
/*  78 */     super.visit(version, access, name, signature, superName, interfaces);
/*     */   }
/*     */   
/*     */   private void checkModifiers(T klass, int modifiers) {
/*  82 */     int oldModifiers = mGraph.getModifiers(klass);
/*  83 */     if (oldModifiers != modifiers)
/*     */     {
/*  85 */       throw new IncrementalShrinker.IncrementalRunImpossibleException(String.format("%s modifiers changed.", new Object[] { mClassName }));
/*     */     }
/*     */   }
/*     */   
/*     */   private void checkInterfaces(T klass, String[] interfaceNames) {
/*     */     try {
/*  91 */       Set<String> oldNames = ImmutableSet.copyOf(interfaceNames);
/*  92 */       T[] interfaces = mGraph.getInterfaces(klass);
/*  93 */       Set<String> newNames = Sets.newHashSet();
/*  94 */       for (T iface : interfaces) {
/*  95 */         newNames.add(mGraph.getClassName(iface));
/*     */       }
/*     */       
/*  98 */       if (!oldNames.equals(newNames))
/*     */       {
/* 100 */         throw new IncrementalShrinker.IncrementalRunImpossibleException(String.format("%s interfaces changed.", new Object[] { mClassName }));
/*     */       }
/*     */     }
/*     */     catch (ClassLookupException e) {
/* 104 */       throw new IncrementalShrinker.IncrementalRunImpossibleException(String.format("Can't find info for class %s.", new Object[] { mClassName }));
/*     */     }
/*     */   }
/*     */   
/*     */   private void checkSuperclass(T klass, String superName) {
/*     */     try {
/* 110 */       T superclass = mGraph.getSuperclass(klass);
/* 111 */       Verify.verifyNotNull(superclass);
/* 112 */       if (!mGraph.getClassName(superclass).equals(superName))
/*     */       {
/* 114 */         throw new IncrementalShrinker.IncrementalRunImpossibleException(String.format("%s superclass changed.", new Object[] { mClassName }));
/*     */       }
/*     */     }
/*     */     catch (ClassLookupException e) {
/* 118 */       throw new IncrementalShrinker.IncrementalRunImpossibleException(String.format("Can't find info for class %s.", new Object[] { mClassName }));
/*     */     }
/*     */   }
/*     */   
/*     */   public FieldVisitor visitField(int access, final String name, String desc, String signature, Object value)
/*     */   {
/* 125 */     T field = mGraph.getMemberReference(mClassName, name, desc);
/* 126 */     if (!mFields.remove(field))
/*     */     {
/* 128 */       throw new IncrementalShrinker.IncrementalRunImpossibleException(String.format("Field %s.%s:%s added.", new Object[] { mClassName, name, desc }));
/*     */     }
/*     */     
/* 131 */     if (mGraph.getModifiers(field) != access)
/*     */     {
/* 133 */       throw new IncrementalShrinker.IncrementalRunImpossibleException(String.format("Field %s.%s:%s modifiers changed.", new Object[] { mClassName, name, desc }));
/*     */     }
/*     */     
/* 136 */     final Set<String> memberAnnotations = Sets.newHashSet(mGraph.getAnnotations(field));
/* 137 */     FieldVisitor superVisitor = super.visitField(access, name, desc, signature, value);
/* 138 */     new FieldVisitor(327680, superVisitor)
/*     */     {
/*     */       public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
/* 141 */         IncrementalRunVisitor.checkForAddedAnnotation(desc, memberAnnotations, mClassName + "." + name);
/* 142 */         return super.visitAnnotation(desc, visible);
/*     */       }
/*     */       
/*     */       public void visitEnd()
/*     */       {
/* 147 */         IncrementalRunVisitor.checkForRemovedAnnotation(memberAnnotations, mClassName + "." + name);
/* 148 */         super.visitEnd();
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   public MethodVisitor visitMethod(int access, final String name, String desc, String signature, String[] exceptions)
/*     */   {
/* 156 */     T method = mGraph.getMemberReference(mClassName, name, desc);
/*     */     
/* 158 */     if (!mMethods.remove(method))
/*     */     {
/* 160 */       throw new IncrementalShrinker.IncrementalRunImpossibleException(String.format("Method %s.%s:%s added.", new Object[] { mClassName, name, desc }));
/*     */     }
/*     */     
/* 163 */     if (mGraph.getModifiers(method) != access)
/*     */     {
/* 165 */       throw new IncrementalShrinker.IncrementalRunImpossibleException(String.format("Method %s.%s:%s modifiers changed.", new Object[] { mClassName, name, desc }));
/*     */     }
/*     */     
/* 168 */     final Set<String> memberAnnotations = Sets.newHashSet(mGraph.getAnnotations(method));
/* 169 */     MethodVisitor superVisitor = super.visitMethod(access, name, desc, signature, exceptions);
/* 170 */     new MethodVisitor(327680, superVisitor)
/*     */     {
/*     */       public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
/* 173 */         IncrementalRunVisitor.checkForAddedAnnotation(desc, memberAnnotations, mClassName + "." + name);
/* 174 */         return super.visitAnnotation(desc, visible);
/*     */       }
/*     */       
/*     */       public void visitEnd()
/*     */       {
/* 179 */         IncrementalRunVisitor.checkForRemovedAnnotation(memberAnnotations, mClassName + "." + name);
/* 180 */         super.visitEnd();
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */   public AnnotationVisitor visitAnnotation(String desc, boolean visible)
/*     */   {
/* 187 */     checkForAddedAnnotation(desc, mAnnotations, mClassName);
/* 188 */     return super.visitAnnotation(desc, visible);
/*     */   }
/*     */   
/*     */   protected void handleDependency(T source, T target, DependencyType type)
/*     */   {
/* 193 */     if ((type == DependencyType.REQUIRED_CODE_REFERENCE) || (type == DependencyType.REQUIRED_CODE_REFERENCE_REFLECTION))
/*     */     {
/* 195 */       mGraph.addDependency(source, target, type);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void handleMultipleInheritance(T klass) {}
/*     */   
/*     */   protected void handleVirtualMethod(T method) {}
/*     */   
/*     */   protected void handleInterfaceInheritance(T klass) {}
/*     */   
/*     */   protected void handleUnresolvedReference(PostProcessingData.UnresolvedReference<T> reference)
/*     */   {
/* 210 */     mUnresolvedReferences.add(reference);
/*     */   }
/*     */   
/*     */   public void visitEnd()
/*     */   {
/* 215 */     T field = Iterables.getFirst(mFields, null);
/* 216 */     if (field != null)
/*     */     {
/* 218 */       throw new IncrementalShrinker.IncrementalRunImpossibleException(String.format("Field %s.%s:%s removed.", new Object[] { mClassName, mGraph
/*     */       
/* 221 */         .getMemberName(field), mGraph
/* 222 */         .getMemberDescriptor(field) }));
/*     */     }
/*     */     
/* 225 */     for (T method : mMethods) {
/* 226 */       if (!mGraph.getMemberName(method).endsWith("$shrinker_fake"))
/*     */       {
/* 230 */         throw new IncrementalShrinker.IncrementalRunImpossibleException(String.format("Method %s.%s:%s removed.", new Object[] { mClassName, mGraph
/*     */         
/* 233 */           .getMemberName(method), mGraph
/* 234 */           .getMemberDescriptor(method) }));
/*     */       }
/*     */     }
/* 237 */     checkForRemovedAnnotation(mAnnotations, mClassName);
/*     */   }
/*     */   
/*     */   private static void checkForAddedAnnotation(String desc, Set<String> annotations, String target)
/*     */   {
/* 242 */     String name = Type.getType(desc).getInternalName();
/* 243 */     if (!annotations.remove(name))
/*     */     {
/* 245 */       throw new IncrementalShrinker.IncrementalRunImpossibleException(String.format("Annotation %s on %s added.", new Object[] { name, target }));
/*     */     }
/*     */   }
/*     */   
/*     */   private static void checkForRemovedAnnotation(Set<String> annotations, String target) {
/* 250 */     String annotation = (String)Iterables.getFirst(annotations, null);
/* 251 */     if (annotation != null)
/*     */     {
/* 253 */       throw new IncrementalShrinker.IncrementalRunImpossibleException(String.format("Annotation %s on %s removed.", new Object[] { annotation, target }));
/*     */     }
/*     */   }
/*     */ }

/* Location:
 * Qualified Name:     com.android.build.gradle.shrinker.IncrementalRunVisitor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */