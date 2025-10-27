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
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.management.loading.MLet;
import org.junit.Test;

public class FunctionRunnerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FunctionRunner.FunctionRunnerResult#getActualOutput()}
   *   <li>{@link FunctionRunner.FunctionRunnerResult#getExpectedOutput()}
   *   <li>{@link FunctionRunner.FunctionRunnerResult#getInput()}
   *   <li>{@link FunctionRunner.FunctionRunnerResult#getJsonActual()}
   *   <li>{@link FunctionRunner.FunctionRunnerResult#getJsonExpected()}
   *   <li>{@link FunctionRunner.FunctionRunnerResult#isSuccess()}
   * </ul>
   */
  @Test
  public void testFunctionRunnerResultGettersAndSetters() {
    // Arrange
    ExecutionDescriptor executionDescriptor = new ExecutionDescriptor();
    FunctionRunner.InstanceLoader instanceLoader = mock(FunctionRunner.InstanceLoader.class);
    MLet classLoader = new MLet();
    FunctionRunner.FunctionRunnerResult<Object, Object> functionRunnerResult = (new FunctionRunner(executionDescriptor,
        instanceLoader, classLoader, new ObjectMapper())).new FunctionRunnerResult("Input", "Expected Output",
            "Actual Output", "Json Actual", "Json Expected");

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
   * Method under test:
   * {@link FunctionRunner.FunctionRunnerResult#FunctionRunnerResult(FunctionRunner, Object, Object, Object, String, String)}
   */
  @Test
  public void testFunctionRunnerResultNewFunctionRunnerResult() {
    // Arrange
    ExecutionDescriptor executionDescriptor = new ExecutionDescriptor();
    FunctionRunner.InstanceLoader instanceLoader = mock(FunctionRunner.InstanceLoader.class);
    MLet classLoader = new MLet();

    // Act
    FunctionRunner.FunctionRunnerResult<Object, Object> actualFunctionRunnerResult = (new FunctionRunner(
        executionDescriptor, instanceLoader, classLoader, new ObjectMapper())).new FunctionRunnerResult("Input",
            "Expected Output", "Actual Output", "Json Actual", "Json Expected");

    // Assert
    assertEquals("Actual Output", actualFunctionRunnerResult.getActualOutput());
    assertEquals("Expected Output", actualFunctionRunnerResult.getExpectedOutput());
    assertEquals("Input", actualFunctionRunnerResult.getInput());
    assertEquals("Json Actual", actualFunctionRunnerResult.getJsonActual());
    assertEquals("Json Expected", actualFunctionRunnerResult.getJsonExpected());
    assertFalse(actualFunctionRunnerResult.isSuccess());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link FunctionRunner#FunctionRunner(ExecutionDescriptor, FunctionRunner.InstanceLoader, ClassLoader, ObjectMapper)}
   *   <li>{@link FunctionRunner#getClassLoader()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ExecutionDescriptor executionDescriptor = new ExecutionDescriptor();
    FunctionRunner.InstanceLoader instanceLoader = mock(FunctionRunner.InstanceLoader.class);
    MLet classLoader = new MLet();

    // Act
    ClassLoader actualClassLoader = (new FunctionRunner(executionDescriptor, instanceLoader, classLoader,
        new ObjectMapper())).getClassLoader();

    // Assert
    assertNotNull(actualClassLoader);
    assertSame(classLoader, actualClassLoader);
  }
}
