package com.regnosys.rosetta.common.serialisation.projectiondata;

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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.regnosys.rosetta.common.serialisation.reportdata.ReportDataItem;
import com.rosetta.model.lib.ModelReportId;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.management.loading.MLet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JsonProjectionDataLoaderDiffblueTest {
  /**
   * Test {@link JsonProjectionDataLoader#loadInputFiles(ProjectionDataSet)} with {@code
   * ProjectionDataSet}.
   *
   * <p>Method under test: {@link JsonProjectionDataLoader#loadInputFiles(ProjectionDataSet)}
   */
  @Test
  @DisplayName("Test loadInputFiles(ProjectionDataSet) with 'ProjectionDataSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProjectionDataSet JsonProjectionDataLoader.loadInputFiles(ProjectionDataSet)"
  })
  void testLoadInputFilesWithProjectionDataSet() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonProjectionDataLoader jsonProjectionDataLoader =
        new JsonProjectionDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    ProjectionDataSet descriptor =
        new ProjectionDataSet(
            "Data Set Name",
            "Data Set Short Name",
            "Input Type",
            applicableProjections,
            applicableReports,
            new ArrayList<>());

    // Act
    ProjectionDataSet actualLoadInputFilesResult =
        jsonProjectionDataLoader.loadInputFiles(descriptor);

    // Assert
    assertEquals(descriptor, actualLoadInputFilesResult);
  }

  /**
   * Test {@link JsonProjectionDataLoader#loadInputFiles(ProjectionDataSet)} with {@code
   * ProjectionDataSet}.
   *
   * <ul>
   *   <li>Then return Data is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonProjectionDataLoader#loadInputFiles(ProjectionDataSet)}
   */
  @Test
  @DisplayName(
      "Test loadInputFiles(ProjectionDataSet) with 'ProjectionDataSet'; then return Data is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProjectionDataSet JsonProjectionDataLoader.loadInputFiles(ProjectionDataSet)"
  })
  void testLoadInputFilesWithProjectionDataSet_thenReturnDataIsArrayList()
      throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonProjectionDataLoader jsonProjectionDataLoader =
        new JsonProjectionDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());
    ArrayList<String> applicableProjections = new ArrayList<>();

    ProjectionDataSet descriptor =
        new ProjectionDataSet(
            "Data Set Name",
            "Data Set Short Name",
            "Input Type",
            applicableProjections,
            new ArrayList<>(),
            data);

    // Act
    ProjectionDataSet actualLoadInputFilesResult =
        jsonProjectionDataLoader.loadInputFiles(descriptor);

    // Assert
    assertEquals(data, actualLoadInputFilesResult.getData());
  }

  /**
   * Test {@link JsonProjectionDataLoader#loadInputFiles(ProjectionDataSet)} with {@code
   * ProjectionDataSet}.
   *
   * <ul>
   *   <li>Then return DataSetName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonProjectionDataLoader#loadInputFiles(ProjectionDataSet)}
   */
  @Test
  @DisplayName(
      "Test loadInputFiles(ProjectionDataSet) with 'ProjectionDataSet'; then return DataSetName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProjectionDataSet JsonProjectionDataLoader.loadInputFiles(ProjectionDataSet)"
  })
  void testLoadInputFilesWithProjectionDataSet_thenReturnDataSetNameIsNull()
      throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonProjectionDataLoader jsonProjectionDataLoader =
        new JsonProjectionDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());

    ProjectionDataSet descriptor = new ProjectionDataSet();
    descriptor.setData(new ArrayList<>());

    // Act
    ProjectionDataSet actualLoadInputFilesResult =
        jsonProjectionDataLoader.loadInputFiles(descriptor);

    // Assert
    assertNull(actualLoadInputFilesResult.getDataSetName());
    assertNull(actualLoadInputFilesResult.getDataSetShortName());
    assertNull(actualLoadInputFilesResult.getInputType());
  }
}
