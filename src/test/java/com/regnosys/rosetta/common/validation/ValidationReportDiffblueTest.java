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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ValidationReportDiffblueTest {
  /**
   * Test {@link ValidationReport#ValidationReport(RosettaModelObject, List)}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   *   <li>Then return not success.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationReport#ValidationReport(RosettaModelObject, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidationReport.<init>(RosettaModelObject, List)"})
  public void testNewValidationReport_givenOptionalWithFoo_thenReturnNotSuccess() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();

    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    validationResults.add(new ModelValidationResult<>("Name", ValidationType.DATA_RULE, "Model Object Name", path,
        "Definition", failureReason));

    // Act
    ValidationReport actualValidationReport = new ValidationReport(resultObject, validationResults);

    // Assert
    assertFalse(actualValidationReport.success());
    assertSame(validationResults, actualValidationReport.getValidationResults());
  }

  /**
   * Test {@link ValidationReport#ValidationReport(RosettaModelObject, List)}.
   * <ul>
   *   <li>Then return ValidationResults size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationReport#ValidationReport(RosettaModelObject, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidationReport.<init>(RosettaModelObject, List)"})
  public void testNewValidationReport_thenReturnValidationResultsSizeIsTwo() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();

    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    validationResults.add(new ModelValidationResult<>("Name", ValidationType.DATA_RULE, "Model Object Name", path,
        "Definition", failureReason));
    RosettaPath path2 = mock(RosettaPath.class);
    Optional<String> failureReason2 = Optional.of("foo");
    ModelValidationResult<?> modelValidationResult = new ModelValidationResult<>("Name", ValidationType.DATA_RULE,
        "Model Object Name", path2, "Definition", failureReason2);

    validationResults.add(modelValidationResult);

    // Act and Assert
    List<ValidationResult<?>> validationResults2 = (new ValidationReport(resultObject, validationResults))
        .getValidationResults();
    assertEquals(2, validationResults2.size());
    assertSame(modelValidationResult, validationResults2.get(1));
  }

  /**
   * Test {@link ValidationReport#ValidationReport(RosettaModelObject, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return success.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationReport#ValidationReport(RosettaModelObject, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidationReport.<init>(RosettaModelObject, List)"})
  public void testNewValidationReport_whenArrayList_thenReturnSuccess() {
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
   * <p>
   * Method under test: {@link ValidationReport#success()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValidationReport.success()"})
  public void testSuccess() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.empty();
    validationResults.add(new ModelValidationResult<>("Name", ValidationType.DATA_RULE, "Model Object Name", path,
        "Definition", failureReason));

    // Act and Assert
    assertTrue((new ValidationReport(new BarBuilder(), validationResults)).success());
  }

  /**
   * Test {@link ValidationReport#success()}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationReport#success()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValidationReport.success()"})
  public void testSuccess_givenOptionalWithFoo_thenReturnFalse() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    validationResults.add(new ModelValidationResult<>("Name", ValidationType.DATA_RULE, "Model Object Name", path,
        "Definition", failureReason));

    // Act and Assert
    assertFalse((new ValidationReport(new BarBuilder(), validationResults)).success());
  }

  /**
   * Test {@link ValidationReport#success()}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationReport#success()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValidationReport.success()"})
  public void testSuccess_givenOptionalWithFoo_thenReturnFalse2() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    validationResults.add(new ModelValidationResult<>("Name", ValidationType.DATA_RULE, "Model Object Name", path,
        "Definition", failureReason));
    RosettaPath path2 = mock(RosettaPath.class);
    Optional<String> failureReason2 = Optional.of("foo");
    validationResults.add(new ModelValidationResult<>("Name", ValidationType.DATA_RULE, "Model Object Name", path2,
        "Definition", failureReason2));

    // Act and Assert
    assertFalse((new ValidationReport(new BarBuilder(), validationResults)).success());
  }

  /**
   * Test {@link ValidationReport#success()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationReport#success()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValidationReport.success()"})
  public void testSuccess_thenReturnTrue() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();

    // Act and Assert
    assertTrue((new ValidationReport(resultObject, new ArrayList<>())).success());
  }

  /**
   * Test {@link ValidationReport#validationFailures()}.
   * <p>
   * Method under test: {@link ValidationReport#validationFailures()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ValidationReport.validationFailures()"})
  public void testValidationFailures() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.empty();
    validationResults.add(new ModelValidationResult<>("Name", ValidationType.DATA_RULE, "Model Object Name", path,
        "Definition", failureReason));

    // Act and Assert
    assertTrue((new ValidationReport(new BarBuilder(), validationResults)).validationFailures().isEmpty());
  }

  /**
   * Test {@link ValidationReport#validationFailures()}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationReport#validationFailures()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ValidationReport.validationFailures()"})
  public void testValidationFailures_givenOptionalWithFoo_thenReturnArrayList() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    validationResults.add(new ModelValidationResult<>("Name", ValidationType.DATA_RULE, "Model Object Name", path,
        "Definition", failureReason));

    // Act and Assert
    assertEquals(validationResults, (new ValidationReport(new BarBuilder(), validationResults)).validationFailures());
  }

  /**
   * Test {@link ValidationReport#validationFailures()}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationReport#validationFailures()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ValidationReport.validationFailures()"})
  public void testValidationFailures_givenOptionalWithFoo_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    validationResults.add(new ModelValidationResult<>("Name", ValidationType.DATA_RULE, "Model Object Name", path,
        "Definition", failureReason));
    RosettaPath path2 = mock(RosettaPath.class);
    Optional<String> failureReason2 = Optional.of("foo");
    ModelValidationResult<?> modelValidationResult = new ModelValidationResult<>("Name", ValidationType.DATA_RULE,
        "Model Object Name", path2, "Definition", failureReason2);

    validationResults.add(modelValidationResult);

    // Act
    List<ValidationResult<?>> actualValidationFailuresResult = (new ValidationReport(new BarBuilder(),
        validationResults)).validationFailures();

    // Assert
    assertEquals(2, actualValidationFailuresResult.size());
    assertSame(modelValidationResult, actualValidationFailuresResult.get(1));
  }

  /**
   * Test {@link ValidationReport#validationFailures()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationReport#validationFailures()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ValidationReport.validationFailures()"})
  public void testValidationFailures_thenReturnEmpty() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();

    // Act and Assert
    assertTrue((new ValidationReport(resultObject, new ArrayList<>())).validationFailures().isEmpty());
  }

  /**
   * Test {@link ValidationReport#results()}.
   * <p>
   * Method under test: {@link ValidationReport#results()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List ValidationReport.results()"})
  public void testResults() {
    // Arrange
    BarBuilder resultObject = new BarBuilder();

    // Act and Assert
    assertTrue((new ValidationReport(resultObject, new ArrayList<>())).results().isEmpty());
  }

  /**
   * Test {@link ValidationReport#logReport()}.
   * <p>
   * Method under test: {@link ValidationReport#logReport()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidationReport.logReport()"})
  public void testLogReport() {
    // Arrange
    RosettaPath path = mock(RosettaPath.class);
    when(path.buildPath()).thenReturn("Build Path");
    Optional<String> failureReason = Optional.empty();
    ModelValidationResult<?> modelValidationResult = new ModelValidationResult<>("Name", ValidationType.DATA_RULE,
        "Model Object Name", path, "Definition", failureReason);

    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    validationResults.add(modelValidationResult);

    // Act
    (new ValidationReport(new BarBuilder(), validationResults)).logReport();

    // Assert
    verify(path).buildPath();
  }

  /**
   * Test {@link ValidationReport#logReport()}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   *   <li>Then calls {@link RosettaPath#buildPath()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationReport#logReport()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidationReport.logReport()"})
  public void testLogReport_givenOptionalWithFoo_thenCallsBuildPath() {
    // Arrange
    RosettaPath path = mock(RosettaPath.class);
    when(path.buildPath()).thenReturn("Build Path");
    Optional<String> failureReason = Optional.of("foo");
    ModelValidationResult<?> modelValidationResult = new ModelValidationResult<>("Name", ValidationType.DATA_RULE,
        "Model Object Name", path, "Definition", failureReason);

    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    validationResults.add(modelValidationResult);

    // Act
    (new ValidationReport(new BarBuilder(), validationResults)).logReport();

    // Assert
    verify(path).buildPath();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ValidationReport#getResultObject()}
   *   <li>{@link ValidationReport#getValidationResults()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RosettaModelObject ValidationReport.getResultObject()",
      "List ValidationReport.getValidationResults()"})
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
}
