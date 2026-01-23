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

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UrlUtilsDiffblueTest {
  /**
   * Test {@link UrlUtils#getFileName(URL)}.
   *
   * <p>Method under test: {@link UrlUtils#getFileName(URL)}
   */
  @Test
  @DisplayName("Test getFileName(URL)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UrlUtils.getFileName(URL)"})
  void testGetFileName() throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals(
        "test.txt",
        UrlUtils.getFileName(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link UrlUtils#getBaseFileName(URL)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code foo} toUri toURL.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtils#getBaseFileName(URL)}
   */
  @Test
  @DisplayName(
      "Test getBaseFileName(URL); when Property is 'java.io.tmpdir' is 'foo' toUri toURL; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UrlUtils.getBaseFileName(URL)"})
  void testGetBaseFileName_whenPropertyIsJavaIoTmpdirIsFooToUriToURL_thenReturnFoo()
      throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals(
        "foo",
        UrlUtils.getBaseFileName(
            Paths.get(System.getProperty("java.io.tmpdir"), "foo").toUri().toURL()));
  }

  /**
   * Test {@link UrlUtils#getBaseFileName(URL)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toUri toURL.
   *   <li>Then return {@code test}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtils#getBaseFileName(URL)}
   */
  @Test
  @DisplayName(
      "Test getBaseFileName(URL); when Property is 'java.io.tmpdir' is 'test.txt' toUri toURL; then return 'test'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UrlUtils.getBaseFileName(URL)"})
  void testGetBaseFileName_whenPropertyIsJavaIoTmpdirIsTestTxtToUriToURL_thenReturnTest()
      throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals(
        "test",
        UrlUtils.getBaseFileName(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link UrlUtils#getFileExtension(URL)}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtils#getFileExtension(URL)}
   */
  @Test
  @DisplayName("Test getFileExtension(URL); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UrlUtils.getFileExtension(URL)"})
  void testGetFileExtension_thenReturnEmptyString() throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals(
        "",
        UrlUtils.getFileExtension(
            Paths.get(System.getProperty("java.io.tmpdir"), "foo").toUri().toURL()));
  }

  /**
   * Test {@link UrlUtils#getFileExtension(URL)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toUri toURL.
   *   <li>Then return {@code txt}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtils#getFileExtension(URL)}
   */
  @Test
  @DisplayName(
      "Test getFileExtension(URL); when Property is 'java.io.tmpdir' is 'test.txt' toUri toURL; then return 'txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String UrlUtils.getFileExtension(URL)"})
  void testGetFileExtension_whenPropertyIsJavaIoTmpdirIsTestTxtToUriToURL_thenReturnTxt()
      throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals(
        "txt",
        UrlUtils.getFileExtension(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }
}
