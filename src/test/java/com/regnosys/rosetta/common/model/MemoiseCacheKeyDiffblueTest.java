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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MemoiseCacheKeyDiffblueTest {
  /**
   * Test {@link MemoiseCacheKey#equals(Object)}, and {@link MemoiseCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MemoiseCacheKey#equals(Object)}
   *   <li>{@link MemoiseCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MemoiseCacheKey.equals(Object)", "int MemoiseCacheKey.hashCode()"})
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
   * Test {@link MemoiseCacheKey#equals(Object)}, and {@link MemoiseCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MemoiseCacheKey#equals(Object)}
   *   <li>{@link MemoiseCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MemoiseCacheKey.equals(Object)", "int MemoiseCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MemoiseCacheKey createResult = MemoiseCacheKey.create("Name", "Arguments");

    // Act and Assert
    assertEquals(createResult, createResult);
    int expectedHashCodeResult = createResult.hashCode();
    assertEquals(expectedHashCodeResult, createResult.hashCode());
  }

  /**
   * Test {@link MemoiseCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoiseCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MemoiseCacheKey.equals(Object)", "int MemoiseCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MemoiseCacheKey createResult = MemoiseCacheKey.create(null, "Arguments");

    // Act and Assert
    assertNotEquals(createResult, MemoiseCacheKey.create("Name", "Arguments"));
  }

  /**
   * Test {@link MemoiseCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoiseCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MemoiseCacheKey.equals(Object)", "int MemoiseCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MemoiseCacheKey createResult = MemoiseCacheKey.create("Name", 1);

    // Act and Assert
    assertNotEquals(createResult, MemoiseCacheKey.create("Name", "Arguments"));
  }

  /**
   * Test {@link MemoiseCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoiseCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MemoiseCacheKey.equals(Object)", "int MemoiseCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MemoiseCacheKey createResult = MemoiseCacheKey.create("Name", MemoiseCacheKey.create("Name", "Arguments"));

    // Act and Assert
    assertNotEquals(createResult, MemoiseCacheKey.create("Name", "Arguments"));
  }

  /**
   * Test {@link MemoiseCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoiseCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MemoiseCacheKey.equals(Object)", "int MemoiseCacheKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MemoiseCacheKey.create("Name", "Arguments"), null);
  }

  /**
   * Test {@link MemoiseCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MemoiseCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MemoiseCacheKey.equals(Object)", "int MemoiseCacheKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MemoiseCacheKey.create("Name", "Arguments"), "Different type to MemoiseCacheKey");
  }
}
