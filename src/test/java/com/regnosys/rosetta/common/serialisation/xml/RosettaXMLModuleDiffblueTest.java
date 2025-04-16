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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.Module.SetupContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.deser.std.JsonLocationInstantiator;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers.XMLGregorianCalendarSerializer;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.datatype.joda.deser.key.DateTimeKeyDeserializer;
import com.rosetta.util.serialisation.RosettaXMLConfiguration;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class RosettaXMLModuleDiffblueTest {
  /**
   * Test {@link RosettaXMLModule#RosettaXMLModule(ObjectMapper, RosettaXMLConfiguration, boolean)}.
   * <p>
   * Method under test: {@link RosettaXMLModule#RosettaXMLModule(ObjectMapper, RosettaXMLConfiguration, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaXMLModule.<init>(ObjectMapper, RosettaXMLConfiguration, boolean)"})
  public void testNewRosettaXMLModule() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    RosettaXMLModule actualRosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);

    // Assert
    Iterable<? extends Module> dependencies = actualRosettaXMLModule.getDependencies();
    assertTrue(dependencies instanceof List);
    Version versionResult = actualRosettaXMLModule.version();
    assertEquals("", versionResult.getArtifactId());
    assertEquals("", versionResult.getGroupId());
    assertEquals("//0.0.0", versionResult.toFullString());
    assertEquals("RosettaXMLModule", actualRosettaXMLModule.getModuleName());
    assertEquals("RosettaXMLModule", actualRosettaXMLModule.getTypeId());
    assertEquals(0, versionResult.getMajorVersion());
    assertEquals(0, versionResult.getMinorVersion());
    assertEquals(0, versionResult.getPatchLevel());
    assertFalse(versionResult.isSnapshot());
    assertTrue(versionResult.isUknownVersion());
    assertTrue(versionResult.isUnknownVersion());
    assertTrue(((List<? extends Module>) dependencies).isEmpty());
  }

  /**
   * Test {@link RosettaXMLModule#setupModule(SetupContext)}.
   * <p>
   * Method under test: {@link RosettaXMLModule#setupModule(SetupContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaXMLModule.setupModule(SetupContext)"})
  public void testSetupModule() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaXMLModule.setupModule(context);

    // Assert
    verify(context, atLeast(1)).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    verify(context, atLeast(1)).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Test {@link RosettaXMLModule#setupModule(SetupContext)}.
   * <p>
   * Method under test: {@link RosettaXMLModule#setupModule(SetupContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaXMLModule.setupModule(SetupContext)"})
  public void testSetupModule2() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();
    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        false);
    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaXMLModule.setupModule(context);

    // Assert
    verify(context, atLeast(1)).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    verify(context, atLeast(1)).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Test {@link RosettaXMLModule#setupModule(SetupContext)}.
   * <p>
   * Method under test: {@link RosettaXMLModule#setupModule(SetupContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaXMLModule.setupModule(SetupContext)"})
  public void testSetupModule3() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    rosettaXMLModule.addSerializer(new XMLGregorianCalendarSerializer());
    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaXMLModule.setupModule(context);

    // Assert
    verify(context, atLeast(1)).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    verify(context, atLeast(1)).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Test {@link RosettaXMLModule#setupModule(SetupContext)}.
   * <p>
   * Method under test: {@link RosettaXMLModule#setupModule(SetupContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaXMLModule.setupModule(SetupContext)"})
  public void testSetupModule4() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    rosettaXMLModule.setDeserializers(new SimpleDeserializers());
    Class<Object> beanType = Object.class;
    rosettaXMLModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaXMLModule.setupModule(context);

    // Assert
    verify(context, atLeast(1)).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    verify(context, atLeast(1)).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).addValueInstantiators(isA(ValueInstantiators.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Test {@link RosettaXMLModule#setupModule(SetupContext)}.
   * <p>
   * Method under test: {@link RosettaXMLModule#setupModule(SetupContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaXMLModule.setupModule(SetupContext)"})
  public void testSetupModule5() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    rosettaXMLModule.setDeserializerModifier(new RosettaBeanDeserializerModifier());
    rosettaXMLModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    rosettaXMLModule.setKeySerializers(new SimpleSerializers());
    Class<Object> beanType = Object.class;
    rosettaXMLModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).addAbstractTypeResolver(Mockito.<AbstractTypeResolver>any());
    doNothing().when(context).addKeySerializers(Mockito.<Serializers>any());
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaXMLModule.setupModule(context);

    // Assert
    verify(context).addAbstractTypeResolver(isA(AbstractTypeResolver.class));
    verify(context, atLeast(1)).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    verify(context, atLeast(1)).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addKeySerializers(isA(Serializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).addValueInstantiators(isA(ValueInstantiators.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Test {@link RosettaXMLModule#setupModule(SetupContext)}.
   * <p>
   * Method under test: {@link RosettaXMLModule#setupModule(SetupContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaXMLModule.setupModule(SetupContext)"})
  public void testSetupModule6() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    rosettaXMLModule.setSerializerModifier(new RosettaBeanSerializerModifier());
    rosettaXMLModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    rosettaXMLModule.setKeySerializers(new SimpleSerializers());
    Class<Object> beanType = Object.class;
    rosettaXMLModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).addAbstractTypeResolver(Mockito.<AbstractTypeResolver>any());
    doNothing().when(context).addKeySerializers(Mockito.<Serializers>any());
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaXMLModule.setupModule(context);

    // Assert
    verify(context).addAbstractTypeResolver(isA(AbstractTypeResolver.class));
    verify(context, atLeast(1)).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    verify(context, atLeast(1)).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addKeySerializers(isA(Serializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).addValueInstantiators(isA(ValueInstantiators.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Test {@link RosettaXMLModule#setupModule(SetupContext)}.
   * <p>
   * Method under test: {@link RosettaXMLModule#setupModule(SetupContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaXMLModule.setupModule(SetupContext)"})
  public void testSetupModule7() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    rosettaXMLModule.registerSubtypes(new Class[]{});
    rosettaXMLModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    rosettaXMLModule.setKeySerializers(new SimpleSerializers());
    Class<Object> beanType = Object.class;
    rosettaXMLModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).addAbstractTypeResolver(Mockito.<AbstractTypeResolver>any());
    doNothing().when(context).addKeySerializers(Mockito.<Serializers>any());
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaXMLModule.setupModule(context);

    // Assert
    verify(context).addAbstractTypeResolver(isA(AbstractTypeResolver.class));
    verify(context, atLeast(1)).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    verify(context, atLeast(1)).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addKeySerializers(isA(Serializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).addValueInstantiators(isA(ValueInstantiators.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Test {@link RosettaXMLModule#setupModule(SetupContext)}.
   * <ul>
   *   <li>Given array of {@link Class} with {@link Object}.</li>
   *   <li>Then calls {@link SetupContext#registerSubtypes(NamedType[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLModule#setupModule(SetupContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaXMLModule.setupModule(SetupContext)"})
  public void testSetupModule_givenArrayOfClassWithObject_thenCallsRegisterSubtypes() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    Class<Object> forNameResult = Object.class;
    rosettaXMLModule.registerSubtypes(forNameResult);
    rosettaXMLModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    rosettaXMLModule.setKeySerializers(new SimpleSerializers());
    Class<Object> beanType = Object.class;
    rosettaXMLModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).registerSubtypes(isA(NamedType[].class));
    doNothing().when(context).addAbstractTypeResolver(Mockito.<AbstractTypeResolver>any());
    doNothing().when(context).addKeySerializers(Mockito.<Serializers>any());
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaXMLModule.setupModule(context);

    // Assert
    verify(context).addAbstractTypeResolver(isA(AbstractTypeResolver.class));
    verify(context, atLeast(1)).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    verify(context, atLeast(1)).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addKeySerializers(isA(Serializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).addValueInstantiators(isA(ValueInstantiators.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
    verify(context).registerSubtypes(isA(NamedType[].class));
  }

  /**
   * Test {@link RosettaXMLModule#setupModule(SetupContext)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then calls {@link SetupContext#addKeyDeserializers(KeyDeserializers)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLModule#setupModule(SetupContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaXMLModule.setupModule(SetupContext)"})
  public void testSetupModule_givenJavaLangObject_thenCallsAddKeyDeserializers() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaXMLModule.setupModule(context);

    // Assert
    verify(context, atLeast(1)).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    verify(context, atLeast(1)).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Test {@link RosettaXMLModule#setupModule(SetupContext)}.
   * <ul>
   *   <li>Then calls {@link SetupContext#addAbstractTypeResolver(AbstractTypeResolver)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLModule#setupModule(SetupContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaXMLModule.setupModule(SetupContext)"})
  public void testSetupModule_thenCallsAddAbstractTypeResolver() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    rosettaXMLModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    rosettaXMLModule.setKeySerializers(new SimpleSerializers());
    Class<Object> beanType = Object.class;
    rosettaXMLModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).addAbstractTypeResolver(Mockito.<AbstractTypeResolver>any());
    doNothing().when(context).addKeySerializers(Mockito.<Serializers>any());
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaXMLModule.setupModule(context);

    // Assert
    verify(context).addAbstractTypeResolver(isA(AbstractTypeResolver.class));
    verify(context, atLeast(1)).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    verify(context, atLeast(1)).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addKeySerializers(isA(Serializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).addValueInstantiators(isA(ValueInstantiators.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Test {@link RosettaXMLModule#setupModule(SetupContext)}.
   * <ul>
   *   <li>Then calls {@link SetupContext#addKeySerializers(Serializers)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLModule#setupModule(SetupContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaXMLModule.setupModule(SetupContext)"})
  public void testSetupModule_thenCallsAddKeySerializers() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    rosettaXMLModule.setKeySerializers(new SimpleSerializers());
    Class<Object> beanType = Object.class;
    rosettaXMLModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).addKeySerializers(Mockito.<Serializers>any());
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaXMLModule.setupModule(context);

    // Assert
    verify(context, atLeast(1)).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    verify(context, atLeast(1)).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addKeySerializers(isA(Serializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).addValueInstantiators(isA(ValueInstantiators.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Test {@link RosettaXMLModule#setupModule(SetupContext)}.
   * <ul>
   *   <li>Then calls {@link SetupContext#addValueInstantiators(ValueInstantiators)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLModule#setupModule(SetupContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaXMLModule.setupModule(SetupContext)"})
  public void testSetupModule_thenCallsAddValueInstantiators() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    Class<Object> beanType = Object.class;
    rosettaXMLModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaXMLModule.setupModule(context);

    // Assert
    verify(context, atLeast(1)).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    verify(context, atLeast(1)).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).addValueInstantiators(isA(ValueInstantiators.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Test {@link RosettaXMLModule#setupModule(SetupContext)}.
   * <ul>
   *   <li>Then calls {@link SetupContext#setMixInAnnotations(Class, Class)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaXMLModule#setupModule(SetupContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaXMLModule.setupModule(SetupContext)"})
  public void testSetupModule_thenCallsSetMixInAnnotations() {
    // Arrange
    JsonMapper mapper = JsonMapper.builder().findAndAddModules().build();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    Class<Object> targetType = Object.class;
    Class<Object> mixinClass = Object.class;
    rosettaXMLModule.setMixInAnnotation(targetType, mixinClass);
    Class<Object> forNameResult = Object.class;
    rosettaXMLModule.registerSubtypes(forNameResult);
    rosettaXMLModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    rosettaXMLModule.setKeySerializers(new SimpleSerializers());
    Class<Object> beanType = Object.class;
    rosettaXMLModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).setMixInAnnotations(Mockito.<Class<Object>>any(), Mockito.<Class<Object>>any());
    doNothing().when(context).registerSubtypes(isA(NamedType[].class));
    doNothing().when(context).addAbstractTypeResolver(Mockito.<AbstractTypeResolver>any());
    doNothing().when(context).addKeySerializers(Mockito.<Serializers>any());
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaXMLModule.setupModule(context);

    // Assert
    verify(context).addAbstractTypeResolver(isA(AbstractTypeResolver.class));
    verify(context, atLeast(1)).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    verify(context, atLeast(1)).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addKeySerializers(isA(Serializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).addValueInstantiators(isA(ValueInstantiators.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
    verify(context).registerSubtypes(isA(NamedType[].class));
    verify(context).setMixInAnnotations(isA(Class.class), isA(Class.class));
  }
}
