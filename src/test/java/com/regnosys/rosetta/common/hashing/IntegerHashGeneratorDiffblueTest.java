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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.junit.Test;

public class IntegerHashGeneratorDiffblueTest {
  /**
   * Method under test: {@link IntegerHashGenerator#handle(Boolean)}
   */
  @Test
  public void testHandle() {
    // Arrange, Act and Assert
    assertEquals(1231, (new IntegerHashGenerator()).handle(true).intValue());
    assertEquals(1237, (new IntegerHashGenerator()).handle(false).intValue());
    assertEquals(1, (new IntegerHashGenerator()).handle(1).intValue());
    assertEquals(-1808118735, (new IntegerHashGenerator()).handle("String").intValue());
    assertEquals(0, (new IntegerHashGenerator()).handle(LocalTime.MIDNIGHT).intValue());
  }

  /**
   * Method under test: {@link IntegerHashGenerator#handle(Object)}
   */
  @Test
  public void testHandle2() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(1993481707, integerHashGenerator.handle(Character.UnicodeScript.of(1)).intValue());
  }

  /**
   * Method under test: {@link IntegerHashGenerator#handle(BigDecimal)}
   */
  @Test
  public void testHandle3() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(49527, integerHashGenerator.handle(new BigDecimal("2.3")).intValue());
  }

  /**
   * Method under test: {@link IntegerHashGenerator#handle(LocalDate)}
   */
  @Test
  public void testHandle4() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(4034625, integerHashGenerator.handle(LocalDate.of(1970, 1, 1)).intValue());
  }

  /**
   * Method under test: {@link IntegerHashGenerator#handle(LocalDateTime)}
   */
  @Test
  public void testHandle5() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(4034625, integerHashGenerator.handle(LocalDate.of(1970, 1, 1).atStartOfDay()).intValue());
  }

  /**
   * Method under test: {@link IntegerHashGenerator#handle(ZonedDateTime)}
   */
  @Test
  public void testHandle6() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(4034587,
        integerHashGenerator.handle(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC)).intValue());
  }
}
