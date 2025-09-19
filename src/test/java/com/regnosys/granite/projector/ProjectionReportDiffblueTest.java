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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.regnosys.granite.ingestor.parser.InputValidationReport;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.regnosys.rosetta.common.validation.ValidationReport;
import com.rosetta.model.lib.RosettaModelObject;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProjectionReportDiffblueTest {
  /**
   * Test {@link ProjectionReport#ProjectionReport(RosettaModelObject, Object, String,
   * InputValidationReport, ValidationReport)}.
   *
   * <ul>
   *   <li>When {@link InputValidationReport#SUCCESS}.
   *   <li>Then return {@code Projected Instance As String}.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionReport#ProjectionReport(RosettaModelObject, Object,
   * String, InputValidationReport, ValidationReport)}
   */
  @Test
  @DisplayName(
      "Test new ProjectionReport(RosettaModelObject, Object, String, InputValidationReport, ValidationReport); when SUCCESS; then return 'Projected Instance As String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProjectionReport.<init>(RosettaModelObject, Object, String, InputValidationReport, ValidationReport)"
  })
  void testNewProjectionReport_whenSuccess_thenReturnProjectedInstanceAsString() {
    // Arrange
    BarBuilder barBuilder = new BarBuilder();
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;
    BarBuilder resultObject = new BarBuilder();
    ValidationReport validationReport = new ValidationReport(resultObject, new ArrayList<>());

    // Act
    ProjectionReport<RosettaModelObject, Object> actualProjectionReport =
        new ProjectionReport<>(
            barBuilder,
            object,
            "Projected Instance As String",
            InputValidationReport.SUCCESS,
            validationReport);

    // Assert
    assertEquals(
        "Projected Instance As String", actualProjectionReport.getProjectedInstanceAsString());
    assertTrue(actualProjectionReport.isSuccess());
    InputValidationReport inputValidation = actualProjectionReport.getInputValidation();
    assertTrue(inputValidation.getErrors().isEmpty());
    assertSame(barBuilder, actualProjectionReport.getRosettaModelInstance());
    assertSame(validationReport, actualProjectionReport.getValidationReport());
    assertSame(object, actualProjectionReport.getProjectedInstance());
    assertSame(InputValidationReport.SUCCESS, inputValidation);
  }

  /**
   * Test {@link ProjectionReport#isSuccess()}.
   *
   * <p>Method under test: {@link ProjectionReport#isSuccess()}
   */
  @Test
  @DisplayName("Test isSuccess()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProjectionReport.isSuccess()"})
  void testIsSuccess() {
    // Arrange
    BarBuilder barBuilder = new BarBuilder();
    BarBuilder resultObject = new BarBuilder();
    ValidationReport validationReport = new ValidationReport(resultObject, new ArrayList<>());

    ProjectionReport<RosettaModelObject, Object> projectionReport =
        new ProjectionReport<>(
            barBuilder, null, null, InputValidationReport.SUCCESS, validationReport);

    // Act and Assert
    assertFalse(projectionReport.isSuccess());
  }

  /**
   * Test {@link ProjectionReport#isSuccess()}.
   *
   * <p>Method under test: {@link ProjectionReport#isSuccess()}
   */
  @Test
  @DisplayName("Test isSuccess()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProjectionReport.isSuccess()"})
  void testIsSuccess2() {
    // Arrange
    BarBuilder barBuilder = new BarBuilder();
    BarBuilder resultObject = new BarBuilder();
    ValidationReport validationReport = new ValidationReport(resultObject, new ArrayList<>());

    ProjectionReport<RosettaModelObject, Object> projectionReport =
        new ProjectionReport<>(
            barBuilder,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            null,
            InputValidationReport.SUCCESS,
            validationReport);

    // Act and Assert
    assertFalse(projectionReport.isSuccess());
  }

  /**
   * Test {@link ProjectionReport#isSuccess()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionReport#isSuccess()}
   */
  @Test
  @DisplayName("Test isSuccess(); given ArrayList() add 'foo'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProjectionReport.isSuccess()"})
  void testIsSuccess_givenArrayListAddFoo_thenReturnFalse() {
    // Arrange
    ArrayList<String> errors = new ArrayList<>();
    errors.add("foo");
    InputValidationReport inputValidation = new InputValidationReport(errors);
    BarBuilder barBuilder = new BarBuilder();
    BarBuilder resultObject = new BarBuilder();
    ValidationReport validationReport = new ValidationReport(resultObject, new ArrayList<>());

    ProjectionReport<RosettaModelObject, Object> projectionReport =
        new ProjectionReport<>(
            barBuilder,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "Projected Instance As String",
            inputValidation,
            validationReport);

    // Act and Assert
    assertFalse(projectionReport.isSuccess());
  }

  /**
   * Test {@link ProjectionReport#isSuccess()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionReport#isSuccess()}
   */
  @Test
  @DisplayName("Test isSuccess(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProjectionReport.isSuccess()"})
  void testIsSuccess_thenReturnTrue() {
    // Arrange
    BarBuilder barBuilder = new BarBuilder();
    BarBuilder resultObject = new BarBuilder();
    ValidationReport validationReport = new ValidationReport(resultObject, new ArrayList<>());

    ProjectionReport<RosettaModelObject, Object> projectionReport =
        new ProjectionReport<>(
            barBuilder,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "Projected Instance As String",
            InputValidationReport.SUCCESS,
            validationReport);

    // Act and Assert
    assertTrue(projectionReport.isSuccess());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProjectionReport#getInputValidation()}
   *   <li>{@link ProjectionReport#getProjectedInstance()}
   *   <li>{@link ProjectionReport#getProjectedInstanceAsString()}
   *   <li>{@link ProjectionReport#getValidationReport()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InputValidationReport ProjectionReport.getInputValidation()",
    "Object ProjectionReport.getProjectedInstance()",
    "String ProjectionReport.getProjectedInstanceAsString()",
    "ValidationReport ProjectionReport.getValidationReport()"
  })
  void testGettersAndSetters() {
    // Arrange
    BarBuilder barBuilder = new BarBuilder();
    BarBuilder resultObject = new BarBuilder();
    ValidationReport validationReport = new ValidationReport(resultObject, new ArrayList<>());

    ProjectionReport<RosettaModelObject, Object> projectionReport =
        new ProjectionReport<>(
            barBuilder,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "Projected Instance As String",
            InputValidationReport.SUCCESS,
            validationReport);

    // Act
    InputValidationReport actualInputValidation = projectionReport.getInputValidation();
    Object actualProjectedInstance = projectionReport.getProjectedInstance();
    String actualProjectedInstanceAsString = projectionReport.getProjectedInstanceAsString();

    // Assert
    assertTrue(actualProjectedInstance instanceof Include);
    assertEquals("Projected Instance As String", actualProjectedInstanceAsString);
    assertEquals(Include.NON_EMPTY, actualProjectedInstance);
    assertSame(validationReport, projectionReport.getValidationReport());
    assertSame(InputValidationReport.SUCCESS, actualInputValidation);
  }
}
