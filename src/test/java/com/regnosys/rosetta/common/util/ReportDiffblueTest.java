package com.regnosys.rosetta.common.util;

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

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.regnosys.rosetta.common.merger.BarBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ReportDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Report#Report(RosettaModelObject)}
   *   <li>{@link Report#getRosettaModelInstance()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Report.<init>(RosettaModelObject)", "RosettaModelObject Report.getRosettaModelInstance()"})
  public void testGettersAndSetters() {
    // Arrange
    BarBuilder barBuilder = new BarBuilder();

    // Act
    Report<RosettaModelObject> actualReport = new Report<>(barBuilder);

    // Assert
    assertSame(barBuilder, actualReport.getRosettaModelInstance());
  }
}
