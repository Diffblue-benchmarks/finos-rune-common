package com.regnosys.rosetta.common.hashing;

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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.regnosys.rosetta.common.serialisation.mixin.DateExtended;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RosettaBasicTypesHashGeneratorDiffblueTest {
  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   *
   * <ul>
   *   <li>Then return intValue is {@code 4034587}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @DisplayName("Test generate(Object); then return intValue is '4034587'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  void testGenerate_thenReturnIntValueIs4034587() {
    // Arrange, Act and Assert
    assertEquals(
        4034587,
        new IntegerHashGenerator()
            .generate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC))
            .intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   *
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return intValue is {@code 49527}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @DisplayName(
      "Test generate(Object); when BigDecimal(String) with '2.3'; then return intValue is '49527'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  void testGenerate_whenBigDecimalWith23_thenReturnIntValueIs49527() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(49527, integerHashGenerator.generate(new BigDecimal("2.3")).intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   *
   * <ul>
   *   <li>When {@link DateExtended#DateExtended(String)} with date is {@code 2020-03-01}.
   *   <li>Then return intValue is {@code 4137153}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @DisplayName(
      "Test generate(Object); when DateExtended(String) with date is '2020-03-01'; then return intValue is '4137153'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  void testGenerate_whenDateExtendedWithDateIs20200301_thenReturnIntValueIs4137153() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(4137153, integerHashGenerator.generate(new DateExtended("2020-03-01")).intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   *
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one atStartOfDay.
   * </ul>
   *
   * <p>Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @DisplayName("Test generate(Object); when LocalDate with '1970' and one and one atStartOfDay")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  void testGenerate_whenLocalDateWith1970AndOneAndOneAtStartOfDay() {
    // Arrange, Act and Assert
    assertEquals(
        4034625,
        new IntegerHashGenerator().generate(LocalDate.of(1970, 1, 1).atStartOfDay()).intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   *
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.
   *   <li>Then return intValue is {@code 4034625}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @DisplayName(
      "Test generate(Object); when LocalDate with '1970' and one and one; then return intValue is '4034625'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  void testGenerate_whenLocalDateWith1970AndOneAndOne_thenReturnIntValueIs4034625() {
    // Arrange, Act and Assert
    assertEquals(4034625, new IntegerHashGenerator().generate(LocalDate.of(1970, 1, 1)).intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   *
   * <ul>
   *   <li>When {@link BeanPropertyWriter#MARKER_FOR_EMPTY}.
   *   <li>Then return intValue is {@code -7755493}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @DisplayName("Test generate(Object); when MARKER_FOR_EMPTY; then return intValue is '-7755493'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  void testGenerate_whenMarker_for_empty_thenReturnIntValueIs7755493() {
    // Arrange, Act and Assert
    assertEquals(
        -7755493,
        new IntegerHashGenerator().generate(BeanPropertyWriter.MARKER_FOR_EMPTY).intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   *
   * <ul>
   *   <li>When {@link LocalTime#MIDNIGHT}.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @DisplayName("Test generate(Object); when MIDNIGHT; then return intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  void testGenerate_whenMidnight_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, new IntegerHashGenerator().generate(LocalTime.MIDNIGHT).intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return intValue is {@code -1939501217}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @DisplayName("Test generate(Object); when 'Object'; then return intValue is '-1939501217'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  void testGenerate_whenObject_thenReturnIntValueIs1939501217() {
    // Arrange, Act and Assert
    assertEquals(-1939501217, new IntegerHashGenerator().generate("Object").intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @DisplayName("Test generate(Object); when one; then return intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  void testGenerate_whenOne_thenReturnIntValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1, new IntegerHashGenerator().generate(1).intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return intValue is {@code 1231}.
   * </ul>
   *
   * <p>Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @DisplayName("Test generate(Object); when 'true'; then return intValue is '1231'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  void testGenerate_whenTrue_thenReturnIntValueIs1231() {
    // Arrange, Act and Assert
    assertEquals(1231, new IntegerHashGenerator().generate(true).intValue());
  }
}
