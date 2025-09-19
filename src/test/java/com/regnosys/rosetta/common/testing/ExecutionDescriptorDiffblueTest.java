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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ExecutionDescriptorDiffblueTest {
  /**
   * Test {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   * with {@code objectMapper}, {@code resourceName}, {@code inputStream}.
   *
   * <p>Method under test: {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String,
   * InputStream)}
   */
  @Test
  @DisplayName(
      "Test loadExecutionDescriptor(ObjectMapper, String, InputStream) with 'objectMapper', 'resourceName', 'inputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List ExecutionDescriptor.loadExecutionDescriptor(ObjectMapper, String, InputStream)"
  })
  void testLoadExecutionDescriptorWithObjectMapperResourceNameInputStream()
      throws UnsupportedEncodingException {
    // Arrange
    JsonMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ExecutionDescriptor.loadExecutionDescriptor(
                objectMapper,
                "Resource Name",
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   * with {@code objectMapper}, {@code resourceName}, {@code inputStream}.
   *
   * <p>Method under test: {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String,
   * InputStream)}
   */
  @Test
  @DisplayName(
      "Test loadExecutionDescriptor(ObjectMapper, String, InputStream) with 'objectMapper', 'resourceName', 'inputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List ExecutionDescriptor.loadExecutionDescriptor(ObjectMapper, String, InputStream)"
  })
  void testLoadExecutionDescriptorWithObjectMapperResourceNameInputStream2()
      throws UnsupportedEncodingException {
    // Arrange
    JsonMapper m = JsonMapper.builder().findAndAddModules().build();
    JsonMapper objectMapper = new Builder(m).findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ExecutionDescriptor.loadExecutionDescriptor(
                objectMapper,
                "Resource Name",
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   * with {@code objectMapper}, {@code resourceName}, {@code inputStream}.
   *
   * <p>Method under test: {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String,
   * InputStream)}
   */
  @Test
  @DisplayName(
      "Test loadExecutionDescriptor(ObjectMapper, String, InputStream) with 'objectMapper', 'resourceName', 'inputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List ExecutionDescriptor.loadExecutionDescriptor(ObjectMapper, String, InputStream)"
  })
  void testLoadExecutionDescriptorWithObjectMapperResourceNameInputStream3() {
    // Arrange
    JsonMapper objectMapper = JsonMapper.builder().findAndAddModules().build();
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ExecutionDescriptor.loadExecutionDescriptor(
                objectMapper, "Resource Name", inputStream));
  }

  /**
   * Test {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   * with {@code objectMapper}, {@code resourceName}, {@code inputStream}.
   *
   * <p>Method under test: {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String,
   * InputStream)}
   */
  @Test
  @DisplayName(
      "Test loadExecutionDescriptor(ObjectMapper, String, InputStream) with 'objectMapper', 'resourceName', 'inputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List ExecutionDescriptor.loadExecutionDescriptor(ObjectMapper, String, InputStream)"
  })
  void testLoadExecutionDescriptorWithObjectMapperResourceNameInputStream4() {
    // Arrange
    JsonMapper objectMapper = JsonMapper.builder().findAndAddModules().build();
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ExecutionDescriptor.loadExecutionDescriptor(
                objectMapper, "Resource Name", inputStream));
  }

  /**
   * Test {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   * with {@code objectMapper}, {@code resourceName}, {@code inputStream}.
   *
   * <p>Method under test: {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String,
   * InputStream)}
   */
  @Test
  @DisplayName(
      "Test loadExecutionDescriptor(ObjectMapper, String, InputStream) with 'objectMapper', 'resourceName', 'inputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List ExecutionDescriptor.loadExecutionDescriptor(ObjectMapper, String, InputStream)"
  })
  void testLoadExecutionDescriptorWithObjectMapperResourceNameInputStream5() {
    // Arrange
    JsonMapper objectMapper = JsonMapper.builder().findAndAddModules().build();
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ExecutionDescriptor.loadExecutionDescriptor(
                objectMapper, "Resource Name", inputStream));
  }

  /**
   * Test {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   * with {@code objectMapper}, {@code resourceName}, {@code inputStream}.
   *
   * <p>Method under test: {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String,
   * InputStream)}
   */
  @Test
  @DisplayName(
      "Test loadExecutionDescriptor(ObjectMapper, String, InputStream) with 'objectMapper', 'resourceName', 'inputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List ExecutionDescriptor.loadExecutionDescriptor(ObjectMapper, String, InputStream)"
  })
  void testLoadExecutionDescriptorWithObjectMapperResourceNameInputStream6() {
    // Arrange
    JsonMapper objectMapper = JsonMapper.builder().findAndAddModules().build();
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ExecutionDescriptor.loadExecutionDescriptor(
                objectMapper, "Resource Name", inputStream));
  }

  /**
   * Test {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   * with {@code objectMapper}, {@code resourceName}, {@code inputStream}.
   *
   * <p>Method under test: {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String,
   * InputStream)}
   */
  @Test
  @DisplayName(
      "Test loadExecutionDescriptor(ObjectMapper, String, InputStream) with 'objectMapper', 'resourceName', 'inputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List ExecutionDescriptor.loadExecutionDescriptor(ObjectMapper, String, InputStream)"
  })
  void testLoadExecutionDescriptorWithObjectMapperResourceNameInputStream7() {
    // Arrange
    JsonMapper objectMapper = JsonMapper.builder().findAndAddModules().build();
    ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[] {});

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ExecutionDescriptor.loadExecutionDescriptor(
                objectMapper, "Resource Name", inputStream));
  }

  /**
   * Test {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   * with {@code objectMapper}, {@code resourceName}, {@code inputStream}.
   *
   * <p>Method under test: {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String,
   * InputStream)}
   */
  @Test
  @DisplayName(
      "Test loadExecutionDescriptor(ObjectMapper, String, InputStream) with 'objectMapper', 'resourceName', 'inputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List ExecutionDescriptor.loadExecutionDescriptor(ObjectMapper, String, InputStream)"
  })
  void testLoadExecutionDescriptorWithObjectMapperResourceNameInputStream8() throws IOException {
    // Arrange
    JsonMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    ObjectInputStream inputStream = mock(ObjectInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ExecutionDescriptor.loadExecutionDescriptor(
                objectMapper, "Resource Name", inputStream));
    verify(inputStream).close();
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
  }

  /**
   * Test {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   * with {@code objectMapper}, {@code resourceName}, {@code inputStream}.
   *
   * <ul>
   *   <li>Then calls {@link DataInputStream#read(byte[], int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String,
   * InputStream)}
   */
  @Test
  @DisplayName(
      "Test loadExecutionDescriptor(ObjectMapper, String, InputStream) with 'objectMapper', 'resourceName', 'inputStream'; then calls read(byte[], int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List ExecutionDescriptor.loadExecutionDescriptor(ObjectMapper, String, InputStream)"
  })
  void testLoadExecutionDescriptorWithObjectMapperResourceNameInputStream_thenCallsRead()
      throws IOException {
    // Arrange
    JsonMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenThrow(new IOException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ExecutionDescriptor.loadExecutionDescriptor(
                objectMapper, "Resource Name", inputStream));
    verify(inputStream).read(isA(byte[].class), eq(0), eq(8000));
  }

  /**
   * Test {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, URL)} with {@code
   * objectMapper}, {@code url}.
   *
   * <p>Method under test: {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, URL)}
   */
  @Test
  @DisplayName("Test loadExecutionDescriptor(ObjectMapper, URL) with 'objectMapper', 'url'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.List ExecutionDescriptor.loadExecutionDescriptor(ObjectMapper, URL)"
  })
  void testLoadExecutionDescriptorWithObjectMapperUrl() throws MalformedURLException {
    // Arrange
    JsonMapper objectMapper = JsonMapper.builder().findAndAddModules().build();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            ExecutionDescriptor.loadExecutionDescriptor(
                objectMapper,
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ExecutionDescriptor}
   *   <li>{@link ExecutionDescriptor#getDescription()}
   *   <li>{@link ExecutionDescriptor#getExecutableFunctionClass()}
   *   <li>{@link ExecutionDescriptor#getExpectedOutputFile()}
   *   <li>{@link ExecutionDescriptor#getGroup()}
   *   <li>{@link ExecutionDescriptor#getInputFile()}
   *   <li>{@link ExecutionDescriptor#getMarkDownFile()}
   *   <li>{@link ExecutionDescriptor#getName()}
   *   <li>{@link ExecutionDescriptor#isNativeFunction()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExecutionDescriptor.<init>()",
    "String ExecutionDescriptor.getDescription()",
    "String ExecutionDescriptor.getExecutableFunctionClass()",
    "String ExecutionDescriptor.getExpectedOutputFile()",
    "String ExecutionDescriptor.getGroup()",
    "String ExecutionDescriptor.getInputFile()",
    "String ExecutionDescriptor.getMarkDownFile()",
    "String ExecutionDescriptor.getName()",
    "boolean ExecutionDescriptor.isNativeFunction()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ExecutionDescriptor actualExecutionDescriptor = new ExecutionDescriptor();
    String actualDescription = actualExecutionDescriptor.getDescription();
    String actualExecutableFunctionClass = actualExecutionDescriptor.getExecutableFunctionClass();
    String actualExpectedOutputFile = actualExecutionDescriptor.getExpectedOutputFile();
    String actualGroup = actualExecutionDescriptor.getGroup();
    String actualInputFile = actualExecutionDescriptor.getInputFile();
    String actualMarkDownFile = actualExecutionDescriptor.getMarkDownFile();
    String actualName = actualExecutionDescriptor.getName();

    // Assert
    assertNull(actualDescription);
    assertNull(actualExecutableFunctionClass);
    assertNull(actualExpectedOutputFile);
    assertNull(actualGroup);
    assertNull(actualInputFile);
    assertNull(actualMarkDownFile);
    assertNull(actualName);
    assertFalse(actualExecutionDescriptor.isNativeFunction());
  }
}
