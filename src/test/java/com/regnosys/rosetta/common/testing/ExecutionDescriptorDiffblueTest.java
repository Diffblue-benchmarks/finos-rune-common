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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import org.junit.Test;
import org.mockito.Mockito;

public class ExecutionDescriptorDiffblueTest {
  /**
   * Methods under test:
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
  public void testGettersAndSetters() {
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

  /**
   * Method under test:
   * {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   */
  @Test
  public void testLoadExecutionDescriptor() throws UnsupportedEncodingException {
    // Arrange
    ObjectMapper objectMapper = new ObjectMapper();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExecutionDescriptor.loadExecutionDescriptor(objectMapper,
        "Resource Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test:
   * {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   */
  @Test
  public void testLoadExecutionDescriptor2() throws UnsupportedEncodingException {
    // Arrange
    ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExecutionDescriptor.loadExecutionDescriptor(objectMapper,
        "Resource Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test:
   * {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   */
  @Test
  public void testLoadExecutionDescriptor3() throws UnsupportedEncodingException {
    // Arrange
    XmlMapper objectMapper = new XmlMapper();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExecutionDescriptor.loadExecutionDescriptor(objectMapper,
        "Resource Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test:
   * {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   */
  @Test
  public void testLoadExecutionDescriptor4() throws UnsupportedEncodingException {
    // Arrange
    YAMLMapper objectMapper = new YAMLMapper();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExecutionDescriptor.loadExecutionDescriptor(objectMapper,
        "Resource Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test:
   * {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   */
  @Test
  public void testLoadExecutionDescriptor5() {
    // Arrange
    ObjectMapper objectMapper = new ObjectMapper();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExecutionDescriptor.loadExecutionDescriptor(objectMapper,
        "Resource Name", new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
  }

  /**
   * Method under test:
   * {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   */
  @Test
  public void testLoadExecutionDescriptor6() {
    // Arrange
    ObjectMapper objectMapper = new ObjectMapper();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExecutionDescriptor.loadExecutionDescriptor(objectMapper,
        "Resource Name", new ByteArrayInputStream(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
  }

  /**
   * Method under test:
   * {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   */
  @Test
  public void testLoadExecutionDescriptor7() {
    // Arrange
    ObjectMapper objectMapper = new ObjectMapper();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExecutionDescriptor.loadExecutionDescriptor(objectMapper,
        "Resource Name", new ByteArrayInputStream(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'})));
  }

  /**
   * Method under test:
   * {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   */
  @Test
  public void testLoadExecutionDescriptor8() {
    // Arrange
    ObjectMapper objectMapper = new ObjectMapper();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> ExecutionDescriptor.loadExecutionDescriptor(objectMapper,
        "Resource Name", new ByteArrayInputStream(new byte[]{})));
  }

  /**
   * Method under test:
   * {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   */
  @Test
  public void testLoadExecutionDescriptor9() throws IOException {
    // Arrange
    ObjectMapper objectMapper = new ObjectMapper();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt())).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ExecutionDescriptor.loadExecutionDescriptor(objectMapper, "Resource Name", inputStream));
    verify(inputStream, atLeast(1)).read(isA(byte[].class), anyInt(), anyInt());
    verify(inputStream).close();
  }

  /**
   * Method under test:
   * {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   */
  @Test
  public void testLoadExecutionDescriptor10() throws IOException {
    // Arrange
    ObjectMapper objectMapper = new ObjectMapper();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new RuntimeException("Unable to load expectations "));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ExecutionDescriptor.loadExecutionDescriptor(objectMapper, "Resource Name", inputStream));
    verify(inputStream).read(isA(byte[].class), eq(0), eq(8000));
  }

  /**
   * Method under test:
   * {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, String, InputStream)}
   */
  @Test
  public void testLoadExecutionDescriptor11() throws IOException {
    // Arrange
    YAMLMapper objectMapper = new YAMLMapper();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenThrow(new RuntimeException("Unable to load expectations "));
    doThrow(new RuntimeException("Unable to load expectations ")).when(inputStream).close();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> ExecutionDescriptor.loadExecutionDescriptor(objectMapper, "Resource Name", inputStream));
    verify(inputStream).read(isA(byte[].class), eq(0), eq(8000));
    verify(inputStream).close();
  }

  /**
   * Method under test:
   * {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, URL)}
   */
  @Test
  public void testLoadExecutionDescriptor12() throws MalformedURLException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ExecutionDescriptor.loadExecutionDescriptor(new ObjectMapper(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Method under test:
   * {@link ExecutionDescriptor#loadExecutionDescriptor(ObjectMapper, URL)}
   */
  @Test
  public void testLoadExecutionDescriptor13() throws MalformedURLException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> ExecutionDescriptor.loadExecutionDescriptor(new YAMLMapper(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }
}
