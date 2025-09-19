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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers.XMLGregorianCalendarSerializer;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator.Builder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.NameTransformer.Chained;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UnwrappingIndexedListSerializerDiffblueTest {
  /**
   * Test {@link UnwrappingIndexedListSerializer#withResolved(BeanProperty, TypeSerializer,
   * JsonSerializer)}.
   *
   * <ul>
   *   <li>Then ContentType return {@link PlaceholderForType}.
   * </ul>
   *
   * <p>Method under test: {@link UnwrappingIndexedListSerializer#withResolved(BeanProperty,
   * TypeSerializer, JsonSerializer)}
   */
  @Test
  @DisplayName(
      "Test withResolved(BeanProperty, TypeSerializer, JsonSerializer); then ContentType return PlaceholderForType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UnwrappingIndexedListSerializer UnwrappingIndexedListSerializer.withResolved(BeanProperty, TypeSerializer, JsonSerializer)"
  })
  void testWithResolved_thenContentTypeReturnPlaceholderForType() {
    // Arrange
    PropertyName internalName = mock(PropertyName.class);
    when(internalName.getSimpleName()).thenReturn("Simple Name");
    MapperConfig<?> config = mock(MapperConfig.class);

    POJOPropertyBuilder propDef =
        new POJOPropertyBuilder(config, new JacksonAnnotationIntrospector(), true, internalName);
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member = new VirtualXMLAttribute(declaringClass, "Name", null);
    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    XMLGregorianCalendarSerializer ser = new XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();

    BeanPropertyWriter property =
        new BeanPropertyWriter(
            propDef,
            member,
            contextAnnotations,
            declaredType,
            ser,
            typeSer,
            new PlaceholderForType(1),
            true,
            BeanPropertyWriter.MARKER_FOR_EMPTY);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    ClassNameIdResolver idRes = new ClassNameIdResolver(baseType, typeFactory, ptv);

    AsArrayTypeSerializer vts = new AsArrayTypeSerializer(idRes, property);
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsArrayTypeSerializer vts2 = new AsArrayTypeSerializer(null, null);
    Class<Object> type = Object.class;
    Default valueSerializer = new Default(1, type);
    Chained nameTransformer = new Chained(mock(NameTransformer.class), mock(NameTransformer.class));

    UnwrappingIndexedListSerializer src =
        new UnwrappingIndexedListSerializer(elemType, true, vts2, valueSerializer, nameTransformer);
    BaseSettings base = mock(BaseSettings.class);
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config2 =
        new DeserializationConfig(
            base,
            str,
            mixins,
            rootNames,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();

    POJOPropertyBuilder propDef2 =
        new POJOPropertyBuilder(config2, ai, true, PropertyName.construct("Simple Name"));
    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute member2 =
        new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    PlaceholderForType declaredType2 = new PlaceholderForType(1);
    XMLGregorianCalendarSerializer ser2 = new XMLGregorianCalendarSerializer();
    BasicPolymorphicTypeValidator ptv2 = BasicPolymorphicTypeValidator.builder().build();
    ClassNameIdResolver idRes2 = new ClassNameIdResolver(null, TypeFactory.defaultInstance(), ptv2);
    AsArrayTypeSerializer typeSer2 = new AsArrayTypeSerializer(idRes2, null);

    BeanPropertyWriter property2 =
        new BeanPropertyWriter(
            propDef2,
            member2,
            contextAnnotations2,
            declaredType2,
            ser2,
            typeSer2,
            new PlaceholderForType(1),
            true,
            BeanPropertyWriter.MARKER_FOR_EMPTY);

    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer =
        new UnwrappingIndexedListSerializer(
            src, property2, vts, new XMLGregorianCalendarSerializer());
    JsonSerializer<Object> elementSerializer = mock(JsonSerializer.class);

    // Act
    UnwrappingIndexedListSerializer actualWithResolvedResult =
        unwrappingIndexedListSerializer.withResolved(
            mock(BeanProperty.class), mock(TypeSerializer.class), elementSerializer);

    // Assert
    verify(internalName).getSimpleName();
    JavaType contentType = actualWithResolvedResult.getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    assertTrue(actualWithResolvedResult._nameTransformer instanceof Chained);
    assertNull(actualWithResolvedResult.getDelegatee());
    assertTrue(actualWithResolvedResult.isUnwrappingSerializer());
    assertTrue(actualWithResolvedResult._staticTyping);
    assertSame(elemType, contentType);
    assertSame(elementSerializer, actualWithResolvedResult.getContentSerializer());
  }

  /**
   * Test {@link UnwrappingIndexedListSerializer#_withValueTypeSerializer(TypeSerializer)}.
   *
   * <p>Method under test: {@link
   * UnwrappingIndexedListSerializer#_withValueTypeSerializer(TypeSerializer)}
   */
  @Test
  @DisplayName("Test _withValueTypeSerializer(TypeSerializer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UnwrappingIndexedListSerializer UnwrappingIndexedListSerializer._withValueTypeSerializer(TypeSerializer)"
  })
  void test_withValueTypeSerializer() {
    // Arrange
    PropertyName internalName = mock(PropertyName.class);
    when(internalName.getSimpleName()).thenReturn("Simple Name");
    MapperConfig<?> config = mock(MapperConfig.class);

    POJOPropertyBuilder propDef =
        new POJOPropertyBuilder(config, new JacksonAnnotationIntrospector(), true, internalName);
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member = new VirtualXMLAttribute(declaringClass, "Name", null);
    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    XMLGregorianCalendarSerializer ser = new XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();

    BeanPropertyWriter property =
        new BeanPropertyWriter(
            propDef,
            member,
            contextAnnotations,
            declaredType,
            ser,
            typeSer,
            new PlaceholderForType(1),
            true,
            BeanPropertyWriter.MARKER_FOR_EMPTY);
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    ClassNameIdResolver idRes = new ClassNameIdResolver(baseType, typeFactory, ptv);

    AsArrayTypeSerializer vts = new AsArrayTypeSerializer(idRes, property);
    PlaceholderForType elemType = new PlaceholderForType(1);
    AsArrayTypeSerializer vts2 = new AsArrayTypeSerializer(null, null);
    Class<Object> type = Object.class;
    Default valueSerializer = new Default(1, type);
    Chained nameTransformer = new Chained(mock(NameTransformer.class), mock(NameTransformer.class));

    UnwrappingIndexedListSerializer src =
        new UnwrappingIndexedListSerializer(elemType, true, vts2, valueSerializer, nameTransformer);
    BaseSettings base = mock(BaseSettings.class);
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config2 =
        new DeserializationConfig(
            base,
            str,
            mixins,
            rootNames,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();

    POJOPropertyBuilder propDef2 =
        new POJOPropertyBuilder(config2, ai, true, PropertyName.construct("Simple Name"));
    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute member2 =
        new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    PlaceholderForType declaredType2 = new PlaceholderForType(1);
    XMLGregorianCalendarSerializer ser2 = new XMLGregorianCalendarSerializer();
    BasicPolymorphicTypeValidator ptv2 = BasicPolymorphicTypeValidator.builder().build();
    ClassNameIdResolver idRes2 = new ClassNameIdResolver(null, TypeFactory.defaultInstance(), ptv2);
    AsArrayTypeSerializer typeSer2 = new AsArrayTypeSerializer(idRes2, null);

    BeanPropertyWriter property2 =
        new BeanPropertyWriter(
            propDef2,
            member2,
            contextAnnotations2,
            declaredType2,
            ser2,
            typeSer2,
            new PlaceholderForType(1),
            true,
            BeanPropertyWriter.MARKER_FOR_EMPTY);
    XMLGregorianCalendarSerializer valueSerializer2 = new XMLGregorianCalendarSerializer();

    UnwrappingIndexedListSerializer unwrappingIndexedListSerializer =
        new UnwrappingIndexedListSerializer(src, property2, vts, valueSerializer2);

    // Act
    UnwrappingIndexedListSerializer actual_withValueTypeSerializerResult =
        unwrappingIndexedListSerializer._withValueTypeSerializer(mock(TypeSerializer.class));

    // Assert
    verify(internalName).getSimpleName();
    JsonSerializer<?> contentSerializer =
        actual_withValueTypeSerializerResult.getContentSerializer();
    assertTrue(contentSerializer instanceof XMLGregorianCalendarSerializer);
    assertTrue(actual_withValueTypeSerializerResult._property instanceof BeanPropertyWriter);
    JavaType contentType = actual_withValueTypeSerializerResult.getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    assertTrue(actual_withValueTypeSerializerResult._nameTransformer instanceof Chained);
    assertNull(actual_withValueTypeSerializerResult.getDelegatee());
    assertTrue(actual_withValueTypeSerializerResult.isUnwrappingSerializer());
    assertTrue(actual_withValueTypeSerializerResult._staticTyping);
    assertSame(valueSerializer2, contentSerializer);
    assertSame(elemType, contentType);
  }
}
