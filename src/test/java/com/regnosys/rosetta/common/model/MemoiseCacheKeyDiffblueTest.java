package com.regnosys.rosetta.common.model;

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
import org.junit.Test;

public class MemoiseCacheKeyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MemoiseCacheKey#equals(Object)}
   *   <li>{@link MemoiseCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MemoiseCacheKey createResult = MemoiseCacheKey.create("Name", "Arguments");
    MemoiseCacheKey createResult2 = MemoiseCacheKey.create("Name", "Arguments");

    // Act and Assert
    assertEquals(createResult, createResult2);
    int expectedHashCodeResult = createResult.hashCode();
    assertEquals(expectedHashCodeResult, createResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MemoiseCacheKey#equals(Object)}
   *   <li>{@link MemoiseCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MemoiseCacheKey createResult = MemoiseCacheKey.create("Name", "Arguments");

    // Act and Assert
    assertEquals(createResult, createResult);
    int expectedHashCodeResult = createResult.hashCode();
    assertEquals(expectedHashCodeResult, createResult.hashCode());
  }

  /**
   * Method under test: {@link MemoiseCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MemoiseCacheKey createResult = MemoiseCacheKey.create(null, "Arguments");

    // Act and Assert
    assertNotEquals(createResult, MemoiseCacheKey.create("Name", "Arguments"));
  }

  /**
   * Method under test: {@link MemoiseCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MemoiseCacheKey createResult = MemoiseCacheKey.create("Name", 1);

    // Act and Assert
    assertNotEquals(createResult, MemoiseCacheKey.create("Name", "Arguments"));
  }

  /**
   * Method under test: {@link MemoiseCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MemoiseCacheKey createResult = MemoiseCacheKey.create("Name", MemoiseCacheKey.create("Name", "Arguments"));

    // Act and Assert
    assertNotEquals(createResult, MemoiseCacheKey.create("Name", "Arguments"));
  }

  /**
   * Method under test: {@link MemoiseCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MemoiseCacheKey.create("Name", "Arguments"), null);
  }

  /**
   * Method under test: {@link MemoiseCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MemoiseCacheKey.create("Name", "Arguments"), "Different type to MemoiseCacheKey");
  }
}
