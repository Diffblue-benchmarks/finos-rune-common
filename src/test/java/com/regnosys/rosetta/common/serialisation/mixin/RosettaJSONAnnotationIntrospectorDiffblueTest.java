package com.regnosys.rosetta.common.serialisation.mixin;

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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.regnosys.rosetta.common.serialisation.mixin.legacy.LegacyRosettaBuilderIntrospector;
import com.regnosys.rosetta.common.serialisation.xml.VirtualXMLAttribute;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RosettaJSONAnnotationIntrospectorDiffblueTest {
  /**
   * Test {@link
   * RosettaJSONAnnotationIntrospector#RosettaJSONAnnotationIntrospector(LegacyRosettaBuilderIntrospector,
   * EnumAsStringBuilderIntrospector, RosettaEnumBuilderIntrospector)}.
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#RosettaJSONAnnotationIntrospector(LegacyRosettaBuilderIntrospector,
   * EnumAsStringBuilderIntrospector, RosettaEnumBuilderIntrospector)}
   */
  @Test
  @DisplayName(
      "Test new RosettaJSONAnnotationIntrospector(LegacyRosettaBuilderIntrospector, EnumAsStringBuilderIntrospector, RosettaEnumBuilderIntrospector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaJSONAnnotationIntrospector.<init>(LegacyRosettaBuilderIntrospector, EnumAsStringBuilderIntrospector, RosettaEnumBuilderIntrospector)"
  })
  void testNewRosettaJSONAnnotationIntrospector() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector =
        new LegacyRosettaBuilderIntrospector();
    EnumAsStringBuilderIntrospector enumAsStringBuilderIntrospector =
        new EnumAsStringBuilderIntrospector();

    // Act
    RosettaJSONAnnotationIntrospector actualRosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(
            legacyRosettaBuilderIntrospector,
            enumAsStringBuilderIntrospector,
            new RosettaEnumBuilderIntrospector(true));

    // Assert
    Collection<AnnotationIntrospector> allIntrospectorsResult =
        actualRosettaJSONAnnotationIntrospector.allIntrospectors();
    assertEquals(1, allIntrospectorsResult.size());
    assertTrue(allIntrospectorsResult instanceof List);
    Version versionResult = actualRosettaJSONAnnotationIntrospector.version();
    assertEquals("", versionResult.getArtifactId());
    assertEquals("", versionResult.getGroupId());
    assertEquals("//0.0.0", versionResult.toFullString());
    assertEquals(0, versionResult.getMajorVersion());
    assertEquals(0, versionResult.getMinorVersion());
    assertEquals(0, versionResult.getPatchLevel());
    assertFalse(versionResult.isSnapshot());
    assertTrue(versionResult.isUknownVersion());
    assertTrue(versionResult.isUnknownVersion());
    assertSame(
        actualRosettaJSONAnnotationIntrospector,
        ((List<AnnotationIntrospector>) allIntrospectorsResult).get(0));
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#RosettaJSONAnnotationIntrospector(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#RosettaJSONAnnotationIntrospector(boolean)}
   */
  @Test
  @DisplayName("Test new RosettaJSONAnnotationIntrospector(boolean); when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaJSONAnnotationIntrospector.<init>(boolean)"})
  void testNewRosettaJSONAnnotationIntrospector_whenFalse() {
    // Arrange and Act
    RosettaJSONAnnotationIntrospector actualRosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(false);

    // Assert
    Collection<AnnotationIntrospector> allIntrospectorsResult =
        actualRosettaJSONAnnotationIntrospector.allIntrospectors();
    assertEquals(1, allIntrospectorsResult.size());
    assertTrue(allIntrospectorsResult instanceof List);
    Version versionResult = actualRosettaJSONAnnotationIntrospector.version();
    assertEquals("", versionResult.getArtifactId());
    assertEquals("", versionResult.getGroupId());
    assertEquals("//0.0.0", versionResult.toFullString());
    assertEquals(0, versionResult.getMajorVersion());
    assertEquals(0, versionResult.getMinorVersion());
    assertEquals(0, versionResult.getPatchLevel());
    assertFalse(versionResult.isSnapshot());
    assertTrue(versionResult.isUknownVersion());
    assertTrue(versionResult.isUnknownVersion());
    assertSame(
        actualRosettaJSONAnnotationIntrospector,
        ((List<AnnotationIntrospector>) allIntrospectorsResult).get(0));
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#RosettaJSONAnnotationIntrospector(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#RosettaJSONAnnotationIntrospector(boolean)}
   */
  @Test
  @DisplayName("Test new RosettaJSONAnnotationIntrospector(boolean); when 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaJSONAnnotationIntrospector.<init>(boolean)"})
  void testNewRosettaJSONAnnotationIntrospector_whenTrue() {
    // Arrange and Act
    RosettaJSONAnnotationIntrospector actualRosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    // Assert
    Collection<AnnotationIntrospector> allIntrospectorsResult =
        actualRosettaJSONAnnotationIntrospector.allIntrospectors();
    assertEquals(1, allIntrospectorsResult.size());
    assertTrue(allIntrospectorsResult instanceof List);
    Version versionResult = actualRosettaJSONAnnotationIntrospector.version();
    assertEquals("", versionResult.getArtifactId());
    assertEquals("", versionResult.getGroupId());
    assertEquals("//0.0.0", versionResult.toFullString());
    assertEquals(0, versionResult.getMajorVersion());
    assertEquals(0, versionResult.getMinorVersion());
    assertEquals(0, versionResult.getPatchLevel());
    assertFalse(versionResult.isSnapshot());
    assertTrue(versionResult.isUknownVersion());
    assertTrue(versionResult.isUnknownVersion());
    assertSame(
        actualRosettaJSONAnnotationIntrospector,
        ((List<AnnotationIntrospector>) allIntrospectorsResult).get(0));
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@link ArrayType} {@link ArrayType#getRawClass()} return {@link Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findPOJOBuilder(AnnotatedClass); given ArrayType getRawClass() return Object; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class RosettaJSONAnnotationIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_givenArrayTypeGetRawClassReturnObject_thenReturnNull() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    ArrayType arrayType = mock(ArrayType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(arrayType.getRawClass()).thenReturn(forNameResult);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(ac.getType()).thenReturn(arrayType);

    // Act
    Class<?> actualFindPOJOBuilderResult = rosettaJSONAnnotationIntrospector.findPOJOBuilder(ac);

    // Assert
    verify(arrayType).getRawClass();
    verify(ac).getType();
    verify(ac).hasAnnotation(isA(Class.class));
    assertNull(actualFindPOJOBuilderResult);
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@link JsonDeserialize} {@link JsonDeserialize#builder()} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findPOJOBuilder(AnnotatedClass); given JsonDeserialize builder() return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class RosettaJSONAnnotationIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_givenJsonDeserializeBuilderReturnNull_thenReturnNull() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    ArrayType arrayType = mock(ArrayType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(arrayType.getRawClass()).thenReturn(forNameResult);

    JsonDeserialize jsonDeserialize = mock(JsonDeserialize.class);
    Mockito.<Class<?>>when(jsonDeserialize.builder()).thenReturn(null);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getAnnotation(RosettaDataType.class)).thenReturn(mock(RosettaDataType.class));
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(ac.getType()).thenReturn(arrayType);
    when(ac.getAnnotation(JsonDeserialize.class)).thenReturn(jsonDeserialize);

    // Act
    Class<?> actualFindPOJOBuilderResult = rosettaJSONAnnotationIntrospector.findPOJOBuilder(ac);

    // Assert
    verify(arrayType).getRawClass();
    verify(jsonDeserialize).builder();
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac).getType();
    verify(ac).hasAnnotation(isA(Class.class));
    assertNull(actualFindPOJOBuilderResult);
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@link JsonDeserialize} {@link JsonDeserialize#builder()} return {@link Void#TYPE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findPOJOBuilder(AnnotatedClass); given JsonDeserialize builder() return TYPE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class RosettaJSONAnnotationIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_givenJsonDeserializeBuilderReturnType_thenReturnNull() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    ArrayType arrayType = mock(ArrayType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(arrayType.getRawClass()).thenReturn(forNameResult);

    JsonDeserialize jsonDeserialize = mock(JsonDeserialize.class);
    Mockito.<Class<?>>when(jsonDeserialize.builder()).thenReturn(Void.TYPE);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getAnnotation(RosettaDataType.class)).thenReturn(mock(RosettaDataType.class));
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(ac.getType()).thenReturn(arrayType);
    when(ac.getAnnotation(JsonDeserialize.class)).thenReturn(jsonDeserialize);

    // Act
    Class<?> actualFindPOJOBuilderResult = rosettaJSONAnnotationIntrospector.findPOJOBuilder(ac);

    // Assert
    verify(arrayType).getRawClass();
    verify(jsonDeserialize).builder();
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac).getType();
    verify(ac).hasAnnotation(isA(Class.class));
    assertNull(actualFindPOJOBuilderResult);
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AnnotatedClass} {@link AnnotatedClass#getType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findPOJOBuilder(AnnotatedClass); given 'null'; when AnnotatedClass getType() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class RosettaJSONAnnotationIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_givenNull_whenAnnotatedClassGetTypeReturnNull() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    JsonDeserialize jsonDeserialize = mock(JsonDeserialize.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(jsonDeserialize.builder()).thenReturn(forNameResult);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(ac.getType()).thenReturn(null);
    when(ac.getAnnotation(JsonDeserialize.class)).thenReturn(jsonDeserialize);

    // Act
    Class<?> actualFindPOJOBuilderResult = rosettaJSONAnnotationIntrospector.findPOJOBuilder(ac);

    // Assert
    verify(jsonDeserialize).builder();
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac).getType();
    verify(ac).hasAnnotation(isA(Class.class));
    Class<Object> expectedFindPOJOBuilderResult = Object.class;
    assertEquals(expectedFindPOJOBuilderResult, actualFindPOJOBuilderResult);
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findPOJOBuilder(AnnotatedClass); given PlaceholderForType(int) with ordinal is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class RosettaJSONAnnotationIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_givenPlaceholderForTypeWithOrdinalIsOne() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    JsonDeserialize jsonDeserialize = mock(JsonDeserialize.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(jsonDeserialize.builder()).thenReturn(forNameResult);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(ac.getType()).thenReturn(new PlaceholderForType(1));
    when(ac.getAnnotation(JsonDeserialize.class)).thenReturn(jsonDeserialize);

    // Act
    Class<?> actualFindPOJOBuilderResult = rosettaJSONAnnotationIntrospector.findPOJOBuilder(ac);

    // Assert
    verify(jsonDeserialize).builder();
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac).getType();
    verify(ac).hasAnnotation(isA(Class.class));
    Class<Object> expectedFindPOJOBuilderResult = Object.class;
    assertEquals(expectedFindPOJOBuilderResult, actualFindPOJOBuilderResult);
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@link RosettaDataType}.
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName("Test findPOJOBuilder(AnnotatedClass); given RosettaDataType; then return Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class RosettaJSONAnnotationIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_givenRosettaDataType_thenReturnObject() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    ArrayType arrayType = mock(ArrayType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(arrayType.getRawClass()).thenReturn(forNameResult);

    JsonDeserialize jsonDeserialize = mock(JsonDeserialize.class);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(jsonDeserialize.builder()).thenReturn(forNameResult2);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getAnnotation(RosettaDataType.class)).thenReturn(mock(RosettaDataType.class));
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(ac.getType()).thenReturn(arrayType);
    when(ac.getAnnotation(JsonDeserialize.class)).thenReturn(jsonDeserialize);

    // Act
    Class<?> actualFindPOJOBuilderResult = rosettaJSONAnnotationIntrospector.findPOJOBuilder(ac);

    // Assert
    verify(arrayType).getRawClass();
    verify(jsonDeserialize).builder();
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac).getType();
    verify(ac).hasAnnotation(isA(Class.class));
    Class<Object> expectedFindPOJOBuilderResult = Object.class;
    assertEquals(expectedFindPOJOBuilderResult, actualFindPOJOBuilderResult);
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@link RosettaModelObjectBuilder}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findPOJOBuilder(AnnotatedClass); given 'true'; then return RosettaModelObjectBuilder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class RosettaJSONAnnotationIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_givenTrue_thenReturnRosettaModelObjectBuilder() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    RosettaDataType rosettaDataType = mock(RosettaDataType.class);
    Class<RosettaModelObjectBuilder> forNameResult = RosettaModelObjectBuilder.class;
    Mockito.<Class<? extends RosettaModelObjectBuilder>>when(rosettaDataType.builder())
        .thenReturn(forNameResult);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getAnnotation(RosettaDataType.class)).thenReturn(rosettaDataType);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(true);
    when(ac.getAnnotation(JsonDeserialize.class)).thenReturn(mock(JsonDeserialize.class));

    // Act
    Class<?> actualFindPOJOBuilderResult = rosettaJSONAnnotationIntrospector.findPOJOBuilder(ac);

    // Assert
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac).hasAnnotation(isA(Class.class));
    verify(rosettaDataType).builder();
    Class<RosettaModelObjectBuilder> expectedFindPOJOBuilderResult =
        RosettaModelObjectBuilder.class;
    assertEquals(expectedFindPOJOBuilderResult, actualFindPOJOBuilderResult);
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}.
   *
   * <ul>
   *   <li>Given {@link JsonGetter} {@link JsonGetter#value()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}
   */
  @Test
  @DisplayName("Test findNameForSerialization(Annotated); given JsonGetter value() return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyName RosettaJSONAnnotationIntrospector.findNameForSerialization(Annotated)"
  })
  void testFindNameForSerialization_givenJsonGetterValueReturn42() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    JsonGetter jsonGetter = mock(JsonGetter.class);
    when(jsonGetter.value()).thenReturn("42");

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.getAnnotation(RosettaAttribute.class)).thenReturn(mock(RosettaAttribute.class));
    when(a.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(a.getAnnotation(JsonGetter.class)).thenReturn(jsonGetter);
    when(a.getAnnotation(JsonProperty.class)).thenReturn(mock(JsonProperty.class));

    // Act
    PropertyName actualFindNameForSerializationResult =
        rosettaJSONAnnotationIntrospector.findNameForSerialization(a);

    // Assert
    verify(jsonGetter).value();
    verify(a).getAnnotation(isA(Class.class));
    verify(a).hasAnnotation(isA(Class.class));
    assertEquals("42", actualFindNameForSerializationResult.getSimpleName());
    assertNull(actualFindNameForSerializationResult.getNamespace());
    assertFalse(actualFindNameForSerializationResult.hasNamespace());
    assertFalse(actualFindNameForSerializationResult.isEmpty());
    assertTrue(actualFindNameForSerializationResult.hasSimpleName());
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}.
   *
   * <ul>
   *   <li>Given {@link JsonProperty} {@link JsonProperty#namespace()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}
   */
  @Test
  @DisplayName(
      "Test findNameForSerialization(Annotated); given JsonProperty namespace() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyName RosettaJSONAnnotationIntrospector.findNameForSerialization(Annotated)"
  })
  void testFindNameForSerialization_givenJsonPropertyNamespaceReturnEmptyString() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    JsonGetter jsonGetter = mock(JsonGetter.class);
    when(jsonGetter.value()).thenReturn("");

    JsonProperty jsonProperty = mock(JsonProperty.class);
    when(jsonProperty.namespace()).thenReturn("");
    when(jsonProperty.value()).thenReturn("42");

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.getAnnotation(RosettaAttribute.class)).thenReturn(mock(RosettaAttribute.class));
    when(a.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(a.getAnnotation(JsonGetter.class)).thenReturn(jsonGetter);
    when(a.getAnnotation(JsonProperty.class)).thenReturn(jsonProperty);

    // Act
    PropertyName actualFindNameForSerializationResult =
        rosettaJSONAnnotationIntrospector.findNameForSerialization(a);

    // Assert
    verify(jsonGetter).value();
    verify(jsonProperty).namespace();
    verify(jsonProperty).value();
    verify(a, atLeast(1)).getAnnotation(Mockito.<Class<Annotation>>any());
    verify(a).hasAnnotation(isA(Class.class));
    assertEquals("42", actualFindNameForSerializationResult.getSimpleName());
    assertNull(actualFindNameForSerializationResult.getNamespace());
    assertFalse(actualFindNameForSerializationResult.hasNamespace());
    assertFalse(actualFindNameForSerializationResult.isEmpty());
    assertTrue(actualFindNameForSerializationResult.hasSimpleName());
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}.
   *
   * <ul>
   *   <li>Given {@link JsonProperty} {@link JsonProperty#value()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}
   */
  @Test
  @DisplayName(
      "Test findNameForSerialization(Annotated); given JsonProperty value() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyName RosettaJSONAnnotationIntrospector.findNameForSerialization(Annotated)"
  })
  void testFindNameForSerialization_givenJsonPropertyValueReturnEmptyString() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    JsonGetter jsonGetter = mock(JsonGetter.class);
    when(jsonGetter.value()).thenReturn("");

    JsonProperty jsonProperty = mock(JsonProperty.class);
    when(jsonProperty.namespace()).thenReturn("");
    when(jsonProperty.value()).thenReturn("");

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.getAnnotation(RosettaAttribute.class)).thenReturn(mock(RosettaAttribute.class));
    when(a.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(a.getAnnotation(JsonGetter.class)).thenReturn(jsonGetter);
    when(a.getAnnotation(JsonProperty.class)).thenReturn(jsonProperty);

    // Act
    PropertyName actualFindNameForSerializationResult =
        rosettaJSONAnnotationIntrospector.findNameForSerialization(a);

    // Assert
    verify(jsonGetter).value();
    verify(jsonProperty).namespace();
    verify(jsonProperty).value();
    verify(a, atLeast(1)).getAnnotation(Mockito.<Class<Annotation>>any());
    verify(a).hasAnnotation(isA(Class.class));
    assertSame(PropertyName.USE_DEFAULT, actualFindNameForSerializationResult);
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}.
   *
   * <ul>
   *   <li>Given {@link RosettaAttribute} {@link RosettaAttribute#value()} return {@code 42}.
   *   <li>Then calls {@link RosettaAttribute#value()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}
   */
  @Test
  @DisplayName(
      "Test findNameForSerialization(Annotated); given RosettaAttribute value() return '42'; then calls value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyName RosettaJSONAnnotationIntrospector.findNameForSerialization(Annotated)"
  })
  void testFindNameForSerialization_givenRosettaAttributeValueReturn42_thenCallsValue() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    RosettaAttribute rosettaAttribute = mock(RosettaAttribute.class);
    when(rosettaAttribute.value()).thenReturn("42");

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.getAnnotation(RosettaAttribute.class)).thenReturn(rosettaAttribute);
    when(a.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(true);
    when(a.getAnnotation(JsonGetter.class)).thenReturn(mock(JsonGetter.class));
    when(a.getAnnotation(JsonProperty.class)).thenReturn(mock(JsonProperty.class));

    // Act
    PropertyName actualFindNameForSerializationResult =
        rosettaJSONAnnotationIntrospector.findNameForSerialization(a);

    // Assert
    verify(a).getAnnotation(isA(Class.class));
    verify(a).hasAnnotation(isA(Class.class));
    verify(rosettaAttribute).value();
    assertEquals("42", actualFindNameForSerializationResult.getSimpleName());
    assertNull(actualFindNameForSerializationResult.getNamespace());
    assertFalse(actualFindNameForSerializationResult.hasNamespace());
    assertFalse(actualFindNameForSerializationResult.isEmpty());
    assertTrue(actualFindNameForSerializationResult.hasSimpleName());
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}.
   *
   * <ul>
   *   <li>Then return {@code Namespace}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}
   */
  @Test
  @DisplayName("Test findNameForSerialization(Annotated); then return 'Namespace'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyName RosettaJSONAnnotationIntrospector.findNameForSerialization(Annotated)"
  })
  void testFindNameForSerialization_thenReturnNamespace() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    JsonGetter jsonGetter = mock(JsonGetter.class);
    when(jsonGetter.value()).thenReturn("");

    JsonProperty jsonProperty = mock(JsonProperty.class);
    when(jsonProperty.namespace()).thenReturn("Namespace");
    when(jsonProperty.value()).thenReturn("42");

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.getAnnotation(RosettaAttribute.class)).thenReturn(mock(RosettaAttribute.class));
    when(a.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(a.getAnnotation(JsonGetter.class)).thenReturn(jsonGetter);
    when(a.getAnnotation(JsonProperty.class)).thenReturn(jsonProperty);

    // Act
    PropertyName actualFindNameForSerializationResult =
        rosettaJSONAnnotationIntrospector.findNameForSerialization(a);

    // Assert
    verify(jsonGetter).value();
    verify(jsonProperty).namespace();
    verify(jsonProperty).value();
    verify(a, atLeast(1)).getAnnotation(Mockito.<Class<Annotation>>any());
    verify(a).hasAnnotation(isA(Class.class));
    assertEquals("42", actualFindNameForSerializationResult.getSimpleName());
    assertEquals("Namespace", actualFindNameForSerializationResult.getNamespace());
    assertFalse(actualFindNameForSerializationResult.isEmpty());
    assertTrue(actualFindNameForSerializationResult.hasNamespace());
    assertTrue(actualFindNameForSerializationResult.hasSimpleName());
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}.
   *
   * <ul>
   *   <li>Then return SimpleName is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}
   */
  @Test
  @DisplayName("Test findNameForSerialization(Annotated); then return SimpleName is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyName RosettaJSONAnnotationIntrospector.findNameForSerialization(Annotated)"
  })
  void testFindNameForSerialization_thenReturnSimpleNameIsFoo() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    JsonGetter jsonGetter = mock(JsonGetter.class);
    when(jsonGetter.value()).thenReturn("foo");

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.getAnnotation(RosettaAttribute.class)).thenReturn(mock(RosettaAttribute.class));
    when(a.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(a.getAnnotation(JsonGetter.class)).thenReturn(jsonGetter);
    when(a.getAnnotation(JsonProperty.class)).thenReturn(mock(JsonProperty.class));

    // Act
    PropertyName actualFindNameForSerializationResult =
        rosettaJSONAnnotationIntrospector.findNameForSerialization(a);

    // Assert
    verify(jsonGetter).value();
    verify(a).getAnnotation(isA(Class.class));
    verify(a).hasAnnotation(isA(Class.class));
    assertEquals("foo", actualFindNameForSerializationResult.getSimpleName());
    assertNull(actualFindNameForSerializationResult.getNamespace());
    assertFalse(actualFindNameForSerializationResult.hasNamespace());
    assertFalse(actualFindNameForSerializationResult.isEmpty());
    assertTrue(actualFindNameForSerializationResult.hasSimpleName());
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}
   */
  @Test
  @DisplayName(
      "Test findNameForSerialization(Annotated); when 'java.lang.Object'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyName RosettaJSONAnnotationIntrospector.findNameForSerialization(Annotated)"
  })
  void testFindNameForSerialization_whenJavaLangObject_thenReturnNull() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute a =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act
    PropertyName actualFindNameForSerializationResult =
        rosettaJSONAnnotationIntrospector.findNameForSerialization(a);

    // Assert
    assertNull(actualFindNameForSerializationResult);
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findNameForDeserialization(Annotated)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#findNameForDeserialization(Annotated)}
   */
  @Test
  @DisplayName("Test findNameForDeserialization(Annotated); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyName RosettaJSONAnnotationIntrospector.findNameForDeserialization(Annotated)"
  })
  void testFindNameForDeserialization_thenReturnNull() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute a =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act
    PropertyName actualFindNameForDeserializationResult =
        rosettaJSONAnnotationIntrospector.findNameForDeserialization(a);

    // Assert
    assertNull(actualFindNameForDeserializationResult);
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findNameForDeserialization(Annotated)}.
   *
   * <ul>
   *   <li>Then return SimpleName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#findNameForDeserialization(Annotated)}
   */
  @Test
  @DisplayName("Test findNameForDeserialization(Annotated); then return SimpleName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyName RosettaJSONAnnotationIntrospector.findNameForDeserialization(Annotated)"
  })
  void testFindNameForDeserialization_thenReturnSimpleNameIs42() {
    // Arrange
    EnumAsStringBuilderIntrospector enumAsStringBuilderIntrospector =
        new EnumAsStringBuilderIntrospector();
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(
            null, enumAsStringBuilderIntrospector, new RosettaEnumBuilderIntrospector(true));

    RosettaAttribute rosettaAttribute = mock(RosettaAttribute.class);
    when(rosettaAttribute.value()).thenReturn("42");

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.getAnnotation(RosettaAttribute.class)).thenReturn(rosettaAttribute);
    when(a.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(true);

    // Act
    PropertyName actualFindNameForDeserializationResult =
        rosettaJSONAnnotationIntrospector.findNameForDeserialization(a);

    // Assert
    verify(a).getAnnotation(isA(Class.class));
    verify(a).hasAnnotation(isA(Class.class));
    verify(rosettaAttribute).value();
    assertEquals("42", actualFindNameForDeserializationResult.getSimpleName());
    assertNull(actualFindNameForDeserializationResult.getNamespace());
    assertFalse(actualFindNameForDeserializationResult.hasNamespace());
    assertFalse(actualFindNameForDeserializationResult.isEmpty());
    assertTrue(actualFindNameForDeserializationResult.hasSimpleName());
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findPropertyIgnorals(Annotated)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link AnnotatedClass#memberMethods()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONAnnotationIntrospector#findPropertyIgnorals(Annotated)}
   */
  @Test
  @DisplayName(
      "Test findPropertyIgnorals(Annotated); given ArrayList(); then calls memberMethods()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonIgnoreProperties.Value RosettaJSONAnnotationIntrospector.findPropertyIgnorals(Annotated)"
  })
  void testFindPropertyIgnorals_givenArrayList_thenCallsMemberMethods() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.memberMethods()).thenReturn(new ArrayList<>());
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(true);

    // Act
    Value actualFindPropertyIgnoralsResult =
        rosettaJSONAnnotationIntrospector.findPropertyIgnorals(ac);

    // Assert
    verify(ac).hasAnnotation(isA(Class.class));
    verify(ac, atLeast(1)).memberMethods();
    assertFalse(actualFindPropertyIgnoralsResult.getAllowGetters());
    assertFalse(actualFindPropertyIgnoralsResult.getIgnoreUnknown());
    assertTrue(actualFindPropertyIgnoralsResult.getAllowSetters());
    assertTrue(actualFindPropertyIgnoralsResult.getMerge());
    assertTrue(actualFindPropertyIgnoralsResult.getIgnored().isEmpty());
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findPropertyIgnorals(Annotated)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link AnnotatedClass#getRawType()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONAnnotationIntrospector#findPropertyIgnorals(Annotated)}
   */
  @Test
  @DisplayName("Test findPropertyIgnorals(Annotated); given 'false'; then calls getRawType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonIgnoreProperties.Value RosettaJSONAnnotationIntrospector.findPropertyIgnorals(Annotated)"
  })
  void testFindPropertyIgnorals_givenFalse_thenCallsGetRawType() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(ac.getRawType()).thenReturn(forNameResult);

    // Act
    Value actualFindPropertyIgnoralsResult =
        rosettaJSONAnnotationIntrospector.findPropertyIgnorals(ac);

    // Assert
    verify(ac).getRawType();
    verify(ac).hasAnnotation(isA(Class.class));
    assertFalse(actualFindPropertyIgnoralsResult.getAllowGetters());
    assertFalse(actualFindPropertyIgnoralsResult.getIgnoreUnknown());
    assertTrue(actualFindPropertyIgnoralsResult.getAllowSetters());
    assertTrue(actualFindPropertyIgnoralsResult.getMerge());
    assertTrue(actualFindPropertyIgnoralsResult.getIgnored().isEmpty());
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findPropertyIgnorals(Annotated)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return not AllowSetters.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONAnnotationIntrospector#findPropertyIgnorals(Annotated)}
   */
  @Test
  @DisplayName(
      "Test findPropertyIgnorals(Annotated); when 'java.lang.Object'; then return not AllowSetters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonIgnoreProperties.Value RosettaJSONAnnotationIntrospector.findPropertyIgnorals(Annotated)"
  })
  void testFindPropertyIgnorals_whenJavaLangObject_thenReturnNotAllowSetters() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute ac =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act
    Value actualFindPropertyIgnoralsResult =
        rosettaJSONAnnotationIntrospector.findPropertyIgnorals(ac);

    // Assert
    assertFalse(actualFindPropertyIgnoralsResult.getAllowGetters());
    assertFalse(actualFindPropertyIgnoralsResult.getAllowSetters());
    assertFalse(actualFindPropertyIgnoralsResult.getIgnoreUnknown());
    assertTrue(actualFindPropertyIgnoralsResult.getMerge());
    assertTrue(actualFindPropertyIgnoralsResult.getIgnored().isEmpty());
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#version()}.
   *
   * <p>Method under test: {@link RosettaJSONAnnotationIntrospector#version()}
   */
  @Test
  @DisplayName("Test version()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Version RosettaJSONAnnotationIntrospector.version()"})
  void testVersion() {
    // Arrange and Act
    Version actualVersionResult = new RosettaJSONAnnotationIntrospector(true).version();

    // Assert
    assertEquals("", actualVersionResult.getArtifactId());
    assertEquals("", actualVersionResult.getGroupId());
    assertEquals("//0.0.0", actualVersionResult.toFullString());
    assertEquals(0, actualVersionResult.getMajorVersion());
    assertEquals(0, actualVersionResult.getMinorVersion());
    assertEquals(0, actualVersionResult.getPatchLevel());
    assertFalse(actualVersionResult.isSnapshot());
    assertTrue(actualVersionResult.isUknownVersion());
    assertTrue(actualVersionResult.isUnknownVersion());
  }
}
