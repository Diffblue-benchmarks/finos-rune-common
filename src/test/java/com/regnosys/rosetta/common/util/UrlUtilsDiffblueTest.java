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
import com.regnosys.rosetta.common.RegPaths;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

public class UrlUtilsDiffblueTest {
  /**
   * Method under test: {@link UrlUtils#getFileName(URL)}
   */
  @Test
  public void testGetFileName() throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals("test.txt",
        UrlUtils.getFileName(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
  }

  /**
   * Method under test: {@link UrlUtils#getBaseFileName(URL)}
   */
  @Test
  public void testGetBaseFileName() throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals("test",
        UrlUtils.getBaseFileName(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
    assertEquals("foo",
        UrlUtils.getBaseFileName(Paths.get(System.getProperty("java.io.tmpdir"), "foo").toUri().toURL()));
  }

  /**
   * Method under test: {@link UrlUtils#getFileExtension(URL)}
   */
  @Test
  public void testGetFileExtension() throws MalformedURLException {
    // Arrange, Act and Assert
    assertEquals("txt",
        UrlUtils.getFileExtension(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL()));
    assertEquals("", UrlUtils.getFileExtension(Paths.get(System.getProperty("java.io.tmpdir"), "foo").toUri().toURL()));
  }

  /**
   * Method under test: {@link UrlUtils#resolve(URL, String)}
   */
  @Test
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
   * Method under test: {@link UrlUtils#toPath(URL)}
   */
  @Test
  public void testToPath() throws MalformedURLException {
    // Arrange, Act and Assert
    File toFileResult = UrlUtils.toPath(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL())
        .toFile();
    assertEquals("test.txt", toFileResult.getName());
    assertTrue(toFileResult.isAbsolute());
  }

  /**
   * Method under test: {@link UrlUtils#toUrl(Path)}
   */
  @Test
  public void testToUrl() {
    // Arrange and Act
    URL actualToUrlResult = UrlUtils.toUrl(RegPaths.CONFIG_PATH);

    // Assert
    String expectedToStringResult = String.join("", "file:",
        Paths.get(System.getProperty("user.dir"), "config").toString());
    assertEquals(expectedToStringResult, actualToUrlResult.toString());
  }

  /**
   * Method under test: {@link UrlUtils#toPortableString(Path)}
   */
  @Test
  public void testToPortableString() {
    // Arrange, Act and Assert
    assertEquals("config", UrlUtils.toPortableString(RegPaths.CONFIG_PATH));
    assertNull(UrlUtils.toPortableString(null));
  }
}
