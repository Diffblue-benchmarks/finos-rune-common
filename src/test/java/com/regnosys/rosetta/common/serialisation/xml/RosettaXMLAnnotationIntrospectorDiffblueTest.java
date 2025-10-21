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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.regnosys.rosetta.common.serialisation.mixin.EnumAsStringBuilderIntrospector;
import com.regnosys.rosetta.common.serialisation.mixin.RosettaEnumBuilderIntrospector;
import com.regnosys.rosetta.common.serialisation.mixin.RosettaJSONAnnotationIntrospector;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.util.serialisation.RosettaXMLConfiguration;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class RosettaXMLAnnotationIntrospectorDiffblueTest {
  /**
   * Test {@link RosettaXMLAnnotationIntrospector#RosettaXMLAnnotationIntrospector(ObjectMapper, RosettaXMLConfiguration, RosettaEnumBuilderIntrospector, EnumAsStringBuilderIntrospector)}.
   * <p>
   * Method under test: {@link RosettaXMLAnnotationIntrospector#RosettaXMLAnnotationIntrospector(ObjectMapper, RosettaXMLConfiguration, RosettaEnumBuilderIntrospector, EnumAsStringBuilderIntrospector)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void RosettaXMLAnnotationIntrospector.<init>(ObjectMapper, RosettaXMLConfiguration, RosettaEnumBuilderIntrospector, EnumAsStringBuilderIntrospector)"})
  public void testNewRosettaXMLAnnotationIntrospector() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLConfiguration rosettaXMLConfiguration = new RosettaXMLConfiguration(new HashMap<>());
    RosettaEnumBuilderIntrospector rosettaEnumBuilderIntrospector = new RosettaEnumBuilderIntrospector(true);

    // Act and Assert
    Version versionResult = (new RosettaXMLAnnotationIntrospector(mapper, rosettaXMLConfiguration,
        rosettaEnumBuilderIntrospector, new EnumAsStringBuilderIntrospector())).version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.1", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals(1, versionResult.getPatchLevel());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#RosettaXMLAnnotationIntrospector(ObjectMapper, RosettaXMLConfiguration, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLAnnotationIntrospector#RosettaXMLAnnotationIntrospector(ObjectMapper, RosettaXMLConfiguration, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaXMLAnnotationIntrospector.<init>(ObjectMapper, RosettaXMLConfiguration, boolean)"})
  public void testNewRosettaXMLAnnotationIntrospector_whenFalse() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    Version versionResult = (new RosettaXMLAnnotationIntrospector(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        false)).version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.1", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals(1, versionResult.getPatchLevel());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#RosettaXMLAnnotationIntrospector(ObjectMapper, RosettaXMLConfiguration, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLAnnotationIntrospector#RosettaXMLAnnotationIntrospector(ObjectMapper, RosettaXMLConfiguration, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaXMLAnnotationIntrospector.<init>(ObjectMapper, RosettaXMLConfiguration, boolean)"})
  public void testNewRosettaXMLAnnotationIntrospector_whenTrue() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    Version versionResult = (new RosettaXMLAnnotationIntrospector(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true)).version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.1", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals(1, versionResult.getPatchLevel());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findSubstitutionMap(MapperConfig, AnnotatedMember)}.
   * <p>
   * Method under test: {@link RosettaXMLAnnotationIntrospector#findSubstitutionMap(MapperConfig, AnnotatedMember)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SubstitutionMap RosettaXMLAnnotationIntrospector.findSubstitutionMap(MapperConfig, AnnotatedMember)"})
  public void testFindSubstitutionMap() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);
    MixInResolver overrides = mock(MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, null, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    Class<Object> declaringClass = Object.class;

    // Act
    SubstitutionMap actualFindSubstitutionMapResult = rosettaXMLAnnotationIntrospector.findSubstitutionMap(config,
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));

    // Assert
    verify(overrides).findMixInClassFor(isA(Class.class));
    assertNull(actualFindSubstitutionMapResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findSubstitutionMap(MapperConfig, AnnotatedMember)}.
   * <p>
   * Method under test: {@link RosettaXMLAnnotationIntrospector#findSubstitutionMap(MapperConfig, AnnotatedMember)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SubstitutionMap RosettaXMLAnnotationIntrospector.findSubstitutionMap(MapperConfig, AnnotatedMember)"})
  public void testFindSubstitutionMap2() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);
    MixInResolver overrides = mock(MixInResolver.class);
    Class<AnnotatedMethod> forNameResult = AnnotatedMethod.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    Class<Object> declaringClass = Object.class;

    // Act
    SubstitutionMap actualFindSubstitutionMapResult = rosettaXMLAnnotationIntrospector.findSubstitutionMap(config,
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));

    // Assert
    verify(overrides, atLeast(1)).findMixInClassFor(isA(Class.class));
    assertNull(actualFindSubstitutionMapResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findSubstitutionMap(MapperConfig, AnnotatedMember)}.
   * <ul>
   *   <li>Given {@code RosettaAttribute}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLAnnotationIntrospector#findSubstitutionMap(MapperConfig, AnnotatedMember)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SubstitutionMap RosettaXMLAnnotationIntrospector.findSubstitutionMap(MapperConfig, AnnotatedMember)"})
  public void testFindSubstitutionMap_givenComRosettaModelLibAnnotationsRosettaAttribute() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);
    MixInResolver overrides = mock(MixInResolver.class);
    Class<RosettaAttribute> forNameResult = RosettaAttribute.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    Class<Object> declaringClass = Object.class;

    // Act
    SubstitutionMap actualFindSubstitutionMapResult = rosettaXMLAnnotationIntrospector.findSubstitutionMap(config,
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));

    // Assert
    verify(overrides, atLeast(1)).findMixInClassFor(isA(Class.class));
    assertNull(actualFindSubstitutionMapResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findSubstitutionMap(MapperConfig, AnnotatedMember)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ClassIntrospector.MixInResolver} {@link ClassIntrospector.MixInResolver#findMixInClassFor(Class)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLAnnotationIntrospector#findSubstitutionMap(MapperConfig, AnnotatedMember)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SubstitutionMap RosettaXMLAnnotationIntrospector.findSubstitutionMap(MapperConfig, AnnotatedMember)"})
  public void testFindSubstitutionMap_givenNull_whenMixInResolverFindMixInClassForReturnNull() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);
    MixInResolver overrides = mock(MixInResolver.class);
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(null);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    Class<Object> declaringClass = Object.class;

    // Act
    SubstitutionMap actualFindSubstitutionMapResult = rosettaXMLAnnotationIntrospector.findSubstitutionMap(config,
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));

    // Assert
    verify(overrides, atLeast(1)).findMixInClassFor(isA(Class.class));
    assertNull(actualFindSubstitutionMapResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findSubstitutionMap(MapperConfig, AnnotatedMember)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLAnnotationIntrospector#findSubstitutionMap(MapperConfig, AnnotatedMember)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "SubstitutionMap RosettaXMLAnnotationIntrospector.findSubstitutionMap(MapperConfig, AnnotatedMember)"})
  public void testFindSubstitutionMap_thenReturnNull() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);
    MixInResolver overrides = mock(MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    Class<Object> declaringClass = Object.class;

    // Act
    SubstitutionMap actualFindSubstitutionMapResult = rosettaXMLAnnotationIntrospector.findSubstitutionMap(config,
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));

    // Assert
    verify(overrides, atLeast(1)).findMixInClassFor(isA(Class.class));
    assertNull(actualFindSubstitutionMapResult);
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findUnwrappingNameTransformer(AnnotatedMember)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLAnnotationIntrospector#findUnwrappingNameTransformer(AnnotatedMember)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "com.fasterxml.jackson.databind.util.NameTransformer RosettaXMLAnnotationIntrospector.findUnwrappingNameTransformer(AnnotatedMember)"})
  public void testFindUnwrappingNameTransformer_whenJavaLangObject_thenReturnNull() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);
    Class<Object> declaringClass = Object.class;

    // Act and Assert
    assertNull(rosettaXMLAnnotationIntrospector
        .findUnwrappingNameTransformer(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1))));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}.
   * <ul>
   *   <li>When {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLAnnotationIntrospector#_findXmlName(Annotated)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector._findXmlName(Annotated)"})
  public void test_findXmlName_whenPlaceholderForTypeWithOrdinalIsOne_thenReturnNull() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);
    Class<Object> declaringClass = Object.class;

    // Act and Assert
    assertNull(rosettaXMLAnnotationIntrospector
        ._findXmlName(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1))));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#isOutputAsAttribute(MapperConfig, Annotated)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLAnnotationIntrospector#isOutputAsAttribute(MapperConfig, Annotated)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean RosettaXMLAnnotationIntrospector.isOutputAsAttribute(MapperConfig, Annotated)"})
  public void testIsOutputAsAttribute_whenJavaLangObject_thenReturnTrue() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    Class<Object> declaringClass = Object.class;

    // Act and Assert
    assertTrue(rosettaXMLAnnotationIntrospector.isOutputAsAttribute(config,
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1))));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#isOutputAsText(MapperConfig, Annotated)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLAnnotationIntrospector#isOutputAsText(MapperConfig, Annotated)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean RosettaXMLAnnotationIntrospector.isOutputAsText(MapperConfig, Annotated)"})
  public void testIsOutputAsText_whenJavaLangObject_thenReturnNull() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    Class<Object> declaringClass = Object.class;

    // Act and Assert
    assertNull(rosettaXMLAnnotationIntrospector.isOutputAsText(config,
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1))));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#_isIgnorable(Annotated)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLAnnotationIntrospector#_isIgnorable(Annotated)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RosettaXMLAnnotationIntrospector._isIgnorable(Annotated)"})
  public void test_isIgnorable_whenJavaLangObject_thenReturnTrue() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);
    Class<Object> declaringClass = Object.class;

    // Act and Assert
    assertTrue(rosettaXMLAnnotationIntrospector
        ._isIgnorable(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1))));
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig, Annotated)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return not AllowGetters.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig, Annotated)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value RosettaXMLAnnotationIntrospector.findPropertyIgnoralByName(MapperConfig, Annotated)"})
  public void testFindPropertyIgnoralByName_whenJavaLangObject_thenReturnNotAllowGetters() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    Class<Object> declaringClass = Object.class;

    // Act
    Value actualFindPropertyIgnoralByNameResult = rosettaXMLAnnotationIntrospector.findPropertyIgnoralByName(config,
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));

    // Assert
    assertFalse(actualFindPropertyIgnoralByNameResult.getAllowGetters());
    assertFalse(actualFindPropertyIgnoralByNameResult.getAllowSetters());
    assertFalse(actualFindPropertyIgnoralByNameResult.getIgnoreUnknown());
    assertTrue(actualFindPropertyIgnoralByNameResult.getMerge());
    assertTrue(actualFindPropertyIgnoralByNameResult.getIgnored().isEmpty());
  }

  /**
   * Test {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@link PropertyName#USE_DEFAULT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLAnnotationIntrospector#findWrapperName(Annotated)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PropertyName RosettaXMLAnnotationIntrospector.findWrapperName(Annotated)"})
  public void testFindWrapperName_whenJavaLangObject_thenReturnUse_default() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector rosettaXMLAnnotationIntrospector = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);
    Class<Object> declaringClass = Object.class;

    // Act
    PropertyName actualFindWrapperNameResult = rosettaXMLAnnotationIntrospector
        .findWrapperName(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));

    // Assert
    assertSame(actualFindWrapperNameResult.USE_DEFAULT, actualFindWrapperNameResult);
  }
}
