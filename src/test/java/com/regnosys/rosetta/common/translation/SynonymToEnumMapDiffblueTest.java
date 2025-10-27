package com.regnosys.rosetta.common.translation;

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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import java.awt.Component;
import java.util.HashMap;
import org.junit.Test;

public class SynonymToEnumMapDiffblueTest {
  /**
   * Method under test: {@link SynonymToEnumMap#getEnumValue(Class, String)}
   */
  @Test
  public void testGetEnumValue() {
    // Arrange
    SynonymToEnumMap synonymToEnumMap = new SynonymToEnumMap(new HashMap<>());
    Class<Component.BaselineResizeBehavior> enumClass = Component.BaselineResizeBehavior.class;

    // Act and Assert
    assertNull(synonymToEnumMap.getEnumValue(enumClass, "42"));
  }

  /**
   * Method under test:
   * {@link SynonymToEnumMap#getEnumValueOptional(Class, String)}
   */
  @Test
  public void testGetEnumValueOptional() {
    // Arrange
    SynonymToEnumMap synonymToEnumMap = new SynonymToEnumMap(new HashMap<>());
    Class<Component.BaselineResizeBehavior> enumClass = Component.BaselineResizeBehavior.class;

    // Act and Assert
    assertFalse(synonymToEnumMap.getEnumValueOptional(enumClass, "42").isPresent());
  }
}
