package com.regnosys.rosetta.common.serialisation.xml;

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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.impl.MethodProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SubstitutedMethodPropertyDiffblueTest {
  /**
   * Test {@link SubstitutedMethodProperty#SubstitutedMethodProperty(SubstitutedMethodProperty,
   * Method)}.
   *
   * <ul>
   *   <li>Then readResolve return {@link SubstitutedMethodProperty}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SubstitutedMethodProperty#SubstitutedMethodProperty(SubstitutedMethodProperty, Method)}
   */
  @Test
  @DisplayName(
      "Test new SubstitutedMethodProperty(SubstitutedMethodProperty, Method); then readResolve return SubstitutedMethodProperty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SubstitutedMethodProperty.<init>(SubstitutedMethodProperty, Method)"})
  void testNewSubstitutedMethodProperty_thenReadResolveReturnSubstitutedMethodProperty() {
    // Arrange
    AnnotatedMethod method = mock(AnnotatedMethod.class);
    when(method.getAnnotated()).thenReturn(null);
    SubstitutedMethodProperty src =
        new SubstitutedMethodProperty(mock(MethodProperty.class), null, method);
    PropertyName newName = PropertyName.construct("Simple Name");

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(src, newName);

    // Act
    SubstitutedMethodProperty actualSubstitutedMethodProperty =
        new SubstitutedMethodProperty(src2, (Method) null);

    // Assert
    verify(method).getAnnotated();
    assertTrue(actualSubstitutedMethodProperty.readResolve() instanceof SubstitutedMethodProperty);
    assertEquals("Simple Name", actualSubstitutedMethodProperty.getName());
    assertNull(actualSubstitutedMethodProperty.getType());
    assertNull(actualSubstitutedMethodProperty.getValueDeserializer());
    assertNull(actualSubstitutedMethodProperty.getMetadata());
    assertNull(actualSubstitutedMethodProperty.getWrapperName());
    assertNull(actualSubstitutedMethodProperty.getNullValueProvider());
    assertNull(actualSubstitutedMethodProperty.getObjectIdInfo());
    assertNull(actualSubstitutedMethodProperty.getValueTypeDeserializer());
    assertNull(actualSubstitutedMethodProperty.getInjectableValueId());
    assertNull(actualSubstitutedMethodProperty.getManagedReferenceName());
    assertNull(actualSubstitutedMethodProperty._setter);
    assertEquals(0, actualSubstitutedMethodProperty.getPropertyIndex());
    assertFalse(actualSubstitutedMethodProperty.hasValueDeserializer());
    assertFalse(actualSubstitutedMethodProperty.hasValueTypeDeserializer());
    assertFalse(actualSubstitutedMethodProperty.hasViews());
    assertFalse(actualSubstitutedMethodProperty.isIgnorable());
    assertFalse(actualSubstitutedMethodProperty.isInjectionOnly());
    assertFalse(actualSubstitutedMethodProperty.isVirtual());
    assertFalse(actualSubstitutedMethodProperty._skipNulls);
    assertSame(newName, actualSubstitutedMethodProperty.getFullName());
  }
}
