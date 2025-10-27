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
import org.junit.Test;

public class ExpectedResultFieldDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExpectedResultField#equals(Object)}
   *   <li>{@link ExpectedResultField#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExpectedResultField expectedResultField = new ExpectedResultField("Name", "42");
    ExpectedResultField expectedResultField2 = new ExpectedResultField("Name", "42");

    // Act and Assert
    assertEquals(expectedResultField, expectedResultField2);
    int expectedHashCodeResult = expectedResultField.hashCode();
    assertEquals(expectedHashCodeResult, expectedResultField2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExpectedResultField#equals(Object)}
   *   <li>{@link ExpectedResultField#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExpectedResultField expectedResultField = new ExpectedResultField("Name", "42");

    // Act and Assert
    assertEquals(expectedResultField, expectedResultField);
    int expectedHashCodeResult = expectedResultField.hashCode();
    assertEquals(expectedHashCodeResult, expectedResultField.hashCode());
  }

  /**
   * Method under test: {@link ExpectedResultField#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExpectedResultField expectedResultField = new ExpectedResultField(null, "42");

    // Act and Assert
    assertNotEquals(expectedResultField, new ExpectedResultField("Name", "42"));
  }

  /**
   * Method under test: {@link ExpectedResultField#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ExpectedResultField expectedResultField = new ExpectedResultField("Name", "Value");

    // Act and Assert
    assertNotEquals(expectedResultField, new ExpectedResultField("Name", "42"));
  }

  /**
   * Method under test: {@link ExpectedResultField#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExpectedResultField("Name", "42"), null);
  }

  /**
   * Method under test: {@link ExpectedResultField#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExpectedResultField("Name", "42"), "Different type to ExpectedResultField");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExpectedResultField#ExpectedResultField()}
   *   <li>{@link ExpectedResultField#toString()}
   *   <li>{@link ExpectedResultField#getName()}
   *   <li>{@link ExpectedResultField#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link ExpectedResultField#ExpectedResultField(String, String)}
   *   <li>{@link ExpectedResultField#toString()}
   *   <li>{@link ExpectedResultField#getName()}
   *   <li>{@link ExpectedResultField#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    ExpectedResultField actualExpectedResultField = new ExpectedResultField("Name", "42");
    String actualToStringResult = actualExpectedResultField.toString();
    String actualName = actualExpectedResultField.getName();

    // Assert
    assertEquals("42", actualExpectedResultField.getValue());
    assertEquals("ExpectedResultField[name='Name', value='42']", actualToStringResult);
    assertEquals("Name", actualName);
  }
}
