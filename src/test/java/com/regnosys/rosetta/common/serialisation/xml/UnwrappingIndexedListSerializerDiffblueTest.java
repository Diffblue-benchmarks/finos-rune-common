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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers.XMLGregorianCalendarSerializer;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeSerializer;
import com.fasterxml.jackson.databind.ser.AnyGetterWriter;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializer;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.NameTransformer.Chained;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UnwrappingIndexedListSerializerDiffblueTest {
  /**
   * Test {@link UnwrappingIndexedListSerializer#UnwrappingIndexedListSerializer(UnwrappingIndexedListSerializer, BeanProperty, TypeSerializer, JsonSerializer)}.
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#UnwrappingIndexedListSerializer(UnwrappingIndexedListSerializer, BeanProperty, TypeSerializer, JsonSerializer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void UnwrappingIndexedListSerializer.<init>(UnwrappingIndexedListSerializer, BeanProperty, TypeSerializer, JsonSerializer)"})
  public void testNewUnwrappingIndexedListSerializer() {
    // Arrange
    BasicBeanDescription beanDesc = mock(BasicBeanDescription.class);
    when(beanDesc.findExpectedFormat()).thenReturn(Value.empty());
    BeanSerializerBuilder builder = new BeanSerializerBuilder(beanDesc);
    BeanSerializer valueSerializer = new BeanSerializer(new PlaceholderForType(1), builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    XMLGregorianCalendarSerializer valueSerializer2 = new XMLGregorianCalendarSerializer();

    // Act
    UnwrappingIndexedListSerializer actualUnwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src,
        property, vts2, valueSerializer2);

    // Assert
    verify(beanDesc).findExpectedFormat();
    JsonSerializer<?> contentSerializer = actualUnwrappingIndexedListSerializer.getContentSerializer();
    assertTrue(contentSerializer instanceof XMLGregorianCalendarSerializer);
    assertTrue(actualUnwrappingIndexedListSerializer._valueTypeSerializer instanceof AsDeductionTypeSerializer);
    JavaType contentType = actualUnwrappingIndexedListSerializer.getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    assertTrue(actualUnwrappingIndexedListSerializer._nameTransformer instanceof Chained);
    assertTrue(actualUnwrappingIndexedListSerializer._property instanceof SubstitutedMethodProperty);
    assertNull(actualUnwrappingIndexedListSerializer.getDelegatee());
    assertTrue(actualUnwrappingIndexedListSerializer.isUnwrappingSerializer());
    assertTrue(actualUnwrappingIndexedListSerializer._staticTyping);
    assertSame(valueSerializer2, contentSerializer);
    assertSame(elemType, contentType);
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#UnwrappingIndexedListSerializer(UnwrappingIndexedListSerializer, BeanProperty, TypeSerializer, JsonSerializer)}.
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#UnwrappingIndexedListSerializer(UnwrappingIndexedListSerializer, BeanProperty, TypeSerializer, JsonSerializer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void UnwrappingIndexedListSerializer.<init>(UnwrappingIndexedListSerializer, BeanProperty, TypeSerializer, JsonSerializer)"})
  public void testNewUnwrappingIndexedListSerializer2() {
    // Arrange
    BasicBeanDescription beanDesc = mock(BasicBeanDescription.class);
    when(beanDesc.findExpectedFormat()).thenReturn(Value.empty());
    BeanSerializerBuilder builder = new BeanSerializerBuilder(beanDesc);
    BeanSerializer valueSerializer = new BeanSerializer(new PlaceholderForType(1), builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    XMLGregorianCalendarSerializer valueSerializer2 = new XMLGregorianCalendarSerializer();

    // Act
    UnwrappingIndexedListSerializer actualUnwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src,
        property, vts2, valueSerializer2);

    // Assert
    verify(beanDesc).findExpectedFormat();
    JsonSerializer<?> contentSerializer = actualUnwrappingIndexedListSerializer.getContentSerializer();
    assertTrue(contentSerializer instanceof XMLGregorianCalendarSerializer);
    assertTrue(actualUnwrappingIndexedListSerializer._valueTypeSerializer instanceof AsDeductionTypeSerializer);
    JavaType contentType = actualUnwrappingIndexedListSerializer.getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    assertTrue(actualUnwrappingIndexedListSerializer._nameTransformer instanceof Chained);
    assertTrue(actualUnwrappingIndexedListSerializer._property instanceof SubstitutedMethodProperty);
    assertNull(actualUnwrappingIndexedListSerializer.getDelegatee());
    assertTrue(actualUnwrappingIndexedListSerializer.isUnwrappingSerializer());
    assertTrue(actualUnwrappingIndexedListSerializer._staticTyping);
    assertSame(valueSerializer2, contentSerializer);
    assertSame(elemType, contentType);
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#withResolved(BeanProperty, TypeSerializer, JsonSerializer)}.
   * <ul>
   *   <li>Then ContentSerializer return {@link CoreXMLSerializers.XMLGregorianCalendarSerializer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#withResolved(BeanProperty, TypeSerializer, JsonSerializer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnwrappingIndexedListSerializer UnwrappingIndexedListSerializer.withResolved(BeanProperty, TypeSerializer, JsonSerializer)"})
  public void testWithResolved_thenContentSerializerReturnXMLGregorianCalendarSerializer() {
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
    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts3 = AsDeductionTypeSerializer.instance();
    XMLGregorianCalendarSerializer elementSerializer = new XMLGregorianCalendarSerializer();

    // Act
    UnwrappingIndexedListSerializer actualWithResolvedResult = unwrappingIndexedListSerializer.withResolved(property2,
        vts3, elementSerializer);

    // Assert
    JsonSerializer<?> contentSerializer = actualWithResolvedResult.getContentSerializer();
    assertTrue(contentSerializer instanceof XMLGregorianCalendarSerializer);
    assertTrue(actualWithResolvedResult._valueTypeSerializer instanceof AsDeductionTypeSerializer);
    JavaType contentType = actualWithResolvedResult.getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    assertTrue(actualWithResolvedResult._nameTransformer instanceof Chained);
    assertTrue(actualWithResolvedResult._property instanceof SubstitutedMethodProperty);
    assertNull(actualWithResolvedResult.getDelegatee());
    assertTrue(actualWithResolvedResult.isUnwrappingSerializer());
    assertTrue(actualWithResolvedResult._staticTyping);
    assertSame(elementSerializer, contentSerializer);
    assertSame(elemType, contentType);
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#isEmpty(SerializerProvider, List)} with {@code prov}, {@code value}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#isEmpty(SerializerProvider, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappingIndexedListSerializer.isEmpty(SerializerProvider, List)"})
  public void testIsEmptyWithProvValue_given42_whenArrayListAdd42_thenReturnFalse() {
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
    Impl prov = new Impl();

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");

    // Act and Assert
    assertFalse(unwrappingIndexedListSerializer.isEmpty(prov, value));
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#isEmpty(SerializerProvider, List)} with {@code prov}, {@code value}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#isEmpty(SerializerProvider, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappingIndexedListSerializer.isEmpty(SerializerProvider, List)"})
  public void testIsEmptyWithProvValue_given42_whenArrayListAdd42_thenReturnFalse2() {
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
    Impl prov = new Impl();

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");
    value.add("42");

    // Act and Assert
    assertFalse(unwrappingIndexedListSerializer.isEmpty(prov, value));
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#isEmpty(SerializerProvider, List)} with {@code prov}, {@code value}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#isEmpty(SerializerProvider, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappingIndexedListSerializer.isEmpty(SerializerProvider, List)"})
  public void testIsEmptyWithProvValue_given42_whenArrayListAdd42_thenReturnFalse3() {
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
    Impl prov = new Impl();

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");

    // Act and Assert
    assertFalse(unwrappingIndexedListSerializer.isEmpty(prov, value));
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#isEmpty(SerializerProvider, List)} with {@code prov}, {@code value}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#isEmpty(SerializerProvider, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappingIndexedListSerializer.isEmpty(SerializerProvider, List)"})
  public void testIsEmptyWithProvValue_given42_whenArrayListAdd42_thenReturnFalse4() {
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
    Impl prov = new Impl();

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");
    value.add("42");

    // Act and Assert
    assertFalse(unwrappingIndexedListSerializer.isEmpty(prov, value));
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#isEmpty(SerializerProvider, List)} with {@code prov}, {@code value}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#isEmpty(SerializerProvider, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappingIndexedListSerializer.isEmpty(SerializerProvider, List)"})
  public void testIsEmptyWithProvValue_whenArrayList_thenReturnTrue() {
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
    Impl prov = new Impl();

    // Act and Assert
    assertTrue(unwrappingIndexedListSerializer.isEmpty(prov, new ArrayList<>()));
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#isEmpty(SerializerProvider, List)} with {@code prov}, {@code value}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#isEmpty(SerializerProvider, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappingIndexedListSerializer.isEmpty(SerializerProvider, List)"})
  public void testIsEmptyWithProvValue_whenArrayList_thenReturnTrue2() {
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
    Impl prov = new Impl();

    // Act and Assert
    assertTrue(unwrappingIndexedListSerializer.isEmpty(prov, new ArrayList<>()));
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#hasSingleElement(List)} with {@code List}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#hasSingleElement(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappingIndexedListSerializer.hasSingleElement(List)"})
  public void testHasSingleElementWithList_given42_whenArrayListAdd42_thenReturnFalse() {
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

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");
    value.add("42");

    // Act and Assert
    assertFalse(unwrappingIndexedListSerializer.hasSingleElement(value));
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#hasSingleElement(List)} with {@code List}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#hasSingleElement(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappingIndexedListSerializer.hasSingleElement(List)"})
  public void testHasSingleElementWithList_given42_whenArrayListAdd42_thenReturnFalse2() {
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

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");
    value.add("42");

    // Act and Assert
    assertFalse(unwrappingIndexedListSerializer.hasSingleElement(value));
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#hasSingleElement(List)} with {@code List}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#hasSingleElement(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappingIndexedListSerializer.hasSingleElement(List)"})
  public void testHasSingleElementWithList_given42_whenArrayListAdd42_thenReturnTrue() {
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

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");

    // Act and Assert
    assertTrue(unwrappingIndexedListSerializer.hasSingleElement(value));
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#hasSingleElement(List)} with {@code List}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#hasSingleElement(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappingIndexedListSerializer.hasSingleElement(List)"})
  public void testHasSingleElementWithList_given42_whenArrayListAdd42_thenReturnTrue2() {
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

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");

    // Act and Assert
    assertTrue(unwrappingIndexedListSerializer.hasSingleElement(value));
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#hasSingleElement(List)} with {@code List}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#hasSingleElement(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappingIndexedListSerializer.hasSingleElement(List)"})
  public void testHasSingleElementWithList_whenArrayList_thenReturnFalse() {
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
    assertFalse(unwrappingIndexedListSerializer.hasSingleElement(new ArrayList<>()));
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#hasSingleElement(List)} with {@code List}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#hasSingleElement(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnwrappingIndexedListSerializer.hasSingleElement(List)"})
  public void testHasSingleElementWithList_whenArrayList_thenReturnFalse2() {
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
    assertFalse(unwrappingIndexedListSerializer.hasSingleElement(new ArrayList<>()));
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#_withValueTypeSerializer(TypeSerializer)}.
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#_withValueTypeSerializer(TypeSerializer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnwrappingIndexedListSerializer UnwrappingIndexedListSerializer._withValueTypeSerializer(TypeSerializer)"})
  public void test_withValueTypeSerializer() {
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

    // Act
    UnwrappingIndexedListSerializer actual_withValueTypeSerializerResult = unwrappingIndexedListSerializer
        ._withValueTypeSerializer(AsDeductionTypeSerializer.instance());

    // Assert
    JsonSerializer<?> contentSerializer = actual_withValueTypeSerializerResult.getContentSerializer();
    assertTrue(contentSerializer instanceof XMLGregorianCalendarSerializer);
    assertTrue(actual_withValueTypeSerializerResult._valueTypeSerializer instanceof AsDeductionTypeSerializer);
    JavaType contentType = actual_withValueTypeSerializerResult.getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    assertTrue(actual_withValueTypeSerializerResult._nameTransformer instanceof Chained);
    assertTrue(actual_withValueTypeSerializerResult._property instanceof SubstitutedMethodProperty);
    assertNull(actual_withValueTypeSerializerResult.getDelegatee());
    assertTrue(actual_withValueTypeSerializerResult.isUnwrappingSerializer());
    assertTrue(actual_withValueTypeSerializerResult._staticTyping);
    assertSame(valueSerializer2, contentSerializer);
    assertSame(elemType, contentType);
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#_withValueTypeSerializer(TypeSerializer)}.
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#_withValueTypeSerializer(TypeSerializer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "UnwrappingIndexedListSerializer UnwrappingIndexedListSerializer._withValueTypeSerializer(TypeSerializer)"})
  public void test_withValueTypeSerializer2() {
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

    // Act
    UnwrappingIndexedListSerializer actual_withValueTypeSerializerResult = unwrappingIndexedListSerializer
        ._withValueTypeSerializer(AsDeductionTypeSerializer.instance());

    // Assert
    JsonSerializer<?> contentSerializer = actual_withValueTypeSerializerResult.getContentSerializer();
    assertTrue(contentSerializer instanceof XMLGregorianCalendarSerializer);
    assertTrue(actual_withValueTypeSerializerResult._valueTypeSerializer instanceof AsDeductionTypeSerializer);
    JavaType contentType = actual_withValueTypeSerializerResult.getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    assertTrue(actual_withValueTypeSerializerResult._nameTransformer instanceof Chained);
    assertTrue(actual_withValueTypeSerializerResult._property instanceof SubstitutedMethodProperty);
    assertNull(actual_withValueTypeSerializerResult.getDelegatee());
    assertTrue(actual_withValueTypeSerializerResult.isUnwrappingSerializer());
    assertTrue(actual_withValueTypeSerializerResult._staticTyping);
    assertSame(valueSerializer2, contentSerializer);
    assertSame(elemType, contentType);
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappingIndexedListSerializer.serialize(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeWithListJsonGeneratorSerializerProvider() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, AsDeductionTypeSerializer.instance(), null);
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class)), true);

    // Act
    unwrappingIndexedListSerializer.serialize(value, gen, new Impl());

    // Assert
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappingIndexedListSerializer.serialize(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeWithListJsonGeneratorSerializerProvider2() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, AsDeductionTypeSerializer.instance(), null);
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class)), true);

    // Act
    unwrappingIndexedListSerializer.serialize(value, gen, new Impl());

    // Assert
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <ul>
   *   <li>Then calls {@link JavaType#getRawClass()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappingIndexedListSerializer.serialize(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeWithListJsonGeneratorSerializerProvider_thenCallsGetRawClass() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, vts2, new XMLGregorianCalendarSerializer());
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class)), true);

    // Act
    unwrappingIndexedListSerializer.serialize(value, gen, new Impl());

    // Assert
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <ul>
   *   <li>Then calls {@link JavaType#getRawClass()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappingIndexedListSerializer.serialize(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeWithListJsonGeneratorSerializerProvider_thenCallsGetRawClass2() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, vts2, new XMLGregorianCalendarSerializer());
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class)), true);

    // Act
    unwrappingIndexedListSerializer.serialize(value, gen, new Impl());

    // Assert
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappingIndexedListSerializer.serializeContents(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeContentsWithListJsonGeneratorSerializerProvider() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, vts2, new XMLGregorianCalendarSerializer());
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate g = new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class)), true);

    // Act
    unwrappingIndexedListSerializer.serializeContents(value, g, new Impl());

    // Assert
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappingIndexedListSerializer.serializeContents(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeContentsWithListJsonGeneratorSerializerProvider2() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, AsDeductionTypeSerializer.instance(), null);
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate g = new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class)), true);

    // Act
    unwrappingIndexedListSerializer.serializeContents(value, g, new Impl());

    // Assert
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappingIndexedListSerializer.serializeContents(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeContentsWithListJsonGeneratorSerializerProvider3() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, vts2, new XMLGregorianCalendarSerializer());
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate g = new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class)), true);

    // Act
    unwrappingIndexedListSerializer.serializeContents(value, g, new Impl());

    // Assert
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)} with {@code List}, {@code JsonGenerator}, {@code SerializerProvider}.
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnwrappingIndexedListSerializer.serializeContents(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeContentsWithListJsonGeneratorSerializerProvider4() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, AsDeductionTypeSerializer.instance(), null);
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate g = new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class)), true);

    // Act
    unwrappingIndexedListSerializer.serializeContents(value, g, new Impl());

    // Assert
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#serializeTypedContents(List, JsonGenerator, SerializerProvider)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link JavaType#getRawClass()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UnwrappingIndexedListSerializer#serializeTypedContents(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void UnwrappingIndexedListSerializer.serializeTypedContents(List, JsonGenerator, SerializerProvider)"})
  public void testSerializeTypedContents_whenArrayList_thenCallsGetRawClass() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    org.mockito.Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, vts2, new XMLGregorianCalendarSerializer());
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate jgen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class)), true);

    // Act
    unwrappingIndexedListSerializer.serializeTypedContents(value, jgen, new Impl());

    // Assert
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
  }
}
