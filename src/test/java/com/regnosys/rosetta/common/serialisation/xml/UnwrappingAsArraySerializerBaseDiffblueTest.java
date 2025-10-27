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
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.dataformat.xml.jaxb.XmlJaxbAnnotationIntrospector;
import com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider;
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;
import com.regnosys.rosetta.common.serialisation.mixin.RosettaJSONAnnotationIntrospector;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.Test;

public class UnwrappingAsArraySerializerBaseDiffblueTest {
  /**
   * Method under test:
   * {@link UnwrappingAsArraySerializerBase#createContextual(SerializerProvider, BeanProperty)}
   */
  @Test
  public void testCreateContextual() throws JsonMappingException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    StdKeySerializers.Default valueSerializer = new StdKeySerializers.Default(1, type);

    UnwrappingIndexedListSerializer src = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    CoreXMLSerializers.XMLGregorianCalendarSerializer valueSerializer2 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src, property,
        vts2, valueSerializer2);
    XmlSerializerProvider src3 = new XmlSerializerProvider(new XmlRootNameLookup());
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
    XmlSerializerProvider serializers = new XmlSerializerProvider(src3,
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides()),
        RosettaSerialiserFactory.INSTANCE);

    SubstitutedMethodProperty src4 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    PropertyName newName = PropertyName.construct("Simple Name");

    // Act
    JsonSerializer<?> actualCreateContextualResult = unwrappingIndexedListSerializer.createContextual(serializers,
        new SubstitutedMethodProperty(src4, newName));

    // Assert
    TypeSerializer typeSerializer = ((UnwrappingIndexedListSerializer) actualCreateContextualResult)._valueTypeSerializer;
    assertTrue(typeSerializer instanceof AsDeductionTypeSerializer);
    assertTrue(
        ((UnwrappingIndexedListSerializer) actualCreateContextualResult)._nameTransformer instanceof NameTransformer.Chained);
    BeanProperty beanProperty = ((UnwrappingIndexedListSerializer) actualCreateContextualResult)._property;
    assertTrue(beanProperty instanceof SubstitutedMethodProperty);
    assertTrue(actualCreateContextualResult instanceof UnwrappingIndexedListSerializer);
    assertEquals("Simple Name", beanProperty.getName());
    assertNull(beanProperty.getType());
    assertNull(((SubstitutedMethodProperty) beanProperty).getValueDeserializer());
    assertNull(actualCreateContextualResult.getDelegatee());
    assertNull(beanProperty.getMetadata());
    assertNull(beanProperty.getWrapperName());
    assertNull(((SubstitutedMethodProperty) beanProperty).getNullValueProvider());
    assertNull(beanProperty.getMember());
    assertNull(((SubstitutedMethodProperty) beanProperty).getObjectIdInfo());
    assertNull(((SubstitutedMethodProperty) beanProperty).getValueTypeDeserializer());
    assertNull(typeSerializer.getTypeIdResolver());
    assertNull(((SubstitutedMethodProperty) beanProperty).getInjectableValueId());
    assertNull(((SubstitutedMethodProperty) beanProperty).getManagedReferenceName());
    assertNull(typeSerializer.getPropertyName());
    assertNull(((SubstitutedMethodProperty) beanProperty)._setter);
    assertEquals(0, ((SubstitutedMethodProperty) beanProperty).getPropertyIndex());
    assertEquals(JsonTypeInfo.As.EXISTING_PROPERTY, typeSerializer.getTypeInclusion());
    assertFalse(beanProperty.isVirtual());
    assertFalse(((SubstitutedMethodProperty) beanProperty).hasValueDeserializer());
    assertFalse(((SubstitutedMethodProperty) beanProperty).hasValueTypeDeserializer());
    assertFalse(((SubstitutedMethodProperty) beanProperty).hasViews());
    assertFalse(((SubstitutedMethodProperty) beanProperty).isIgnorable());
    assertFalse(((SubstitutedMethodProperty) beanProperty).isInjectionOnly());
    assertFalse(((SubstitutedMethodProperty) beanProperty)._skipNulls);
    assertTrue(actualCreateContextualResult.isUnwrappingSerializer());
    assertTrue(((UnwrappingIndexedListSerializer) actualCreateContextualResult)._staticTyping);
    assertSame(valueSerializer2,
        ((UnwrappingIndexedListSerializer) actualCreateContextualResult).getContentSerializer());
    assertSame(elemType, ((UnwrappingIndexedListSerializer) actualCreateContextualResult).getContentType());
    assertSame(newName, beanProperty.getFullName());
  }

  /**
   * Method under test: {@link UnwrappingAsArraySerializerBase#getContentType()}
   */
  @Test
  public void testGetContentType() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    StdKeySerializers.Default valueSerializer = new StdKeySerializers.Default(1, type);

    UnwrappingIndexedListSerializer src = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src, property,
        vts2, new CoreXMLSerializers.XMLGregorianCalendarSerializer());

    // Act and Assert
    assertSame(unwrappingIndexedListSerializer._elementType, unwrappingIndexedListSerializer.getContentType());
  }

  /**
   * Method under test:
   * {@link UnwrappingAsArraySerializerBase#getContentSerializer()}
   */
  @Test
  public void testGetContentSerializer() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    StdKeySerializers.Default valueSerializer = new StdKeySerializers.Default(1, type);

    UnwrappingIndexedListSerializer src = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src, property,
        vts2, new CoreXMLSerializers.XMLGregorianCalendarSerializer());

    // Act and Assert
    assertSame(unwrappingIndexedListSerializer._elementSerializer,
        unwrappingIndexedListSerializer.getContentSerializer());
  }

  /**
   * Method under test:
   * {@link UnwrappingAsArraySerializerBase#_findAndAddDynamic(PropertySerializerMap, JavaType, SerializerProvider)}
   */
  @Test
  public void test_findAndAddDynamic() throws JsonMappingException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    StdKeySerializers.Default valueSerializer = new StdKeySerializers.Default(1, type);

    UnwrappingIndexedListSerializer src = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src, property,
        vts2, new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    PropertySerializerMap map = mock(PropertySerializerMap.class);
    PlaceholderForType type2 = new PlaceholderForType(1);
    XmlSerializerProvider src3 = new XmlSerializerProvider(new XmlRootNameLookup());
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

    // Act
    JsonSerializer<Object> actual_findAndAddDynamicResult = unwrappingIndexedListSerializer._findAndAddDynamic(map,
        type2,
        new XmlSerializerProvider(src3, new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides()),
            RosettaSerialiserFactory.INSTANCE));

    // Assert
    assertTrue(actual_findAndAddDynamicResult instanceof UnknownSerializer);
    assertNull(actual_findAndAddDynamicResult.getDelegatee());
    assertFalse(actual_findAndAddDynamicResult.isUnwrappingSerializer());
  }

  /**
   * Method under test:
   * {@link UnwrappingAsArraySerializerBase#_findAndAddDynamic(PropertySerializerMap, Class, SerializerProvider)}
   */
  @Test
  public void test_findAndAddDynamic2() throws JsonMappingException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    StdKeySerializers.Default valueSerializer = new StdKeySerializers.Default(1, type);

    UnwrappingIndexedListSerializer src = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src, property,
        vts2, new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    PropertySerializerMap map = mock(PropertySerializerMap.class);
    Class<Object> type2 = Object.class;
    XmlSerializerProvider src3 = new XmlSerializerProvider(new XmlRootNameLookup());
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

    // Act
    JsonSerializer<Object> actual_findAndAddDynamicResult = unwrappingIndexedListSerializer._findAndAddDynamic(map,
        type2,
        new XmlSerializerProvider(src3, new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides()),
            RosettaSerialiserFactory.INSTANCE));

    // Assert
    assertTrue(actual_findAndAddDynamicResult instanceof UnknownSerializer);
    assertNull(actual_findAndAddDynamicResult.getDelegatee());
    assertFalse(actual_findAndAddDynamicResult.isUnwrappingSerializer());
    assertSame(elemType, unwrappingIndexedListSerializer.getContentType());
  }

  /**
   * Method under test:
   * {@link UnwrappingAsArraySerializerBase#_findAndAddDynamic(PropertySerializerMap, Class, SerializerProvider)}
   */
  @Test
  public void test_findAndAddDynamic3() throws JsonMappingException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    StdKeySerializers.Default valueSerializer = new StdKeySerializers.Default(1, type);

    UnwrappingIndexedListSerializer src = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src, property,
        vts2, new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    PropertySerializerMap map = mock(PropertySerializerMap.class);
    Class<Object> type2 = Object.class;
    XmlSerializerProvider src3 = new XmlSerializerProvider(new XmlRootNameLookup());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    XmlJaxbAnnotationIntrospector ai = new XmlJaxbAnnotationIntrospector();
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

    // Act
    JsonSerializer<Object> actual_findAndAddDynamicResult = unwrappingIndexedListSerializer._findAndAddDynamic(map,
        type2,
        new XmlSerializerProvider(src3, new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides()),
            RosettaSerialiserFactory.INSTANCE));

    // Assert
    assertTrue(actual_findAndAddDynamicResult instanceof UnknownSerializer);
    assertNull(actual_findAndAddDynamicResult.getDelegatee());
    assertFalse(actual_findAndAddDynamicResult.isUnwrappingSerializer());
    assertSame(elemType, unwrappingIndexedListSerializer.getContentType());
  }
}
