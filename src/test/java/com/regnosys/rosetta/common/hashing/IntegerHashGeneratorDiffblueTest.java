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

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.Character.UnicodeScript;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IntegerHashGeneratorDiffblueTest {
  /**
   * Test {@link IntegerHashGenerator#handle(BigDecimal)} with {@code bigDecimal}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return intValue is {@code 49527}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegerHashGenerator#handle(BigDecimal)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(BigDecimal)"})
  public void testHandleWithBigDecimal_whenBigDecimalWith23_thenReturnIntValueIs49527() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(49527, integerHashGenerator.handle(new BigDecimal("2.3")).intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(Boolean)} with {@code bool}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return intValue is {@code 1237}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegerHashGenerator#handle(Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(Boolean)"})
  public void testHandleWithBool_whenFalse_thenReturnIntValueIs1237() {
    // Arrange, Act and Assert
    assertEquals(1237, (new IntegerHashGenerator()).handle(false).intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(Boolean)} with {@code bool}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return intValue is {@code 1231}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegerHashGenerator#handle(Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(Boolean)"})
  public void testHandleWithBool_whenTrue_thenReturnIntValueIs1231() {
    // Arrange, Act and Assert
    assertEquals(1231, (new IntegerHashGenerator()).handle(true).intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(Enum)} with {@code e}.
   * <ul>
   *   <li>When {@link UnicodeScript} with one.</li>
   *   <li>Then return intValue is {@code 1993481707}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegerHashGenerator#handle(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(java.lang.Enum)"})
  public void testHandleWithE_whenUnicodeScriptWithOne_thenReturnIntValueIs1993481707() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(1993481707, integerHashGenerator.handle(UnicodeScript.of(1)).intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(Integer)} with {@code integer}.
   * <p>
   * Method under test: {@link IntegerHashGenerator#handle(Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(Integer)"})
  public void testHandleWithInteger() {
    // Arrange, Act and Assert
    assertEquals(1, (new IntegerHashGenerator()).handle(1).intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(LocalDateTime)} with {@code localDateTime}.
   * <p>
   * Method under test: {@link IntegerHashGenerator#handle(LocalDateTime)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(LocalDateTime)"})
  public void testHandleWithLocalDateTime() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(4034625, integerHashGenerator.handle(LocalDate.of(1970, 1, 1).atStartOfDay()).intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(LocalDate)} with {@code localDate}.
   * <ul>
   *   <li>Then return intValue is {@code 4034625}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegerHashGenerator#handle(LocalDate)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(LocalDate)"})
  public void testHandleWithLocalDate_thenReturnIntValueIs4034625() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(4034625, integerHashGenerator.handle(LocalDate.of(1970, 1, 1)).intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(LocalTime)} with {@code localTime}.
   * <ul>
   *   <li>When {@link LocalTime#MIDNIGHT}.</li>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link IntegerHashGenerator#handle(LocalTime)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(LocalTime)"})
  public void testHandleWithLocalTime_whenMidnight_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new IntegerHashGenerator()).handle(LocalTime.MIDNIGHT).intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(String)} with {@code string}.
   * <p>
   * Method under test: {@link IntegerHashGenerator#handle(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(String)"})
  public void testHandleWithString() {
    // Arrange, Act and Assert
    assertEquals(-1808118735, (new IntegerHashGenerator()).handle("String").intValue());
  }

  /**
   * Test {@link IntegerHashGenerator#handle(ZonedDateTime)} with {@code zonedDateTime}.
   * <p>
   * Method under test: {@link IntegerHashGenerator#handle(ZonedDateTime)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer IntegerHashGenerator.handle(ZonedDateTime)"})
  public void testHandleWithZonedDateTime() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(4034587,
        integerHashGenerator.handle(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC)).intValue());
  }
}
