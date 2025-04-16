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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LookupDataItemDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return toString is {@code LookupDataItem[key=null, value=null]}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LookupDataItem#LookupDataItem()}
   *   <li>{@link LookupDataItem#toString()}
   *   <li>{@link LookupDataItem#getKey()}
   *   <li>{@link LookupDataItem#getValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LookupDataItem.<init>()", "void LookupDataItem.<init>(Object, Object)",
      "Object LookupDataItem.getKey()", "Object LookupDataItem.getValue()", "String LookupDataItem.toString()"})
  public void testGettersAndSetters_thenReturnToStringIsLookupDataItemKeyNullValueNull() {
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
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code Key}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LookupDataItem#LookupDataItem(Object, Object)}
   *   <li>{@link LookupDataItem#toString()}
   *   <li>{@link LookupDataItem#getKey()}
   *   <li>{@link LookupDataItem#getValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LookupDataItem.<init>()", "void LookupDataItem.<init>(Object, Object)",
      "Object LookupDataItem.getKey()", "Object LookupDataItem.getValue()", "String LookupDataItem.toString()"})
  public void testGettersAndSetters_whenKey_thenReturnKey() {
    // Arrange and Act
    LookupDataItem actualLookupDataItem = new LookupDataItem("Key", "Value");
    String actualToStringResult = actualLookupDataItem.toString();
    Object actualKey = actualLookupDataItem.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("LookupDataItem[key=Key, value=Value]", actualToStringResult);
    assertEquals("Value", actualLookupDataItem.getValue());
  }

  /**
   * Test {@link LookupDataItem#equals(Object)}, and {@link LookupDataItem#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LookupDataItem#equals(Object)}
   *   <li>{@link LookupDataItem#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LookupDataItem.equals(Object)", "int LookupDataItem.hashCode()"})
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
   * Test {@link LookupDataItem#equals(Object)}, and {@link LookupDataItem#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LookupDataItem#equals(Object)}
   *   <li>{@link LookupDataItem#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LookupDataItem.equals(Object)", "int LookupDataItem.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LookupDataItem lookupDataItem = new LookupDataItem();

    // Act and Assert
    assertEquals(lookupDataItem, lookupDataItem);
    int expectedHashCodeResult = lookupDataItem.hashCode();
    assertEquals(expectedHashCodeResult, lookupDataItem.hashCode());
  }

  /**
   * Test {@link LookupDataItem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LookupDataItem.equals(Object)", "int LookupDataItem.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LookupDataItem lookupDataItem = new LookupDataItem("Key", "Value");

    // Act and Assert
    assertNotEquals(lookupDataItem, new LookupDataItem());
  }

  /**
   * Test {@link LookupDataItem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LookupDataItem.equals(Object)", "int LookupDataItem.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LookupDataItem lookupDataItem = new LookupDataItem(new LookupDataItem(), "Value");

    // Act and Assert
    assertNotEquals(lookupDataItem, new LookupDataItem());
  }

  /**
   * Test {@link LookupDataItem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LookupDataItem.equals(Object)", "int LookupDataItem.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LookupDataItem lookupDataItem = new LookupDataItem(null, "Value");

    // Act and Assert
    assertNotEquals(lookupDataItem, new LookupDataItem());
  }

  /**
   * Test {@link LookupDataItem#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LookupDataItem.equals(Object)", "int LookupDataItem.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LookupDataItem lookupDataItem = new LookupDataItem(null, new LookupDataItem());

    // Act and Assert
    assertNotEquals(lookupDataItem, new LookupDataItem());
  }

  /**
   * Test {@link LookupDataItem#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LookupDataItem.equals(Object)", "int LookupDataItem.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookupDataItem(), null);
  }

  /**
   * Test {@link LookupDataItem#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupDataItem#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LookupDataItem.equals(Object)", "int LookupDataItem.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LookupDataItem(), "Different type to LookupDataItem");
  }
}
