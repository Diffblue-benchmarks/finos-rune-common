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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.RegPaths;
import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClassPathUtilsDiffblueTest {
  /**
   * Test {@link ClassPathUtils#expandPaths(Collection, String, Optional)}.
   *
   * <ul>
   *   <li>Given {@link RegPaths#CONFIG_PATH}.
   *   <li>Then throw {@link UncheckedIOException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtils#expandPaths(Collection, String, Optional)}
   */
  @Test
  @DisplayName(
      "Test expandPaths(Collection, String, Optional); given CONFIG_PATH; then throw UncheckedIOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ClassPathUtils.expandPaths(Collection, String, Optional)"})
  void testExpandPaths_givenConfig_path_thenThrowUncheckedIOException() {
    // Arrange
    ArrayList<Path> paths = new ArrayList<>();
    paths.add(RegPaths.CONFIG_PATH);
    Optional<String> excludeRegex = Optional.of("foo");

    // Act and Assert
    assertThrows(
        UncheckedIOException.class, () -> ClassPathUtils.expandPaths(paths, ".*", excludeRegex));
  }

  /**
   * Test {@link ClassPathUtils#expandPaths(Collection, String, Optional)}.
   *
   * <ul>
   *   <li>Given {@link RegPaths#CONFIG_PATH}.
   *   <li>Then throw {@link UncheckedIOException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtils#expandPaths(Collection, String, Optional)}
   */
  @Test
  @DisplayName(
      "Test expandPaths(Collection, String, Optional); given CONFIG_PATH; then throw UncheckedIOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ClassPathUtils.expandPaths(Collection, String, Optional)"})
  void testExpandPaths_givenConfig_path_thenThrowUncheckedIOException2() {
    // Arrange
    ArrayList<Path> paths = new ArrayList<>();
    paths.add(RegPaths.CONFIG_PATH);
    paths.add(RegPaths.CONFIG_PATH);
    Optional<String> excludeRegex = Optional.of("foo");

    // Act and Assert
    assertThrows(
        UncheckedIOException.class, () -> ClassPathUtils.expandPaths(paths, ".*", excludeRegex));
  }

  /**
   * Test {@link ClassPathUtils#expandPaths(Collection, String, Optional)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathUtils#expandPaths(Collection, String, Optional)}
   */
  @Test
  @DisplayName(
      "Test expandPaths(Collection, String, Optional); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ClassPathUtils.expandPaths(Collection, String, Optional)"})
  void testExpandPaths_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<Path> paths = new ArrayList<>();
    Optional<String> excludeRegex = Optional.of("foo");

    // Act
    List<Path> actualExpandPathsResult = ClassPathUtils.expandPaths(paths, ".*", excludeRegex);

    // Assert
    assertTrue(actualExpandPathsResult.isEmpty());
  }
}
