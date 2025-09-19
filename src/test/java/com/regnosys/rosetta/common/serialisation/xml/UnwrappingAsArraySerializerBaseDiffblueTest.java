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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers.XMLGregorianCalendarSerializer;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper.Base;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator.Builder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.NameTransformer.Chained;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider;
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UnwrappingAsArraySerializerBaseDiffblueTest {
  /**
   * Test {@link UnwrappingAsArraySerializerBase#getContentType()}.
   *
   * <p>Method under test: {@link UnwrappingAsArraySerializerBase#getContentType()}
   */
  @Test
  @DisplayName("Test getContentType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JavaType UnwrappingAsArraySerializerBase.getContentType()"})
  void testGetContentType() {
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

    // Act
    JavaType actualContentType = unwrappingIndexedListSerializer.getContentType();

    // Assert
    verify(internalName).getSimpleName();
    assertSame(unwrappingIndexedListSerializer._elementType, actualContentType);
  }

  /**
   * Test {@link UnwrappingAsArraySerializerBase#getContentSerializer()}.
   *
   * <p>Method under test: {@link UnwrappingAsArraySerializerBase#getContentSerializer()}
   */
  @Test
  @DisplayName("Test getContentSerializer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonSerializer UnwrappingAsArraySerializerBase.getContentSerializer()"})
  void testGetContentSerializer() {
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

    // Act
    JsonSerializer<?> actualContentSerializer =
        unwrappingIndexedListSerializer.getContentSerializer();

    // Assert
    verify(internalName).getSimpleName();
    assertSame(unwrappingIndexedListSerializer._elementSerializer, actualContentSerializer);
  }

  /**
   * Test {@link UnwrappingAsArraySerializerBase#serializeWithType(Object, JsonGenerator,
   * SerializerProvider, TypeSerializer)}.
   *
   * <p>Method under test: {@link UnwrappingAsArraySerializerBase#serializeWithType(Object,
   * JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  @DisplayName("Test serializeWithType(Object, JsonGenerator, SerializerProvider, TypeSerializer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnwrappingAsArraySerializerBase.serializeWithType(Object, JsonGenerator, SerializerProvider, TypeSerializer)"
  })
  void testSerializeWithType() throws IOException {
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
    ArrayList<Object> objectList = new ArrayList<>();

    JsonGenerator gen = mock(JsonGenerator.class);
    doNothing().when(gen).assignCurrentValue(Mockito.<Object>any());

    SerializerProvider provider = mock(SerializerProvider.class);
    when(provider.reportBadDefinition(Mockito.<Class<?>>any(), Mockito.<String>any()))
        .thenReturn(BeanPropertyWriter.MARKER_FOR_EMPTY);
    when(provider.isEnabled(Mockito.<SerializationFeature>any())).thenReturn(true);

    // Act
    unwrappingIndexedListSerializer.serializeWithType(
        objectList, gen, provider, mock(TypeSerializer.class));

    // Assert
    verify(gen).assignCurrentValue(isA(Object.class));
    verify(provider)
        .reportBadDefinition(
            isA(Class.class),
            eq(
                "Unwrapped property requires use of type information: cannot serialize without disabling `SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`"));
    verify(internalName).getSimpleName();
    verify(provider).isEnabled(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS);
  }

  /**
   * Test {@link UnwrappingAsArraySerializerBase#serializeWithType(Object, JsonGenerator,
   * SerializerProvider, TypeSerializer)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link SerializerProvider} {@link
   *       SerializerProvider#isEnabled(SerializationFeature)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link UnwrappingAsArraySerializerBase#serializeWithType(Object,
   * JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  @DisplayName(
      "Test serializeWithType(Object, JsonGenerator, SerializerProvider, TypeSerializer); given 'false'; when SerializerProvider isEnabled(SerializationFeature) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnwrappingAsArraySerializerBase.serializeWithType(Object, JsonGenerator, SerializerProvider, TypeSerializer)"
  })
  void testSerializeWithType_givenFalse_whenSerializerProviderIsEnabledReturnFalse()
      throws IOException {
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
    ArrayList<Object> objectList = new ArrayList<>();

    JsonGenerator gen = mock(JsonGenerator.class);
    doNothing().when(gen).assignCurrentValue(Mockito.<Object>any());

    SerializerProvider provider = mock(SerializerProvider.class);
    when(provider.isEnabled(Mockito.<SerializationFeature>any())).thenReturn(false);

    // Act
    unwrappingIndexedListSerializer.serializeWithType(
        objectList, gen, provider, mock(TypeSerializer.class));

    // Assert
    verify(gen).assignCurrentValue(isA(Object.class));
    verify(internalName).getSimpleName();
    verify(provider).isEnabled(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS);
  }

  /**
   * Test {@link UnwrappingAsArraySerializerBase#serializeWithType(Object, JsonGenerator,
   * SerializerProvider, TypeSerializer)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonMappingException}.
   * </ul>
   *
   * <p>Method under test: {@link UnwrappingAsArraySerializerBase#serializeWithType(Object,
   * JsonGenerator, SerializerProvider, TypeSerializer)}
   */
  @Test
  @DisplayName(
      "Test serializeWithType(Object, JsonGenerator, SerializerProvider, TypeSerializer); then throw JsonMappingException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnwrappingAsArraySerializerBase.serializeWithType(Object, JsonGenerator, SerializerProvider, TypeSerializer)"
  })
  void testSerializeWithType_thenThrowJsonMappingException() throws IOException {
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
    ArrayList<Object> objectList = new ArrayList<>();
    JsonGenerator gen = mock(JsonGenerator.class);

    SerializerProvider provider = mock(SerializerProvider.class);
    when(provider.reportBadDefinition(Mockito.<Class<?>>any(), Mockito.<String>any()))
        .thenThrow(
            new JsonMappingException(
                "Unwrapped property requires use of type information: cannot serialize without disabling `SerializationFeature"
                    + ".FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`"));
    when(provider.isEnabled(Mockito.<SerializationFeature>any())).thenReturn(true);

    // Act and Assert
    assertThrows(
        JsonMappingException.class,
        () ->
            unwrappingIndexedListSerializer.serializeWithType(
                objectList, gen, provider, mock(TypeSerializer.class)));
    verify(provider)
        .reportBadDefinition(
            isA(Class.class),
            eq(
                "Unwrapped property requires use of type information: cannot serialize without disabling `SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`"));
    verify(internalName).getSimpleName();
    verify(provider).isEnabled(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS);
  }

  /**
   * Test {@link UnwrappingAsArraySerializerBase#acceptJsonFormatVisitor(JsonFormatVisitorWrapper,
   * JavaType)}.
   *
   * <ul>
   *   <li>Then calls {@link PropertyName#getSimpleName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UnwrappingAsArraySerializerBase#acceptJsonFormatVisitor(JsonFormatVisitorWrapper, JavaType)}
   */
  @Test
  @DisplayName(
      "Test acceptJsonFormatVisitor(JsonFormatVisitorWrapper, JavaType); then calls getSimpleName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnwrappingAsArraySerializerBase.acceptJsonFormatVisitor(JsonFormatVisitorWrapper, JavaType)"
  })
  void testAcceptJsonFormatVisitor_thenCallsGetSimpleName() throws JsonMappingException {
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
    Base visitor = new Base();

    // Act
    unwrappingIndexedListSerializer.acceptJsonFormatVisitor(visitor, new PlaceholderForType(1));

    // Assert
    verify(internalName).getSimpleName();
  }

  /**
   * Test {@link UnwrappingAsArraySerializerBase#_findAndAddDynamic(PropertySerializerMap, Class,
   * SerializerProvider)} with {@code PropertySerializerMap}, {@code Class}, {@code
   * SerializerProvider}.
   *
   * <p>Method under test: {@link
   * UnwrappingAsArraySerializerBase#_findAndAddDynamic(PropertySerializerMap, Class,
   * SerializerProvider)}
   */
  @Test
  @DisplayName(
      "Test _findAndAddDynamic(PropertySerializerMap, Class, SerializerProvider) with 'PropertySerializerMap', 'Class', 'SerializerProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonSerializer UnwrappingAsArraySerializerBase._findAndAddDynamic(PropertySerializerMap, Class, SerializerProvider)"
  })
  void test_findAndAddDynamicWithPropertySerializerMapClassSerializerProvider()
      throws JsonMappingException {
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
    PropertySerializerMap map = mock(PropertySerializerMap.class);
    Class<Object> type2 = Object.class;
    XmlSerializerProvider src2 = new XmlSerializerProvider(new XmlRootNameLookup());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai2 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult2 = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny2 = Object.class;
    BasicPolymorphicTypeValidator ptv3 =
        builderResult2.denyForExactBaseType(baseTypeToDeny2).build();

    BaseSettings base2 =
        new BaseSettings(ci, ai2, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv3);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames2 = new RootNameLookup();

    SerializationConfig config3 =
        new SerializationConfig(base2, str2, mixins2, rootNames2, new ConfigOverrides());

    XmlSerializerProvider provider =
        new XmlSerializerProvider(src2, config3, RosettaSerialiserFactory.INSTANCE);

    // Act
    JsonSerializer<Object> actual_findAndAddDynamicResult =
        unwrappingIndexedListSerializer._findAndAddDynamic(map, type2, provider);

    // Assert
    verify(internalName).getSimpleName();
    BeanProperty beanProperty = unwrappingIndexedListSerializer._property;
    assertTrue(beanProperty instanceof BeanPropertyWriter);
    assertTrue(actual_findAndAddDynamicResult instanceof UnknownSerializer);
    JavaType contentType = unwrappingIndexedListSerializer.getContentType();
    assertTrue(contentType instanceof PlaceholderForType);
    assertNull(actual_findAndAddDynamicResult.getDelegatee());
    assertFalse(actual_findAndAddDynamicResult.isUnwrappingSerializer());
    Class<Object> expectedRawClass = Object.class;
    assertEquals(expectedRawClass, contentType.getRawClass());
    assertSame(baseTypeToDeny2, ((BeanPropertyWriter) beanProperty).getRawSerializationType());
  }

  /**
   * Test {@link UnwrappingAsArraySerializerBase#_findAndAddDynamic(PropertySerializerMap, JavaType,
   * SerializerProvider)} with {@code PropertySerializerMap}, {@code JavaType}, {@code
   * SerializerProvider}.
   *
   * <p>Method under test: {@link
   * UnwrappingAsArraySerializerBase#_findAndAddDynamic(PropertySerializerMap, JavaType,
   * SerializerProvider)}
   */
  @Test
  @DisplayName(
      "Test _findAndAddDynamic(PropertySerializerMap, JavaType, SerializerProvider) with 'PropertySerializerMap', 'JavaType', 'SerializerProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonSerializer UnwrappingAsArraySerializerBase._findAndAddDynamic(PropertySerializerMap, JavaType, SerializerProvider)"
  })
  void test_findAndAddDynamicWithPropertySerializerMapJavaTypeSerializerProvider()
      throws JsonMappingException {
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
    PropertySerializerMap map = mock(PropertySerializerMap.class);
    PlaceholderForType type2 = new PlaceholderForType(1);
    XmlSerializerProvider src2 = new XmlSerializerProvider(new XmlRootNameLookup());
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai2 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult2 = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny2 = Object.class;
    BasicPolymorphicTypeValidator ptv3 =
        builderResult2.denyForExactBaseType(baseTypeToDeny2).build();

    BaseSettings base2 =
        new BaseSettings(ci, ai2, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv3);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames2 = new RootNameLookup();

    SerializationConfig config3 =
        new SerializationConfig(base2, str2, mixins2, rootNames2, new ConfigOverrides());

    XmlSerializerProvider provider =
        new XmlSerializerProvider(src2, config3, RosettaSerialiserFactory.INSTANCE);

    // Act
    JsonSerializer<Object> actual_findAndAddDynamicResult =
        unwrappingIndexedListSerializer._findAndAddDynamic(map, type2, provider);

    // Assert
    verify(internalName).getSimpleName();
    assertTrue(actual_findAndAddDynamicResult instanceof UnknownSerializer);
    assertNull(actual_findAndAddDynamicResult.getDelegatee());
    assertFalse(actual_findAndAddDynamicResult.isUnwrappingSerializer());
  }
}
