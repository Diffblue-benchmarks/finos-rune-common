package com.regnosys.rosetta.common.translation.flat;

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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class IndexCapturePathDiffblueTest {
  /**
   * Method under test:
   * {@link IndexCapturePath.IndexCapturePathElement#compareTo(IndexCapturePath.IndexCapturePathElement)}
   */
  @Test
  public void testIndexCapturePathElementCompareTo() {
    // Arrange
    IndexCapturePath.IndexCapturePathElement parseResult = IndexCapturePath.IndexCapturePathElement.parse("foo");

    // Act and Assert
    assertEquals(0, parseResult.compareTo(IndexCapturePath.IndexCapturePathElement.parse("foo")));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IndexCapturePath.IndexCapturePathElement#equals(Object)}
   *   <li>{@link IndexCapturePath.IndexCapturePathElement#hashCode()}
   * </ul>
   */
  @Test
  public void testIndexCapturePathElementEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    IndexCapturePath.IndexCapturePathElement parseResult = IndexCapturePath.IndexCapturePathElement.parse("foo");
    IndexCapturePath.IndexCapturePathElement parseResult2 = IndexCapturePath.IndexCapturePathElement.parse("foo");

    // Act and Assert
    assertEquals(parseResult, parseResult2);
    int expectedHashCodeResult = parseResult.hashCode();
    assertEquals(expectedHashCodeResult, parseResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IndexCapturePath.IndexCapturePathElement#equals(Object)}
   *   <li>{@link IndexCapturePath.IndexCapturePathElement#hashCode()}
   * </ul>
   */
  @Test
  public void testIndexCapturePathElementEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IndexCapturePath.IndexCapturePathElement parseResult = IndexCapturePath.IndexCapturePathElement.parse("foo");

    // Act and Assert
    assertEquals(parseResult, parseResult);
    int expectedHashCodeResult = parseResult.hashCode();
    assertEquals(expectedHashCodeResult, parseResult.hashCode());
  }

  /**
   * Method under test:
   * {@link IndexCapturePath.IndexCapturePathElement#equals(Object)}
   */
  @Test
  public void testIndexCapturePathElementEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IndexCapturePath.IndexCapturePathElement parseResult = IndexCapturePath.IndexCapturePathElement.parse("");

    // Act and Assert
    assertNotEquals(parseResult, IndexCapturePath.IndexCapturePathElement.parse("foo"));
  }

  /**
   * Method under test:
   * {@link IndexCapturePath.IndexCapturePathElement#equals(Object)}
   */
  @Test
  public void testIndexCapturePathElementEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IndexCapturePath.IndexCapturePathElement.parse("foo"), null);
  }

  /**
   * Method under test:
   * {@link IndexCapturePath.IndexCapturePathElement#equals(Object)}
   */
  @Test
  public void testIndexCapturePathElementEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IndexCapturePath.IndexCapturePathElement.parse("foo"), "Different type to IndexCapturePathElement");
  }

  /**
   * Method under test:
   * {@link IndexCapturePath.IndexCapturePathElement#matches(IndexCapturePath.IndexCapturePathElement)}
   */
  @Test
  public void testIndexCapturePathElementMatches() {
    // Arrange
    IndexCapturePath.IndexCapturePathElement parseResult = IndexCapturePath.IndexCapturePathElement.parse("foo");

    // Act and Assert
    assertTrue(parseResult.matches(IndexCapturePath.IndexCapturePathElement.parse("foo")));
  }

  /**
   * Method under test:
   * {@link IndexCapturePath.IndexCapturePathElement#matches(IndexCapturePath.IndexCapturePathElement)}
   */
  @Test
  public void testIndexCapturePathElementMatches2() {
    // Arrange
    IndexCapturePath.IndexCapturePathElement parseResult = IndexCapturePath.IndexCapturePathElement.parse("");

    // Act and Assert
    assertFalse(parseResult.matches(IndexCapturePath.IndexCapturePathElement.parse("foo")));
  }

  /**
   * Method under test:
   * {@link IndexCapturePath.IndexCapturePathElement#matches(IndexCapturePath.IndexCapturePathElement)}
   */
  @Test
  public void testIndexCapturePathElementMatches3() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePath.IndexCapturePathElement.parse("foo").matches(null));
  }

  /**
   * Method under test:
   * {@link IndexCapturePath.IndexCapturePathElement#parse(String)}
   */
  @Test
  public void testIndexCapturePathElementParse() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePath.IndexCapturePathElement.parse("foo").matches(null));
  }

  /**
   * Method under test:
   * {@link IndexCapturePath.IndexCapturePathElement#toString()}
   */
  @Test
  public void testIndexCapturePathElementToString() {
    // Arrange, Act and Assert
    assertEquals("foo", IndexCapturePath.IndexCapturePathElement.parse("foo").toString());
  }

  /**
   * Method under test:
   * {@link IndexCapturePath.IndexCapturePathElement#toUnindexed()}
   */
  @Test
  public void testIndexCapturePathElementToUnindexed() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePath.IndexCapturePathElement.parse("foo").toUnindexed().matches(null));
  }

  /**
   * Method under test: {@link IndexCapturePath#parse(String)}
   */
  @Test
  public void testParse() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePath.parse("foo").getLastIndex().isPresent());
  }

  /**
   * Method under test: {@link IndexCapturePath#toUnindexed()}
   */
  @Test
  public void testToUnindexed() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePath.parse("foo").toUnindexed().getLastIndex().isPresent());
  }

  /**
   * Method under test: {@link IndexCapturePath#captureIndexes(IndexCapturePath)}
   */
  @Test
  public void testCaptureIndexes() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("foo");

    // Act and Assert
    assertTrue(parseResult.captureIndexes(IndexCapturePath.parse("foo")).isEmpty());
  }

  /**
   * Method under test: {@link IndexCapturePath#captureIndexes(IndexCapturePath)}
   */
  @Test
  public void testCaptureIndexes2() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath
        .parse("com.regnosys.rosetta.common.translation.flat.IndexCapturePath");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> parseResult.captureIndexes(IndexCapturePath.parse("foo")));
  }

  /**
   * Method under test: {@link IndexCapturePath#captureIndexes(IndexCapturePath)}
   */
  @Test
  public void testCaptureIndexes3() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> parseResult.captureIndexes(IndexCapturePath.parse("foo")));
  }

  /**
   * Method under test: {@link IndexCapturePath#captureIndexes(IndexCapturePath)}
   */
  @Test
  public void testCaptureIndexes4() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> IndexCapturePath.parse("foo").captureIndexes(null));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IndexCapturePath#equals(Object)}
   *   <li>{@link IndexCapturePath#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("foo");
    IndexCapturePath parseResult2 = IndexCapturePath.parse("foo");

    // Act and Assert
    assertEquals(parseResult, parseResult2);
    int expectedHashCodeResult = parseResult.hashCode();
    assertEquals(expectedHashCodeResult, parseResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IndexCapturePath#equals(Object)}
   *   <li>{@link IndexCapturePath#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("foo");

    // Act and Assert
    assertEquals(parseResult, parseResult);
    int expectedHashCodeResult = parseResult.hashCode();
    assertEquals(expectedHashCodeResult, parseResult.hashCode());
  }

  /**
   * Method under test: {@link IndexCapturePath#matches(IndexCapturePath)}
   */
  @Test
  public void testMatches() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("foo");

    // Act and Assert
    assertTrue(parseResult.matches(IndexCapturePath.parse("foo")));
  }

  /**
   * Method under test: {@link IndexCapturePath#matches(IndexCapturePath)}
   */
  @Test
  public void testMatches2() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath
        .parse("com.regnosys.rosetta.common.translation.flat.IndexCapturePath");

    // Act and Assert
    assertFalse(parseResult.matches(IndexCapturePath.parse("foo")));
  }

  /**
   * Method under test: {@link IndexCapturePath#matches(IndexCapturePath)}
   */
  @Test
  public void testMatches3() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("42");

    // Act and Assert
    assertFalse(parseResult.matches(IndexCapturePath.parse("foo")));
  }

  /**
   * Method under test: {@link IndexCapturePath#matches(IndexCapturePath)}
   */
  @Test
  public void testMatches4() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePath.parse("foo").matches(null));
  }

  /**
   * Method under test: {@link IndexCapturePath#compareTo(IndexCapturePath)}
   */
  @Test
  public void testCompareTo() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("foo");

    // Act and Assert
    assertEquals(0, parseResult.compareTo(IndexCapturePath.parse("foo")));
  }

  /**
   * Method under test: {@link IndexCapturePath#compareTo(IndexCapturePath)}
   */
  @Test
  public void testCompareTo2() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath
        .parse("com.regnosys.rosetta.common.translation.flat.IndexCapturePath");

    // Act and Assert
    assertEquals(-3, parseResult.compareTo(IndexCapturePath.parse("foo")));
  }

  /**
   * Method under test: {@link IndexCapturePath#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath
        .parse("com.regnosys.rosetta.common.translation.flat.IndexCapturePath");

    // Act and Assert
    assertNotEquals(parseResult, IndexCapturePath.parse("foo"));
  }

  /**
   * Method under test: {@link IndexCapturePath#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(IndexCapturePath.parse("foo"), mock(IndexCapturePath.IndexCapturePathElement.class));
  }

  /**
   * Method under test: {@link IndexCapturePath#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IndexCapturePath.parse("foo"), null);
  }

  /**
   * Method under test: {@link IndexCapturePath#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IndexCapturePath.parse("foo"), "Different type to IndexCapturePath");
  }

  /**
   * Method under test: {@link IndexCapturePath#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("IndexCapturePath [foo]", IndexCapturePath.parse("foo").toString());
  }

  /**
   * Method under test: {@link IndexCapturePath#getLastIndex()}
   */
  @Test
  public void testGetLastIndex() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePath.parse("foo").getLastIndex().isPresent());
  }
}
