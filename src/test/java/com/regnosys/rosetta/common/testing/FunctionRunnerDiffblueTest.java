package com.regnosys.rosetta.common.testing;

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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.regnosys.rosetta.common.testing.FunctionRunner.FunctionRunnerResult;
import com.regnosys.rosetta.common.testing.FunctionRunner.InstanceLoader;
import javax.management.loading.MLet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FunctionRunnerDiffblueTest {
  /**
   * Test FunctionRunnerResult getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FunctionRunnerResult#getActualOutput()}
   *   <li>{@link FunctionRunnerResult#getExpectedOutput()}
   *   <li>{@link FunctionRunnerResult#getInput()}
   *   <li>{@link FunctionRunnerResult#getJsonActual()}
   *   <li>{@link FunctionRunnerResult#getJsonExpected()}
   *   <li>{@link FunctionRunnerResult#isSuccess()}
   * </ul>
   */
  @Test
  @DisplayName("Test FunctionRunnerResult getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FunctionRunnerResult.getActualOutput()",
    "Object FunctionRunnerResult.getExpectedOutput()",
    "Object FunctionRunnerResult.getInput()",
    "String FunctionRunnerResult.getJsonActual()",
    "String FunctionRunnerResult.getJsonExpected()",
    "boolean FunctionRunnerResult.isSuccess()"
  })
  void testFunctionRunnerResultGettersAndSetters() {
    // Arrange
    ExecutionDescriptor executionDescriptor = new ExecutionDescriptor();
    InstanceLoader instanceLoader = mock(InstanceLoader.class);
    MLet classLoader = new MLet();
    JsonMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    FunctionRunner functionRunner =
        new FunctionRunner(executionDescriptor, instanceLoader, classLoader, objectMapper);
    FunctionRunnerResult<Object, Object> functionRunnerResult =
        functionRunner
        .new FunctionRunnerResult(
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "Json Actual",
            "Json Expected");

    // Act
    Object actualActualOutput = functionRunnerResult.getActualOutput();
    Object actualExpectedOutput = functionRunnerResult.getExpectedOutput();
    Object actualInput = functionRunnerResult.getInput();
    String actualJsonActual = functionRunnerResult.getJsonActual();
    String actualJsonExpected = functionRunnerResult.getJsonExpected();

    // Assert
    assertTrue(actualActualOutput instanceof Include);
    assertTrue(actualExpectedOutput instanceof Include);
    assertTrue(actualInput instanceof Include);
    assertEquals("Json Actual", actualJsonActual);
    assertEquals("Json Expected", actualJsonExpected);
    assertEquals(Include.NON_EMPTY, actualActualOutput);
    assertEquals(Include.NON_EMPTY, actualExpectedOutput);
    assertEquals(Include.NON_EMPTY, actualInput);
    assertFalse(functionRunnerResult.isSuccess());
  }

  /**
   * Test FunctionRunnerResult {@link FunctionRunnerResult#FunctionRunnerResult(FunctionRunner,
   * Object, Object, Object, String, String)}.
   *
   * <p>Method under test: {@link FunctionRunnerResult#FunctionRunnerResult(FunctionRunner, Object,
   * Object, Object, String, String)}
   */
  @Test
  @DisplayName(
      "Test FunctionRunnerResult new FunctionRunnerResult(FunctionRunner, Object, Object, Object, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FunctionRunnerResult.<init>(FunctionRunner, Object, Object, Object, String, String)"
  })
  void testFunctionRunnerResultNewFunctionRunnerResult() {
    // Arrange
    ExecutionDescriptor executionDescriptor = new ExecutionDescriptor();
    InstanceLoader instanceLoader = mock(InstanceLoader.class);
    MLet classLoader = new MLet();
    JsonMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    FunctionRunner functionRunner =
        new FunctionRunner(executionDescriptor, instanceLoader, classLoader, objectMapper);
    Object object = BeanPropertyWriter.MARKER_FOR_EMPTY;

    // Act
    FunctionRunnerResult<Object, Object> actualFunctionRunnerResult =
        functionRunner
        .new FunctionRunnerResult(
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            object,
            "Json Actual",
            "Json Expected");

    // Assert
    assertEquals("Json Actual", actualFunctionRunnerResult.getJsonActual());
    assertEquals("Json Expected", actualFunctionRunnerResult.getJsonExpected());
    assertFalse(actualFunctionRunnerResult.isSuccess());
    assertSame(object, actualFunctionRunnerResult.getActualOutput());
    assertSame(object, actualFunctionRunnerResult.getExpectedOutput());
    assertSame(object, actualFunctionRunnerResult.getInput());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FunctionRunner#FunctionRunner(ExecutionDescriptor, InstanceLoader, ClassLoader,
   *       ObjectMapper)}
   *   <li>{@link FunctionRunner#getClassLoader()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FunctionRunner.<init>(ExecutionDescriptor, InstanceLoader, ClassLoader, ObjectMapper)",
    "ClassLoader FunctionRunner.getClassLoader()"
  })
  void testGettersAndSetters() {
    // Arrange
    ExecutionDescriptor executionDescriptor = new ExecutionDescriptor();
    InstanceLoader instanceLoader = mock(InstanceLoader.class);
    MLet classLoader = new MLet();
    JsonMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act
    FunctionRunner actualFunctionRunner =
        new FunctionRunner(executionDescriptor, instanceLoader, classLoader, objectMapper);
    ClassLoader actualClassLoader = actualFunctionRunner.getClassLoader();

    // Assert
    assertNotNull(actualClassLoader);
    assertSame(classLoader, actualClassLoader);
  }
}
