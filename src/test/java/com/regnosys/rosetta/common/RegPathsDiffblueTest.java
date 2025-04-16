package com.regnosys.rosetta.common;

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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rosetta.model.lib.ModelReportId;
import com.rosetta.util.DottedPath;
import java.io.File;
import java.nio.file.Path;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RegPathsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RegPaths#RegPaths(Path, Path, Path, Path, Path)}
   *   <li>{@link RegPaths#getConfigRelativePath()}
   *   <li>{@link RegPaths#getInputRelativePath()}
   *   <li>{@link RegPaths#getLookupRelativePath()}
   *   <li>{@link RegPaths#getOutputRelativePath()}
   *   <li>{@link RegPaths#getRootRelativePath()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RegPaths.<init>(Path, Path, Path, Path, Path)", "Path RegPaths.getConfigRelativePath()",
      "Path RegPaths.getInputRelativePath()", "Path RegPaths.getLookupRelativePath()",
      "Path RegPaths.getOutputRelativePath()", "Path RegPaths.getRootRelativePath()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    RegPaths actualRegPaths = new RegPaths(RegPaths.CONFIG_PATH, RegPaths.CONFIG_PATH, RegPaths.CONFIG_PATH,
        RegPaths.CONFIG_PATH, RegPaths.CONFIG_PATH);
    Path actualConfigRelativePath = actualRegPaths.getConfigRelativePath();
    Path actualInputRelativePath = actualRegPaths.getInputRelativePath();
    Path actualLookupRelativePath = actualRegPaths.getLookupRelativePath();
    Path actualOutputRelativePath = actualRegPaths.getOutputRelativePath();

    // Assert
    Path path = actualRegPaths.CONFIG_PATH;
    assertSame(path, actualConfigRelativePath);
    assertSame(path, actualInputRelativePath);
    assertSame(path, actualLookupRelativePath);
    assertSame(path, actualOutputRelativePath);
    assertSame(path, actualRegPaths.getRootRelativePath());
  }

  /**
   * Test {@link RegPaths#directoryNameOfDataset(String)}.
   * <p>
   * Method under test: {@link RegPaths#directoryNameOfDataset(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String RegPaths.directoryNameOfDataset(String)"})
  public void testDirectoryNameOfDataset() {
    // Arrange, Act and Assert
    assertEquals("dataset-name", RegPaths.directoryNameOfDataset("Dataset Name"));
  }

  /**
   * Test {@link RegPaths#directoryName(ModelReportId)}.
   * <ul>
   *   <li>Then return {@code not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegPaths#directoryName(ModelReportId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String RegPaths.directoryName(ModelReportId)"})
  public void testDirectoryName_thenReturnNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    assertEquals("not all who wander are lost",
        RegPaths.directoryName(new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost")));
  }

  /**
   * Test {@link RegPaths#directoryName(ModelReportId)}.
   * <ul>
   *   <li>Then return {@code not all who wander are lost-corpus list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegPaths#directoryName(ModelReportId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String RegPaths.directoryName(ModelReportId)"})
  public void testDirectoryName_thenReturnNotAllWhoWanderAreLostCorpusList() {
    // Arrange, Act and Assert
    assertEquals("not all who wander are lost-corpus list", RegPaths.directoryName(
        new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List")));
  }

  /**
   * Test {@link RegPaths#getOutputPath(Path, ModelReportId)}.
   * <ul>
   *   <li>Then return toFile Name is {@code not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegPaths#getOutputPath(Path, ModelReportId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path RegPaths.getOutputPath(Path, ModelReportId)"})
  public void testGetOutputPath_thenReturnToFileNameIsNotAllWhoWanderAreLost() {
    // Arrange, Act and Assert
    File toFileResult = RegPaths
        .getOutputPath(RegPaths.CONFIG_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost"))
        .toFile();
    assertEquals("not all who wander are lost", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link RegPaths#getOutputPath(Path, ModelReportId)}.
   * <ul>
   *   <li>Then return toFile Name is {@code not all who wander are lost-corpus list}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegPaths#getOutputPath(Path, ModelReportId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path RegPaths.getOutputPath(Path, ModelReportId)"})
  public void testGetOutputPath_thenReturnToFileNameIsNotAllWhoWanderAreLostCorpusList() {
    // Arrange, Act and Assert
    File toFileResult = RegPaths
        .getOutputPath(RegPaths.CONFIG_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List"))
        .toFile();
    assertEquals("not all who wander are lost-corpus list", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link RegPaths#getOutputDataSetPath(Path, ModelReportId, String)}.
   * <p>
   * Method under test: {@link RegPaths#getOutputDataSetPath(Path, ModelReportId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path RegPaths.getOutputDataSetPath(Path, ModelReportId, String)"})
  public void testGetOutputDataSetPath() {
    // Arrange, Act and Assert
    File toFileResult = RegPaths
        .getOutputDataSetPath(RegPaths.CONFIG_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost"), "Data Set Name")
        .toFile();
    assertEquals("data-set-name", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link RegPaths#getOutputDataSetPath(Path, ModelReportId, String)}.
   * <ul>
   *   <li>Then return toFile Name is {@code data-set-name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegPaths#getOutputDataSetPath(Path, ModelReportId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path RegPaths.getOutputDataSetPath(Path, ModelReportId, String)"})
  public void testGetOutputDataSetPath_thenReturnToFileNameIsDataSetName() {
    // Arrange, Act and Assert
    File toFileResult = RegPaths
        .getOutputDataSetPath(RegPaths.CONFIG_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List"),
            "Data Set Name")
        .toFile();
    assertEquals("data-set-name", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link RegPaths#getInputDataSetPath(Path, String)}.
   * <ul>
   *   <li>When {@link RegPaths#CONFIG_PATH}.</li>
   *   <li>Then return toFile Name is {@code data-set-name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegPaths#getInputDataSetPath(Path, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path RegPaths.getInputDataSetPath(Path, String)"})
  public void testGetInputDataSetPath_whenConfig_path_thenReturnToFileNameIsDataSetName() {
    // Arrange, Act and Assert
    File toFileResult = RegPaths.getInputDataSetPath(RegPaths.CONFIG_PATH, "Data Set Name").toFile();
    assertEquals("data-set-name", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link RegPaths#getKeyValueExpectationFilePath(Path, ModelReportId, String, Path)}.
   * <p>
   * Method under test: {@link RegPaths#getKeyValueExpectationFilePath(Path, ModelReportId, String, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path RegPaths.getKeyValueExpectationFilePath(Path, ModelReportId, String, Path)"})
  public void testGetKeyValueExpectationFilePath() {
    // Arrange, Act and Assert
    File toFileResult = RegPaths
        .getKeyValueExpectationFilePath(RegPaths.CONFIG_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost"), "Data Set Name",
            RegPaths.CONFIG_PATH)
        .toFile();
    assertEquals("config", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }

  /**
   * Test {@link RegPaths#getKeyValueExpectationFilePath(Path, ModelReportId, String, Path)}.
   * <ul>
   *   <li>Then return toFile Name is {@code config}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RegPaths#getKeyValueExpectationFilePath(Path, ModelReportId, String, Path)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Path RegPaths.getKeyValueExpectationFilePath(Path, ModelReportId, String, Path)"})
  public void testGetKeyValueExpectationFilePath_thenReturnToFileNameIsConfig() {
    // Arrange, Act and Assert
    File toFileResult = RegPaths
        .getKeyValueExpectationFilePath(RegPaths.CONFIG_PATH,
            new ModelReportId(DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List"),
            "Data Set Name", RegPaths.CONFIG_PATH)
        .toFile();
    assertEquals("config", toFileResult.getName());
    assertFalse(toFileResult.isAbsolute());
  }
}
