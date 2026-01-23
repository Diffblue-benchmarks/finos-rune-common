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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import java.lang.Character.UnicodeScript;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EnumAsStringBuilderIntrospectorDiffblueTest {
  /**
   * Test {@link EnumAsStringBuilderIntrospector#findEnumValues(AnnotatedClass, Enum[], String[])}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link AnnotatedClass#fields()}.
   * </ul>
   *
   * <p>Method under test: {@link EnumAsStringBuilderIntrospector#findEnumValues(AnnotatedClass,
   * Object[], String[])}
   */
  @Test
  @DisplayName(
      "Test findEnumValues(AnnotatedClass, Enum[], String[]); given ArrayList(); then calls fields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EnumAsStringBuilderIntrospector.findEnumValues(AnnotatedClass, Enum[], String[])"
  })
  void testFindEnumValues_givenArrayList_thenCallsFields() {
    // Arrange
    EnumAsStringBuilderIntrospector enumAsStringBuilderIntrospector =
        new EnumAsStringBuilderIntrospector();

    AnnotatedClass enumType = mock(AnnotatedClass.class);
    when(enumType.fields()).thenReturn(new ArrayList<>());

    // Act
    enumAsStringBuilderIntrospector.findEnumValues(
        enumType, new Enum[] {UnicodeScript.of(1)}, new String[] {"Names"});

    // Assert
    verify(enumType).fields();
  }
}
