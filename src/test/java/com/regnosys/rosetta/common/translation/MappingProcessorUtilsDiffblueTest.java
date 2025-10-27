package com.regnosys.rosetta.common.translation;

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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.regnosys.rosetta.common.hashing.ScopeReferenceHelper;
import com.rosetta.model.lib.path.RosettaPath;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.BasicNotifierImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class MappingProcessorUtilsDiffblueTest {
  /**
   * Method under test:
   * {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testGetValueAndUpdateMappings() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils
        .getValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, mock(RosettaPath.class));

    // Assert
    assertFalse(actualValueAndUpdateMappings.isPresent());
    assertTrue(mappings.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testGetValueAndUpdateMappings2() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils
        .getValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertEquals("Xml Value", actualValueAndUpdateMappings.get());
    assertTrue(actualValueAndUpdateMappings.isPresent());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testGetValueAndUpdateMappings3() {
    // Arrange
    Path synonymPath = new Path();

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils.getValueAndUpdateMappings(synonymPath,
        mappings, mock(RosettaPath.class));

    // Assert
    assertEquals(1, mappings.size());
    assertFalse(actualValueAndUpdateMappings.isPresent());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testGetValueAndUpdateMappings4() {
    // Arrange
    Path synonymPath = Path.valueOf("Path");

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils.getValueAndUpdateMappings(synonymPath,
        mappings, mock(RosettaPath.class));

    // Assert
    assertEquals(1, mappings.size());
    assertFalse(actualValueAndUpdateMappings.isPresent());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testGetValueAndUpdateMappings5() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    Mapping mapping2 = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping2);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils
        .getValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath, atLeast(1)).allElements();
    assertEquals(2, mappings.size());
    assertEquals("Xml Value", actualValueAndUpdateMappings.get());
    assertTrue(actualValueAndUpdateMappings.isPresent());
    assertSame(mapping, mappings.get(0));
    assertSame(mapping2, mappings.get(1));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testGetValueAndUpdateMappings6() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils
        .getValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, mock(RosettaPath.class));

    // Assert
    assertEquals(1, mappings.size());
    assertFalse(actualValueAndUpdateMappings.isPresent());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testGetValueAndUpdateMappings7() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new Path.PathElement("emptyScope"),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils
        .getValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertEquals("emptyScope", actualValueAndUpdateMappings.get());
    assertTrue(actualValueAndUpdateMappings.isPresent());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testGetValueAndUpdateMappings8() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new Path.PathElement("emptyScope", 1),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils
        .getValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertEquals("emptyScope(1)", actualValueAndUpdateMappings.get());
    assertTrue(actualValueAndUpdateMappings.isPresent());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testGetValueAndUpdateMappings9() {
    // Arrange
    Path synonymPath = new Path();

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils.getValueAndUpdateMappings(synonymPath,
        mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertEquals("Xml Value", actualValueAndUpdateMappings.get());
    assertTrue(actualValueAndUpdateMappings.isPresent());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testGetValueListAndUpdateMappings() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();

    // Act
    List<String> actualValueListAndUpdateMappings = MappingProcessorUtils
        .getValueListAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, mock(RosettaPath.class));

    // Assert
    assertTrue(mappings.isEmpty());
    assertTrue(actualValueListAndUpdateMappings.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testGetValueListAndUpdateMappings2() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    List<String> actualValueListAndUpdateMappings = MappingProcessorUtils
        .getValueListAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertEquals(1, actualValueListAndUpdateMappings.size());
    assertEquals("Xml Value", actualValueListAndUpdateMappings.get(0));
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testGetValueListAndUpdateMappings3() {
    // Arrange
    Path synonymPath = new Path();

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    List<String> actualValueListAndUpdateMappings = MappingProcessorUtils.getValueListAndUpdateMappings(synonymPath,
        mappings, mock(RosettaPath.class));

    // Assert
    assertEquals(1, mappings.size());
    assertTrue(actualValueListAndUpdateMappings.isEmpty());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testGetValueListAndUpdateMappings4() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    Mapping mapping2 = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping2);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    List<String> actualValueListAndUpdateMappings = MappingProcessorUtils
        .getValueListAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath, atLeast(1)).allElements();
    assertEquals(2, mappings.size());
    assertEquals(2, actualValueListAndUpdateMappings.size());
    assertEquals("Xml Value", actualValueListAndUpdateMappings.get(0));
    assertEquals("Xml Value", actualValueListAndUpdateMappings.get(1));
    assertSame(mapping, mappings.get(0));
    assertSame(mapping2, mappings.get(1));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testGetValueListAndUpdateMappings5() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new Path.PathElement("emptyScope"),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    List<String> actualValueListAndUpdateMappings = MappingProcessorUtils
        .getValueListAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertEquals(1, actualValueListAndUpdateMappings.size());
    assertEquals("emptyScope", actualValueListAndUpdateMappings.get(0));
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testGetValueListAndUpdateMappings6() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new Path.PathElement("emptyScope", 1),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    List<String> actualValueListAndUpdateMappings = MappingProcessorUtils
        .getValueListAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertEquals(1, actualValueListAndUpdateMappings.size());
    assertEquals("emptyScope(1)", actualValueListAndUpdateMappings.get(0));
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndUpdateMappings() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;
    ArrayList<Mapping> mappings = new ArrayList<>();

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings,
        mock(RosettaPath.class));

    // Assert that nothing has changed
    assertTrue(mappings.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndUpdateMappings2() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndUpdateMappings3() {
    // Arrange
    Path synonymPath = new Path();
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(synonymPath, setter, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndUpdateMappings4() {
    // Arrange
    Path synonymPath = Path.valueOf("Path");
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(synonymPath, setter, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndUpdateMappings5() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    Mapping mapping2 = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping2);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath, atLeast(1)).allElements();
    assertEquals(2, mappings.size());
    assertSame(mapping, mappings.get(0));
    assertSame(mapping2, mappings.get(1));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndUpdateMappings6() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings,
        mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndUpdateMappings7() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new Path.PathElement("emptyScope"),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndUpdateMappings8() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new Path.PathElement("emptyScope", 1),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndUpdateMappings9() {
    // Arrange
    Path synonymPath = new Path();
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(synonymPath, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  public void testSetValueListAndUpdateMappings() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;
    ArrayList<Mapping> mappings = new ArrayList<>();

    // Act
    MappingProcessorUtils.setValueListAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings,
        mock(RosettaPath.class));

    // Assert that nothing has changed
    assertTrue(mappings.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  public void testSetValueListAndUpdateMappings2() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueListAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings,
        rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  public void testSetValueListAndUpdateMappings3() {
    // Arrange
    Path synonymPath = new Path();
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    MappingProcessorUtils.setValueListAndUpdateMappings(synonymPath, setter, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  public void testSetValueListAndUpdateMappings4() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    Mapping mapping2 = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping2);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueListAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings,
        rosettaPath);

    // Assert
    verify(rosettaPath, atLeast(1)).allElements();
    assertEquals(2, mappings.size());
    assertSame(mapping, mappings.get(0));
    assertSame(mapping2, mappings.get(1));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  public void testSetValueListAndUpdateMappings5() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new Path.PathElement("emptyScope"),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueListAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings,
        rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  public void testSetValueListAndUpdateMappings6() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new Path.PathElement("emptyScope", 1),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueListAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings,
        rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndOptionallyUpdateMappings() {
    // Arrange
    Function<String, Boolean> func = mock(Function.class);
    ArrayList<Mapping> mappings = new ArrayList<>();

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, func, mappings,
        mock(RosettaPath.class));

    // Assert that nothing has changed
    assertTrue(mappings.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndOptionallyUpdateMappings2() {
    // Arrange
    Function<String, Boolean> func = mock(Function.class);
    when(func.apply(Mockito.<String>any())).thenReturn(true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, func, mappings,
        rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    verify(func).apply(eq("Xml Value"));
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndOptionallyUpdateMappings3() {
    // Arrange
    Path synonymPath = new Path();
    Function<String, Boolean> func = mock(Function.class);

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(synonymPath, func, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndOptionallyUpdateMappings4() {
    // Arrange
    Path synonymPath = Path.valueOf("Path");
    Function<String, Boolean> func = mock(Function.class);

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(synonymPath, func, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndOptionallyUpdateMappings5() {
    // Arrange
    Function<String, Boolean> func = mock(Function.class);
    when(func.apply(Mockito.<String>any())).thenReturn(false);

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, func, mappings,
        mock(RosettaPath.class));

    // Assert
    verify(func).apply(eq("Xml Value"));
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndOptionallyUpdateMappings6() {
    // Arrange
    Function<String, Boolean> func = mock(Function.class);
    when(func.apply(Mockito.<String>any())).thenReturn(true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    Mapping mapping2 = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping2);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, func, mappings,
        rosettaPath);

    // Assert
    verify(rosettaPath, atLeast(1)).allElements();
    verify(func).apply(eq("Xml Value"));
    assertEquals(2, mappings.size());
    assertSame(mapping, mappings.get(0));
    assertSame(mapping2, mappings.get(1));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndOptionallyUpdateMappings7() {
    // Arrange
    Function<String, Boolean> func = mock(Function.class);

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, func, mappings,
        mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndOptionallyUpdateMappings8() {
    // Arrange
    Function<String, Boolean> func = mock(Function.class);
    when(func.apply(Mockito.<String>any())).thenReturn(true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new Path.PathElement("emptyScope"),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, func, mappings,
        rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    verify(func).apply(eq("emptyScope"));
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndOptionallyUpdateMappings9() {
    // Arrange
    Function<String, Boolean> func = mock(Function.class);
    when(func.apply(Mockito.<String>any())).thenReturn(true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new Path.PathElement("emptyScope", 1),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, func, mappings,
        rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    verify(func).apply(eq("emptyScope(1)"));
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  public void testSetValueAndOptionallyUpdateMappings10() {
    // Arrange
    Path synonymPath = new Path();
    Function<String, Boolean> func = mock(Function.class);
    when(func.apply(Mockito.<String>any())).thenReturn(true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(synonymPath, func, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    verify(func).apply(eq("Xml Value"));
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterListMappings(List, Path)}
   */
  @Test
  public void testFilterListMappings() {
    // Arrange and Act
    List<Mapping> actualFilterListMappingsResult = MappingProcessorUtils.filterListMappings(new ArrayList<>(),
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterListMappingsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterListMappings(List, Path)}
   */
  @Test
  public void testFilterListMappings2() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterListMappingsResult = MappingProcessorUtils.filterListMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(mappings, actualFilterListMappingsResult);
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterListMappings(List, Path)}
   */
  @Test
  public void testFilterListMappings3() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterListMappingsResult = MappingProcessorUtils.filterListMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(mappings, actualFilterListMappingsResult);
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterListMappings(List, Path)}
   */
  @Test
  public void testFilterListMappings4() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, mock(BasicNotifierImpl.EAdapterList.class),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterListMappingsResult = MappingProcessorUtils.filterListMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(mappings, actualFilterListMappingsResult);
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterListMappings(List, Path)}
   */
  @Test
  public void testFilterListMappings5() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterListMappingsResult = MappingProcessorUtils.filterListMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterListMappingsResult.isEmpty());
  }

  /**
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  public void testFilterMappings() {
    // Arrange and Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(new ArrayList<>(),
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  public void testFilterMappings2() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(mappings, actualFilterMappingsResult);
  }

  /**
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  public void testFilterMappings3() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(mappings, actualFilterMappingsResult);
  }

  /**
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  public void testFilterMappings4() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, mock(BasicNotifierImpl.EAdapterList.class),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(mappings, actualFilterMappingsResult);
  }

  /**
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  public void testFilterMappings5() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  public void testFilterMappings6() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings, new Path());

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  public void testFilterMappings7() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings, Path.valueOf("Path"));

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  public void testFilterMappings8() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings, new Path());

    // Assert
    assertEquals(mappings, actualFilterMappingsResult);
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  public void testFilterMappings9() {
    // Arrange and Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(new ArrayList<>(),
        ScopeReferenceHelper.EMPTY_SCOPE, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  public void testFilterMappings10() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(mappings, actualFilterMappingsResult);
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  public void testFilterMappings11() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(mappings, actualFilterMappingsResult);
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  public void testFilterMappings12() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, mock(BasicNotifierImpl.EAdapterList.class),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(mappings, actualFilterMappingsResult);
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  public void testFilterMappings13() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  public void testFilterMappings14() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", new Path(), "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  public void testFilterMappings15() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", null, "Rosetta Value", "An error occurred",
        true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  public void testFilterMappings16() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings, new Path(),
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  public void testFilterMappings17() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings, Path.valueOf("Path"),
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  public void testFilterMappings18() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, new Path());

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  public void testFilterMappings19() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, Path.valueOf("Path"));

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  public void testFilterMappings20() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings, new Path(),
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(mappings, actualFilterMappingsResult);
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  public void testFilterMappings21() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", new Path(), "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, new Path());

    // Assert
    assertEquals(mappings, actualFilterMappingsResult);
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  public void testFilterMappings22() {
    // Arrange and Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(new ArrayList<>(),
        mock(RosettaPath.class));

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  public void testFilterMappings23() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings, mock(RosettaPath.class));

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  public void testFilterMappings24() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings, mock(RosettaPath.class));

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  public void testFilterMappings25() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, null,
        "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings, mock(RosettaPath.class));

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  public void testFilterMappings26() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", new Path(), "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings, mock(RosettaPath.class));

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  public void testFilterMappings27() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", null, "Rosetta Value", "An error occurred",
        true, true, true));

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings, mock(RosettaPath.class));

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  public void testGetEmptyMappings() {
    // Arrange and Act
    List<Mapping> actualEmptyMappings = MappingProcessorUtils.getEmptyMappings(new ArrayList<>(),
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualEmptyMappings.isEmpty());
  }

  /**
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  public void testGetEmptyMappings2() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualEmptyMappings = MappingProcessorUtils.getEmptyMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(mappings, actualEmptyMappings);
  }

  /**
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  public void testGetEmptyMappings3() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualEmptyMappings = MappingProcessorUtils.getEmptyMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(mappings, actualEmptyMappings);
  }

  /**
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  public void testGetEmptyMappings4() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, mock(BasicNotifierImpl.EAdapterList.class),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualEmptyMappings = MappingProcessorUtils.getEmptyMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(mappings, actualEmptyMappings);
  }

  /**
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  public void testGetEmptyMappings5() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", null, true, true, true));

    // Act
    List<Mapping> actualEmptyMappings = MappingProcessorUtils.getEmptyMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualEmptyMappings.isEmpty());
  }

  /**
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  public void testGetEmptyMappings6() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    List<Mapping> actualEmptyMappings = MappingProcessorUtils.getEmptyMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualEmptyMappings.isEmpty());
  }

  /**
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  public void testGetEmptyMappings7() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", null, "Rosetta Value", "An error occurred",
        true, true, true));

    // Act
    List<Mapping> actualEmptyMappings = MappingProcessorUtils.getEmptyMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(mappings, actualEmptyMappings);
  }

  /**
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  public void testGetEmptyMappings8() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualEmptyMappings = MappingProcessorUtils.getEmptyMappings(mappings, new Path());

    // Assert
    assertTrue(actualEmptyMappings.isEmpty());
  }

  /**
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  public void testGetEmptyMappings9() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<Mapping> actualEmptyMappings = MappingProcessorUtils.getEmptyMappings(mappings, Path.valueOf("Path"));

    // Assert
    assertTrue(actualEmptyMappings.isEmpty());
  }

  /**
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  public void testGetEmptyMappings10() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    List<Mapping> actualEmptyMappings = MappingProcessorUtils.getEmptyMappings(mappings, new Path());

    // Assert
    assertEquals(mappings, actualEmptyMappings);
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  public void testGetNonNullMappedValue() {
    // Arrange and Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils
        .getNonNullMappedValue(ScopeReferenceHelper.EMPTY_SCOPE, new ArrayList<>());

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  public void testGetNonNullMappedValue2() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils
        .getNonNullMappedValue(ScopeReferenceHelper.EMPTY_SCOPE, mappings);

    // Assert
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  public void testGetNonNullMappedValue3() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils
        .getNonNullMappedValue(ScopeReferenceHelper.EMPTY_SCOPE, mappings);

    // Assert
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  public void testGetNonNullMappedValue4() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new Path.PathElement("emptyScope"),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils
        .getNonNullMappedValue(ScopeReferenceHelper.EMPTY_SCOPE, mappings);

    // Assert
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  public void testGetNonNullMappedValue5() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new Path.PathElement("emptyScope", 1),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils
        .getNonNullMappedValue(ScopeReferenceHelper.EMPTY_SCOPE, mappings);

    // Assert
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  public void testGetNonNullMappedValue6() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, mock(BasicNotifierImpl.EAdapterList.class),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils
        .getNonNullMappedValue(ScopeReferenceHelper.EMPTY_SCOPE, mappings);

    // Assert
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  public void testGetNonNullMappedValue7() {
    // Arrange
    Path synonymPath = new Path();

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(synonymPath, mappings);

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  public void testGetNonNullMappedValue8() {
    // Arrange
    Path synonymPath = Path.valueOf("Path");

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(synonymPath, mappings);

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  public void testGetNonNullMappedValue9() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils
        .getNonNullMappedValue(ScopeReferenceHelper.EMPTY_SCOPE, mappings);

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  public void testGetNonNullMappedValue10() {
    // Arrange
    Path synonymPath = new Path();

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(synonymPath, mappings);

    // Assert
    assertEquals("Xml Value", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List)}
   */
  @Test
  public void testGetNonNullMappedValue11() {
    // Arrange and Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(new ArrayList<>());

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List)}
   */
  @Test
  public void testGetNonNullMappedValue12() {
    // Arrange
    ArrayList<Mapping> filteredMappings = new ArrayList<>();
    filteredMappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(filteredMappings);

    // Assert
    assertEquals("Xml Value", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List)}
   */
  @Test
  public void testGetNonNullMappedValue13() {
    // Arrange
    ArrayList<Mapping> filteredMappings = new ArrayList<>();
    filteredMappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    filteredMappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(filteredMappings);

    // Assert
    assertEquals("Xml Value", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMappedValue14() {
    // Arrange and Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(new ArrayList<>(),
        ScopeReferenceHelper.EMPTY_SCOPE, "Ends With");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMappedValue15() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, "Ends With");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMappedValue16() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, "Ends With");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMappedValue17() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, "Ends With");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMappedValue18() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(mappings, new Path(),
        "Ends With");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMappedValue19() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(mappings,
        Path.valueOf("Path"), "Ends With");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMappedValue20() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, "emptyScope");

    // Assert
    assertEquals("Xml Value", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMappedValue21() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, "Ends With", "java.lang.Boolean");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMappedValue22() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(mappings, new Path(),
        "Ends With");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMappedValue23() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, null, ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, "emptyScope");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMappedValue24() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new Path.PathElement("emptyScope"),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, "emptyScope");

    // Assert
    assertEquals("emptyScope", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMappedValue25() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new Path.PathElement("emptyScope", 1),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, "emptyScope");

    // Assert
    assertEquals("emptyScope(1)", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  public void testGetNonNullMapping() {
    // Arrange and Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(new ArrayList<>(),
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  public void testGetNonNullMapping2() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualNonNullMapping.isPresent());
    assertSame(mapping, actualNonNullMapping.get());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  public void testGetNonNullMapping3() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualNonNullMapping.isPresent());
    assertSame(mapping, actualNonNullMapping.get());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  public void testGetNonNullMapping4() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, null, ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  public void testGetNonNullMapping5() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, null, ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualNonNullMapping.isPresent());
    assertSame(mapping, actualNonNullMapping.get());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  public void testGetNonNullMapping6() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  public void testGetNonNullMapping7() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings, new Path());

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  public void testGetNonNullMapping8() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings, Path.valueOf("Path"));

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  public void testGetNonNullMapping9() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings, new Path());

    // Assert
    assertTrue(actualNonNullMapping.isPresent());
    assertSame(mapping, actualNonNullMapping.get());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping10() {
    // Arrange and Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(new ArrayList<>(),
        ScopeReferenceHelper.EMPTY_SCOPE, "Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping11() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, "Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping12() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, "Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping13() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, "Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping14() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings, new Path(), "Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping15() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings, Path.valueOf("Path"),
        "Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping16() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, "emptyScope");

    // Assert
    assertTrue(actualNonNullMapping.isPresent());
    assertSame(mapping, actualNonNullMapping.get());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping17() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, "Ends With", "java.lang.Boolean");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping18() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings, new Path(), "Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping19() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, null, ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, "emptyScope");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping20() {
    // Arrange and Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(new ArrayList<>(),
        mock(RosettaPath.class), ScopeReferenceHelper.EMPTY_SCOPE, "Synonym Path Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping21() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings, mock(RosettaPath.class),
        ScopeReferenceHelper.EMPTY_SCOPE, "Synonym Path Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping22() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings, mock(RosettaPath.class),
        ScopeReferenceHelper.EMPTY_SCOPE, "Synonym Path Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping23() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings, mock(RosettaPath.class),
        ScopeReferenceHelper.EMPTY_SCOPE, "Synonym Path Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping24() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath modelPathStartsWith = mock(RosettaPath.class);

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings, modelPathStartsWith,
        new Path(), "Synonym Path Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping25() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath modelPathStartsWith = mock(RosettaPath.class);

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings, modelPathStartsWith,
        Path.valueOf("Path"), "Synonym Path Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping26() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath modelPathStartsWith = mock(RosettaPath.class);
    when(modelPathStartsWith.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings, modelPathStartsWith,
        ScopeReferenceHelper.EMPTY_SCOPE, "emptyScope");

    // Assert
    verify(modelPathStartsWith).allElements();
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping27() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", new Path(), "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath modelPathStartsWith = mock(RosettaPath.class);
    when(modelPathStartsWith.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings, modelPathStartsWith,
        ScopeReferenceHelper.EMPTY_SCOPE, "emptyScope");

    // Assert
    verify(modelPathStartsWith).allElements();
    assertTrue(actualNonNullMapping.isPresent());
    assertSame(mapping, actualNonNullMapping.get());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping28() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings, mock(RosettaPath.class),
        ScopeReferenceHelper.EMPTY_SCOPE, "Synonym Path Ends With", "java.lang.Boolean");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  public void testGetNonNullMapping29() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, null, new Path(), "Rosetta Value", "An error occurred",
        true, true, true));
    RosettaPath modelPathStartsWith = mock(RosettaPath.class);
    when(modelPathStartsWith.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings, modelPathStartsWith,
        ScopeReferenceHelper.EMPTY_SCOPE, "emptyScope");

    // Assert
    verify(modelPathStartsWith).allElements();
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  public void testGetNonNullMappingForModelPath() {
    // Arrange and Act
    Optional<Mapping> actualNonNullMappingForModelPath = MappingProcessorUtils
        .getNonNullMappingForModelPath(new ArrayList<>(), ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertFalse(actualNonNullMappingForModelPath.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  public void testGetNonNullMappingForModelPath2() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    Optional<Mapping> actualNonNullMappingForModelPath = MappingProcessorUtils.getNonNullMappingForModelPath(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualNonNullMappingForModelPath.isPresent());
    assertSame(mapping, actualNonNullMappingForModelPath.get());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  public void testGetNonNullMappingForModelPath3() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMappingForModelPath = MappingProcessorUtils.getNonNullMappingForModelPath(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualNonNullMappingForModelPath.isPresent());
    assertSame(mapping, actualNonNullMappingForModelPath.get());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  public void testGetNonNullMappingForModelPath4() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, null, ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMappingForModelPath = MappingProcessorUtils.getNonNullMappingForModelPath(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertFalse(actualNonNullMappingForModelPath.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  public void testGetNonNullMappingForModelPath5() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, null, ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    Optional<Mapping> actualNonNullMappingForModelPath = MappingProcessorUtils.getNonNullMappingForModelPath(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualNonNullMappingForModelPath.isPresent());
    assertSame(mapping, actualNonNullMappingForModelPath.get());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  public void testGetNonNullMappingForModelPath6() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", new Path(), "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMappingForModelPath = MappingProcessorUtils.getNonNullMappingForModelPath(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertFalse(actualNonNullMappingForModelPath.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  public void testGetNonNullMappingForModelPath7() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", null, "Rosetta Value", "An error occurred",
        true, true, true));

    // Act
    Optional<Mapping> actualNonNullMappingForModelPath = MappingProcessorUtils.getNonNullMappingForModelPath(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertFalse(actualNonNullMappingForModelPath.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  public void testGetNonNullMappingForModelPath8() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMappingForModelPath = MappingProcessorUtils.getNonNullMappingForModelPath(mappings,
        new Path());

    // Assert
    assertFalse(actualNonNullMappingForModelPath.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  public void testGetNonNullMappingForModelPath9() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<Mapping> actualNonNullMappingForModelPath = MappingProcessorUtils.getNonNullMappingForModelPath(mappings,
        Path.valueOf("Path"));

    // Assert
    assertFalse(actualNonNullMappingForModelPath.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  public void testGetNonNullMappingForModelPath10() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", new Path(), "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    Optional<Mapping> actualNonNullMappingForModelPath = MappingProcessorUtils.getNonNullMappingForModelPath(mappings,
        new Path());

    // Assert
    assertTrue(actualNonNullMappingForModelPath.isPresent());
    assertSame(mapping, actualNonNullMappingForModelPath.get());
  }

  /**
   * Method under test: {@link MappingProcessorUtils#subPath(String, Path)}
   */
  @Test
  public void testSubPath() {
    // Arrange and Act
    Optional<Path> actualSubPathResult = MappingProcessorUtils.subPath("Last Element",
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertFalse(actualSubPathResult.isPresent());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testUpdateMappings() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();

    // Act
    MappingProcessorUtils.updateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertTrue(mappings.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testUpdateMappings2() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.updateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testUpdateMappings3() {
    // Arrange
    Path synonymPath = new Path();

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    MappingProcessorUtils.updateMappings(synonymPath, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testUpdateMappings4() {
    // Arrange
    Path synonymPath = Path.valueOf("Path");

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    MappingProcessorUtils.updateMappings(synonymPath, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testUpdateMappings5() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    Mapping mapping2 = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping2);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.updateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath, atLeast(1)).allElements();
    assertEquals(2, mappings.size());
    assertSame(mapping, mappings.get(0));
    assertSame(mapping2, mappings.get(1));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testUpdateMappings6() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    MappingProcessorUtils.updateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}
   */
  @Test
  public void testUpdateMappings7() {
    // Arrange
    Path synonymPath = new Path();

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.updateMappings(synonymPath, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertSame(mapping, mappings.get(0));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#updateMappingSuccess(Mapping, Path)}
   */
  @Test
  public void testUpdateMappingSuccess() {
    // Arrange
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    // Act
    MappingProcessorUtils.updateMappingSuccess(mapping, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertNull(mapping.getError());
    assertFalse(mapping.isDuplicate());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#updateMappingSuccess(Mapping, RosettaPath)}
   */
  @Test
  public void testUpdateMappingSuccess2() {
    // Arrange
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.updateMappingSuccess(mapping, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    Path xmlPath = mapping.getXmlPath();
    Path.PathElement lastElement = xmlPath.getLastElement();
    assertEquals("emptyScope", lastElement.getPathName());
    Path rosettaPath2 = mapping.getRosettaPath();
    assertNull(rosettaPath2.getLastElement());
    assertNull(mapping.getError());
    assertEquals(0, rosettaPath2.getPathNames().length);
    List<Path.PathElement> elements = xmlPath.getElements();
    assertEquals(1, elements.size());
    assertFalse(mapping.isDuplicate());
    assertFalse(lastElement.getIndex().isPresent());
    assertTrue(rosettaPath2.getElements().isEmpty());
    assertTrue(lastElement.getMetas().isEmpty());
    assertEquals(rosettaPath2, xmlPath.getParent());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[]{"emptyScope"}, xmlPath.getPathNames());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#updateMappingFail(Mapping, String)}
   */
  @Test
  public void testUpdateMappingFail() {
    // Arrange
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    // Act
    MappingProcessorUtils.updateMappingFail(mapping, "An error occurred");

    // Assert
    Path xmlPath = mapping.getXmlPath();
    Path.PathElement lastElement = xmlPath.getLastElement();
    assertEquals("emptyScope", lastElement.getPathName());
    Path parent = xmlPath.getParent();
    assertNull(parent.getLastElement());
    assertNull(mapping.getRosettaPath());
    assertNull(mapping.getRosettaValue());
    assertEquals(0, parent.getPathNames().length);
    List<Path.PathElement> elements = xmlPath.getElements();
    assertEquals(1, elements.size());
    assertFalse(lastElement.getIndex().isPresent());
    assertTrue(parent.getElements().isEmpty());
    assertTrue(lastElement.getMetas().isEmpty());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[]{"emptyScope"}, xmlPath.getPathNames());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValueList(List)}
   */
  @Test
  public void testGetNonNullMappedValueList() {
    // Arrange and Act
    List<String> actualNonNullMappedValueList = MappingProcessorUtils.getNonNullMappedValueList(new ArrayList<>());

    // Assert
    assertTrue(actualNonNullMappedValueList.isEmpty());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValueList(List)}
   */
  @Test
  public void testGetNonNullMappedValueList2() {
    // Arrange
    ArrayList<Mapping> filteredMappings = new ArrayList<>();
    filteredMappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<String> actualNonNullMappedValueList = MappingProcessorUtils.getNonNullMappedValueList(filteredMappings);

    // Assert
    assertEquals(1, actualNonNullMappedValueList.size());
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValueList(List)}
   */
  @Test
  public void testGetNonNullMappedValueList3() {
    // Arrange
    ArrayList<Mapping> filteredMappings = new ArrayList<>();
    filteredMappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    filteredMappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<String> actualNonNullMappedValueList = MappingProcessorUtils.getNonNullMappedValueList(filteredMappings);

    // Assert
    assertEquals(2, actualNonNullMappedValueList.size());
    assertEquals("Xml Value", actualNonNullMappedValueList.get(1));
  }

  /**
   * Method under test:
   * {@link MappingProcessorUtils#getNonNullMappedValueList(List)}
   */
  @Test
  public void testGetNonNullMappedValueList4() {
    // Arrange
    ArrayList<Mapping> filteredMappings = new ArrayList<>();
    filteredMappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, mock(BasicNotifierImpl.EAdapterList.class),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<String> actualNonNullMappedValueList = MappingProcessorUtils.getNonNullMappedValueList(filteredMappings);

    // Assert
    assertEquals(1, actualNonNullMappedValueList.size());
  }
}
