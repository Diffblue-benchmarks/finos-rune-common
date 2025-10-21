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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class QualificationResultDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QualificationResult#QualificationResult(Class, List)}
   *   <li>{@link QualificationResult#getAllQualifyResults()}
   *   <li>{@link QualificationResult#getQualifiedRosettaObjectType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QualificationResult.<init>(Class, List)", "List QualificationResult.getAllQualifyResults()",
      "Class QualificationResult.getQualifiedRosettaObjectType()"})
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

  /**
   * Test {@link QualificationResult#getUniqueSuccessQualifyResult()}.
   * <p>
   * Method under test: {@link QualificationResult#getUniqueSuccessQualifyResult()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional QualificationResult.getUniqueSuccessQualifyResult()"})
  public void testGetUniqueSuccessQualifyResult() {
    // Arrange
    ArrayList<QualifyResult> allQualifyResults = new ArrayList<>();
    QualifyResultBuilder setDefinitionResult = QualifyResult.builder().setDefinition("Definition");
    QualifyResult buildResult = setDefinitionResult.setExpressionResult("Definition", ComparisonResult.success())
        .setName("Name")
        .build();
    allQualifyResults.add(buildResult);
    Class<Object> qualifiedRosettaObjectType = Object.class;

    // Act
    Optional<QualifyResult> actualUniqueSuccessQualifyResult = (new QualificationResult(qualifiedRosettaObjectType,
        allQualifyResults)).getUniqueSuccessQualifyResult();

    // Assert
    QualifyResult getResult = actualUniqueSuccessQualifyResult.get();
    Collection<ExpressionDataRuleResult> expressionDataRuleResults = getResult.getExpressionDataRuleResults();
    assertEquals(1, expressionDataRuleResults.size());
    assertTrue(expressionDataRuleResults instanceof List);
    ExpressionDataRuleResult getResult2 = ((List<ExpressionDataRuleResult>) expressionDataRuleResults).get(0);
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
   * <ul>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link QualificationResult#getUniqueSuccessQualifyResult()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional QualificationResult.getUniqueSuccessQualifyResult()"})
  public void testGetUniqueSuccessQualifyResult_thenReturnNotPresent() {
    // Arrange
    Class<Object> qualifiedRosettaObjectType = Object.class;

    // Act and Assert
    assertFalse((new QualificationResult(qualifiedRosettaObjectType, new ArrayList<>())).getUniqueSuccessQualifyResult()
        .isPresent());
  }

  /**
   * Test {@link QualificationResult#isSuccess()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QualificationResult#isSuccess()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QualificationResult.isSuccess()"})
  public void testIsSuccess_thenReturnFalse() {
    // Arrange
    Class<Object> qualifiedRosettaObjectType = Object.class;

    // Act and Assert
    assertFalse((new QualificationResult(qualifiedRosettaObjectType, new ArrayList<>())).isSuccess());
  }

  /**
   * Test {@link QualificationResult#isSuccess()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QualificationResult#isSuccess()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean QualificationResult.isSuccess()"})
  public void testIsSuccess_thenReturnTrue() {
    // Arrange
    ArrayList<QualifyResult> allQualifyResults = new ArrayList<>();
    QualifyResultBuilder setDefinitionResult = QualifyResult.builder().setDefinition("Definition");
    QualifyResult buildResult = setDefinitionResult.setExpressionResult("Definition", ComparisonResult.success())
        .setName("Name")
        .build();
    allQualifyResults.add(buildResult);
    Class<Object> qualifiedRosettaObjectType = Object.class;

    // Act and Assert
    assertTrue((new QualificationResult(qualifiedRosettaObjectType, allQualifyResults)).isSuccess());
  }

  /**
   * Test {@link QualificationResult#toString()}.
   * <p>
   * Method under test: {@link QualificationResult#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String QualificationResult.toString()"})
  public void testToString() {
    // Arrange
    ArrayList<QualifyResult> allQualifyResults = new ArrayList<>();
    QualifyResultBuilder setDefinitionResult = QualifyResult.builder().setDefinition("Definition");
    QualifyResult buildResult = setDefinitionResult.setExpressionResult("Definition", ComparisonResult.success())
        .setName("Name")
        .build();
    allQualifyResults.add(buildResult);
    QualifyResultBuilder setDefinitionResult2 = QualifyResult.builder().setDefinition("Definition");
    QualifyResult buildResult2 = setDefinitionResult2.setExpressionResult("Definition", ComparisonResult.success())
        .setName("Name")
        .build();
    allQualifyResults.add(buildResult2);
    Class<Object> qualifiedRosettaObjectType = Object.class;

    // Act and Assert
    assertEquals("QualificationResult { FAILURE on [Object] because [MULTIPLE_MATCHES: Name,Name] }",
        (new QualificationResult(qualifiedRosettaObjectType, allQualifyResults)).toString());
  }

  /**
   * Test {@link QualificationResult#toString()}.
   * <ul>
   *   <li>Given {@link Optional} with {@code QualificationResult { SUCCESS on [%s:%s] }}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link QualificationResult#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String QualificationResult.toString()"})
  public void testToString_givenOptionalWithQualificationResultSuccessOnSS_thenReturnAString() {
    // Arrange
    QualifyResultBuilder builderResult = QualifyResult.builder();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("QualificationResult { SUCCESS on [%s:%s] }");
    builderResult.addAndDataRuleResult(new ModelValidationResult<>("QualificationResult { SUCCESS on [%s:%s] }",
        ValidationType.DATA_RULE, "QualificationResult { SUCCESS on [%s:%s] }", path,
        "QualificationResult { SUCCESS on [%s:%s] }", failureReason));
    QualifyResultBuilder setDefinitionResult = builderResult.setDefinition("Definition");
    QualifyResult buildResult = setDefinitionResult.setExpressionResult("Definition", ComparisonResult.success())
        .setName("Name")
        .build();

    ArrayList<QualifyResult> allQualifyResults = new ArrayList<>();
    allQualifyResults.add(buildResult);
    Class<Object> qualifiedRosettaObjectType = Object.class;

    // Act and Assert
    assertEquals(
        "QualificationResult { FAILURE on [Object] because [UNMATCHED], errors: [[Name[QualificationResult {"
            + " SUCCESS on [%s:%s] }]]] }",
        (new QualificationResult(qualifiedRosettaObjectType, allQualifyResults)).toString());
  }

  /**
   * Test {@link QualificationResult#toString()}.
   * <ul>
   *   <li>Then return {@code QualificationResult { FAILURE on [Object] because [UNMATCHED], errors: [[]] }}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QualificationResult#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String QualificationResult.toString()"})
  public void testToString_thenReturnQualificationResultFailureOnObjectBecauseUnmatchedErrors() {
    // Arrange
    Class<Object> qualifiedRosettaObjectType = Object.class;

    // Act and Assert
    assertEquals("QualificationResult { FAILURE on [Object] because [UNMATCHED], errors: [[]] }",
        (new QualificationResult(qualifiedRosettaObjectType, new ArrayList<>())).toString());
  }

  /**
   * Test {@link QualificationResult#toString()}.
   * <ul>
   *   <li>Then return {@code QualificationResult { SUCCESS on [Object:Name] }}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QualificationResult#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String QualificationResult.toString()"})
  public void testToString_thenReturnQualificationResultSuccessOnObjectName() {
    // Arrange
    ArrayList<QualifyResult> allQualifyResults = new ArrayList<>();
    QualifyResultBuilder setDefinitionResult = QualifyResult.builder().setDefinition("Definition");
    QualifyResult buildResult = setDefinitionResult.setExpressionResult("Definition", ComparisonResult.success())
        .setName("Name")
        .build();
    allQualifyResults.add(buildResult);
    Class<Object> qualifiedRosettaObjectType = Object.class;

    // Act and Assert
    assertEquals("QualificationResult { SUCCESS on [Object:Name] }",
        (new QualificationResult(qualifiedRosettaObjectType, allQualifyResults)).toString());
  }
}
