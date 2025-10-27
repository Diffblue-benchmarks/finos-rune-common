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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class LookupDataSetDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LookupDataSet#equals(Object)}
   *   <li>{@link LookupDataSet#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LookupDataSet lookupDataSet = new LookupDataSet();
    LookupDataSet lookupDataSet2 = new LookupDataSet();

    // Act and Assert
    assertEquals(lookupDataSet, lookupDataSet2);
    int expectedHashCodeResult = lookupDataSet.hashCode();
    assertEquals(expectedHashCodeResult, lookupDataSet2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LookupDataSet#equals(Object)}
   *   <li>{@link LookupDataSet#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LookupDataSet lookupDataSet = new LookupDataSet();

    // Act and Assert
    assertEquals(lookupDataSet, lookupDataSet);
    int expectedHashCodeResult = lookupDataSet.hashCode();
    assertEquals(expectedHashCodeResult, lookupDataSet.hashCode());
  }

  /**
   * Method under test: {@link LookupDataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LookupDataSet lookupDataSet = new LookupDataSet("Name", "Key Type", "42", new ArrayList<>());

    // Act and Assert
    assertNotEquals(lookupDataSet, new LookupDataSet());
  }

  /**
   * Method under test: {@link LookupDataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LookupDataSet lookupDataSet = new LookupDataSet(null, "Key Type", "42", new ArrayList<>());

    // Act and Assert
    assertNotEquals(lookupDataSet, new LookupDataSet());
  }

  /**
   * Method under test: {@link LookupDataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LookupDataSet lookupDataSet = new LookupDataSet(null, null, "42", new ArrayList<>());

    // Act and Assert
    assertNotEquals(lookupDataSet, new LookupDataSet());
  }

  /**
   * Method under test: {@link LookupDataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LookupDataSet lookupDataSet = new LookupDataSet(null, null, null, new ArrayList<>());

    // Act and Assert
    assertNotEquals(lookupDataSet, new LookupDataSet());
  }

  /**
   * Method under test: {@link LookupDataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookupDataSet(), null);
  }

  /**
   * Method under test: {@link LookupDataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookupDataSet(), "Different type to LookupDataSet");
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange and Act
    LookupDataSet actualLookupDataSet = new LookupDataSet();
    String actualToStringResult = actualLookupDataSet.toString();
    List<LookupDataItem> actualData = actualLookupDataSet.getData();
    String actualKeyType = actualLookupDataSet.getKeyType();
    String actualName = actualLookupDataSet.getName();

    // Assert
    assertEquals("LookupDataSet[name='null', keyType='null', valueType='null', data=null]", actualToStringResult);
    assertNull(actualKeyType);
    assertNull(actualName);
    assertNull(actualLookupDataSet.getValueType());
    assertNull(actualData);
  }

  /**
   * Methods under test:
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
  public void testGettersAndSetters2() {
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
    assertEquals("LookupDataSet[name='Name', keyType='Key Type', valueType='42', data=[]]", actualToStringResult);
    assertEquals("Name", actualName);
    assertTrue(actualData.isEmpty());
    assertSame(data, actualData);
  }
}
