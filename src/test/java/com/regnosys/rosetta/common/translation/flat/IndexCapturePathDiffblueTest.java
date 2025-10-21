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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.translation.flat.IndexCapturePath.IndexCapturePathElement;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IndexCapturePathDiffblueTest {
  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#compareTo(IndexCapturePathElement)} with {@code IndexCapturePathElement}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePathElement#compareTo(IndexCapturePathElement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IndexCapturePathElement.compareTo(IndexCapturePathElement)"})
  public void testIndexCapturePathElementCompareToWithIndexCapturePathElement_thenReturnZero() {
    // Arrange
    IndexCapturePathElement parseResult = IndexCapturePathElement.parse("foo");

    // Act and Assert
    assertEquals(0, parseResult.compareTo(IndexCapturePathElement.parse("foo")));
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#equals(Object)}, and {@link IndexCapturePathElement#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IndexCapturePathElement#equals(Object)}
   *   <li>{@link IndexCapturePathElement#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePathElement.equals(Object)", "int IndexCapturePathElement.hashCode()"})
  public void testIndexCapturePathElementEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    IndexCapturePathElement parseResult = IndexCapturePathElement.parse("foo");
    IndexCapturePathElement parseResult2 = IndexCapturePathElement.parse("foo");

    // Act and Assert
    assertEquals(parseResult, parseResult2);
    int expectedHashCodeResult = parseResult.hashCode();
    assertEquals(expectedHashCodeResult, parseResult2.hashCode());
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#equals(Object)}, and {@link IndexCapturePathElement#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IndexCapturePathElement#equals(Object)}
   *   <li>{@link IndexCapturePathElement#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePathElement.equals(Object)", "int IndexCapturePathElement.hashCode()"})
  public void testIndexCapturePathElementEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IndexCapturePathElement parseResult = IndexCapturePathElement.parse("foo");

    // Act and Assert
    assertEquals(parseResult, parseResult);
    int expectedHashCodeResult = parseResult.hashCode();
    assertEquals(expectedHashCodeResult, parseResult.hashCode());
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePathElement#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePathElement.equals(Object)", "int IndexCapturePathElement.hashCode()"})
  public void testIndexCapturePathElementEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IndexCapturePathElement parseResult = IndexCapturePathElement.parse("");

    // Act and Assert
    assertNotEquals(parseResult, IndexCapturePathElement.parse("foo"));
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePathElement#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePathElement.equals(Object)", "int IndexCapturePathElement.hashCode()"})
  public void testIndexCapturePathElementEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IndexCapturePathElement.parse("foo"), null);
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePathElement#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePathElement.equals(Object)", "int IndexCapturePathElement.hashCode()"})
  public void testIndexCapturePathElementEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IndexCapturePathElement.parse("foo"), "Different type to IndexCapturePathElement");
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#matches(IndexCapturePathElement)}.
   * <ul>
   *   <li>Given parse empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePathElement#matches(IndexCapturePathElement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePathElement.matches(IndexCapturePathElement)"})
  public void testIndexCapturePathElementMatches_givenParseEmptyString_thenReturnFalse() {
    // Arrange
    IndexCapturePathElement parseResult = IndexCapturePathElement.parse("");

    // Act and Assert
    assertFalse(parseResult.matches(IndexCapturePathElement.parse("foo")));
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#matches(IndexCapturePathElement)}.
   * <ul>
   *   <li>Given parse {@code foo}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePathElement#matches(IndexCapturePathElement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePathElement.matches(IndexCapturePathElement)"})
  public void testIndexCapturePathElementMatches_givenParseFoo_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePathElement.parse("foo").matches(null));
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#matches(IndexCapturePathElement)}.
   * <ul>
   *   <li>Given parse {@code foo}.</li>
   *   <li>When parse {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePathElement#matches(IndexCapturePathElement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePathElement.matches(IndexCapturePathElement)"})
  public void testIndexCapturePathElementMatches_givenParseFoo_whenParseFoo_thenReturnTrue() {
    // Arrange
    IndexCapturePathElement parseResult = IndexCapturePathElement.parse("foo");

    // Act and Assert
    assertTrue(parseResult.matches(IndexCapturePathElement.parse("foo")));
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#parse(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return not matches {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePathElement#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IndexCapturePathElement IndexCapturePathElement.parse(String)"})
  public void testIndexCapturePathElementParse_whenFoo_thenReturnNotMatchesNull() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePathElement.parse("foo").matches(null));
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#toString()}.
   * <p>
   * Method under test: {@link IndexCapturePathElement#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String IndexCapturePathElement.toString()"})
  public void testIndexCapturePathElementToString() {
    // Arrange, Act and Assert
    assertEquals("foo", IndexCapturePathElement.parse("foo").toString());
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#toUnindexed()}.
   * <p>
   * Method under test: {@link IndexCapturePathElement#toUnindexed()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IndexCapturePathElement IndexCapturePathElement.toUnindexed()"})
  public void testIndexCapturePathElementToUnindexed() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePathElement.parse("foo").toUnindexed().matches(null));
  }

  /**
   * Test {@link IndexCapturePath#parse(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return not LastIndex Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePath#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IndexCapturePath IndexCapturePath.parse(String)"})
  public void testParse_whenFoo_thenReturnNotLastIndexPresent() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePath.parse("foo").getLastIndex().isPresent());
  }

  /**
   * Test {@link IndexCapturePath#toUnindexed()}.
   * <p>
   * Method under test: {@link IndexCapturePath#toUnindexed()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IndexCapturePath IndexCapturePath.toUnindexed()"})
  public void testToUnindexed() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePath.parse("foo").toUnindexed().getLastIndex().isPresent());
  }

  /**
   * Test {@link IndexCapturePath#captureIndexes(IndexCapturePath)}.
   * <p>
   * Method under test: {@link IndexCapturePath#captureIndexes(IndexCapturePath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Map IndexCapturePath.captureIndexes(IndexCapturePath)"})
  public void testCaptureIndexes() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath
        .parse("com.regnosys.rosetta.common.translation.flat.IndexCapturePath");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> parseResult.captureIndexes(IndexCapturePath.parse("foo")));
  }

  /**
   * Test {@link IndexCapturePath#captureIndexes(IndexCapturePath)}.
   * <ul>
   *   <li>Given parse {@code 42}.</li>
   *   <li>When parse {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePath#captureIndexes(IndexCapturePath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Map IndexCapturePath.captureIndexes(IndexCapturePath)"})
  public void testCaptureIndexes_givenParse42_whenParseFoo_thenThrowRuntimeException() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("42");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> parseResult.captureIndexes(IndexCapturePath.parse("foo")));
  }

  /**
   * Test {@link IndexCapturePath#captureIndexes(IndexCapturePath)}.
   * <ul>
   *   <li>Given parse {@code foo}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePath#captureIndexes(IndexCapturePath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Map IndexCapturePath.captureIndexes(IndexCapturePath)"})
  public void testCaptureIndexes_givenParseFoo_whenNull_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> IndexCapturePath.parse("foo").captureIndexes(null));
  }

  /**
   * Test {@link IndexCapturePath#captureIndexes(IndexCapturePath)}.
   * <ul>
   *   <li>Given parse {@code foo}.</li>
   *   <li>When parse {@code foo}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePath#captureIndexes(IndexCapturePath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Map IndexCapturePath.captureIndexes(IndexCapturePath)"})
  public void testCaptureIndexes_givenParseFoo_whenParseFoo_thenReturnEmpty() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("foo");

    // Act and Assert
    assertTrue(parseResult.captureIndexes(IndexCapturePath.parse("foo")).isEmpty());
  }

  /**
   * Test {@link IndexCapturePath#equals(Object)}, and {@link IndexCapturePath#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IndexCapturePath#equals(Object)}
   *   <li>{@link IndexCapturePath#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePath.equals(Object)", "int IndexCapturePath.hashCode()"})
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
   * Test {@link IndexCapturePath#equals(Object)}, and {@link IndexCapturePath#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IndexCapturePath#equals(Object)}
   *   <li>{@link IndexCapturePath#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePath.equals(Object)", "int IndexCapturePath.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("foo");

    // Act and Assert
    assertEquals(parseResult, parseResult);
    int expectedHashCodeResult = parseResult.hashCode();
    assertEquals(expectedHashCodeResult, parseResult.hashCode());
  }

  /**
   * Test {@link IndexCapturePath#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePath#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePath.equals(Object)", "int IndexCapturePath.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath
        .parse("com.regnosys.rosetta.common.translation.flat.IndexCapturePath");

    // Act and Assert
    assertNotEquals(parseResult, IndexCapturePath.parse("foo"));
  }

  /**
   * Test {@link IndexCapturePath#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePath#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePath.equals(Object)", "int IndexCapturePath.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IndexCapturePath.parse("foo"), null);
  }

  /**
   * Test {@link IndexCapturePath#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePath#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePath.equals(Object)", "int IndexCapturePath.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IndexCapturePath.parse("foo"), "Different type to IndexCapturePath");
  }

  /**
   * Test {@link IndexCapturePath#matches(IndexCapturePath)}.
   * <ul>
   *   <li>Given parse {@code 42}.</li>
   *   <li>When parse {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePath#matches(IndexCapturePath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePath.matches(IndexCapturePath)"})
  public void testMatches_givenParse42_whenParseFoo_thenReturnFalse() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("42");

    // Act and Assert
    assertFalse(parseResult.matches(IndexCapturePath.parse("foo")));
  }

  /**
   * Test {@link IndexCapturePath#matches(IndexCapturePath)}.
   * <ul>
   *   <li>Given parse {@code IndexCapturePath}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePath#matches(IndexCapturePath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePath.matches(IndexCapturePath)"})
  public void testMatches_givenParseComRegnosysRosettaCommonTranslationFlatIndexCapturePath() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath
        .parse("com.regnosys.rosetta.common.translation.flat.IndexCapturePath");

    // Act and Assert
    assertFalse(parseResult.matches(IndexCapturePath.parse("foo")));
  }

  /**
   * Test {@link IndexCapturePath#matches(IndexCapturePath)}.
   * <ul>
   *   <li>Given parse {@code foo}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePath#matches(IndexCapturePath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePath.matches(IndexCapturePath)"})
  public void testMatches_givenParseFoo_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePath.parse("foo").matches(null));
  }

  /**
   * Test {@link IndexCapturePath#matches(IndexCapturePath)}.
   * <ul>
   *   <li>Given parse {@code foo}.</li>
   *   <li>When parse {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePath#matches(IndexCapturePath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IndexCapturePath.matches(IndexCapturePath)"})
  public void testMatches_givenParseFoo_whenParseFoo_thenReturnTrue() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("foo");

    // Act and Assert
    assertTrue(parseResult.matches(IndexCapturePath.parse("foo")));
  }

  /**
   * Test {@link IndexCapturePath#compareTo(IndexCapturePath)} with {@code IndexCapturePath}.
   * <ul>
   *   <li>Given parse {@code foo}.</li>
   *   <li>When parse {@code foo}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePath#compareTo(IndexCapturePath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IndexCapturePath.compareTo(IndexCapturePath)"})
  public void testCompareToWithIndexCapturePath_givenParseFoo_whenParseFoo_thenReturnZero() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("foo");

    // Act and Assert
    assertEquals(0, parseResult.compareTo(IndexCapturePath.parse("foo")));
  }

  /**
   * Test {@link IndexCapturePath#compareTo(IndexCapturePath)} with {@code IndexCapturePath}.
   * <ul>
   *   <li>Then return minus three.</li>
   * </ul>
   * <p>
   * Method under test: {@link IndexCapturePath#compareTo(IndexCapturePath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int IndexCapturePath.compareTo(IndexCapturePath)"})
  public void testCompareToWithIndexCapturePath_thenReturnMinusThree() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath
        .parse("com.regnosys.rosetta.common.translation.flat.IndexCapturePath");

    // Act and Assert
    assertEquals(-3, parseResult.compareTo(IndexCapturePath.parse("foo")));
  }

  /**
   * Test {@link IndexCapturePath#toString()}.
   * <p>
   * Method under test: {@link IndexCapturePath#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String IndexCapturePath.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("IndexCapturePath [foo]", IndexCapturePath.parse("foo").toString());
  }

  /**
   * Test {@link IndexCapturePath#getLastIndex()}.
   * <p>
   * Method under test: {@link IndexCapturePath#getLastIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Optional IndexCapturePath.getLastIndex()"})
  public void testGetLastIndex() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePath.parse("foo").getLastIndex().isPresent());
  }
}
