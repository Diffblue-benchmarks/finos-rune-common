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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Value;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator.Builder;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import com.regnosys.rosetta.common.serialisation.xml.VirtualXMLAttribute;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConstantAttributePropertyWriterDiffblueTest {
  /**
   * Test {@link ConstantAttributePropertyWriter#ConstantAttributePropertyWriter(String,
   * BeanPropertyDefinition, Annotations, JavaType, String)}.
   *
   * <ul>
   *   <li>Then Member return {@link VirtualXMLAttribute}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConstantAttributePropertyWriter#ConstantAttributePropertyWriter(String, BeanPropertyDefinition,
   * Annotations, JavaType, String)}
   */
  @Test
  @DisplayName(
      "Test new ConstantAttributePropertyWriter(String, BeanPropertyDefinition, Annotations, JavaType, String); then Member return VirtualXMLAttribute")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantAttributePropertyWriter.<init>(String, BeanPropertyDefinition, Annotations, JavaType, String)"
  })
  void testNewConstantAttributePropertyWriter_thenMemberReturnVirtualXMLAttribute() {
    // Arrange
    SimpleBeanPropertyDefinition propDef = mock(SimpleBeanPropertyDefinition.class);
    PropertyName constructResult = PropertyName.construct("Simple Name");
    when(propDef.getWrapperName()).thenReturn(constructResult);
    when(propDef.findInclusion()).thenReturn(Value.empty());
    when(propDef.getMetadata()).thenReturn(mock(PropertyMetadata.class));
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute virtualXMLAttribute =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));
    when(propDef.getPrimaryMember()).thenReturn(virtualXMLAttribute);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();

    // Act
    ConstantAttributePropertyWriter actualConstantAttributePropertyWriter =
        new ConstantAttributePropertyWriter(
            "Attr Name", propDef, contextAnnotations, new PlaceholderForType(1), "42");

    // Assert
    verify(propDef).findInclusion();
    verify(propDef).getMetadata();
    verify(propDef).getName();
    verify(propDef).getPrimaryMember();
    verify(propDef).getWrapperName();
    AnnotatedMember member = actualConstantAttributePropertyWriter.getMember();
    assertTrue(member instanceof VirtualXMLAttribute);
    assertEquals("Name", actualConstantAttributePropertyWriter.getName());
    assertSame(virtualXMLAttribute, member);
    assertSame(constructResult, actualConstantAttributePropertyWriter.getWrapperName());
  }

  /**
   * Test {@link ConstantAttributePropertyWriter#ConstantAttributePropertyWriter(String,
   * BeanPropertyDefinition, Annotations, JavaType, String)}.
   *
   * <ul>
   *   <li>Then return Name is {@code Simple Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ConstantAttributePropertyWriter#ConstantAttributePropertyWriter(String, BeanPropertyDefinition,
   * Annotations, JavaType, String)}
   */
  @Test
  @DisplayName(
      "Test new ConstantAttributePropertyWriter(String, BeanPropertyDefinition, Annotations, JavaType, String); then return Name is 'Simple Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantAttributePropertyWriter.<init>(String, BeanPropertyDefinition, Annotations, JavaType, String)"
  })
  void testNewConstantAttributePropertyWriter_thenReturnNameIsSimpleName() {
    // Arrange
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
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config =
        new DeserializationConfig(
            base,
            str,
            mixins,
            rootNames,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    PropertyName internalName = PropertyName.construct("Simple Name");

    POJOPropertyBuilder propDef = new POJOPropertyBuilder(config, null, true, internalName);
    AnnotationMap contextAnnotations = new AnnotationMap();

    // Act
    ConstantAttributePropertyWriter actualConstantAttributePropertyWriter =
        new ConstantAttributePropertyWriter(
            "Attr Name", propDef, contextAnnotations, new PlaceholderForType(1), "42");

    // Assert
    assertEquals("Simple Name", actualConstantAttributePropertyWriter.getName());
    assertNull(actualConstantAttributePropertyWriter.getWrapperName());
    assertNull(actualConstantAttributePropertyWriter.getMember());
    assertEquals(internalName, actualConstantAttributePropertyWriter.getFullName());
  }

  /**
   * Test {@link ConstantAttributePropertyWriter#value(Object, JsonGenerator, SerializerProvider)}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantAttributePropertyWriter#value(Object, JsonGenerator,
   * SerializerProvider)}
   */
  @Test
  @DisplayName("Test value(Object, JsonGenerator, SerializerProvider); then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ConstantAttributePropertyWriter.value(Object, JsonGenerator, SerializerProvider)"
  })
  void testValue_thenReturn42() throws Exception {
    // Arrange
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer = new StdTypeResolverBuilder();
    BasicPolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder().build();

    BaseSettings base =
        new BaseSettings(
            ci,
            ai,
            pns,
            tf,
            typer,
            new SimpleDateFormat("yyyy/mm/dd"),
            mock(HandlerInstantiator.class),
            Locale.getDefault(),
            TimeZone.getTimeZone("America/Los_Angeles"),
            Base64Variants.getDefaultVariant(),
            ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config =
        new DeserializationConfig(
            base,
            str,
            mixins,
            rootNames,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    POJOPropertyBuilder propDef =
        new POJOPropertyBuilder(config, null, true, PropertyName.construct("Simple Name"));
    AnnotationMap contextAnnotations = new AnnotationMap();

    ConstantAttributePropertyWriter constantAttributePropertyWriter =
        new ConstantAttributePropertyWriter(
            "Attr Name", propDef, contextAnnotations, new PlaceholderForType(1), "42");
    JsonGeneratorDelegate d = new JsonGeneratorDelegate(mock(JsonGenerator.class));
    JsonGeneratorDelegate jgen = new JsonGeneratorDelegate(d, true);

    // Act and Assert
    assertEquals(
        "42",
        constantAttributePropertyWriter.value(
            BeanPropertyWriter.MARKER_FOR_EMPTY, jgen, new Impl()));
  }
}
