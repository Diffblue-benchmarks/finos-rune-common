package com.regnosys.rosetta.common.compile;

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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import org.junit.Test;

public class JavaCompilationResultDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link JavaCompilationResult#JavaCompilationResult(CompilationCompletionState, List)}
   *   <li>{@link JavaCompilationResult#getCompilationCompletionState()}
   *   <li>{@link JavaCompilationResult#getDiagnostics()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<Diagnostic<? extends JavaFileObject>> diagnostics = new ArrayList<>();

    // Act
    JavaCompilationResult actualJavaCompilationResult = new JavaCompilationResult(
        CompilationCompletionState.COMPILATION_SUCCESS, diagnostics);
    CompilationCompletionState actualCompilationCompletionState = actualJavaCompilationResult
        .getCompilationCompletionState();
    List<Diagnostic<? extends JavaFileObject>> actualDiagnostics = actualJavaCompilationResult.getDiagnostics();

    // Assert
    assertEquals(CompilationCompletionState.COMPILATION_SUCCESS, actualCompilationCompletionState);
    assertTrue(actualDiagnostics.isEmpty());
    assertSame(diagnostics, actualDiagnostics);
  }

  /**
   * Method under test: {@link JavaCompilationResult#isCompilationSuccessful()}
   */
  @Test
  public void testIsCompilationSuccessful() {
    // Arrange, Act and Assert
    assertTrue((new JavaCompilationResult(CompilationCompletionState.COMPILATION_SUCCESS, new ArrayList<>()))
        .isCompilationSuccessful());
    assertFalse((new JavaCompilationResult(CompilationCompletionState.COMPILATION_FAILURES, new ArrayList<>()))
        .isCompilationSuccessful());
  }
}
