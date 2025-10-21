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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers.XMLGregorianCalendarSerializer;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.NameTransformer.Chained;
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
import org.junit.experimental.categories.Category;

public class UnwrappingAsArraySerializerBaseDiffblueTest {
  /**
   * Test {@link UnwrappingAsArraySerializerBase#createContextual(SerializerProvider, BeanProperty)}.
   * <ul>
   *   <li>Then ContentSerializer return {@link CoreXMLSerializers.XMLGregorianCalendarSerializer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingAsArraySerializerBase#createContextual(SerializerProvider, BeanProperty)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "JsonSerializer UnwrappingAsArraySerializerBase.createContextual(SerializerProvider, BeanProperty)"})
  public void testCreateContextual_thenContentSerializerReturnXMLGregorianCalendarSerializer()
      throws JsonMappingException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    Default valueSerializer = new Default(1, type);

    UnwrappingIndexedListSerializer src = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    XMLGregorianCalendarSerializer valueSerializer2 = new XMLGregorianCalendarSerializer();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src, property,
        vts2, valueSerializer2);
    XmlSerializerProvider src3 = new XmlSerializerProvider(new XmlRootNameLookup());
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
    XmlSerializerProvider serializers = new XmlSerializerProvider(src3,
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides()),
        RosettaSerialiserFactory.INSTANCE);

    SubstitutedMethodProperty src4 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    // Act
    JsonSerializer<?> actualCreateContextualResult = unwrappingIndexedListSerializer.createContextual(serializers,
        new SubstitutedMethodProperty(src4, PropertyName.construct("Simple Name")));

    // Assert
    JsonSerializer<?> contentSerializer = ((UnwrappingIndexedListSerializer) actualCreateContextualResult)
        .getContentSerializer();
    assertTrue(contentSerializer instanceof XMLGregorianCalendarSerializer);
    assertTrue(
        ((UnwrappingIndexedListSerializer) actualCreateContextualResult)._valueTypeSerializer instanceof AsDeductionTypeSerializer);
    JavaType contentType = ((UnwrappingIndexedListSerializer) actualCreateContextualResult).getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    assertTrue(((UnwrappingIndexedListSerializer) actualCreateContextualResult)._nameTransformer instanceof Chained);
    assertTrue(
        ((UnwrappingIndexedListSerializer) actualCreateContextualResult)._property instanceof SubstitutedMethodProperty);
    assertTrue(actualCreateContextualResult instanceof UnwrappingIndexedListSerializer);
    assertNull(actualCreateContextualResult.getDelegatee());
    assertTrue(actualCreateContextualResult.isUnwrappingSerializer());
    assertTrue(((UnwrappingIndexedListSerializer) actualCreateContextualResult)._staticTyping);
    assertSame(valueSerializer2, contentSerializer);
    assertSame(elemType, contentType);
  }

  /**
   * Test {@link UnwrappingAsArraySerializerBase#getContentType()}.
   * <p>
   * Method under test: {@link UnwrappingAsArraySerializerBase#getContentType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JavaType UnwrappingAsArraySerializerBase.getContentType()"})
  public void testGetContentType() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    Default valueSerializer = new Default(1, type);

    UnwrappingIndexedListSerializer src = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src, property,
        vts2, new XMLGregorianCalendarSerializer());

    // Act and Assert
    assertSame(unwrappingIndexedListSerializer._elementType, unwrappingIndexedListSerializer.getContentType());
  }

  /**
   * Test {@link UnwrappingAsArraySerializerBase#getContentSerializer()}.
   * <p>
   * Method under test: {@link UnwrappingAsArraySerializerBase#getContentSerializer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JsonSerializer UnwrappingAsArraySerializerBase.getContentSerializer()"})
  public void testGetContentSerializer() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    Default valueSerializer = new Default(1, type);

    UnwrappingIndexedListSerializer src = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src, property,
        vts2, new XMLGregorianCalendarSerializer());

    // Act and Assert
    assertSame(unwrappingIndexedListSerializer._elementSerializer,
        unwrappingIndexedListSerializer.getContentSerializer());
  }

  /**
   * Test {@link UnwrappingAsArraySerializerBase#_findAndAddDynamic(PropertySerializerMap, Class, SerializerProvider)} with {@code PropertySerializerMap}, {@code Class}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappingAsArraySerializerBase#_findAndAddDynamic(PropertySerializerMap, Class, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "JsonSerializer UnwrappingAsArraySerializerBase._findAndAddDynamic(PropertySerializerMap, Class, SerializerProvider)"})
  public void test_findAndAddDynamicWithPropertySerializerMapClassSerializerProvider() throws JsonMappingException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    Default valueSerializer = new Default(1, type);

    UnwrappingIndexedListSerializer src = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src, property,
        vts2, new XMLGregorianCalendarSerializer());
    PropertySerializerMap map = mock(PropertySerializerMap.class);
    Class<Object> type2 = Object.class;
    XmlSerializerProvider src3 = new XmlSerializerProvider(new XmlRootNameLookup());
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

    // Act
    JsonSerializer<Object> actual_findAndAddDynamicResult = unwrappingIndexedListSerializer._findAndAddDynamic(map,
        type2,
        new XmlSerializerProvider(src3, new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides()),
            RosettaSerialiserFactory.INSTANCE));

    // Assert
    assertTrue(actual_findAndAddDynamicResult instanceof UnknownSerializer);
    JavaType contentType = unwrappingIndexedListSerializer.getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    JavaType superClass = contentType.getSuperClass();
    assertTrue(superClass instanceof SimpleType);
    assertNull(actual_findAndAddDynamicResult.getDelegatee());
    assertFalse(actual_findAndAddDynamicResult.isUnwrappingSerializer());
    Class<Object> expectedRawClass = Object.class;
    assertEquals(expectedRawClass, contentType.getRawClass());
    assertSame(type2, superClass.getRawClass());
  }

  /**
   * Test {@link UnwrappingAsArraySerializerBase#_findAndAddDynamic(PropertySerializerMap, Class, SerializerProvider)} with {@code PropertySerializerMap}, {@code Class}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappingAsArraySerializerBase#_findAndAddDynamic(PropertySerializerMap, Class, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "JsonSerializer UnwrappingAsArraySerializerBase._findAndAddDynamic(PropertySerializerMap, Class, SerializerProvider)"})
  public void test_findAndAddDynamicWithPropertySerializerMapClassSerializerProvider2() throws JsonMappingException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    Default valueSerializer = new Default(1, type);

    UnwrappingIndexedListSerializer src = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src, property,
        vts2, new XMLGregorianCalendarSerializer());
    PropertySerializerMap map = mock(PropertySerializerMap.class);
    Class<Object> type2 = Object.class;
    XmlSerializerProvider src3 = new XmlSerializerProvider(new XmlRootNameLookup());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    XmlJaxbAnnotationIntrospector ai = new XmlJaxbAnnotationIntrospector();
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

    // Act
    JsonSerializer<Object> actual_findAndAddDynamicResult = unwrappingIndexedListSerializer._findAndAddDynamic(map,
        type2,
        new XmlSerializerProvider(src3, new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides()),
            RosettaSerialiserFactory.INSTANCE));

    // Assert
    assertTrue(actual_findAndAddDynamicResult instanceof UnknownSerializer);
    JavaType contentType = unwrappingIndexedListSerializer.getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    JavaType superClass = contentType.getSuperClass();
    assertTrue(superClass instanceof SimpleType);
    assertNull(actual_findAndAddDynamicResult.getDelegatee());
    assertFalse(actual_findAndAddDynamicResult.isUnwrappingSerializer());
    Class<Object> expectedRawClass = Object.class;
    assertEquals(expectedRawClass, contentType.getRawClass());
    assertSame(type2, superClass.getRawClass());
  }

  /**
   * Test {@link UnwrappingAsArraySerializerBase#_findAndAddDynamic(PropertySerializerMap, JavaType, SerializerProvider)} with {@code PropertySerializerMap}, {@code JavaType}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappingAsArraySerializerBase#_findAndAddDynamic(PropertySerializerMap, JavaType, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "JsonSerializer UnwrappingAsArraySerializerBase._findAndAddDynamic(PropertySerializerMap, JavaType, SerializerProvider)"})
  public void test_findAndAddDynamicWithPropertySerializerMapJavaTypeSerializerProvider() throws JsonMappingException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    Default valueSerializer = new Default(1, type);

    UnwrappingIndexedListSerializer src = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src, property,
        vts2, new XMLGregorianCalendarSerializer());
    PropertySerializerMap map = mock(PropertySerializerMap.class);
    PlaceholderForType type2 = new PlaceholderForType(1);
    XmlSerializerProvider src3 = new XmlSerializerProvider(new XmlRootNameLookup());
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
}
