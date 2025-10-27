package com.regnosys.rosetta.common.serialisation.reportdata;

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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ReportDataItemDiffblueTest {
  /**
   * Method under test: {@link ReportDataItem#getInput()}
   */
  @Test
  public void testGetInput() {
    // Arrange, Act and Assert
    assertNull((new ReportDataItem()).getInput());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReportDataItem#equals(Object)}
   *   <li>{@link ReportDataItem#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReportDataItem reportDataItem = new ReportDataItem();
    ReportDataItem reportDataItem2 = new ReportDataItem();

    // Act and Assert
    assertEquals(reportDataItem, reportDataItem2);
    int expectedHashCodeResult = reportDataItem.hashCode();
    assertEquals(expectedHashCodeResult, reportDataItem2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReportDataItem#equals(Object)}
   *   <li>{@link ReportDataItem#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReportDataItem reportDataItem = new ReportDataItem();

    // Act and Assert
    assertEquals(reportDataItem, reportDataItem);
    int expectedHashCodeResult = reportDataItem.hashCode();
    assertEquals(expectedHashCodeResult, reportDataItem.hashCode());
  }

  /**
   * Method under test: {@link ReportDataItem#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("ReportDataItem[name='null', input=null, expected=]", (new ReportDataItem()).toString());
    assertEquals("ReportDataItem[name=', ', input=Input, expected=Expected]",
        (new ReportDataItem(", ", "Input", "Expected")).toString());
  }

  /**
   * Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ReportDataItem reportDataItem = new ReportDataItem("Name", "Input", "Expected");

    // Act and Assert
    assertNotEquals(reportDataItem, new ReportDataItem());
  }

  /**
   * Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ReportDataItem reportDataItem = new ReportDataItem(null, "Input", "Expected");

    // Act and Assert
    assertNotEquals(reportDataItem, new ReportDataItem());
  }

  /**
   * Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ReportDataItem reportDataItem = new ReportDataItem(null, new ReportDataItem(), "Expected");

    // Act and Assert
    assertNotEquals(reportDataItem, new ReportDataItem());
  }

  /**
   * Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ReportDataItem reportDataItem = new ReportDataItem(null, null, "Expected");

    // Act and Assert
    assertNotEquals(reportDataItem, new ReportDataItem());
  }

  /**
   * Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ReportDataItem reportDataItem = new ReportDataItem(null, null, new ReportDataItem());

    // Act and Assert
    assertNotEquals(reportDataItem, new ReportDataItem());
  }

  /**
   * Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportDataItem(), null);
  }

  /**
   * Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportDataItem(), "Different type to ReportDataItem");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReportDataItem#ReportDataItem()}
   *   <li>{@link ReportDataItem#getError()}
   *   <li>{@link ReportDataItem#getExpected()}
   *   <li>{@link ReportDataItem#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ReportDataItem actualReportDataItem = new ReportDataItem();
    Exception actualError = actualReportDataItem.getError();
    Object actualExpected = actualReportDataItem.getExpected();

    // Assert
    assertNull(actualError);
    assertNull(actualExpected);
    assertNull(actualReportDataItem.getName());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReportDataItem#ReportDataItem(String, Object, Object)}
   *   <li>{@link ReportDataItem#getError()}
   *   <li>{@link ReportDataItem#getExpected()}
   *   <li>{@link ReportDataItem#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    ReportDataItem actualReportDataItem = new ReportDataItem("Name", "Input", "Expected");
    Exception actualError = actualReportDataItem.getError();
    Object actualExpected = actualReportDataItem.getExpected();

    // Assert
    assertEquals("Expected", actualExpected);
    assertEquals("Name", actualReportDataItem.getName());
    assertNull(actualError);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReportDataItem#ReportDataItem(String, Object, Object, Exception)}
   *   <li>{@link ReportDataItem#getError()}
   *   <li>{@link ReportDataItem#getExpected()}
   *   <li>{@link ReportDataItem#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters3() {
    // Arrange
    Exception error = new Exception("foo");

    // Act
    ReportDataItem actualReportDataItem = new ReportDataItem("Name", "Input", "Expected", error);
    Exception actualError = actualReportDataItem.getError();
    Object actualExpected = actualReportDataItem.getExpected();

    // Assert
    assertEquals("Expected", actualExpected);
    assertEquals("Name", actualReportDataItem.getName());
    assertSame(error, actualError);
  }
}
