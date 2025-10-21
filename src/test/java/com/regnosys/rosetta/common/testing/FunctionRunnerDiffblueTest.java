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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.regnosys.rosetta.common.testing.FunctionRunner.FunctionRunnerResult;
import com.regnosys.rosetta.common.testing.FunctionRunner.InstanceLoader;
import javax.management.loading.MLet;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FunctionRunnerDiffblueTest {
  /**
   * Test FunctionRunnerResult getters and setters.
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object FunctionRunnerResult.getActualOutput()", "Object FunctionRunnerResult.getExpectedOutput()",
      "Object FunctionRunnerResult.getInput()", "String FunctionRunnerResult.getJsonActual()",
      "String FunctionRunnerResult.getJsonExpected()", "boolean FunctionRunnerResult.isSuccess()"})
  public void testFunctionRunnerResultGettersAndSetters() {
    // Arrange
    ExecutionDescriptor executionDescriptor = new ExecutionDescriptor();
    InstanceLoader instanceLoader = mock(InstanceLoader.class);
    MLet classLoader = new MLet();
    FunctionRunnerResult<Object, Object> functionRunnerResult = (new FunctionRunner(executionDescriptor, instanceLoader,
        classLoader, JsonMapper.builder().findAndAddModules().build())).new FunctionRunnerResult<>("Input",
            "Expected Output", "Actual Output", "Json Actual", "Json Expected");

    // Act
    Object actualActualOutput = functionRunnerResult.getActualOutput();
    Object actualExpectedOutput = functionRunnerResult.getExpectedOutput();
    Object actualInput = functionRunnerResult.getInput();
    String actualJsonActual = functionRunnerResult.getJsonActual();
    String actualJsonExpected = functionRunnerResult.getJsonExpected();

    // Assert
    assertEquals("Actual Output", actualActualOutput);
    assertEquals("Expected Output", actualExpectedOutput);
    assertEquals("Input", actualInput);
    assertEquals("Json Actual", actualJsonActual);
    assertEquals("Json Expected", actualJsonExpected);
    assertFalse(functionRunnerResult.isSuccess());
  }

  /**
   * Test FunctionRunnerResult {@link FunctionRunnerResult#FunctionRunnerResult(FunctionRunner, Object, Object, Object, String, String)}.
   * <p>
   * Method under test: {@link FunctionRunnerResult#FunctionRunnerResult(FunctionRunner, Object, Object, Object, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FunctionRunnerResult.<init>(FunctionRunner, Object, Object, Object, String, String)"})
  public void testFunctionRunnerResultNewFunctionRunnerResult() {
    // Arrange
    ExecutionDescriptor executionDescriptor = new ExecutionDescriptor();
    InstanceLoader instanceLoader = mock(InstanceLoader.class);
    MLet classLoader = new MLet();

    // Act
    FunctionRunnerResult<Object, Object> actualFunctionRunnerResult = (new FunctionRunner(executionDescriptor,
        instanceLoader, classLoader, JsonMapper.builder().findAndAddModules().build())).new FunctionRunnerResult<>(
            "Input", "Expected Output", "Actual Output", "Json Actual", "Json Expected");

    // Assert
    assertEquals("Actual Output", actualFunctionRunnerResult.getActualOutput());
    assertEquals("Expected Output", actualFunctionRunnerResult.getExpectedOutput());
    assertEquals("Input", actualFunctionRunnerResult.getInput());
    assertEquals("Json Actual", actualFunctionRunnerResult.getJsonActual());
    assertEquals("Json Expected", actualFunctionRunnerResult.getJsonExpected());
    assertFalse(actualFunctionRunnerResult.isSuccess());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FunctionRunner#FunctionRunner(ExecutionDescriptor, InstanceLoader, ClassLoader, ObjectMapper)}
   *   <li>{@link FunctionRunner#getClassLoader()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FunctionRunner.<init>(ExecutionDescriptor, InstanceLoader, ClassLoader, ObjectMapper)",
      "ClassLoader FunctionRunner.getClassLoader()"})
  public void testGettersAndSetters() {
    // Arrange
    ExecutionDescriptor executionDescriptor = new ExecutionDescriptor();
    InstanceLoader instanceLoader = mock(InstanceLoader.class);
    MLet classLoader = new MLet();

    // Act
    ClassLoader actualClassLoader = (new FunctionRunner(executionDescriptor, instanceLoader, classLoader,
        JsonMapper.builder().findAndAddModules().build())).getClassLoader();

    // Assert
    assertNotNull(actualClassLoader);
    assertSame(classLoader, actualClassLoader);
  }
}
