package com.regnosys.rosetta.common.model;

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

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;

public class FunctionMemoisingModuleBuilderDiffblueTest {
  /**
   * Method under test:
   * {@link FunctionMemoisingModuleBuilder#setPackages(String[])}
   */
  @Test
  public void testSetPackages() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder = new FunctionMemoisingModuleBuilder();

    // Act and Assert
    assertSame(functionMemoisingModuleBuilder, functionMemoisingModuleBuilder.setPackages("java.text"));
  }

  /**
   * Method under test:
   * {@link FunctionMemoisingModuleBuilder#setDebugLoggingFunctions(Class[])}
   */
  @Test
  public void testSetDebugLoggingFunctions() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder = new FunctionMemoisingModuleBuilder();
    Class<RosettaFunction> forNameResult = RosettaFunction.class;

    // Act and Assert
    assertSame(functionMemoisingModuleBuilder, functionMemoisingModuleBuilder.setDebugLoggingFunctions(forNameResult));
  }

  /**
   * Method under test: {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}
   */
  @Test
  public void testSetFromMap() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder = new FunctionMemoisingModuleBuilder();

    // Act and Assert
    assertSame(functionMemoisingModuleBuilder, functionMemoisingModuleBuilder.setFromMap(new HashMap<>()));
  }

  /**
   * Method under test: {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}
   */
  @Test
  public void testSetFromMap2() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder = new FunctionMemoisingModuleBuilder();

    HashMap<String, String> map = new HashMap<>();
    map.put("foo", "foo");

    // Act and Assert
    assertSame(functionMemoisingModuleBuilder, functionMemoisingModuleBuilder.setFromMap(map));
  }

  /**
   * Method under test: {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}
   */
  @Test
  public void testSetFromMap3() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder = new FunctionMemoisingModuleBuilder();

    HashMap<String, String> map = new HashMap<>();
    map.computeIfPresent(FunctionMemoisingModuleBuilder.DEBUG_FUNCTION_ENV_PREFIX, mock(BiFunction.class));
    map.put("foo", "foo");

    // Act and Assert
    assertSame(functionMemoisingModuleBuilder, functionMemoisingModuleBuilder.setFromMap(map));
  }

  /**
   * Method under test: {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}
   */
  @Test
  public void testSetFromMap4() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder = new FunctionMemoisingModuleBuilder();

    HashMap<String, String> map = new HashMap<>();
    map.put(FunctionMemoisingModuleBuilder.DEBUG_FUNCTION_ENV_PREFIX, "foo");

    // Act and Assert
    assertSame(functionMemoisingModuleBuilder, functionMemoisingModuleBuilder.setFromMap(map));
  }

  /**
   * Method under test: {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}
   */
  @Test
  public void testSetFromMap5() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder = new FunctionMemoisingModuleBuilder();

    HashMap<String, String> map = new HashMap<>();
    map.put("42", "foo");
    map.put("foo", "foo");

    // Act and Assert
    assertSame(functionMemoisingModuleBuilder, functionMemoisingModuleBuilder.setFromMap(map));
  }

  /**
   * Method under test:
   * {@link FunctionMemoisingModuleBuilder#setFromEnvironment()}
   */
  @Test
  public void testSetFromEnvironment() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder = new FunctionMemoisingModuleBuilder();

    // Act and Assert
    assertSame(functionMemoisingModuleBuilder, functionMemoisingModuleBuilder.setFromEnvironment());
  }
}
