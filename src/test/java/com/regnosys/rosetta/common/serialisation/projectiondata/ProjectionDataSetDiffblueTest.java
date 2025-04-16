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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.serialisation.reportdata.ReportDataItem;
import com.rosetta.model.lib.ModelReportId;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProjectionDataSetDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProjectionDataSet#ProjectionDataSet()}
   *   <li>{@link ProjectionDataSet#toString()}
   *   <li>{@link ProjectionDataSet#getApplicableProjections()}
   *   <li>{@link ProjectionDataSet#getApplicableReports()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProjectionDataSet.<init>()", "List ProjectionDataSet.getApplicableProjections()",
      "List ProjectionDataSet.getApplicableReports()", "String ProjectionDataSet.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    ProjectionDataSet actualProjectionDataSet = new ProjectionDataSet();
    String actualToStringResult = actualProjectionDataSet.toString();
    List<String> actualApplicableProjections = actualProjectionDataSet.getApplicableProjections();
    List<ModelReportId> actualApplicableReports = actualProjectionDataSet.getApplicableReports();

    // Assert
    assertEquals("ProjectionDataSet[dataSetName='null', inputType='null', expectedType='com.regnosys.rosetta.common"
        + ".serialisation.reportdata.ExpectedResult', applicableReports=null, applicableProjections=null,"
        + " data=null]", actualToStringResult);
    assertNull(actualProjectionDataSet.getDataSetName());
    assertNull(actualProjectionDataSet.getDataSetShortName());
    assertNull(actualProjectionDataSet.getInputType());
    assertNull(actualProjectionDataSet.getData());
    assertNull(actualApplicableReports);
    assertNull(actualApplicableProjections);
  }

  /**
   * Test {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProjectionDataSet.<init>(String, String, String, List, List, List)"})
  public void testNewProjectionDataSet_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    applicableProjections.add("42");
    applicableProjections.add("foo");
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    // Act
    ProjectionDataSet actualProjectionDataSet = new ProjectionDataSet("Data Set Name", "Data Set Short Name",
        "Input Type", applicableProjections, applicableReports, new ArrayList<>());

    // Assert
    assertEquals("Data Set Short Name", actualProjectionDataSet.getDataSetShortName());
    assertTrue(actualProjectionDataSet.getData().isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableReports().isEmpty());
    assertSame(applicableProjections, actualProjectionDataSet.getApplicableProjections());
  }

  /**
   * Test {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return ApplicableProjections is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProjectionDataSet.<init>(String, String, String, List, List, List)"})
  public void testNewProjectionDataSet_givenFoo_thenReturnApplicableProjectionsIsArrayList() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    applicableProjections.add("foo");
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    // Act
    ProjectionDataSet actualProjectionDataSet = new ProjectionDataSet("Data Set Name", "Data Set Short Name",
        "Input Type", applicableProjections, applicableReports, new ArrayList<>());

    // Assert
    assertEquals("Data Set Short Name", actualProjectionDataSet.getDataSetShortName());
    assertTrue(actualProjectionDataSet.getData().isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableReports().isEmpty());
    assertSame(applicableProjections, actualProjectionDataSet.getApplicableProjections());
  }

  /**
   * Test {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}.
   * <ul>
   *   <li>Given {@link ReportDataItem#ReportDataItem()}.</li>
   *   <li>Then return Data is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProjectionDataSet.<init>(String, String, String, List, List, List)"})
  public void testNewProjectionDataSet_givenReportDataItem_thenReturnDataIsArrayList() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());

    // Act and Assert
    assertSame(data, (new ProjectionDataSet("Data Set Name", "Data Set Short Name", "Input Type", applicableProjections,
        applicableReports, data)).getData());
  }

  /**
   * Test {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}.
   * <ul>
   *   <li>Given {@link ReportDataItem#ReportDataItem()}.</li>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProjectionDataSet.<init>(String, String, String, List, List, List)"})
  public void testNewProjectionDataSet_givenReportDataItem_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());
    ReportDataItem reportDataItem = new ReportDataItem();
    data.add(reportDataItem);

    // Act and Assert
    List<ReportDataItem> data2 = (new ProjectionDataSet("Data Set Name", "Data Set Short Name", "Input Type",
        applicableProjections, applicableReports, data)).getData();
    assertEquals(2, data2.size());
    assertSame(reportDataItem, data2.get(1));
  }

  /**
   * Test {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}.
   * <ul>
   *   <li>When {@code Data Set Short Name}.</li>
   *   <li>Then return {@code Data Set Short Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProjectionDataSet.<init>(String, String, String, List, List, List)"})
  public void testNewProjectionDataSet_whenDataSetShortName_thenReturnDataSetShortName() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    // Act
    ProjectionDataSet actualProjectionDataSet = new ProjectionDataSet("Data Set Name", "Data Set Short Name",
        "Input Type", applicableProjections, applicableReports, new ArrayList<>());

    // Assert
    assertEquals("Data Set Short Name", actualProjectionDataSet.getDataSetShortName());
    assertTrue(actualProjectionDataSet.getData().isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableProjections().isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableReports().isEmpty());
  }

  /**
   * Test {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return DataSetShortName is {@code Data Set Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProjectionDataSet.<init>(String, String, String, List, List, List)"})
  public void testNewProjectionDataSet_whenEmptyString_thenReturnDataSetShortNameIsDataSetName() {
    // Arrange and Act
    ProjectionDataSet actualProjectionDataSet = new ProjectionDataSet("Data Set Name", "", "Input Type", null, null,
        new ArrayList<>());

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetShortName());
    assertTrue(actualProjectionDataSet.getData().isEmpty());
    List<String> applicableProjections = actualProjectionDataSet.getApplicableProjections();
    assertTrue(applicableProjections.isEmpty());
    assertSame(applicableProjections, actualProjectionDataSet.getApplicableReports());
  }

  /**
   * Test {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return DataSetShortName is {@code Data Set Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProjectionDataSet.<init>(String, String, String, List, List, List)"})
  public void testNewProjectionDataSet_whenNull_thenReturnDataSetShortNameIsDataSetName() {
    // Arrange and Act
    ProjectionDataSet actualProjectionDataSet = new ProjectionDataSet("Data Set Name", null, "Input Type", null, null,
        new ArrayList<>());

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetShortName());
    assertTrue(actualProjectionDataSet.getData().isEmpty());
    List<String> applicableProjections = actualProjectionDataSet.getApplicableProjections();
    assertTrue(applicableProjections.isEmpty());
    assertSame(applicableProjections, actualProjectionDataSet.getApplicableReports());
  }

  /**
   * Test {@link ProjectionDataSet#equals(Object)}, and {@link ProjectionDataSet#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProjectionDataSet#equals(Object)}
   *   <li>{@link ProjectionDataSet#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProjectionDataSet.equals(Object)", "int ProjectionDataSet.hashCode()"})
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
   * Test {@link ProjectionDataSet#equals(Object)}, and {@link ProjectionDataSet#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProjectionDataSet#equals(Object)}
   *   <li>{@link ProjectionDataSet#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProjectionDataSet.equals(Object)", "int ProjectionDataSet.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProjectionDataSet projectionDataSet = new ProjectionDataSet();

    // Act and Assert
    assertEquals(projectionDataSet, projectionDataSet);
    int expectedHashCodeResult = projectionDataSet.hashCode();
    assertEquals(expectedHashCodeResult, projectionDataSet.hashCode());
  }

  /**
   * Test {@link ProjectionDataSet#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionDataSet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProjectionDataSet.equals(Object)", "int ProjectionDataSet.hashCode()"})
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
   * Test {@link ProjectionDataSet#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionDataSet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProjectionDataSet.equals(Object)", "int ProjectionDataSet.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProjectionDataSet(), null);
  }

  /**
   * Test {@link ProjectionDataSet#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProjectionDataSet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProjectionDataSet.equals(Object)", "int ProjectionDataSet.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProjectionDataSet(), "Different type to ProjectionDataSet");
  }
}
