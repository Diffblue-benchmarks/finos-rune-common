package com.regnosys.rosetta.common.translation;

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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.regnosys.rosetta.common.hashing.ScopeReferenceHelper;
import org.junit.Test;

public class MappingDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Mapping#equals(Object)}
   *   <li>{@link Mapping#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);
    Mapping mapping2 = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    // Act and Assert
    assertEquals(mapping, mapping2);
    int expectedHashCodeResult = mapping.hashCode();
    assertEquals(expectedHashCodeResult, mapping2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Mapping#equals(Object)}
   *   <li>{@link Mapping#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    // Act and Assert
    assertEquals(mapping, mapping);
    int expectedHashCodeResult = mapping.hashCode();
    assertEquals(expectedHashCodeResult, mapping.hashCode());
  }

  /**
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Mapping mapping = new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true);

    // Act and Assert
    assertNotEquals(mapping, new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
  }

  /**
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Mapping mapping = new Mapping(mock(Path.class), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true);

    // Act and Assert
    assertNotEquals(mapping, new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
  }

  /**
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, 42, ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    // Act and Assert
    assertNotEquals(mapping, new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
  }

  /**
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE,
        new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
            "An error occurred", true, true, true),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true);

    // Act and Assert
    assertNotEquals(mapping, new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
  }

  /**
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", new Path(), "Rosetta Value",
        "An error occurred", true, true, true);

    // Act and Assert
    assertNotEquals(mapping, new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
  }

  /**
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, 42,
        "An error occurred", true, true, true);

    // Act and Assert
    assertNotEquals(mapping, new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
  }

  /**
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
            "An error occurred", true, true, true),
        "An error occurred", true, true, true);

    // Act and Assert
    assertNotEquals(mapping, new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
  }

  /**
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "Error", true, true, true);

    // Act and Assert
    assertNotEquals(mapping, new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
  }

  /**
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", false, true, true);

    // Act and Assert
    assertNotEquals(mapping, new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
  }

  /**
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, false, true);

    // Act and Assert
    assertNotEquals(mapping, new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
  }

  /**
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, false);

    // Act and Assert
    assertNotEquals(mapping, new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
  }

  /**
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true), null);
  }

  /**
   * Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true), "Different type to Mapping");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link Mapping#Mapping(Path, Object, Path, Object, String, boolean, boolean, boolean)}
   *   <li>{@link Mapping#setCondition(boolean)}
   *   <li>{@link Mapping#setDuplicate(boolean)}
   *   <li>{@link Mapping#setError(String)}
   *   <li>{@link Mapping#setRosettaPath(Path)}
   *   <li>{@link Mapping#setRosettaValue(Object)}
   *   <li>{@link Mapping#toString()}
   *   <li>{@link Mapping#getError()}
   *   <li>{@link Mapping#getRosettaPath()}
   *   <li>{@link Mapping#getRosettaValue()}
   *   <li>{@link Mapping#getXmlPath()}
   *   <li>{@link Mapping#getXmlValue()}
   *   <li>{@link Mapping#isAllowsMultiple()}
   *   <li>{@link Mapping#isCondition()}
   *   <li>{@link Mapping#isDuplicate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Mapping actualMapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);
    actualMapping.setCondition(true);
    actualMapping.setDuplicate(true);
    actualMapping.setError("An error occurred");
    Path rosettaPath = ScopeReferenceHelper.EMPTY_SCOPE;
    actualMapping.setRosettaPath(rosettaPath);
    actualMapping.setRosettaValue("Rosetta Value");
    String actualToStringResult = actualMapping.toString();
    String actualError = actualMapping.getError();
    Path actualRosettaPath = actualMapping.getRosettaPath();
    Object actualRosettaValue = actualMapping.getRosettaValue();
    Path actualXmlPath = actualMapping.getXmlPath();
    Object actualXmlValue = actualMapping.getXmlValue();
    boolean actualIsAllowsMultipleResult = actualMapping.isAllowsMultiple();
    boolean actualIsConditionResult = actualMapping.isCondition();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualError);
    assertEquals("Mapping{xmlPath=emptyScope, xmlValue=Xml Value, rosettaPath=emptyScope, rosettaValue=Rosetta Value,"
        + " error='An error occurred', allowsMultiple=true, condition=true, duplicate=true}", actualToStringResult);
    assertEquals("Rosetta Value", actualRosettaValue);
    assertEquals("Xml Value", actualXmlValue);
    assertTrue(actualIsAllowsMultipleResult);
    assertTrue(actualIsConditionResult);
    assertTrue(actualMapping.isDuplicate());
    assertSame(rosettaPath, actualRosettaPath);
    assertSame(rosettaPath, actualXmlPath);
  }
}
