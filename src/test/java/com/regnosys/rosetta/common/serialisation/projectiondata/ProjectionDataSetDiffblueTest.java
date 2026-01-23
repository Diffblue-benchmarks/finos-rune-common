package com.regnosys.rosetta.common.serialisation.projectiondata;

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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.serialisation.reportdata.ReportDataItem;
import com.rosetta.model.lib.ModelReportId;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProjectionDataSetDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProjectionDataSet#ProjectionDataSet()}
   *   <li>{@link ProjectionDataSet#toString()}
   *   <li>{@link ProjectionDataSet#getApplicableProjections()}
   *   <li>{@link ProjectionDataSet#getApplicableReports()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProjectionDataSet.<init>()",
    "List ProjectionDataSet.getApplicableProjections()",
    "List ProjectionDataSet.getApplicableReports()",
    "String ProjectionDataSet.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ProjectionDataSet actualProjectionDataSet = new ProjectionDataSet();
    String actualToStringResult = actualProjectionDataSet.toString();
    List<String> actualApplicableProjections = actualProjectionDataSet.getApplicableProjections();
    List<ModelReportId> actualApplicableReports = actualProjectionDataSet.getApplicableReports();

    // Assert
    assertEquals(
        "ProjectionDataSet[dataSetName='null', inputType='null', expectedType='com.regnosys.rosetta.common"
            + ".serialisation.reportdata.ExpectedResult', applicableReports=null, applicableProjections=null,"
            + " data=null]",
        actualToStringResult);
    assertNull(actualProjectionDataSet.getDataSetName());
    assertNull(actualProjectionDataSet.getDataSetShortName());
    assertNull(actualProjectionDataSet.getInputType());
    assertNull(actualProjectionDataSet.getData());
    assertNull(actualApplicableReports);
    assertNull(actualApplicableProjections);
  }

  /**
   * Test {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List,
   * List, List)}
   */
  @Test
  @DisplayName(
      "Test new ProjectionDataSet(String, String, String, List, List, List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProjectionDataSet.<init>(String, String, String, List, List, List)"})
  void testNewProjectionDataSet_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    applicableProjections.add("42");
    applicableProjections.add("foo");
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    // Act
    ProjectionDataSet actualProjectionDataSet =
        new ProjectionDataSet(
            "Data Set Name",
            "Data Set Short Name",
            "Input Type",
            applicableProjections,
            applicableReports,
            new ArrayList<>());

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetName());
    assertEquals("Data Set Short Name", actualProjectionDataSet.getDataSetShortName());
    assertEquals("Input Type", actualProjectionDataSet.getInputType());
    assertEquals(
        "com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualProjectionDataSet.getExpectedType());
    assertTrue(actualProjectionDataSet.getData().isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableReports().isEmpty());
    assertSame(applicableProjections, actualProjectionDataSet.getApplicableProjections());
  }

  /**
   * Test {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return ApplicableProjections is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List,
   * List, List)}
   */
  @Test
  @DisplayName(
      "Test new ProjectionDataSet(String, String, String, List, List, List); given 'foo'; then return ApplicableProjections is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProjectionDataSet.<init>(String, String, String, List, List, List)"})
  void testNewProjectionDataSet_givenFoo_thenReturnApplicableProjectionsIsArrayList() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    applicableProjections.add("foo");
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    // Act
    ProjectionDataSet actualProjectionDataSet =
        new ProjectionDataSet(
            "Data Set Name",
            "Data Set Short Name",
            "Input Type",
            applicableProjections,
            applicableReports,
            new ArrayList<>());

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetName());
    assertEquals("Data Set Short Name", actualProjectionDataSet.getDataSetShortName());
    assertEquals("Input Type", actualProjectionDataSet.getInputType());
    assertEquals(
        "com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualProjectionDataSet.getExpectedType());
    assertTrue(actualProjectionDataSet.getData().isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableReports().isEmpty());
    assertSame(applicableProjections, actualProjectionDataSet.getApplicableProjections());
  }

  /**
   * Test {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link ReportDataItem#ReportDataItem()}.
   *   <li>Then return Data is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List,
   * List, List)}
   */
  @Test
  @DisplayName(
      "Test new ProjectionDataSet(String, String, String, List, List, List); given ReportDataItem(); then return Data is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProjectionDataSet.<init>(String, String, String, List, List, List)"})
  void testNewProjectionDataSet_givenReportDataItem_thenReturnDataIsArrayList() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());

    // Act
    ProjectionDataSet actualProjectionDataSet =
        new ProjectionDataSet(
            "Data Set Name",
            "Data Set Short Name",
            "Input Type",
            applicableProjections,
            applicableReports,
            data);

    // Assert
    assertSame(data, actualProjectionDataSet.getData());
  }

  /**
   * Test {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}.
   *
   * <ul>
   *   <li>Given {@link ReportDataItem#ReportDataItem()}.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List,
   * List, List)}
   */
  @Test
  @DisplayName(
      "Test new ProjectionDataSet(String, String, String, List, List, List); given ReportDataItem(); then return Data size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProjectionDataSet.<init>(String, String, String, List, List, List)"})
  void testNewProjectionDataSet_givenReportDataItem_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());
    ReportDataItem reportDataItem = new ReportDataItem();
    data.add(reportDataItem);

    // Act
    ProjectionDataSet actualProjectionDataSet =
        new ProjectionDataSet(
            "Data Set Name",
            "Data Set Short Name",
            "Input Type",
            applicableProjections,
            applicableReports,
            data);

    // Assert
    List<ReportDataItem> data2 = actualProjectionDataSet.getData();
    assertEquals(2, data2.size());
    assertSame(reportDataItem, data2.get(1));
  }

  /**
   * Test {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}.
   *
   * <ul>
   *   <li>When {@code Data Set Short Name}.
   *   <li>Then return {@code Data Set Short Name}.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List,
   * List, List)}
   */
  @Test
  @DisplayName(
      "Test new ProjectionDataSet(String, String, String, List, List, List); when 'Data Set Short Name'; then return 'Data Set Short Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProjectionDataSet.<init>(String, String, String, List, List, List)"})
  void testNewProjectionDataSet_whenDataSetShortName_thenReturnDataSetShortName() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    // Act
    ProjectionDataSet actualProjectionDataSet =
        new ProjectionDataSet(
            "Data Set Name",
            "Data Set Short Name",
            "Input Type",
            applicableProjections,
            applicableReports,
            new ArrayList<>());

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetName());
    assertEquals("Data Set Short Name", actualProjectionDataSet.getDataSetShortName());
    assertEquals("Input Type", actualProjectionDataSet.getInputType());
    assertEquals(
        "com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualProjectionDataSet.getExpectedType());
    assertTrue(actualProjectionDataSet.getData().isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableProjections().isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableReports().isEmpty());
  }

  /**
   * Test {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return DataSetShortName is {@code Data Set Name}.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List,
   * List, List)}
   */
  @Test
  @DisplayName(
      "Test new ProjectionDataSet(String, String, String, List, List, List); when empty string; then return DataSetShortName is 'Data Set Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProjectionDataSet.<init>(String, String, String, List, List, List)"})
  void testNewProjectionDataSet_whenEmptyString_thenReturnDataSetShortNameIsDataSetName() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    // Act
    ProjectionDataSet actualProjectionDataSet =
        new ProjectionDataSet(
            "Data Set Name",
            "",
            "Input Type",
            applicableProjections,
            applicableReports,
            new ArrayList<>());

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetName());
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetShortName());
    assertEquals("Input Type", actualProjectionDataSet.getInputType());
    assertEquals(
        "com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualProjectionDataSet.getExpectedType());
    assertTrue(actualProjectionDataSet.getData().isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableProjections().isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableReports().isEmpty());
  }

  /**
   * Test {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return DataSetShortName is {@code Data Set Name}.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List,
   * List, List)}
   */
  @Test
  @DisplayName(
      "Test new ProjectionDataSet(String, String, String, List, List, List); when empty string; then return DataSetShortName is 'Data Set Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProjectionDataSet.<init>(String, String, String, List, List, List)"})
  void testNewProjectionDataSet_whenEmptyString_thenReturnDataSetShortNameIsDataSetName2() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();

    // Act
    ProjectionDataSet actualProjectionDataSet =
        new ProjectionDataSet(
            "Data Set Name", "", "Input Type", applicableProjections, null, new ArrayList<>());

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetName());
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetShortName());
    assertEquals("Input Type", actualProjectionDataSet.getInputType());
    assertEquals(
        "com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualProjectionDataSet.getExpectedType());
    assertTrue(actualProjectionDataSet.getData().isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableProjections().isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableReports().isEmpty());
  }

  /**
   * Test {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return DataSetShortName is {@code Data Set Name}.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List,
   * List, List)}
   */
  @Test
  @DisplayName(
      "Test new ProjectionDataSet(String, String, String, List, List, List); when empty string; then return DataSetShortName is 'Data Set Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProjectionDataSet.<init>(String, String, String, List, List, List)"})
  void testNewProjectionDataSet_whenEmptyString_thenReturnDataSetShortNameIsDataSetName3() {
    // Arrange
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    // Act
    ProjectionDataSet actualProjectionDataSet =
        new ProjectionDataSet(
            "Data Set Name", "", "Input Type", null, applicableReports, new ArrayList<>());

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetName());
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetShortName());
    assertEquals("Input Type", actualProjectionDataSet.getInputType());
    assertEquals(
        "com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualProjectionDataSet.getExpectedType());
    assertTrue(actualProjectionDataSet.getData().isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableProjections().isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableReports().isEmpty());
  }

  /**
   * Test {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List, List, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return DataSetShortName is {@code Data Set Name}.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionDataSet#ProjectionDataSet(String, String, String, List,
   * List, List)}
   */
  @Test
  @DisplayName(
      "Test new ProjectionDataSet(String, String, String, List, List, List); when 'null'; then return DataSetShortName is 'Data Set Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProjectionDataSet.<init>(String, String, String, List, List, List)"})
  void testNewProjectionDataSet_whenNull_thenReturnDataSetShortNameIsDataSetName() {
    // Arrange
    ArrayList<String> applicableProjections = new ArrayList<>();
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    // Act
    ProjectionDataSet actualProjectionDataSet =
        new ProjectionDataSet(
            "Data Set Name",
            null,
            "Input Type",
            applicableProjections,
            applicableReports,
            new ArrayList<>());

    // Assert
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetName());
    assertEquals("Data Set Name", actualProjectionDataSet.getDataSetShortName());
    assertEquals("Input Type", actualProjectionDataSet.getInputType());
    assertEquals(
        "com.regnosys.rosetta.common.serialisation.reportdata.ExpectedResult",
        actualProjectionDataSet.getExpectedType());
    assertTrue(actualProjectionDataSet.getData().isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableProjections().isEmpty());
    assertTrue(actualProjectionDataSet.getApplicableReports().isEmpty());
  }

  /**
   * Test {@link ProjectionDataSet#equals(Object)}, and {@link ProjectionDataSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProjectionDataSet#equals(Object)}
   *   <li>{@link ProjectionDataSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProjectionDataSet.equals(Object)",
    "int ProjectionDataSet.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProjectionDataSet projectionDataSet = new ProjectionDataSet();
    ProjectionDataSet projectionDataSet2 = new ProjectionDataSet();

    // Act and Assert
    assertEquals(projectionDataSet, projectionDataSet2);
    assertEquals(projectionDataSet.hashCode(), projectionDataSet2.hashCode());
  }

  /**
   * Test {@link ProjectionDataSet#equals(Object)}, and {@link ProjectionDataSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProjectionDataSet#equals(Object)}
   *   <li>{@link ProjectionDataSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProjectionDataSet.equals(Object)",
    "int ProjectionDataSet.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProjectionDataSet projectionDataSet = new ProjectionDataSet();

    // Act and Assert
    assertEquals(projectionDataSet, projectionDataSet);
    int expectedHashCodeResult = projectionDataSet.hashCode();
    assertEquals(expectedHashCodeResult, projectionDataSet.hashCode());
  }

  /**
   * Test {@link ProjectionDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProjectionDataSet.equals(Object)",
    "int ProjectionDataSet.hashCode()"
  })
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
   * Test {@link ProjectionDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProjectionDataSet.equals(Object)",
    "int ProjectionDataSet.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProjectionDataSet(), null);
  }

  /**
   * Test {@link ProjectionDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProjectionDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProjectionDataSet.equals(Object)",
    "int ProjectionDataSet.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProjectionDataSet(), "Different type to ProjectionDataSet");
  }
}
