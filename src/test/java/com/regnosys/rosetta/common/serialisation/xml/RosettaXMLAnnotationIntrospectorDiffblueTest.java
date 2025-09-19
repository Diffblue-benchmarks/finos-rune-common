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
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator.Builder;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.regnosys.rosetta.common.serialisation.mixin.EnumAsStringBuilderIntrospector;
import com.regnosys.rosetta.common.serialisation.mixin.RosettaEnumBuilderIntrospector;
import com.rosetta.model.lib.ModelSymbolId;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RosettaEnum;
import com.rosetta.util.serialisation.AttributeXMLConfiguration;
import com.rosetta.util.serialisation.RosettaXMLConfiguration;
import com.rosetta.util.serialisation.TypeXMLConfiguration;
import java.lang.Character.UnicodeScript;
import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;
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
   * Test {@link RosettaXMLAnnotationIntrospector#findSubstitutionMap(MapperConfig,
   * AnnotatedMember)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findSubstitutionMap(MapperConfig,
   * AnnotatedMember)}
   */
  @Test
  @DisplayName(
      "Test findSubstitutionMap(MapperConfig, AnnotatedMember); given 'java.lang.Object'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SubstitutionMap RosettaXMLAnnotationIntrospector.findSubstitutionMap(MapperConfig, AnnotatedMember)"
  })
  void testFindSubstitutionMap_givenJavaLangObject_thenReturnNull() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(mixins.findMixInClassFor(Mockito.<Class<?>>any()))
        .thenReturn(forNameResult);
    BaseSettings base = mock(BaseSettings.class);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig overrides =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(overrides);
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

    BaseSettings base2 =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    RootNameLookup rootNames2 = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config =
        new DeserializationConfig(
            base2,
            str2,
            mixins2,
            rootNames2,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act
    SubstitutionMap actualFindSubstitutionMapResult =
        rosettaXMLAnnotationIntrospector.findSubstitutionMap(config, member);

    // Assert
    verify(mixins, atLeast(1)).findMixInClassFor(isA(Class.class));
    assertNull(actualFindSubstitutionMapResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findSubstitutionMap(MapperConfig,
   * AnnotatedMember)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findSubstitutionMap(MapperConfig,
   * AnnotatedMember)}
   */
  @Test
  @DisplayName(
      "Test findSubstitutionMap(MapperConfig, AnnotatedMember); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SubstitutionMap RosettaXMLAnnotationIntrospector.findSubstitutionMap(MapperConfig, AnnotatedMember)"
  })
  void testFindSubstitutionMap_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    Mockito.<Class<?>>when(mixins.findMixInClassFor(Mockito.<Class<?>>any()))
        .thenThrow(new RuntimeException());
    BaseSettings base = mock(BaseSettings.class);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig overrides =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(overrides);
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

    BaseSettings base2 =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    RootNameLookup rootNames2 = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config =
        new DeserializationConfig(
            base2,
            str2,
            mixins2,
            rootNames2,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> rosettaXMLAnnotationIntrospector.findSubstitutionMap(config, member));
    verify(mixins).findMixInClassFor(isA(Class.class));
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
    when(ac.getAnnotation(Mockito.<Class<JsonDeserialize>>any())).thenReturn(jsonDeserialize);

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
    when(ac.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(false);
    when(ac.getAnnotation(Mockito.<Class<JsonDeserialize>>any())).thenReturn(jsonDeserialize);

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
    when(ac.getAnnotation(Mockito.<Class<JsonDeserialize>>any())).thenReturn(jsonDeserialize);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> rosettaXMLAnnotationIntrospector.findPOJOBuilder(ac));
    verify(jsonDeserialize).builder();
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac).hasAnnotation(isA(Class.class));
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
    "JsonPOJOBuilder.Value RosettaXMLAnnotationIntrospector.findPOJOBuilderConfig(AnnotatedClass)"
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
    when(ac.getAnnotation(Mockito.<Class<JsonPOJOBuilder>>any())).thenReturn(jsonPOJOBuilder);

    // Act
    JsonPOJOBuilder.Value actualFindPOJOBuilderConfigResult =
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
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}
   */
  @Test
  @DisplayName("Test findRootName(AnnotatedClass); given 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findRootName(AnnotatedClass)"})
  void testFindRootName_givenNull_thenReturnNull() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getAnnotation(Mockito.<Class<Annotation>>any())).thenReturn(null);

    // Act
    PropertyName actualFindRootNameResult = rosettaXMLAnnotationIntrospector.findRootName(ac);

    // Assert
    verify(ac, atLeast(1)).getAnnotation(Mockito.<Class<Annotation>>any());
    assertNull(actualFindRootNameResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findRootName(AnnotatedClass)}
   */
  @Test
  @DisplayName(
      "Test findRootName(AnnotatedClass); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findRootName(AnnotatedClass)"})
  void testFindRootName_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getAnnotation(Mockito.<Class<Annotation>>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> rosettaXMLAnnotationIntrospector.findRootName(ac));
    verify(ac).getAnnotation(isA(Class.class));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>When {@link AnnotatedClass} {@link AnnotatedClass#getRawType()} return {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}
   */
  @Test
  @DisplayName(
      "Test _findXmlName(Annotated); given 'java.lang.Object'; when AnnotatedClass getRawType() return Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector._findXmlName(Annotated)"})
  void test_findXmlName_givenJavaLangObject_whenAnnotatedClassGetRawTypeReturnObject() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.getAnnotation(Mockito.<Class<Annotation>>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(a.getRawType()).thenReturn(forNameResult);

    // Act
    PropertyName actual_findXmlNameResult = rosettaXMLAnnotationIntrospector._findXmlName(a);

    // Assert
    verify(a, atLeast(1)).getAnnotation(Mockito.<Class<Annotation>>any());
    verify(a).getRawType();
    assertNull(actual_findXmlNameResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}.
   *
   * <ul>
   *   <li>Given {@code List}.
   *   <li>When {@link AnnotatedClass} {@link AnnotatedClass#getRawType()} return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}
   */
  @Test
  @DisplayName(
      "Test _findXmlName(Annotated); given 'java.util.List'; when AnnotatedClass getRawType() return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector._findXmlName(Annotated)"})
  void test_findXmlName_givenJavaUtilList_whenAnnotatedClassGetRawTypeReturnList() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.getAnnotation(Mockito.<Class<Annotation>>any())).thenReturn(null);
    Class<List> forNameResult = List.class;
    Mockito.<Class<?>>when(a.getRawType()).thenReturn(forNameResult);

    // Act
    PropertyName actual_findXmlNameResult = rosettaXMLAnnotationIntrospector._findXmlName(a);

    // Assert
    verify(a, atLeast(1)).getAnnotation(Mockito.<Class<Annotation>>any());
    verify(a).getRawType();
    assertNull(actual_findXmlNameResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}
   */
  @Test
  @DisplayName(
      "Test _findXmlName(Annotated); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector._findXmlName(Annotated)"})
  void test_findXmlName_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.getAnnotation(Mockito.<Class<Annotation>>any())).thenThrow(new RuntimeException());
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
   * Test {@link RosettaXMLAnnotationIntrospector#findAndAddVirtualProperties(MapperConfig,
   * AnnotatedClass, List)}.
   *
   * <p>Method under test: {@link
   * RosettaXMLAnnotationIntrospector#findAndAddVirtualProperties(MapperConfig, AnnotatedClass,
   * List)}
   */
  @Test
  @DisplayName("Test findAndAddVirtualProperties(MapperConfig, AnnotatedClass, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaXMLAnnotationIntrospector.findAndAddVirtualProperties(MapperConfig, AnnotatedClass, List)"
  })
  void testFindAndAddVirtualProperties() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
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

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getAnnotation(Mockito.<Class<RosettaDataType>>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            rosettaXMLAnnotationIntrospector.findAndAddVirtualProperties(
                config, ac, new ArrayList<>()));
    verify(ac).getAnnotation(isA(Class.class));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findAndAddVirtualProperties(MapperConfig,
   * AnnotatedClass, List)}.
   *
   * <p>Method under test: {@link
   * RosettaXMLAnnotationIntrospector#findAndAddVirtualProperties(MapperConfig, AnnotatedClass,
   * List)}
   */
  @Test
  @DisplayName("Test findAndAddVirtualProperties(MapperConfig, AnnotatedClass, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaXMLAnnotationIntrospector.findAndAddVirtualProperties(MapperConfig, AnnotatedClass, List)"
  })
  void testFindAndAddVirtualProperties2() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    Mockito.<Class<?>>when(mixins.findMixInClassFor(Mockito.<Class<?>>any()))
        .thenThrow(new RuntimeException());
    BaseSettings base = mock(BaseSettings.class);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig overrides =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(overrides);
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

    BaseSettings base2 =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    RootNameLookup rootNames2 = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config =
        new DeserializationConfig(
            base2,
            str2,
            mixins2,
            rootNames2,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));

    RosettaDataType rosettaDataType = mock(RosettaDataType.class);
    when(rosettaDataType.value()).thenReturn("42");

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getType()).thenReturn(new PlaceholderForType(1));
    when(ac.getAnnotation(Mockito.<Class<RosettaDataType>>any())).thenReturn(rosettaDataType);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            rosettaXMLAnnotationIntrospector.findAndAddVirtualProperties(
                config, ac, new ArrayList<>()));
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac, atLeast(1)).getType();
    verify(mixins).findMixInClassFor(isA(Class.class));
    verify(rosettaDataType).value();
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findAndAddVirtualProperties(MapperConfig,
   * AnnotatedClass, List)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then calls {@link SimpleMixInResolver#findMixInClassFor(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaXMLAnnotationIntrospector#findAndAddVirtualProperties(MapperConfig, AnnotatedClass,
   * List)}
   */
  @Test
  @DisplayName(
      "Test findAndAddVirtualProperties(MapperConfig, AnnotatedClass, List); given 'java.lang.Object'; then calls findMixInClassFor(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaXMLAnnotationIntrospector.findAndAddVirtualProperties(MapperConfig, AnnotatedClass, List)"
  })
  void testFindAndAddVirtualProperties_givenJavaLangObject_thenCallsFindMixInClassFor() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(mixins.findMixInClassFor(Mockito.<Class<?>>any()))
        .thenReturn(forNameResult);
    BaseSettings base = mock(BaseSettings.class);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig overrides =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(overrides);
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

    BaseSettings base2 =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    RootNameLookup rootNames2 = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config =
        new DeserializationConfig(
            base2,
            str2,
            mixins2,
            rootNames2,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));

    RosettaDataType rosettaDataType = mock(RosettaDataType.class);
    when(rosettaDataType.value()).thenReturn("42");

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getType()).thenReturn(new PlaceholderForType(1));
    when(ac.getAnnotation(Mockito.<Class<RosettaDataType>>any())).thenReturn(rosettaDataType);

    // Act
    rosettaXMLAnnotationIntrospector.findAndAddVirtualProperties(config, ac, new ArrayList<>());

    // Assert
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac, atLeast(1)).getType();
    verify(mixins, atLeast(1)).findMixInClassFor(isA(Class.class));
    verify(rosettaDataType).value();
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findAndAddVirtualProperties(MapperConfig,
   * AnnotatedClass, List)}.
   *
   * <ul>
   *   <li>Given {@link RosettaDataType} {@link RosettaDataType#value()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaXMLAnnotationIntrospector#findAndAddVirtualProperties(MapperConfig, AnnotatedClass,
   * List)}
   */
  @Test
  @DisplayName(
      "Test findAndAddVirtualProperties(MapperConfig, AnnotatedClass, List); given RosettaDataType value() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaXMLAnnotationIntrospector.findAndAddVirtualProperties(MapperConfig, AnnotatedClass, List)"
  })
  void testFindAndAddVirtualProperties_givenRosettaDataTypeValueThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
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

    RosettaDataType rosettaDataType = mock(RosettaDataType.class);
    when(rosettaDataType.value()).thenThrow(new RuntimeException());

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getAnnotation(Mockito.<Class<RosettaDataType>>any())).thenReturn(rosettaDataType);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            rosettaXMLAnnotationIntrospector.findAndAddVirtualProperties(
                config, ac, new ArrayList<>()));
    verify(ac).getAnnotation(isA(Class.class));
    verify(rosettaDataType).value();
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findAndAddVirtualProperties(MapperConfig,
   * AnnotatedClass, List)}.
   *
   * <ul>
   *   <li>When {@link AnnotatedClass} {@link AnnotatedClass#getType()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaXMLAnnotationIntrospector#findAndAddVirtualProperties(MapperConfig, AnnotatedClass,
   * List)}
   */
  @Test
  @DisplayName(
      "Test findAndAddVirtualProperties(MapperConfig, AnnotatedClass, List); when AnnotatedClass getType() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaXMLAnnotationIntrospector.findAndAddVirtualProperties(MapperConfig, AnnotatedClass, List)"
  })
  void testFindAndAddVirtualProperties_whenAnnotatedClassGetTypeThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
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

    RosettaDataType rosettaDataType = mock(RosettaDataType.class);
    when(rosettaDataType.value()).thenReturn("42");

    AnnotatedClass ac = mock(AnnotatedClass.class);
    when(ac.getType()).thenThrow(new RuntimeException());
    when(ac.getAnnotation(Mockito.<Class<RosettaDataType>>any())).thenReturn(rosettaDataType);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            rosettaXMLAnnotationIntrospector.findAndAddVirtualProperties(
                config, ac, new ArrayList<>()));
    verify(ac).getAnnotation(isA(Class.class));
    verify(ac).getType();
    verify(rosettaDataType).value();
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#isOutputAsAttribute(MapperConfig, Annotated)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#isOutputAsAttribute(MapperConfig,
   * Annotated)}
   */
  @Test
  @DisplayName("Test isOutputAsAttribute(MapperConfig, Annotated); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean RosettaXMLAnnotationIntrospector.isOutputAsAttribute(MapperConfig, Annotated)"
  })
  void testIsOutputAsAttribute_thenReturnNull() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
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
    TypeResolutionContext typeContext = mock(TypeResolutionContext.class);
    Class<Object> declaringClass = Object.class;

    VirtualAnnotatedMember ann =
        new VirtualAnnotatedMember(typeContext, declaringClass, "Name", new PlaceholderForType(1));

    // Act and Assert
    assertNull(rosettaXMLAnnotationIntrospector.isOutputAsAttribute(config, ann));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#isOutputAsAttribute(MapperConfig, Annotated)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#isOutputAsAttribute(MapperConfig,
   * Annotated)}
   */
  @Test
  @DisplayName("Test isOutputAsAttribute(MapperConfig, Annotated); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean RosettaXMLAnnotationIntrospector.isOutputAsAttribute(MapperConfig, Annotated)"
  })
  void testIsOutputAsAttribute_thenReturnTrue() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
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

    // Act and Assert
    assertTrue(rosettaXMLAnnotationIntrospector.isOutputAsAttribute(config, ann));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#isOutputAsText(MapperConfig, Annotated)}.
   *
   * <ul>
   *   <li>When {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#isOutputAsText(MapperConfig,
   * Annotated)}
   */
  @Test
  @DisplayName(
      "Test isOutputAsText(MapperConfig, Annotated); when PlaceholderForType(int) with ordinal is one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean RosettaXMLAnnotationIntrospector.isOutputAsText(MapperConfig, Annotated)"
  })
  void testIsOutputAsText_whenPlaceholderForTypeWithOrdinalIsOne_thenReturnNull() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
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

    // Act and Assert
    assertNull(rosettaXMLAnnotationIntrospector.isOutputAsText(config, ann));
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
   * Test {@link RosettaXMLAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig,
   * Annotated)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaXMLAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig, Annotated)}
   */
  @Test
  @DisplayName("Test findPropertyIgnoralByName(MapperConfig, Annotated); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value RosettaXMLAnnotationIntrospector.findPropertyIgnoralByName(MapperConfig, Annotated)"
  })
  void testFindPropertyIgnoralByName_givenNull() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
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

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.getAnnotation(Mockito.<Class<Annotation>>any())).thenReturn(null);

    // Act
    Value actualFindPropertyIgnoralByNameResult =
        rosettaXMLAnnotationIntrospector.findPropertyIgnoralByName(config, a);

    // Assert
    verify(a, atLeast(1)).getAnnotation(Mockito.<Class<Annotation>>any());
    assertFalse(actualFindPropertyIgnoralByNameResult.getAllowGetters());
    assertFalse(actualFindPropertyIgnoralByNameResult.getAllowSetters());
    assertFalse(actualFindPropertyIgnoralByNameResult.getIgnoreUnknown());
    assertTrue(actualFindPropertyIgnoralByNameResult.getMerge());
    assertTrue(actualFindPropertyIgnoralByNameResult.getIgnored().isEmpty());
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig,
   * Annotated)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaXMLAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig, Annotated)}
   */
  @Test
  @DisplayName(
      "Test findPropertyIgnoralByName(MapperConfig, Annotated); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value RosettaXMLAnnotationIntrospector.findPropertyIgnoralByName(MapperConfig, Annotated)"
  })
  void testFindPropertyIgnoralByName_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
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

    AnnotatedClass a = mock(AnnotatedClass.class);
    when(a.getAnnotation(Mockito.<Class<Annotation>>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> rosettaXMLAnnotationIntrospector.findPropertyIgnoralByName(config, a));
    verify(a).getAnnotation(isA(Class.class));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig,
   * Annotated)}.
   *
   * <ul>
   *   <li>When {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaXMLAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig, Annotated)}
   */
  @Test
  @DisplayName(
      "Test findPropertyIgnoralByName(MapperConfig, Annotated); when PlaceholderForType(int) with ordinal is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Value RosettaXMLAnnotationIntrospector.findPropertyIgnoralByName(MapperConfig, Annotated)"
  })
  void testFindPropertyIgnoralByName_whenPlaceholderForTypeWithOrdinalIsOne() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
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
    VirtualXMLAttribute a =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act
    Value actualFindPropertyIgnoralByNameResult =
        rosettaXMLAnnotationIntrospector.findPropertyIgnoralByName(config, a);

    // Assert
    assertFalse(actualFindPropertyIgnoralByNameResult.getAllowGetters());
    assertFalse(actualFindPropertyIgnoralByNameResult.getAllowSetters());
    assertFalse(actualFindPropertyIgnoralByNameResult.getIgnoreUnknown());
    assertTrue(actualFindPropertyIgnoralByNameResult.getMerge());
    assertTrue(actualFindPropertyIgnoralByNameResult.getIgnored().isEmpty());
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
    when(ann.getAnnotation(Mockito.<Class<JacksonXmlElementWrapper>>any()))
        .thenReturn(jacksonXmlElementWrapper);

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
    when(ann.getAnnotation(Mockito.<Class<JacksonXmlElementWrapper>>any()))
        .thenReturn(jacksonXmlElementWrapper);

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
    when(ann.getAnnotation(Mockito.<Class<JacksonXmlElementWrapper>>any()))
        .thenReturn(jacksonXmlElementWrapper);

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
    when(ann.getAnnotation(Mockito.<Class<JacksonXmlElementWrapper>>any()))
        .thenReturn(jacksonXmlElementWrapper);

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
    when(ann.getAnnotation(Mockito.<Class<JacksonXmlElementWrapper>>any()))
        .thenReturn(jacksonXmlElementWrapper);

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
   *   <li>Then return SimpleName is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}
   */
  @Test
  @DisplayName("Test findWrapperName(Annotated); then return SimpleName is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findWrapperName(Annotated)"})
  void testFindWrapperName_thenReturnSimpleNameIsFoo() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);

    JacksonXmlElementWrapper jacksonXmlElementWrapper = mock(JacksonXmlElementWrapper.class);
    when(jacksonXmlElementWrapper.namespace()).thenReturn("Namespace");
    when(jacksonXmlElementWrapper.localName()).thenReturn("foo");
    when(jacksonXmlElementWrapper.useWrapping()).thenReturn(true);

    AnnotatedClass ann = mock(AnnotatedClass.class);
    when(ann.hasAnnotation(Mockito.<Class<?>>any())).thenReturn(true);
    when(ann.getAnnotation(Mockito.<Class<JacksonXmlElementWrapper>>any()))
        .thenReturn(jacksonXmlElementWrapper);

    // Act
    PropertyName actualFindWrapperNameResult =
        rosettaXMLAnnotationIntrospector.findWrapperName(ann);

    // Assert
    verify(ann).getAnnotation(isA(Class.class));
    verify(ann).hasAnnotation(isA(Class.class));
    verify(jacksonXmlElementWrapper, atLeast(1)).localName();
    verify(jacksonXmlElementWrapper).namespace();
    verify(jacksonXmlElementWrapper).useWrapping();
    assertEquals("Namespace", actualFindWrapperNameResult.getNamespace());
    assertEquals("foo", actualFindWrapperNameResult.getSimpleName());
    assertFalse(actualFindWrapperNameResult.isEmpty());
    assertTrue(actualFindWrapperNameResult.hasNamespace());
    assertTrue(actualFindWrapperNameResult.hasSimpleName());
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
    when(ann.getAnnotation(Mockito.<Class<JacksonXmlElementWrapper>>any()))
        .thenReturn(jacksonXmlElementWrapper);

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

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findEnumValues(MapperConfig, AnnotatedClass,
   * Enum[], String[])} with {@code config}, {@code enumType}, {@code enumValues}, {@code names}.
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findEnumValues(MapperConfig,
   * AnnotatedClass, Object[], String[])}
   */
  @Test
  @DisplayName(
      "Test findEnumValues(MapperConfig, AnnotatedClass, Enum[], String[]) with 'config', 'enumType', 'enumValues', 'names'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String[] RosettaXMLAnnotationIntrospector.findEnumValues(MapperConfig, AnnotatedClass, Enum[], String[])"
  })
  void testFindEnumValuesWithConfigEnumTypeEnumValuesNames() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
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
    when(enumType.getAnnotation(Mockito.<Class<RosettaEnum>>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            rosettaXMLAnnotationIntrospector.findEnumValues(
                config, enumType, new Enum[] {UnicodeScript.of(1)}, new String[] {"Names"}));
    verify(enumType).getAnnotation(isA(Class.class));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findEnumValues(MapperConfig, AnnotatedClass,
   * Enum[], String[])} with {@code config}, {@code enumType}, {@code enumValues}, {@code names}.
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findEnumValues(MapperConfig,
   * AnnotatedClass, Object[], String[])}
   */
  @Test
  @DisplayName(
      "Test findEnumValues(MapperConfig, AnnotatedClass, Enum[], String[]) with 'config', 'enumType', 'enumValues', 'names'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String[] RosettaXMLAnnotationIntrospector.findEnumValues(MapperConfig, AnnotatedClass, Enum[], String[])"
  })
  void testFindEnumValuesWithConfigEnumTypeEnumValuesNames2() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
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

    RosettaEnum rosettaEnum = mock(RosettaEnum.class);
    when(rosettaEnum.value()).thenThrow(new RuntimeException());

    AnnotatedClass enumType = mock(AnnotatedClass.class);
    when(enumType.getAnnotation(Mockito.<Class<RosettaEnum>>any())).thenReturn(rosettaEnum);
    when(enumType.fields()).thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            rosettaXMLAnnotationIntrospector.findEnumValues(
                config, enumType, new Enum[] {UnicodeScript.of(1)}, new String[] {"Names"}));
    verify(enumType).fields();
    verify(enumType, atLeast(1)).getAnnotation(isA(Class.class));
    verify(rosettaEnum).value();
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findEnumValues(MapperConfig, AnnotatedClass,
   * Enum[], String[])} with {@code config}, {@code enumType}, {@code enumValues}, {@code names}.
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findEnumValues(MapperConfig,
   * AnnotatedClass, Object[], String[])}
   */
  @Test
  @DisplayName(
      "Test findEnumValues(MapperConfig, AnnotatedClass, Enum[], String[]) with 'config', 'enumType', 'enumValues', 'names'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String[] RosettaXMLAnnotationIntrospector.findEnumValues(MapperConfig, AnnotatedClass, Enum[], String[])"
  })
  void testFindEnumValuesWithConfigEnumTypeEnumValuesNames3() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
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

    RosettaEnum rosettaEnum = mock(RosettaEnum.class);
    when(rosettaEnum.value()).thenReturn("42");

    AnnotatedClass enumType = mock(AnnotatedClass.class);
    when(enumType.getType()).thenReturn(new PlaceholderForType(1));
    when(enumType.getAnnotation(Mockito.<Class<RosettaEnum>>any())).thenReturn(rosettaEnum);
    when(enumType.fields()).thenReturn(new ArrayList<>());
    String[] names = new String[] {"Names"};

    // Act
    String[] actualFindEnumValuesResult =
        rosettaXMLAnnotationIntrospector.findEnumValues(
            config, enumType, new Enum[] {UnicodeScript.of(1)}, names);

    // Assert
    verify(enumType).fields();
    verify(enumType, atLeast(1)).getAnnotation(isA(Class.class));
    verify(enumType).getType();
    verify(rosettaEnum).value();
    assertSame(names, actualFindEnumValuesResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findEnumValues(MapperConfig, AnnotatedClass,
   * Enum[], String[])} with {@code config}, {@code enumType}, {@code enumValues}, {@code names}.
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findEnumValues(MapperConfig,
   * AnnotatedClass, Object[], String[])}
   */
  @Test
  @DisplayName(
      "Test findEnumValues(MapperConfig, AnnotatedClass, Enum[], String[]) with 'config', 'enumType', 'enumValues', 'names'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String[] RosettaXMLAnnotationIntrospector.findEnumValues(MapperConfig, AnnotatedClass, Enum[], String[])"
  })
  void testFindEnumValuesWithConfigEnumTypeEnumValuesNames4() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
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

    RosettaEnum rosettaEnum = mock(RosettaEnum.class);
    when(rosettaEnum.value()).thenReturn("42");

    AnnotatedClass enumType = mock(AnnotatedClass.class);
    when(enumType.getType()).thenThrow(new RuntimeException());
    when(enumType.getAnnotation(Mockito.<Class<RosettaEnum>>any())).thenReturn(rosettaEnum);
    when(enumType.fields()).thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            rosettaXMLAnnotationIntrospector.findEnumValues(
                config, enumType, new Enum[] {UnicodeScript.of(1)}, new String[] {"Names"}));
    verify(enumType).fields();
    verify(enumType, atLeast(1)).getAnnotation(isA(Class.class));
    verify(enumType).getType();
    verify(rosettaEnum).value();
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findEnumValues(MapperConfig, AnnotatedClass,
   * Enum[], String[])} with {@code config}, {@code enumType}, {@code enumValues}, {@code names}.
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findEnumValues(MapperConfig,
   * AnnotatedClass, Object[], String[])}
   */
  @Test
  @DisplayName(
      "Test findEnumValues(MapperConfig, AnnotatedClass, Enum[], String[]) with 'config', 'enumType', 'enumValues', 'names'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String[] RosettaXMLAnnotationIntrospector.findEnumValues(MapperConfig, AnnotatedClass, Enum[], String[])"
  })
  void testFindEnumValuesWithConfigEnumTypeEnumValuesNames5() {
    // Arrange
    HashMap<ModelSymbolId, TypeXMLConfiguration> typeConfigMap = new HashMap<>();
    ModelSymbolId fromQualifiedNameResult = ModelSymbolId.fromQualifiedName("Str");
    Optional<ModelSymbolId> substitutionFor = Optional.of(ModelSymbolId.fromQualifiedName("Str"));
    Optional<String> xmlElementName = Optional.of("foo");
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

    RosettaEnum rosettaEnum = mock(RosettaEnum.class);
    when(rosettaEnum.value()).thenReturn("42");

    AnnotatedClass enumType = mock(AnnotatedClass.class);
    when(enumType.getType()).thenReturn(new PlaceholderForType(1));
    when(enumType.getAnnotation(Mockito.<Class<RosettaEnum>>any())).thenReturn(rosettaEnum);
    when(enumType.fields()).thenReturn(new ArrayList<>());
    String[] names = new String[] {"Names"};

    // Act
    String[] actualFindEnumValuesResult =
        rosettaXMLAnnotationIntrospector.findEnumValues(
            config, enumType, new Enum[] {UnicodeScript.of(1)}, names);

    // Assert
    verify(enumType).fields();
    verify(enumType, atLeast(1)).getAnnotation(isA(Class.class));
    verify(enumType).getType();
    verify(rosettaEnum).value();
    assertSame(names, actualFindEnumValuesResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findEnumAliases(MapperConfig, AnnotatedClass,
   * Enum[], String[][])} with {@code config}, {@code enumType}, {@code enumValues}, {@code
   * aliasList}.
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findEnumAliases(MapperConfig,
   * AnnotatedClass, Object[], String[][])}
   */
  @Test
  @DisplayName(
      "Test findEnumAliases(MapperConfig, AnnotatedClass, Enum[], String[][]) with 'config', 'enumType', 'enumValues', 'aliasList'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaXMLAnnotationIntrospector.findEnumAliases(MapperConfig, AnnotatedClass, Enum[], String[][])"
  })
  void testFindEnumAliasesWithConfigEnumTypeEnumValuesAliasList() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
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
    when(enumType.getAnnotation(Mockito.<Class<RosettaEnum>>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            rosettaXMLAnnotationIntrospector.findEnumAliases(
                config,
                enumType,
                new Enum[] {UnicodeScript.of(1)},
                new String[][] {new String[] {"Alias List"}}));
    verify(enumType).getAnnotation(isA(Class.class));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findEnumAliases(MapperConfig, AnnotatedClass,
   * Enum[], String[][])} with {@code config}, {@code enumType}, {@code enumValues}, {@code
   * aliasList}.
   *
   * <ul>
   *   <li>Then calls {@link AnnotatedClass#fields()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaXMLAnnotationIntrospector#findEnumAliases(MapperConfig,
   * AnnotatedClass, Object[], String[][])}
   */
  @Test
  @DisplayName(
      "Test findEnumAliases(MapperConfig, AnnotatedClass, Enum[], String[][]) with 'config', 'enumType', 'enumValues', 'aliasList'; then calls fields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RosettaXMLAnnotationIntrospector.findEnumAliases(MapperConfig, AnnotatedClass, Enum[], String[][])"
  })
  void testFindEnumAliasesWithConfigEnumTypeEnumValuesAliasList_thenCallsFields() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
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
    rosettaXMLAnnotationIntrospector.findEnumAliases(
        config,
        enumType,
        new Enum[] {UnicodeScript.of(1)},
        new String[][] {new String[] {"Alias List"}});

    // Assert
    verify(enumType).fields();
    verify(enumType).getAnnotation(isA(Class.class));
  }
}
