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
import static org.mockito.Mockito.mock;
import com.regnosys.rosetta.common.hashing.ScopeReferenceHelper;
import com.regnosys.rosetta.common.util.PathException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import org.junit.Test;

public class PathDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Path.PathElement#equals(Object)}
   *   <li>{@link Path.PathElement#hashCode()}
   * </ul>
   */
  @Test
  public void testPathElementEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Path.PathElement parseResult = Path.PathElement.parse("foo", true);
    Path.PathElement parseResult2 = Path.PathElement.parse("foo", true);

    // Act and Assert
    assertEquals(parseResult, parseResult2);
    int expectedHashCodeResult = parseResult.hashCode();
    assertEquals(expectedHashCodeResult, parseResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Path.PathElement#equals(Object)}
   *   <li>{@link Path.PathElement#hashCode()}
   * </ul>
   */
  @Test
  public void testPathElementEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Path.PathElement parseResult = Path.PathElement.parse("foo", true);

    // Act and Assert
    assertEquals(parseResult, parseResult);
    int expectedHashCodeResult = parseResult.hashCode();
    assertEquals(expectedHashCodeResult, parseResult.hashCode());
  }

  /**
   * Method under test: {@link Path.PathElement#equals(Object)}
   */
  @Test
  public void testPathElementEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Path.PathElement parseResult = Path.PathElement.parse("42", true);

    // Act and Assert
    assertNotEquals(parseResult, Path.PathElement.parse("foo", true));
  }

  /**
   * Method under test: {@link Path.PathElement#equals(Object)}
   */
  @Test
  public void testPathElementEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Path.PathElement pathElement = new Path.PathElement("foo", 1);

    // Act and Assert
    assertNotEquals(pathElement, Path.PathElement.parse("foo", true));
  }

  /**
   * Method under test: {@link Path.PathElement#equals(Object)}
   */
  @Test
  public void testPathElementEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Path.PathElement.parse("foo", true), null);
  }

  /**
   * Method under test: {@link Path.PathElement#equals(Object)}
   */
  @Test
  public void testPathElementEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(Path.PathElement.parse("foo", true), "Different type to PathElement");
  }

  /**
   * Method under test: {@link Path.PathElement#forceGetIndex()}
   */
  @Test
  public void testPathElementForceGetIndex() {
    // Arrange
    Path.PathElement parseResult = Path.PathElement.parse("foo", true);

    // Act and Assert
    assertEquals(0, parseResult.forceGetIndex());
    Optional<Integer> index = parseResult.getIndex();
    assertEquals(0, index.get().intValue());
    assertTrue(index.isPresent());
  }

  /**
   * Method under test: {@link Path.PathElement#forceGetIndex()}
   */
  @Test
  public void testPathElementForceGetIndex2() {
    // Arrange, Act and Assert
    assertEquals(1, (new Path.PathElement("Path Name", 1)).forceGetIndex());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Path.PathElement#toString()}
   *   <li>{@link Path.PathElement#getIndex()}
   *   <li>{@link Path.PathElement#getMetas()}
   *   <li>{@link Path.PathElement#getPathName()}
   * </ul>
   */
  @Test
  public void testPathElementGettersAndSetters() {
    // Arrange
    Path.PathElement parseResult = Path.PathElement.parse("foo", true);

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
   * Method under test: {@link Path.PathElement#PathElement(String)}
   */
  @Test
  public void testPathElementNewPathElement() {
    // Arrange and Act
    Path.PathElement actualPathElement = new Path.PathElement("Path Name");

    // Assert
    assertEquals("Path Name", actualPathElement.getPathName());
    assertFalse(actualPathElement.getIndex().isPresent());
    assertTrue(actualPathElement.getMetas().isEmpty());
  }

  /**
   * Method under test: {@link Path.PathElement#PathElement(String, int)}
   */
  @Test
  public void testPathElementNewPathElement2() {
    // Arrange and Act
    Path.PathElement actualPathElement = new Path.PathElement("Path Name", 1);

    // Assert
    assertEquals("Path Name", actualPathElement.getPathName());
    Optional<Integer> index = actualPathElement.getIndex();
    assertEquals(1, index.get().intValue());
    assertTrue(actualPathElement.getMetas().isEmpty());
    assertTrue(index.isPresent());
  }

  /**
   * Method under test: {@link Path.PathElement#PathElement(String, int, Map)}
   */
  @Test
  public void testPathElementNewPathElement3() {
    // Arrange
    HashMap<String, String> metas = new HashMap<>();

    // Act
    Path.PathElement actualPathElement = new Path.PathElement("Path Name", 1, metas);

    // Assert
    assertEquals("Path Name", actualPathElement.getPathName());
    Optional<Integer> index = actualPathElement.getIndex();
    assertEquals(1, index.get().intValue());
    Map<String, String> metas2 = actualPathElement.getMetas();
    assertTrue(metas2.isEmpty());
    assertTrue(index.isPresent());
    assertSame(metas, metas2);
  }

  /**
   * Method under test: {@link Path.PathElement#PathElement(String, int, Map)}
   */
  @Test
  public void testPathElementNewPathElement4() {
    // Arrange
    HashMap<String, String> metas = new HashMap<>();
    metas.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    Path.PathElement actualPathElement = new Path.PathElement("Path Name", 1, metas);

    // Assert
    assertEquals("Path Name", actualPathElement.getPathName());
    Optional<Integer> index = actualPathElement.getIndex();
    assertEquals(1, index.get().intValue());
    Map<String, String> metas2 = actualPathElement.getMetas();
    assertTrue(metas2.isEmpty());
    assertTrue(index.isPresent());
    assertSame(metas, metas2);
  }

  /**
   * Method under test: {@link Path.PathElement#PathElement(String, Map)}
   */
  @Test
  public void testPathElementNewPathElement5() {
    // Arrange
    HashMap<String, String> metas = new HashMap<>();

    // Act
    Path.PathElement actualPathElement = new Path.PathElement("Path Name", metas);

    // Assert
    assertEquals("Path Name", actualPathElement.getPathName());
    assertFalse(actualPathElement.getIndex().isPresent());
    Map<String, String> metas2 = actualPathElement.getMetas();
    assertTrue(metas2.isEmpty());
    assertSame(metas, metas2);
  }

  /**
   * Method under test: {@link Path.PathElement#PathElement(String, Map)}
   */
  @Test
  public void testPathElementNewPathElement6() {
    // Arrange
    HashMap<String, String> metas = new HashMap<>();
    metas.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    Path.PathElement actualPathElement = new Path.PathElement("Path Name", metas);

    // Assert
    assertEquals("Path Name", actualPathElement.getPathName());
    assertFalse(actualPathElement.getIndex().isPresent());
    Map<String, String> metas2 = actualPathElement.getMetas();
    assertTrue(metas2.isEmpty());
    assertSame(metas, metas2);
  }

  /**
   * Method under test:
   * {@link Path.PathElement#PathElement(String, Optional, Map)}
   */
  @Test
  public void testPathElementNewPathElement7() {
    // Arrange
    Optional<Integer> index = Optional.<Integer>of(1);
    HashMap<String, String> metas = new HashMap<>();

    // Act
    Path.PathElement actualPathElement = new Path.PathElement("Path Name", index, metas);

    // Assert
    assertEquals("Path Name", actualPathElement.getPathName());
    Map<String, String> metas2 = actualPathElement.getMetas();
    assertTrue(metas2.isEmpty());
    assertSame(metas, metas2);
    assertSame(index, actualPathElement.getIndex());
  }

  /**
   * Method under test:
   * {@link Path.PathElement#PathElement(String, Optional, Map)}
   */
  @Test
  public void testPathElementNewPathElement8() {
    // Arrange
    Optional<Integer> index = Optional.<Integer>of(1);

    HashMap<String, String> metas = new HashMap<>();
    metas.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    Path.PathElement actualPathElement = new Path.PathElement("Path Name", index, metas);

    // Assert
    assertEquals("Path Name", actualPathElement.getPathName());
    Map<String, String> metas2 = actualPathElement.getMetas();
    assertTrue(metas2.isEmpty());
    assertSame(metas, metas2);
    assertSame(index, actualPathElement.getIndex());
  }

  /**
   * Method under test: {@link Path.PathElement#parse(String)}
   */
  @Test
  public void testPathElementParse() {
    // Arrange and Act
    Path.PathElement actualParseResult = Path.PathElement.parse("foo");

    // Assert
    assertEquals("foo", actualParseResult.getPathName());
    assertFalse(actualParseResult.getIndex().isPresent());
    assertTrue(actualParseResult.getMetas().isEmpty());
  }

  /**
   * Method under test: {@link Path.PathElement#parse(String)}
   */
  @Test
  public void testPathElementParse2() {
    // Arrange and Act
    Path.PathElement actualParseResult = Path.PathElement.parse("U[9]");

    // Assert
    assertEquals("U", actualParseResult.getPathName());
    Optional<Integer> index = actualParseResult.getIndex();
    assertEquals(9, index.get().intValue());
    assertTrue(actualParseResult.getMetas().isEmpty());
    assertTrue(index.isPresent());
  }

  /**
   * Method under test: {@link Path.PathElement#parse(String)}
   */
  @Test
  public void testPathElementParse3() {
    // Arrange, Act and Assert
    assertThrows(PathException.class, () -> Path.PathElement.parse("([*]|\\w*)(\\[(\\d*)])?"));
  }

  /**
   * Method under test: {@link Path.PathElement#parse(String, boolean)}
   */
  @Test
  public void testPathElementParse4() {
    // Arrange and Act
    Path.PathElement actualParseResult = Path.PathElement.parse("foo", true);

    // Assert
    assertEquals("foo", actualParseResult.getPathName());
    assertFalse(actualParseResult.getIndex().isPresent());
    assertTrue(actualParseResult.getMetas().isEmpty());
  }

  /**
   * Method under test: {@link Path.PathElement#parse(String, boolean)}
   */
  @Test
  public void testPathElementParse5() {
    // Arrange and Act
    Path.PathElement actualParseResult = Path.PathElement.parse("foo", false);

    // Assert
    assertEquals("foo", actualParseResult.getPathName());
    assertFalse(actualParseResult.getIndex().isPresent());
    assertTrue(actualParseResult.getMetas().isEmpty());
  }

  /**
   * Method under test: {@link Path.PathElement#parse(String, boolean)}
   */
  @Test
  public void testPathElementParse6() {
    // Arrange and Act
    Path.PathElement actualParseResult = Path.PathElement.parse("*[9]", true);

    // Assert
    assertEquals("*", actualParseResult.getPathName());
    Optional<Integer> index = actualParseResult.getIndex();
    assertEquals(9, index.get().intValue());
    assertTrue(actualParseResult.getMetas().isEmpty());
    assertTrue(index.isPresent());
  }

  /**
   * Method under test: {@link Path.PathElement#parse(String, boolean)}
   */
  @Test
  public void testPathElementParse7() {
    // Arrange, Act and Assert
    assertThrows(PathException.class, () -> Path.PathElement.parse("([*]|\\w*)(\\[(\\d*)])?", true));
  }

  /**
   * Method under test: {@link Path#valueOf(String)}
   */
  @Test
  public void testValueOf() {
    // Arrange and Act
    Path actualValueOfResult = Path.valueOf("Path");

    // Assert
    Path.PathElement lastElement = actualValueOfResult.getLastElement();
    assertEquals("Path", lastElement.getPathName());
    Path parent = actualValueOfResult.getParent();
    assertNull(parent.getLastElement());
    assertEquals(0, parent.getPathNames().length);
    List<Path.PathElement> elements = actualValueOfResult.getElements();
    assertEquals(1, elements.size());
    assertFalse(lastElement.getIndex().isPresent());
    assertTrue(parent.getElements().isEmpty());
    assertTrue(lastElement.getMetas().isEmpty());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[]{"Path"}, actualValueOfResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#valueOf(List)}
   */
  @Test
  public void testValueOf2() {
    // Arrange and Act
    Path actualValueOfResult = Path.valueOf(new ArrayList<>());

    // Assert
    assertNull(actualValueOfResult.getLastElement());
    assertEquals(0, actualValueOfResult.getPathNames().length);
    assertTrue(actualValueOfResult.getElements().isEmpty());
  }

  /**
   * Method under test: {@link Path#valueOf(List)}
   */
  @Test
  public void testValueOf3() {
    // Arrange
    ArrayList<String> path = new ArrayList<>();
    path.add("foo");

    // Act
    Path actualValueOfResult = Path.valueOf(path);

    // Assert
    Path.PathElement lastElement = actualValueOfResult.getLastElement();
    assertEquals("foo", lastElement.getPathName());
    Path parent = actualValueOfResult.getParent();
    assertNull(parent.getLastElement());
    assertEquals(0, parent.getPathNames().length);
    List<Path.PathElement> elements = actualValueOfResult.getElements();
    assertEquals(1, elements.size());
    assertFalse(lastElement.getIndex().isPresent());
    assertTrue(parent.getElements().isEmpty());
    assertTrue(lastElement.getMetas().isEmpty());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[]{"foo"}, actualValueOfResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#valueOf(List)}
   */
  @Test
  public void testValueOf4() {
    // Arrange
    ArrayList<String> path = new ArrayList<>();
    path.add("42");
    path.add("foo");

    // Act
    Path actualValueOfResult = Path.valueOf(path);

    // Assert
    List<Path.PathElement> elements = actualValueOfResult.getElements();
    assertEquals(2, elements.size());
    Path.PathElement getResult = elements.get(0);
    assertEquals("42", getResult.getPathName());
    Path.PathElement lastElement = actualValueOfResult.getLastElement();
    assertEquals("foo", lastElement.getPathName());
    Path parent = actualValueOfResult.getParent();
    Path parent2 = parent.getParent();
    assertNull(parent2.getLastElement());
    assertEquals(0, parent2.getPathNames().length);
    List<Path.PathElement> elements2 = parent.getElements();
    assertEquals(1, elements2.size());
    Optional<Integer> index = lastElement.getIndex();
    assertFalse(index.isPresent());
    assertTrue(parent2.getElements().isEmpty());
    Map<String, String> metas = lastElement.getMetas();
    assertTrue(metas.isEmpty());
    assertSame(lastElement, elements.get(1));
    assertSame(index, getResult.getIndex());
    assertSame(metas, getResult.getMetas());
    assertSame(getResult, parent.getLastElement());
    assertSame(getResult, elements2.get(0));
    assertArrayEquals(new String[]{"42"}, parent.getPathNames());
    assertArrayEquals(new String[]{"42", "foo"}, actualValueOfResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#addElement(Path.PathElement)}
   */
  @Test
  public void testAddElement() {
    // Arrange
    Path path = ScopeReferenceHelper.EMPTY_SCOPE;
    Path.PathElement element = Path.PathElement.parse("foo", true);

    // Act
    Path actualAddElementResult = path.addElement(element);

    // Assert
    List<Path.PathElement> elements = actualAddElementResult.getElements();
    assertEquals(2, elements.size());
    assertEquals("emptyScope", elements.get(0).getPathName());
    assertEquals(path, actualAddElementResult.getParent());
    assertSame(element, actualAddElementResult.getLastElement());
    assertSame(element, elements.get(1));
    assertArrayEquals(new String[]{"emptyScope", "foo"}, actualAddElementResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#addElement(Path.PathElement)}
   */
  @Test
  public void testAddElement2() {
    // Arrange
    Path path = new Path();
    Path.PathElement element = Path.PathElement.parse("foo", true);

    // Act
    Path actualAddElementResult = path.addElement(element);

    // Assert
    List<Path.PathElement> elements = actualAddElementResult.getElements();
    assertEquals(1, elements.size());
    assertEquals(path, actualAddElementResult.getParent());
    assertSame(element, actualAddElementResult.getLastElement());
    assertSame(element, elements.get(0));
    assertArrayEquals(new String[]{"foo"}, actualAddElementResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#addElement(String)}
   */
  @Test
  public void testAddElement3() {
    // Arrange
    Path path = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act
    Path actualAddElementResult = path.addElement("Name");

    // Assert
    Path.PathElement lastElement = actualAddElementResult.getLastElement();
    assertEquals("Name", lastElement.getPathName());
    List<Path.PathElement> elements = actualAddElementResult.getElements();
    assertEquals(2, elements.size());
    Path.PathElement getResult = elements.get(0);
    assertEquals("emptyScope", getResult.getPathName());
    Optional<Integer> index = lastElement.getIndex();
    assertFalse(index.isPresent());
    Map<String, String> metas = lastElement.getMetas();
    assertTrue(metas.isEmpty());
    assertEquals(path, actualAddElementResult.getParent());
    assertSame(lastElement, elements.get(1));
    assertSame(index, getResult.getIndex());
    assertSame(metas, getResult.getMetas());
    assertArrayEquals(new String[]{"emptyScope", "Name"}, actualAddElementResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#addElement(String)}
   */
  @Test
  public void testAddElement4() {
    // Arrange
    Path path = new Path();

    // Act
    Path actualAddElementResult = path.addElement("Name");

    // Assert
    Path.PathElement lastElement = actualAddElementResult.getLastElement();
    assertEquals("Name", lastElement.getPathName());
    List<Path.PathElement> elements = actualAddElementResult.getElements();
    assertEquals(1, elements.size());
    assertFalse(lastElement.getIndex().isPresent());
    assertTrue(lastElement.getMetas().isEmpty());
    assertEquals(path, actualAddElementResult.getParent());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[]{"Name"}, actualAddElementResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#addElement(String, Integer)}
   */
  @Test
  public void testAddElement5() {
    // Arrange
    Path path = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act
    Path actualAddElementResult = path.addElement("Name", 1);

    // Assert
    Path.PathElement lastElement = actualAddElementResult.getLastElement();
    assertEquals("Name", lastElement.getPathName());
    List<Path.PathElement> elements = actualAddElementResult.getElements();
    assertEquals(2, elements.size());
    Path.PathElement getResult = elements.get(0);
    assertEquals("emptyScope", getResult.getPathName());
    Optional<Integer> index = lastElement.getIndex();
    assertEquals(1, index.get().intValue());
    assertFalse(getResult.getIndex().isPresent());
    Map<String, String> metas = lastElement.getMetas();
    assertTrue(metas.isEmpty());
    assertTrue(index.isPresent());
    assertEquals(path, actualAddElementResult.getParent());
    assertSame(lastElement, elements.get(1));
    assertSame(metas, getResult.getMetas());
    assertArrayEquals(new String[]{"emptyScope", "Name"}, actualAddElementResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#addElement(String, Integer)}
   */
  @Test
  public void testAddElement6() {
    // Arrange
    Path path = new Path();

    // Act
    Path actualAddElementResult = path.addElement("Name", 1);

    // Assert
    Path.PathElement lastElement = actualAddElementResult.getLastElement();
    assertEquals("Name", lastElement.getPathName());
    Optional<Integer> index = lastElement.getIndex();
    assertEquals(1, index.get().intValue());
    List<Path.PathElement> elements = actualAddElementResult.getElements();
    assertEquals(1, elements.size());
    assertTrue(lastElement.getMetas().isEmpty());
    assertTrue(index.isPresent());
    assertEquals(path, actualAddElementResult.getParent());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[]{"Name"}, actualAddElementResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#getPathNames()}
   */
  @Test
  public void testGetPathNames() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"emptyScope"}, ScopeReferenceHelper.EMPTY_SCOPE.getPathNames());
  }

  /**
   * Method under test: {@link Path#getParent()}
   */
  @Test
  public void testGetParent() {
    // Arrange and Act
    Path actualParent = ScopeReferenceHelper.EMPTY_SCOPE.getParent();

    // Assert
    assertNull(actualParent.getLastElement());
    assertEquals(0, actualParent.getPathNames().length);
    assertTrue(actualParent.getElements().isEmpty());
  }

  /**
   * Method under test: {@link Path#getLastElement()}
   */
  @Test
  public void testGetLastElement() {
    // Arrange and Act
    Path.PathElement actualLastElement = ScopeReferenceHelper.EMPTY_SCOPE.getLastElement();

    // Assert
    assertEquals("emptyScope", actualLastElement.getPathName());
    assertFalse(actualLastElement.getIndex().isPresent());
    assertTrue(actualLastElement.getMetas().isEmpty());
  }

  /**
   * Method under test: {@link Path#getLastElement()}
   */
  @Test
  public void testGetLastElement2() {
    // Arrange, Act and Assert
    assertNull((new Path()).getLastElement());
  }

  /**
   * Method under test: {@link Path#append(Path)}
   */
  @Test
  public void testAppend() {
    // Arrange
    Path append = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act
    Path actualAppendResult = ScopeReferenceHelper.EMPTY_SCOPE.append(append);

    // Assert
    Path.PathElement lastElement = actualAppendResult.getLastElement();
    assertEquals("emptyScope", lastElement.getPathName());
    List<Path.PathElement> elements = actualAppendResult.getElements();
    assertEquals(2, elements.size());
    assertFalse(lastElement.getIndex().isPresent());
    assertTrue(lastElement.getMetas().isEmpty());
    assertEquals(append, actualAppendResult.getParent());
    assertSame(lastElement, elements.get(0));
    assertSame(lastElement, elements.get(1));
    assertArrayEquals(new String[]{"emptyScope", "emptyScope"}, actualAppendResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#append(Path)}
   */
  @Test
  public void testAppend2() {
    // Arrange
    Path append = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act and Assert
    assertEquals(append, (new Path()).append(append));
  }

  /**
   * Method under test: {@link Path#append(Path)}
   */
  @Test
  public void testAppend3() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertEquals(path, path.append(new Path()));
  }

  /**
   * Method under test: {@link Path#append(Path)}
   */
  @Test
  public void testAppend4() {
    // Arrange
    Path parseResult = Path.parse("com.regnosys.rosetta.common.translation.Path", true);

    // Act
    Path actualAppendResult = parseResult.append(ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    List<Path.PathElement> elements = actualAppendResult.getElements();
    assertEquals(7, elements.size());
    Path.PathElement getResult = elements.get(5);
    assertEquals("Path", getResult.getPathName());
    Path.PathElement getResult2 = elements.get(0);
    assertEquals("com", getResult2.getPathName());
    Path.PathElement lastElement = actualAppendResult.getLastElement();
    assertEquals("emptyScope", lastElement.getPathName());
    Path.PathElement getResult3 = elements.get(1);
    assertEquals("regnosys", getResult3.getPathName());
    Path.PathElement getResult4 = elements.get(2);
    assertEquals("rosetta", getResult4.getPathName());
    Path.PathElement getResult5 = elements.get(4);
    assertEquals("translation", getResult5.getPathName());
    Optional<Integer> index = lastElement.getIndex();
    assertFalse(index.isPresent());
    Map<String, String> metas = lastElement.getMetas();
    assertTrue(metas.isEmpty());
    assertEquals(parseResult, actualAppendResult.getParent());
    assertSame(lastElement, elements.get(6));
    assertSame(index, getResult2.getIndex());
    assertSame(index, getResult3.getIndex());
    assertSame(index, getResult4.getIndex());
    assertSame(index, getResult5.getIndex());
    assertSame(index, getResult.getIndex());
    assertSame(metas, getResult2.getMetas());
    assertSame(metas, getResult3.getMetas());
    assertSame(metas, getResult4.getMetas());
    assertSame(metas, getResult5.getMetas());
    assertSame(metas, getResult.getMetas());
    assertArrayEquals(new String[]{"com", "regnosys", "rosetta", "common", "translation", "Path", "emptyScope"},
        actualAppendResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#append(Path)}
   */
  @Test
  public void testAppend5() {
    // Arrange
    Path append = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act and Assert
    assertEquals(append, Path.parse("", true).append(append));
  }

  /**
   * Method under test: {@link Path#prefixWithWildcard()}
   */
  @Test
  public void testPrefixWithWildcard() {
    // Arrange and Act
    Path actualPrefixWithWildcardResult = ScopeReferenceHelper.EMPTY_SCOPE.prefixWithWildcard();

    // Assert
    List<Path.PathElement> elements = actualPrefixWithWildcardResult.getElements();
    assertEquals(2, elements.size());
    Path.PathElement getResult = elements.get(0);
    assertEquals("*", getResult.getPathName());
    Path.PathElement lastElement = actualPrefixWithWildcardResult.getLastElement();
    assertEquals("emptyScope", lastElement.getPathName());
    Path parent = actualPrefixWithWildcardResult.getParent();
    Path parent2 = parent.getParent();
    assertNull(parent2.getLastElement());
    assertEquals(0, parent2.getPathNames().length);
    List<Path.PathElement> elements2 = parent.getElements();
    assertEquals(1, elements2.size());
    Optional<Integer> index = lastElement.getIndex();
    assertFalse(index.isPresent());
    assertTrue(parent2.getElements().isEmpty());
    Map<String, String> metas = lastElement.getMetas();
    assertTrue(metas.isEmpty());
    assertSame(lastElement, elements.get(1));
    assertSame(index, getResult.getIndex());
    assertSame(metas, getResult.getMetas());
    assertSame(getResult, parent.getLastElement());
    assertSame(getResult, elements2.get(0));
    assertArrayEquals(new String[]{"*"}, parent.getPathNames());
    assertArrayEquals(new String[]{"*", "emptyScope"}, actualPrefixWithWildcardResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#prefixWithWildcard()}
   */
  @Test
  public void testPrefixWithWildcard2() {
    // Arrange
    Path path = new Path();

    // Act
    Path actualPrefixWithWildcardResult = path.prefixWithWildcard();

    // Assert
    Path.PathElement lastElement = actualPrefixWithWildcardResult.getLastElement();
    assertEquals("*", lastElement.getPathName());
    List<Path.PathElement> elements = actualPrefixWithWildcardResult.getElements();
    assertEquals(1, elements.size());
    assertFalse(lastElement.getIndex().isPresent());
    assertTrue(lastElement.getMetas().isEmpty());
    assertEquals(path, actualPrefixWithWildcardResult.getParent());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[]{"*"}, actualPrefixWithWildcardResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#prefixWithWildcard()}
   */
  @Test
  public void testPrefixWithWildcard3() {
    // Arrange and Act
    Path actualPrefixWithWildcardResult = Path.parse("com.regnosys.rosetta.common.translation.Path", true)
        .prefixWithWildcard();

    // Assert
    List<Path.PathElement> elements = actualPrefixWithWildcardResult.getElements();
    assertEquals(7, elements.size());
    Path.PathElement getResult = elements.get(0);
    assertEquals("*", getResult.getPathName());
    Path.PathElement lastElement = actualPrefixWithWildcardResult.getLastElement();
    assertEquals("Path", lastElement.getPathName());
    Path.PathElement getResult2 = elements.get(1);
    assertEquals("com", getResult2.getPathName());
    Path.PathElement getResult3 = elements.get(4);
    assertEquals("common", getResult3.getPathName());
    Path.PathElement getResult4 = elements.get(2);
    assertEquals("regnosys", getResult4.getPathName());
    Path parent = actualPrefixWithWildcardResult.getParent();
    Path parent2 = parent.getParent();
    List<Path.PathElement> elements2 = parent2.getElements();
    assertEquals(5, elements2.size());
    Path.PathElement getResult5 = elements2.get(3);
    assertEquals("rosetta", getResult5.getPathName());
    Path.PathElement getResult6 = elements.get(5);
    assertEquals("translation", getResult6.getPathName());
    Path parent3 = parent2.getParent();
    Path parent4 = parent3.getParent();
    Path parent5 = parent4.getParent();
    Path parent6 = parent5.getParent();
    Path parent7 = parent6.getParent();
    assertNull(parent7.getLastElement());
    assertEquals(0, parent7.getPathNames().length);
    List<Path.PathElement> elements3 = parent6.getElements();
    assertEquals(1, elements3.size());
    List<Path.PathElement> elements4 = parent5.getElements();
    assertEquals(2, elements4.size());
    List<Path.PathElement> elements5 = parent4.getElements();
    assertEquals(3, elements5.size());
    List<Path.PathElement> elements6 = parent3.getElements();
    assertEquals(4, elements6.size());
    List<Path.PathElement> elements7 = parent.getElements();
    assertEquals(6, elements7.size());
    Optional<Integer> index = lastElement.getIndex();
    assertFalse(index.isPresent());
    assertTrue(parent7.getElements().isEmpty());
    Map<String, String> metas = lastElement.getMetas();
    assertTrue(metas.isEmpty());
    assertSame(lastElement, elements.get(6));
    assertSame(index, getResult5.getIndex());
    assertSame(index, getResult.getIndex());
    assertSame(index, getResult2.getIndex());
    assertSame(index, getResult4.getIndex());
    assertSame(index, getResult3.getIndex());
    assertSame(index, getResult6.getIndex());
    assertSame(metas, getResult5.getMetas());
    assertSame(metas, getResult.getMetas());
    assertSame(metas, getResult2.getMetas());
    assertSame(metas, getResult4.getMetas());
    assertSame(metas, getResult3.getMetas());
    assertSame(metas, getResult6.getMetas());
    assertSame(getResult, parent6.getLastElement());
    assertSame(getResult, elements3.get(0));
    assertSame(getResult, elements4.get(0));
    assertSame(getResult, elements5.get(0));
    assertSame(getResult, elements6.get(0));
    assertSame(getResult, elements2.get(0));
    assertSame(getResult, elements7.get(0));
    assertSame(getResult2, parent5.getLastElement());
    assertSame(getResult2, elements4.get(1));
    assertSame(getResult2, elements5.get(1));
    assertSame(getResult2, elements6.get(1));
    assertSame(getResult2, elements2.get(1));
    assertSame(getResult2, elements7.get(1));
    assertSame(getResult4, parent4.getLastElement());
    assertSame(getResult4, elements5.get(2));
    assertSame(getResult4, elements6.get(2));
    assertSame(getResult3, parent2.getLastElement());
    assertSame(getResult3, elements2.get(4));
    assertSame(getResult3, elements7.get(4));
    assertSame(getResult6, parent.getLastElement());
    assertSame(getResult6, elements7.get(5));
    assertArrayEquals(new String[]{"*"}, parent6.getPathNames());
    assertArrayEquals(new String[]{"*", "com"}, parent5.getPathNames());
    assertArrayEquals(new String[]{"*", "com", "regnosys"}, parent4.getPathNames());
    assertArrayEquals(new String[]{"*", "com", "regnosys", "rosetta"}, parent3.getPathNames());
    assertArrayEquals(new String[]{"*", "com", "regnosys", "rosetta", "common"}, parent2.getPathNames());
    assertArrayEquals(new String[]{"*", "com", "regnosys", "rosetta", "common", "translation"}, parent.getPathNames());
    assertArrayEquals(new String[]{"*", "com", "regnosys", "rosetta", "common", "translation", "Path"},
        actualPrefixWithWildcardResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#prefixWithWildcard()}
   */
  @Test
  public void testPrefixWithWildcard4() {
    // Arrange
    Path parseResult = Path.parse("", true);

    // Act
    Path actualPrefixWithWildcardResult = parseResult.prefixWithWildcard();

    // Assert
    Path.PathElement lastElement = actualPrefixWithWildcardResult.getLastElement();
    assertEquals("*", lastElement.getPathName());
    List<Path.PathElement> elements = actualPrefixWithWildcardResult.getElements();
    assertEquals(1, elements.size());
    assertFalse(lastElement.getIndex().isPresent());
    assertTrue(lastElement.getMetas().isEmpty());
    assertEquals(parseResult, actualPrefixWithWildcardResult.getParent());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[]{"*"}, actualPrefixWithWildcardResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#trimFirst()}
   */
  @Test
  public void testTrimFirst() {
    // Arrange and Act
    Path actualTrimFirstResult = ScopeReferenceHelper.EMPTY_SCOPE.trimFirst();

    // Assert
    assertNull(actualTrimFirstResult.getLastElement());
    assertEquals(0, actualTrimFirstResult.getPathNames().length);
    assertTrue(actualTrimFirstResult.getElements().isEmpty());
  }

  /**
   * Method under test: {@link Path#nameStartMatches(Path)}
   */
  @Test
  public void testNameStartMatches() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE));
    assertFalse((new Path()).nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE));
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.nameStartMatches(new Path()));
    assertFalse(Path.valueOf("Path").nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE));
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
    assertFalse((new Path()).nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.nameStartMatches(new Path(), true));
    assertFalse(Path.valueOf("Path").nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
    assertFalse(Path.valueOf("Path").nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, false));
    assertTrue(Path.valueOf("*").nameStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.nameStartMatches(Path.valueOf("*"), true));
  }

  /**
   * Method under test: {@link Path#nameStartMatches(Path)}
   */
  @Test
  public void testNameStartMatches2() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertTrue(path.nameStartMatches(new Path()));
  }

  /**
   * Method under test: {@link Path#nameStartMatches(Path, boolean)}
   */
  @Test
  public void testNameStartMatches3() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertTrue(path.nameStartMatches(new Path(), true));
  }

  /**
   * Method under test: {@link Path#fullStartMatches(Path)}
   */
  @Test
  public void testFullStartMatches() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE));
    assertFalse((new Path()).fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE));
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(new Path()));
    assertFalse(Path.valueOf("Path").fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE));
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
    assertFalse((new Path()).fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
    assertTrue(Path.valueOf("*").fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(new Path(), true));
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(Path.valueOf("*"), true));
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, false));
    assertFalse(Path.valueOf("Path").fullStartMatches(ScopeReferenceHelper.EMPTY_SCOPE, true));
  }

  /**
   * Method under test: {@link Path#fullStartMatches(Path)}
   */
  @Test
  public void testFullStartMatches2() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertTrue(path.fullStartMatches(new Path()));
  }

  /**
   * Method under test: {@link Path#fullStartMatches(Path, boolean)}
   */
  @Test
  public void testFullStartMatches3() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertTrue(path.fullStartMatches(new Path(), true));
  }

  /**
   * Method under test: {@link Path#nameIndexMatches(Path)}
   */
  @Test
  public void testNameIndexMatches() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.nameIndexMatches(ScopeReferenceHelper.EMPTY_SCOPE));
    assertFalse((new Path()).nameIndexMatches(ScopeReferenceHelper.EMPTY_SCOPE));
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.nameIndexMatches(new Path()));
    assertFalse(Path.valueOf("Path").nameIndexMatches(ScopeReferenceHelper.EMPTY_SCOPE));
  }

  /**
   * Method under test: {@link Path#nameIndexMatches(Path)}
   */
  @Test
  public void testNameIndexMatches2() {
    // Arrange
    Path path = new Path();

    // Act and Assert
    assertTrue(path.nameIndexMatches(new Path()));
  }

  /**
   * Method under test: {@link Path#endsWith(Path)}
   */
  @Test
  public void testEndsWith() {
    // Arrange, Act and Assert
    assertTrue(ScopeReferenceHelper.EMPTY_SCOPE.endsWith(ScopeReferenceHelper.EMPTY_SCOPE));
    assertFalse((new Path()).endsWith(ScopeReferenceHelper.EMPTY_SCOPE));
    assertFalse(Path.valueOf("Path").endsWith(ScopeReferenceHelper.EMPTY_SCOPE));
    assertTrue(Path.valueOf("emptyScope").endsWith(ScopeReferenceHelper.EMPTY_SCOPE));
    assertFalse(ScopeReferenceHelper.EMPTY_SCOPE.endsWith("Path"));
    assertFalse((new Path()).endsWith("Path"));
    assertTrue(Path.valueOf("Path").endsWith("Path"));
  }

  /**
   * Method under test: {@link Path#cardinality()}
   */
  @Test
  public void testCardinality() {
    // Arrange, Act and Assert
    assertEquals(0, ScopeReferenceHelper.EMPTY_SCOPE.cardinality());
    assertEquals(0, (new Path()).cardinality());
  }

  /**
   * Method under test: {@link Path#parse(String)}
   */
  @Test
  public void testParse() {
    // Arrange and Act
    Path actualParseResult = Path.parse("U[9]");

    // Assert
    Path.PathElement lastElement = actualParseResult.getLastElement();
    assertEquals("U", lastElement.getPathName());
    Path parent = actualParseResult.getParent();
    assertNull(parent.getLastElement());
    assertEquals(0, parent.getPathNames().length);
    List<Path.PathElement> elements = actualParseResult.getElements();
    assertEquals(1, elements.size());
    Optional<Integer> index = lastElement.getIndex();
    assertEquals(9, index.get().intValue());
    assertTrue(parent.getElements().isEmpty());
    assertTrue(lastElement.getMetas().isEmpty());
    assertTrue(index.isPresent());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[]{"U"}, actualParseResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#parse(String)}
   */
  @Test
  public void testParse2() {
    // Arrange and Act
    Path actualParseResult = Path.parse("42");

    // Assert
    Path.PathElement lastElement = actualParseResult.getLastElement();
    assertEquals("42", lastElement.getPathName());
    Path parent = actualParseResult.getParent();
    assertNull(parent.getLastElement());
    assertEquals(0, parent.getPathNames().length);
    List<Path.PathElement> elements = actualParseResult.getElements();
    assertEquals(1, elements.size());
    assertFalse(lastElement.getIndex().isPresent());
    assertTrue(parent.getElements().isEmpty());
    assertTrue(lastElement.getMetas().isEmpty());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[]{"42"}, actualParseResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#parse(String)}
   */
  @Test
  public void testParse3() {
    // Arrange and Act
    Path actualParseResult = Path.parse("com.regnosys.rosetta.common.translation.Path");

    // Assert
    Path.PathElement lastElement = actualParseResult.getLastElement();
    assertEquals("Path", lastElement.getPathName());
    List<Path.PathElement> elements = actualParseResult.getElements();
    assertEquals(6, elements.size());
    Path.PathElement getResult = elements.get(0);
    assertEquals("com", getResult.getPathName());
    Path.PathElement getResult2 = elements.get(3);
    assertEquals("common", getResult2.getPathName());
    Path.PathElement getResult3 = elements.get(1);
    assertEquals("regnosys", getResult3.getPathName());
    Path.PathElement getResult4 = elements.get(2);
    assertEquals("rosetta", getResult4.getPathName());
    Path.PathElement getResult5 = elements.get(4);
    assertEquals("translation", getResult5.getPathName());
    Path parent = actualParseResult.getParent();
    Path parent2 = parent.getParent();
    Path parent3 = parent2.getParent();
    Path parent4 = parent3.getParent();
    Path parent5 = parent4.getParent();
    Path parent6 = parent5.getParent();
    assertNull(parent6.getLastElement());
    assertEquals(0, parent6.getPathNames().length);
    List<Path.PathElement> elements2 = parent5.getElements();
    assertEquals(1, elements2.size());
    List<Path.PathElement> elements3 = parent4.getElements();
    assertEquals(2, elements3.size());
    List<Path.PathElement> elements4 = parent3.getElements();
    assertEquals(3, elements4.size());
    List<Path.PathElement> elements5 = parent2.getElements();
    assertEquals(4, elements5.size());
    List<Path.PathElement> elements6 = parent.getElements();
    assertEquals(5, elements6.size());
    Optional<Integer> index = lastElement.getIndex();
    assertFalse(index.isPresent());
    assertTrue(parent6.getElements().isEmpty());
    Map<String, String> metas = lastElement.getMetas();
    assertTrue(metas.isEmpty());
    assertSame(lastElement, elements.get(5));
    assertSame(index, getResult.getIndex());
    assertSame(index, getResult3.getIndex());
    assertSame(index, getResult4.getIndex());
    assertSame(index, getResult2.getIndex());
    assertSame(index, getResult5.getIndex());
    assertSame(metas, getResult.getMetas());
    assertSame(metas, getResult3.getMetas());
    assertSame(metas, getResult4.getMetas());
    assertSame(metas, getResult2.getMetas());
    assertSame(metas, getResult5.getMetas());
    assertSame(getResult, parent5.getLastElement());
    assertSame(getResult, elements2.get(0));
    assertSame(getResult, elements3.get(0));
    assertSame(getResult, elements4.get(0));
    assertSame(getResult, elements5.get(0));
    assertSame(getResult, elements6.get(0));
    assertSame(getResult3, parent4.getLastElement());
    assertSame(getResult3, elements3.get(1));
    assertSame(getResult3, elements4.get(1));
    assertSame(getResult3, elements5.get(1));
    assertSame(getResult3, elements6.get(1));
    assertSame(getResult4, parent3.getLastElement());
    assertSame(getResult4, elements4.get(2));
    assertSame(getResult4, elements5.get(2));
    assertSame(getResult2, parent2.getLastElement());
    assertSame(getResult2, elements5.get(3));
    assertSame(getResult2, elements6.get(3));
    assertSame(getResult5, parent.getLastElement());
    assertSame(getResult5, elements6.get(4));
    assertArrayEquals(new String[]{"com"}, parent5.getPathNames());
    assertArrayEquals(new String[]{"com", "regnosys"}, parent4.getPathNames());
    assertArrayEquals(new String[]{"com", "regnosys", "rosetta"}, parent3.getPathNames());
    assertArrayEquals(new String[]{"com", "regnosys", "rosetta", "common"}, parent2.getPathNames());
    assertArrayEquals(new String[]{"com", "regnosys", "rosetta", "common", "translation"}, parent.getPathNames());
    assertArrayEquals(new String[]{"com", "regnosys", "rosetta", "common", "translation", "Path"},
        actualParseResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#parse(String)}
   */
  @Test
  public void testParse4() {
    // Arrange and Act
    Path actualParseResult = Path.parse("");

    // Assert
    assertNull(actualParseResult.getLastElement());
    assertEquals(0, actualParseResult.getPathNames().length);
    assertTrue(actualParseResult.getElements().isEmpty());
  }

  /**
   * Method under test: {@link Path#parse(String, boolean)}
   */
  @Test
  public void testParse5() {
    // Arrange and Act
    Path actualParseResult = Path.parse("*[9]", true);

    // Assert
    Path.PathElement lastElement = actualParseResult.getLastElement();
    assertEquals("*", lastElement.getPathName());
    Path parent = actualParseResult.getParent();
    assertNull(parent.getLastElement());
    assertEquals(0, parent.getPathNames().length);
    List<Path.PathElement> elements = actualParseResult.getElements();
    assertEquals(1, elements.size());
    Optional<Integer> index = lastElement.getIndex();
    assertEquals(9, index.get().intValue());
    assertTrue(parent.getElements().isEmpty());
    assertTrue(lastElement.getMetas().isEmpty());
    assertTrue(index.isPresent());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[]{"*"}, actualParseResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#parse(String, boolean)}
   */
  @Test
  public void testParse6() {
    // Arrange and Act
    Path actualParseResult = Path.parse("*", true);

    // Assert
    Path.PathElement lastElement = actualParseResult.getLastElement();
    assertEquals("*", lastElement.getPathName());
    Path parent = actualParseResult.getParent();
    assertNull(parent.getLastElement());
    assertEquals(0, parent.getPathNames().length);
    List<Path.PathElement> elements = actualParseResult.getElements();
    assertEquals(1, elements.size());
    assertFalse(lastElement.getIndex().isPresent());
    assertTrue(parent.getElements().isEmpty());
    assertTrue(lastElement.getMetas().isEmpty());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[]{"*"}, actualParseResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#parse(String, boolean)}
   */
  @Test
  public void testParse7() {
    // Arrange and Act
    Path actualParseResult = Path.parse("com.regnosys.rosetta.common.translation.Path", true);

    // Assert
    Path.PathElement lastElement = actualParseResult.getLastElement();
    assertEquals("Path", lastElement.getPathName());
    List<Path.PathElement> elements = actualParseResult.getElements();
    assertEquals(6, elements.size());
    Path.PathElement getResult = elements.get(0);
    assertEquals("com", getResult.getPathName());
    Path.PathElement getResult2 = elements.get(3);
    assertEquals("common", getResult2.getPathName());
    Path.PathElement getResult3 = elements.get(1);
    assertEquals("regnosys", getResult3.getPathName());
    Path.PathElement getResult4 = elements.get(2);
    assertEquals("rosetta", getResult4.getPathName());
    Path.PathElement getResult5 = elements.get(4);
    assertEquals("translation", getResult5.getPathName());
    Path parent = actualParseResult.getParent();
    Path parent2 = parent.getParent();
    Path parent3 = parent2.getParent();
    Path parent4 = parent3.getParent();
    Path parent5 = parent4.getParent();
    Path parent6 = parent5.getParent();
    assertNull(parent6.getLastElement());
    assertEquals(0, parent6.getPathNames().length);
    List<Path.PathElement> elements2 = parent5.getElements();
    assertEquals(1, elements2.size());
    List<Path.PathElement> elements3 = parent4.getElements();
    assertEquals(2, elements3.size());
    List<Path.PathElement> elements4 = parent3.getElements();
    assertEquals(3, elements4.size());
    List<Path.PathElement> elements5 = parent2.getElements();
    assertEquals(4, elements5.size());
    List<Path.PathElement> elements6 = parent.getElements();
    assertEquals(5, elements6.size());
    Optional<Integer> index = lastElement.getIndex();
    assertFalse(index.isPresent());
    assertTrue(parent6.getElements().isEmpty());
    Map<String, String> metas = lastElement.getMetas();
    assertTrue(metas.isEmpty());
    assertSame(lastElement, elements.get(5));
    assertSame(index, getResult.getIndex());
    assertSame(index, getResult3.getIndex());
    assertSame(index, getResult4.getIndex());
    assertSame(index, getResult2.getIndex());
    assertSame(index, getResult5.getIndex());
    assertSame(metas, getResult.getMetas());
    assertSame(metas, getResult3.getMetas());
    assertSame(metas, getResult4.getMetas());
    assertSame(metas, getResult2.getMetas());
    assertSame(metas, getResult5.getMetas());
    assertSame(getResult, parent5.getLastElement());
    assertSame(getResult, elements2.get(0));
    assertSame(getResult, elements3.get(0));
    assertSame(getResult, elements4.get(0));
    assertSame(getResult, elements5.get(0));
    assertSame(getResult, elements6.get(0));
    assertSame(getResult3, parent4.getLastElement());
    assertSame(getResult3, elements3.get(1));
    assertSame(getResult3, elements4.get(1));
    assertSame(getResult3, elements5.get(1));
    assertSame(getResult3, elements6.get(1));
    assertSame(getResult4, parent3.getLastElement());
    assertSame(getResult4, elements4.get(2));
    assertSame(getResult4, elements5.get(2));
    assertSame(getResult2, parent2.getLastElement());
    assertSame(getResult2, elements5.get(3));
    assertSame(getResult2, elements6.get(3));
    assertSame(getResult5, parent.getLastElement());
    assertSame(getResult5, elements6.get(4));
    assertArrayEquals(new String[]{"com"}, parent5.getPathNames());
    assertArrayEquals(new String[]{"com", "regnosys"}, parent4.getPathNames());
    assertArrayEquals(new String[]{"com", "regnosys", "rosetta"}, parent3.getPathNames());
    assertArrayEquals(new String[]{"com", "regnosys", "rosetta", "common"}, parent2.getPathNames());
    assertArrayEquals(new String[]{"com", "regnosys", "rosetta", "common", "translation"}, parent.getPathNames());
    assertArrayEquals(new String[]{"com", "regnosys", "rosetta", "common", "translation", "Path"},
        actualParseResult.getPathNames());
  }

  /**
   * Method under test: {@link Path#parse(String, boolean)}
   */
  @Test
  public void testParse8() {
    // Arrange and Act
    Path actualParseResult = Path.parse("", true);

    // Assert
    assertNull(actualParseResult.getLastElement());
    assertEquals(0, actualParseResult.getPathNames().length);
    assertTrue(actualParseResult.getElements().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Path#equals(Object)}
   *   <li>{@link Path#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link Path#equals(Object)}
   *   <li>{@link Path#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Path path = ScopeReferenceHelper.EMPTY_SCOPE;

    // Act and Assert
    assertEquals(path, path);
    int expectedHashCodeResult = path.hashCode();
    assertEquals(expectedHashCodeResult, path.hashCode());
  }

  /**
   * Method under test: {@link Path#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Path(), ScopeReferenceHelper.EMPTY_SCOPE);
  }

  /**
   * Method under test: {@link Path#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Path path = new Path();
    path.addElement(mock(Path.PathElement.class));

    // Act and Assert
    assertNotEquals(path, ScopeReferenceHelper.EMPTY_SCOPE);
  }

  /**
   * Method under test: {@link Path#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ScopeReferenceHelper.EMPTY_SCOPE, null);
  }

  /**
   * Method under test: {@link Path#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ScopeReferenceHelper.EMPTY_SCOPE, "Different type to Path");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Path#Path(List)}
   *   <li>{@link Path#toString()}
   *   <li>{@link Path#getElements()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<Path.PathElement> elements = new ArrayList<>();

    // Act
    Path actualPath = new Path(elements);
    String actualToStringResult = actualPath.toString();
    List<Path.PathElement> actualElements = actualPath.getElements();

    // Assert
    assertEquals("", actualToStringResult);
    assertTrue(actualElements.isEmpty());
    assertSame(elements, actualElements);
  }

  /**
   * Method under test: {@link Path#Path()}
   */
  @Test
  public void testNewPath() {
    // Arrange and Act
    Path actualPath = new Path();

    // Assert
    assertNull(actualPath.getLastElement());
    assertEquals(0, actualPath.getPathNames().length);
    assertTrue(actualPath.getElements().isEmpty());
  }
}
