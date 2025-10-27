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
import static org.mockito.Mockito.mock;
import com.rosetta.model.lib.ModelReportId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;

public class ExpectedResultDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExpectedResult#equals(Object)}
   *   <li>{@link ExpectedResult#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link ExpectedResult#equals(Object)}
   *   <li>{@link ExpectedResult#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExpectedResult expectedResult = new ExpectedResult();

    // Act and Assert
    assertEquals(expectedResult, expectedResult);
    int expectedHashCodeResult = expectedResult.hashCode();
    assertEquals(expectedHashCodeResult, expectedResult.hashCode());
  }

  /**
   * Method under test: {@link ExpectedResult#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExpectedResult expectedResult = new ExpectedResult(new HashMap<>());

    // Act and Assert
    assertNotEquals(expectedResult, new ExpectedResult());
  }

  /**
   * Method under test: {@link ExpectedResult#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<ModelReportId, List<ExpectedResultField>> expectationsPerReport = new HashMap<>();
    expectationsPerReport.computeIfPresent(null, mock(BiFunction.class));
    ExpectedResult expectedResult = new ExpectedResult(expectationsPerReport);

    // Act and Assert
    assertNotEquals(expectedResult, new ExpectedResult());
  }

  /**
   * Method under test: {@link ExpectedResult#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExpectedResult(), null);
  }

  /**
   * Method under test: {@link ExpectedResult#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ExpectedResult(), "Different type to ExpectedResult");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExpectedResult#ExpectedResult()}
   *   <li>{@link ExpectedResult#toString()}
   *   <li>{@link ExpectedResult#getExpectationsPerReport()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ExpectedResult actualExpectedResult = new ExpectedResult();
    String actualToStringResult = actualExpectedResult.toString();

    // Assert
    assertEquals("ExpectedResult{expectationsPerReport=null}", actualToStringResult);
    assertNull(actualExpectedResult.getExpectationsPerReport());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExpectedResult#ExpectedResult(Map)}
   *   <li>{@link ExpectedResult#toString()}
   *   <li>{@link ExpectedResult#getExpectationsPerReport()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
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
}
