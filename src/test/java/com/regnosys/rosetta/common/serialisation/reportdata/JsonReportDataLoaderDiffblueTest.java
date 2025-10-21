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

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.rosetta.model.lib.ModelReportId;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.management.loading.MLet;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JsonReportDataLoaderDiffblueTest {
  /**
   * Test {@link JsonReportDataLoader#loadInputFiles(ReportDataSet)} with {@code ReportDataSet}.
   * <p>
   * Method under test: {@link JsonReportDataLoader#loadInputFiles(ReportDataSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReportDataSet JsonReportDataLoader.loadInputFiles(ReportDataSet)"})
  public void testLoadInputFilesWithReportDataSet() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonReportDataLoader jsonReportDataLoader = new JsonReportDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ReportDataSet descriptor = new ReportDataSet("Data Set Name", "Input Type", applicableReports, new ArrayList<>());

    // Act and Assert
    assertEquals(descriptor, jsonReportDataLoader.loadInputFiles(descriptor));
  }

  /**
   * Test {@link JsonReportDataLoader#loadInputFiles(ReportDataSet)} with {@code ReportDataSet}.
   * <p>
   * Method under test: {@link JsonReportDataLoader#loadInputFiles(ReportDataSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReportDataSet JsonReportDataLoader.loadInputFiles(ReportDataSet)"})
  public void testLoadInputFilesWithReportDataSet2() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonReportDataLoader jsonReportDataLoader = new JsonReportDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ReportDataSet descriptor = new ReportDataSet("", "Input Type", applicableReports, new ArrayList<>());

    // Act and Assert
    assertEquals(descriptor, jsonReportDataLoader.loadInputFiles(descriptor));
  }

  /**
   * Test {@link JsonReportDataLoader#loadInputFiles(ReportDataSet)} with {@code ReportDataSet}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link ReportDataSet#ReportDataSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonReportDataLoader#loadInputFiles(ReportDataSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReportDataSet JsonReportDataLoader.loadInputFiles(ReportDataSet)"})
  public void testLoadInputFilesWithReportDataSet_givenArrayList_thenReturnReportDataSet()
      throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonReportDataLoader jsonReportDataLoader = new JsonReportDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());

    ReportDataSet descriptor = new ReportDataSet();
    descriptor.setData(new ArrayList<>());

    // Act and Assert
    assertEquals(descriptor, jsonReportDataLoader.loadInputFiles(descriptor));
  }

  /**
   * Test {@link JsonReportDataLoader#loadInputFiles(ReportDataSet)} with {@code ReportDataSet}.
   * <ul>
   *   <li>Then return Data is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonReportDataLoader#loadInputFiles(ReportDataSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReportDataSet JsonReportDataLoader.loadInputFiles(ReportDataSet)"})
  public void testLoadInputFilesWithReportDataSet_thenReturnDataIsArrayList() throws MalformedURLException {
    // Arrange
    MLet classLoader = new MLet();
    JsonMapper rosettaObjectMapper = JsonMapper.builder().findAndAddModules().build();
    URL descriptorPath = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri().toURL();
    JsonReportDataLoader jsonReportDataLoader = new JsonReportDataLoader(classLoader, rosettaObjectMapper,
        descriptorPath, new ArrayList<>());

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());

    // Act and Assert
    assertEquals(data,
        jsonReportDataLoader.loadInputFiles(new ReportDataSet("Data Set Name", "Input Type", new ArrayList<>(), data))
            .getData());
  }
}
