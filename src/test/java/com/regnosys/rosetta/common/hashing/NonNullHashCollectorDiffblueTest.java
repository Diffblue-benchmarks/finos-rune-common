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
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.regnosys.rosetta.common.serialisation.json.preannotation.testpojo.metafields.ReferenceWithMetaPrice;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.meta.Reference;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import org.junit.Test;
import org.mockito.Mockito;

public class NonNullHashCollectorDiffblueTest {
  /**
   * Method under test:
   * {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessRosetta() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;

    ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl parent = new ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl();
    parent.setReference(null);

    // Act and Assert
    assertFalse(
        nonNullHashCollector.processRosetta(path, rosettaType, (RosettaModelObject) null, parent, AttributeMeta.META));
  }

  /**
   * Method under test:
   * {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessRosetta2() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;

    ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl referenceWithMetaPriceBuilderImpl = new ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl();
    referenceWithMetaPriceBuilderImpl.setReference(null);

    ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl parent = new ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl();
    parent.setReference(null);

    // Act and Assert
    assertFalse(nonNullHashCollector.processRosetta(path, rosettaType, referenceWithMetaPriceBuilderImpl, parent,
        AttributeMeta.META));
  }

  /**
   * Method under test:
   * {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessRosetta3() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    Reference.ReferenceImpl referenceImpl = new Reference.ReferenceImpl(
        "method toBuilder in BarBuilder has not been implemented", "alice.liddell@example.org",
        "method toBuilder in BarBuilder has not been implemented");

    // Act and Assert
    assertTrue(
        nonNullHashCollector.processRosetta(path, rosettaType, referenceImpl, new BarBuilder(), AttributeMeta.META));
  }

  /**
   * Method under test:
   * {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessRosetta4() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    Reference.ReferenceImpl referenceImpl = new Reference.ReferenceImpl(
        "method toBuilder in BarBuilder has not been implemented", "alice.liddell@example.org",
        "method toBuilder in BarBuilder has not been implemented");

    // Act and Assert
    assertTrue(nonNullHashCollector.processRosetta(path, rosettaType, referenceImpl,
        new ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl(), AttributeMeta.META));
  }

  /**
   * Method under test:
   * {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessRosetta5() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    Reference.ReferenceImpl referenceImpl = new Reference.ReferenceImpl(
        "method toBuilder in BarBuilder has not been implemented", "alice.liddell@example.org",
        "method toBuilder in BarBuilder has not been implemented");

    ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl parent = new ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl();
    parent.setReference(Reference.builder());

    // Act and Assert
    assertFalse(nonNullHashCollector.processRosetta(path, rosettaType, referenceImpl, parent, AttributeMeta.META));
  }

  /**
   * Method under test:
   * {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessRosetta6() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    Reference.ReferenceImpl referenceImpl = new Reference.ReferenceImpl(
        "method toBuilder in BarBuilder has not been implemented", "alice.liddell@example.org",
        "method toBuilder in BarBuilder has not been implemented");

    // Act and Assert
    assertFalse(nonNullHashCollector.processRosetta(path, rosettaType, referenceImpl, new BarBuilder(),
        AttributeMeta.GLOBAL_KEY));
  }

  /**
   * Method under test:
   * {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessRosetta7() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    Reference.ReferenceImpl referenceImpl = new Reference.ReferenceImpl(
        "method toBuilder in BarBuilder has not been implemented", "alice.liddell@example.org",
        "method toBuilder in BarBuilder has not been implemented");

    // Act and Assert
    assertFalse(nonNullHashCollector.processRosetta(path, rosettaType, referenceImpl, new BarBuilder(),
        AttributeMeta.GLOBAL_KEY_FIELD));
  }

  /**
   * Method under test:
   * {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessRosetta8() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    Reference.ReferenceImpl referenceImpl = new Reference.ReferenceImpl(
        "method toBuilder in BarBuilder has not been implemented", "alice.liddell@example.org",
        "method toBuilder in BarBuilder has not been implemented");

    // Act and Assert
    assertTrue(nonNullHashCollector.processRosetta(path, rosettaType, referenceImpl, new BarBuilder()));
  }

  /**
   * Method under test:
   * {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessRosetta9() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;
    Reference.ReferenceImpl referenceImpl = new Reference.ReferenceImpl(
        "method toBuilder in BarBuilder has not been implemented", "alice.liddell@example.org",
        "method toBuilder in BarBuilder has not been implemented");

    // Act and Assert
    assertTrue(nonNullHashCollector.processRosetta(path, rosettaType, referenceImpl, new BarBuilder(),
        AttributeMeta.META, null));
  }

  /**
   * Method under test:
   * {@link NonNullHashCollector#processRosetta(RosettaPath, Class, RosettaModelObject, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessRosetta10() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<RosettaModelObject> rosettaType = RosettaModelObject.class;

    ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl referenceWithMetaPriceBuilderImpl = new ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl();
    referenceWithMetaPriceBuilderImpl
        .setReference(new Reference.ReferenceImpl("Scope", "alice.liddell@example.org", "Reference"));

    ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl parent = new ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl();
    parent.setReference(null);

    // Act and Assert
    assertTrue(nonNullHashCollector.processRosetta(path, rosettaType, referenceWithMetaPriceBuilderImpl, parent,
        AttributeMeta.META));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link NonNullHashCollector}
   */
  @Test
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
   * Method under test:
   * {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessBasic() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<Object> rosettaType = Object.class;

    // Act
    nonNullHashCollector.processBasic(path, rosettaType, "Instance", new BarBuilder(), AttributeMeta.META);

    // Assert that nothing has changed
    IntegerReport reportResult = nonNullHashCollector.report();
    assertEquals(0, reportResult.getResult());
    assertEquals(0, nonNullHashCollector.report.getResult());
    assertSame(nonNullHashCollector.report, reportResult);
  }

