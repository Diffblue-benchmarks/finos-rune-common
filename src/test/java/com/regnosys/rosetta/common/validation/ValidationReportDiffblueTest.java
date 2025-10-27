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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

public class ValidationReportDiffblueTest {
  /**
   * Method under test: {@link ValidationReport#success()}
   */
  @Test
  public void testSuccess() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();

    // Act and Assert
    assertTrue((new ValidationReport(resultObject, new ArrayList<>())).success());
  }

  /**
   * Method under test: {@link ValidationReport#success()}
   */
  @Test
  public void testSuccess2() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    validationResults.add(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason));

    // Act and Assert
    assertFalse((new ValidationReport(new BarBuilder(), validationResults)).success());
  }

  /**
   * Method under test: {@link ValidationReport#success()}
   */
  @Test
  public void testSuccess3() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    validationResults.add(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason));
    RosettaPath path2 = mock(RosettaPath.class);
    Optional<String> failureReason2 = Optional.of("foo");
    validationResults.add(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path2, "Definition", failureReason2));

    // Act and Assert
    assertFalse((new ValidationReport(new BarBuilder(), validationResults)).success());
  }

  /**
   * Method under test: {@link ValidationReport#success()}
   */
  @Test
  public void testSuccess4() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.empty();
    validationResults.add(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason));

    // Act and Assert
    assertTrue((new ValidationReport(new BarBuilder(), validationResults)).success());
  }

  /**
   * Method under test: {@link ValidationReport#validationFailures()}
   */
  @Test
  public void testValidationFailures() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();

    // Act and Assert
    assertTrue((new ValidationReport(resultObject, new ArrayList<>())).validationFailures().isEmpty());
  }

  /**
   * Method under test: {@link ValidationReport#validationFailures()}
   */
  @Test
  public void testValidationFailures2() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    validationResults.add(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason));

    // Act and Assert
    assertEquals(validationResults, (new ValidationReport(new BarBuilder(), validationResults)).validationFailures());
  }

  /**
   * Method under test: {@link ValidationReport#validationFailures()}
   */
  @Test
  public void testValidationFailures3() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    validationResults.add(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason));
    RosettaPath path2 = mock(RosettaPath.class);
    Optional<String> failureReason2 = Optional.of("foo");
    validationResults.add(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path2, "Definition", failureReason2));

    // Act and Assert
    assertEquals(validationResults, (new ValidationReport(new BarBuilder(), validationResults)).validationFailures());
  }

  /**
   * Method under test: {@link ValidationReport#validationFailures()}
   */
  @Test
  public void testValidationFailures4() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.empty();
    validationResults.add(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason));

    // Act and Assert
    assertTrue((new ValidationReport(new BarBuilder(), validationResults)).validationFailures().isEmpty());
  }

  /**
   * Method under test: {@link ValidationReport#results()}
   */
  @Test
  public void testResults() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();

    // Act
    List<ValidationResult<?>> actualResultsResult = (new ValidationReport(resultObject, validationResults)).results();

    // Assert
    assertTrue(actualResultsResult.isEmpty());
    assertSame(validationResults, actualResultsResult);
  }

  /**
   * Method under test: {@link ValidationReport#results()}
   */
  @Test
  public void testResults2() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    validationResults.add(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason));

    // Act and Assert
    assertSame(validationResults, (new ValidationReport(new BarBuilder(), validationResults)).results());
  }

  /**
   * Method under test: {@link ValidationReport#logReport()}
   */
  @Test
  public void testLogReport() {
    // Arrange
    RosettaPath path = mock(RosettaPath.class);
    when(path.buildPath()).thenReturn("Build Path");
    Optional<String> failureReason = Optional.of("foo");
    ValidationResult.ModelValidationResult<?> modelValidationResult = new ValidationResult.ModelValidationResult<>(
        "Name", ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason);

    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    validationResults.add(modelValidationResult);

    // Act
    (new ValidationReport(new BarBuilder(), validationResults)).logReport();

    // Assert
    verify(path).buildPath();
  }

  /**
   * Method under test: {@link ValidationReport#logReport()}
   */
  @Test
  public void testLogReport2() {
    // Arrange
    RosettaPath path = mock(RosettaPath.class);
    when(path.buildPath()).thenReturn("Build Path");
    Optional<String> failureReason = Optional.empty();
    ValidationResult.ModelValidationResult<?> modelValidationResult = new ValidationResult.ModelValidationResult<>(
        "Name", ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason);

    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    validationResults.add(modelValidationResult);

    // Act
    (new ValidationReport(new BarBuilder(), validationResults)).logReport();

    // Assert
    verify(path).buildPath();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationReport#getResultObject()}
   *   <li>{@link ValidationReport#getValidationResults()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
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

  /**
   * Method under test:
   * {@link ValidationReport#ValidationReport(RosettaModelObject, List)}
   */
  @Test
  public void testNewValidationReport() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();

    // Act
    ValidationReport actualValidationReport = new ValidationReport(resultObject, validationResults);

    // Assert
    assertTrue(actualValidationReport.success());
    List<ValidationResult<?>> validationResults2 = actualValidationReport.getValidationResults();
    assertTrue(validationResults2.isEmpty());
    assertSame(resultObject, actualValidationReport.getResultObject());
    assertSame(validationResults, validationResults2);
  }

  /**
   * Method under test:
   * {@link ValidationReport#ValidationReport(RosettaModelObject, List)}
   */
  @Test
  public void testNewValidationReport2() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();

    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    validationResults.add(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason));

    // Act
    ValidationReport actualValidationReport = new ValidationReport(resultObject, validationResults);

    // Assert
    assertFalse(actualValidationReport.success());
    assertSame(resultObject, actualValidationReport.getResultObject());
    assertSame(validationResults, actualValidationReport.getValidationResults());
  }

  /**
   * Method under test:
   * {@link ValidationReport#ValidationReport(RosettaModelObject, List)}
   */
  @Test
  public void testNewValidationReport3() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();

    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    validationResults.add(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason));
    RosettaPath path2 = mock(RosettaPath.class);
    Optional<String> failureReason2 = Optional.of("foo");
    validationResults.add(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path2, "Definition", failureReason2));

    // Act
    ValidationReport actualValidationReport = new ValidationReport(resultObject, validationResults);

    // Assert
    assertFalse(actualValidationReport.success());
    assertSame(resultObject, actualValidationReport.getResultObject());
    assertSame(validationResults, actualValidationReport.getValidationResults());
  }
}
