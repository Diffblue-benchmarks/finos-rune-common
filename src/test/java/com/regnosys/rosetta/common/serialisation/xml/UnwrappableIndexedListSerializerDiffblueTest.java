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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.ctc.wstx.api.WriterConfig;
import com.ctc.wstx.sw.AsciiXmlWriter;
import com.ctc.wstx.sw.NonNsStreamWriter;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
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
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers.XMLGregorianCalendarSerializer;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializer;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.NameTransformer.Chained;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider;
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.regnosys.rosetta.common.serialisation.mixin.RosettaJSONAnnotationIntrospector;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.codehaus.stax2.util.StreamWriter2Delegate;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions.Version;

public class UnwrappableIndexedListSerializerDiffblueTest {
  /**
   * Test {@link UnwrappableIndexedListSerializer#UnwrappableIndexedListSerializer(UnwrappableIndexedListSerializer, BeanProperty, TypeSerializer, JsonSerializer, Boolean)}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#UnwrappableIndexedListSerializer(UnwrappableIndexedListSerializer, BeanProperty, TypeSerializer, JsonSerializer, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void UnwrappableIndexedListSerializer.<init>(UnwrappableIndexedListSerializer, BeanProperty, TypeSerializer, JsonSerializer, Boolean)"})
  public void testNewUnwrappableIndexedListSerializer() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer src = new UnwrappableIndexedListSerializer(elemType, true, vts,
        new Default(1, type));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    XMLGregorianCalendarSerializer valueSerializer = new XMLGregorianCalendarSerializer();

    // Act
    UnwrappableIndexedListSerializer actualUnwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(src,
        property, vts2, valueSerializer, true);

    // Assert
    JsonSerializer<?> contentSerializer = actualUnwrappableIndexedListSerializer.getContentSerializer();
    assertTrue(contentSerializer instanceof XMLGregorianCalendarSerializer);
    JavaType contentType = actualUnwrappableIndexedListSerializer.getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    assertNull(actualUnwrappableIndexedListSerializer.getDelegatee());
    assertFalse(actualUnwrappableIndexedListSerializer.isUnwrappingSerializer());
    assertSame(valueSerializer, contentSerializer);
    assertSame(elemType, contentType);
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#unwrappingSerializer(NameTransformer)}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#unwrappingSerializer(NameTransformer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnwrappingIndexedListSerializer UnwrappableIndexedListSerializer.unwrappingSerializer(NameTransformer)"})
  public void testUnwrappingSerializer() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        false, vts, new Default(1, type));

    // Act and Assert
    JavaType contentType = unwrappableIndexedListSerializer
        .unwrappingSerializer(new Chained(mock(NameTransformer.class), mock(NameTransformer.class)))
        .getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    JavaType superClass = contentType.getSuperClass();
    assertTrue(superClass instanceof SimpleType);
    TypeBindings expectedBindings = contentType.getBindings();
    assertSame(expectedBindings, superClass.getBindings());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#unwrappingSerializer(NameTransformer)}.
   * <ul>
   *   <li>Then return {@link UnwrappingAsArraySerializerBase#_staticTyping}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#unwrappingSerializer(NameTransformer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnwrappingIndexedListSerializer UnwrappableIndexedListSerializer.unwrappingSerializer(NameTransformer)"})
  public void testUnwrappingSerializer_thenReturn_staticTyping() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));

    // Act
    UnwrappingIndexedListSerializer actualUnwrappingSerializerResult = unwrappableIndexedListSerializer
        .unwrappingSerializer(new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    // Assert
    JavaType contentType = actualUnwrappingSerializerResult.getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    JavaType superClass = contentType.getSuperClass();
    assertTrue(superClass instanceof SimpleType);
    assertTrue(actualUnwrappingSerializerResult._staticTyping);
    TypeBindings expectedBindings = contentType.getBindings();
    assertSame(expectedBindings, superClass.getBindings());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#unwrappingSerializer(NameTransformer)}.
   * <ul>
   *   <li>Then {@link UnwrappingAsArraySerializerBase#_valueTypeSerializer} return {@link AsDeductionTypeSerializer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#unwrappingSerializer(NameTransformer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnwrappingIndexedListSerializer UnwrappableIndexedListSerializer.unwrappingSerializer(NameTransformer)"})
  public void testUnwrappingSerializer_then_valueTypeSerializerReturnAsDeductionTypeSerializer() {
    // Arrange
    CollectionLikeType elemType = mock(CollectionLikeType.class);
    when(elemType.isFinal()).thenReturn(false);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    Default valueSerializer = new Default(1, type);

    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        false, vts, valueSerializer);

    // Act
    UnwrappingIndexedListSerializer actualUnwrappingSerializerResult = unwrappableIndexedListSerializer
        .unwrappingSerializer(new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    // Assert
    verify(elemType, atLeast(1)).isFinal();
    TypeSerializer typeSerializer = actualUnwrappingSerializerResult._valueTypeSerializer;
    assertTrue(typeSerializer instanceof AsDeductionTypeSerializer);
    assertTrue(actualUnwrappingSerializerResult._nameTransformer instanceof Chained);
    assertNull(actualUnwrappingSerializerResult._property);
    assertNull(actualUnwrappingSerializerResult.getDelegatee());
    assertNull(typeSerializer.getTypeIdResolver());
    assertNull(typeSerializer.getPropertyName());
    assertEquals(As.EXISTING_PROPERTY, typeSerializer.getTypeInclusion());
    assertFalse(actualUnwrappingSerializerResult._staticTyping);
    assertTrue(actualUnwrappingSerializerResult.isUnwrappingSerializer());
    assertSame(valueSerializer, actualUnwrappingSerializerResult.getContentSerializer());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#withResolved(BeanProperty, TypeSerializer, JsonSerializer, Boolean)} with {@code property}, {@code vts}, {@code elementSerializer}, {@code unwrapSingle}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#withResolved(BeanProperty, TypeSerializer, JsonSerializer, Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnwrappableIndexedListSerializer UnwrappableIndexedListSerializer.withResolved(BeanProperty, TypeSerializer, JsonSerializer, Boolean)"})
  public void testWithResolvedWithPropertyVtsElementSerializerUnwrapSingle() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    XMLGregorianCalendarSerializer elementSerializer = new XMLGregorianCalendarSerializer();

    // Act
    UnwrappableIndexedListSerializer actualWithResolvedResult = unwrappableIndexedListSerializer.withResolved(property,
        vts2, elementSerializer, true);

    // Assert
    JsonSerializer<?> contentSerializer = actualWithResolvedResult.getContentSerializer();
    assertTrue(contentSerializer instanceof XMLGregorianCalendarSerializer);
    JavaType contentType = actualWithResolvedResult.getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    assertNull(actualWithResolvedResult.getDelegatee());
    assertFalse(actualWithResolvedResult.isUnwrappingSerializer());
    assertSame(elementSerializer, contentSerializer);
    assertSame(elemType, contentType);
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#isEmpty(SerializerProvider, List)} with {@code prov}, {@code value}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#isEmpty(SerializerProvider, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappableIndexedListSerializer.isEmpty(SerializerProvider, List)"})
  public void testIsEmptyWithProvValue_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));
    Impl prov = new Impl();

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");

    // Act and Assert
    assertFalse(unwrappableIndexedListSerializer.isEmpty(prov, value));
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#isEmpty(SerializerProvider, List)} with {@code prov}, {@code value}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#isEmpty(SerializerProvider, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappableIndexedListSerializer.isEmpty(SerializerProvider, List)"})
  public void testIsEmptyWithProvValue_given42_whenArrayListAdd42_thenReturnFalse2() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));
    Impl prov = new Impl();

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");
    value.add("42");

    // Act and Assert
    assertFalse(unwrappableIndexedListSerializer.isEmpty(prov, value));
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#isEmpty(SerializerProvider, List)} with {@code prov}, {@code value}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#isEmpty(SerializerProvider, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappableIndexedListSerializer.isEmpty(SerializerProvider, List)"})
  public void testIsEmptyWithProvValue_whenArrayList_thenReturnTrue() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));
    Impl prov = new Impl();

    // Act and Assert
    assertTrue(unwrappableIndexedListSerializer.isEmpty(prov, new ArrayList<>()));
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#hasSingleElement(List)} with {@code List}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#hasSingleElement(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappableIndexedListSerializer.hasSingleElement(List)"})
  public void testHasSingleElementWithList_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");
    value.add("42");

    // Act and Assert
    assertFalse(unwrappableIndexedListSerializer.hasSingleElement(value));
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#hasSingleElement(List)} with {@code List}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#hasSingleElement(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappableIndexedListSerializer.hasSingleElement(List)"})
  public void testHasSingleElementWithList_given42_whenArrayListAdd42_thenReturnTrue() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");

    // Act and Assert
    assertTrue(unwrappableIndexedListSerializer.hasSingleElement(value));
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#hasSingleElement(List)} with {@code List}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#hasSingleElement(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappableIndexedListSerializer.hasSingleElement(List)"})
  public void testHasSingleElementWithList_whenArrayList_thenReturnFalse() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));

    // Act and Assert
    assertFalse(unwrappableIndexedListSerializer.hasSingleElement(new ArrayList<>()));
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#_withValueTypeSerializer(TypeSerializer)}.
   * <ul>
   *   <li>Then ContentSerializer return {@link StdKeySerializers.Default}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#_withValueTypeSerializer(TypeSerializer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnwrappableIndexedListSerializer UnwrappableIndexedListSerializer._withValueTypeSerializer(TypeSerializer)"})
  public void test_withValueTypeSerializer_thenContentSerializerReturnDefault() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    Default valueSerializer = new Default(1, type);

    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, valueSerializer);

    // Act
    UnwrappableIndexedListSerializer actual_withValueTypeSerializerResult = unwrappableIndexedListSerializer
        ._withValueTypeSerializer(AsDeductionTypeSerializer.instance());

    // Assert
    JsonSerializer<?> contentSerializer = actual_withValueTypeSerializerResult.getContentSerializer();
    assertTrue(contentSerializer instanceof Default);
    JavaType contentType = actual_withValueTypeSerializerResult.getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    assertNull(actual_withValueTypeSerializerResult.getDelegatee());
    assertFalse(actual_withValueTypeSerializerResult.isUnwrappingSerializer());
    assertSame(valueSerializer, contentSerializer);
    assertSame(elemType, contentType);
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappableIndexedListSerializer.serialize(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeWithListJsonGeneratorSerializerProvider() throws IOException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));
    ArrayList<Object> value = new ArrayList<>();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeEndArray();
    doNothing().when(d).writeStartArray(Mockito.<Object>any(), anyInt());
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    // Act
    unwrappableIndexedListSerializer.serialize(value, gen, new Impl());

    // Assert that nothing has changed
    verify(d).writeEndArray();
    verify(d).writeStartArray(isA(Object.class), eq(0));
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof JsonGeneratorDelegate);
    assertEquals(0, delegateResult.getOutputBuffered());
    assertEquals(0, gen.getOutputBuffered());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappableIndexedListSerializer.serialize(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeWithListJsonGeneratorSerializerProvider2() throws IOException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, AsDeductionTypeSerializer.instance(), null);
    ArrayList<Object> value = new ArrayList<>();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeEndArray();
    doNothing().when(d).writeStartArray(Mockito.<Object>any(), anyInt());
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    // Act
    unwrappableIndexedListSerializer.serialize(value, gen, new Impl());

    // Assert that nothing has changed
    verify(d).writeEndArray();
    verify(d).writeStartArray(isA(Object.class), eq(0));
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof JsonGeneratorDelegate);
    assertEquals(0, delegateResult.getOutputBuffered());
    assertEquals(0, gen.getOutputBuffered());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappableIndexedListSerializer.serialize(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeWithListJsonGeneratorSerializerProvider3() throws IOException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));
    ArrayList<Object> value = new ArrayList<>();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeEndArray();
    doNothing().when(d).writeStartArray();
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeEmptyArray(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter).filterFinishArray();
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.filterStartArray()).thenReturn(tokenFilter);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter2);
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d2, f, Inclusion.ONLY_INCLUDE_ALL, true), true);

    // Act
    unwrappableIndexedListSerializer.serialize(value, gen, new Impl());

    // Assert
    verify(d).writeEndArray();
    verify(d).writeStartArray();
    verify(tokenFilter).filterFinishArray();
    verify(tokenFilter2).filterStartArray();
    verify(tokenFilter).includeEmptyArray(eq(false));
    verify(f).includeRootValue(eq(0));
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    JsonGenerator delegateResult2 = ((FilteringGeneratorDelegate) delegateResult).delegate();
    assertTrue(delegateResult2 instanceof JsonGeneratorDelegate);
    JsonGenerator delegateResult3 = ((JsonGeneratorDelegate) delegateResult2).delegate();
    assertTrue(delegateResult3 instanceof JsonGeneratorDelegate);
    assertEquals(0, delegateResult.getOutputBuffered());
    assertEquals(0, delegateResult2.getOutputBuffered());
    assertEquals(0, delegateResult3.getOutputBuffered());
    assertEquals(0, gen.getOutputBuffered());
    assertEquals(1, outputContext.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappableIndexedListSerializer.serialize(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeWithListJsonGeneratorSerializerProvider4() throws IOException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));
    ArrayList<Object> value = new ArrayList<>();
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeEndArray();
    doNothing().when(d).writeStartArray();
    JsonGeneratorDelegate d2 = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeEmptyArray(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter).filterFinishArray();
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.filterStartArray()).thenReturn(tokenFilter);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter2);
    JsonGeneratorDelegate d3 = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d2, f, Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.includeEmptyArray(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter3).filterFinishArray();
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.filterStartArray()).thenReturn(tokenFilter3);
    TokenFilter f2 = mock(TokenFilter.class);
    when(f2.includeRootValue(anyInt())).thenReturn(tokenFilter4);
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d3, f2, Inclusion.ONLY_INCLUDE_ALL, true), true);

    // Act
    unwrappableIndexedListSerializer.serialize(value, gen, new Impl());

    // Assert
    verify(d).writeEndArray();
    verify(d).writeStartArray();
    verify(tokenFilter).filterFinishArray();
    verify(tokenFilter3).filterFinishArray();
    verify(tokenFilter2).filterStartArray();
    verify(tokenFilter4).filterStartArray();
    verify(tokenFilter).includeEmptyArray(eq(false));
    verify(tokenFilter3).includeEmptyArray(eq(false));
    verify(f).includeRootValue(eq(0));
    verify(f2).includeRootValue(eq(0));
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonGenerator delegateResult2 = ((FilteringGeneratorDelegate) delegateResult).delegate();
    JsonStreamContext outputContext = delegateResult2.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    JsonStreamContext outputContext2 = gen.getOutputContext();
    assertTrue(outputContext2 instanceof TokenFilterContext);
    assertTrue(delegateResult2 instanceof JsonGeneratorDelegate);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(1, outputContext2.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertTrue(outputContext2.hasCurrentIndex());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappableIndexedListSerializer.serialize(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeWithListJsonGeneratorSerializerProvider5() throws IOException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));
    ArrayList<Object> value = new ArrayList<>();
    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeEmptyArray(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter).filterFinishArray();
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.filterStartArray()).thenReturn(tokenFilter);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter2);
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    JsonMapper codec = JsonMapper.builder().findAndAddModules().build();
    JsonGeneratorDelegate d = new JsonGeneratorDelegate(new FilteringGeneratorDelegate(
        new JsonGeneratorDelegate(new UTF8JsonGenerator(ctxt, 1, codec, new ByteArrayOutputStream(1)), true), f,
        Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.includeEmptyArray(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter3).filterFinishArray();
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.filterStartArray()).thenReturn(tokenFilter3);
    TokenFilter f2 = mock(TokenFilter.class);
    when(f2.includeRootValue(anyInt())).thenReturn(tokenFilter4);
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d, f2, Inclusion.ONLY_INCLUDE_ALL, true), true);

    // Act
    unwrappableIndexedListSerializer.serialize(value, gen, new Impl());

    // Assert
    verify(tokenFilter).filterFinishArray();
    verify(tokenFilter3).filterFinishArray();
    verify(tokenFilter2).filterStartArray();
    verify(tokenFilter4).filterStartArray();
    verify(tokenFilter).includeEmptyArray(eq(false));
    verify(tokenFilter3).includeEmptyArray(eq(false));
    verify(f).includeRootValue(eq(0));
    verify(f2).includeRootValue(eq(0));
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonGenerator delegateResult2 = ((FilteringGeneratorDelegate) delegateResult).delegate();
    JsonGenerator delegateResult3 = ((JsonGeneratorDelegate) delegateResult2).delegate();
    assertTrue(delegateResult3 instanceof FilteringGeneratorDelegate);
    JsonGenerator delegateResult4 = ((FilteringGeneratorDelegate) delegateResult3).delegate();
    JsonGenerator delegateResult5 = ((JsonGeneratorDelegate) delegateResult4).delegate();
    assertTrue(delegateResult5 instanceof UTF8JsonGenerator);
    assertTrue(delegateResult2 instanceof JsonGeneratorDelegate);
    assertTrue(delegateResult4 instanceof JsonGeneratorDelegate);
    assertEquals(2, delegateResult.getOutputBuffered());
    assertEquals(2, delegateResult2.getOutputBuffered());
    assertEquals(2, delegateResult4.getOutputBuffered());
    assertEquals(2, delegateResult3.getOutputBuffered());
    assertEquals(2, delegateResult5.getOutputBuffered());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappableIndexedListSerializer.serialize(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeWithListJsonGeneratorSerializerProvider6() throws IOException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));
    ArrayList<Object> value = new ArrayList<>();
    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeEmptyArray(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter).filterFinishArray();
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.filterStartArray()).thenReturn(tokenFilter);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter2);
    JsonGeneratorDelegate d = new JsonGeneratorDelegate(new FilteringGeneratorDelegate(
        new JsonGeneratorDelegate(
            new TokenBuffer(new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()))), true),
        f, Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.includeEmptyArray(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter3).filterFinishArray();
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.filterStartArray()).thenReturn(tokenFilter3);
    TokenFilter f2 = mock(TokenFilter.class);
    when(f2.includeRootValue(anyInt())).thenReturn(tokenFilter4);
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d, f2, Inclusion.ONLY_INCLUDE_ALL, true), true);

    // Act
    unwrappableIndexedListSerializer.serialize(value, gen, new Impl());

    // Assert
    verify(tokenFilter).filterFinishArray();
    verify(tokenFilter3).filterFinishArray();
    verify(tokenFilter2).filterStartArray();
    verify(tokenFilter4).filterStartArray();
    verify(tokenFilter).includeEmptyArray(eq(false));
    verify(tokenFilter3).includeEmptyArray(eq(false));
    verify(f).includeRootValue(eq(0));
    verify(f2).includeRootValue(eq(0));
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonGenerator delegateResult2 = ((FilteringGeneratorDelegate) delegateResult).delegate();
    JsonGenerator delegateResult3 = ((JsonGeneratorDelegate) delegateResult2).delegate();
    assertTrue(delegateResult3 instanceof FilteringGeneratorDelegate);
    JsonStreamContext outputContext = delegateResult2.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    JsonGenerator delegateResult4 = ((FilteringGeneratorDelegate) delegateResult3).delegate();
    JsonStreamContext outputContext2 = delegateResult4.getOutputContext();
    assertTrue(outputContext2 instanceof JsonWriteContext);
    assertTrue(delegateResult2 instanceof JsonGeneratorDelegate);
    assertTrue(delegateResult4 instanceof JsonGeneratorDelegate);
    JsonGenerator delegateResult5 = ((JsonGeneratorDelegate) delegateResult4).delegate();
    assertTrue(delegateResult5 instanceof TokenBuffer);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(1, outputContext2.getEntryCount());
    assertFalse(((TokenBuffer) delegateResult5).isEmpty());
    assertTrue(outputContext.hasCurrentIndex());
    assertTrue(outputContext2.hasCurrentIndex());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappableIndexedListSerializer.serialize(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeWithListJsonGeneratorSerializerProvider7() throws IOException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));
    ArrayList<Object> value = new ArrayList<>();
    TokenFilter tokenFilter = mock(TokenFilter.class);
    when(tokenFilter.includeEmptyArray(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter).filterFinishArray();
    TokenFilter tokenFilter2 = mock(TokenFilter.class);
    when(tokenFilter2.filterStartArray()).thenReturn(tokenFilter);
    TokenFilter f = mock(TokenFilter.class);
    when(f.includeRootValue(anyInt())).thenReturn(tokenFilter2);
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    JsonMapper codec = JsonMapper.builder().findAndAddModules().build();
    JsonGeneratorDelegate d = new JsonGeneratorDelegate(new FilteringGeneratorDelegate(
        new JsonGeneratorDelegate(new YAMLGenerator(ctxt, 1, 1, codec, new StringWriter(), Version.V1_0), true), f,
        Inclusion.ONLY_INCLUDE_ALL, true), true);

    TokenFilter tokenFilter3 = mock(TokenFilter.class);
    when(tokenFilter3.includeEmptyArray(anyBoolean())).thenReturn(true);
    doNothing().when(tokenFilter3).filterFinishArray();
    TokenFilter tokenFilter4 = mock(TokenFilter.class);
    when(tokenFilter4.filterStartArray()).thenReturn(tokenFilter3);
    TokenFilter f2 = mock(TokenFilter.class);
    when(f2.includeRootValue(anyInt())).thenReturn(tokenFilter4);
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
        new FilteringGeneratorDelegate(d, f2, Inclusion.ONLY_INCLUDE_ALL, true), true);

    // Act
    unwrappableIndexedListSerializer.serialize(value, gen, new Impl());

    // Assert
    verify(tokenFilter).filterFinishArray();
    verify(tokenFilter3).filterFinishArray();
    verify(tokenFilter2).filterStartArray();
    verify(tokenFilter4).filterStartArray();
    verify(tokenFilter).includeEmptyArray(eq(false));
    verify(tokenFilter3).includeEmptyArray(eq(false));
    verify(f).includeRootValue(eq(0));
    verify(f2).includeRootValue(eq(0));
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof FilteringGeneratorDelegate);
    JsonGenerator delegateResult2 = ((FilteringGeneratorDelegate) delegateResult).delegate();
    JsonGenerator delegateResult3 = ((JsonGeneratorDelegate) delegateResult2).delegate();
    assertTrue(delegateResult3 instanceof FilteringGeneratorDelegate);
    JsonStreamContext outputContext = delegateResult2.getOutputContext();
    assertTrue(outputContext instanceof TokenFilterContext);
    JsonGenerator delegateResult4 = ((FilteringGeneratorDelegate) delegateResult3).delegate();
    JsonStreamContext outputContext2 = delegateResult4.getOutputContext();
    assertTrue(outputContext2 instanceof JsonWriteContext);
    assertTrue(delegateResult2 instanceof JsonGeneratorDelegate);
    assertTrue(delegateResult4 instanceof JsonGeneratorDelegate);
    assertEquals("%YAML 1.0\n--- []", gen.getOutputTarget().toString());
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(1, outputContext2.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertTrue(outputContext2.hasCurrentIndex());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappableIndexedListSerializer.serialize(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeWithListJsonGeneratorSerializerProvider8() throws IOException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));
    ArrayList<Object> value = new ArrayList<>();
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    JsonMapper codec = JsonMapper.builder().findAndAddModules().build();
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
        new UTF8JsonGenerator(ctxt, 1, codec, new ByteArrayOutputStream(1)), true);

    // Act
    unwrappableIndexedListSerializer.serialize(value, gen, new Impl());

    // Assert
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof JsonWriteContext);
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof UTF8JsonGenerator);
    assertEquals(1, outputContext.getEntryCount());
    assertEquals(2, delegateResult.getOutputBuffered());
    assertEquals(2, gen.getOutputBuffered());
    assertTrue(outputContext.hasCurrentIndex());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappableIndexedListSerializer.serialize(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeWithListJsonGeneratorSerializerProvider9() throws IOException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
        new TokenBuffer(new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()))), true);

    // Act
    unwrappableIndexedListSerializer.serialize(value, gen, new Impl());

    // Assert
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof JsonWriteContext);
    JsonGenerator delegateResult = gen.delegate();
    assertTrue(delegateResult instanceof TokenBuffer);
    assertEquals(-1, gen.getOutputBuffered());
    assertEquals(1, outputContext.getEntryCount());
    assertFalse(((TokenBuffer) delegateResult).isEmpty());
    assertTrue(outputContext.hasCurrentIndex());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappableIndexedListSerializer.serialize(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeWithListJsonGeneratorSerializerProvider10() throws IOException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));
    ArrayList<Object> value = new ArrayList<>();
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    JsonMapper codec = JsonMapper.builder().findAndAddModules().build();
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    AsciiXmlWriter xw = new AsciiXmlWriter(out, WriterConfig.createFullDefaults(), true);

    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new ToXmlGenerator(ctxt, 1, 1, codec,
        new StreamWriter2Delegate(new NonNsStreamWriter(xw, "Enc", WriterConfig.createFullDefaults())),
        mock(XmlNameProcessor.class)), true);

    // Act
    unwrappableIndexedListSerializer.serialize(value, gen, new Impl());

    // Assert
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof JsonWriteContext);
    assertEquals(-1, gen.getOutputBuffered());
    assertEquals(1, outputContext.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappableIndexedListSerializer.serialize(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeWithListJsonGeneratorSerializerProvider11() throws IOException {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, vts, new Default(1, type));
    ArrayList<Object> value = new ArrayList<>();
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.redacted(), true);

    JsonMapper codec = JsonMapper.builder().findAndAddModules().build();
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
        new YAMLGenerator(ctxt, 1, 1, codec, new StringWriter(), Version.V1_0), true);

    // Act
    unwrappableIndexedListSerializer.serialize(value, gen, new Impl());

    // Assert
    JsonStreamContext outputContext = gen.getOutputContext();
    assertTrue(outputContext instanceof JsonWriteContext);
    assertEquals("%YAML 1.0\n--- []", gen.getOutputTarget().toString());
    assertEquals(-1, gen.getOutputBuffered());
    assertEquals(1, outputContext.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void UnwrappableIndexedListSerializer.serializeContents(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeContentsWithListJsonGeneratorSerializerProvider() throws IOException {
    // Arrange
    Default valueSerializer = mock(Default.class);
    doNothing().when(valueSerializer)
        .serializeWithType(Mockito.<Object>any(), Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any(),
            Mockito.<TypeSerializer>any());
    PlaceholderForType elemType = new PlaceholderForType(1);
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, AsDeductionTypeSerializer.instance(), valueSerializer);

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");
    JsonGeneratorDelegate g = new JsonGeneratorDelegate(new JsonGeneratorDelegate(null), true);

    // Act
    unwrappableIndexedListSerializer.serializeContents(value, g, new Impl());

    // Assert
    verify(valueSerializer).serializeWithType(isA(Object.class), isA(JsonGenerator.class),
        isA(SerializerProvider.class), isA(TypeSerializer.class));
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void UnwrappableIndexedListSerializer.serializeContents(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeContentsWithListJsonGeneratorSerializerProvider2() throws IOException {
    // Arrange
    Default valueSerializer = mock(Default.class);
    doNothing().when(valueSerializer)
        .serialize(Mockito.<Object>any(), Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());

    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(
        new PlaceholderForType(1), true, null, valueSerializer);
    unwrappableIndexedListSerializer.setNextElementSubstitutionMap(new SubstitutionMap(new HashMap<>()));

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");
    JsonGeneratorDelegate g = new JsonGeneratorDelegate(new JsonGeneratorDelegate(null), true);

    // Act
    unwrappableIndexedListSerializer.serializeContents(value, g, new Impl());

    // Assert
    verify(valueSerializer).serialize(isA(Object.class), isA(JsonGenerator.class), isA(SerializerProvider.class));
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void UnwrappableIndexedListSerializer.serializeContents(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeContentsWithListJsonGeneratorSerializerProvider3() throws IOException {
    // Arrange
    Default valueSerializer = mock(Default.class);
    doThrow(new IOException("foo")).when(valueSerializer)
        .serialize(Mockito.<Object>any(), Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(
        new PlaceholderForType(1), true, null, valueSerializer);

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");
    JsonGeneratorDelegate g = new JsonGeneratorDelegate(new JsonGeneratorDelegate(null), true);

    XmlSerializerProvider src = new XmlSerializerProvider(new XmlRootNameLookup());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector ai = new RosettaJSONAnnotationIntrospector(true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer = new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, null, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(null);
    RootNameLookup rootNames = new RootNameLookup();

    // Act and Assert
    assertThrows(IOException.class,
        () -> unwrappableIndexedListSerializer.serializeContents(value, g,
            new XmlSerializerProvider(src, new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides()),
                RosettaSerialiserFactory.INSTANCE)));
    verify(valueSerializer).serialize(isA(Object.class), isA(JsonGenerator.class), isA(SerializerProvider.class));
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <ul>
   *   <li>Then calls {@link StdKeySerializers.Default#serialize(Object, JsonGenerator, SerializerProvider)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void UnwrappableIndexedListSerializer.serializeContents(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeContentsWithListJsonGeneratorSerializerProvider_thenCallsSerialize() throws IOException {
    // Arrange
    Default valueSerializer = mock(Default.class);
    doNothing().when(valueSerializer)
        .serialize(Mockito.<Object>any(), Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(
        new PlaceholderForType(1), true, null, valueSerializer);

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");
    JsonGeneratorDelegate g = new JsonGeneratorDelegate(new JsonGeneratorDelegate(null), true);

    // Act
    unwrappableIndexedListSerializer.serializeContents(value, g, new Impl());

    // Assert
    verify(valueSerializer).serialize(isA(Object.class), isA(JsonGenerator.class), isA(SerializerProvider.class));
  }

  /**
   * Test {@link UnwrappableIndexedListSerializer#serializeTypedContents(List, JsonGenerator, SerializerProvider)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link JavaType#getRawClass()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappableIndexedListSerializer#serializeTypedContents(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void UnwrappableIndexedListSerializer.serializeTypedContents(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeTypedContents_whenArrayList_thenCallsGetRawClass() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription beanDesc = mock(BasicBeanDescription.class);
    when(beanDesc.findExpectedFormat()).thenReturn(Value.empty());
    BeanSerializerBuilder builder = new BeanSerializerBuilder(beanDesc);
    POJOPropertyBuilder propDef = mock(POJOPropertyBuilder.class);
    when(propDef.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef.getMetadata()).thenReturn(null);
    when(propDef.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations = new AnnotationMap();
    XMLGregorianCalendarSerializer ser = new XMLGregorianCalendarSerializer();
    POJOPropertyBuilder propDef2 = mock(POJOPropertyBuilder.class);
    when(propDef2.getWrapperName()).thenReturn(PropertyName.construct("Simple Name"));
    when(propDef2.getMetadata()).thenReturn(null);
    when(propDef2.getName()).thenReturn("Name");
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    XMLGregorianCalendarSerializer ser2 = new XMLGregorianCalendarSerializer();
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef, null, contextAnnotations, null, ser,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")},
        new BeanPropertyWriter[]{new BeanPropertyWriter(propDef2, null, contextAnnotations2, null, ser2,
            AsDeductionTypeSerializer.instance(), null, true, "Suppressable Value")});

    PlaceholderForType elemType = new PlaceholderForType(1);
    UnwrappableIndexedListSerializer unwrappableIndexedListSerializer = new UnwrappableIndexedListSerializer(elemType,
        true, AsDeductionTypeSerializer.instance(), valueSerializer);
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate jgen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(null), true);

    // Act
    unwrappableIndexedListSerializer.serializeTypedContents(value, jgen, new Impl());

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
}
