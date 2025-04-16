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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JavaCompilationResultDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JavaCompilationResult#JavaCompilationResult(CompilationCompletionState, List)}
   *   <li>{@link JavaCompilationResult#getCompilationCompletionState()}
   *   <li>{@link JavaCompilationResult#getDiagnostics()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JavaCompilationResult.<init>(CompilationCompletionState, List)",
      "CompilationCompletionState JavaCompilationResult.getCompilationCompletionState()",
      "List JavaCompilationResult.getDiagnostics()"})
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
   * Test {@link JavaCompilationResult#isCompilationSuccessful()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JavaCompilationResult#isCompilationSuccessful()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JavaCompilationResult.isCompilationSuccessful()"})
  public void testIsCompilationSuccessful_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new JavaCompilationResult(CompilationCompletionState.COMPILATION_FAILURES, new ArrayList<>()))
        .isCompilationSuccessful());
  }

  /**
   * Test {@link JavaCompilationResult#isCompilationSuccessful()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JavaCompilationResult#isCompilationSuccessful()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JavaCompilationResult.isCompilationSuccessful()"})
  public void testIsCompilationSuccessful_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new JavaCompilationResult(CompilationCompletionState.COMPILATION_SUCCESS, new ArrayList<>()))
        .isCompilationSuccessful());
  }
}
