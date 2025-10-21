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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.granite.ingestor.parser.InputValidationReport;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.regnosys.rosetta.common.validation.ValidationReport;
import com.rosetta.model.lib.RosettaModelObject;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProjectionReportDiffblueTest {
  /**
   * Test {@link ProjectionReport#ProjectionReport(RosettaModelObject, Object, String, InputValidationReport, ValidationReport)}.
   * <ul>
   *   <li>When {@link InputValidationReport#SUCCESS}.</li>
   *   <li>Then return {@code Projected Instance As String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionReport#ProjectionReport(RosettaModelObject, Object, String, InputValidationReport, ValidationReport)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ProjectionReport.<init>(RosettaModelObject, Object, String, InputValidationReport, ValidationReport)"})
  public void testNewProjectionReport_whenSuccess_thenReturnProjectedInstanceAsString() {
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
    InputValidationReport inputValidation2 = actualProjectionReport.getInputValidation();
    assertTrue(inputValidation2.getErrors().isEmpty());
    assertSame(barBuilder, actualProjectionReport.getRosettaModelInstance());
    assertSame(validationReport, actualProjectionReport.getValidationReport());
    assertSame(inputValidation.SUCCESS, inputValidation2);
  }

  /**
   * Test {@link ProjectionReport#isSuccess()}.
   * <p>
   * Method under test: {@link ProjectionReport#isSuccess()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProjectionReport.isSuccess()"})
  public void testIsSuccess() {
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
   * Test {@link ProjectionReport#isSuccess()}.
   * <p>
   * Method under test: {@link ProjectionReport#isSuccess()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProjectionReport.isSuccess()"})
  public void testIsSuccess2() {
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
   * Test {@link ProjectionReport#isSuccess()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionReport#isSuccess()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProjectionReport.isSuccess()"})
  public void testIsSuccess_thenReturnTrue() {
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProjectionReport#getInputValidation()}
   *   <li>{@link ProjectionReport#getProjectedInstance()}
   *   <li>{@link ProjectionReport#getProjectedInstanceAsString()}
   *   <li>{@link ProjectionReport#getValidationReport()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InputValidationReport ProjectionReport.getInputValidation()",
      "Object ProjectionReport.getProjectedInstance()", "String ProjectionReport.getProjectedInstanceAsString()",
      "ValidationReport ProjectionReport.getValidationReport()"})
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
}
