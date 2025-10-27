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
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.regnosys.rosetta.common.serialisation.mixin.RosettaJSONAnnotationIntrospector;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.Test;

public class SubstitutingBeanPropertyWriterDiffblueTest {
  /**
   * Method under test:
   * {@link SubstitutingBeanPropertyWriter#SubstitutingBeanPropertyWriter(BeanPropertyWriter, SubstitutionMap)}
   */
  @Test
  public void testNewSubstitutingBeanPropertyWriter() {
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

    RosettaJSONAnnotationIntrospector ai2 = new RosettaJSONAnnotationIntrospector(true);
    PropertyName internalName = PropertyName.construct("Simple Name");
    POJOPropertyBuilder propDef = new POJOPropertyBuilder(config, ai2, true, internalName);

    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member = new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();
    PlaceholderForType serType = new PlaceholderForType(1);
    BeanPropertyWriter base2 = new BeanPropertyWriter(propDef, member, contextAnnotations, declaredType, ser, typeSer,
        serType, true, "Suppressable Value");

    // Act
    SubstitutingBeanPropertyWriter actualSubstitutingBeanPropertyWriter = new SubstitutingBeanPropertyWriter(base2,
        new SubstitutionMap(new HashMap<>()));

    // Assert
    SerializableString serializedName = actualSubstitutingBeanPropertyWriter.getSerializedName();
    assertTrue(serializedName instanceof SerializedString);
    assertEquals("Simple Name", serializedName.getValue());
    assertEquals("Simple Name", actualSubstitutingBeanPropertyWriter.getName());
    assertEquals("Simple Name", serializedName.toString());
    assertNull(actualSubstitutingBeanPropertyWriter.getViews());
    PropertyMetadata metadata = actualSubstitutingBeanPropertyWriter.getMetadata();
    assertNull(metadata.getContentNulls());
    assertNull(metadata.getValueNulls());
    assertNull(metadata.getMergeInfo());
    assertNull(actualSubstitutingBeanPropertyWriter.getWrapperName());
    assertNull(metadata.getRequired());
    assertNull(actualSubstitutingBeanPropertyWriter.getPropertyType());
    assertNull(metadata.getIndex());
    assertNull(metadata.getDefaultValue());
    assertNull(metadata.getDescription());
    assertNull(actualSubstitutingBeanPropertyWriter.getGenericPropertyType());
    assertFalse(metadata.hasDefaultValue());
    assertFalse(metadata.hasIndex());
    assertFalse(actualSubstitutingBeanPropertyWriter.isRequired());
    assertFalse(actualSubstitutingBeanPropertyWriter.isVirtual());
    assertFalse(actualSubstitutingBeanPropertyWriter.hasNullSerializer());
    assertFalse(actualSubstitutingBeanPropertyWriter.isUnwrapping());
    assertTrue(actualSubstitutingBeanPropertyWriter.hasSerializer());
    assertEquals(internalName, actualSubstitutingBeanPropertyWriter.getFullName());
    Class<Object> expectedRawSerializationType = Object.class;
    Class<?> rawSerializationType = actualSubstitutingBeanPropertyWriter.getRawSerializationType();
    assertEquals(expectedRawSerializationType, rawSerializationType);
    assertSame(ser, actualSubstitutingBeanPropertyWriter.getSerializer());
    assertSame(serType, actualSubstitutingBeanPropertyWriter.getSerializationType());
    assertSame(declaredType, actualSubstitutingBeanPropertyWriter.getType());
    assertSame(member, actualSubstitutingBeanPropertyWriter.getMember());
    assertSame(typeSer, actualSubstitutingBeanPropertyWriter.getTypeSerializer());
    assertSame(declaringClass, rawSerializationType);
  }

