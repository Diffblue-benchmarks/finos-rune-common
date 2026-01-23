package com.regnosys.rosetta.common.compile;

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
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CompilationCancellationExceptionDiffblueTest {
  /**
   * Test {@link CompilationCancellationException#CompilationCancellationException(String)}.
   *
   * <p>Method under test: {@link
   * CompilationCancellationException#CompilationCancellationException(String)}
   */
  @Test
  @DisplayName("Test new CompilationCancellationException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompilationCancellationException.<init>(String)"})
  void testNewCompilationCancellationException() {
    // Arrange and Act
    CompilationCancellationException actualCompilationCancellationException =
        new CompilationCancellationException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualCompilationCancellationException.getMessage());
    assertNull(actualCompilationCancellationException.getCause());
    assertEquals(0, actualCompilationCancellationException.getSuppressed().length);
  }
}
