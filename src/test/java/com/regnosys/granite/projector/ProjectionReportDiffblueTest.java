package com.regnosys.granite.projector;

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
import com.regnosys.granite.ingestor.parser.InputValidationReport;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.regnosys.rosetta.common.validation.ValidationReport;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.Test;

public class ProjectionReportDiffblueTest {
  /**
   * Method under test: {@link ProjectionReport#isSuccess()}
   */
  @Test
  public void testIsSuccess() {
    // Arrange
    BarBuilder barBuilder = new BarBuilder();
    BarBuilder resultObject = new BarBuilder();
    ProjectionReport<RosettaModelObject, Object> projectionReport = new ProjectionReport<>(barBuilder,
        "Projected Instance", "Projected Instance As String", InputValidationReport.SUCCESS,
        new ValidationReport(resultObject, new ArrayList<>()));

    // Act and Assert
    assertTrue(projectionReport.isSuccess());
  }

  /**
   * Method under test: {@link ProjectionReport#isSuccess()}
   */
  @Test
  public void testIsSuccess2() {
    // Arrange
    BarBuilder barBuilder = new BarBuilder();
    BarBuilder resultObject = new BarBuilder();
    ProjectionReport<RosettaModelObject, Object> projectionReport = new ProjectionReport<>(barBuilder, null,
        "Projected Instance As String", InputValidationReport.SUCCESS,
        new ValidationReport(resultObject, new ArrayList<>()));

    // Act and Assert
    assertFalse(projectionReport.isSuccess());
  }

  /**
   * Method under test: {@link ProjectionReport#isSuccess()}
   */
  @Test
  public void testIsSuccess3() {
    // Arrange
    BarBuilder barBuilder = new BarBuilder();
    BarBuilder resultObject = new BarBuilder();
    ProjectionReport<RosettaModelObject, Object> projectionReport = new ProjectionReport<>(barBuilder,
        "Projected Instance", null, InputValidationReport.SUCCESS,
        new ValidationReport(resultObject, new ArrayList<>()));

    // Act and Assert
    assertFalse(projectionReport.isSuccess());
  }

  /**
   * Method under test: {@link ProjectionReport#isSuccess()}
   */
  @Test
  public void testIsSuccess4() {
    // Arrange
    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    validationResults.add(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason));
    ValidationReport validationReport = new ValidationReport(new BarBuilder(), validationResults);

    ProjectionReport<RosettaModelObject, Object> projectionReport = new ProjectionReport<>(new BarBuilder(),
        "Projected Instance", "Projected Instance As String", InputValidationReport.SUCCESS, validationReport);

    // Act and Assert
    assertTrue(projectionReport.isSuccess());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProjectionReport#getInputValidation()}
   *   <li>{@link ProjectionReport#getProjectedInstance()}
   *   <li>{@link ProjectionReport#getProjectedInstanceAsString()}
   *   <li>{@link ProjectionReport#getValidationReport()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BarBuilder barBuilder = new BarBuilder();
    BarBuilder resultObject = new BarBuilder();
    ValidationReport validationReport = new ValidationReport(resultObject, new ArrayList<>());

    ProjectionReport<RosettaModelObject, Object> projectionReport = new ProjectionReport<>(barBuilder,
        "Projected Instance", "Projected Instance As String", InputValidationReport.SUCCESS, validationReport);

    // Act
    InputValidationReport actualInputValidation = projectionReport.getInputValidation();
    Object actualProjectedInstance = projectionReport.getProjectedInstance();
    String actualProjectedInstanceAsString = projectionReport.getProjectedInstanceAsString();

    // Assert
    assertEquals("Projected Instance As String", actualProjectedInstanceAsString);
    assertEquals("Projected Instance", actualProjectedInstance);
    assertSame(validationReport, projectionReport.getValidationReport());
    assertSame(actualInputValidation.SUCCESS, actualInputValidation);
  }

  /**
   * Method under test:
   * {@link ProjectionReport#ProjectionReport(RosettaModelObject, Object, String, InputValidationReport, ValidationReport)}
   */
  @Test
  public void testNewProjectionReport() {
    // Arrange
    BarBuilder barBuilder = new BarBuilder();
    InputValidationReport inputValidation = InputValidationReport.SUCCESS;
    BarBuilder resultObject = new BarBuilder();
    ValidationReport validationReport = new ValidationReport(resultObject, new ArrayList<>());

    // Act
    ProjectionReport<RosettaModelObject, Object> actualProjectionReport = new ProjectionReport<>(barBuilder,
        "Projected Instance", "Projected Instance As String", inputValidation, validationReport);

    // Assert
    assertEquals("Projected Instance As String", actualProjectionReport.getProjectedInstanceAsString());
    assertEquals("Projected Instance", actualProjectionReport.getProjectedInstance());
    assertTrue(actualProjectionReport.isSuccess());
    assertSame(barBuilder, actualProjectionReport.getRosettaModelInstance());
    assertSame(validationReport, actualProjectionReport.getValidationReport());
    InputValidationReport expectedInputValidation = inputValidation.SUCCESS;
    assertSame(expectedInputValidation, actualProjectionReport.getInputValidation());
  }

  /**
   * Method under test:
   * {@link ProjectionReport#ProjectionReport(RosettaModelObject, Object, String, InputValidationReport, ValidationReport)}
   */
  @Test
  public void testNewProjectionReport2() {
    // Arrange
    BarBuilder barBuilder = new BarBuilder();
    InputValidationReport inputValidation = InputValidationReport.SUCCESS;

    ArrayList<ValidationResult<?>> validationResults = new ArrayList<>();
    RosettaPath path = mock(RosettaPath.class);
    Optional<String> failureReason = Optional.of("foo");
    validationResults.add(new ValidationResult.ModelValidationResult<>("Name",
        ValidationResult.ValidationType.DATA_RULE, "Model Object Name", path, "Definition", failureReason));
    ValidationReport validationReport = new ValidationReport(new BarBuilder(), validationResults);

    // Act
    ProjectionReport<RosettaModelObject, Object> actualProjectionReport = new ProjectionReport<>(barBuilder,
        "Projected Instance", "Projected Instance As String", inputValidation, validationReport);

    // Assert
    assertEquals("Projected Instance As String", actualProjectionReport.getProjectedInstanceAsString());
    assertEquals("Projected Instance", actualProjectionReport.getProjectedInstance());
    assertTrue(actualProjectionReport.isSuccess());
    InputValidationReport inputValidation2 = actualProjectionReport.getInputValidation();
    assertTrue(inputValidation2.getErrors().isEmpty());
    assertSame(barBuilder, actualProjectionReport.getRosettaModelInstance());
    assertSame(validationReport, actualProjectionReport.getValidationReport());
    assertSame(inputValidation.SUCCESS, inputValidation2);
  }
}
