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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeSerializer;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializer;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

public class UnwrappableIndexedListSerializerDiffblueTest {
  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#unwrappingSerializer(NameTransformer)}
   */
  @Test
  public void testUnwrappingSerializer() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    StdKeySerializers.Default valueSerializer = new StdKeySerializers.Default(1, type);

    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, valueSerializer);

    // Act
    UnwrappingIndexedListSerializer actualUnwrappingSerializerResult = unwrappableIndexedListSerializer
        .unwrappingSerializer(new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    // Assert
    TypeSerializer typeSerializer = actualUnwrappingSerializerResult._valueTypeSerializer;
    assertTrue(typeSerializer instanceof AsDeductionTypeSerializer);
    assertTrue(actualUnwrappingSerializerResult._nameTransformer instanceof NameTransformer.Chained);
    assertNull(actualUnwrappingSerializerResult._property);
    assertNull(actualUnwrappingSerializerResult.getDelegatee());
    assertNull(typeSerializer.getTypeIdResolver());
    assertNull(typeSerializer.getPropertyName());
    assertEquals(JsonTypeInfo.As.EXISTING_PROPERTY, typeSerializer.getTypeInclusion());
    assertTrue(actualUnwrappingSerializerResult.isUnwrappingSerializer());
    assertTrue(actualUnwrappingSerializerResult._staticTyping);
    assertSame(valueSerializer, actualUnwrappingSerializerResult.getContentSerializer());
    assertSame(elemType, actualUnwrappingSerializerResult.getContentType());
  }

  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#unwrappingSerializer(NameTransformer)}
   */
  @Test
  public void testUnwrappingSerializer2() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    StdKeySerializers.Default valueSerializer = new StdKeySerializers.Default(1, type);

    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        false, vts, valueSerializer);

    // Act
    UnwrappingIndexedListSerializer actualUnwrappingSerializerResult = unwrappableIndexedListSerializer
        .unwrappingSerializer(new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    // Assert
    TypeSerializer typeSerializer = actualUnwrappingSerializerResult._valueTypeSerializer;
    assertTrue(typeSerializer instanceof AsDeductionTypeSerializer);
    assertTrue(actualUnwrappingSerializerResult._nameTransformer instanceof NameTransformer.Chained);
    assertNull(actualUnwrappingSerializerResult._property);
    assertNull(actualUnwrappingSerializerResult.getDelegatee());
    assertNull(typeSerializer.getTypeIdResolver());
    assertNull(typeSerializer.getPropertyName());
    assertEquals(JsonTypeInfo.As.EXISTING_PROPERTY, typeSerializer.getTypeInclusion());
    assertFalse(actualUnwrappingSerializerResult._staticTyping);
    assertTrue(actualUnwrappingSerializerResult.isUnwrappingSerializer());
    assertSame(valueSerializer, actualUnwrappingSerializerResult.getContentSerializer());
    assertSame(elemType, actualUnwrappingSerializerResult.getContentType());
  }

  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#unwrappingSerializer(NameTransformer)}
   */
  @Test
  public void testUnwrappingSerializer3() {
    // Arrange
    CollectionLikeType elemType = mock(CollectionLikeType.class);
    when(elemType.isFinal()).thenReturn(false);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    StdKeySerializers.Default valueSerializer = new StdKeySerializers.Default(1, type);

    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        false, vts, valueSerializer);

    // Act
    UnwrappingIndexedListSerializer actualUnwrappingSerializerResult = unwrappableIndexedListSerializer
        .unwrappingSerializer(new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    // Assert
    verify(elemType, atLeast(1)).isFinal();
    TypeSerializer typeSerializer = actualUnwrappingSerializerResult._valueTypeSerializer;
    assertTrue(typeSerializer instanceof AsDeductionTypeSerializer);
    assertTrue(actualUnwrappingSerializerResult._nameTransformer instanceof NameTransformer.Chained);
    assertNull(actualUnwrappingSerializerResult._property);
    assertNull(actualUnwrappingSerializerResult.getDelegatee());
    assertNull(typeSerializer.getTypeIdResolver());
    assertNull(typeSerializer.getPropertyName());
    assertEquals(JsonTypeInfo.As.EXISTING_PROPERTY, typeSerializer.getTypeInclusion());
    assertFalse(actualUnwrappingSerializerResult._staticTyping);
    assertTrue(actualUnwrappingSerializerResult.isUnwrappingSerializer());
    assertSame(valueSerializer, actualUnwrappingSerializerResult.getContentSerializer());
  }

  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#withResolved(BeanProperty, TypeSerializer, JsonSerializer, Boolean)}
   */
  @Test
  public void testWithResolved() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new StdKeySerializers.Default(1, type));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    CoreXMLSerializers.XMLGregorianCalendarSerializer elementSerializer = new CoreXMLSerializers.XMLGregorianCalendarSerializer();

    // Act
    UnwrappableIndexedListSerializer actualWithResolvedResult = unwrappableIndexedListSerializer.withResolved(property,
        vts2, elementSerializer, true);

    // Assert
    assertNull(actualWithResolvedResult.getDelegatee());
    assertFalse(actualWithResolvedResult.isUnwrappingSerializer());
    assertSame(elementSerializer, actualWithResolvedResult.getContentSerializer());
    assertSame(elemType, actualWithResolvedResult.getContentType());
  }

  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#isEmpty(SerializerProvider, List)}
   */
  @Test
  public void testIsEmpty() {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription beanDesc = mock(BasicBeanDescription.class);
    when(beanDesc.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = new BeanSerializerBuilder(beanDesc);
    POJOPropertyBuilder propDef = mock(POJOPropertyBuilder.class);
    when(propDef.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef.getMetadata()).thenReturn(null);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    POJOPropertyBuilder propDef2 = mock(POJOPropertyBuilder.class);
    when(propDef2.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef2.getMetadata()).thenReturn(null);
    when(propDef2.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser2 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef, null, contextAnnotations, null, ser,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")},
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef2, null, contextAnnotations2, null, ser2,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")});

    CollectionLikeType elemType = mock(CollectionLikeType.class);
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, AsDeductionTypeSerializer.instance(), valueSerializer);
    DefaultSerializerProvider.Impl prov = new DefaultSerializerProvider.Impl();

    // Act
    boolean actualIsEmptyResult = unwrappableIndexedListSerializer.isEmpty(prov, new ArrayList<>());

    // Assert
    verify(type).getRawClass();
    verify(beanDesc).findExpectedFormat();
    verify(propDef).getMetadata();
    verify(propDef2).getMetadata();
    verify(propDef).getName();
    verify(propDef2).getName();
    verify(propDef).getWrapperName();
    verify(propDef2).getWrapperName();
    assertTrue(actualIsEmptyResult);
  }

  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#isEmpty(SerializerProvider, List)}
   */
  @Test
  public void testIsEmpty2() {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription beanDesc = mock(BasicBeanDescription.class);
    when(beanDesc.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = new BeanSerializerBuilder(beanDesc);
    POJOPropertyBuilder propDef = mock(POJOPropertyBuilder.class);
    when(propDef.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef.getMetadata()).thenReturn(null);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    POJOPropertyBuilder propDef2 = mock(POJOPropertyBuilder.class);
    when(propDef2.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef2.getMetadata()).thenReturn(null);
    when(propDef2.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser2 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef, null, contextAnnotations, null, ser,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")},
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef2, null, contextAnnotations2, null, ser2,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")});

    CollectionLikeType elemType = mock(CollectionLikeType.class);
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, AsDeductionTypeSerializer.instance(), valueSerializer);
    DefaultSerializerProvider.Impl prov = new DefaultSerializerProvider.Impl();

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");

    // Act
    boolean actualIsEmptyResult = unwrappableIndexedListSerializer.isEmpty(prov, value);

    // Assert
    verify(type).getRawClass();
    verify(beanDesc).findExpectedFormat();
    verify(propDef).getMetadata();
    verify(propDef2).getMetadata();
    verify(propDef).getName();
    verify(propDef2).getName();
    verify(propDef).getWrapperName();
    verify(propDef2).getWrapperName();
    assertFalse(actualIsEmptyResult);
  }

  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#isEmpty(SerializerProvider, List)}
   */
  @Test
  public void testIsEmpty3() {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription beanDesc = mock(BasicBeanDescription.class);
    when(beanDesc.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = new BeanSerializerBuilder(beanDesc);
    POJOPropertyBuilder propDef = mock(POJOPropertyBuilder.class);
    when(propDef.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef.getMetadata()).thenReturn(null);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    POJOPropertyBuilder propDef2 = mock(POJOPropertyBuilder.class);
    when(propDef2.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef2.getMetadata()).thenReturn(null);
    when(propDef2.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser2 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef, null, contextAnnotations, null, ser,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")},
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef2, null, contextAnnotations2, null, ser2,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")});

    CollectionLikeType elemType = mock(CollectionLikeType.class);
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, AsDeductionTypeSerializer.instance(), valueSerializer);
    DefaultSerializerProvider.Impl prov = new DefaultSerializerProvider.Impl();

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");
    value.add("42");

    // Act
    boolean actualIsEmptyResult = unwrappableIndexedListSerializer.isEmpty(prov, value);

    // Assert
    verify(type).getRawClass();
    verify(beanDesc).findExpectedFormat();
    verify(propDef).getMetadata();
    verify(propDef2).getMetadata();
    verify(propDef).getName();
    verify(propDef2).getName();
    verify(propDef).getWrapperName();
    verify(propDef2).getWrapperName();
    assertFalse(actualIsEmptyResult);
  }

  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#hasSingleElement(List)}
   */
  @Test
  public void testHasSingleElement() {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription beanDesc = mock(BasicBeanDescription.class);
    when(beanDesc.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = new BeanSerializerBuilder(beanDesc);
    POJOPropertyBuilder propDef = mock(POJOPropertyBuilder.class);
    when(propDef.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef.getMetadata()).thenReturn(null);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    POJOPropertyBuilder propDef2 = mock(POJOPropertyBuilder.class);
    when(propDef2.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef2.getMetadata()).thenReturn(null);
    when(propDef2.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser2 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef, null, contextAnnotations, null, ser,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")},
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef2, null, contextAnnotations2, null, ser2,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")});

    CollectionLikeType elemType = mock(CollectionLikeType.class);
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, AsDeductionTypeSerializer.instance(), valueSerializer);

    // Act
    boolean actualHasSingleElementResult = unwrappableIndexedListSerializer.hasSingleElement(new ArrayList<>());

    // Assert
    verify(type).getRawClass();
    verify(beanDesc).findExpectedFormat();
    verify(propDef).getMetadata();
    verify(propDef2).getMetadata();
    verify(propDef).getName();
    verify(propDef2).getName();
    verify(propDef).getWrapperName();
    verify(propDef2).getWrapperName();
    assertFalse(actualHasSingleElementResult);
  }

  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#hasSingleElement(List)}
   */
  @Test
  public void testHasSingleElement2() {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription beanDesc = mock(BasicBeanDescription.class);
    when(beanDesc.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = new BeanSerializerBuilder(beanDesc);
    POJOPropertyBuilder propDef = mock(POJOPropertyBuilder.class);
    when(propDef.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef.getMetadata()).thenReturn(null);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    POJOPropertyBuilder propDef2 = mock(POJOPropertyBuilder.class);
    when(propDef2.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef2.getMetadata()).thenReturn(null);
    when(propDef2.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser2 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef, null, contextAnnotations, null, ser,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")},
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef2, null, contextAnnotations2, null, ser2,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")});

    CollectionLikeType elemType = mock(CollectionLikeType.class);
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, AsDeductionTypeSerializer.instance(), valueSerializer);

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");

    // Act
    boolean actualHasSingleElementResult = unwrappableIndexedListSerializer.hasSingleElement(value);

    // Assert
    verify(type).getRawClass();
    verify(beanDesc).findExpectedFormat();
    verify(propDef).getMetadata();
    verify(propDef2).getMetadata();
    verify(propDef).getName();
    verify(propDef2).getName();
    verify(propDef).getWrapperName();
    verify(propDef2).getWrapperName();
    assertTrue(actualHasSingleElementResult);
  }

  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#hasSingleElement(List)}
   */
  @Test
  public void testHasSingleElement3() {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription beanDesc = mock(BasicBeanDescription.class);
    when(beanDesc.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = new BeanSerializerBuilder(beanDesc);
    POJOPropertyBuilder propDef = mock(POJOPropertyBuilder.class);
    when(propDef.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef.getMetadata()).thenReturn(null);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    POJOPropertyBuilder propDef2 = mock(POJOPropertyBuilder.class);
    when(propDef2.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef2.getMetadata()).thenReturn(null);
    when(propDef2.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser2 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef, null, contextAnnotations, null, ser,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")},
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef2, null, contextAnnotations2, null, ser2,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")});

    CollectionLikeType elemType = mock(CollectionLikeType.class);
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, AsDeductionTypeSerializer.instance(), valueSerializer);

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");
    value.add("42");

    // Act
    boolean actualHasSingleElementResult = unwrappableIndexedListSerializer.hasSingleElement(value);

    // Assert
    verify(type).getRawClass();
    verify(beanDesc).findExpectedFormat();
    verify(propDef).getMetadata();
    verify(propDef2).getMetadata();
    verify(propDef).getName();
    verify(propDef2).getName();
    verify(propDef).getWrapperName();
    verify(propDef2).getWrapperName();
    assertFalse(actualHasSingleElementResult);
  }

  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#UnwrappableIndexedListSerializer(UnwrappableIndexedListSerializer, BeanProperty, TypeSerializer, JsonSerializer, Boolean)}
   */
  @Test
  public void testNewUnwrappableIndexedListSerializer() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer src = new UnwrappableIndexedListSerializer(elemType, true, vts,
        new StdKeySerializers.Default(1, type));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    CoreXMLSerializers.XMLGregorianCalendarSerializer valueSerializer = new CoreXMLSerializers.XMLGregorianCalendarSerializer();

    // Act
    UnwrappableIndexedListSerializer actualUnwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(src,
        property, vts2, valueSerializer, true);

    // Assert
    assertNull(actualUnwrappableIndexedListSerializer.getDelegatee());
    assertFalse(actualUnwrappableIndexedListSerializer.isUnwrappingSerializer());
    assertSame(valueSerializer, actualUnwrappableIndexedListSerializer.getContentSerializer());
    assertSame(elemType, actualUnwrappableIndexedListSerializer.getContentType());
  }

  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#_withValueTypeSerializer(TypeSerializer)}
   */
  @Test
  public void test_withValueTypeSerializer() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    StdKeySerializers.Default valueSerializer = new StdKeySerializers.Default(1, type);

    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, valueSerializer);

    // Act
    UnwrappableIndexedListSerializer actual_withValueTypeSerializerResult = unwrappableIndexedListSerializer
        ._withValueTypeSerializer(AsDeductionTypeSerializer.instance());

    // Assert
    assertNull(actual_withValueTypeSerializerResult.getDelegatee());
    assertFalse(actual_withValueTypeSerializerResult.isUnwrappingSerializer());
    assertSame(valueSerializer, actual_withValueTypeSerializerResult.getContentSerializer());
    assertSame(elemType, actual_withValueTypeSerializerResult.getContentType());
  }

  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  public void testSerialize() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription beanDesc = mock(BasicBeanDescription.class);
    when(beanDesc.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = new BeanSerializerBuilder(beanDesc);
    POJOPropertyBuilder propDef = mock(POJOPropertyBuilder.class);
    when(propDef.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef.getMetadata()).thenReturn(null);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    POJOPropertyBuilder propDef2 = mock(POJOPropertyBuilder.class);
    when(propDef2.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef2.getMetadata()).thenReturn(null);
    when(propDef2.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser2 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef, null, contextAnnotations, null, ser,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")},
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef2, null, contextAnnotations2, null, ser2,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")});

    CollectionLikeType elemType = mock(CollectionLikeType.class);
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, AsDeductionTypeSerializer.instance(), valueSerializer);
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(new JsonGeneratorDelegate(new JsonGeneratorDelegate(null), true), null,
            TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true),
        true);

    // Act
    unwrappableIndexedListSerializer.serialize(value, gen, new DefaultSerializerProvider.Impl());

    // Assert
    verify(type).getRawClass();
    verify(beanDesc).findExpectedFormat();
    verify(propDef).getMetadata();
    verify(propDef2).getMetadata();
    verify(propDef).getName();
    verify(propDef2).getName();
    verify(propDef).getWrapperName();
    verify(propDef2).getWrapperName();
  }

  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  public void testSerialize2() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription beanDesc = mock(BasicBeanDescription.class);
    when(beanDesc.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = new BeanSerializerBuilder(beanDesc);
    POJOPropertyBuilder propDef = mock(POJOPropertyBuilder.class);
    when(propDef.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef.getMetadata()).thenReturn(null);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    POJOPropertyBuilder propDef2 = mock(POJOPropertyBuilder.class);
    when(propDef2.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef2.getMetadata()).thenReturn(null);
    when(propDef2.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser2 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef, null, contextAnnotations, null, ser,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")},
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef2, null, contextAnnotations2, null, ser2,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")});

    CollectionLikeType elemType = mock(CollectionLikeType.class);
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, AsDeductionTypeSerializer.instance(), valueSerializer);
    ArrayList<Object> value = new ArrayList<>();
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    ObjectMapper codec = new ObjectMapper();
    UTF8JsonGenerator d = new UTF8JsonGenerator(ctxt, 1, codec, new ByteArrayOutputStream(1));

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d, true);

    // Act
    unwrappableIndexedListSerializer.serialize(value, gen, new DefaultSerializerProvider.Impl());

    // Assert
    verify(type).getRawClass();
    verify(beanDesc).findExpectedFormat();
    verify(propDef).getMetadata();
    verify(propDef2).getMetadata();
    verify(propDef).getName();
    verify(propDef2).getName();
    verify(propDef).getWrapperName();
    verify(propDef2).getWrapperName();
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof JsonWriteContext);
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof UTF8JsonGenerator);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(2, delegateResult.getOutputBuffered());
    assertEquals(2, gen.getOutputBuffered());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d, delegateResult);
  }

  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  public void testSerialize3() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription beanDesc = mock(BasicBeanDescription.class);
    when(beanDesc.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = new BeanSerializerBuilder(beanDesc);
    POJOPropertyBuilder propDef = mock(POJOPropertyBuilder.class);
    when(propDef.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef.getMetadata()).thenReturn(null);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    POJOPropertyBuilder propDef2 = mock(POJOPropertyBuilder.class);
    when(propDef2.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef2.getMetadata()).thenReturn(null);
    when(propDef2.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser2 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef, null, contextAnnotations, null, ser,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")},
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef2, null, contextAnnotations2, null, ser2,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")});

    CollectionLikeType elemType = mock(CollectionLikeType.class);
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, AsDeductionTypeSerializer.instance(), valueSerializer);
    ArrayList<Object> value = new ArrayList<>();
    FilteringGeneratorDelegate d = mock(FilteringGeneratorDelegate.class);
    doNothing().when(d).writeEndArray();
    doNothing().when(d).writeStartArray(Mockito.<Object>any(), anyInt());
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(d, true);

    // Act
    unwrappableIndexedListSerializer.serialize(value, gen, new DefaultSerializerProvider.Impl());

    // Assert that nothing has changed
    verify(d).writeEndArray();
    verify(d).writeStartArray(isA(Object.class), eq(0));
    verify(type).getRawClass();
    verify(beanDesc).findExpectedFormat();
    verify(propDef).getMetadata();
    verify(propDef2).getMetadata();
    verify(propDef).getName();
    verify(propDef2).getName();
    verify(propDef).getWrapperName();
    verify(propDef2).getWrapperName();
  }

  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  public void testSerializeContents() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription beanDesc = mock(BasicBeanDescription.class);
    when(beanDesc.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = new BeanSerializerBuilder(beanDesc);
    POJOPropertyBuilder propDef = mock(POJOPropertyBuilder.class);
    when(propDef.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef.getMetadata()).thenReturn(null);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    POJOPropertyBuilder propDef2 = mock(POJOPropertyBuilder.class);
    when(propDef2.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef2.getMetadata()).thenReturn(null);
    when(propDef2.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser2 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef, null, contextAnnotations, null, ser,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")},
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef2, null, contextAnnotations2, null, ser2,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")});

    CollectionLikeType elemType = mock(CollectionLikeType.class);
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, AsDeductionTypeSerializer.instance(), valueSerializer);
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate g = new JsonGeneratorDelegate(new JsonGeneratorDelegate(null), true);

    // Act
    unwrappableIndexedListSerializer.serializeContents(value, g, new DefaultSerializerProvider.Impl());

    // Assert that nothing has changed
    verify(type).getRawClass();
    verify(beanDesc).findExpectedFormat();
    verify(propDef).getMetadata();
    verify(propDef2).getMetadata();
    verify(propDef).getName();
    verify(propDef2).getName();
    verify(propDef).getWrapperName();
    verify(propDef2).getWrapperName();
  }

  /**
   * Method under test:
   * {@link UnwrappableIndexedListSerializer#serializeTypedContents(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  public void testSerializeTypedContents() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription beanDesc = mock(BasicBeanDescription.class);
    when(beanDesc.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = new BeanSerializerBuilder(beanDesc);
    POJOPropertyBuilder propDef = mock(POJOPropertyBuilder.class);
    when(propDef.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef.getMetadata()).thenReturn(null);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    POJOPropertyBuilder propDef2 = mock(POJOPropertyBuilder.class);
    when(propDef2.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef2.getMetadata()).thenReturn(null);
    when(propDef2.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser2 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef, null, contextAnnotations, null, ser,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")},
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef2, null, contextAnnotations2, null, ser2,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")});

    CollectionLikeType elemType = mock(CollectionLikeType.class);
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, AsDeductionTypeSerializer.instance(), valueSerializer);
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate jgen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(null), true);

    // Act
    unwrappableIndexedListSerializer.serializeTypedContents(value, jgen, new DefaultSerializerProvider.Impl());

    // Assert that nothing has changed
    verify(type).getRawClass();
    verify(beanDesc).findExpectedFormat();
    verify(propDef).getMetadata();
    verify(propDef2).getMetadata();
    verify(propDef).getName();
    verify(propDef2).getName();
    verify(propDef).getWrapperName();
    verify(propDef2).getWrapperName();
  }
}
