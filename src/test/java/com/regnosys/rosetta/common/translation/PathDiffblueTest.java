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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.hashing.ScopeReferenceHelper;
import com.regnosys.rosetta.common.translation.Path.PathElement;
import com.regnosys.rosetta.common.util.PathException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PathDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Path#Path(List)}
   *   <li>{@link Path#toString()}
   *   <li>{@link Path#getElements()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Path.<init>(List)", "List Path.getElements()", "String Path.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ArrayList<PathElement> elements = new ArrayList<>();

    // Act
    Path actualPath = new Path(elements);
    String actualToStringResult = actualPath.toString();
    List<PathElement> actualElements = actualPath.getElements();

    // Assert
    assertEquals("", actualToStringResult);
    assertTrue(actualElements.isEmpty());
    assertSame(elements, actualElements);
  }

  /**
   * Test {@link Path#Path()}.
   *
   * <p>Method under test: {@link Path#Path()}
   */
  @Test
  @DisplayName("Test new Path()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Path.<init>()"})
  void testNewPath() {
    // Arrange and Act
    Path actualPath = new Path();

    // Assert
    assertNull(actualPath.getLastElement());
    assertEquals(0, actualPath.getPathNames().length);
    assertTrue(actualPath.getElements().isEmpty());
  }

  /**
   * Test PathElement {@link PathElement#equals(Object)}, and {@link PathElement#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PathElement#equals(Object)}
   *   <li>{@link PathElement#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test PathElement equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PathElement.equals(Object)", "int PathElement.hashCode()"})
  void testPathElementEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PathElement parseResult = PathElement.parse("foo", true);
    PathElement parseResult2 = PathElement.parse("foo", true);

    // Act and Assert
    assertEquals(parseResult, parseResult2);
    assertEquals(parseResult.hashCode(), parseResult2.hashCode());
  }

  /**
   * Test PathElement {@link PathElement#equals(Object)}, and {@link PathElement#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PathElement#equals(Object)}
   *   <li>{@link PathElement#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test PathElement equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PathElement.equals(Object)", "int PathElement.hashCode()"})
  void testPathElementEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PathElement parseResult = PathElement.parse("foo", true);

    // Act and Assert
    assertEquals(parseResult, parseResult);
    int expectedHashCodeResult = parseResult.hashCode();
    assertEquals(expectedHashCodeResult, parseResult.hashCode());
  }

  /**
   * Test PathElement {@link PathElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PathElement#equals(Object)}
   */
  @Test
  @DisplayName("Test PathElement equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PathElement.equals(Object)", "int PathElement.hashCode()"})
  void testPathElementEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PathElement pathElement = new PathElement("foo", 1);

    // Act and Assert
    assertNotEquals(pathElement, PathElement.parse("foo", true));
  }

  /**
   * Test PathElement {@link PathElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PathElement#equals(Object)}
   */
  @Test
  @DisplayName("Test PathElement equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PathElement.equals(Object)", "int PathElement.hashCode()"})
  void testPathElementEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PathElement parseResult = PathElement.parse("42", true);

    // Act and Assert
    assertNotEquals(parseResult, PathElement.parse("foo", true));
  }

  /**
   * Test PathElement {@link PathElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PathElement#equals(Object)}
   */
  @Test
  @DisplayName("Test PathElement equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PathElement.equals(Object)", "int PathElement.hashCode()"})
  void testPathElementEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PathElement.parse("foo", true), null);
  }

  /**
   * Test PathElement {@link PathElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PathElement#equals(Object)}
   */
  @Test
  @DisplayName("Test PathElement equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PathElement.equals(Object)", "int PathElement.hashCode()"})
  void testPathElementEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PathElement.parse("foo", true), "Different type to PathElement");
  }

  /**
   * Test PathElement {@link PathElement#forceGetIndex()}.
   *
   * <ul>
   *   <li>Given parse {@code foo} and {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PathElement#forceGetIndex()}
   */
  @Test
  @DisplayName("Test PathElement forceGetIndex(); given parse 'foo' and 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PathElement.forceGetIndex()"})
  void testPathElementForceGetIndex_givenParseFooAndTrue_thenReturnZero() {
    // Arrange
    PathElement parseResult = PathElement.parse("foo", true);

    // Act and Assert
    assertEquals(0, parseResult.forceGetIndex());
    Optional<Integer> index = parseResult.getIndex();
    assertEquals(0, index.get().intValue());
    assertTrue(index.isPresent());
  }

  /**
   * Test PathElement {@link PathElement#forceGetIndex()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PathElement#forceGetIndex()}
   */
  @Test
  @DisplayName("Test PathElement forceGetIndex(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PathElement.forceGetIndex()"})
  void testPathElementForceGetIndex_thenReturnOne() {
    // Arrange
    PathElement pathElement = new PathElement("Path Name", 1);

    // Act and Assert
    assertEquals(1, pathElement.forceGetIndex());
    Optional<Integer> index = pathElement.getIndex();
    assertEquals(1, index.get().intValue());
    assertTrue(index.isPresent());
  }

  /**
   * Test PathElement getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PathElement#toString()}
   *   <li>{@link PathElement#getIndex()}
   *   <li>{@link PathElement#getMetas()}
   *   <li>{@link PathElement#getPathName()}
   * </ul>
   */
  @Test
  @DisplayName("Test PathElement getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional PathElement.getIndex()",
    "Map PathElement.getMetas()",
    "String PathElement.getPathName()",
    "String PathElement.toString()"
  })
  void testPathElementGettersAndSetters() {
    // Arrange
    PathElement parseResult = PathElement.parse("foo", true);

    // Act
    String actualToStringResult = parseResult.toString();
    Optional<Integer> actualIndex = parseResult.getIndex();
    Map<String, String> actualMetas = parseResult.getMetas();

    // Assert
    assertEquals("foo", parseResult.getPathName());
    assertEquals("foo", actualToStringResult);
    assertFalse(actualIndex.isPresent());
    assertTrue(actualMetas.isEmpty());
  }

  /**
   * Test PathElement {@link PathElement#PathElement(String)}.
   *
   * <p>Method under test: {@link PathElement#PathElement(String)}
   */
  @Test
  @DisplayName("Test PathElement new PathElement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PathElement.<init>(String)"})
  void testPathElementNewPathElement() {
    // Arrange and Act
    PathElement actualPathElement = new PathElement("Path Name");

    // Assert
    assertEquals("Path Name", actualPathElement.getPathName());
    assertFalse(actualPathElement.getIndex().isPresent());
    assertTrue(actualPathElement.getMetas().isEmpty());
  }

  /**
   * Test PathElement {@link PathElement#PathElement(String, int)}.
   *
   * <p>Method under test: {@link PathElement#PathElement(String, int)}
   */
  @Test
  @DisplayName("Test PathElement new PathElement(String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PathElement.<init>(String, int)"})
  void testPathElementNewPathElement2() {
    // Arrange and Act
    PathElement actualPathElement = new PathElement("Path Name", 1);

    // Assert
    assertEquals("Path Name", actualPathElement.getPathName());
    Optional<Integer> index = actualPathElement.getIndex();
    assertEquals(1, index.get().intValue());
    assertTrue(actualPathElement.getMetas().isEmpty());
    assertTrue(index.isPresent());
  }

  /**
   * Test PathElement {@link PathElement#PathElement(String, int, Map)}.
   *
   * <p>Method under test: {@link PathElement#PathElement(String, int, Map)}
   */
  @Test
  @DisplayName("Test PathElement new PathElement(String, int, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PathElement.<init>(String, int, Map)"})
  void testPathElementNewPathElement3() {
    // Arrange and Act
    PathElement actualPathElement = new PathElement("Path Name", 1, new HashMap<>());

    // Assert
    assertEquals("Path Name", actualPathElement.getPathName());
    Optional<Integer> index = actualPathElement.getIndex();
    assertEquals(1, index.get().intValue());
    assertTrue(actualPathElement.getMetas().isEmpty());
    assertTrue(index.isPresent());
  }

  /**
   * Test PathElement {@link PathElement#PathElement(String, Map)}.
   *
   * <p>Method under test: {@link PathElement#PathElement(String, Map)}
   */
  @Test
  @DisplayName("Test PathElement new PathElement(String, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PathElement.<init>(String, Map)"})
  void testPathElementNewPathElement4() {
    // Arrange and Act
    PathElement actualPathElement = new PathElement("Path Name", new HashMap<>());

    // Assert
    assertEquals("Path Name", actualPathElement.getPathName());
    assertFalse(actualPathElement.getIndex().isPresent());
    assertTrue(actualPathElement.getMetas().isEmpty());
  }

  /**
   * Test PathElement {@link PathElement#PathElement(String, Optional, Map)}.
   *
   * <p>Method under test: {@link PathElement#PathElement(String, Optional, Map)}
   */
  @Test
  @DisplayName("Test PathElement new PathElement(String, Optional, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PathElement.<init>(String, Optional, Map)"})
  void testPathElementNewPathElement5() {
    // Arrange
    Optional<Integer> index = Optional.of(1);

    // Act
    PathElement actualPathElement = new PathElement("Path Name", index, new HashMap<>());

    // Assert
    assertEquals("Path Name", actualPathElement.getPathName());
    assertTrue(actualPathElement.getMetas().isEmpty());
    assertSame(index, actualPathElement.getIndex());
  }

  /**
   * Test PathElement {@link PathElement#parse(String, boolean)} with {@code s}, {@code
   * allowWildcard}.
   *
   * <ul>
   *   <li>When {@code *[9]}.
   *   <li>Then return PathName is {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link PathElement#parse(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test PathElement parse(String, boolean) with 's', 'allowWildcard'; when '*[9]'; then return PathName is '*'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PathElement PathElement.parse(String, boolean)"})
  void testPathElementParseWithSAllowWildcard_when9_thenReturnPathNameIsAsterisk() {
    // Arrange and Act
    PathElement actualParseResult = PathElement.parse("*[9]", true);

    // Assert
    assertEquals("*", actualParseResult.getPathName());
    Optional<Integer> index = actualParseResult.getIndex();
    assertEquals(9, index.get().intValue());
    assertTrue(actualParseResult.getMetas().isEmpty());
    assertTrue(index.isPresent());
  }

  /**
   * Test PathElement {@link PathElement#parse(String, boolean)} with {@code s}, {@code
   * allowWildcard}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return PathName is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PathElement#parse(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test PathElement parse(String, boolean) with 's', 'allowWildcard'; when 'foo'; then return PathName is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PathElement PathElement.parse(String, boolean)"})
  void testPathElementParseWithSAllowWildcard_whenFoo_thenReturnPathNameIsFoo() {
    // Arrange and Act
    PathElement actualParseResult = PathElement.parse("foo", true);

    // Assert
    assertEquals("foo", actualParseResult.getPathName());
    assertFalse(actualParseResult.getIndex().isPresent());
    assertTrue(actualParseResult.getMetas().isEmpty());
  }

  /**
   * Test PathElement {@link PathElement#parse(String, boolean)} with {@code s}, {@code
   * allowWildcard}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return PathName is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PathElement#parse(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test PathElement parse(String, boolean) with 's', 'allowWildcard'; when 'foo'; then return PathName is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PathElement PathElement.parse(String, boolean)"})
  void testPathElementParseWithSAllowWildcard_whenFoo_thenReturnPathNameIsFoo2() {
    // Arrange and Act
    PathElement actualParseResult = PathElement.parse("foo", false);

    // Assert
    assertEquals("foo", actualParseResult.getPathName());
    assertFalse(actualParseResult.getIndex().isPresent());
    assertTrue(actualParseResult.getMetas().isEmpty());
  }

  /**
   * Test PathElement {@link PathElement#parse(String, boolean)} with {@code s}, {@code
   * allowWildcard}.
   *
   * <ul>
   *   <li>When {@code ([*]|\w*)(\[(\d*)])?}.
   *   <li>Then throw {@link PathException}.
   * </ul>
   *
   * <p>Method under test: {@link PathElement#parse(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test PathElement parse(String, boolean) with 's', 'allowWildcard'; when '([*]|\\w*)(\\[(\\d*)])?'; then throw PathException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PathElement PathElement.parse(String, boolean)"})
  void testPathElementParseWithSAllowWildcard_whenWD_thenThrowPathException() {
    // Arrange, Act and Assert
    assertThrows(PathException.class, () -> PathElement.parse("([*]|\\w*)(\\[(\\d*)])?", true));
  }

  /**
   * Test PathElement {@link PathElement#parse(String)} with {@code s}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then return PathName is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PathElement#parse(String)}
   */
  @Test
  @DisplayName("Test PathElement parse(String) with 's'; when 'foo'; then return PathName is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PathElement PathElement.parse(String)"})
  void testPathElementParseWithS_whenFoo_thenReturnPathNameIsFoo() {
    // Arrange and Act
    PathElement actualParseResult = PathElement.parse("foo");

    // Assert
    assertEquals("foo", actualParseResult.getPathName());
    assertFalse(actualParseResult.getIndex().isPresent());
    assertTrue(actualParseResult.getMetas().isEmpty());
  }

  /**
   * Test PathElement {@link PathElement#parse(String)} with {@code s}.
   *
   * <ul>
   *   <li>When {@code U[9]}.
   *   <li>Then return PathName is {@code U}.
   * </ul>
   *
   * <p>Method under test: {@link PathElement#parse(String)}
   */
  @Test
  @DisplayName("Test PathElement parse(String) with 's'; when 'U[9]'; then return PathName is 'U'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PathElement PathElement.parse(String)"})
  void testPathElementParseWithS_whenU9_thenReturnPathNameIsU() {
    // Arrange and Act
    PathElement actualParseResult = PathElement.parse("U[9]");

    // Assert
    assertEquals("U", actualParseResult.getPathName());
    Optional<Integer> index = actualParseResult.getIndex();
    assertEquals(9, index.get().intValue());
    assertTrue(actualParseResult.getMetas().isEmpty());
    assertTrue(index.isPresent());
  }

  /**
   * Test PathElement {@link PathElement#parse(String)} with {@code s}.
   *
   * <ul>
   *   <li>When {@code ([*]|\w*)(\[(\d*)])?}.
   *   <li>Then throw {@link PathException}.
   * </ul>
   *
   * <p>Method under test: {@link PathElement#parse(String)}
   */
  @Test
  @DisplayName(
      "Test PathElement parse(String) with 's'; when '([*]|\\w*)(\\[(\\d*)])?'; then throw PathException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PathElement PathElement.parse(String)"})
  void testPathElementParseWithS_whenWD_thenThrowPathException() {
    // Arrange, Act and Assert
    assertThrows(PathException.class, () -> PathElement.parse("([*]|\\w*)(\\[(\\d*)])?"));
  }

  /**
   * Test {@link Path#valueOf(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Parent Elements size is one.
   * </ul>
   *
   * <p>Method under test: {@link Path#valueOf(List)}
   */
  @Test
  @DisplayName(
      "Test valueOf(List) with 'List'; given '42'; when ArrayList() add '42'; then return Parent Elements size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.valueOf(List)"})
  void testValueOfWithList_given42_whenArrayListAdd42_thenReturnParentElementsSizeIsOne() {
    // Arrange
    ArrayList<String> path = new ArrayList<>();
    path.add("42");
    path.add("foo");

    // Act
    Path actualValueOfResult = Path.valueOf(path);

    // Assert
    Path parent = actualValueOfResult.getParent();
    assertEquals(1, parent.getElements().size());
    assertEquals(1, parent.getPathNames().length);
    List<PathElement> elements = actualValueOfResult.getElements();
    assertEquals(2, elements.size());
    assertSame(elements.get(0), parent.getLastElement());
    assertArrayEquals(new String[] {"42", "foo"}, actualValueOfResult.getPathNames());
  }

  /**
   * Test {@link Path#valueOf(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return Parent LastElement is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Path#valueOf(List)}
   */
  @Test
  @DisplayName(
      "Test valueOf(List) with 'List'; given 'foo'; then return Parent LastElement is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.valueOf(List)"})
  void testValueOfWithList_givenFoo_thenReturnParentLastElementIsNull() {
    // Arrange
    ArrayList<String> path = new ArrayList<>();
    path.add("foo");

    // Act
    Path actualValueOfResult = Path.valueOf(path);

    // Assert
    Path parent = actualValueOfResult.getParent();
    assertNull(parent.getLastElement());
    assertEquals(0, parent.getPathNames().length);
    assertEquals(1, actualValueOfResult.getElements().size());
    assertTrue(parent.getElements().isEmpty());
    assertArrayEquals(new String[] {"foo"}, actualValueOfResult.getPathNames());
  }

  /**
   * Test {@link Path#valueOf(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return LastElement is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Path#valueOf(List)}
   */
  @Test
  @DisplayName(
      "Test valueOf(List) with 'List'; when ArrayList(); then return LastElement is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.valueOf(List)"})
  void testValueOfWithList_whenArrayList_thenReturnLastElementIsNull() {
    // Arrange and Act
    Path actualValueOfResult = Path.valueOf(new ArrayList<>());

    // Assert
    assertNull(actualValueOfResult.getLastElement());
    assertEquals(0, actualValueOfResult.getPathNames().length);
    assertTrue(actualValueOfResult.getElements().isEmpty());
  }

  /**
   * Test {@link Path#valueOf(String)} with {@code String}.
   *
   * <p>Method under test: {@link Path#valueOf(String)}
   */
  @Test
  @DisplayName("Test valueOf(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.valueOf(String)"})
  void testValueOfWithString() {
    // Arrange and Act
    Path actualValueOfResult = Path.valueOf("Path");

    // Assert
    PathElement lastElement = actualValueOfResult.getLastElement();
    assertEquals("Path", lastElement.getPathName());
    Path parent = actualValueOfResult.getParent();
    assertNull(parent.getLastElement());
    assertEquals(0, parent.getPathNames().length);
    List<PathElement> elements = actualValueOfResult.getElements();
    assertEquals(1, elements.size());
    assertFalse(lastElement.getIndex().isPresent());
    assertTrue(parent.getElements().isEmpty());
    assertTrue(lastElement.getMetas().isEmpty());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[] {"Path"}, actualValueOfResult.getPathNames());
  }

  /**
   * Test {@link Path#addElement(PathElement)} with {@code element}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return Elements size is two.
   * </ul>
   *
   * <p>Method under test: {@link Path#addElement(PathElement)}
   */
  @Test
  @DisplayName(
      "Test addElement(PathElement) with 'element'; given EMPTY_SCOPE; then return Elements size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.addElement(PathElement)"})
  void testAddElementWithElement_givenEmpty_scope_thenReturnElementsSizeIsTwo() {
    // Arrange
    Path path = ScopeReferenceHelper.EMPTY_SCOPE;
    PathElement element = PathElement.parse("foo", true);

    // Act
    Path actualAddElementResult = path.addElement(element);

    // Assert
    List<PathElement> elements = actualAddElementResult.getElements();
    assertEquals(2, elements.size());
    assertEquals(path, actualAddElementResult.getParent());
    assertSame(element, elements.get(1));
    assertArrayEquals(new String[] {"emptyScope", "foo"}, actualAddElementResult.getPathNames());
  }

  /**
   * Test {@link Path#addElement(PathElement)} with {@code element}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>Then return Elements size is one.
   * </ul>
   *
   * <p>Method under test: {@link Path#addElement(PathElement)}
   */
  @Test
  @DisplayName(
      "Test addElement(PathElement) with 'element'; given Path(); then return Elements size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.addElement(PathElement)"})
  void testAddElementWithElement_givenPath_thenReturnElementsSizeIsOne() {
    // Arrange
    Path path = new Path();
    PathElement element = PathElement.parse("foo", true);

    // Act
    Path actualAddElementResult = path.addElement(element);

    // Assert
    List<PathElement> elements = actualAddElementResult.getElements();
    assertEquals(1, elements.size());
    assertEquals(path, actualAddElementResult.getParent());
    assertSame(element, elements.get(0));
    assertArrayEquals(new String[] {"foo"}, actualAddElementResult.getPathNames());
  }

  /**
   * Test {@link Path#addElement(String, Integer)} with {@code name}, {@code index}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return Elements size is two.
   * </ul>
   *
   * <p>Method under test: {@link Path#addElement(String, Integer)}
   */
  @Test
  @DisplayName(
      "Test addElement(String, Integer) with 'name', 'index'; given EMPTY_SCOPE; then return Elements size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.addElement(String, Integer)"})
  void testAddElementWithNameIndex_givenEmpty_scope_thenReturnElementsSizeIsTwo() {
    // Arrange
    Path path = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act
    Path actualAddElementResult = path.addElement("Name", 1);

    // Assert
    assertEquals(2, actualAddElementResult.getElements().size());
    assertEquals(path, actualAddElementResult.getParent());
    assertArrayEquals(new String[] {"emptyScope", "Name"}, actualAddElementResult.getPathNames());
  }

  /**
   * Test {@link Path#addElement(String, Integer)} with {@code name}, {@code index}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>Then return Elements size is one.
   * </ul>
   *
   * <p>Method under test: {@link Path#addElement(String, Integer)}
   */
  @Test
  @DisplayName(
      "Test addElement(String, Integer) with 'name', 'index'; given Path(); then return Elements size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.addElement(String, Integer)"})
  void testAddElementWithNameIndex_givenPath_thenReturnElementsSizeIsOne() {
    // Arrange
    Path path = new Path();

    // Act
    Path actualAddElementResult = path.addElement("Name", 1);

    // Assert
    assertEquals(1, actualAddElementResult.getElements().size());
    assertEquals(path, actualAddElementResult.getParent());
    assertArrayEquals(new String[] {"Name"}, actualAddElementResult.getPathNames());
  }

  /**
   * Test {@link Path#addElement(String)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return Elements size is two.
   * </ul>
   *
   * <p>Method under test: {@link Path#addElement(String)}
   */
  @Test
  @DisplayName(
      "Test addElement(String) with 'name'; given EMPTY_SCOPE; then return Elements size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.addElement(String)"})
  void testAddElementWithName_givenEmpty_scope_thenReturnElementsSizeIsTwo() {
    // Arrange
    Path path = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act
    Path actualAddElementResult = path.addElement("Name");

    // Assert
    assertEquals(2, actualAddElementResult.getElements().size());
    assertEquals(path, actualAddElementResult.getParent());
    assertArrayEquals(new String[] {"emptyScope", "Name"}, actualAddElementResult.getPathNames());
  }

  /**
   * Test {@link Path#addElement(String)} with {@code name}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>Then return Elements size is one.
   * </ul>
   *
   * <p>Method under test: {@link Path#addElement(String)}
   */
  @Test
  @DisplayName(
      "Test addElement(String) with 'name'; given Path(); then return Elements size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.addElement(String)"})
  void testAddElementWithName_givenPath_thenReturnElementsSizeIsOne() {
    // Arrange
    Path path = new Path();

    // Act
    Path actualAddElementResult = path.addElement("Name");

    // Assert
    assertEquals(1, actualAddElementResult.getElements().size());
    assertEquals(path, actualAddElementResult.getParent());
    assertArrayEquals(new String[] {"Name"}, actualAddElementResult.getPathNames());
  }

  /**
   * Test {@link Path#getPathNames()}.
   *
   * <p>Method under test: {@link Path#getPathNames()}
   */
  @Test
  @DisplayName("Test getPathNames()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] Path.getPathNames()"})
  void testGetPathNames() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[] {"emptyScope"}, ScopeReferenceHelper.EMPTY_SCOPE.getPathNames());
  }

  /**
   * Test {@link Path#getParent()}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return LastElement is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Path#getParent()}
   */
  @Test
  @DisplayName("Test getParent(); given EMPTY_SCOPE; then return LastElement is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.getParent()"})
  void testGetParent_givenEmpty_scope_thenReturnLastElementIsNull() {
    // Arrange and Act
    Path actualParent = ScopeReferenceHelper.EMPTY_SCOPE.getParent();

    // Assert
    assertNull(actualParent.getLastElement());
    assertEquals(0, actualParent.getPathNames().length);
    assertTrue(actualParent.getElements().isEmpty());
  }

  /**
   * Test {@link Path#getLastElement()}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return PathName is {@code emptyScope}.
   * </ul>
   *
   * <p>Method under test: {@link Path#getLastElement()}
   */
  @Test
  @DisplayName("Test getLastElement(); given EMPTY_SCOPE; then return PathName is 'emptyScope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PathElement Path.getLastElement()"})
  void testGetLastElement_givenEmpty_scope_thenReturnPathNameIsEmptyScope() {
    // Arrange and Act
    PathElement actualLastElement = ScopeReferenceHelper.EMPTY_SCOPE.getLastElement();

    // Assert
    assertEquals("emptyScope", actualLastElement.getPathName());
    assertFalse(actualLastElement.getIndex().isPresent());
    assertTrue(actualLastElement.getMetas().isEmpty());
  }

  /**
   * Test {@link Path#getLastElement()}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Path#getLastElement()}
   */
  @Test
  @DisplayName("Test getLastElement(); given Path(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PathElement Path.getLastElement()"})
  void testGetLastElement_givenPath_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Path().getLastElement());
  }

  /**
   * Test {@link Path#append(Path)}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return second element is {@code emptyScope}.
   * </ul>
   *
   * <p>Method under test: {@link Path#append(Path)}
   */
  @Test
  @DisplayName(
      "Test append(Path); given EMPTY_SCOPE; when EMPTY_SCOPE; then return second element is 'emptyScope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.append(Path)"})
  void testAppend_givenEmpty_scope_whenEmpty_scope_thenReturnSecondElementIsEmptyScope() {
    // Arrange
    Path append = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act
    Path actualAppendResult = ScopeReferenceHelper.EMPTY_SCOPE.append(append);

    // Assert
    String[] pathNames = actualAppendResult.getPathNames();
    assertEquals("emptyScope", pathNames[1]);
    assertEquals(2, actualAppendResult.getElements().size());
    assertEquals(2, pathNames.length);
    assertEquals(append, actualAppendResult.getParent());
  }

  /**
   * Test {@link Path#append(Path)}.
   *
   * <ul>
   *   <li>Given parse empty string and {@code true}.
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   * </ul>
   *
   * <p>Method under test: {@link Path#append(Path)}
   */
  @Test
  @DisplayName(
      "Test append(Path); given parse empty string and 'true'; when EMPTY_SCOPE; then return EMPTY_SCOPE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.append(Path)"})
  void testAppend_givenParseEmptyStringAndTrue_whenEmpty_scope_thenReturnEmpty_scope() {
    // Arrange
    Path append = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act
    Path actualAppendResult = Path.parse("", true).append(append);

    // Assert
    assertEquals(append, actualAppendResult);
  }

  /**
   * Test {@link Path#append(Path)}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return Elements size is one.
   * </ul>
   *
   * <p>Method under test: {@link Path#append(Path)}
   */
  @Test
  @DisplayName(
      "Test append(Path); given Path(); when EMPTY_SCOPE; then return Elements size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.append(Path)"})
  void testAppend_givenPath_whenEmpty_scope_thenReturnElementsSizeIsOne() {
    // Arrange
    Path path = new Path();

    // Act
    Path actualAppendResult = path.append(ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(1, actualAppendResult.getElements().size());
    assertEquals(path, actualAppendResult.getParent());
  }

  /**
   * Test {@link Path#append(Path)}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>When {@link Path#Path()}.
   *   <li>Then return {@link Path#Path()}.
   * </ul>
   *
   * <p>Method under test: {@link Path#append(Path)}
   */
  @Test
  @DisplayName("Test append(Path); given Path(); when Path(); then return Path()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.append(Path)"})
  void testAppend_givenPath_whenPath_thenReturnPath() {
    // Arrange
    Path path = new Path();

    // Act
    Path actualAppendResult = path.append(new Path());

    // Assert
    assertEquals(path, actualAppendResult);
  }

  /**
   * Test {@link Path#append(Path)}.
   *
   * <ul>
   *   <li>Then return Elements size is seven.
   * </ul>
   *
   * <p>Method under test: {@link Path#append(Path)}
   */
  @Test
  @DisplayName("Test append(Path); then return Elements size is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.append(Path)"})
  void testAppend_thenReturnElementsSizeIsSeven() {
    // Arrange
    Path parseResult = Path.parse("com.regnosys.rosetta.common.translation.Path", true);

    // Act
    Path actualAppendResult = parseResult.append(ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(7, actualAppendResult.getElements().size());
    assertEquals(parseResult, actualAppendResult.getParent());
    assertArrayEquals(
        new String[] {"com", "regnosys", "rosetta", "common", "translation", "Path", "emptyScope"},
        actualAppendResult.getPathNames());
  }

  /**
   * Test {@link Path#prefixWithWildcard()}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>Then return Parent is {@link Path#Path()}.
   * </ul>
   *
   * <p>Method under test: {@link Path#prefixWithWildcard()}
   */
  @Test
  @DisplayName("Test prefixWithWildcard(); given Path(); then return Parent is Path()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.prefixWithWildcard()"})
  void testPrefixWithWildcard_givenPath_thenReturnParentIsPath() {
    // Arrange
    Path path = new Path();

    // Act
    Path actualPrefixWithWildcardResult = path.prefixWithWildcard();

    // Assert
    assertEquals(1, actualPrefixWithWildcardResult.getElements().size());
    assertEquals(path, actualPrefixWithWildcardResult.getParent());
  }

  /**
   * Test {@link Path#prefixWithWildcard()}.
   *
   * <ul>
   *   <li>Then return LastElement PathName is {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link Path#prefixWithWildcard()}
   */
  @Test
  @DisplayName("Test prefixWithWildcard(); then return LastElement PathName is '*'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.prefixWithWildcard()"})
  void testPrefixWithWildcard_thenReturnLastElementPathNameIsAsterisk() {
    // Arrange
    Path parseResult = Path.parse("", true);

    // Act
    Path actualPrefixWithWildcardResult = parseResult.prefixWithWildcard();

    // Assert
    PathElement lastElement = actualPrefixWithWildcardResult.getLastElement();
    assertEquals("*", lastElement.getPathName());
    List<PathElement> elements = actualPrefixWithWildcardResult.getElements();
    assertEquals(1, elements.size());
    assertEquals(1, actualPrefixWithWildcardResult.getPathNames().length);
    assertEquals(parseResult, actualPrefixWithWildcardResult.getParent());
    assertSame(lastElement, elements.get(0));
  }

  /**
   * Test {@link Path#prefixWithWildcard()}.
   *
   * <ul>
   *   <li>Then return LastElement PathName is {@code emptyScope}.
   * </ul>
   *
   * <p>Method under test: {@link Path#prefixWithWildcard()}
   */
  @Test
  @DisplayName("Test prefixWithWildcard(); then return LastElement PathName is 'emptyScope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.prefixWithWildcard()"})
  void testPrefixWithWildcard_thenReturnLastElementPathNameIsEmptyScope() {
    // Arrange and Act
    Path actualPrefixWithWildcardResult = ScopeReferenceHelper.EMPTY_SCOPE.prefixWithWildcard();

    // Assert
    PathElement lastElement = actualPrefixWithWildcardResult.getLastElement();
    assertEquals("emptyScope", lastElement.getPathName());
    String[] pathNames = actualPrefixWithWildcardResult.getPathNames();
    assertEquals("emptyScope", pathNames[1]);
    Path parent = actualPrefixWithWildcardResult.getParent();
    Path parent2 = parent.getParent();
    assertNull(parent2.getLastElement());
    assertEquals(0, parent2.getPathNames().length);
    List<PathElement> elements = parent.getElements();
    assertEquals(1, elements.size());
    assertEquals(1, parent.getPathNames().length);
    List<PathElement> elements2 = actualPrefixWithWildcardResult.getElements();
    assertEquals(2, elements2.size());
    assertEquals(2, pathNames.length);
    assertTrue(parent2.getElements().isEmpty());
    assertSame(lastElement, elements2.get(1));
    PathElement getResult = elements2.get(0);
    assertSame(getResult, parent.getLastElement());
    assertSame(getResult, elements.get(0));
  }

  /**
   * Test {@link Path#prefixWithWildcard()}.
   *
   * <ul>
   *   <li>Then return LastElement PathName is {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link Path#prefixWithWildcard()}
   */
  @Test
  @DisplayName("Test prefixWithWildcard(); then return LastElement PathName is 'Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.prefixWithWildcard()"})
  void testPrefixWithWildcard_thenReturnLastElementPathNameIsPath() {
    // Arrange and Act
    Path actualPrefixWithWildcardResult =
        Path.parse("com.regnosys.rosetta.common.translation.Path", true).prefixWithWildcard();

    // Assert
    PathElement lastElement = actualPrefixWithWildcardResult.getLastElement();
    assertEquals("Path", lastElement.getPathName());
    String[] pathNames = actualPrefixWithWildcardResult.getPathNames();
    assertEquals("Path", pathNames[6]);
    assertEquals("com", pathNames[1]);
    assertEquals("common", pathNames[4]);
    assertEquals("regnosys", pathNames[2]);
    assertEquals("rosetta", pathNames[3]);
    assertEquals("translation", pathNames[5]);
    Path parent = actualPrefixWithWildcardResult.getParent();
    assertEquals(6, parent.getElements().size());
    assertEquals(6, parent.getPathNames().length);
    List<PathElement> elements = actualPrefixWithWildcardResult.getElements();
    assertEquals(7, elements.size());
    assertEquals(7, pathNames.length);
    assertSame(lastElement, elements.get(6));
    assertSame(elements.get(5), parent.getLastElement());
  }

  /**
   * Test {@link Path#trimFirst()}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return LastElement is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Path#trimFirst()}
   */
  @Test
  @DisplayName("Test trimFirst(); given EMPTY_SCOPE; then return LastElement is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.trimFirst()"})
  void testTrimFirst_givenEmpty_scope_thenReturnLastElementIsNull() {
    // Arrange and Act
    Path actualTrimFirstResult = ScopeReferenceHelper.EMPTY_SCOPE.trimFirst();

    // Assert
    assertNull(actualTrimFirstResult.getLastElement());
    assertEquals(0, actualTrimFirstResult.getPathNames().length);
    assertTrue(actualTrimFirstResult.getElements().isEmpty());
  }

  /**
   * Test {@link Path#nameStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>When {@link Path#Path()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Path#nameStartMatches(Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test nameStartMatches(Path, boolean) with 'other', 'allowWildcard'; given Path(); when Path(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path, boolean)"})
  void testNameStartMatchesWithOtherAllowWildcard_givenPath_whenPath_thenReturnTrue() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertTrue(path.nameStartMatches(new Path(), true));
  }

  /**
   * Test {@link Path#nameStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Path#nameStartMatches(Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test nameStartMatches(Path, boolean) with 'other', 'allowWildcard'; when EMPTY_SCOPE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path, boolean)"})
  void testNameStartMatchesWithOtherAllowWildcard_whenEmpty_scope_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Path().nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
  }

  /**
   * Test {@link Path#nameStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Path#nameStartMatches(Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test nameStartMatches(Path, boolean) with 'other', 'allowWildcard'; when EMPTY_SCOPE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path, boolean)"})
  void testNameStartMatchesWithOtherAllowWildcard_whenEmpty_scope_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        ScopeReferenceHelper.EMPTY_SCOPE.nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
  }

  /**
   * Test {@link Path#nameStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>When {@link Path#Path()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Path#nameStartMatches(Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test nameStartMatches(Path, boolean) with 'other', 'allowWildcard'; when Path(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path, boolean)"})
  void testNameStartMatchesWithOtherAllowWildcard_whenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.nameStartMatches(new Path(), true));
  }

  /**
   * Test {@link Path#nameStartMatches(Path)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Path#nameStartMatches(Path)}
   */
  @Test
  @DisplayName(
      "Test nameStartMatches(Path) with 'other'; given EMPTY_SCOPE; when EMPTY_SCOPE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path)"})
  void testNameStartMatchesWithOther_givenEmpty_scope_whenEmpty_scope_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#nameStartMatches(Path)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>When {@link Path#Path()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Path#nameStartMatches(Path)}
   */
  @Test
  @DisplayName(
      "Test nameStartMatches(Path) with 'other'; given EMPTY_SCOPE; when Path(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path)"})
  void testNameStartMatchesWithOther_givenEmpty_scope_whenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.nameStartMatches(new Path()));
  }

  /**
   * Test {@link Path#nameStartMatches(Path)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Path#nameStartMatches(Path)}
   */
  @Test
  @DisplayName(
      "Test nameStartMatches(Path) with 'other'; given Path(); when EMPTY_SCOPE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path)"})
  void testNameStartMatchesWithOther_givenPath_whenEmpty_scope_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Path().nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#nameStartMatches(Path)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>When {@link Path#Path()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Path#nameStartMatches(Path)}
   */
  @Test
  @DisplayName(
      "Test nameStartMatches(Path) with 'other'; given Path(); when Path(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path)"})
  void testNameStartMatchesWithOther_givenPath_whenPath_thenReturnTrue() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertTrue(path.nameStartMatches(new Path()));
  }

  /**
   * Test {@link Path#fullStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test fullStartMatches(Path, boolean) with 'other', 'allowWildcard'; given EMPTY_SCOPE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path, boolean)"})
  void testFullStartMatchesWithOtherAllowWildcard_givenEmpty_scope_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
  }

  /**
   * Test {@link Path#fullStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test fullStartMatches(Path, boolean) with 'other', 'allowWildcard'; given Path(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path, boolean)"})
  void testFullStartMatchesWithOtherAllowWildcard_givenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Path().fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
  }

  /**
   * Test {@link Path#fullStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>When {@link Path#Path()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test fullStartMatches(Path, boolean) with 'other', 'allowWildcard'; given Path(); when Path(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path, boolean)"})
  void testFullStartMatchesWithOtherAllowWildcard_givenPath_whenPath_thenReturnTrue() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertTrue(path.fullStartMatches(new Path(), true));
  }

  /**
   * Test {@link Path#fullStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>Given valueOf {@code *}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test fullStartMatches(Path, boolean) with 'other', 'allowWildcard'; given valueOf '*'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path, boolean)"})
  void testFullStartMatchesWithOtherAllowWildcard_givenValueOfAsterisk_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Path.valueOf("*").fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
  }

  /**
   * Test {@link Path#fullStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>Given valueOf {@code *}.
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test fullStartMatches(Path, boolean) with 'other', 'allowWildcard'; given valueOf '*'; when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path, boolean)"})
  void testFullStartMatchesWithOtherAllowWildcard_givenValueOfAsterisk_whenFalse() {
    // Arrange, Act and Assert
    assertFalse(Path.valueOf("*").fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, false));
  }

  /**
   * Test {@link Path#fullStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test fullStartMatches(Path, boolean) with 'other', 'allowWildcard'; when 'false'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path, boolean)"})
  void testFullStartMatchesWithOtherAllowWildcard_whenFalse_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, false));
  }

  /**
   * Test {@link Path#fullStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>When {@link Path#Path()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test fullStartMatches(Path, boolean) with 'other', 'allowWildcard'; when Path(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path, boolean)"})
  void testFullStartMatchesWithOtherAllowWildcard_whenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(new Path(), true));
  }

  /**
   * Test {@link Path#fullStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>When valueOf {@code *}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  @DisplayName(
      "Test fullStartMatches(Path, boolean) with 'other', 'allowWildcard'; when valueOf '*'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path, boolean)"})
  void testFullStartMatchesWithOtherAllowWildcard_whenValueOfAsterisk_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(Path.valueOf("*"), true));
  }

  /**
   * Test {@link Path#fullStartMatches(Path)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Path#fullStartMatches(Path)}
   */
  @Test
  @DisplayName(
      "Test fullStartMatches(Path) with 'other'; given EMPTY_SCOPE; when EMPTY_SCOPE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path)"})
  void testFullStartMatchesWithOther_givenEmpty_scope_whenEmpty_scope_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#fullStartMatches(Path)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>When {@link Path#Path()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Path#fullStartMatches(Path)}
   */
  @Test
  @DisplayName(
      "Test fullStartMatches(Path) with 'other'; given EMPTY_SCOPE; when Path(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path)"})
  void testFullStartMatchesWithOther_givenEmpty_scope_whenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(new Path()));
  }

  /**
   * Test {@link Path#fullStartMatches(Path)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Path#fullStartMatches(Path)}
   */
  @Test
  @DisplayName(
      "Test fullStartMatches(Path) with 'other'; given Path(); when EMPTY_SCOPE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path)"})
  void testFullStartMatchesWithOther_givenPath_whenEmpty_scope_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Path().fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#fullStartMatches(Path)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>When {@link Path#Path()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Path#fullStartMatches(Path)}
   */
  @Test
  @DisplayName(
      "Test fullStartMatches(Path) with 'other'; given Path(); when Path(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path)"})
  void testFullStartMatchesWithOther_givenPath_whenPath_thenReturnTrue() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertTrue(path.fullStartMatches(new Path()));
  }

  /**
   * Test {@link Path#nameIndexMatches(Path)}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Path#nameIndexMatches(Path)}
   */
  @Test
  @DisplayName(
      "Test nameIndexMatches(Path); given EMPTY_SCOPE; when EMPTY_SCOPE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.nameIndexMatches(Path)"})
  void testNameIndexMatches_givenEmpty_scope_whenEmpty_scope_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.nameIndexMatches(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#nameIndexMatches(Path)}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>When {@link Path#Path()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Path#nameIndexMatches(Path)}
   */
  @Test
  @DisplayName("Test nameIndexMatches(Path); given EMPTY_SCOPE; when Path(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.nameIndexMatches(Path)"})
  void testNameIndexMatches_givenEmpty_scope_whenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.nameIndexMatches(new Path()));
  }

  /**
   * Test {@link Path#nameIndexMatches(Path)}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Path#nameIndexMatches(Path)}
   */
  @Test
  @DisplayName("Test nameIndexMatches(Path); given Path(); when EMPTY_SCOPE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.nameIndexMatches(Path)"})
  void testNameIndexMatches_givenPath_whenEmpty_scope_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Path().nameIndexMatches(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#nameIndexMatches(Path)}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>When {@link Path#Path()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Path#nameIndexMatches(Path)}
   */
  @Test
  @DisplayName("Test nameIndexMatches(Path); given Path(); when Path(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.nameIndexMatches(Path)"})
  void testNameIndexMatches_givenPath_whenPath_thenReturnTrue() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertTrue(path.nameIndexMatches(new Path()));
  }

  /**
   * Test {@link Path#endsWith(Path)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Path#endsWith(Path)}
   */
  @Test
  @DisplayName(
      "Test endsWith(Path) with 'other'; given EMPTY_SCOPE; when EMPTY_SCOPE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.endsWith(Path)"})
  void testEndsWithWithOther_givenEmpty_scope_whenEmpty_scope_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.endsWith(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#endsWith(Path)} with {@code other}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Path#endsWith(Path)}
   */
  @Test
  @DisplayName(
      "Test endsWith(Path) with 'other'; given Path(); when EMPTY_SCOPE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.endsWith(Path)"})
  void testEndsWithWithOther_givenPath_whenEmpty_scope_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Path().endsWith(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#endsWith(Path)} with {@code other}.
   *
   * <ul>
   *   <li>Given valueOf {@code Path}.
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Path#endsWith(Path)}
   */
  @Test
  @DisplayName(
      "Test endsWith(Path) with 'other'; given valueOf 'Path'; when EMPTY_SCOPE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.endsWith(Path)"})
  void testEndsWithWithOther_givenValueOfPath_whenEmpty_scope_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Path.valueOf("Path").endsWith(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#endsWith(Path)} with {@code other}.
   *
   * <ul>
   *   <li>Given valueOf {@code Path}.
   *   <li>When valueOf {@code Path}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Path#endsWith(Path)}
   */
  @Test
  @DisplayName(
      "Test endsWith(Path) with 'other'; given valueOf 'Path'; when valueOf 'Path'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.endsWith(Path)"})
  void testEndsWithWithOther_givenValueOfPath_whenValueOfPath_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Path.valueOf("Path").endsWith(Path.valueOf("Path")));
  }

  /**
   * Test {@link Path#endsWith(String[])} with {@code path}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Path#endsWith(String[])}
   */
  @Test
  @DisplayName("Test endsWith(String[]) with 'path'; given EMPTY_SCOPE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.endsWith(String[])"})
  void testEndsWithWithPath_givenEmpty_scope_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.endsWith("Path"));
  }

  /**
   * Test {@link Path#endsWith(String[])} with {@code path}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Path#endsWith(String[])}
   */
  @Test
  @DisplayName("Test endsWith(String[]) with 'path'; given Path(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.endsWith(String[])"})
  void testEndsWithWithPath_givenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Path().endsWith("Path"));
  }

  /**
   * Test {@link Path#endsWith(String[])} with {@code path}.
   *
   * <ul>
   *   <li>Given valueOf {@code Path}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Path#endsWith(String[])}
   */
  @Test
  @DisplayName("Test endsWith(String[]) with 'path'; given valueOf 'Path'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.endsWith(String[])"})
  void testEndsWithWithPath_givenValueOfPath_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Path.valueOf("Path").endsWith("Path"));
  }

  /**
   * Test {@link Path#cardinality()}.
   *
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.
   * </ul>
   *
   * <p>Method under test: {@link Path#cardinality()}
   */
  @Test
  @DisplayName("Test cardinality(); given EMPTY_SCOPE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Path.cardinality()"})
  void testCardinality_givenEmpty_scope() {
    // Arrange, Act and Assert
    assertEquals(0, ScopeReferenceHelper.EMPTY_SCOPE.cardinality());
  }

  /**
   * Test {@link Path#cardinality()}.
   *
   * <ul>
   *   <li>Given {@link Path#Path()}.
   * </ul>
   *
   * <p>Method under test: {@link Path#cardinality()}
   */
  @Test
  @DisplayName("Test cardinality(); given Path()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Path.cardinality()"})
  void testCardinality_givenPath() {
    // Arrange, Act and Assert
    assertEquals(0, new Path().cardinality());
  }

  /**
   * Test {@link Path#parse(String, boolean)} with {@code pathString}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>Then return LastElement Index intValue is nine.
   * </ul>
   *
   * <p>Method under test: {@link Path#parse(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parse(String, boolean) with 'pathString', 'allowWildcard'; then return LastElement Index intValue is nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.parse(String, boolean)"})
  void testParseWithPathStringAllowWildcard_thenReturnLastElementIndexIntValueIsNine() {
    // Arrange and Act
    Path actualParseResult = Path.parse("*[9]", true);

    // Assert
    PathElement lastElement = actualParseResult.getLastElement();
    assertEquals("*", lastElement.getPathName());
    Path parent = actualParseResult.getParent();
    assertNull(parent.getLastElement());
    assertEquals(0, parent.getPathNames().length);
    List<PathElement> elements = actualParseResult.getElements();
    assertEquals(1, elements.size());
    Optional<Integer> index = lastElement.getIndex();
    assertEquals(9, index.get().intValue());
    assertTrue(parent.getElements().isEmpty());
    assertTrue(index.isPresent());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[] {"*"}, actualParseResult.getPathNames());
  }

  /**
   * Test {@link Path#parse(String, boolean)} with {@code pathString}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>Then return Parent Elements size is five.
   * </ul>
   *
   * <p>Method under test: {@link Path#parse(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parse(String, boolean) with 'pathString', 'allowWildcard'; then return Parent Elements size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.parse(String, boolean)"})
  void testParseWithPathStringAllowWildcard_thenReturnParentElementsSizeIsFive() {
    // Arrange and Act
    Path actualParseResult = Path.parse("com.regnosys.rosetta.common.translation.Path", true);

    // Assert
    Path parent = actualParseResult.getParent();
    assertEquals(5, parent.getElements().size());
    List<PathElement> elements = actualParseResult.getElements();
    assertEquals(6, elements.size());
    assertSame(elements.get(4), parent.getLastElement());
  }

  /**
   * Test {@link Path#parse(String, boolean)} with {@code pathString}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>Then return Parent Elements size is five.
   * </ul>
   *
   * <p>Method under test: {@link Path#parse(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parse(String, boolean) with 'pathString', 'allowWildcard'; then return Parent Elements size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.parse(String, boolean)"})
  void testParseWithPathStringAllowWildcard_thenReturnParentElementsSizeIsFive2() {
    // Arrange and Act
    Path actualParseResult = Path.parse("com.regnosys.rosetta.common.translation.Path", false);

    // Assert
    Path parent = actualParseResult.getParent();
    assertEquals(5, parent.getElements().size());
    List<PathElement> elements = actualParseResult.getElements();
    assertEquals(6, elements.size());
    assertSame(elements.get(4), parent.getLastElement());
  }

  /**
   * Test {@link Path#parse(String, boolean)} with {@code pathString}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>When {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link Path#parse(String, boolean)}
   */
  @Test
  @DisplayName("Test parse(String, boolean) with 'pathString', 'allowWildcard'; when '*'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.parse(String, boolean)"})
  void testParseWithPathStringAllowWildcard_whenAsterisk() {
    // Arrange and Act
    Path actualParseResult = Path.parse("*", true);

    // Assert
    PathElement lastElement = actualParseResult.getLastElement();
    assertEquals("*", lastElement.getPathName());
    Path parent = actualParseResult.getParent();
    assertNull(parent.getLastElement());
    assertEquals(0, parent.getPathNames().length);
    List<PathElement> elements = actualParseResult.getElements();
    assertEquals(1, elements.size());
    assertTrue(parent.getElements().isEmpty());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[] {"*"}, actualParseResult.getPathNames());
  }

  /**
   * Test {@link Path#parse(String, boolean)} with {@code pathString}, {@code allowWildcard}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return LastElement is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Path#parse(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parse(String, boolean) with 'pathString', 'allowWildcard'; when empty string; then return LastElement is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.parse(String, boolean)"})
  void testParseWithPathStringAllowWildcard_whenEmptyString_thenReturnLastElementIsNull() {
    // Arrange and Act
    Path actualParseResult = Path.parse("", true);

    // Assert
    assertNull(actualParseResult.getLastElement());
    assertEquals(0, actualParseResult.getPathNames().length);
    assertTrue(actualParseResult.getElements().isEmpty());
  }

  /**
   * Test {@link Path#parse(String)} with {@code pathString}.
   *
   * <ul>
   *   <li>Then return LastElement PathName is {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link Path#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String) with 'pathString'; then return LastElement PathName is 'Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.parse(String)"})
  void testParseWithPathString_thenReturnLastElementPathNameIsPath() {
    // Arrange and Act
    Path actualParseResult = Path.parse("com.regnosys.rosetta.common.translation.Path");

    // Assert
    PathElement lastElement = actualParseResult.getLastElement();
    assertEquals("Path", lastElement.getPathName());
    Path parent = actualParseResult.getParent();
    assertEquals(5, parent.getElements().size());
    assertEquals(5, parent.getPathNames().length);
    List<PathElement> elements = actualParseResult.getElements();
    assertEquals(6, elements.size());
    assertSame(lastElement, elements.get(5));
    assertSame(elements.get(4), parent.getLastElement());
    assertArrayEquals(
        new String[] {"com", "regnosys", "rosetta", "common", "translation", "Path"},
        actualParseResult.getPathNames());
  }

  /**
   * Test {@link Path#parse(String)} with {@code pathString}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return LastElement PathName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Path#parse(String)}
   */
  @Test
  @DisplayName(
      "Test parse(String) with 'pathString'; when '42'; then return LastElement PathName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.parse(String)"})
  void testParseWithPathString_when42_thenReturnLastElementPathNameIs42() {
    // Arrange and Act
    Path actualParseResult = Path.parse("42");

    // Assert
    PathElement lastElement = actualParseResult.getLastElement();
    assertEquals("42", lastElement.getPathName());
    Path parent = actualParseResult.getParent();
    assertNull(parent.getLastElement());
    assertEquals(0, parent.getPathNames().length);
    List<PathElement> elements = actualParseResult.getElements();
    assertEquals(1, elements.size());
    assertFalse(lastElement.getIndex().isPresent());
    assertTrue(parent.getElements().isEmpty());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[] {"42"}, actualParseResult.getPathNames());
  }

  /**
   * Test {@link Path#parse(String)} with {@code pathString}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return LastElement is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Path#parse(String)}
   */
  @Test
  @DisplayName(
      "Test parse(String) with 'pathString'; when empty string; then return LastElement is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.parse(String)"})
  void testParseWithPathString_whenEmptyString_thenReturnLastElementIsNull() {
    // Arrange and Act
    Path actualParseResult = Path.parse("");

    // Assert
    assertNull(actualParseResult.getLastElement());
    assertEquals(0, actualParseResult.getPathNames().length);
    assertTrue(actualParseResult.getElements().isEmpty());
  }

  /**
   * Test {@link Path#parse(String)} with {@code pathString}.
   *
   * <ul>
   *   <li>When {@code U[9]}.
   *   <li>Then return LastElement PathName is {@code U}.
   * </ul>
   *
   * <p>Method under test: {@link Path#parse(String)}
   */
  @Test
  @DisplayName(
      "Test parse(String) with 'pathString'; when 'U[9]'; then return LastElement PathName is 'U'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path Path.parse(String)"})
  void testParseWithPathString_whenU9_thenReturnLastElementPathNameIsU() {
    // Arrange and Act
    Path actualParseResult = Path.parse("U[9]");

    // Assert
    PathElement lastElement = actualParseResult.getLastElement();
    assertEquals("U", lastElement.getPathName());
    List<PathElement> elements = actualParseResult.getElements();
    assertEquals(1, elements.size());
    Optional<Integer> index = lastElement.getIndex();
    assertEquals(9, index.get().intValue());
    assertTrue(index.isPresent());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[] {"U"}, actualParseResult.getPathNames());
  }

  /**
   * Test {@link Path#equals(Object)}, and {@link Path#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Path#equals(Object)}
   *   <li>{@link Path#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.equals(Object)", "int Path.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Path path = ScopeReferenceHelper.EMPTY_SCOPE;
    Path path2 = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act and Assert
    assertEquals(path, path2);
    assertEquals(path.hashCode(), path2.hashCode());
  }

  /**
   * Test {@link Path#equals(Object)}, and {@link Path#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Path#equals(Object)}
   *   <li>{@link Path#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.equals(Object)", "int Path.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Path path = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act and Assert
    assertEquals(path, path);
    int expectedHashCodeResult = path.hashCode();
    assertEquals(expectedHashCodeResult, path.hashCode());
  }

  /**
   * Test {@link Path#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Path#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.equals(Object)", "int Path.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Path(), ScopeReferenceHelper.EMPTY_SCOPE);
  }

  /**
   * Test {@link Path#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Path#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.equals(Object)", "int Path.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ScopeReferenceHelper.EMPTY_SCOPE, null);
  }

  /**
   * Test {@link Path#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Path#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Path.equals(Object)", "int Path.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ScopeReferenceHelper.EMPTY_SCOPE, "Different type to Path");
  }
}
