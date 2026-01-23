package com.regnosys.rosetta.common.serialisation.reportdata;

/*-
 * ==============
 * Rune Common
 * ==============
 * Copyright (C) 2018 - 2026 REGnosys
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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportDataItemDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Expected is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReportDataItem#ReportDataItem()}
   *   <li>{@link ReportDataItem#getError()}
   *   <li>{@link ReportDataItem#getExpected()}
   *   <li>{@link ReportDataItem#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Expected is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReportDataItem.<init>()",
    "void ReportDataItem.<init>(String, Object, Object)",
    "void ReportDataItem.<init>(String, Object, Object, Exception)",
    "Exception ReportDataItem.getError()",
    "Object ReportDataItem.getExpected()",
    "String ReportDataItem.getName()"
  })
  void testGettersAndSetters_thenReturnExpectedIsNull() {
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
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then Expected return {@link JsonInclude.Include}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReportDataItem#ReportDataItem(String, Object, Object, Exception)}
   *   <li>{@link ReportDataItem#getError()}
   *   <li>{@link ReportDataItem#getExpected()}
   *   <li>{@link ReportDataItem#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Exception(); then Expected return Include")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReportDataItem.<init>()",
    "void ReportDataItem.<init>(String, Object, Object)",
    "void ReportDataItem.<init>(String, Object, Object, Exception)",
    "Exception ReportDataItem.getError()",
    "Object ReportDataItem.getExpected()",
    "String ReportDataItem.getName()"
  })
  void testGettersAndSetters_whenException_thenExpectedReturnInclude() {
    // Arrange
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;
    Exception error = new Exception();

    // Act
    ReportDataItem actualReportDataItem =
        new ReportDataItem("Name", BeanPropertyWriter.MARKER_FOR_EMPTY, object, error);
    Exception actualError = actualReportDataItem.getError();
    Object actualExpected = actualReportDataItem.getExpected();

    // Assert
    assertTrue(actualExpected instanceof Include);
    assertEquals("Name", actualReportDataItem.getName());
    assertEquals(Include.NON_EMPTY, actualExpected);
    assertSame(error, actualError);
    assertSame(object, actualExpected);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReportDataItem#ReportDataItem(String, Object, Object)}
   *   <li>{@link ReportDataItem#getError()}
   *   <li>{@link ReportDataItem#getExpected()}
   *   <li>{@link ReportDataItem#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Name'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReportDataItem.<init>()",
    "void ReportDataItem.<init>(String, Object, Object)",
    "void ReportDataItem.<init>(String, Object, Object, Exception)",
    "Exception ReportDataItem.getError()",
    "Object ReportDataItem.getExpected()",
    "String ReportDataItem.getName()"
  })
  void testGettersAndSetters_whenName_thenReturnName() {
    // Arrange
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;

    // Act
    ReportDataItem actualReportDataItem =
        new ReportDataItem("Name", BeanPropertyWriter.MARKER_FOR_EMPTY, object);
    Exception actualError = actualReportDataItem.getError();
    Object actualExpected = actualReportDataItem.getExpected();

    // Assert
    assertEquals("Name", actualReportDataItem.getName());
    assertNull(actualError);
    assertSame(object, actualExpected);
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}, and {@link ReportDataItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReportDataItem#equals(Object)}
   *   <li>{@link ReportDataItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReportDataItem reportDataItem = new ReportDataItem();
    ReportDataItem reportDataItem2 = new ReportDataItem();

    // Act and Assert
    assertEquals(reportDataItem, reportDataItem2);
    assertEquals(reportDataItem.hashCode(), reportDataItem2.hashCode());
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}, and {@link ReportDataItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReportDataItem#equals(Object)}
   *   <li>{@link ReportDataItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReportDataItem reportDataItem = new ReportDataItem();

    // Act and Assert
    assertEquals(reportDataItem, reportDataItem);
    int expectedHashCodeResult = reportDataItem.hashCode();
    assertEquals(expectedHashCodeResult, reportDataItem.hashCode());
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ReportDataItem reportDataItem =
        new ReportDataItem(
            "Name", BeanPropertyWriter.MARKER_FOR_EMPTY, BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act and Assert
    assertNotEquals(reportDataItem, new ReportDataItem());
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ReportDataItem reportDataItem =
        new ReportDataItem(
            null, BeanPropertyWriter.MARKER_FOR_EMPTY, BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act and Assert
    assertNotEquals(reportDataItem, new ReportDataItem());
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ReportDataItem reportDataItem =
        new ReportDataItem(null, new ReportDataItem(), BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act and Assert
    assertNotEquals(reportDataItem, new ReportDataItem());
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ReportDataItem reportDataItem =
        new ReportDataItem(null, null, BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act and Assert
    assertNotEquals(reportDataItem, new ReportDataItem());
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ReportDataItem reportDataItem = new ReportDataItem(null, null, new ReportDataItem());

    // Act and Assert
    assertNotEquals(reportDataItem, new ReportDataItem());
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportDataItem(), null);
  }

  /**
   * Test {@link ReportDataItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportDataItem.equals(Object)", "int ReportDataItem.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportDataItem(), "Different type to ReportDataItem");
  }

  /**
   * Test {@link ReportDataItem#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ReportDataItem[name='Name', input=NON_EMPTY, expected=NON_EMPTY]}.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataItem#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); then return 'ReportDataItem[name='Name', input=NON_EMPTY, expected=NON_EMPTY]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ReportDataItem.toString()"})
  void testToString_thenReturnReportDataItemNameNameInputNonEmptyExpectedNonEmpty() {
    // Arrange
    ReportDataItem reportDataItem =
        new ReportDataItem(
            "Name", BeanPropertyWriter.MARKER_FOR_EMPTY, BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act and Assert
    assertEquals(
        "ReportDataItem[name='Name', input=NON_EMPTY, expected=NON_EMPTY]",
        reportDataItem.toString());
  }

  /**
   * Test {@link ReportDataItem#toString()}.
   *
   * <ul>
   *   <li>Then return {@code ReportDataItem[name='null', input=null, expected=]}.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataItem#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ReportDataItem[name='null', input=null, expected=]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ReportDataItem.toString()"})
  void testToString_thenReturnReportDataItemNameNullInputNullExpected() {
    // Arrange, Act and Assert
    assertEquals(
        "ReportDataItem[name='null', input=null, expected=]", new ReportDataItem().toString());
  }
}
