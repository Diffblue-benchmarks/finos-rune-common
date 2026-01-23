package com.regnosys.rosetta.common.translation;

/*-
 * ==============
 * Rune Common
 * ==============
 * Copyright (C) 2018 - 2026 REGnosys
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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.regnosys.rosetta.common.hashing.ScopeReferenceHelper;
import com.regnosys.rosetta.common.translation.Path.PathElement;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.path.RosettaPath.NullPath;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MappingProcessorUtilsDiffblueTest {
  /**
   * Test {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Error is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List,
   * RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test getValueAndUpdateMappings(Path, List, RosettaPath); then ArrayList() first Error is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional MappingProcessorUtils.getValueAndUpdateMappings(Path, List, RosettaPath)"
  })
  void testGetValueAndUpdateMappings_thenArrayListFirstErrorIsAnErrorOccurred() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Path xmlPath = new Path();
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    // Act
    Optional<String> actualValueAndUpdateMappings =
        MappingProcessorUtils.getValueAndUpdateMappings(
            synonymPath, mappings, mock(RosettaPath.class));

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
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code emptyScope}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List,
   * RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test getValueAndUpdateMappings(Path, List, RosettaPath); then return get() is 'emptyScope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional MappingProcessorUtils.getValueAndUpdateMappings(Path, List, RosettaPath)"
  })
  void testGetValueAndUpdateMappings_thenReturnGetIsEmptyScope() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            PathElement.parse("emptyScope", true),
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<String> actualValueAndUpdateMappings =
        MappingProcessorUtils.getValueAndUpdateMappings(synonymPath, mappings, rosettaPath);

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
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code emptyScope(1)}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List,
   * RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test getValueAndUpdateMappings(Path, List, RosettaPath); then return get() is 'emptyScope(1)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional MappingProcessorUtils.getValueAndUpdateMappings(Path, List, RosettaPath)"
  })
  void testGetValueAndUpdateMappings_thenReturnGetIsEmptyScope1() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            new PathElement("emptyScope", 1),
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<String> actualValueAndUpdateMappings =
        MappingProcessorUtils.getValueAndUpdateMappings(synonymPath, mappings, rosettaPath);

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
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code NON_EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List,
   * RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test getValueAndUpdateMappings(Path, List, RosettaPath); then return get() is 'NON_EMPTY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional MappingProcessorUtils.getValueAndUpdateMappings(Path, List, RosettaPath)"
  })
  void testGetValueAndUpdateMappings_thenReturnGetIsNonEmpty() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<String> actualValueAndUpdateMappings =
        MappingProcessorUtils.getValueAndUpdateMappings(synonymPath, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertEquals("NON_EMPTY", actualValueAndUpdateMappings.get());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
    assertTrue(actualValueAndUpdateMappings.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List, RosettaPath)}.
   *
   * <ul>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getValueAndUpdateMappings(Path, List,
   * RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test getValueAndUpdateMappings(Path, List, RosettaPath); when EMPTY_SCOPE; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional MappingProcessorUtils.getValueAndUpdateMappings(Path, List, RosettaPath)"
  })
  void testGetValueAndUpdateMappings_whenEmpty_scope_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualValueAndUpdateMappings =
        MappingProcessorUtils.getValueAndUpdateMappings(
            ScopeReferenceHelper.EMPTY_SCOPE, new ArrayList<>(), mock(RosettaPath.class));

    // Assert
    assertFalse(actualValueAndUpdateMappings.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Error is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List,
   * RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test getValueListAndUpdateMappings(Path, List, RosettaPath); then ArrayList() first Error is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List MappingProcessorUtils.getValueListAndUpdateMappings(Path, List, RosettaPath)"
  })
  void testGetValueListAndUpdateMappings_thenArrayListFirstErrorIsAnErrorOccurred() {
    // Arrange
    Path synonymPath = new Path();

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);

    // Act
    List<String> actualValueListAndUpdateMappings =
        MappingProcessorUtils.getValueListAndUpdateMappings(
            synonymPath, mappings, mock(RosettaPath.class));

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
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List,
   * RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test getValueListAndUpdateMappings(Path, List, RosettaPath); then ArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List MappingProcessorUtils.getValueListAndUpdateMappings(Path, List, RosettaPath)"
  })
  void testGetValueListAndUpdateMappings_thenArrayListSizeIsTwo() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    List<String> actualValueListAndUpdateMappings =
        MappingProcessorUtils.getValueListAndUpdateMappings(
            ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath, atLeast(1)).allElements();
    assertEquals(2, mappings.size());
    assertEquals(2, actualValueListAndUpdateMappings.size());
    assertEquals("NON_EMPTY", actualValueListAndUpdateMappings.get(0));
    assertEquals("NON_EMPTY", actualValueListAndUpdateMappings.get(1));
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}.
   *
   * <ul>
   *   <li>Then return first is {@code emptyScope}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List,
   * RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test getValueListAndUpdateMappings(Path, List, RosettaPath); then return first is 'emptyScope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List MappingProcessorUtils.getValueListAndUpdateMappings(Path, List, RosettaPath)"
  })
  void testGetValueListAndUpdateMappings_thenReturnFirstIsEmptyScope() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            PathElement.parse("emptyScope", true),
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    List<String> actualValueListAndUpdateMappings =
        MappingProcessorUtils.getValueListAndUpdateMappings(
            ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

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
   *
   * <ul>
   *   <li>Then return first is {@code emptyScope(1)}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List,
   * RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test getValueListAndUpdateMappings(Path, List, RosettaPath); then return first is 'emptyScope(1)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List MappingProcessorUtils.getValueListAndUpdateMappings(Path, List, RosettaPath)"
  })
  void testGetValueListAndUpdateMappings_thenReturnFirstIsEmptyScope1() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            new PathElement("emptyScope", 1),
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    List<String> actualValueListAndUpdateMappings =
        MappingProcessorUtils.getValueListAndUpdateMappings(
            ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

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
   *
   * <ul>
   *   <li>Then return first is {@code NON_EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List,
   * RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test getValueListAndUpdateMappings(Path, List, RosettaPath); then return first is 'NON_EMPTY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List MappingProcessorUtils.getValueListAndUpdateMappings(Path, List, RosettaPath)"
  })
  void testGetValueListAndUpdateMappings_thenReturnFirstIsNonEmpty() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    List<String> actualValueListAndUpdateMappings =
        MappingProcessorUtils.getValueListAndUpdateMappings(
            ScopeReferenceHelper.EMPTY_SCOPE, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    assertEquals(1, actualValueListAndUpdateMappings.size());
    assertEquals("NON_EMPTY", actualValueListAndUpdateMappings.get(0));
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List, RosettaPath)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getValueListAndUpdateMappings(Path, List,
   * RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test getValueListAndUpdateMappings(Path, List, RosettaPath); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List MappingProcessorUtils.getValueListAndUpdateMappings(Path, List, RosettaPath)"
  })
  void testGetValueListAndUpdateMappings_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualValueListAndUpdateMappings =
        MappingProcessorUtils.getValueListAndUpdateMappings(
            ScopeReferenceHelper.EMPTY_SCOPE, new ArrayList<>(), mock(RosettaPath.class));

    // Assert
    assertTrue(actualValueListAndUpdateMappings.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List,
   * RosettaPath)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Error is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer,
   * List, RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test setValueAndUpdateMappings(Path, Consumer, List, RosettaPath); then ArrayList() first Error is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MappingProcessorUtils.setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)"
  })
  void testSetValueAndUpdateMappings_thenArrayListFirstErrorIsAnErrorOccurred() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Path xmlPath = new Path();
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    Consumer<String> setter = mapping::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(
        synonymPath, setter, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("An error occurred", getResult.getError());
    assertTrue(getResult.isDuplicate());
    assertSame(synonymPath, getResult.getRosettaPath());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List,
   * RosettaPath)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Error is {@code emptyScope}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer,
   * List, RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test setValueAndUpdateMappings(Path, Consumer, List, RosettaPath); then ArrayList() first Error is 'emptyScope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MappingProcessorUtils.setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)"
  })
  void testSetValueAndUpdateMappings_thenArrayListFirstErrorIsEmptyScope() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            PathElement.parse("emptyScope", true),
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    Consumer<String> setter = mapping::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(synonymPath, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("emptyScope", getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List,
   * RosettaPath)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Error is {@code emptyScope(1)}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer,
   * List, RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test setValueAndUpdateMappings(Path, Consumer, List, RosettaPath); then ArrayList() first Error is 'emptyScope(1)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MappingProcessorUtils.setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)"
  })
  void testSetValueAndUpdateMappings_thenArrayListFirstErrorIsEmptyScope1() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            new PathElement("emptyScope", 1),
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    Consumer<String> setter = mapping::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(synonymPath, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("emptyScope(1)", getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer, List,
   * RosettaPath)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Error is {@code NON_EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#setValueAndUpdateMappings(Path, Consumer,
   * List, RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test setValueAndUpdateMappings(Path, Consumer, List, RosettaPath); then ArrayList() first Error is 'NON_EMPTY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MappingProcessorUtils.setValueAndUpdateMappings(Path, Consumer, List, RosettaPath)"
  })
  void testSetValueAndUpdateMappings_thenArrayListFirstErrorIsNonEmpty() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    Consumer<String> setter = mapping::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndUpdateMappings(synonymPath, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("NON_EMPTY", getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List,
   * RosettaPath)}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path,
   * Consumer, List, RosettaPath)}
   */
  @Test
  @DisplayName("Test setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MappingProcessorUtils.setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)"
  })
  void testSetValueListAndUpdateMappings() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    Consumer<String> setter = mapping::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            PathElement.parse("emptyScope", true),
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueListAndUpdateMappings(
        ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List,
   * RosettaPath)}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path,
   * Consumer, List, RosettaPath)}
   */
  @Test
  @DisplayName("Test setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MappingProcessorUtils.setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)"
  })
  void testSetValueListAndUpdateMappings2() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    Consumer<String> setter = mapping::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            new PathElement("emptyScope", 1),
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueListAndUpdateMappings(
        ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List,
   * RosettaPath)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Error is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path,
   * Consumer, List, RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath); then ArrayList() first Error is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MappingProcessorUtils.setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)"
  })
  void testSetValueListAndUpdateMappings_thenArrayListFirstErrorIsAnErrorOccurred() {
    // Arrange
    Path synonymPath = new Path();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    Consumer<String> setter = mapping::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    MappingProcessorUtils.setValueListAndUpdateMappings(
        synonymPath, setter, mappings, mock(RosettaPath.class));

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
   * Test {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List,
   * RosettaPath)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path,
   * Consumer, List, RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath); then ArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MappingProcessorUtils.setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)"
  })
  void testSetValueListAndUpdateMappings_thenArrayListSizeIsOne() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    Consumer<String> setter = mapping::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueListAndUpdateMappings(
        ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path, Consumer, List,
   * RosettaPath)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#setValueListAndUpdateMappings(Path,
   * Consumer, List, RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath); then ArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MappingProcessorUtils.setValueListAndUpdateMappings(Path, Consumer, List, RosettaPath)"
  })
  void testSetValueListAndUpdateMappings_thenArrayListSizeIsTwo() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    Consumer<String> setter = mapping::setError;

    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);
    Mapping mapping3 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping3);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueListAndUpdateMappings(
        ScopeReferenceHelper.EMPTY_SCOPE, setter, mappings, rosettaPath);

    // Assert
    verify(rosettaPath, atLeast(1)).allElements();
    assertEquals(2, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
    assertSame(mapping3, mappings.get(1));
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List,
   * RosettaPath)}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path,
   * Function, List, RosettaPath)}
   */
  @Test
  @DisplayName("Test setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MappingProcessorUtils.setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)"
  })
  void testSetValueAndOptionallyUpdateMappings() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Function<String, Boolean> func = mock(Function.class);
    when(func.apply(Mockito.<String>any())).thenReturn(true);

    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(
        synonymPath, func, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    verify(func).apply("NON_EMPTY");
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List,
   * RosettaPath)}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path,
   * Function, List, RosettaPath)}
   */
  @Test
  @DisplayName("Test setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MappingProcessorUtils.setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)"
  })
  void testSetValueAndOptionallyUpdateMappings2() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Function<String, Boolean> func = mock(Function.class);
    when(func.apply(Mockito.<String>any())).thenReturn(true);

    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            PathElement.parse("emptyScope", true),
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(
        synonymPath, func, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    verify(func).apply("emptyScope");
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List,
   * RosettaPath)}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path,
   * Function, List, RosettaPath)}
   */
  @Test
  @DisplayName("Test setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MappingProcessorUtils.setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)"
  })
  void testSetValueAndOptionallyUpdateMappings3() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Function<String, Boolean> func = mock(Function.class);
    when(func.apply(Mockito.<String>any())).thenReturn(true);

    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            new PathElement("emptyScope", 1),
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(
        synonymPath, func, mappings, rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    verify(func).apply("emptyScope(1)");
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertNull(getResult.getError());
    assertFalse(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List,
   * RosettaPath)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Error is {@code no destination}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path,
   * Function, List, RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath); then ArrayList() first Error is 'no destination'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MappingProcessorUtils.setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)"
  })
  void testSetValueAndOptionallyUpdateMappings_thenArrayListFirstErrorIsNoDestination() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Function<String, Boolean> func = mock(Function.class);
    when(func.apply(Mockito.<String>any())).thenReturn(false);

    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(
        synonymPath, func, mappings, mock(RosettaPath.class));

    // Assert
    verify(func).apply("NON_EMPTY");
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    assertEquals("no destination", getResult.getError());
    assertNull(getResult.getRosettaPath());
    assertNull(getResult.getRosettaValue());
    assertTrue(getResult.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path, Function, List,
   * RosettaPath)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first RosettaValue {@link JsonInclude.Include}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#setValueAndOptionallyUpdateMappings(Path,
   * Function, List, RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath); then ArrayList() first RosettaValue Include")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MappingProcessorUtils.setValueAndOptionallyUpdateMappings(Path, Function, List, RosettaPath)"
  })
  void testSetValueAndOptionallyUpdateMappings_thenArrayListFirstRosettaValueInclude() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    Function<String, Boolean> func = mock(Function.class);

    Path xmlPath = new Path();
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    // Act
    MappingProcessorUtils.setValueAndOptionallyUpdateMappings(
        synonymPath, func, mappings, mock(RosettaPath.class));

    // Assert that nothing has changed
    assertEquals(1, mappings.size());
    Mapping getResult = mappings.get(0);
    Object rosettaValue = getResult.getRosettaValue();
    assertTrue(rosettaValue instanceof Include);
    assertEquals("An error occurred", getResult.getError());
    assertEquals(Include.NON_EMPTY, rosettaValue);
    assertSame(synonymPath, getResult.getRosettaPath());
  }

  /**
   * Test {@link MappingProcessorUtils#filterListMappings(List, Path)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterListMappings(List, Path)}
   */
  @Test
  @DisplayName("Test filterListMappings(List, Path); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterListMappings(List, Path)"})
  void testFilterListMappings_thenReturnArrayList() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);

    // Act
    List<Mapping> actualFilterListMappingsResult =
        MappingProcessorUtils.filterListMappings(mappings, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(mappings, actualFilterListMappingsResult);
  }

  /**
   * Test {@link MappingProcessorUtils#filterListMappings(List, Path)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterListMappings(List, Path)}
   */
  @Test
  @DisplayName("Test filterListMappings(List, Path); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterListMappings(List, Path)"})
  void testFilterListMappings_thenReturnEmpty() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            new Path(),
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);

    // Act
    List<Mapping> actualFilterListMappingsResult =
        MappingProcessorUtils.filterListMappings(mappings, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterListMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterListMappings(List, Path)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterListMappings(List, Path)}
   */
  @Test
  @DisplayName("Test filterListMappings(List, Path); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterListMappings(List, Path)"})
  void testFilterListMappings_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    List<Mapping> actualFilterListMappingsResult =
        MappingProcessorUtils.filterListMappings(mappings, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(2, actualFilterListMappingsResult.size());
    assertSame(mapping2, actualFilterListMappingsResult.get(1));
  }

  /**
   * Test {@link MappingProcessorUtils#filterListMappings(List, Path)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterListMappings(List, Path)}
   */
  @Test
  @DisplayName("Test filterListMappings(List, Path); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterListMappings(List, Path)"})
  void testFilterListMappings_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Mapping> actualFilterListMappingsResult =
        MappingProcessorUtils.filterListMappings(
            new ArrayList<>(), ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterListMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, RosettaPath)} with {@code mappings},
   * {@code rosettaPath}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  @DisplayName("Test filterMappings(List, RosettaPath) with 'mappings', 'rosettaPath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, RosettaPath)"})
  void testFilterMappingsWithMappingsRosettaPath() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);

    // Act
    List<Mapping> actualFilterMappingsResult =
        MappingProcessorUtils.filterMappings(mappings, mock(RosettaPath.class));

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, RosettaPath)} with {@code mappings},
   * {@code rosettaPath}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  @DisplayName("Test filterMappings(List, RosettaPath) with 'mappings', 'rosettaPath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, RosettaPath)"})
  void testFilterMappingsWithMappingsRosettaPath2() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    List<Mapping> actualFilterMappingsResult =
        MappingProcessorUtils.filterMappings(mappings, mock(RosettaPath.class));

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, RosettaPath)} with {@code mappings},
   * {@code rosettaPath}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  @DisplayName("Test filterMappings(List, RosettaPath) with 'mappings', 'rosettaPath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, RosettaPath)"})
  void testFilterMappingsWithMappingsRosettaPath3() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            new Path(),
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);

    // Act
    List<Mapping> actualFilterMappingsResult =
        MappingProcessorUtils.filterMappings(mappings, mock(RosettaPath.class));

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, RosettaPath)} with {@code mappings},
   * {@code rosettaPath}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  @DisplayName("Test filterMappings(List, RosettaPath) with 'mappings', 'rosettaPath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, RosettaPath)"})
  void testFilterMappingsWithMappingsRosettaPath4() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            null,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);

    // Act
    List<Mapping> actualFilterMappingsResult =
        MappingProcessorUtils.filterMappings(mappings, mock(RosettaPath.class));

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, RosettaPath)} with {@code mappings},
   * {@code rosettaPath}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  @DisplayName("Test filterMappings(List, RosettaPath) with 'mappings', 'rosettaPath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, RosettaPath)"})
  void testFilterMappingsWithMappingsRosettaPath5() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            null,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);

    // Act
    List<Mapping> actualFilterMappingsResult =
        MappingProcessorUtils.filterMappings(mappings, mock(RosettaPath.class));

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, RosettaPath)} with {@code mappings},
   * {@code rosettaPath}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  @DisplayName("Test filterMappings(List, RosettaPath) with 'mappings', 'rosettaPath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, RosettaPath)"})
  void testFilterMappingsWithMappingsRosettaPath6() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            new Path(),
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);

    // Act
    List<Mapping> actualFilterMappingsResult =
        MappingProcessorUtils.filterMappings(mappings, new NullPath());

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, RosettaPath)} with {@code mappings},
   * {@code rosettaPath}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test filterMappings(List, RosettaPath) with 'mappings', 'rosettaPath'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, RosettaPath)"})
  void testFilterMappingsWithMappingsRosettaPath_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Mapping> actualFilterMappingsResult =
        MappingProcessorUtils.filterMappings(new ArrayList<>(), mock(RosettaPath.class));

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, RosettaPath)} with {@code mappings},
   * {@code rosettaPath}.
   *
   * <ul>
   *   <li>When {@link NullPath} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterMappings(List, RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test filterMappings(List, RosettaPath) with 'mappings', 'rosettaPath'; when NullPath (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, RosettaPath)"})
  void testFilterMappingsWithMappingsRosettaPath_whenNullPath() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    List<Mapping> actualFilterMappingsResult =
        MappingProcessorUtils.filterMappings(mappings, new NullPath());

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings},
   * {@code synonymPath}, {@code startsWithModelPath}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @DisplayName(
      "Test filterMappings(List, Path, Path) with 'mappings', 'synonymPath', 'startsWithModelPath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath() {
    // Arrange
    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            null,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    // Act
    List<Mapping> actualFilterMappingsResult =
        MappingProcessorUtils.filterMappings(
            mappings, synonymPath, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings},
   * {@code synonymPath}, {@code startsWithModelPath}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @DisplayName(
      "Test filterMappings(List, Path, Path) with 'mappings', 'synonymPath', 'startsWithModelPath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath2() {
    // Arrange
    Path xmlPath = new Path();
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    // Act
    List<Mapping> actualFilterMappingsResult =
        MappingProcessorUtils.filterMappings(
            mappings, synonymPath, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings},
   * {@code synonymPath}, {@code startsWithModelPath}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @DisplayName(
      "Test filterMappings(List, Path, Path) with 'mappings', 'synonymPath', 'startsWithModelPath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath3() {
    // Arrange
    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            new Path(),
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    // Act
    List<Mapping> actualFilterMappingsResult =
        MappingProcessorUtils.filterMappings(
            mappings, synonymPath, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings},
   * {@code synonymPath}, {@code startsWithModelPath}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @DisplayName(
      "Test filterMappings(List, Path, Path) with 'mappings', 'synonymPath', 'startsWithModelPath'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath_thenReturnArrayList() {
    // Arrange
    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    // Act
    List<Mapping> actualFilterMappingsResult =
        MappingProcessorUtils.filterMappings(
            mappings, synonymPath, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(mappings, actualFilterMappingsResult);
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path, Path)} with {@code mappings},
   * {@code synonymPath}, {@code startsWithModelPath}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterMappings(List, Path, Path)}
   */
  @Test
  @DisplayName(
      "Test filterMappings(List, Path, Path) with 'mappings', 'synonymPath', 'startsWithModelPath'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path, Path)"})
  void testFilterMappingsWithMappingsSynonymPathStartsWithModelPath_whenArrayList() {
    // Arrange and Act
    List<Mapping> actualFilterMappingsResult =
        MappingProcessorUtils.filterMappings(
            new ArrayList<>(), ScopeReferenceHelper.EMPTY_SCOPE, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path)} with {@code mappings}, {@code
   * synonymPath}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()} addElement parse {@code foo} and {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  @DisplayName(
      "Test filterMappings(List, Path) with 'mappings', 'synonymPath'; given Path() addElement parse 'foo' and 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path)"})
  void testFilterMappingsWithMappingsSynonymPath_givenPathAddElementParseFooAndTrue() {
    // Arrange
    Path xmlPath = new Path();
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    // Act
    List<Mapping> actualFilterMappingsResult =
        MappingProcessorUtils.filterMappings(mappings, synonymPath);

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path)} with {@code mappings}, {@code
   * synonymPath}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  @DisplayName(
      "Test filterMappings(List, Path) with 'mappings', 'synonymPath'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path)"})
  void testFilterMappingsWithMappingsSynonymPath_thenReturnArrayList() {
    // Arrange
    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    // Act
    List<Mapping> actualFilterMappingsResult =
        MappingProcessorUtils.filterMappings(mappings, synonymPath);

    // Assert
    assertEquals(mappings, actualFilterMappingsResult);
  }

  /**
   * Test {@link MappingProcessorUtils#filterMappings(List, Path)} with {@code mappings}, {@code
   * synonymPath}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#filterMappings(List, Path)}
   */
  @Test
  @DisplayName(
      "Test filterMappings(List, Path) with 'mappings', 'synonymPath'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.filterMappings(List, Path)"})
  void testFilterMappingsWithMappingsSynonymPath_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Mapping> actualFilterMappingsResult =
        MappingProcessorUtils.filterMappings(new ArrayList<>(), ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualFilterMappingsResult.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#getEmptyMappings(List, Path)}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  @DisplayName("Test getEmptyMappings(List, Path)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.getEmptyMappings(List, Path)"})
  void testGetEmptyMappings() {
    // Arrange
    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    // Act
    List<Mapping> actualEmptyMappings =
        MappingProcessorUtils.getEmptyMappings(mappings, synonymPath);

    // Assert
    assertEquals(1, actualEmptyMappings.size());
    assertSame(mapping, actualEmptyMappings.get(0));
  }

  /**
   * Test {@link MappingProcessorUtils#getEmptyMappings(List, Path)}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  @DisplayName("Test getEmptyMappings(List, Path)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.getEmptyMappings(List, Path)"})
  void testGetEmptyMappings2() {
    // Arrange
    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            null,
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    // Act
    List<Mapping> actualEmptyMappings =
        MappingProcessorUtils.getEmptyMappings(mappings, synonymPath);

    // Assert
    assertTrue(actualEmptyMappings.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#getEmptyMappings(List, Path)}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  @DisplayName("Test getEmptyMappings(List, Path)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.getEmptyMappings(List, Path)"})
  void testGetEmptyMappings3() {
    // Arrange
    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            null,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    // Act
    List<Mapping> actualEmptyMappings =
        MappingProcessorUtils.getEmptyMappings(mappings, synonymPath);

    // Assert
    assertEquals(1, actualEmptyMappings.size());
    assertSame(mapping, actualEmptyMappings.get(0));
  }

  /**
   * Test {@link MappingProcessorUtils#getEmptyMappings(List, Path)}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()} addElement parse {@code foo} and {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  @DisplayName("Test getEmptyMappings(List, Path); given Path() addElement parse 'foo' and 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.getEmptyMappings(List, Path)"})
  void testGetEmptyMappings_givenPathAddElementParseFooAndTrue() {
    // Arrange
    Path xmlPath = new Path();
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    // Act
    List<Mapping> actualEmptyMappings =
        MappingProcessorUtils.getEmptyMappings(mappings, synonymPath);

    // Assert
    assertTrue(actualEmptyMappings.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#getEmptyMappings(List, Path)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getEmptyMappings(List, Path)}
   */
  @Test
  @DisplayName("Test getEmptyMappings(List, Path); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.getEmptyMappings(List, Path)"})
  void testGetEmptyMappings_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Mapping> actualEmptyMappings =
        MappingProcessorUtils.getEmptyMappings(new ArrayList<>(), ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertTrue(actualEmptyMappings.isEmpty());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List)} with {@code filteredMappings}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code NON_EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List)}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(List) with 'filteredMappings'; then return get() is 'NON_EMPTY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List)"})
  void testGetNonNullMappedValueWithFilteredMappings_thenReturnGetIsNonEmpty() {
    // Arrange
    ArrayList<Mapping> filteredMappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    filteredMappings.add(mapping);

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(filteredMappings);

    // Assert
    assertEquals("NON_EMPTY", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List)} with {@code filteredMappings}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code NON_EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List)}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(List) with 'filteredMappings'; then return get() is 'NON_EMPTY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List)"})
  void testGetNonNullMappedValueWithFilteredMappings_thenReturnGetIsNonEmpty2() {
    // Arrange
    ArrayList<Mapping> filteredMappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    filteredMappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    filteredMappings.add(mapping2);

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(filteredMappings);

    // Assert
    assertEquals("NON_EMPTY", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List)} with {@code filteredMappings}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List)}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(List) with 'filteredMappings'; when ArrayList(); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List)"})
  void testGetNonNullMappedValueWithFilteredMappings_whenArrayList_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(new ArrayList<>());

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  void testGetNonNullMappedValueWithMappingsStartsWithEndsWith() {
    // Arrange
    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path startsWith = ScopeReferenceHelper.EMPTY_SCOPE;
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(mappings, startsWith, "Ends With");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  void testGetNonNullMappedValueWithMappingsStartsWithEndsWith2() {
    // Arrange
    Path xmlPath = new Path();
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path startsWith = ScopeReferenceHelper.EMPTY_SCOPE;
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(mappings, startsWith, "Ends With");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  void testGetNonNullMappedValueWithMappingsStartsWithEndsWith3() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(
            mappings, ScopeReferenceHelper.EMPTY_SCOPE, "Ends With", "java.lang.Boolean");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  void testGetNonNullMappedValueWithMappingsStartsWithEndsWith4() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            new Path(),
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(mappings, new Path(), "Ends With");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  void testGetNonNullMappedValueWithMappingsStartsWithEndsWith5() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            PathElement.parse("emptyScope", true),
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(mappings, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals("emptyScope", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  void testGetNonNullMappedValueWithMappingsStartsWithEndsWith6() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            null,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(mappings, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals("NON_EMPTY", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  void testGetNonNullMappedValueWithMappingsStartsWithEndsWith7() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            new PathElement("emptyScope", 1),
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(mappings, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals("emptyScope(1)", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code NON_EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'; then return get() is 'NON_EMPTY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  void testGetNonNullMappedValueWithMappingsStartsWithEndsWith_thenReturnGetIsNonEmpty() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(mappings, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals("NON_EMPTY", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  void testGetNonNullMappedValueWithMappingsStartsWithEndsWith_thenReturnNotPresent() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(
            mappings, ScopeReferenceHelper.EMPTY_SCOPE, "Ends With");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  void testGetNonNullMappedValueWithMappingsStartsWithEndsWith_whenArrayList() {
    // Arrange and Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(
            new ArrayList<>(), ScopeReferenceHelper.EMPTY_SCOPE, "Ends With");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <ul>
   *   <li>When {@link Path#Path()}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'; when Path()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  void testGetNonNullMappedValueWithMappingsStartsWithEndsWith_whenPath() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(mappings, new Path(), "Ends With");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <ul>
   *   <li>When valueOf {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'; when valueOf 'Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(List, Path, String[])"})
  void testGetNonNullMappedValueWithMappingsStartsWithEndsWith_whenValueOfPath() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(mappings, Path.valueOf("Path"), "Ends With");

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)} with {@code synonymPath},
   * {@code mappings}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  @DisplayName("Test getNonNullMappedValue(Path, List) with 'synonymPath', 'mappings'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(Path, List)"})
  void testGetNonNullMappedValueWithSynonymPathMappings() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Path xmlPath = new Path();
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(synonymPath, mappings);

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)} with {@code synonymPath},
   * {@code mappings}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code emptyScope}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(Path, List) with 'synonymPath', 'mappings'; then return get() is 'emptyScope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(Path, List)"})
  void testGetNonNullMappedValueWithSynonymPathMappings_thenReturnGetIsEmptyScope() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            PathElement.parse("emptyScope", true),
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(synonymPath, mappings);

    // Assert
    assertEquals("emptyScope", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)} with {@code synonymPath},
   * {@code mappings}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code emptyScope(1)}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(Path, List) with 'synonymPath', 'mappings'; then return get() is 'emptyScope(1)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(Path, List)"})
  void testGetNonNullMappedValueWithSynonymPathMappings_thenReturnGetIsEmptyScope1() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            new PathElement("emptyScope", 1),
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(synonymPath, mappings);

    // Assert
    assertEquals("emptyScope(1)", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)} with {@code synonymPath},
   * {@code mappings}.
   *
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@code NON_EMPTY}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(Path, List) with 'synonymPath', 'mappings'; then return get() is 'NON_EMPTY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(Path, List)"})
  void testGetNonNullMappedValueWithSynonymPathMappings_thenReturnGetIsNonEmpty() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    // Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(synonymPath, mappings);

    // Assert
    assertEquals("NON_EMPTY", actualNonNullMappedValue.get());
    assertTrue(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)} with {@code synonymPath},
   * {@code mappings}.
   *
   * <ul>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValue(Path, List)}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappedValue(Path, List) with 'synonymPath', 'mappings'; when EMPTY_SCOPE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappedValue(Path, List)"})
  void testGetNonNullMappedValueWithSynonymPathMappings_whenEmpty_scope() {
    // Arrange and Act
    Optional<String> actualNonNullMappedValue =
        MappingProcessorUtils.getNonNullMappedValue(
            ScopeReferenceHelper.EMPTY_SCOPE, new ArrayList<>());

    // Assert
    assertFalse(actualNonNullMappedValue.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with
   * {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code
   * synonymPathEndsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, RosettaPath, Path, String[]) with 'mappings', 'modelPathStartsWith', 'synonymPathStartsWith', 'synonymPathEndsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"
  })
  void
      testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith() {
    // Arrange and Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(
            new ArrayList<>(),
            mock(RosettaPath.class),
            ScopeReferenceHelper.EMPTY_SCOPE,
            "Synonym Path Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with
   * {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code
   * synonymPathEndsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, RosettaPath, Path, String[]) with 'mappings', 'modelPathStartsWith', 'synonymPathStartsWith', 'synonymPathEndsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"
  })
  void
      testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith2() {
    // Arrange
    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);
    RosettaPath modelPathStartsWith = mock(RosettaPath.class);

    Path synonymPathStartsWith = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(
            mappings, modelPathStartsWith, synonymPathStartsWith, "Synonym Path Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with
   * {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code
   * synonymPathEndsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, RosettaPath, Path, String[]) with 'mappings', 'modelPathStartsWith', 'synonymPathStartsWith', 'synonymPathEndsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"
  })
  void
      testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith3() {
    // Arrange
    Path xmlPath = new Path();
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);
    RosettaPath modelPathStartsWith = mock(RosettaPath.class);

    Path synonymPathStartsWith = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));
    synonymPathStartsWith.addElement(PathElement.parse("foo", true));

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(
            mappings, modelPathStartsWith, synonymPathStartsWith, "Synonym Path Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with
   * {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code
   * synonymPathEndsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, RosettaPath, Path, String[]) with 'mappings', 'modelPathStartsWith', 'synonymPathStartsWith', 'synonymPathEndsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"
  })
  void
      testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith4() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(
            mappings,
            mock(RosettaPath.class),
            ScopeReferenceHelper.EMPTY_SCOPE,
            "Synonym Path Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with
   * {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code
   * synonymPathEndsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, RosettaPath, Path, String[]) with 'mappings', 'modelPathStartsWith', 'synonymPathStartsWith', 'synonymPathEndsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"
  })
  void
      testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith5() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);
    RosettaPath modelPathStartsWith = mock(RosettaPath.class);

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(
            mappings, modelPathStartsWith, new Path(), "Synonym Path Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with
   * {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code
   * synonymPathEndsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, RosettaPath, Path, String[]) with 'mappings', 'modelPathStartsWith', 'synonymPathStartsWith', 'synonymPathEndsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"
  })
  void
      testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith6() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(
            mappings, mock(RosettaPath.class), Path.valueOf("Path"), "Synonym Path Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with
   * {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code
   * synonymPathEndsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, RosettaPath, Path, String[]) with 'mappings', 'modelPathStartsWith', 'synonymPathStartsWith', 'synonymPathEndsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"
  })
  void
      testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith7() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    RosettaPath modelPathStartsWith = mock(RosettaPath.class);
    when(modelPathStartsWith.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(
            mappings, modelPathStartsWith, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    verify(modelPathStartsWith, atLeast(1)).allElements();
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with
   * {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code
   * synonymPathEndsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, RosettaPath, Path, String[]) with 'mappings', 'modelPathStartsWith', 'synonymPathStartsWith', 'synonymPathEndsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"
  })
  void
      testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith8() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            new Path(),
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    RosettaPath modelPathStartsWith = mock(RosettaPath.class);
    when(modelPathStartsWith.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(
            mappings, modelPathStartsWith, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    verify(modelPathStartsWith).allElements();
    assertTrue(actualNonNullMapping.isPresent());
    assertSame(mapping, actualNonNullMapping.get());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with
   * {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code
   * synonymPathEndsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, RosettaPath, Path, String[]) with 'mappings', 'modelPathStartsWith', 'synonymPathStartsWith', 'synonymPathEndsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"
  })
  void
      testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith9() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(
            mappings,
            mock(RosettaPath.class),
            ScopeReferenceHelper.EMPTY_SCOPE,
            "Synonym Path Ends With",
            "java.lang.Boolean");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path, String[])} with
   * {@code mappings}, {@code modelPathStartsWith}, {@code synonymPathStartsWith}, {@code
   * synonymPathEndsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, RosettaPath, Path,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, RosettaPath, Path, String[]) with 'mappings', 'modelPathStartsWith', 'synonymPathStartsWith', 'synonymPathEndsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional MappingProcessorUtils.getNonNullMapping(List, RosettaPath, Path, String[])"
  })
  void
      testGetNonNullMappingWithMappingsModelPathStartsWithSynonymPathStartsWithSynonymPathEndsWith10() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            null,
            new Path(),
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    RosettaPath modelPathStartsWith = mock(RosettaPath.class);
    when(modelPathStartsWith.allElements()).thenReturn(new LinkedList<>());

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(
            mappings, modelPathStartsWith, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    verify(modelPathStartsWith, atLeast(1)).allElements();
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  void testGetNonNullMappingWithMappingsStartsWithEndsWith() {
    // Arrange
    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path startsWith = ScopeReferenceHelper.EMPTY_SCOPE;
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(mappings, startsWith, "Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  void testGetNonNullMappingWithMappingsStartsWithEndsWith2() {
    // Arrange
    Path xmlPath = new Path();
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path startsWith = ScopeReferenceHelper.EMPTY_SCOPE;
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));
    startsWith.addElement(PathElement.parse("foo", true));

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(mappings, startsWith, "Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  void testGetNonNullMappingWithMappingsStartsWithEndsWith3() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(
            mappings, ScopeReferenceHelper.EMPTY_SCOPE, "Ends With", "java.lang.Boolean");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  void testGetNonNullMappingWithMappingsStartsWithEndsWith4() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            new Path(),
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(mappings, new Path(), "Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  void testGetNonNullMappingWithMappingsStartsWithEndsWith5() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            null,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(
            mappings, ScopeReferenceHelper.EMPTY_SCOPE, new String[] {});

    // Assert
    assertTrue(actualNonNullMapping.isPresent());
    assertSame(mapping2, actualNonNullMapping.get());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <ul>
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'; then return Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  void testGetNonNullMappingWithMappingsStartsWithEndsWith_thenReturnPresent() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(
            mappings, ScopeReferenceHelper.EMPTY_SCOPE, new String[] {});

    // Assert
    assertTrue(actualNonNullMapping.isPresent());
    assertSame(mapping, actualNonNullMapping.get());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  void testGetNonNullMappingWithMappingsStartsWithEndsWith_whenArrayList() {
    // Arrange and Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(
            new ArrayList<>(), ScopeReferenceHelper.EMPTY_SCOPE, "Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <ul>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'; when EMPTY_SCOPE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  void testGetNonNullMappingWithMappingsStartsWithEndsWith_whenEmpty_scope() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(
            mappings, ScopeReferenceHelper.EMPTY_SCOPE, "Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <ul>
   *   <li>When {@link Path#Path()}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'; when Path()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  void testGetNonNullMappingWithMappingsStartsWithEndsWith_whenPath() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(mappings, new Path(), "Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])} with {@code
   * mappings}, {@code startsWith}, {@code endsWith}.
   *
   * <ul>
   *   <li>When valueOf {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path, String[])}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, Path, String[]) with 'mappings', 'startsWith', 'endsWith'; when valueOf 'Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path, String[])"})
  void testGetNonNullMappingWithMappingsStartsWithEndsWith_whenValueOfPath() {
    // Arrange
    ArrayList<Mapping> mappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    mappings.add(mapping2);

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(mappings, Path.valueOf("Path"), "Ends With");

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path)} with {@code mappings}, {@code
   * synonymPath}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  @DisplayName("Test getNonNullMapping(List, Path) with 'mappings', 'synonymPath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path)"})
  void testGetNonNullMappingWithMappingsSynonymPath() {
    // Arrange
    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            null,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(mappings, synonymPath);

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path)} with {@code mappings}, {@code
   * synonymPath}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()} addElement parse {@code foo} and {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, Path) with 'mappings', 'synonymPath'; given Path() addElement parse 'foo' and 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path)"})
  void testGetNonNullMappingWithMappingsSynonymPath_givenPathAddElementParseFooAndTrue() {
    // Arrange
    Path xmlPath = new Path();
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(mappings, synonymPath);

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path)} with {@code mappings}, {@code
   * synonymPath}.
   *
   * <ul>
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, Path) with 'mappings', 'synonymPath'; then return Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path)"})
  void testGetNonNullMappingWithMappingsSynonymPath_thenReturnPresent() {
    // Arrange
    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    // Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(mappings, synonymPath);

    // Assert
    assertTrue(actualNonNullMapping.isPresent());
    assertSame(mapping, actualNonNullMapping.get());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMapping(List, Path)} with {@code mappings}, {@code
   * synonymPath}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMapping(List, Path)}
   */
  @Test
  @DisplayName(
      "Test getNonNullMapping(List, Path) with 'mappings', 'synonymPath'; when ArrayList(); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMapping(List, Path)"})
  void testGetNonNullMappingWithMappingsSynonymPath_whenArrayList_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Mapping> actualNonNullMapping =
        MappingProcessorUtils.getNonNullMapping(
            new ArrayList<>(), ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertFalse(actualNonNullMapping.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  @DisplayName("Test getNonNullMappingForModelPath(List, Path)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappingForModelPath(List, Path)"})
  void testGetNonNullMappingForModelPath() {
    // Arrange
    Path rosettaPath = ScopeReferenceHelper.EMPTY_SCOPE;
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            null,
            rosettaPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path modelPath = ScopeReferenceHelper.EMPTY_SCOPE;
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));

    // Act
    Optional<Mapping> actualNonNullMappingForModelPath =
        MappingProcessorUtils.getNonNullMappingForModelPath(mappings, modelPath);

    // Assert
    assertFalse(actualNonNullMappingForModelPath.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()} addElement parse {@code foo} and {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappingForModelPath(List, Path); given Path() addElement parse 'foo' and 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappingForModelPath(List, Path)"})
  void testGetNonNullMappingForModelPath_givenPathAddElementParseFooAndTrue() {
    // Arrange
    Path rosettaPath = new Path();
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            rosettaPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path modelPath = ScopeReferenceHelper.EMPTY_SCOPE;
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));

    // Act
    Optional<Mapping> actualNonNullMappingForModelPath =
        MappingProcessorUtils.getNonNullMappingForModelPath(mappings, modelPath);

    // Assert
    assertFalse(actualNonNullMappingForModelPath.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}.
   *
   * <ul>
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  @DisplayName("Test getNonNullMappingForModelPath(List, Path); then return Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappingForModelPath(List, Path)"})
  void testGetNonNullMappingForModelPath_thenReturnPresent() {
    // Arrange
    Path rosettaPath = ScopeReferenceHelper.EMPTY_SCOPE;
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    rosettaPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            rosettaPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

    Path modelPath = ScopeReferenceHelper.EMPTY_SCOPE;
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));
    modelPath.addElement(PathElement.parse("foo", true));

    // Act
    Optional<Mapping> actualNonNullMappingForModelPath =
        MappingProcessorUtils.getNonNullMappingForModelPath(mappings, modelPath);

    // Assert
    assertTrue(actualNonNullMappingForModelPath.isPresent());
    assertSame(mapping, actualNonNullMappingForModelPath.get());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappingForModelPath(List, Path)}
   */
  @Test
  @DisplayName(
      "Test getNonNullMappingForModelPath(List, Path); when ArrayList(); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.getNonNullMappingForModelPath(List, Path)"})
  void testGetNonNullMappingForModelPath_whenArrayList_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Mapping> actualNonNullMappingForModelPath =
        MappingProcessorUtils.getNonNullMappingForModelPath(
            new ArrayList<>(), ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertFalse(actualNonNullMappingForModelPath.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#subPath(String, Path)}.
   *
   * <ul>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#subPath(String, Path)}
   */
  @Test
  @DisplayName("Test subPath(String, Path); when EMPTY_SCOPE; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional MappingProcessorUtils.subPath(String, Path)"})
  void testSubPath_whenEmpty_scope_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Path> actualSubPathResult =
        MappingProcessorUtils.subPath("Last Element", ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertFalse(actualSubPathResult.isPresent());
  }

  /**
   * Test {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Error is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test updateMappings(Path, List, RosettaPath); then ArrayList() first Error is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MappingProcessorUtils.updateMappings(Path, List, RosettaPath)"})
  void testUpdateMappings_thenArrayListFirstErrorIsAnErrorOccurred() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Path xmlPath = new Path();
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

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
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Error is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#updateMappings(Path, List, RosettaPath)}
   */
  @Test
  @DisplayName(
      "Test updateMappings(Path, List, RosettaPath); then ArrayList() first Error is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MappingProcessorUtils.updateMappings(Path, List, RosettaPath)"})
  void testUpdateMappings_thenArrayListFirstErrorIsNull() {
    // Arrange
    Path synonymPath = ScopeReferenceHelper.EMPTY_SCOPE;
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));
    synonymPath.addElement(PathElement.parse("foo", true));

    Path xmlPath = ScopeReferenceHelper.EMPTY_SCOPE;
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    xmlPath.addElement(PathElement.parse("foo", true));
    Mapping mapping =
        new Mapping(
            xmlPath,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    ArrayList<Mapping> mappings = new ArrayList<>();
    mappings.add(mapping);

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
  }

  /**
   * Test {@link MappingProcessorUtils#updateMappingSuccess(Mapping, Path)} with {@code Mapping},
   * {@code Path}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#updateMappingSuccess(Mapping, Path)}
   */
  @Test
  @DisplayName("Test updateMappingSuccess(Mapping, Path) with 'Mapping', 'Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MappingProcessorUtils.updateMappingSuccess(Mapping, Path)"})
  void testUpdateMappingSuccessWithMappingPath() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    // Act
    MappingProcessorUtils.updateMappingSuccess(mapping, ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertNull(mapping.getError());
    assertFalse(mapping.isDuplicate());
  }

  /**
   * Test {@link MappingProcessorUtils#updateMappingSuccess(Mapping, RosettaPath)} with {@code
   * Mapping}, {@code RosettaPath}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#updateMappingSuccess(Mapping, RosettaPath)}
   */
  @Test
  @DisplayName("Test updateMappingSuccess(Mapping, RosettaPath) with 'Mapping', 'RosettaPath'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MappingProcessorUtils.updateMappingSuccess(Mapping, RosettaPath)"})
  void testUpdateMappingSuccessWithMappingRosettaPath() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

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
    assertArrayEquals(new String[] {"emptyScope"}, xmlPath.getPathNames());
  }

  /**
   * Test {@link MappingProcessorUtils#updateMappingFail(Mapping, String)}.
   *
   * <p>Method under test: {@link MappingProcessorUtils#updateMappingFail(Mapping, String)}
   */
  @Test
  @DisplayName("Test updateMappingFail(Mapping, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MappingProcessorUtils.updateMappingFail(Mapping, String)"})
  void testUpdateMappingFail() {
    // Arrange
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);

    // Act
    MappingProcessorUtils.updateMappingFail(mapping, "An error occurred");

    // Assert
    Path xmlPath = mapping.getXmlPath();
    PathElement lastElement = xmlPath.getLastElement();
    assertEquals("emptyScope", lastElement.getPathName());
    assertNull(mapping.getRosettaPath());
    Path parent = xmlPath.getParent();
    assertNull(parent.getLastElement());
    assertNull(mapping.getRosettaValue());
    assertEquals(0, parent.getPathNames().length);
    List<PathElement> elements = xmlPath.getElements();
    assertEquals(1, elements.size());
    assertFalse(lastElement.getIndex().isPresent());
    assertTrue(parent.getElements().isEmpty());
    assertTrue(lastElement.getMetas().isEmpty());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[] {"emptyScope"}, xmlPath.getPathNames());
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValueList(List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValueList(List)}
   */
  @Test
  @DisplayName("Test getNonNullMappedValueList(List); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.getNonNullMappedValueList(List)"})
  void testGetNonNullMappedValueList_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Mapping> filteredMappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    filteredMappings.add(mapping);

    // Act
    List<String> actualNonNullMappedValueList =
        MappingProcessorUtils.getNonNullMappedValueList(filteredMappings);

    // Assert
    assertEquals(1, actualNonNullMappedValueList.size());
    assertEquals("NON_EMPTY", actualNonNullMappedValueList.get(0));
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValueList(List)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValueList(List)}
   */
  @Test
  @DisplayName("Test getNonNullMappedValueList(List); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.getNonNullMappedValueList(List)"})
  void testGetNonNullMappedValueList_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Mapping> filteredMappings = new ArrayList<>();
    Mapping mapping =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    filteredMappings.add(mapping);
    Mapping mapping2 =
        new Mapping(
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            ScopeReferenceHelper.EMPTY_SCOPE,
            BeanPropertyWriter.MARKER_FOR_EMPTY,
            "An error occurred",
            true,
            true,
            true);
    filteredMappings.add(mapping2);

    // Act
    List<String> actualNonNullMappedValueList =
        MappingProcessorUtils.getNonNullMappedValueList(filteredMappings);

    // Assert
    assertEquals(2, actualNonNullMappedValueList.size());
    assertEquals("NON_EMPTY", actualNonNullMappedValueList.get(0));
    assertEquals("NON_EMPTY", actualNonNullMappedValueList.get(1));
  }

  /**
   * Test {@link MappingProcessorUtils#getNonNullMappedValueList(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MappingProcessorUtils#getNonNullMappedValueList(List)}
   */
  @Test
  @DisplayName("Test getNonNullMappedValueList(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MappingProcessorUtils.getNonNullMappedValueList(List)"})
  void testGetNonNullMappedValueList_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualNonNullMappedValueList =
        MappingProcessorUtils.getNonNullMappedValueList(new ArrayList<>());

    // Assert
    assertTrue(actualNonNullMappedValueList.isEmpty());
  }
}
