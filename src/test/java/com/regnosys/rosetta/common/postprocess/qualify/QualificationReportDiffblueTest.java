package com.regnosys.rosetta.common.postprocess.qualify;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.meta.Key;
import com.rosetta.model.lib.meta.Key.KeyBuilderImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class QualificationReportDiffblueTest {
  /**
   * Test {@link QualificationReport#QualificationReport(RosettaModelObject, Collection)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return Results size is one.
   * </ul>
   *
   * <p>Method under test: {@link QualificationReport#QualificationReport(RosettaModelObject,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test new QualificationReport(RosettaModelObject, Collection); given 'java.lang.Object'; then return Results size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QualificationReport.<init>(RosettaModelObject, Collection)"})
  void testNewQualificationReport_givenJavaLangObject_thenReturnResultsSizeIsOne() {
    // Arrange
    BarBuilder ingestedObject = new BarBuilder();

    ArrayList<QualificationResult> results = new ArrayList<>();
    Class<Object> qualifiedRosettaObjectType = Object.class;
    QualificationResult qualificationResult =
        new QualificationResult(qualifiedRosettaObjectType, new ArrayList<>());
    results.add(qualificationResult);

    // Act
    QualificationReport actualQualificationReport =
        new QualificationReport(ingestedObject, results);

    // Assert
    Collection<QualificationResult> results2 = actualQualificationReport.getResults();
    assertEquals(1, results2.size());
    assertTrue(results2 instanceof List);
    assertEquals(1, actualQualificationReport.getQualifiableObjectsCount());
    assertSame(qualificationResult, ((List<QualificationResult>) results2).get(0));
  }

  /**
   * Test {@link QualificationReport#QualificationReport(RosettaModelObject, Collection)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return Results size is two.
   * </ul>
   *
   * <p>Method under test: {@link QualificationReport#QualificationReport(RosettaModelObject,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test new QualificationReport(RosettaModelObject, Collection); given 'java.lang.Object'; then return Results size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QualificationReport.<init>(RosettaModelObject, Collection)"})
  void testNewQualificationReport_givenJavaLangObject_thenReturnResultsSizeIsTwo() {
    // Arrange
    BarBuilder ingestedObject = new BarBuilder();

    ArrayList<QualificationResult> results = new ArrayList<>();
    Class<Object> qualifiedRosettaObjectType = Object.class;
    QualificationResult qualificationResult =
        new QualificationResult(qualifiedRosettaObjectType, new ArrayList<>());
    results.add(qualificationResult);
    Class<Object> qualifiedRosettaObjectType2 = Object.class;
    QualificationResult qualificationResult2 =
        new QualificationResult(qualifiedRosettaObjectType2, new ArrayList<>());
    results.add(qualificationResult2);

    // Act
    QualificationReport actualQualificationReport =
        new QualificationReport(ingestedObject, results);

    // Assert
    Collection<QualificationResult> results2 = actualQualificationReport.getResults();
    assertEquals(2, results2.size());
    assertTrue(results2 instanceof List);
    assertEquals(2, actualQualificationReport.getQualifiableObjectsCount());
    assertSame(qualificationResult2, ((List<QualificationResult>) results2).get(1));
  }

  /**
   * Test {@link QualificationReport#QualificationReport(RosettaModelObject, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return QualifiableObjectsCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link QualificationReport#QualificationReport(RosettaModelObject,
   * Collection)}
   */
  @Test
  @DisplayName(
      "Test new QualificationReport(RosettaModelObject, Collection); when ArrayList(); then return QualifiableObjectsCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QualificationReport.<init>(RosettaModelObject, Collection)"})
  void testNewQualificationReport_whenArrayList_thenReturnQualifiableObjectsCountIsZero() {
    // Arrange
    BarBuilder ingestedObject = new BarBuilder();
    ArrayList<QualificationResult> results = new ArrayList<>();

    // Act
    QualificationReport actualQualificationReport =
        new QualificationReport(ingestedObject, results);

    // Assert
    assertEquals(0, actualQualificationReport.getQualifiableObjectsCount());
    assertEquals(0, actualQualificationReport.getUniquelyQualifiedObjectsCount());
    assertSame(ingestedObject, actualQualificationReport.getIngestedObject());
    assertSame(results, actualQualificationReport.getResults());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QualificationReport#getIngestedObject()}
   *   <li>{@link QualificationReport#getQualifiableObjectsCount()}
   *   <li>{@link QualificationReport#getResults()}
   *   <li>{@link QualificationReport#getUniquelyQualifiedObjectsCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RosettaModelObject QualificationReport.getIngestedObject()",
    "int QualificationReport.getQualifiableObjectsCount()",
    "Collection QualificationReport.getResults()",
    "int QualificationReport.getUniquelyQualifiedObjectsCount()"
  })
  void testGettersAndSetters() {
    // Arrange
    BarBuilder ingestedObject = new BarBuilder();
    ArrayList<QualificationResult> results = new ArrayList<>();

    QualificationReport qualificationReport = new QualificationReport(ingestedObject, results);

    // Act
    RosettaModelObject actualIngestedObject = qualificationReport.getIngestedObject();
    int actualQualifiableObjectsCount = qualificationReport.getQualifiableObjectsCount();
    Collection<QualificationResult> actualResults = qualificationReport.getResults();

    // Assert
    assertTrue(actualResults instanceof List);
    assertEquals(0, actualQualifiableObjectsCount);
    assertEquals(0, qualificationReport.getUniquelyQualifiedObjectsCount());
    assertSame(ingestedObject, actualIngestedObject);
    assertSame(results, actualResults);
  }

  /**
   * Test {@link QualificationReport#getResultObject()}.
   *
   * <ul>
   *   <li>Then return {@link KeyBuilderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link QualificationReport#getResultObject()}
   */
  @Test
  @DisplayName("Test getResultObject(); then return KeyBuilderImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RosettaModelObjectBuilder QualificationReport.getResultObject()"})
  void testGetResultObject_thenReturnKeyBuilderImpl() {
    // Arrange
    KeyBuilderImpl ingestedObject = new KeyBuilderImpl();
    QualificationReport qualificationReport =
        new QualificationReport(ingestedObject, new ArrayList<>());

    // Act and Assert
    assertSame(ingestedObject, qualificationReport.getResultObject());
  }
}
