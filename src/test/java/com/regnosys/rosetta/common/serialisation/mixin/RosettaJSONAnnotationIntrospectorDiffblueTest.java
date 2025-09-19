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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties.Value;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator.Builder;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.regnosys.rosetta.common.serialisation.mixin.legacy.LegacyRosettaBuilderIntrospector;
import com.regnosys.rosetta.common.serialisation.xml.VirtualXMLAttribute;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaEnum;
import java.lang.Character.UnicodeScript;
import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;
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
    // Arrange, Act and Assert
    Version versionResult = new RosettaJSONAnnotationIntrospector(false).version();
    assertEquals("", versionResult.getArtifactId());
    assertEquals("", versionResult.getGroupId());
    assertEquals("//0.0.0", versionResult.toFullString());
    assertEquals(0, versionResult.getMajorVersion());
    assertEquals(0, versionResult.getMinorVersion());
    assertEquals(0, versionResult.getPatchLevel());
    assertFalse(versionResult.isSnapshot());
    assertTrue(versionResult.isUknownVersion());
    assertTrue(versionResult.isUnknownVersion());
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
    // Arrange, Act and Assert
    Version versionResult = new RosettaJSONAnnotationIntrospector(true).version();
    assertEquals("", versionResult.getArtifactId());
    assertEquals("", versionResult.getGroupId());
    assertEquals("//0.0.0", versionResult.toFullString());
    assertEquals(0, versionResult.getMajorVersion());
    assertEquals(0, versionResult.getMinorVersion());
    assertEquals(0, versionResult.getPatchLevel());
    assertFalse(versionResult.isSnapshot());
    assertTrue(versionResult.isUknownVersion());
    assertTrue(versionResult.isUnknownVersion());
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONAnnotationIntrospector#findPOJOBuilder(AnnotatedClass)}
   */
  @Test
  @DisplayName("Test findPOJOBuilder(AnnotatedClass); given 'java.lang.Object'; then return Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class RosettaJSONAnnotationIntrospector.findPOJOBuilder(AnnotatedClass)"})
  void testFindPOJOBuilder_givenJavaLangObject_thenReturnObject() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    JsonDeserialize jsonDeserialize = mock(JsonDeserialize.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(jsonDeserialize.builder()).thenReturn(forNameResult);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(ac.getType()).thenReturn(null);
    when(ac.getAnnotation(Mockito.<Class<JsonDeserialize>>any())).thenReturn(jsonDeserialize);

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

    JsonDeserialize jsonDeserialize = mock(JsonDeserialize.class);
    Mockito.<Class<?>>when(jsonDeserialize.builder()).thenReturn(null);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(ac.getType()).thenReturn(null);
    when(ac.getAnnotation(Mockito.<Class<JsonDeserialize>>any())).thenReturn(jsonDeserialize);

    // Act
    Class<?> actualFindPOJOBuilderResult = rosettaJSONAnnotationIntrospector.findPOJOBuilder(ac);

    // Assert
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

    JsonDeserialize jsonDeserialize = mock(JsonDeserialize.class);
    Mockito.<Class<?>>when(jsonDeserialize.builder()).thenReturn(Void.TYPE);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(ac.getType()).thenReturn(null);
    when(ac.getAnnotation(Mockito.<Class<JsonDeserialize>>any())).thenReturn(jsonDeserialize);

    // Act
    Class<?> actualFindPOJOBuilderResult = rosettaJSONAnnotationIntrospector.findPOJOBuilder(ac);

    // Assert
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
    when(ac.getAnnotation(Mockito.<Class<JsonDeserialize>>any())).thenReturn(jsonDeserialize);

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
   * Test {@link RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}.
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}
   */
  @Test
  @DisplayName("Test findNameForSerialization(Annotated)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyName RosettaJSONAnnotationIntrospector.findNameForSerialization(Annotated)"
  })
  void testFindNameForSerialization() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);
    PlaceholderForType type = new PlaceholderForType(1);
    TypeResolutionContext typeContext = mock(TypeResolutionContext.class);

    AnnotatedParameter a = new AnnotatedParameter(null, type, typeContext, new AnnotationMap(), 1);

    // Act
    PropertyName actualFindNameForSerializationResult =
        rosettaJSONAnnotationIntrospector.findNameForSerialization(a);

    // Assert
    assertNull(actualFindNameForSerializationResult);
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@link PropertyName#USE_DEFAULT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}
   */
  @Test
  @DisplayName("Test findNameForSerialization(Annotated); given 'false'; then return USE_DEFAULT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PropertyName RosettaJSONAnnotationIntrospector.findNameForSerialization(Annotated)"
  })
  void testFindNameForSerialization_givenFalse_thenReturnUse_default() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(a.hasOneOf(Mockito.<Class<Annotation>[]>any())).thenReturn(true);
    when(a.getAnnotation(Mockito.<Class<Annotation>>any())).thenReturn(null);

    // Act
    PropertyName actualFindNameForSerializationResult =
        rosettaJSONAnnotationIntrospector.findNameForSerialization(a);

    // Assert
    verify(a, atLeast(1)).getAnnotation(Mockito.<Class<Annotation>>any());
    verify(a).hasAnnotation(isA(Class.class));
    verify(a).hasOneOf(isA(Class[].class));
    assertSame(PropertyName.USE_DEFAULT, actualFindNameForSerializationResult);
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
    when(a.getAnnotation(Mockito.<Class<RosettaAttribute>>any())).thenReturn(rosettaAttribute);
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
   * Test {@link RosettaJSONAnnotationIntrospector#findEnumValues(MapperConfig, AnnotatedClass,
   * Enum[], String[])} with {@code config}, {@code enumType}, {@code enumValues}, {@code names}.
   *
   * <p>Method under test: {@link RosettaJSONAnnotationIntrospector#findEnumValues(MapperConfig,
   * AnnotatedClass, Object[], String[])}
   */
  @Test
  @DisplayName(
      "Test findEnumValues(MapperConfig, AnnotatedClass, Enum[], String[]) with 'config', 'enumType', 'enumValues', 'names'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String[] RosettaJSONAnnotationIntrospector.findEnumValues(MapperConfig, AnnotatedClass, Enum[], String[])"
  })
  void testFindEnumValuesWithConfigEnumTypeEnumValuesNames() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    BaseSettings base2 = mock(BaseSettings.class);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig overrides =
        new SerializationConfig(base2, str2, mixins, rootNames, new ConfigOverrides());
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(overrides);
    RootNameLookup rootNames2 = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config =
        new DeserializationConfig(
            base,
            str,
            mixins2,
            rootNames2,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));

    AnnotatedClass enumType = mock(AnnotatedClass.class);
    when(enumType.fields()).thenReturn(new ArrayList<>());
    when(enumType.getAnnotation(Mockito.<Class<RosettaEnum>>any()))
        .thenReturn(mock(RosettaEnum.class));
    String[] names = new String[] {"Names"};

    // Act
    String[] actualFindEnumValuesResult =
        rosettaJSONAnnotationIntrospector.findEnumValues(
            config, enumType, new Enum[] {UnicodeScript.of(1)}, names);

    // Assert
    verify(enumType).fields();
    verify(enumType).getAnnotation(isA(Class.class));
    assertSame(names, actualFindEnumValuesResult);
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findEnumAliases(MapperConfig, AnnotatedClass,
   * Enum[], String[][])} with {@code config}, {@code enumType}, {@code enumValues}, {@code
   * aliasList}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotatedClass#fields()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONAnnotationIntrospector#findEnumAliases(MapperConfig,
   * AnnotatedClass, Object[], String[][])}
   */
  @Test
  @DisplayName(
      "Test findEnumAliases(MapperConfig, AnnotatedClass, Enum[], String[][]) with 'config', 'enumType', 'enumValues', 'aliasList'; then calls fields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaJSONAnnotationIntrospector.findEnumAliases(MapperConfig, AnnotatedClass, Enum[], String[][])"
  })
  void testFindEnumAliasesWithConfigEnumTypeEnumValuesAliasList_thenCallsFields() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    BaseSettings base2 = mock(BaseSettings.class);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig overrides =
        new SerializationConfig(base2, str2, mixins, rootNames, new ConfigOverrides());
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(overrides);
    RootNameLookup rootNames2 = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config =
        new DeserializationConfig(
            base,
            str,
            mixins2,
            rootNames2,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));

    AnnotatedClass enumType = mock(AnnotatedClass.class);
    when(enumType.fields()).thenReturn(new ArrayList<>());
    when(enumType.getAnnotation(Mockito.<Class<RosettaEnum>>any()))
        .thenReturn(mock(RosettaEnum.class));

    // Act
    rosettaJSONAnnotationIntrospector.findEnumAliases(
        config,
        enumType,
        new Enum[] {UnicodeScript.of(1)},
        new String[][] {new String[] {"Alias List"}});

    // Assert
    verify(enumType).fields();
    verify(enumType).getAnnotation(isA(Class.class));
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig,
   * Annotated)}.
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig, Annotated)}
   */
  @Test
  @DisplayName("Test findPropertyIgnoralByName(MapperConfig, Annotated)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value RosettaJSONAnnotationIntrospector.findPropertyIgnoralByName(MapperConfig, Annotated)"
  })
  void testFindPropertyIgnoralByName() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector =
        new LegacyRosettaBuilderIntrospector();
    EnumAsStringBuilderIntrospector enumAsStringBuilderIntrospector =
        new EnumAsStringBuilderIntrospector();

    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(
            legacyRosettaBuilderIntrospector,
            enumAsStringBuilderIntrospector,
            new RosettaEnumBuilderIntrospector(true));
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    BaseSettings base2 = mock(BaseSettings.class);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig overrides =
        new SerializationConfig(base2, str2, mixins, rootNames, new ConfigOverrides());
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(overrides);
    RootNameLookup rootNames2 = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config =
        new DeserializationConfig(
            base,
            str,
            mixins2,
            rootNames2,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute ann =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act
    Value actualFindPropertyIgnoralByNameResult =
        rosettaJSONAnnotationIntrospector.findPropertyIgnoralByName(config, ann);

    // Assert
    assertFalse(actualFindPropertyIgnoralByNameResult.getAllowGetters());
    assertFalse(actualFindPropertyIgnoralByNameResult.getAllowSetters());
    assertFalse(actualFindPropertyIgnoralByNameResult.getIgnoreUnknown());
    assertTrue(actualFindPropertyIgnoralByNameResult.getMerge());
    assertTrue(actualFindPropertyIgnoralByNameResult.getIgnored().isEmpty());
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig,
   * Annotated)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then calls {@link AnnotatedClass#getRawType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig, Annotated)}
   */
  @Test
  @DisplayName(
      "Test findPropertyIgnoralByName(MapperConfig, Annotated); given 'java.lang.Object'; then calls getRawType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value RosettaJSONAnnotationIntrospector.findPropertyIgnoralByName(MapperConfig, Annotated)"
  })
  void testFindPropertyIgnoralByName_givenJavaLangObject_thenCallsGetRawType() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    BaseSettings base2 = mock(BaseSettings.class);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig overrides =
        new SerializationConfig(base2, str2, mixins, rootNames, new ConfigOverrides());
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(overrides);
    RootNameLookup rootNames2 = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config =
        new DeserializationConfig(
            base,
            str,
            mixins2,
            rootNames2,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));

    AnnotatedClass ann = mock(AnnotatedClass.class);
    when(ann.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(ann.getRawType()).thenReturn(forNameResult);

    // Act
    Value actualFindPropertyIgnoralByNameResult =
        rosettaJSONAnnotationIntrospector.findPropertyIgnoralByName(config, ann);

    // Assert
    verify(ann).getRawType();
    verify(ann).hasAnnotation(isA(Class.class));
    assertFalse(actualFindPropertyIgnoralByNameResult.getAllowGetters());
    assertFalse(actualFindPropertyIgnoralByNameResult.getIgnoreUnknown());
    assertTrue(actualFindPropertyIgnoralByNameResult.getAllowSetters());
    assertTrue(actualFindPropertyIgnoralByNameResult.getMerge());
    assertTrue(actualFindPropertyIgnoralByNameResult.getIgnored().isEmpty());
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig,
   * Annotated)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link AnnotatedClass#memberMethods()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig, Annotated)}
   */
  @Test
  @DisplayName(
      "Test findPropertyIgnoralByName(MapperConfig, Annotated); given 'true'; then calls memberMethods()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value RosettaJSONAnnotationIntrospector.findPropertyIgnoralByName(MapperConfig, Annotated)"
  })
  void testFindPropertyIgnoralByName_givenTrue_thenCallsMemberMethods() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    BaseSettings base2 = mock(BaseSettings.class);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig overrides =
        new SerializationConfig(base2, str2, mixins, rootNames, new ConfigOverrides());
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(overrides);
    RootNameLookup rootNames2 = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config =
        new DeserializationConfig(
            base,
            str,
            mixins2,
            rootNames2,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));

    AnnotatedClass ann = mock(AnnotatedClass.class);
    when(ann.memberMethods()).thenReturn(new ArrayList<>());
    when(ann.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(true);

    // Act
    Value actualFindPropertyIgnoralByNameResult =
        rosettaJSONAnnotationIntrospector.findPropertyIgnoralByName(config, ann);

    // Assert
    verify(ann).hasAnnotation(isA(Class.class));
    verify(ann, atLeast(1)).memberMethods();
    assertFalse(actualFindPropertyIgnoralByNameResult.getAllowGetters());
    assertFalse(actualFindPropertyIgnoralByNameResult.getIgnoreUnknown());
    assertTrue(actualFindPropertyIgnoralByNameResult.getAllowSetters());
    assertTrue(actualFindPropertyIgnoralByNameResult.getMerge());
    assertTrue(actualFindPropertyIgnoralByNameResult.getIgnored().isEmpty());
  }

  /**
   * Test {@link RosettaJSONAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig,
   * Annotated)}.
   *
   * <ul>
   *   <li>Then return not AllowSetters.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaJSONAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig, Annotated)}
   */
  @Test
  @DisplayName(
      "Test findPropertyIgnoralByName(MapperConfig, Annotated); then return not AllowSetters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value RosettaJSONAnnotationIntrospector.findPropertyIgnoralByName(MapperConfig, Annotated)"
  })
  void testFindPropertyIgnoralByName_thenReturnNotAllowSetters() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector =
        new RosettaJSONAnnotationIntrospector(true);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    BaseSettings base2 = mock(BaseSettings.class);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig overrides =
        new SerializationConfig(base2, str2, mixins, rootNames, new ConfigOverrides());
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(overrides);
    RootNameLookup rootNames2 = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config =
        new DeserializationConfig(
            base,
            str,
            mixins2,
            rootNames2,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute ann =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act
    Value actualFindPropertyIgnoralByNameResult =
        rosettaJSONAnnotationIntrospector.findPropertyIgnoralByName(config, ann);

    // Assert
    assertFalse(actualFindPropertyIgnoralByNameResult.getAllowGetters());
    assertFalse(actualFindPropertyIgnoralByNameResult.getAllowSetters());
    assertFalse(actualFindPropertyIgnoralByNameResult.getIgnoreUnknown());
    assertTrue(actualFindPropertyIgnoralByNameResult.getMerge());
    assertTrue(actualFindPropertyIgnoralByNameResult.getIgnored().isEmpty());
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
  @MethodsUnderTest({"Value RosettaJSONAnnotationIntrospector.findPropertyIgnorals(Annotated)"})
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
  @MethodsUnderTest({"Value RosettaJSONAnnotationIntrospector.findPropertyIgnorals(Annotated)"})
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
  @MethodsUnderTest({"Value RosettaJSONAnnotationIntrospector.findPropertyIgnorals(Annotated)"})
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
