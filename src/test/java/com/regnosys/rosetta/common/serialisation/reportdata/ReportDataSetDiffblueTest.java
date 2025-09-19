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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rosetta.model.lib.ModelReportId;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportDataSetDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReportDataSet#ReportDataSet()}
   *   <li>{@link ReportDataSet#toString()}
   *   <li>{@link ReportDataSet#getApplicableReports()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReportDataSet.<init>()",
    "List ReportDataSet.getApplicableReports()",
    "String ReportDataSet.toString()"
  })
  void testGettersAndSetters() {
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
   * Test {@link ReportDataSet#ReportDataSet(String, String, List, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return ApplicableReports is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataSet#ReportDataSet(String, String, List, List)}
   */
  @Test
  @DisplayName(
      "Test new ReportDataSet(String, String, List, List); given 'null'; then return ApplicableReports is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportDataSet.<init>(String, String, List, List)"})
  void testNewReportDataSet_givenNull_thenReturnApplicableReportsIsArrayList() {
    // Arrange
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    applicableReports.add(null);

    // Act
    ReportDataSet actualReportDataSet =
        new ReportDataSet("Data Set Name", "Input Type", applicableReports, new ArrayList<>());

    // Assert
    assertEquals("Data Set Name", actualReportDataSet.getDataSetName());
    assertEquals("Data Set Name", actualReportDataSet.getDataSetShortName());
    assertTrue(actualReportDataSet.getData().isEmpty());
    assertSame(applicableReports, actualReportDataSet.getApplicableReports());
  }

  /**
   * Test {@link ReportDataSet#ReportDataSet(String, String, List, List)}.
   *
   * <ul>
   *   <li>Given {@link ReportDataItem#ReportDataItem()}.
   *   <li>Then return Data is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataSet#ReportDataSet(String, String, List, List)}
   */
  @Test
  @DisplayName(
      "Test new ReportDataSet(String, String, List, List); given ReportDataItem(); then return Data is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportDataSet.<init>(String, String, List, List)"})
  void testNewReportDataSet_givenReportDataItem_thenReturnDataIsArrayList() {
    // Arrange
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());

    // Act
    ReportDataSet actualReportDataSet =
        new ReportDataSet("Data Set Name", "Input Type", applicableReports, data);

    // Assert
    assertSame(data, actualReportDataSet.getData());
  }

  /**
   * Test {@link ReportDataSet#ReportDataSet(String, String, List, List)}.
   *
   * <ul>
   *   <li>Given {@link ReportDataItem#ReportDataItem()}.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataSet#ReportDataSet(String, String, List, List)}
   */
  @Test
  @DisplayName(
      "Test new ReportDataSet(String, String, List, List); given ReportDataItem(); then return Data size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportDataSet.<init>(String, String, List, List)"})
  void testNewReportDataSet_givenReportDataItem_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    ArrayList<ReportDataItem> data = new ArrayList<>();
    data.add(new ReportDataItem());
    ReportDataItem reportDataItem = new ReportDataItem();
    data.add(reportDataItem);

    // Act
    ReportDataSet actualReportDataSet =
        new ReportDataSet("Data Set Name", "Input Type", applicableReports, data);

    // Assert
    List<ReportDataItem> data2 = actualReportDataSet.getData();
    assertEquals(2, data2.size());
    assertSame(reportDataItem, data2.get(1));
  }

  /**
   * Test {@link ReportDataSet#ReportDataSet(String, String, List, List)}.
   *
   * <ul>
   *   <li>When {@code Data Set Name}.
   *   <li>Then return {@code Data Set Name}.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataSet#ReportDataSet(String, String, List, List)}
   */
  @Test
  @DisplayName(
      "Test new ReportDataSet(String, String, List, List); when 'Data Set Name'; then return 'Data Set Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportDataSet.<init>(String, String, List, List)"})
  void testNewReportDataSet_whenDataSetName_thenReturnDataSetName() {
    // Arrange
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    // Act
    ReportDataSet actualReportDataSet =
        new ReportDataSet("Data Set Name", "Input Type", applicableReports, new ArrayList<>());

    // Assert
    assertEquals("Data Set Name", actualReportDataSet.getDataSetName());
    assertEquals("Data Set Name", actualReportDataSet.getDataSetShortName());
    assertTrue(actualReportDataSet.getData().isEmpty());
    assertTrue(actualReportDataSet.getApplicableReports().isEmpty());
  }

  /**
   * Test {@link ReportDataSet#ReportDataSet(String, String, List, List)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return DataSetName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataSet#ReportDataSet(String, String, List, List)}
   */
  @Test
  @DisplayName(
      "Test new ReportDataSet(String, String, List, List); when empty string; then return DataSetName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportDataSet.<init>(String, String, List, List)"})
  void testNewReportDataSet_whenEmptyString_thenReturnDataSetNameIsEmptyString() {
    // Arrange
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    // Act
    ReportDataSet actualReportDataSet =
        new ReportDataSet("", "Input Type", applicableReports, new ArrayList<>());

    // Assert
    assertEquals("", actualReportDataSet.getDataSetName());
    assertEquals("", actualReportDataSet.getDataSetShortName());
    assertTrue(actualReportDataSet.getData().isEmpty());
    assertTrue(actualReportDataSet.getApplicableReports().isEmpty());
  }

  /**
   * Test {@link ReportDataSet#ReportDataSet(String, String, List, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return DataSetName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataSet#ReportDataSet(String, String, List, List)}
   */
  @Test
  @DisplayName(
      "Test new ReportDataSet(String, String, List, List); when 'null'; then return DataSetName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReportDataSet.<init>(String, String, List, List)"})
  void testNewReportDataSet_whenNull_thenReturnDataSetNameIsNull() {
    // Arrange
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();

    // Act
    ReportDataSet actualReportDataSet =
        new ReportDataSet(null, "Input Type", applicableReports, new ArrayList<>());

    // Assert
    assertNull(actualReportDataSet.getDataSetName());
    assertNull(actualReportDataSet.getDataSetShortName());
    assertTrue(actualReportDataSet.getData().isEmpty());
    assertTrue(actualReportDataSet.getApplicableReports().isEmpty());
  }

  /**
   * Test {@link ReportDataSet#equals(Object)}, and {@link ReportDataSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReportDataSet#equals(Object)}
   *   <li>{@link ReportDataSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportDataSet.equals(Object)", "int ReportDataSet.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReportDataSet reportDataSet = new ReportDataSet();
    ReportDataSet reportDataSet2 = new ReportDataSet();

    // Act and Assert
    assertEquals(reportDataSet, reportDataSet2);
    assertEquals(reportDataSet.hashCode(), reportDataSet2.hashCode());
  }

  /**
   * Test {@link ReportDataSet#equals(Object)}, and {@link ReportDataSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReportDataSet#equals(Object)}
   *   <li>{@link ReportDataSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportDataSet.equals(Object)", "int ReportDataSet.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReportDataSet reportDataSet = new ReportDataSet();

    // Act and Assert
    assertEquals(reportDataSet, reportDataSet);
    int expectedHashCodeResult = reportDataSet.hashCode();
    assertEquals(expectedHashCodeResult, reportDataSet.hashCode());
  }

  /**
   * Test {@link ReportDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportDataSet.equals(Object)", "int ReportDataSet.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<ModelReportId> applicableReports = new ArrayList<>();
    ReportDataSet reportDataSet =
        new ReportDataSet("Data Set Name", "Input Type", applicableReports, new ArrayList<>());

    // Act and Assert
    assertNotEquals(reportDataSet, new ReportDataSet());
  }

  /**
   * Test {@link ReportDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportDataSet.equals(Object)", "int ReportDataSet.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportDataSet(), null);
  }

  /**
   * Test {@link ReportDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReportDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ReportDataSet.equals(Object)", "int ReportDataSet.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportDataSet(), "Different type to ReportDataSet");
  }
}
