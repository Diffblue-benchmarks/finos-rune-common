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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FunctionMemoisingModuleBuilderDiffblueTest {
  /**
   * Test {@link FunctionMemoisingModuleBuilder#setPackages(String[])}.
   * <p>
   * Method under test: {@link FunctionMemoisingModuleBuilder#setPackages(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FunctionMemoisingModuleBuilder FunctionMemoisingModuleBuilder.setPackages(String[])"})
  public void testSetPackages() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder = new FunctionMemoisingModuleBuilder();

    // Act and Assert
    assertSame(functionMemoisingModuleBuilder, functionMemoisingModuleBuilder.setPackages("java.text"));
  }

  /**
   * Test {@link FunctionMemoisingModuleBuilder#setDebugLoggingFunctions(Class[])}.
   * <ul>
   *   <li>Then return {@link FunctionMemoisingModuleBuilder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FunctionMemoisingModuleBuilder#setDebugLoggingFunctions(Class[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FunctionMemoisingModuleBuilder FunctionMemoisingModuleBuilder.setDebugLoggingFunctions(Class[])"})
  public void testSetDebugLoggingFunctions_thenReturnFunctionMemoisingModuleBuilder() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder = new FunctionMemoisingModuleBuilder();
    Class<RosettaFunction> forNameResult = RosettaFunction.class;

    // Act and Assert
    assertSame(functionMemoisingModuleBuilder, functionMemoisingModuleBuilder.setDebugLoggingFunctions(forNameResult));
  }

  /**
   * Test {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FunctionMemoisingModuleBuilder FunctionMemoisingModuleBuilder.setFromMap(Map)"})
  public void testSetFromMap_given42_whenHashMap42IsFoo() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder = new FunctionMemoisingModuleBuilder();

    HashMap<String, String> map = new HashMap<>();
    map.put("42", "foo");
    map.put("foo", "foo");

    // Act and Assert
    assertSame(functionMemoisingModuleBuilder, functionMemoisingModuleBuilder.setFromMap(map));
  }

  /**
   * Test {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}.
   * <ul>
   *   <li>Given {@link FunctionMemoisingModuleBuilder#DEBUG_FUNCTION_ENV_PREFIX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FunctionMemoisingModuleBuilder FunctionMemoisingModuleBuilder.setFromMap(Map)"})
  public void testSetFromMap_givenDebug_function_env_prefix() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder = new FunctionMemoisingModuleBuilder();

    HashMap<String, String> map = new HashMap<>();
    map.put(FunctionMemoisingModuleBuilder.DEBUG_FUNCTION_ENV_PREFIX, "foo");

    // Act and Assert
    assertSame(functionMemoisingModuleBuilder, functionMemoisingModuleBuilder.setFromMap(map));
  }

  /**
   * Test {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FunctionMemoisingModuleBuilder FunctionMemoisingModuleBuilder.setFromMap(Map)"})
  public void testSetFromMap_givenFoo_whenHashMapFooIsFoo() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder = new FunctionMemoisingModuleBuilder();

    HashMap<String, String> map = new HashMap<>();
    map.put("foo", "foo");

    // Act and Assert
    assertSame(functionMemoisingModuleBuilder, functionMemoisingModuleBuilder.setFromMap(map));
  }

  /**
   * Test {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FunctionMemoisingModuleBuilder#setFromMap(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FunctionMemoisingModuleBuilder FunctionMemoisingModuleBuilder.setFromMap(Map)"})
  public void testSetFromMap_whenHashMap() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder = new FunctionMemoisingModuleBuilder();

    // Act and Assert
    assertSame(functionMemoisingModuleBuilder, functionMemoisingModuleBuilder.setFromMap(new HashMap<>()));
  }

  /**
   * Test {@link FunctionMemoisingModuleBuilder#setFromEnvironment()}.
   * <p>
   * Method under test: {@link FunctionMemoisingModuleBuilder#setFromEnvironment()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FunctionMemoisingModuleBuilder FunctionMemoisingModuleBuilder.setFromEnvironment()"})
  public void testSetFromEnvironment() {
    // Arrange
    FunctionMemoisingModuleBuilder functionMemoisingModuleBuilder = new FunctionMemoisingModuleBuilder();

    // Act and Assert
    assertSame(functionMemoisingModuleBuilder, functionMemoisingModuleBuilder.setFromEnvironment());
  }
}
