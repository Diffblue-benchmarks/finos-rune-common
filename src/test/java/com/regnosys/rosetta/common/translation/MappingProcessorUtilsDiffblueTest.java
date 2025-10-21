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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.hashing.ScopeReferenceHelper;
import com.regnosys.rosetta.common.translation.Path.PathElement;
import com.rosetta.model.lib.path.RosettaPath;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class MappingProcessorUtilsDiffblueTest {
  /**
   * Test {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first RosettaPath Elements size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getValueAndUpdateMappings(Path, List, RosettaPath)"})
  public void testGetValueAndUpdateMappings_thenArrayListFirstRosettaPathElementsSizeIsOne() {
    // Arrange
    Path synonymPath = new Path();

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils.getValueAndUpdateMappings(synonymPath,
        mappings, mock(RosettaPath.class));

    // Assert
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("An error occurred", getResult.getError());
    Path rosettaPath = getResult.getRosettaPath();
    assertEquals(1, rosettaPath.getElements().size());
    assertEquals(1, rosettaPath.getPathNames().length);
    assertFalse(actualValueAndUpdateMappings.isPresent());
    assertTrue(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first RosettaPath is {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getValueAndUpdateMappings(Path, List, RosettaPath)"})
  public void testGetValueAndUpdateMappings_thenArrayListFirstRosettaPathIsEmpty_scope() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils.getValueAndUpdateMappings(synonymPath,
        mappings, mock(RosettaPath.class));

    // Assert
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("An error occurred", getResult.getError());
    assertFalse(actualValueAndUpdateMappings.isPresent());
    assertTrue(getResult.isDuplicate());
    assertSame(synonymPath, getResult.getRosettaPath());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first RosettaPath is {@link Path#Path()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getValueAndUpdateMappings(Path, List, RosettaPath)"})
  public void testGetValueAndUpdateMappings_thenArrayListFirstRosettaPathIsPath() {
    // Arrange
    Path synonymPath = new Path();

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils.getValueAndUpdateMappings(synonymPath,
        mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertEquals("Xml Value", actualValueAndUpdateMappings.get());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
    assertTrue(actualValueAndUpdateMappings.isPresent());
    assertEquals(synonymPath, getResult.getRosettaPath());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getValueAndUpdateMappings(Path, List, RosettaPath)"})
  public void testGetValueAndUpdateMappings_thenArrayListSizeIsTwo() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils
        .getValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath, atLeast(1)).allElements();
    assertEquals(2, mappings.size());
    assertEquals("Xml Value", actualValueAndUpdateMappings.get());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
    assertTrue(actualValueAndUpdateMappings.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code emptyScope}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getValueAndUpdateMappings(Path, List, RosettaPath)"})
  public void testGetValueAndUpdateMappings_thenReturnGetIsEmptyScope() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new PathElement("emptyScope"),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils
        .getValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertEquals("emptyScope", actualValueAndUpdateMappings.get());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
    assertTrue(actualValueAndUpdateMappings.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code emptyScope(1)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getValueAndUpdateMappings(Path, List, RosettaPath)"})
  public void testGetValueAndUpdateMappings_thenReturnGetIsEmptyScope1() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new PathElement("emptyScope", 1),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils
        .getValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertEquals("emptyScope(1)", actualValueAndUpdateMappings.get());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
    assertTrue(actualValueAndUpdateMappings.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code Xml Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getValueAndUpdateMappings(Path, List, RosettaPath)"})
  public void testGetValueAndUpdateMappings_thenReturnGetIsXmlValue() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils
        .getValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertEquals("Xml Value", actualValueAndUpdateMappings.get());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
    assertTrue(actualValueAndUpdateMappings.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getValueAndUpdateMappings(Path, List, RosettaPath)"})
  public void testGetValueAndUpdateMappings_whenArrayList_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils
        .getValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, new ArrayList<>(), mock(RosettaPath.class));

    // Assert
    assertFalse(actualValueAndUpdateMappings.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>When valueOf {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getValueAndUpdateMappings(Path, List, RosettaPath)"})
  public void testGetValueAndUpdateMappings_whenValueOfPath() {
    // Arrange
    Path synonymPath = Path.valueOf("Path");

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualValueAndUpdateMappings = MappingProcessorUtils.getValueAndUpdateMappings(synonymPath,
        mappings, mock(RosettaPath.class));

    // Assert
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("An error occurred", getResult.getError());
    Path rosettaPath = getResult.getRosettaPath();
    assertEquals(1, rosettaPath.getElements().size());
    assertEquals(1, rosettaPath.getPathNames().length);
    assertFalse(actualValueAndUpdateMappings.isPresent());
    assertTrue(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Error is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getValueListAndUpdateMappings(Path, List, RosettaPath)"})
  public void testGetValueListAndUpdateMappings_thenArrayListFirstErrorIsAnErrorOccurred() {
    // Arrange
    Path synonymPath = new Path();

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<String> actualValueListAndUpdateMappings = MappingProcessorUtils.getValueListAndUpdateMappings(synonymPath,
        mappings, mock(RosettaPath.class));

    // Assert
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("An error occurred", getResult.getError());
    Path rosettaPath = getResult.getRosettaPath();
    assertEquals(1, rosettaPath.getElements().size());
    assertEquals(1, rosettaPath.getPathNames().length);
    assertTrue(getResult.isDuplicate());
    assertTrue(actualValueListAndUpdateMappings.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getValueListAndUpdateMappings(Path, List, RosettaPath)"})
  public void testGetValueListAndUpdateMappings_thenArrayListSizeIsTwo() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
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
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>Then return first is {@code emptyScope}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getValueListAndUpdateMappings(Path, List, RosettaPath)"})
  public void testGetValueListAndUpdateMappings_thenReturnFirstIsEmptyScope() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new PathElement("emptyScope"),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
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
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>Then return first is {@code emptyScope(1)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getValueListAndUpdateMappings(Path, List, RosettaPath)"})
  public void testGetValueListAndUpdateMappings_thenReturnFirstIsEmptyScope1() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new PathElement("emptyScope", 1),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
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
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>Then return first is {@code Xml Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getValueListAndUpdateMappings(Path, List, RosettaPath)"})
  public void testGetValueListAndUpdateMappings_thenReturnFirstIsXmlValue() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
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
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getValueListAndUpdateMappings(Path, List, RosettaPath)"})
  public void testGetValueListAndUpdateMappings_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualValueListAndUpdateMappings = MappingProcessorUtils
        .getValueListAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, new ArrayList<>(), mock(RosettaPath.class));

    // Assert
    assertTrue(actualValueListAndUpdateMappings.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)"})
  public void testSetValueAndUpdateMappings() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new PathElement("emptyScope", 1),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}.
   * <ul>
   *   <li>Given {@link PathElement#PathElement(String)} with pathName is {@code emptyScope}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)"})
  public void testSetValueAndUpdateMappings_givenPathElementWithPathNameIsEmptyScope() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new PathElement("emptyScope"),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Error is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)"})
  public void testSetValueAndUpdateMappings_thenArrayListFirstErrorIsNull() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first RosettaPath Elements size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)"})
  public void testSetValueAndUpdateMappings_thenArrayListFirstRosettaPathElementsSizeIsOne() {
    // Arrange
    Path synonymPath = new Path();
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(synonymPath, setter, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("An error occurred", getResult.getError());
    Path rosettaPath = getResult.getRosettaPath();
    assertEquals(1, rosettaPath.getElements().size());
    assertEquals(1, rosettaPath.getPathNames().length);
    assertTrue(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first RosettaPath is {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)"})
  public void testSetValueAndUpdateMappings_thenArrayListFirstRosettaPathIsEmpty_scope() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(synonymPath, setter, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("An error occurred", getResult.getError());
    assertTrue(getResult.isDuplicate());
    assertSame(synonymPath, getResult.getRosettaPath());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first RosettaPath is {@link Path#Path()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)"})
  public void testSetValueAndUpdateMappings_thenArrayListFirstRosettaPathIsPath() {
    // Arrange
    Path synonymPath = new Path();
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(synonymPath, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
    assertEquals(synonymPath, getResult.getRosettaPath());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)"})
  public void testSetValueAndUpdateMappings_thenArrayListSizeIsTwo() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath, atLeast(1)).allElements();
    assertEquals(2, mappings.size());
    assertSame(mapping, mappings.get(1));
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}.
   * <ul>
   *   <li>When valueOf {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)"})
  public void testSetValueAndUpdateMappings_whenValueOfPath() {
    // Arrange
    Path synonymPath = Path.valueOf("Path");
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(synonymPath, setter, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("An error occurred", getResult.getError());
    Path rosettaPath = getResult.getRosettaPath();
    assertEquals(1, rosettaPath.getElements().size());
    assertEquals(1, rosettaPath.getPathNames().length);
    assertTrue(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)"})
  public void testSetValueListAndUpdateMappings() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new PathElement("emptyScope", 1),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueListAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings,
        rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)}.
   * <ul>
   *   <li>Given {@link PathElement#PathElement(String)} with pathName is {@code emptyScope}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)"})
  public void testSetValueListAndUpdateMappings_givenPathElementWithPathNameIsEmptyScope() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new PathElement("emptyScope"),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueListAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings,
        rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Error is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)"})
  public void testSetValueListAndUpdateMappings_thenArrayListFirstErrorIsAnErrorOccurred() {
    // Arrange
    Path synonymPath = new Path();
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    MappingProcessorUtils.setValueListAndUpdateMappings(synonymPath, setter, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("An error occurred", getResult.getError());
    Path rosettaPath = getResult.getRosettaPath();
    assertEquals(1, rosettaPath.getElements().size());
    assertEquals(1, rosettaPath.getPathNames().length);
    assertTrue(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)"})
  public void testSetValueListAndUpdateMappings_thenArrayListSizeIsOne() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueListAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings,
        rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)"})
  public void testSetValueListAndUpdateMappings_thenArrayListSizeIsTwo() {
    // Arrange
    Consumer<String> setter = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value",
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true)::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueListAndUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings,
        rosettaPath);

    // Assert
    verify(rosettaPath, atLeast(1)).allElements();
    assertEquals(2, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
    assertSame(mapping, mappings.get(1));
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MappingProcessorUtils.setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)"})
  public void testSetValueAndOptionallyUpdateMappings() {
    // Arrange
    Path synonymPath = new Path();
    Function<String, Boolean> func = mock(Function.class);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(synonymPath, func, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("An error occurred", getResult.getError());
    Path rosettaPath = getResult.getRosettaPath();
    assertEquals(1, rosettaPath.getElements().size());
    assertEquals(1, rosettaPath.getPathNames().length);
    assertTrue(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MappingProcessorUtils.setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)"})
  public void testSetValueAndOptionallyUpdateMappings2() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    Function<String, Boolean> func = mock(Function.class);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(synonymPath, func, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("An error occurred", getResult.getError());
    assertEquals("Rosetta Value", getResult.getRosettaValue());
    assertSame(synonymPath, getResult.getRosettaPath());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MappingProcessorUtils.setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)"})
  public void testSetValueAndOptionallyUpdateMappings3() {
    // Arrange
    Function<String, Boolean> func = mock(Function.class);
    when(func.apply(Mockito.<String>any())).thenReturn(true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new PathElement("emptyScope", 1),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, func, mappings,
        rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    verify(func).apply(eq("emptyScope(1)"));
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}.
   * <ul>
   *   <li>Given {@link PathElement#PathElement(String)} with pathName is {@code emptyScope}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MappingProcessorUtils.setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)"})
  public void testSetValueAndOptionallyUpdateMappings_givenPathElementWithPathNameIsEmptyScope() {
    // Arrange
    Function<String, Boolean> func = mock(Function.class);
    when(func.apply(Mockito.<String>any())).thenReturn(true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new PathElement("emptyScope"),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, func, mappings,
        rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    verify(func).apply(eq("emptyScope"));
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Error is {@code no destination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MappingProcessorUtils.setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)"})
  public void testSetValueAndOptionallyUpdateMappings_thenArrayListFirstErrorIsNoDestination() {
    // Arrange
    Function<String, Boolean> func = mock(Function.class);
    when(func.apply(Mockito.<String>any())).thenReturn(false);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, func, mappings,
        mock(RosettaPath.class));

    // Assert
    verify(func).apply(eq("Xml Value"));
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("no destination", getResult.getError());
    assertNull(getResult.getRosettaPath());
    assertNull(getResult.getRosettaValue());
    assertTrue(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Error is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MappingProcessorUtils.setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)"})
  public void testSetValueAndOptionallyUpdateMappings_thenArrayListFirstErrorIsNull() {
    // Arrange
    Function<String, Boolean> func = mock(Function.class);
    when(func.apply(Mockito.<String>any())).thenReturn(true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, func, mappings,
        rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    verify(func).apply(eq("Xml Value"));
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first RosettaPath is {@link Path#Path()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MappingProcessorUtils.setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)"})
  public void testSetValueAndOptionallyUpdateMappings_thenArrayListFirstRosettaPathIsPath() {
    // Arrange
    Path synonymPath = new Path();
    Function<String, Boolean> func = mock(Function.class);
    when(func.apply(Mockito.<String>any())).thenReturn(true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(synonymPath, func, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    verify(func).apply(eq("Xml Value"));
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
    assertEquals(synonymPath, getResult.getRosettaPath());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MappingProcessorUtils.setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)"})
  public void testSetValueAndOptionallyUpdateMappings_thenArrayListSizeIsTwo() {
    // Arrange
    Function<String, Boolean> func = mock(Function.class);
    when(func.apply(Mockito.<String>any())).thenReturn(true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(ScopeReferenceHelper.EMPTY_SCOPE, func, mappings,
        rosettaPath);

    // Assert
    verify(rosettaPath, atLeast(1)).allElements();
    verify(func).apply(eq("Xml Value"));
    assertEquals(2, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}.
   * <ul>
   *   <li>When valueOf {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MappingProcessorUtils.setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)"})
  public void testSetValueAndOptionallyUpdateMappings_whenValueOfPath() {
    // Arrange
    Path synonymPath = Path.valueOf("Path");
    Function<String, Boolean> func = mock(Function.class);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(synonymPath, func, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("An error occurred", getResult.getError());
    Path rosettaPath = getResult.getRosettaPath();
    assertEquals(1, rosettaPath.getElements().size());
    assertEquals(1, rosettaPath.getPathNames().length);
    assertTrue(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#filterListMappings(List, Path)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterListMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterListMappings(List, Path)"})
  public void testFilterListMappings_thenReturnArrayList() {
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
   * Test {@link MappingProcessorUtils#filterListMappings(List, Path)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterListMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterListMappings(List, Path)"})
  public void testFilterListMappings_thenReturnEmpty() {
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
   * Test {@link MappingProcessorUtils#filterListMappings(List, Path)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterListMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterListMappings(List, Path)"})
  public void testFilterListMappings_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    List<Mapping> actualFilterListMappingsResult = MappingProcessorUtils.filterListMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(2, actualFilterListMappingsResult.size());
    assertSame(mapping, actualFilterListMappingsResult.get(1));
  }

  /**
   * Test {@link MappingProcessorUtils#filterListMappings(List, Path)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterListMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterListMappings(List, Path)"})
  public void testFilterListMappings_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Mapping> actualFilterListMappingsResult = MappingProcessorUtils.filterListMappings(new ArrayList<>(),
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterListMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, RosettaPath)} with {@code mappings}, {@code rosettaPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, RosettaPath)"})
  public void testFilterMappingsWithMappingsRosettaPath() {
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
   * Test {@link MappingProcessorUtils#filterMappings(List, RosettaPath)} with {@code mappings}, {@code rosettaPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, RosettaPath)"})
  public void testFilterMappingsWithMappingsRosettaPath2() {
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
   * Test {@link MappingProcessorUtils#filterMappings(List, RosettaPath)} with {@code mappings}, {@code rosettaPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, RosettaPath)"})
  public void testFilterMappingsWithMappingsRosettaPath3() {
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
   * Test {@link MappingProcessorUtils#filterMappings(List, RosettaPath)} with {@code mappings}, {@code rosettaPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, RosettaPath)"})
  public void testFilterMappingsWithMappingsRosettaPath4() {
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
   * Test {@link MappingProcessorUtils#filterMappings(List, RosettaPath)} with {@code mappings}, {@code rosettaPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, RosettaPath)"})
  public void testFilterMappingsWithMappingsRosettaPath5() {
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
   * Test {@link MappingProcessorUtils#filterMappings(List, RosettaPath)} with {@code mappings}, {@code rosettaPath}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, RosettaPath)"})
  public void testFilterMappingsWithMappingsRosettaPath_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(new ArrayList<>(),
        mock(RosettaPath.class));

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path)} with {@code mappings}, {@code synonymPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path)"})
  public void testFilterMappingsWithMappingsSynonymPath() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(1, actualFilterMappingsResult.size());
    assertSame(mapping, actualFilterMappingsResult.get(0));
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path)} with {@code mappings}, {@code synonymPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path)"})
  public void testFilterMappingsWithMappingsSynonymPath2() {
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
   * Test {@link MappingProcessorUtils#filterMappings(List, Path)} with {@code mappings}, {@code synonymPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path)"})
  public void testFilterMappingsWithMappingsSynonymPath3() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings, new Path());

    // Assert
    assertEquals(1, actualFilterMappingsResult.size());
    assertSame(mapping, actualFilterMappingsResult.get(0));
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings}, {@code synonymPath}, {@code startsWithModelPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  public void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(1, actualFilterMappingsResult.size());
    assertSame(mapping, actualFilterMappingsResult.get(0));
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings}, {@code synonymPath}, {@code startsWithModelPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  public void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath2() {
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
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings}, {@code synonymPath}, {@code startsWithModelPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  public void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath3() {
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
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings}, {@code synonymPath}, {@code startsWithModelPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  public void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath4() {
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
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings}, {@code synonymPath}, {@code startsWithModelPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  public void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath5() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings, new Path(),
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(1, actualFilterMappingsResult.size());
    assertSame(mapping, actualFilterMappingsResult.get(0));
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings}, {@code synonymPath}, {@code startsWithModelPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  public void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath6() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", new Path(), "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, new Path());

    // Assert
    assertEquals(1, actualFilterMappingsResult.size());
    assertSame(mapping, actualFilterMappingsResult.get(0));
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings}, {@code synonymPath}, {@code startsWithModelPath}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  public void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(2, actualFilterMappingsResult.size());
    assertSame(mapping, actualFilterMappingsResult.get(1));
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings}, {@code synonymPath}, {@code startsWithModelPath}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  public void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath_whenArrayList() {
    // Arrange and Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(new ArrayList<>(),
        ScopeReferenceHelper.EMPTY_SCOPE, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings}, {@code synonymPath}, {@code startsWithModelPath}.
   * <ul>
   *   <li>When {@link Path#Path()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  public void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath_whenPath() {
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
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings}, {@code synonymPath}, {@code startsWithModelPath}.
   * <ul>
   *   <li>When {@link Path#Path()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  public void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath_whenPath2() {
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
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings}, {@code synonymPath}, {@code startsWithModelPath}.
   * <ul>
   *   <li>When valueOf {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  public void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath_whenValueOfPath() {
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
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings}, {@code synonymPath}, {@code startsWithModelPath}.
   * <ul>
   *   <li>When valueOf {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  public void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath_whenValueOfPath2() {
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
   * Test {@link MappingProcessorUtils#filterMappings(List, Path)} with {@code mappings}, {@code synonymPath}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path)"})
  public void testFilterMappingsWithMappingsSynonymPath_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(2, actualFilterMappingsResult.size());
    assertSame(mapping, actualFilterMappingsResult.get(1));
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path)} with {@code mappings}, {@code synonymPath}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path)"})
  public void testFilterMappingsWithMappingsSynonymPath_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Mapping> actualFilterMappingsResult = MappingProcessorUtils.filterMappings(new ArrayList<>(),
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path)} with {@code mappings}, {@code synonymPath}.
   * <ul>
   *   <li>When {@link Path#Path()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path)"})
  public void testFilterMappingsWithMappingsSynonymPath_whenPath_thenReturnEmpty() {
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
   * Test {@link MappingProcessorUtils#filterMappings(List, Path)} with {@code mappings}, {@code synonymPath}.
   * <ul>
   *   <li>When valueOf {@code Path}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path)"})
  public void testFilterMappingsWithMappingsSynonymPath_whenValueOfPath_thenReturnEmpty() {
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
   * Test {@link MappingProcessorUtils#getEmptyMappings(List, Path)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getEmptyMappings(List, Path)"})
  public void testGetEmptyMappings() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    List<Mapping> actualEmptyMappings = MappingProcessorUtils.getEmptyMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(1, actualEmptyMappings.size());
    assertSame(mapping, actualEmptyMappings.get(0));
  }

  /**
   * Test {@link MappingProcessorUtils#getEmptyMappings(List, Path)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getEmptyMappings(List, Path)"})
  public void testGetEmptyMappings2() {
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
   * Test {@link MappingProcessorUtils#getEmptyMappings(List, Path)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getEmptyMappings(List, Path)"})
  public void testGetEmptyMappings3() {
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
   * Test {@link MappingProcessorUtils#getEmptyMappings(List, Path)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getEmptyMappings(List, Path)"})
  public void testGetEmptyMappings4() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", null, "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    List<Mapping> actualEmptyMappings = MappingProcessorUtils.getEmptyMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(1, actualEmptyMappings.size());
    assertSame(mapping, actualEmptyMappings.get(0));
  }

  /**
   * Test {@link MappingProcessorUtils#getEmptyMappings(List, Path)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getEmptyMappings(List, Path)"})
  public void testGetEmptyMappings5() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    List<Mapping> actualEmptyMappings = MappingProcessorUtils.getEmptyMappings(mappings, new Path());

    // Assert
    assertEquals(1, actualEmptyMappings.size());
    assertSame(mapping, actualEmptyMappings.get(0));
  }

  /**
   * Test {@link MappingProcessorUtils#getEmptyMappings(List, Path)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getEmptyMappings(List, Path)"})
  public void testGetEmptyMappings_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    List<Mapping> actualEmptyMappings = MappingProcessorUtils.getEmptyMappings(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(2, actualEmptyMappings.size());
    assertSame(mapping, actualEmptyMappings.get(1));
  }

  /**
   * Test {@link MappingProcessorUtils#getEmptyMappings(List, Path)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getEmptyMappings(List, Path)"})
  public void testGetEmptyMappings_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Mapping> actualEmptyMappings = MappingProcessorUtils.getEmptyMappings(new ArrayList<>(),
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualEmptyMappings.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#getEmptyMappings(List, Path)}.
   * <ul>
   *   <li>When {@link Path#Path()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getEmptyMappings(List, Path)"})
  public void testGetEmptyMappings_whenPath() {
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
   * Test {@link MappingProcessorUtils#getEmptyMappings(List, Path)}.
   * <ul>
   *   <li>When valueOf {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getEmptyMappings(List, Path)"})
  public void testGetEmptyMappings_whenValueOfPath() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List)} with {@code filteredMappings}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code Xml Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List)"})
  public void testGetNonNullMappedValueWithFilteredMappings_thenReturnGetIsXmlValue() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List)} with {@code filteredMappings}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code Xml Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List)"})
  public void testGetNonNullMappedValueWithFilteredMappings_thenReturnGetIsXmlValue2() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List)} with {@code filteredMappings}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List)"})
  public void testGetNonNullMappedValueWithFilteredMappings_whenArrayList_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(new ArrayList<>());

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  public void testGetNonNullMappedValueWithMappingsStartsWithEndsWith() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  public void testGetNonNullMappedValueWithMappingsStartsWithEndsWith2() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  public void testGetNonNullMappedValueWithMappingsStartsWithEndsWith3() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  public void testGetNonNullMappedValueWithMappingsStartsWithEndsWith4() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  public void testGetNonNullMappedValueWithMappingsStartsWithEndsWith5() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  public void testGetNonNullMappedValueWithMappingsStartsWithEndsWith6() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  public void testGetNonNullMappedValueWithMappingsStartsWithEndsWith7() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new PathElement("emptyScope"),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, "emptyScope");

    // Assert
    assertEquals("emptyScope", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  public void testGetNonNullMappedValueWithMappingsStartsWithEndsWith8() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new PathElement("emptyScope", 1),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE, "emptyScope");

    // Assert
    assertEquals("emptyScope(1)", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code Xml Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  public void testGetNonNullMappedValueWithMappingsStartsWithEndsWith_thenReturnGetIsXmlValue() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  public void testGetNonNullMappedValueWithMappingsStartsWithEndsWith_whenArrayList() {
    // Arrange and Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils.getNonNullMappedValue(new ArrayList<>(),
        ScopeReferenceHelper.EMPTY_SCOPE, "Ends With");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <ul>
   *   <li>When {@link Path#Path()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  public void testGetNonNullMappedValueWithMappingsStartsWithEndsWith_whenPath() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <ul>
   *   <li>When valueOf {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  public void testGetNonNullMappedValueWithMappingsStartsWithEndsWith_whenValueOfPath() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)} with {@code synonymPath}, {@code mappings}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(Path, List)"})
  public void testGetNonNullMappedValueWithSynonymPathMappings() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)} with {@code synonymPath}, {@code mappings}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(Path, List)"})
  public void testGetNonNullMappedValueWithSynonymPathMappings2() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)} with {@code synonymPath}, {@code mappings}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code emptyScope}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(Path, List)"})
  public void testGetNonNullMappedValueWithSynonymPathMappings_thenReturnGetIsEmptyScope() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new PathElement("emptyScope"),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils
        .getNonNullMappedValue(ScopeReferenceHelper.EMPTY_SCOPE, mappings);

    // Assert
    assertEquals("emptyScope", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)} with {@code synonymPath}, {@code mappings}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code emptyScope(1)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(Path, List)"})
  public void testGetNonNullMappedValueWithSynonymPathMappings_thenReturnGetIsEmptyScope1() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, new PathElement("emptyScope", 1),
        ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils
        .getNonNullMappedValue(ScopeReferenceHelper.EMPTY_SCOPE, mappings);

    // Assert
    assertEquals("emptyScope(1)", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)} with {@code synonymPath}, {@code mappings}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code Xml Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(Path, List)"})
  public void testGetNonNullMappedValueWithSynonymPathMappings_thenReturnGetIsXmlValue() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils
        .getNonNullMappedValue(ScopeReferenceHelper.EMPTY_SCOPE, mappings);

    // Assert
    assertEquals("Xml Value", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)} with {@code synonymPath}, {@code mappings}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code Xml Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(Path, List)"})
  public void testGetNonNullMappedValueWithSynonymPathMappings_thenReturnGetIsXmlValue2() {
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
    assertEquals("Xml Value", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)} with {@code synonymPath}, {@code mappings}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(Path, List)"})
  public void testGetNonNullMappedValueWithSynonymPathMappings_whenArrayList() {
    // Arrange and Act
    Optional<String> actualNonNullMappedValue = MappingProcessorUtils
        .getNonNullMappedValue(ScopeReferenceHelper.EMPTY_SCOPE, new ArrayList<>());

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)} with {@code synonymPath}, {@code mappings}.
   * <ul>
   *   <li>When {@link Path#Path()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(Path, List)"})
  public void testGetNonNullMappedValueWithSynonymPathMappings_whenPath_thenReturnNotPresent() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)} with {@code synonymPath}, {@code mappings}.
   * <ul>
   *   <li>When valueOf {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(Path, List)"})
  public void testGetNonNullMappedValueWithSynonymPathMappings_whenValueOfPath() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code synonymPathEndsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"})
  public void testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith() {
    // Arrange and Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(new ArrayList<>(),
        mock(RosettaPath.class), ScopeReferenceHelper.EMPTY_SCOPE, "Synonym Path Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code synonymPathEndsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"})
  public void testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith2() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code synonymPathEndsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"})
  public void testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith3() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code synonymPathEndsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"})
  public void testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith4() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code synonymPathEndsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"})
  public void testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith5() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code synonymPathEndsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"})
  public void testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith6() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code synonymPathEndsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"})
  public void testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith7() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code synonymPathEndsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"})
  public void testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith8() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code synonymPathEndsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"})
  public void testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith9() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code synonymPathEndsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"})
  public void testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith10() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  public void testGetNonNullMappingWithMappingsStartsWithEndsWith() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  public void testGetNonNullMappingWithMappingsStartsWithEndsWith2() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  public void testGetNonNullMappingWithMappingsStartsWithEndsWith3() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  public void testGetNonNullMappingWithMappingsStartsWithEndsWith4() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  public void testGetNonNullMappingWithMappingsStartsWithEndsWith5() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  public void testGetNonNullMappingWithMappingsStartsWithEndsWith6() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <ul>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  public void testGetNonNullMappingWithMappingsStartsWithEndsWith_thenReturnPresent() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  public void testGetNonNullMappingWithMappingsStartsWithEndsWith_whenArrayList() {
    // Arrange and Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(new ArrayList<>(),
        ScopeReferenceHelper.EMPTY_SCOPE, "Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <ul>
   *   <li>When {@link Path#Path()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  public void testGetNonNullMappingWithMappingsStartsWithEndsWith_whenPath() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code mappings}, {@code startsWith}, {@code endsWith}.
   * <ul>
   *   <li>When valueOf {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  public void testGetNonNullMappingWithMappingsStartsWithEndsWith_whenValueOfPath() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path)} with {@code mappings}, {@code synonymPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path)"})
  public void testGetNonNullMappingWithMappingsSynonymPath() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertSame(mapping, actualNonNullMapping.get());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path)} with {@code mappings}, {@code synonymPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path)"})
  public void testGetNonNullMappingWithMappingsSynonymPath2() {
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
    assertSame(mapping, actualNonNullMapping.get());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path)} with {@code mappings}, {@code synonymPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path)"})
  public void testGetNonNullMappingWithMappingsSynonymPath3() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path)} with {@code mappings}, {@code synonymPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path)"})
  public void testGetNonNullMappingWithMappingsSynonymPath4() {
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
    assertSame(mapping, actualNonNullMapping.get());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path)} with {@code mappings}, {@code synonymPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path)"})
  public void testGetNonNullMappingWithMappingsSynonymPath5() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path)} with {@code mappings}, {@code synonymPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path)"})
  public void testGetNonNullMappingWithMappingsSynonymPath6() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(mappings, new Path());

    // Assert
    assertSame(mapping, actualNonNullMapping.get());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path)} with {@code mappings}, {@code synonymPath}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path)"})
  public void testGetNonNullMappingWithMappingsSynonymPath_whenArrayList_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Mapping> actualNonNullMapping = MappingProcessorUtils.getNonNullMapping(new ArrayList<>(),
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path)} with {@code mappings}, {@code synonymPath}.
   * <ul>
   *   <li>When {@link Path#Path()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path)"})
  public void testGetNonNullMappingWithMappingsSynonymPath_whenPath_thenReturnNotPresent() {
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
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path)} with {@code mappings}, {@code synonymPath}.
   * <ul>
   *   <li>When valueOf {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path)"})
  public void testGetNonNullMappingWithMappingsSynonymPath_whenValueOfPath() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappingForModelPath(List, Path)"})
  public void testGetNonNullMappingForModelPath() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    Optional<Mapping> actualNonNullMappingForModelPath = MappingProcessorUtils.getNonNullMappingForModelPath(mappings,
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertSame(mapping, actualNonNullMappingForModelPath.get());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappingForModelPath(List, Path)"})
  public void testGetNonNullMappingForModelPath2() {
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
    assertSame(mapping, actualNonNullMappingForModelPath.get());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappingForModelPath(List, Path)"})
  public void testGetNonNullMappingForModelPath3() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappingForModelPath(List, Path)"})
  public void testGetNonNullMappingForModelPath4() {
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
    assertSame(mapping, actualNonNullMappingForModelPath.get());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappingForModelPath(List, Path)"})
  public void testGetNonNullMappingForModelPath5() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappingForModelPath(List, Path)"})
  public void testGetNonNullMappingForModelPath6() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappingForModelPath(List, Path)"})
  public void testGetNonNullMappingForModelPath7() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", new Path(), "Rosetta Value",
        "An error occurred", true, true, true);

    mappings.add(mapping);

    // Act
    Optional<Mapping> actualNonNullMappingForModelPath = MappingProcessorUtils.getNonNullMappingForModelPath(mappings,
        new Path());

    // Assert
    assertSame(mapping, actualNonNullMappingForModelPath.get());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappingForModelPath(List, Path)"})
  public void testGetNonNullMappingForModelPath_whenArrayList_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Mapping> actualNonNullMappingForModelPath = MappingProcessorUtils
        .getNonNullMappingForModelPath(new ArrayList<>(), ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertFalse(actualNonNullMappingForModelPath.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}.
   * <ul>
   *   <li>When {@link Path#Path()}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappingForModelPath(List, Path)"})
  public void testGetNonNullMappingForModelPath_whenPath_thenReturnNotPresent() {
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
   * Test {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}.
   * <ul>
   *   <li>When valueOf {@code Path}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappingForModelPath(List, Path)"})
  public void testGetNonNullMappingForModelPath_whenValueOfPath_thenReturnNotPresent() {
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
   * Test {@link MappingProcessorUtils#subPath(String, Path)}.
   * <ul>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#subPath(String, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional MappingProcessorUtils.subPath(String, Path)"})
  public void testSubPath_whenEmpty_scope_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Path> actualSubPathResult = MappingProcessorUtils.subPath("Last Element",
        ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertFalse(actualSubPathResult.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Error is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.updateMappings(Path, List, RosettaPath)"})
  public void testUpdateMappings_thenArrayListFirstErrorIsNull() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.updateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first RosettaPath is {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.updateMappings(Path, List, RosettaPath)"})
  public void testUpdateMappings_thenArrayListFirstRosettaPathIsEmpty_scope() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));

    // Act
    MappingProcessorUtils.updateMappings(synonymPath, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("An error occurred", getResult.getError());
    assertTrue(getResult.isDuplicate());
    assertSame(synonymPath, getResult.getRosettaPath());
  }

  /**
   * Test {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first RosettaPath is {@link Path#Path()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.updateMappings(Path, List, RosettaPath)"})
  public void testUpdateMappings_thenArrayListFirstRosettaPathIsPath() {
    // Arrange
    Path synonymPath = new Path();

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(new Path(), "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE, "Rosetta Value",
        "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.updateMappings(synonymPath, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
    assertEquals(synonymPath, getResult.getRosettaPath());
  }

  /**
   * Test {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.updateMappings(Path, List, RosettaPath)"})
  public void testUpdateMappings_thenArrayListSizeIsTwo() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.updateMappings(ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath, atLeast(1)).allElements();
    assertEquals(2, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>When {@link Path#Path()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} first RosettaPath Elements size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.updateMappings(Path, List, RosettaPath)"})
  public void testUpdateMappings_whenPath_thenArrayListFirstRosettaPathElementsSizeIsOne() {
    // Arrange
    Path synonymPath = new Path();

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    MappingProcessorUtils.updateMappings(synonymPath, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("An error occurred", getResult.getError());
    Path rosettaPath = getResult.getRosettaPath();
    assertEquals(1, rosettaPath.getElements().size());
    assertEquals(1, rosettaPath.getPathNames().length);
    assertTrue(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}.
   * <ul>
   *   <li>When valueOf {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.updateMappings(Path, List, RosettaPath)"})
  public void testUpdateMappings_whenValueOfPath() {
    // Arrange
    Path synonymPath = Path.valueOf("Path");

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    MappingProcessorUtils.updateMappings(synonymPath, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("An error occurred", getResult.getError());
    Path rosettaPath = getResult.getRosettaPath();
    assertEquals(1, rosettaPath.getElements().size());
    assertEquals(1, rosettaPath.getPathNames().length);
    assertTrue(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#updateMappingSuccess(Mapping, Path)} with {@code Mapping}, {@code Path}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#updateMappingSuccess(Mapping, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.updateMappingSuccess(Mapping, Path)"})
  public void testUpdateMappingSuccessWithMappingPath() {
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
   * Test {@link MappingProcessorUtils#updateMappingSuccess(Mapping, RosettaPath)} with {@code Mapping}, {@code RosettaPath}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#updateMappingSuccess(Mapping, RosettaPath)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.updateMappingSuccess(Mapping, RosettaPath)"})
  public void testUpdateMappingSuccessWithMappingRosettaPath() {
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
    PathElement lastElement = xmlPath.getLastElement();
    assertEquals("emptyScope", lastElement.getPathName());
    Path rosettaPath2 = mapping.getRosettaPath();
    assertNull(rosettaPath2.getLastElement());
    assertNull(mapping.getError());
    assertEquals(0, rosettaPath2.getPathNames().length);
    List<PathElement> elements = xmlPath.getElements();
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
   * Test {@link MappingProcessorUtils#updateMappingFail(Mapping, String)}.
   * <p>
   * Method under test: {@link MappingProcessorUtils#updateMappingFail(Mapping, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MappingProcessorUtils.updateMappingFail(Mapping, String)"})
  public void testUpdateMappingFail() {
    // Arrange
    Mapping mapping = new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true);

    // Act
    MappingProcessorUtils.updateMappingFail(mapping, "An error occurred");

    // Assert
    Path xmlPath = mapping.getXmlPath();
    PathElement lastElement = xmlPath.getLastElement();
    assertEquals("emptyScope", lastElement.getPathName());
    Path parent = xmlPath.getParent();
    assertNull(parent.getLastElement());
    assertNull(mapping.getRosettaPath());
    assertNull(mapping.getRosettaValue());
    assertEquals(0, parent.getPathNames().length);
    List<PathElement> elements = xmlPath.getElements();
    assertEquals(1, elements.size());
    assertFalse(lastElement.getIndex().isPresent());
    assertTrue(parent.getElements().isEmpty());
    assertTrue(lastElement.getMetas().isEmpty());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[]{"emptyScope"}, xmlPath.getPathNames());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValueList(List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValueList(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getNonNullMappedValueList(List)"})
  public void testGetNonNullMappedValueList_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Mapping> filteredMappings = new ArrayList<>();
    filteredMappings.add(new Mapping(ScopeReferenceHelper.EMPTY_SCOPE, "Xml Value", ScopeReferenceHelper.EMPTY_SCOPE,
        "Rosetta Value", "An error occurred", true, true, true));

    // Act
    List<String> actualNonNullMappedValueList = MappingProcessorUtils.getNonNullMappedValueList(filteredMappings);

    // Assert
    assertEquals(1, actualNonNullMappedValueList.size());
    assertEquals("Xml Value", actualNonNullMappedValueList.get(0));
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValueList(List)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValueList(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getNonNullMappedValueList(List)"})
  public void testGetNonNullMappedValueList_thenReturnSizeIsTwo() {
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
    assertEquals("Xml Value", actualNonNullMappedValueList.get(0));
    assertEquals("Xml Value", actualNonNullMappedValueList.get(1));
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValueList(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MappingProcessorUtils#getNonNullMappedValueList(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MappingProcessorUtils.getNonNullMappedValueList(List)"})
  public void testGetNonNullMappedValueList_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualNonNullMappedValueList = MappingProcessorUtils.getNonNullMappedValueList(new ArrayList<>());

    // Assert
    assertTrue(actualNonNullMappedValueList.isEmpty());
  }
}
