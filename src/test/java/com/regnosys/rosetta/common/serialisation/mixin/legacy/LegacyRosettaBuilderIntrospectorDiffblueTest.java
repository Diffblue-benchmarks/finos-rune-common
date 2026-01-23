package com.regnosys.rosetta.common.serialisation.mixin.legacy;

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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties.Value;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.regnosys.rosetta.common.serialisation.RosettaSerialiserException;
import com.regnosys.rosetta.common.serialisation.xml.VirtualXMLAttribute;
import com.rosetta.model.lib.RosettaModelObject;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LegacyRosettaBuilderIntrospectorDiffblueTest {
  /**
   * Test {@link LegacyRosettaBuilderIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <p>Method under test: {@link LegacyRosettaBuilderIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName("Test findPOJOBuilder(AnnotatedClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LegacyRosettaBuilderIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector =
        new LegacyRosettaBuilderIntrospector();

    AnnotatedClass ac = mock(AnnotatedClass.class);
    RosettaSerialiserException rosettaSerialiserException =
        new RosettaSerialiserException("An error occurred", new Throwable());
    when(ac.getType()).thenThrow(rosettaSerialiserException);

    // Act and Assert
    assertThrows(
        RosettaSerialiserException.class,
        () -> legacyRosettaBuilderIntrospector.findPOJOBuilder(ac));
    verify(ac).getType();
  }

  /**
   * Test {@link LegacyRosettaBuilderIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <p>Method under test: {@link LegacyRosettaBuilderIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName("Test findPOJOBuilder(AnnotatedClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LegacyRosettaBuilderIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder2() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector =
        new LegacyRosettaBuilderIntrospector();

    ArrayType arrayType = mock(ArrayType.class);
    RosettaSerialiserException rosettaSerialiserException =
        new RosettaSerialiserException("An error occurred", new Throwable());
    org.mockito.Mockito.<Class<?>>when(arrayType.getRawClass())
        .thenThrow(rosettaSerialiserException);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getType()).thenReturn(arrayType);

    // Act and Assert
    assertThrows(
        RosettaSerialiserException.class,
        () -> legacyRosettaBuilderIntrospector.findPOJOBuilder(ac));
    verify(arrayType).getRawClass();
    verify(ac).getType();
  }

  /**
   * Test {@link LegacyRosettaBuilderIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@code RosettaModelObject}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyRosettaBuilderIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findPOJOBuilder(AnnotatedClass); given 'com.rosetta.model.lib.RosettaModelObject'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LegacyRosettaBuilderIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_givenComRosettaModelLibRosettaModelObject() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector =
        new LegacyRosettaBuilderIntrospector();

    ArrayType arrayType = mock(ArrayType.class);
    Class<RosettaModelObject> forNameResult = RosettaModelObject.class;
    org.mockito.Mockito.<Class<?>>when(arrayType.getRawClass()).thenReturn(forNameResult);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getType()).thenReturn(arrayType);

    // Act and Assert
    assertThrows(
        RosettaSerialiserException.class,
        () -> legacyRosettaBuilderIntrospector.findPOJOBuilder(ac));
    verify(arrayType).getRawClass();
    verify(ac).getType();
  }

  /**
   * Test {@link LegacyRosettaBuilderIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AnnotatedClass} {@link AnnotatedClass#getType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyRosettaBuilderIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findPOJOBuilder(AnnotatedClass); given 'null'; when AnnotatedClass getType() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LegacyRosettaBuilderIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_givenNull_whenAnnotatedClassGetTypeReturnNull() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector =
        new LegacyRosettaBuilderIntrospector();

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getType()).thenReturn(null);

    // Act
    Optional<Class<?>> actualFindPOJOBuilderResult =
        legacyRosettaBuilderIntrospector.findPOJOBuilder(ac);

    // Assert
    verify(ac).getType();
    assertFalse(actualFindPOJOBuilderResult.isPresent());
  }

  /**
   * Test {@link LegacyRosettaBuilderIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   * </ul>
   *
   * <p>Method under test: {@link LegacyRosettaBuilderIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findPOJOBuilder(AnnotatedClass); given PlaceholderForType(int) with ordinal is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LegacyRosettaBuilderIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_givenPlaceholderForTypeWithOrdinalIsOne() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector =
        new LegacyRosettaBuilderIntrospector();

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getType()).thenReturn(new PlaceholderForType(1));

    // Act
    Optional<Class<?>> actualFindPOJOBuilderResult =
        legacyRosettaBuilderIntrospector.findPOJOBuilder(ac);

    // Assert
    verify(ac).getType();
    assertFalse(actualFindPOJOBuilderResult.isPresent());
  }

  /**
   * Test {@link LegacyRosettaBuilderIntrospector#findNameForDeserialization(Annotated)}.
   *
   * <p>Method under test: {@link
   * LegacyRosettaBuilderIntrospector#findNameForDeserialization(Annotated)}
   */
  @Test
  @DisplayName("Test findNameForDeserialization(Annotated)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional LegacyRosettaBuilderIntrospector.findNameForDeserialization(Annotated)"
  })
  void testFindNameForDeserialization() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector =
        new LegacyRosettaBuilderIntrospector();
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute a =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act and Assert
    assertFalse(legacyRosettaBuilderIntrospector.findNameForDeserialization(a).isPresent());
  }

  /**
   * Test {@link LegacyRosettaBuilderIntrospector#findPropertyIgnorals(Annotated)}.
   *
   * <p>Method under test: {@link LegacyRosettaBuilderIntrospector#findPropertyIgnorals(Annotated)}
   */
  @Test
  @DisplayName("Test findPropertyIgnorals(Annotated)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LegacyRosettaBuilderIntrospector.findPropertyIgnorals(Annotated)"})
  void testFindPropertyIgnorals() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector =
        new LegacyRosettaBuilderIntrospector();

    AnnotatedClass ac = mock(AnnotatedClass.class);
    RosettaSerialiserException rosettaSerialiserException =
        new RosettaSerialiserException("An error occurred", new Throwable());
    org.mockito.Mockito.<Class<?>>when(ac.getRawType()).thenThrow(rosettaSerialiserException);

    // Act and Assert
    assertThrows(
        RosettaSerialiserException.class,
        () -> legacyRosettaBuilderIntrospector.findPropertyIgnorals(ac));
    verify(ac).getRawType();
  }

  /**
   * Test {@link LegacyRosettaBuilderIntrospector#findPropertyIgnorals(Annotated)}.
   *
   * <p>Method under test: {@link LegacyRosettaBuilderIntrospector#findPropertyIgnorals(Annotated)}
   */
  @Test
  @DisplayName("Test findPropertyIgnorals(Annotated)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LegacyRosettaBuilderIntrospector.findPropertyIgnorals(Annotated)"})
  void testFindPropertyIgnorals2() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector =
        new LegacyRosettaBuilderIntrospector();

    AnnotatedClass ac = mock(AnnotatedClass.class);
    RosettaSerialiserException rosettaSerialiserException =
        new RosettaSerialiserException("An error occurred", new Throwable());
    when(ac.memberMethods()).thenThrow(rosettaSerialiserException);
    Class<RosettaModelObject> forNameResult = RosettaModelObject.class;
    org.mockito.Mockito.<Class<?>>when(ac.getRawType()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(
        RosettaSerialiserException.class,
        () -> legacyRosettaBuilderIntrospector.findPropertyIgnorals(ac));
    verify(ac).getRawType();
    verify(ac).memberMethods();
  }

  /**
   * Test {@link LegacyRosettaBuilderIntrospector#findPropertyIgnorals(Annotated)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return not {@link Optional#get()} AllowGetters.
   * </ul>
   *
   * <p>Method under test: {@link LegacyRosettaBuilderIntrospector#findPropertyIgnorals(Annotated)}
   */
  @Test
  @DisplayName(
      "Test findPropertyIgnorals(Annotated); given ArrayList(); then return not get() AllowGetters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LegacyRosettaBuilderIntrospector.findPropertyIgnorals(Annotated)"})
  void testFindPropertyIgnorals_givenArrayList_thenReturnNotGetAllowGetters() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector =
        new LegacyRosettaBuilderIntrospector();

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.memberMethods()).thenReturn(new ArrayList<>());
    Class<RosettaModelObject> forNameResult = RosettaModelObject.class;
    org.mockito.Mockito.<Class<?>>when(ac.getRawType()).thenReturn(forNameResult);

    // Act
    Optional<Value> actualFindPropertyIgnoralsResult =
        legacyRosettaBuilderIntrospector.findPropertyIgnorals(ac);

    // Assert
    verify(ac).getRawType();
    verify(ac).memberMethods();
    Value getResult = actualFindPropertyIgnoralsResult.get();
    assertFalse(getResult.getAllowGetters());
    assertFalse(getResult.getIgnoreUnknown());
    assertTrue(getResult.getAllowSetters());
    assertTrue(getResult.getMerge());
    assertTrue(actualFindPropertyIgnoralsResult.isPresent());
    assertTrue(getResult.getIgnored().isEmpty());
  }

  /**
   * Test {@link LegacyRosettaBuilderIntrospector#findPropertyIgnorals(Annotated)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyRosettaBuilderIntrospector#findPropertyIgnorals(Annotated)}
   */
  @Test
  @DisplayName("Test findPropertyIgnorals(Annotated); given 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LegacyRosettaBuilderIntrospector.findPropertyIgnorals(Annotated)"})
  void testFindPropertyIgnorals_givenJavaLangObject() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector =
        new LegacyRosettaBuilderIntrospector();

    AnnotatedClass ac = mock(AnnotatedClass.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<?>>when(ac.getRawType()).thenReturn(forNameResult);

    // Act
    Optional<Value> actualFindPropertyIgnoralsResult =
        legacyRosettaBuilderIntrospector.findPropertyIgnorals(ac);

    // Assert
    verify(ac).getRawType();
    Value getResult = actualFindPropertyIgnoralsResult.get();
    assertFalse(getResult.getAllowGetters());
    assertFalse(getResult.getIgnoreUnknown());
    assertTrue(getResult.getAllowSetters());
    assertTrue(getResult.getMerge());
    assertTrue(actualFindPropertyIgnoralsResult.isPresent());
    assertTrue(getResult.getIgnored().isEmpty());
  }

  /**
   * Test {@link LegacyRosettaBuilderIntrospector#findPropertyIgnorals(Annotated)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link LegacyRosettaBuilderIntrospector#findPropertyIgnorals(Annotated)}
   */
  @Test
  @DisplayName(
      "Test findPropertyIgnorals(Annotated); when 'java.lang.Object'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional LegacyRosettaBuilderIntrospector.findPropertyIgnorals(Annotated)"})
  void testFindPropertyIgnorals_whenJavaLangObject_thenReturnNotPresent() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector =
        new LegacyRosettaBuilderIntrospector();
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute ac =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act and Assert
    assertFalse(legacyRosettaBuilderIntrospector.findPropertyIgnorals(ac).isPresent());
  }
}
