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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.ValidationResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

public class QualificationResultDiffblueTest {
  /**
   * Method under test:
   * {@link QualificationResult#getUniqueSuccessQualifyResult()}
   */
  @Test
  public void testGetUniqueSuccessQualifyResult() {
    // Arrange
    Class<Object> qualifiedRosettaObjectType = Object.class;

    // Act and Assert
    assertFalse((new QualificationResult(qualifiedRosettaObjectType, new ArrayList<>())).getUniqueSuccessQualifyResult()
        .isPresent());
  }

  /**
   * Method under test:
   * {@link QualificationResult#getUniqueSuccessQualifyResult()}
   */
  @Test
  public void testGetUniqueSuccessQualifyResult2() {
    // Arrange
    QualifyResult.QualifyResultBuilder builder = QualifyResult.builder();
    builder.setExpressionResult("Definition", ComparisonResult.success());
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    builder.addAndDataRuleResult(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason));
    QualifyResult qualifyResult = new QualifyResult(builder);

    ArrayList<QualifyResult> allQualifyResults = new ArrayList<>();
    allQualifyResults.add(qualifyResult);
    Class<Object> qualifiedRosettaObjectType = Object.class;

    // Act and Assert
    assertFalse((new QualificationResult(qualifiedRosettaObjectType, allQualifyResults)).getUniqueSuccessQualifyResult()
        .isPresent());
  }

  /**
   * Method under test: {@link QualificationResult#isSuccess()}
   */
  @Test
  public void testIsSuccess() {
    // Arrange
    Class<Object> qualifiedRosettaObjectType = Object.class;

    // Act and Assert
    assertFalse((new QualificationResult(qualifiedRosettaObjectType, new ArrayList<>())).isSuccess());
  }

  /**
   * Method under test: {@link QualificationResult#isSuccess()}
   */
  @Test
  public void testIsSuccess2() {
    // Arrange
    QualifyResult.QualifyResultBuilder builder = QualifyResult.builder();
    builder.setExpressionResult("Definition", ComparisonResult.success());
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    builder.addAndDataRuleResult(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason));
    QualifyResult qualifyResult = new QualifyResult(builder);

    ArrayList<QualifyResult> allQualifyResults = new ArrayList<>();
    allQualifyResults.add(qualifyResult);
    Class<Object> qualifiedRosettaObjectType = Object.class;

    // Act and Assert
    assertFalse((new QualificationResult(qualifiedRosettaObjectType, allQualifyResults)).isSuccess());
  }

  /**
   * Method under test: {@link QualificationResult#toString()}
   */
  @Test
  public void testToString() {
    // Arrange
    Class<Object> qualifiedRosettaObjectType = Object.class;

    // Act and Assert
    assertEquals("QualificationResult { FAILURE on [Object] because [UNMATCHED], errors: [[]] }",
        (new QualificationResult(qualifiedRosettaObjectType, new ArrayList<>())).toString());
  }

  /**
   * Method under test: {@link QualificationResult#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    QualifyResult.QualifyResultBuilder builder = QualifyResult.builder();
    builder.setExpressionResult("Definition", ComparisonResult.success());
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    builder.addAndDataRuleResult(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason));
    QualifyResult qualifyResult = new QualifyResult(builder);

    ArrayList<QualifyResult> allQualifyResults = new ArrayList<>();
    allQualifyResults.add(qualifyResult);
    Class<Object> qualifiedRosettaObjectType = Object.class;

    // Act and Assert
    assertEquals("QualificationResult { FAILURE on [Object] because [UNMATCHED], errors: [[null[foo]]] }",
        (new QualificationResult(qualifiedRosettaObjectType, allQualifyResults)).toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link QualificationResult#QualificationResult(Class, List)}
   *   <li>{@link QualificationResult#getAllQualifyResults()}
   *   <li>{@link QualificationResult#getQualifiedRosettaObjectType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Class<Object> qualifiedRosettaObjectType = Object.class;
    ArrayList<QualifyResult> allQualifyResults = new ArrayList<>();

    // Act
    QualificationResult actualQualificationResult = new QualificationResult(qualifiedRosettaObjectType,
        allQualifyResults);
    List<QualifyResult> actualAllQualifyResults = actualQualificationResult.getAllQualifyResults();
    Class<?> actualQualifiedRosettaObjectType = actualQualificationResult.getQualifiedRosettaObjectType();

    // Assert
    assertTrue(actualAllQualifyResults.isEmpty());
    Class<Object> expectedQualifiedRosettaObjectType = Object.class;
    assertEquals(expectedQualifiedRosettaObjectType, actualQualifiedRosettaObjectType);
    assertSame(allQualifyResults, actualAllQualifyResults);
    assertSame(qualifiedRosettaObjectType, actualQualifiedRosettaObjectType);
  }
}
