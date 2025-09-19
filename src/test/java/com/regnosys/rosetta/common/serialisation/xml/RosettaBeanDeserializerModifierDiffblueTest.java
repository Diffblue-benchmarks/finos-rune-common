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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
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
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBuilder;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.Impl;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator.Builder;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RosettaBeanDeserializerModifierDiffblueTest {
  /**
   * Test {@link RosettaBeanDeserializerModifier#updateBuilder(DeserializationConfig,
   * BeanDescription, BeanDeserializerBuilder)}.
   *
   * <p>Method under test: {@link
   * RosettaBeanDeserializerModifier#updateBuilder(DeserializationConfig, BeanDescription,
   * BeanDeserializerBuilder)}
   */
  @Test
  @DisplayName(
      "Test updateBuilder(DeserializationConfig, BeanDescription, BeanDeserializerBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BeanDeserializerBuilder RosettaBeanDeserializerModifier.updateBuilder(DeserializationConfig, BeanDescription, BeanDeserializerBuilder)"
  })
  void testUpdateBuilder() {
    // Arrange
    RosettaBeanDeserializerModifier rosettaBeanDeserializerModifier =
        new RosettaBeanDeserializerModifier();
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
    Impl ctxt = new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()));
    BeanDeserializerBuilder builder = new BeanDeserializerBuilder(null, ctxt);

    // Act
    BeanDeserializerBuilder actualUpdateBuilderResult =
        rosettaBeanDeserializerModifier.updateBuilder(config, null, builder);

    // Assert
    assertSame(builder, actualUpdateBuilderResult);
  }

  /**
   * Test {@link RosettaBeanDeserializerModifier#updateBuilder(DeserializationConfig,
   * BeanDescription, BeanDeserializerBuilder)}.
   *
   * <p>Method under test: {@link
   * RosettaBeanDeserializerModifier#updateBuilder(DeserializationConfig, BeanDescription,
   * BeanDeserializerBuilder)}
   */
  @Test
  @DisplayName(
      "Test updateBuilder(DeserializationConfig, BeanDescription, BeanDeserializerBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BeanDeserializerBuilder RosettaBeanDeserializerModifier.updateBuilder(DeserializationConfig, BeanDescription, BeanDeserializerBuilder)"
  })
  void testUpdateBuilder2() {
    // Arrange
    RosettaBeanDeserializerModifier rosettaBeanDeserializerModifier =
        new RosettaBeanDeserializerModifier();
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
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv =
        BasicPolymorphicTypeValidator.builder().denyForExactBaseType(baseTypeToDeny).build();

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
    Impl ctxt = new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()));

    BeanDeserializerBuilder builder = new BeanDeserializerBuilder(null, ctxt);
    SubstitutedMethodProperty src =
        new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);
    SubstitutedMethodProperty prop =
        new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));
    builder.addOrReplaceProperty(prop, true);

    // Act and Assert
    Iterator<SettableBeanProperty> properties =
        rosettaBeanDeserializerModifier.updateBuilder(config, null, builder).getProperties();
    SettableBeanProperty actualNextResult = properties.next();
    assertFalse(properties.hasNext());
    assertSame(prop, actualNextResult);
  }

  /**
   * Test {@link RosettaBeanDeserializerModifier#updateBuilder(DeserializationConfig,
   * BeanDescription, BeanDeserializerBuilder)}.
   *
   * <ul>
   *   <li>Then Properties next return {@link SubstitutedMethodProperty}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaBeanDeserializerModifier#updateBuilder(DeserializationConfig, BeanDescription,
   * BeanDeserializerBuilder)}
   */
  @Test
  @DisplayName(
      "Test updateBuilder(DeserializationConfig, BeanDescription, BeanDeserializerBuilder); then Properties next return SubstitutedMethodProperty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BeanDeserializerBuilder RosettaBeanDeserializerModifier.updateBuilder(DeserializationConfig, BeanDescription, BeanDeserializerBuilder)"
  })
  void testUpdateBuilder_thenPropertiesNextReturnSubstitutedMethodProperty() {
    // Arrange
    RosettaBeanDeserializerModifier rosettaBeanDeserializerModifier =
        new RosettaBeanDeserializerModifier();
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
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv =
        BasicPolymorphicTypeValidator.builder().denyForExactBaseType(baseTypeToDeny).build();

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
    Impl ctxt = new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()));

    BeanDeserializerBuilder builder = new BeanDeserializerBuilder(null, ctxt);
    SubstitutedMethodProperty src =
        new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);
    SubstitutedMethodProperty prop =
        new SubstitutedMethodProperty(src, PropertyName.construct("42"));
    builder.addOrReplaceProperty(prop, false);
    SubstitutedMethodProperty src2 =
        new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);
    SubstitutedMethodProperty prop2 =
        new SubstitutedMethodProperty(src2, PropertyName.construct("Simple Name"));
    builder.addOrReplaceProperty(prop2, true);

    // Act and Assert
    Iterator<SettableBeanProperty> properties =
        rosettaBeanDeserializerModifier.updateBuilder(config, null, builder).getProperties();
    SettableBeanProperty actualNextResult = properties.next();
    SettableBeanProperty nextResult = properties.next();
    assertTrue(nextResult instanceof SubstitutedMethodProperty);
    assertFalse(properties.hasNext());
    assertSame(prop, actualNextResult);
    assertSame(prop2, nextResult);
  }

  /**
   * Test {@link RosettaBeanDeserializerModifier#updateBuilder(DeserializationConfig,
   * BeanDescription, BeanDeserializerBuilder)}.
   *
   * <ul>
   *   <li>Then return not Properties hasNext.
   * </ul>
   *
   * <p>Method under test: {@link
   * RosettaBeanDeserializerModifier#updateBuilder(DeserializationConfig, BeanDescription,
   * BeanDeserializerBuilder)}
   */
  @Test
  @DisplayName(
      "Test updateBuilder(DeserializationConfig, BeanDescription, BeanDeserializerBuilder); then return not Properties hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BeanDeserializerBuilder RosettaBeanDeserializerModifier.updateBuilder(DeserializationConfig, BeanDescription, BeanDeserializerBuilder)"
  })
  void testUpdateBuilder_thenReturnNotPropertiesHasNext() {
    // Arrange
    RosettaBeanDeserializerModifier rosettaBeanDeserializerModifier =
        new RosettaBeanDeserializerModifier();
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
    Class<Object> baseTypeToDeny = Object.class;
    BasicPolymorphicTypeValidator ptv =
        BasicPolymorphicTypeValidator.builder().denyForExactBaseType(baseTypeToDeny).build();

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
    Impl ctxt = new Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig()));

    BeanDeserializerBuilder builder = new BeanDeserializerBuilder(null, ctxt);
    SubstitutedMethodProperty src =
        new SubstitutedMethodProperty(mock(SubstitutedMethodProperty.class), (Method) null);
    SubstitutedMethodProperty prop =
        new SubstitutedMethodProperty(src, PropertyName.construct("Simple Name"));
    builder.addOrReplaceProperty(prop, true);

    // Act and Assert
    Iterator<SettableBeanProperty> properties =
        rosettaBeanDeserializerModifier.updateBuilder(config, null, builder).getProperties();
    SettableBeanProperty actualNextResult = properties.next();
    assertFalse(properties.hasNext());
    assertSame(prop, actualNextResult);
  }
}
