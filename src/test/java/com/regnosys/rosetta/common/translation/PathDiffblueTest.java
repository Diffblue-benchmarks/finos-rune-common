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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.hashing.ScopeReferenceHelper;
import com.regnosys.rosetta.common.translation.Path.PathElement;
import com.regnosys.rosetta.common.util.PathException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PathDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Path#Path(List)}
   *   <li>{@link Path#toString()}
   *   <li>{@link Path#getElements()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Path.<init>(List)", "List Path.getElements()", "String Path.toString()"})
  public void testGettersAndSetters() {
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
   * <p>
   * Method under test: {@link Path#Path()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Path.<init>()"})
  public void testNewPath() {
    // Arrange and Act
    Path actualPath = new Path();

    // Assert
    assertNull(actualPath.getLastElement());
    assertEquals(0, actualPath.getPathNames().length);
    assertTrue(actualPath.getElements().isEmpty());
  }

  /**
   * Test PathElement {@link PathElement#equals(Object)}, and {@link PathElement#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PathElement#equals(Object)}
   *   <li>{@link PathElement#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PathElement.equals(Object)", "int PathElement.hashCode()"})
  public void testPathElementEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PathElement parseResult = PathElement.parse("foo", true);
    PathElement parseResult2 = PathElement.parse("foo", true);

    // Act and Assert
    assertEquals(parseResult, parseResult2);
    int expectedHashCodeResult = parseResult.hashCode();
    assertEquals(expectedHashCodeResult, parseResult2.hashCode());
  }

  /**
   * Test PathElement {@link PathElement#equals(Object)}, and {@link PathElement#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PathElement#equals(Object)}
   *   <li>{@link PathElement#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PathElement.equals(Object)", "int PathElement.hashCode()"})
  public void testPathElementEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PathElement parseResult = PathElement.parse("foo", true);

    // Act and Assert
    assertEquals(parseResult, parseResult);
    int expectedHashCodeResult = parseResult.hashCode();
    assertEquals(expectedHashCodeResult, parseResult.hashCode());
  }

  /**
   * Test PathElement {@link PathElement#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathElement#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PathElement.equals(Object)", "int PathElement.hashCode()"})
  public void testPathElementEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PathElement parseResult = PathElement.parse("42", true);

    // Act and Assert
    assertNotEquals(parseResult, PathElement.parse("foo", true));
  }

  /**
   * Test PathElement {@link PathElement#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathElement#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PathElement.equals(Object)", "int PathElement.hashCode()"})
  public void testPathElementEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PathElement pathElement = new PathElement("foo", 1);

    // Act and Assert
    assertNotEquals(pathElement, PathElement.parse("foo", true));
  }

  /**
   * Test PathElement {@link PathElement#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathElement#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PathElement.equals(Object)", "int PathElement.hashCode()"})
  public void testPathElementEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PathElement.parse("foo", true), null);
  }

  /**
   * Test PathElement {@link PathElement#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathElement#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PathElement.equals(Object)", "int PathElement.hashCode()"})
  public void testPathElementEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PathElement.parse("foo", true), "Different type to PathElement");
  }

  /**
   * Test PathElement {@link PathElement#forceGetIndex()}.
   * <ul>
   *   <li>Given parse {@code foo} and {@code true}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathElement#forceGetIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int PathElement.forceGetIndex()"})
  public void testPathElementForceGetIndex_givenParseFooAndTrue_thenReturnZero() {
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
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathElement#forceGetIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int PathElement.forceGetIndex()"})
  public void testPathElementForceGetIndex_thenReturnOne() {
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PathElement#toString()}
   *   <li>{@link PathElement#getIndex()}
   *   <li>{@link PathElement#getMetas()}
   *   <li>{@link PathElement#getPathName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional PathElement.getIndex()", "Map PathElement.getMetas()",
      "String PathElement.getPathName()", "String PathElement.toString()"})
  public void testPathElementGettersAndSetters() {
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
   * <p>
   * Method under test: {@link PathElement#PathElement(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PathElement.<init>(String)"})
  public void testPathElementNewPathElement() {
    // Arrange and Act
    PathElement actualPathElement = new PathElement("Path Name");

    // Assert
    assertEquals("Path Name", actualPathElement.getPathName());
    assertFalse(actualPathElement.getIndex().isPresent());
    assertTrue(actualPathElement.getMetas().isEmpty());
  }

  /**
   * Test PathElement {@link PathElement#PathElement(String, int)}.
   * <p>
   * Method under test: {@link PathElement#PathElement(String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PathElement.<init>(String, int)"})
  public void testPathElementNewPathElement2() {
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
   * <p>
   * Method under test: {@link PathElement#PathElement(String, int, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PathElement.<init>(String, int, Map)"})
  public void testPathElementNewPathElement3() {
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
   * <p>
   * Method under test: {@link PathElement#PathElement(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PathElement.<init>(String, Map)"})
  public void testPathElementNewPathElement4() {
    // Arrange and Act
    PathElement actualPathElement = new PathElement("Path Name", new HashMap<>());

    // Assert
    assertEquals("Path Name", actualPathElement.getPathName());
    assertFalse(actualPathElement.getIndex().isPresent());
    assertTrue(actualPathElement.getMetas().isEmpty());
  }

  /**
   * Test PathElement {@link PathElement#PathElement(String, Optional, Map)}.
   * <p>
   * Method under test: {@link PathElement#PathElement(String, Optional, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PathElement.<init>(String, Optional, Map)"})
  public void testPathElementNewPathElement5() {
    // Arrange
    Optional<Integer> index = Optional.<Integer>of(1);

    // Act
    PathElement actualPathElement = new PathElement("Path Name", index, new HashMap<>());

    // Assert
    assertEquals("Path Name", actualPathElement.getPathName());
    assertTrue(actualPathElement.getMetas().isEmpty());
    assertSame(index, actualPathElement.getIndex());
  }

  /**
   * Test PathElement {@link PathElement#parse(String, boolean)} with {@code s}, {@code allowWildcard}.
   * <ul>
   *   <li>When {@code *[9]}.</li>
   *   <li>Then return PathName is {@code *}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathElement#parse(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PathElement PathElement.parse(String, boolean)"})
  public void testPathElementParseWithSAllowWildcard_when9_thenReturnPathNameIsAsterisk() {
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
   * Test PathElement {@link PathElement#parse(String, boolean)} with {@code s}, {@code allowWildcard}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return PathName is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathElement#parse(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PathElement PathElement.parse(String, boolean)"})
  public void testPathElementParseWithSAllowWildcard_whenFoo_thenReturnPathNameIsFoo() {
    // Arrange and Act
    PathElement actualParseResult = PathElement.parse("foo", true);

    // Assert
    assertEquals("foo", actualParseResult.getPathName());
    assertFalse(actualParseResult.getIndex().isPresent());
    assertTrue(actualParseResult.getMetas().isEmpty());
  }

  /**
   * Test PathElement {@link PathElement#parse(String, boolean)} with {@code s}, {@code allowWildcard}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return PathName is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathElement#parse(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PathElement PathElement.parse(String, boolean)"})
  public void testPathElementParseWithSAllowWildcard_whenFoo_thenReturnPathNameIsFoo2() {
    // Arrange and Act
    PathElement actualParseResult = PathElement.parse("foo", false);

    // Assert
    assertEquals("foo", actualParseResult.getPathName());
    assertFalse(actualParseResult.getIndex().isPresent());
    assertTrue(actualParseResult.getMetas().isEmpty());
  }

  /**
   * Test PathElement {@link PathElement#parse(String, boolean)} with {@code s}, {@code allowWildcard}.
   * <ul>
   *   <li>When {@code ([*]|\w*)(\[(\d*)])?}.</li>
   *   <li>Then throw {@link PathException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathElement#parse(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PathElement PathElement.parse(String, boolean)"})
  public void testPathElementParseWithSAllowWildcard_whenWD_thenThrowPathException() {
    // Arrange, Act and Assert
    assertThrows(PathException.class, () -> PathElement.parse("([*]|\\w*)(\\[(\\d*)])?", true));
  }

  /**
   * Test PathElement {@link PathElement#parse(String)} with {@code s}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return PathName is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathElement#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PathElement PathElement.parse(String)"})
  public void testPathElementParseWithS_whenFoo_thenReturnPathNameIsFoo() {
    // Arrange and Act
    PathElement actualParseResult = PathElement.parse("foo");

    // Assert
    assertEquals("foo", actualParseResult.getPathName());
    assertFalse(actualParseResult.getIndex().isPresent());
    assertTrue(actualParseResult.getMetas().isEmpty());
  }

  /**
   * Test PathElement {@link PathElement#parse(String)} with {@code s}.
   * <ul>
   *   <li>When {@code U[9]}.</li>
   *   <li>Then return PathName is {@code U}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathElement#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PathElement PathElement.parse(String)"})
  public void testPathElementParseWithS_whenU9_thenReturnPathNameIsU() {
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
   * <ul>
   *   <li>When {@code ([*]|\w*)(\[(\d*)])?}.</li>
   *   <li>Then throw {@link PathException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PathElement#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PathElement PathElement.parse(String)"})
  public void testPathElementParseWithS_whenWD_thenThrowPathException() {
    // Arrange, Act and Assert
    assertThrows(PathException.class, () -> PathElement.parse("([*]|\\w*)(\\[(\\d*)])?"));
  }

  /**
   * Test {@link Path#valueOf(List)} with {@code List}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return Parent Elements size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#valueOf(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.valueOf(List)"})
  public void testValueOfWithList_given42_whenArrayListAdd42_thenReturnParentElementsSizeIsOne() {
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
    PathElement expectedLastElement = elements.get(0);
    assertSame(expectedLastElement, parent.getLastElement());
    assertArrayEquals(new String[]{"42", "foo"}, actualValueOfResult.getPathNames());
  }

  /**
   * Test {@link Path#valueOf(List)} with {@code List}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return Parent LastElement is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#valueOf(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.valueOf(List)"})
  public void testValueOfWithList_givenFoo_thenReturnParentLastElementIsNull() {
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
    assertArrayEquals(new String[]{"foo"}, actualValueOfResult.getPathNames());
  }

  /**
   * Test {@link Path#valueOf(List)} with {@code List}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return LastElement is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#valueOf(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.valueOf(List)"})
  public void testValueOfWithList_whenArrayList_thenReturnLastElementIsNull() {
    // Arrange and Act
    Path actualValueOfResult = Path.valueOf(new ArrayList<>());

    // Assert
    assertNull(actualValueOfResult.getLastElement());
    assertEquals(0, actualValueOfResult.getPathNames().length);
    assertTrue(actualValueOfResult.getElements().isEmpty());
  }

  /**
   * Test {@link Path#valueOf(String)} with {@code String}.
   * <p>
   * Method under test: {@link Path#valueOf(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.valueOf(String)"})
  public void testValueOfWithString() {
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
    assertArrayEquals(new String[]{"Path"}, actualValueOfResult.getPathNames());
  }

  /**
   * Test {@link Path#addElement(PathElement)} with {@code element}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return Elements size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#addElement(PathElement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.addElement(PathElement)"})
  public void testAddElementWithElement_givenEmpty_scope_thenReturnElementsSizeIsTwo() {
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
    assertArrayEquals(new String[]{"emptyScope", "foo"}, actualAddElementResult.getPathNames());
  }

  /**
   * Test {@link Path#addElement(PathElement)} with {@code element}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>Then return Elements size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#addElement(PathElement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.addElement(PathElement)"})
  public void testAddElementWithElement_givenPath_thenReturnElementsSizeIsOne() {
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
    assertArrayEquals(new String[]{"foo"}, actualAddElementResult.getPathNames());
  }

  /**
   * Test {@link Path#addElement(String, Integer)} with {@code name}, {@code index}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return Elements size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#addElement(String, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.addElement(String, Integer)"})
  public void testAddElementWithNameIndex_givenEmpty_scope_thenReturnElementsSizeIsTwo() {
    // Arrange
    Path path = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act
    Path actualAddElementResult = path.addElement("Name", 1);

    // Assert
    assertEquals(2, actualAddElementResult.getElements().size());
    assertEquals(path, actualAddElementResult.getParent());
    assertArrayEquals(new String[]{"emptyScope", "Name"}, actualAddElementResult.getPathNames());
  }

  /**
   * Test {@link Path#addElement(String, Integer)} with {@code name}, {@code index}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>Then return Elements size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#addElement(String, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.addElement(String, Integer)"})
  public void testAddElementWithNameIndex_givenPath_thenReturnElementsSizeIsOne() {
    // Arrange
    Path path = new Path();

    // Act
    Path actualAddElementResult = path.addElement("Name", 1);

    // Assert
    assertEquals(1, actualAddElementResult.getElements().size());
    assertEquals(path, actualAddElementResult.getParent());
    assertArrayEquals(new String[]{"Name"}, actualAddElementResult.getPathNames());
  }

  /**
   * Test {@link Path#addElement(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return Elements size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#addElement(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.addElement(String)"})
  public void testAddElementWithName_givenEmpty_scope_thenReturnElementsSizeIsTwo() {
    // Arrange
    Path path = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act
    Path actualAddElementResult = path.addElement("Name");

    // Assert
    assertEquals(2, actualAddElementResult.getElements().size());
    assertEquals(path, actualAddElementResult.getParent());
    assertArrayEquals(new String[]{"emptyScope", "Name"}, actualAddElementResult.getPathNames());
  }

  /**
   * Test {@link Path#addElement(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>Then return Elements size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#addElement(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.addElement(String)"})
  public void testAddElementWithName_givenPath_thenReturnElementsSizeIsOne() {
    // Arrange
    Path path = new Path();

    // Act
    Path actualAddElementResult = path.addElement("Name");

    // Assert
    assertEquals(1, actualAddElementResult.getElements().size());
    assertEquals(path, actualAddElementResult.getParent());
    assertArrayEquals(new String[]{"Name"}, actualAddElementResult.getPathNames());
  }

  /**
   * Test {@link Path#getPathNames()}.
   * <p>
   * Method under test: {@link Path#getPathNames()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] Path.getPathNames()"})
  public void testGetPathNames() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"emptyScope"}, ScopeReferenceHelper.EMPTY_SCOPE.getPathNames());
  }

  /**
   * Test {@link Path#getParent()}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return LastElement is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#getParent()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.getParent()"})
  public void testGetParent_givenEmpty_scope_thenReturnLastElementIsNull() {
    // Arrange and Act
    Path actualParent = ScopeReferenceHelper.EMPTY_SCOPE.getParent();

    // Assert
    assertNull(actualParent.getLastElement());
    assertEquals(0, actualParent.getPathNames().length);
    assertTrue(actualParent.getElements().isEmpty());
  }

  /**
   * Test {@link Path#getLastElement()}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return PathName is {@code emptyScope}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#getLastElement()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PathElement Path.getLastElement()"})
  public void testGetLastElement_givenEmpty_scope_thenReturnPathNameIsEmptyScope() {
    // Arrange and Act
    PathElement actualLastElement = ScopeReferenceHelper.EMPTY_SCOPE.getLastElement();

    // Assert
    assertEquals("emptyScope", actualLastElement.getPathName());
    assertFalse(actualLastElement.getIndex().isPresent());
    assertTrue(actualLastElement.getMetas().isEmpty());
  }

  /**
   * Test {@link Path#getLastElement()}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#getLastElement()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PathElement Path.getLastElement()"})
  public void testGetLastElement_givenPath_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Path()).getLastElement());
  }

  /**
   * Test {@link Path#append(Path)}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return second element is {@code emptyScope}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#append(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.append(Path)"})
  public void testAppend_givenEmpty_scope_whenEmpty_scope_thenReturnSecondElementIsEmptyScope() {
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
   * <ul>
   *   <li>Given parse empty string and {@code true}.</li>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#append(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.append(Path)"})
  public void testAppend_givenParseEmptyStringAndTrue_whenEmpty_scope_thenReturnEmpty_scope() {
    // Arrange
    Path append = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act and Assert
    assertEquals(append, Path.parse("", true).append(append));
  }

  /**
   * Test {@link Path#append(Path)}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return Elements size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#append(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.append(Path)"})
  public void testAppend_givenPath_whenEmpty_scope_thenReturnElementsSizeIsOne() {
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
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>When {@link Path#Path()}.</li>
   *   <li>Then return {@link Path#Path()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#append(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.append(Path)"})
  public void testAppend_givenPath_whenPath_thenReturnPath() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertEquals(path, path.append(new Path()));
  }

  /**
   * Test {@link Path#append(Path)}.
   * <ul>
   *   <li>Then return Elements size is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#append(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.append(Path)"})
  public void testAppend_thenReturnElementsSizeIsSeven() {
    // Arrange
    Path parseResult = Path.parse("com.regnosys.rosetta.common.translation.Path", true);

    // Act
    Path actualAppendResult = parseResult.append(ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    assertEquals(7, actualAppendResult.getElements().size());
    assertEquals(parseResult, actualAppendResult.getParent());
    assertArrayEquals(new String[]{"com", "regnosys", "rosetta", "common", "translation", "Path", "emptyScope"},
        actualAppendResult.getPathNames());
  }

  /**
   * Test {@link Path#prefixWithWildcard()}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>Then return Parent is {@link Path#Path()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#prefixWithWildcard()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.prefixWithWildcard()"})
  public void testPrefixWithWildcard_givenPath_thenReturnParentIsPath() {
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
   * <ul>
   *   <li>Then return LastElement PathName is {@code *}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#prefixWithWildcard()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.prefixWithWildcard()"})
  public void testPrefixWithWildcard_thenReturnLastElementPathNameIsAsterisk() {
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
   * <ul>
   *   <li>Then return LastElement PathName is {@code emptyScope}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#prefixWithWildcard()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.prefixWithWildcard()"})
  public void testPrefixWithWildcard_thenReturnLastElementPathNameIsEmptyScope() {
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
   * <ul>
   *   <li>Then return LastElement PathName is {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#prefixWithWildcard()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.prefixWithWildcard()"})
  public void testPrefixWithWildcard_thenReturnLastElementPathNameIsPath() {
    // Arrange and Act
    Path actualPrefixWithWildcardResult = Path.parse("com.regnosys.rosetta.common.translation.Path", true)
        .prefixWithWildcard();

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
    PathElement expectedLastElement = elements.get(5);
    assertSame(expectedLastElement, parent.getLastElement());
  }

  /**
   * Test {@link Path#trimFirst()}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return LastElement is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#trimFirst()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.trimFirst()"})
  public void testTrimFirst_givenEmpty_scope_thenReturnLastElementIsNull() {
    // Arrange and Act
    Path actualTrimFirstResult = ScopeReferenceHelper.EMPTY_SCOPE.trimFirst();

    // Assert
    assertNull(actualTrimFirstResult.getLastElement());
    assertEquals(0, actualTrimFirstResult.getPathNames().length);
    assertTrue(actualTrimFirstResult.getElements().isEmpty());
  }

  /**
   * Test {@link Path#nameStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameStartMatches(Path, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path, boolean)"})
  public void testNameStartMatchesWithOtherAllowWildcard_givenEmpty_scope_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
  }

  /**
   * Test {@link Path#nameStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameStartMatches(Path, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path, boolean)"})
  public void testNameStartMatchesWithOtherAllowWildcard_givenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Path()).nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
  }

  /**
   * Test {@link Path#nameStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>When {@link Path#Path()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameStartMatches(Path, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path, boolean)"})
  public void testNameStartMatchesWithOtherAllowWildcard_givenPath_whenPath_thenReturnTrue() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertTrue(path.nameStartMatches(new Path(), true));
  }

  /**
   * Test {@link Path#nameStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   * <ul>
   *   <li>Given valueOf {@code *}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameStartMatches(Path, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path, boolean)"})
  public void testNameStartMatchesWithOtherAllowWildcard_givenValueOfAsterisk_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Path.valueOf("*").nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
  }

  /**
   * Test {@link Path#nameStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   * <ul>
   *   <li>Given valueOf {@code Path}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameStartMatches(Path, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path, boolean)"})
  public void testNameStartMatchesWithOtherAllowWildcard_givenValueOfPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Path.valueOf("Path").nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
  }

  /**
   * Test {@link Path#nameStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   * <ul>
   *   <li>Given valueOf {@code Path}.</li>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameStartMatches(Path, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path, boolean)"})
  public void testNameStartMatchesWithOtherAllowWildcard_givenValueOfPath_whenFalse() {
    // Arrange, Act and Assert
    assertFalse(Path.valueOf("Path").nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, false));
  }

  /**
   * Test {@link Path#nameStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   * <ul>
   *   <li>When {@link Path#Path()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameStartMatches(Path, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path, boolean)"})
  public void testNameStartMatchesWithOtherAllowWildcard_whenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.nameStartMatches(new Path(), true));
  }

  /**
   * Test {@link Path#nameStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   * <ul>
   *   <li>When valueOf {@code *}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameStartMatches(Path, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path, boolean)"})
  public void testNameStartMatchesWithOtherAllowWildcard_whenValueOfAsterisk_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.nameStartMatches(Path.valueOf("*"), true));
  }

  /**
   * Test {@link Path#nameStartMatches(Path)} with {@code other}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameStartMatches(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path)"})
  public void testNameStartMatchesWithOther_givenEmpty_scope_whenEmpty_scope_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#nameStartMatches(Path)} with {@code other}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>When {@link Path#Path()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameStartMatches(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path)"})
  public void testNameStartMatchesWithOther_givenEmpty_scope_whenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.nameStartMatches(new Path()));
  }

  /**
   * Test {@link Path#nameStartMatches(Path)} with {@code other}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameStartMatches(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path)"})
  public void testNameStartMatchesWithOther_givenPath_whenEmpty_scope_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Path()).nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#nameStartMatches(Path)} with {@code other}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>When {@link Path#Path()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameStartMatches(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path)"})
  public void testNameStartMatchesWithOther_givenPath_whenPath_thenReturnTrue() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertTrue(path.nameStartMatches(new Path()));
  }

  /**
   * Test {@link Path#nameStartMatches(Path)} with {@code other}.
   * <ul>
   *   <li>Given valueOf {@code Path}.</li>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameStartMatches(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameStartMatches(Path)"})
  public void testNameStartMatchesWithOther_givenValueOfPath_whenEmpty_scope_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Path.valueOf("Path").nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#fullStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path, boolean)"})
  public void testFullStartMatchesWithOtherAllowWildcard_givenEmpty_scope_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
  }

  /**
   * Test {@link Path#fullStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path, boolean)"})
  public void testFullStartMatchesWithOtherAllowWildcard_givenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Path()).fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
  }

  /**
   * Test {@link Path#fullStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>When {@link Path#Path()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path, boolean)"})
  public void testFullStartMatchesWithOtherAllowWildcard_givenPath_whenPath_thenReturnTrue() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertTrue(path.fullStartMatches(new Path(), true));
  }

  /**
   * Test {@link Path#fullStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   * <ul>
   *   <li>Given valueOf {@code *}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path, boolean)"})
  public void testFullStartMatchesWithOtherAllowWildcard_givenValueOfAsterisk_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Path.valueOf("*").fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
  }

  /**
   * Test {@link Path#fullStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   * <ul>
   *   <li>Given valueOf {@code Path}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path, boolean)"})
  public void testFullStartMatchesWithOtherAllowWildcard_givenValueOfPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Path.valueOf("Path").fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
  }

  /**
   * Test {@link Path#fullStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path, boolean)"})
  public void testFullStartMatchesWithOtherAllowWildcard_whenFalse_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, false));
  }

  /**
   * Test {@link Path#fullStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   * <ul>
   *   <li>When {@link Path#Path()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path, boolean)"})
  public void testFullStartMatchesWithOtherAllowWildcard_whenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(new Path(), true));
  }

  /**
   * Test {@link Path#fullStartMatches(Path, boolean)} with {@code other}, {@code allowWildcard}.
   * <ul>
   *   <li>When valueOf {@code *}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path, boolean)"})
  public void testFullStartMatchesWithOtherAllowWildcard_whenValueOfAsterisk_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(Path.valueOf("*"), true));
  }

  /**
   * Test {@link Path#fullStartMatches(Path)} with {@code other}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#fullStartMatches(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path)"})
  public void testFullStartMatchesWithOther_givenEmpty_scope_whenEmpty_scope_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#fullStartMatches(Path)} with {@code other}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>When {@link Path#Path()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#fullStartMatches(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path)"})
  public void testFullStartMatchesWithOther_givenEmpty_scope_whenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(new Path()));
  }

  /**
   * Test {@link Path#fullStartMatches(Path)} with {@code other}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#fullStartMatches(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path)"})
  public void testFullStartMatchesWithOther_givenPath_whenEmpty_scope_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Path()).fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#fullStartMatches(Path)} with {@code other}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>When {@link Path#Path()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#fullStartMatches(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path)"})
  public void testFullStartMatchesWithOther_givenPath_whenPath_thenReturnTrue() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertTrue(path.fullStartMatches(new Path()));
  }

  /**
   * Test {@link Path#fullStartMatches(Path)} with {@code other}.
   * <ul>
   *   <li>Given valueOf {@code Path}.</li>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#fullStartMatches(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.fullStartMatches(Path)"})
  public void testFullStartMatchesWithOther_givenValueOfPath_whenEmpty_scope_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Path.valueOf("Path").fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#nameIndexMatches(Path)}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameIndexMatches(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameIndexMatches(Path)"})
  public void testNameIndexMatches_givenEmpty_scope_whenEmpty_scope_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.nameIndexMatches(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#nameIndexMatches(Path)}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>When {@link Path#Path()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameIndexMatches(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameIndexMatches(Path)"})
  public void testNameIndexMatches_givenEmpty_scope_whenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.nameIndexMatches(new Path()));
  }

  /**
   * Test {@link Path#nameIndexMatches(Path)}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameIndexMatches(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameIndexMatches(Path)"})
  public void testNameIndexMatches_givenPath_whenEmpty_scope_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Path()).nameIndexMatches(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#nameIndexMatches(Path)}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>When {@link Path#Path()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameIndexMatches(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameIndexMatches(Path)"})
  public void testNameIndexMatches_givenPath_whenPath_thenReturnTrue() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertTrue(path.nameIndexMatches(new Path()));
  }

  /**
   * Test {@link Path#nameIndexMatches(Path)}.
   * <ul>
   *   <li>Given valueOf {@code Path}.</li>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#nameIndexMatches(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.nameIndexMatches(Path)"})
  public void testNameIndexMatches_givenValueOfPath_whenEmpty_scope_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Path.valueOf("Path").nameIndexMatches(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#endsWith(Path)} with {@code other}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#endsWith(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.endsWith(Path)"})
  public void testEndsWithWithOther_givenEmpty_scope_whenEmpty_scope_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.endsWith(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#endsWith(Path)} with {@code other}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#endsWith(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.endsWith(Path)"})
  public void testEndsWithWithOther_givenPath_whenEmpty_scope_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Path()).endsWith(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#endsWith(Path)} with {@code other}.
   * <ul>
   *   <li>Given valueOf {@code emptyScope}.</li>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#endsWith(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.endsWith(Path)"})
  public void testEndsWithWithOther_givenValueOfEmptyScope_whenEmpty_scope_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Path.valueOf("emptyScope").endsWith(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#endsWith(Path)} with {@code other}.
   * <ul>
   *   <li>Given valueOf {@code Path}.</li>
   *   <li>When {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#endsWith(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.endsWith(Path)"})
  public void testEndsWithWithOther_givenValueOfPath_whenEmpty_scope_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Path.valueOf("Path").endsWith(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Test {@link Path#endsWith(String[])} with {@code path}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#endsWith(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.endsWith(String[])"})
  public void testEndsWithWithPath_givenEmpty_scope_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.endsWith("Path"));
  }

  /**
   * Test {@link Path#endsWith(String[])} with {@code path}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#endsWith(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.endsWith(String[])"})
  public void testEndsWithWithPath_givenPath_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Path()).endsWith("Path"));
  }

  /**
   * Test {@link Path#endsWith(String[])} with {@code path}.
   * <ul>
   *   <li>Given valueOf {@code Path}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#endsWith(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.endsWith(String[])"})
  public void testEndsWithWithPath_givenValueOfPath_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Path.valueOf("Path").endsWith("Path"));
  }

  /**
   * Test {@link Path#cardinality()}.
   * <ul>
   *   <li>Given {@link ScopeReferenceHelper#EMPTY_SCOPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#cardinality()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Path.cardinality()"})
  public void testCardinality_givenEmpty_scope() {
    // Arrange, Act and Assert
    assertEquals(0, ScopeReferenceHelper.EMPTY_SCOPE.cardinality());
  }

  /**
   * Test {@link Path#cardinality()}.
   * <ul>
   *   <li>Given {@link Path#Path()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#cardinality()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int Path.cardinality()"})
  public void testCardinality_givenPath() {
    // Arrange, Act and Assert
    assertEquals(0, (new Path()).cardinality());
  }

  /**
   * Test {@link Path#parse(String, boolean)} with {@code pathString}, {@code allowWildcard}.
   * <ul>
   *   <li>Then return LastElement Index intValue is nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#parse(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.parse(String, boolean)"})
  public void testParseWithPathStringAllowWildcard_thenReturnLastElementIndexIntValueIsNine() {
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
    assertArrayEquals(new String[]{"*"}, actualParseResult.getPathNames());
  }

  /**
   * Test {@link Path#parse(String, boolean)} with {@code pathString}, {@code allowWildcard}.
   * <ul>
   *   <li>Then return LastElement PathName is {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#parse(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.parse(String, boolean)"})
  public void testParseWithPathStringAllowWildcard_thenReturnLastElementPathNameIsPath() {
    // Arrange and Act
    Path actualParseResult = Path.parse("com.regnosys.rosetta.common.translation.Path", true);

    // Assert
    PathElement lastElement = actualParseResult.getLastElement();
    assertEquals("Path", lastElement.getPathName());
    Path parent = actualParseResult.getParent();
    assertEquals(5, parent.getElements().size());
    assertEquals(5, parent.getPathNames().length);
    List<PathElement> elements = actualParseResult.getElements();
    assertEquals(6, elements.size());
    assertSame(lastElement, elements.get(5));
    PathElement expectedLastElement = elements.get(4);
    assertSame(expectedLastElement, parent.getLastElement());
    assertArrayEquals(new String[]{"com", "regnosys", "rosetta", "common", "translation", "Path"},
        actualParseResult.getPathNames());
  }

  /**
   * Test {@link Path#parse(String, boolean)} with {@code pathString}, {@code allowWildcard}.
   * <ul>
   *   <li>Then return not LastElement Index Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#parse(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.parse(String, boolean)"})
  public void testParseWithPathStringAllowWildcard_thenReturnNotLastElementIndexPresent() {
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
    assertFalse(lastElement.getIndex().isPresent());
    assertTrue(parent.getElements().isEmpty());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[]{"*"}, actualParseResult.getPathNames());
  }

  /**
   * Test {@link Path#parse(String, boolean)} with {@code pathString}, {@code allowWildcard}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return LastElement is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#parse(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.parse(String, boolean)"})
  public void testParseWithPathStringAllowWildcard_whenEmptyString_thenReturnLastElementIsNull() {
    // Arrange and Act
    Path actualParseResult = Path.parse("", true);

    // Assert
    assertNull(actualParseResult.getLastElement());
    assertEquals(0, actualParseResult.getPathNames().length);
    assertTrue(actualParseResult.getElements().isEmpty());
  }

  /**
   * Test {@link Path#parse(String)} with {@code pathString}.
   * <ul>
   *   <li>Then return LastElement PathName is {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.parse(String)"})
  public void testParseWithPathString_thenReturnLastElementPathNameIsPath() {
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
    PathElement expectedLastElement = elements.get(4);
    assertSame(expectedLastElement, parent.getLastElement());
    assertArrayEquals(new String[]{"com", "regnosys", "rosetta", "common", "translation", "Path"},
        actualParseResult.getPathNames());
  }

  /**
   * Test {@link Path#parse(String)} with {@code pathString}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return LastElement PathName is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.parse(String)"})
  public void testParseWithPathString_when42_thenReturnLastElementPathNameIs42() {
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
    assertArrayEquals(new String[]{"42"}, actualParseResult.getPathNames());
  }

  /**
   * Test {@link Path#parse(String)} with {@code pathString}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return LastElement is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.parse(String)"})
  public void testParseWithPathString_whenEmptyString_thenReturnLastElementIsNull() {
    // Arrange and Act
    Path actualParseResult = Path.parse("");

    // Assert
    assertNull(actualParseResult.getLastElement());
    assertEquals(0, actualParseResult.getPathNames().length);
    assertTrue(actualParseResult.getElements().isEmpty());
  }

  /**
   * Test {@link Path#parse(String)} with {@code pathString}.
   * <ul>
   *   <li>When {@code U[9]}.</li>
   *   <li>Then return LastElement PathName is {@code U}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path Path.parse(String)"})
  public void testParseWithPathString_whenU9_thenReturnLastElementPathNameIsU() {
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
    assertArrayEquals(new String[]{"U"}, actualParseResult.getPathNames());
  }

  /**
   * Test {@link Path#equals(Object)}, and {@link Path#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Path#equals(Object)}
   *   <li>{@link Path#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.equals(Object)", "int Path.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Path path = ScopeReferenceHelper.EMPTY_SCOPE;
    Path path2 = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act and Assert
    assertEquals(path, path2);
    int expectedHashCodeResult = path.hashCode();
    assertEquals(expectedHashCodeResult, path2.hashCode());
  }

  /**
   * Test {@link Path#equals(Object)}, and {@link Path#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Path#equals(Object)}
   *   <li>{@link Path#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.equals(Object)", "int Path.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Path path = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act and Assert
    assertEquals(path, path);
    int expectedHashCodeResult = path.hashCode();
    assertEquals(expectedHashCodeResult, path.hashCode());
  }

  /**
   * Test {@link Path#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.equals(Object)", "int Path.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Path(), ScopeReferenceHelper.EMPTY_SCOPE);
  }

  /**
   * Test {@link Path#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.equals(Object)", "int Path.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ScopeReferenceHelper.EMPTY_SCOPE, null);
  }

  /**
   * Test {@link Path#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Path#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean Path.equals(Object)", "int Path.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ScopeReferenceHelper.EMPTY_SCOPE, "Different type to Path");
  }
}
