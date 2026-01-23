package com.regnosys.rosetta.common.model;

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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MemoiseCacheKeyDiffblueTest {
  /**
   * Test {@link MemoiseCacheKey#equals(Object)}, and {@link MemoiseCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MemoiseCacheKey#equals(Object)}
   *   <li>{@link MemoiseCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemoiseCacheKey.equals(Object)", "int MemoiseCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MemoiseCacheKey createResult =
        MemoiseCacheKey.create("Name", BeanPropertyWriter.MARKER_FOR_EMPTY);
    MemoiseCacheKey createResult2 =
        MemoiseCacheKey.create("Name", BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act and Assert
    assertEquals(createResult, createResult2);
    assertEquals(createResult.hashCode(), createResult2.hashCode());
  }

  /**
   * Test {@link MemoiseCacheKey#equals(Object)}, and {@link MemoiseCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MemoiseCacheKey#equals(Object)}
   *   <li>{@link MemoiseCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemoiseCacheKey.equals(Object)", "int MemoiseCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MemoiseCacheKey createResult =
        MemoiseCacheKey.create("Name", BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act and Assert
    assertEquals(createResult, createResult);
    int expectedHashCodeResult = createResult.hashCode();
    assertEquals(expectedHashCodeResult, createResult.hashCode());
  }

  /**
   * Test {@link MemoiseCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MemoiseCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemoiseCacheKey.equals(Object)", "int MemoiseCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MemoiseCacheKey.create("Name", BeanPropertyWriter.MARKER_FOR_EMPTY), 1);
  }

  /**
   * Test {@link MemoiseCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MemoiseCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemoiseCacheKey.equals(Object)", "int MemoiseCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MemoiseCacheKey createResult =
        MemoiseCacheKey.create(null, BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act and Assert
    assertNotEquals(
        createResult, MemoiseCacheKey.create("Name", BeanPropertyWriter.MARKER_FOR_EMPTY));
  }

  /**
   * Test {@link MemoiseCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MemoiseCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemoiseCacheKey.equals(Object)", "int MemoiseCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MemoiseCacheKey createResult = MemoiseCacheKey.create("Name", 1);

    // Act and Assert
    assertNotEquals(
        createResult, MemoiseCacheKey.create("Name", BeanPropertyWriter.MARKER_FOR_EMPTY));
  }

  /**
   * Test {@link MemoiseCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MemoiseCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemoiseCacheKey.equals(Object)", "int MemoiseCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MemoiseCacheKey createResult =
        MemoiseCacheKey.create(
            "Name", MemoiseCacheKey.create("Name", BeanPropertyWriter.MARKER_FOR_EMPTY));

    // Act and Assert
    assertNotEquals(
        createResult, MemoiseCacheKey.create("Name", BeanPropertyWriter.MARKER_FOR_EMPTY));
  }

  /**
   * Test {@link MemoiseCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MemoiseCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemoiseCacheKey.equals(Object)", "int MemoiseCacheKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MemoiseCacheKey.create("Name", BeanPropertyWriter.MARKER_FOR_EMPTY), null);
  }

  /**
   * Test {@link MemoiseCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MemoiseCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MemoiseCacheKey.equals(Object)", "int MemoiseCacheKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        MemoiseCacheKey.create("Name", BeanPropertyWriter.MARKER_FOR_EMPTY),
        "Different type to MemoiseCacheKey");
  }
}
