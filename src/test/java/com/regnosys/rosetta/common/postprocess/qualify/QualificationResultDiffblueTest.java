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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.qualify.QualifyResult.ExpressionDataRuleResult;
import com.rosetta.model.lib.qualify.QualifyResult.ExpressionDataRuleResult.Type;
import com.rosetta.model.lib.qualify.QualifyResult.QualifyResultBuilder;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ModelValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class QualificationResultDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QualificationResult#QualificationResult(Class, List)}
   *   <li>{@link QualificationResult#getAllQualifyResults()}
   *   <li>{@link QualificationResult#getQualifiedRosettaObjectType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QualificationResult.<init>(Class, List)",
    "List QualificationResult.getAllQualifyResults()",
    "Class QualificationResult.getQualifiedRosettaObjectType()"
  })
  void testGettersAndSetters() {
    // Arrange
    Class<Object> qualifiedRosettaObjectType = Object.class;
    ArrayList<QualifyResult> allQualifyResults = new ArrayList<>();

    // Act
    QualificationResult actualQualificationResult =
        new QualificationResult(qualifiedRosettaObjectType, allQualifyResults);
    List<QualifyResult> actualAllQualifyResults = actualQualificationResult.getAllQualifyResults();
    Class<?> actualQualifiedRosettaObjectType =
        actualQualificationResult.getQualifiedRosettaObjectType();

    // Assert
    assertTrue(actualAllQualifyResults.isEmpty());
    Class<Object> expectedQualifiedRosettaObjectType = Object.class;
    assertEquals(expectedQualifiedRosettaObjectType, actualQualifiedRosettaObjectType);
    assertSame(allQualifyResults, actualAllQualifyResults);
    assertSame(qualifiedRosettaObjectType, actualQualifiedRosettaObjectType);
  }

  /**
   * Test {@link QualificationResult#getUniqueSuccessQualifyResult()}.
   *
   * <p>Method under test: {@link QualificationResult#getUniqueSuccessQualifyResult()}
   */
  @Test
  @DisplayName("Test getUniqueSuccessQualifyResult()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional QualificationResult.getUniqueSuccessQualifyResult()"})
  void testGetUniqueSuccessQualifyResult() {
    // Arrange
    ArrayList<QualifyResult> allQualifyResults = new ArrayList<>();

    QualifyResultBuilder setDefinitionResult = QualifyResult.builder().setDefinition("Definition");
    allQualifyResults.add(
        setDefinitionResult
            .setExpressionResult("Definition", ComparisonResult.success())
            .setName("Name")
            .build());
    Class<Object> qualifiedRosettaObjectType = Object.class;

    QualificationResult qualificationResult =
        new QualificationResult(qualifiedRosettaObjectType, allQualifyResults);

    // Act
    Optional<QualifyResult> actualUniqueSuccessQualifyResult =
        qualificationResult.getUniqueSuccessQualifyResult();

    // Assert
    QualifyResult getResult = actualUniqueSuccessQualifyResult.get();
    Collection<ExpressionDataRuleResult> expressionDataRuleResults =
        getResult.getExpressionDataRuleResults();
    assertEquals(1, expressionDataRuleResults.size());
    assertTrue(expressionDataRuleResults instanceof List);
    ExpressionDataRuleResult getResult2 =
        ((List<ExpressionDataRuleResult>) expressionDataRuleResults).get(0);
    assertEquals("", getResult2.getOperator());
    assertEquals("Definition", getResult.getDefinition());
    assertEquals("Definition", getResult2.getDefinition());
    assertEquals("Expression", getResult2.getName());
    assertEquals("Name", getResult.getName());
    assertNull(getResult2.getError());
    assertEquals(Type.Expression, getResult2.getType());
    assertTrue(getResult.isSuccess());
    assertTrue(getResult2.isSuccess());
    assertTrue(actualUniqueSuccessQualifyResult.isPresent());
  }

  /**
   * Test {@link QualificationResult#getUniqueSuccessQualifyResult()}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link QualificationResult#getUniqueSuccessQualifyResult()}
   */
  @Test
  @DisplayName("Test getUniqueSuccessQualifyResult(); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional QualificationResult.getUniqueSuccessQualifyResult()"})
  void testGetUniqueSuccessQualifyResult_thenReturnNotPresent() {
    // Arrange
    Class<Object> qualifiedRosettaObjectType = Object.class;
    QualificationResult qualificationResult =
        new QualificationResult(qualifiedRosettaObjectType, new ArrayList<>());

    // Act and Assert
    assertFalse(qualificationResult.getUniqueSuccessQualifyResult().isPresent());
  }

  /**
   * Test {@link QualificationResult#isSuccess()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link QualificationResult#isSuccess()}
   */
  @Test
  @DisplayName("Test isSuccess(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QualificationResult.isSuccess()"})
  void testIsSuccess_thenReturnFalse() {
    // Arrange
    Class<Object> qualifiedRosettaObjectType = Object.class;
    QualificationResult qualificationResult =
        new QualificationResult(qualifiedRosettaObjectType, new ArrayList<>());

    // Act and Assert
    assertFalse(qualificationResult.isSuccess());
  }

  /**
   * Test {@link QualificationResult#isSuccess()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link QualificationResult#isSuccess()}
   */
  @Test
  @DisplayName("Test isSuccess(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QualificationResult.isSuccess()"})
  void testIsSuccess_thenReturnTrue() {
    // Arrange
    ArrayList<QualifyResult> allQualifyResults = new ArrayList<>();

    QualifyResultBuilder setDefinitionResult = QualifyResult.builder().setDefinition("Definition");
    allQualifyResults.add(
        setDefinitionResult
            .setExpressionResult("Definition", ComparisonResult.success())
            .setName("Name")
            .build());
    Class<Object> qualifiedRosettaObjectType = Object.class;

    QualificationResult qualificationResult =
        new QualificationResult(qualifiedRosettaObjectType, allQualifyResults);

    // Act and Assert
    assertTrue(qualificationResult.isSuccess());
  }

  /**
   * Test {@link QualificationResult#toString()}.
   *
   * <p>Method under test: {@link QualificationResult#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String QualificationResult.toString()"})
  void testToString() {
    // Arrange
    ArrayList<QualifyResult> allQualifyResults = new ArrayList<>();

    QualifyResultBuilder setDefinitionResult = QualifyResult.builder().setDefinition("Definition");
    allQualifyResults.add(
        setDefinitionResult
            .setExpressionResult("Definition", ComparisonResult.success())
            .setName("Name")
            .build());

    QualifyResultBuilder setDefinitionResult2 = QualifyResult.builder().setDefinition("Definition");
    allQualifyResults.add(
        setDefinitionResult2
            .setExpressionResult("Definition", ComparisonResult.success())
            .setName("Name")
            .build());
    Class<Object> qualifiedRosettaObjectType = Object.class;

    QualificationResult qualificationResult =
        new QualificationResult(qualifiedRosettaObjectType, allQualifyResults);

    // Act and Assert
    assertEquals(
        "QualificationResult { FAILURE on [Object] because [MULTIPLE_MATCHES: Name,Name] }",
        qualificationResult.toString());
  }

  /**
   * Test {@link QualificationResult#toString()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link QualificationResult#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String QualificationResult.toString()"})
  void testToString_thenReturnAString() {
    // Arrange
    QualifyResultBuilder builderResult = QualifyResult.builder();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("QualificationResult { SUCCESS on [%s:%s] }");

    ModelValidationResult<?> result =
        new ModelValidationResult<>(
            "QualificationResult { SUCCESS on [%s:%s] }",
            ValidationType.DATA_RULE,
            "QualificationResult { SUCCESS on [%s:%s] }",
            path,
            "QualificationResult { SUCCESS on [%s:%s] }",
            failureReason);
    builderResult.addAndDataRuleResult(result);

    QualifyResultBuilder setDefinitionResult = builderResult.setDefinition("Definition");
    QualifyResult qualifyResult =
        setDefinitionResult
            .setExpressionResult("Definition", ComparisonResult.success())
            .setName("Name")
            .build();

    ArrayList<QualifyResult> allQualifyResults = new ArrayList<>();
    allQualifyResults.add(qualifyResult);
    Class<Object> qualifiedRosettaObjectType = Object.class;

    QualificationResult qualificationResult =
        new QualificationResult(qualifiedRosettaObjectType, allQualifyResults);

    // Act and Assert
    assertEquals(
        "QualificationResult { FAILURE on [Object] because [UNMATCHED], errors: [[Name[QualificationResult {"
            + " SUCCESS on [%s:%s] }]]] }",
        qualificationResult.toString());
  }

  /**
   * Test {@link QualificationResult#toString()}.
   *
   * <ul>
   *   <li>Then return {@code QualificationResult { FAILURE on [Object] because [UNMATCHED], errors:
   *       [[]] }}.
   * </ul>
   *
   * <p>Method under test: {@link QualificationResult#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'QualificationResult { FAILURE on [Object] because [UNMATCHED], errors: [[]] }'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String QualificationResult.toString()"})
  void testToString_thenReturnQualificationResultFailureOnObjectBecauseUnmatchedErrors() {
    // Arrange
    Class<Object> qualifiedRosettaObjectType = Object.class;
    QualificationResult qualificationResult =
        new QualificationResult(qualifiedRosettaObjectType, new ArrayList<>());

    // Act and Assert
    assertEquals(
        "QualificationResult { FAILURE on [Object] because [UNMATCHED], errors: [[]] }",
        qualificationResult.toString());
  }

  /**
   * Test {@link QualificationResult#toString()}.
   *
   * <ul>
   *   <li>Then return {@code QualificationResult { SUCCESS on [Object:Name] }}.
   * </ul>
   *
   * <p>Method under test: {@link QualificationResult#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'QualificationResult { SUCCESS on [Object:Name] }'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String QualificationResult.toString()"})
  void testToString_thenReturnQualificationResultSuccessOnObjectName() {
    // Arrange
    ArrayList<QualifyResult> allQualifyResults = new ArrayList<>();

    QualifyResultBuilder setDefinitionResult = QualifyResult.builder().setDefinition("Definition");
    allQualifyResults.add(
        setDefinitionResult
            .setExpressionResult("Definition", ComparisonResult.success())
            .setName("Name")
            .build());
    Class<Object> qualifiedRosettaObjectType = Object.class;

    QualificationResult qualificationResult =
        new QualificationResult(qualifiedRosettaObjectType, allQualifyResults);

    // Act and Assert
    assertEquals(
        "QualificationResult { SUCCESS on [Object:Name] }", qualificationResult.toString());
  }
}
