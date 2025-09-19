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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.RegPaths;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
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
  @MethodsUnderTest({"String UrlUtils.getFileName(URL)"})
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
  @MethodsUnderTest({"String UrlUtils.getBaseFileName(URL)"})
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
  @MethodsUnderTest({"String UrlUtils.getBaseFileName(URL)"})
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
  @MethodsUnderTest({"String UrlUtils.getFileExtension(URL)"})
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
  @MethodsUnderTest({"String UrlUtils.getFileExtension(URL)"})
  void testGetFileExtension_whenPropertyIsJavaIoTmpdirIsTestTxtToUriToURL_thenReturnTxt()
      throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals(
        "txt",
        UrlUtils.getFileExtension(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link UrlUtils#resolve(URL, String)}.
   *
   * <p>Method under test: {@link UrlUtils#resolve(URL, String)}
   */
  @Test
  @DisplayName("Test resolve(URL, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URL UrlUtils.resolve(URL, String)"})
  void testResolve() throws MalformedURLException {
    // Arrange and Act
    URL actualResolveResult =
        UrlUtils.resolve(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(),
            "https://example.org/example");

    // Assert
    Path getResult = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt", "https");
    String expectedToStringResult =
        String.join("", "file:", getResult.toString(), "://example.org/example");
    assertEquals(expectedToStringResult, actualResolveResult.toString());
  }

  /**
   * Test {@link UrlUtils#toPath(URL)}.
   *
   * <p>Method under test: {@link UrlUtils#toPath(URL)}
   */
  @Test
  @DisplayName("Test toPath(URL)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path UrlUtils.toPath(URL)"})
  void testToPath() throws MalformedURLException {
    // Arrange, Act and Assert
    File toFileResult =
        UrlUtils.toPath(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL())
            .toFile();
    assertEquals("test.txt", toFileResult.getName());
    assertTrue(toFileResult.isAbsolute());
  }

  /**
   * Test {@link UrlUtils#toUrl(Path)}.
   *
   * <p>Method under test: {@link UrlUtils#toUrl(Path)}
   */
  @Test
  @DisplayName("Test toUrl(Path)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URL UrlUtils.toUrl(Path)"})
  void testToUrl() {
    // Arrange and Act
    URL actualToUrlResult = UrlUtils.toUrl(RegPaths.CONFIG_PATH);

    // Assert
    String expectedToStringResult =
        String.join("", "file:", Paths.get(System.getProperty("user.dir"), "config").toString());
    assertEquals(expectedToStringResult, actualToUrlResult.toString());
  }

  /**
   * Test {@link UrlUtils#toPortableString(Path)}.
   *
   * <ul>
   *   <li>When {@link RegPaths#CONFIG_PATH}.
   *   <li>Then return {@code config}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtils#toPortableString(Path)}
   */
  @Test
  @DisplayName("Test toPortableString(Path); when CONFIG_PATH; then return 'config'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtils.toPortableString(Path)"})
  void testToPortableString_whenConfig_path_thenReturnConfig() {
    // Arrange, Act and Assert
    assertEquals("config", UrlUtils.toPortableString(RegPaths.CONFIG_PATH));
  }

  /**
   * Test {@link UrlUtils#toPortableString(Path)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UrlUtils#toPortableString(Path)}
   */
  @Test
  @DisplayName("Test toPortableString(Path); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UrlUtils.toPortableString(Path)"})
  void testToPortableString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(UrlUtils.toPortableString(null));
  }
}
