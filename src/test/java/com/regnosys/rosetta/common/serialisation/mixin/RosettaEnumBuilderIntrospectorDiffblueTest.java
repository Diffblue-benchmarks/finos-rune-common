package com.regnosys.rosetta.common.serialisation.mixin;

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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.rosetta.model.lib.annotations.RosettaEnum;
import java.lang.Character.UnicodeScript;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RosettaEnumBuilderIntrospectorDiffblueTest {
  /**
   * Test {@link RosettaEnumBuilderIntrospector#isApplicable(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@link RosettaEnum}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaEnumBuilderIntrospector#isApplicable(AnnotatedClass)}
   */
  @Test
  @DisplayName("Test isApplicable(AnnotatedClass); given RosettaEnum; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RosettaEnumBuilderIntrospector.isApplicable(AnnotatedClass)"})
  void testIsApplicable_givenRosettaEnum_thenReturnTrue() {
    // Arrange
    RosettaEnumBuilderIntrospector rosettaEnumBuilderIntrospector =
        new RosettaEnumBuilderIntrospector(true);

    AnnotatedClass enumType = mock(AnnotatedClass.class);
    when(enumType.getAnnotation(RosettaEnum.class)).thenReturn(mock(RosettaEnum.class));

    // Act
    boolean actualIsApplicableResult = rosettaEnumBuilderIntrospector.isApplicable(enumType);

    // Assert
    verify(enumType).getAnnotation(isA(Class.class));
    assertTrue(actualIsApplicableResult);
  }

  /**
   * Test {@link RosettaEnumBuilderIntrospector#isApplicable(AnnotatedClass)}.
   *
   * <ul>
   *   <li>When {@link AnnotatedClass}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaEnumBuilderIntrospector#isApplicable(AnnotatedClass)}
   */
  @Test
  @DisplayName("Test isApplicable(AnnotatedClass); when AnnotatedClass; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RosettaEnumBuilderIntrospector.isApplicable(AnnotatedClass)"})
  void testIsApplicable_whenAnnotatedClass_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new RosettaEnumBuilderIntrospector(true).isApplicable(mock(AnnotatedClass.class)));
  }

  /**
   * Test {@link RosettaEnumBuilderIntrospector#findEnumValues(AnnotatedClass, Enum[], String[])}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link AnnotatedClass#fields()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaEnumBuilderIntrospector#findEnumValues(AnnotatedClass,
   * Object[], String[])}
   */
  @Test
  @DisplayName(
      "Test findEnumValues(AnnotatedClass, Enum[], String[]); given ArrayList(); then calls fields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaEnumBuilderIntrospector.findEnumValues(AnnotatedClass, Enum[], String[])"
  })
  void testFindEnumValues_givenArrayList_thenCallsFields() {
    // Arrange
    RosettaEnumBuilderIntrospector rosettaEnumBuilderIntrospector =
        new RosettaEnumBuilderIntrospector(true);

    AnnotatedClass enumType = mock(AnnotatedClass.class);
    when(enumType.fields()).thenReturn(new ArrayList<>());

    // Act
    rosettaEnumBuilderIntrospector.findEnumValues(
        enumType, new Enum[] {UnicodeScript.of(1)}, new String[] {"Names"});

    // Assert
    verify(enumType).fields();
  }

  /**
   * Test {@link RosettaEnumBuilderIntrospector#findEnumAliases(AnnotatedClass, Enum[],
   * String[][])}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link AnnotatedClass#fields()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaEnumBuilderIntrospector#findEnumAliases(AnnotatedClass,
   * Object[], String[][])}
   */
  @Test
  @DisplayName(
      "Test findEnumAliases(AnnotatedClass, Enum[], String[][]); given ArrayList(); then calls fields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaEnumBuilderIntrospector.findEnumAliases(AnnotatedClass, Enum[], String[][])"
  })
  void testFindEnumAliases_givenArrayList_thenCallsFields() {
    // Arrange
    RosettaEnumBuilderIntrospector rosettaEnumBuilderIntrospector =
        new RosettaEnumBuilderIntrospector(true);

    AnnotatedClass enumType = mock(AnnotatedClass.class);
    when(enumType.fields()).thenReturn(new ArrayList<>());

    // Act
    rosettaEnumBuilderIntrospector.findEnumAliases(
        enumType, new Enum[] {UnicodeScript.of(1)}, new String[][] {new String[] {"Alias List"}});

    // Assert
    verify(enumType).fields();
  }
}
