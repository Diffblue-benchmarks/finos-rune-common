package com.regnosys.rosetta.common.serialisation;

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
import com.regnosys.rosetta.common.serialisation.projectiondata.ProjectionDataSet;
import com.regnosys.rosetta.common.serialisation.reportdata.ReportDataItem;
import com.rosetta.model.lib.ModelReportId;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class DataSetDiffblueTest {
  /**
   * Method under test: {@link DataSet#getDataSetShortName()}
   */
  @Test
  public void testGetDataSetShortName() {
    // Arrange, Act and Assert
    assertNull((new ProjectionDataSet()).getDataSetShortName());
  }

  /**
   * Method under test: {@link DataSet#getDataSetName()}
   */
  @Test
  public void testGetDataSetName() {
    // Arrange, Act and Assert
    assertNull((new ProjectionDataSet()).getDataSetName());
  }

  /**
   * Method under test: {@link DataSet#getInputType()}
   */
  @Test
  public void testGetInputType() {
    // Arrange, Act and Assert
    assertNull((new ProjectionDataSet()).getInputType());
  }

  /**
   * Method under test: {@link DataSet#getExpectedType()}
   */
  @Test
  public void testGetExpectedType() {
    // Arrange, Act and Assert
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        (new ProjectionDataSet()).getExpectedType());
  }

  /**
   * Method under test: {@link DataSet#getData()}
   */
  @Test
  public void testGetData() {
    // Arrange, Act and Assert
    assertNull((new ProjectionDataSet()).getData());
  }

  /**
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProjectionDataSet projectionDataSet = new ProjectionDataSet();
    ProjectionDataSet projectionDataSet2 = new ProjectionDataSet();

    // Act and Assert
    assertEquals(projectionDataSet, projectionDataSet2);
    int expectedHashCodeResult = projectionDataSet.hashCode();
    assertEquals(expectedHashCodeResult, projectionDataSet2.hashCode());
  }

  /**
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProjectionDataSet projectionDataSet = new ProjectionDataSet();

    // Act and Assert
    assertEquals(projectionDataSet, projectionDataSet);
    int expectedHashCodeResult = projectionDataSet.hashCode();
    assertEquals(expectedHashCodeResult, projectionDataSet.hashCode());
  }

  /**
   * Method under test: {@link DataSet#setData(List)}
   */
  @Test
  public void testSetData() {
    // Arrange
    ProjectionDataSet projectionDataSet = new ProjectionDataSet();
    ArrayList<ReportDataItem> data = new ArrayList<>();

    // Act
    projectionDataSet.setData(data);

    // Assert
    assertSame(data, projectionDataSet.getData());
  }

  /**
   * Method under test: {@link DataSet#setData(List)}
   */
  @Test
  public void testSetData2() {
    // Arrange
    ProjectionDataSet projectionDataSet = new ProjectionDataSet();

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());

    // Act
    projectionDataSet.setData(data);

    // Assert
    assertSame(data, projectionDataSet.getData());
  }

  /**
   * Method under test: {@link DataSet#setData(List)}
   */
  @Test
  public void testSetData3() {
    // Arrange
    ProjectionDataSet projectionDataSet = new ProjectionDataSet();

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());
    data.add(new ReportDataItem());

    // Act
    projectionDataSet.setData(data);

    // Assert
    assertSame(data, projectionDataSet.getData());
  }

  /**
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ProjectionDataSet projectionDataSet = new ProjectionDataSet("Data Set Name", "Data Set Short Name", "Input Type",
        applicableProjections, applicableReports, new ArrayList<>());

    // Act and Assert
    assertNotEquals(projectionDataSet, new ProjectionDataSet());
  }

  /**
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProjectionDataSet projectionDataSet = new ProjectionDataSet();
    projectionDataSet.setData(new ArrayList<>());

    // Act and Assert
    assertNotEquals(projectionDataSet, new ProjectionDataSet());
  }

  /**
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ProjectionDataSet projectionDataSet = new ProjectionDataSet(null, "Data Set Short Name", "Input Type",
        applicableProjections, applicableReports, new ArrayList<>());

    // Act and Assert
    assertNotEquals(projectionDataSet, new ProjectionDataSet());
  }

  /**
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ProjectionDataSet projectionDataSet = new ProjectionDataSet(null, null, "Input Type", applicableProjections,
        applicableReports, new ArrayList<>());

    // Act and Assert
    assertNotEquals(projectionDataSet, new ProjectionDataSet());
  }

  /**
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProjectionDataSet(), null);
  }

  /**
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProjectionDataSet(), "Different type to DataSet");
  }
}
