package com.regnosys.rosetta.common.projection;

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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import java.io.File;
import java.nio.file.Path;
import org.junit.Test;

public class RegProjectionPathsDiffblueTest {
  /**
   * Method under test: {@link RegProjectionPaths#getProjectionPath()}
   */
  @Test
  public void testGetProjectionPath() {
    // Arrange and Act
    RegProjectionPaths actualProjectionPath = RegProjectionPaths.getProjectionPath();

    // Assert
    File toFileResult = actualProjectionPath.getConfigRelativePath().toFile();
    assertEquals("config", toFileResult.getName());
    File toFileResult2 = actualProjectionPath.getInputRelativePath().toFile();
    assertEquals("input", toFileResult2.getName());
    File toFileResult3 = actualProjectionPath.getRootRelativePath().toFile();
    assertEquals("iso-20022", toFileResult3.getName());
    File toFileResult4 = actualProjectionPath.getLookupRelativePath().toFile();
    assertEquals("lookup", toFileResult4.getName());
    File toFileResult5 = actualProjectionPath.getOutputRelativePath().toFile();
    assertEquals("output", toFileResult5.getName());
    assertFalse(toFileResult.isAbsolute());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult4.isAbsolute());
    assertFalse(toFileResult5.isAbsolute());
    assertFalse(toFileResult3.isAbsolute());
  }

  /**
   * Method under test:
   * {@link RegProjectionPaths#RegProjectionPaths(Path, Path, Path, Path, Path)}
   */
  @Test
  public void testNewRegProjectionPaths() {
    // Arrange and Act
    RegProjectionPaths actualRegProjectionPaths = new RegProjectionPaths(RegProjectionPaths.ISO20022_PATH,
        RegProjectionPaths.ISO20022_PATH, RegProjectionPaths.ISO20022_PATH, RegProjectionPaths.ISO20022_PATH,
        RegProjectionPaths.ISO20022_PATH);

    // Assert
    Path path = actualRegProjectionPaths.ISO20022_PATH;
    assertSame(path, actualRegProjectionPaths.getConfigRelativePath());
    assertSame(path, actualRegProjectionPaths.getInputRelativePath());
    assertSame(path, actualRegProjectionPaths.getLookupRelativePath());
    assertSame(path, actualRegProjectionPaths.getOutputRelativePath());
    assertSame(path, actualRegProjectionPaths.getRootRelativePath());
  }
}
