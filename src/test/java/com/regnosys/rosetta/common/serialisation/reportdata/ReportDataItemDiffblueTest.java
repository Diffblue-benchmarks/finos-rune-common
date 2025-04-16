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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ReportDataItemDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Expected is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReportDataItem#ReportDataItem()}
   *   <li>{@link ReportDataItem#getError()}
   *   <li>{@link ReportDataItem#getExpected()}
   *   <li>{@link ReportDataItem#getName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReportDataItem.<init>()", "void ReportDataItem.<init>(String, Object, Object)",
      "void ReportDataItem.<init>(String, Object, Object, Exception)", "Exception ReportDataItem.getError()",
      "Object ReportDataItem.getExpected()", "String ReportDataItem.getName()"})
  public void testGettersAndSetters_thenReturnExpectedIsNull() {
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@link Exception#Exception(String)} with {@code foo}.</li>
   *   <li>Then return Error is {@link Exception#Exception(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReportDataItem#ReportDataItem(String, Object, Object, Exception)}
   *   <li>{@link ReportDataItem#getError()}
   *   <li>{@link ReportDataItem#getExpected()}
   *   <li>{@link ReportDataItem#getName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReportDataItem.<init>()", "void ReportDataItem.<init>(String, Object, Object)",
      "void ReportDataItem.<init>(String, Object, Object, Exception)", "Exception ReportDataItem.getError()",
      "Object ReportDataItem.getExpected()", "String ReportDataItem.getName()"})
  public void testGettersAndSetters_whenExceptionWithFoo_thenReturnErrorIsExceptionWithFoo() {
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

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code Expected}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReportDataItem#ReportDataItem(String, Object, Object)}
   *   <li>{@link ReportDataItem#getError()}
   *   <li>{@link ReportDataItem#getExpected()}
   *   <li>{@link ReportDataItem#getName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ReportDataItem.<init>()", "void ReportDataItem.<init>(String, Object, Object)",
      "void ReportDataItem.<init>(String, Object, Object, Exception)", "Exception ReportDataItem.getError()",
      "Object ReportDataItem.getExpected()", "String ReportDataItem.getName()"})
  public void testGettersAndSetters_whenName_thenReturnExpected() {
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
   * Test {@link ReportDataItem#getInput()}.
   * <ul>
   *   <li>Given {@link ReportDataItem#ReportDataItem()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportDataItem#getInput()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReportDataItem.getInput()"})
  public void testGetInput_givenReportDataItem_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ReportDataItem()).getInput());
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}, and {@link ReportDataItem#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReportDataItem#equals(Object)}
   *   <li>{@link ReportDataItem#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
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
   * Test {@link ReportDataItem#equals(Object)}, and {@link ReportDataItem#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReportDataItem#equals(Object)}
   *   <li>{@link ReportDataItem#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReportDataItem reportDataItem = new ReportDataItem();

    // Act and Assert
    assertEquals(reportDataItem, reportDataItem);
    int expectedHashCodeResult = reportDataItem.hashCode();
    assertEquals(expectedHashCodeResult, reportDataItem.hashCode());
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ReportDataItem reportDataItem = new ReportDataItem("Name", "Input", "Expected");

    // Act and Assert
    assertNotEquals(reportDataItem, new ReportDataItem());
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ReportDataItem reportDataItem = new ReportDataItem(null, "Input", "Expected");

    // Act and Assert
    assertNotEquals(reportDataItem, new ReportDataItem());
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ReportDataItem reportDataItem = new ReportDataItem(null, new ReportDataItem(), "Expected");

    // Act and Assert
    assertNotEquals(reportDataItem, new ReportDataItem());
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ReportDataItem reportDataItem = new ReportDataItem(null, null, "Expected");

    // Act and Assert
    assertNotEquals(reportDataItem, new ReportDataItem());
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ReportDataItem reportDataItem = new ReportDataItem(null, null, new ReportDataItem());

    // Act and Assert
    assertNotEquals(reportDataItem, new ReportDataItem());
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportDataItem(), null);
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportDataItem(), "Different type to ReportDataItem");
  }

  /**
   * Test {@link ReportDataItem#toString()}.
   * <ul>
   *   <li>Then return {@code ReportDataItem[name=', ', input=Input, expected=Expected]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportDataItem#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ReportDataItem.toString()"})
  public void testToString_thenReturnReportDataItemNameInputInputExpectedExpected() {
    // Arrange, Act and Assert
    assertEquals("ReportDataItem[name=', ', input=Input, expected=Expected]",
        (new ReportDataItem(", ", "Input", "Expected")).toString());
  }

  /**
   * Test {@link ReportDataItem#toString()}.
   * <ul>
   *   <li>Then return {@code ReportDataItem[name='null', input=null, expected=]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportDataItem#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ReportDataItem.toString()"})
  public void testToString_thenReturnReportDataItemNameNullInputNullExpected() {
    // Arrange, Act and Assert
    assertEquals("ReportDataItem[name='null', input=null, expected=]", (new ReportDataItem()).toString());
  }
}
