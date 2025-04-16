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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExpectedResultFieldDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return toString is {@code ExpectedResultField[name='null', value='null']}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExpectedResultField#ExpectedResultField()}
   *   <li>{@link ExpectedResultField#toString()}
   *   <li>{@link ExpectedResultField#getName()}
   *   <li>{@link ExpectedResultField#getValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExpectedResultField.<init>()", "void ExpectedResultField.<init>(String, String)",
      "String ExpectedResultField.getName()", "String ExpectedResultField.getValue()",
      "String ExpectedResultField.toString()"})
  public void testGettersAndSetters_thenReturnToStringIsExpectedResultFieldNameNullValueNull() {
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
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return Value is {@code 42}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExpectedResultField#ExpectedResultField(String, String)}
   *   <li>{@link ExpectedResultField#toString()}
   *   <li>{@link ExpectedResultField#getName()}
   *   <li>{@link ExpectedResultField#getValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExpectedResultField.<init>()", "void ExpectedResultField.<init>(String, String)",
      "String ExpectedResultField.getName()", "String ExpectedResultField.getValue()",
      "String ExpectedResultField.toString()"})
  public void testGettersAndSetters_whenName_thenReturnValueIs42() {
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
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExpectedResultField#equals(Object)}
   *   <li>{@link ExpectedResultField#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExpectedResultField.equals(Object)", "int ExpectedResultField.hashCode()"})
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
   * Test {@link ExpectedResultField#equals(Object)}, and {@link ExpectedResultField#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExpectedResultField#equals(Object)}
   *   <li>{@link ExpectedResultField#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExpectedResultField.equals(Object)", "int ExpectedResultField.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExpectedResultField expectedResultField = new ExpectedResultField("Name", "42");

    // Act and Assert
    assertEquals(expectedResultField, expectedResultField);
    int expectedHashCodeResult = expectedResultField.hashCode();
    assertEquals(expectedHashCodeResult, expectedResultField.hashCode());
  }

  /**
   * Test {@link ExpectedResultField#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExpectedResultField#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExpectedResultField.equals(Object)", "int ExpectedResultField.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExpectedResultField expectedResultField = new ExpectedResultField(null, "42");

    // Act and Assert
    assertNotEquals(expectedResultField, new ExpectedResultField("Name", "42"));
  }

  /**
   * Test {@link ExpectedResultField#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExpectedResultField#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExpectedResultField.equals(Object)", "int ExpectedResultField.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ExpectedResultField expectedResultField = new ExpectedResultField("Name", "Value");

    // Act and Assert
    assertNotEquals(expectedResultField, new ExpectedResultField("Name", "42"));
  }

  /**
   * Test {@link ExpectedResultField#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExpectedResultField#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExpectedResultField.equals(Object)", "int ExpectedResultField.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExpectedResultField("Name", "42"), null);
  }

  /**
   * Test {@link ExpectedResultField#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExpectedResultField#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExpectedResultField.equals(Object)", "int ExpectedResultField.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExpectedResultField("Name", "42"), "Different type to ExpectedResultField");
  }
}
