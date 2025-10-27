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
import com.regnosys.rosetta.common.serialisation.mixin.DateExtended;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import org.junit.Test;

public class RosettaBasicTypesHashGeneratorDiffblueTest {
  /**
   * Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  public void testGenerate() {
    // Arrange, Act and Assert
    assertEquals(-1939501217, (new IntegerHashGenerator()).generate("Object").intValue());
    assertEquals(1, (new IntegerHashGenerator()).<Object>generate(1).intValue());
    assertEquals(0, (new IntegerHashGenerator()).generate(LocalTime.MIDNIGHT).intValue());
    assertEquals(1231, (new IntegerHashGenerator()).generate(true).intValue());
    assertEquals(1993481707, (new IntegerHashGenerator()).generate(Character.UnicodeScript.COMMON).intValue());
  }

  /**
   * Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  public void testGenerate2() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(4034625, integerHashGenerator.generate(LocalDate.of(1970, 1, 1)).intValue());
  }

  /**
   * Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  public void testGenerate3() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(4137153, integerHashGenerator.generate(new DateExtended("2020-03-01")).intValue());
  }

  /**
   * Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  public void testGenerate4() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(4034625, integerHashGenerator.generate(LocalDate.of(1970, 1, 1).atStartOfDay()).intValue());
  }

  /**
   * Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  public void testGenerate5() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(4034587,
        integerHashGenerator.generate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC)).intValue());
  }

  /**
   * Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  public void testGenerate6() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(49527, integerHashGenerator.generate(new BigDecimal("2.3")).intValue());
  }
}