  /**
   * Method under test: {@link SubstitutingBeanPropertyWriter#_new(PropertyName)}
   */
  @Test
  public void test_new() {
    // Arrange
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(null, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyName internalName = PropertyName.construct("Simple Name");
    POJOPropertyBuilder propDef = new POJOPropertyBuilder(config, ai, true, internalName);

    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member = new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();
    PlaceholderForType serType = new PlaceholderForType(1);
    BeanPropertyWriter base = new BeanPropertyWriter(propDef, member, contextAnnotations, declaredType, ser, typeSer,
        serType, true, "Suppressable Value");

    SubstitutingBeanPropertyWriter substitutingBeanPropertyWriter = new SubstitutingBeanPropertyWriter(base,
        new SubstitutionMap(new HashMap<>()));

    // Act
    SubstitutingBeanPropertyWriter actual_newResult = substitutingBeanPropertyWriter
        ._new(PropertyName.construct("Simple Name"));

    // Assert
    SerializableString serializedName = actual_newResult.getSerializedName();
    assertTrue(serializedName instanceof SerializedString);
    assertEquals("Simple Name", serializedName.getValue());
    assertEquals("Simple Name", actual_newResult.getName());
    assertEquals("Simple Name", serializedName.toString());
    assertNull(actual_newResult.getViews());
    PropertyMetadata metadata = actual_newResult.getMetadata();
    assertNull(metadata.getContentNulls());
    assertNull(metadata.getValueNulls());
    assertNull(metadata.getMergeInfo());
    assertNull(actual_newResult.getWrapperName());
    assertNull(metadata.getRequired());
    assertNull(actual_newResult.getPropertyType());
    assertNull(metadata.getIndex());
    assertNull(metadata.getDefaultValue());
    assertNull(metadata.getDescription());
    assertNull(actual_newResult.getGenericPropertyType());
    assertFalse(metadata.hasDefaultValue());
    assertFalse(metadata.hasIndex());
    assertFalse(actual_newResult.isRequired());
    assertFalse(actual_newResult.isVirtual());
    assertFalse(actual_newResult.hasNullSerializer());
    assertFalse(actual_newResult.isUnwrapping());
    assertTrue(actual_newResult.hasSerializer());
    assertEquals(internalName, actual_newResult.getFullName());
    Class<Object> expectedRawSerializationType = Object.class;
    Class<?> rawSerializationType = actual_newResult.getRawSerializationType();
    assertEquals(expectedRawSerializationType, rawSerializationType);
    assertSame(ser, actual_newResult.getSerializer());
    assertSame(serType, actual_newResult.getSerializationType());
    assertSame(declaredType, actual_newResult.getType());
    assertSame(member, actual_newResult.getMember());
    assertSame(typeSer, actual_newResult.getTypeSerializer());
    assertSame(declaringClass, rawSerializationType);
  }

  /**
   * Method under test: {@link SubstitutingBeanPropertyWriter#_new(PropertyName)}
   */
  @Test
  public void test_new2() {
    // Arrange
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(null, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyName internalName = PropertyName.construct("Simple Name");
    POJOPropertyBuilder propDef = new POJOPropertyBuilder(config, ai, true, internalName);

    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member = new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();
    PlaceholderForType serType = new PlaceholderForType(1);

    BeanPropertyWriter base = new BeanPropertyWriter(propDef, member, contextAnnotations, declaredType, ser, typeSer,
        serType, true, "Suppressable Value");
    base.setInternalSetting("Key", "Value");
    SubstitutingBeanPropertyWriter substitutingBeanPropertyWriter = new SubstitutingBeanPropertyWriter(base,
        new SubstitutionMap(new HashMap<>()));

    // Act
    SubstitutingBeanPropertyWriter actual_newResult = substitutingBeanPropertyWriter
        ._new(PropertyName.construct("Simple Name"));

    // Assert
    SerializableString serializedName = actual_newResult.getSerializedName();
    assertTrue(serializedName instanceof SerializedString);
    assertEquals("Simple Name", serializedName.getValue());
    assertEquals("Simple Name", actual_newResult.getName());
    assertEquals("Simple Name", serializedName.toString());
    assertNull(actual_newResult.getViews());
    PropertyMetadata metadata = actual_newResult.getMetadata();
    assertNull(metadata.getContentNulls());
    assertNull(metadata.getValueNulls());
    assertNull(metadata.getMergeInfo());
    assertNull(actual_newResult.getWrapperName());
    assertNull(metadata.getRequired());
    assertNull(actual_newResult.getPropertyType());
    assertNull(metadata.getIndex());
    assertNull(metadata.getDefaultValue());
    assertNull(metadata.getDescription());
    assertNull(actual_newResult.getGenericPropertyType());
    assertFalse(metadata.hasDefaultValue());
    assertFalse(metadata.hasIndex());
    assertFalse(actual_newResult.isRequired());
    assertFalse(actual_newResult.isVirtual());
    assertFalse(actual_newResult.hasNullSerializer());
    assertFalse(actual_newResult.isUnwrapping());
    assertTrue(actual_newResult.hasSerializer());
    assertEquals(internalName, actual_newResult.getFullName());
    Class<Object> expectedRawSerializationType = Object.class;
    Class<?> rawSerializationType = actual_newResult.getRawSerializationType();
    assertEquals(expectedRawSerializationType, rawSerializationType);
    assertSame(ser, actual_newResult.getSerializer());
    assertSame(serType, actual_newResult.getSerializationType());
    assertSame(declaredType, actual_newResult.getType());
    assertSame(member, actual_newResult.getMember());
    assertSame(typeSer, actual_newResult.getTypeSerializer());
    assertSame(declaringClass, rawSerializationType);
  }

  /**
   * Method under test:
   * {@link SubstitutingBeanPropertyWriter#SubstitutingBeanPropertyWriter(SubstitutingBeanPropertyWriter, PropertyName)}
   */
  @Test
  public void testNewSubstitutingBeanPropertyWriter2() {
    // Arrange
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(null, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyName internalName = PropertyName.construct("Simple Name");
    POJOPropertyBuilder propDef = new POJOPropertyBuilder(config, ai, true, internalName);

    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member = new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();
    PlaceholderForType serType = new PlaceholderForType(1);
    BeanPropertyWriter base = new BeanPropertyWriter(propDef, member, contextAnnotations, declaredType, ser, typeSer,
        serType, true, "Suppressable Value");

    SubstitutingBeanPropertyWriter base2 = new SubstitutingBeanPropertyWriter(base,
        new SubstitutionMap(new HashMap<>()));

    // Act
    SubstitutingBeanPropertyWriter actualSubstitutingBeanPropertyWriter = new SubstitutingBeanPropertyWriter(base2,
        PropertyName.construct("Simple Name"));

    // Assert
    SerializableString serializedName = actualSubstitutingBeanPropertyWriter.getSerializedName();
    assertTrue(serializedName instanceof SerializedString);
    assertEquals("Simple Name", serializedName.getValue());
    assertEquals("Simple Name", actualSubstitutingBeanPropertyWriter.getName());
    assertEquals("Simple Name", serializedName.toString());
    assertNull(actualSubstitutingBeanPropertyWriter.getViews());
    PropertyMetadata metadata = actualSubstitutingBeanPropertyWriter.getMetadata();
    assertNull(metadata.getContentNulls());
    assertNull(metadata.getValueNulls());
    assertNull(metadata.getMergeInfo());
    assertNull(actualSubstitutingBeanPropertyWriter.getWrapperName());
    assertNull(metadata.getRequired());
    assertNull(actualSubstitutingBeanPropertyWriter.getPropertyType());
    assertNull(metadata.getIndex());
    assertNull(metadata.getDefaultValue());
    assertNull(metadata.getDescription());
    assertNull(actualSubstitutingBeanPropertyWriter.getGenericPropertyType());
    assertFalse(metadata.hasDefaultValue());
    assertFalse(metadata.hasIndex());
    assertFalse(actualSubstitutingBeanPropertyWriter.isRequired());
    assertFalse(actualSubstitutingBeanPropertyWriter.isVirtual());
    assertFalse(actualSubstitutingBeanPropertyWriter.hasNullSerializer());
    assertFalse(actualSubstitutingBeanPropertyWriter.isUnwrapping());
    assertTrue(actualSubstitutingBeanPropertyWriter.hasSerializer());
    assertEquals(internalName, actualSubstitutingBeanPropertyWriter.getFullName());
    Class<Object> expectedRawSerializationType = Object.class;
    Class<?> rawSerializationType = actualSubstitutingBeanPropertyWriter.getRawSerializationType();
    assertEquals(expectedRawSerializationType, rawSerializationType);
    assertSame(ser, actualSubstitutingBeanPropertyWriter.getSerializer());
    assertSame(serType, actualSubstitutingBeanPropertyWriter.getSerializationType());
    assertSame(declaredType, actualSubstitutingBeanPropertyWriter.getType());
    assertSame(member, actualSubstitutingBeanPropertyWriter.getMember());
    assertSame(typeSer, actualSubstitutingBeanPropertyWriter.getTypeSerializer());
    assertSame(declaringClass, rawSerializationType);
  }

  /**
   * Method under test:
   * {@link SubstitutingBeanPropertyWriter#SubstitutingBeanPropertyWriter(SubstitutingBeanPropertyWriter, PropertyName)}
   */
  @Test
  public void testNewSubstitutingBeanPropertyWriter3() {
    // Arrange
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(null, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyName internalName = PropertyName.construct("Simple Name");
    POJOPropertyBuilder propDef = new POJOPropertyBuilder(config, ai, true, internalName);

    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member = new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();
    PlaceholderForType serType = new PlaceholderForType(1);

    BeanPropertyWriter base = new BeanPropertyWriter(propDef, member, contextAnnotations, declaredType, ser, typeSer,
        serType, true, "Suppressable Value");
    base.setInternalSetting("Key", "Value");
    SubstitutingBeanPropertyWriter base2 = new SubstitutingBeanPropertyWriter(base,
        new SubstitutionMap(new HashMap<>()));

    // Act
    SubstitutingBeanPropertyWriter actualSubstitutingBeanPropertyWriter = new SubstitutingBeanPropertyWriter(base2,
        PropertyName.construct("Simple Name"));

    // Assert
    SerializableString serializedName = actualSubstitutingBeanPropertyWriter.getSerializedName();
    assertTrue(serializedName instanceof SerializedString);
    assertEquals("Simple Name", serializedName.getValue());
    assertEquals("Simple Name", actualSubstitutingBeanPropertyWriter.getName());
    assertEquals("Simple Name", serializedName.toString());
    assertNull(actualSubstitutingBeanPropertyWriter.getViews());
    PropertyMetadata metadata = actualSubstitutingBeanPropertyWriter.getMetadata();
    assertNull(metadata.getContentNulls());
    assertNull(metadata.getValueNulls());
    assertNull(metadata.getMergeInfo());
    assertNull(actualSubstitutingBeanPropertyWriter.getWrapperName());
    assertNull(metadata.getRequired());
    assertNull(actualSubstitutingBeanPropertyWriter.getPropertyType());
    assertNull(metadata.getIndex());
    assertNull(metadata.getDefaultValue());
    assertNull(metadata.getDescription());
    assertNull(actualSubstitutingBeanPropertyWriter.getGenericPropertyType());
    assertFalse(metadata.hasDefaultValue());
    assertFalse(metadata.hasIndex());
    assertFalse(actualSubstitutingBeanPropertyWriter.isRequired());
    assertFalse(actualSubstitutingBeanPropertyWriter.isVirtual());
    assertFalse(actualSubstitutingBeanPropertyWriter.hasNullSerializer());
    assertFalse(actualSubstitutingBeanPropertyWriter.isUnwrapping());
    assertTrue(actualSubstitutingBeanPropertyWriter.hasSerializer());
    assertEquals(internalName, actualSubstitutingBeanPropertyWriter.getFullName());
    Class<Object> expectedRawSerializationType = Object.class;
    Class<?> rawSerializationType = actualSubstitutingBeanPropertyWriter.getRawSerializationType();
    assertEquals(expectedRawSerializationType, rawSerializationType);
    assertSame(ser, actualSubstitutingBeanPropertyWriter.getSerializer());
    assertSame(serType, actualSubstitutingBeanPropertyWriter.getSerializationType());
    assertSame(declaredType, actualSubstitutingBeanPropertyWriter.getType());
    assertSame(member, actualSubstitutingBeanPropertyWriter.getMember());
    assertSame(typeSer, actualSubstitutingBeanPropertyWriter.getTypeSerializer());
    assertSame(declaringClass, rawSerializationType);
  }
}
