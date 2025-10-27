package com.regnosys.rosetta.common.serialisation.mixin;

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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.deser.std.JsonLocationInstantiator;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.datatype.joda.deser.key.DateTimeKeyDeserializer;
import com.regnosys.rosetta.common.serialisation.xml.RosettaBeanDeserializerModifier;
import com.regnosys.rosetta.common.serialisation.xml.RosettaBeanSerializerModifier;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

public class RosettaJSONModuleDiffblueTest {
  /**
   * Method under test: {@link RosettaJSONModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    Module.SetupContext context = mock(Module.SetupContext.class);
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaJSONModule.setupModule(context);

    // Assert
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Method under test: {@link RosettaJSONModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule2() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(false);
    Module.SetupContext context = mock(Module.SetupContext.class);
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaJSONModule.setupModule(context);

    // Assert
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Method under test: {@link RosettaJSONModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule3() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    rosettaJSONModule.addSerializer(new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaJSONModule.setupModule(context);

    // Assert
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Method under test: {@link RosettaJSONModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule4() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    Class<Object> type = Object.class;
    rosettaJSONModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    rosettaJSONModule.addSerializer(new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaJSONModule.setupModule(context);

    // Assert
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Method under test: {@link RosettaJSONModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule5() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    Class<Object> beanType = Object.class;
    rosettaJSONModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaJSONModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    rosettaJSONModule.addSerializer(new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaJSONModule.setupModule(context);

    // Assert
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).addValueInstantiators(isA(ValueInstantiators.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Method under test: {@link RosettaJSONModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule6() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    rosettaJSONModule.setDeserializers(new SimpleDeserializers());
    Class<Object> beanType = Object.class;
    rosettaJSONModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaJSONModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    rosettaJSONModule.addSerializer(new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaJSONModule.setupModule(context);

    // Assert
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).addValueInstantiators(isA(ValueInstantiators.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Method under test: {@link RosettaJSONModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule7() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    rosettaJSONModule.setKeySerializers(new SimpleSerializers());
    rosettaJSONModule.setDeserializers(new SimpleDeserializers());
    Class<Object> beanType = Object.class;
    rosettaJSONModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaJSONModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    rosettaJSONModule.addSerializer(new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
    doNothing().when(context).addKeySerializers(Mockito.<Serializers>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaJSONModule.setupModule(context);

    // Assert
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addKeySerializers(isA(Serializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).addValueInstantiators(isA(ValueInstantiators.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Method under test: {@link RosettaJSONModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule8() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    rosettaJSONModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    rosettaJSONModule.setKeySerializers(new SimpleSerializers());
    rosettaJSONModule.setDeserializers(new SimpleDeserializers());
    Class<Object> beanType = Object.class;
    rosettaJSONModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaJSONModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    rosettaJSONModule.addSerializer(new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
    doNothing().when(context).addAbstractTypeResolver(Mockito.<AbstractTypeResolver>any());
    doNothing().when(context).addKeySerializers(Mockito.<Serializers>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaJSONModule.setupModule(context);

    // Assert
    verify(context).addAbstractTypeResolver(isA(AbstractTypeResolver.class));
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addKeySerializers(isA(Serializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).addValueInstantiators(isA(ValueInstantiators.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Method under test: {@link RosettaJSONModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule9() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    rosettaJSONModule.setDeserializerModifier(new RosettaBeanDeserializerModifier());
    rosettaJSONModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    rosettaJSONModule.setKeySerializers(new SimpleSerializers());
    rosettaJSONModule.setDeserializers(new SimpleDeserializers());
    Class<Object> beanType = Object.class;
    rosettaJSONModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaJSONModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    rosettaJSONModule.addSerializer(new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addAbstractTypeResolver(Mockito.<AbstractTypeResolver>any());
    doNothing().when(context).addKeySerializers(Mockito.<Serializers>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaJSONModule.setupModule(context);

    // Assert
    verify(context).addAbstractTypeResolver(isA(AbstractTypeResolver.class));
    verify(context).addBeanDeserializerModifier(isA(BeanDeserializerModifier.class));
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addKeySerializers(isA(Serializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).addValueInstantiators(isA(ValueInstantiators.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Method under test: {@link RosettaJSONModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule10() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    rosettaJSONModule.setSerializerModifier(new RosettaBeanSerializerModifier());
    rosettaJSONModule.setDeserializerModifier(new RosettaBeanDeserializerModifier());
    rosettaJSONModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    rosettaJSONModule.setKeySerializers(new SimpleSerializers());
    rosettaJSONModule.setDeserializers(new SimpleDeserializers());
    Class<Object> beanType = Object.class;
    rosettaJSONModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaJSONModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    rosettaJSONModule.addSerializer(new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
    doNothing().when(context).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addAbstractTypeResolver(Mockito.<AbstractTypeResolver>any());
    doNothing().when(context).addKeySerializers(Mockito.<Serializers>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaJSONModule.setupModule(context);

    // Assert
    verify(context).addAbstractTypeResolver(isA(AbstractTypeResolver.class));
    verify(context).addBeanDeserializerModifier(isA(BeanDeserializerModifier.class));
    verify(context).addBeanSerializerModifier(isA(BeanSerializerModifier.class));
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addKeySerializers(isA(Serializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).addValueInstantiators(isA(ValueInstantiators.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Method under test: {@link RosettaJSONModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule11() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    Class<Object> forNameResult = Object.class;
    rosettaJSONModule.registerSubtypes(forNameResult);
    rosettaJSONModule.setSerializerModifier(new RosettaBeanSerializerModifier());
    rosettaJSONModule.setDeserializerModifier(new RosettaBeanDeserializerModifier());
    rosettaJSONModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    rosettaJSONModule.setKeySerializers(new SimpleSerializers());
    rosettaJSONModule.setDeserializers(new SimpleDeserializers());
    Class<Object> beanType = Object.class;
    rosettaJSONModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaJSONModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    rosettaJSONModule.addSerializer(new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
    doNothing().when(context).registerSubtypes(isA(NamedType[].class));
    doNothing().when(context).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addAbstractTypeResolver(Mockito.<AbstractTypeResolver>any());
    doNothing().when(context).addKeySerializers(Mockito.<Serializers>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaJSONModule.setupModule(context);

    // Assert
    verify(context).addAbstractTypeResolver(isA(AbstractTypeResolver.class));
    verify(context).addBeanDeserializerModifier(isA(BeanDeserializerModifier.class));
    verify(context).addBeanSerializerModifier(isA(BeanSerializerModifier.class));
    verify(context).addDeserializers(isA(Deserializers.class));
    verify(context).addKeyDeserializers(isA(KeyDeserializers.class));
    verify(context).addKeySerializers(isA(Serializers.class));
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).addValueInstantiators(isA(ValueInstantiators.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
    verify(context).registerSubtypes(isA(NamedType[].class));
  }

  /**
   * Method under test: {@link RosettaJSONModule#setupModule(Module.SetupContext)}
   */
  @Test
  public void testSetupModule12() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    Class<Object> targetType = Object.class;
    Class<Object> mixinClass = Object.class;
    rosettaJSONModule.setMixInAnnotation(targetType, mixinClass);
    Class<Object> forNameResult = Object.class;
    rosettaJSONModule.registerSubtypes(forNameResult);
    rosettaJSONModule.setSerializerModifier(new RosettaBeanSerializerModifier());
    rosettaJSONModule.setDeserializerModifier(new RosettaBeanDeserializerModifier());
    rosettaJSONModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    rosettaJSONModule.setKeySerializers(new SimpleSerializers());
    rosettaJSONModule.setDeserializers(new SimpleDeserializers());
    Class<Object> beanType = Object.class;
    rosettaJSONModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaJSONModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    rosettaJSONModule.addSerializer(new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    Module.SetupContext context = mock(Module.SetupContext.class);
    doNothing().when(context).setMixInAnnotations(Mockito.<Class<Object>>any(), Mockito.<Class<Object>>any());
    doNothing().when(context).registerSubtypes(isA(NamedType[].class));
    doNothing().when(context).addBeanSerializerModifier(Mockito.<BeanSerializerModifier>any());
    doNothing().when(context).addBeanDeserializerModifier(Mockito.<BeanDeserializerModifier>any());
    doNothing().when(context).addAbstractTypeResolver(Mockito.<AbstractTypeResolver>any());
    doNothing().when(context).addKeySerializers(Mockito.<Serializers>any());
    doNothing().when(context).addDeserializers(Mockito.<Deserializers>any());
    doNothing().when(context).addValueInstantiators(Mockito.<ValueInstantiators>any());
    doNothing().when(context).addKeyDeserializers(Mockito.<KeyDeserializers>any());
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaJSONModule.setupModule(context);

    // Assert
    verify(context).addAbstractTypeResolver(isA(AbstractTypeResolver.class));
    verify(context).addBeanDeserializerModifier(isA(BeanDeserializerModifier.class));
    verify(context).addBeanSerializerModifier(isA(BeanSerializerModifier.class));
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
   * Methods under test:
   * <ul>
   *   <li>{@link RosettaJSONModule#equals(Object)}
   *   <li>{@link RosettaJSONModule#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);

    // Act and Assert
    assertEquals(rosettaJSONModule, rosettaJSONModule);
    int expectedHashCodeResult = rosettaJSONModule.hashCode();
    assertEquals(expectedHashCodeResult, rosettaJSONModule.hashCode());
  }

  /**
   * Method under test: {@link RosettaJSONModule#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);

    // Act and Assert
    assertNotEquals(rosettaJSONModule, new RosettaJSONModule(true));
  }

  /**
   * Method under test: {@link RosettaJSONModule#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RosettaJSONModule(true), null);
  }

  /**
   * Method under test: {@link RosettaJSONModule#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RosettaJSONModule(true), "Different type to RosettaJSONModule");
  }

  /**
   * Method under test: {@link RosettaJSONModule#RosettaJSONModule(boolean)}
   */
  @Test
  public void testNewRosettaJSONModule() {
    // Arrange and Act
    RosettaJSONModule actualRosettaJSONModule = new RosettaJSONModule(true);

    // Assert
    Iterable<? extends Module> dependencies = actualRosettaJSONModule.getDependencies();
    assertTrue(dependencies instanceof List);
    Version versionResult = actualRosettaJSONModule.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-core/2.17.1", versionResult.toFullString());
    assertEquals("jackson-core", versionResult.getArtifactId());
    assertEquals("jackson-core", actualRosettaJSONModule.getModuleName());
    assertEquals("jackson-core", actualRosettaJSONModule.getTypeId());
    assertEquals(1, versionResult.getPatchLevel());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertTrue(((List<? extends Module>) dependencies).isEmpty());
  }
}
