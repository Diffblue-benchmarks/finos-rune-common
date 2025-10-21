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
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rosetta.model.lib.path.RosettaPath;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PathValueDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PathValue#PathValue(RosettaPath, String)}
   *   <li>{@link PathValue#getHierarchicalPath()}
   *   <li>{@link PathValue#getValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PathValue.<init>(RosettaPath, String)", "RosettaPath PathValue.getHierarchicalPath()",
      "String PathValue.getValue()", "String PathValue.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    PathValue actualPathValue = new PathValue(null, "42");
    RosettaPath actualHierarchicalPath = actualPathValue.getHierarchicalPath();

    // Assert
    assertEquals("42", actualPathValue.getValue());
    assertNull(actualHierarchicalPath);
  }

  /**
   * Test {@link PathValue#equals(Object)}, and {@link PathValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PathValue#equals(Object)}
   *   <li>{@link PathValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PathValue pathValue = PathValue.EMPTY;
    PathValue pathValue2 = PathValue.EMPTY;

    // Act and Assert
    assertEquals(pathValue, pathValue2);
    int expectedHashCodeResult = pathValue.hashCode();
    assertEquals(expectedHashCodeResult, pathValue2.hashCode());
  }

  /**
   * Test {@link PathValue#equals(Object)}, and {@link PathValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PathValue#equals(Object)}
   *   <li>{@link PathValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PathValue pathValue = new PathValue(null, "42");
    PathValue pathValue2 = new PathValue(null, "42");

    // Act and Assert
    assertEquals(pathValue, pathValue2);
    int expectedHashCodeResult = pathValue.hashCode();
    assertEquals(expectedHashCodeResult, pathValue2.hashCode());
  }

  /**
   * Test {@link PathValue#equals(Object)}, and {@link PathValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PathValue#equals(Object)}
   *   <li>{@link PathValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PathValue pathValue = new PathValue(null, null);
    PathValue pathValue2 = new PathValue(null, null);

    // Act and Assert
    assertEquals(pathValue, pathValue2);
    int expectedHashCodeResult = pathValue.hashCode();
    assertEquals(expectedHashCodeResult, pathValue2.hashCode());
  }

  /**
   * Test {@link PathValue#equals(Object)}, and {@link PathValue#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PathValue#equals(Object)}
   *   <li>{@link PathValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PathValue pathValue = PathValue.EMPTY;

    // Act and Assert
    assertEquals(pathValue, pathValue);
    int expectedHashCodeResult = pathValue.hashCode();
    assertEquals(expectedHashCodeResult, pathValue.hashCode());
  }

  /**
   * Test {@link PathValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PathValue(null, "42"), PathValue.EMPTY);
  }

  /**
   * Test {@link PathValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new PathValue(mock(RosettaPath.class), "42"), PathValue.EMPTY);
  }

  /**
   * Test {@link PathValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PathValue pathValue = new PathValue(null, null);

    // Act and Assert
    assertNotEquals(pathValue, new PathValue(null, "42"));
  }

  /**
   * Test {@link PathValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PathValue.EMPTY, null);
  }

  /**
   * Test {@link PathValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PathValue.equals(Object)", "int PathValue.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PathValue.EMPTY, "Different type to PathValue");
  }
}
