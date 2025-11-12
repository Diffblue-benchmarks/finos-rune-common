package com.regnosys.rosetta.common.serialisation.reportdata;

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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.rosetta.model.lib.ModelReportId;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.management.loading.MLet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JsonReportDataLoaderDiffblueTest {
  /**
   * Test {@link JsonReportDataLoader#loadInputFiles(ReportDataSet)} with {@code ReportDataSet}.
   *
   * <p>Method under test: {@link JsonReportDataLoader#loadInputFiles(ReportDataSet)}
   */
  @Test
  @DisplayName("Test loadInputFiles(ReportDataSet) with 'ReportDataSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportDataSet JsonReportDataLoader.loadInputFiles(ReportDataSet)"})
  void testLoadInputFilesWithReportDataSet() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonReportDataLoader jsonReportDataLoader =
        new JsonReportDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ReportDataSet descriptor =
        new ReportDataSet("", "Input Type", applicableReports, new ArrayList<>());

    // Act
    ReportDataSet actualLoadInputFilesResult = jsonReportDataLoader.loadInputFiles(descriptor);

    // Assert
    assertEquals(descriptor, actualLoadInputFilesResult);
  }

  /**
   * Test {@link JsonReportDataLoader#loadInputFiles(ReportDataSet)} with {@code ReportDataSet}.
   *
   * <p>Method under test: {@link JsonReportDataLoader#loadInputFiles(ReportDataSet)}
   */
  @Test
  @DisplayName("Test loadInputFiles(ReportDataSet) with 'ReportDataSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportDataSet JsonReportDataLoader.loadInputFiles(ReportDataSet)"})
  void testLoadInputFilesWithReportDataSet2() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonReportDataLoader jsonReportDataLoader =
        new JsonReportDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ReportDataSet descriptor =
        new ReportDataSet(null, "Input Type", applicableReports, new ArrayList<>());

    // Act
    ReportDataSet actualLoadInputFilesResult = jsonReportDataLoader.loadInputFiles(descriptor);

    // Assert
    assertEquals(descriptor, actualLoadInputFilesResult);
  }

  /**
   * Test {@link JsonReportDataLoader#loadInputFiles(ReportDataSet)} with {@code ReportDataSet}.
   *
   * <p>Method under test: {@link JsonReportDataLoader#loadInputFiles(ReportDataSet)}
   */
  @Test
  @DisplayName("Test loadInputFiles(ReportDataSet) with 'ReportDataSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportDataSet JsonReportDataLoader.loadInputFiles(ReportDataSet)"})
  void testLoadInputFilesWithReportDataSet3() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonReportDataLoader jsonReportDataLoader =
        new JsonReportDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ReportDataSet descriptor =
        new ReportDataSet("Data Set Name", "Input Type", applicableReports, new ArrayList<>());

    // Act
    ReportDataSet actualLoadInputFilesResult = jsonReportDataLoader.loadInputFiles(descriptor);

    // Assert
    assertEquals(descriptor, actualLoadInputFilesResult);
  }

  /**
   * Test {@link JsonReportDataLoader#loadInputFiles(ReportDataSet)} with {@code ReportDataSet}.
   *
   * <ul>
   *   <li>Then return Data is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonReportDataLoader#loadInputFiles(ReportDataSet)}
   */
  @Test
  @DisplayName(
      "Test loadInputFiles(ReportDataSet) with 'ReportDataSet'; then return Data is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportDataSet JsonReportDataLoader.loadInputFiles(ReportDataSet)"})
  void testLoadInputFilesWithReportDataSet_thenReturnDataIsArrayList()
      throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath =
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();

    JsonReportDataLoader jsonReportDataLoader =
        new JsonReportDataLoader(
            classLoader, rosettaObjectMapper, descriptorPath, new ArrayList<>());

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());
    ReportDataSet descriptor =
        new ReportDataSet("Data Set Name", "Input Type", new ArrayList<>(), data);

    // Act
    ReportDataSet actualLoadInputFilesResult = jsonReportDataLoader.loadInputFiles(descriptor);

    // Assert
    assertEquals(data, actualLoadInputFilesResult.getData());
  }
}
