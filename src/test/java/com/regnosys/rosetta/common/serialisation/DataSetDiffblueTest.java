package com.regnosys.rosetta.common.serialisation;

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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.serialisation.projectiondata.ProjectionDataSet;
import com.regnosys.rosetta.common.serialisation.reportdata.ReportDataItem;
import com.rosetta.model.lib.ModelReportId;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataSetDiffblueTest {
  /**
   * Test {@link DataSet#getDataSetShortName()}.
   *
   * <p>Method under test: {@link DataSet#getDataSetShortName()}
   */
  @Test
  @DisplayName("Test getDataSetShortName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataSet.getDataSetShortName()"})
  void testGetDataSetShortName() {
    // Arrange, Act and Assert
    assertNull(new ProjectionDataSet().getDataSetShortName());
  }

  /**
   * Test {@link DataSet#getDataSetName()}.
   *
   * <p>Method under test: {@link DataSet#getDataSetName()}
   */
  @Test
  @DisplayName("Test getDataSetName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataSet.getDataSetName()"})
  void testGetDataSetName() {
    // Arrange, Act and Assert
    assertNull(new ProjectionDataSet().getDataSetName());
  }

  /**
   * Test {@link DataSet#getInputType()}.
   *
   * <p>Method under test: {@link DataSet#getInputType()}
   */
  @Test
  @DisplayName("Test getInputType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataSet.getInputType()"})
  void testGetInputType() {
    // Arrange, Act and Assert
    assertNull(new ProjectionDataSet().getInputType());
  }

  /**
   * Test {@link DataSet#getExpectedType()}.
   *
   * <p>Method under test: {@link DataSet#getExpectedType()}
   */
  @Test
  @DisplayName("Test getExpectedType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DataSet.getExpectedType()"})
  void testGetExpectedType() {
    // Arrange, Act and Assert
    assertEquals(
        "com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        new ProjectionDataSet().getExpectedType());
  }

  /**
   * Test {@link DataSet#getData()}.
   *
   * <p>Method under test: {@link DataSet#getData()}
   */
  @Test
  @DisplayName("Test getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataSet.getData()"})
  void testGetData() {
    // Arrange, Act and Assert
    assertNull(new ProjectionDataSet().getData());
  }

  /**
   * Test {@link DataSet#equals(Object)}, and {@link DataSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProjectionDataSet projectionDataSet = new ProjectionDataSet();
    ProjectionDataSet projectionDataSet2 = new ProjectionDataSet();

    // Act and Assert
    assertEquals(projectionDataSet, projectionDataSet2);
    assertEquals(projectionDataSet.hashCode(), projectionDataSet2.hashCode());
  }

  /**
   * Test {@link DataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    ProjectionDataSet projectionDataSet =
        new ProjectionDataSet(
            "Data Set Name",
            "Data Set Short Name",
            "Input Type",
            applicableProjections,
            applicableReports,
            new ArrayList<>());

    // Act and Assert
    assertNotEquals(projectionDataSet, new ProjectionDataSet());
  }

  /**
   * Test {@link DataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProjectionDataSet projectionDataSet = new ProjectionDataSet();
    projectionDataSet.setData(new ArrayList<>());

    // Act and Assert
    assertNotEquals(projectionDataSet, new ProjectionDataSet());
  }

  /**
   * Test {@link DataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    ProjectionDataSet projectionDataSet =
        new ProjectionDataSet(
            null,
            "Data Set Short Name",
            "Input Type",
            applicableProjections,
            applicableReports,
            new ArrayList<>());

    // Act and Assert
    assertNotEquals(projectionDataSet, new ProjectionDataSet());
  }

  /**
   * Test {@link DataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    ProjectionDataSet projectionDataSet =
        new ProjectionDataSet(
            null, null, "Input Type", applicableProjections, applicableReports, new ArrayList<>());

    // Act and Assert
    assertNotEquals(projectionDataSet, new ProjectionDataSet());
  }

  /**
   * Test {@link DataSet#setData(List)}.
   *
   * <ul>
   *   <li>Given {@link ReportDataItem#ReportDataItem()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ReportDataItem#ReportDataItem()}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet#setData(List)}
   */
  @Test
  @DisplayName("Test setData(List); given ReportDataItem(); when ArrayList() add ReportDataItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataSet.setData(List)"})
  void testSetData_givenReportDataItem_whenArrayListAddReportDataItem() {
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
   * Test {@link DataSet#setData(List)}.
   *
   * <ul>
   *   <li>Given {@link ReportDataItem#ReportDataItem()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ReportDataItem#ReportDataItem()}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet#setData(List)}
   */
  @Test
  @DisplayName("Test setData(List); given ReportDataItem(); when ArrayList() add ReportDataItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataSet.setData(List)"})
  void testSetData_givenReportDataItem_whenArrayListAddReportDataItem2() {
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
   * Test {@link DataSet#setData(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DataSet#setData(List)}
   */
  @Test
  @DisplayName("Test setData(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataSet.setData(List)"})
  void testSetData_whenArrayList() {
    // Arrange
    ProjectionDataSet projectionDataSet = new ProjectionDataSet();
    ArrayList<ReportDataItem> data = new ArrayList<>();

    // Act
    projectionDataSet.setData(data);

    // Assert
    assertSame(data, projectionDataSet.getData());
  }
}
