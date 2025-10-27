package com.regnosys.rosetta.common.reports;

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
import com.rosetta.model.lib.ModelReportId;
import com.rosetta.util.DottedPath;
import java.io.File;
import java.nio.file.Path;
import org.junit.Test;

public class RegReportPathsDiffblueTest {
  /**
   * Method under test: {@link RegReportPaths#get(Path)}
   */
  @Test
  public void testGet() {
    // Arrange and Act
    RegReportPaths actualGetResult = RegReportPaths.get(RegReportPaths.REGULATORY_REPORTING_PATH);

    // Assert
    Path configRelativePath = actualGetResult.getConfigRelativePath();
    File toFileResult = configRelativePath.toFile();
    assertEquals("data", toFileResult.getName());
    File toFileResult2 = actualGetResult.getLookupRelativePath().toFile();
    assertEquals("lookup", toFileResult2.getName());
    assertFalse(toFileResult.isAbsolute());
    assertFalse(toFileResult2.isAbsolute());
    assertSame(configRelativePath, actualGetResult.getInputRelativePath());
    assertSame(configRelativePath, actualGetResult.getOutputRelativePath());
    assertSame(configRelativePath, actualGetResult.getRootRelativePath());
  }

  /**
   * Method under test: {@link RegReportPaths#getDefault()}
   */
  @Test
  public void testGetDefault() {
    // Arrange and Act
    RegReportPaths actualDefault = RegReportPaths.getDefault();

    // Assert
    File toFileResult = actualDefault.getConfigRelativePath().toFile();
    assertEquals("config", toFileResult.getName());
    File toFileResult2 = actualDefault.getInputRelativePath().toFile();
    assertEquals("input", toFileResult2.getName());
    File toFileResult3 = actualDefault.getLookupRelativePath().toFile();
    assertEquals("lookup", toFileResult3.getName());
    File toFileResult4 = actualDefault.getOutputRelativePath().toFile();
    assertEquals("output", toFileResult4.getName());
    assertFalse(toFileResult.isAbsolute());
    assertFalse(toFileResult2.isAbsolute());
    assertFalse(toFileResult3.isAbsolute());
    assertFalse(toFileResult4.isAbsolute());
    Path expectedRootRelativePath = actualDefault.REGULATORY_REPORTING_PATH;
    assertSame(expectedRootRelativePath, actualDefault.getRootRelativePath());
  }

  /**
   * Method under test: {@link RegReportPaths#getLegacy()}
   */
  @Test
  public void testGetLegacy() {
    // Arrange and Act
    RegReportPaths actualLegacy = RegReportPaths.getLegacy();

    // Assert
    Path configRelativePath = actualLegacy.getConfigRelativePath();
    File toFileResult = configRelativePath.toFile();
    assertEquals("data", toFileResult.getName());
    File toFileResult2 = actualLegacy.getLookupRelativePath().toFile();
    assertEquals("lookup", toFileResult2.getName());
    assertFalse(toFileResult.isAbsolute());
    assertFalse(toFileResult2.isAbsolute());
    assertSame(configRelativePath, actualLegacy.getInputRelativePath());
    assertSame(configRelativePath, actualLegacy.getOutputRelativePath());
    assertSame(configRelativePath, actualLegacy.getRootRelativePath());
  }

  /**
   * Method under test:
   * {@link RegReportPaths#getReportExpectationsFilePath(Path, ModelReportId, String)}
   */
  @Test
  public void testGetReportExpectationsFilePath() {
    // Arrange, Act and Assert
    File toFileResult = RegReportPaths
        .getReportExpectationsFilePath(RegReportPaths.REGULATORY_REPORTING_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List"),
            "Data Set Name")
        .toFile();
    assertFalse(toFileResult.isAbsolute());
    assertEquals(RegReportPaths.REPORT_EXPECTATIONS_FILE_NAME, toFileResult.getName());
  }

