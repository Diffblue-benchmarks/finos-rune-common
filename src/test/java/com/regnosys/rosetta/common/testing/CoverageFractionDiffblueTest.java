package com.regnosys.rosetta.common.testing;

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
import org.junit.Test;

public class CoverageFractionDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link CoverageFraction}
   */
  @Test
  public void testNewCoverageFraction() {
    // Arrange and Act
    CoverageFraction actualCoverageFraction = new CoverageFraction();

    // Assert
    assertEquals(0, actualCoverageFraction.denominator);
    assertEquals(0, actualCoverageFraction.numerator);
  }
}
