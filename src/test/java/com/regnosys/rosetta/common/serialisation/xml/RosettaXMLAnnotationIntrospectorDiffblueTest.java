package com.regnosys.rosetta.common.serialisation.xml;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.ResolvedRecursiveType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.regnosys.rosetta.common.serialisation.mixin.EnumAsStringBuilderIntrospector;
import com.regnosys.rosetta.common.serialisation.mixin.RosettaEnumBuilderIntrospector;
import com.rosetta.model.lib.ModelSymbolId;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.util.serialisation.AttributeXMLConfiguration;
import com.rosetta.util.serialisation.RosettaXMLConfiguration;
import com.rosetta.util.serialisation.TypeXMLConfiguration;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RosettaXMLAnnotationIntrospectorDiffblueTest {
  /**
   * Test {@link RosettaXMLAnnotationIntrospector#RosettaXMLAnnotationIntrospector(ObjectMapper,
   * RosettaXMLConfiguration, RosettaEnumBuilderIntrospector, EnumAsStringBuilderIntrospector)}.
   *
   * <p>Method under test: {@link
   * RosettaXMLAnnotationIntrospector#RosettaXMLAnnotationIntrospector(ObjectMapper,
   * RosettaXMLConfiguration, RosettaEnumBuilderIntrospector, EnumAsStringBuilderIntrospector)}
   */
  @Test
  @DisplayName(
      "Test new RosettaXMLAnnotationIntrospector(ObjectMapper, RosettaXMLConfiguration, RosettaEnumBuilderIntrospector, EnumAsStringBuilderIntrospector)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaXMLAnnotationIntrospector.<init>(ObjectMapper, RosettaXMLConfiguration, RosettaEnumBuilderIntrospector, EnumAsStringBuilderIntrospector)"
  })
  void testNewRosettaXMLAnnotationIntrospector() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLConfiguration rosettaXMLConfiguration = new RosettaXMLConfiguration(new HashMap<>());
    RosettaEnumBuilderIntrospector rosettaEnumBuilderIntrospector =
        new RosettaEnumBuilderIntrospector(true);

    // Act
    RosettaXMLAnnotationIntrospector actualRosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper,
            rosettaXMLConfiguration,
            rosettaEnumBuilderIntrospector,
            new EnumAsStringBuilderIntrospector());

    // Assert
    Version versionResult = actualRosettaXMLAnnotationIntrospector.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals(
        "com.fasterxml.jackson.core/jackson-databind/2.17.1", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals(1, versionResult.getPatchLevel());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#RosettaXMLAnnotationIntrospector(ObjectMapper,
   * RosettaXMLConfiguration, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaXMLAnnotationIntrospector#RosettaXMLAnnotationIntrospector(ObjectMapper,
   * RosettaXMLConfiguration, boolean)}
   */
  @Test
  @DisplayName(
      "Test new RosettaXMLAnnotationIntrospector(ObjectMapper, RosettaXMLConfiguration, boolean); when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaXMLAnnotationIntrospector.<init>(ObjectMapper, RosettaXMLConfiguration, boolean)"
  })
  void testNewRosettaXMLAnnotationIntrospector_whenFalse() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    RosettaXMLAnnotationIntrospector actualRosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), false);

    // Assert
    Version versionResult = actualRosettaXMLAnnotationIntrospector.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals(
        "com.fasterxml.jackson.core/jackson-databind/2.17.1", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals(1, versionResult.getPatchLevel());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#RosettaXMLAnnotationIntrospector(ObjectMapper,
   * RosettaXMLConfiguration, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaXMLAnnotationIntrospector#RosettaXMLAnnotationIntrospector(ObjectMapper,
   * RosettaXMLConfiguration, boolean)}
   */
  @Test
  @DisplayName(
      "Test new RosettaXMLAnnotationIntrospector(ObjectMapper, RosettaXMLConfiguration, boolean); when 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaXMLAnnotationIntrospector.<init>(ObjectMapper, RosettaXMLConfiguration, boolean)"
  })
  void testNewRosettaXMLAnnotationIntrospector_whenTrue() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    RosettaXMLAnnotationIntrospector actualRosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    // Assert
    Version versionResult = actualRosettaXMLAnnotationIntrospector.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals(
        "com.fasterxml.jackson.core/jackson-databind/2.17.1", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals(1, versionResult.getPatchLevel());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findUnwrappingNameTransformer(AnnotatedMember)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaXMLAnnotationIntrospector#findUnwrappingNameTransformer(AnnotatedMember)}
   */
  @Test
  @DisplayName(
      "Test findUnwrappingNameTransformer(AnnotatedMember); when 'java.lang.Object'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NameTransformer RosettaXMLAnnotationIntrospector.findUnwrappingNameTransformer(AnnotatedMember)"
  })
  void testFindUnwrappingNameTransformer_whenJavaLangObject_thenReturnNull() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act
    NameTransformer actualFindUnwrappingNameTransformerResult =
        rosettaXMLAnnotationIntrospector.findUnwrappingNameTransformer(member);

    // Assert
    assertNull(actualFindUnwrappingNameTransformerResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName("Test findPOJOBuilder(AnnotatedClass); given 'false'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class RosettaXMLAnnotationIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_givenFalse_thenReturnNull() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);

    // Act
    Class<?> actualFindPOJOBuilderResult = rosettaXMLAnnotationIntrospector.findPOJOBuilder(ac);

    // Assert
    verify(ac).hasAnnotation(isA(Class.class));
    assertNull(actualFindPOJOBuilderResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName("Test findPOJOBuilder(AnnotatedClass); given 'java.lang.Object'; then return Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class RosettaXMLAnnotationIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_givenJavaLangObject_thenReturnObject() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    JsonDeserialize jsonDeserialize = mock(JsonDeserialize.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(jsonDeserialize.builder()).thenReturn(forNameResult);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(ac.getAnnotation(JsonDeserialize.class)).thenReturn(jsonDeserialize);

    // Act
    Class<?> actualFindPOJOBuilderResult = rosettaXMLAnnotationIntrospector.findPOJOBuilder(ac);

    // Assert
    verify(jsonDeserialize).builder();
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac).hasAnnotation(isA(Class.class));
    Class<Object> expectedFindPOJOBuilderResult = Object.class;
    assertEquals(expectedFindPOJOBuilderResult, actualFindPOJOBuilderResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@link JsonDeserialize} {@link JsonDeserialize#builder()} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findPOJOBuilder(AnnotatedClass); given JsonDeserialize builder() return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class RosettaXMLAnnotationIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_givenJsonDeserializeBuilderReturnNull_thenReturnNull() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    JsonDeserialize jsonDeserialize = mock(JsonDeserialize.class);
    Mockito.<Class<?>>when(jsonDeserialize.builder()).thenReturn(null);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getAnnotation(RosettaDataType.class)).thenReturn(mock(RosettaDataType.class));
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(ac.getAnnotation(JsonDeserialize.class)).thenReturn(jsonDeserialize);

    // Act
    Class<?> actualFindPOJOBuilderResult = rosettaXMLAnnotationIntrospector.findPOJOBuilder(ac);

    // Assert
    verify(jsonDeserialize).builder();
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac).hasAnnotation(isA(Class.class));
    assertNull(actualFindPOJOBuilderResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@link JsonDeserialize} {@link JsonDeserialize#builder()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findPOJOBuilder(AnnotatedClass); given JsonDeserialize builder() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class RosettaXMLAnnotationIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_givenJsonDeserializeBuilderThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    JsonDeserialize jsonDeserialize = mock(JsonDeserialize.class);
    Mockito.<Class<?>>when(jsonDeserialize.builder()).thenThrow(new RuntimeException());

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(ac.getAnnotation(JsonDeserialize.class)).thenReturn(jsonDeserialize);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> rosettaXMLAnnotationIntrospector.findPOJOBuilder(ac));
    verify(jsonDeserialize).builder();
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac).hasAnnotation(isA(Class.class));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@link RosettaDataType} {@link RosettaDataType#builder()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findPOJOBuilder(AnnotatedClass); given RosettaDataType builder() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class RosettaXMLAnnotationIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_givenRosettaDataTypeBuilderThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    RosettaDataType rosettaDataType = mock(RosettaDataType.class);
    Mockito.<Class<? extends RosettaModelObjectBuilder>>when(rosettaDataType.builder())
        .thenThrow(new RuntimeException());

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getAnnotation(RosettaDataType.class)).thenReturn(rosettaDataType);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(true);
    when(ac.getAnnotation(JsonDeserialize.class)).thenReturn(mock(JsonDeserialize.class));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> rosettaXMLAnnotationIntrospector.findPOJOBuilder(ac));
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac).hasAnnotation(isA(Class.class));
    verify(rosettaDataType).builder();
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Then return {@link RosettaModelObjectBuilder}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName("Test findPOJOBuilder(AnnotatedClass); then return RosettaModelObjectBuilder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class RosettaXMLAnnotationIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_thenReturnRosettaModelObjectBuilder() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    RosettaDataType rosettaDataType = mock(RosettaDataType.class);
    Class<RosettaModelObjectBuilder> forNameResult = RosettaModelObjectBuilder.class;
    Mockito.<Class<? extends RosettaModelObjectBuilder>>when(rosettaDataType.builder())
        .thenReturn(forNameResult);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getAnnotation(RosettaDataType.class)).thenReturn(rosettaDataType);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(true);
    when(ac.getAnnotation(JsonDeserialize.class)).thenReturn(mock(JsonDeserialize.class));

    // Act
    Class<?> actualFindPOJOBuilderResult = rosettaXMLAnnotationIntrospector.findPOJOBuilder(ac);

    // Assert
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac).hasAnnotation(isA(Class.class));
    verify(rosettaDataType).builder();
    Class<RosettaModelObjectBuilder> expectedFindPOJOBuilderResult =
        RosettaModelObjectBuilder.class;
    assertEquals(expectedFindPOJOBuilderResult, actualFindPOJOBuilderResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>When {@link AnnotatedClass} {@link AnnotatedClass#getAnnotation(Class)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findPOJOBuilder(AnnotatedClass); when AnnotatedClass getAnnotation(Class) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class RosettaXMLAnnotationIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_whenAnnotatedClassGetAnnotationThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getAnnotation(RosettaDataType.class)).thenThrow(new RuntimeException());
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(true);
    when(ac.getAnnotation(JsonDeserialize.class)).thenReturn(mock(JsonDeserialize.class));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> rosettaXMLAnnotationIntrospector.findPOJOBuilder(ac));
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac).hasAnnotation(isA(Class.class));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>When {@link AnnotatedClass} {@link AnnotatedClass#hasAnnotation(Class)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findPOJOBuilder(AnnotatedClass); when AnnotatedClass hasAnnotation(Class) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class RosettaXMLAnnotationIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_whenAnnotatedClassHasAnnotationThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> rosettaXMLAnnotationIntrospector.findPOJOBuilder(ac));
    verify(ac).hasAnnotation(isA(Class.class));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findPOJOBuilderConfig(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaXMLAnnotationIntrospector#findPOJOBuilderConfig(AnnotatedClass)}
   */
  @Test
  @DisplayName("Test findPOJOBuilderConfig(AnnotatedClass); given 'false'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value RosettaXMLAnnotationIntrospector.findPOJOBuilderConfig(AnnotatedClass)"
  })
  void testFindPOJOBuilderConfig_givenFalse_thenReturnNull() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);

    // Act
    Value actualFindPOJOBuilderConfigResult =
        rosettaXMLAnnotationIntrospector.findPOJOBuilderConfig(ac);

    // Assert
    verify(ac).hasAnnotation(isA(Class.class));
    assertNull(actualFindPOJOBuilderConfigResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findPOJOBuilderConfig(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaXMLAnnotationIntrospector#findPOJOBuilderConfig(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findPOJOBuilderConfig(AnnotatedClass); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value RosettaXMLAnnotationIntrospector.findPOJOBuilderConfig(AnnotatedClass)"
  })
  void testFindPOJOBuilderConfig_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> rosettaXMLAnnotationIntrospector.findPOJOBuilderConfig(ac));
    verify(ac).hasAnnotation(isA(Class.class));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findPOJOBuilderConfig(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@link Value#buildMethodName} is {@code build}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaXMLAnnotationIntrospector#findPOJOBuilderConfig(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findPOJOBuilderConfig(AnnotatedClass); given 'true'; then return buildMethodName is 'build'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value RosettaXMLAnnotationIntrospector.findPOJOBuilderConfig(AnnotatedClass)"
  })
  void testFindPOJOBuilderConfig_givenTrue_thenReturnBuildMethodNameIsBuild() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(true);

    // Act
    Value actualFindPOJOBuilderConfigResult =
        rosettaXMLAnnotationIntrospector.findPOJOBuilderConfig(ac);

    // Assert
    verify(ac).hasAnnotation(isA(Class.class));
    assertEquals("build", actualFindPOJOBuilderConfigResult.buildMethodName);
    assertEquals("set", actualFindPOJOBuilderConfigResult.withPrefix);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findPOJOBuilderConfig(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Then return {@code Build Method Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaXMLAnnotationIntrospector#findPOJOBuilderConfig(AnnotatedClass)}
   */
  @Test
  @DisplayName("Test findPOJOBuilderConfig(AnnotatedClass); then return 'Build Method Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value RosettaXMLAnnotationIntrospector.findPOJOBuilderConfig(AnnotatedClass)"
  })
  void testFindPOJOBuilderConfig_thenReturnBuildMethodName() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    JsonPOJOBuilder jsonPOJOBuilder = mock(JsonPOJOBuilder.class);
    when(jsonPOJOBuilder.buildMethodName()).thenReturn("Build Method Name");
    when(jsonPOJOBuilder.withPrefix()).thenReturn("Prefix");

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(ac.getAnnotation(JsonPOJOBuilder.class)).thenReturn(jsonPOJOBuilder);

    // Act
    Value actualFindPOJOBuilderConfigResult =
        rosettaXMLAnnotationIntrospector.findPOJOBuilderConfig(ac);

    // Assert
    verify(jsonPOJOBuilder).buildMethodName();
    verify(jsonPOJOBuilder).withPrefix();
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac).hasAnnotation(isA(Class.class));
    assertEquals("Build Method Name", actualFindPOJOBuilderConfigResult.buildMethodName);
    assertEquals("Prefix", actualFindPOJOBuilderConfigResult.withPrefix);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}.
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}
   */
  @Test
  @DisplayName("Test findRootName(AnnotatedClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findRootName(AnnotatedClass)"})
  void testFindRootName() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    RosettaDataType rosettaDataType = mock(RosettaDataType.class);
    when(rosettaDataType.value()).thenReturn("42");

    JacksonXmlRootElement jacksonXmlRootElement = mock(JacksonXmlRootElement.class);
    when(jacksonXmlRootElement.localName()).thenReturn("Local Name");
    when(jacksonXmlRootElement.namespace()).thenReturn("Namespace");

    AnnotatedClass ac = mock(AnnotatedClass.class);
    Class<Object> erasedType = Object.class;
    when(ac.getType())
        .thenReturn(new ResolvedRecursiveType(erasedType, TypeBindings.emptyBindings()));
    when(ac.getAnnotation(RosettaDataType.class)).thenReturn(rosettaDataType);
    when(ac.getAnnotation(JacksonXmlRootElement.class)).thenReturn(jacksonXmlRootElement);
    when(ac.getAnnotation(JsonRootName.class)).thenReturn(mock(JsonRootName.class));

    // Act
    PropertyName actualFindRootNameResult = rosettaXMLAnnotationIntrospector.findRootName(ac);

    // Assert
    verify(ac, atLeast(1)).getAnnotation(Mockito.<Class<Annotation>>any());
    verify(ac, atLeast(1)).getType();
    verify(jacksonXmlRootElement).localName();
    verify(jacksonXmlRootElement).namespace();
    verify(rosettaDataType).value();
    assertEquals("Local Name", actualFindRootNameResult.getSimpleName());
    assertEquals("Namespace", actualFindRootNameResult.getNamespace());
    assertTrue(actualFindRootNameResult.hasNamespace());
    assertTrue(actualFindRootNameResult.hasSimpleName());
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}.
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}
   */
  @Test
  @DisplayName("Test findRootName(AnnotatedClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findRootName(AnnotatedClass)"})
  void testFindRootName2() {
    // Arrange
    HashMap<ModelSymbolId, TypeXMLConfiguration> typeConfigMap = new HashMap<>();
    ModelSymbolId fromQualifiedNameResult = ModelSymbolId.fromQualifiedName("Str");
    Optional<ModelSymbolId> substitutionFor = Optional.of(ModelSymbolId.fromQualifiedName("Str"));
    Optional<String> xmlElementName = Optional.of("42");
    Optional<Map<String, String>> xmlAttributes = Optional.of(new HashMap<>());
    Optional<Map<String, AttributeXMLConfiguration>> attributes = Optional.of(new HashMap<>());
    Optional<Map<String, String>> enumValues = Optional.of(new HashMap<>());

    TypeXMLConfiguration typeXMLConfiguration =
        new TypeXMLConfiguration(
            substitutionFor, xmlElementName, xmlAttributes, attributes, enumValues);

    typeConfigMap.put(fromQualifiedNameResult, typeXMLConfiguration);
    RosettaXMLConfiguration rosettaXMLConfiguration = new RosettaXMLConfiguration(typeConfigMap);
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(mapper, rosettaXMLConfiguration, true);

    RosettaDataType rosettaDataType = mock(RosettaDataType.class);
    when(rosettaDataType.value()).thenReturn("42");

    JacksonXmlRootElement jacksonXmlRootElement = mock(JacksonXmlRootElement.class);
    when(jacksonXmlRootElement.localName()).thenReturn("Local Name");
    when(jacksonXmlRootElement.namespace()).thenReturn("Namespace");

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getType()).thenReturn(new PlaceholderForType(1));
    when(ac.getAnnotation(RosettaDataType.class)).thenReturn(rosettaDataType);
    when(ac.getAnnotation(JacksonXmlRootElement.class)).thenReturn(jacksonXmlRootElement);
    when(ac.getAnnotation(JsonRootName.class)).thenReturn(mock(JsonRootName.class));

    // Act
    PropertyName actualFindRootNameResult = rosettaXMLAnnotationIntrospector.findRootName(ac);

    // Assert
    verify(ac, atLeast(1)).getAnnotation(Mockito.<Class<Annotation>>any());
    verify(ac, atLeast(1)).getType();
    verify(jacksonXmlRootElement).localName();
    verify(jacksonXmlRootElement).namespace();
    verify(rosettaDataType).value();
    assertEquals("Local Name", actualFindRootNameResult.getSimpleName());
    assertEquals("Namespace", actualFindRootNameResult.getNamespace());
    assertTrue(actualFindRootNameResult.hasNamespace());
    assertTrue(actualFindRootNameResult.hasSimpleName());
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given builder addMixIn {@link Object} and {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}
   */
  @Test
  @DisplayName("Test findRootName(AnnotatedClass); given builder addMixIn Object and Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findRootName(AnnotatedClass)"})
  void testFindRootName_givenBuilderAddMixInObjectAndObject() {
    // Arrange
    Builder builderResult = JsonMapper.builder();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;

    builderResult.addMixIn(target, mixinSource);
    JsonMapper mapper = builderResult.findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    RosettaDataType rosettaDataType = mock(RosettaDataType.class);
    when(rosettaDataType.value()).thenReturn("42");

    JacksonXmlRootElement jacksonXmlRootElement = mock(JacksonXmlRootElement.class);
    when(jacksonXmlRootElement.localName()).thenReturn("Local Name");
    when(jacksonXmlRootElement.namespace()).thenReturn("Namespace");

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getType()).thenReturn(new PlaceholderForType(1));
    when(ac.getAnnotation(RosettaDataType.class)).thenReturn(rosettaDataType);
    when(ac.getAnnotation(JacksonXmlRootElement.class)).thenReturn(jacksonXmlRootElement);
    when(ac.getAnnotation(JsonRootName.class)).thenReturn(mock(JsonRootName.class));

    // Act
    PropertyName actualFindRootNameResult = rosettaXMLAnnotationIntrospector.findRootName(ac);

    // Assert
    verify(ac, atLeast(1)).getAnnotation(Mockito.<Class<Annotation>>any());
    verify(ac, atLeast(1)).getType();
    verify(jacksonXmlRootElement).localName();
    verify(jacksonXmlRootElement).namespace();
    verify(rosettaDataType).value();
    assertEquals("Local Name", actualFindRootNameResult.getSimpleName());
    assertEquals("Namespace", actualFindRootNameResult.getNamespace());
    assertTrue(actualFindRootNameResult.hasNamespace());
    assertTrue(actualFindRootNameResult.hasSimpleName());
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@link JacksonXmlRootElement} {@link JacksonXmlRootElement#localName()} return
   *       empty string.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findRootName(AnnotatedClass); given JacksonXmlRootElement localName() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findRootName(AnnotatedClass)"})
  void testFindRootName_givenJacksonXmlRootElementLocalNameReturnEmptyString() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    RosettaDataType rosettaDataType = mock(RosettaDataType.class);
    when(rosettaDataType.value()).thenReturn("42");

    JacksonXmlRootElement jacksonXmlRootElement = mock(JacksonXmlRootElement.class);
    when(jacksonXmlRootElement.localName()).thenReturn("");
    when(jacksonXmlRootElement.namespace()).thenReturn("Namespace");

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getType()).thenReturn(new PlaceholderForType(1));
    when(ac.getAnnotation(RosettaDataType.class)).thenReturn(rosettaDataType);
    when(ac.getAnnotation(JacksonXmlRootElement.class)).thenReturn(jacksonXmlRootElement);
    when(ac.getAnnotation(JsonRootName.class)).thenReturn(mock(JsonRootName.class));

    // Act
    PropertyName actualFindRootNameResult = rosettaXMLAnnotationIntrospector.findRootName(ac);

    // Assert
    verify(ac, atLeast(1)).getAnnotation(Mockito.<Class<Annotation>>any());
    verify(ac, atLeast(1)).getType();
    verify(jacksonXmlRootElement).localName();
    verify(jacksonXmlRootElement).namespace();
    verify(rosettaDataType).value();
    assertEquals("", actualFindRootNameResult.getSimpleName());
    assertEquals("Namespace", actualFindRootNameResult.getNamespace());
    assertFalse(actualFindRootNameResult.hasSimpleName());
    assertTrue(actualFindRootNameResult.hasNamespace());
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@link JacksonXmlRootElement} {@link JacksonXmlRootElement#localName()} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findRootName(AnnotatedClass); given JacksonXmlRootElement localName() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findRootName(AnnotatedClass)"})
  void testFindRootName_givenJacksonXmlRootElementLocalNameThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    RosettaDataType rosettaDataType = mock(RosettaDataType.class);
    when(rosettaDataType.value()).thenReturn("42");

    JacksonXmlRootElement jacksonXmlRootElement = mock(JacksonXmlRootElement.class);
    when(jacksonXmlRootElement.localName()).thenThrow(new RuntimeException());

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getType()).thenReturn(new PlaceholderForType(1));
    when(ac.getAnnotation(RosettaDataType.class)).thenReturn(rosettaDataType);
    when(ac.getAnnotation(JacksonXmlRootElement.class)).thenReturn(jacksonXmlRootElement);
    when(ac.getAnnotation(JsonRootName.class)).thenReturn(mock(JsonRootName.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> rosettaXMLAnnotationIntrospector.findRootName(ac));
    verify(ac, atLeast(1)).getAnnotation(Mockito.<Class<Annotation>>any());
    verify(ac, atLeast(1)).getType();
    verify(jacksonXmlRootElement).localName();
    verify(rosettaDataType).value();
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@link RosettaDataType} {@link RosettaDataType#value()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findRootName(AnnotatedClass); given RosettaDataType value() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findRootName(AnnotatedClass)"})
  void testFindRootName_givenRosettaDataTypeValueThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    RosettaDataType rosettaDataType = mock(RosettaDataType.class);
    when(rosettaDataType.value()).thenThrow(new RuntimeException());

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getAnnotation(RosettaDataType.class)).thenReturn(rosettaDataType);
    when(ac.getAnnotation(JacksonXmlRootElement.class))
        .thenReturn(mock(JacksonXmlRootElement.class));
    when(ac.getAnnotation(JsonRootName.class)).thenReturn(mock(JsonRootName.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> rosettaXMLAnnotationIntrospector.findRootName(ac));
    verify(ac).getAnnotation(isA(Class.class));
    verify(rosettaDataType).value();
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Then return SimpleName is {@code Local Name}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}
   */
  @Test
  @DisplayName("Test findRootName(AnnotatedClass); then return SimpleName is 'Local Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findRootName(AnnotatedClass)"})
  void testFindRootName_thenReturnSimpleNameIsLocalName() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    RosettaDataType rosettaDataType = mock(RosettaDataType.class);
    when(rosettaDataType.value()).thenReturn("42");

    JacksonXmlRootElement jacksonXmlRootElement = mock(JacksonXmlRootElement.class);
    when(jacksonXmlRootElement.localName()).thenReturn("Local Name");
    when(jacksonXmlRootElement.namespace()).thenReturn("Namespace");

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getType()).thenReturn(new PlaceholderForType(1));
    when(ac.getAnnotation(RosettaDataType.class)).thenReturn(rosettaDataType);
    when(ac.getAnnotation(JacksonXmlRootElement.class)).thenReturn(jacksonXmlRootElement);
    when(ac.getAnnotation(JsonRootName.class)).thenReturn(mock(JsonRootName.class));

    // Act
    PropertyName actualFindRootNameResult = rosettaXMLAnnotationIntrospector.findRootName(ac);

    // Assert
    verify(ac, atLeast(1)).getAnnotation(Mockito.<Class<Annotation>>any());
    verify(ac, atLeast(1)).getType();
    verify(jacksonXmlRootElement).localName();
    verify(jacksonXmlRootElement).namespace();
    verify(rosettaDataType).value();
    assertEquals("Local Name", actualFindRootNameResult.getSimpleName());
    assertEquals("Namespace", actualFindRootNameResult.getNamespace());
    assertTrue(actualFindRootNameResult.hasNamespace());
    assertTrue(actualFindRootNameResult.hasSimpleName());
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}.
   *
   * <ul>
   *   <li>When {@link AnnotatedClass} {@link AnnotatedClass#getAnnotation(Class)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findRootName(AnnotatedClass); when AnnotatedClass getAnnotation(Class) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findRootName(AnnotatedClass)"})
  void testFindRootName_whenAnnotatedClassGetAnnotationThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getAnnotation(RosettaDataType.class)).thenThrow(new RuntimeException());
    when(ac.getAnnotation(JacksonXmlRootElement.class)).thenThrow(new RuntimeException());
    when(ac.getAnnotation(JsonRootName.class)).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> rosettaXMLAnnotationIntrospector.findRootName(ac));
    verify(ac).getAnnotation(isA(Class.class));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}.
   *
   * <ul>
   *   <li>When {@link AnnotatedClass} {@link AnnotatedClass#getType()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findRootName(AnnotatedClass); when AnnotatedClass getType() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findRootName(AnnotatedClass)"})
  void testFindRootName_whenAnnotatedClassGetTypeThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    RosettaDataType rosettaDataType = mock(RosettaDataType.class);
    when(rosettaDataType.value()).thenReturn("42");

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getType()).thenThrow(new RuntimeException());
    when(ac.getAnnotation(RosettaDataType.class)).thenReturn(rosettaDataType);
    when(ac.getAnnotation(JacksonXmlRootElement.class))
        .thenReturn(mock(JacksonXmlRootElement.class));
    when(ac.getAnnotation(JsonRootName.class)).thenReturn(mock(JsonRootName.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> rosettaXMLAnnotationIntrospector.findRootName(ac));
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac).getType();
    verify(rosettaDataType).value();
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}.
   *
   * <ul>
   *   <li>Given {@link RosettaAttribute} {@link RosettaAttribute#value()} return {@code 42}.
   *   <li>Then return SimpleName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}
   */
  @Test
  @DisplayName(
      "Test _findXmlName(Annotated); given RosettaAttribute value() return '42'; then return SimpleName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector._findXmlName(Annotated)"})
  void test_findXmlName_givenRosettaAttributeValueReturn42_thenReturnSimpleNameIs42() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    RosettaAttribute rosettaAttribute = mock(RosettaAttribute.class);
    when(rosettaAttribute.value()).thenReturn("42");

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.getAnnotation(RosettaAttribute.class)).thenReturn(rosettaAttribute);
    when(a.getAnnotation(JacksonXmlProperty.class)).thenReturn(mock(JacksonXmlProperty.class));
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(a.getRawType()).thenReturn(forNameResult);

    // Act
    PropertyName actual_findXmlNameResult = rosettaXMLAnnotationIntrospector._findXmlName(a);

    // Assert
    verify(a).getAnnotation(isA(Class.class));
    verify(a).getRawType();
    verify(rosettaAttribute).value();
    assertEquals("42", actual_findXmlNameResult.getSimpleName());
    assertNull(actual_findXmlNameResult.getNamespace());
    assertFalse(actual_findXmlNameResult.hasNamespace());
    assertFalse(actual_findXmlNameResult.isEmpty());
    assertTrue(actual_findXmlNameResult.hasSimpleName());
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}.
   *
   * <ul>
   *   <li>Given {@link RosettaAttribute} {@link RosettaAttribute#value()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}
   */
  @Test
  @DisplayName(
      "Test _findXmlName(Annotated); given RosettaAttribute value() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector._findXmlName(Annotated)"})
  void test_findXmlName_givenRosettaAttributeValueThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    RosettaAttribute rosettaAttribute = mock(RosettaAttribute.class);
    when(rosettaAttribute.value()).thenThrow(new RuntimeException());

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.getAnnotation(RosettaAttribute.class)).thenReturn(rosettaAttribute);
    when(a.getAnnotation(JacksonXmlProperty.class)).thenReturn(mock(JacksonXmlProperty.class));
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(a.getRawType()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> rosettaXMLAnnotationIntrospector._findXmlName(a));
    verify(a).getAnnotation(isA(Class.class));
    verify(a).getRawType();
    verify(rosettaAttribute).value();
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}
   */
  @Test
  @DisplayName("Test _findXmlName(Annotated); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector._findXmlName(Annotated)"})
  void test_findXmlName_givenRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.getAnnotation(RosettaAttribute.class)).thenThrow(new RuntimeException());
    when(a.getAnnotation(JacksonXmlProperty.class)).thenThrow(new RuntimeException());
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(a.getRawType()).thenReturn(forNameResult);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> rosettaXMLAnnotationIntrospector._findXmlName(a));
    verify(a).getAnnotation(isA(Class.class));
    verify(a).getRawType();
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}.
   *
   * <ul>
   *   <li>Then return {@link PropertyName#USE_DEFAULT}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}
   */
  @Test
  @DisplayName("Test _findXmlName(Annotated); then return USE_DEFAULT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector._findXmlName(Annotated)"})
  void test_findXmlName_thenReturnUse_default() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    RosettaAttribute rosettaAttribute = mock(RosettaAttribute.class);
    when(rosettaAttribute.value()).thenReturn("");

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.getAnnotation(RosettaAttribute.class)).thenReturn(rosettaAttribute);
    when(a.getAnnotation(JacksonXmlProperty.class)).thenReturn(mock(JacksonXmlProperty.class));
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(a.getRawType()).thenReturn(forNameResult);

    // Act
    PropertyName actual_findXmlNameResult = rosettaXMLAnnotationIntrospector._findXmlName(a);

    // Assert
    verify(a).getAnnotation(isA(Class.class));
    verify(a).getRawType();
    verify(rosettaAttribute).value();
    assertSame(PropertyName.USE_DEFAULT, actual_findXmlNameResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}.
   *
   * <ul>
   *   <li>When {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}
   */
  @Test
  @DisplayName(
      "Test _findXmlName(Annotated); when PlaceholderForType(int) with ordinal is one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector._findXmlName(Annotated)"})
  void test_findXmlName_whenPlaceholderForTypeWithOrdinalIsOne_thenReturnNull() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute a =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act
    PropertyName actual_findXmlNameResult = rosettaXMLAnnotationIntrospector._findXmlName(a);

    // Assert
    assertNull(actual_findXmlNameResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#_isIgnorable(Annotated)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#_isIgnorable(Annotated)}
   */
  @Test
  @DisplayName("Test _isIgnorable(Annotated); when 'java.lang.Object'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RosettaXMLAnnotationIntrospector._isIgnorable(Annotated)"})
  void test_isIgnorable_whenJavaLangObject_thenReturnTrue() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute a =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act
    boolean actual_isIgnorableResult = rosettaXMLAnnotationIntrospector._isIgnorable(a);

    // Assert
    assertTrue(actual_isIgnorableResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}.
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}
   */
  @Test
  @DisplayName("Test findWrapperName(Annotated)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findWrapperName(Annotated)"})
  void testFindWrapperName() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    JacksonXmlElementWrapper jacksonXmlElementWrapper = mock(JacksonXmlElementWrapper.class);
    when(jacksonXmlElementWrapper.useWrapping()).thenThrow(new RuntimeException());

    AnnotatedClass ann = mock(AnnotatedClass.class);
    when(ann.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(true);
    when(ann.getAnnotation(JacksonXmlElementWrapper.class)).thenReturn(jacksonXmlElementWrapper);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> rosettaXMLAnnotationIntrospector.findWrapperName(ann));
    verify(ann).getAnnotation(isA(Class.class));
    verify(ann).hasAnnotation(isA(Class.class));
    verify(jacksonXmlElementWrapper).useWrapping();
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}.
   *
   * <ul>
   *   <li>Given {@link JacksonXmlElementWrapper} {@link JacksonXmlElementWrapper#localName()}
   *       return empty string.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}
   */
  @Test
  @DisplayName(
      "Test findWrapperName(Annotated); given JacksonXmlElementWrapper localName() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findWrapperName(Annotated)"})
  void testFindWrapperName_givenJacksonXmlElementWrapperLocalNameReturnEmptyString() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    JacksonXmlElementWrapper jacksonXmlElementWrapper = mock(JacksonXmlElementWrapper.class);
    when(jacksonXmlElementWrapper.localName()).thenReturn("");
    when(jacksonXmlElementWrapper.useWrapping()).thenReturn(true);

    AnnotatedClass ann = mock(AnnotatedClass.class);
    when(ann.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(true);
    when(ann.getAnnotation(JacksonXmlElementWrapper.class)).thenReturn(jacksonXmlElementWrapper);

    // Act
    PropertyName actualFindWrapperNameResult =
        rosettaXMLAnnotationIntrospector.findWrapperName(ann);

    // Assert
    verify(ann).getAnnotation(isA(Class.class));
    verify(ann).hasAnnotation(isA(Class.class));
    verify(jacksonXmlElementWrapper).localName();
    verify(jacksonXmlElementWrapper).useWrapping();
    assertSame(PropertyName.USE_DEFAULT, actualFindWrapperNameResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}.
   *
   * <ul>
   *   <li>Given {@link JacksonXmlElementWrapper} {@link JacksonXmlElementWrapper#localName()} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}
   */
  @Test
  @DisplayName(
      "Test findWrapperName(Annotated); given JacksonXmlElementWrapper localName() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findWrapperName(Annotated)"})
  void testFindWrapperName_givenJacksonXmlElementWrapperLocalNameThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    JacksonXmlElementWrapper jacksonXmlElementWrapper = mock(JacksonXmlElementWrapper.class);
    when(jacksonXmlElementWrapper.localName()).thenThrow(new RuntimeException());
    when(jacksonXmlElementWrapper.useWrapping()).thenReturn(true);

    AnnotatedClass ann = mock(AnnotatedClass.class);
    when(ann.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(true);
    when(ann.getAnnotation(JacksonXmlElementWrapper.class)).thenReturn(jacksonXmlElementWrapper);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> rosettaXMLAnnotationIntrospector.findWrapperName(ann));
    verify(ann).getAnnotation(isA(Class.class));
    verify(ann).hasAnnotation(isA(Class.class));
    verify(jacksonXmlElementWrapper).localName();
    verify(jacksonXmlElementWrapper).useWrapping();
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}.
   *
   * <ul>
   *   <li>Given {@link JacksonXmlElementWrapper} {@link JacksonXmlElementWrapper#namespace()} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}
   */
  @Test
  @DisplayName(
      "Test findWrapperName(Annotated); given JacksonXmlElementWrapper namespace() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findWrapperName(Annotated)"})
  void testFindWrapperName_givenJacksonXmlElementWrapperNamespaceThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    JacksonXmlElementWrapper jacksonXmlElementWrapper = mock(JacksonXmlElementWrapper.class);
    when(jacksonXmlElementWrapper.namespace()).thenThrow(new RuntimeException());
    when(jacksonXmlElementWrapper.localName()).thenReturn("Local Name");
    when(jacksonXmlElementWrapper.useWrapping()).thenReturn(true);

    AnnotatedClass ann = mock(AnnotatedClass.class);
    when(ann.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(true);
    when(ann.getAnnotation(JacksonXmlElementWrapper.class)).thenReturn(jacksonXmlElementWrapper);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> rosettaXMLAnnotationIntrospector.findWrapperName(ann));
    verify(ann).getAnnotation(isA(Class.class));
    verify(ann).hasAnnotation(isA(Class.class));
    verify(jacksonXmlElementWrapper, atLeast(1)).localName();
    verify(jacksonXmlElementWrapper).namespace();
    verify(jacksonXmlElementWrapper).useWrapping();
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}
   */
  @Test
  @DisplayName("Test findWrapperName(Annotated); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findWrapperName(Annotated)"})
  void testFindWrapperName_givenRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    AnnotatedClass ann = mock(AnnotatedClass.class);
    when(ann.hasAnnotation(Mockito.<Class<?>>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> rosettaXMLAnnotationIntrospector.findWrapperName(ann));
    verify(ann).hasAnnotation(isA(Class.class));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}.
   *
   * <ul>
   *   <li>Then return {@link PropertyName#NO_NAME}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}
   */
  @Test
  @DisplayName("Test findWrapperName(Annotated); then return NO_NAME")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findWrapperName(Annotated)"})
  void testFindWrapperName_thenReturnNo_name() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    JacksonXmlElementWrapper jacksonXmlElementWrapper = mock(JacksonXmlElementWrapper.class);
    when(jacksonXmlElementWrapper.useWrapping()).thenReturn(false);

    AnnotatedClass ann = mock(AnnotatedClass.class);
    when(ann.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(true);
    when(ann.getAnnotation(JacksonXmlElementWrapper.class)).thenReturn(jacksonXmlElementWrapper);

    // Act
    PropertyName actualFindWrapperNameResult =
        rosettaXMLAnnotationIntrospector.findWrapperName(ann);

    // Assert
    verify(ann).getAnnotation(isA(Class.class));
    verify(ann).hasAnnotation(isA(Class.class));
    verify(jacksonXmlElementWrapper).useWrapping();
    assertSame(PropertyName.NO_NAME, actualFindWrapperNameResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}.
   *
   * <ul>
   *   <li>Then return SimpleName is {@code Local Name}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}
   */
  @Test
  @DisplayName("Test findWrapperName(Annotated); then return SimpleName is 'Local Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findWrapperName(Annotated)"})
  void testFindWrapperName_thenReturnSimpleNameIsLocalName() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    JacksonXmlElementWrapper jacksonXmlElementWrapper = mock(JacksonXmlElementWrapper.class);
    when(jacksonXmlElementWrapper.namespace()).thenReturn("Namespace");
    when(jacksonXmlElementWrapper.localName()).thenReturn("Local Name");
    when(jacksonXmlElementWrapper.useWrapping()).thenReturn(true);

    AnnotatedClass ann = mock(AnnotatedClass.class);
    when(ann.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(true);
    when(ann.getAnnotation(JacksonXmlElementWrapper.class)).thenReturn(jacksonXmlElementWrapper);

    // Act
    PropertyName actualFindWrapperNameResult =
        rosettaXMLAnnotationIntrospector.findWrapperName(ann);

    // Assert
    verify(ann).getAnnotation(isA(Class.class));
    verify(ann).hasAnnotation(isA(Class.class));
    verify(jacksonXmlElementWrapper, atLeast(1)).localName();
    verify(jacksonXmlElementWrapper).namespace();
    verify(jacksonXmlElementWrapper).useWrapping();
    assertEquals("Local Name", actualFindWrapperNameResult.getSimpleName());
    assertEquals("Namespace", actualFindWrapperNameResult.getNamespace());
    assertFalse(actualFindWrapperNameResult.isEmpty());
    assertTrue(actualFindWrapperNameResult.hasNamespace());
    assertTrue(actualFindWrapperNameResult.hasSimpleName());
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@link PropertyName#USE_DEFAULT}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}
   */
  @Test
  @DisplayName("Test findWrapperName(Annotated); when 'java.lang.Object'; then return USE_DEFAULT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findWrapperName(Annotated)"})
  void testFindWrapperName_whenJavaLangObject_thenReturnUse_default() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute ann =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act
    PropertyName actualFindWrapperNameResult =
        rosettaXMLAnnotationIntrospector.findWrapperName(ann);

    // Assert
    assertSame(PropertyName.USE_DEFAULT, actualFindWrapperNameResult);
  }
}
