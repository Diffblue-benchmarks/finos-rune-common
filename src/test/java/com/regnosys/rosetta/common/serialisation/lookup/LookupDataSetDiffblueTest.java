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
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LookupDataSetDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LookupDataSet#LookupDataSet()}
   *   <li>{@link LookupDataSet#toString()}
   *   <li>{@link LookupDataSet#getData()}
   *   <li>{@link LookupDataSet#getKeyType()}
   *   <li>{@link LookupDataSet#getName()}
   *   <li>{@link LookupDataSet#getValueType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LookupDataSet.<init>()",
    "void LookupDataSet.<init>(String, String, String, List)",
    "List LookupDataSet.getData()",
    "String LookupDataSet.getKeyType()",
    "String LookupDataSet.getName()",
    "String LookupDataSet.getValueType()",
    "String LookupDataSet.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    LookupDataSet actualLookupDataSet = new LookupDataSet();
    String actualToStringResult = actualLookupDataSet.toString();
    List<LookupDataItem> actualData = actualLookupDataSet.getData();
    String actualKeyType = actualLookupDataSet.getKeyType();
    String actualName = actualLookupDataSet.getName();

    // Assert
    assertEquals(
        "LookupDataSet[name='null', keyType='null', valueType='null', data=null]",
        actualToStringResult);
    assertNull(actualKeyType);
    assertNull(actualName);
    assertNull(actualLookupDataSet.getValueType());
    assertNull(actualData);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return ValueType is {@code 42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LookupDataSet#LookupDataSet(String, String, String, List)}
   *   <li>{@link LookupDataSet#toString()}
   *   <li>{@link LookupDataSet#getData()}
   *   <li>{@link LookupDataSet#getKeyType()}
   *   <li>{@link LookupDataSet#getName()}
   *   <li>{@link LookupDataSet#getValueType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Name'; then return ValueType is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LookupDataSet.<init>()",
    "void LookupDataSet.<init>(String, String, String, List)",
    "List LookupDataSet.getData()",
    "String LookupDataSet.getKeyType()",
    "String LookupDataSet.getName()",
    "String LookupDataSet.getValueType()",
    "String LookupDataSet.toString()"
  })
  void testGettersAndSetters_whenName_thenReturnValueTypeIs42() {
    // Arrange
    ArrayList<LookupDataItem> data = new ArrayList<>();

    // Act
    LookupDataSet actualLookupDataSet = new LookupDataSet("Name", "Key Type", "42", data);
    String actualToStringResult = actualLookupDataSet.toString();
    List<LookupDataItem> actualData = actualLookupDataSet.getData();
    String actualKeyType = actualLookupDataSet.getKeyType();
    String actualName = actualLookupDataSet.getName();

    // Assert
    assertEquals("42", actualLookupDataSet.getValueType());
    assertEquals("Key Type", actualKeyType);
    assertEquals(
        "LookupDataSet[name='Name', keyType='Key Type', valueType='42', data=[]]",
        actualToStringResult);
    assertEquals("Name", actualName);
    assertTrue(actualData.isEmpty());
    assertSame(data, actualData);
  }

  /**
   * Test {@link LookupDataSet#equals(Object)}, and {@link LookupDataSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LookupDataSet#equals(Object)}
   *   <li>{@link LookupDataSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LookupDataSet.equals(Object)", "int LookupDataSet.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LookupDataSet lookupDataSet = new LookupDataSet();
    LookupDataSet lookupDataSet2 = new LookupDataSet();

    // Act and Assert
    assertEquals(lookupDataSet, lookupDataSet2);
    assertEquals(lookupDataSet.hashCode(), lookupDataSet2.hashCode());
  }

  /**
   * Test {@link LookupDataSet#equals(Object)}, and {@link LookupDataSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LookupDataSet#equals(Object)}
   *   <li>{@link LookupDataSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LookupDataSet.equals(Object)", "int LookupDataSet.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LookupDataSet lookupDataSet = new LookupDataSet();

    // Act and Assert
    assertEquals(lookupDataSet, lookupDataSet);
    int expectedHashCodeResult = lookupDataSet.hashCode();
    assertEquals(expectedHashCodeResult, lookupDataSet.hashCode());
  }

  /**
   * Test {@link LookupDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LookupDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LookupDataSet.equals(Object)", "int LookupDataSet.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LookupDataSet lookupDataSet = new LookupDataSet("Name", "Key Type", "42", new ArrayList<>());

    // Act and Assert
    assertNotEquals(lookupDataSet, new LookupDataSet());
  }

  /**
   * Test {@link LookupDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LookupDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LookupDataSet.equals(Object)", "int LookupDataSet.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LookupDataSet lookupDataSet = new LookupDataSet(null, "Key Type", "42", new ArrayList<>());

    // Act and Assert
    assertNotEquals(lookupDataSet, new LookupDataSet());
  }

  /**
   * Test {@link LookupDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LookupDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LookupDataSet.equals(Object)", "int LookupDataSet.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LookupDataSet lookupDataSet = new LookupDataSet(null, null, "42", new ArrayList<>());

    // Act and Assert
    assertNotEquals(lookupDataSet, new LookupDataSet());
  }

  /**
   * Test {@link LookupDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LookupDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LookupDataSet.equals(Object)", "int LookupDataSet.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LookupDataSet lookupDataSet = new LookupDataSet(null, null, null, new ArrayList<>());

    // Act and Assert
    assertNotEquals(lookupDataSet, new LookupDataSet());
  }

  /**
   * Test {@link LookupDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LookupDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LookupDataSet.equals(Object)", "int LookupDataSet.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookupDataSet(), null);
  }

  /**
   * Test {@link LookupDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LookupDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LookupDataSet.equals(Object)", "int LookupDataSet.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookupDataSet(), "Different type to LookupDataSet");
  }
}
