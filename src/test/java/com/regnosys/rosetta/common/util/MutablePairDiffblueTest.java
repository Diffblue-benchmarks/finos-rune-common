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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MutablePairDiffblueTest {
  /**
   * Test {@link MutablePair#of(Object, Object)}.
   * <p>
   * Method under test: {@link MutablePair#of(Object, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MutablePair MutablePair.of(Object, Object)"})
  public void testOf() {
    // Arrange and Act
    MutablePair<Object, Object> actualOfResult = MutablePair.of("Left", "Right");

    // Assert
    assertEquals("Left", actualOfResult.getLeft());
    assertEquals("Right", actualOfResult.getRight());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MutablePair#MutablePair(Object, Object)}
   *   <li>{@link MutablePair#setLeft(Object)}
   *   <li>{@link MutablePair#setRight(Object)}
   *   <li>{@link MutablePair#getLeft()}
   *   <li>{@link MutablePair#getRight()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MutablePair.<init>(Object, Object)", "Object MutablePair.getLeft()",
      "Object MutablePair.getRight()", "void MutablePair.setLeft(Object)", "void MutablePair.setRight(Object)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    MutablePair<Object, Object> actualMutablePair = new MutablePair<>("Left", "Right");
    actualMutablePair.setLeft("Left");
    actualMutablePair.setRight("Right");
    Object actualLeft = actualMutablePair.getLeft();

    // Assert
    assertEquals("Left", actualLeft);
    assertEquals("Right", actualMutablePair.getRight());
  }

  /**
   * Test {@link MutablePair#setValue(Object)}.
   * <p>
   * Method under test: {@link MutablePair#setValue(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object MutablePair.setValue(Object)"})
  public void testSetValue() {
    // Arrange
    MutablePair<Object, Object> ofResult = MutablePair.of("Left", "Right");

    // Act and Assert
    assertEquals("Right", ofResult.setValue("Value"));
    assertEquals("Value", ofResult.getRight());
  }
}
