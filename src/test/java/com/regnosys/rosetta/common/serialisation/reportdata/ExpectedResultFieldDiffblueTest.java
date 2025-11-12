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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExpectedResultFieldDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code ExpectedResultField[name='null', value='null']}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExpectedResultField#ExpectedResultField()}
   *   <li>{@link ExpectedResultField#toString()}
   *   <li>{@link ExpectedResultField#getName()}
   *   <li>{@link ExpectedResultField#getValue()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; then return toString is 'ExpectedResultField[name='null', value='null']'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpectedResultField.<init>()",
    "void ExpectedResultField.<init>(String, String)",
    "String ExpectedResultField.getName()",
    "String ExpectedResultField.getValue()",
    "String ExpectedResultField.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsExpectedResultFieldNameNullValueNull() {
    // Arrange and Act
    ExpectedResultField actualExpectedResultField = new ExpectedResultField();
    String actualToStringResult = actualExpectedResultField.toString();
    String actualName = actualExpectedResultField.getName();

    // Assert
    assertEquals("ExpectedResultField[name='null', value='null']", actualToStringResult);
    assertNull(actualName);
    assertNull(actualExpectedResultField.getValue());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return Value is {@code 42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExpectedResultField#ExpectedResultField(String, String)}
   *   <li>{@link ExpectedResultField#toString()}
   *   <li>{@link ExpectedResultField#getName()}
   *   <li>{@link ExpectedResultField#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Name'; then return Value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExpectedResultField.<init>()",
    "void ExpectedResultField.<init>(String, String)",
    "String ExpectedResultField.getName()",
    "String ExpectedResultField.getValue()",
    "String ExpectedResultField.toString()"
  })
  void testGettersAndSetters_whenName_thenReturnValueIs42() {
    // Arrange and Act
    ExpectedResultField actualExpectedResultField = new ExpectedResultField("Name", "42");
    String actualToStringResult = actualExpectedResultField.toString();
    String actualName = actualExpectedResultField.getName();

    // Assert
    assertEquals("42", actualExpectedResultField.getValue());
    assertEquals("ExpectedResultField[name='Name', value='42']", actualToStringResult);
    assertEquals("Name", actualName);
  }

  /**
   * Test {@link ExpectedResultField#equals(Object)}, and {@link ExpectedResultField#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExpectedResultField#equals(Object)}
   *   <li>{@link ExpectedResultField#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ExpectedResultField.equals(Object)",
    "int ExpectedResultField.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExpectedResultField expectedResultField = new ExpectedResultField("Name", "42");
    ExpectedResultField expectedResultField2 = new ExpectedResultField("Name", "42");

    // Act and Assert
    assertEquals(expectedResultField, expectedResultField2);
    assertEquals(expectedResultField.hashCode(), expectedResultField2.hashCode());
  }

  /**
   * Test {@link ExpectedResultField#equals(Object)}, and {@link ExpectedResultField#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExpectedResultField#equals(Object)}
   *   <li>{@link ExpectedResultField#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ExpectedResultField.equals(Object)",
    "int ExpectedResultField.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExpectedResultField expectedResultField = new ExpectedResultField("Name", "42");

    // Act and Assert
    assertEquals(expectedResultField, expectedResultField);
    int expectedHashCodeResult = expectedResultField.hashCode();
    assertEquals(expectedHashCodeResult, expectedResultField.hashCode());
  }

  /**
   * Test {@link ExpectedResultField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ExpectedResultField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ExpectedResultField.equals(Object)",
    "int ExpectedResultField.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExpectedResultField expectedResultField = new ExpectedResultField(null, "42");

    // Act and Assert
    assertNotEquals(expectedResultField, new ExpectedResultField("Name", "42"));
  }

  /**
   * Test {@link ExpectedResultField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ExpectedResultField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ExpectedResultField.equals(Object)",
    "int ExpectedResultField.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ExpectedResultField expectedResultField = new ExpectedResultField("Name", "Value");

    // Act and Assert
    assertNotEquals(expectedResultField, new ExpectedResultField("Name", "42"));
  }

  /**
   * Test {@link ExpectedResultField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ExpectedResultField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ExpectedResultField.equals(Object)",
    "int ExpectedResultField.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExpectedResultField("Name", "42"), null);
  }

  /**
   * Test {@link ExpectedResultField#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ExpectedResultField#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ExpectedResultField.equals(Object)",
    "int ExpectedResultField.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExpectedResultField("Name", "42"), "Different type to ExpectedResultField");
  }
}
