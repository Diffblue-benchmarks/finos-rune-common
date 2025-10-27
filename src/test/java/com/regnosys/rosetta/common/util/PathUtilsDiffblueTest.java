package com.regnosys.rosetta.common.util;

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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.regnosys.rosetta.common.hashing.ScopeReferenceHelper;
import com.regnosys.rosetta.common.translation.Path;
import com.rosetta.model.lib.path.RosettaPath;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import org.junit.Test;

public class PathUtilsDiffblueTest {
  /**
   * Method under test: {@link PathUtils#toRosettaPath(Path)}
   */
  @Test
  public void testToRosettaPath() {
    // Arrange and Act
    RosettaPath actualToRosettaPathResult = PathUtils.toRosettaPath(ScopeReferenceHelper.EMPTY_SCOPE);

    // Assert
    RosettaPath.Element element = actualToRosettaPathResult.getElement();
    assertEquals("FpML_5_10", element.getUri());
    assertEquals("emptyScope", element.getPath());
    assertNull(actualToRosettaPathResult.getParent());
    assertFalse(element.getIndex().isPresent());
    assertTrue(element.getMetas().isEmpty());
  }

  /**
   * Method under test: {@link PathUtils#toRosettaPath(Path)}
   */
  @Test
  public void testToRosettaPath2() {
    // Arrange, Act and Assert
    assertNull(PathUtils.toRosettaPath(new Path()));
  }

  /**
   * Method under test: {@link PathUtils#toRosettaPath(Path)}
   */
  @Test
  public void testToRosettaPath3() {
    // Arrange and Act
    RosettaPath actualToRosettaPathResult = PathUtils
        .toRosettaPath(Path.parse("com.regnosys.rosetta.common.translation.Path", true));

    // Assert
    RosettaPath parent = actualToRosettaPathResult.getParent();
    RosettaPath parent2 = parent.getParent();
    RosettaPath parent3 = parent2.getParent();
    RosettaPath parent4 = parent3.getParent();
    RosettaPath parent5 = parent4.getParent();
    RosettaPath.Element element = parent5.getElement();
    assertEquals("FpML_5_10", element.getUri());
    RosettaPath.Element element2 = parent4.getElement();
    assertEquals("FpML_5_10", element2.getUri());
    RosettaPath.Element element3 = parent3.getElement();
    assertEquals("FpML_5_10", element3.getUri());
    RosettaPath.Element element4 = parent2.getElement();
    assertEquals("FpML_5_10", element4.getUri());
    RosettaPath.Element element5 = parent.getElement();
    assertEquals("FpML_5_10", element5.getUri());
    RosettaPath.Element element6 = actualToRosettaPathResult.getElement();
    assertEquals("FpML_5_10", element6.getUri());
    assertEquals("Path", element6.getPath());
    assertEquals("com", element.getPath());
    assertEquals("common", element4.getPath());
    assertEquals("regnosys", element2.getPath());
    assertEquals("rosetta", element3.getPath());
    assertEquals("translation", element5.getPath());
    assertNull(parent5.getParent());
    OptionalInt index = element6.getIndex();
    assertFalse(index.isPresent());
    Map<String, String> metas = element6.getMetas();
    assertTrue(metas.isEmpty());
    assertSame(index, element.getIndex());
    assertSame(index, element2.getIndex());
    assertSame(index, element3.getIndex());
    assertSame(index, element4.getIndex());
    assertSame(index, element5.getIndex());
    assertSame(metas, element.getMetas());
    assertSame(metas, element2.getMetas());
    assertSame(metas, element3.getMetas());
    assertSame(metas, element4.getMetas());
    assertSame(metas, element5.getMetas());
  }

  /**
   * Method under test: {@link PathUtils#toPath(RosettaPath)}
   */
  @Test
  public void testToPath() {
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
   * Method under test: {@link PathUtils#toPath(RosettaPath)}
   */
  @Test
  public void testToPath2() {
    // Arrange
    RosettaPath rosettaPath = mock(RosettaPath.class);
    when(rosettaPath.allElements()).thenThrow(new PathException("0123456789ABCDEF"));

    // Act and Assert
    assertThrows(PathException.class, () -> PathUtils.toPath(rosettaPath));
    verify(rosettaPath).allElements();
  }

  /**
   * Method under test: {@link PathUtils#filterSubPaths(Collection)}
   */
  @Test
  public void testFilterSubPaths() {
    // Arrange and Act
    List<Path> actualFilterSubPathsResult = PathUtils.filterSubPaths(new ArrayList<>());

    // Assert
    assertTrue(actualFilterSubPathsResult.isEmpty());
  }

  /**
   * Method under test: {@link PathUtils#filterSubPaths(Collection)}
   */
  @Test
  public void testFilterSubPaths2() {
    // Arrange
    ArrayList<Path> paths = new ArrayList<>();
    paths.add(ScopeReferenceHelper.EMPTY_SCOPE);

    // Act
    List<Path> actualFilterSubPathsResult = PathUtils.filterSubPaths(paths);

    // Assert
    assertEquals(paths, actualFilterSubPathsResult);
  }

  /**
   * Method under test: {@link PathUtils#filterSubPaths(Collection)}
   */
  @Test
  public void testFilterSubPaths3() {
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
   * Method under test: {@link PathUtils#filterSubPaths(Collection)}
   */
  @Test
  public void testFilterSubPaths4() {
    // Arrange
    ArrayList<Path> paths = new ArrayList<>();
    paths.add(new Path());

    // Act
    List<Path> actualFilterSubPathsResult = PathUtils.filterSubPaths(paths);

    // Assert
    assertEquals(paths, actualFilterSubPathsResult);
  }

  /**
   * Method under test: {@link PathUtils#filterSubPaths(Collection)}
   */
  @Test
  public void testFilterSubPaths5() {
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
    Path.PathElement lastElement = getResult.getLastElement();
    assertEquals("emptyScope", lastElement.getPathName());
    List<Path.PathElement> elements = getResult.getElements();
    assertEquals(1, elements.size());
    assertFalse(lastElement.getIndex().isPresent());
    assertTrue(lastElement.getMetas().isEmpty());
    assertEquals(path, getResult.getParent());
    assertSame(lastElement, elements.get(0));
    assertArrayEquals(new String[]{"emptyScope"}, getResult.getPathNames());
  }

  /**
   * Method under test: {@link PathUtils#filterSubPaths(Collection)}
   */
  @Test
  public void testFilterSubPaths6() {
    // Arrange
    ArrayList<Path> paths = new ArrayList<>();
    paths.add(Path.valueOf("Path"));
    paths.add(ScopeReferenceHelper.EMPTY_SCOPE);

    // Act
    List<Path> actualFilterSubPathsResult = PathUtils.filterSubPaths(paths);

    // Assert
    assertEquals(paths, actualFilterSubPathsResult);
  }
}
