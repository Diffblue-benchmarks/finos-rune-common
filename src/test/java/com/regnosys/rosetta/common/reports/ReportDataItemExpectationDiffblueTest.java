package com.regnosys.rosetta.common.reports;

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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ReportDataItemExpectationDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReportDataItemExpectation#ReportDataItemExpectation(String, int)}
   *   <li>{@link ReportDataItemExpectation#setFileName(String)}
   *   <li>{@link ReportDataItemExpectation#setValidationFailures(int)}
   *   <li>{@link ReportDataItemExpectation#getFileName()}
   *   <li>{@link ReportDataItemExpectation#getValidationFailures()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReportDataItemExpectation.<init>(String, int)",
      "String ReportDataItemExpectation.getFileName()", "int ReportDataItemExpectation.getValidationFailures()",
      "void ReportDataItemExpectation.setFileName(String)",
      "void ReportDataItemExpectation.setValidationFailures(int)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    ReportDataItemExpectation actualReportDataItemExpectation = new ReportDataItemExpectation("foo.txt", 1);
    actualReportDataItemExpectation.setFileName("foo.txt");
    actualReportDataItemExpectation.setValidationFailures(1);
    String actualFileName = actualReportDataItemExpectation.getFileName();

    // Assert
    assertEquals("foo.txt", actualFileName);
    assertEquals(1, actualReportDataItemExpectation.getValidationFailures());
  }

  /**
   * Test {@link ReportDataItemExpectation#compareTo(ReportDataItemExpectation)} with {@code ReportDataItemExpectation}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportDataItemExpectation#compareTo(ReportDataItemExpectation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReportDataItemExpectation.compareTo(ReportDataItemExpectation)"})
  public void testCompareToWithReportDataItemExpectation_thenReturnZero() {
    // Arrange
    ReportDataItemExpectation reportDataItemExpectation = new ReportDataItemExpectation("foo.txt", 1);

    // Act and Assert
    assertEquals(0, reportDataItemExpectation.compareTo(new ReportDataItemExpectation("foo.txt", 1)));
  }
}
