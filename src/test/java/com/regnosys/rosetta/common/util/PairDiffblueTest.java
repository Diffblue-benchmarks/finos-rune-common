package com.regnosys.rosetta.common.util;

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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PairDiffblueTest {
  /**
   * Test {@link Pair#of(Object, Object)}.
   * <p>
   * Method under test: {@link Pair#of(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Pair Pair.of(Object, Object)"})
  public void testOf() {
    // Arrange and Act
    Pair<Object, Object> actualOfResult = Pair.of("Left", "Right");

    // Assert
    assertEquals("Left", actualOfResult.left());
    assertEquals("Right", actualOfResult.right());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Pair#toString()}
   *   <li>{@link Pair#left()}
   *   <li>{@link Pair#right()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object Pair.left()", "Object Pair.right()", "String Pair.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    Pair<Object, Object> ofResult = Pair.of("Left", "Right");

    // Act
    String actualToStringResult = ofResult.toString();
    Object actualLeftResult = ofResult.left();

    // Assert
    assertEquals("(Left,Right)", actualToStringResult);
    assertEquals("Left", actualLeftResult);
    assertEquals("Right", ofResult.right());
  }

  /**
   * Test {@link Pair#equals(Object)}, and {@link Pair#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Pair#equals(Object)}
   *   <li>{@link Pair#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Pair.equals(Object)", "int Pair.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Pair<Object, Object> ofResult = Pair.of("Left", "Right");
    Pair<Object, Object> ofResult2 = Pair.of("Left", "Right");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Test {@link Pair#equals(Object)}, and {@link Pair#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Pair#equals(Object)}
   *   <li>{@link Pair#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Pair.equals(Object)", "int Pair.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Pair<Object, Object> ofResult = Pair.of("Left", "Right");

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Test {@link Pair#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Pair#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Pair.equals(Object)", "int Pair.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Pair<Object, Object> ofResult = Pair.<Object, Object>of(1, "Right");
    Pair<Object, Object> ofResult2 = Pair.of("Left", "Right");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Test {@link Pair#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Pair#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Pair.equals(Object)", "int Pair.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Pair<Object, Object> ofResult = Pair.of("Left", "Right");
    Pair<Object, Object> ofResult2 = Pair.of(ofResult, "Right");
    Pair<Object, Object> ofResult3 = Pair.of("Left", "Right");

    // Act and Assert
    assertNotEquals(ofResult2, ofResult3);
  }

  /**
   * Test {@link Pair#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Pair#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Pair.equals(Object)", "int Pair.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Pair<Object, Object> ofResult = Pair.<Object, Object>of("Left", 1);
    Pair<Object, Object> ofResult2 = Pair.of("Left", "Right");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Test {@link Pair#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Pair#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Pair.equals(Object)", "int Pair.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Pair<Object, Object> ofResult = Pair.of("Left", "Right");
    Pair<Object, Object> ofResult2 = Pair.of("Left", ofResult);
    Pair<Object, Object> ofResult3 = Pair.of("Left", "Right");

    // Act and Assert
    assertNotEquals(ofResult2, ofResult3);
  }

  /**
   * Test {@link Pair#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Pair#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Pair.equals(Object)", "int Pair.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Pair<Object, Object> ofResult = Pair.of("Left", "Right");

    // Act and Assert
    assertNotEquals(ofResult, null);
  }

  /**
   * Test {@link Pair#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Pair#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Pair.equals(Object)", "int Pair.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Pair<Object, Object> ofResult = Pair.of("Left", "Right");

    // Act and Assert
    assertNotEquals(ofResult, "Different type to Pair");
  }
}
