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
import static org.mockito.Mockito.mock;
import com.regnosys.rosetta.common.serialisation.reportdata.ReportDataItem;
import com.regnosys.rosetta.common.serialisation.reportdata.ReportDataSet;
import com.rosetta.model.lib.ModelReportId;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.impl.EStoreEObjectImpl;
import org.junit.Test;

public class ProjectionDataSetDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProjectionDataSet#equals(Object)}
   *   <li>{@link ProjectionDataSet#hashCode()}
   * </ul>
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
   * Methods under test:
   * <ul>
   *   <li>{@link ProjectionDataSet#equals(Object)}
   *   <li>{@link ProjectionDataSet#hashCode()}
   * </ul>
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
   * Method under test: {@link ProjectionDataSet#equals(Object)}
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
   * Method under test: {@link ProjectionDataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ProjectionDataSet(), mock(ReportDataSet.class));
  }

  /**
   * Method under test: {@link ProjectionDataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProjectionDataSet(), null);
  }

  /**
   * Method under test: {@link ProjectionDataSet#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProjectionDataSet(), "Different type to ProjectionDataSet");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProjectionDataSet#ProjectionDataSet()}
   *   <li>{@link ProjectionDataSet#toString()}
   *   <li>{@link ProjectionDataSet#getApplicableProjections()}
   *   <li>{@link ProjectionDataSet#getApplicableReports()}
   * </ul>
   */
  @Test
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
   * Method under test:
   * {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}
   */
  @Test
  public void testNewProjectionDataSet() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ArrayList<ReportDataItem> data = new ArrayList<>();

    // Act
    ProjectionDataSet actualProjectionDataSet = new ProjectionDataSet("Data Set Name", "Data Set Short Name",
        "Input Type", applicableProjections, applicableReports, data);

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetName());
    assertEquals("Data Set Short Name", actualProjectionDataSet.getDataSetShortName());
    assertEquals("Input Type", actualProjectionDataSet.getInputType());
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualProjectionDataSet.getExpectedType());
    List<ReportDataItem> data2 = actualProjectionDataSet.getData();
    assertTrue(data2.isEmpty());
    List<String> applicableProjections2 = actualProjectionDataSet.getApplicableProjections();
    assertTrue(applicableProjections2.isEmpty());
    List<ModelReportId> applicableReports2 = actualProjectionDataSet.getApplicableReports();
    assertTrue(applicableReports2.isEmpty());
    assertSame(data, data2);
    assertSame(applicableProjections, applicableProjections2);
    assertSame(applicableReports, applicableReports2);
  }

  /**
   * Method under test:
   * {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}
   */
  @Test
  public void testNewProjectionDataSet2() {
    // Arrange
    ArrayList<ReportDataItem> data = new ArrayList<>();

    // Act
    ProjectionDataSet actualProjectionDataSet = new ProjectionDataSet("Data Set Name", null, "Input Type", null, null,
        data);

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetName());
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetShortName());
    assertEquals("Input Type", actualProjectionDataSet.getInputType());
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualProjectionDataSet.getExpectedType());
    List<ReportDataItem> data2 = actualProjectionDataSet.getData();
    assertTrue(data2.isEmpty());
    List<String> applicableProjections = actualProjectionDataSet.getApplicableProjections();
    assertTrue(applicableProjections.isEmpty());
    assertSame(data, data2);
    assertSame(applicableProjections, actualProjectionDataSet.getApplicableReports());
  }

  /**
   * Method under test:
   * {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}
   */
  @Test
  public void testNewProjectionDataSet3() {
    // Arrange
    ArrayList<ReportDataItem> data = new ArrayList<>();

    // Act
    ProjectionDataSet actualProjectionDataSet = new ProjectionDataSet("Data Set Name", "", "Input Type", null, null,
        data);

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetName());
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetShortName());
    assertEquals("Input Type", actualProjectionDataSet.getInputType());
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualProjectionDataSet.getExpectedType());
    List<ReportDataItem> data2 = actualProjectionDataSet.getData();
    assertTrue(data2.isEmpty());
    List<String> applicableProjections = actualProjectionDataSet.getApplicableProjections();
    assertTrue(applicableProjections.isEmpty());
    assertSame(data, data2);
    assertSame(applicableProjections, actualProjectionDataSet.getApplicableReports());
  }

  /**
   * Method under test:
   * {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}
   */
  @Test
  public void testNewProjectionDataSet4() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    applicableProjections.add("foo");
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ArrayList<ReportDataItem> data = new ArrayList<>();

    // Act
    ProjectionDataSet actualProjectionDataSet = new ProjectionDataSet("Data Set Name", "Data Set Short Name",
        "Input Type", applicableProjections, applicableReports, data);

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetName());
    assertEquals("Data Set Short Name", actualProjectionDataSet.getDataSetShortName());
    assertEquals("Input Type", actualProjectionDataSet.getInputType());
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualProjectionDataSet.getExpectedType());
    List<String> applicableProjections2 = actualProjectionDataSet.getApplicableProjections();
    assertEquals(1, applicableProjections2.size());
    assertEquals("foo", applicableProjections2.get(0));
    List<ReportDataItem> data2 = actualProjectionDataSet.getData();
    assertTrue(data2.isEmpty());
    List<ModelReportId> applicableReports2 = actualProjectionDataSet.getApplicableReports();
    assertTrue(applicableReports2.isEmpty());
    assertSame(data, data2);
    assertSame(applicableProjections, applicableProjections2);
    assertSame(applicableReports, applicableReports2);
  }

  /**
   * Method under test:
   * {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}
   */
  @Test
  public void testNewProjectionDataSet5() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    applicableProjections.add("42");
    applicableProjections.add("foo");
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ArrayList<ReportDataItem> data = new ArrayList<>();

    // Act
    ProjectionDataSet actualProjectionDataSet = new ProjectionDataSet("Data Set Name", "Data Set Short Name",
        "Input Type", applicableProjections, applicableReports, data);

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetName());
    assertEquals("Data Set Short Name", actualProjectionDataSet.getDataSetShortName());
    assertEquals("Input Type", actualProjectionDataSet.getInputType());
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualProjectionDataSet.getExpectedType());
    List<ReportDataItem> data2 = actualProjectionDataSet.getData();
    assertTrue(data2.isEmpty());
    List<ModelReportId> applicableReports2 = actualProjectionDataSet.getApplicableReports();
    assertTrue(applicableReports2.isEmpty());
    assertSame(data, data2);
    assertSame(applicableProjections, actualProjectionDataSet.getApplicableProjections());
    assertSame(applicableReports, applicableReports2);
  }

  /**
   * Method under test:
   * {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}
   */
  @Test
  public void testNewProjectionDataSet6() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());

    // Act
    ProjectionDataSet actualProjectionDataSet = new ProjectionDataSet("Data Set Name", "Data Set Short Name",
        "Input Type", applicableProjections, applicableReports, data);

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetName());
    assertEquals("Data Set Short Name", actualProjectionDataSet.getDataSetShortName());
    assertEquals("Input Type", actualProjectionDataSet.getInputType());
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualProjectionDataSet.getExpectedType());
    List<String> applicableProjections2 = actualProjectionDataSet.getApplicableProjections();
    assertTrue(applicableProjections2.isEmpty());
    List<ModelReportId> applicableReports2 = actualProjectionDataSet.getApplicableReports();
    assertTrue(applicableReports2.isEmpty());
    assertSame(data, actualProjectionDataSet.getData());
    assertSame(applicableProjections, applicableProjections2);
    assertSame(applicableReports, applicableReports2);
  }

  /**
   * Method under test:
   * {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}
   */
  @Test
  public void testNewProjectionDataSet7() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());
    data.add(new ReportDataItem());

    // Act
    ProjectionDataSet actualProjectionDataSet = new ProjectionDataSet("Data Set Name", "Data Set Short Name",
        "Input Type", applicableProjections, applicableReports, data);

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetName());
    assertEquals("Data Set Short Name", actualProjectionDataSet.getDataSetShortName());
    assertEquals("Input Type", actualProjectionDataSet.getInputType());
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualProjectionDataSet.getExpectedType());
    List<String> applicableProjections2 = actualProjectionDataSet.getApplicableProjections();
    assertTrue(applicableProjections2.isEmpty());
    List<ModelReportId> applicableReports2 = actualProjectionDataSet.getApplicableReports();
    assertTrue(applicableReports2.isEmpty());
    assertSame(data, actualProjectionDataSet.getData());
    assertSame(applicableProjections, applicableProjections2);
    assertSame(applicableReports, applicableReports2);
  }

  /**
   * Method under test:
   * {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}
   */
  @Test
  public void testNewProjectionDataSet8() {
    // Arrange
    EStoreEObjectImpl.BasicEStoreEList<String> applicableProjections = mock(EStoreEObjectImpl.BasicEStoreEList.class);
    ArrayList<ReportDataItem> data = new ArrayList<>();

    // Act
    ProjectionDataSet actualProjectionDataSet = new ProjectionDataSet("Data Set Name", null, "Input Type",
        applicableProjections, null, data);

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetName());
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetShortName());
    assertEquals("Input Type", actualProjectionDataSet.getInputType());
    assertEquals("com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualProjectionDataSet.getExpectedType());
    List<ReportDataItem> data2 = actualProjectionDataSet.getData();
    assertTrue(data2.isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableReports().isEmpty());
    assertSame(data, data2);
    assertSame(applicableProjections, actualProjectionDataSet.getApplicableProjections());
  }
}
