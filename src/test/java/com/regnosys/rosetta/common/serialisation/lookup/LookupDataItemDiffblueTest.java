package com.regnosys.rosetta.common.serialisation.lookup;

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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

class LookupDataItemDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code LookupDataItem[key=null, value=null]}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LookupDataItem#LookupDataItem()}
   *   <li>{@link LookupDataItem#toString()}
   *   <li>{@link LookupDataItem#getKey()}
   *   <li>{@link LookupDataItem#getValue()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; then return toString is 'LookupDataItem[key=null, value=null]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LookupDataItem.<init>()",
    "void LookupDataItem.<init>(Object, Object)",
    "Object LookupDataItem.getKey()",
    "Object LookupDataItem.getValue()",
    "String LookupDataItem.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsLookupDataItemKeyNullValueNull() {
    // Arrange and Act
    LookupDataItem actualLookupDataItem = new LookupDataItem();
    String actualToStringResult = actualLookupDataItem.toString();
    Object actualKey = actualLookupDataItem.getKey();

    // Assert
    assertEquals("LookupDataItem[key=null, value=null]", actualToStringResult);
    assertNull(actualKey);
    assertNull(actualLookupDataItem.getValue());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>Then Key return {@link JsonInclude.Include}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LookupDataItem#LookupDataItem(Object, Object)}
   *   <li>{@link LookupDataItem#toString()}
   *   <li>{@link LookupDataItem#getKey()}
   *   <li>{@link LookupDataItem#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when MARKER_FOR_EMPTY; then Key return Include")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LookupDataItem.<init>()",
    "void LookupDataItem.<init>(Object, Object)",
    "Object LookupDataItem.getKey()",
    "Object LookupDataItem.getValue()",
    "String LookupDataItem.toString()"
  })
  void testGettersAndSetters_whenMarker_for_empty_thenKeyReturnInclude() {
    // Arrange
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;

    // Act
    LookupDataItem actualLookupDataItem =
        new LookupDataItem(BeanPropertyWriter.MARKER_FOR_EMPTY, object);
    String actualToStringResult = actualLookupDataItem.toString();
    Object actualKey = actualLookupDataItem.getKey();

    // Assert
    assertTrue(actualKey instanceof Include);
    assertEquals("LookupDataItem[key=NON_EMPTY, value=NON_EMPTY]", actualToStringResult);
    assertEquals(Include.NON_EMPTY, actualKey);
    assertSame(object, actualKey);
    assertSame(object, actualLookupDataItem.getValue());
  }

  /**
   * Test {@link LookupDataItem#equals(Object)}, and {@link LookupDataItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LookupDataItem#equals(Object)}
   *   <li>{@link LookupDataItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LookupDataItem.equals(Object)", "int LookupDataItem.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LookupDataItem lookupDataItem = new LookupDataItem();
    LookupDataItem lookupDataItem2 = new LookupDataItem();

    // Act and Assert
    assertEquals(lookupDataItem, lookupDataItem2);
    assertEquals(lookupDataItem.hashCode(), lookupDataItem2.hashCode());
  }

  /**
   * Test {@link LookupDataItem#equals(Object)}, and {@link LookupDataItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LookupDataItem#equals(Object)}
   *   <li>{@link LookupDataItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LookupDataItem.equals(Object)", "int LookupDataItem.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LookupDataItem lookupDataItem = new LookupDataItem();

    // Act and Assert
    assertEquals(lookupDataItem, lookupDataItem);
    int expectedHashCodeResult = lookupDataItem.hashCode();
    assertEquals(expectedHashCodeResult, lookupDataItem.hashCode());
  }

  /**
   * Test {@link LookupDataItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LookupDataItem.equals(Object)", "int LookupDataItem.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LookupDataItem lookupDataItem =
        new LookupDataItem(
            BeanPropertyWriter.MARKER_FOR_EMPTY, BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act and Assert
    assertNotEquals(lookupDataItem, new LookupDataItem());
  }

  /**
   * Test {@link LookupDataItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LookupDataItem.equals(Object)", "int LookupDataItem.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LookupDataItem lookupDataItem =
        new LookupDataItem(new LookupDataItem(), BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act and Assert
    assertNotEquals(lookupDataItem, new LookupDataItem());
  }

  /**
   * Test {@link LookupDataItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LookupDataItem.equals(Object)", "int LookupDataItem.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LookupDataItem lookupDataItem = new LookupDataItem(null, BeanPropertyWriter.MARKER_FOR_EMPTY);

    // Act and Assert
    assertNotEquals(lookupDataItem, new LookupDataItem());
  }

  /**
   * Test {@link LookupDataItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LookupDataItem.equals(Object)", "int LookupDataItem.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LookupDataItem lookupDataItem = new LookupDataItem(null, new LookupDataItem());

    // Act and Assert
    assertNotEquals(lookupDataItem, new LookupDataItem());
  }

  /**
   * Test {@link LookupDataItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LookupDataItem.equals(Object)", "int LookupDataItem.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookupDataItem(), null);
  }

  /**
   * Test {@link LookupDataItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LookupDataItem.equals(Object)", "int LookupDataItem.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookupDataItem(), "Different type to LookupDataItem");
  }
}
