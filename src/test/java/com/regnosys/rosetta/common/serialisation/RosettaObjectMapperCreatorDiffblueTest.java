package com.regnosys.rosetta.common.serialisation;

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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.std.JsonLocationInstantiator;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker.Std;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.deser.XmlDeserializationContext;
import com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider;
import com.regnosys.rosetta.common.serialisation.xml.RosettaBeanDeserializerModifier;
import com.regnosys.rosetta.common.serialisation.xml.RosettaBeanSerializerModifier;
import com.regnosys.rosetta.common.serialisation.xml.RosettaSerialiserFactory;
import com.rosetta.util.serialisation.RosettaXMLConfiguration;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RosettaObjectMapperCreatorDiffblueTest {
  /**
   * Test {@link RosettaObjectMapperCreator#forJSON()}.
   *
   * <p>Method under test: {@link RosettaObjectMapperCreator#forJSON()}
   */
  @Test
  @DisplayName("Test forJSON()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RosettaObjectMapperCreator RosettaObjectMapperCreator.forJSON()"})
  void testForJSON() {
    // Arrange and Act
    ObjectMapper actualCreateResult = RosettaObjectMapperCreator.forJSON().create();

    // Assert
    JsonFactory factory = actualCreateResult.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    assertTrue(
        actualCreateResult.getDeserializationContext()
            instanceof DefaultDeserializationContext.Impl);
    assertTrue(actualCreateResult.getVisibilityChecker() instanceof Std);
    assertTrue(
        actualCreateResult.getPolymorphicTypeValidator() instanceof LaissezFaireSubTypeValidator);
    assertTrue(actualCreateResult.getSubtypeResolver() instanceof StdSubtypeResolver);
    assertTrue(actualCreateResult.getSerializerFactory() instanceof BeanSerializerFactory);
    assertTrue(actualCreateResult.getSerializerProvider() instanceof Impl);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
    assertTrue(actualCreateResult.getDateFormat() instanceof StdDateFormat);
    assertNull(actualCreateResult.getInjectableValues());
    assertNull(actualCreateResult.getPropertyNamingStrategy());
    assertEquals(7, actualCreateResult.getRegisteredModuleIds().size());
    assertSame(factory, actualCreateResult.getJsonFactory());
  }

  /**
   * Test {@link RosettaObjectMapperCreator#forXML()}.
   *
   * <p>Method under test: {@link RosettaObjectMapperCreator#forXML()}
   */
  @Test
  @DisplayName("Test forXML()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RosettaObjectMapperCreator RosettaObjectMapperCreator.forXML()"})
  void testForXML() {
    // Arrange and Act
    ObjectMapper actualCreateResult = RosettaObjectMapperCreator.forXML().create();

    // Assert
    assertTrue(actualCreateResult.getVisibilityChecker() instanceof Std);
    assertTrue(
        actualCreateResult.getPolymorphicTypeValidator() instanceof LaissezFaireSubTypeValidator);
    assertTrue(actualCreateResult.getSubtypeResolver() instanceof StdSubtypeResolver);
    assertTrue(actualCreateResult.getDateFormat() instanceof StdDateFormat);
    assertTrue(actualCreateResult instanceof XmlMapper);
    assertTrue(actualCreateResult.getDeserializationContext() instanceof XmlDeserializationContext);
    assertTrue(actualCreateResult.getSerializerProvider() instanceof XmlSerializerProvider);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof XmlSerializerProvider);
    assertTrue(actualCreateResult.getSerializerFactory() instanceof RosettaSerialiserFactory);
    assertNull(actualCreateResult.getInjectableValues());
    assertNull(actualCreateResult.getPropertyNamingStrategy());
    assertEquals(7, actualCreateResult.getRegisteredModuleIds().size());
  }

  /**
   * Test {@link RosettaObjectMapperCreator#forXML(RosettaXMLConfiguration)} with {@code config}.
   *
   * <p>Method under test: {@link RosettaObjectMapperCreator#forXML(RosettaXMLConfiguration)}
   */
  @Test
  @DisplayName("Test forXML(RosettaXMLConfiguration) with 'config'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RosettaObjectMapperCreator RosettaObjectMapperCreator.forXML(RosettaXMLConfiguration)"
  })
  void testForXMLWithConfig() {
    // Arrange and Act
    ObjectMapper actualCreateResult =
        RosettaObjectMapperCreator.forXML(new RosettaXMLConfiguration(new HashMap<>())).create();

    // Assert
    assertTrue(actualCreateResult.getVisibilityChecker() instanceof Std);
    assertTrue(
        actualCreateResult.getPolymorphicTypeValidator() instanceof LaissezFaireSubTypeValidator);
    assertTrue(actualCreateResult.getSubtypeResolver() instanceof StdSubtypeResolver);
    assertTrue(actualCreateResult.getDateFormat() instanceof StdDateFormat);
    assertTrue(actualCreateResult instanceof XmlMapper);
    assertTrue(actualCreateResult.getDeserializationContext() instanceof XmlDeserializationContext);
    assertTrue(actualCreateResult.getSerializerProvider() instanceof XmlSerializerProvider);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof XmlSerializerProvider);
    assertTrue(actualCreateResult.getSerializerFactory() instanceof RosettaSerialiserFactory);
    assertNull(actualCreateResult.getInjectableValues());
    assertNull(actualCreateResult.getPropertyNamingStrategy());
    assertEquals(7, actualCreateResult.getRegisteredModuleIds().size());
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   *
   * <p>Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @DisplayName("Test create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  void testCreate() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    JsonMapper baseMapper = JsonMapper.builder().findAndAddModules().build();

    RosettaObjectMapperCreator rosettaObjectMapperCreator =
        new RosettaObjectMapperCreator(rosettaModule, baseMapper);

    // Act
    ObjectMapper actualCreateResult = rosettaObjectMapperCreator.create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   *
   * <p>Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @DisplayName("Test create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  void testCreate2() {
    // Arrange
    JacksonXmlModule rosettaModule = new JacksonXmlModule();
    JsonMapper baseMapper = JsonMapper.builder().findAndAddModules().build();

    RosettaObjectMapperCreator rosettaObjectMapperCreator =
        new RosettaObjectMapperCreator(rosettaModule, baseMapper);

    // Act
    ObjectMapper actualCreateResult = rosettaObjectMapperCreator.create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   *
   * <p>Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @DisplayName("Test create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  void testCreate3() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    rosettaModule.setDeserializerModifier(new RosettaBeanDeserializerModifier());
    Class<Object> beanType = Object.class;
    rosettaModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    JsonMapper baseMapper = JsonMapper.builder().findAndAddModules().build();

    RosettaObjectMapperCreator rosettaObjectMapperCreator =
        new RosettaObjectMapperCreator(rosettaModule, baseMapper);

    // Act
    ObjectMapper actualCreateResult = rosettaObjectMapperCreator.create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   *
   * <ul>
   *   <li>Given array of {@link Class} with {@link Object}.
   *   <li>Then return {@link JsonMapper}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @DisplayName("Test create(); given array of Class with Object; then return JsonMapper")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  void testCreate_givenArrayOfClassWithObject_thenReturnJsonMapper() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    Class<Object> forNameResult = Object.class;
    rosettaModule.registerSubtypes(forNameResult);
    Class<Object> beanType = Object.class;
    rosettaModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    JsonMapper baseMapper = JsonMapper.builder().findAndAddModules().build();

    RosettaObjectMapperCreator rosettaObjectMapperCreator =
        new RosettaObjectMapperCreator(rosettaModule, baseMapper);

    // Act
    ObjectMapper actualCreateResult = rosettaObjectMapperCreator.create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   *
   * <ul>
   *   <li>Given forJSON.
   *   <li>Then Factory return {@link MappingJsonFactory}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @DisplayName("Test create(); given forJSON; then Factory return MappingJsonFactory")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  void testCreate_givenForJSON_thenFactoryReturnMappingJsonFactory() {
    // Arrange and Act
    ObjectMapper actualCreateResult = RosettaObjectMapperCreator.forJSON().create();

    // Assert
    JsonFactory factory = actualCreateResult.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
    assertSame(factory, actualCreateResult.getJsonFactory());
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return {@link JsonMapper}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @DisplayName("Test create(); given 'java.lang.Object'; then return JsonMapper")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  void testCreate_givenJavaLangObject_thenReturnJsonMapper() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    Class<Object> beanType = Object.class;
    rosettaModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    JsonMapper baseMapper = JsonMapper.builder().findAndAddModules().build();

    RosettaObjectMapperCreator rosettaObjectMapperCreator =
        new RosettaObjectMapperCreator(rosettaModule, baseMapper);

    // Act
    ObjectMapper actualCreateResult = rosettaObjectMapperCreator.create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   *
   * <ul>
   *   <li>Given {@link SimpleModule#SimpleModule()} KeySerializers is {@link
   *       SimpleSerializers#SimpleSerializers()}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @DisplayName("Test create(); given SimpleModule() KeySerializers is SimpleSerializers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  void testCreate_givenSimpleModuleKeySerializersIsSimpleSerializers() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    rosettaModule.setKeySerializers(new SimpleSerializers());
    Class<Object> beanType = Object.class;
    rosettaModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    JsonMapper baseMapper = JsonMapper.builder().findAndAddModules().build();

    RosettaObjectMapperCreator rosettaObjectMapperCreator =
        new RosettaObjectMapperCreator(rosettaModule, baseMapper);

    // Act
    ObjectMapper actualCreateResult = rosettaObjectMapperCreator.create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   *
   * <ul>
   *   <li>Given {@link SimpleModule#SimpleModule()} MixInAnnotation {@link Object} is {@link
   *       Object}.
   *   <li>Then return {@link JsonMapper}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @DisplayName(
      "Test create(); given SimpleModule() MixInAnnotation Object is Object; then return JsonMapper")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  void testCreate_givenSimpleModuleMixInAnnotationObjectIsObject_thenReturnJsonMapper() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    Class<Object> targetType = Object.class;
    Class<Object> mixinClass = Object.class;

    rosettaModule.setMixInAnnotation(targetType, mixinClass);
    Class<Object> beanType = Object.class;
    rosettaModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    JsonMapper baseMapper = JsonMapper.builder().findAndAddModules().build();

    RosettaObjectMapperCreator rosettaObjectMapperCreator =
        new RosettaObjectMapperCreator(rosettaModule, baseMapper);

    // Act
    ObjectMapper actualCreateResult = rosettaObjectMapperCreator.create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   *
   * <ul>
   *   <li>Given {@link SimpleModule#SimpleModule()} registerSubtypes {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link JsonMapper}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @DisplayName(
      "Test create(); given SimpleModule() registerSubtypes ArrayList(); then return JsonMapper")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  void testCreate_givenSimpleModuleRegisterSubtypesArrayList_thenReturnJsonMapper() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    rosettaModule.registerSubtypes(new ArrayList<>());
    Class<Object> beanType = Object.class;
    rosettaModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    JsonMapper baseMapper = JsonMapper.builder().findAndAddModules().build();

    RosettaObjectMapperCreator rosettaObjectMapperCreator =
        new RosettaObjectMapperCreator(rosettaModule, baseMapper);

    // Act
    ObjectMapper actualCreateResult = rosettaObjectMapperCreator.create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   *
   * <ul>
   *   <li>Given {@link SimpleModule#SimpleModule()} SerializerModifier is {@link
   *       RosettaBeanSerializerModifier} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @DisplayName(
      "Test create(); given SimpleModule() SerializerModifier is RosettaBeanSerializerModifier (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  void testCreate_givenSimpleModuleSerializerModifierIsRosettaBeanSerializerModifier() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    rosettaModule.setSerializerModifier(new RosettaBeanSerializerModifier());
    Class<Object> beanType = Object.class;
    rosettaModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    JsonMapper baseMapper = JsonMapper.builder().findAndAddModules().build();

    RosettaObjectMapperCreator rosettaObjectMapperCreator =
        new RosettaObjectMapperCreator(rosettaModule, baseMapper);

    // Act
    ObjectMapper actualCreateResult = rosettaObjectMapperCreator.create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   *
   * <ul>
   *   <li>Then DeserializationContext return {@link DefaultDeserializationContext.Impl}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @DisplayName("Test create(); then DeserializationContext return Impl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  void testCreate_thenDeserializationContextReturnImpl() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    rosettaModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    Class<Object> beanType = Object.class;
    rosettaModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    JsonMapper baseMapper = JsonMapper.builder().findAndAddModules().build();

    RosettaObjectMapperCreator rosettaObjectMapperCreator =
        new RosettaObjectMapperCreator(rosettaModule, baseMapper);

    // Act
    ObjectMapper actualCreateResult = rosettaObjectMapperCreator.create();

    // Assert
    assertTrue(
        actualCreateResult.getDeserializationContext()
            instanceof DefaultDeserializationContext.Impl);
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   *
   * <ul>
   *   <li>Then return {@link XmlMapper}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @DisplayName("Test create(); then return XmlMapper")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  void testCreate_thenReturnXmlMapper() {
    // Arrange and Act
    ObjectMapper actualCreateResult =
        RosettaObjectMapperCreator.forXML(new RosettaXMLConfiguration(new HashMap<>())).create();

    // Assert
    assertTrue(actualCreateResult instanceof XmlMapper);
    assertTrue(actualCreateResult.getDeserializationContext() instanceof XmlDeserializationContext);
    assertTrue(actualCreateResult.getSerializerProvider() instanceof XmlSerializerProvider);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof XmlSerializerProvider);
    assertTrue(actualCreateResult.getSerializerFactory() instanceof RosettaSerialiserFactory);
  }
}
