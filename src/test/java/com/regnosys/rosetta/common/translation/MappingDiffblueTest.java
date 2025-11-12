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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.regnosys.rosetta.common.hashing.ScopeReferenceHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MappingDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Mapping#Mapping(Path, Object, Path, Object, String, boolean, boolean, boolean)}
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Mapping.<init>(Path, Object, Path, Object, String, boolean, boolean, boolean)",
    "String Mapping.getError()",
    "Path Mapping.getRosettaPath()",
    "Object Mapping.getRosettaValue()",
    "Path Mapping.getXmlPath()",
    "Object Mapping.getXmlValue()",
    "boolean Mapping.isAllowsMultiple()",
    "boolean Mapping.isCondition()",
    "boolean Mapping.isDuplicate()",
    "void Mapping.setCondition(boolean)",
    "void Mapping.setDuplicate(boolean)",
    "void Mapping.setError(String)",
    "void Mapping.setRosettaPath(Path)",
    "void Mapping.setRosettaValue(Object)",
    "String Mapping.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Mapping actualMapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    actualMapping.setCondition(true);
    actualMapping.setDuplicate(true);
    actualMapping.setError("An error occurred");
    Path rosettaPath = ScopeReferenceHelper.EMPTY_SCOPE;
    actualMapping.setRosettaPath(rosettaPath);
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;
    actualMapping.setRosettaValue(object);
    String actualToStringResult = actualMapping.toString();
    String actualError = actualMapping.getError();
    Path actualRosettaPath = actualMapping.getRosettaPath();
    Object actualRosettaValue = actualMapping.getRosettaValue();
    Path actualXmlPath = actualMapping.getXmlPath();
    Object actualXmlValue = actualMapping.getXmlValue();
    boolean actualIsAllowsMultipleResult = actualMapping.isAllowsMultiple();
    boolean actualIsConditionResult = actualMapping.isCondition();

    // Assert
    assertTrue(actualRosettaValue instanceof Include);
    assertEquals("An error occurred", actualError);
    assertEquals(
        "Mapping{xmlPath=emptyScope, xmlValue=NON_EMPTY, rosettaPath=emptyScope, rosettaValue=NON_EMPTY, error='An"
            + " error occurred', allowsMultiple=true, condition=true, duplicate=true}",
        actualToStringResult);
    assertEquals(Include.NON_EMPTY, actualRosettaValue);
    assertTrue(actualIsAllowsMultipleResult);
    assertTrue(actualIsConditionResult);
    assertTrue(actualMapping.isDuplicate());
    assertSame(object, actualRosettaValue);
    assertSame(object, actualXmlValue);
    assertSame(rosettaPath, actualRosettaPath);
    assertSame(rosettaPath, actualXmlPath);
  }

  /**
   * Test {@link Mapping#equals(Object)}, and {@link Mapping#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Mapping#equals(Object)}
   *   <li>{@link Mapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    // Act and Assert
    assertEquals(mapping, mapping2);
    assertEquals(mapping.hashCode(), mapping2.hashCode());
  }

  /**
   * Test {@link Mapping#equals(Object)}, and {@link Mapping#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Mapping#equals(Object)}
   *   <li>{@link Mapping#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    // Act and Assert
    assertEquals(mapping, mapping);
    int expectedHashCodeResult = mapping.hashCode();
    assertEquals(expectedHashCodeResult, mapping.hashCode());
  }

  /**
   * Test {@link Mapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Mapping mapping =
        new Mapping(
            new Path(),
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    // Act and Assert
    assertNotEquals(
        mapping,
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true));
  }

  /**
   * Test {@link Mapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            42,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    // Act and Assert
    assertNotEquals(
        mapping,
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true));
  }

  /**
   * Test {@link Mapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            mapping,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    // Act and Assert
    assertNotEquals(
        mapping2,
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true));
  }

  /**
   * Test {@link Mapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            new Path(),
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    // Act and Assert
    assertNotEquals(
        mapping,
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true));
  }

  /**
   * Test {@link Mapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            42,
            "An error occurred",
            true,
            true,
            true);

    // Act and Assert
    assertNotEquals(
        mapping,
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true));
  }

  /**
   * Test {@link Mapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            mapping,
            "An error occurred",
            true,
            true,
            true);

    // Act and Assert
    assertNotEquals(
        mapping2,
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true));
  }

  /**
   * Test {@link Mapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "Error",
            true,
            true,
            true);

    // Act and Assert
    assertNotEquals(
        mapping,
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true));
  }

  /**
   * Test {@link Mapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            false,
            true,
            true);

    // Act and Assert
    assertNotEquals(
        mapping,
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true));
  }

  /**
   * Test {@link Mapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            false,
            true);

    // Act and Assert
    assertNotEquals(
        mapping,
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true));
  }

  /**
   * Test {@link Mapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            false);

    // Act and Assert
    assertNotEquals(
        mapping,
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true));
  }

  /**
   * Test {@link Mapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true),
        null);
  }

  /**
   * Test {@link Mapping#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Mapping#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Mapping.equals(Object)", "int Mapping.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true),
        "Different type to Mapping");
  }
}
