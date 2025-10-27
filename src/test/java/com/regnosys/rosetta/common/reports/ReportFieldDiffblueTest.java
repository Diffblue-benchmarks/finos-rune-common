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
import org.junit.Test;

public class ReportFieldDiffblueTest {
  /**
   * Method under test: {@link ReportField#compareTo(ReportField)}
   */
  @Test
  public void testCompareTo() {
    // Arrange
    ReportField reportField = new ReportField("Name", "Rule", 1, "42", "Issue");

    // Act and Assert
    assertEquals(0, reportField.compareTo(new ReportField("Name", "Rule", 1, "42", "Issue")));
  }

  /**
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
}
