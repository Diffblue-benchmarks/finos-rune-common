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

public class ReportFieldDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReportField#ReportField(String, String, Integer, String, String)}
   *   <li>{@link ReportField#toString()}
   *   <li>{@link ReportField#getIssue()}
   *   <li>{@link ReportField#getName()}
   *   <li>{@link ReportField#getRepeatableIndex()}
   *   <li>{@link ReportField#getRule()}
   *   <li>{@link ReportField#getValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReportField.<init>(String, String, Integer, String, String)",
      "String ReportField.getIssue()", "String ReportField.getName()", "Integer ReportField.getRepeatableIndex()",
      "String ReportField.getRule()", "String ReportField.getValue()", "String ReportField.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    ReportField actualReportField = new ReportField("Name", "Rule", 1, "42", "Issue");
    String actualToStringResult = actualReportField.toString();
    String actualIssue = actualReportField.getIssue();
    String actualName = actualReportField.getName();
    Integer actualRepeatableIndex = actualReportField.getRepeatableIndex();
    String actualRule = actualReportField.getRule();

    // Assert
    assertEquals("42", actualReportField.getValue());
    assertEquals("Issue", actualIssue);
    assertEquals("Name", actualName);
    assertEquals("ReportField[name='Name', rule='Rule', repeatableIndex=1, value='42', issue='Issue']",
        actualToStringResult);
    assertEquals("Rule", actualRule);
    assertEquals(1, actualRepeatableIndex.intValue());
  }

  /**
   * Test {@link ReportField#compareTo(ReportField)} with {@code ReportField}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportField#compareTo(ReportField)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReportField.compareTo(ReportField)"})
  public void testCompareToWithReportField_thenReturnZero() {
    // Arrange
    ReportField reportField = new ReportField("Name", "Rule", 1, "42", "Issue");

    // Act and Assert
    assertEquals(0, reportField.compareTo(new ReportField("Name", "Rule", 1, "42", "Issue")));
  }
}
