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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import com.regnosys.rosetta.common.serialisation.mixin.RosettaDateModule;
import com.regnosys.rosetta.common.serialisation.xml.RosettaBeanDeserializerModifier;
import com.regnosys.rosetta.common.serialisation.xml.RosettaBeanSerializerModifier;
import com.regnosys.rosetta.common.serialisation.xml.RosettaSerialiserFactory;
import com.rosetta.util.serialisation.RosettaXMLConfiguration;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RosettaObjectMapperCreatorDiffblueTest {
  /**
   * Test {@link RosettaObjectMapperCreator#forJSON()}.
   * <p>
   * Method under test: {@link RosettaObjectMapperCreator#forJSON()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RosettaObjectMapperCreator RosettaObjectMapperCreator.forJSON()"})
  public void testForJSON() {
    // Arrange and Act
    ObjectMapper actualCreateResult = RosettaObjectMapperCreator.forJSON().create();

    // Assert
    JsonFactory factory = actualCreateResult.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    assertTrue(actualCreateResult.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
    assertTrue(actualCreateResult.getVisibilityChecker() instanceof Std);
    assertTrue(actualCreateResult.getPolymorphicTypeValidator() instanceof LaissezFaireSubTypeValidator);
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
   * <p>
   * Method under test: {@link RosettaObjectMapperCreator#forXML()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RosettaObjectMapperCreator RosettaObjectMapperCreator.forXML()"})
  public void testForXML() {
    // Arrange and Act
    ObjectMapper actualCreateResult = RosettaObjectMapperCreator.forXML().create();

    // Assert
    assertTrue(actualCreateResult.getVisibilityChecker() instanceof Std);
    assertTrue(actualCreateResult.getPolymorphicTypeValidator() instanceof LaissezFaireSubTypeValidator);
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
   * <p>
   * Method under test: {@link RosettaObjectMapperCreator#forXML(RosettaXMLConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RosettaObjectMapperCreator RosettaObjectMapperCreator.forXML(RosettaXMLConfiguration)"})
  public void testForXMLWithConfig() {
    // Arrange and Act
    ObjectMapper actualCreateResult = RosettaObjectMapperCreator.forXML(new RosettaXMLConfiguration(new HashMap<>()))
        .create();

    // Assert
    assertTrue(actualCreateResult.getVisibilityChecker() instanceof Std);
    assertTrue(actualCreateResult.getPolymorphicTypeValidator() instanceof LaissezFaireSubTypeValidator);
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
   * <p>
   * Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  public void testCreate() {
    // Arrange
    RosettaDateModule rosettaModule = new RosettaDateModule();

    // Act
    ObjectMapper actualCreateResult = (new RosettaObjectMapperCreator(rosettaModule,
        JsonMapper.builder().findAndAddModules().build())).create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   * <p>
   * Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  public void testCreate2() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();

    // Act
    ObjectMapper actualCreateResult = (new RosettaObjectMapperCreator(rosettaModule,
        JsonMapper.builder().findAndAddModules().build())).create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   * <p>
   * Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  public void testCreate3() {
    // Arrange
    JacksonXmlModule rosettaModule = new JacksonXmlModule();

    // Act
    ObjectMapper actualCreateResult = (new RosettaObjectMapperCreator(rosettaModule,
        JsonMapper.builder().findAndAddModules().build())).create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   * <p>
   * Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  public void testCreate4() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    rosettaModule.setDeserializerModifier(new RosettaBeanDeserializerModifier());
    Class<Object> beanType = Object.class;
    rosettaModule.addValueInstantiator(beanType, new JsonLocationInstantiator());

    // Act
    ObjectMapper actualCreateResult = (new RosettaObjectMapperCreator(rosettaModule,
        JsonMapper.builder().findAndAddModules().build())).create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   * <ul>
   *   <li>Given array of {@link Class} with {@link Object}.</li>
   *   <li>Then return {@link JsonMapper}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  public void testCreate_givenArrayOfClassWithObject_thenReturnJsonMapper() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    Class<Object> forNameResult = Object.class;
    rosettaModule.registerSubtypes(forNameResult);
    Class<Object> beanType = Object.class;
    rosettaModule.addValueInstantiator(beanType, new JsonLocationInstantiator());

    // Act
    ObjectMapper actualCreateResult = (new RosettaObjectMapperCreator(rosettaModule,
        JsonMapper.builder().findAndAddModules().build())).create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   * <ul>
   *   <li>Given forJSON.</li>
   *   <li>Then Factory return {@link MappingJsonFactory}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  public void testCreate_givenForJSON_thenFactoryReturnMappingJsonFactory() {
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
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then return {@link JsonMapper}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  public void testCreate_givenJavaLangObject_thenReturnJsonMapper() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    Class<Object> beanType = Object.class;
    rosettaModule.addValueInstantiator(beanType, new JsonLocationInstantiator());

    // Act
    ObjectMapper actualCreateResult = (new RosettaObjectMapperCreator(rosettaModule,
        JsonMapper.builder().findAndAddModules().build())).create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   * <ul>
   *   <li>Given {@link SimpleModule#SimpleModule()} KeySerializers is {@link SimpleSerializers#SimpleSerializers()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  public void testCreate_givenSimpleModuleKeySerializersIsSimpleSerializers() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    rosettaModule.setKeySerializers(new SimpleSerializers());
    Class<Object> beanType = Object.class;
    rosettaModule.addValueInstantiator(beanType, new JsonLocationInstantiator());

    // Act
    ObjectMapper actualCreateResult = (new RosettaObjectMapperCreator(rosettaModule,
        JsonMapper.builder().findAndAddModules().build())).create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   * <ul>
   *   <li>Given {@link SimpleModule#SimpleModule()} MixInAnnotation {@link Object} is {@link Object}.</li>
   *   <li>Then return {@link JsonMapper}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  public void testCreate_givenSimpleModuleMixInAnnotationObjectIsObject_thenReturnJsonMapper() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    Class<Object> targetType = Object.class;
    Class<Object> mixinClass = Object.class;
    rosettaModule.setMixInAnnotation(targetType, mixinClass);
    Class<Object> beanType = Object.class;
    rosettaModule.addValueInstantiator(beanType, new JsonLocationInstantiator());

    // Act
    ObjectMapper actualCreateResult = (new RosettaObjectMapperCreator(rosettaModule,
        JsonMapper.builder().findAndAddModules().build())).create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   * <ul>
   *   <li>Given {@link SimpleModule#SimpleModule()} registerSubtypes {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link JsonMapper}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  public void testCreate_givenSimpleModuleRegisterSubtypesArrayList_thenReturnJsonMapper() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    rosettaModule.registerSubtypes(new ArrayList<>());
    Class<Object> beanType = Object.class;
    rosettaModule.addValueInstantiator(beanType, new JsonLocationInstantiator());

    // Act
    ObjectMapper actualCreateResult = (new RosettaObjectMapperCreator(rosettaModule,
        JsonMapper.builder().findAndAddModules().build())).create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   * <ul>
   *   <li>Given {@link SimpleModule#SimpleModule()} SerializerModifier is {@link RosettaBeanSerializerModifier} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  public void testCreate_givenSimpleModuleSerializerModifierIsRosettaBeanSerializerModifier() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    rosettaModule.setSerializerModifier(new RosettaBeanSerializerModifier());
    Class<Object> beanType = Object.class;
    rosettaModule.addValueInstantiator(beanType, new JsonLocationInstantiator());

    // Act
    ObjectMapper actualCreateResult = (new RosettaObjectMapperCreator(rosettaModule,
        JsonMapper.builder().findAndAddModules().build())).create();

    // Assert
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   * <ul>
   *   <li>Then DeserializationContext return {@link DefaultDeserializationContext.Impl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  public void testCreate_thenDeserializationContextReturnImpl() {
    // Arrange
    SimpleModule rosettaModule = new SimpleModule();
    rosettaModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    Class<Object> beanType = Object.class;
    rosettaModule.addValueInstantiator(beanType, new JsonLocationInstantiator());

    // Act
    ObjectMapper actualCreateResult = (new RosettaObjectMapperCreator(rosettaModule,
        JsonMapper.builder().findAndAddModules().build())).create();

    // Assert
    assertTrue(actualCreateResult.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
    assertTrue(actualCreateResult instanceof JsonMapper);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof Impl);
  }

  /**
   * Test {@link RosettaObjectMapperCreator#create()}.
   * <ul>
   *   <li>Then return {@link XmlMapper}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaObjectMapperCreator#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapperCreator.create()"})
  public void testCreate_thenReturnXmlMapper() {
    // Arrange and Act
    ObjectMapper actualCreateResult = RosettaObjectMapperCreator.forXML(new RosettaXMLConfiguration(new HashMap<>()))
        .create();

    // Assert
    assertTrue(actualCreateResult instanceof XmlMapper);
    assertTrue(actualCreateResult.getDeserializationContext() instanceof XmlDeserializationContext);
    assertTrue(actualCreateResult.getSerializerProvider() instanceof XmlSerializerProvider);
    assertTrue(actualCreateResult.getSerializerProviderInstance() instanceof XmlSerializerProvider);
    assertTrue(actualCreateResult.getSerializerFactory() instanceof RosettaSerialiserFactory);
  }
}
