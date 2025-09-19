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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTypeResolverBuilder;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers.XMLGregorianCalendarSerializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator.Builder;
import com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeSerializer;
import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.AttributePropertyWriter;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializer;
import com.rosetta.util.serialisation.RosettaXMLConfiguration;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RosettaBeanSerializerModifierDiffblueTest {
  /**
   * Test {@link RosettaBeanSerializerModifier#changeProperties(SerializationConfig,
   * BeanDescription, List)}.
   *
   * <p>Method under test: {@link
   * RosettaBeanSerializerModifier#changeProperties(SerializationConfig, BeanDescription, List)}
   */
  @Test
  @DisplayName("Test changeProperties(SerializationConfig, BeanDescription, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RosettaBeanSerializerModifier.changeProperties(SerializationConfig, BeanDescription, List)"
  })
  void testChangeProperties() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier =
        new RosettaBeanSerializerModifier();
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    ArrayList<BeanPropertyWriter> beanProperties = new ArrayList<>();
    BasicClassIntrospector ci2 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai2 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns2 = new PropertyNamingStrategy();
    TypeFactory tf2 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer2 = new StdTypeResolverBuilder();
    BasicPolymorphicTypeValidator ptv2 = BasicPolymorphicTypeValidator.builder().build();

    BaseSettings base2 =
        new BaseSettings(
            ci2,
            ai2,
            pns2,
            tf2,
            typer2,
            new SimpleDateFormat("yyyy/mm/dd"),
            mock(HandlerInstantiator.class),
            Locale.getDefault(),
            TimeZone.getTimeZone("America/Los_Angeles"),
            Base64Variants.getDefaultVariant(),
            ptv2);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames2 = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config2 =
        new DeserializationConfig(
            base2,
            str2,
            mixins2,
            rootNames2,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    JacksonAnnotationIntrospector ai3 = new JacksonAnnotationIntrospector();

    POJOPropertyBuilder propDef =
        new POJOPropertyBuilder(config2, ai3, true, PropertyName.construct("Simple Name"));
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));
    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    XMLGregorianCalendarSerializer ser = new XMLGregorianCalendarSerializer();
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    Builder builderResult2 = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny2 = Object.class;
    BasicPolymorphicTypeValidator ptv3 =
        builderResult2.denyForExactBaseType(baseTypeToDeny2).build();

    ClassNameIdResolver idRes = new ClassNameIdResolver(baseType, typeFactory, ptv3);
    BasicClassIntrospector ci3 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai4 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns3 = new PropertyNamingStrategy();
    TypeFactory tf3 = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer3 =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi2 = mock(HandlerInstantiator.class);
    Locale locale2 = Locale.getDefault();
    TimeZone tz2 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase642 = Base64Variants.getDefaultVariant();

    Builder builderResult3 = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny3 = Object.class;
    BasicPolymorphicTypeValidator ptv4 =
        builderResult3.denyForExactBaseType(baseTypeToDeny3).build();

    BaseSettings base3 =
        new BaseSettings(
            ci3, ai4, pns3, tf3, typer3, dateFormat2, hi2, locale2, tz2, defaultBase642, ptv4);
    StdSubtypeResolver str3 = new StdSubtypeResolver();
    BaseSettings base4 = mock(BaseSettings.class);
    StdSubtypeResolver str4 = new StdSubtypeResolver();
    SimpleMixInResolver mixins3 = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames3 = new RootNameLookup();

    SerializationConfig overrides =
        new SerializationConfig(base4, str4, mixins3, rootNames3, new ConfigOverrides());
    SimpleMixInResolver mixins4 = new SimpleMixInResolver(overrides);
    RootNameLookup rootNames4 = new RootNameLookup();
    ConfigOverrides configOverrides2 = new ConfigOverrides();

    DeserializationConfig config3 =
        new DeserializationConfig(
            base3,
            str3,
            mixins4,
            rootNames4,
            configOverrides2,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    JacksonAnnotationIntrospector ai5 = new JacksonAnnotationIntrospector();

    POJOPropertyBuilder propDef2 =
        new POJOPropertyBuilder(config3, ai5, true, PropertyName.construct("Simple Name"));
    AnnotatedMember member2 = mock(AnnotatedMember.class);
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    XMLGregorianCalendarSerializer ser2 = new XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();
    Class<Object> forNameResult = Object.class;
    Class<?>[] includeInViews = new Class[] {forNameResult};

    BeanPropertyWriter property =
        new BeanPropertyWriter(
            propDef2,
            member2,
            contextAnnotations2,
            null,
            ser2,
            typeSer,
            null,
            true,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            includeInViews);

    AsArrayTypeSerializer typeSer2 = new AsArrayTypeSerializer(idRes, property);

    BeanPropertyWriter beanPropertyWriter =
        new BeanPropertyWriter(
            propDef,
            member,
            contextAnnotations,
            declaredType,
            ser,
            typeSer2,
            new PlaceholderForType(1),
            true,
            BeanPropertyWriter.MARKER_FOR_EMPTY);
    beanProperties.add(beanPropertyWriter);

    // Act
    List<BeanPropertyWriter> actualChangePropertiesResult =
        rosettaBeanSerializerModifier.changeProperties(config, null, beanProperties);

    // Assert
    assertEquals(1, actualChangePropertiesResult.size());
    BeanPropertyWriter getResult = actualChangePropertiesResult.get(0);
    assertTrue(getResult.getSerializationType() instanceof PlaceholderForType);
    assertTrue(getResult.getType() instanceof PlaceholderForType);
    assertTrue(getResult.getMember() instanceof VirtualXMLAttribute);
  }

  /**
   * Test {@link RosettaBeanSerializerModifier#changeProperties(SerializationConfig,
   * BeanDescription, List)}.
   *
   * <p>Method under test: {@link
   * RosettaBeanSerializerModifier#changeProperties(SerializationConfig, BeanDescription, List)}
   */
  @Test
  @DisplayName("Test changeProperties(SerializationConfig, BeanDescription, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RosettaBeanSerializerModifier.changeProperties(SerializationConfig, BeanDescription, List)"
  })
  void testChangeProperties2() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier =
        new RosettaBeanSerializerModifier();
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector p = new JacksonAnnotationIntrospector();
    AnnotationIntrospectorPair ai =
        new AnnotationIntrospectorPair(p, new JacksonAnnotationIntrospector());
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    ArrayList<BeanPropertyWriter> beanProperties = new ArrayList<>();
    BasicClassIntrospector ci2 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai2 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns2 = new PropertyNamingStrategy();
    TypeFactory tf2 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer2 = new StdTypeResolverBuilder();
    BasicPolymorphicTypeValidator ptv2 = BasicPolymorphicTypeValidator.builder().build();

    BaseSettings base2 =
        new BaseSettings(
            ci2,
            ai2,
            pns2,
            tf2,
            typer2,
            new SimpleDateFormat("yyyy/mm/dd"),
            mock(HandlerInstantiator.class),
            Locale.getDefault(),
            TimeZone.getTimeZone("America/Los_Angeles"),
            Base64Variants.getDefaultVariant(),
            ptv2);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames2 = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config2 =
        new DeserializationConfig(
            base2,
            str2,
            mixins2,
            rootNames2,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    JacksonAnnotationIntrospector ai3 = new JacksonAnnotationIntrospector();

    POJOPropertyBuilder propDef =
        new POJOPropertyBuilder(config2, ai3, true, PropertyName.construct("Simple Name"));
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));
    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    XMLGregorianCalendarSerializer ser = new XMLGregorianCalendarSerializer();
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    Builder builderResult2 = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny2 = Object.class;
    BasicPolymorphicTypeValidator ptv3 =
        builderResult2.denyForExactBaseType(baseTypeToDeny2).build();

    ClassNameIdResolver idRes = new ClassNameIdResolver(baseType, typeFactory, ptv3);
    BasicClassIntrospector ci3 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai4 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns3 = new PropertyNamingStrategy();
    TypeFactory tf3 = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer3 =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi2 = mock(HandlerInstantiator.class);
    Locale locale2 = Locale.getDefault();
    TimeZone tz2 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase642 = Base64Variants.getDefaultVariant();

    Builder builderResult3 = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny3 = Object.class;
    BasicPolymorphicTypeValidator ptv4 =
        builderResult3.denyForExactBaseType(baseTypeToDeny3).build();

    BaseSettings base3 =
        new BaseSettings(
            ci3, ai4, pns3, tf3, typer3, dateFormat2, hi2, locale2, tz2, defaultBase642, ptv4);
    StdSubtypeResolver str3 = new StdSubtypeResolver();
    BaseSettings base4 = mock(BaseSettings.class);
    StdSubtypeResolver str4 = new StdSubtypeResolver();
    SimpleMixInResolver mixins3 = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames3 = new RootNameLookup();

    SerializationConfig overrides =
        new SerializationConfig(base4, str4, mixins3, rootNames3, new ConfigOverrides());
    SimpleMixInResolver mixins4 = new SimpleMixInResolver(overrides);
    RootNameLookup rootNames4 = new RootNameLookup();
    ConfigOverrides configOverrides2 = new ConfigOverrides();

    DeserializationConfig config3 =
        new DeserializationConfig(
            base3,
            str3,
            mixins4,
            rootNames4,
            configOverrides2,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    JacksonAnnotationIntrospector ai5 = new JacksonAnnotationIntrospector();

    POJOPropertyBuilder propDef2 =
        new POJOPropertyBuilder(config3, ai5, true, PropertyName.construct("Simple Name"));
    AnnotatedMember member2 = mock(AnnotatedMember.class);
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    XMLGregorianCalendarSerializer ser2 = new XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();
    Class<Object> forNameResult = Object.class;
    Class<?>[] includeInViews = new Class[] {forNameResult};

    BeanPropertyWriter property =
        new BeanPropertyWriter(
            propDef2,
            member2,
            contextAnnotations2,
            null,
            ser2,
            typeSer,
            null,
            true,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            includeInViews);

    AsArrayTypeSerializer typeSer2 = new AsArrayTypeSerializer(idRes, property);

    BeanPropertyWriter beanPropertyWriter =
        new BeanPropertyWriter(
            propDef,
            member,
            contextAnnotations,
            declaredType,
            ser,
            typeSer2,
            new PlaceholderForType(1),
            true,
            BeanPropertyWriter.MARKER_FOR_EMPTY);
    beanProperties.add(beanPropertyWriter);

    // Act
    List<BeanPropertyWriter> actualChangePropertiesResult =
        rosettaBeanSerializerModifier.changeProperties(config, null, beanProperties);

    // Assert
    assertEquals(1, actualChangePropertiesResult.size());
    BeanPropertyWriter getResult = actualChangePropertiesResult.get(0);
    assertTrue(getResult.getSerializationType() instanceof PlaceholderForType);
    assertTrue(getResult.getType() instanceof PlaceholderForType);
    assertTrue(getResult.getMember() instanceof VirtualXMLAttribute);
  }

  /**
   * Test {@link RosettaBeanSerializerModifier#changeProperties(SerializationConfig,
   * BeanDescription, List)}.
   *
   * <ul>
   *   <li>Given {@code XmlBeanSerializer}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaBeanSerializerModifier#changeProperties(SerializationConfig, BeanDescription, List)}
   */
  @Test
  @DisplayName(
      "Test changeProperties(SerializationConfig, BeanDescription, List); given 'com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RosettaBeanSerializerModifier.changeProperties(SerializationConfig, BeanDescription, List)"
  })
  void testChangeProperties_givenComFasterxmlJacksonDataformatXmlSerXmlBeanSerializer() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier =
        new RosettaBeanSerializerModifier();

    MixInResolver overrides = mock(MixInResolver.class);
    Class<XmlBeanSerializer> forNameResult = XmlBeanSerializer.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<?>>any()))
        .thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector ai =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    AttributePropertyWriter attributePropertyWriter = mock(AttributePropertyWriter.class);
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute virtualXMLAttribute =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));
    when(attributePropertyWriter.getMember()).thenReturn(virtualXMLAttribute);

    ArrayList<BeanPropertyWriter> beanProperties = new ArrayList<>();
    beanProperties.add(attributePropertyWriter);

    // Act
    List<BeanPropertyWriter> actualChangePropertiesResult =
        rosettaBeanSerializerModifier.changeProperties(config, null, beanProperties);

    // Assert
    verify(overrides, atLeast(1)).findMixInClassFor(isA(Class.class));
    verify(attributePropertyWriter).getMember();
    assertSame(beanProperties, actualChangePropertiesResult);
  }

  /**
   * Test {@link RosettaBeanSerializerModifier#changeProperties(SerializationConfig,
   * BeanDescription, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ClassIntrospector.MixInResolver} {@link
   *       ClassIntrospector.MixInResolver#findMixInClassFor(Class)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaBeanSerializerModifier#changeProperties(SerializationConfig, BeanDescription, List)}
   */
  @Test
  @DisplayName(
      "Test changeProperties(SerializationConfig, BeanDescription, List); given 'null'; when MixInResolver findMixInClassFor(Class) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RosettaBeanSerializerModifier.changeProperties(SerializationConfig, BeanDescription, List)"
  })
  void testChangeProperties_givenNull_whenMixInResolverFindMixInClassForReturnNull() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier =
        new RosettaBeanSerializerModifier();

    MixInResolver overrides = mock(MixInResolver.class);
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<?>>any())).thenReturn(null);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector ai =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    AttributePropertyWriter attributePropertyWriter = mock(AttributePropertyWriter.class);
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute virtualXMLAttribute =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));
    when(attributePropertyWriter.getMember()).thenReturn(virtualXMLAttribute);

    ArrayList<BeanPropertyWriter> beanProperties = new ArrayList<>();
    beanProperties.add(attributePropertyWriter);

    // Act
    List<BeanPropertyWriter> actualChangePropertiesResult =
        rosettaBeanSerializerModifier.changeProperties(config, null, beanProperties);

    // Assert
    verify(overrides, atLeast(1)).findMixInClassFor(isA(Class.class));
    verify(attributePropertyWriter).getMember();
    assertSame(beanProperties, actualChangePropertiesResult);
  }

  /**
   * Test {@link RosettaBeanSerializerModifier#changeProperties(SerializationConfig,
   * BeanDescription, List)}.
   *
   * <ul>
   *   <li>Given {@link Object}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaBeanSerializerModifier#changeProperties(SerializationConfig, BeanDescription, List)}
   */
  @Test
  @DisplayName(
      "Test changeProperties(SerializationConfig, BeanDescription, List); given Object; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RosettaBeanSerializerModifier.changeProperties(SerializationConfig, BeanDescription, List)"
  })
  void testChangeProperties_givenObject_thenReturnSizeIsOne() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier =
        new RosettaBeanSerializerModifier();

    MixInResolver overrides = mock(MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<?>>any()))
        .thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector ai =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    ArrayList<BeanPropertyWriter> beanProperties = new ArrayList<>();
    BasicClassIntrospector ci2 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai2 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns2 = new PropertyNamingStrategy();
    TypeFactory tf2 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer2 = new StdTypeResolverBuilder();
    BasicPolymorphicTypeValidator ptv2 = BasicPolymorphicTypeValidator.builder().build();

    BaseSettings base2 =
        new BaseSettings(
            ci2,
            ai2,
            pns2,
            tf2,
            typer2,
            new SimpleDateFormat("yyyy/mm/dd"),
            mock(HandlerInstantiator.class),
            Locale.getDefault(),
            TimeZone.getTimeZone("America/Los_Angeles"),
            Base64Variants.getDefaultVariant(),
            ptv2);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames2 = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config2 =
        new DeserializationConfig(
            base2,
            str2,
            mixins2,
            rootNames2,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    JacksonAnnotationIntrospector ai3 = new JacksonAnnotationIntrospector();

    POJOPropertyBuilder propDef =
        new POJOPropertyBuilder(config2, ai3, true, PropertyName.construct("Simple Name"));
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));
    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    XMLGregorianCalendarSerializer ser = new XMLGregorianCalendarSerializer();
    PlaceholderForType baseType = new PlaceholderForType(1);
    TypeFactory typeFactory = TypeFactory.defaultInstance();

    Builder builderResult2 = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny2 = Object.class;
    BasicPolymorphicTypeValidator ptv3 =
        builderResult2.denyForExactBaseType(baseTypeToDeny2).build();

    ClassNameIdResolver idRes = new ClassNameIdResolver(baseType, typeFactory, ptv3);
    BasicClassIntrospector ci3 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai4 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns3 = new PropertyNamingStrategy();
    TypeFactory tf3 = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer3 =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi2 = mock(HandlerInstantiator.class);
    Locale locale2 = Locale.getDefault();
    TimeZone tz2 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase642 = Base64Variants.getDefaultVariant();

    Builder builderResult3 = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny3 = Object.class;
    BasicPolymorphicTypeValidator ptv4 =
        builderResult3.denyForExactBaseType(baseTypeToDeny3).build();

    BaseSettings base3 =
        new BaseSettings(
            ci3, ai4, pns3, tf3, typer3, dateFormat2, hi2, locale2, tz2, defaultBase642, ptv4);
    StdSubtypeResolver str3 = new StdSubtypeResolver();
    BaseSettings base4 = mock(BaseSettings.class);
    StdSubtypeResolver str4 = new StdSubtypeResolver();
    SimpleMixInResolver mixins3 = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames3 = new RootNameLookup();

    SerializationConfig overrides2 =
        new SerializationConfig(base4, str4, mixins3, rootNames3, new ConfigOverrides());
    SimpleMixInResolver mixins4 = new SimpleMixInResolver(overrides2);
    RootNameLookup rootNames4 = new RootNameLookup();
    ConfigOverrides configOverrides2 = new ConfigOverrides();

    DeserializationConfig config3 =
        new DeserializationConfig(
            base3,
            str3,
            mixins4,
            rootNames4,
            configOverrides2,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    JacksonAnnotationIntrospector ai5 = new JacksonAnnotationIntrospector();

    POJOPropertyBuilder propDef2 =
        new POJOPropertyBuilder(config3, ai5, true, PropertyName.construct("Simple Name"));
    AnnotatedMember member2 = mock(AnnotatedMember.class);
    AnnotationMap contextAnnotations2 = new AnnotationMap();
    XMLGregorianCalendarSerializer ser2 = new XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();
    Class<Object> forNameResult2 = Object.class;
    Class<?>[] includeInViews = new Class[] {forNameResult2};

    BeanPropertyWriter property =
        new BeanPropertyWriter(
            propDef2,
            member2,
            contextAnnotations2,
            null,
            ser2,
            typeSer,
            null,
            true,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            includeInViews);

    AsArrayTypeSerializer typeSer2 = new AsArrayTypeSerializer(idRes, property);

    BeanPropertyWriter beanPropertyWriter =
        new BeanPropertyWriter(
            propDef,
            member,
            contextAnnotations,
            declaredType,
            ser,
            typeSer2,
            new PlaceholderForType(1),
            true,
            BeanPropertyWriter.MARKER_FOR_EMPTY);
    beanProperties.add(beanPropertyWriter);

    // Act
    List<BeanPropertyWriter> actualChangePropertiesResult =
        rosettaBeanSerializerModifier.changeProperties(config, null, beanProperties);

    // Assert
    verify(overrides, atLeast(1)).findMixInClassFor(isA(Class.class));
    assertEquals(1, actualChangePropertiesResult.size());
    BeanPropertyWriter getResult = actualChangePropertiesResult.get(0);
    assertTrue(getResult.getSerializationType() instanceof PlaceholderForType);
    assertTrue(getResult.getType() instanceof PlaceholderForType);
    assertTrue(getResult.getMember() instanceof VirtualXMLAttribute);
  }

  /**
   * Test {@link RosettaBeanSerializerModifier#changeProperties(SerializationConfig,
   * BeanDescription, List)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaBeanSerializerModifier#changeProperties(SerializationConfig, BeanDescription, List)}
   */
  @Test
  @DisplayName(
      "Test changeProperties(SerializationConfig, BeanDescription, List); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RosettaBeanSerializerModifier.changeProperties(SerializationConfig, BeanDescription, List)"
  })
  void testChangeProperties_thenReturnArrayList() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier =
        new RosettaBeanSerializerModifier();

    MixInResolver overrides = mock(MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<?>>any()))
        .thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector ai =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    AttributePropertyWriter attributePropertyWriter = mock(AttributePropertyWriter.class);
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute virtualXMLAttribute =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));
    when(attributePropertyWriter.getMember()).thenReturn(virtualXMLAttribute);

    ArrayList<BeanPropertyWriter> beanProperties = new ArrayList<>();
    beanProperties.add(attributePropertyWriter);

    // Act
    List<BeanPropertyWriter> actualChangePropertiesResult =
        rosettaBeanSerializerModifier.changeProperties(config, null, beanProperties);

    // Assert
    verify(overrides, atLeast(1)).findMixInClassFor(isA(Class.class));
    verify(attributePropertyWriter).getMember();
    assertSame(beanProperties, actualChangePropertiesResult);
  }

  /**
   * Test {@link RosettaBeanSerializerModifier#changeProperties(SerializationConfig,
   * BeanDescription, List)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaBeanSerializerModifier#changeProperties(SerializationConfig, BeanDescription, List)}
   */
  @Test
  @DisplayName(
      "Test changeProperties(SerializationConfig, BeanDescription, List); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RosettaBeanSerializerModifier.changeProperties(SerializationConfig, BeanDescription, List)"
  })
  void testChangeProperties_thenReturnEmpty() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier =
        new RosettaBeanSerializerModifier();
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    // Act and Assert
    assertTrue(
        rosettaBeanSerializerModifier.changeProperties(config, null, new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link RosettaBeanSerializerModifier#findSubstitutionMap(MapperConfig,
   * AnnotationIntrospector, AnnotatedMember)}.
   *
   * <p>Method under test: {@link RosettaBeanSerializerModifier#findSubstitutionMap(MapperConfig,
   * AnnotationIntrospector, AnnotatedMember)}
   */
  @Test
  @DisplayName("Test findSubstitutionMap(MapperConfig, AnnotationIntrospector, AnnotatedMember)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SubstitutionMap RosettaBeanSerializerModifier.findSubstitutionMap(MapperConfig, AnnotationIntrospector, AnnotatedMember)"
  })
  void testFindSubstitutionMap() {
    // Arrange
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    BaseSettings base2 = mock(BaseSettings.class);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig overrides =
        new SerializationConfig(base2, str2, mixins, rootNames, new ConfigOverrides());
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(overrides);
    RootNameLookup rootNames2 = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config =
        new DeserializationConfig(
            base,
            str,
            mixins2,
            rootNames2,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    JacksonAnnotationIntrospector p = new JacksonAnnotationIntrospector();
    AnnotationIntrospectorPair ai2 =
        new AnnotationIntrospectorPair(p, new JacksonAnnotationIntrospector());
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute prop =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act
    SubstitutionMap actualFindSubstitutionMapResult =
        RosettaBeanSerializerModifier.findSubstitutionMap(config, ai2, prop);

    // Assert
    assertNull(actualFindSubstitutionMapResult);
  }

  /**
   * Test {@link RosettaBeanSerializerModifier#findSubstitutionMap(MapperConfig,
   * AnnotationIntrospector, AnnotatedMember)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then calls {@link SimpleMixInResolver#findMixInClassFor(Class)}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaBeanSerializerModifier#findSubstitutionMap(MapperConfig,
   * AnnotationIntrospector, AnnotatedMember)}
   */
  @Test
  @DisplayName(
      "Test findSubstitutionMap(MapperConfig, AnnotationIntrospector, AnnotatedMember); given 'java.lang.Object'; then calls findMixInClassFor(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SubstitutionMap RosettaBeanSerializerModifier.findSubstitutionMap(MapperConfig, AnnotationIntrospector, AnnotatedMember)"
  })
  void testFindSubstitutionMap_givenJavaLangObject_thenCallsFindMixInClassFor() {
    // Arrange
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(mixins.findMixInClassFor(Mockito.<Class<?>>any()))
        .thenReturn(forNameResult);
    BaseSettings base = mock(BaseSettings.class);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig overrides =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base2 =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    RootNameLookup rootNames2 = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config =
        new DeserializationConfig(
            base2,
            str2,
            mixins2,
            rootNames2,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLAnnotationIntrospector ai2 =
        new RosettaXMLAnnotationIntrospector(
            mapper, new RosettaXMLConfiguration(new HashMap<>()), true);
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute prop =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act
    SubstitutionMap actualFindSubstitutionMapResult =
        RosettaBeanSerializerModifier.findSubstitutionMap(config, ai2, prop);

    // Assert
    verify(mixins, atLeast(1)).findMixInClassFor(isA(Class.class));
    assertNull(actualFindSubstitutionMapResult);
  }

  /**
   * Test {@link RosettaBeanSerializerModifier#findSubstitutionMap(MapperConfig,
   * AnnotationIntrospector, AnnotatedMember)}.
   *
   * <ul>
   *   <li>When {@link JacksonAnnotationIntrospector} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaBeanSerializerModifier#findSubstitutionMap(MapperConfig,
   * AnnotationIntrospector, AnnotatedMember)}
   */
  @Test
  @DisplayName(
      "Test findSubstitutionMap(MapperConfig, AnnotationIntrospector, AnnotatedMember); when JacksonAnnotationIntrospector (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SubstitutionMap RosettaBeanSerializerModifier.findSubstitutionMap(MapperConfig, AnnotationIntrospector, AnnotatedMember)"
  })
  void testFindSubstitutionMap_whenJacksonAnnotationIntrospector_thenReturnNull() {
    // Arrange
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    BaseSettings base2 = mock(BaseSettings.class);
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig overrides =
        new SerializationConfig(base2, str2, mixins, rootNames, new ConfigOverrides());
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(overrides);
    RootNameLookup rootNames2 = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();

    DeserializationConfig config =
        new DeserializationConfig(
            base,
            str,
            mixins2,
            rootNames2,
            configOverrides,
            new CoercionConfigs(),
            mock(DatatypeFeatures.class));
    JacksonAnnotationIntrospector ai2 = new JacksonAnnotationIntrospector();
    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute prop =
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    // Act
    SubstitutionMap actualFindSubstitutionMapResult =
        RosettaBeanSerializerModifier.findSubstitutionMap(config, ai2, prop);

    // Assert
    assertNull(actualFindSubstitutionMapResult);
  }

  /**
   * Test {@link RosettaBeanSerializerModifier#modifySerializer(SerializationConfig,
   * BeanDescription, JsonSerializer)}.
   *
   * <ul>
   *   <li>Then return {@link
   *       CoreXMLSerializers.XMLGregorianCalendarSerializer#XMLGregorianCalendarSerializer()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaBeanSerializerModifier#modifySerializer(SerializationConfig, BeanDescription,
   * JsonSerializer)}
   */
  @Test
  @DisplayName(
      "Test modifySerializer(SerializationConfig, BeanDescription, JsonSerializer); then return XMLGregorianCalendarSerializer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonSerializer RosettaBeanSerializerModifier.modifySerializer(SerializationConfig, BeanDescription, JsonSerializer)"
  })
  void testModifySerializer_thenReturnXMLGregorianCalendarSerializer() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier =
        new RosettaBeanSerializerModifier();
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    DefaultTypeResolverBuilder typer =
        new DefaultTypeResolverBuilder(DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();

    Builder builderResult = BasicPolymorphicTypeValidator.builder();
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv = builderResult.denyForExactBaseType(baseTypeToDeny).build();

    BaseSettings base =
        new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64, ptv);
    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();

    SerializationConfig config =
        new SerializationConfig(base, str, mixins, rootNames, new ConfigOverrides());
    XMLGregorianCalendarSerializer serializer = new XMLGregorianCalendarSerializer();

    // Act
    JsonSerializer<?> actualModifySerializerResult =
        rosettaBeanSerializerModifier.modifySerializer(config, null, serializer);

    // Assert
    assertSame(serializer, actualModifySerializerResult);
  }
}
