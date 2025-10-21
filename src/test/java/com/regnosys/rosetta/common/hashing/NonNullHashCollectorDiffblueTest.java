package com.regnosys.rosetta.common.hashing;

/*-
 * ==============
 * Rune Common
 * ==============
 * Copyright (C) 2018 - 2025 REGnosys
 * ==============
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ==============
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.ReferenceWithMetaPrice;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.meta.Reference;
import com.rosetta.model.lib.meta.Reference.ReferenceImpl;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class NonNullHashCollectorDiffblueTest {
  /**
   * Test new {@link NonNullHashCollector} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link NonNullHashCollector}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NonNullHashCollector.<init>()"})
  public void testNewNonNullHashCollector() {
    // Arrange and Act
    NonNullHashCollector actualNonNullHashCollector = new NonNullHashCollector();

    // Assert
    IntegerReport reportResult = actualNonNullHashCollector.report();
    assertEquals(0, reportResult.getResult());
    assertEquals(0, actualNonNullHashCollector.report.getResult());
    assertSame(actualNonNullHashCollector.report, reportResult);
  }

  /**
   * Test {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <p>
   * Method under test: {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean NonNullHashCollector.processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])"})
  public void testProcessRosettaWithPathRosettaTypeInstanceParentMetas() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    ReferenceImpl referenceImpl = new ReferenceImpl("method toBuilder in BarBuilder has not been implemented",
        "alice.liddell@example.org", "method toBuilder in BarBuilder has not been implemented");

    // Act and Assert
    assertTrue(nonNullHashCollector.processRosetta(path, rosettaType, referenceImpl,
        new ReferenceWithMetaPriceBuilderImpl(), AttributeMeta.META));
  }

  /**
   * Test {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <p>
   * Method under test: {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean NonNullHashCollector.processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])"})
  public void testProcessRosettaWithPathRosettaTypeInstanceParentMetas2() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;

    ReferenceWithMetaPriceBuilderImpl referenceWithMetaPriceBuilderImpl = new ReferenceWithMetaPriceBuilderImpl();
    referenceWithMetaPriceBuilderImpl
        .setReference(new ReferenceImpl("Scope", "alice.liddell@example.org", "Reference"));

    ReferenceWithMetaPriceBuilderImpl parent = new ReferenceWithMetaPriceBuilderImpl();
    parent.setReference(null);

    // Act and Assert
    assertTrue(nonNullHashCollector.processRosetta(path, rosettaType, referenceWithMetaPriceBuilderImpl, parent,
        AttributeMeta.META));
  }

  /**
   * Test {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <ul>
   *   <li>Given builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean NonNullHashCollector.processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])"})
  public void testProcessRosettaWithPathRosettaTypeInstanceParentMetas_givenBuilder() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    ReferenceImpl referenceImpl = new ReferenceImpl("method toBuilder in BarBuilder has not been implemented",
        "alice.liddell@example.org", "method toBuilder in BarBuilder has not been implemented");

    ReferenceWithMetaPriceBuilderImpl parent = new ReferenceWithMetaPriceBuilderImpl();
    parent.setReference(Reference.builder());

    // Act and Assert
    assertFalse(nonNullHashCollector.processRosetta(path, rosettaType, referenceImpl, parent, AttributeMeta.META));
  }

  /**
   * Test {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean NonNullHashCollector.processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])"})
  public void testProcessRosettaWithPathRosettaTypeInstanceParentMetas_givenNull() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;

    ReferenceWithMetaPriceBuilderImpl referenceWithMetaPriceBuilderImpl = new ReferenceWithMetaPriceBuilderImpl();
    referenceWithMetaPriceBuilderImpl.setReference(null);

    ReferenceWithMetaPriceBuilderImpl parent = new ReferenceWithMetaPriceBuilderImpl();
    parent.setReference(null);

    // Act and Assert
    assertFalse(nonNullHashCollector.processRosetta(path, rosettaType, referenceWithMetaPriceBuilderImpl, parent,
        AttributeMeta.META));
  }

  /**
   * Test {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean NonNullHashCollector.processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])"})
  public void testProcessRosettaWithPathRosettaTypeInstanceParentMetas_givenNull_whenNull() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;

    ReferenceWithMetaPriceBuilderImpl parent = new ReferenceWithMetaPriceBuilderImpl();
    parent.setReference(null);

    // Act and Assert
    assertFalse(
        nonNullHashCollector.processRosetta(path, rosettaType, (RosettaModelObject) null, parent, AttributeMeta.META));
  }

  /**
   * Test {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean NonNullHashCollector.processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])"})
  public void testProcessRosettaWithPathRosettaTypeInstanceParentMetas_thenReturnTrue() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    ReferenceImpl referenceImpl = new ReferenceImpl("method toBuilder in BarBuilder has not been implemented",
        "alice.liddell@example.org", "method toBuilder in BarBuilder has not been implemented");

    // Act and Assert
    assertTrue(
        nonNullHashCollector.processRosetta(path, rosettaType, referenceImpl, new BarBuilder(), AttributeMeta.META));
  }

  /**
   * Test {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean NonNullHashCollector.processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])"})
  public void testProcessRosettaWithPathRosettaTypeInstanceParentMetas_thenReturnTrue2() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    ReferenceImpl referenceImpl = new ReferenceImpl("method toBuilder in BarBuilder has not been implemented",
        "alice.liddell@example.org", "method toBuilder in BarBuilder has not been implemented");

    // Act and Assert
    assertTrue(nonNullHashCollector.processRosetta(path, rosettaType, referenceImpl, new BarBuilder()));
  }

  /**
   * Test {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <ul>
   *   <li>When {@code GLOBAL_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean NonNullHashCollector.processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])"})
  public void testProcessRosettaWithPathRosettaTypeInstanceParentMetas_whenGlobalKey() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    ReferenceImpl referenceImpl = new ReferenceImpl("method toBuilder in BarBuilder has not been implemented",
        "alice.liddell@example.org", "method toBuilder in BarBuilder has not been implemented");

    // Act and Assert
    assertFalse(nonNullHashCollector.processRosetta(path, rosettaType, referenceImpl, new BarBuilder(),
        AttributeMeta.GLOBAL_KEY));
  }

  /**
   * Test {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <ul>
   *   <li>When {@code GLOBAL_KEY_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean NonNullHashCollector.processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])"})
  public void testProcessRosettaWithPathRosettaTypeInstanceParentMetas_whenGlobalKeyField() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    ReferenceImpl referenceImpl = new ReferenceImpl("method toBuilder in BarBuilder has not been implemented",
        "alice.liddell@example.org", "method toBuilder in BarBuilder has not been implemented");

    // Act and Assert
    assertFalse(nonNullHashCollector.processRosetta(path, rosettaType, referenceImpl, new BarBuilder(),
        AttributeMeta.GLOBAL_KEY_FIELD));
  }

  /**
   * Test {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <ul>
   *   <li>When {@code META} and {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean NonNullHashCollector.processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])"})
  public void testProcessRosettaWithPathRosettaTypeInstanceParentMetas_whenMetaAndNull() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    ReferenceImpl referenceImpl = new ReferenceImpl("method toBuilder in BarBuilder has not been implemented",
        "alice.liddell@example.org", "method toBuilder in BarBuilder has not been implemented");

    // Act and Assert
    assertTrue(nonNullHashCollector.processRosetta(path, rosettaType, referenceImpl, new BarBuilder(),
        AttributeMeta.META, null));
  }

  /**
   * Test {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <p>
   * Method under test: {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void NonNullHashCollector.processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])"})
  public void testProcessBasicWithPathRosettaTypeInstanceParentMetas() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<Object> rosettaType = Object.class;

    // Act
    nonNullHashCollector.processBasic(path, rosettaType, "Instance", new BarBuilder(), AttributeMeta.META);

    // Assert that nothing has changed
    assertEquals(0, nonNullHashCollector.report().getResult());
    assertEquals(0, nonNullHashCollector.report.getResult());
  }

  /**
   * Test {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <p>
   * Method under test: {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void NonNullHashCollector.processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])"})
  public void testProcessBasicWithPathRosettaTypeInstanceParentMetas2() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<Object> rosettaType = Object.class;

    // Act
    nonNullHashCollector.processBasic(path, rosettaType, "Instance", new BarBuilder());

    // Assert
    assertEquals(619772085, nonNullHashCollector.report().getResult());
    assertEquals(619772085, nonNullHashCollector.report.getResult());
  }

  /**
   * Test {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void NonNullHashCollector.processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])"})
  public void testProcessBasicWithPathRosettaTypeInstanceParentMetas_givenFalse() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    when(path.endsWith(Mockito.<RosettaPath>any())).thenReturn(false);
    Class<Object> rosettaType = Object.class;

    // Act
    nonNullHashCollector.processBasic(path, rosettaType, "Instance", new ReferenceWithMetaPriceBuilderImpl(),
        AttributeMeta.META);

    // Assert that nothing has changed
    verify(path).endsWith(isA(RosettaPath.class));
    assertEquals(0, nonNullHashCollector.report().getResult());
    assertEquals(0, nonNullHashCollector.report.getResult());
  }

  /**
   * Test {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void NonNullHashCollector.processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])"})
  public void testProcessBasicWithPathRosettaTypeInstanceParentMetas_givenTrue() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    when(path.endsWith(Mockito.<RosettaPath>any())).thenReturn(true);
    Class<Object> rosettaType = Object.class;

    // Act
    nonNullHashCollector.processBasic(path, rosettaType, "Instance", new ReferenceWithMetaPriceBuilderImpl(),
        AttributeMeta.META);

    // Assert
    verify(path).endsWith(isA(RosettaPath.class));
    assertEquals(619772085, nonNullHashCollector.report().getResult());
    assertEquals(619772085, nonNullHashCollector.report.getResult());
  }

  /**
   * Test {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <ul>
   *   <li>When {@code META} and {@code EXTERNAL_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void NonNullHashCollector.processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])"})
  public void testProcessBasicWithPathRosettaTypeInstanceParentMetas_whenMetaAndExternalKey() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<Object> rosettaType = Object.class;

    // Act
    nonNullHashCollector.processBasic(path, rosettaType, "Instance", new BarBuilder(), AttributeMeta.META,
        AttributeMeta.EXTERNAL_KEY);

    // Assert
    assertEquals(619772085, nonNullHashCollector.report().getResult());
    assertEquals(619772085, nonNullHashCollector.report.getResult());
  }

  /**
   * Test {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <ul>
   *   <li>When {@code META} and {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void NonNullHashCollector.processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])"})
  public void testProcessBasicWithPathRosettaTypeInstanceParentMetas_whenMetaAndNull() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<Object> rosettaType = Object.class;

    // Act
    nonNullHashCollector.processBasic(path, rosettaType, "Instance", new BarBuilder(), AttributeMeta.META, null);

    // Assert that nothing has changed
    assertEquals(0, nonNullHashCollector.report().getResult());
    assertEquals(0, nonNullHashCollector.report.getResult());
  }

  /**
   * Test {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])} with {@code path}, {@code rosettaType}, {@code instance}, {@code parent}, {@code metas}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void NonNullHashCollector.processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])"})
  public void testProcessBasicWithPathRosettaTypeInstanceParentMetas_whenNull() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<Object> rosettaType = Object.class;

    // Act
    nonNullHashCollector.processBasic(path, rosettaType, (Object) null, new BarBuilder(), AttributeMeta.META);

    // Assert that nothing has changed
    assertEquals(0, nonNullHashCollector.report().getResult());
    assertEquals(0, nonNullHashCollector.report.getResult());
  }

  /**
   * Test {@link NonNullHashCollector#report()}.
   * <p>
   * Method under test: {@link NonNullHashCollector#report()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerReport NonNullHashCollector.report()"})
  public void testReport() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();

    // Act
    IntegerReport actualReportResult = nonNullHashCollector.report();

    // Assert
    assertEquals(0, actualReportResult.getResult());
    assertSame(nonNullHashCollector.report, actualReportResult);
  }
}
