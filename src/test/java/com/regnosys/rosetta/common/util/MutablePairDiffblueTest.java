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

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class MutablePairDiffblueTest {
  /**
   * Test {@link MutablePair#of(Object, Object)}.
   *
   * <p>Method under test: {@link MutablePair#of(Object, Object)}
   */
  @Test
  @DisplayName("Test of(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MutablePair MutablePair.of(Object, Object)"})
  void testOf() {
    // Arrange
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;

    // Act
    MutablePair<Object, Object> actualOfResult =
        MutablePair.of(BeanPropertyWriter.MARKER_FOR_EMPTY, object);

    // Assert
    assertSame(object, actualOfResult.getLeft());
    assertSame(object, actualOfResult.getRight());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MutablePair#MutablePair(Object, Object)}
   *   <li>{@link MutablePair#setLeft(Object)}
   *   <li>{@link MutablePair#setRight(Object)}
   *   <li>{@link MutablePair#getLeft()}
   *   <li>{@link MutablePair#getRight()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MutablePair.<init>(Object, Object)",
    "Object MutablePair.getLeft()",
    "Object MutablePair.getRight()",
    "void MutablePair.setLeft(Object)",
    "void MutablePair.setRight(Object)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    MutablePair<Object, Object> actualMutablePair =
        new MutablePair<>(BeanPropertyWriter.MARKER_FOR_EMPTY, BeanPropertyWriter.MARKER_FOR_EMPTY);
    actualMutablePair.setLeft(BeanPropertyWriter.MARKER_FOR_EMPTY);
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;
    actualMutablePair.setRight(object);
    Object actualLeft = actualMutablePair.getLeft();

    // Assert
    assertTrue(actualLeft instanceof Include);
    assertEquals(Include.NON_EMPTY, actualLeft);
    assertSame(object, actualLeft);
    assertSame(object, actualMutablePair.getRight());
  }

  /**
   * Test {@link MutablePair#setValue(Object)}.
   *
   * <p>Method under test: {@link MutablePair#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object MutablePair.setValue(Object)"})
  void testSetValue() {
    // Arrange
    MutablePair<Object, Object> ofResult =
        MutablePair.of(BeanPropertyWriter.MARKER_FOR_EMPTY, BeanPropertyWriter.MARKER_FOR_EMPTY);
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;

    // Act
    Object actualSetValueResult = ofResult.setValue(object);

    // Assert
    assertSame(object, actualSetValueResult);
  }
}
