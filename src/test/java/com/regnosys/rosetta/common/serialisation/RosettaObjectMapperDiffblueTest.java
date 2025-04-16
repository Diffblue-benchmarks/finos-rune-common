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
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker.Std;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RosettaObjectMapperDiffblueTest {
  /**
   * Test {@link RosettaObjectMapper#getNewMinimalRosettaObjectMapper()}.
   * <p>
   * Method under test: {@link RosettaObjectMapper#getNewMinimalRosettaObjectMapper()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapper.getNewMinimalRosettaObjectMapper()"})
  public void testGetNewMinimalRosettaObjectMapper() {
    // Arrange and Act
    ObjectMapper actualNewMinimalRosettaObjectMapper = RosettaObjectMapper.getNewMinimalRosettaObjectMapper();

    // Assert
    JsonFactory factory = actualNewMinimalRosettaObjectMapper.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    assertTrue(
        actualNewMinimalRosettaObjectMapper.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
    assertTrue(actualNewMinimalRosettaObjectMapper.getVisibilityChecker() instanceof Std);
    assertTrue(
        actualNewMinimalRosettaObjectMapper.getPolymorphicTypeValidator() instanceof LaissezFaireSubTypeValidator);
    assertTrue(actualNewMinimalRosettaObjectMapper.getSubtypeResolver() instanceof StdSubtypeResolver);
    assertTrue(actualNewMinimalRosettaObjectMapper.getSerializerFactory() instanceof BeanSerializerFactory);
    assertTrue(actualNewMinimalRosettaObjectMapper.getSerializerProvider() instanceof Impl);
    assertTrue(actualNewMinimalRosettaObjectMapper.getSerializerProviderInstance() instanceof Impl);
    assertTrue(actualNewMinimalRosettaObjectMapper.getDateFormat() instanceof StdDateFormat);
    assertNull(actualNewMinimalRosettaObjectMapper.getInjectableValues());
    assertNull(actualNewMinimalRosettaObjectMapper.getPropertyNamingStrategy());
    assertEquals(8, actualNewMinimalRosettaObjectMapper.getRegisteredModuleIds().size());
    assertSame(factory, actualNewMinimalRosettaObjectMapper.getJsonFactory());
  }

  /**
   * Test {@link RosettaObjectMapper#getNewRosettaObjectMapper()}.
   * <p>
   * Method under test: {@link RosettaObjectMapper#getNewRosettaObjectMapper()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectMapper RosettaObjectMapper.getNewRosettaObjectMapper()"})
  public void testGetNewRosettaObjectMapper() {
    // Arrange and Act
    ObjectMapper actualNewRosettaObjectMapper = RosettaObjectMapper.getNewRosettaObjectMapper();

    // Assert
    JsonFactory factory = actualNewRosettaObjectMapper.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    assertTrue(actualNewRosettaObjectMapper.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
    assertTrue(actualNewRosettaObjectMapper.getVisibilityChecker() instanceof Std);
    assertTrue(actualNewRosettaObjectMapper.getPolymorphicTypeValidator() instanceof LaissezFaireSubTypeValidator);
    assertTrue(actualNewRosettaObjectMapper.getSubtypeResolver() instanceof StdSubtypeResolver);
    assertTrue(actualNewRosettaObjectMapper.getSerializerFactory() instanceof BeanSerializerFactory);
    assertTrue(actualNewRosettaObjectMapper.getSerializerProvider() instanceof Impl);
    assertTrue(actualNewRosettaObjectMapper.getSerializerProviderInstance() instanceof Impl);
    assertTrue(actualNewRosettaObjectMapper.getDateFormat() instanceof StdDateFormat);
    assertNull(actualNewRosettaObjectMapper.getInjectableValues());
    assertNull(actualNewRosettaObjectMapper.getPropertyNamingStrategy());
    assertEquals(8, actualNewRosettaObjectMapper.getRegisteredModuleIds().size());
    assertSame(factory, actualNewRosettaObjectMapper.getJsonFactory());
  }
}
