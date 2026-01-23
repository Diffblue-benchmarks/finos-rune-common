package com.regnosys.rosetta.common.serialisation;

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

class BeanUtilDiffblueTest {
  /**
   * Test {@link BeanUtil#toLowerCamelCase(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BeanUtil#toLowerCamelCase(String)}
   */
  @Test
  @DisplayName("Test toLowerCamelCase(String); when empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BeanUtil.toLowerCamelCase(String)"})
  void testToLowerCamelCase_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", BeanUtil.toLowerCamelCase(""));
  }

  /**
   * Test {@link BeanUtil#toLowerCamelCase(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BeanUtil#toLowerCamelCase(String)}
   */
  @Test
  @DisplayName("Test toLowerCamelCase(String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BeanUtil.toLowerCamelCase(String)"})
  void testToLowerCamelCase_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BeanUtil.toLowerCamelCase(null));
  }

  /**
   * Test {@link BeanUtil#toLowerCamelCase(String)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code string}.
   * </ul>
   *
   * <p>Method under test: {@link BeanUtil#toLowerCamelCase(String)}
   */
  @Test
  @DisplayName("Test toLowerCamelCase(String); when 'String'; then return 'string'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BeanUtil.toLowerCamelCase(String)"})
  void testToLowerCamelCase_whenString_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals("string", BeanUtil.toLowerCamelCase("String"));
  }
}
