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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class PathExceptionDiffblueTest {
  /**
   * Method under test: {@link PathException#PathException(String)}
   */
  @Test
  public void testNewPathException() {
    // Arrange and Act
    PathException actualPathException = new PathException("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualPathException.getMessage());
    assertNull(actualPathException.getCause());
    assertEquals(0, actualPathException.getSuppressed().length);
  }

  /**
   * Method under test: {@link PathException#PathException(String, Throwable)}
   */
  @Test
  public void testNewPathException2() {
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
