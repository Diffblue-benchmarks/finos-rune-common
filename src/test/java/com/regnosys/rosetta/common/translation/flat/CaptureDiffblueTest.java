package com.regnosys.rosetta.common.translation.flat;

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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class CaptureDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Capture#Capture(Map, String)}
   *   <li>{@link Capture#getIndexes()}
   *   <li>{@link Capture#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    HashMap<String, Integer> indexes = new HashMap<>();

    // Act
    Capture actualCapture = new Capture(indexes, "42");
    Map<String, Integer> actualIndexes = actualCapture.getIndexes();

    // Assert
    assertEquals("42", actualCapture.getValue());
    assertTrue(actualIndexes.isEmpty());
    assertSame(indexes, actualIndexes);
  }
}
