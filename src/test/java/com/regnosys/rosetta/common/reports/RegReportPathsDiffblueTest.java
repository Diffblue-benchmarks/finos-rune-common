package com.regnosys.rosetta.common.reports;

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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rosetta.model.lib.ModelReportId;
import com.rosetta.util.DottedPath;
import java.io.File;
import java.nio.file.Path;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RegReportPathsDiffblueTest {
  /**
   * Test {@link RegReportPaths#get(Path)}.
   *
   * <ul>
   *   <li>Then return ConfigRelativePath toFile Name is {@code data}.
   * </ul>
   *
   * <p>Method under test: {@link RegReportPaths#get(Path)}
   */
  @Test
  @DisplayName("Test get(Path); then return ConfigRelativePath toFile Name is 'data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegReportPaths RegReportPaths.get(Path)"})
  void testGet_thenReturnConfigRelativePathToFileNameIsData() {
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
   * Test {@link RegReportPaths#getDefault()}.
   *
   * <p>Method under test: {@link RegReportPaths#getDefault()}
   */
  @Test
  @DisplayName("Test getDefault()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegReportPaths RegReportPaths.getDefault()"})
  void testGetDefault() {
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
    assertSame(RegReportPaths.REGULATORY_REPORTING_PATH, actualDefault.getRootRelativePath());
  }

  /**
   * Test {@link RegReportPaths#getLegacy()}.
   *
   * <p>Method under test: {@link RegReportPaths#getLegacy()}
   */
  @Test
  @DisplayName("Test getLegacy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RegReportPaths RegReportPaths.getLegacy()"})
  void testGetLegacy() {
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
   * Test {@link RegReportPaths#RegReportPaths(Path, Path, Path, Path, Path)}.
   *
   * <p>Method under test: {@link RegReportPaths#RegReportPaths(Path, Path, Path, Path, Path)}
   */
  @Test
  @DisplayName("Test new RegReportPaths(Path, Path, Path, Path, Path)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RegReportPaths.<init>(Path, Path, Path, Path, Path)"})
  void testNewRegReportPaths() {
    // Arrange and Act
    RegReportPaths actualRegReportPaths =
        new RegReportPaths(
            RegReportPaths.REGULATORY_REPORTING_PATH,
            RegReportPaths.REGULATORY_REPORTING_PATH,
            RegReportPaths.REGULATORY_REPORTING_PATH,
            RegReportPaths.REGULATORY_REPORTING_PATH,
            RegReportPaths.REGULATORY_REPORTING_PATH);

    // Assert
    Path path = RegReportPaths.REGULATORY_REPORTING_PATH;
    assertSame(path, actualRegReportPaths.getConfigRelativePath());
    assertSame(path, actualRegReportPaths.getInputRelativePath());
    assertSame(path, actualRegReportPaths.getLookupRelativePath());
    assertSame(path, actualRegReportPaths.getOutputRelativePath());
    assertSame(path, actualRegReportPaths.getRootRelativePath());
  }

  /**
   * Test {@link RegReportPaths#getReportExpectationsFilePath(Path, ModelReportId, String)}.
   *
   * <p>Method under test: {@link RegReportPaths#getReportExpectationsFilePath(Path, ModelReportId,
   * String)}
   */
  @Test
  @DisplayName("Test getReportExpectationsFilePath(Path, ModelReportId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Path RegReportPaths.getReportExpectationsFilePath(Path, ModelReportId, String)"
  })
  void testGetReportExpectationsFilePath() {
    // Arrange
    ModelReportId reportIdentifier =
        new ModelReportId(
            DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List");

    // Act
    Path actualReportExpectationsFilePath =
        RegReportPaths.getReportExpectationsFilePath(
            RegReportPaths.REGULATORY_REPORTING_PATH, reportIdentifier, "Data Set Name");

    // Assert
    File toFileResult = actualReportExpectationsFilePath.toFile();
    assertFalse(toFileResult.isAbsolute());
    assertEquals(RegReportPaths.REPORT_EXPECTATIONS_FILE_NAME, toFileResult.getName());
  }

  /**
   * Test {@link RegReportPaths#getReportExpectationsFilePath(Path, ModelReportId, String)}.
   *
   * <p>Method under test: {@link RegReportPaths#getReportExpectationsFilePath(Path, ModelReportId,
   * String)}
   */
  @Test
  @DisplayName("Test getReportExpectationsFilePath(Path, ModelReportId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Path RegReportPaths.getReportExpectationsFilePath(Path, ModelReportId, String)"
  })
  void testGetReportExpectationsFilePath2() {
    // Arrange and Act
    Path actualReportExpectationsFilePath =
        RegReportPaths.getReportExpectationsFilePath(
            RegReportPaths.REGULATORY_REPORTING_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost"),
            "Data Set Name");

    // Assert
    File toFileResult = actualReportExpectationsFilePath.toFile();
    assertFalse(toFileResult.isAbsolute());
    assertEquals(RegReportPaths.REPORT_EXPECTATIONS_FILE_NAME, toFileResult.getName());
  }

  /**
   * Test {@link RegReportPaths#getLegacyReportPath(Path, ModelReportId)}.
   *
   * <ul>
   *   <li>Then return toFile Name is {@code not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link RegReportPaths#getLegacyReportPath(Path, ModelReportId)}
   */
  @Test
  @DisplayName(
      "Test getLegacyReportPath(Path, ModelReportId); then return toFile Name is 'not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path RegReportPaths.getLegacyReportPath(Path, ModelReportId)"})
  void testGetLegacyReportPath_thenReturnToFileNameIsNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    File toFileResult =
        RegReportPaths.getLegacyReportPath(
                RegReportPaths.REGULATORY_REPORTING_PATH,
                new ModelReportId(
                    DottedPath.split("Str", "Separator"), "Not all who wander are lost"))
            .toFile();
    assertEquals("not all who wander are lost", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link RegReportPaths#getLegacyReportPath(Path, ModelReportId)}.
   *
   * <ul>
   *   <li>Then return toFile Name is {@code not all who wander are lostcorpus list}.
   * </ul>
   *
   * <p>Method under test: {@link RegReportPaths#getLegacyReportPath(Path, ModelReportId)}
   */
  @Test
  @DisplayName(
      "Test getLegacyReportPath(Path, ModelReportId); then return toFile Name is 'not all who wander are lostcorpus list'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path RegReportPaths.getLegacyReportPath(Path, ModelReportId)"})
  void testGetLegacyReportPath_thenReturnToFileNameIsNotAllWhoWanderAreLostcorpusList() {
    // Arrange
    ModelReportId reportIdentifier =
        new ModelReportId(
            DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List");

    // Act and Assert
    File toFileResult =
        RegReportPaths.getLegacyReportPath(
                RegReportPaths.REGULATORY_REPORTING_PATH, reportIdentifier)
            .toFile();
    assertEquals("not all who wander are lostcorpus list", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link RegReportPaths#getLegacyKeyValueExpectationFilePath(Path, ModelReportId, String,
   * Path)}.
   *
   * <p>Method under test: {@link RegReportPaths#getLegacyKeyValueExpectationFilePath(Path,
   * ModelReportId, String, Path)}
   */
  @Test
  @DisplayName("Test getLegacyKeyValueExpectationFilePath(Path, ModelReportId, String, Path)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Path RegReportPaths.getLegacyKeyValueExpectationFilePath(Path, ModelReportId, String, Path)"
  })
  void testGetLegacyKeyValueExpectationFilePath() {
    // Arrange
    ModelReportId reportIdentifier =
        new ModelReportId(
            DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List");

    // Act
    Path actualLegacyKeyValueExpectationFilePath =
        RegReportPaths.getLegacyKeyValueExpectationFilePath(
            RegReportPaths.REGULATORY_REPORTING_PATH,
            reportIdentifier,
            "Data Set Name",
            RegReportPaths.REGULATORY_REPORTING_PATH);

    // Assert
    File toFileResult = actualLegacyKeyValueExpectationFilePath.toFile();
    assertEquals("regulatory-reporting", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link RegReportPaths#getLegacyKeyValueExpectationFilePath(Path, ModelReportId, String,
   * Path)}.
   *
   * <p>Method under test: {@link RegReportPaths#getLegacyKeyValueExpectationFilePath(Path,
   * ModelReportId, String, Path)}
   */
  @Test
  @DisplayName("Test getLegacyKeyValueExpectationFilePath(Path, ModelReportId, String, Path)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Path RegReportPaths.getLegacyKeyValueExpectationFilePath(Path, ModelReportId, String, Path)"
  })
  void testGetLegacyKeyValueExpectationFilePath2() {
    // Arrange and Act
    Path actualLegacyKeyValueExpectationFilePath =
        RegReportPaths.getLegacyKeyValueExpectationFilePath(
            RegReportPaths.REGULATORY_REPORTING_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost"),
            "Data Set Name",
            RegReportPaths.REGULATORY_REPORTING_PATH);

    // Assert
    File toFileResult = actualLegacyKeyValueExpectationFilePath.toFile();
    assertEquals("regulatory-reporting", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link RegReportPaths#getReportExpectationFilePath(Path, ModelReportId, String, Path)}.
   *
   * <p>Method under test: {@link RegReportPaths#getReportExpectationFilePath(Path, ModelReportId,
   * String, Path)}
   */
  @Test
  @DisplayName("Test getReportExpectationFilePath(Path, ModelReportId, String, Path)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Path RegReportPaths.getReportExpectationFilePath(Path, ModelReportId, String, Path)"
  })
  void testGetReportExpectationFilePath() {
    // Arrange and Act
    Path actualReportExpectationFilePath =
        RegReportPaths.getReportExpectationFilePath(
            RegReportPaths.REGULATORY_REPORTING_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost"),
            "Data Set Name",
            RegReportPaths.REGULATORY_REPORTING_PATH);

    // Assert
    File toFileResult = actualReportExpectationFilePath.toFile();
    assertEquals("regulatory-reporting", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link RegReportPaths#getReportExpectationFilePath(Path, ModelReportId, String, Path)}.
   *
   * <ul>
   *   <li>Then return toFile Name is {@code regulatory-reporting}.
   * </ul>
   *
   * <p>Method under test: {@link RegReportPaths#getReportExpectationFilePath(Path, ModelReportId,
   * String, Path)}
   */
  @Test
  @DisplayName(
      "Test getReportExpectationFilePath(Path, ModelReportId, String, Path); then return toFile Name is 'regulatory-reporting'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Path RegReportPaths.getReportExpectationFilePath(Path, ModelReportId, String, Path)"
  })
  void testGetReportExpectationFilePath_thenReturnToFileNameIsRegulatoryReporting() {
    // Arrange
    ModelReportId reportIdentifier =
        new ModelReportId(
            DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List");

    // Act
    Path actualReportExpectationFilePath =
        RegReportPaths.getReportExpectationFilePath(
            RegReportPaths.REGULATORY_REPORTING_PATH,
            reportIdentifier,
            "Data Set Name",
            RegReportPaths.REGULATORY_REPORTING_PATH);

    // Assert
    File toFileResult = actualReportExpectationFilePath.toFile();
    assertEquals("regulatory-reporting", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link RegReportPaths#legacyDirectoryName(ModelReportId)}.
   *
   * <ul>
   *   <li>Then return {@code not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link RegReportPaths#legacyDirectoryName(ModelReportId)}
   */
  @Test
  @DisplayName("Test legacyDirectoryName(ModelReportId); then return 'not all who wander are lost'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RegReportPaths.legacyDirectoryName(ModelReportId)"})
  void testLegacyDirectoryName_thenReturnNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertEquals(
        "not all who wander are lost",
        RegReportPaths.legacyDirectoryName(
            new ModelReportId(
                DottedPath.split("Str", "Separator"), "Not all who wander are lost")));
  }

  /**
   * Test {@link RegReportPaths#legacyDirectoryName(ModelReportId)}.
   *
   * <ul>
   *   <li>Then return {@code not all who wander are lostcorpus list}.
   * </ul>
   *
   * <p>Method under test: {@link RegReportPaths#legacyDirectoryName(ModelReportId)}
   */
  @Test
  @DisplayName(
      "Test legacyDirectoryName(ModelReportId); then return 'not all who wander are lostcorpus list'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RegReportPaths.legacyDirectoryName(ModelReportId)"})
  void testLegacyDirectoryName_thenReturnNotAllWhoWanderAreLostcorpusList() {
    // Arrange
    ModelReportId id =
        new ModelReportId(
            DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List");

    // Act and Assert
    assertEquals("not all who wander are lostcorpus list", RegReportPaths.legacyDirectoryName(id));
  }

  /**
   * Test {@link RegReportPaths#getLegacyReportDataSetPath(Path, ModelReportId, String)}.
   *
   * <p>Method under test: {@link RegReportPaths#getLegacyReportDataSetPath(Path, ModelReportId,
   * String)}
   */
  @Test
  @DisplayName("Test getLegacyReportDataSetPath(Path, ModelReportId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path RegReportPaths.getLegacyReportDataSetPath(Path, ModelReportId, String)"})
  void testGetLegacyReportDataSetPath() {
    // Arrange
    ModelReportId reportIdentifier =
        new ModelReportId(
            DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List");

    // Act
    Path actualLegacyReportDataSetPath =
        RegReportPaths.getLegacyReportDataSetPath(
            RegReportPaths.REGULATORY_REPORTING_PATH, reportIdentifier, "Data Set Name");

    // Assert
    File toFileResult = actualLegacyReportDataSetPath.toFile();
    assertEquals("data-set-name", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link RegReportPaths#getLegacyReportDataSetPath(Path, ModelReportId, String)}.
   *
   * <p>Method under test: {@link RegReportPaths#getLegacyReportDataSetPath(Path, ModelReportId,
   * String)}
   */
  @Test
  @DisplayName("Test getLegacyReportDataSetPath(Path, ModelReportId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Path RegReportPaths.getLegacyReportDataSetPath(Path, ModelReportId, String)"})
  void testGetLegacyReportDataSetPath2() {
    // Arrange and Act
    Path actualLegacyReportDataSetPath =
        RegReportPaths.getLegacyReportDataSetPath(
            RegReportPaths.REGULATORY_REPORTING_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost"),
            "Data Set Name");

    // Assert
    File toFileResult = actualLegacyReportDataSetPath.toFile();
    assertEquals("data-set-name", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }
}