  /**
   * Method under test:
   * {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessBasic2() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<Object> rosettaType = Object.class;

    // Act
    nonNullHashCollector.processBasic(path, rosettaType, (Object) null, new BarBuilder(), AttributeMeta.META);

    // Assert that nothing has changed
    IntegerReport reportResult = nonNullHashCollector.report();
    assertEquals(0, reportResult.getResult());
    assertEquals(0, nonNullHashCollector.report.getResult());
    assertSame(nonNullHashCollector.report, reportResult);
  }

  /**
   * Method under test:
   * {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessBasic3() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<Object> rosettaType = Object.class;

    // Act
    nonNullHashCollector.processBasic(path, rosettaType, "Instance", new BarBuilder());

    // Assert
    IntegerReport reportResult = nonNullHashCollector.report();
    assertEquals(619772085, reportResult.getResult());
    assertEquals(619772085, nonNullHashCollector.report.getResult());
    assertSame(nonNullHashCollector.report, reportResult);
  }

  /**
   * Method under test:
   * {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessBasic4() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<Object> rosettaType = Object.class;

    // Act
    nonNullHashCollector.processBasic(path, rosettaType, "Instance", new BarBuilder(), AttributeMeta.META, null);

    // Assert that nothing has changed
    IntegerReport reportResult = nonNullHashCollector.report();
    assertEquals(0, reportResult.getResult());
    assertEquals(0, nonNullHashCollector.report.getResult());
    assertSame(nonNullHashCollector.report, reportResult);
  }

  /**
   * Method under test:
   * {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessBasic5() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    Class<Object> rosettaType = Object.class;

    // Act
    nonNullHashCollector.processBasic(path, rosettaType, "Instance", new BarBuilder(), AttributeMeta.META,
        AttributeMeta.EXTERNAL_KEY);

    // Assert
    IntegerReport reportResult = nonNullHashCollector.report();
    assertEquals(619772085, reportResult.getResult());
    assertEquals(619772085, nonNullHashCollector.report.getResult());
    assertSame(nonNullHashCollector.report, reportResult);
  }

  /**
   * Method under test:
   * {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessBasic6() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    when(path.endsWith(Mockito.<RosettaPath>any())).thenReturn(true);
    Class<Object> rosettaType = Object.class;

    // Act
    nonNullHashCollector.processBasic(path, rosettaType, "Instance",
        new ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl(), AttributeMeta.META);

    // Assert
    verify(path).endsWith(isA(RosettaPath.class));
    IntegerReport reportResult = nonNullHashCollector.report();
    assertEquals(619772085, reportResult.getResult());
    assertEquals(619772085, nonNullHashCollector.report.getResult());
    assertSame(nonNullHashCollector.report, reportResult);
  }

  /**
   * Method under test:
   * {@link NonNullHashCollector#processBasic(RosettaPath, Class, Object, RosettaModelObject, AttributeMeta[])}
   */
  @Test
  public void testProcessBasic7() {
    // Arrange
    NonNullHashCollector nonNullHashCollector = new NonNullHashCollector();
    RosettaPath path = mock(RosettaPath.class);
    when(path.endsWith(Mockito.<RosettaPath>any())).thenReturn(false);
    Class<Object> rosettaType = Object.class;

    // Act
    nonNullHashCollector.processBasic(path, rosettaType, "Instance",
        new ReferenceWithMetaPrice.ReferenceWithMetaPriceBuilderImpl(), AttributeMeta.META);

    // Assert that nothing has changed
    verify(path).endsWith(isA(RosettaPath.class));
    IntegerReport reportResult = nonNullHashCollector.report();
    assertEquals(0, reportResult.getResult());
    assertEquals(0, nonNullHashCollector.report.getResult());
    assertSame(nonNullHashCollector.report, reportResult);
  }

  /**
   * Method under test: {@link NonNullHashCollector#report()}
   */
  @Test
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
