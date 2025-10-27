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
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.DatatypeFeatures;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.deser.std.JsonLocationInstantiator;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.datatype.joda.deser.key.DateTimeKeyDeserializer;
import com.regnosys.rosetta.common.serialisation.mixin.RosettaJSONAnnotationIntrospector;
import com.rosetta.util.serialisation.RosettaXMLConfiguration;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.Test;
import org.mockito.Mockito;

public class RosettaXMLModuleDiffblueTest {
  /**
   * Method under test:
   * {@link RosettaXMLModule#RosettaXMLModule(ObjectMapper, RosettaXMLConfiguration, boolean)}
   */
  @Test
  public void testNewRosettaXMLModule() {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();

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
   * Method under test: {@link RosettaXMLModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule() {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();
    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    Module.SetupContext context = mock(Module.SetupContext.class);
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
   * Method under test: {@link RosettaXMLModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule2() {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();
    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        false);
    Module.SetupContext context = mock(Module.SetupContext.class);
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
   * Method under test: {@link RosettaXMLModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule3() {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    rosettaXMLModule.addSerializer(new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
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
   * Method under test: {@link RosettaXMLModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule4() {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
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
   * Method under test: {@link RosettaXMLModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule5() {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    Class<Object> beanType = Object.class;
    rosettaXMLModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
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
   * Method under test: {@link RosettaXMLModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule6() {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    rosettaXMLModule.setDeserializers(new SimpleDeserializers());
    Class<Object> beanType = Object.class;
    rosettaXMLModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
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
   * Method under test: {@link RosettaXMLModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule7() {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    rosettaXMLModule.setKeySerializers(new SimpleSerializers());
    Class<Object> beanType = Object.class;
    rosettaXMLModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
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
   * Method under test: {@link RosettaXMLModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule8() {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    rosettaXMLModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    rosettaXMLModule.setKeySerializers(new SimpleSerializers());
    Class<Object> beanType = Object.class;
    rosettaXMLModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
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
   * Method under test: {@link RosettaXMLModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule9() {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    rosettaXMLModule.setDeserializerModifier(new RosettaBeanDeserializerModifier());
    rosettaXMLModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    rosettaXMLModule.setKeySerializers(new SimpleSerializers());
    Class<Object> beanType = Object.class;
    rosettaXMLModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
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
   * Method under test: {@link RosettaXMLModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule10() {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();

    RosettaXMLModule rosettaXMLModule = new RosettaXMLModule(mapper, new RosettaXMLConfiguration(new HashMap<>()),
        true);
    rosettaXMLModule.setSerializerModifier(new RosettaBeanSerializerModifier());
    rosettaXMLModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    rosettaXMLModule.setKeySerializers(new SimpleSerializers());
    Class<Object> beanType = Object.class;
    rosettaXMLModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaXMLModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
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
   * Method under test: {@link RosettaXMLModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule11() {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();

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
    Module.SetupContext context = mock(Module.SetupContext.class);
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
   * Method under test: {@link RosettaXMLModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule12() {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();

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
    Module.SetupContext context = mock(Module.SetupContext.class);
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

  /**
   * Method under test:
   * {@link RosettaXMLModule#RosettaXMLModule(ObjectMapper, RosettaXMLConfiguration, boolean)}
   */
  @Test
  public void testNewRosettaXMLModule2() {
    // Arrange
    ObjectMapper mapper = new ObjectMapper();
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
    mapper.setConfig(new DeserializationConfig(base, str, mixins, rootNames, configOverrides, new CoercionConfigs(),
        mock(DatatypeFeatures.class)));

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
}
