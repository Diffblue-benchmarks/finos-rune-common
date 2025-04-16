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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.serialisation.projectiondata.ProjectionDataSet;
import com.regnosys.rosetta.common.serialisation.reportdata.ReportDataItem;
import com.rosetta.model.lib.ModelReportId;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DataSetDiffblueTest {
  /**
   * Test {@link DataSet#getDataSetShortName()}.
   * <p>
   * Method under test: {@link DataSet#getDataSetShortName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataSet.getDataSetShortName()"})
  public void testGetDataSetShortName() {
    // Arrange, Act and Assert
    assertNull((new ProjectionDataSet()).getDataSetShortName());
  }

  /**
   * Test {@link DataSet#getDataSetName()}.
   * <p>
   * Method under test: {@link DataSet#getDataSetName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataSet.getDataSetName()"})
  public void testGetDataSetName() {
    // Arrange, Act and Assert
    assertNull((new ProjectionDataSet()).getDataSetName());
  }

  /**
   * Test {@link DataSet#getInputType()}.
   * <p>
   * Method under test: {@link DataSet#getInputType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataSet.getInputType()"})
  public void testGetInputType() {
    // Arrange, Act and Assert
    assertNull((new ProjectionDataSet()).getInputType());
  }

  /**
   * Test {@link DataSet#getExpectedType()}.
   * <p>
   * Method under test: {@link DataSet#getExpectedType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DataSet.getExpectedType()"})
  public void testGetExpectedType() {
    // Arrange, Act and Assert
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        (new ProjectionDataSet()).getExpectedType());
  }

  /**
   * Test {@link DataSet#getData()}.
   * <p>
   * Method under test: {@link DataSet#getData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DataSet.getData()"})
  public void testGetData() {
    // Arrange, Act and Assert
    assertNull((new ProjectionDataSet()).getData());
  }

  /**
   * Test {@link DataSet#equals(Object)}, and {@link DataSet#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
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
   * Test {@link DataSet#equals(Object)}, and {@link DataSet#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProjectionDataSet projectionDataSet = new ProjectionDataSet();

    // Act and Assert
    assertEquals(projectionDataSet, projectionDataSet);
    int expectedHashCodeResult = projectionDataSet.hashCode();
    assertEquals(expectedHashCodeResult, projectionDataSet.hashCode());
  }

  /**
   * Test {@link DataSet#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
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
   * Test {@link DataSet#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProjectionDataSet projectionDataSet = new ProjectionDataSet();
    projectionDataSet.setData(new ArrayList<>());

    // Act and Assert
    assertNotEquals(projectionDataSet, new ProjectionDataSet());
  }

  /**
   * Test {@link DataSet#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
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
   * Test {@link DataSet#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
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
   * Test {@link DataSet#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProjectionDataSet(), null);
  }

  /**
   * Test {@link DataSet#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataSet.equals(Object)", "int DataSet.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProjectionDataSet(), "Different type to DataSet");
  }

  /**
   * Test {@link DataSet#setData(List)}.
   * <ul>
   *   <li>Given {@link ReportDataItem#ReportDataItem()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ReportDataItem#ReportDataItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#setData(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataSet.setData(List)"})
  public void testSetData_givenReportDataItem_whenArrayListAddReportDataItem() {
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
   * <ul>
   *   <li>Given {@link ReportDataItem#ReportDataItem()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ReportDataItem#ReportDataItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#setData(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataSet.setData(List)"})
  public void testSetData_givenReportDataItem_whenArrayListAddReportDataItem2() {
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataSet#setData(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataSet.setData(List)"})
  public void testSetData_whenArrayList() {
    // Arrange
    ProjectionDataSet projectionDataSet = new ProjectionDataSet();
    ArrayList<ReportDataItem> data = new ArrayList<>();

    // Act
    projectionDataSet.setData(data);

    // Assert
    assertSame(data, projectionDataSet.getData());
  }
}
