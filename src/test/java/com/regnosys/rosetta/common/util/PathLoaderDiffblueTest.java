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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mockStatic;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.management.loading.MLet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class PathLoaderDiffblueTest {
  /**
   * Test {@link PathLoader#loadFromClasspath(String, ClassLoader)}.
   *
   * <ul>
   *   <li>Given {@link Files} {@link Files#isWritable(Path)} return {@code true}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link PathLoader#loadFromClasspath(String, ClassLoader)}
   */
  @Test
  @DisplayName(
      "Test loadFromClasspath(String, ClassLoader); given Files isWritable(Path) return 'true'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream PathLoader.loadFromClasspath(String, ClassLoader)"})
  void testLoadFromClasspath_givenFilesIsWritableReturnTrue_thenThrowRuntimeException()
      throws IOException {
    // Arrange
    try (MockedStatic<Files> mockFiles = mockStatic(Files.class)) {
      mockFiles.when(() -> Files.isWritable(Mockito.<Path>any())).thenReturn(true);
      mockFiles
          .when(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)))
          .thenReturn(true);
      mockFiles
          .when(() -> Files.newByteChannel(Mockito.<Path>any(), isA(OpenOption[].class)))
          .thenReturn(null);
      mockFiles
          .when(
              () ->
                  Files.readAttributes(
                      Mockito.<Path>any(), eq(BasicFileAttributes.class), isA(LinkOption[].class)))
          .thenThrow(new IOException());

      // Act and Assert
      assertThrows(RuntimeException.class, () -> PathLoader.loadFromClasspath("", new MLet()));
      mockFiles.verify(() -> Files.notExists(Mockito.<Path>any(), isA(LinkOption[].class)));
      mockFiles.verify(
          () ->
              Files.readAttributes(
                  Mockito.<Path>any(), eq(BasicFileAttributes.class), isA(LinkOption[].class)));
    }
  }

  /**
   * Test {@link PathLoader#loadFromClasspath(String, ClassLoader)}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link PathLoader#loadFromClasspath(String, ClassLoader)}
   */
  @Test
  @DisplayName(
      "Test loadFromClasspath(String, ClassLoader); when 'Path'; then return limit five collect toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Stream PathLoader.loadFromClasspath(String, ClassLoader)"})
  void testLoadFromClasspath_whenPath_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Path> actualLoadFromClasspathResult = PathLoader.loadFromClasspath("Path", new MLet());

    // Assert
    assertTrue(actualLoadFromClasspathResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
