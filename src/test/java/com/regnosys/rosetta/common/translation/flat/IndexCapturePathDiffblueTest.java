package com.regnosys.rosetta.common.translation.flat;

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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.translation.flat.IndexCapturePath.IndexCapturePathElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IndexCapturePathDiffblueTest {
  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#compareTo(IndexCapturePathElement)}
   * with {@code IndexCapturePathElement}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePathElement#compareTo(IndexCapturePathElement)}
   */
  @Test
  @DisplayName(
      "Test IndexCapturePathElement compareTo(IndexCapturePathElement) with 'IndexCapturePathElement'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IndexCapturePathElement.compareTo(IndexCapturePathElement)"})
  void testIndexCapturePathElementCompareToWithIndexCapturePathElement_thenReturnZero() {
    // Arrange
    IndexCapturePathElement parseResult = IndexCapturePathElement.parse("foo");

    // Act and Assert
    assertEquals(0, parseResult.compareTo(IndexCapturePathElement.parse("foo")));
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#equals(Object)}, and {@link
   * IndexCapturePathElement#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IndexCapturePathElement#equals(Object)}
   *   <li>{@link IndexCapturePathElement#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test IndexCapturePathElement equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IndexCapturePathElement.equals(Object)",
    "int IndexCapturePathElement.hashCode()"
  })
  void testIndexCapturePathElementEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    IndexCapturePathElement parseResult = IndexCapturePathElement.parse("foo");
    IndexCapturePathElement parseResult2 = IndexCapturePathElement.parse("foo");

    // Act and Assert
    assertEquals(parseResult, parseResult2);
    assertEquals(parseResult.hashCode(), parseResult2.hashCode());
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#equals(Object)}, and {@link
   * IndexCapturePathElement#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IndexCapturePathElement#equals(Object)}
   *   <li>{@link IndexCapturePathElement#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test IndexCapturePathElement equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IndexCapturePathElement.equals(Object)",
    "int IndexCapturePathElement.hashCode()"
  })
  void testIndexCapturePathElementEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IndexCapturePathElement parseResult = IndexCapturePathElement.parse("foo");

    // Act and Assert
    assertEquals(parseResult, parseResult);
    int expectedHashCodeResult = parseResult.hashCode();
    assertEquals(expectedHashCodeResult, parseResult.hashCode());
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePathElement#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test IndexCapturePathElement equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IndexCapturePathElement.equals(Object)",
    "int IndexCapturePathElement.hashCode()"
  })
  void testIndexCapturePathElementEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IndexCapturePathElement.parse("foo"), 1);
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePathElement#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test IndexCapturePathElement equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IndexCapturePathElement.equals(Object)",
    "int IndexCapturePathElement.hashCode()"
  })
  void testIndexCapturePathElementEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    IndexCapturePathElement parseResult = IndexCapturePathElement.parse("");

    // Act and Assert
    assertNotEquals(parseResult, IndexCapturePathElement.parse("foo"));
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePathElement#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test IndexCapturePathElement equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IndexCapturePathElement.equals(Object)",
    "int IndexCapturePathElement.hashCode()"
  })
  void testIndexCapturePathElementEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IndexCapturePathElement.parse("foo"), null);
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePathElement#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test IndexCapturePathElement equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IndexCapturePathElement.equals(Object)",
    "int IndexCapturePathElement.hashCode()"
  })
  void testIndexCapturePathElementEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        IndexCapturePathElement.parse("foo"), "Different type to IndexCapturePathElement");
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#matches(IndexCapturePathElement)}.
   *
   * <ul>
   *   <li>Given parse empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePathElement#matches(IndexCapturePathElement)}
   */
  @Test
  @DisplayName(
      "Test IndexCapturePathElement matches(IndexCapturePathElement); given parse empty string; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexCapturePathElement.matches(IndexCapturePathElement)"})
  void testIndexCapturePathElementMatches_givenParseEmptyString_thenReturnFalse() {
    // Arrange
    IndexCapturePathElement parseResult = IndexCapturePathElement.parse("");

    // Act and Assert
    assertFalse(parseResult.matches(IndexCapturePathElement.parse("foo")));
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#matches(IndexCapturePathElement)}.
   *
   * <ul>
   *   <li>Given parse {@code foo}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePathElement#matches(IndexCapturePathElement)}
   */
  @Test
  @DisplayName(
      "Test IndexCapturePathElement matches(IndexCapturePathElement); given parse 'foo'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexCapturePathElement.matches(IndexCapturePathElement)"})
  void testIndexCapturePathElementMatches_givenParseFoo_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePathElement.parse("foo").matches(null));
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#matches(IndexCapturePathElement)}.
   *
   * <ul>
   *   <li>Given parse {@code foo}.
   *   <li>When parse {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePathElement#matches(IndexCapturePathElement)}
   */
  @Test
  @DisplayName(
      "Test IndexCapturePathElement matches(IndexCapturePathElement); given parse 'foo'; when parse 'foo'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexCapturePathElement.matches(IndexCapturePathElement)"})
  void testIndexCapturePathElementMatches_givenParseFoo_whenParseFoo_thenReturnTrue() {
    // Arrange
    IndexCapturePathElement parseResult = IndexCapturePathElement.parse("foo");

    // Act and Assert
    assertTrue(parseResult.matches(IndexCapturePathElement.parse("foo")));
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#parse(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return not matches {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePathElement#parse(String)}
   */
  @Test
  @DisplayName(
      "Test IndexCapturePathElement parse(String); when 'foo'; then return not matches 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IndexCapturePathElement IndexCapturePathElement.parse(String)"})
  void testIndexCapturePathElementParse_whenFoo_thenReturnNotMatchesNull() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePathElement.parse("foo").matches(null));
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#toString()}.
   *
   * <p>Method under test: {@link IndexCapturePathElement#toString()}
   */
  @Test
  @DisplayName("Test IndexCapturePathElement toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String IndexCapturePathElement.toString()"})
  void testIndexCapturePathElementToString() {
    // Arrange, Act and Assert
    assertEquals("foo", IndexCapturePathElement.parse("foo").toString());
  }

  /**
   * Test IndexCapturePathElement {@link IndexCapturePathElement#toUnindexed()}.
   *
   * <p>Method under test: {@link IndexCapturePathElement#toUnindexed()}
   */
  @Test
  @DisplayName("Test IndexCapturePathElement toUnindexed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IndexCapturePathElement IndexCapturePathElement.toUnindexed()"})
  void testIndexCapturePathElementToUnindexed() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePathElement.parse("foo").toUnindexed().matches(null));
  }

  /**
   * Test {@link IndexCapturePath#parse(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return not LastIndex Present.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePath#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String); when 'foo'; then return not LastIndex Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IndexCapturePath IndexCapturePath.parse(String)"})
  void testParse_whenFoo_thenReturnNotLastIndexPresent() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePath.parse("foo").getLastIndex().isPresent());
  }

  /**
   * Test {@link IndexCapturePath#toUnindexed()}.
   *
   * <p>Method under test: {@link IndexCapturePath#toUnindexed()}
   */
  @Test
  @DisplayName("Test toUnindexed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IndexCapturePath IndexCapturePath.toUnindexed()"})
  void testToUnindexed() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePath.parse("foo").toUnindexed().getLastIndex().isPresent());
  }

  /**
   * Test {@link IndexCapturePath#captureIndexes(IndexCapturePath)}.
   *
   * <p>Method under test: {@link IndexCapturePath#captureIndexes(IndexCapturePath)}
   */
  @Test
  @DisplayName("Test captureIndexes(IndexCapturePath)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map IndexCapturePath.captureIndexes(IndexCapturePath)"})
  void testCaptureIndexes() {
    // Arrange
    IndexCapturePath parseResult =
        IndexCapturePath.parse("com.regnosys.rosetta.common.translation.flat.IndexCapturePath");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> parseResult.captureIndexes(IndexCapturePath.parse("foo")));
  }

  /**
   * Test {@link IndexCapturePath#captureIndexes(IndexCapturePath)}.
   *
   * <ul>
   *   <li>Given parse {@code 42}.
   *   <li>When parse {@code foo}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePath#captureIndexes(IndexCapturePath)}
   */
  @Test
  @DisplayName(
      "Test captureIndexes(IndexCapturePath); given parse '42'; when parse 'foo'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map IndexCapturePath.captureIndexes(IndexCapturePath)"})
  void testCaptureIndexes_givenParse42_whenParseFoo_thenThrowRuntimeException() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("42");

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> parseResult.captureIndexes(IndexCapturePath.parse("foo")));
  }

  /**
   * Test {@link IndexCapturePath#captureIndexes(IndexCapturePath)}.
   *
   * <ul>
   *   <li>Given parse {@code foo}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePath#captureIndexes(IndexCapturePath)}
   */
  @Test
  @DisplayName(
      "Test captureIndexes(IndexCapturePath); given parse 'foo'; when 'null'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map IndexCapturePath.captureIndexes(IndexCapturePath)"})
  void testCaptureIndexes_givenParseFoo_whenNull_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> IndexCapturePath.parse("foo").captureIndexes(null));
  }

  /**
   * Test {@link IndexCapturePath#captureIndexes(IndexCapturePath)}.
   *
   * <ul>
   *   <li>Given parse {@code foo}.
   *   <li>When parse {@code foo}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePath#captureIndexes(IndexCapturePath)}
   */
  @Test
  @DisplayName(
      "Test captureIndexes(IndexCapturePath); given parse 'foo'; when parse 'foo'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map IndexCapturePath.captureIndexes(IndexCapturePath)"})
  void testCaptureIndexes_givenParseFoo_whenParseFoo_thenReturnEmpty() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("foo");

    // Act and Assert
    assertTrue(parseResult.captureIndexes(IndexCapturePath.parse("foo")).isEmpty());
  }

  /**
   * Test {@link IndexCapturePath#equals(Object)}, and {@link IndexCapturePath#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IndexCapturePath#equals(Object)}
   *   <li>{@link IndexCapturePath#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexCapturePath.equals(Object)", "int IndexCapturePath.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("foo");
    IndexCapturePath parseResult2 = IndexCapturePath.parse("foo");

    // Act and Assert
    assertEquals(parseResult, parseResult2);
    assertEquals(parseResult.hashCode(), parseResult2.hashCode());
  }

  /**
   * Test {@link IndexCapturePath#equals(Object)}, and {@link IndexCapturePath#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IndexCapturePath#equals(Object)}
   *   <li>{@link IndexCapturePath#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexCapturePath.equals(Object)", "int IndexCapturePath.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("foo");

    // Act and Assert
    assertEquals(parseResult, parseResult);
    int expectedHashCodeResult = parseResult.hashCode();
    assertEquals(expectedHashCodeResult, parseResult.hashCode());
  }

  /**
   * Test {@link IndexCapturePath#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePath#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexCapturePath.equals(Object)", "int IndexCapturePath.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IndexCapturePath.parse("foo"), 1);
  }

  /**
   * Test {@link IndexCapturePath#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePath#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexCapturePath.equals(Object)", "int IndexCapturePath.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    IndexCapturePath parseResult =
        IndexCapturePath.parse("com.regnosys.rosetta.common.translation.flat.IndexCapturePath");

    // Act and Assert
    assertNotEquals(parseResult, IndexCapturePath.parse("foo"));
  }

  /**
   * Test {@link IndexCapturePath#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePath#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexCapturePath.equals(Object)", "int IndexCapturePath.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IndexCapturePath.parse("foo"), null);
  }

  /**
   * Test {@link IndexCapturePath#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePath#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexCapturePath.equals(Object)", "int IndexCapturePath.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(IndexCapturePath.parse("foo"), "Different type to IndexCapturePath");
  }

  /**
   * Test {@link IndexCapturePath#matches(IndexCapturePath)}.
   *
   * <ul>
   *   <li>Given parse {@code 42}.
   *   <li>When parse {@code foo}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePath#matches(IndexCapturePath)}
   */
  @Test
  @DisplayName(
      "Test matches(IndexCapturePath); given parse '42'; when parse 'foo'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexCapturePath.matches(IndexCapturePath)"})
  void testMatches_givenParse42_whenParseFoo_thenReturnFalse() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("42");

    // Act and Assert
    assertFalse(parseResult.matches(IndexCapturePath.parse("foo")));
  }

  /**
   * Test {@link IndexCapturePath#matches(IndexCapturePath)}.
   *
   * <ul>
   *   <li>Given parse {@code IndexCapturePath}.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePath#matches(IndexCapturePath)}
   */
  @Test
  @DisplayName(
      "Test matches(IndexCapturePath); given parse 'com.regnosys.rosetta.common.translation.flat.IndexCapturePath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexCapturePath.matches(IndexCapturePath)"})
  void testMatches_givenParseComRegnosysRosettaCommonTranslationFlatIndexCapturePath() {
    // Arrange
    IndexCapturePath parseResult =
        IndexCapturePath.parse("com.regnosys.rosetta.common.translation.flat.IndexCapturePath");

    // Act and Assert
    assertFalse(parseResult.matches(IndexCapturePath.parse("foo")));
  }

  /**
   * Test {@link IndexCapturePath#matches(IndexCapturePath)}.
   *
   * <ul>
   *   <li>Given parse {@code foo}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePath#matches(IndexCapturePath)}
   */
  @Test
  @DisplayName(
      "Test matches(IndexCapturePath); given parse 'foo'; when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexCapturePath.matches(IndexCapturePath)"})
  void testMatches_givenParseFoo_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePath.parse("foo").matches(null));
  }

  /**
   * Test {@link IndexCapturePath#matches(IndexCapturePath)}.
   *
   * <ul>
   *   <li>Given parse {@code foo}.
   *   <li>When parse {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePath#matches(IndexCapturePath)}
   */
  @Test
  @DisplayName(
      "Test matches(IndexCapturePath); given parse 'foo'; when parse 'foo'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IndexCapturePath.matches(IndexCapturePath)"})
  void testMatches_givenParseFoo_whenParseFoo_thenReturnTrue() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("foo");

    // Act and Assert
    assertTrue(parseResult.matches(IndexCapturePath.parse("foo")));
  }

  /**
   * Test {@link IndexCapturePath#compareTo(IndexCapturePath)} with {@code IndexCapturePath}.
   *
   * <ul>
   *   <li>Given parse {@code foo}.
   *   <li>When parse {@code foo}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePath#compareTo(IndexCapturePath)}
   */
  @Test
  @DisplayName(
      "Test compareTo(IndexCapturePath) with 'IndexCapturePath'; given parse 'foo'; when parse 'foo'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IndexCapturePath.compareTo(IndexCapturePath)"})
  void testCompareToWithIndexCapturePath_givenParseFoo_whenParseFoo_thenReturnZero() {
    // Arrange
    IndexCapturePath parseResult = IndexCapturePath.parse("foo");

    // Act and Assert
    assertEquals(0, parseResult.compareTo(IndexCapturePath.parse("foo")));
  }

  /**
   * Test {@link IndexCapturePath#compareTo(IndexCapturePath)} with {@code IndexCapturePath}.
   *
   * <ul>
   *   <li>Then return minus three.
   * </ul>
   *
   * <p>Method under test: {@link IndexCapturePath#compareTo(IndexCapturePath)}
   */
  @Test
  @DisplayName("Test compareTo(IndexCapturePath) with 'IndexCapturePath'; then return minus three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IndexCapturePath.compareTo(IndexCapturePath)"})
  void testCompareToWithIndexCapturePath_thenReturnMinusThree() {
    // Arrange
    IndexCapturePath parseResult =
        IndexCapturePath.parse("com.regnosys.rosetta.common.translation.flat.IndexCapturePath");

    // Act and Assert
    assertEquals(-3, parseResult.compareTo(IndexCapturePath.parse("foo")));
  }

  /**
   * Test {@link IndexCapturePath#toString()}.
   *
   * <p>Method under test: {@link IndexCapturePath#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String IndexCapturePath.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("IndexCapturePath [foo]", IndexCapturePath.parse("foo").toString());
  }

  /**
   * Test {@link IndexCapturePath#getLastIndex()}.
   *
   * <p>Method under test: {@link IndexCapturePath#getLastIndex()}
   */
  @Test
  @DisplayName("Test getLastIndex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional IndexCapturePath.getLastIndex()"})
  void testGetLastIndex() {
    // Arrange, Act and Assert
    assertFalse(IndexCapturePath.parse("foo").getLastIndex().isPresent());
  }
}
