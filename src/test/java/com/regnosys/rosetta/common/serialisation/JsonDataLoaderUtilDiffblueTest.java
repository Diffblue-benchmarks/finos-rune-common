package com.regnosys.rosetta.common.serialisation;

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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.regnosys.rosetta.common.postprocess.qualify.QualificationReport;
import com.regnosys.rosetta.common.projection.ProjectionDataItemExpectation;
import com.regnosys.rosetta.common.serialisation.mixin.RosettaJSONAnnotationIntrospector;
import java.io.CharArrayReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;
import javax.management.loading.MLet;
import org.eclipse.core.internal.boot.PlatformURLHandler;
import org.junit.Test;
import org.mockito.Mockito;

public class JsonDataLoaderUtilDiffblueTest {
  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, new ObjectMapper(), "Json"));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType2() {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, new ObjectMapper(), "Json"));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType3() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, new XmlMapper(), "Json"));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType4() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals("Json", JsonDataLoaderUtil.readType(type, new YAMLMapper(), "Json"));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType5() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, new ObjectMapper(), "["));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType6() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, new ObjectMapper(), "]"));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType7() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, new ObjectMapper(), ""));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType8() {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, new YAMLMapper(), "Json"));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType9() {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, new ObjectMapper(), "["));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType10() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "["));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType11() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "["));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType12() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.NON_CONCRETE_AND_ARRAYS);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "["));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType13() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.NON_FINAL);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "["));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType14() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer = new StdTypeResolverBuilder();
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "["));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType15() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.NON_FINAL_AND_ENUMS);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "["));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType16() {
    // Arrange
    Class<Object> type = Object.class;
    JsonTypeInfo.Value settings = mock(JsonTypeInfo.Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(JsonTypeInfo.As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(JsonTypeInfo.Id.NONE);

    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    typer.init(settings, new ClassNameIdResolver(baseType, typeFactory, new DefaultBaseTypeLimitingValidator()));
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult2);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "["));
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType17() {
    // Arrange
    Class<List> type = List.class;
    JsonTypeInfo.Value settings = mock(JsonTypeInfo.Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(JsonTypeInfo.As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(JsonTypeInfo.Id.NONE);

    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    typer.init(settings, new ClassNameIdResolver(baseType, typeFactory, new DefaultBaseTypeLimitingValidator()));
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult2);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "["));
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, String)}
   */
  @Test
  public void testReadType18() {
    // Arrange
    Class<Object> type = Object.class;
    JsonTypeInfo.Value settings = mock(JsonTypeInfo.Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(JsonTypeInfo.As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(JsonTypeInfo.Id.CLASS);

    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    typer.init(settings, new ClassNameIdResolver(baseType, typeFactory, new DefaultBaseTypeLimitingValidator()));
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult2);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, rosettaObjectMapper, "["));
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)}
   */
  @Test
  public void testReadType19() throws MalformedURLException {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, new ObjectMapper(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readType(Class, ObjectMapper, URL)}
   */
  @Test
  public void testReadType20() throws MalformedURLException {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readType(type, new ObjectMapper(),
        Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList() {
    // Arrange
    Class<Object> type = Object.class;
    ObjectMapper rosettaObjectMapper = new ObjectMapper();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("foo")));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList2() {
    // Arrange
    Class<List> type = List.class;
    ObjectMapper rosettaObjectMapper = new ObjectMapper();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("foo")));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList3() {
    // Arrange
    Class<Object> type = Object.class;
    XmlMapper rosettaObjectMapper = new XmlMapper();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("foo")));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList4() {
    // Arrange
    Class<Object> type = Object.class;
    YAMLMapper rosettaObjectMapper = new YAMLMapper();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("foo")));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList5() {
    // Arrange
    Class<Object> type = Object.class;
    ObjectMapper rosettaObjectMapper = new ObjectMapper();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper,
        new StringReader(" cannot be serialised to list of ")));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList6() {
    // Arrange
    Class<Object> type = Object.class;
    ObjectMapper rosettaObjectMapper = new ObjectMapper();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList7() {
    // Arrange
    Class<Object> type = Object.class;
    ObjectMapper rosettaObjectMapper = new ObjectMapper();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("")));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList8() {
    // Arrange
    Class<Object> type = Object.class;
    ObjectMapper rosettaObjectMapper = new ObjectMapper();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper,
        new CharArrayReader("A\u0000A\u0000".toCharArray(), 1, 1)));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList9() {
    // Arrange
    Class<List> type = List.class;
    YAMLMapper rosettaObjectMapper = new YAMLMapper();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("foo")));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList10() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList11() {
    // Arrange
    Class<List> type = List.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList12() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList13() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.NON_CONCRETE_AND_ARRAYS);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList14() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.NON_FINAL);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList15() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer = new StdTypeResolverBuilder();
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList16() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.NON_FINAL_AND_ENUMS);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList17() {
    // Arrange
    Class<Object> type = Object.class;
    JsonTypeInfo.Value settings = mock(JsonTypeInfo.Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(JsonTypeInfo.As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(JsonTypeInfo.Id.NONE);

    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    typer.init(settings, new ClassNameIdResolver(baseType, typeFactory, new DefaultBaseTypeLimitingValidator()));
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult2);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList18() {
    // Arrange
    Class<Object> type = Object.class;
    JsonTypeInfo.Value settings = mock(JsonTypeInfo.Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(JsonTypeInfo.As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(JsonTypeInfo.Id.NONE);

    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    typer.init(settings, new ClassNameIdResolver(baseType, typeFactory, new DefaultBaseTypeLimitingValidator()));
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult2);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, Reader)}
   */
  @Test
  public void testReadTypeList19() {
    // Arrange
    Class<Object> type = Object.class;
    JsonTypeInfo.Value settings = mock(JsonTypeInfo.Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(JsonTypeInfo.As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(JsonTypeInfo.Id.CLASS);

    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    typer.init(settings, new ClassNameIdResolver(baseType, typeFactory, new DefaultBaseTypeLimitingValidator()));
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult2);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.readTypeList(type, rosettaObjectMapper, new StringReader("42")));
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, URL)}
   */
  @Test
  public void testReadTypeList20() throws MalformedURLException {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readTypeList(type, new ObjectMapper(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#readTypeList(Class, ObjectMapper, URL)}
   */
  @Test
  public void testReadTypeList21() throws MalformedURLException {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.readTypeList(type, new ObjectMapper(),
        Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL()));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    Object actualFromObjectResult = JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type,
        new ObjectMapper());

    // Assert
    assertEquals(4, ((Map<String, Object>) actualFromObjectResult).size());
    Object getResult = ((Map<String, Object>) actualFromObjectResult).get("results");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromObjectResult instanceof Map);
    assertNull(((Map<String, Object>) actualFromObjectResult).get("ingestedObject"));
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("qualifiableObjectsCount"));
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("uniquelyQualifiedObjectsCount"));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject2() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals("java.lang.Object", JsonDataLoaderUtil.fromObject(forNameResult, type, new ObjectMapper()));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject3() {
    // Arrange
    ProjectionDataItemExpectation projectionDataItemExpectation = new ProjectionDataItemExpectation("Input File", "42",
        "Output File", 1, true, true);

    Class<Object> type = Object.class;

    // Act
    Object actualFromObjectResult = JsonDataLoaderUtil.fromObject(projectionDataItemExpectation, type,
        new ObjectMapper());

    // Assert
    assertTrue(actualFromObjectResult instanceof Map);
    assertEquals(6, ((Map<String, Object>) actualFromObjectResult).size());
    assertEquals("42", ((Map<String, Object>) actualFromObjectResult).get("keyValueFile"));
    assertEquals("Input File", ((Map<String, Object>) actualFromObjectResult).get("inputFile"));
    assertEquals("Output File", ((Map<String, Object>) actualFromObjectResult).get("outputFile"));
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("error"));
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("validXml"));
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("validationFailures"));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject4() {
    // Arrange
    Class<List> type = List.class;

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type, new ObjectMapper()));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject5() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    Object actualFromObjectResult = JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type, new XmlMapper());

    // Assert
    assertTrue(actualFromObjectResult instanceof Map);
    assertEquals(4, ((Map<String, String>) actualFromObjectResult).size());
    assertEquals("", ((Map<String, String>) actualFromObjectResult).get("ingestedObject"));
    assertEquals("", ((Map<String, String>) actualFromObjectResult).get("results"));
    assertEquals("0", ((Map<String, String>) actualFromObjectResult).get("qualifiableObjectsCount"));
    assertEquals("0", ((Map<String, String>) actualFromObjectResult).get("uniquelyQualifiedObjectsCount"));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject6() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    Object actualFromObjectResult = JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type, new YAMLMapper());

    // Assert
    assertEquals(4, ((Map<String, Object>) actualFromObjectResult).size());
    Object getResult = ((Map<String, Object>) actualFromObjectResult).get("results");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromObjectResult instanceof Map);
    assertNull(((Map<String, Object>) actualFromObjectResult).get("ingestedObject"));
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("qualifiableObjectsCount"));
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("uniquelyQualifiedObjectsCount"));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject7() {
    // Arrange
    Class<Object> type = Object.class;

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    rosettaObjectMapper.addMixIn(target, mixinSource);

    // Act
    Object actualFromObjectResult = JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type,
        rosettaObjectMapper);

    // Assert
    assertEquals(4, ((Map<String, Object>) actualFromObjectResult).size());
    Object getResult = ((Map<String, Object>) actualFromObjectResult).get("results");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromObjectResult instanceof Map);
    assertNull(((Map<String, Object>) actualFromObjectResult).get("ingestedObject"));
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("qualifiableObjectsCount"));
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("uniquelyQualifiedObjectsCount"));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject8() {
    // Arrange
    Class<Object> type = Object.class;

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setDefaultLeniency(true);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    rosettaObjectMapper.addMixIn(target, mixinSource);

    // Act
    Object actualFromObjectResult = JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type,
        rosettaObjectMapper);

    // Assert
    assertEquals(4, ((Map<String, Object>) actualFromObjectResult).size());
    Object getResult = ((Map<String, Object>) actualFromObjectResult).get("results");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromObjectResult instanceof Map);
    assertNull(((Map<String, Object>) actualFromObjectResult).get("ingestedObject"));
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("qualifiableObjectsCount"));
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("uniquelyQualifiedObjectsCount"));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject9() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    rosettaObjectMapper.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type, rosettaObjectMapper));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject10() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    rosettaObjectMapper.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.fromObject(null, type, rosettaObjectMapper));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject11() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    rosettaObjectMapper.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type, rosettaObjectMapper));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject12() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.NON_CONCRETE_AND_ARRAYS);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    rosettaObjectMapper.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type, rosettaObjectMapper));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject13() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.NON_FINAL);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    rosettaObjectMapper.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type, rosettaObjectMapper));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject14() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer = new StdTypeResolverBuilder();
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    rosettaObjectMapper.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type, rosettaObjectMapper));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject15() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);
    Class<Object> target = Object.class;
    Class<List> mixinSource = List.class;
    rosettaObjectMapper.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type, rosettaObjectMapper));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject16() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
    rosettaObjectMapper.setConfig(config);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    rosettaObjectMapper.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type, rosettaObjectMapper));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject17() {
    // Arrange
    Class<Object> type = Object.class;
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.NON_FINAL_AND_ENUMS);
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

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    rosettaObjectMapper.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type, rosettaObjectMapper));
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject18() {
    // Arrange
    Class<Object> type = Object.class;
    JsonTypeInfo.Value settings = mock(JsonTypeInfo.Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(JsonTypeInfo.As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(JsonTypeInfo.Id.NONE);

    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    typer.init(settings, new ClassNameIdResolver(baseType, typeFactory, new DefaultBaseTypeLimitingValidator()));
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult2);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    rosettaObjectMapper.addMixIn(target, mixinSource);

    // Act
    Object actualFromObjectResult = JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type,
        rosettaObjectMapper);

    // Assert
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
    assertEquals(4, ((Map<String, Object>) actualFromObjectResult).size());
    Object getResult = ((Map<String, Object>) actualFromObjectResult).get("results");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromObjectResult instanceof Map);
    assertNull(((Map<String, Object>) actualFromObjectResult).get("ingestedObject"));
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("qualifiableObjectsCount"));
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("uniquelyQualifiedObjectsCount"));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject19() {
    // Arrange
    Class<Object> type = Object.class;
    JsonTypeInfo.Value settings = mock(JsonTypeInfo.Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(JsonTypeInfo.As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(JsonTypeInfo.Id.NONE);

    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    typer.init(settings, new ClassNameIdResolver(baseType, typeFactory, new DefaultBaseTypeLimitingValidator()));
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult2);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    rosettaObjectMapper.addMixIn(target, mixinSource);

    // Act
    Object actualFromObjectResult = JsonDataLoaderUtil.fromObject(null, type, rosettaObjectMapper);

    // Assert
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
    assertNull(actualFromObjectResult);
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject20() {
    // Arrange
    JsonIgnoreProperties.Value emptyResult = JsonIgnoreProperties.Value.empty();
    Class<Object> type = Object.class;
    JsonTypeInfo.Value settings = mock(JsonTypeInfo.Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(JsonTypeInfo.As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(JsonTypeInfo.Id.NONE);

    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    typer.init(settings, new ClassNameIdResolver(baseType, typeFactory, new DefaultBaseTypeLimitingValidator()));
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult2);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    rosettaObjectMapper.addMixIn(target, mixinSource);

    // Act
    Object actualFromObjectResult = JsonDataLoaderUtil.fromObject(emptyResult, type, rosettaObjectMapper);

    // Assert
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
    assertEquals(5, ((Map<String, Object>) actualFromObjectResult).size());
    Object getResult = ((Map<String, Object>) actualFromObjectResult).get("ignored");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromObjectResult instanceof Map);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("allowGetters"));
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("allowSetters"));
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("ignoreUnknown"));
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("merge"));
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject21() {
    // Arrange
    Class<List> type = List.class;
    JsonTypeInfo.Value settings = mock(JsonTypeInfo.Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(JsonTypeInfo.As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(JsonTypeInfo.Id.NONE);

    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    typer.init(settings, new ClassNameIdResolver(baseType, typeFactory, new DefaultBaseTypeLimitingValidator()));
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult2);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    rosettaObjectMapper.addMixIn(target, mixinSource);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type, rosettaObjectMapper));
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
  }

  /**
   * Method under test:
   * {@link JsonDataLoaderUtil#fromObject(Object, Class, ObjectMapper)}
   */
  @Test
  public void testFromObject22() {
    // Arrange
    Class<Object> type = Object.class;
    JsonTypeInfo.Value settings = mock(JsonTypeInfo.Value.class);
    when(settings.getIdVisible()).thenReturn(true);
    when(settings.getInclusionType()).thenReturn(JsonTypeInfo.As.PROPERTY);
    when(settings.getRequireTypeIdForSubtypes()).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(settings.getDefaultImpl()).thenReturn(forNameResult);
    when(settings.getPropertyName()).thenReturn("Property Name");
    when(settings.getIdType()).thenReturn(JsonTypeInfo.Id.CLASS);

    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();
    typer.init(settings, new ClassNameIdResolver(baseType, typeFactory, new DefaultBaseTypeLimitingValidator()));
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult2 = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult2);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    ObjectMapper rosettaObjectMapper = new ObjectMapper();
    rosettaObjectMapper.setConfig(config);
    Class<Object> target = Object.class;
    Class<Object> mixinSource = Object.class;
    rosettaObjectMapper.addMixIn(target, mixinSource);

    // Act
    Object actualFromObjectResult = JsonDataLoaderUtil.fromObject(QualificationReport.SUCCESS, type,
        rosettaObjectMapper);

    // Assert
    verify(settings).getDefaultImpl();
    verify(settings).getIdType();
    verify(settings).getIdVisible();
    verify(settings).getInclusionType();
    verify(settings).getPropertyName();
    verify(settings).getRequireTypeIdForSubtypes();
    verify(overrides, atLeast(1)).findMixInClassFor(Mockito.<Class<Object>>any());
    assertEquals(4, ((Map<String, Object>) actualFromObjectResult).size());
    Object getResult = ((Map<String, Object>) actualFromObjectResult).get("results");
    assertTrue(getResult instanceof List);
    assertTrue(actualFromObjectResult instanceof Map);
    assertNull(((Map<String, Object>) actualFromObjectResult).get("ingestedObject"));
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("qualifiableObjectsCount"));
    assertTrue(((Map<String, Object>) actualFromObjectResult).containsKey("uniquelyQualifiedObjectsCount"));
  }

  /**
   * Method under test: {@link JsonDataLoaderUtil#openURL(URL)}
   */
  @Test
  public void testOpenURL() throws MalformedURLException {
    // Arrange and Act
    Optional<Reader> actualOpenURLResult = JsonDataLoaderUtil
        .openURL(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL());

    // Assert
    assertFalse(actualOpenURLResult.isPresent());
  }

  /**
   * Method under test: {@link JsonDataLoaderUtil#openURL(URL)}
   */
  @Test
  public void testOpenURL2() throws MalformedURLException {
    // Arrange and Act
    Optional<Reader> actualOpenURLResult = JsonDataLoaderUtil
        .openURL(Paths.get(System.getProperty("java.io.tmpdir"), "").toUri().toURL());

    // Assert
    assertTrue(actualOpenURLResult.isPresent());
  }

  /**
   * Method under test: {@link JsonDataLoaderUtil#loadClass(String, ClassLoader)}
   */
  @Test
  public void testLoadClass() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> JsonDataLoaderUtil.loadClass("Type", new MLet()));
  }

  /**
   * Method under test: {@link JsonDataLoaderUtil#loadClass(String, ClassLoader)}
   */
  @Test
  public void testLoadClass2() {
    // Arrange and Act
    Class<?> actualLoadClassResult = JsonDataLoaderUtil.loadClass("java.util.List", new MLet());

    // Assert
    Class<List> expectedLoadClassResult = List.class;
    assertEquals(expectedLoadClassResult, actualLoadClassResult);
  }

  /**
   * Method under test: {@link JsonDataLoaderUtil#loadClass(String, ClassLoader)}
   */
  @Test
  public void testLoadClass3() throws MalformedURLException {
    // Arrange
    URLStreamHandlerFactory urlStreamHandlerFactory = mock(URLStreamHandlerFactory.class);
    when(urlStreamHandlerFactory.createURLStreamHandler(Mockito.<String>any())).thenReturn(new PlatformURLHandler());

    // Act
    Class<?> actualLoadClassResult = JsonDataLoaderUtil.loadClass("java.util.List",
        new URLClassLoader(new URL[]{Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()},
            new MLet(), urlStreamHandlerFactory));

    // Assert
    verify(urlStreamHandlerFactory).createURLStreamHandler(eq("jar"));
    Class<List> expectedLoadClassResult = List.class;
    assertEquals(expectedLoadClassResult, actualLoadClassResult);
  }
}
