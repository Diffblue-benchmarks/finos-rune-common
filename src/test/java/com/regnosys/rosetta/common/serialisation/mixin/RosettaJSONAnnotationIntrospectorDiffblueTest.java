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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.fasterxml.jackson.databind.introspect.VirtualAnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.regnosys.rosetta.common.serialisation.mixin.legacy.LegacyRosettaBuilderIntrospector;
import com.regnosys.rosetta.common.serialisation.xml.VirtualXMLAttribute;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.Test;

public class RosettaJSONAnnotationIntrospectorDiffblueTest {
  /**
   * Method under test:
   * {@link RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}
   */
  @Test
  public void testFindNameForSerialization() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector = new RosettaJSONAnnotationIntrospector(true);
    Class<Object> declaringClass = Object.class;

    // Act and Assert
    assertNull(rosettaJSONAnnotationIntrospector
        .findNameForSerialization(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1))));
  }

  /**
   * Method under test:
   * {@link RosettaJSONAnnotationIntrospector#findNameForSerialization(Annotated)}
   */
  @Test
  public void testFindNameForSerialization2() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector = new RosettaJSONAnnotationIntrospector(true);
    Class<Object> declaringClass = Object.class;

    // Act and Assert
    assertNull(rosettaJSONAnnotationIntrospector
        .findNameForSerialization(new VirtualXMLAttribute(declaringClass, "Name", mock(CollectionLikeType.class))));
  }

  /**
   * Method under test:
   * {@link RosettaJSONAnnotationIntrospector#findNameForDeserialization(Annotated)}
   */
  @Test
  public void testFindNameForDeserialization() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector = new RosettaJSONAnnotationIntrospector(true);
    Class<Object> declaringClass = Object.class;

    // Act and Assert
    assertNull(rosettaJSONAnnotationIntrospector
        .findNameForDeserialization(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1))));
  }

  /**
   * Method under test:
   * {@link RosettaJSONAnnotationIntrospector#findNameForDeserialization(Annotated)}
   */
  @Test
  public void testFindNameForDeserialization2() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector = new RosettaJSONAnnotationIntrospector(false);
    TypeResolutionContext typeContext = mock(TypeResolutionContext.class);
    Class<Object> declaringClass = Object.class;

    // Act and Assert
    assertNull(rosettaJSONAnnotationIntrospector.findNameForDeserialization(
        new VirtualAnnotatedMember(typeContext, declaringClass, "Name", new PlaceholderForType(1))));
  }

  /**
   * Method under test:
   * {@link RosettaJSONAnnotationIntrospector#findNameForDeserialization(Annotated)}
   */
  @Test
  public void testFindNameForDeserialization3() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector = new RosettaJSONAnnotationIntrospector(false);
    PlaceholderForType type = new PlaceholderForType(1);
    TypeResolutionContext typeContext = mock(TypeResolutionContext.class);

    // Act and Assert
    assertNull(rosettaJSONAnnotationIntrospector
        .findNameForDeserialization(new AnnotatedParameter(null, type, typeContext, new AnnotationMap(), 1)));
  }

  /**
   * Method under test:
   * {@link RosettaJSONAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig, Annotated)}
   */
  @Test
  public void testFindPropertyIgnoralByName() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector = new RosettaJSONAnnotationIntrospector(true);
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
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    Class<Object> declaringClass = Object.class;

    // Act
    JsonIgnoreProperties.Value actualFindPropertyIgnoralByNameResult = rosettaJSONAnnotationIntrospector
        .findPropertyIgnoralByName(config, new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));

    // Assert
    assertFalse(actualFindPropertyIgnoralByNameResult.getAllowGetters());
    assertFalse(actualFindPropertyIgnoralByNameResult.getAllowSetters());
    assertFalse(actualFindPropertyIgnoralByNameResult.getIgnoreUnknown());
    assertTrue(actualFindPropertyIgnoralByNameResult.getMerge());
    assertTrue(actualFindPropertyIgnoralByNameResult.getIgnored().isEmpty());
  }

  /**
   * Method under test:
   * {@link RosettaJSONAnnotationIntrospector#findPropertyIgnoralByName(MapperConfig, Annotated)}
   */
  @Test
  public void testFindPropertyIgnoralByName2() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector = new RosettaJSONAnnotationIntrospector(false);
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
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    Class<Object> declaringClass = Object.class;

    // Act
    JsonIgnoreProperties.Value actualFindPropertyIgnoralByNameResult = rosettaJSONAnnotationIntrospector
        .findPropertyIgnoralByName(config, new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));

    // Assert
    assertFalse(actualFindPropertyIgnoralByNameResult.getAllowGetters());
    assertFalse(actualFindPropertyIgnoralByNameResult.getAllowSetters());
    assertFalse(actualFindPropertyIgnoralByNameResult.getIgnoreUnknown());
    assertTrue(actualFindPropertyIgnoralByNameResult.getMerge());
    assertTrue(actualFindPropertyIgnoralByNameResult.getIgnored().isEmpty());
  }

  /**
   * Method under test:
   * {@link RosettaJSONAnnotationIntrospector#findPropertyIgnorals(Annotated)}
   */
  @Test
  public void testFindPropertyIgnorals() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector = new RosettaJSONAnnotationIntrospector(true);
    Class<Object> declaringClass = Object.class;

    // Act
    JsonIgnoreProperties.Value actualFindPropertyIgnoralsResult = rosettaJSONAnnotationIntrospector
        .findPropertyIgnorals(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));

    // Assert
    assertFalse(actualFindPropertyIgnoralsResult.getAllowGetters());
    assertFalse(actualFindPropertyIgnoralsResult.getAllowSetters());
    assertFalse(actualFindPropertyIgnoralsResult.getIgnoreUnknown());
    assertTrue(actualFindPropertyIgnoralsResult.getMerge());
    assertTrue(actualFindPropertyIgnoralsResult.getIgnored().isEmpty());
  }

  /**
   * Method under test:
   * {@link RosettaJSONAnnotationIntrospector#findPropertyIgnorals(Annotated)}
   */
  @Test
  public void testFindPropertyIgnorals2() {
    // Arrange
    RosettaJSONAnnotationIntrospector rosettaJSONAnnotationIntrospector = new RosettaJSONAnnotationIntrospector(false);
    TypeResolutionContext typeContext = mock(TypeResolutionContext.class);
    Class<Object> declaringClass = Object.class;

    // Act
    JsonIgnoreProperties.Value actualFindPropertyIgnoralsResult = rosettaJSONAnnotationIntrospector
        .findPropertyIgnorals(
            new VirtualAnnotatedMember(typeContext, declaringClass, "Name", new PlaceholderForType(1)));

    // Assert
    assertFalse(actualFindPropertyIgnoralsResult.getAllowGetters());
    assertFalse(actualFindPropertyIgnoralsResult.getAllowSetters());
    assertFalse(actualFindPropertyIgnoralsResult.getIgnoreUnknown());
    assertTrue(actualFindPropertyIgnoralsResult.getMerge());
    assertTrue(actualFindPropertyIgnoralsResult.getIgnored().isEmpty());
  }

  /**
   * Method under test: {@link RosettaJSONAnnotationIntrospector#version()}
   */
  @Test
  public void testVersion() {
    // Arrange and Act
    Version actualVersionResult = (new RosettaJSONAnnotationIntrospector(true)).version();

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

  /**
   * Method under test:
   * {@link RosettaJSONAnnotationIntrospector#RosettaJSONAnnotationIntrospector(LegacyRosettaBuilderIntrospector, EnumAsStringBuilderIntrospector, RosettaEnumBuilderIntrospector)}
   */
  @Test
  public void testNewRosettaJSONAnnotationIntrospector() {
    // Arrange
    LegacyRosettaBuilderIntrospector legacyRosettaBuilderIntrospector = new LegacyRosettaBuilderIntrospector();
    EnumAsStringBuilderIntrospector enumAsStringBuilderIntrospector = new EnumAsStringBuilderIntrospector();

    // Act and Assert
    Version versionResult = (new RosettaJSONAnnotationIntrospector(legacyRosettaBuilderIntrospector,
        enumAsStringBuilderIntrospector, new RosettaEnumBuilderIntrospector(true))).version();
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
   * Method under test:
   * {@link RosettaJSONAnnotationIntrospector#RosettaJSONAnnotationIntrospector(boolean)}
   */
  @Test
  public void testNewRosettaJSONAnnotationIntrospector2() {
    // Arrange, Act and Assert
    Version versionResult = (new RosettaJSONAnnotationIntrospector(true)).version();
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
   * Method under test:
   * {@link RosettaJSONAnnotationIntrospector#RosettaJSONAnnotationIntrospector(boolean)}
   */
  @Test
  public void testNewRosettaJSONAnnotationIntrospector3() {
    // Arrange, Act and Assert
    Version versionResult = (new RosettaJSONAnnotationIntrospector(false)).version();
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
}
