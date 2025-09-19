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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PathExceptionDiffblueTest {
  /**
   * Test {@link PathException#PathException(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PathException#PathException(String)}
   */
  @Test
  @DisplayName(
      "Test new PathException(String); when '0123456789ABCDEF'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PathException.<init>(String)",
    "void PathException.<init>(String, Throwable)"
  })
  void testNewPathException_when0123456789abcdef_thenReturnCauseIsNull() {
    // Arrange and Act
    PathException actualPathException = new PathException("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualPathException.getMessage());
    assertNull(actualPathException.getCause());
    assertEquals(0, actualPathException.getSuppressed().length);
  }

  /**
   * Test {@link PathException#PathException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link PathException#PathException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new PathException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PathException.<init>(String)",
    "void PathException.<init>(String, Throwable)"
  })
  void testNewPathException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    PathException actualPathException = new PathException("0123456789ABCDEF", cause);

    // Assert
    assertEquals("0123456789ABCDEF", actualPathException.getMessage());
    assertEquals(0, actualPathException.getSuppressed().length);
    assertSame(cause, actualPathException.getCause());
  }
}
