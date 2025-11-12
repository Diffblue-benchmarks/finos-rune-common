package com.regnosys.rosetta.common.validation;

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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ModelValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidationReportDiffblueTest {
  /**
   * Test {@link ValidationReport#ValidationReport(RosettaModelObject, List)}.
   *
   * <ul>
   *   <li>Then return not success.
   * </ul>
   *
   * <p>Method under test: {@link ValidationReport#ValidationReport(RosettaModelObject, List)}
   */
  @Test
  @DisplayName("Test new ValidationReport(RosettaModelObject, List); then return not success")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidationReport.<init>(RosettaModelObject, List)"})
  void testNewValidationReport_thenReturnNotSuccess() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();

    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("42");

    ModelValidationResult<?> modelValidationResult =
        new ModelValidationResult<>(
            "Name",
            ValidationType.DATA_RULE,
            "Model Object Name",
            path,
            "Definition",
            failureReason);
    validationResults.add(modelValidationResult);

    // Act
    ValidationReport actualValidationReport = new ValidationReport(resultObject, validationResults);

    // Assert
    assertFalse(actualValidationReport.success());
    assertSame(validationResults, actualValidationReport.getValidationResults());
  }

  /**
   * Test {@link ValidationReport#ValidationReport(RosettaModelObject, List)}.
   *
   * <ul>
   *   <li>Then return ValidationResults size is two.
   * </ul>
   *
   * <p>Method under test: {@link ValidationReport#ValidationReport(RosettaModelObject, List)}
   */
  @Test
  @DisplayName(
      "Test new ValidationReport(RosettaModelObject, List); then return ValidationResults size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidationReport.<init>(RosettaModelObject, List)"})
  void testNewValidationReport_thenReturnValidationResultsSizeIsTwo() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();

    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("42");

    ModelValidationResult<?> modelValidationResult =
        new ModelValidationResult<>(
            "Name",
            ValidationType.DATA_RULE,
            "Model Object Name",
            path,
            "Definition",
            failureReason);
    validationResults.add(modelValidationResult);
    RosettaPath path2 = mock(RosettaPath.class);
    Optional<String> failureReason2 = Optional.of("42");

    ModelValidationResult<?> modelValidationResult2 =
        new ModelValidationResult<>(
            "Name",
            ValidationType.DATA_RULE,
            "Model Object Name",
            path2,
            "Definition",
            failureReason2);
    validationResults.add(modelValidationResult2);

    // Act
    ValidationReport actualValidationReport = new ValidationReport(resultObject, validationResults);

    // Assert
    List<ValidationResult<?>> validationResults2 = actualValidationReport.getValidationResults();
    assertEquals(2, validationResults2.size());
    assertSame(modelValidationResult2, validationResults2.get(1));
  }

  /**
   * Test {@link ValidationReport#ValidationReport(RosettaModelObject, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return success.
   * </ul>
   *
   * <p>Method under test: {@link ValidationReport#ValidationReport(RosettaModelObject, List)}
   */
  @Test
  @DisplayName(
      "Test new ValidationReport(RosettaModelObject, List); when ArrayList(); then return success")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidationReport.<init>(RosettaModelObject, List)"})
  void testNewValidationReport_whenArrayList_thenReturnSuccess() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();

    // Act
    ValidationReport actualValidationReport = new ValidationReport(resultObject, new ArrayList<>());

    // Assert
    assertTrue(actualValidationReport.success());
    assertTrue(actualValidationReport.getValidationResults().isEmpty());
    assertSame(resultObject, actualValidationReport.getResultObject());
  }

  /**
   * Test {@link ValidationReport#success()}.
   *
   * <p>Method under test: {@link ValidationReport#success()}
   */
  @Test
  @DisplayName("Test success()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationReport.success()"})
  void testSuccess() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.empty();

    ModelValidationResult<?> modelValidationResult =
        new ModelValidationResult<>(
            "Name",
            ValidationType.DATA_RULE,
            "Model Object Name",
            path,
            "Definition",
            failureReason);
    validationResults.add(modelValidationResult);
    ValidationReport validationReport = new ValidationReport(new BarBuilder(), validationResults);

    // Act and Assert
    assertTrue(validationReport.success());
  }

  /**
   * Test {@link ValidationReport#success()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationReport#success()}
   */
  @Test
  @DisplayName("Test success(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationReport.success()"})
  void testSuccess_thenReturnFalse() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("42");

    ModelValidationResult<?> modelValidationResult =
        new ModelValidationResult<>(
            "Name",
            ValidationType.DATA_RULE,
            "Model Object Name",
            path,
            "Definition",
            failureReason);
    validationResults.add(modelValidationResult);
    ValidationReport validationReport = new ValidationReport(new BarBuilder(), validationResults);

    // Act and Assert
    assertFalse(validationReport.success());
  }

  /**
   * Test {@link ValidationReport#success()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationReport#success()}
   */
  @Test
  @DisplayName("Test success(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationReport.success()"})
  void testSuccess_thenReturnFalse2() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("42");

    ModelValidationResult<?> modelValidationResult =
        new ModelValidationResult<>(
            "Name",
            ValidationType.DATA_RULE,
            "Model Object Name",
            path,
            "Definition",
            failureReason);
    validationResults.add(modelValidationResult);
    RosettaPath path2 = mock(RosettaPath.class);
    Optional<String> failureReason2 = Optional.of("42");

    ModelValidationResult<?> modelValidationResult2 =
        new ModelValidationResult<>(
            "Name",
            ValidationType.DATA_RULE,
            "Model Object Name",
            path2,
            "Definition",
            failureReason2);
    validationResults.add(modelValidationResult2);
    ValidationReport validationReport = new ValidationReport(new BarBuilder(), validationResults);

    // Act and Assert
    assertFalse(validationReport.success());
  }

  /**
   * Test {@link ValidationReport#success()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationReport#success()}
   */
  @Test
  @DisplayName("Test success(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidationReport.success()"})
  void testSuccess_thenReturnTrue() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();
    ValidationReport validationReport = new ValidationReport(resultObject, new ArrayList<>());

    // Act and Assert
    assertTrue(validationReport.success());
  }

  /**
   * Test {@link ValidationReport#validationFailures()}.
   *
   * <p>Method under test: {@link ValidationReport#validationFailures()}
   */
  @Test
  @DisplayName("Test validationFailures()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ValidationReport.validationFailures()"})
  void testValidationFailures() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.empty();

    ModelValidationResult<?> modelValidationResult =
        new ModelValidationResult<>(
            "Name",
            ValidationType.DATA_RULE,
            "Model Object Name",
            path,
            "Definition",
            failureReason);
    validationResults.add(modelValidationResult);
    ValidationReport validationReport = new ValidationReport(new BarBuilder(), validationResults);

    // Act and Assert
    assertTrue(validationReport.validationFailures().isEmpty());
  }

  /**
   * Test {@link ValidationReport#validationFailures()}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidationReport#validationFailures()}
   */
  @Test
  @DisplayName("Test validationFailures(); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ValidationReport.validationFailures()"})
  void testValidationFailures_thenReturnArrayList() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("42");

    ModelValidationResult<?> modelValidationResult =
        new ModelValidationResult<>(
            "Name",
            ValidationType.DATA_RULE,
            "Model Object Name",
            path,
            "Definition",
            failureReason);
    validationResults.add(modelValidationResult);
    ValidationReport validationReport = new ValidationReport(new BarBuilder(), validationResults);

    // Act and Assert
    assertEquals(validationResults, validationReport.validationFailures());
  }

  /**
   * Test {@link ValidationReport#validationFailures()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ValidationReport#validationFailures()}
   */
  @Test
  @DisplayName("Test validationFailures(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ValidationReport.validationFailures()"})
  void testValidationFailures_thenReturnEmpty() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();
    ValidationReport validationReport = new ValidationReport(resultObject, new ArrayList<>());

    // Act and Assert
    assertTrue(validationReport.validationFailures().isEmpty());
  }

  /**
   * Test {@link ValidationReport#validationFailures()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ValidationReport#validationFailures()}
   */
  @Test
  @DisplayName("Test validationFailures(); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ValidationReport.validationFailures()"})
  void testValidationFailures_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("42");

    ModelValidationResult<?> modelValidationResult =
        new ModelValidationResult<>(
            "Name",
            ValidationType.DATA_RULE,
            "Model Object Name",
            path,
            "Definition",
            failureReason);
    validationResults.add(modelValidationResult);
    RosettaPath path2 = mock(RosettaPath.class);
    Optional<String> failureReason2 = Optional.of("42");

    ModelValidationResult<?> modelValidationResult2 =
        new ModelValidationResult<>(
            "Name",
            ValidationType.DATA_RULE,
            "Model Object Name",
            path2,
            "Definition",
            failureReason2);
    validationResults.add(modelValidationResult2);
    ValidationReport validationReport = new ValidationReport(new BarBuilder(), validationResults);

    // Act
    List<ValidationResult<?>> actualValidationFailuresResult =
        validationReport.validationFailures();

    // Assert
    assertEquals(2, actualValidationFailuresResult.size());
    assertSame(modelValidationResult2, actualValidationFailuresResult.get(1));
  }

  /**
   * Test {@link ValidationReport#results()}.
   *
   * <p>Method under test: {@link ValidationReport#results()}
   */
  @Test
  @DisplayName("Test results()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ValidationReport.results()"})
  void testResults() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();
    ValidationReport validationReport = new ValidationReport(resultObject, new ArrayList<>());

    // Act and Assert
    assertTrue(validationReport.results().isEmpty());
  }

  /**
   * Test {@link ValidationReport#logReport()}.
   *
   * <p>Method under test: {@link ValidationReport#logReport()}
   */
  @Test
  @DisplayName("Test logReport()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidationReport.logReport()"})
  void testLogReport() {
    // Arrange
    RosettaPath path = mock(RosettaPath.class);
    when(path.buildPath()).thenReturn("Build Path");
    Optional<String> failureReason = Optional.of("42");

    ModelValidationResult<?> modelValidationResult =
        new ModelValidationResult<>(
            "Name",
            ValidationType.DATA_RULE,
            "Model Object Name",
            path,
            "Definition",
            failureReason);

    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    validationResults.add(modelValidationResult);
    ValidationReport validationReport = new ValidationReport(new BarBuilder(), validationResults);

    // Act
    validationReport.logReport();

    // Assert
    verify(path).buildPath();
  }

  /**
   * Test {@link ValidationReport#logReport()}.
   *
   * <p>Method under test: {@link ValidationReport#logReport()}
   */
  @Test
  @DisplayName("Test logReport()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidationReport.logReport()"})
  void testLogReport2() {
    // Arrange
    RosettaPath path = mock(RosettaPath.class);
    when(path.buildPath()).thenReturn("Build Path");
    Optional<String> failureReason = Optional.empty();

    ModelValidationResult<?> modelValidationResult =
        new ModelValidationResult<>(
            "Name",
            ValidationType.DATA_RULE,
            "Model Object Name",
            path,
            "Definition",
            failureReason);

    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    validationResults.add(modelValidationResult);
    ValidationReport validationReport = new ValidationReport(new BarBuilder(), validationResults);

    // Act
    validationReport.logReport();

    // Assert
    verify(path).buildPath();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValidationReport#getResultObject()}
   *   <li>{@link ValidationReport#getValidationResults()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RosettaModelObject ValidationReport.getResultObject()",
    "List ValidationReport.getValidationResults()"
  })
  void testGettersAndSetters() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();

    ValidationReport validationReport = new ValidationReport(resultObject, validationResults);

    // Act
    RosettaModelObject actualResultObject = validationReport.getResultObject();
    List<ValidationResult<?>> actualValidationResults = validationReport.getValidationResults();

    // Assert
    assertTrue(actualValidationResults.isEmpty());
    assertSame(resultObject, actualResultObject);
    assertSame(validationResults, actualValidationResults);
  }
}
