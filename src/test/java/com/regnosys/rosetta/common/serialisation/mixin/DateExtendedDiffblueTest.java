package com.regnosys.rosetta.common.serialisation.mixin;

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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DateExtendedDiffblueTest {
  /**
   * Test {@link DateExtended#DateExtended(int, int, int)}.
   *
   * <p>Method under test: {@link DateExtended#DateExtended(int, int, int)}
   */
  @Test
  @DisplayName("Test new DateExtended(int, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateExtended.<init>(int, int, int)"})
  void testNewDateExtended() {
    // Arrange and Act
    DateExtended actualDateExtended = new DateExtended(1, 1, 1);

    // Assert
    assertEquals(1, actualDateExtended.getDay());
    assertEquals(1, actualDateExtended.getMonth());
    assertEquals(1, actualDateExtended.getYear());
  }

  /**
   * Test {@link DateExtended#DateExtended(String)}.
   *
   * <p>Method under test: {@link DateExtended#DateExtended(String)}
   */
  @Test
  @DisplayName("Test new DateExtended(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DateExtended.<init>(String)"})
  void testNewDateExtended2() {
    // Arrange and Act
    DateExtended actualDateExtended = new DateExtended("2020-03-01");

    // Assert
    assertEquals(1, actualDateExtended.getDay());
    assertEquals(2020, actualDateExtended.getYear());
    assertEquals(3, actualDateExtended.getMonth());
  }
}
