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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.rosetta.model.lib.ModelReportId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExpectedResultDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExpectedResult#ExpectedResult()}
   *   <li>{@link ExpectedResult#toString()}
   *   <li>{@link ExpectedResult#getExpectationsPerReport()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExpectedResult.<init>()", "void ExpectedResult.<init>(Map)",
      "Map ExpectedResult.getExpectationsPerReport()", "String ExpectedResult.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    ExpectedResult actualExpectedResult = new ExpectedResult();
    String actualToStringResult = actualExpectedResult.toString();

    // Assert
    assertEquals("ExpectedResult{expectationsPerReport=null}", actualToStringResult);
    assertNull(actualExpectedResult.getExpectationsPerReport());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return toString is {@code ExpectedResult{expectationsPerReport={}}}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExpectedResult#ExpectedResult(Map)}
   *   <li>{@link ExpectedResult#toString()}
   *   <li>{@link ExpectedResult#getExpectationsPerReport()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ExpectedResult.<init>()", "void ExpectedResult.<init>(Map)",
      "Map ExpectedResult.getExpectationsPerReport()", "String ExpectedResult.toString()"})
  public void testGettersAndSetters_thenReturnToStringIsExpectedResultExpectationsPerReport() {
    // Arrange
    HashMap<ModelReportId, List<ExpectedResultField>> expectationsPerReport = new HashMap<>();

    // Act
    ExpectedResult actualExpectedResult = new ExpectedResult(expectationsPerReport);
    String actualToStringResult = actualExpectedResult.toString();
    Map<ModelReportId, List<ExpectedResultField>> actualExpectationsPerReport = actualExpectedResult
        .getExpectationsPerReport();

    // Assert
    assertEquals("ExpectedResult{expectationsPerReport={}}", actualToStringResult);
    assertTrue(actualExpectationsPerReport.isEmpty());
    assertSame(expectationsPerReport, actualExpectationsPerReport);
  }

  /**
   * Test {@link ExpectedResult#equals(Object)}, and {@link ExpectedResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExpectedResult#equals(Object)}
   *   <li>{@link ExpectedResult#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExpectedResult.equals(Object)", "int ExpectedResult.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ExpectedResult expectedResult = new ExpectedResult();
    ExpectedResult expectedResult2 = new ExpectedResult();

    // Act and Assert
    assertEquals(expectedResult, expectedResult2);
    int expectedHashCodeResult = expectedResult.hashCode();
    assertEquals(expectedHashCodeResult, expectedResult2.hashCode());
  }

  /**
   * Test {@link ExpectedResult#equals(Object)}, and {@link ExpectedResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ExpectedResult#equals(Object)}
   *   <li>{@link ExpectedResult#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExpectedResult.equals(Object)", "int ExpectedResult.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExpectedResult expectedResult = new ExpectedResult();

    // Act and Assert
    assertEquals(expectedResult, expectedResult);
    int expectedHashCodeResult = expectedResult.hashCode();
    assertEquals(expectedHashCodeResult, expectedResult.hashCode());
  }

  /**
   * Test {@link ExpectedResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExpectedResult#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExpectedResult.equals(Object)", "int ExpectedResult.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExpectedResult expectedResult = new ExpectedResult(new HashMap<>());

    // Act and Assert
    assertNotEquals(expectedResult, new ExpectedResult());
  }

  /**
   * Test {@link ExpectedResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExpectedResult#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExpectedResult.equals(Object)", "int ExpectedResult.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExpectedResult(), null);
  }

  /**
   * Test {@link ExpectedResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExpectedResult#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExpectedResult.equals(Object)", "int ExpectedResult.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExpectedResult(), "Different type to ExpectedResult");
  }
}
