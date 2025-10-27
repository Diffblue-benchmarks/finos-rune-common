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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.regnosys.rosetta.common.serialisation.projectiondata.ProjectionDataSet;
import com.rosetta.model.lib.ModelReportId;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ReportDataSetDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReportDataSet#equals(Object)}
   *   <li>{@link ReportDataSet#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReportDataSet reportDataSet = new ReportDataSet();
    ReportDataSet reportDataSet2 = new ReportDataSet();

    // Act and Assert
    assertEquals(reportDataSet, reportDataSet2);
    int expectedHashCodeResult = reportDataSet.hashCode();
    assertEquals(expectedHashCodeResult, reportDataSet2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReportDataSet#equals(Object)}
   *   <li>{@link ReportDataSet#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReportDataSet reportDataSet = new ReportDataSet();

    // Act and Assert
    assertEquals(reportDataSet, reportDataSet);
    int expectedHashCodeResult = reportDataSet.hashCode();
    assertEquals(expectedHashCodeResult, reportDataSet.hashCode());
  }

  /**
   * Method under test: {@link ReportDataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ReportDataSet reportDataSet = new ReportDataSet("Data Set Name", "Input Type", applicableReports,
        new ArrayList<>());

    // Act and Assert
    assertNotEquals(reportDataSet, new ReportDataSet());
  }

  /**
   * Method under test: {@link ReportDataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportDataSet(), mock(ProjectionDataSet.class));
  }

  /**
   * Method under test: {@link ReportDataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportDataSet(), null);
  }

  /**
   * Method under test: {@link ReportDataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportDataSet(), "Different type to ReportDataSet");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReportDataSet#ReportDataSet()}
   *   <li>{@link ReportDataSet#toString()}
   *   <li>{@link ReportDataSet#getApplicableReports()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ReportDataSet actualReportDataSet = new ReportDataSet();
    String actualToStringResult = actualReportDataSet.toString();
    List<ModelReportId> actualApplicableReports = actualReportDataSet.getApplicableReports();

    // Assert
    assertEquals(
        "ReportDataSet[dataSetName='null', inputType='null', expectedType='com.regnosys.rosetta.common.serialisation"
            + ".reportdata.ExpectedResult', applicableReports=null, data=null]",
        actualToStringResult);
    assertNull(actualReportDataSet.getDataSetName());
    assertNull(actualReportDataSet.getDataSetShortName());
    assertNull(actualReportDataSet.getInputType());
    assertNull(actualReportDataSet.getData());
    assertNull(actualApplicableReports);
  }

  /**
   * Method under test:
   * {@link ReportDataSet#ReportDataSet(String, String, List, List)}
   */
  @Test
  public void testNewReportDataSet() {
    // Arrange
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ArrayList<ReportDataItem> data = new ArrayList<>();

    // Act
    ReportDataSet actualReportDataSet = new ReportDataSet("Data Set Name", "Input Type", applicableReports, data);

    // Assert
    assertEquals("Data Set Name", actualReportDataSet.getDataSetName());
    assertEquals("Data Set Name", actualReportDataSet.getDataSetShortName());
    assertEquals("Input Type", actualReportDataSet.getInputType());
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualReportDataSet.getExpectedType());
    List<ReportDataItem> data2 = actualReportDataSet.getData();
    assertTrue(data2.isEmpty());
    List<ModelReportId> applicableReports2 = actualReportDataSet.getApplicableReports();
    assertTrue(applicableReports2.isEmpty());
    assertSame(data, data2);
    assertSame(applicableReports, applicableReports2);
  }

  /**
   * Method under test:
   * {@link ReportDataSet#ReportDataSet(String, String, List, List)}
   */
  @Test
  public void testNewReportDataSet2() {
    // Arrange
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ArrayList<ReportDataItem> data = new ArrayList<>();

    // Act
    ReportDataSet actualReportDataSet = new ReportDataSet(null, "Input Type", applicableReports, data);

    // Assert
    assertEquals("Input Type", actualReportDataSet.getInputType());
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualReportDataSet.getExpectedType());
    assertNull(actualReportDataSet.getDataSetName());
    assertNull(actualReportDataSet.getDataSetShortName());
    List<ReportDataItem> data2 = actualReportDataSet.getData();
    assertTrue(data2.isEmpty());
    List<ModelReportId> applicableReports2 = actualReportDataSet.getApplicableReports();
    assertTrue(applicableReports2.isEmpty());
    assertSame(data, data2);
    assertSame(applicableReports, applicableReports2);
  }

  /**
   * Method under test:
   * {@link ReportDataSet#ReportDataSet(String, String, List, List)}
   */
  @Test
  public void testNewReportDataSet3() {
    // Arrange
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ArrayList<ReportDataItem> data = new ArrayList<>();

    // Act
    ReportDataSet actualReportDataSet = new ReportDataSet("", "Input Type", applicableReports, data);

    // Assert
    assertEquals("", actualReportDataSet.getDataSetName());
    assertEquals("", actualReportDataSet.getDataSetShortName());
    assertEquals("Input Type", actualReportDataSet.getInputType());
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualReportDataSet.getExpectedType());
    List<ReportDataItem> data2 = actualReportDataSet.getData();
    assertTrue(data2.isEmpty());
    List<ModelReportId> applicableReports2 = actualReportDataSet.getApplicableReports();
    assertTrue(applicableReports2.isEmpty());
    assertSame(data, data2);
    assertSame(applicableReports, applicableReports2);
  }

  /**
   * Method under test:
   * {@link ReportDataSet#ReportDataSet(String, String, List, List)}
   */
  @Test
  public void testNewReportDataSet4() {
    // Arrange
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());

    // Act
    ReportDataSet actualReportDataSet = new ReportDataSet("Data Set Name", "Input Type", applicableReports, data);

    // Assert
    assertEquals("Data Set Name", actualReportDataSet.getDataSetName());
    assertEquals("Data Set Name", actualReportDataSet.getDataSetShortName());
    assertEquals("Input Type", actualReportDataSet.getInputType());
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualReportDataSet.getExpectedType());
    List<ModelReportId> applicableReports2 = actualReportDataSet.getApplicableReports();
    assertTrue(applicableReports2.isEmpty());
    assertSame(data, actualReportDataSet.getData());
    assertSame(applicableReports, applicableReports2);
  }

  /**
   * Method under test:
   * {@link ReportDataSet#ReportDataSet(String, String, List, List)}
   */
  @Test
  public void testNewReportDataSet5() {
    // Arrange
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());
    data.add(new ReportDataItem());

    // Act
    ReportDataSet actualReportDataSet = new ReportDataSet("Data Set Name", "Input Type", applicableReports, data);

    // Assert
    assertEquals("Data Set Name", actualReportDataSet.getDataSetName());
    assertEquals("Data Set Name", actualReportDataSet.getDataSetShortName());
    assertEquals("Input Type", actualReportDataSet.getInputType());
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualReportDataSet.getExpectedType());
    List<ModelReportId> applicableReports2 = actualReportDataSet.getApplicableReports();
    assertTrue(applicableReports2.isEmpty());
    assertSame(data, actualReportDataSet.getData());
    assertSame(applicableReports, applicableReports2);
  }

  /**
   * Method under test:
   * {@link ReportDataSet#ReportDataSet(String, String, List, List)}
   */
  @Test
  public void testNewReportDataSet6() {
    // Arrange
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    applicableReports.add(null);
    ArrayList<ReportDataItem> data = new ArrayList<>();

    // Act
    ReportDataSet actualReportDataSet = new ReportDataSet("Data Set Name", "Input Type", applicableReports, data);

    // Assert
    assertEquals("Data Set Name", actualReportDataSet.getDataSetName());
    assertEquals("Data Set Name", actualReportDataSet.getDataSetShortName());
    assertEquals("Input Type", actualReportDataSet.getInputType());
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualReportDataSet.getExpectedType());
    List<ModelReportId> applicableReports2 = actualReportDataSet.getApplicableReports();
    assertEquals(1, applicableReports2.size());
    assertNull(applicableReports2.get(0));
    List<ReportDataItem> data2 = actualReportDataSet.getData();
    assertTrue(data2.isEmpty());
    assertSame(data, data2);
    assertSame(applicableReports, applicableReports2);
  }
}
