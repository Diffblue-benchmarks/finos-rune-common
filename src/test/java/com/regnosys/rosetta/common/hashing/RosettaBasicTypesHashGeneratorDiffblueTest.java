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
import com.regnosys.rosetta.common.serialisation.mixin.DateExtended;
import java.lang.Character.UnicodeScript;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RosettaBasicTypesHashGeneratorDiffblueTest {
  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   * <ul>
   *   <li>Then return intValue is {@code 4034587}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  public void testGenerate_thenReturnIntValueIs4034587() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(4034587,
        integerHashGenerator.generate(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC)).intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   * <ul>
   *   <li>When {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return intValue is {@code 49527}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  public void testGenerate_whenBigDecimalWith23_thenReturnIntValueIs49527() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(49527, integerHashGenerator.generate(new BigDecimal("2.3")).intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   * <ul>
   *   <li>When {@code COMMON}.</li>
   *   <li>Then return intValue is {@code 1993481707}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  public void testGenerate_whenCommon_thenReturnIntValueIs1993481707() {
    // Arrange, Act and Assert
    assertEquals(1993481707, (new IntegerHashGenerator()).generate(UnicodeScript.COMMON).intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   * <ul>
   *   <li>When {@link DateExtended#DateExtended(String)} with date is {@code 2020-03-01}.</li>
   *   <li>Then return intValue is {@code 4137153}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  public void testGenerate_whenDateExtendedWithDateIs20200301_thenReturnIntValueIs4137153() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(4137153, integerHashGenerator.generate(new DateExtended("2020-03-01")).intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one atStartOfDay.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  public void testGenerate_whenLocalDateWith1970AndOneAndOneAtStartOfDay() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(4034625, integerHashGenerator.generate(LocalDate.of(1970, 1, 1).atStartOfDay()).intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one.</li>
   *   <li>Then return intValue is {@code 4034625}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  public void testGenerate_whenLocalDateWith1970AndOneAndOne_thenReturnIntValueIs4034625() {
    // Arrange
    IntegerHashGenerator integerHashGenerator = new IntegerHashGenerator();

    // Act and Assert
    assertEquals(4034625, integerHashGenerator.generate(LocalDate.of(1970, 1, 1)).intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   * <ul>
   *   <li>When {@link LocalTime#MIDNIGHT}.</li>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  public void testGenerate_whenMidnight_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new IntegerHashGenerator()).generate(LocalTime.MIDNIGHT).intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return intValue is {@code -1939501217}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  public void testGenerate_whenObject_thenReturnIntValueIs1939501217() {
    // Arrange, Act and Assert
    assertEquals(-1939501217, (new IntegerHashGenerator()).generate("Object").intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  public void testGenerate_whenOne_thenReturnIntValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new IntegerHashGenerator()).<Object>generate(1).intValue());
  }

  /**
   * Test {@link RosettaBasicTypesHashGenerator#generate(Object)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return intValue is {@code 1231}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RosettaBasicTypesHashGenerator#generate(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object RosettaBasicTypesHashGenerator.generate(Object)"})
  public void testGenerate_whenTrue_thenReturnIntValueIs1231() {
    // Arrange, Act and Assert
    assertEquals(1231, (new IntegerHashGenerator()).generate(true).intValue());
  }
}
