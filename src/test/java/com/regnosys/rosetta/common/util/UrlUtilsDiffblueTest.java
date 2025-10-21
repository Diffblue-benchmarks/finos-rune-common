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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.RegPaths;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UrlUtilsDiffblueTest {
  /**
   * Test {@link UrlUtils#getFileName(URL)}.
   * <p>
   * Method under test: {@link UrlUtils#getFileName(URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtils.getFileName(URL)"})
  public void testGetFileName() throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals("test.txt",
        UrlUtils.getFileName(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link UrlUtils#getBaseFileName(URL)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code foo} toUri toURL.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtils#getBaseFileName(URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtils.getBaseFileName(URL)"})
  public void testGetBaseFileName_whenPropertyIsJavaIoTmpdirIsFooToUriToURL_thenReturnFoo()
      throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals("foo",
        UrlUtils.getBaseFileName(Paths.get(System.getProperty("java.io.tmpdir"), "foo").toUri().toURL()));
  }

  /**
   * Test {@link UrlUtils#getBaseFileName(URL)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toUri toURL.</li>
   *   <li>Then return {@code test}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtils#getBaseFileName(URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtils.getBaseFileName(URL)"})
  public void testGetBaseFileName_whenPropertyIsJavaIoTmpdirIsTestTxtToUriToURL_thenReturnTest()
      throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals("test",
        UrlUtils.getBaseFileName(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link UrlUtils#getFileExtension(URL)}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtils#getFileExtension(URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtils.getFileExtension(URL)"})
  public void testGetFileExtension_thenReturnEmptyString() throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals("", UrlUtils.getFileExtension(Paths.get(System.getProperty("java.io.tmpdir"), "foo").toUri().toURL()));
  }

  /**
   * Test {@link UrlUtils#getFileExtension(URL)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toUri toURL.</li>
   *   <li>Then return {@code txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtils#getFileExtension(URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtils.getFileExtension(URL)"})
  public void testGetFileExtension_whenPropertyIsJavaIoTmpdirIsTestTxtToUriToURL_thenReturnTxt()
      throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals("txt",
        UrlUtils.getFileExtension(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Test {@link UrlUtils#resolve(URL, String)}.
   * <p>
   * Method under test: {@link UrlUtils#resolve(URL, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URL UrlUtils.resolve(URL, String)"})
  public void testResolve() throws MalformedURLException {
    // Arrange and Act
    URL actualResolveResult = UrlUtils.resolve(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL(), "https://example.org/example");

    // Assert
    String expectedToStringResult = String.join("", "file:",
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt", "https").toString(), "://example.org/example");
    assertEquals(expectedToStringResult, actualResolveResult.toString());
  }

  /**
   * Test {@link UrlUtils#toPath(URL)}.
   * <p>
   * Method under test: {@link UrlUtils#toPath(URL)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path UrlUtils.toPath(URL)"})
  public void testToPath() throws MalformedURLException {
    // Arrange, Act and Assert
    File toFileResult = UrlUtils.toPath(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL())
        .toFile();
    assertEquals("test.txt", toFileResult.getName());
    assertTrue(toFileResult.isAbsolute());
  }

  /**
   * Test {@link UrlUtils#toUrl(Path)}.
   * <p>
   * Method under test: {@link UrlUtils#toUrl(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"URL UrlUtils.toUrl(Path)"})
  public void testToUrl() {
    // Arrange and Act
    URL actualToUrlResult = UrlUtils.toUrl(RegPaths.CONFIG_PATH);

    // Assert
    String expectedToStringResult = String.join("", "file:",
        Paths.get(System.getProperty("user.dir"), "config").toString());
    assertEquals(expectedToStringResult, actualToUrlResult.toString());
  }

  /**
   * Test {@link UrlUtils#toPortableString(Path)}.
   * <ul>
   *   <li>When {@link RegPaths#CONFIG_PATH}.</li>
   *   <li>Then return {@code config}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtils#toPortableString(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtils.toPortableString(Path)"})
  public void testToPortableString_whenConfig_path_thenReturnConfig() {
    // Arrange, Act and Assert
    assertEquals("config", UrlUtils.toPortableString(RegPaths.CONFIG_PATH));
  }

  /**
   * Test {@link UrlUtils#toPortableString(Path)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UrlUtils#toPortableString(Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String UrlUtils.toPortableString(Path)"})
  public void testToPortableString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(UrlUtils.toPortableString(null));
  }
}
