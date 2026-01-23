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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JavaCompilationResultDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JavaCompilationResult#JavaCompilationResult(CompilationCompletionState, List)}
   *   <li>{@link JavaCompilationResult#getCompilationCompletionState()}
   *   <li>{@link JavaCompilationResult#getDiagnostics()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JavaCompilationResult.<init>(CompilationCompletionState, List)",
    "CompilationCompletionState JavaCompilationResult.getCompilationCompletionState()",
    "List JavaCompilationResult.getDiagnostics()"
  })
  void testGettersAndSetters() {
    // Arrange
    ArrayList<Diagnostic<? extends JavaFileObject>> diagnostics = new ArrayList<>();

    // Act
    JavaCompilationResult actualJavaCompilationResult =
        new JavaCompilationResult(CompilationCompletionState.COMPILATION_SUCCESS, diagnostics);
    CompilationCompletionState actualCompilationCompletionState =
        actualJavaCompilationResult.getCompilationCompletionState();
    List<Diagnostic<? extends JavaFileObject>> actualDiagnostics =
        actualJavaCompilationResult.getDiagnostics();

    // Assert
    assertEquals(CompilationCompletionState.COMPILATION_SUCCESS, actualCompilationCompletionState);
    assertTrue(actualDiagnostics.isEmpty());
    assertSame(diagnostics, actualDiagnostics);
  }

  /**
   * Test {@link JavaCompilationResult#isCompilationSuccessful()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JavaCompilationResult#isCompilationSuccessful()}
   */
  @Test
  @DisplayName("Test isCompilationSuccessful(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JavaCompilationResult.isCompilationSuccessful()"})
  void testIsCompilationSuccessful_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new JavaCompilationResult(
                CompilationCompletionState.COMPILATION_FAILURES, new ArrayList<>())
            .isCompilationSuccessful());
  }

  /**
   * Test {@link JavaCompilationResult#isCompilationSuccessful()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JavaCompilationResult#isCompilationSuccessful()}
   */
  @Test
  @DisplayName("Test isCompilationSuccessful(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JavaCompilationResult.isCompilationSuccessful()"})
  void testIsCompilationSuccessful_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new JavaCompilationResult(CompilationCompletionState.COMPILATION_SUCCESS, new ArrayList<>())
            .isCompilationSuccessful());
  }
}
