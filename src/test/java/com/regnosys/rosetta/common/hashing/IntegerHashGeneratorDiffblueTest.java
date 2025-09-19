package com.regnosys.rosetta.common.hashing;

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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.Character.UnicodeScript;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IntegerHashGeneratorDiffblueTest {
  /**
   * Test {@link IntegerHashGenerator#handle(BigDecimal)} with {@code bigDecimal}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return intValue is {@code 49527}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerHashGenerator#handle(BigDecimal)}
   */
  @Test
  @DisplayName(
      "Test handle(BigDecimal) with 'bigDecimal'; when BigDecimal(String) with '2.3'; then return intValue is '49527'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(BigDecimal)"})
  void testHandleWithBigDecimal_whenBigDecimalWith23_thenReturnIntValueIs49527() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(49527, integerHashGenerator.handle(new BigDecimal("2.3")).intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(Boolean)} with {@code bool}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return intValue is {@code 1237}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerHashGenerator#handle(Boolean)}
   */
  @Test
  @DisplayName("Test handle(Boolean) with 'bool'; when 'false'; then return intValue is '1237'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(Boolean)"})
  void testHandleWithBool_whenFalse_thenReturnIntValueIs1237() {
    // Arrange, Act and Assert
    assertEquals(1237, new IntegerHashGenerator().handle(false).intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(Boolean)} with {@code bool}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return intValue is {@code 1231}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerHashGenerator#handle(Boolean)}
   */
  @Test
  @DisplayName("Test handle(Boolean) with 'bool'; when 'true'; then return intValue is '1231'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(Boolean)"})
  void testHandleWithBool_whenTrue_thenReturnIntValueIs1231() {
    // Arrange, Act and Assert
    assertEquals(1231, new IntegerHashGenerator().handle(true).intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(Enum)} with {@code e}.
   *
   * <ul>
   *   <li>When {@link UnicodeScript} with one.
   *   <li>Then return intValue is {@code 1993481707}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerHashGenerator#handle(Object)}
   */
  @Test
  @DisplayName(
      "Test handle(Enum) with 'e'; when UnicodeScript with one; then return intValue is '1993481707'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(java.lang.Enum)"})
  void testHandleWithE_whenUnicodeScriptWithOne_thenReturnIntValueIs1993481707() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(1993481707, integerHashGenerator.handle(UnicodeScript.of(1)).intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(Integer)} with {@code integer}.
   *
   * <p>Method under test: {@link IntegerHashGenerator#handle(Integer)}
   */
  @Test
  @DisplayName("Test handle(Integer) with 'integer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(Integer)"})
  void testHandleWithInteger() {
    // Arrange, Act and Assert
    assertEquals(1, new IntegerHashGenerator().handle(1).intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(LocalDateTime)} with {@code localDateTime}.
   *
   * <p>Method under test: {@link IntegerHashGenerator#handle(LocalDateTime)}
   */
  @Test
  @DisplayName("Test handle(LocalDateTime) with 'localDateTime'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(LocalDateTime)"})
  void testHandleWithLocalDateTime() {
    // Arrange, Act and Assert
    assertEquals(
        4034625,
        new IntegerHashGenerator().handle(LocalDate.of(1970, 1, 1).atStartOfDay()).intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(LocalDate)} with {@code localDate}.
   *
   * <ul>
   *   <li>Then return intValue is {@code 4034625}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerHashGenerator#handle(LocalDate)}
   */
  @Test
  @DisplayName("Test handle(LocalDate) with 'localDate'; then return intValue is '4034625'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(LocalDate)"})
  void testHandleWithLocalDate_thenReturnIntValueIs4034625() {
    // Arrange, Act and Assert
    assertEquals(4034625, new IntegerHashGenerator().handle(LocalDate.of(1970, 1, 1)).intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(LocalTime)} with {@code localTime}.
   *
   * <ul>
   *   <li>When {@link LocalTime#MIDNIGHT}.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link IntegerHashGenerator#handle(LocalTime)}
   */
  @Test
  @DisplayName(
      "Test handle(LocalTime) with 'localTime'; when MIDNIGHT; then return intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(LocalTime)"})
  void testHandleWithLocalTime_whenMidnight_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, new IntegerHashGenerator().handle(LocalTime.MIDNIGHT).intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(String)} with {@code string}.
   *
   * <p>Method under test: {@link IntegerHashGenerator#handle(String)}
   */
  @Test
  @DisplayName("Test handle(String) with 'string'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(String)"})
  void testHandleWithString() {
    // Arrange, Act and Assert
    assertEquals(-1808118735, new IntegerHashGenerator().handle("String").intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(ZonedDateTime)} with {@code zonedDateTime}.
   *
   * <p>Method under test: {@link IntegerHashGenerator#handle(ZonedDateTime)}
   */
  @Test
  @DisplayName("Test handle(ZonedDateTime) with 'zonedDateTime'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(ZonedDateTime)"})
  void testHandleWithZonedDateTime() {
    // Arrange, Act and Assert
    assertEquals(
        4034587,
        new IntegerHashGenerator()
            .handle(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC))
            .intValue());
  }
}
