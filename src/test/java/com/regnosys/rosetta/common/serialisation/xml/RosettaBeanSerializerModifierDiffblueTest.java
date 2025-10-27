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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
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
import com.fasterxml.jackson.databind.ser.impl.AttributePropertyWriter;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializer;
import com.regnosys.rosetta.common.serialisation.mixin.RosettaJSONAnnotationIntrospector;
import com.rosetta.util.serialisation.RosettaXMLConfiguration;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.Test;
import org.mockito.Mockito;

public class RosettaBeanSerializerModifierDiffblueTest {
  /**
   * Method under test:
   * {@link RosettaBeanSerializerModifier#changeProperties(SerializationConfig, BeanDescription, List)}
   */
  @Test
  public void testChangeProperties() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier = new RosettaBeanSerializerModifier();
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
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str2, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str, mixins2, rootNames2, new ConfigOverrides());

    ArrayList<BeanPropertyWriter> beanProperties = new ArrayList<>();

    // Act
    List<BeanPropertyWriter> actualChangePropertiesResult = rosettaBeanSerializerModifier.changeProperties(config, null,
        beanProperties);

    // Assert
    assertTrue(actualChangePropertiesResult.isEmpty());
    assertSame(beanProperties, actualChangePropertiesResult);
  }

  /**
   * Method under test:
   * {@link RosettaBeanSerializerModifier#changeProperties(SerializationConfig, BeanDescription, List)}
   */
  @Test
  public void testChangeProperties2() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier = new RosettaBeanSerializerModifier();
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
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str2, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str, mixins2, rootNames2, new ConfigOverrides());

    ArrayList<BeanPropertyWriter> beanProperties = new ArrayList<>();
    BasicClassIntrospector ci2 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai2 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns2 = new PropertyNamingStrategy();
    TypeFactory tf2 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer2 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi2 = mock(HandlerInstantiator.class);
    Locale locale2 = Locale.getDefault();
    TimeZone tz2 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase642 = Base64Variants.getDefaultVariant();
    BaseSettings base2 = new BaseSettings(ci2, ai2, pns2, tf2, typer2, dateFormat2, hi2, locale2, tz2, defaultBase642,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str3 = new StdSubtypeResolver();
    SimpleMixInResolver mixins3 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames3 = new RootNameLookup();
    ConfigOverrides configOverrides2 = new ConfigOverrides();
    DeserializationConfig config2 = new DeserializationConfig(base2, str3, mixins3, rootNames3, configOverrides2,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai3 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef = new POJOPropertyBuilder(config2, ai3, true, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member = new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef, member, contextAnnotations, declaredType, ser, typeSer,
        new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci3 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai4 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns3 = new PropertyNamingStrategy();
    TypeFactory tf3 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer3 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi3 = mock(HandlerInstantiator.class);
    Locale locale3 = Locale.getDefault();
    TimeZone tz3 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase643 = Base64Variants.getDefaultVariant();
    BaseSettings base3 = new BaseSettings(ci3, ai4, pns3, tf3, typer3, dateFormat3, hi3, locale3, tz3, defaultBase643,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str4 = new StdSubtypeResolver();
    SimpleMixInResolver mixins4 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames4 = new RootNameLookup();
    ConfigOverrides configOverrides3 = new ConfigOverrides();
    DeserializationConfig config3 = new DeserializationConfig(base3, str4, mixins4, rootNames4, configOverrides3,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai5 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef2 = new POJOPropertyBuilder(config3, ai5, true, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute member2 = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations2 = new AnnotationMap();
    PlaceholderForType declaredType2 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser2 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer2 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef2, member2, contextAnnotations2, declaredType2, ser2, typeSer2,
        new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci4 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai6 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns4 = new PropertyNamingStrategy();
    TypeFactory tf4 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer4 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat4 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi4 = mock(HandlerInstantiator.class);
    Locale locale4 = Locale.getDefault();
    TimeZone tz4 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase644 = Base64Variants.getDefaultVariant();
    BaseSettings base4 = new BaseSettings(ci4, ai6, pns4, tf4, typer4, dateFormat4, hi4, locale4, tz4, defaultBase644,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str5 = new StdSubtypeResolver();
    SimpleMixInResolver mixins5 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames5 = new RootNameLookup();
    ConfigOverrides configOverrides4 = new ConfigOverrides();
    DeserializationConfig config4 = new DeserializationConfig(base4, str5, mixins5, rootNames5, configOverrides4,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai7 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef3 = new POJOPropertyBuilder(config4, ai7, true, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass3 = Object.class;
    VirtualXMLAttribute member3 = new VirtualXMLAttribute(declaringClass3, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations3 = new AnnotationMap();
    PlaceholderForType declaredType3 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser3 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer3 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef3, member3, contextAnnotations3, declaredType3, ser3, typeSer3,
        new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci5 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai8 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns5 = new PropertyNamingStrategy();
    TypeFactory tf5 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer5 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat5 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi5 = mock(HandlerInstantiator.class);
    Locale locale5 = Locale.getDefault();
    TimeZone tz5 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase645 = Base64Variants.getDefaultVariant();
    BaseSettings base5 = new BaseSettings(ci5, ai8, pns5, tf5, typer5, dateFormat5, hi5, locale5, tz5, defaultBase645,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str6 = new StdSubtypeResolver();
    SimpleMixInResolver mixins6 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames6 = new RootNameLookup();
    ConfigOverrides configOverrides5 = new ConfigOverrides();
    DeserializationConfig config5 = new DeserializationConfig(base5, str6, mixins6, rootNames6, configOverrides5,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai9 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef4 = new POJOPropertyBuilder(config5, ai9, true, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass4 = Object.class;
    VirtualXMLAttribute member4 = new VirtualXMLAttribute(declaringClass4, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations4 = new AnnotationMap();
    PlaceholderForType declaredType4 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser4 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer4 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef4, member4, contextAnnotations4, declaredType4, ser4, typeSer4,
        new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci6 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai10 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns6 = new PropertyNamingStrategy();
    TypeFactory tf6 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer6 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat6 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi6 = mock(HandlerInstantiator.class);
    Locale locale6 = Locale.getDefault();
    TimeZone tz6 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase646 = Base64Variants.getDefaultVariant();
    BaseSettings base6 = new BaseSettings(ci6, ai10, pns6, tf6, typer6, dateFormat6, hi6, locale6, tz6, defaultBase646,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str7 = new StdSubtypeResolver();
    SimpleMixInResolver mixins7 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames7 = new RootNameLookup();
    ConfigOverrides configOverrides6 = new ConfigOverrides();
    DeserializationConfig config6 = new DeserializationConfig(base6, str7, mixins7, rootNames7, configOverrides6,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai11 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef5 = new POJOPropertyBuilder(config6, ai11, true, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass5 = Object.class;
    VirtualXMLAttribute member5 = new VirtualXMLAttribute(declaringClass5, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations5 = new AnnotationMap();
    PlaceholderForType declaredType5 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser5 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer5 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef5, member5, contextAnnotations5, declaredType5, ser5, typeSer5,
        new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci7 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai12 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns7 = new PropertyNamingStrategy();
    TypeFactory tf7 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer7 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat7 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi7 = mock(HandlerInstantiator.class);
    Locale locale7 = Locale.getDefault();
    TimeZone tz7 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase647 = Base64Variants.getDefaultVariant();
    BaseSettings base7 = new BaseSettings(ci7, ai12, pns7, tf7, typer7, dateFormat7, hi7, locale7, tz7, defaultBase647,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str8 = new StdSubtypeResolver();
    SimpleMixInResolver mixins8 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames8 = new RootNameLookup();
    ConfigOverrides configOverrides7 = new ConfigOverrides();
    DeserializationConfig config7 = new DeserializationConfig(base7, str8, mixins8, rootNames8, configOverrides7,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai13 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef6 = new POJOPropertyBuilder(config7, ai13, true, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass6 = Object.class;
    VirtualXMLAttribute member6 = new VirtualXMLAttribute(declaringClass6, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations6 = new AnnotationMap();
    PlaceholderForType declaredType6 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser6 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer6 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef6, member6, contextAnnotations6, declaredType6, ser6, typeSer6,
        new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci8 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai14 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns8 = new PropertyNamingStrategy();
    TypeFactory tf8 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer8 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat8 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi8 = mock(HandlerInstantiator.class);
    Locale locale8 = Locale.getDefault();
    TimeZone tz8 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase648 = Base64Variants.getDefaultVariant();
    BaseSettings base8 = new BaseSettings(ci8, ai14, pns8, tf8, typer8, dateFormat8, hi8, locale8, tz8, defaultBase648,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str9 = new StdSubtypeResolver();
    SimpleMixInResolver mixins9 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames9 = new RootNameLookup();
    ConfigOverrides configOverrides8 = new ConfigOverrides();
    DeserializationConfig config8 = new DeserializationConfig(base8, str9, mixins9, rootNames9, configOverrides8,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai15 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef7 = new POJOPropertyBuilder(config8, ai15, true, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass7 = Object.class;
    VirtualXMLAttribute member7 = new VirtualXMLAttribute(declaringClass7, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations7 = new AnnotationMap();
    PlaceholderForType declaredType7 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser7 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer7 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef7, member7, contextAnnotations7, declaredType7, ser7, typeSer7,
        new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci9 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai16 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns9 = new PropertyNamingStrategy();
    TypeFactory tf9 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer9 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat9 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi9 = mock(HandlerInstantiator.class);
    Locale locale9 = Locale.getDefault();
    TimeZone tz9 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase649 = Base64Variants.getDefaultVariant();
    BaseSettings base9 = new BaseSettings(ci9, ai16, pns9, tf9, typer9, dateFormat9, hi9, locale9, tz9, defaultBase649,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str10 = new StdSubtypeResolver();
    SimpleMixInResolver mixins10 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames10 = new RootNameLookup();
    ConfigOverrides configOverrides9 = new ConfigOverrides();
    DeserializationConfig config9 = new DeserializationConfig(base9, str10, mixins10, rootNames10, configOverrides9,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai17 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef8 = new POJOPropertyBuilder(config9, ai17, true, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass8 = Object.class;
    VirtualXMLAttribute member8 = new VirtualXMLAttribute(declaringClass8, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations8 = new AnnotationMap();
    PlaceholderForType declaredType8 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser8 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer8 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef8, member8, contextAnnotations8, declaredType8, ser8, typeSer8,
        new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci10 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai18 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns10 = new PropertyNamingStrategy();
    TypeFactory tf10 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer10 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat10 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi10 = mock(HandlerInstantiator.class);
    Locale locale10 = Locale.getDefault();
    TimeZone tz10 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase6410 = Base64Variants.getDefaultVariant();
    BaseSettings base10 = new BaseSettings(ci10, ai18, pns10, tf10, typer10, dateFormat10, hi10, locale10, tz10,
        defaultBase6410, new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str11 = new StdSubtypeResolver();
    SimpleMixInResolver mixins11 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames11 = new RootNameLookup();
    ConfigOverrides configOverrides10 = new ConfigOverrides();
    DeserializationConfig config10 = new DeserializationConfig(base10, str11, mixins11, rootNames11, configOverrides10,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai19 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef9 = new POJOPropertyBuilder(config10, ai19, true, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass9 = Object.class;
    VirtualXMLAttribute member9 = new VirtualXMLAttribute(declaringClass9, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations9 = new AnnotationMap();
    PlaceholderForType declaredType9 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser9 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer9 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef9, member9, contextAnnotations9, declaredType9, ser9, typeSer9,
        new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci11 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai20 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns11 = new PropertyNamingStrategy();
    TypeFactory tf11 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer11 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat11 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi11 = mock(HandlerInstantiator.class);
    Locale locale11 = Locale.getDefault();
    TimeZone tz11 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase6411 = Base64Variants.getDefaultVariant();
    BaseSettings base11 = new BaseSettings(ci11, ai20, pns11, tf11, typer11, dateFormat11, hi11, locale11, tz11,
        defaultBase6411, new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str12 = new StdSubtypeResolver();
    SimpleMixInResolver mixins12 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames12 = new RootNameLookup();
    ConfigOverrides configOverrides11 = new ConfigOverrides();
    DeserializationConfig config11 = new DeserializationConfig(base11, str12, mixins12, rootNames12, configOverrides11,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai21 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef10 = new POJOPropertyBuilder(config11, ai21, true,
        PropertyName.construct("Simple Name"));

    Class<Object> declaringClass10 = Object.class;
    VirtualXMLAttribute member10 = new VirtualXMLAttribute(declaringClass10, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations10 = new AnnotationMap();
    PlaceholderForType declaredType10 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser10 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer10 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef10, member10, contextAnnotations10, declaredType10, ser10,
        typeSer10, new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci12 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai22 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns12 = new PropertyNamingStrategy();
    TypeFactory tf12 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer12 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat12 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi12 = mock(HandlerInstantiator.class);
    Locale locale12 = Locale.getDefault();
    TimeZone tz12 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase6412 = Base64Variants.getDefaultVariant();
    BaseSettings base12 = new BaseSettings(ci12, ai22, pns12, tf12, typer12, dateFormat12, hi12, locale12, tz12,
        defaultBase6412, new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str13 = new StdSubtypeResolver();
    SimpleMixInResolver mixins13 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames13 = new RootNameLookup();
    ConfigOverrides configOverrides12 = new ConfigOverrides();
    DeserializationConfig config12 = new DeserializationConfig(base12, str13, mixins13, rootNames13, configOverrides12,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai23 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef11 = new POJOPropertyBuilder(config12, ai23, true,
        PropertyName.construct("Simple Name"));

    Class<Object> declaringClass11 = Object.class;
    VirtualXMLAttribute member11 = new VirtualXMLAttribute(declaringClass11, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations11 = new AnnotationMap();
    PlaceholderForType declaredType11 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser11 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer11 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef11, member11, contextAnnotations11, declaredType11, ser11,
        typeSer11, new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci13 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai24 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns13 = new PropertyNamingStrategy();
    TypeFactory tf13 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer13 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat13 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi13 = mock(HandlerInstantiator.class);
    Locale locale13 = Locale.getDefault();
    TimeZone tz13 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase6413 = Base64Variants.getDefaultVariant();
    BaseSettings base13 = new BaseSettings(ci13, ai24, pns13, tf13, typer13, dateFormat13, hi13, locale13, tz13,
        defaultBase6413, new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str14 = new StdSubtypeResolver();
    SimpleMixInResolver mixins14 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames14 = new RootNameLookup();
    ConfigOverrides configOverrides13 = new ConfigOverrides();
    DeserializationConfig config13 = new DeserializationConfig(base13, str14, mixins14, rootNames14, configOverrides13,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai25 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef12 = new POJOPropertyBuilder(config13, ai25, true,
        PropertyName.construct("Simple Name"));

    Class<Object> declaringClass12 = Object.class;
    VirtualXMLAttribute member12 = new VirtualXMLAttribute(declaringClass12, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations12 = new AnnotationMap();
    PlaceholderForType declaredType12 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser12 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer12 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef12, member12, contextAnnotations12, declaredType12, ser12,
        typeSer12, new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci14 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai26 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns14 = new PropertyNamingStrategy();
    TypeFactory tf14 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer14 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat14 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi14 = mock(HandlerInstantiator.class);
    Locale locale14 = Locale.getDefault();
    TimeZone tz14 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase6414 = Base64Variants.getDefaultVariant();
    BaseSettings base14 = new BaseSettings(ci14, ai26, pns14, tf14, typer14, dateFormat14, hi14, locale14, tz14,
        defaultBase6414, new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str15 = new StdSubtypeResolver();
    SimpleMixInResolver mixins15 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames15 = new RootNameLookup();
    ConfigOverrides configOverrides14 = new ConfigOverrides();
    DeserializationConfig config14 = new DeserializationConfig(base14, str15, mixins15, rootNames15, configOverrides14,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai27 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef13 = new POJOPropertyBuilder(config14, ai27, true,
        PropertyName.construct("Simple Name"));

    Class<Object> declaringClass13 = Object.class;
    VirtualXMLAttribute member13 = new VirtualXMLAttribute(declaringClass13, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations13 = new AnnotationMap();
    PlaceholderForType declaredType13 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser13 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer13 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef13, member13, contextAnnotations13, declaredType13, ser13,
        typeSer13, new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci15 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai28 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns15 = new PropertyNamingStrategy();
    TypeFactory tf15 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer15 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat15 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi15 = mock(HandlerInstantiator.class);
    Locale locale15 = Locale.getDefault();
    TimeZone tz15 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase6415 = Base64Variants.getDefaultVariant();
    BaseSettings base15 = new BaseSettings(ci15, ai28, pns15, tf15, typer15, dateFormat15, hi15, locale15, tz15,
        defaultBase6415, new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str16 = new StdSubtypeResolver();
    SimpleMixInResolver mixins16 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames16 = new RootNameLookup();
    ConfigOverrides configOverrides15 = new ConfigOverrides();
    DeserializationConfig config15 = new DeserializationConfig(base15, str16, mixins16, rootNames16, configOverrides15,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai29 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef14 = new POJOPropertyBuilder(config15, ai29, true,
        PropertyName.construct("Simple Name"));

    Class<Object> declaringClass14 = Object.class;
    VirtualXMLAttribute member14 = new VirtualXMLAttribute(declaringClass14, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations14 = new AnnotationMap();
    PlaceholderForType declaredType14 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser14 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer14 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef14, member14, contextAnnotations14, declaredType14, ser14,
        typeSer14, new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci16 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai30 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns16 = new PropertyNamingStrategy();
    TypeFactory tf16 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer16 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat16 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi16 = mock(HandlerInstantiator.class);
    Locale locale16 = Locale.getDefault();
    TimeZone tz16 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase6416 = Base64Variants.getDefaultVariant();
    BaseSettings base16 = new BaseSettings(ci16, ai30, pns16, tf16, typer16, dateFormat16, hi16, locale16, tz16,
        defaultBase6416, new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str17 = new StdSubtypeResolver();
    SimpleMixInResolver mixins17 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames17 = new RootNameLookup();
    ConfigOverrides configOverrides16 = new ConfigOverrides();
    DeserializationConfig config16 = new DeserializationConfig(base16, str17, mixins17, rootNames17, configOverrides16,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai31 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef15 = new POJOPropertyBuilder(config16, ai31, true,
        PropertyName.construct("Simple Name"));

    Class<Object> declaringClass15 = Object.class;
    VirtualXMLAttribute member15 = new VirtualXMLAttribute(declaringClass15, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations15 = new AnnotationMap();
    PlaceholderForType declaredType15 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser15 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer15 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef15, member15, contextAnnotations15, declaredType15, ser15,
        typeSer15, new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci17 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai32 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns17 = new PropertyNamingStrategy();
    TypeFactory tf17 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer17 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat17 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi17 = mock(HandlerInstantiator.class);
    Locale locale17 = Locale.getDefault();
    TimeZone tz17 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase6417 = Base64Variants.getDefaultVariant();
    BaseSettings base17 = new BaseSettings(ci17, ai32, pns17, tf17, typer17, dateFormat17, hi17, locale17, tz17,
        defaultBase6417, new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str18 = new StdSubtypeResolver();
    SimpleMixInResolver mixins18 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames18 = new RootNameLookup();
    ConfigOverrides configOverrides17 = new ConfigOverrides();
    DeserializationConfig config17 = new DeserializationConfig(base17, str18, mixins18, rootNames18, configOverrides17,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai33 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef16 = new POJOPropertyBuilder(config17, ai33, true,
        PropertyName.construct("Simple Name"));

    Class<Object> declaringClass16 = Object.class;
    VirtualXMLAttribute member16 = new VirtualXMLAttribute(declaringClass16, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations16 = new AnnotationMap();
    PlaceholderForType declaredType16 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser16 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer16 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef16, member16, contextAnnotations16, declaredType16, ser16,
        typeSer16, new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci18 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai34 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns18 = new PropertyNamingStrategy();
    TypeFactory tf18 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer18 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat18 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi18 = mock(HandlerInstantiator.class);
    Locale locale18 = Locale.getDefault();
    TimeZone tz18 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase6418 = Base64Variants.getDefaultVariant();
    BaseSettings base18 = new BaseSettings(ci18, ai34, pns18, tf18, typer18, dateFormat18, hi18, locale18, tz18,
        defaultBase6418, new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str19 = new StdSubtypeResolver();
    SimpleMixInResolver mixins19 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames19 = new RootNameLookup();
    ConfigOverrides configOverrides18 = new ConfigOverrides();
    DeserializationConfig config18 = new DeserializationConfig(base18, str19, mixins19, rootNames19, configOverrides18,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai35 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef17 = new POJOPropertyBuilder(config18, ai35, true,
        PropertyName.construct("Simple Name"));

    Class<Object> declaringClass17 = Object.class;
    VirtualXMLAttribute member17 = new VirtualXMLAttribute(declaringClass17, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations17 = new AnnotationMap();
    PlaceholderForType declaredType17 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser17 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer17 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef17, member17, contextAnnotations17, declaredType17, ser17,
        typeSer17, new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci19 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai36 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns19 = new PropertyNamingStrategy();
    TypeFactory tf19 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer19 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat19 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi19 = mock(HandlerInstantiator.class);
    Locale locale19 = Locale.getDefault();
    TimeZone tz19 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase6419 = Base64Variants.getDefaultVariant();
    BaseSettings base19 = new BaseSettings(ci19, ai36, pns19, tf19, typer19, dateFormat19, hi19, locale19, tz19,
        defaultBase6419, new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str20 = new StdSubtypeResolver();
    SimpleMixInResolver mixins20 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames20 = new RootNameLookup();
    ConfigOverrides configOverrides19 = new ConfigOverrides();
    DeserializationConfig config19 = new DeserializationConfig(base19, str20, mixins20, rootNames20, configOverrides19,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai37 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef18 = new POJOPropertyBuilder(config19, ai37, true,
        PropertyName.construct("Simple Name"));

    Class<Object> declaringClass18 = Object.class;
    VirtualXMLAttribute member18 = new VirtualXMLAttribute(declaringClass18, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations18 = new AnnotationMap();
    PlaceholderForType declaredType18 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser18 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer18 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef18, member18, contextAnnotations18, declaredType18, ser18,
        typeSer18, new PlaceholderForType(1), true, "Suppressable Value"));

    // Act and Assert
    assertSame(beanProperties, rosettaBeanSerializerModifier.changeProperties(config, null, beanProperties));
  }

  /**
   * Method under test:
   * {@link RosettaBeanSerializerModifier#changeProperties(SerializationConfig, BeanDescription, List)}
   */
  @Test
  public void testChangeProperties3() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier = new RosettaBeanSerializerModifier();
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
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str2, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str, mixins2, rootNames2, new ConfigOverrides());

    ArrayList<BeanPropertyWriter> beanProperties = new ArrayList<>();
    BasicClassIntrospector ci2 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai2 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns2 = new PropertyNamingStrategy();
    TypeFactory tf2 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer2 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi2 = mock(HandlerInstantiator.class);
    Locale locale2 = Locale.getDefault();
    TimeZone tz2 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase642 = Base64Variants.getDefaultVariant();
    BaseSettings base2 = new BaseSettings(ci2, ai2, pns2, tf2, typer2, dateFormat2, hi2, locale2, tz2, defaultBase642,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str3 = new StdSubtypeResolver();
    SimpleMixInResolver mixins3 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames3 = new RootNameLookup();
    ConfigOverrides configOverrides2 = new ConfigOverrides();
    DeserializationConfig config2 = new DeserializationConfig(base2, str3, mixins3, rootNames3, configOverrides2,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai3 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef = new POJOPropertyBuilder(config2, ai3, true, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member = new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef, member, contextAnnotations, declaredType, ser, typeSer,
        new PlaceholderForType(1), true, "Suppressable Value"));

    // Act and Assert
    assertSame(beanProperties, rosettaBeanSerializerModifier.changeProperties(config, null, beanProperties));
  }

  /**
   * Method under test:
   * {@link RosettaBeanSerializerModifier#changeProperties(SerializationConfig, BeanDescription, List)}
   */
  @Test
  public void testChangeProperties4() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier = new RosettaBeanSerializerModifier();
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
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str2, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str, mixins2, rootNames2, new ConfigOverrides());

    ArrayList<BeanPropertyWriter> beanProperties = new ArrayList<>();
    BasicClassIntrospector ci2 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai2 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns2 = new PropertyNamingStrategy();
    TypeFactory tf2 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer2 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi2 = mock(HandlerInstantiator.class);
    Locale locale2 = Locale.getDefault();
    TimeZone tz2 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase642 = Base64Variants.getDefaultVariant();
    BaseSettings base2 = new BaseSettings(ci2, ai2, pns2, tf2, typer2, dateFormat2, hi2, locale2, tz2, defaultBase642,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str3 = new StdSubtypeResolver();
    SimpleMixInResolver mixins3 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames3 = new RootNameLookup();
    ConfigOverrides configOverrides2 = new ConfigOverrides();
    DeserializationConfig config2 = new DeserializationConfig(base2, str3, mixins3, rootNames3, configOverrides2,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai3 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef = new POJOPropertyBuilder(config2, ai3, true, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member = new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef, member, contextAnnotations, declaredType, ser, typeSer,
        new PlaceholderForType(1), true, "Suppressable Value"));
    BasicClassIntrospector ci3 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai4 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns3 = new PropertyNamingStrategy();
    TypeFactory tf3 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer3 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi3 = mock(HandlerInstantiator.class);
    Locale locale3 = Locale.getDefault();
    TimeZone tz3 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase643 = Base64Variants.getDefaultVariant();
    BaseSettings base3 = new BaseSettings(ci3, ai4, pns3, tf3, typer3, dateFormat3, hi3, locale3, tz3, defaultBase643,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str4 = new StdSubtypeResolver();
    SimpleMixInResolver mixins4 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames4 = new RootNameLookup();
    ConfigOverrides configOverrides3 = new ConfigOverrides();
    DeserializationConfig config3 = new DeserializationConfig(base3, str4, mixins4, rootNames4, configOverrides3,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai5 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef2 = new POJOPropertyBuilder(config3, ai5, true, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass2 = Object.class;
    VirtualXMLAttribute member2 = new VirtualXMLAttribute(declaringClass2, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations2 = new AnnotationMap();
    PlaceholderForType declaredType2 = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser2 = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer2 = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef2, member2, contextAnnotations2, declaredType2, ser2, typeSer2,
        new PlaceholderForType(1), true, "Suppressable Value"));

    // Act and Assert
    assertSame(beanProperties, rosettaBeanSerializerModifier.changeProperties(config, null, beanProperties));
  }

  /**
   * Method under test:
   * {@link RosettaBeanSerializerModifier#changeProperties(SerializationConfig, BeanDescription, List)}
   */
  @Test
  public void testChangeProperties5() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier = new RosettaBeanSerializerModifier();
    BasicClassIntrospector ci = new BasicClassIntrospector();
    RosettaJSONAnnotationIntrospector p = new RosettaJSONAnnotationIntrospector(true);
    AnnotationIntrospectorPair ai = new AnnotationIntrospectorPair(p, new RosettaJSONAnnotationIntrospector(true));

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
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str2, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str, mixins2, rootNames2, new ConfigOverrides());

    ArrayList<BeanPropertyWriter> beanProperties = new ArrayList<>();
    BasicClassIntrospector ci2 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai2 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns2 = new PropertyNamingStrategy();
    TypeFactory tf2 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer2 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi2 = mock(HandlerInstantiator.class);
    Locale locale2 = Locale.getDefault();
    TimeZone tz2 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase642 = Base64Variants.getDefaultVariant();
    BaseSettings base2 = new BaseSettings(ci2, ai2, pns2, tf2, typer2, dateFormat2, hi2, locale2, tz2, defaultBase642,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str3 = new StdSubtypeResolver();
    SimpleMixInResolver mixins3 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames3 = new RootNameLookup();
    ConfigOverrides configOverrides2 = new ConfigOverrides();
    DeserializationConfig config2 = new DeserializationConfig(base2, str3, mixins3, rootNames3, configOverrides2,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai3 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef = new POJOPropertyBuilder(config2, ai3, true, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member = new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef, member, contextAnnotations, declaredType, ser, typeSer,
        new PlaceholderForType(1), true, "Suppressable Value"));

    // Act and Assert
    assertSame(beanProperties, rosettaBeanSerializerModifier.changeProperties(config, null, beanProperties));
  }

  /**
   * Method under test:
   * {@link RosettaBeanSerializerModifier#changeProperties(SerializationConfig, BeanDescription, List)}
   */
  @Test
  public void testChangeProperties6() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier = new RosettaBeanSerializerModifier();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(mixins.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    BasicClassIntrospector ci = new BasicClassIntrospector();
    ObjectMapper mapper = new ObjectMapper();
    RosettaXMLAnnotationIntrospector ai = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);

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

    StdSubtypeResolver str2 = new StdSubtypeResolver();
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str2, mixins2, rootNames2, new ConfigOverrides());

    ArrayList<BeanPropertyWriter> beanProperties = new ArrayList<>();
    BasicClassIntrospector ci2 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai2 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns2 = new PropertyNamingStrategy();
    TypeFactory tf2 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer2 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi2 = mock(HandlerInstantiator.class);
    Locale locale2 = Locale.getDefault();
    TimeZone tz2 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase642 = Base64Variants.getDefaultVariant();
    BaseSettings base2 = new BaseSettings(ci2, ai2, pns2, tf2, typer2, dateFormat2, hi2, locale2, tz2, defaultBase642,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str3 = new StdSubtypeResolver();
    SimpleMixInResolver mixins3 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames3 = new RootNameLookup();
    ConfigOverrides configOverrides2 = new ConfigOverrides();
    DeserializationConfig config2 = new DeserializationConfig(base2, str3, mixins3, rootNames3, configOverrides2,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai3 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef = new POJOPropertyBuilder(config2, ai3, true, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member = new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef, member, contextAnnotations, declaredType, ser, typeSer,
        new PlaceholderForType(1), true, "Suppressable Value"));

    // Act
    List<BeanPropertyWriter> actualChangePropertiesResult = rosettaBeanSerializerModifier.changeProperties(config, null,
        beanProperties);

    // Assert
    verify(mixins, atLeast(1)).findMixInClassFor(isA(Class.class));
    assertSame(beanProperties, actualChangePropertiesResult);
  }

  /**
   * Method under test:
   * {@link RosettaBeanSerializerModifier#changeProperties(SerializationConfig, BeanDescription, List)}
   */
  @Test
  public void testChangeProperties7() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier = new RosettaBeanSerializerModifier();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    Class<XmlBeanSerializer> forNameResult = XmlBeanSerializer.class;
    Mockito.<Class<?>>when(mixins.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    BasicClassIntrospector ci = new BasicClassIntrospector();
    ObjectMapper mapper = new ObjectMapper();
    RosettaXMLAnnotationIntrospector ai = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);

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

    StdSubtypeResolver str2 = new StdSubtypeResolver();
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str2, mixins2, rootNames2, new ConfigOverrides());

    ArrayList<BeanPropertyWriter> beanProperties = new ArrayList<>();
    BasicClassIntrospector ci2 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai2 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns2 = new PropertyNamingStrategy();
    TypeFactory tf2 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer2 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi2 = mock(HandlerInstantiator.class);
    Locale locale2 = Locale.getDefault();
    TimeZone tz2 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase642 = Base64Variants.getDefaultVariant();
    BaseSettings base2 = new BaseSettings(ci2, ai2, pns2, tf2, typer2, dateFormat2, hi2, locale2, tz2, defaultBase642,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str3 = new StdSubtypeResolver();
    SimpleMixInResolver mixins3 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames3 = new RootNameLookup();
    ConfigOverrides configOverrides2 = new ConfigOverrides();
    DeserializationConfig config2 = new DeserializationConfig(base2, str3, mixins3, rootNames3, configOverrides2,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai3 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef = new POJOPropertyBuilder(config2, ai3, true, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member = new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef, member, contextAnnotations, declaredType, ser, typeSer,
        new PlaceholderForType(1), true, "Suppressable Value"));

    // Act
    List<BeanPropertyWriter> actualChangePropertiesResult = rosettaBeanSerializerModifier.changeProperties(config, null,
        beanProperties);

    // Assert
    verify(mixins, atLeast(1)).findMixInClassFor(isA(Class.class));
    assertSame(beanProperties, actualChangePropertiesResult);
  }

  /**
   * Method under test:
   * {@link RosettaBeanSerializerModifier#changeProperties(SerializationConfig, BeanDescription, List)}
   */
  @Test
  public void testChangeProperties8() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier = new RosettaBeanSerializerModifier();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    Mockito.<Class<?>>when(mixins.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(null);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    BasicClassIntrospector ci = new BasicClassIntrospector();
    ObjectMapper mapper = new ObjectMapper();
    RosettaXMLAnnotationIntrospector ai = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);

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

    StdSubtypeResolver str2 = new StdSubtypeResolver();
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str2, mixins2, rootNames2, new ConfigOverrides());

    ArrayList<BeanPropertyWriter> beanProperties = new ArrayList<>();
    BasicClassIntrospector ci2 = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai2 = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns2 = new PropertyNamingStrategy();
    TypeFactory tf2 = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer2 = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi2 = mock(HandlerInstantiator.class);
    Locale locale2 = Locale.getDefault();
    TimeZone tz2 = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase642 = Base64Variants.getDefaultVariant();
    BaseSettings base2 = new BaseSettings(ci2, ai2, pns2, tf2, typer2, dateFormat2, hi2, locale2, tz2, defaultBase642,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str3 = new StdSubtypeResolver();
    SimpleMixInResolver mixins3 = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames3 = new RootNameLookup();
    ConfigOverrides configOverrides2 = new ConfigOverrides();
    DeserializationConfig config2 = new DeserializationConfig(base2, str3, mixins3, rootNames3, configOverrides2,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai3 = new RosettaJSONAnnotationIntrospector(true);
    POJOPropertyBuilder propDef = new POJOPropertyBuilder(config2, ai3, true, PropertyName.construct("Simple Name"));

    Class<Object> declaringClass = Object.class;
    VirtualXMLAttribute member = new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1));

    AnnotationMap contextAnnotations = new AnnotationMap();
    PlaceholderForType declaredType = new PlaceholderForType(1);
    CoreXMLSerializers.XMLGregorianCalendarSerializer ser = new CoreXMLSerializers.XMLGregorianCalendarSerializer();
    AsDeductionTypeSerializer typeSer = AsDeductionTypeSerializer.instance();
    beanProperties.add(new BeanPropertyWriter(propDef, member, contextAnnotations, declaredType, ser, typeSer,
        new PlaceholderForType(1), true, "Suppressable Value"));

    // Act
    List<BeanPropertyWriter> actualChangePropertiesResult = rosettaBeanSerializerModifier.changeProperties(config, null,
        beanProperties);

    // Assert
    verify(mixins, atLeast(1)).findMixInClassFor(isA(Class.class));
    assertSame(beanProperties, actualChangePropertiesResult);
  }

  /**
   * Method under test:
   * {@link RosettaBeanSerializerModifier#changeProperties(SerializationConfig, BeanDescription, List)}
   */
  @Test
  public void testChangeProperties9() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier = new RosettaBeanSerializerModifier();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(mixins.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    BasicClassIntrospector ci = new BasicClassIntrospector();
    ObjectMapper mapper = new ObjectMapper();
    RosettaXMLAnnotationIntrospector ai = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);

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

    StdSubtypeResolver str2 = new StdSubtypeResolver();
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str2, mixins2, rootNames2, new ConfigOverrides());

    AttributePropertyWriter attributePropertyWriter = mock(AttributePropertyWriter.class);
    Class<Object> declaringClass = Object.class;
    when(attributePropertyWriter.getMember())
        .thenReturn(new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));

    ArrayList<BeanPropertyWriter> beanProperties = new ArrayList<>();
    beanProperties.add(attributePropertyWriter);

    // Act
    List<BeanPropertyWriter> actualChangePropertiesResult = rosettaBeanSerializerModifier.changeProperties(config, null,
        beanProperties);

    // Assert
    verify(mixins, atLeast(1)).findMixInClassFor(isA(Class.class));
    verify(attributePropertyWriter).getMember();
    assertEquals(1, actualChangePropertiesResult.size());
    assertSame(beanProperties, actualChangePropertiesResult);
  }

  /**
   * Method under test:
   * {@link RosettaBeanSerializerModifier#findSubstitutionMap(MapperConfig, AnnotationIntrospector, AnnotatedMember)}
   */
  @Test
  public void testFindSubstitutionMap() {
    // Arrange
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
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector ai2 = new RosettaJSONAnnotationIntrospector(true);
    Class<Object> declaringClass = Object.class;

    // Act and Assert
    assertNull(RosettaBeanSerializerModifier.findSubstitutionMap(config, ai2,
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1))));
  }

  /**
   * Method under test:
   * {@link RosettaBeanSerializerModifier#findSubstitutionMap(MapperConfig, AnnotationIntrospector, AnnotatedMember)}
   */
  @Test
  public void testFindSubstitutionMap2() {
    // Arrange
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
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    RosettaJSONAnnotationIntrospector p = new RosettaJSONAnnotationIntrospector(true);
    AnnotationIntrospectorPair ai2 = new AnnotationIntrospectorPair(p, new RosettaJSONAnnotationIntrospector(true));

    Class<Object> declaringClass = Object.class;

    // Act and Assert
    assertNull(RosettaBeanSerializerModifier.findSubstitutionMap(config, ai2,
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1))));
  }

  /**
   * Method under test:
   * {@link RosettaBeanSerializerModifier#findSubstitutionMap(MapperConfig, AnnotationIntrospector, AnnotatedMember)}
   */
  @Test
  public void testFindSubstitutionMap3() {
    // Arrange
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
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
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    ObjectMapper mapper = new ObjectMapper();
    RosettaXMLAnnotationIntrospector ai2 = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);

    Class<Object> declaringClass = Object.class;

    // Act
    SubstitutionMap actualFindSubstitutionMapResult = RosettaBeanSerializerModifier.findSubstitutionMap(config, ai2,
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));

    // Assert
    verify(overrides, atLeast(1)).findMixInClassFor(isA(Class.class));
    assertNull(actualFindSubstitutionMapResult);
  }

  /**
   * Method under test:
   * {@link RosettaBeanSerializerModifier#findSubstitutionMap(MapperConfig, AnnotationIntrospector, AnnotatedMember)}
   */
  @Test
  public void testFindSubstitutionMap4() {
    // Arrange
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
    BasicClassIntrospector ci = new BasicClassIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    ObjectMapper.DefaultTypeResolverBuilder typer = new ObjectMapper.DefaultTypeResolverBuilder(
        ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, null, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    ObjectMapper mapper = new ObjectMapper();
    RosettaXMLAnnotationIntrospector ai = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);

    Class<Object> declaringClass = Object.class;

    // Act
    SubstitutionMap actualFindSubstitutionMapResult = RosettaBeanSerializerModifier.findSubstitutionMap(config, ai,
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));

    // Assert
    verify(overrides).findMixInClassFor(isA(Class.class));
    assertNull(actualFindSubstitutionMapResult);
  }

  /**
   * Method under test:
   * {@link RosettaBeanSerializerModifier#findSubstitutionMap(MapperConfig, AnnotationIntrospector, AnnotatedMember)}
   */
  @Test
  public void testFindSubstitutionMap5() {
    // Arrange
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Class<XmlBeanSerializer> forNameResult = XmlBeanSerializer.class;
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(forNameResult);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
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
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    ObjectMapper mapper = new ObjectMapper();
    RosettaXMLAnnotationIntrospector ai2 = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);

    Class<Object> declaringClass = Object.class;

    // Act
    SubstitutionMap actualFindSubstitutionMapResult = RosettaBeanSerializerModifier.findSubstitutionMap(config, ai2,
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));

    // Assert
    verify(overrides, atLeast(1)).findMixInClassFor(isA(Class.class));
    assertNull(actualFindSubstitutionMapResult);
  }

  /**
   * Method under test:
   * {@link RosettaBeanSerializerModifier#findSubstitutionMap(MapperConfig, AnnotationIntrospector, AnnotatedMember)}
   */
  @Test
  public void testFindSubstitutionMap6() {
    // Arrange
    ClassIntrospector.MixInResolver overrides = mock(ClassIntrospector.MixInResolver.class);
    Mockito.<Class<?>>when(overrides.findMixInClassFor(Mockito.<Class<Object>>any())).thenReturn(null);
    SimpleMixInResolver mixins = new SimpleMixInResolver(overrides);
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
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, configOverrides,
        new CoercionConfigs(), mock(DatatypeFeatures.class));

    ObjectMapper mapper = new ObjectMapper();
    RosettaXMLAnnotationIntrospector ai2 = new RosettaXMLAnnotationIntrospector(mapper,
        new RosettaXMLConfiguration(new HashMap<>()), true);

    Class<Object> declaringClass = Object.class;

    // Act
    SubstitutionMap actualFindSubstitutionMapResult = RosettaBeanSerializerModifier.findSubstitutionMap(config, ai2,
        new VirtualXMLAttribute(declaringClass, "Name", new PlaceholderForType(1)));

    // Assert
    verify(overrides, atLeast(1)).findMixInClassFor(isA(Class.class));
    assertNull(actualFindSubstitutionMapResult);
  }

  /**
   * Method under test:
   * {@link RosettaBeanSerializerModifier#modifySerializer(SerializationConfig, BeanDescription, JsonSerializer)}
   */
  @Test
  public void testModifySerializer() {
    // Arrange
    RosettaBeanSerializerModifier rosettaBeanSerializerModifier = new RosettaBeanSerializerModifier();
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
    StdSubtypeResolver str2 = new StdSubtypeResolver();
    SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
    RootNameLookup rootNames = new RootNameLookup();
    ConfigOverrides configOverrides = new ConfigOverrides();
    SimpleMixInResolver mixins2 = new SimpleMixInResolver(new DeserializationConfig(null, str2, mixins, rootNames,
        configOverrides, new CoercionConfigs(), mock(DatatypeFeatures.class)));
    RootNameLookup rootNames2 = new RootNameLookup();
    SerializationConfig config = new SerializationConfig(base, str, mixins2, rootNames2, new ConfigOverrides());

    CoreXMLSerializers.XMLGregorianCalendarSerializer serializer = new CoreXMLSerializers.XMLGregorianCalendarSerializer();

    // Act and Assert
    assertSame(serializer, rosettaBeanSerializerModifier.modifySerializer(config, null, serializer));
  }
}