  /**
   * Method under test:
   * {@link RegReportPaths#getReportExpectationsFilePath(Path, ModelReportId, String)}
   */
  @Test
  public void testGetReportExpectationsFilePath2() {
    // Arrange, Act and Assert
    File toFileResult = RegReportPaths
        .getReportExpectationsFilePath(RegReportPaths.REGULATORY_REPORTING_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost"), "Data Set Name")
        .toFile();
    assertFalse(toFileResult.isAbsolute());
    assertEquals(RegReportPaths.REPORT_EXPECTATIONS_FILE_NAME, toFileResult.getName());
  }

  /**
   * Method under test:
   * {@link RegReportPaths#getLegacyReportPath(Path, ModelReportId)}
   */
  @Test
  public void testGetLegacyReportPath() {
    // Arrange, Act and Assert
    File toFileResult = RegReportPaths
        .getLegacyReportPath(RegReportPaths.REGULATORY_REPORTING_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List"))
        .toFile();
    assertEquals("not all who wander are lostcorpus list", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Method under test:
   * {@link RegReportPaths#getLegacyReportPath(Path, ModelReportId)}
   */
  @Test
  public void testGetLegacyReportPath2() {
    // Arrange, Act and Assert
    File toFileResult = RegReportPaths
        .getLegacyReportPath(RegReportPaths.REGULATORY_REPORTING_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost"))
        .toFile();
    assertEquals("not all who wander are lost", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Method under test:
   * {@link RegReportPaths#getLegacyKeyValueExpectationFilePath(Path, ModelReportId, String, Path)}
   */
  @Test
  public void testGetLegacyKeyValueExpectationFilePath() {
    // Arrange, Act and Assert
    File toFileResult = RegReportPaths
        .getLegacyKeyValueExpectationFilePath(RegReportPaths.REGULATORY_REPORTING_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List"),
            "Data Set Name", RegReportPaths.REGULATORY_REPORTING_PATH)
        .toFile();
    assertEquals("regulatory-reporting", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Method under test:
   * {@link RegReportPaths#getLegacyKeyValueExpectationFilePath(Path, ModelReportId, String, Path)}
   */
  @Test
  public void testGetLegacyKeyValueExpectationFilePath2() {
    // Arrange, Act and Assert
    File toFileResult = RegReportPaths
        .getLegacyKeyValueExpectationFilePath(RegReportPaths.REGULATORY_REPORTING_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost"), "Data Set Name",
            RegReportPaths.REGULATORY_REPORTING_PATH)
        .toFile();
    assertEquals("regulatory-reporting", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Method under test:
   * {@link RegReportPaths#getReportExpectationFilePath(Path, ModelReportId, String, Path)}
   */
  @Test
  public void testGetReportExpectationFilePath() {
    // Arrange, Act and Assert
    File toFileResult = RegReportPaths
        .getReportExpectationFilePath(RegReportPaths.REGULATORY_REPORTING_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List"),
            "Data Set Name", RegReportPaths.REGULATORY_REPORTING_PATH)
        .toFile();
    assertEquals("regulatory-reporting", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Method under test:
   * {@link RegReportPaths#getReportExpectationFilePath(Path, ModelReportId, String, Path)}
   */
  @Test
  public void testGetReportExpectationFilePath2() {
    // Arrange, Act and Assert
    File toFileResult = RegReportPaths
        .getReportExpectationFilePath(RegReportPaths.REGULATORY_REPORTING_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost"), "Data Set Name",
            RegReportPaths.REGULATORY_REPORTING_PATH)
        .toFile();
    assertEquals("regulatory-reporting", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Method under test: {@link RegReportPaths#legacyDirectoryName(ModelReportId)}
   */
  @Test
  public void testLegacyDirectoryName() {
    // Arrange, Act and Assert
    assertEquals("not all who wander are lostcorpus list", RegReportPaths.legacyDirectoryName(
        new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List")));
    assertEquals("not all who wander are lost", RegReportPaths
        .legacyDirectoryName(new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost")));
  }

  /**
   * Method under test:
   * {@link RegReportPaths#getLegacyReportDataSetPath(Path, ModelReportId, String)}
   */
  @Test
  public void testGetLegacyReportDataSetPath() {
    // Arrange, Act and Assert
    File toFileResult = RegReportPaths
        .getLegacyReportDataSetPath(RegReportPaths.REGULATORY_REPORTING_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List"),
            "Data Set Name")
        .toFile();
    assertEquals("data-set-name", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Method under test:
   * {@link RegReportPaths#getLegacyReportDataSetPath(Path, ModelReportId, String)}
   */
  @Test
  public void testGetLegacyReportDataSetPath2() {
    // Arrange, Act and Assert
    File toFileResult = RegReportPaths
        .getLegacyReportDataSetPath(RegReportPaths.REGULATORY_REPORTING_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost"), "Data Set Name")
        .toFile();
    assertEquals("data-set-name", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Method under test:
   * {@link RegReportPaths#RegReportPaths(Path, Path, Path, Path, Path)}
   */
  @Test
  public void testNewRegReportPaths() {
    // Arrange and Act
    RegReportPaths actualRegReportPaths = new RegReportPaths(RegReportPaths.REGULATORY_REPORTING_PATH,
        RegReportPaths.REGULATORY_REPORTING_PATH, RegReportPaths.REGULATORY_REPORTING_PATH,
        RegReportPaths.REGULATORY_REPORTING_PATH, RegReportPaths.REGULATORY_REPORTING_PATH);

    // Assert
    Path path = actualRegReportPaths.REGULATORY_REPORTING_PATH;
    assertSame(path, actualRegReportPaths.getConfigRelativePath());
    assertSame(path, actualRegReportPaths.getInputRelativePath());
    assertSame(path, actualRegReportPaths.getLookupRelativePath());
    assertSame(path, actualRegReportPaths.getOutputRelativePath());
    assertSame(path, actualRegReportPaths.getRootRelativePath());
  }
}
