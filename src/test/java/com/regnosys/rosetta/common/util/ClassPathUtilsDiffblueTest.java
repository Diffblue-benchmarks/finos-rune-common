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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.regnosys.rosetta.common.RegPaths;
import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

public class ClassPathUtilsDiffblueTest {
  /**
   * Method under test:
   * {@link ClassPathUtils#expandPaths(Collection, String, Optional)}
   */
  @Test
  public void testExpandPaths() {
    // Arrange
    ArrayList<Path> paths = new ArrayList<>();
    Optional<String> excludeRegex = Optional.of("foo");

    // Act
    List<Path> actualExpandPathsResult = ClassPathUtils.expandPaths(paths, ".*", excludeRegex);

    // Assert
    assertTrue(actualExpandPathsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link ClassPathUtils#expandPaths(Collection, String, Optional)}
   */
  @Test
  public void testExpandPaths2() {
    // Arrange
    ArrayList<Path> paths = new ArrayList<>();
    paths.add(RegPaths.CONFIG_PATH);
    Optional<String> excludeRegex = Optional.of("foo");

    // Act and Assert
    assertThrows(UncheckedIOException.class, () -> ClassPathUtils.expandPaths(paths, ".*", excludeRegex));
  }

  /**
   * Method under test:
   * {@link ClassPathUtils#expandPaths(Collection, String, Optional)}
   */
  @Test
  public void testExpandPaths3() {
    // Arrange
    ArrayList<Path> paths = new ArrayList<>();
    paths.add(RegPaths.CONFIG_PATH);
    paths.add(RegPaths.CONFIG_PATH);
    Optional<String> excludeRegex = Optional.of("foo");

    // Act and Assert
    assertThrows(UncheckedIOException.class, () -> ClassPathUtils.expandPaths(paths, ".*", excludeRegex));
  }

  /**
   * Method under test:
   * {@link ClassPathUtils#expandPaths(Collection, String, Optional)}
   */
  @Test
  public void testExpandPaths4() {
    // Arrange
    ArrayList<Path> paths = new ArrayList<>();
    paths.add(Paths.get(System.getProperty("java.io.tmpdir"), ""));
    Optional<String> excludeRegex = Optional.of("foo");

    // Act
    List<Path> actualExpandPathsResult = ClassPathUtils.expandPaths(paths, "U", excludeRegex);

    // Assert
    assertTrue(actualExpandPathsResult.isEmpty());
  }

  /**
   * Method under test: {@link ClassPathUtils#getResource(Path)}
   */
  @Test
  public void testGetResource() {
    // Arrange, Act and Assert
    assertNull(ClassPathUtils.getResource(RegPaths.CONFIG_PATH));
  }
}
