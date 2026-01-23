package com.regnosys.rosetta.common.util;

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
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rosetta.model.lib.path.RosettaPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PathValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PathValue#PathValue(RosettaPath, String)}
   *   <li>{@link PathValue#getHierarchicalPath()}
   *   <li>{@link PathValue#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PathValue.<init>(RosettaPath, String)",
    "RosettaPath PathValue.getHierarchicalPath()",
    "String PathValue.getValue()",
    "String PathValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    PathValue actualPathValue = new PathValue(null, "42");
    RosettaPath actualHierarchicalPath = actualPathValue.getHierarchicalPath();

    // Assert
    assertEquals("42", actualPathValue.getValue());
    assertNull(actualHierarchicalPath);
  }

  /**
   * Test {@link PathValue#equals(Object)}, and {@link PathValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PathValue#equals(Object)}
   *   <li>{@link PathValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PathValue pathValue = PathValue.EMPTY;
    PathValue pathValue2 = PathValue.EMPTY;

    // Act and Assert
    assertEquals(pathValue, pathValue2);
    assertEquals(pathValue.hashCode(), pathValue2.hashCode());
  }

  /**
   * Test {@link PathValue#equals(Object)}, and {@link PathValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PathValue#equals(Object)}
   *   <li>{@link PathValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PathValue pathValue = new PathValue(null, "42");
    PathValue pathValue2 = new PathValue(null, "42");

    // Act and Assert
    assertEquals(pathValue, pathValue2);
    assertEquals(pathValue.hashCode(), pathValue2.hashCode());
  }

  /**
   * Test {@link PathValue#equals(Object)}, and {@link PathValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PathValue#equals(Object)}
   *   <li>{@link PathValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PathValue pathValue = new PathValue(null, null);
    PathValue pathValue2 = new PathValue(null, null);

    // Act and Assert
    assertEquals(pathValue, pathValue2);
    assertEquals(pathValue.hashCode(), pathValue2.hashCode());
  }

  /**
   * Test {@link PathValue#equals(Object)}, and {@link PathValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PathValue#equals(Object)}
   *   <li>{@link PathValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PathValue pathValue = PathValue.EMPTY;

    // Act and Assert
    assertEquals(pathValue, pathValue);
    int expectedHashCodeResult = pathValue.hashCode();
    assertEquals(expectedHashCodeResult, pathValue.hashCode());
  }

  /**
   * Test {@link PathValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PathValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PathValue(null, "42"), PathValue.EMPTY);
  }

  /**
   * Test {@link PathValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PathValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new PathValue(mock(RosettaPath.class), "42"), PathValue.EMPTY);
  }

  /**
   * Test {@link PathValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PathValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PathValue pathValue = new PathValue(null, null);

    // Act and Assert
    assertNotEquals(pathValue, new PathValue(null, "42"));
  }

  /**
   * Test {@link PathValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PathValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PathValue.EMPTY, null);
  }

  /**
   * Test {@link PathValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PathValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PathValue.EMPTY, "Different type to PathValue");
  }
}
