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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers;
import com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeSerializer;
import com.fasterxml.jackson.databind.ser.AnyGetterWriter;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializer;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

public class UnwrappingIndexedListSerializerDiffblueTest {
  /**
   * Method under test:
   * {@link UnwrappingIndexedListSerializer#withResolved(BeanProperty, TypeSerializer, JsonSerializer)}
   */
  @Test
  public void testWithResolved() {
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
    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    PropertyName newName = PropertyName.construct("Simple Name");
    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, newName);

    AsDeductionTypeSerializer vts3 = AsDeductionTypeSerializer.instance();
    CoreXMLSerializers.XMLGregorianCalendarSerializer elementSerializer = new CoreXMLSerializers.XMLGregorianCalendarSerializer();

    // Act
    UnwrappingIndexedListSerializer actualWithResolvedResult = unwrappingIndexedListSerializer.withResolved(property2,
        vts3, elementSerializer);

    // Assert
    TypeSerializer typeSerializer = actualWithResolvedResult._valueTypeSerializer;
    assertTrue(typeSerializer instanceof AsDeductionTypeSerializer);
    assertTrue(actualWithResolvedResult._nameTransformer instanceof NameTransformer.Chained);
    BeanProperty beanProperty = actualWithResolvedResult._property;
    assertTrue(beanProperty instanceof SubstitutedMethodProperty);
    assertEquals("Simple Name", beanProperty.getName());
    assertNull(beanProperty.getType());
    assertNull(((SubstitutedMethodProperty) beanProperty).getValueDeserializer());
    assertNull(actualWithResolvedResult.getDelegatee());
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
    assertTrue(actualWithResolvedResult.isUnwrappingSerializer());
    assertTrue(actualWithResolvedResult._staticTyping);
    assertSame(elementSerializer, actualWithResolvedResult.getContentSerializer());
    assertSame(elemType, actualWithResolvedResult.getContentType());
    assertSame(newName, beanProperty.getFullName());
  }

  /**
   * Method under test:
   * {@link UnwrappingIndexedListSerializer#isEmpty(SerializerProvider, List)}
   */
  @Test
  public void testIsEmpty() {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new CoreXMLSerializers.XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, vts2, new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    DefaultSerializerProvider.Impl prov = new DefaultSerializerProvider.Impl();

    // Act
    boolean actualIsEmptyResult = unwrappingIndexedListSerializer.isEmpty(prov, new ArrayList<>());

    // Assert
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
    assertTrue(actualIsEmptyResult);
  }

  /**
   * Method under test:
   * {@link UnwrappingIndexedListSerializer#isEmpty(SerializerProvider, List)}
   */
  @Test
  public void testIsEmpty2() {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new CoreXMLSerializers.XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, vts2, new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    DefaultSerializerProvider.Impl prov = new DefaultSerializerProvider.Impl();

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");

    // Act
    boolean actualIsEmptyResult = unwrappingIndexedListSerializer.isEmpty(prov, value);

    // Assert
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
    assertFalse(actualIsEmptyResult);
  }

  /**
   * Method under test:
   * {@link UnwrappingIndexedListSerializer#isEmpty(SerializerProvider, List)}
   */
  @Test
  public void testIsEmpty3() {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new CoreXMLSerializers.XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, vts2, new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    DefaultSerializerProvider.Impl prov = new DefaultSerializerProvider.Impl();

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");
    value.add("42");

    // Act
    boolean actualIsEmptyResult = unwrappingIndexedListSerializer.isEmpty(prov, value);

    // Assert
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
    assertFalse(actualIsEmptyResult);
  }

  /**
   * Method under test:
   * {@link UnwrappingIndexedListSerializer#hasSingleElement(List)}
   */
  @Test
  public void testHasSingleElement() {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new CoreXMLSerializers.XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, vts2, new CoreXMLSerializers.XMLGregorianCalendarSerializer());

    // Act
    boolean actualHasSingleElementResult = unwrappingIndexedListSerializer.hasSingleElement(new ArrayList<>());

    // Assert
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
    assertFalse(actualHasSingleElementResult);
  }

  /**
   * Method under test:
   * {@link UnwrappingIndexedListSerializer#hasSingleElement(List)}
   */
  @Test
  public void testHasSingleElement2() {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new CoreXMLSerializers.XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, vts2, new CoreXMLSerializers.XMLGregorianCalendarSerializer());

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");

    // Act
    boolean actualHasSingleElementResult = unwrappingIndexedListSerializer.hasSingleElement(value);

    // Assert
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
    assertTrue(actualHasSingleElementResult);
  }

  /**
   * Method under test:
   * {@link UnwrappingIndexedListSerializer#hasSingleElement(List)}
   */
  @Test
  public void testHasSingleElement3() {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new CoreXMLSerializers.XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, vts2, new CoreXMLSerializers.XMLGregorianCalendarSerializer());

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");
    value.add("42");

    // Act
    boolean actualHasSingleElementResult = unwrappingIndexedListSerializer.hasSingleElement(value);

    // Assert
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
    assertFalse(actualHasSingleElementResult);
  }

  /**
   * Method under test:
   * {@link UnwrappingIndexedListSerializer#UnwrappingIndexedListSerializer(UnwrappingIndexedListSerializer, BeanProperty, TypeSerializer, JsonSerializer)}
   */
  @Test
  public void testNewUnwrappingIndexedListSerializer() {
    // Arrange
    BasicBeanDescription beanDesc = mock(BasicBeanDescription.class);
    when(beanDesc.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = new BeanSerializerBuilder(beanDesc);
    BeanSerializer valueSerializer = new BeanSerializer(new PlaceholderForType(1), builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    PropertyName newName = PropertyName.construct("Simple Name");
    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, newName);

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    CoreXMLSerializers.XMLGregorianCalendarSerializer valueSerializer2 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();

    // Act
    UnwrappingIndexedListSerializer actualUnwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src,
        property, vts2, valueSerializer2);

    // Assert
    verify(beanDesc).findExpectedFormat();
    TypeSerializer typeSerializer = actualUnwrappingIndexedListSerializer._valueTypeSerializer;
    assertTrue(typeSerializer instanceof AsDeductionTypeSerializer);
    assertTrue(actualUnwrappingIndexedListSerializer._nameTransformer instanceof NameTransformer.Chained);
    BeanProperty beanProperty = actualUnwrappingIndexedListSerializer._property;
    assertTrue(beanProperty instanceof SubstitutedMethodProperty);
    assertEquals("Simple Name", beanProperty.getName());
    assertNull(beanProperty.getType());
    assertNull(((SubstitutedMethodProperty) beanProperty).getValueDeserializer());
    assertNull(actualUnwrappingIndexedListSerializer.getDelegatee());
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
    assertTrue(actualUnwrappingIndexedListSerializer.isUnwrappingSerializer());
    assertTrue(actualUnwrappingIndexedListSerializer._staticTyping);
    assertSame(valueSerializer2, actualUnwrappingIndexedListSerializer.getContentSerializer());
    assertSame(elemType, actualUnwrappingIndexedListSerializer.getContentType());
    assertSame(newName, beanProperty.getFullName());
  }

  /**
   * Method under test:
   * {@link UnwrappingIndexedListSerializer#_withValueTypeSerializer(TypeSerializer)}
   */
  @Test
  public void test_withValueTypeSerializer() {
    // Arrange
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    Class<Object> type = Object.class;
    StdKeySerializers.Default valueSerializer = new StdKeySerializers.Default(1, type);

    UnwrappingIndexedListSerializer src = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src2 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    PropertyName newName = PropertyName.construct("Simple Name");
    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src2, newName);

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    CoreXMLSerializers.XMLGregorianCalendarSerializer valueSerializer2 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src, property,
        vts2, valueSerializer2);

    // Act
    UnwrappingIndexedListSerializer actual_withValueTypeSerializerResult = unwrappingIndexedListSerializer
        ._withValueTypeSerializer(AsDeductionTypeSerializer.instance());

    // Assert
    TypeSerializer typeSerializer = actual_withValueTypeSerializerResult._valueTypeSerializer;
    assertTrue(typeSerializer instanceof AsDeductionTypeSerializer);
    assertTrue(actual_withValueTypeSerializerResult._nameTransformer instanceof NameTransformer.Chained);
    BeanProperty beanProperty = actual_withValueTypeSerializerResult._property;
    assertTrue(beanProperty instanceof SubstitutedMethodProperty);
    assertEquals("Simple Name", beanProperty.getName());
    assertNull(beanProperty.getType());
    assertNull(((SubstitutedMethodProperty) beanProperty).getValueDeserializer());
    assertNull(actual_withValueTypeSerializerResult.getDelegatee());
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
    assertTrue(actual_withValueTypeSerializerResult.isUnwrappingSerializer());
    assertTrue(actual_withValueTypeSerializerResult._staticTyping);
    assertSame(valueSerializer2, actual_withValueTypeSerializerResult.getContentSerializer());
    assertSame(elemType, actual_withValueTypeSerializerResult.getContentType());
    assertSame(newName, beanProperty.getFullName());
  }

  /**
   * Method under test:
   * {@link UnwrappingIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  public void testSerialize() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new CoreXMLSerializers.XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, vts2, new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class)), true);

    // Act
    unwrappingIndexedListSerializer.serialize(value, gen, new DefaultSerializerProvider.Impl());

    // Assert that nothing has changed
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
  }

  /**
   * Method under test:
   * {@link UnwrappingIndexedListSerializer#serialize(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  public void testSerialize2() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new CoreXMLSerializers.XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, AsDeductionTypeSerializer.instance(), null);
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class)), true);

    // Act
    unwrappingIndexedListSerializer.serialize(value, gen, new DefaultSerializerProvider.Impl());

    // Assert that nothing has changed
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
  }

  /**
   * Method under test:
   * {@link UnwrappingIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  public void testSerializeContents() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new CoreXMLSerializers.XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, vts2, new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate g = new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class)), true);

    // Act
    unwrappingIndexedListSerializer.serializeContents(value, g, new DefaultSerializerProvider.Impl());

    // Assert that nothing has changed
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
  }

  /**
   * Method under test:
   * {@link UnwrappingIndexedListSerializer#serializeContents(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  public void testSerializeContents2() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new CoreXMLSerializers.XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, AsDeductionTypeSerializer.instance(), null);
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate g = new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class)), true);

    // Act
    unwrappingIndexedListSerializer.serializeContents(value, g, new DefaultSerializerProvider.Impl());

    // Assert that nothing has changed
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
  }

  /**
   * Method under test:
   * {@link UnwrappingIndexedListSerializer#serializeTypedContents(List, JsonGenerator, SerializerProvider)}
   */
  @Test
  public void testSerializeTypedContents() throws IOException {
    // Arrange
    CollectionLikeType type = mock(CollectionLikeType.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(type.getRawClass()).thenReturn(forNameResult);
    BasicBeanDescription basicBeanDescription = mock(BasicBeanDescription.class);
    when(basicBeanDescription.findExpectedFormat()).thenReturn(JsonFormat.Value.empty());
    BeanSerializerBuilder builder = mock(BeanSerializerBuilder.class);
    when(builder.getBeanDescription()).thenReturn(basicBeanDescription);
    Class<Object> declaringClass = Object.class;
    when(builder.getTypeId()).thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));
    SubstitutedMethodProperty src = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);

    SubstitutedMethodProperty property = new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute accessor = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    when(builder.getAnyGetter())
        .thenReturn(new AnyGetterWriter(property, accessor, new CoreXMLSerializers.XMLGregorianCalendarSerializer()));
    when(builder.getObjectIdWriter()).thenReturn(null);
    when(builder.getFilterId()).thenReturn("Filter Id");
    BeanSerializer valueSerializer = new BeanSerializer(type, builder,
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)},
        new BeanPropertyWriter[]{mock(BeanPropertyWriter.class)});

    PlaceholderForType elemType = new PlaceholderForType(1);
    AsDeductionTypeSerializer vts = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer src2 = new UnwrappingIndexedListSerializer(elemType, true, vts, valueSerializer,
        new NameTransformer.Chained(mock(NameTransformer.class), mock(NameTransformer.class)));

    SubstitutedMethodProperty src3 = new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class),
        (Method) null);

    SubstitutedMethodProperty property2 = new SubstitutedMethodProperty(src3, PropertyName.construct("Simple Name"));

    AsDeductionTypeSerializer vts2 = AsDeductionTypeSerializer.instance();
    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer = new UnwrappingIndexedListSerializer(src2,
        property2, vts2, new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    ArrayList<Object> value = new ArrayList<>();
    JsonGeneratorDelegate jgen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class)), true);

    // Act
    unwrappingIndexedListSerializer.serializeTypedContents(value, jgen, new DefaultSerializerProvider.Impl());

    // Assert that nothing has changed
    verify(type).getRawClass();
    verify(basicBeanDescription).findExpectedFormat();
    verify(builder).getAnyGetter();
    verify(builder).getBeanDescription();
    verify(builder).getFilterId();
    verify(builder).getObjectIdWriter();
    verify(builder).getTypeId();
  }
}
