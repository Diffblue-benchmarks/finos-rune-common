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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rosetta.model.lib.ModelReportId;
import com.rosetta.util.DottedPath;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ReportIdentifierDataSetDiffblueTest {
  /**
   * Test {@link ReportIdentifierDataSet#equals(Object)}, and {@link ReportIdentifierDataSet#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReportIdentifierDataSet#equals(Object)}
   *   <li>{@link ReportIdentifierDataSet#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReportIdentifierDataSet.equals(Object)", "int ReportIdentifierDataSet.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReportIdentifierDataSet reportIdentifierDataSet = new ReportIdentifierDataSet();
    ReportIdentifierDataSet reportIdentifierDataSet2 = new ReportIdentifierDataSet();

    // Act and Assert
    assertEquals(reportIdentifierDataSet, reportIdentifierDataSet2);
    int expectedHashCodeResult = reportIdentifierDataSet.hashCode();
    assertEquals(expectedHashCodeResult, reportIdentifierDataSet2.hashCode());
  }

  /**
   * Test {@link ReportIdentifierDataSet#equals(Object)}, and {@link ReportIdentifierDataSet#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReportIdentifierDataSet#equals(Object)}
   *   <li>{@link ReportIdentifierDataSet#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReportIdentifierDataSet.equals(Object)", "int ReportIdentifierDataSet.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReportIdentifierDataSet reportIdentifierDataSet = new ReportIdentifierDataSet();

    // Act and Assert
    assertEquals(reportIdentifierDataSet, reportIdentifierDataSet);
    int expectedHashCodeResult = reportIdentifierDataSet.hashCode();
    assertEquals(expectedHashCodeResult, reportIdentifierDataSet.hashCode());
  }

  /**
   * Test {@link ReportIdentifierDataSet#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportIdentifierDataSet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReportIdentifierDataSet.equals(Object)", "int ReportIdentifierDataSet.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportIdentifierDataSet(), 1);
  }

  /**
   * Test {@link ReportIdentifierDataSet#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportIdentifierDataSet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReportIdentifierDataSet.equals(Object)", "int ReportIdentifierDataSet.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ReportIdentifierDataSet reportIdentifierDataSet = new ReportIdentifierDataSet(null, new ReportDataSet());

    // Act and Assert
    assertNotEquals(reportIdentifierDataSet, new ReportIdentifierDataSet());
  }

  /**
   * Test {@link ReportIdentifierDataSet#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportIdentifierDataSet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReportIdentifierDataSet.equals(Object)", "int ReportIdentifierDataSet.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ModelReportId reportIdentifier = new ModelReportId(DottedPath.split("Str", "Separator"),
        "Not all who wander are lost", "Corpus List");

    ReportIdentifierDataSet reportIdentifierDataSet = new ReportIdentifierDataSet(reportIdentifier,
        new ReportDataSet());

    // Act and Assert
    assertNotEquals(reportIdentifierDataSet, new ReportIdentifierDataSet());
  }

  /**
   * Test {@link ReportIdentifierDataSet#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportIdentifierDataSet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReportIdentifierDataSet.equals(Object)", "int ReportIdentifierDataSet.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportIdentifierDataSet(), null);
  }

  /**
   * Test {@link ReportIdentifierDataSet#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReportIdentifierDataSet#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReportIdentifierDataSet.equals(Object)", "int ReportIdentifierDataSet.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReportIdentifierDataSet(), "Different type to ReportIdentifierDataSet");
  }
}
