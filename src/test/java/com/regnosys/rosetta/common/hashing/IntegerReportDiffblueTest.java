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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IntegerReportDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IntegerReport#IntegerReport(int)}
   *   <li>{@link IntegerReport#accumulate(int)}
   *   <li>{@link IntegerReport#accumulate()}
   *   <li>{@link IntegerReport#toString()}
   *   <li>{@link IntegerReport#getResult()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IntegerReport.<init>(int)",
    "void IntegerReport.accumulate()",
    "void IntegerReport.accumulate(int)",
    "int IntegerReport.getResult()",
    "String IntegerReport.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    IntegerReport actualIntegerReport = new IntegerReport(1);
    actualIntegerReport.accumulate(42);
    actualIntegerReport.accumulate();
    String actualToStringResult = actualIntegerReport.toString();

    // Assert
    assertEquals("8d7", actualToStringResult);
    assertEquals(2263, actualIntegerReport.getResult());
  }
}
