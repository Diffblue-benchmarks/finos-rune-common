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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.util.HashMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SynonymToEnumMapDiffblueTest {
  /**
   * Test {@link SynonymToEnumMap#getEnumValue(Class, String)}.
   * <p>
   * Method under test: {@link SynonymToEnumMap#getEnumValue(Class, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Enum SynonymToEnumMap.getEnumValue(Class, String)"})
  public void testGetEnumValue() {
    // Arrange
    SynonymToEnumMap synonymToEnumMap = new SynonymToEnumMap(new HashMap<>());
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;

    // Act and Assert
    assertNull(synonymToEnumMap.getEnumValue(enumClass, "42"));
  }

  /**
   * Test {@link SynonymToEnumMap#getEnumValueOptional(Class, String)}.
   * <p>
   * Method under test: {@link SynonymToEnumMap#getEnumValueOptional(Class, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Optional SynonymToEnumMap.getEnumValueOptional(Class, String)"})
  public void testGetEnumValueOptional() {
    // Arrange
    SynonymToEnumMap synonymToEnumMap = new SynonymToEnumMap(new HashMap<>());
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;

    // Act and Assert
    assertFalse(synonymToEnumMap.getEnumValueOptional(enumClass, "42").isPresent());
  }
}
