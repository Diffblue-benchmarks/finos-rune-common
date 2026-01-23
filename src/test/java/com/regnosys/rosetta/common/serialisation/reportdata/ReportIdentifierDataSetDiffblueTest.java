package com.regnosys.rosetta.common.serialisation.reportdata;

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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rosetta.model.lib.ModelReportId;
import com.rosetta.util.DottedPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportIdentifierDataSetDiffblueTest {
  /**
   * Test {@link ReportIdentifierDataSet#equals(Object)}, and {@link
   * ReportIdentifierDataSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReportIdentifierDataSet#equals(Object)}
   *   <li>{@link ReportIdentifierDataSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReportIdentifierDataSet.equals(Object)",
    "int ReportIdentifierDataSet.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReportIdentifierDataSet reportIdentifierDataSet = new ReportIdentifierDataSet();
    ReportIdentifierDataSet reportIdentifierDataSet2 = new ReportIdentifierDataSet();

    // Act and Assert
    assertEquals(reportIdentifierDataSet, reportIdentifierDataSet2);
    assertEquals(reportIdentifierDataSet.hashCode(), reportIdentifierDataSet2.hashCode());
  }

  /**
   * Test {@link ReportIdentifierDataSet#equals(Object)}, and {@link
   * ReportIdentifierDataSet#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReportIdentifierDataSet#equals(Object)}
   *   <li>{@link ReportIdentifierDataSet#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReportIdentifierDataSet.equals(Object)",
    "int ReportIdentifierDataSet.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReportIdentifierDataSet reportIdentifierDataSet = new ReportIdentifierDataSet();

    // Act and Assert
    assertEquals(reportIdentifierDataSet, reportIdentifierDataSet);
    int expectedHashCodeResult = reportIdentifierDataSet.hashCode();
    assertEquals(expectedHashCodeResult, reportIdentifierDataSet.hashCode());
  }

  /**
   * Test {@link ReportIdentifierDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReportIdentifierDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReportIdentifierDataSet.equals(Object)",
    "int ReportIdentifierDataSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportIdentifierDataSet(), 1);
  }

  /**
   * Test {@link ReportIdentifierDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReportIdentifierDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReportIdentifierDataSet.equals(Object)",
    "int ReportIdentifierDataSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ReportIdentifierDataSet reportIdentifierDataSet =
        new ReportIdentifierDataSet(null, new ReportDataSet());

    // Act and Assert
    assertNotEquals(reportIdentifierDataSet, new ReportIdentifierDataSet());
  }

  /**
   * Test {@link ReportIdentifierDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReportIdentifierDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReportIdentifierDataSet.equals(Object)",
    "int ReportIdentifierDataSet.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ModelReportId reportIdentifier =
        new ModelReportId(
            DottedPath.split("Str", "Separator"), "Not all who wander are lost", "Corpus List");
    ReportIdentifierDataSet reportIdentifierDataSet =
        new ReportIdentifierDataSet(reportIdentifier, new ReportDataSet());

    // Act and Assert
    assertNotEquals(reportIdentifierDataSet, new ReportIdentifierDataSet());
  }

  /**
   * Test {@link ReportIdentifierDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReportIdentifierDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReportIdentifierDataSet.equals(Object)",
    "int ReportIdentifierDataSet.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportIdentifierDataSet(), null);
  }

  /**
   * Test {@link ReportIdentifierDataSet#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReportIdentifierDataSet#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ReportIdentifierDataSet.equals(Object)",
    "int ReportIdentifierDataSet.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportIdentifierDataSet(), "Different type to ReportIdentifierDataSet");
  }
}
