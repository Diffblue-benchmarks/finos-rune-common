package com.regnosys.rosetta.common.serialisation.mixin.legacy;

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

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.regnosys.rosetta.common.serialisation.xml.VirtualXMLAttribute;
import org.junit.Test;

public class LegacyRosettaBuilderIntrospectorDiffblueTest {
  /**
   * Method under test:
   * {@link LegacyRosettaBuilderIntrospector#findNameForDeserialization(Annotated)}
   */
  @Test
  public void testFindNameForDeserialization() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector = new LegacyRosettaBuilderIntrospector();
    Class<Object> declaringClass = Object.class;

    // Act and Assert
    assertFalse(legacyRosettaBuilderIntrospector
        .findNameForDeserialization(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)))
        .isPresent());
  }

  /**
   * Method under test:
   * {@link LegacyRosettaBuilderIntrospector#findNameForDeserialization(Annotated)}
   */
  @Test
  public void testFindNameForDeserialization2() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector = new LegacyRosettaBuilderIntrospector();
    TypeResolutionContext typeContext = mock(TypeResolutionContext.class);
    Class<Object> declaringClass = Object.class;

    // Act and Assert
    assertFalse(
        legacyRosettaBuilderIntrospector
            .findNameForDeserialization(
                new VirtualAnnotatedMember(typeContext, declaringClass, "Name", new PlaceholderForType(1)))
            .isPresent());
  }

  /**
   * Method under test:
   * {@link LegacyRosettaBuilderIntrospector#findPropertyIgnorals(Annotated)}
   */
  @Test
  public void testFindPropertyIgnorals() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector = new LegacyRosettaBuilderIntrospector();
    Class<Object> declaringClass = Object.class;

    // Act and Assert
    assertFalse(legacyRosettaBuilderIntrospector
        .findPropertyIgnorals(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)))
        .isPresent());
  }

  /**
   * Method under test:
   * {@link LegacyRosettaBuilderIntrospector#findPropertyIgnorals(Annotated)}
   */
  @Test
  public void testFindPropertyIgnorals2() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector = new LegacyRosettaBuilderIntrospector();
    TypeResolutionContext typeContext = mock(TypeResolutionContext.class);
    Class<Object> declaringClass = Object.class;

    // Act and Assert
    assertFalse(
        legacyRosettaBuilderIntrospector
            .findPropertyIgnorals(
                new VirtualAnnotatedMember(typeContext, declaringClass, "Name", new PlaceholderForType(1)))
            .isPresent());
  }
}
