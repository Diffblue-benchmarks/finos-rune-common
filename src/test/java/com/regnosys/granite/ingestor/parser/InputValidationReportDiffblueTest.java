package com.regnosys.granite.ingestor.parser;

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
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InputValidationReportDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InputValidationReport#InputValidationReport(List)}
   *   <li>{@link InputValidationReport#getErrors()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void InputValidationReport.<init>(List)", "List InputValidationReport.getErrors()"})
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<String> errors = new ArrayList<>();

    // Act
    List<String> actualErrors = (new InputValidationReport(errors)).getErrors();

    // Assert
    assertTrue(actualErrors.isEmpty());
    assertSame(errors, actualErrors);
  }
}
