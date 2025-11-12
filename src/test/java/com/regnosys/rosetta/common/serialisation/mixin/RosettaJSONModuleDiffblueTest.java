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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.Module.SetupContext;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.deser.std.JsonLocationInstantiator;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers;
import com.fasterxml.jackson.databind.ext.CoreXMLSerializers.XMLGregorianCalendarSerializer;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RosettaJSONModuleDiffblueTest {
  /**
   * Test {@link RosettaJSONModule#RosettaJSONModule(boolean)}.
   *
   * <p>Method under test: {@link RosettaJSONModule#RosettaJSONModule(boolean)}
   */
  @Test
  @DisplayName("Test new RosettaJSONModule(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaJSONModule.<init>(boolean)"})
  void testNewRosettaJSONModule() {
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

  /**
   * Test {@link RosettaJSONModule#setupModule(SetupContext)}.
   *
   * <p>Method under test: {@link RosettaJSONModule#setupModule(SetupContext)}
   */
  @Test
  @DisplayName("Test setupModule(SetupContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaJSONModule.setupModule(SetupContext)"})
  void testSetupModule() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    rosettaJSONModule.registerSubtypes(new Class[] {});
    rosettaJSONModule.setSerializerModifier(new RosettaBeanSerializerModifier());
    rosettaJSONModule.setDeserializerModifier(new RosettaBeanDeserializerModifier());
    rosettaJSONModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    rosettaJSONModule.setKeySerializers(new SimpleSerializers());
    rosettaJSONModule.setDeserializers(new SimpleDeserializers());
    Class<Object> beanType = Object.class;
    rosettaJSONModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaJSONModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    rosettaJSONModule.addSerializer(new XMLGregorianCalendarSerializer());

    SetupContext context = mock(SetupContext.class);
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
   * Test {@link RosettaJSONModule#setupModule(SetupContext)}.
   *
   * <ul>
   *   <li>Given array of {@link Class} with {@link Object}.
   *   <li>Then calls {@link SetupContext#registerSubtypes(NamedType[])}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONModule#setupModule(SetupContext)}
   */
  @Test
  @DisplayName(
      "Test setupModule(SetupContext); given array of Class with Object; then calls registerSubtypes(NamedType[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaJSONModule.setupModule(SetupContext)"})
  void testSetupModule_givenArrayOfClassWithObject_thenCallsRegisterSubtypes() {
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
    rosettaJSONModule.addSerializer(new XMLGregorianCalendarSerializer());

    SetupContext context = mock(SetupContext.class);
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
   * Test {@link RosettaJSONModule#setupModule(SetupContext)}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then calls {@link SetupContext#addKeyDeserializers(KeyDeserializers)}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONModule#setupModule(SetupContext)}
   */
  @Test
  @DisplayName(
      "Test setupModule(SetupContext); given 'java.lang.Object'; then calls addKeyDeserializers(KeyDeserializers)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaJSONModule.setupModule(SetupContext)"})
  void testSetupModule_givenJavaLangObject_thenCallsAddKeyDeserializers() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    Class<Object> type = Object.class;
    rosettaJSONModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    rosettaJSONModule.addSerializer(new XMLGregorianCalendarSerializer());

    SetupContext context = mock(SetupContext.class);
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
   * Test {@link RosettaJSONModule#setupModule(SetupContext)}.
   *
   * <ul>
   *   <li>Given {@link RosettaJSONModule#RosettaJSONModule(boolean)} with supportRosettaEnumValue
   *       is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONModule#setupModule(SetupContext)}
   */
  @Test
  @DisplayName(
      "Test setupModule(SetupContext); given RosettaJSONModule(boolean) with supportRosettaEnumValue is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaJSONModule.setupModule(SetupContext)"})
  void testSetupModule_givenRosettaJSONModuleWithSupportRosettaEnumValueIsFalse() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(false);

    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaJSONModule.setupModule(context);

    // Assert
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Test {@link RosettaJSONModule#setupModule(SetupContext)}.
   *
   * <ul>
   *   <li>Given {@link RosettaJSONModule#RosettaJSONModule(boolean)} with supportRosettaEnumValue
   *       is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONModule#setupModule(SetupContext)}
   */
  @Test
  @DisplayName(
      "Test setupModule(SetupContext); given RosettaJSONModule(boolean) with supportRosettaEnumValue is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaJSONModule.setupModule(SetupContext)"})
  void testSetupModule_givenRosettaJSONModuleWithSupportRosettaEnumValueIsTrue() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);

    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaJSONModule.setupModule(context);

    // Assert
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Test {@link RosettaJSONModule#setupModule(SetupContext)}.
   *
   * <ul>
   *   <li>Then calls {@link SetupContext#addAbstractTypeResolver(AbstractTypeResolver)}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONModule#setupModule(SetupContext)}
   */
  @Test
  @DisplayName(
      "Test setupModule(SetupContext); then calls addAbstractTypeResolver(AbstractTypeResolver)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaJSONModule.setupModule(SetupContext)"})
  void testSetupModule_thenCallsAddAbstractTypeResolver() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    rosettaJSONModule.setAbstractTypes(new SimpleAbstractTypeResolver());
    rosettaJSONModule.setKeySerializers(new SimpleSerializers());
    rosettaJSONModule.setDeserializers(new SimpleDeserializers());
    Class<Object> beanType = Object.class;
    rosettaJSONModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaJSONModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    rosettaJSONModule.addSerializer(new XMLGregorianCalendarSerializer());

    SetupContext context = mock(SetupContext.class);
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
   * Test {@link RosettaJSONModule#setupModule(SetupContext)}.
   *
   * <ul>
   *   <li>Then calls {@link SetupContext#addBeanDeserializerModifier(BeanDeserializerModifier)}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONModule#setupModule(SetupContext)}
   */
  @Test
  @DisplayName(
      "Test setupModule(SetupContext); then calls addBeanDeserializerModifier(BeanDeserializerModifier)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaJSONModule.setupModule(SetupContext)"})
  void testSetupModule_thenCallsAddBeanDeserializerModifier() {
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
    rosettaJSONModule.addSerializer(new XMLGregorianCalendarSerializer());

    SetupContext context = mock(SetupContext.class);
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
   * Test {@link RosettaJSONModule#setupModule(SetupContext)}.
   *
   * <ul>
   *   <li>Then calls {@link SetupContext#addBeanSerializerModifier(BeanSerializerModifier)}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONModule#setupModule(SetupContext)}
   */
  @Test
  @DisplayName(
      "Test setupModule(SetupContext); then calls addBeanSerializerModifier(BeanSerializerModifier)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaJSONModule.setupModule(SetupContext)"})
  void testSetupModule_thenCallsAddBeanSerializerModifier() {
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
    rosettaJSONModule.addSerializer(new XMLGregorianCalendarSerializer());

    SetupContext context = mock(SetupContext.class);
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
   * Test {@link RosettaJSONModule#setupModule(SetupContext)}.
   *
   * <ul>
   *   <li>Then calls {@link SetupContext#addDeserializers(Deserializers)}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONModule#setupModule(SetupContext)}
   */
  @Test
  @DisplayName("Test setupModule(SetupContext); then calls addDeserializers(Deserializers)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaJSONModule.setupModule(SetupContext)"})
  void testSetupModule_thenCallsAddDeserializers() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    rosettaJSONModule.setDeserializers(new SimpleDeserializers());
    Class<Object> beanType = Object.class;
    rosettaJSONModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaJSONModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    rosettaJSONModule.addSerializer(new XMLGregorianCalendarSerializer());

    SetupContext context = mock(SetupContext.class);
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
   * Test {@link RosettaJSONModule#setupModule(SetupContext)}.
   *
   * <ul>
   *   <li>Then calls {@link SetupContext#addKeySerializers(Serializers)}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONModule#setupModule(SetupContext)}
   */
  @Test
  @DisplayName("Test setupModule(SetupContext); then calls addKeySerializers(Serializers)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaJSONModule.setupModule(SetupContext)"})
  void testSetupModule_thenCallsAddKeySerializers() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    rosettaJSONModule.setKeySerializers(new SimpleSerializers());
    rosettaJSONModule.setDeserializers(new SimpleDeserializers());
    Class<Object> beanType = Object.class;
    rosettaJSONModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaJSONModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    rosettaJSONModule.addSerializer(new XMLGregorianCalendarSerializer());

    SetupContext context = mock(SetupContext.class);
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
   * Test {@link RosettaJSONModule#setupModule(SetupContext)}.
   *
   * <ul>
   *   <li>Then calls {@link SetupContext#addSerializers(Serializers)}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONModule#setupModule(SetupContext)}
   */
  @Test
  @DisplayName("Test setupModule(SetupContext); then calls addSerializers(Serializers)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaJSONModule.setupModule(SetupContext)"})
  void testSetupModule_thenCallsAddSerializers() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    rosettaJSONModule.addSerializer(new XMLGregorianCalendarSerializer());

    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).addSerializers(Mockito.<Serializers>any());
    doNothing().when(context).insertAnnotationIntrospector(Mockito.<AnnotationIntrospector>any());

    // Act
    rosettaJSONModule.setupModule(context);

    // Assert
    verify(context).addSerializers(isA(Serializers.class));
    verify(context).insertAnnotationIntrospector(isA(AnnotationIntrospector.class));
  }

  /**
   * Test {@link RosettaJSONModule#setupModule(SetupContext)}.
   *
   * <ul>
   *   <li>Then calls {@link SetupContext#addValueInstantiators(ValueInstantiators)}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONModule#setupModule(SetupContext)}
   */
  @Test
  @DisplayName(
      "Test setupModule(SetupContext); then calls addValueInstantiators(ValueInstantiators)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaJSONModule.setupModule(SetupContext)"})
  void testSetupModule_thenCallsAddValueInstantiators() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);
    Class<Object> beanType = Object.class;
    rosettaJSONModule.addValueInstantiator(beanType, new JsonLocationInstantiator());
    Class<Object> type = Object.class;
    rosettaJSONModule.addKeyDeserializer(type, new DateTimeKeyDeserializer());
    rosettaJSONModule.addSerializer(new XMLGregorianCalendarSerializer());

    SetupContext context = mock(SetupContext.class);
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
   * Test {@link RosettaJSONModule#setupModule(SetupContext)}.
   *
   * <ul>
   *   <li>Then calls {@link SetupContext#setMixInAnnotations(Class, Class)}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONModule#setupModule(SetupContext)}
   */
  @Test
  @DisplayName("Test setupModule(SetupContext); then calls setMixInAnnotations(Class, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaJSONModule.setupModule(SetupContext)"})
  void testSetupModule_thenCallsSetMixInAnnotations() {
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
    rosettaJSONModule.addSerializer(new XMLGregorianCalendarSerializer());

    SetupContext context = mock(SetupContext.class);
    doNothing().when(context).setMixInAnnotations(Mockito.<Class<?>>any(), Mockito.<Class<?>>any());
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
   * Test {@link RosettaJSONModule#equals(Object)}, and {@link RosettaJSONModule#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RosettaJSONModule#equals(Object)}
   *   <li>{@link RosettaJSONModule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RosettaJSONModule.equals(Object)",
    "int RosettaJSONModule.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);

    // Act and Assert
    assertEquals(rosettaJSONModule, rosettaJSONModule);
    int expectedHashCodeResult = rosettaJSONModule.hashCode();
    assertEquals(expectedHashCodeResult, rosettaJSONModule.hashCode());
  }

  /**
   * Test {@link RosettaJSONModule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONModule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RosettaJSONModule.equals(Object)",
    "int RosettaJSONModule.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RosettaJSONModule rosettaJSONModule = new RosettaJSONModule(true);

    // Act and Assert
    assertNotEquals(rosettaJSONModule, new RosettaJSONModule(true));
  }

  /**
   * Test {@link RosettaJSONModule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONModule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RosettaJSONModule.equals(Object)",
    "int RosettaJSONModule.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RosettaJSONModule(true), null);
  }

  /**
   * Test {@link RosettaJSONModule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RosettaJSONModule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RosettaJSONModule.equals(Object)",
    "int RosettaJSONModule.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RosettaJSONModule(true), "Different type to RosettaJSONModule");
  }
}
