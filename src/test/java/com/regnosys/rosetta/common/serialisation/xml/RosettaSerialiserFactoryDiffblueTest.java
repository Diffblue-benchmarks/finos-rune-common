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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RosettaSerialiserFactoryDiffblueTest {
  /**
   * Test {@link RosettaSerialiserFactory#RosettaSerialiserFactory(SerializerFactoryConfig)}.
   * <ul>
   *   <li>Then FactoryConfig serializers return {@link ArrayIterator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaSerialiserFactory#RosettaSerialiserFactory(SerializerFactoryConfig)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaSerialiserFactory.<init>(SerializerFactoryConfig)"})
  public void testNewRosettaSerialiserFactory_thenFactoryConfigSerializersReturnArrayIterator() {
    // Arrange, Act and Assert
    SerializerFactoryConfig factoryConfig = (new RosettaSerialiserFactory(null)).getFactoryConfig();
    Iterable<Serializers> serializersResult = factoryConfig.serializers();
    assertTrue(serializersResult instanceof ArrayIterator);
    assertFalse(factoryConfig.hasKeySerializers());
    assertFalse(factoryConfig.hasSerializerModifiers());
    assertFalse(factoryConfig.hasSerializers());
    assertFalse(((ArrayIterator<Serializers>) serializersResult).hasNext());
  }

  /**
   * Test {@link RosettaSerialiserFactory#RosettaSerialiserFactory(SerializerFactoryConfig)}.
   * <ul>
   *   <li>Then return FactoryConfig is {@link SerializerFactoryConfig#SerializerFactoryConfig()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaSerialiserFactory#RosettaSerialiserFactory(SerializerFactoryConfig)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RosettaSerialiserFactory.<init>(SerializerFactoryConfig)"})
  public void testNewRosettaSerialiserFactory_thenReturnFactoryConfigIsSerializerFactoryConfig() {
    // Arrange
    SerializerFactoryConfig config = new SerializerFactoryConfig();

    // Act and Assert
    assertSame(config, (new RosettaSerialiserFactory(config)).getFactoryConfig());
  }

  /**
   * Test {@link RosettaSerialiserFactory#withConfig(SerializerFactoryConfig)}.
   * <ul>
   *   <li>Then return FactoryConfig is {@link SerializerFactoryConfig#SerializerFactoryConfig()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaSerialiserFactory#withConfig(SerializerFactoryConfig)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SerializerFactory RosettaSerialiserFactory.withConfig(SerializerFactoryConfig)"})
  public void testWithConfig_thenReturnFactoryConfigIsSerializerFactoryConfig() {
    // Arrange
    SerializerFactoryConfig config = new SerializerFactoryConfig();

    // Act
    SerializerFactory actualWithConfigResult = RosettaSerialiserFactory.INSTANCE.withConfig(config);

    // Assert
    assertTrue(actualWithConfigResult instanceof RosettaSerialiserFactory);
    assertSame(config, ((RosettaSerialiserFactory) actualWithConfigResult).getFactoryConfig());
  }

  /**
   * Test {@link RosettaSerialiserFactory#withConfig(SerializerFactoryConfig)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then FactoryConfig serializers return {@link ArrayIterator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaSerialiserFactory#withConfig(SerializerFactoryConfig)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SerializerFactory RosettaSerialiserFactory.withConfig(SerializerFactoryConfig)"})
  public void testWithConfig_whenNull_thenFactoryConfigSerializersReturnArrayIterator() {
    // Arrange and Act
    SerializerFactory actualWithConfigResult = RosettaSerialiserFactory.INSTANCE.withConfig(null);

    // Assert
    SerializerFactoryConfig factoryConfig = ((RosettaSerialiserFactory) actualWithConfigResult).getFactoryConfig();
    Iterable<Serializers> serializersResult = factoryConfig.serializers();
    assertTrue(serializersResult instanceof ArrayIterator);
    assertTrue(actualWithConfigResult instanceof RosettaSerialiserFactory);
    assertFalse(factoryConfig.hasKeySerializers());
    assertFalse(factoryConfig.hasSerializerModifiers());
    assertFalse(factoryConfig.hasSerializers());
    assertFalse(((ArrayIterator<Serializers>) serializersResult).hasNext());
  }
}
