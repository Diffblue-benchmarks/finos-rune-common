package com.regnosys.rosetta.common.util;

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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.hashing.ScopeReferenceHelper;
import com.regnosys.rosetta.common.translation.Path;
import com.regnosys.rosetta.common.translation.Path.PathElement;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.path.RosettaPath.Element;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PathUtilsDiffblueTest {
  /**
   * Test {@link PathUtils#toRosettaPath(Path)}.
   *
   * <ul>
   *   <li>Then return Parent Parent Parent Element Uri is {@code FpML_5_10}.
   * </ul>
   *
   * <p>Method under test: {@link PathUtils#toRosettaPath(Path)}
   */
  @Test
  @DisplayName(
      "Test toRosettaPath(Path); then return Parent Parent Parent Element Uri is 'FpML_5_10'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RosettaPath PathUtils.toRosettaPath(Path)"})
  void testToRosettaPath_thenReturnParentParentParentElementUriIsFpML510() {
    // Arrange and Act
    RosettaPath actualToRosettaPathResult =
        PathUtils.toRosettaPath(Path.parse("com.regnosys.rosetta.common.translation.Path", true));

    // Assert
    RosettaPath parent = actualToRosettaPathResult.getParent();
    RosettaPath parent2 = parent.getParent();
    Element element = parent2.getParent().getElement();
    assertEquals("FpML_5_10", element.getUri());
    Element element2 = parent2.getElement();
    assertEquals("FpML_5_10", element2.getUri());
    Element element3 = parent.getElement();
    assertEquals("FpML_5_10", element3.getUri());
    assertEquals("Path", actualToRosettaPathResult.getElement().getPath());
    assertEquals("common", element2.getPath());
    assertEquals("rosetta", element.getPath());
    assertEquals("translation", element3.getPath());
  }

  /**
   * Test {@link PathUtils#toRosettaPath(Path)}.
   *
   * <ul>
   *   <li>When {@link Path#Path()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PathUtils#toRosettaPath(Path)}
   */
  @Test
  @DisplayName("Test toRosettaPath(Path); when Path(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RosettaPath PathUtils.toRosettaPath(Path)"})
  void testToRosettaPath_whenPath_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PathUtils.toRosettaPath(new Path()));
  }

  /**
   * Test {@link PathUtils#toPath(RosettaPath)}.
   *
   * <ul>
   *   <li>Given {@link LinkedList#LinkedList()}.
   *   <li>Then return LastElement is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PathUtils#toPath(RosettaPath)}
   */
  @Test
  @DisplayName("Test toPath(RosettaPath); given LinkedList(); then return LastElement is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path PathUtils.toPath(RosettaPath)"})
  void testToPath_givenLinkedList_thenReturnLastElementIsNull() {
    // Arrange
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenReturn(new LinkedList<>());

    // Act
    Path actualToPathResult = PathUtils.toPath(rosettaPath);

    // Assert
    verify(rosettaPath).allElements();
    assertNull(actualToPathResult.getLastElement());
    assertEquals(0, actualToPathResult.getPathNames().length);
    assertTrue(actualToPathResult.getElements().isEmpty());
  }

  /**
   * Test {@link PathUtils#toPath(RosettaPath)}.
   *
   * <ul>
   *   <li>Then throw {@link PathException}.
   * </ul>
   *
   * <p>Method under test: {@link PathUtils#toPath(RosettaPath)}
   */
  @Test
  @DisplayName("Test toPath(RosettaPath); then throw PathException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path PathUtils.toPath(RosettaPath)"})
  void testToPath_thenThrowPathException() {
    // Arrange
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenThrow(new PathException("0123456789ABCDEF"));

    // Act and Assert
    assertThrows(PathException.class, () -> PathUtils.toPath(rosettaPath));
    verify(rosettaPath).allElements();
  }

  /**
   * Test {@link PathUtils#filterSubPaths(Collection)}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE} addElement parse {@code foo} and {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link PathUtils#filterSubPaths(Collection)}
   */
  @Test
  @DisplayName(
      "Test filterSubPaths(Collection); given EMPTY_SCOPE addElement parse 'foo' and 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PathUtils.filterSubPaths(Collection)"})
  void testFilterSubPaths_givenEmpty_scopeAddElementParseFooAndTrue() {
    // Arrange
    Path path = ScopeReferenceHelper.EMPTY_SCOPE;
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));

    LinkedHashSet<Path> paths = new LinkedHashSet<>();
    paths.add(path);

    // Act
    List<Path> actualFilterSubPathsResult = PathUtils.filterSubPaths(paths);

    // Assert
    assertEquals(1, actualFilterSubPathsResult.size());
    Path getResult = actualFilterSubPathsResult.get(0);
    PathElement lastElement = getResult.getLastElement();
    assertEquals("emptyScope", lastElement.getPathName());
    List<PathElement> elements = getResult.getElements();
    assertEquals(1, elements.size());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[] {"emptyScope"}, getResult.getPathNames());
  }

  /**
   * Test {@link PathUtils#filterSubPaths(Collection)}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PathUtils#filterSubPaths(Collection)}
   */
  @Test
  @DisplayName("Test filterSubPaths(Collection); given EMPTY_SCOPE; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PathUtils.filterSubPaths(Collection)"})
  void testFilterSubPaths_givenEmpty_scope_thenReturnArrayList() {
    // Arrange
    ArrayList<Path> paths = new ArrayList<>();
    paths.add(ScopeReferenceHelper.EMPTY_SCOPE);
    paths.add(ScopeReferenceHelper.EMPTY_SCOPE);

    // Act
    List<Path> actualFilterSubPathsResult = PathUtils.filterSubPaths(paths);

    // Assert
    assertEquals(paths, actualFilterSubPathsResult);
  }

  /**
   * Test {@link PathUtils#filterSubPaths(Collection)}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()} addElement parse {@code foo} and {@code true}.
   *   <li>Then return first is {@link Path#Path()}.
   * </ul>
   *
   * <p>Method under test: {@link PathUtils#filterSubPaths(Collection)}
   */
  @Test
  @DisplayName(
      "Test filterSubPaths(Collection); given Path() addElement parse 'foo' and 'true'; then return first is Path()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PathUtils.filterSubPaths(Collection)"})
  void testFilterSubPaths_givenPathAddElementParseFooAndTrue_thenReturnFirstIsPath() {
    // Arrange
    Path path = new Path();
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));
    path.addElement(PathElement.parse("foo", true));

    LinkedHashSet<Path> paths = new LinkedHashSet<>();
    paths.add(path);

    // Act
    List<Path> actualFilterSubPathsResult = PathUtils.filterSubPaths(paths);

    // Assert
    assertEquals(1, actualFilterSubPathsResult.size());
    assertSame(path, actualFilterSubPathsResult.get(0));
  }

  /**
   * Test {@link PathUtils#filterSubPaths(Collection)}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Path#Path()}.
   *   <li>Then return first Parent is {@link Path#Path()}.
   * </ul>
   *
   * <p>Method under test: {@link PathUtils#filterSubPaths(Collection)}
   */
  @Test
  @DisplayName(
      "Test filterSubPaths(Collection); given Path(); when ArrayList() add Path(); then return first Parent is Path()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PathUtils.filterSubPaths(Collection)"})
  void testFilterSubPaths_givenPath_whenArrayListAddPath_thenReturnFirstParentIsPath() {
    // Arrange
    ArrayList<Path> paths = new ArrayList<>();
    Path path = new Path();
    paths.add(path);
    paths.add(ScopeReferenceHelper.EMPTY_SCOPE);

    // Act
    List<Path> actualFilterSubPathsResult = PathUtils.filterSubPaths(paths);

    // Assert
    assertEquals(1, actualFilterSubPathsResult.size());
    Path getResult = actualFilterSubPathsResult.get(0);
    PathElement lastElement = getResult.getLastElement();
    assertEquals("emptyScope", lastElement.getPathName());
    List<PathElement> elements = getResult.getElements();
    assertEquals(1, elements.size());
    assertEquals(path, getResult.getParent());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[] {"emptyScope"}, getResult.getPathNames());
  }

  /**
   * Test {@link PathUtils#filterSubPaths(Collection)}.
   *
   * <ul>
   *   <li>Given valueOf {@code Path}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link PathUtils#filterSubPaths(Collection)}
   */
  @Test
  @DisplayName("Test filterSubPaths(Collection); given valueOf 'Path'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PathUtils.filterSubPaths(Collection)"})
  void testFilterSubPaths_givenValueOfPath_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Path> paths = new ArrayList<>();
    Path valueOfResult = Path.valueOf("Path");
    paths.add(valueOfResult);
    paths.add(ScopeReferenceHelper.EMPTY_SCOPE);

    // Act
    List<Path> actualFilterSubPathsResult = PathUtils.filterSubPaths(paths);

    // Assert
    assertEquals(2, actualFilterSubPathsResult.size());
    Path getResult = actualFilterSubPathsResult.get(1);
    PathElement lastElement = getResult.getLastElement();
    assertEquals("emptyScope", lastElement.getPathName());
    List<PathElement> elements = getResult.getElements();
    assertEquals(1, elements.size());
    assertSame(lastElement, elements.get(0));
    assertSame(valueOfResult, actualFilterSubPathsResult.get(0));
    assertArrayEquals(new String[] {"emptyScope"}, getResult.getPathNames());
  }

  /**
   * Test {@link PathUtils#filterSubPaths(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PathUtils#filterSubPaths(Collection)}
   */
  @Test
  @DisplayName("Test filterSubPaths(Collection); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PathUtils.filterSubPaths(Collection)"})
  void testFilterSubPaths_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Path> actualFilterSubPathsResult = PathUtils.filterSubPaths(new ArrayList<>());

    // Assert
    assertTrue(actualFilterSubPathsResult.isEmpty());
  }
}
