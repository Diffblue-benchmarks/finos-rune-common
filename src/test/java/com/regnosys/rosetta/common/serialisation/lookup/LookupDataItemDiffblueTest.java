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
import org.junit.Test;

public class LookupDataItemDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LookupDataItem#equals(Object)}
   *   <li>{@link LookupDataItem#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LookupDataItem lookupDataItem = new LookupDataItem();
    LookupDataItem lookupDataItem2 = new LookupDataItem();

    // Act and Assert
    assertEquals(lookupDataItem, lookupDataItem2);
    int expectedHashCodeResult = lookupDataItem.hashCode();
    assertEquals(expectedHashCodeResult, lookupDataItem2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LookupDataItem#equals(Object)}
   *   <li>{@link LookupDataItem#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LookupDataItem lookupDataItem = new LookupDataItem();

    // Act and Assert
    assertEquals(lookupDataItem, lookupDataItem);
    int expectedHashCodeResult = lookupDataItem.hashCode();
    assertEquals(expectedHashCodeResult, lookupDataItem.hashCode());
  }

  /**
   * Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LookupDataItem lookupDataItem = new LookupDataItem("Key", "Value");

    // Act and Assert
    assertNotEquals(lookupDataItem, new LookupDataItem());
  }

  /**
   * Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LookupDataItem lookupDataItem = new LookupDataItem(new LookupDataItem(), "Value");

    // Act and Assert
    assertNotEquals(lookupDataItem, new LookupDataItem());
  }

  /**
   * Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LookupDataItem lookupDataItem = new LookupDataItem(null, "Value");

    // Act and Assert
    assertNotEquals(lookupDataItem, new LookupDataItem());
  }

  /**
   * Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LookupDataItem lookupDataItem = new LookupDataItem(null, new LookupDataItem());

    // Act and Assert
    assertNotEquals(lookupDataItem, new LookupDataItem());
  }

  /**
   * Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookupDataItem(), null);
  }

  /**
   * Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookupDataItem(), "Different type to LookupDataItem");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LookupDataItem#LookupDataItem()}
   *   <li>{@link LookupDataItem#toString()}
   *   <li>{@link LookupDataItem#getKey()}
   *   <li>{@link LookupDataItem#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link LookupDataItem#LookupDataItem(Object, Object)}
   *   <li>{@link LookupDataItem#toString()}
   *   <li>{@link LookupDataItem#getKey()}
   *   <li>{@link LookupDataItem#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    LookupDataItem actualLookupDataItem = new LookupDataItem("Key", "Value");
    String actualToStringResult = actualLookupDataItem.toString();
    Object actualKey = actualLookupDataItem.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("LookupDataItem[key=Key, value=Value]", actualToStringResult);
    assertEquals("Value", actualLookupDataItem.getValue());
  }
}
