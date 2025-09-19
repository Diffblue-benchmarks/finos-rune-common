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

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RosettaSerialiserFactoryDiffblueTest {
  /**
   * Test {@link RosettaSerialiserFactory#RosettaSerialiserFactory(SerializerFactoryConfig)}.
   *
   * <p>Method under test: {@link
   * RosettaSerialiserFactory#RosettaSerialiserFactory(SerializerFactoryConfig)}
   */
  @Test
  @DisplayName("Test new RosettaSerialiserFactory(SerializerFactoryConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RosettaSerialiserFactory.<init>(SerializerFactoryConfig)"})
  void testNewRosettaSerialiserFactory() {
    // Arrange
    SerializerFactoryConfig config = new SerializerFactoryConfig();

    // Act and Assert
    assertSame(config, new RosettaSerialiserFactory(config).getFactoryConfig());
  }

  /**
   * Test {@link RosettaSerialiserFactory#withConfig(SerializerFactoryConfig)}.
   *
   * <p>Method under test: {@link RosettaSerialiserFactory#withConfig(SerializerFactoryConfig)}
   */
  @Test
  @DisplayName("Test withConfig(SerializerFactoryConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SerializerFactory RosettaSerialiserFactory.withConfig(SerializerFactoryConfig)"
  })
  void testWithConfig() {
    // Arrange
    SerializerFactoryConfig config = new SerializerFactoryConfig();

    // Act
    SerializerFactory actualWithConfigResult = RosettaSerialiserFactory.INSTANCE.withConfig(config);

    // Assert
    assertTrue(actualWithConfigResult instanceof RosettaSerialiserFactory);
    assertSame(config, ((RosettaSerialiserFactory) actualWithConfigResult).getFactoryConfig());
  }
}
