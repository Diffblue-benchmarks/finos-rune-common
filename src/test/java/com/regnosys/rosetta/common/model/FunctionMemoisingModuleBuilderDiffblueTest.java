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

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FunctionMemoisingModuleBuilderDiffblueTest {
  /**
   * Test {@link FunctionMemoisingModuleBuilder#setPackages(String[])}.
   *
   * <p>Method under test: {@link FunctionMemoisingModuleBuilder#setPackages(String[])}
   */
  @Test
  @DisplayName("Test setPackages(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FunctionMemoisingModuleBuilder FunctionMemoisingModuleBuilder.setPackages(String[])"
  })
  void testSetPackages() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder =
        new FunctionMemoisingModuleBuilder();

    // Act
    FunctionMemoisingModuleBuilder actualSetPackagesResult =
        functionMemoisingModuleBuilder.setPackages("java.text");

    // Assert
    assertSame(functionMemoisingModuleBuilder, actualSetPackagesResult);
  }

  /**
   * Test {@link FunctionMemoisingModuleBuilder#setDebugLoggingFunctions(Class[])}.
   *
   * <ul>
   *   <li>Then return {@link FunctionMemoisingModuleBuilder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FunctionMemoisingModuleBuilder#setDebugLoggingFunctions(Class[])}
   */
  @Test
  @DisplayName(
      "Test setDebugLoggingFunctions(Class[]); then return FunctionMemoisingModuleBuilder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FunctionMemoisingModuleBuilder FunctionMemoisingModuleBuilder.setDebugLoggingFunctions(Class[])"
  })
  void testSetDebugLoggingFunctions_thenReturnFunctionMemoisingModuleBuilder() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder =
        new FunctionMemoisingModuleBuilder();
    Class<RosettaFunction> forNameResult = RosettaFunction.class;

    // Act
    FunctionMemoisingModuleBuilder actualSetDebugLoggingFunctionsResult =
        functionMemoisingModuleBuilder.setDebugLoggingFunctions(forNameResult);

    // Assert
    assertSame(functionMemoisingModuleBuilder, actualSetDebugLoggingFunctionsResult);
  }

  /**
   * Test {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}
   */
  @Test
  @DisplayName("Test setFromMap(Map); given '42'; when HashMap() '42' is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FunctionMemoisingModuleBuilder FunctionMemoisingModuleBuilder.setFromMap(Map)"
  })
  void testSetFromMap_given42_whenHashMap42IsFoo() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder =
        new FunctionMemoisingModuleBuilder();

    HashMap<String, String> map = new HashMap<>();
    map.put("42", "foo");
    map.put("foo", "foo");

    // Act
    FunctionMemoisingModuleBuilder actualSetFromMapResult =
        functionMemoisingModuleBuilder.setFromMap(map);

    // Assert
    assertSame(functionMemoisingModuleBuilder, actualSetFromMapResult);
  }

  /**
   * Test {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}.
   *
   * <ul>
   *   <li>Given {@link FunctionMemoisingModuleBuilder#DEBUG_FUNCTION_ENV_PREFIX}.
   * </ul>
   *
   * <p>Method under test: {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}
   */
  @Test
  @DisplayName("Test setFromMap(Map); given DEBUG_FUNCTION_ENV_PREFIX")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FunctionMemoisingModuleBuilder FunctionMemoisingModuleBuilder.setFromMap(Map)"
  })
  void testSetFromMap_givenDebug_function_env_prefix() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder =
        new FunctionMemoisingModuleBuilder();

    HashMap<String, String> map = new HashMap<>();
    map.put(FunctionMemoisingModuleBuilder.DEBUG_FUNCTION_ENV_PREFIX, "foo");

    // Act
    FunctionMemoisingModuleBuilder actualSetFromMapResult =
        functionMemoisingModuleBuilder.setFromMap(map);

    // Assert
    assertSame(functionMemoisingModuleBuilder, actualSetFromMapResult);
  }

  /**
   * Test {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}
   */
  @Test
  @DisplayName("Test setFromMap(Map); given 'foo'; when HashMap() 'foo' is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FunctionMemoisingModuleBuilder FunctionMemoisingModuleBuilder.setFromMap(Map)"
  })
  void testSetFromMap_givenFoo_whenHashMapFooIsFoo() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder =
        new FunctionMemoisingModuleBuilder();

    HashMap<String, String> map = new HashMap<>();
    map.put("foo", "foo");

    // Act
    FunctionMemoisingModuleBuilder actualSetFromMapResult =
        functionMemoisingModuleBuilder.setFromMap(map);

    // Assert
    assertSame(functionMemoisingModuleBuilder, actualSetFromMapResult);
  }

  /**
   * Test {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}
   */
  @Test
  @DisplayName("Test setFromMap(Map); when HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FunctionMemoisingModuleBuilder FunctionMemoisingModuleBuilder.setFromMap(Map)"
  })
  void testSetFromMap_whenHashMap() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder =
        new FunctionMemoisingModuleBuilder();

    // Act
    FunctionMemoisingModuleBuilder actualSetFromMapResult =
        functionMemoisingModuleBuilder.setFromMap(new HashMap<>());

    // Assert
    assertSame(functionMemoisingModuleBuilder, actualSetFromMapResult);
  }

  /**
   * Test {@link FunctionMemoisingModuleBuilder#setFromEnvironment()}.
   *
   * <p>Method under test: {@link FunctionMemoisingModuleBuilder#setFromEnvironment()}
   */
  @Test
  @DisplayName("Test setFromEnvironment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FunctionMemoisingModuleBuilder FunctionMemoisingModuleBuilder.setFromEnvironment()"
  })
  void testSetFromEnvironment() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder =
        new FunctionMemoisingModuleBuilder();

    // Act
    FunctionMemoisingModuleBuilder actualSetFromEnvironmentResult =
        functionMemoisingModuleBuilder.setFromEnvironment();

    // Assert
    assertSame(functionMemoisingModuleBuilder, actualSetFromEnvironmentResult);
  }
}
