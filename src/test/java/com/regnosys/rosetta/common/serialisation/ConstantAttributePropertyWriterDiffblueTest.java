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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import com.regnosys.rosetta.common.serialisation.mixin.RosettaJSONAnnotationIntrospector;
import com.regnosys.rosetta.common.serialisation.xml.VirtualXMLAttribute;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.Test;

public class ConstantAttributePropertyWriterDiffblueTest {
  /**
   * Method under test:
   * {@link ConstantAttributePropertyWriter#ConstantAttributePropertyWriter(String, BeanPropertyDefinition, Annotations, JavaType, String)}
   */
  @Test
  public void testNewConstantAttributePropertyWriter() {
    // Arrange
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

    PropertyName internalName = PropertyName.construct("Simple Name");
    POJOPropertyBuilder propDef = new POJOPropertyBuilder(config, null, true, internalName);

    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);

    // Act
    ConstantAttributePropertyWriter actualConstantAttributePropertyWriter = new ConstantAttributePropertyWriter(
        "Attr Name", propDef, contextAnnotations, declaredType, "42");

    // Assert
    SerializableString serializedName = actualConstantAttributePropertyWriter.getSerializedName();
    assertTrue(serializedName instanceof SerializedString);
    assertEquals("Simple Name", serializedName.getValue());
    assertEquals("Simple Name", actualConstantAttributePropertyWriter.getName());
    assertEquals("Simple Name", serializedName.toString());
    assertNull(actualConstantAttributePropertyWriter.getViews());
    PropertyMetadata metadata = actualConstantAttributePropertyWriter.getMetadata();
    assertNull(metadata.getContentNulls());
    assertNull(metadata.getValueNulls());
    assertNull(actualConstantAttributePropertyWriter.getSerializationType());
    assertNull(actualConstantAttributePropertyWriter.getSerializer());
    assertNull(metadata.getMergeInfo());
    assertNull(actualConstantAttributePropertyWriter.getWrapperName());
    assertNull(actualConstantAttributePropertyWriter.getMember());
    assertNull(actualConstantAttributePropertyWriter.getTypeSerializer());
    assertNull(metadata.getRequired());
    assertNull(actualConstantAttributePropertyWriter.getPropertyType());
    assertNull(actualConstantAttributePropertyWriter.getRawSerializationType());
    assertNull(metadata.getIndex());
    assertNull(metadata.getDefaultValue());
    assertNull(metadata.getDescription());
    assertNull(actualConstantAttributePropertyWriter.getGenericPropertyType());
    assertFalse(metadata.hasDefaultValue());
    assertFalse(metadata.hasIndex());
    assertFalse(actualConstantAttributePropertyWriter.isRequired());
    assertFalse(actualConstantAttributePropertyWriter.hasNullSerializer());
    assertFalse(actualConstantAttributePropertyWriter.hasSerializer());
    assertFalse(actualConstantAttributePropertyWriter.isUnwrapping());
    assertTrue(actualConstantAttributePropertyWriter.isVirtual());
    assertEquals(internalName, actualConstantAttributePropertyWriter.getFullName());
    assertSame(declaredType, actualConstantAttributePropertyWriter.getType());
  }

  /**
   * Method under test:
   * {@link ConstantAttributePropertyWriter#value(Object, JsonGenerator, SerializerProvider)}
   */
  @Test
  public void testValue() throws Exception {
    // Arrange
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
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
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    POJOPropertyBuilder propDef = new POJOPropertyBuilder(config, null, true, PropertyName.construct("Simple Name"));

    AnnotationMap contextAnnotations = new AnnotationMap();
    ConstantAttributePropertyWriter constantAttributePropertyWriter = new ConstantAttributePropertyWriter("Attr Name",
        propDef, contextAnnotations, new PlaceholderForType(1), "42");
    JsonGeneratorDelegate jgen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class)), true);

    // Act and Assert
    assertEquals("42", constantAttributePropertyWriter.value("Bean", jgen, new DefaultSerializerProvider.Impl()));
  }

  /**
   * Method under test:
   * {@link ConstantAttributePropertyWriter#ConstantAttributePropertyWriter(String, BeanPropertyDefinition, Annotations, JavaType, String)}
   */
  @Test
  public void testNewConstantAttributePropertyWriter2() {
    // Arrange
    SimpleBeanPropertyDefinition propDef = mock(SimpleBeanPropertyDefinition.class);
    PropertyName constructResult = PropertyName.construct("Simple Name");
    when(propDef.getWrapperName()).thenReturn(constructResult);
    when(propDef.findInclusion()).thenReturn(JsonInclude.Value.empty());
    when(propDef.getMetadata()).thenReturn(mock(PropertyMetadata.class));
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute virtualXMLAttribute = new VirtualXMLAttribute(declaringClass, "Name",
        new PlaceholderForType(1));

    when(propDef.getPrimaryMember()).thenReturn(virtualXMLAttribute);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);

    // Act
    ConstantAttributePropertyWriter actualConstantAttributePropertyWriter = new ConstantAttributePropertyWriter(
        "Attr Name", propDef, contextAnnotations, declaredType, "42");

    // Assert
    verify(propDef).findInclusion();
    verify(propDef).getMetadata();
    verify(propDef).getName();
    verify(propDef).getPrimaryMember();
    verify(propDef).getWrapperName();
    SerializableString serializedName = actualConstantAttributePropertyWriter.getSerializedName();
    assertTrue(serializedName instanceof SerializedString);
    assertEquals("Name", serializedName.getValue());
    PropertyName fullName = actualConstantAttributePropertyWriter.getFullName();
    assertEquals("Name", fullName.getSimpleName());
    assertEquals("Name", actualConstantAttributePropertyWriter.getName());
    assertEquals("Name", serializedName.toString());
    assertNull(actualConstantAttributePropertyWriter.getViews());
    assertNull(actualConstantAttributePropertyWriter.getSerializationType());
    assertNull(actualConstantAttributePropertyWriter.getSerializer());
    assertNull(actualConstantAttributePropertyWriter.getTypeSerializer());
    assertNull(actualConstantAttributePropertyWriter.getPropertyType());
    assertNull(actualConstantAttributePropertyWriter.getRawSerializationType());
    assertNull(fullName.getNamespace());
    assertNull(actualConstantAttributePropertyWriter.getGenericPropertyType());
    assertFalse(fullName.hasNamespace());
    assertFalse(fullName.isEmpty());
    assertFalse(actualConstantAttributePropertyWriter.isRequired());
    assertFalse(actualConstantAttributePropertyWriter.hasNullSerializer());
    assertFalse(actualConstantAttributePropertyWriter.hasSerializer());
    assertFalse(actualConstantAttributePropertyWriter.isUnwrapping());
    assertTrue(fullName.hasSimpleName());
    assertTrue(actualConstantAttributePropertyWriter.isVirtual());
    assertSame(declaredType, actualConstantAttributePropertyWriter.getType());
    assertSame(virtualXMLAttribute, actualConstantAttributePropertyWriter.getMember());
    assertSame(constructResult, actualConstantAttributePropertyWriter.getWrapperName());
  }

  /**
   * Method under test:
   * {@link ConstantAttributePropertyWriter#ConstantAttributePropertyWriter(String, BeanPropertyDefinition, Annotations, JavaType, String)}
   */
  @Test
  public void testNewConstantAttributePropertyWriter3() {
    // Arrange
    SimpleBeanPropertyDefinition propDef = mock(SimpleBeanPropertyDefinition.class);
    PropertyName constructResult = PropertyName.construct("Simple Name");
    when(propDef.getWrapperName()).thenReturn(constructResult);
    when(propDef.findInclusion())
        .thenReturn(JsonInclude.Value.construct(JsonInclude.Include.ALWAYS, JsonInclude.Include.ALWAYS));
    when(propDef.getMetadata()).thenReturn(mock(PropertyMetadata.class));
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute virtualXMLAttribute = new VirtualXMLAttribute(declaringClass, "Name",
        new PlaceholderForType(1));

    when(propDef.getPrimaryMember()).thenReturn(virtualXMLAttribute);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);

    // Act
    ConstantAttributePropertyWriter actualConstantAttributePropertyWriter = new ConstantAttributePropertyWriter(
        "Attr Name", propDef, contextAnnotations, declaredType, "42");

    // Assert
    verify(propDef).findInclusion();
    verify(propDef).getMetadata();
    verify(propDef).getName();
    verify(propDef).getPrimaryMember();
    verify(propDef).getWrapperName();
    SerializableString serializedName = actualConstantAttributePropertyWriter.getSerializedName();
    assertTrue(serializedName instanceof SerializedString);
    assertEquals("Name", serializedName.getValue());
    PropertyName fullName = actualConstantAttributePropertyWriter.getFullName();
    assertEquals("Name", fullName.getSimpleName());
    assertEquals("Name", actualConstantAttributePropertyWriter.getName());
    assertEquals("Name", serializedName.toString());
    assertNull(actualConstantAttributePropertyWriter.getViews());
    assertNull(actualConstantAttributePropertyWriter.getSerializationType());
    assertNull(actualConstantAttributePropertyWriter.getSerializer());
    assertNull(actualConstantAttributePropertyWriter.getTypeSerializer());
    assertNull(actualConstantAttributePropertyWriter.getPropertyType());
    assertNull(actualConstantAttributePropertyWriter.getRawSerializationType());
    assertNull(fullName.getNamespace());
    assertNull(actualConstantAttributePropertyWriter.getGenericPropertyType());
    assertFalse(fullName.hasNamespace());
    assertFalse(fullName.isEmpty());
    assertFalse(actualConstantAttributePropertyWriter.isRequired());
    assertFalse(actualConstantAttributePropertyWriter.hasNullSerializer());
    assertFalse(actualConstantAttributePropertyWriter.hasSerializer());
    assertFalse(actualConstantAttributePropertyWriter.isUnwrapping());
    assertTrue(fullName.hasSimpleName());
    assertTrue(actualConstantAttributePropertyWriter.isVirtual());
    assertSame(declaredType, actualConstantAttributePropertyWriter.getType());
    assertSame(virtualXMLAttribute, actualConstantAttributePropertyWriter.getMember());
    assertSame(constructResult, actualConstantAttributePropertyWriter.getWrapperName());
  }

  /**
   * Method under test:
   * {@link ConstantAttributePropertyWriter#ConstantAttributePropertyWriter(String, BeanPropertyDefinition, Annotations, JavaType, String)}
   */
  @Test
  public void testNewConstantAttributePropertyWriter4() {
    // Arrange
    SimpleBeanPropertyDefinition propDef = mock(SimpleBeanPropertyDefinition.class);
    PropertyName constructResult = PropertyName.construct("Simple Name");
    when(propDef.getWrapperName()).thenReturn(constructResult);
    when(propDef.findInclusion()).thenReturn(null);
    when(propDef.getMetadata()).thenReturn(mock(PropertyMetadata.class));
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute virtualXMLAttribute = new VirtualXMLAttribute(declaringClass, "Name",
        new PlaceholderForType(1));

    when(propDef.getPrimaryMember()).thenReturn(virtualXMLAttribute);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);

    // Act
    ConstantAttributePropertyWriter actualConstantAttributePropertyWriter = new ConstantAttributePropertyWriter(
        "Attr Name", propDef, contextAnnotations, declaredType, "42");

    // Assert
    verify(propDef).findInclusion();
    verify(propDef).getMetadata();
    verify(propDef).getName();
    verify(propDef).getPrimaryMember();
    verify(propDef).getWrapperName();
    SerializableString serializedName = actualConstantAttributePropertyWriter.getSerializedName();
    assertTrue(serializedName instanceof SerializedString);
    assertEquals("Name", serializedName.getValue());
    PropertyName fullName = actualConstantAttributePropertyWriter.getFullName();
    assertEquals("Name", fullName.getSimpleName());
    assertEquals("Name", actualConstantAttributePropertyWriter.getName());
    assertEquals("Name", serializedName.toString());
    assertNull(actualConstantAttributePropertyWriter.getViews());
    assertNull(actualConstantAttributePropertyWriter.getSerializationType());
    assertNull(actualConstantAttributePropertyWriter.getSerializer());
    assertNull(actualConstantAttributePropertyWriter.getTypeSerializer());
    assertNull(actualConstantAttributePropertyWriter.getPropertyType());
    assertNull(actualConstantAttributePropertyWriter.getRawSerializationType());
    assertNull(fullName.getNamespace());
    assertNull(actualConstantAttributePropertyWriter.getGenericPropertyType());
    assertFalse(fullName.hasNamespace());
    assertFalse(fullName.isEmpty());
    assertFalse(actualConstantAttributePropertyWriter.isRequired());
    assertFalse(actualConstantAttributePropertyWriter.hasNullSerializer());
    assertFalse(actualConstantAttributePropertyWriter.hasSerializer());
    assertFalse(actualConstantAttributePropertyWriter.isUnwrapping());
    assertTrue(fullName.hasSimpleName());
    assertTrue(actualConstantAttributePropertyWriter.isVirtual());
    assertSame(declaredType, actualConstantAttributePropertyWriter.getType());
    assertSame(virtualXMLAttribute, actualConstantAttributePropertyWriter.getMember());
    assertSame(constructResult, actualConstantAttributePropertyWriter.getWrapperName());
  }

  /**
   * Method under test:
   * {@link ConstantAttributePropertyWriter#ConstantAttributePropertyWriter(String, BeanPropertyDefinition, Annotations, JavaType, String)}
   */
  @Test
  public void testNewConstantAttributePropertyWriter5() {
    // Arrange
    SimpleBeanPropertyDefinition propDef = mock(SimpleBeanPropertyDefinition.class);
    PropertyName constructResult = PropertyName.construct("Simple Name");
    when(propDef.getWrapperName()).thenReturn(constructResult);
    when(propDef.findInclusion())
        .thenReturn(JsonInclude.Value.construct(JsonInclude.Include.NON_NULL, JsonInclude.Include.ALWAYS));
    when(propDef.getMetadata()).thenReturn(mock(PropertyMetadata.class));
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute virtualXMLAttribute = new VirtualXMLAttribute(declaringClass, "Name",
        new PlaceholderForType(1));

    when(propDef.getPrimaryMember()).thenReturn(virtualXMLAttribute);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);

    // Act
    ConstantAttributePropertyWriter actualConstantAttributePropertyWriter = new ConstantAttributePropertyWriter(
        "Attr Name", propDef, contextAnnotations, declaredType, "42");

    // Assert
    verify(propDef).findInclusion();
    verify(propDef).getMetadata();
    verify(propDef).getName();
    verify(propDef).getPrimaryMember();
    verify(propDef).getWrapperName();
    SerializableString serializedName = actualConstantAttributePropertyWriter.getSerializedName();
    assertTrue(serializedName instanceof SerializedString);
    assertEquals("Name", serializedName.getValue());
    PropertyName fullName = actualConstantAttributePropertyWriter.getFullName();
    assertEquals("Name", fullName.getSimpleName());
    assertEquals("Name", actualConstantAttributePropertyWriter.getName());
    assertEquals("Name", serializedName.toString());
    assertNull(actualConstantAttributePropertyWriter.getViews());
    assertNull(actualConstantAttributePropertyWriter.getSerializationType());
    assertNull(actualConstantAttributePropertyWriter.getSerializer());
    assertNull(actualConstantAttributePropertyWriter.getTypeSerializer());
    assertNull(actualConstantAttributePropertyWriter.getPropertyType());
    assertNull(actualConstantAttributePropertyWriter.getRawSerializationType());
    assertNull(fullName.getNamespace());
    assertNull(actualConstantAttributePropertyWriter.getGenericPropertyType());
    assertFalse(fullName.hasNamespace());
    assertFalse(fullName.isEmpty());
    assertFalse(actualConstantAttributePropertyWriter.isRequired());
    assertFalse(actualConstantAttributePropertyWriter.hasNullSerializer());
    assertFalse(actualConstantAttributePropertyWriter.hasSerializer());
    assertFalse(actualConstantAttributePropertyWriter.isUnwrapping());
    assertTrue(fullName.hasSimpleName());
    assertTrue(actualConstantAttributePropertyWriter.isVirtual());
    assertSame(declaredType, actualConstantAttributePropertyWriter.getType());
    assertSame(virtualXMLAttribute, actualConstantAttributePropertyWriter.getMember());
    assertSame(constructResult, actualConstantAttributePropertyWriter.getWrapperName());
  }

  /**
   * Method under test:
   * {@link ConstantAttributePropertyWriter#ConstantAttributePropertyWriter(String, BeanPropertyDefinition, Annotations, JavaType, String)}
   */
  @Test
  public void testNewConstantAttributePropertyWriter6() {
    // Arrange
    SimpleBeanPropertyDefinition propDef = mock(SimpleBeanPropertyDefinition.class);
    PropertyName constructResult = PropertyName.construct("Simple Name");
    when(propDef.getWrapperName()).thenReturn(constructResult);
    when(propDef.findInclusion())
        .thenReturn(JsonInclude.Value.construct(JsonInclude.Include.NON_ABSENT, JsonInclude.Include.ALWAYS));
    when(propDef.getMetadata()).thenReturn(mock(PropertyMetadata.class));
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute virtualXMLAttribute = new VirtualXMLAttribute(declaringClass, "Name",
        new PlaceholderForType(1));

    when(propDef.getPrimaryMember()).thenReturn(virtualXMLAttribute);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);

    // Act
    ConstantAttributePropertyWriter actualConstantAttributePropertyWriter = new ConstantAttributePropertyWriter(
        "Attr Name", propDef, contextAnnotations, declaredType, "42");

    // Assert
    verify(propDef).findInclusion();
    verify(propDef).getMetadata();
    verify(propDef).getName();
    verify(propDef).getPrimaryMember();
    verify(propDef).getWrapperName();
    SerializableString serializedName = actualConstantAttributePropertyWriter.getSerializedName();
    assertTrue(serializedName instanceof SerializedString);
    assertEquals("Name", serializedName.getValue());
    PropertyName fullName = actualConstantAttributePropertyWriter.getFullName();
    assertEquals("Name", fullName.getSimpleName());
    assertEquals("Name", actualConstantAttributePropertyWriter.getName());
    assertEquals("Name", serializedName.toString());
    assertNull(actualConstantAttributePropertyWriter.getViews());
    assertNull(actualConstantAttributePropertyWriter.getSerializationType());
    assertNull(actualConstantAttributePropertyWriter.getSerializer());
    assertNull(actualConstantAttributePropertyWriter.getTypeSerializer());
    assertNull(actualConstantAttributePropertyWriter.getPropertyType());
    assertNull(actualConstantAttributePropertyWriter.getRawSerializationType());
    assertNull(fullName.getNamespace());
    assertNull(actualConstantAttributePropertyWriter.getGenericPropertyType());
    assertFalse(fullName.hasNamespace());
    assertFalse(fullName.isEmpty());
    assertFalse(actualConstantAttributePropertyWriter.isRequired());
    assertFalse(actualConstantAttributePropertyWriter.hasNullSerializer());
    assertFalse(actualConstantAttributePropertyWriter.hasSerializer());
    assertFalse(actualConstantAttributePropertyWriter.isUnwrapping());
    assertTrue(fullName.hasSimpleName());
    assertTrue(actualConstantAttributePropertyWriter.isVirtual());
    assertSame(declaredType, actualConstantAttributePropertyWriter.getType());
    assertSame(virtualXMLAttribute, actualConstantAttributePropertyWriter.getMember());
    assertSame(constructResult, actualConstantAttributePropertyWriter.getWrapperName());
  }
}
