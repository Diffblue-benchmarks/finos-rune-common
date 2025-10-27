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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.meta.Key;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Test;

public class QualificationReportDiffblueTest {
  /**
   * Method under test: {@link QualificationReport#getResultObject()}
   */
  @Test
  public void testGetResultObject() {
    // Arrange
    Key.KeyBuilderImpl ingestedObject = new Key.KeyBuilderImpl();

    // Act and Assert
    assertSame(ingestedObject, (new QualificationReport(ingestedObject, new ArrayList<>())).getResultObject());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QualificationReport#getIngestedObject()}
   *   <li>{@link QualificationReport#getQualifiableObjectsCount()}
   *   <li>{@link QualificationReport#getResults()}
   *   <li>{@link QualificationReport#getUniquelyQualifiedObjectsCount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
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
   * Method under test:
   * {@link QualificationReport#QualificationReport(RosettaModelObject, Collection)}
   */
  @Test
  public void testNewQualificationReport() {
    // Arrange
    BarBuilder ingestedObject = new BarBuilder();
    ArrayList<QualificationResult> results = new ArrayList<>();

    // Act
    QualificationReport actualQualificationReport = new QualificationReport(ingestedObject, results);

    // Assert
    Collection<QualificationResult> results2 = actualQualificationReport.getResults();
    assertTrue(results2 instanceof List);
    assertEquals(0, actualQualificationReport.getQualifiableObjectsCount());
    assertEquals(0, actualQualificationReport.getUniquelyQualifiedObjectsCount());
    assertTrue(results2.isEmpty());
    assertSame(ingestedObject, actualQualificationReport.getIngestedObject());
    assertSame(results, results2);
  }

  /**
   * Method under test:
   * {@link QualificationReport#QualificationReport(RosettaModelObject, Collection)}
   */
  @Test
  public void testNewQualificationReport2() {
    // Arrange
    BarBuilder ingestedObject = new BarBuilder();

    ArrayList<QualificationResult> results = new ArrayList<>();
    Class<Object> qualifiedRosettaObjectType = Object.class;
    results.add(new QualificationResult(qualifiedRosettaObjectType, new ArrayList<>()));

    // Act
    QualificationReport actualQualificationReport = new QualificationReport(ingestedObject, results);

    // Assert
    assertEquals(0, actualQualificationReport.getUniquelyQualifiedObjectsCount());
    assertEquals(1, actualQualificationReport.getQualifiableObjectsCount());
    assertSame(ingestedObject, actualQualificationReport.getIngestedObject());
    assertSame(results, actualQualificationReport.getResults());
  }

  /**
   * Method under test:
   * {@link QualificationReport#QualificationReport(RosettaModelObject, Collection)}
   */
  @Test
  public void testNewQualificationReport3() {
    // Arrange
    BarBuilder ingestedObject = new BarBuilder();

    ArrayList<QualificationResult> results = new ArrayList<>();
    Class<Object> qualifiedRosettaObjectType = Object.class;
    results.add(new QualificationResult(qualifiedRosettaObjectType, new ArrayList<>()));
    Class<Object> qualifiedRosettaObjectType2 = Object.class;
    results.add(new QualificationResult(qualifiedRosettaObjectType2, new ArrayList<>()));

    // Act
    QualificationReport actualQualificationReport = new QualificationReport(ingestedObject, results);

    // Assert
    assertEquals(0, actualQualificationReport.getUniquelyQualifiedObjectsCount());
    assertEquals(2, actualQualificationReport.getQualifiableObjectsCount());
    assertSame(ingestedObject, actualQualificationReport.getIngestedObject());
    assertSame(results, actualQualificationReport.getResults());
  }
}
